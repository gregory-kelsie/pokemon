package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 10/25/2017.
 */

public class Explosion extends DamageSkill {
    /**
     * - Name: Explosion
     * - Type: Normal
     * - Base Damage: 250
     * - PP: 5
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public Explosion() {
        super(SkillFactory.EXPLOSION, "Explosion", SkillDescription.EXPLOSION, 5,
                Pokemon.Type.NORMAL, SkillCategory.PHYSICAL, 100, 250, 1);
        continuesUseThroughNoEffect = true;
    }


    /**
     * Use Explosion and return the move results.
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
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition,
                            int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill,
                            List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        List<String> results;

        if (effectsEnemy(enemyPokemon)) {
            results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                    enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack,
                    targetSkill, skillUserParty, enemyPokemonParty);
        } else {
            results = new ArrayList<String>();
            results.add("It does not effect " + enemyPokemon.getName() + "...");
        }
        skillUser.subtractHealth(skillUser.getCurrentHealth());

        return results;
    }

    /**
     * Return Explosion's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Explosion's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon,
                               Field field, SubField userField, SubField enemyField,
                               boolean isFirstAttack, Skill targetsSkill) {
        if (enemyPokemon.getBattleAbility() == Pokemon.Ability.DAMP) {
            return new FailResult(enemyPokemon.getName() + "'s ability Damp\nprevents Explosion.");
        }
        return new FailResult(false);
    }
}
