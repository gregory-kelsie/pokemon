package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.WeatherType;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.FreezeEffect;

import java.util.List;

/**
 * Created by Gregory on 9/19/2017.
 */

public class Blizzard extends SecondaryEffectSkill {
    /**
     * - Name: Blizzard
     * - Type: Ice
     * - Base Damage: 110
     * - PP: 5
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 70
     */
    public Blizzard() {
        super(SkillFactory.BLIZZARD, "Blizzard", SkillDescription.BLIZZARD, 5, Pokemon.Type.ICE,
                SkillCategory.SPECIAL, 70, 110, 1, .1);
        secondaryEffects.add(new FreezeEffect(SecondaryEffect.Target.ENEMY));
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

    public boolean willHitEnemy(Pokemon skillUser, Pokemon enemyPokemon,
                                Field field, SubField userField, SubField enemyField,
                                boolean isFirstAttack) {
        if (enemyPokemon.isUnderwater() || enemyPokemon.isUnderground() ||
                enemyPokemon.isFlying()) {
            //Misses when enemy is semi-invulnerable, even if there is
            //an accuracy bypass.
            return false;
        } else {
            if (field.getWeatherType() == WeatherType.HAIL) {
                //Bypass accuracy check
                return true;
            } else {
                return super.willHitEnemy(skillUser, enemyPokemon, field, userField, enemyField,
                        isFirstAttack);
            }
        }
    }
}
