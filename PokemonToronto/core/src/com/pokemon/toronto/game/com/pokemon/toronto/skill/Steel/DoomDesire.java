package com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 9/1/2017.
 */

public class DoomDesire extends Skill {
    /**
     * - Name: Doom Desire
     * - Type: Psychic
     * - Damage: 140 when it hits.
     * - PP: 5
     * - Cat: Special
     * - Accuracy: 100
     */
    public DoomDesire() {
        super(30, "Doom Desire", 5, Pokemon.Type.STEEL, Skill.SkillCategory.MISC, 100);
    }

    /**
     * Set up Doom Desire on the opponent.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param field The field of the battle.
     * @return Stealth Rock's move results.
     */
    @Override
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack) {
        List<String> results = new ArrayList<String>();
        enemyPokemon.receiveDoomDesire(skillUser);
        results.add(skillUser.getName() + " chose Doom Desire\nas its destiny!");
        return results;
    }

    /**
     * Return Doom Desire's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Future Sight's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon,
                               Field field, SubField userField, SubField enemyField,
                               boolean isFirstAttack) {
        if (enemyPokemon.witnessedFutureSight() || enemyPokemon.witnessedDoomDesire()) {
            return new FailResult("It failed...");
        }
        return new FailResult(false);
    }
}
