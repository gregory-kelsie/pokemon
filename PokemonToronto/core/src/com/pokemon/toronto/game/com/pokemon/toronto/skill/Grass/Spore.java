package com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SleepEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 9/19/2017.
 */

public class Spore extends EffectSkill {

    /**
     * - Name: Spore
     * - Type: Grass
     * - PP: 15
     * - Cat: Misc
     * - Accuracy: 100
     */
    public Spore() {
        super(SkillFactory.SPORE, "Spore", SkillDescription.SPORE, 15, Pokemon.Type.GRASS, 100);
        effects.add(new SleepEffect(SecondaryEffect.Target.ENEMY));
    }

    /**
     * Use Spore and return the move results
     * The user scatters a big cloud of sleep-inducing dust around the target.
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
        enemyPokemon.induceSleep();
        results.add(enemyPokemon.getName() + " fell asleep!");
        return results;
    }

    /**
     * Return Spore's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Spore's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon, Field field,
                               SubField userField, SubField enemyField, boolean isFirstAttacker,
                               Skill targetsSkill) {
        if (enemyPokemon.isStatused()) {
            return new FailResult("It failed...");
        }
        return new FailResult(false);
    }
}
