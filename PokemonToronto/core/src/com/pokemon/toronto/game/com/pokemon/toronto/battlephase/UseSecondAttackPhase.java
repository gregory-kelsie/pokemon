package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.end_of_turn_effects.EndTurnPhase;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.AbsorbResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;

import java.util.ArrayList;

/**
 * Created by Gregory on 7/31/2017.
 */

public class UseSecondAttackPhase extends UseAttackPhase {

    public UseSecondAttackPhase(PhaseUpdaterInterface pui) {
        super(pui);
        phaseName = "UseSecondAttack";
        firstAttack = false;
        if (pui.isUserPokemonFirstAttacker()) {
            attackerIsUser = false;
            attemptSkillUsage();
        } else {
            attackerIsUser = true;
            attemptSkillUsage();
        }
    }
    
    private void attemptSkillUsage() {
        if (attackerIsUser) {
            attacker = pui.getUserPokemon();
            receiver = pui.getEnemyPokemon();
            usedSkill = pui.getUserSkill();
            targetsSkill = pui.getEnemySkill();
            attackerSubField = pui.getField().getPlayerField();
            receiverSubField = pui.getField().getOpponentField();
        } else {
            attacker = pui.getEnemyPokemon();
            receiver = pui.getUserPokemon();
            usedSkill = pui.getEnemySkill();
            targetsSkill = pui.getUserSkill();
            attackerSubField = pui.getField().getOpponentField();
            receiverSubField = pui.getField().getPlayerField();
        }
        if (attacker.isPowdered() && usedSkill.getType() == Pokemon.Type.FIRE) {
            attacker.subtractHealth((int)Math.round(attacker.getHealthStat() / 4.0));
            updateAttackerHealth = true;
            powdered = true;
        } else {
            FailResult failResult = usedSkill.willFail(attacker,
                    receiver, pui.getField(), attackerSubField, receiverSubField, false,
                    targetsSkill);
            if (!failResult.hasFailed()) {
                if (!usedSkill.doesDamageToEnemy() || usedSkill.continuesUseThroughNoEffect() ||
                        (usedSkill.doesDamageToEnemy() && receiver.getResistances()
                                .get(usedSkill.getType()) != 0)) {
                    if (!usedSkill.targetsEnemy(attacker, pui.getField()) || usedSkill.willHitEnemy(attacker, receiver, pui.getField(),
                            attackerSubField, receiverSubField, false)) {
                        AbsorbResult absorbResult = receiver.getAbsorbResults(usedSkill);
                        if (usedSkill.targetsEnemy(attacker, pui.getField()) && absorbResult.hasAbsorbed()) {
                            battleResults = absorbResult.getAbsorbResult();
                        } else {
                            if (attackerIsUser) {
                                battleResults = usedSkill.use(attacker, receiver, pui.getUserPokemonPosition(), pui.getEnemyPokemonPosition(),
                                        pui.getField(), attackerSubField, receiverSubField, false, targetsSkill, pui.getPlayerParty(), new ArrayList<Pokemon>());
                            } else {
                                battleResults = usedSkill.use(attacker, receiver, pui.getEnemyPokemonPosition(), pui.getUserPokemonPosition(),
                                        pui.getField(), attackerSubField, receiverSubField, false, targetsSkill, new ArrayList<Pokemon>(), pui.getPlayerParty());
                            }
                        }
                        if (attackerIsUser) {
                            animation = usedSkill.getAnimation(PLAYER_SIDE_ANIMATION);
                            checkPokemonHealthAfterUserAttack();
                        } else {
                            animation = pui.getEnemySkill().getAnimation(ENEMY_SIDE_ANIMATION);
                            checkPokemonHealthAfterEnemyAttack();
                        }
                    } else {
                        missText = attacker.getName() + "'s attack missed.";
                        attacker.cancelMissSkills(receiver);
                        updatingAnimation = false;
                        missed = true;
                        resetTextBox();
                    }
                } else {
                    missText = "It had no effect...";
                    attacker.cancelMissSkills(receiver);
                    updatingAnimation = false;
                    missed = true;
                    resetTextBox();
                }
            } else {
                missText = failResult.getFailResult();
                attacker.cancelMissSkills(receiver);
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
            int missRecoil = usedSkill.getMissRecoil();
            if (missRecoil == 0) {
                pui.setPhase(new EndTurnPhase(pui));
            }
            else {
                if (missRecoil == 1) {
                    attacker.subtractHealth((int)Math
                            .round(attacker.getHealthStat() / 2.0));
                    missed = false;
                    updateAttackerHealth = true;
                }
            }

        }

    }

    private void finishedDepletion(double dt) {
        if (enemyFainted && !userFainted) {
            pui.setPhase(new ExpPhase(pui));
        } else if (!enemyFainted && !userFainted) {
            pui.setPhase(new EndTurnPhase(pui));
        } else if (enemyFainted && userFainted) {
            if (!pui.playerHasMorePokemon()) {
                pui.setPhase(new BlackedOutPhase(pui));
            } else {
                if (pui.isWildBattle()) {
                    pui.finishedBattle();
                } else {
                    if (pui.hasWipedOutTrainer()) {
                        pui.setPhase(new EndTrainerBattle(pui));
                    } else {
                        pui.setTrainerDoubleFaint();
                        pui.setPhase(new PlayerPokemonFaintPhase(pui));
                    }
                }
            }
        } else if (!enemyFainted && userFainted) {
            if (pui.playerHasMorePokemon() && !pui.waitingForNextPokemon()) {
                pui.setPhase(new EndTurnPhase(pui, true, false));
            } else if (!pui.playerHasMorePokemon()) {
                pui.setPhase(new BlackedOutPhase(pui));
            }
        }
    }

    public SkillAnimation getSkillAnimation() {
        return animation;
    }

}
