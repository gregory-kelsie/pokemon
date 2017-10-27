package com.pokemon.toronto.game.com.pokemon.toronto.skill.Dragon;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpeedEffect;

/**
 * Created by Gregory on 10/19/2017.
 */

public class DragonDance extends EffectSkill {
    /**
     * - Name: Dragon Dance
     * - Type: Dragon
     * - PP: 20
     * - Cat: Misc
     * - Accuracy: -1 (Should never miss)
     */
    public DragonDance() {
        super(SkillFactory.DRAGON_DANCE, "Dragon Dance", 20, Pokemon.Type.DRAGON, -1);
        effects.add(new AttackEffect(SecondaryEffect.Target.SELF, 1, SecondaryEffect.StatDirection.INCREASE));
        effects.add(new SpeedEffect(SecondaryEffect.Target.SELF, 1, SecondaryEffect.StatDirection.INCREASE));
        targetsEnemy = false;
    }

    /**
     * Return Dragon Dance's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Dragon Dance's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
