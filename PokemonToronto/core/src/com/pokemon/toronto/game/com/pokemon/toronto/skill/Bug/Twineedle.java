package com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.RegularDamageAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.MultiHitMove;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.PoisonEffect;

import java.util.List;

/**
 * Created by Gregory on 10/19/2017.
 */

public class Twineedle extends MultiHitMove {

    private SecondaryEffect poisonEffect;
    private double poisonChance;

    /**
     * - Name: Twineedle
     * - Type: Bug
     * - Base Damage: 25
     * - PP: 20
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     * - Number of Hits: 2
     */
    public Twineedle() {
        super(SkillFactory.TWINEEDLE, "Twineedle", 20, Pokemon.Type.BUG, Skill.SkillCategory.PHYSICAL, 100, 25, 1, 0);
        poisonEffect = new PoisonEffect(SecondaryEffect.Target.ENEMY);
        poisonChance = 0.2;
    }

    /**
     * Damage the enemy 2 with a chance to poison..
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     * @param enemyPokemonPartyPosition
     * @param field The field of the battle.
     * @param targetSkill
     * @param skillUserParty
     * @param enemyPokemonParty    @return The results of using the move.
     * */
    @Override
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition, int enemyPokemonPartyPosition, Field field,
                            SubField userField, SubField enemyField, boolean isFirstAttack, Skill targetSkill, List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        List<String> results = super.use(skillUser, enemyPokemon, skillUserPartyPosition, enemyPokemonPartyPosition, field,
                userField,enemyField, isFirstAttack, targetSkill, skillUserParty, enemyPokemonParty);
        double rand = Math.random();
        if (rand <= poisonChance) {
            poisonEffect.use(results, skillUser, enemyPokemon, field, userField, enemyField, isFirstAttack);
        }
        return results;
    }

    /**
     * Return Twineedle's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Quick Attack's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new RegularDamageAnimation(userAnimation);
    }
}
