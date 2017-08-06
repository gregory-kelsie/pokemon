package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.Gdx;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;

import java.util.List;

/**
 * Created by Gregory on 7/31/2017.
 */

public class UseSecondAttackPhase extends UseAttackPhase {

    public UseSecondAttackPhase(PhaseUpdaterInterface pui) {
        super(pui);
        phaseName = "UseSecondAttack";
        Gdx.app.log("secondattack", "bam");
        if (pui.isUserPokemonFirstAttacker()) {
            battleListText = pui.getEnemySkill().use(pui.getEnemyPokemon(), pui.getUserPokemon());
            animation = pui.getEnemySkill().getAnimation(ENEMY_SIDE_ANIMATION);
            attacker = pui.getEnemyPokemon();
            receiver = pui.getUserPokemon();
            checkPokemonHealthAfterEnemyAttack();
        } else {
            battleListText = pui.getUserSkill().use(pui.getUserPokemon(), pui.getEnemyPokemon());
            animation = pui.getUserSkill().getAnimation(PLAYER_SIDE_ANIMATION);
            attacker = pui.getUserPokemon();
            receiver = pui.getEnemyPokemon();
            checkPokemonHealthAfterUserAttack();
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
            pui.setPhase(new PoisonCheckPhase(pui));
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
