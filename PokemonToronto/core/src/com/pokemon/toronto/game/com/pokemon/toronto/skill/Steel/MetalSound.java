package com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialDefenseEffect;

/**
 * Created by Gregory on 9/19/2017.
 */

public class MetalSound extends EffectSkill {
    /**
     * - Name: Metal Sound
     * - Type: Steel
     * - PP: 40
     * - Cat: Misc
     * - Accuracy: 85
     * - Decrease sp defense by 2 stages.
     */
    public MetalSound() {
        super(SkillFactory.METAL_SOUND, "Metal Sound", SkillDescription.METAL_SOUND,40,
                Pokemon.Type.STEEL, 85);
        effects.add(new SpecialDefenseEffect(SecondaryEffect.Target.ENEMY,
                2, SecondaryEffect.StatDirection.DECREASE));
    }

    /**
     * Return Metal Sound's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Metal Sound's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
