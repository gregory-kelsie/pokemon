package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.Gdx;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 7/30/2017.
 */

public class UseFirstAttackPhase extends UseAttackPhase {

    public UseFirstAttackPhase(PhaseUpdaterInterface pui) {
        super(pui);
        phaseName = "UseFirstAttack";
        firstAttack = true;
        if (pui.isUserPokemonFirstAttacker()) {
            attackerIsUser = true;
            attemptSkillUsage();
        } else {
            attackerIsUser = false;
            attemptSkillUsage();
        }
    }
    
    private void attemptSkillUsage() {
        if (attackerIsUser) {
            attacker = pui.getUserPokemon();
            receiver = pui.getEnemyPokemon();
            usedSkill = pui.getUserSkill();
        } else {
            attacker = pui.getEnemyPokemon();
            receiver = pui.getUserPokemon();
            usedSkill = pui.getEnemySkill();
        }
        FailResult failResult = usedSkill.willFail(attacker, receiver, pui.getField(), true);
        if (!failResult.hasFailed()) {
            if (!usedSkill.doesDamageToEnemy() || usedSkill.continuesUseThroughNoEffect() ||
                    (usedSkill.doesDamageToEnemy() && receiver.getResistances()
                            .get(usedSkill.getType()) != 0)) {
                if (usedSkill.willHitEnemy(attacker, receiver, pui.getField(), true)) {
                    battleListText = usedSkill.use(attacker, receiver, pui.getField(), true);
                    if (attackerIsUser) {
                        animation = usedSkill.getAnimation(PLAYER_SIDE_ANIMATION);
                        checkPokemonHealthAfterUserAttack();
                    } else {
                        animation = pui.getEnemySkill().getAnimation(ENEMY_SIDE_ANIMATION);
                        checkPokemonHealthAfterEnemyAttack();
                    }
                } else {
                    missText = attacker.getName() + "'s attack missed.";
                    updatingAnimation = false;
                    missed = true;
                    resetTextBox();
                }
            } else {
                missText = "It had no effect...";
                updatingAnimation = false;
                missed = true;
                resetTextBox();
            }
        } else {
            missText = failResult.getFailResult();
            updatingAnimation = false;
            missed = true;
            resetTextBox();
        }      
    }

    @Override
    public void update(double dt) {
        if (state == ABILITY_CONTACT) {
            checkAbilityContact(dt);
        } else if (state == DISPLAY_ABILITY_CONTACT_RESULTS) {
            updateAbilityContactResults(dt);
        }
        else if (updatingAnimation) {
            updateAnimation(dt);
        } else if (updatingHealth) {
            updateReceiverHealth(dt);
        } else if (displayingResults) {
            displayResults(dt);
        } else if (displayEnemyFaintAnimation) {
            updateEnemyFaintAnimation(dt);
        } else if (updateAttackerHealth) {
            updateAttackerHealth(dt);
        } else if (displayRecoilResults) {
            displayRecoilResults(dt);
        } else if (displayUserFaintAnimation) {
            updateUserFaintAnimation(dt);
        } else if (finishedDepletion) {
            finishedDepletion(dt);
        } else if (missed) {
            updateMissText(dt);
        }
    }

    private void updateMissText(double dt) {
        textCounter += dt;
        if (textCounter >= 0.05) {
            if (textPosition < missText.length()) {
                textPosition++;
                textCounter = 0;
            }
        }
        if (textCounter >= 1.5) {
            pui.setPhase(new SleepCheckPhase(pui, false));
        }

    }

    private void finishedDepletion(double dt) {
        if (enemyFainted && !userFainted) {
            pui.setPhase(new ExpPhase(pui));
        } else if (!enemyFainted && !userFainted) {
            pui.setPhase(new SleepCheckPhase(pui, false));
        } else if (enemyFainted && userFainted) {
            if (!pui.playerHasMorePokemon()) {
                pui.setPhase(new BlackedOutPhase(pui));
            } else {
                pui.finishedBattle();
            }
        } else if (!enemyFainted && userFainted) {
            if (pui.isUserPokemonFirstAttacker()) {
                //The user killed themselves with recoil if this is the case.
                //Go to the enemy's second move to hit nothing and then switch.
                pui.setPhase(new MissAfterRecoilFaintPhase(pui));
            } else {
                if (pui.playerHasMorePokemon() && !pui.waitingForNextPokemon()) {
                    pui.setPhase(new PlayerPokemonFaintPhase(pui));
                } else if (!pui.playerHasMorePokemon()) {
                    pui.setPhase(new BlackedOutPhase(pui));
                }
            }
        }
    }

    public SkillAnimation getSkillAnimation() {
        return animation;
    }


}
