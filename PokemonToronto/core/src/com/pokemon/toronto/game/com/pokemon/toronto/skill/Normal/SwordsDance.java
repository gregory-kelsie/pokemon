package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;

/**
 * Created by Gregory on 10/26/2017.
 */

public class SwordsDance extends EffectSkill {
    /**
     * - Name: Swords Dance
     * - Type: Normal
     * - PP: 20
     * - Cat: Misc
     * - Accuracy: N/A
     * - Increase user ATK by 2 stages.
     */
    public SwordsDance() {
        super(SkillFactory.SWORDS_DANCE, "Swords Dance", SkillDescription.SWORDS_DANCE, 20,
                Pokemon.Type.NORMAL, -1);
        effects.add(new AttackEffect(SecondaryEffect.Target.SELF, 2,
                SecondaryEffect.StatDirection.INCREASE));
        targetsEnemy = false;
    }

    /**
     * Return Swords Dance's move animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Swords Dance's move animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
