package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.FreezeEffect;

/**
 * Created by Gregory on 9/19/2017.
 */

public class FreezeDry extends SecondaryEffectSkill {
    /**
     * - Name: Freeze-Dry
     * - Type: Ice
     * - Base Damage: 70
     * - PP: 20
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public FreezeDry() {
        super(SkillFactory.FREEZE_DRY, "Freeze-Dry", SkillDescription.FREEZE_DRY, 20,
                Pokemon.Type.ICE, SkillCategory.SPECIAL, 100, 70, 1, .1);
        secondaryEffects.add(new FreezeEffect(SecondaryEffect.Target.ENEMY));
    }

    /**
     * 	Return the effectiveness modifier
     *	@param user - The Attacker
     *	@param enemy - The pokemon that gets attacked
     */
    @Override
    protected double getResistModifier(Pokemon user, Pokemon enemy) {
        if (enemy.getBattleTypeOne() == Pokemon.Type.WATER ||
                enemy.getBattleTypeTwo() == Pokemon.Type.WATER) {
            //Make the hit super effective against water types.
            double resistMod = 2;
            if (enemy.getBattleAbility().getId() == Ability.AbilityId.FILTER ||
                    enemy.getBattleAbility().getId() == Ability.AbilityId.SOLID_ROCK) {
                //Filter and Solid Rock reduce super effective damage.
               resistMod *= 0.75;
            }
            return resistMod;

        } else {
            //Since it's not against a water type, calculate resistances normally.
            return super.getResistModifier(user, enemy);
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
