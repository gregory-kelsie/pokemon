package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;
import com.pokemon.toronto.game.com.pokemon.toronto.pokenav.PokeNavScreen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/8/2017.
 */
public class PokeNavState extends GameState{

    private GameStateManager gsm;
    private Texture background;
    private List<PokeNavScreen> pokeNavScreens;
    private int currentScreen;

    private final int POKEDEX_SCREEN = 0;
    private final int PC_SCREEN = 1;
    private final int MAP_SCREEN = 2;
    private final int SIMULATOR_SCREEN = 3;
    private final int COMMUNITY_SCREEN = 4;
    private final int POKECENTER_SCREEN = 5;
    private final int POKEMART_SCREEN = 6;
    public PokeNavState(GameStateManager gsm) {
        this.gsm = gsm;
        background = gsm.getLoader().get("pokeNav/background.png", Texture.class);
        initPokeNavScreens();
    }

    private void initPokeNavScreens() {
        pokeNavScreens = new ArrayList<PokeNavScreen>();
        pokeNavScreens.add(new PokeNavScreen(gsm.getLoader().get("pokeNav/pokedex.png", Texture.class),
                gsm.getLoader().get("pokeNav/pokedex_text.png", Texture.class)));
        pokeNavScreens.add(new PokeNavScreen(gsm.getLoader().get("pokeNav/pokemonpc.png", Texture.class),
                gsm.getLoader().get("pokeNav/pokemonpc_text.png", Texture.class)));
        pokeNavScreens.add(new PokeNavScreen(gsm.getLoader().get("pokeNav/worldmap.png", Texture.class),
                gsm.getLoader().get("pokeNav/worldmap_text.png", Texture.class)));
        pokeNavScreens.add(new PokeNavScreen(gsm.getLoader().get("pokeNav/battlesimulator.png", Texture.class),
                gsm.getLoader().get("pokeNav/battlesimulator_text.png", Texture.class)));
        pokeNavScreens.add(new PokeNavScreen(gsm.getLoader().get("pokeNav/community.png", Texture.class),
                gsm.getLoader().get("pokeNav/community_text.png", Texture.class)));
        pokeNavScreens.add(new PokeNavScreen(gsm.getLoader().get("pokeNav/blissey.png", Texture.class),
                gsm.getLoader().get("pokeNav/pokemoncenter_text.png", Texture.class)));
        pokeNavScreens.add(new PokeNavScreen(gsm.getLoader().get("pokeNav/pokemart.png", Texture.class),
                gsm.getLoader().get("pokeNav/pokemart_text.png", Texture.class)));
        currentScreen = POKEDEX_SCREEN;
    }

    private void clickedLeft() {
        if (currentScreen != 0) {
            currentScreen--;
        }
    }

    private boolean clickedLeft(int x, int y) {
        if (x >= 0 && x <= 128 && y >= 1617 && y <= 1737) {
            return true;
        }
        return false;
    }

    private void clickedRight() {
        if (currentScreen != pokeNavScreens.size() - 1) {
            currentScreen++;
        }
    }

    private boolean clickedRight(int x, int y) {
        if (x >= 218 && x <= 305 && y >= 1612 && y <= 1788) {
            return true;
        }
        return false;
    }

    private void clickedBack() {
        gsm.setState(new LoadingState(gsm, LoadingState.MAIN_MENU));
        dispose();
    }

    private boolean clickedBack(int x, int y) {
        if (x >= 808 && x <= 974 && y >= 1530 && y <= 1666) {
            return true;
        }
        return false;
    }

    private void clickedSelect() {
        switch (currentScreen) {
            case POKEDEX_SCREEN:
                break;
            case PC_SCREEN:
                executePokemonBoxScreen();
                break;
            case MAP_SCREEN:
                executeMapScreen();
                break;
            case SIMULATOR_SCREEN:
                executeSimulator();
                break;
            case COMMUNITY_SCREEN:
                break;
            case POKECENTER_SCREEN:
                executePokeCenterScreen();
            case POKEMART_SCREEN:
                break;
        }
    }

    private void executeSimulator() {
        gsm.setState(new RegionSelect(gsm));
        dispose();
    }

    private void executePokeCenterScreen() {
        gsm.setState(new LoadingState(gsm, LoadingState.POKECENTER_STATE));
        dispose();
    }

    private void executePokemonBoxScreen() {
        gsm.setState(new BoxState(gsm, true));
        dispose();
    }

    private void executeMapScreen() {/*
        if (gsm.gotCoordinates()) {
            gsm.getGameCallBack().startMapActivity(gsm.getLatitude(), gsm.getLongitude());
        } else {
            //play error sound
        }*/
        gsm.setState(new LoadingState(gsm, LoadingState.MAP_STATE));
        dispose();
    }
    private boolean clickedSelect(int x, int y) {
        if (x >= 882 && x <= 1033 && y >= 1687 && y <= 1808) {
            return true;
        }
        return false;
    }
    @Override
    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 0);
        pokeNavScreens.get(currentScreen).render(batch);
    }

    @Override
    public void update(double dt) {
        if (MyInput.clicked()) {
            int x = MyInput.getX();
            int y = MyInput.getY();
            if (clickedLeft(x, y)) {
                clickedLeft();
            } else if (clickedRight(x, y)) {
                clickedRight();
            } else if (clickedBack(x, y)) {
                clickedBack();
            } else if (clickedSelect(x, y)) {
                clickedSelect();
            }
            Gdx.app.log("GDX LOGGERs - ", "X: " + MyInput.getX() + ", Y: " + MyInput.getY());
        }
    }

    @Override
    protected void dispose() {
        gsm.getLoader().unload("pokeNav/background.png");
        gsm.getLoader().unload("pokeNav/pokedex.png");
        gsm.getLoader().unload("pokeNav/pokedex_text.png");
        gsm.getLoader().unload("pokeNav/pokemonpc.png");
        gsm.getLoader().unload("pokeNav/pokemonpc_text.png");
        gsm.getLoader().unload("pokeNav/worldmap.png");
        gsm.getLoader().unload("pokeNav/worldmap_text.png");
        gsm.getLoader().unload("pokeNav/battlesimulator.png");
        gsm.getLoader().unload("pokeNav/battlesimulator_text.png");
        gsm.getLoader().unload("pokeNav/community.png");
        gsm.getLoader().unload("pokeNav/community_text.png");
        gsm.getLoader().unload("pokeNav/blissey.png");
        gsm.getLoader().unload("pokeNav/pokemoncenter_text.png");
        gsm.getLoader().unload("pokeNav/pokemart.png");
        gsm.getLoader().unload("pokeNav/pokemart_text.png");
    }
}
