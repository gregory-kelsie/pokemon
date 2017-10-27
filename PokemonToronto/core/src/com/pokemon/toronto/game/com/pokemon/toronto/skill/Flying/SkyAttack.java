package com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.FlinchEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 9/29/2017.
 */

public class SkyAttack extends SecondaryEffectSkill {
    /**
     * - Name: Sky Attack
     * - Type: Flying
     * - Base Damage: 140
     * - PP: 5
     * - Cat: Physical
     * - Crit Stage: 2
     * - Accuracy: 70
     */
    public SkyAttack() {
        super(SkillFactory.SKY_ATTACK, "Sky Attack", 5, Pokemon.Type.FLYING, SkillCategory.PHYSICAL, 90, 140, 2, .3);
        secondaryEffects.add(new FlinchEffect(SecondaryEffect.Target.ENEMY));
    }

    /**
     * Damage the enemy after 1 turn
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

        //Use the damage part of the move.
        if (!skillUser.hasNextTurnSkill()) {
            skillUser.setNextTurnSkill(this);
            List<String> results = new ArrayList<String>();
            results.add(skillUser.getName() + " became cloaked\nin harsh light!");
            return results;
        } else {
            return super.use(skillUser, enemyPokemon, skillUserPartyPosition, enemyPokemonPartyPosition, field,
                    userField, enemyField, isFirstAttack, targetSkill, skillUserParty, enemyPokemonParty);
        }
    }

    @Override
    public boolean targetsEnemy(Pokemon skillUser, Field field) {
        if (skillUser.hasNextTurnSkill()) {
            return true;
        } else {
            return false;
        }
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
