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
                gsm.setState(new LoadingState(gsm, LoadingState.HUB_STATE));
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
        gsm.stopBgm();
        if (gsm.gotCoordinates()) {
            Gdx.app.log("MapState", "Gsm has coordinates");
            double[] pokemonLatitude = new double[gsm.getNearbyPokemon().size()];
            double[] pokemonLongitude = new double[gsm.getNearbyPokemon().size()];
            String[] pokemonIcon = new String[gsm.getNearbyPokemon().size()];
            double[] trainerLatitude = new double[gsm.getNearbyTrainers().size()];
            double[] trainerLongitude = new double[gsm.getNearbyTrainers().size()];
            String[] trainerIcon = new String[gsm.getNearbyTrainers().size()];
            int[] id = new int[gsm.getNearbyPokemon().size()];
            for (int i = 0; i < gsm.getNearbyPokemon().size(); i++) {
                pokemonLatitude[i] = gsm.getNearbyPokemon().get(i).getLatitude();
                pokemonLongitude[i] = gsm.getNearbyPokemon().get(i).getLongitude();
                pokemonIcon[i] = gsm.getNearbyPokemon().get(i).getPokemon().getMapIconPath();
                id[i] = i;
            }
            for (int i = 0; i < gsm.getNearbyTrainers().size(); i++) {
                trainerLatitude[i] = gsm.getNearbyTrainers().get(i).getLatitude();
                trainerLongitude[i] = gsm.getNearbyTrainers().get(i).getLongitude();
                trainerIcon[i] = gsm.getNearbyTrainers().get(i).getIconPath();
            }
            gsm.getGameCallBack().startMapActivity(pokemonLatitude, pokemonLongitude, pokemonIcon, trainerLatitude,
                    trainerLongitude, trainerIcon, id);
        } else {
            //play error sound
            Gdx.app.log("MapState", "Gsm doesnt have coordiantes");
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
    public void dispose() {
        gsm.getLoader().unload("mapMenu.png");
    }
}
