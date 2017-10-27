package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.List;

/**
 * Created by Gregory on 10/25/2017.
 */

public class Flail extends DamageSkill {
    /**
     * - Name: Flail
     * - Type: Normal
     * - Base Damage: 1
     * - PP: 15
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Flail() {
        super(SkillFactory.FLAIL, "Flail", 15, Pokemon.Type.NORMAL,
                Skill.SkillCategory.PHYSICAL, 100, 1, 1);
        makesPhysicalContact = true;
    }

    /**
     * The lower the user's hp the higher the damage.
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
     * @return The move results.
     * */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition,
                            int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill,
                            List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {


        if (skillUser.getCurrentHealth() >= skillUser.getHealthStat() * .6875) {
            damage = 20;
        } else if (skillUser.getCurrentHealth() >= skillUser.getHealthStat() * .3542) {
            damage = 40;
        } else if (skillUser.getCurrentHealth() >= skillUser.getHealthStat() * .2083) {
            damage = 80;
        } else if (skillUser.getCurrentHealth() >= skillUser.getHealthStat() * .1042) {
            damage = 100;
        } else if (skillUser.getCurrentHealth() >= skillUser.getHealthStat() * .0417) {
            damage = 150;
        } else {
            damage = 200;
        }
        List<String> results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack,
                targetSkill, skillUserParty, enemyPokemonParty);
        damage = 1; //Reset damage
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
