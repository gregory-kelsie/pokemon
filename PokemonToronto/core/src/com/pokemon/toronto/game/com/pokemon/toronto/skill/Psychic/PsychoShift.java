package com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 10/23/2017.
 */

public class PsychoShift extends Skill {
    /**
     * - Name: Psycho Shift
     * - Type: Psychic
     * - PP: 10
     * - Cat: Misc
     * - Accuracy: 100
     */
    public PsychoShift() {
        super(SkillFactory.PSYCHO_SHIFT, "Psycho Shift", SkillDescription.PSYCHO_SHIFT, 10,
                Pokemon.Type.PSYCHIC, Skill.SkillCategory.MISC, 100);
    }

    /**
     * Use Psycho Shift and return the move results.
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
                            int enemyPokemonPartyPosition, Field field,
                            SubField userField, SubField enemyField, boolean isFirstAttack,
                            Skill targetSkill, List<Pokemon> skillUserParty,
                            List<Pokemon> enemyPokemonParty) {
        Pokemon.Status transferredStatus = skillUser.getStatus();
        List<String> results = new ArrayList<String>();
        if (transferredStatus == Pokemon.Status.POISON) {
            results.add(enemyPokemon.getName() + " was poisoned.");
            results.add(skillUser.getName() + "'s Poison was healed.");
        } else if (transferredStatus == Pokemon.Status.BURN) {
            results.add(enemyPokemon.getName() + " was burned.");
            results.add(skillUser.getName() + "'s Burn was healed.");
        } else if (transferredStatus == Pokemon.Status.SLEEP) {
            results.add(enemyPokemon.getName() + " fell asleep.");
            results.add(skillUser.getName() + " woke up!");
        } else if (transferredStatus == Pokemon.Status.FROZEN) {
            results.add(enemyPokemon.getName() + " was frozen.");
            results.add(skillUser.getName() + " thawed out!");
        } else if (transferredStatus == Pokemon.Status.PARALYSIS) {
            results.add(enemyPokemon.getName() + " was paralyzed.");
            results.add(skillUser.getName() + "'s Paralysis was healed.");
        }
        enemyPokemon.setPreStatus(transferredStatus);
        skillUser.wakeUp(); //Wake up removes status ailments and sleep coutner.

        return results;
    }

    /**
     * Return Psycho Shift's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Psycho Shift's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon, Field field,
                               SubField userField, SubField enemyField, boolean isFirstAttack,
                               Skill targetsSkill) {
        if (skillUser.isPoisoned() && enemyPokemon.isPoisonable()) {
            return new FailResult(false);
        } else if (skillUser.isParalyzed() && enemyPokemon.isParalyzable()) {
            return new FailResult(false);
        } else if (skillUser.isFrozen() && enemyPokemon.isFreezable()) {
            return new FailResult(false);
        } else if (skillUser.isBurned() && enemyPokemon.isBurnable()) {
            return new FailResult(false);
        } else if (skillUser.isSleeping() && enemyPokemon.isSleepable()) {
            return new FailResult(false);
        } else {
            return new FailResult("It failed...");
        }

    }
}
