package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;

/**
 * Created by Gregory on 6/9/2017.
 */
public class MapState extends GameState {
    private GameStateManager gsm;
    private Texture background;

    private double refreshCounter;
    private boolean mapOpened;

    public MapState(GameStateManager gsm) {
        this.gsm = gsm;
        background = gsm.getLoader().get("mapMenu.png", Texture.class);
        refreshCounter = 0;
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 0);
    }

    @Override
    public void update(double dt) {
        if (MyInput.clicked()) {
            int x = MyInput.getX();
            int y = MyInput.getY();
            if (clickedMapLocation(x, y)) {
                openMap();
            } else if (clickedCheckPokemon(x, y)) {
                openPokemonList();
            } else if (clickedBack(x, y)) {
                gsm.setState(new LoadingState(gsm, LoadingState.POKENAV_MENU));
                this.dispose();
            }
        }
    }

    private boolean clickedMapLocation(int x, int y) {
        if (x >= 275 && x <= 811 && y >= 378 && y <= 833) {
            return true;
        }
        return false;
    }


    private boolean clickedCheckPokemon(int x, int y) {
        if (x >= 304 && x <= 836 && y >= 1353 && y <= 1691) {
            return true;
        }
        return false;
    }

    private boolean clickedBack(int x, int y) {
        if (x >= 836 && x <= 1016 && y >= 1755 && y <= 1874) {
            return true;
        }
        return false;
    }

    private void openMap() {
        if (gsm.gotCoordinates()) {
            double[] pokemonLatitude = new double[gsm.getNearbyPokemon().size()];
            double[] pokemonLongitude = new double[gsm.getNearbyPokemon().size()];
            String[] pokemonIcon = new String[gsm.getNearbyPokemon().size()];
            for (int i = 0; i < gsm.getNearbyPokemon().size(); i++) {
                pokemonLatitude[i] = gsm.getNearbyPokemon().get(i).getLatitude();
                pokemonLongitude[i] = gsm.getNearbyPokemon().get(i).getLongitude();
                pokemonIcon[i] = gsm.getNearbyPokemon().get(i).getPokemon().getMapIconPath();
            }
            gsm.getGameCallBack().startMapActivity(pokemonLatitude, pokemonLongitude, pokemonIcon);
        } else {
            //play error sound
        }
    }

    private void openPokemonList() {
        //Check the pokemon list, if none open the no wild pokemon state
        if (gsm.getNearbyPokemon().size() >= 1) {
            for (int i = 0; i < gsm.getNearbyPokemon().size(); i++) {
                if (gsm.getNearbyPokemon().get(i).isExpired()) {
                    gsm.getNearbyPokemon().remove(i);
                    i--;


                }
            }
            gsm.setState(new LoadingState(gsm, LoadingState.WILD_POKEMON_LIST));
            dispose();
        } else {
            gsm.setState(new LoadingState(gsm, LoadingState.EMPTY_WILD_POKEMON_SCREEN));
            dispose();
        }

    }

    @Override
    protected void dispose() {
        gsm.getLoader().unload("mapMenu.png");
    }
}
