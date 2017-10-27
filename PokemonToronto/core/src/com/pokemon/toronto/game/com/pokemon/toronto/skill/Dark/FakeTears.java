package com.pokemon.toronto.game.com.pokemon.toronto.skill.Dark;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialDefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpeedEffect;

/**
 * Created by Gregory on 10/21/2017.
 */

public class FakeTears extends EffectSkill {
    /**
     * - Name: Fake Tears
     * - Type: Dark
     * - PP: 20
     * - Cat: Misc
     * - Accuracy: 100
     */
    public FakeTears() {
        super(SkillFactory.FAKE_TEARS, "Fake Tears", 20, Pokemon.Type.DARK, 100);
        effects.add(new SpecialDefenseEffect(SecondaryEffect.Target.ENEMY, 2, SecondaryEffect.StatDirection.DECREASE));
    }

    /**
     * Return Fake Tears's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Fake Tears's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
