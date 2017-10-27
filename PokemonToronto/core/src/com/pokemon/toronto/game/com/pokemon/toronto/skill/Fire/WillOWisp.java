package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fire;

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
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.BurnEffect;

/**
 * Created by Gregory on 10/1/2017.
 */

public class WillOWisp extends EffectSkill {
    /**
     * - Name: Will O Wisp
     * - Type: Fire
     * - PP: 15
     * - Cat: Misc
     * - Accuracy: 85
     */
    public WillOWisp() {
        super(SkillFactory.WILL_O_WISP, "Will O Wisp", 15, Pokemon.Type.FIRE, 85);
        effects.add(new BurnEffect(SecondaryEffect.Target.ENEMY));
    }

    /**
     * Return Will O Wisp's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Spore's skill animation.
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
