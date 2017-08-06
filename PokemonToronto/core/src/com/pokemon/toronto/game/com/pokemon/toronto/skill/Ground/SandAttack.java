package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ground;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

/**
 * Created by Gregory on 6/15/2017.
 */
public class SandAttack extends Skill {

    /**
     * - Name: Sand Attack
     * - Type: Ground
     * - PP: 15
     * - Cat: Misc
     */
    public SandAttack() {
        super("Sand Attack", 15, Pokemon.Type.GROUND, SkillCategory.MISC);
    }

    //TODO: Implement use and lower the enemy's accuracy by 1 stage.

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
