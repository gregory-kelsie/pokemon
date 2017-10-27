package com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialAttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialDefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpeedEffect;

/**
 * Created by Gregory on 10/19/2017.
 */

public class QuiverDance extends EffectSkill {
    /**
     * - Name: Quiver Dance
     * - Type: Bug
     * - PP: 20
     * - Cat: Misc
     * - Accuracy: 100
     * - Increase Sp Atk, Sp Def and Speed by 1 stage.
     */
    public QuiverDance() {
        super(SkillFactory.QUIVER_DANCE, "Quiver Dance", 20, Pokemon.Type.BUG, -1);
        effects.add(new SpecialAttackEffect(SecondaryEffect.Target.SELF,
                1, SecondaryEffect.StatDirection.INCREASE));
        effects.add(new SpecialDefenseEffect(SecondaryEffect.Target.SELF,
                1, SecondaryEffect.StatDirection.INCREASE));
        effects.add(new SpeedEffect(SecondaryEffect.Target.SELF,
                1, SecondaryEffect.StatDirection.INCREASE));
        targetsEnemy = false;
    }

    /**
     * Return Quiver Dance's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Quiver Dance's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
