package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fairy;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialAttackEffect;

/**
 * Created by Gregory on 10/22/2017.
 */

public class PlayRough extends SecondaryEffectSkill {
    /**
     * - Name: Play Rough
     * - Type: Fairy
     * - Base Damage: 90
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 90
     */
    public PlayRough() {
        super(SkillFactory.PLAY_ROUGH, "Play Rough", 10, Pokemon.Type.FAIRY, SkillCategory.PHYSICAL,
                90, 90, 1, .1);
        secondaryEffects.add(new AttackEffect(SecondaryEffect.Target.ENEMY, 1,
                SecondaryEffect.StatDirection.DECREASE));
        makesPhysicalContact = true;
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
