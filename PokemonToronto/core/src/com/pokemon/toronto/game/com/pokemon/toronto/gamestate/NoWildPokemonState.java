package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;

/**
 * Created by Gregory on 6/9/2017.
 */
public class NoWildPokemonState extends GameState{
    private GameStateManager gsm;
    private Texture background;
    public NoWildPokemonState(GameStateManager gsm) {
        this.gsm = gsm;
        background = gsm.getLoader().get("noNewPokemon.png", Texture.class);
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
            if (clickedBack(x, y)) {
                gsm.setState(new LoadingState(gsm, LoadingState.MAP_STATE));
            }
            Gdx.app.log("GDX LOGGERs - ", "X: " + MyInput.getX() + ", Y: " + MyInput.getY());
        }

    }

    private boolean clickedBack(int x, int y) {
        if (x >= 814 && x <= 1068 && y >= 1672 && y <= 1890) {
            return true;
        }
        return false;
    }

    @Override
    public void dispose() {
        gsm.getLoader().unload("noNewPokemon.png");
    }
}
