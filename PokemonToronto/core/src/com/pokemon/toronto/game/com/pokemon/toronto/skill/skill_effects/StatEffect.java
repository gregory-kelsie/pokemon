package com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;

import java.util.List;

/**
 * Created by Gregory on 8/31/2017.
 */

public abstract class StatEffect extends SecondaryEffect {
    protected int amount;
    protected int finalAmount; //Amount after ability or skill adjustments. Ex: Simple Ability
    protected StatDirection statDirection;

    protected Pokemon effectReceiver;
    protected SubField receiverField;

    public StatEffect(Target target, int amount, StatDirection statDirection) {
        super(target);
        this.amount = amount;
        this.statDirection = statDirection;
        finalAmount = amount;
    }

    /**
     * The direction for the stat chance - Increase or Decrease. null
     * for non-stat effects.
     * @return The direction of stat change.
     */
    public StatDirection getStatDirection() {
        return statDirection;
    }

    public void use(List<String> results, Pokemon skillUser, Pokemon enemyPokemon, Field field, SubField userField, SubField enemyField, boolean isFirstAttack) {
        if (target == SecondaryEffect.Target.SELF) {
            effectReceiver = skillUser;
            receiverField = userField;
        } else {
            effectReceiver = enemyPokemon;
            receiverField = enemyField;
        }
        if (effectReceiver.getBattleAbility() == Pokemon.Ability.SIMPLE) {
            finalAmount = amount * 2;
        } else {
            finalAmount = amount;
        }
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
        if (finalAmount == 1) {
            return " fell!";
        } else if (finalAmount == 2) {
            return " harshly fell!";
        } else {
            return " severely fell!";
        }
    }

    protected String getRoseText() {
        if (finalAmount == 1) {
            return " rose!";
        } else if (finalAmount == 2) {
            return " sharply rose!";
        } else {
            return " drastically rose!";
        }
    }

}
