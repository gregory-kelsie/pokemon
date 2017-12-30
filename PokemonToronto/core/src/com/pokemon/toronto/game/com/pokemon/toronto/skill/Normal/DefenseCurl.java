package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialAttackEffect;

/**
 * Created by Gregory on 10/25/2017.
 */

public class DefenseCurl extends EffectSkill {
    /**
     * - Name: Defense Curl
     * - Type: Normal
     * - PP: 40
     * - Cat: Misc
     * - Accuracy: N/A
     * - Increase def by 1 stage
     */
    public DefenseCurl() {
        super(SkillFactory.DEFENSE_CURL, "Defense Curl", SkillDescription.DEFENSE_CURL, 40,
                Pokemon.Type.NORMAL, -1);
        effects.add(new DefenseEffect(SecondaryEffect.Target.SELF, 1,
                SecondaryEffect.StatDirection.INCREASE));
        targetsEnemy = false;
        //TODO: Increase rollout and ice ball damage when defense curl is used.
    }

    /**
     * Return Defense Curl's move animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Defense Curl's move animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
