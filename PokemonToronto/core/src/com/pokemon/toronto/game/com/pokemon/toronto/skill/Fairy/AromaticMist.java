package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fairy;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialDefenseEffect;

import java.util.List;

/**
 * Created by Gregory on 10/22/2017.
 */

public class AromaticMist extends EffectSkill {
    /**
     * - Name: Aromatic Mist
     * - Type: Fairy
     * - PP: 20
     * - Cat: Misc
     * - Accuracy: -1
     * - Increase sp def by 2 stages (Custom skill since doubles are not implemented.
     */
    public AromaticMist() {
        super(SkillFactory.AROMATIC_MIST, "Aromatic Mist", 20, Pokemon.Type.FAIRY, -1);
        effects.add(new SpecialDefenseEffect(SecondaryEffect.Target.SELF,
                2, SecondaryEffect.StatDirection.INCREASE));
        targetsEnemy = false;
    }

    /**
     * Return Aromatic Mist's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Aromatic Mist's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
