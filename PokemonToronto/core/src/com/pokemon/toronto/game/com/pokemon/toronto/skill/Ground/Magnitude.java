package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ground;

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
 * Created by Gregory on 10/22/2017.
 */

public class Magnitude extends DamageSkill {
    /**
     * - Name: Magnitude
     * - Type: Ground
     * - Base Damage: 1 - Damage based on magnitude size 4-10
     * - PP: 30
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Magnitude() {
        super(SkillFactory.MAGNITUDE, "Magnitude", 30, Pokemon.Type.GROUND,
                Skill.SkillCategory.PHYSICAL, 100, 1, 1);
    }

    /**
     * Increase damage based on each stat stage increase.
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

        double rand = Math.random();
        int magnitudeSize;
        if (rand <= .05) {
            damage = 10;
            magnitudeSize = 4;
        } else if (rand <= .1) {
            damage = 150;
            magnitudeSize = 10;
        } else if (rand <= .2) {
            damage = 30;
            magnitudeSize = 5;
        } else if (rand <= .3) {
            damage = 110;
            magnitudeSize = 9;
        } else if (rand <= .5) {
            damage = 50;
            magnitudeSize = 6;
        } else if (rand <= .7) {
            damage = 90;
            magnitudeSize = 8;
        } else {
            damage = 70;
            magnitudeSize = 7;
        }
        List<String> results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack, targetSkill,
                skillUserParty, enemyPokemonParty);
        results.add(0, "Magnitude " + magnitudeSize);
        damage = 1; //Reset damage to normal.
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
