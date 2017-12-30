package com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.EvasionEffect;

import java.util.List;

/**
 * Created by Gregory on 9/20/2017.
 */

public class Defog extends EffectSkill {
    /**
     * - Name: Defog
     * - Type: Flying
     * - PP: 15
     * - Cat: Misc
     * - Accuracy: 100
     */
    public Defog() {
        super(SkillFactory.DEFOG, "Defog", SkillDescription.DEFOG, 15, Pokemon.Type.FLYING, 100);
        effects.add(new EvasionEffect(SecondaryEffect.Target.ENEMY,
                1, SecondaryEffect.StatDirection.DECREASE));
    }

    /**
     * Use Defog and return the move results.
     * Sets the weather to Defog.
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
        List<String> results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack,
                targetSkill, skillUserParty, enemyPokemonParty);

        if (userField.hasStealthRocks() || enemyField.hasStealthRocks()) {
            results.add(skillUser.getName() + " blew away\nStealth Rock!");
            userField.removeStealthRocks();
            enemyField.removeStealthRocks();
        }
        if (userField.hasSpikes() || enemyField.hasSpikes()) {
            results.add(skillUser.getName() + " blew away\nSpikes!");
            userField.removeSpikes();
            enemyField.removeSpikes();
        }
        if (userField.hasToxicSpikes() || enemyField.hasToxicSpikes()) {
            results.add(skillUser.getName() + " blew away\nToxic Spikes!");
            userField.removeToxicSpikes();
            enemyField.removeToxicSpikes();
        }
        if (userField.hasStickyWeb() || enemyField.hasStickyWeb()) {
            results.add(skillUser.getName() + " blew away\nSticky Web!");
            userField.removeStickyWeb();
            enemyField.removeStickyWeb();
        }
        if (enemyField.hasMist()) {
            results.add(skillUser.getName() + " blew away\nthe Mist!");
            enemyField.removeMist();
        }
        if (enemyField.hasReflect()) {
            results.add(skillUser.getName() + " blew away\nthe Reflect!");
            enemyField.removeReflect();
        }
        if (enemyField.hasLightScreen()) {
            results.add(skillUser.getName() + " blew away\nthe Light Screen!");
            enemyField.removeLightScreen();
        }
        return results;
    }

    /**
     * Return Defog's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Defog's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }

}
