package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;

import java.util.List;

/**
 * Created by Gregory on 6/18/2017.
 */
public interface BattleInterface {
    public void setIsBattling(boolean battling);
    public void setBattleTextList(List<List<String>> bList);
    public boolean isBattling();
    public void endBattle();
    public void blackedOut();
    public void setCurrentPokemon(Pokemon poke);
    void switchUserPokemonTextures();
    void removeBattleVariablesFromCurrentPokemon();
}
