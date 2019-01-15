package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.location.PokemonPlace;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer;

/**
 * Created by Gregory on 6/5/2017.
 */
public abstract class GameState {
    public abstract void render(SpriteBatch batch);
    public abstract void update(double dt);
    public abstract void dispose();
    public void openTrainerPopUp(Trainer t) {

    }
    public void addPokemonPlace(int pokemonId) {

    }

    public void addPokemonGeographic(int pokemonId) {

    }
    public void drawStage() {}

}
