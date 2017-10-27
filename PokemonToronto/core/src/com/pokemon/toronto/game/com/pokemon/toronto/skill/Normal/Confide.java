package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialAttackEffect;

/**
 * Created by Gregory on 10/25/2017.
 */

public class Confide extends EffectSkill {
    /**
     * - Name: Confide
     * - Type: Normal
     * - PP: 20
     * - Cat: Misc
     * - Accuracy: 100
     * - Lower enemy Sp. Atk by 1 stage.
     */
    public Confide() {
        super(SkillFactory.CONFIDE, "Confide", 20, Pokemon.Type.NORMAL, 100);
        effects.add(new SpecialAttackEffect(SecondaryEffect.Target.ENEMY, 1,
                SecondaryEffect.StatDirection.DECREASE));
    }

    /**
     * Return Confide's move animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Confide's move animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
