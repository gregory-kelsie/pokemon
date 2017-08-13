package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

/**
 * Created by Gregory on 7/30/2017.
 */

public interface PhaseUpdaterInterface {
    void setPhase(BattlePhase p);
    void setUserFirstAttacker(Skill userSkill, Skill enemySkill);
    void setEnemyFirstAttacker(Skill userSkill, Skill enemySkill);
    boolean isUserPokemonFirstAttacker();
    Pokemon getUserPokemon();
    Pokemon getEnemyPokemon();
    Skill getUserSkill();
    Skill getEnemySkill();
    boolean playerHasMorePokemon();
    void endBattle();
    BitmapFont getFont();
    void setWaitingForNextPokemon();
    boolean waitingForNextPokemon();
    void blackOut();
    void finishedBattle();
    void setDisplayYesNo();
    boolean deletingFirstMove();
    boolean deletingSecondMove();
    boolean deletingThirdMove();
    boolean deletingFourthMove();
    boolean stoppedDeletingMove();
    void setWaitingForMoveDeletion();
    boolean hasAcceptedNewMove();
    boolean hasDeclinedNewMove();
    void caughtTheWildPokemon();
    void swapPokemon(Pokemon sentOutPokemon);
    void resetYesNoResult();
    void resetDeletionResult();
    Field getField();
}
