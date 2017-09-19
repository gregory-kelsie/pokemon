package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice;

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
 * Created by Gregory on 9/19/2017.
 */

public class IceBall extends DamageSkill {
    /**
     * - Name: Ice Ball
     * - Type: Ice
     * - Base Damage: 30
     * - PP: 20
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 90
     */
    public IceBall() {
        super(SkillFactory.ICE_BALL, "Ice Ball", 20, Pokemon.Type.ICE, Skill.SkillCategory.PHYSICAL, 90, 30, 1);
        makesPhysicalContact = true;
    }


    /**
     * Damage the enemy then recharge the next turn.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     *@param enemyPokemonPartyPosition
     * @param field The field for the battle.
     * @param userField The field for the battle.
     * @param enemyField The field for the battle.
     * @param skillUserParty
     * @param enemyPokemonParty      @return The results of using the move.
     */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition, int enemyPokemonPartyPosition, Field field,
                            SubField userField, SubField enemyField, boolean isFirstAttack, List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {

        if (skillUser.getRolloutTurns() == 0) {
            skillUser.startRollout(this);
        } else {
            damage = damage * (2 * skillUser.getRolloutTurns()); //double damage per turn
            if (skillUser.getRolloutTurns() == 5) {
                //Cancel rollout when it reaches 5 turns.
                skillUser.cancelRollout();
            } else {
                skillUser.addRolloutTurn();
            }
        }
        List<String> results;
        results = super.use(skillUser, enemyPokemon, skillUserPartyPosition, enemyPokemonPartyPosition, field,
                userField, enemyField, isFirstAttack, skillUserParty, enemyPokemonParty);
        damage = 30; // Set damage back to regular amount.
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
