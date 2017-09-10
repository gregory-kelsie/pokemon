package com.pokemon.toronto.game.com.pokemon.toronto.skill.Water;

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
 * Created by Gregory on 9/1/2017.
 */

public class AquaRing extends Skill {
    /**
     * - Name: Aqua Ring
     * - Type: Water
     * - PP: 20
     * - Cat: Misc
     * - Accuracy: 100
     */
    public AquaRing() {
        super(32, "Aqua Ring", 20, Pokemon.Type.WATER, Skill.SkillCategory.MISC, 100);
    }

    /**
     * Set up Aqua Ring.
     * - Heal for 1/16 hp every end turn.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     *@param enemyPokemonPartyPosition
     * @param field The field of the battle.
     * @param skillUserParty
     * @param enemyPokemonParty    @return Aqua Ring's move results.
     */
    @Override
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition, int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        List<String> results = new ArrayList<String>();
        skillUser.receiveAquaRing();
        results.add(skillUser.getName() + " surrounded\nitself in a veil of water!");
        return results;
    }

    /**
     * Return Stealth Rock's skill animation.
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
                               boolean isFirstAttack) {
        if (skillUser.isEnvelopedInAquaRing()) {
            return new FailResult("It failed...");
        }
        return new FailResult(false);
    }
}
