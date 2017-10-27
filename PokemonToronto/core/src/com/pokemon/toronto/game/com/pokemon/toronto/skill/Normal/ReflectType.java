package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 10/25/2017.
 */

public class ReflectType extends Skill {
    /**
     * - Name: Reflect Type
     * - Type: Normal
     * - PP: 15
     * - Cat: Misc
     * - Accuracy: N/A
     */
    public ReflectType() {
        super(SkillFactory.REFLECT_TYPE, "Reflect Type", 15, Pokemon.Type.NORMAL,
                Skill.SkillCategory.MISC, -1);
    }

    /**
     * Use Reflect Type, change type to target's type
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     * @param enemyPokemonPartyPosition
     * @param field The field for the battle.
     * @param userField The field for the battle.
     * @param enemyField The field for the battle.
     * @param targetSkill
     * @param skillUserParty
     * @param enemyPokemonParty      @return The move results.
     * */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition,
                            int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill,
                            List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        List<String> results = new ArrayList<String>();
        skillUser.setBattleTypeOne(enemyPokemon.getBattleTypeOne());
        skillUser.setBattleTypeTwo(enemyPokemon.getBattleTypeTwo());
        results.add(skillUser.getName() + " copied\n" + enemyPokemon.getName() + "'s typing!");
        return results;
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon, Field field,
                               SubField userField, SubField enemyField, boolean isFirstAttack,
                               Skill targetsSkill) {
        if (enemyPokemon.getBattleTypeOne() == Pokemon.Type.NONE) {
            return new FailResult("It failed...");
        }
        return new FailResult(false);
    }

    /**
     * Return Reflect Type's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Focus Energy's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
