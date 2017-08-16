package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 8/15/2017.
 */

public class SkullBash extends DamageSkill {
    /**
     * - Name: Skull Bash
     * - Type: Normal
     * - Base Damage: 130
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public SkullBash() {
        super("Skull Bash", 10, Pokemon.Type.NORMAL, SkillCategory.PHYSICAL, 100, 130, 1);
    }

    /**
     * Raise defense by 1 stage and then attack the next turn.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param field The field of the battle.
     * @return The results of using the move.
     */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, Field field, boolean isFirstAttack) {

        List<String> results;
        if (skillUser.hasNextTurnSkill()) {
            results = super.use(skillUser, enemyPokemon, field, isFirstAttack);
            skillUser.removeNextTurnSkill();
        } else {
            results = new ArrayList<String>();
            results.add(skillUser.getName() + " tucked in\nits head!");
            skillUser.setNextTurnSkill(this);
            if (skillUser.getDefenseStage() < 6) {
                skillUser.increaseDefenseStage(1);
                results.add(skillUser.getName() + "'s defense rose!");
            } else {
                results.add(skillUser.getName() + "'s defense can't get any higher.");
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
