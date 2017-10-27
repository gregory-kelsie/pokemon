package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fire;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.BurnEffect;

import java.util.List;

/**
 * Created by Gregory on 9/29/2017.
 */

public class FireFang extends SecondaryEffectSkill {

    /**
     * - Name: Fire Fang
     * - Type: Fire
     * - Base Damage: 65
     * - PP: 15
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 95
     * 10% chance to burn and another 10% chance to flinch.
     */
    public FireFang() {
        super(SkillFactory.FIRE_FANG, "Fire Fang", 15, Pokemon.Type.FIRE, SkillCategory.PHYSICAL, 95, 65, 1, .1);
        secondaryEffects.add(new BurnEffect(SecondaryEffect.Target.ENEMY));
        makesPhysicalContact = true;
    }

    /**
     * Damage the enemy, but also use the secondary effects.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     * @param enemyPokemonPartyPosition
     * @param field The field of the battle.
     * @param targetSkill
     * @param skillUserParty
     * @param enemyPokemonParty    @return The results of using the move.
     * */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition, int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill, List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        //Use the damage part of the move.
        List<String> results = super.use(skillUser, enemyPokemon, skillUserPartyPosition, enemyPokemonPartyPosition, field,
                userField, enemyField, isFirstAttack, targetSkill, skillUserParty, enemyPokemonParty);

        if (Math.random() <= .1 && isFirstAttack) {
            //Flinch
            if (enemyPokemon.getBattleAbility() !=
                    Pokemon.Ability.INNER_FOCUS && enemyPokemon.getBattleAbility() !=
                    Pokemon.Ability.SHIELD_DUST) {
                enemyPokemon.flinch();
            }
        }
        return results;
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
