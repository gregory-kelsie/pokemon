package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fairy;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialDefenseEffect;

/**
 * Created by Gregory on 10/22/2017.
 */

public class Charm extends EffectSkill {
    /**
     * - Name: Charm
     * - Type: Fairy
     * - PP: 20
     * - Cat: Misc
     * - Accuracy: 100
     * - Decrease attack by 2 stages.
     */
    public Charm() {
        super(SkillFactory.CHARM, "Charm", 20, Pokemon.Type.FAIRY, 100);
        effects.add(new AttackEffect(SecondaryEffect.Target.ENEMY,
                2, SecondaryEffect.StatDirection.DECREASE));
    }

    /**
     * Return Charm's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Charm's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
