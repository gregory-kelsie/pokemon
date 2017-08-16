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
public class Growl extends Skill {

    /**
     * - Name: Growl
     * - Type: Normal
     * - PP: 35
     * - Cat: Misc
     * - Accuracy: 100
     */
    public Growl() {
        super("Growl", 40, Pokemon.Type.NORMAL, SkillCategory.MISC, 100);
    }

    /**
     * Use Growl and return the move results
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param field The field for the battle.
     * @param userField The field for the battle.
     * @param enemyField The field for the battle.
     * @return The move results.
     */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, Field field,
                            SubField userField, SubField enemyField, boolean isFirstAttack) {
        List<String> results = new ArrayList<String>();
        //Attempt to lower the attack stage of the enemy by 1 stage.
        if (enemyPokemon.getAttackStage() == -6) {
            results.add(enemyPokemon.getName() + "'s attack can't be lowered.");
        } else {
            enemyPokemon.decreaseAttackStage(1);
            results.add(enemyPokemon.getName() + "'s attack fell!");
        }
        return results;
    }

    /**
     * Return Growl's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Growl's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
