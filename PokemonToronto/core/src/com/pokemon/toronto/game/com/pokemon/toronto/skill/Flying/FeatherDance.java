package com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;

/**
 * Created by Gregory on 9/20/2017.
 */

public class FeatherDance extends EffectSkill {
    /**
     * - Name: Feather Dance
     * - Type: Flying
     * - PP: 15
     * - Cat: Misc
     * - Accuracy: 100
     * - Decrease attack by 2 stages.
     */
    public FeatherDance() {
        super(SkillFactory.FEATHER_DANCE, "Feather Dance", 15, Pokemon.Type.FLYING, 100);
        effects.add(new AttackEffect(SecondaryEffect.Target.ENEMY,
                2, SecondaryEffect.StatDirection.DECREASE));
        targetsEnemy = false;
    }

    /**
     * Return Feather Dance's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Feather Dance's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
