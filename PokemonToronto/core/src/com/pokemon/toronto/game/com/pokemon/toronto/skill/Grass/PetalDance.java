package com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;

import java.util.List;

/**
 * Created by Gregory on 8/15/2017.
 */

public class PetalDance extends DamageSkill {

    /**
     * - Name: Petal Dance
     * - Type: Grass
     * - Base Damage: 120
     * - PP: 10
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public PetalDance() {
        super(21, "Petal Dance", SkillDescription.PETAL_DANCE, 10, Pokemon.Type.GRASS,
                SkillCategory.SPECIAL, 100, 120, 1);
    }

    /**
     * Damage the enemy for 2-3 turns. Once finished confuses the user.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     * @param enemyPokemonPartyPosition
     * @param field The field for the battle.
     * @param userField The field for the battle.
     * @param enemyField The field for the battle.
     * @param targetSkill
     * @param skillUserParty
     * @param enemyPokemonParty      @return The results of using the move.
     * */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition,
                            int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill,
                            List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        //Use the damage part of the move.
        if (!skillUser.isOutraging()) {
            double rand = Math.random();
            int turns;
            if (rand <= .5) {
                turns = 2;
            } else {
                turns = 3;
            }
            skillUser.activateOutrage(this, turns);
        }
        List<String> results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack,
                targetSkill, skillUserParty, enemyPokemonParty);

        skillUser.reduceOutrageTime();
        if (skillUser.getOutrageTime() == 0) {
            if (!skillUser.isConfused() && skillUser.getBattleAbility().getId()
                    != Ability.AbilityId.OWN_TEMPO) {
                results.add(skillUser.getName() + " became confused.");
                skillUser.induceConfusion();
                skillUser.removeOutrageSkill();
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
