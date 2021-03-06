package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer;

import java.util.List;

/**
 * Created by Gregory on 6/18/2017.
 */
public interface BattleInterface {
    void setIsBattling(boolean battling);
    void setBattleTextList(List<List<String>> bList);
    boolean isBattling();
    void startLoading();
    void endBattle();
    void blackedOut();
    void setCurrentPokemon(Pokemon poke);
    void switchUserPokemonTextures();
    void removeBattleVariablesFromCurrentPokemon();
    void transferPositionalBattleVariables(int newCurrentPokemonPosition);
    void playVictoryBgm();
    void stopBgm();
    void playEnemyCry();
    void playUserPokemonCry();
    void setNormalMoveSelectText();
    void setNoSwitchText();
    void playTrainerEnemyCry();
    boolean isFinishedIntroAnimation();
    int getBattleType();
    boolean hasWipedOutTrainer();
    boolean isWildBattle();
    Trainer getTrainer();
    String getNextPokemonName();
    Pokemon setNextEnemyPokemon();
    void disposeBgm();
    void updatePlayerSprite();
    void updateEnemySprite();
}
