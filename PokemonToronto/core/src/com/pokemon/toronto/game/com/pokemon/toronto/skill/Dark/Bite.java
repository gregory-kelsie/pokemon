package com.pokemon.toronto.game.com.pokemon.toronto.skill.Dark;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

import java.util.List;

/**
 * Created by Gregory on 8/14/2017.
 */

public class Bite extends DamageSkill {
    /**
     * - Name: Bite
     * - Type: Dark
     * - Base Damage: 60
     * - PP: 25
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Bite() {
        super("Bite", 25, Pokemon.Type.DARK, SkillCategory.PHYSICAL, 100, 60, 1);
        makesPhysicalContact = true;
    }

    /**
     * Damage the enemy, but also has a 30% chance to flinch the enemy if bite goes first.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param field The field for the battle.
     * @param userField The field for the battle.
     * @param enemyField The field for the battle.
     * @return The results of using the move.
     */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, Field field,
                            SubField userField, SubField enemyField, boolean isFirstAttack) {
        //Use the damage part of the move.
        List<String> results = super.use(skillUser, enemyPokemon, field, userField,
                enemyField, isFirstAttack);
        if (isFirstAttack && (enemyPokemon.getAbility() !=
                Pokemon.Ability.INNER_FOCUS && enemyPokemon.getAbility() !=
                Pokemon.Ability.SHIELD_DUST)) {
            double rand = Math.random();
            if (rand <= .3) {
                enemyPokemon.flinch();
            }
        }

        return results;
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
