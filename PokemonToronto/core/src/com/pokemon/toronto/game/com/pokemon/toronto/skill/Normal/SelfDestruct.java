package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 8/15/2017.
 */

public class SelfDestruct extends DamageSkill {
    /**
     * - Name: Self-Destruct
     * - Type: Normal
     * - Base Damage: 200
     * - PP: 5
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public SelfDestruct() {
        super("Self-Destruct", 5, Pokemon.Type.NORMAL, SkillCategory.PHYSICAL, 100, 200, 1);
        continuesUseThroughNoEffect = true;
    }


    /**
     * Use Self-Destruct and return the move results.
     * Deal heavy damage to enemy, but kills self.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param field The field the battle is on.
     * @return Thunder Shock's move results.
     */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, Field field,
                            SubField userField, SubField enemyField, boolean isFirstAttack) {
        List<String> results;

        if (effectsEnemy(enemyPokemon)) {
            results = super.use(skillUser, enemyPokemon, field, userField, enemyField, isFirstAttack);
        } else {
            results = new ArrayList<String>();
            results.add("It does not effect " + enemyPokemon.getName() + "...");
        }
        skillUser.subtractHealth(skillUser.getCurrentHealth());

        return results;
    }

    /**
     * Return Self-Destruct's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Self-Destruct's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon,
                               Field field, SubField userField, SubField enemyField,
                               boolean isFirstAttack) {
        if (enemyPokemon.getAbility() == Pokemon.Ability.DAMP) {
            return new FailResult(enemyPokemon.getName() + "'s ability Damp\nprevents Self-Destruct.");
        }
        return new FailResult(false);
    }
}
