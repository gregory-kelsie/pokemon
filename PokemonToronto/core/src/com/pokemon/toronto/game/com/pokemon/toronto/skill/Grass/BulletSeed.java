package com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.RegularDamageAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.MultiHitMove;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

/**
 * Created by Gregory on 9/19/2017.
 */

public class BulletSeed extends MultiHitMove {
    /**
     * - Name: Bullet Seed
     * - Type: Grass
     * - Base Damage: 25
     * - PP: 30
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     * - Number of Hits: 2-5 (As denoted by the last parameter of 0)
     */
    public BulletSeed() {
        super(SkillFactory.BULLET_SEED, "Bullet Seed", SkillDescription.BULLET_SEED, 30,
                Pokemon.Type.GRASS, SkillCategory.PHYSICAL, 100, 25, 1, 0);
    }

    /**
     * Return Bullet Seed's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Quick Attack's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new RegularDamageAnimation(userAnimation);
    }
}
