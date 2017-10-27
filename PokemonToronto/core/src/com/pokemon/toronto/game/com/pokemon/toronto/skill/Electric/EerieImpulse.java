package com.pokemon.toronto.game.com.pokemon.toronto.skill.Electric;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialAttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialDefenseEffect;

import java.util.List;

/**
 * Created by Gregory on 10/22/2017.
 */

public class EerieImpulse extends EffectSkill {
    /**
     * - Name: Eerie Impulse
     * - Type: Electric
     * - PP: 15
     * - Cat: Misc
     * - Accuracy: -1
     * - Increase power of next electric attack and increase sp. def by 1 stage.
     */
    public EerieImpulse() {
        super(SkillFactory.EERIE_IMPULSE, "Eerie Impulse", 15, Pokemon.Type.ELECTRIC, -1);
        effects.add(new SpecialAttackEffect(SecondaryEffect.Target.ENEMY,
                2, SecondaryEffect.StatDirection.DECREASE));
    }

    /**
     * Return Eerie Impulse's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Eerie Impulse's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
