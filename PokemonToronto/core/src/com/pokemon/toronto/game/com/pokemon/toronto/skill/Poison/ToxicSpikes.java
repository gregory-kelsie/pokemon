package com.pokemon.toronto.game.com.pokemon.toronto.skill.Poison;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 8/16/2017.
 */

public class ToxicSpikes extends Skill {

    /**
     * - Name: Toxic Spikes
     * - Type: Poison
     * - PP: 20
     * - Cat: Misc
     * - Accuracy: 100
     */
    public ToxicSpikes() {
        super(26, "Toxic Spikes", 20, Pokemon.Type.POISON, Skill.SkillCategory.MISC, 100);
    }

    /**
     * Set up a layer of toxic spikes on the opponent's field.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     * @param enemyPokemonPartyPosition
     * @param field The field of the battle.
     * @param targetSkill
     * @param skillUserParty
     * @param enemyPokemonParty    @return Toxic Spikes' move results.
     * */
    @Override
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition, int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill, List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        List<String> results = new ArrayList<String>();
        enemyField.addToxicSpikeLayer();
        results.add(skillUser.getName() + " added\na layer of Toxic Spikes.");
        return results;
    }

    /**
     * Return Toxic Spikes' skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Toxic Spikes' skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon,
                               Field field, SubField userField, SubField enemyField,
                               boolean isFirstAttack, Skill targetsSkill) {
        if (enemyField.getNumberOfToxicSpikeLayers() >=
                enemyField.getMaxToxicSpikeLayers()) {
            return new FailResult("It failed...");
        }
        return new FailResult(false);
    }
}
