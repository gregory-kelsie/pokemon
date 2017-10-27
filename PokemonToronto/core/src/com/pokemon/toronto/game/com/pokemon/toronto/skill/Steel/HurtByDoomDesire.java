package com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel;

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

public class HurtByDoomDesire extends DamageSkill {
    public HurtByDoomDesire() {
        super(-1, "Hurt By Doom Desire", -1, Pokemon.Type.STEEL, Skill.SkillCategory.SPECIAL, 100, 140, 1);
    }

    /**
     * Damage the enemy with doom desire.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param field The field of the battle.
     * @return The results of using the move.
     */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, Field field) {
        //Use the damage part of the move.
        List<String> results = new ArrayList<String>();
        int dmg = getDamage(skillUser, skillUser, field, null, null, false);
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
