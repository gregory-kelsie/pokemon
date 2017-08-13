package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.Gdx;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
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
            if (!pui.getUserSkill().doesDamageToEnemy() || (pui.getUserSkill().doesDamageToEnemy() &&
                    pui.getEnemyPokemon().getResistances().get(pui.getUserSkill().getType()) != 0)) {
                if (pui.getUserSkill().willHitEnemy(pui.getUserPokemon(), pui.getEnemyPokemon())) {
                    usedSkill = pui.getUserSkill();
                    battleListText = pui.getUserSkill().use(pui.getUserPokemon(), pui.getEnemyPokemon(), pui.getField());
                    animation = pui.getUserSkill().getAnimation(PLAYER_SIDE_ANIMATION);
                    attacker = pui.getUserPokemon();
                    receiver = pui.getEnemyPokemon();
                    checkPokemonHealthAfterUserAttack();
                } else {
                    missText = pui.getUserPokemon().getName() + "'s attack missed.";
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
            attackerIsUser = false;
            if (!pui.getEnemySkill().doesDamageToEnemy() || (pui.getEnemySkill().doesDamageToEnemy() &&
                    pui.getUserPokemon().getResistances().get(pui.getEnemySkill().getType()) != 0)) {
                if (pui.getEnemySkill().willHitEnemy(pui.getEnemyPokemon(), pui.getUserPokemon())) {
                    usedSkill = pui.getUserSkill();
                    battleListText = pui.getEnemySkill().use(pui.getEnemyPokemon(), pui.getUserPokemon(), pui.getField());
                    animation = pui.getEnemySkill().getAnimation(ENEMY_SIDE_ANIMATION);
                    attacker = pui.getEnemyPokemon();
                    receiver = pui.getUserPokemon();
                    checkPokemonHealthAfterEnemyAttack();
                } else {
                    missText = pui.getEnemyPokemon().getName() + "'s attack missed.";
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
            pui.setPhase(new ParalysisCheckPhase(pui, false));
        }

    }

    private void finishedDepletion(double dt) {
        if (enemyFainted && !userFainted) {
            pui.setPhase(new ExpPhase(pui));
        } else if (!enemyFainted && !userFainted) {
            pui.setPhase(new ParalysisCheckPhase(pui, false));
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
