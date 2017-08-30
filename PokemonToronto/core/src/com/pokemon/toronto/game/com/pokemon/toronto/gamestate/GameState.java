package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Gregory on 6/5/2017.
 */
public abstract class GameState {
    public abstract void render(SpriteBatch batch);
    public abstract void update(double dt);
    protected abstract void dispose();
    public void drawStage() {}
}
