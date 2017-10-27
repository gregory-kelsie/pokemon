package com.pokemon.toronto.game.com.pokemon.toronto.skill.Poison;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpeedEffect;

/**
 * Created by Gregory on 10/22/2017.
 */

public class AcidArmor extends EffectSkill {
    /**
     * - Name: Acid Armor
     * - Type: Poison
     * - PP: 20
     * - Cat: Misc
     * - Accuracy: -1
     * - Increase def by two stages.
     */
    public AcidArmor() {
        super(SkillFactory.ACID_ARMOR, "Acid Armor", 20, Pokemon.Type.POISON, -1);
        effects.add(new DefenseEffect(SecondaryEffect.Target.SELF,
                2, SecondaryEffect.StatDirection.INCREASE));
        targetsEnemy = false;
    }

    /**
     * Return Acid Armor's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Acid Armor's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
