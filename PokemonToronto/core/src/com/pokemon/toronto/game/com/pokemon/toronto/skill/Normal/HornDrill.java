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

public class HornDrill extends DamageSkill {
    /**
     * - Name: Horn Drill
     * - Type: Normal
     * - Base Damage: 1 HIT KO
     * - PP: 5
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 30
     */
    public HornDrill() {
        super(SkillFactory.HORN_DRILL, "Horn Drill", 5, Pokemon.Type.NORMAL,
                Skill.SkillCategory.PHYSICAL, 30, 1, 1);
        makesPhysicalContact = true;
    }

    /**
     * Use Horn Drill and return the move results.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     * @param enemyPokemonPartyPosition
     * @param field The field the battle is on.
     * @param targetSkill
     * @param skillUserParty
     * @param enemyPokemonParty
     * @return Horn Drill's move results.
     * */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition,
                            int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill,
                            List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        List<String> results = new ArrayList<String>();
        enemyPokemon.subtractHealth(enemyPokemon.getCurrentHealth());
        return results;
    }

    /**
     * Return Horn Drill's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Horn Drill's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
