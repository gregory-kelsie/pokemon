package com.pokemon.toronto.game.com.pokemon.toronto.pokenav;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Gregory on 6/8/2017.
 */
public class PokeNavScreen {

    //Instance Variables
    private Texture icon;
    private Texture text;

    /**
     * A representation of the PokeNav screen
     * @param icon The icon texture for the PokeNavScreen.
     *             Ex: Chansey for the PokeCenter
     * @param text The description texture for the screen.
     */
    public PokeNavScreen(Texture icon, Texture text) {
        this.icon = icon;
        this.text = text;
    }

    /**
     * Render the PokeNavScreen to the SpriteBatch.
     * @param batch
     */
    public void render(SpriteBatch batch) {
        batch.draw(icon, 0, 0);
        batch.draw(text, 0, 0);
    }

    /**
     * Dispose of the icon and text textures.
     */
    public void dispose() {
        icon.dispose();
        text.dispose();
    }
}
