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
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ConfusionEffect;

/**
 * Created by Gregory on 10/26/2017.
 */

public class Swagger extends EffectSkill {
    /**
     * - Name: Swagger
     * - Type: Normal
     * - PP: 15
     * - Cat: Misc
     * - Accuracy: 85
     */
    public Swagger() {
        super(SkillFactory.SWAGGER, "Swagger", 15, Pokemon.Type.NORMAL, 85);
        effects.add(new AttackEffect(SecondaryEffect.Target.ENEMY, 2,
                SecondaryEffect.StatDirection.INCREASE));
        effects.add(new ConfusionEffect(SecondaryEffect.Target.ENEMY));
    }

    /**
     * Return Swagger's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Swagger's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

}
