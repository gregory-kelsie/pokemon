package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ground;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/15/2017.
 */
public class SandAttack extends Skill {

    /**
     * - Name: Sand Attack
     * - Type: Ground
     * - PP: 15
     * - Cat: Misc
     * - Accuracy: 100
     */
    public SandAttack() {
        super("Sand Attack", 15, Pokemon.Type.GROUND, SkillCategory.MISC, 100);
    }

    /**
     * Use Sand Attack and return the move results
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param field The field the battle is on.
     * @return The move results.
     */
    @Override
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, Field field, boolean isFirstAttack) {
        List<String> results = new ArrayList<String>();
        //Attempt to lower the attack stage of the enemy by 1 stage.
        if (enemyPokemon.isProtectedByAccuracyLoweringEffects()) {
            results.add(enemyPokemon.getName() + "'s accuracy cannot be\nlowered due to " +
                    enemyPokemon.getAbilityString() + ".");
        }
        else if (enemyPokemon.getAccuracyStage() == -6) {
            results.add(enemyPokemon.getName() + "'s accuracy can't be lowered.");
        } else {
            enemyPokemon.decreaseAccuracyStage(1);
            results.add(enemyPokemon.getName() + "'s accuracy fell!");
        }
        return results;
    }

    /**
     * Return Sand Attack's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Sand Attack's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
