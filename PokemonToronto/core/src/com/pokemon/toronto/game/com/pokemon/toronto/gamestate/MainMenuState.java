package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;

/**
 * Created by Gregory on 6/7/2017.
 */
public class MainMenuState extends GameState{
    private GameStateManager gsm;
    private Texture background;
    public MainMenuState(GameStateManager gsm) {
        this.gsm = gsm;
        background = gsm.getLoader().get("mainMenu.png", Texture.class);

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
            if (clickedPokeNav(x, y)) {
                clickedPokeNav();
            } else if (clickedPokemon(x, y)) {
                clickedPokemon();
            }
            Gdx.app.log("GDX LOGGERs - ", "X: " + MyInput.getX() + ", Y: " + MyInput.getY());
        }
    }

    private boolean clickedPokeNav(int x, int y) {
        if (x >= 53 && x <= 722 && y >= 1270 && y <= 1448) {
            return true;
        } else if (x > 672 && x <= 976 && y >= 1197 && y <= 1403) {
            return true;
        }
        return false;
    }

    private  boolean clickedPokemon(int x, int y) {
        if (x >= 93 && x <= 760 && y >= 444 && y <= 615) {
            return true;
        }
        return false;
    }

    private void clickedPokemon() {
        gsm.setState(new LoadingState(gsm, LoadingState.POKEMON_MENU));
    }
    private void clickedPokeNav() {

        gsm.setState(new LoadingState(gsm, LoadingState.POKENAV_MENU));
    }

    @Override
    protected void dispose() {
        gsm.getLoader().unload("mainMenu.png");
    }
}
