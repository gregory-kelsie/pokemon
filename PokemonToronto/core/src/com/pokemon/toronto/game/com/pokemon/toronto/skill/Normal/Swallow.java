package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 10/26/2017.
 */

public class Swallow extends Skill {
    /**
     * - Name: Swallow
     * - Type: Normal
     * - PP: 10
     * - Cat: Misc
     * - Accuracy: n/a
     */
    public Swallow() {
        super(SkillFactory.SWALLOW, "Swallow", SkillDescription.SWALLOW, 10, Pokemon.Type.NORMAL,
                Skill.SkillCategory.MISC, -1);
        targetsEnemy = false;
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
     * @param enemyPokemonParty      @return The results of using the move.
     * */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition,
                            int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill,
                            List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {

        List<String> results = new ArrayList<String>();
        if (skillUser.getStockpileStacks() == 1) {
            skillUser.addHealth((int)Math.round(skillUser.getHealthStat() * .25));
            results.add(skillUser.getName() + "'s defense fell!");
            SecondaryEffect defEffect = new DefenseEffect(SecondaryEffect.Target.SELF, 1,
                    SecondaryEffect.StatDirection.DECREASE);
            SecondaryEffect spDefEffect = new DefenseEffect(SecondaryEffect.Target.SELF, 1,
                    SecondaryEffect.StatDirection.DECREASE);
            defEffect.use(results, skillUser, enemyPokemon, field, userField, enemyField,
                    isFirstAttack);
            spDefEffect.use(results, skillUser, enemyPokemon, field, userField, enemyField,
                    isFirstAttack);
        } else if (skillUser.getStockpileStacks() == 2) {
            skillUser.addHealth((int)Math.round(skillUser.getHealthStat() * .5));
            results.add(skillUser.getName() + "'s defense harshly fell!");
            SecondaryEffect defEffect = new DefenseEffect(SecondaryEffect.Target.SELF, 2,
                    SecondaryEffect.StatDirection.DECREASE);
            SecondaryEffect spDefEffect = new DefenseEffect(SecondaryEffect.Target.SELF, 2,
                    SecondaryEffect.StatDirection.DECREASE);
            defEffect.use(results, skillUser, enemyPokemon, field, userField, enemyField,
                    isFirstAttack);
            spDefEffect.use(results, skillUser, enemyPokemon, field, userField, enemyField,
                    isFirstAttack);
        } else if (skillUser.getStockpileStacks() == 3) {
            skillUser.setCurrentHealth(skillUser.getHealthStat());
            results.add(skillUser.getName() + "'s defense drastically fell!");
            SecondaryEffect defEffect = new DefenseEffect(SecondaryEffect.Target.SELF, 3,
                    SecondaryEffect.StatDirection.DECREASE);
            SecondaryEffect spDefEffect = new DefenseEffect(SecondaryEffect.Target.SELF, 3,
                    SecondaryEffect.StatDirection.DECREASE);
            defEffect.use(results, skillUser, enemyPokemon, field, userField, enemyField,
                    isFirstAttack);
            spDefEffect.use(results, skillUser, enemyPokemon, field, userField, enemyField,
                    isFirstAttack);

        }
        results.add(skillUser.getName() + "'s Stockpile effect wore off!");
        results.add(0, skillUser.getName() + "'s HP was restored."); //Put as the first text.

        return results;
    }

    /**
     * Return Swallow's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Swallow's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon, Field field,
                               SubField userField, SubField enemyField, boolean isFirstAttack,
                               Skill targetsSkill) {
        if (skillUser.hasFullHealth()) {
            return new FailResult(skillUser.getName() + " is full health!");
        }
        return new FailResult(false);
    }
}
