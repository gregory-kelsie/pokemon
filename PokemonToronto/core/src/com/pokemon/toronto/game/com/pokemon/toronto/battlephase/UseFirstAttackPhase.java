package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.battlephase.end_of_turn_effects.EndTurnPhase;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.AbsorbResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;

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
            isUser = true;
            attemptSkillUsage();
        } else {
            attackerIsUser = false;
            isUser = false;
            attemptSkillUsage();
        }
    }
    
    private void attemptSkillUsage() {
        if (attackerIsUser) {
            attacker = pui.getUserPokemon();
            attackerPartyPosition = pui.getUserPokemonPosition();
            receiver = pui.getEnemyPokemon();
            receiverPartyPosition = pui.getEnemyPokemonPosition();
            usedSkill = pui.getUserSkill();
            targetsSkill = pui.getEnemySkill();
            attackerSubField = pui.getField().getPlayerField();
            receiverSubField = pui.getField().getOpponentField();
        } else {
            attacker = pui.getEnemyPokemon();
            attackerPartyPosition =  pui.getEnemyPokemonPosition();
            receiver = pui.getUserPokemon();
            receiverPartyPosition = pui.getUserPokemonPosition();
            usedSkill = pui.getEnemySkill();
            targetsSkill = pui.getUserSkill();
            attackerSubField = pui.getField().getOpponentField();
            receiverSubField = pui.getField().getPlayerField();
        }
        FailResult failResult = usedSkill.willFail(attacker, receiver, pui.getField(),
                attackerSubField, receiverSubField, true, targetsSkill);
        if (!failResult.hasFailed()) {
            if (!usedSkill.doesDamageToEnemy() || usedSkill.continuesUseThroughNoEffect() ||
                    (usedSkill.doesDamageToEnemy() && receiver.getResistances()
                            .get(usedSkill.getType()) != 0)) {
                if (!usedSkill.targetsEnemy(attacker, pui.getField()) ||
                        usedSkill.willHitEnemy(attacker, receiver, pui.getField(),
                        attackerSubField, receiverSubField, true)) {
                    AbsorbResult absorbResult = receiver.getAbsorbResults(usedSkill);
                    if (usedSkill.targetsEnemy(attacker, pui.getField()) &&
                            absorbResult.hasAbsorbed()) {
                        List<String> blt = absorbResult.getAbsorbResult();
                        battleResults = blt;
                    } else {
                        if (attackerIsUser) {
                            calcSchoolingBeforeDamageOrHeal(attacker, isUser);
                            calcSchoolingBeforeDamageOrHeal(receiver, !isUser);
                            battleResults = usedSkill.use(attacker, receiver,
                                    pui.getUserPokemonPosition(), pui.getEnemyPokemonPosition(),
                                    pui.getField(), attackerSubField, receiverSubField, true,
                                    targetsSkill, pui.getPlayerParty(), new ArrayList<Pokemon>());
                            calcSchoolingAfterDamageOrHeal(attacker, isUser);
                            calcSchoolingAfterDamageOrHeal(receiver, !isUser);
                        } else {
                            calcSchoolingBeforeDamageOrHeal(attacker, !isUser);
                            calcSchoolingBeforeDamageOrHeal(receiver, isUser);
                            battleResults = usedSkill.use(attacker, receiver,
                                    pui.getEnemyPokemonPosition(), pui.getUserPokemonPosition(),
                                    pui.getField(), attackerSubField, receiverSubField, true,
                                    targetsSkill, new ArrayList<Pokemon>(), pui.getPlayerParty());
                            calcSchoolingAfterDamageOrHeal(attacker, !isUser);
                            calcSchoolingAfterDamageOrHeal(receiver, isUser);
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
                updatingAnimation = false;
                attacker.cancelMissSkills(receiver);
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
            //TODO: Check if the Pokemon damages themself with a miss
            int missRecoil = usedSkill.getMissRecoil();
            if (missRecoil == 0) {
                pui.setPhase(new SleepCheckPhase(pui, false));
            }
            else {
                if (missRecoil == 1) {
                    calcSchoolingBeforeDamageOrHeal(attacker, isUser);
                    attacker.subtractHealth((int)Math
                            .round(attacker.getHealthStat() / 2.0));
                    calcSchoolingAfterDamageOrHeal(attacker, isUser);
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
            pui.setPhase(new SleepCheckPhase(pui, false));
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
            if (pui.isUserPokemonFirstAttacker()) {
                //The user killed themselves with recoil if this is the case.
                //Go to the enemy's second move to hit nothing and then switch.
                pui.setPhase(new MissAfterRecoilFaintPhase(pui));
            } else {
                if (pui.playerHasMorePokemon() && !pui.waitingForNextPokemon()) {
                    pui.setPhase(new EndTurnPhase(pui, true, false));
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
