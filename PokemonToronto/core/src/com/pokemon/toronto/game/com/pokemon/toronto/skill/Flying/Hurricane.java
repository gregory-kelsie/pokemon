package com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.WeatherType;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ConfusionEffect;

/**
 * Created by Gregory on 9/20/2017.
 */

public class Hurricane extends SecondaryEffectSkill {
    /**
     * - Name: Hurricane
     * - Type: Flying
     * - Base Damage: 110
     * - PP: 10
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 70
     */
    public Hurricane() {
        super(SkillFactory.HURRICANE, "Hurricane", SkillDescription.HURRICANE, 10,
                Pokemon.Type.FLYING, Skill.SkillCategory.SPECIAL, 70, 110, 1, .3);
        secondaryEffects.add(new ConfusionEffect(SecondaryEffect.Target.ENEMY));
        hitFlyingPokemon = true;
    }

    /**
     * Return whether or not the move will hit the enemy.
     * @param skillUser The Pokemon using the skill.
     * @param enemyPokemon The Pokemon receiving the skill.
     * @param field The field for the battle.
     * @param userField The field for the battle.
     * @param enemyField The field for the battle.
     * @param isFirstAttack Whether or not the skill was used first in the clash
     * @return Whether or not the skill hits the enemy.
     */
    public boolean willHitEnemy(Pokemon skillUser, Pokemon enemyPokemon,
                                Field field, SubField userField, SubField enemyField,
                                boolean isFirstAttack) {
        if (field.getWeatherType() == WeatherType.RAIN) {
            accuracy = 100;
        } else if (field.getWeatherType() == WeatherType.SUN) {
            accuracy = 50;
        }
        boolean result = super.willHitEnemy(skillUser, enemyPokemon, field, userField, enemyField,
                isFirstAttack);
        accuracy = 70; //Set it back to normal.
        return result;
    }


    /**
     * Return the skill's animation, player side or enemy side.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return The skill's animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
