package com.pokemon.toronto.game.com.pokemon.toronto.skill.Dark;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SleepEffect;

/**
 * Created by Gregory on 10/20/2017.
 */

public class DarkVoid extends EffectSkill {

    /**
     * - Name: Dark Void
     * - Type: Dark
     * - PP: 5
     * - Cat: Misc
     * - Accuracy: 50
     */
    public DarkVoid() {
        super(SkillFactory.DARK_VOID, "Dark Void", 5, Pokemon.Type.DARK, 50);
        effects.add(new SleepEffect(SecondaryEffect.Target.ENEMY));
    }

    /**
     * Return Dark Void's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Dark Void's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon, Field field,
                               SubField userField, SubField enemyField, boolean isFirstAttacker, Skill targetsSkill) {
        if (enemyPokemon.isStatused()) {
            return new FailResult("It failed...");
        }
        return new FailResult(false);
    }
}
