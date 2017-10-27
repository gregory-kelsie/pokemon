package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ConfusionEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.FlinchEffect;

import java.util.List;

/**
 * Created by Gregory on 10/25/2017.
 */

public class FakeOut extends SecondaryEffectSkill {
    /**
     * - Name: Fake Out
     * - Type: Normal
     * - Base Damage: 40
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public FakeOut() {
        super(SkillFactory.FAKE_OUT, "Fake Out", 10, Pokemon.Type.NORMAL,
                SkillCategory.PHYSICAL, 100, 40, 1, 1.0);
        secondaryEffects.add(new FlinchEffect(SecondaryEffect.Target.ENEMY));
        makesPhysicalContact = true;
        setPriority(3);
    }

    /**
     * Fake Out fails when it is not used on the first turn the Pokemon is on the Field.
     * @param skillUser The skill's user.
     * @param enemyPokemon The Pokemon on the receiving end.
     * @param field The field for the battle.
     * @param userField The field for the battle.
     * @param enemyField The field for the battle.
     * @param isFirstAttack Whether or not the skill was used first in the clash
     * @param targetsSkill
     * @return
     */
    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon,
                               Field field, SubField userField, SubField enemyField,
                               boolean isFirstAttack, Skill targetsSkill) {
        if (skillUser.isFirstTurn()) {
            return new FailResult(false);
        } else {
            return new FailResult("It failed...");
        }
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
