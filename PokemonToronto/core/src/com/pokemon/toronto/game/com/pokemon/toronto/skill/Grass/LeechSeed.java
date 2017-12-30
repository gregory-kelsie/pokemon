package com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 9/2/2017.
 */

public class LeechSeed extends Skill {
    /**
     * - Name: Leech Seed
     * - Type: Grass
     * - PP: 10
     * - Cat: Misc
     * - Accuracy: 90
     */
    public LeechSeed() {
        super(34, "Leech Seed", SkillDescription.LEECH_SEED, 10, Pokemon.Type.GRASS,
                Skill.SkillCategory.MISC, 90);
    }

    /**
     * Set up Leech Seed
     * - Drain for 1/8 hp every end turn.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     * @param enemyPokemonPartyPosition
     * @param field The field of the battle.
     * @param targetSkill
     * @param skillUserParty
     * @param enemyPokemonParty    @return Leech Seed's move results.
     * */
    @Override
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition,
                            int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill,
                            List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        List<String> results = new ArrayList<String>();
        enemyPokemon.receiveLeechSeed();
        results.add(enemyPokemon.getName() + " was seeded!");
        return results;
    }

    /**
     * Return Leech Seed's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Stealth Rock's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon,
                               Field field, SubField userField, SubField enemyField,
                               boolean isFirstAttack, Skill targetsSkill) {
        if (enemyPokemon.isSeeded()) {
            return new FailResult("It failed...");
        } else if (enemyPokemon.getBattleTypeOne() == Pokemon.Type.GRASS ||
                enemyPokemon.getBattleTypeTwo() == Pokemon.Type.GRASS) {
            return new FailResult("Leech Seed does not affect Grass types.");
        }
        return new FailResult(false);
    }
}
