package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fairy;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialDefenseEffect;

/**
 * Created by Gregory on 10/22/2017.
 */

public class BabyDollEyes extends EffectSkill {
    /**
     * - Name: Baby-Doll Eyes
     * - Type: Fairy
     * - PP: 30
     * - Cat: Misc
     * - Accuracy: -1
     * - Decrease attack by 1 stage
     */
    public BabyDollEyes() {
        super(SkillFactory.BABY_DOLL_EYES, "Baby-Doll Eyes", SkillDescription.BABY_DOLL_EYES, 30,
                Pokemon.Type.FAIRY, 100);
        effects.add(new AttackEffect(SecondaryEffect.Target.ENEMY,
                1, SecondaryEffect.StatDirection.DECREASE));
    }

    /**
     * Return Baby-Doll Eyes's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Baby-Doll Eyes's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
