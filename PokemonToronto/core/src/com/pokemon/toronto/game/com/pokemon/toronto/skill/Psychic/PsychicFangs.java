package com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.List;

/**
 * Created by Gregory on 10/23/2017.
 */

public class PsychicFangs extends DamageSkill {
    /**
     * - Name: Psychic Fangs
     * - Type: Psychic
     * - Base Damage: 85
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public PsychicFangs() {
        super(SkillFactory.PSYCHIC_FANGS, "Psychic Fangs", SkillDescription.PSYCHIC_FANGS,10,
                Pokemon.Type.PSYCHIC, Skill.SkillCategory.PHYSICAL, 100, 85, 1);
        makesPhysicalContact = true;

    }

    /**
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
        boolean brokeLightScreen = false;
        boolean brokeReflect = false;
        if (enemyField.hasLightScreen()) {
            enemyField.removeLightScreen();
            brokeLightScreen = true;
        }
        if (enemyField.hasReflect()) {
            enemyField.removeReflect();
            brokeReflect = true;
        }
        List<String> results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack,
                targetSkill, skillUserParty, enemyPokemonParty);
        if (brokeLightScreen) {
            results.add(enemyPokemon.getName() + "s Light Screen was broken.");
        }
        if (brokeReflect) {
            results.add(enemyPokemon.getName() + "s Reflect was broken.");
        }
        return results;
    }

    /**
     * Return Psychic Fangs's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Psychic Fangs's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
