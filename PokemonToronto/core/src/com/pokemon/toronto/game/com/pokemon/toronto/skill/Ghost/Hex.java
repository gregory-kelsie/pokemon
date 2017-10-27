package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ghost;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialAttackEffect;

import java.util.List;

/**
 * Created by Gregory on 10/22/2017.
 */

public class Hex extends DamageSkill {
    /**
     * - Name: Hex
     * - Type: Ghost
     * - Base Damage: 65
     * - PP: 10
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Hex() {
        super(SkillFactory.HEX, "Hex", 10, Pokemon.Type.GHOST, SkillCategory.SPECIAL,
                100, 65, 1);
    }

    /**
     * Increase damage to 130 if the target is statused.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     * @param enemyPokemonPartyPosition
     * @param field The field for the battle.
     * @param userField The field for the battle.
     * @param enemyField The field for the battle.
     * @param targetSkill
     * @param skillUserParty
     * @param enemyPokemonParty
     * @return The results of using the move.
     * */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition,
                            int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill,
                            List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {

        if (enemyPokemon.isStatused()) {
            damage = 130;
            List<String> results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                    enemyPokemonPartyPosition, field,
                    userField, enemyField, isFirstAttack, targetSkill, skillUserParty,
                    enemyPokemonParty);
            damage = 65; //Reset to normal.
            return results;
        }
        return super.use(skillUser, enemyPokemon, skillUserPartyPosition, enemyPokemonPartyPosition,
                field, userField, enemyField, isFirstAttack, targetSkill, skillUserParty,
                enemyPokemonParty);
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
