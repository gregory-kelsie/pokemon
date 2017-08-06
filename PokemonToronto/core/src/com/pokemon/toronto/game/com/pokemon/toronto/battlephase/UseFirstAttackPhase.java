package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.Gdx;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 7/30/2017.
 */

public class UseFirstAttackPhase extends UseAttackPhase {

    public UseFirstAttackPhase(PhaseUpdaterInterface pui) {
        super(pui);
        phaseName = "UseFirstAttack";
        if (pui.isUserPokemonFirstAttacker()) {
            battleListText = pui.getUserSkill().use(pui.getUserPokemon(), pui.getEnemyPokemon());
            animation = pui.getUserSkill().getAnimation(PLAYER_SIDE_ANIMATION);
            attacker = pui.getUserPokemon();
            receiver = pui.getEnemyPokemon();
            checkPokemonHealthAfterUserAttack();

        } else {
            battleListText = pui.getEnemySkill().use(pui.getEnemyPokemon(), pui.getUserPokemon());
            animation = pui.getEnemySkill().getAnimation(ENEMY_SIDE_ANIMATION);
            attacker = pui.getEnemyPokemon();
            receiver = pui.getUserPokemon();
            checkPokemonHealthAfterEnemyAttack();
        }

    }

    @Override
    public void update(double dt) {
        if (updatingAnimation) {
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
        }
    }

    private void finishedDepletion(double dt) {
        if (enemyFainted && !userFainted) {
            Gdx.app.log("AttackResults", "EXP PHASE");
            //pui.setPhase(new ExpPhase(pui));
        } else if (!enemyFainted && !userFainted) {
            Gdx.app.log("hooplah", "blah");
            pui.setPhase(new ParalysisCheckPhase(pui, false));
        } else if (enemyFainted && userFainted) {
            if (pui.playerHasMorePokemon()) {
                pui.endBattle();
            } else {
                Gdx.app.log("AttackResults", "BLACK OUT PHASE");
                //pui.setPhase(new BlackedOutPhase(pui));
            }
        } else if (!enemyFainted && userFainted) {
            if (pui.playerHasMorePokemon()) {
                Gdx.app.log("AttackResults", "FORCE SWITCH");
                //pui.setPhase(new SwitchOutPhase(pui));
            } else {
                Gdx.app.log("AttackResults", "BLACK OUT PHASE");
               // pui.setPhase(new BlackedOutPhase(pui));
            }
        }
    }

    public SkillAnimation getSkillAnimation() {
        return animation;
    }


}
