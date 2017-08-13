package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

import java.util.List;

/**
 * Created by Gregory on 8/11/2017.
 */

public class TakeDown extends DamageSkill {

    /**
     * - Name: Take Down
     * - Type: Normal
     * - Base Damage: 90
     * - PP: 20
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 85
     * - Recoil: 1/4 of damage dealt
     */
    public TakeDown() {
        //1/4 RECOIL
        super("Take Down", 20, Pokemon.Type.NORMAL, Skill.SkillCategory.PHYSICAL, 85, 90, 1, 1);
        makesPhysicalContact = true;
    }

    /**
     * Damage the enemy and take 1/4 recoil damage.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param field The field of the battle.
     * @return The results of using the move.
     */
    public List<List<String>> use(Pokemon skillUser, Pokemon enemyPokemon, Field field) {
        return super.use(skillUser, enemyPokemon, field);
    }

    /**
     * Return Take Down's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Take Down's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
