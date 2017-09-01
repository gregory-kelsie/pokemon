package com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;

/**
 * Created by Gregory on 8/31/2017.
 */

public abstract class StatEffect extends SecondaryEffect {
    protected int amount;
    protected StatDirection statDirection;
    public StatEffect(double chance, Target target, int amount, StatDirection statDirection) {
        super(chance, target);
        this.amount = amount;
        this.statDirection = statDirection;
    }

    /**
     * The direction for the stat chance - Increase or Decrease. null
     * for non-stat effects.
     * @return The direction of stat change.
     */
    public StatDirection getStatDirection() {
        return statDirection;
    }


    /**
     * Return the stage increase/decrease amount. 0 for non stage
     * effects.
     * @return The effect's stage increase/decrease amount.
     */
    public int getAmount() {
        return amount;
    }

    protected String getFallText() {
        if (amount == 1) {
            return " fell!";
        } else if (amount == 2) {
            return " harshly fell!";
        } else {
            return " rose drastically!";
        }
    }

    protected String getRoseText() {
        if (amount == 1) {
            return " rose!";
        } else if (amount == 2) {
            return " sharply rose!";
        } else {
            return " severely fell!";
        }
    }

}
