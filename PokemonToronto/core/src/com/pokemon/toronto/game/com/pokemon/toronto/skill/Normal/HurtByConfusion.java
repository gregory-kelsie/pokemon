package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.RegularDamageAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 8/13/2017.
 */

public class HurtByConfusion extends DamageSkill {
    public HurtByConfusion() {
        super(-1, "Hurt By Confusion", -1, Pokemon.Type.NORMAL, Skill.SkillCategory.PHYSICAL, -1, 40, 1);
    }

    /**
     * Damage the enemy, hit self with confusion.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param field The field of the battle.
     * @return The results of using the move.
     */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, Field field) {
        //Use the damage part of the move.
        List<String> results = new ArrayList<String>();
        int dmg = getDamage(skillUser, skillUser, field, null, null, false);
        skillUser.subtractHealth(dmg);
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
        //Opposite since it's the player hitting themself so !userAnimation
        return new RegularDamageAnimation(!userAnimation);
    }
}
