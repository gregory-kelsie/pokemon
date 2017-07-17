package com.pokemon.toronto.game.com.pokemon.toronto.stateupdater;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.PokeballAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.catching.CatchResults;
import com.pokemon.toronto.game.com.pokemon.toronto.gamestate.BattleInterface;
import com.pokemon.toronto.game.com.pokemon.toronto.gamestate.BattleState;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

import java.util.List;

/**
 * Created by Gregory on 6/18/2017.
 */
public class BattleUpdater {
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

    public BattleUpdater(BattleInterface battleState, BitmapFont font) {
        this.battleState = battleState;
        this.font = font;
        started = false;
        state = IDLE;
        counter = 0;
        hidingUserPokemon = false;
        caughtThePokemon = false;

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

        text = "";
        textCounter = 0;
        textPosition = 0;
        listPosition = 0;

        state = SPEED_CHECK_PHASE;
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
     * When the battle is started by the player throwing a pokeball in an attempt to catch
     * the enemy pokemon. Therefore there is no skill being used by the player, a ball type
     * and an enemy skill in case the attempt to catch the pokemon fails.
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
        catchResults = getCatchResults();
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
        pokeballAnimation = new PokeballAnimation();
        state = THROW_POKEBALL;
        started = true;
    }

    private CatchResults getCatchResults() {
        double ballMultiplier = getBallMultiplier(ballType);
        double catchRate = enemyPokemon.getCaptureRate();
        int maxHealth = enemyPokemon.getHealthStat();
        int currentHealth = enemyPokemon.getCurrentHealth();
        double bonusStatus = getBonusStatus(enemyPokemon.getStatus());
        double a = (((3 * maxHealth - 2 * currentHealth) * catchRate * ballMultiplier)
                / (3 * maxHealth)) * bonusStatus;
        Gdx.app.log("Capture", "a: " + a);
        int shakeAmount = 0;
        if (a < 255) {
            double b = 1048560 / (Math.sqrt(Math.sqrt(16711680 / a)));
            Gdx.app.log("Capture", "b: " + b);
            boolean caught = true;
            for (int i = 0; i < 4; i++) {
                long rand = Math.round(Math.random() * 65535);
                Gdx.app.log("Capture", "rand: " + rand);
                if (rand < b) {
                    shakeAmount++;
                } else {
                    caught = false;
                    break;
                }
            }
            return new CatchResults(caught, shakeAmount);
        } else {
            return new CatchResults(true, 0);
        }

    }

    private double getBonusStatus(Pokemon.Status s) {
        if (s == Pokemon.Status.BURN || s == Pokemon.Status.PARALYSIS) {
            return 1.5;
        } else if (s == Pokemon.Status.FROZEN || s == Pokemon.Status.SLEEP) {
            return 2;
        } else {
            return 1;
        }
    }
    private double getBallMultiplier(int ballType) {
        if (ballType == POKEBALL) {
            return 1;
        } else {
            return 1;
        }
    }

    /*
    * Update the battle phase. Determine how to update the phase
    * based on which state it is in.
    * @param double dt The time passed since the previous loop.
     */
    public void update(double dt) {
        if (state == SPEED_CHECK_PHASE) {
            speedClash(userPokemon, enemyPokemon, userSkill, enemySkill);
        }
        else if (state == DISPLAY_FIRST_SKILL_NAME) {
            updateFirstSkillName(dt);
        } else if (state == DISPLAY_FIRST_SKILL_MISS_FAIL) {
            updateDisplayFirstSkillMissFail(dt);
        } else if (state == USE_FIRST_SKILL_ANIMATION) {
            animation.update(dt);
            userPokemon.setPlayerX(animation.getPlayerX());
            userPokemon.setPlayerY(animation.getPlayerY());
            enemyPokemon.setEnemyX(animation.getEnemyX());
            enemyPokemon.setEnemyY(animation.getEnemyY());
            if (animation.isFinished()) {
                animation.dispose();
                state = DEPLETE_SLOW_POKEMON_HEALTH;
            }
        } else if (state == DEPLETE_SLOW_POKEMON_HEALTH) {
            depleteSlowPokemonHealth();

        } else if (state == DISPLAY_SECOND_SKILL_NAME) {
            updateSecondSkillName(dt);
        } else if (state == USE_SECOND_SKILL_ANIMATION) {
            animation.update(dt);
            userPokemon.setPlayerX(animation.getPlayerX());
            userPokemon.setPlayerY(animation.getPlayerY());
            enemyPokemon.setEnemyX(animation.getEnemyX());
            enemyPokemon.setEnemyY(animation.getEnemyY());
            if (animation.isFinished()) {
                animation.dispose();
                state = DEPLETE_FAST_POKEMON_HEALTH;
            }
        } else if (state == DEPLETE_FAST_POKEMON_HEALTH) {
            depleteFastPokemonHealth();
        } else if (state == DISPLAY_FIRST_MOVE_RESULTS) {
            updateFirstMoveResults(dt);
        } else if (state == DISPLAY_SECOND_MOVE_RESULTS) {
            updateSecondMoveResults(dt);
        } else if (state == FAINT_SLOW_POKEMON) {
            faintSlowPokemon(dt);
        } else if (state == FAINT_FAST_POKEMON) {
            faintFastPokemon(dt);
        } else if (state == DISPLAY_BLACKED_OUT_TEXT) {
            Gdx.app.log("Blacked out", "bbbb");
            updateBlackedOutText(dt);
        } else if (state == SWITCH_POKEMON) {
            updateSwitchPokemon(dt);
        } else if (state == DRAW_SWITCH_RETURN_BALL) {
            updateDrawSwitchReturnBall(dt);
        } else if (state == DRAW_SWITCH_THROW_BALL) {
            updateDrawSwitchThrowBall(dt);
        } else if (state == THROW_POKEBALL) {
            updateThrowPokeball(dt);
        } else if (state == SHAKING_POKEBALL) {
            updateShakingPokeball(dt);
        } else if (state == DISPLAY_CATCH_RESULTS) {
            updateCatchResultsText(dt);
        } else if (state == HIDE_SWITCHED_POKEMON) {
            counter += dt;
            //Wait two seconds before displaying the pokemon that is coming out.
            if (counter >= 1.5) {
                counter = 0;
                state = DISPLAY_NEW_POKEMON_NAME;
            }
        } else if (state == DELAY_AFTER_NEW_POKEMON_ENTRANCE) {
            updateDelayAfterNewPokemonEntrance(dt);
        } else if (state == DISPLAY_NEW_POKEMON_NAME) {

            updateNewPokemonName(dt);
        } else if (state == DISPLAY_SENT_OUT_POKEMON) {

        }

    }

    private void updateNewPokemonName(double dt) {
        textCounter += dt;
        if (textCounter >= 0.05) {
            if (textPosition == text.length()) {

            } else {
                textPosition += 1;
                textCounter = 0;
            }

        }
        //1 Second delay after writing the name.
        if (textCounter >= 1) {
            textCounter = 0;
            textPosition = 0;
            listPosition = 0;
            userPokemon = sentOutPokemon;
            state = DELAY_AFTER_NEW_POKEMON_ENTRANCE;
            text = "";
            counter = 0;

        }
    }

    private void updateDelayAfterNewPokemonEntrance(double dt) {
        counter += dt;
        if (counter >= 1.5) {
            counter = 0;
            text = enemyPokemon.getName() + " used " + enemySkill.getName();
            state = DISPLAY_SECOND_SKILL_NAME;
        }
    }
    private void updateThrowPokeball(double dt) {
        pokeballAnimation.update(dt);
        if (pokeballAnimation.isFinished()) {
            state = SHAKING_POKEBALL;
            pokeballAnimation.resetFinish(catchResults);
        }
    }

    private void updateShakingPokeball(double dt) {
        pokeballAnimation.update(dt);
        if (pokeballAnimation.isFinished()) {
            state = DISPLAY_CATCH_RESULTS;
        }
    }

    private void updateCatchResultsText(double dt) {
        textCounter += dt;
        if (textCounter >= 0.05) {
            if (textPosition == text.length()) {

            } else {
                textPosition += 1;
                textCounter = 0;
            }

        }
        //1 Second delay after writing the name.
        if (textCounter >= 2) {
            if (catchResults.isCaught()) {
                started = false;
                caughtThePokemon = true;
            } else {
                text = enemyPokemon.getName() + " used " + enemySkill.getName();
                textCounter = 0;
                textPosition = 0;
                listPosition = 0;
                state = DISPLAY_SECOND_SKILL_NAME;
            }
        }
    }

    private void updateDrawSwitchThrowBall(double dt) {
        boolean textFinished = false;
        boolean pokeballFinished = false;
        textCounter += dt;
        if (textCounter >= 0.05) {
            if (textPosition == text.length() - 1) {
                textFinished = true;
            } else {
                textPosition += 1;
                textCounter = 0;
            }
        }
        if (pokeballX + 123 < 375) {
            pokeballX += 7;
            pokeballY = (int) Math.round(-0.00069372181 * (Math.pow(pokeballX, 2)) + 1446);
        } else {
            if (pokeballFinished && textFinished) {
                counter += dt;
                if (counter >= 0.5) {
                    //GET Skill from enemy and use slow skill.
                }
            }
        }
    }
    private void updateDrawSwitchReturnBall(double dt) {
        counter += dt;

        if (counter >= 1) {
            state = DRAW_SWITCH_THROW_BALL;
            counter = 0;
        }
    }

    private void updateSwitchPokemon(double dt) {
        boolean delay = false;
        textCounter += dt;
        if (textCounter >= 0.05) {
            if (textPosition == text.length()) {
                delay = true;
            } else {
                textPosition += 1;
                textCounter = 0;
            }
            if (delay && textCounter >= 1) {
                textCounter = 0;
                state = HIDE_SWITCHED_POKEMON;
                text = "Go " + sentOutPokemon.getName() + "!!";
                textPosition = 0;
                counter = 0;
            }
        }

    }

    /*
    * Check which Pokemon will be the first attacker based on speed and
    * move priority. Then go to the display skill name state.
    * @param Pokemon userPokemon The player's pokemon in the battle
    * @param Pokemon enemyPokemon The enemy's pokemon in the battle
    * @param Skill userSkill The move the player is using in this phase.
    * @param Skill enemySkill The move the enemy is using in this phase.
     */
    private void speedClash(Pokemon userPokemon, Pokemon enemyPokemon,
                            Skill userSkill,Skill enemySkill) {
        if (userPokemon.getSpeedStat() >= enemyPokemon.getSpeedStat()) {
            firstSkill = userSkill;
            secondSkill = enemySkill;
            userPokemonIsFirstAttacker = true;
            text = userPokemon.getName() + " used " + firstSkill.getName();
        } else {
            firstSkill = enemySkill;
            secondSkill = userSkill;
            userPokemonIsFirstAttacker = false;
            text = enemyPokemon.getName() + " used " + firstSkill.getName();
        }
        state = DISPLAY_FIRST_SKILL_NAME;

        textCounter = 0;
    }

    /*
    * Update the first move's skill name substring until it reaches the
    * length. When it reaches the length, use the skill.
    * @param double dt The time passed since the previous loop.
     */
    private void updateFirstSkillName(double dt) {
        textCounter += dt;
        if (textCounter >= 0.05) {
            if (textPosition == text.length()) {

            } else {
                textPosition += 1;
                textCounter = 0;
            }

        }
        //1 Second delay after writing the name.
        if (textCounter >= 1) {
            textCounter = 0;
            useFastSkill();
        }
    }

    /*
    * Use the fast pokemon's skill. Get the list of results after using
    * the move. Go to the animation state after use.
     */
    private void useFastSkill() {
        if (userPokemonIsFirstAttacker) {
            battleListText = firstSkill.use(userPokemon, enemyPokemon);
            battleState.setBattleTextList(battleListText);
            if (battleListText.get(0).size() == 0) {
                state = USE_FIRST_SKILL_ANIMATION;
                animation = firstSkill.getAnimation(PLAYER_SIDE_ANIMATION);
            } else {
                state = DISPLAY_FIRST_SKILL_MISS_FAIL;
            }
        } else {
            battleListText = firstSkill.use(enemyPokemon, userPokemon);
            battleState.setBattleTextList(battleListText);
            if (battleListText.get(0).size() == 0) {
                state = USE_FIRST_SKILL_ANIMATION;
                animation = firstSkill.getAnimation(ENEMY_SIDE_ANIMATION);
            } else {
                state = DISPLAY_FIRST_SKILL_MISS_FAIL;
            }
        }
    }

    /*
    * Deplete the health of the faster pokemon. This is due to
    * the slower pokemon's move.
     */
    private void depleteFastPokemonHealth() {
        //Check which pokemon is the fast one.
        if (userPokemonIsFirstAttacker) {
            //User is the fast one
            if (!userPokemon.matchingAnimationHealth()) {
                userPokemon.adjustAnimationHealth(1);
            } else {
                if (userPokemon.getCurrentHealth() != 0) {
                    state = DISPLAY_SECOND_MOVE_RESULTS;
                    text = battleListText.get(1).get(0);
                    textCounter = 0;
                    textPosition = 0;
                    listPosition = 0;
                    //started = false;
                } else {
                    //ASDFADSFASDFASDFASDF
                    state = FAINT_FAST_POKEMON;
                    textCounter = 0;
                    textPosition = 0;
                }
            }
        } else {
            //Enemy is the fast one.
            if (!enemyPokemon.matchingAnimationHealth()) {
                enemyPokemon.adjustAnimationHealth(1);
            } else {
                if (enemyPokemon.getCurrentHealth() != 0) {
                    state = DISPLAY_SECOND_MOVE_RESULTS;
                    text = battleListText.get(1).get(0);
                    textCounter = 0;
                    textPosition = 0;
                    listPosition = 0;
                    //started = false;
                } else {
                    state = FAINT_FAST_POKEMON;
                    textCounter = 0;
                    textPosition = 0;
                }
            }
        }
    }

    /*
    * Update the result text of the first move. Ex: Whether it
    * was super effective or crit. After update change state to
    * display the name of the slower pokemon's move.
    * @param double dt The time passed since the previous loop.
     */
    private void updateFirstMoveResults(double dt) {
        textCounter += dt;
        //Keep track on whether or not to reset the textCounter
        boolean resetCounter = true;
        if (textCounter >= 0.05) {
            if (textPosition == battleListText.get(1).get(listPosition).length() - 1) {
                resetCounter = false;
            } else {
                textPosition++;
            }
            //When the textCounter is past 1.5 the delay is over
            //It will only be past 1.5 when finished drawing the lines
            if (textCounter >= 1.5) {
                textPosition = 0;
                if (listPosition < battleListText.get(1).size() - 1)
                {
                    listPosition++;
                    textCounter = 0;
                }
                else {
                    listPosition = 0;
                    if (userPokemonIsFirstAttacker) {
                        if (enemyPokemon.isFainted()) {
                            state = DISPLAY_EXP_GAIN;
                        } else {
                            state = DISPLAY_SECOND_SKILL_NAME;
                            text = enemyPokemon.getName() + " used " + secondSkill.getName();
                        }
                    } else {
                        if (userPokemon.isFainted()) {
                            if (playerHasMorePokemon()) {
                                state = WAIT_FOR_NEXT_POKEMON;
                            } else {
                                Gdx.app.log("Blacked", "BABY");
                                state = DISPLAY_BLACKED_OUT_TEXT;
                                text = "You have blacked out";
                                textPosition = 0;
                                textCounter = 0;
                            }
                        } else {
                            state = DISPLAY_SECOND_SKILL_NAME;
                            text = userPokemon.getName() + " used " + secondSkill.getName();
                        }
                    }
                }

            }
            if (resetCounter) {
                //Reset the counter
                textCounter = 0;
            }
        }
    }

    private void updateBlackedOutText(double dt) {
        boolean delay = false;
        textCounter += dt;
        if (textCounter >= 0.05) {
            if (textPosition <= text.length() - 1) {
                textPosition++;
                textCounter = 0;
            } else {
                delay = true;
            }
        }
        if (!delay) {

        } else {
            if (textCounter >= 1.5) {
                battleState.blackedOut();
            }
        }
    }

    public boolean waitingForNextPokemon() {
        if (state == WAIT_FOR_NEXT_POKEMON) {
            return true;
        }
        return false;
    }

    public void finishedFaintSwitch() {
        state = DISPLAY_SECOND_MOVE_RESULTS;
        started = false;
    }
    /*
    * Updates the second move name, similar to updateFirstSkillName
    * @param double dt The time passed since the previous loop.
     */
    private void updateSecondSkillName(double dt) {
        textCounter += dt;
        if (textCounter >= 0.05) {
            if (textPosition == text.length()) {

            } else {
                textPosition += 1;
                textCounter = 0;
            }
        }
        //1 Second delay after writing the name.
        if (textCounter >= 1) {
            textCounter = 0;
            useSecondSkill();
        }
    }

    /*
    * Deplete the health of the second attacker. This is due to
    * the faster pokemon's move.
     */
    private void depleteSlowPokemonHealth() {
        //TODO: Implement death
        //Determine which pokemon is the slow one
        if (userPokemonIsFirstAttacker) {
            //Enemy pokemon is slow so deplete their health.
            if (!enemyPokemon.matchingAnimationHealth()) {
                enemyPokemon.adjustAnimationHealth(1);
            } else {
                if (enemyPokemon.getCurrentHealth() != 0) {
                    //Display the second skill name after depleting health.
                    if (battleListText.get(1).size() > 0) {
                        state = DISPLAY_FIRST_MOVE_RESULTS;
                        text = battleListText.get(1).get(0);
                        listPosition = 0;
                        textCounter = 0;
                        textPosition = 0;
                    }
                    else {

                    text = enemyPokemon.getName() + " used " + secondSkill.getName();
                    textCounter = 0;
                    textPosition = 0;
                    state = DISPLAY_SECOND_SKILL_NAME;

                    }
                } else {
                    state = FAINT_SLOW_POKEMON;
                    textCounter = 0;
                    textPosition = 0;
                }
            }
        } else {
            //User's pokemon is slow so deplete their health.
            if (!userPokemon.matchingAnimationHealth()) {
                userPokemon.adjustAnimationHealth(1);
            } else {
                if (userPokemon.getCurrentHealth() != 0) {
                    //Display the second skill name after depleting health.
                    if (battleListText.get(1).size() > 0) {
                        state = DISPLAY_FIRST_MOVE_RESULTS;
                        text = battleListText.get(1).get(0);
                        listPosition = 0;
                        textCounter = 0;
                        textPosition = 0;
                    } else {
                        text = userPokemon.getName() + " used " + secondSkill.getName();
                        textCounter = 0;
                        textPosition = 0;
                        state = DISPLAY_SECOND_SKILL_NAME;
                    }
                } else {
                    state = FAINT_SLOW_POKEMON;
                    listPosition = 0;
                    textCounter = 0;
                    textPosition = 0;
                }
            }
        }
    }

    /**
     * Update the fainting animation and when it's finished faint the slow
     * pokemon and move onto the move results state.
     * @param dt The time passed.
     */
    private void faintSlowPokemon(double dt) {
        if (userPokemonIsFirstAttacker) {
            enemyPokemon.setEnemyY((int)(enemyPokemon.getEnemyY() - 10));
            Gdx.app.log("FAINT", "" + enemyPokemon.getEnemyY());
            if (enemyPokemon.getEnemyY() <= enemyPokemon.getFaintedEnemyY()) {
                //Make the pokemon faint when it went down to the right faint position
                enemyPokemon.setEnemyY(enemyPokemon.getFaintedEnemyY());
                enemyPokemon.setFaint(true);

                state = DISPLAY_FIRST_MOVE_RESULTS;
                textCounter = 0;
                textPosition = 0;
                listPosition = 0;
            }
        } else {
            //Make the sprite go down
            userPokemon.setPlayerY((int)(userPokemon.getPlayerY() - 10));
            if (userPokemon.getPlayerY() <= userPokemon.getFaintedPlayerY()) {
                //Make the pokemon faint when it went down to the right faint position
                userPokemon.setPlayerY(userPokemon.getPlayerNormalY());
                userPokemon.setFaint(true);

                state = DISPLAY_FIRST_MOVE_RESULTS;
                textCounter = 0;
                textPosition = 0;
                listPosition = 0;
            }
        }
    }

    private void faintFastPokemon(double dt) {
        if (userPokemonIsFirstAttacker) {
            //Make the sprite go down
            userPokemon.setPlayerY((int)(userPokemon.getPlayerY() - 10));
            if (userPokemon.getPlayerY() <= userPokemon.getFaintedPlayerY()) {
                //Make the pokemon faint when it went down to the right faint position
                userPokemon.setPlayerY(userPokemon.getPlayerNormalY());
                userPokemon.setFaint(true);

                state = DISPLAY_SECOND_MOVE_RESULTS;
                textCounter = 0;
                textPosition = 0;
                listPosition = 0;
            }

        } else {
            enemyPokemon.setEnemyY((int)(enemyPokemon.getEnemyY() - 10));
            Gdx.app.log("FAINT", "" + enemyPokemon.getEnemyY());
            if (enemyPokemon.getEnemyY() <= enemyPokemon.getFaintedEnemyY()) {
                //Make the pokemon faint when it went down to the right faint position
                enemyPokemon.setEnemyY(enemyPokemon.getFaintedEnemyY());
                enemyPokemon.setFaint(true);

                state = DISPLAY_SECOND_MOVE_RESULTS;
                textCounter = 0;
                textPosition = 0;
                listPosition = 0;
            }
        }
    }

    private boolean playerHasMorePokemon() {
        boolean hasMore = false;
        for (int i = 0; i < playerParty.size(); i++) {
            if (!playerParty.get(i).isFainted()) {
                return true;
            }
        }
        return false;
    }

    /**
    * Update the result of the second move, similar to
    * updateFirstMoveResults.
    * @param dt The time passed since the previous loop.
     */
    private void updateSecondMoveResults(double dt) {
        textCounter += dt;
        //Keep track on whether or not to reset the textCounter
        boolean resetCounter = true;
        if (textCounter >= 0.05) {
            if (textPosition == battleListText.get(1).get(listPosition).length() - 1) {
              resetCounter = false;
            } else {
                textPosition++;
            }
            //When the textCounter is past 1.5 the delay is over
            //It will only be past 1.5 when finished drawing the lines
            if (textCounter >= 1.5) {
                textCounter = 0;
                textPosition = 0;
                if (listPosition == battleListText.get(1).size() - 1) {
                    listPosition = 0;
                    listPosition = 0;
                    if (userPokemonIsFirstAttacker)
                    {
                        if (userPokemon.isFainted()) {
                            if (playerHasMorePokemon()) {
                                state = WAIT_FOR_NEXT_POKEMON;
                            } else {
                                state = DISPLAY_BLACKED_OUT_TEXT;
                                text = "You have blacked out";
                                textPosition = 0;
                                textCounter = 0;
                            }
                        } else {
                            started = false;
                        }

                    }
                    else
                    {
                        if (enemyPokemon.isFainted()) {
                            state = DISPLAY_EXP_GAIN;
                        } else {
                            started = false;
                        }
                    }
                }
                else
                {
                    listPosition++;
                }
            }
            if (resetCounter) {
                //Reset the counter
                textCounter = 0;
            }
        }
    }

    /*
    * Use the second skill, similar to useFirstSkill. After use
    * change the state to start the second skill's animation.
     */
    private  void useSecondSkill() {
        if (userPokemonIsFirstAttacker) {
            battleListText = secondSkill.use(enemyPokemon, userPokemon);
            battleState.setBattleTextList(battleListText);
            if (battleListText.get(0).size() == 0) {
                state = USE_SECOND_SKILL_ANIMATION;
                animation = secondSkill.getAnimation(ENEMY_SIDE_ANIMATION);
            } else {
                //Second fail miss
            }
        } else {
            battleListText = secondSkill.use(userPokemon, enemyPokemon);
            battleState.setBattleTextList(battleListText);
            if (battleListText.get(0).size() == 0) {
                state = USE_SECOND_SKILL_ANIMATION;
                animation = secondSkill.getAnimation(PLAYER_SIDE_ANIMATION);
            } else {
                //second fail miss
            }
        }
    }

    /*
    * Render the text that goes into the textbox.
    * @param batch The batch we render the text to.
     */
    public void renderText(SpriteBatch batch) {
        if (state == DISPLAY_FIRST_SKILL_NAME  || state == DISPLAY_SECOND_SKILL_NAME || state == DISPLAY_BLACKED_OUT_TEXT ||
                state == SWITCH_POKEMON || state == DISPLAY_CATCH_RESULTS || state == HIDE_SWITCHED_POKEMON ||
        state == DISPLAY_NEW_POKEMON_NAME) {
            font.draw(batch, text.substring(0, textPosition), 54, 1143);
        } else if (state == DISPLAY_FIRST_SKILL_MISS_FAIL) {
            font.draw(batch, battleListText.get(0).get(listPosition)
                    .substring(0, textPosition), 54, 1143);
        } else if (state == DISPLAY_FIRST_MOVE_RESULTS || state == DISPLAY_SECOND_MOVE_RESULTS) {
            font.draw(batch, battleListText.get(1).get(listPosition)
                    .substring(0, textPosition), 54, 1143);
        }
    }


    /*
    * Render the animation background. Usually empty unless a special
    * skill utilizes it.
    * @param SpriteBatch batch The batch we render the background to.
     */
    public void renderAnimationBackground(SpriteBatch batch) {
        if (animation != null) {
            if (started && animation.drawAnimationBackground()) {
                animation.drawAnimationBackground(batch);
            }
        }
    }

    public void renderExtras(SpriteBatch batch) {
        if (state == THROW_POKEBALL || state == SHAKING_POKEBALL) {
            pokeballAnimation.render(batch);
        }
    }

    /*
    * Update the text of the first skill's fail results. Ex: If the skill
    * missed or failed. Start the second move after the update is complete.
    * @param double dt The time passed since the previous loop.
     */
    private void updateDisplayFirstSkillMissFail(double dt) {
        textCounter += dt;
        if (textCounter >= 0.05) {
            if (textPosition == battleListText.get(0).get(listPosition).length() - 1) {
                if (listPosition == battleListText.get(0).size() - 1) {
                    state = START_SECOND_MOVE;
                    listPosition = 0;
                } else {
                    listPosition++;
                }
            } else {
                textPosition++;
            }
            textCounter = 0;
        }
    }

    /*
    * Return the current skill animation
    * @return animation The current skill animation.
     */
    public SkillAnimation getSkillAnimation() {
        return animation;
    }

    /*
    * Return the player's pokemon.
    * @return userPokemon The player's pokemon in the battle.
     */
    public Pokemon getUserPokemon() {
        return userPokemon;
    }

    /*
    * Return the enemy's pokemon.
    * @param Pokemon enemyPokemon The enemy's pokemon in the battle.
     */
    public Pokemon getEnemyPokemon() {
        return enemyPokemon;
    }

    /*
    * Return whether or not the battle phase started.
    * @param boolean started Whether or not the battle phase started.
     */
    public boolean started() {
        return started;
    }

    public boolean caughtThePokemon() { return caughtThePokemon; }


    public boolean isShaking() {
        if (state == SHAKING_POKEBALL) {
            return true;
        } else {
            if (state == DISPLAY_CATCH_RESULTS && catchResults.isCaught()) {
                return true;
            }
            return false;
        }
    }

    public boolean hidingUserPokemon() {
        if (state == HIDE_SWITCHED_POKEMON || state == DISPLAY_NEW_POKEMON_NAME) {
            return true;
        }
        return false;
    }

    public boolean isDisplayingNewPokemon() {
        if (state == DELAY_AFTER_NEW_POKEMON_ENTRANCE) {
            return true;
        }
        return false;
    }

    public void getNextPokemonPosition(int position) {
        userPokemon = playerParty.get(position);
    }

    public void dispose() {
        if (pokeballAnimation != null) {
            pokeballAnimation.dispose();
        }
    }


}
