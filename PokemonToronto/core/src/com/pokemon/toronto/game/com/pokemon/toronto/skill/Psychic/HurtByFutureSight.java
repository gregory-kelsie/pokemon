package com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.RegularDamageAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 9/1/2017.
 */

public class HurtByFutureSight extends DamageSkill {
    public HurtByFutureSight() {
        super(-1, "Hurt By Future Sight", -1, Pokemon.Type.PSYCHIC, Skill.SkillCategory.SPECIAL, 100, 120, 1);
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
        int dmg = getDamage(skillUser, skillUser, field, false);
        enemyPokemon.subtractHealth(dmg);
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
