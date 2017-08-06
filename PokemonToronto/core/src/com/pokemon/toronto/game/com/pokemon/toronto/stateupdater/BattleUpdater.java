package com.pokemon.toronto.game.com.pokemon.toronto.stateupdater;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.PokeballAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.BattlePhase;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.PhaseUpdaterInterface;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.SpeedCheckPhase;
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
    private List<List<String>> battleListText;
    private boolean userPokemonIsFirstAttacker;
    private Pokemon userPokemon;
    private Pokemon sentOutPokemon;
    private Pokemon enemyPokemon;
    private List<Pokemon> playerParty;
    private Skill userSkill;
    private Skill enemySkill;
    private Skill firstSkill;
    private Skill secondSkill;
    private boolean started;
    private boolean hidingUserPokemon;
    private int ballType;
    private boolean caughtThePokemon;
    private CatchResults catchResults;
    private boolean doneDisplayingExpText;
    private double expGain;
    private long fullBarofExp;
    private double expGainRate;
    private List<Integer> newSkillsForLevelUp;
    private boolean displayingYesNo;
    private Skill newMove;

    private int state;

    private final int POKEBALL = 0;
    private final int GREATBALL = 1;
    private final int ULTRABALL = 2;

    private final boolean PLAYER_SIDE_ANIMATION = true;
    private final boolean ENEMY_SIDE_ANIMATION = false;

    //BATTLE PHASE STATES.
    private final int IDLE = -1;
    private final int SPEED_CHECK_PHASE = 0;
    private final int DISPLAY_FIRST_SKILL_NAME = 1;
    private final int DISPLAY_FIRST_SKILL_MISS_FAIL = 2;
    private final int USE_FIRST_SKILL_ANIMATION = 3;
    private final int START_SECOND_MOVE = 4;
    private final int DEPLETE_SLOW_POKEMON_HEALTH = 5;
    private final int DISPLAY_SECOND_SKILL_NAME = 6;
    private final int USE_SECOND_SKILL_ANIMATION = 7;
    private final int DEPLETE_FAST_POKEMON_HEALTH = 8;
    private final int DISPLAY_FIRST_MOVE_RESULTS = 9;
    private final int DISPLAY_SECOND_MOVE_RESULTS = 10;
    private final int FAINT_SLOW_POKEMON = 11;
    private final int FAINT_FAST_POKEMON = 12;
    private final int DISPLAY_EXP_GAIN = 13;
    private final int DISPLAY_BLACKED_OUT_TEXT = 14;
    private final int WAIT_FOR_NEXT_POKEMON = 15;
    private final int SWITCH_POKEMON = 16;
    private final int DRAW_SWITCH_RETURN_BALL = 17;
    private final int DRAW_SWITCH_THROW_BALL = 18;
    private final int THROW_POKEBALL = 19; //Catching
    private final int SHAKING_POKEBALL = 20; //when the enemy pokemon is in the ball
    private final int DISPLAY_CATCH_RESULTS = 21;
    private final int HIDE_SWITCHED_POKEMON = 22;
    private final int DISPLAY_NEW_POKEMON_NAME = 23;
    private final int DISPLAY_SENT_OUT_POKEMON = 24;
    private final int DELAY_AFTER_NEW_POKEMON_ENTRANCE = 25;
    private final int WAIT_FOR_FAINT_CLICK = 26; //wait for player to click so exp can be distributed
    private final int ADD_EXP = 27;
    private final int LEVEL_UP_STATE = 28;
    private final int DELAY_AFTER_EXP_GAIN = 29;
    private final int AUTOMATIC_NEW_MOVE = 30;
    private final int ASKING_TO_MAKE_ROOM = 31;
    private final int WAITING_FOR_MOVE_DELETION = 32;
    private final int FINISHED_REPLACING_MOVE = 33;
    private final int FAST_PARALYSIS = 34;
    private final int SLOW_PARALYSIS = 35;
    private final int DEPLETE_ENEMY_HEALTH_POISON = 36;
    private final int DEPLETE_PLAYER_HEALTH_POISON = 37;
    private final int DISPLAY_ENEMY_POISON_RESULTS = 38;
    private final int DISPLAY_PLAYER_POISON_RESULTS = 39;
    private final int FAINT_ENEMY_FROM_POISON = 40;
    private final int FAINT_PLAYER_FROM_POISON = 41;
    private final int DISPLAY_ENEMY_POISON_FAINT_RESULTS = 42;
    private final int DISPLAY_PLAYER_POISON_FAINT_RESULTS = 43;

    private final double PAUSE_TIME = 1; //Pause for 1 second

    private String text;
    private double textCounter;
    private int textPosition;
    private int listPosition;
    private BitmapFont font;
    private SkillAnimation animation;
    private double counter;
    private int pokeballX;
    private int pokeballY;

    private Texture userPokemonTexture;
    private PokeballAnimation pokeballAnimation;

    private BattlePhase currentPhase;

    public BattleUpdater(BattleInterface battleState, BitmapFont font) {
        this.battleState = battleState;
        this.font = font;
        started = false;
        state = IDLE;
        counter = 0;
        hidingUserPokemon = false;
        caughtThePokemon = false;
        doneDisplayingExpText = false;
        expGain = 0;
        displayingYesNo = false;


    }

    /*
    * Start the battle phase
    * @param Pokemon userPokemon The player's pokemon in the battle
    * @param Pokemon enemyPokemon The enemy's pokemon in the battle
    * @param Skill userSkill The move the player is using in this phase.
    * @param Skill enemySkill The move the enemy is using in this phase.
     */
    public void start(List<Pokemon> playerParty, Pokemon userPokemon, Pokemon enemyPokemon,
                      Skill userSkill, Skill enemySkill) {
        this.playerParty = playerParty;
        this.userPokemon = userPokemon;
        this.enemyPokemon = enemyPokemon;
        this.userSkill = userSkill;
        this.enemySkill = enemySkill;
        currentPhase = new SpeedCheckPhase(this, userPokemon, enemyPokemon, userSkill, enemySkill);

        started = true;
    }

    public void start(List<Pokemon> playerParty, Pokemon prevPokemon, Pokemon enemyPokemon,
                      Pokemon sentOutPokemon, Skill enemySkill) {
        this.playerParty = playerParty;
        this.userPokemon = prevPokemon;
        this.enemyPokemon = enemyPokemon;
        this.sentOutPokemon = sentOutPokemon;
        this.enemySkill = enemySkill;
        secondSkill = enemySkill;
        text = "Come back " + prevPokemon.getName() + "!";
        textCounter = 0;
        textPosition = 0;
        pokeballX = 0;
        pokeballY = 1446;
        state = SWITCH_POKEMON;
        userPokemonIsFirstAttacker = true;
        started = true;
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
                      int pokeballType, Skill enemySkill) {
        this.playerParty = playerParty;
        this.userPokemon = userPokemon;
        this.enemyPokemon = enemyPokemon;
        this.ballType = POKEBALL;
        this.enemySkill = enemySkill;
        secondSkill = enemySkill;
        //catchResults = getCatchResults();
        if (catchResults.isCaught()) {
            text = "You caught a " + enemyPokemon.getName() + "!";
        } else {
            if (catchResults.getShakes() == 0) {
                text = "Oh, no! The Pokémon broke free!";
            } else if (catchResults.getShakes() == 1) {
                text = "Aww! It appeared to be caught!";
            } else if (catchResults.getShakes() == 2) {
                text = "Aargh! Almost had it!";
            } else {
                text = "Shoot! It was so close, too!";
            }
        }
        textCounter = 0;
        textPosition = 0;
        listPosition = 0;
        userPokemonIsFirstAttacker = true;
        pokeballAnimation = new PokeballAnimation(catchResults);
        state = THROW_POKEBALL;
        started = true;
    }


    public void dispose() {
        if (pokeballAnimation != null) {
            pokeballAnimation.dispose();
        }
    }

    /****************************************************************************************************
     *
     *      INTERFACE METHODS THAT LINK BATTLEUPDATER AND BATTLESTATE
     *
     * *************************************************************************************************
     */

    public void finishedFaintSwitch() {
        state = DISPLAY_SECOND_MOVE_RESULTS;
        started = false;
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
        state = FINISHED_REPLACING_MOVE;
        text = "1, 2 and... Poof! " + userPokemon.getName() + " forgot "
                + userPokemon.getSkills().get(0).getName() +
                "\n and... " + userPokemon.getName() + " learned " + newMove.getName();
        userPokemon.getSkills().set(0, newMove);
    }
    public void removeSecondSkill() {
        state = FINISHED_REPLACING_MOVE;
        text = "1, 2 and... Poof! " + userPokemon.getName() + " forgot "
                + userPokemon.getSkills().get(1).getName() +
                "\n and... " + userPokemon.getName() + " learned " + newMove.getName();
        userPokemon.getSkills().set(1, newMove);
    }
    public void removeThirdSkill() {
        state = FINISHED_REPLACING_MOVE;
        text = "1, 2 and... Poof! " + userPokemon.getName() + " forgot "
                + userPokemon.getSkills().get(2).getName() +
                "\n and... " + userPokemon.getName() + " learned " + newMove.getName();
        userPokemon.getSkills().set(2, newMove);
    }
    public void removeFourthSkill() {
        state = FINISHED_REPLACING_MOVE;
        text = "1, 2 and... Poof! " + userPokemon.getName() + " forgot "
                + userPokemon.getSkills().get(3).getName() +
                "\n and... " + userPokemon.getName() + " learned " + newMove.getName();
        userPokemon.getSkills().set(3, newMove);
    }

    /*
* Return whether or not the battle phase started.
* @param boolean started Whether or not the battle phase started.
 */
    public boolean started() {
        return started;
    }

    public void acceptedNewMove() {
        state = WAITING_FOR_MOVE_DELETION;
        displayingYesNo = false;
    }



    public void declinedNewMove() {
        displayingYesNo = false;
        state = AUTOMATIC_NEW_MOVE;
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

    public void goToExpGraphicsState() {
        state = ADD_EXP;
        doneDisplayingExpText = false;
    }

    public void goToExpGainState() {
        expGain = enemyPokemon.calculateExp(1);
        fullBarofExp = userPokemon.getNextLevelExp();
        expGainRate = fullBarofExp / 1.5;
        if (!userPokemon.hasMaxEvs()) {
            userPokemon.addEvs(enemyPokemon.getEvYield());
        } else {
            Gdx.app.log("MAXED STATS", "");
        }
        text = userPokemon.getName() + " gained " + enemyPokemon.calculateExp(1) + " Exp. Points.";
        state = DISPLAY_EXP_GAIN;
    }

    public void renderText(SpriteBatch batch) {
        currentPhase.renderText(batch);
    }

    public boolean caughtThePokemon() {
        return false;
    }

    public boolean isDisplayingNewPokemon() {
        return false;
    }

    public SkillAnimation getSkillAnimation() {
        if (currentPhase instanceof UseAttackPhase) {
            return currentPhase.getSkillAnimation();
        } else {
            return null;
        }
    }

    public boolean hidingUserPokemon() {
        return false;
    }

    public boolean isHidingEnemyPokemon() {
        return false;
    }

    public void renderExtras(SpriteBatch batch) {
        if (state == THROW_POKEBALL || state == SHAKING_POKEBALL) {
            pokeballAnimation.render(batch);
        }
    }

    public void renderAnimationBackground(SpriteBatch batch) {

    }

    public void update(double dt) {
        currentPhase.update(dt);
        //Gdx.app.log("PHASE", currentPhase.getPhaseName());
    }

    /**
     * PUI METHODS
     */

    public void setPhase(BattlePhase p) {
        Gdx.app.log("SETTT", p.getPhaseName());
        this.currentPhase = p;
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
    public BitmapFont getFont() {
        return font;
    }
}
