package com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug;

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
 * Created by Gregory on 10/19/2017.
 */

public class SpiderWeb extends Skill {
    /**
     * - Name: Spider Web
     * - Type: Bug
     * - PP: 10
     * - Cat: Misc
     * - Accuracy: Doesn't miss
     */
    public SpiderWeb() {
        super(SkillFactory.SPIDER_WEB, "Spider Web", SkillDescription.spiderWeb, 10,
                Pokemon.Type.BUG, Skill.SkillCategory.MISC, -1);
    }

    /**
     * Set up Spider Web.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     * @param enemyPokemonPartyPosition
     * @param field The field of the battle.
     * @param targetSkill
     * @param skillUserParty
     * @param enemyPokemonParty    @return Spider Web's move results.
     * */
    @Override
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition, int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill, List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        List<String> results = new ArrayList<String>();
        enemyPokemon.applySpiderWeb();
        results.add(enemyPokemon.getName() + " can no longer escape!");
        return results;
    }

    /**
     * Return Spider Web's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Spider Web's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon,
                               Field field, SubField userField, SubField enemyField,
                               boolean isFirstAttack, Skill targetsSkill) {
        if (enemyPokemon.isSpiderWebbed()) {
            return new FailResult("It failed...");
        } else if (enemyPokemon.getTypeOne() == Pokemon.Type.GHOST ||
                enemyPokemon.getTypeTwo() == Pokemon.Type.GHOST) {
            return new FailResult("Spider Web does not affect\nGhost type Pokemon.");
        }
        return new FailResult(false);
    }
}
