package com.pokemon.toronto.game.com.pokemon.toronto.pokenav;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Gregory on 6/8/2017.
 */
public class PokeNavScreen {
    private Texture icon;
    private Texture text;

    public PokeNavScreen(Texture icon, Texture text) {
        this.icon = icon;
        this.text = text;
    }

    public void render(SpriteBatch batch) {
        batch.draw(icon, 0, 0);
        batch.draw(text, 0, 0);
    }

    public void dispose() {
        icon.dispose();
        text.dispose();
    }
}
