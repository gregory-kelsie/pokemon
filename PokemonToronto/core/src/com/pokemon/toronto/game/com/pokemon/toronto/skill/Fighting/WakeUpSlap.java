package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 10/2/2017.
 */

public class WakeUpSlap extends DamageSkill {
    /**
     * - Name: Wake-Up Slap
     * - Type: Fighting
     * - Base Damage: 70
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public WakeUpSlap() {
        super(SkillFactory.WAKE_UP_SLAP, "Wake-Up Slap", 10, Pokemon.Type.FIGHTING, Skill.SkillCategory.PHYSICAL, 100, 70, 1);
        makesPhysicalContact = true;
    }

    /**
     * Damage the enemy, deal extra damage if sleeping and wake them up
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
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition, int enemyPokemonPartyPosition, Field field,
                            SubField userField, SubField enemyField, boolean isFirstAttack, Skill targetSkill, List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {

        List<String> results = new ArrayList<String>();
        boolean wokeUp = false;
        if (enemyPokemon.isSleeping()) {
            enemyPokemon.wakeUp();
            damage = 140;
            wokeUp = true;
        }
        results = super.use(skillUser, enemyPokemon, skillUserPartyPosition, enemyPokemonPartyPosition, field,
                userField, enemyField, isFirstAttack, targetSkill, skillUserParty, enemyPokemonParty);
        if (wokeUp) {
            results.add(enemyPokemon.getName() + " woke up!");
            damage = 70; //Reset to the normal amount.
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
