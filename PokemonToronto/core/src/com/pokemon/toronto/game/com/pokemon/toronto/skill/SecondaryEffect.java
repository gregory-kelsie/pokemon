package com.pokemon.toronto.game.com.pokemon.toronto.skill;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;

import java.util.List;

/**
 * Created by Gregory on 8/31/2017.
 */

public abstract class SecondaryEffect {

    public enum SecondaryEffectId {
        BURN, PARALYSIS, SLEEP, FREEZE, POISON, FLINCH, CONFUSION, SPATK, ATK, SPDEF, DEF, SPD, ACC
    }

    public enum StatDirection {
        INCREASE, DECREASE
    }

    public enum Target {
        SELF, ENEMY;
    }


    private final int INCREASE = 0;
    private final int DECREASE = 1;

    protected Target target;
    protected int amount;
    protected StatDirection statDirection;

    /**
     * Create a secondary effect for stats, atk, def, speed, accuracy etc where direction
     * and stage amount matters.
     * @param target The target for the effect.
     * @param amount The stage increase/decrease amount.
     * @param statDirection The direction determining whether or not to increase
     *                      or decrease the stage.
     */
    public SecondaryEffect(Target target, int amount, StatDirection statDirection) {
        this.target = target;
        this.amount = amount;
        this.statDirection = statDirection;
    }

    /**
     * Create a secondary effect for statuses, confusion or flinches where amount and stat direction
     * don't matter.
     * @param target The target for the effect.
     */
    public SecondaryEffect(Target target) {
        this.target = target;
        this.amount = 0;
        this.statDirection = null;
    }

    /**
     * Return the target for the effect.
     * @return The target for the effect - SELF or ENEMY
     */
    public Target getTarget() {
        return target;
    }


    public abstract void use(List<String> results, Pokemon skillUser,
                             Pokemon enemyPokemon, Field field, SubField userField,
                             SubField enemyField, boolean isFirstAttack);

}
