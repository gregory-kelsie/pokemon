package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

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
 * Created by Gregory on 10/25/2017.
 */

public class EchoedVoice extends DamageSkill {
    /**
     * - Name: Echoed Voice
     * - Type: Bug
     * - Base Damage: 40
     * - PP: 15
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public EchoedVoice() {
        super(SkillFactory.ECHOED_VOICE, "Echoed Voice", 15, Pokemon.Type.NORMAL,
                SkillCategory.SPECIAL, 100, 40, 1);
    }


    /**
     * Damage the enemy, increasing for each successive use.
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

        List<String> results = new ArrayList<String>();
        int stacks = skillUser.getEchoedVoiceStacks();
        damage = getEchoedVoiceDamage(damage, stacks);
        results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack, targetSkill,
                skillUserParty, enemyPokemonParty);

        //Reset damage
        damage = 40;
        skillUser.setEchoedVoiceStacks(stacks + 1);
        return results;
    }

    public int getEchoedVoiceDamage(int damage, int stacks) {
        if (stacks == 0) {
            return damage;
        }
        return getEchoedVoiceDamage(damage * 2, stacks - 1);
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
