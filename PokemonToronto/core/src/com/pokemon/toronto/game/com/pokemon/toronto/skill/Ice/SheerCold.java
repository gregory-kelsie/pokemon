package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 9/19/2017.
 */

public class SheerCold extends DamageSkill {
    /**
     * - Name: Sheer Cold
     * - Type: Ice
     * - Base Damage: 1 HIT KO
     * - PP: 5
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 30
     */
    public SheerCold() {
        super(SkillFactory.SHEER_COLD, "Sheer Cold", 5, Pokemon.Type.ICE, SkillCategory.SPECIAL, 30, 100, 1);
    }


    /**
     * Use Sheer Cold and return the move results.
     * Deal heavy damage to enemy, but kills self.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     * @param enemyPokemonPartyPosition
     * @param field The field the battle is on.
     * @param targetSkill
     * @param skillUserParty
     * @param enemyPokemonParty    @return Thunder Shock's move results.
     * */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition, int enemyPokemonPartyPosition, Field field,
                            SubField userField, SubField enemyField, boolean isFirstAttack, Skill targetSkill, List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        List<String> results = new ArrayList<String>();
        enemyPokemon.subtractHealth(enemyPokemon.getCurrentHealth());
        return results;
    }

    /**
     * Return Sheer Cold's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Sheer Cold's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

    /**
     * Return whether or not the move will hit the enemy.
     * @param skillUser The Pokemon using the skill.
     * @param enemyPokemon The Pokemon receiving the skill.
     * @param field The field for the battle.
     * @param userField The field for the battle.
     * @param enemyField The field for the battle.
     * @param isFirstAttack Whether or not the skill was used first in the clash
     * @return Whether or not the skill hits the enemy.
     */
    @Override
    public boolean willHitEnemy(Pokemon skillUser, Pokemon enemyPokemon,
                                Field field, SubField userField, SubField enemyField, boolean isFirstAttack) {
        if (enemyPokemon.isSemiInvulnerable()) {
            return false;
        }
        if (Math.random() <= 1) {
            return true;
        }
        return false;
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon,
                               Field field, SubField userField, SubField enemyField,
                               boolean isFirstAttack, Skill targetsSkill) {
        if (enemyPokemon.getBattleTypeOne() == Pokemon.Type.ICE ||
                enemyPokemon.getBattleTypeTwo() == Pokemon.Type.ICE) {
            return new FailResult("Sheer Cold does not affect\nIce type Pokemon.");
        } else if (enemyPokemon.getBattleAbility() == Pokemon.Ability.STURDY &&
                skillUser.getBattleAbility() != Pokemon.Ability.MOLD_BREAKER) {
            return new FailResult("Sheer Cold does not affect " +
                    enemyPokemon.getName() + "\nDue to its ability Sturdy!");
        }
        return new FailResult(false);
    }
}
