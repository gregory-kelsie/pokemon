package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/15/2017.
 */
public class Leer extends Skill {

    /**
     * - Name: Leer
     * - Type: Normal
     * - PP: 30
     * - Cat: Misc
     * - Accuracy: 100
     */
    public Leer() {
        super(4, "Leer", 30, Pokemon.Type.NORMAL, SkillCategory.MISC, 100);
    }

    /**
     * Use Leer and return the move results.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param field The field for the battle.
     * @param userField The field for the battle.
     * @param enemyField The field for the battle.
     * @return The move results
     */
    @Override
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, Field field,
                            SubField userField, SubField enemyField, boolean isFirstAttack) {
        List<String> results = new ArrayList<String>();

        //Attempt to lower the enemy's defense by 1 stage.
        if (enemyPokemon.isProtectedByDefenseLoweringEffects()) {
            results.add(enemyPokemon.getName() +"'s defense can't be lowered\n" +
                    "Due to the ability " + enemyPokemon.getAbilityString());
        }
        else if (enemyPokemon.getDefenseStage() == -6) {
            results.add(enemyPokemon.getName() + "'s defense can't be lowered.");
        } else {
            enemyPokemon.decreaseDefenseStage(1);
            results.add(enemyPokemon.getName() + "'s defense fell!");
        }
        return results;
    }

    /**
     * Return Leer's move animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Leer's move animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
