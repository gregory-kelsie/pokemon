package com.pokemon.toronto.game.com.pokemon.toronto.skill.Fire;

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
 * Created by Gregory on 9/29/2017.
 */

public class Eruption extends DamageSkill {
    /**
     * - Name: Eruption
     * - Type: Fire
     * - Base Damage: 150
     * - PP: 5
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Eruption() {
        super(SkillFactory.ERUPTION, "Eruption", 5, Pokemon.Type.FIRE, SkillCategory.SPECIAL, 100, 150, 1);
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
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition, int enemyPokemonPartyPosition, Field field,
                            SubField userField, SubField enemyField, boolean isFirstAttack, Skill targetSkill, List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {

        List<String> results;

        damage = (int)Math.round((skillUser.getCurrentHealth() * damage * 1.0) / skillUser.getHealthStat());
        results = super.use(skillUser, enemyPokemon, skillUserPartyPosition, enemyPokemonPartyPosition, field,
                userField, enemyField, isFirstAttack, targetSkill, skillUserParty, enemyPokemonParty);
        damage = 150; //Reset damage back to normal.
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
