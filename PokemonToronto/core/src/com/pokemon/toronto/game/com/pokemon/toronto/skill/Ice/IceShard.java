package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 9/19/2017.
 */

public class IceShard extends DamageSkill {
    /**
     * - Name: Ice Shard
     * - Type: Ice
     * - Base Damage: 40
     * - PP: 30
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public IceShard() {
        super(SkillFactory.ICE_SHARD, "Ice Shard", SkillDescription.ICE_SHARD, 30, Pokemon.Type.ICE,
                SkillCategory.PHYSICAL, 100, 40, 1);
        setPriority(1); //Has a priority of +1
    }

    /**
     * Return Ice Shard's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Ice Shard's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
