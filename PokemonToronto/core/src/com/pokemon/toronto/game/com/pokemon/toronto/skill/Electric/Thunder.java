package com.pokemon.toronto.game.com.pokemon.toronto.skill.Electric;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.WeatherType;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ParalysisEffect;

/**
 * Created by Gregory on 10/22/2017.
 */

public class Thunder extends SecondaryEffectSkill {
    /**
     * - Name: Thunder
     * - Type: Electric
     * - Base Damage: 110
     * - PP: 10
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 70
     */
    public Thunder() {
        super(SkillFactory.THUNDER, "Thunder", SkillDescription.THUNDER, 30, Pokemon.Type.ELECTRIC,
                SkillCategory.SPECIAL, 70, 110, 1, .3);
        secondaryEffects.add(new ParalysisEffect(SecondaryEffect.Target.ENEMY));
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
        //Thunder has 100 accuracy in the rain.
        if (field.getWeatherType() == WeatherType.RAIN ||
                field.getWeatherType() == WeatherType.HEAVY_RAIN) {
            accuracy = 100;
        }
        boolean hit = super.willHitEnemy(skillUser, enemyPokemon, field, userField, enemyField,
                isFirstAttack);
        accuracy = 70; //Reset accuracy back to normal.
        return hit;
    }

    /**
     * Return Thunder's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Thunder's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
