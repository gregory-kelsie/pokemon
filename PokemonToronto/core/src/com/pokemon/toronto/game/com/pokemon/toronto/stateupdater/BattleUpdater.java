package com.pokemon.toronto.game.com.pokemon.toronto.stateupdater;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.PokeballAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.BattlePhase;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.CatchingPhase;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.PhaseUpdaterInterface;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.SentOutAbilityPhase;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.SpeedCheckPhase;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.SwitchPhase;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.UseAttackPhase;
import com.pokemon.toronto.game.com.pokemon.toronto.catching.CatchResults;
import com.pokemon.toronto.game.com.pokemon.toronto.gamestate.BattleInterface;
import com.pokemon.toronto.game.com.pokemon.toronto.gamestate.BattleState;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.List;

/**
 * Created by Gregory on 6/18/2017.
 */
public class BattleUpdater implements PhaseUpdaterInterface {
    private BattleInterface battleState;
    private boolean userPokemonIsFirstAttacker;
    private Pokemon userPokemon;
    private Pokemon sentOutPokemon;
    private Pokemon enemyPokemon;
    private List<Pokemon> playerParty;
    private Skill userSkill;
    private Skill enemySkill;
    private boolean started;
    private boolean caughtThePokemon;

    private boolean doneDisplayingExpText;

    private boolean displayingYesNo;

    private int state;


    //BATTLE PHASE STATES.
    private final int IDLE = -1;
    private final int WAIT_FOR_NEXT_POKEMON = 15;
    private final int SWITCH_POKEMON = 16;
    private final int WAIT_FOR_FAINT_CLICK = 26; //wait for player to click so exp can be distributed
    private final int WAITING_FOR_MOVE_DELETION = 32;

    private BitmapFont font;
    private BattlePhase currentPhase;


    //Move Deletion Result Values
    private final int DELETED_FIRST_MOVE = 0;
    private final int DELETED_SECOND_MOVE = 1;
    private final int DELETED_THIRD_MOVE = 2;
    private final int DELETED_FOURTH_MOVE = 3;
    private final int STOPPED_DELETING_MOVE = 4;
    private int moveDeletionResult;

    //Yes No Result Values
    private final int YES_MOVE_REPLACEMENT = 0;
    private final int NO_MOVE_REPLACEMENT = 1;
    private int yesNoResult;

    //Field
    private Field field;

    //Battle Sound Effects
    private Sound poisonSound;
    private Music expGainSound;
    private Sound levelUpSound;


    public BattleUpdater(BattleInterface battleState, BitmapFont font) {
        this.battleState = battleState;
        this.font = font;
        started = false;
        state = IDLE;
        caughtThePokemon = false;
        doneDisplayingExpText = false;
        displayingYesNo = false;

        moveDeletionResult = -1;
        yesNoResult = -1;

        poisonSound = Gdx.audio.newSound(Gdx.files.internal("sounds/poison.wav"));
        levelUpSound = Gdx.audio.newSound(Gdx.files.internal("sounds/levelup.wav"));
        expGainSound = Gdx.audio.newMusic(Gdx.files.internal("sounds/expgain.wav"));
    }

    /*
    * Start the battle phase
    * @param Pokemon userPokemon The player's pokemon in the battle
    * @param Pokemon enemyPokemon The enemy's pokemon in the battle
    * @param Skill userSkill The move the player is using in this phase.
    * @param Skill enemySkill The move the enemy is using in this phase.
     */
    public void start(List<Pokemon> playerParty, Pokemon userPokemon, Pokemon enemyPokemon,
                      Skill userSkill, Skill enemySkill, Field field) {
        this.playerParty = playerParty;
        this.userPokemon = userPokemon;
        this.enemyPokemon = enemyPokemon;
        this.userSkill = userSkill;
        this.enemySkill = enemySkill;
        this.field = field;
        currentPhase = new SpeedCheckPhase(this, userPokemon, enemyPokemon, userSkill, enemySkill);
        state = IDLE;
        started = true;
    }

    public void start(List<Pokemon> playerParty, Pokemon prevPokemon, Pokemon enemyPokemon,
                      Pokemon sentOutPokemon, Skill enemySkill, Field field) {
        this.playerParty = playerParty;
        this.userPokemon = prevPokemon;
        this.enemyPokemon = enemyPokemon;
        this.sentOutPokemon = sentOutPokemon;
        this.enemySkill = enemySkill;
        this.field = field;
        userPokemonIsFirstAttacker = true;
        started = true;
        currentPhase = new SwitchPhase(this, sentOutPokemon);
    }

    /**
     * When the battle is started by the player throwing a pokeball in an attempt to catching
     * the enemy pokemon. Therefore there is no skill being used by the player, a ball type
     * and an enemy skill in case the attempt to catching the pokemon fails.
     * @param playerParty The player's Pokemon Party
     * @param userPokemon The current Pokemon the player has on the field
     * @param enemyPokemon The enemy Pokemon on the field
     * @param pokeballType The type of Pokeball being thrown at the enemy pokemon
     * @param enemySkill The skill the enemy will use if the ball fails
     */
    public void start(List<Pokemon> playerParty, Pokemon userPokemon, Pokemon enemyPokemon,
                      int pokeballType, Skill enemySkill, Field field) {
        this.userPokemon = userPokemon;
        this.enemyPokemon = enemyPokemon;
        this.enemySkill = enemySkill;
        this.field = field;
        userPokemonIsFirstAttacker = true;
        started = true;
        currentPhase = new CatchingPhase(this, enemySkill, pokeballType);
    }

    public void initiateFirstAbilities(Pokemon userPokemon, Pokemon enemyPokemon, Field field) {
        started = true;
        this.userPokemon = userPokemon;
        this.enemyPokemon = enemyPokemon;
        this.field = field;
        setPhase(new SentOutAbilityPhase(this));
    }


    public void dispose() {
        poisonSound.dispose();
        expGainSound.dispose();
        levelUpSound.dispose();
    }

    /****************************************************************************************************
     *
     *      INTERFACE METHODS THAT LINK BATTLEUPDATER AND BATTLESTATE
     *
     * *************************************************************************************************
     */

    @Override
    public void playVictoryBgm() {
        battleState.playVictoryBgm();
    }
    @Override
    public void playPoisonSound() {
        poisonSound.play();
    }

    @Override
    public void playExpSound() {
        if (!expGainSound.isPlaying()) {
            expGainSound.setPosition(0.0f); //Restart from start if playing again.
            Gdx.app.log("expsound", "play");
            expGainSound.play();
        }
    }

    @Override
    public void stopExpSound() {
        if (expGainSound.isPlaying()) {
            Gdx.app.log("expsound", "stop");
            expGainSound.stop();

        }
    }

    @Override
    public void playLevelUpSound() {
        levelUpSound.play();
    }

    @Override
    public void setWaitingForMoveDeletion() {
        state = WAITING_FOR_MOVE_DELETION;
    }

    @Override
    public void resetDeletionResult() {
        moveDeletionResult = -1;
    }
    public boolean deletingFirstMove() {
        if (moveDeletionResult == DELETED_FIRST_MOVE) {
            return true;
        }
        return false;
    }

    public boolean deletingSecondMove() {
        if (moveDeletionResult == DELETED_SECOND_MOVE) {
            return true;
        }
        return false;
    }

    public boolean deletingThirdMove() {
        if (moveDeletionResult == DELETED_THIRD_MOVE) {
            return true;
        }
        return false;
    }

    public boolean deletingFourthMove() {
        if (moveDeletionResult == DELETED_FOURTH_MOVE) {
            return true;
        }
        return false;
    }

    public boolean stoppedDeletingMove() {
        if (moveDeletionResult == STOPPED_DELETING_MOVE) {
            return true;
        }
        return false;
    }

    public void finishedFaintSwitch(Pokemon currentPokemon) {
        state = IDLE;
        userPokemon = currentPokemon;
        setPhase(new SentOutAbilityPhase(this, userPokemon, enemyPokemon, true));
        //started = false;
    }

    public boolean waitingForNextPokemon() {
        if (state == WAIT_FOR_NEXT_POKEMON) {
            return true;
        }
        return false;
    }

    public boolean waitingForMoveDeletion() {
        if (state == WAITING_FOR_MOVE_DELETION) {
            return true;
        }
        return false;
    }

    public void removeFirstSkill() {
        moveDeletionResult = DELETED_FIRST_MOVE;
        state = IDLE;
    }
    public void removeSecondSkill() {
        moveDeletionResult = DELETED_SECOND_MOVE;
        state = IDLE;
    }
    public void removeThirdSkill() {
        moveDeletionResult = DELETED_THIRD_MOVE;
        state = IDLE;
    }
    public void removeFourthSkill() {
        moveDeletionResult = DELETED_FOURTH_MOVE;
        state = IDLE;
    }

    /*
* Return whether or not the battle phase started.
* @param boolean started Whether or not the battle phase started.
 */
    public boolean started() {
        return started;
    }

    public void acceptedNewMove() {
        displayingYesNo = false;
        yesNoResult = YES_MOVE_REPLACEMENT;
    }



    public void declinedNewMove() {
        displayingYesNo = false;
        yesNoResult = NO_MOVE_REPLACEMENT;
    }


    public boolean waitingForFaintClick() {
        if (state == WAIT_FOR_FAINT_CLICK) {
            return true;
        }
        return false;
    }

    public boolean waitingForExpClick() {
        if (doneDisplayingExpText) {
            return true;
        }
        return false;
    }

    public boolean displayingYesNo() {
        return displayingYesNo;
    }


    public void renderText(SpriteBatch batch) {
        currentPhase.renderText(batch);
    }

    public boolean caughtThePokemon() {
        return caughtThePokemon;
    }

    public SkillAnimation getSkillAnimation() {
        if (currentPhase instanceof UseAttackPhase) {
            return currentPhase.getSkillAnimation();
        } else {
            return null;
        }
    }

    public boolean hidingUserPokemon() {
        if (currentPhase != null) {
            return currentPhase.isHidingUserPokemon();
        }
        return false;

    }

    public boolean isHidingEnemyPokemon() {
        if (currentPhase != null) {
            return currentPhase.isHidingEnemyPokemon();
        } else {
            return false;
        }
    }

    public void renderExtras(SpriteBatch batch) {
        if (currentPhase != null) {
            currentPhase.render(batch);
        }
    }

    public void renderAnimationBackground(SpriteBatch batch) {

    }

    public void update(double dt) {
        currentPhase.update(dt);
    }

    /**
     * PUI METHODS
     */

    public void setPhase(BattlePhase p) {
        this.currentPhase = p;
    }

    @Override
    public Field getField() {
        return field;
    }

    @Override
    public void swapPokemon(Pokemon sentOutPokemon) {
        userPokemon = sentOutPokemon;
        battleState.switchUserPokemonTextures();
    }

    @Override
    public void caughtTheWildPokemon() {
        caughtThePokemon = true;
    }
    @Override
    public boolean hasAcceptedNewMove() {
        if (yesNoResult == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean hasDeclinedNewMove() {
        if (yesNoResult == 1) {
            return true;
        }
        return false;
    }

    @Override
    public void resetYesNoResult() {
        yesNoResult = -1;
    }

    @Override
    public void setDisplayYesNo() {
        displayingYesNo = true;
    }

    @Override
    public void blackOut() {
        battleState.blackedOut();
    }

    @Override
    public void setUserFirstAttacker(Skill userSkill, Skill enemySkill) {
        userPokemonIsFirstAttacker = true;
    }

    @Override
    public void setEnemyFirstAttacker(Skill userSkill, Skill enemySkill) {
        userPokemonIsFirstAttacker = false;
    }

    @Override
    public boolean isUserPokemonFirstAttacker() {
        return userPokemonIsFirstAttacker;
    }

    @Override
    public Pokemon getUserPokemon() {
        return userPokemon;
    }

    @Override
    public Pokemon getEnemyPokemon() {
        return enemyPokemon;
    }

    @Override
    public Skill getUserSkill() {
        return userSkill;
    }

    @Override
    public Skill getEnemySkill() {
        return enemySkill;
    }

    @Override
    public boolean playerHasMorePokemon() {
        for (int i = 0; i < playerParty.size(); i++) {
            if (!playerParty.get(i).isFainted()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void endBattle() {
        started = false;
    }

    @Override
    public void finishedBattle() {
        battleState.endBattle();
    }

    @Override
    public BitmapFont getFont() {
        return font;
    }

    @Override
    public void setWaitingForNextPokemon() {
        state = WAIT_FOR_NEXT_POKEMON;
    }
}
