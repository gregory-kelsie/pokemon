package com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ConfusionEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.FlinchEffect;

/**
 * Created by Gregory on 10/23/2017.
 */

public class Extrasensory extends SecondaryEffectSkill {
    /**
     * - Name: Extrasensory
     * - Type: Psychic
     * - Base Damage: 80
     * - PP: 20
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Extrasensory() {
        super(SkillFactory.EXTRASENSORY, "Extrasensory", 20, Pokemon.Type.PSYCHIC, SkillCategory.SPECIAL,
                100, 80, 1, .1);
        secondaryEffects.add(new FlinchEffect(SecondaryEffect.Target.ENEMY));
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
