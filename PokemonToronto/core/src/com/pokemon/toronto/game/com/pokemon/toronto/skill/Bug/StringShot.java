package com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpeedEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/15/2017.
 */
public class StringShot extends EffectSkill {

    /**
     * - Name: String Shot
     * - Type: Bug
     * - PP: 35
     * - Cat: Misc
     * - Accuracy: 95
     */
    public StringShot() {
        super(8, "String Shot", 35, Pokemon.Type.BUG, 95);
        effects.add(new SpeedEffect(1,
                SecondaryEffect.Target.ENEMY, 1, SecondaryEffect.StatDirection.DECREASE));
    }

    /**
     * Return String Shot's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return String Shot's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
