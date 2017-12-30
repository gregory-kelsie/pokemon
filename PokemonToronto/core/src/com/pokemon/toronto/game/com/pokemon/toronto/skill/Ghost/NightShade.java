package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ghost;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.FlinchEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 10/22/2017.
 */

public class NightShade extends DamageSkill {
    /**
     * - Name: Night Shade
     * - Type: Ghost
     * - Base Damage: 1 - Damage = to user's level.
     * - PP: 15
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public NightShade() {
        super(SkillFactory.NIGHT_SHADE, "Night Shade", SkillDescription.NIGHT_SHADE, 15,
                Pokemon.Type.GHOST, Skill.SkillCategory.SPECIAL, 100, 1, 1);
    }

    /**
     * Deal damage equal to user's level.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     * @param enemyPokemonPartyPosition
     * @param field The field for the battle.
     * @param userField The field for the battle.
     * @param enemyField The field for the battle.
     * @param targetSkill
     * @param skillUserParty
     * @param enemyPokemonParty
     * @return The results of using the move.
     * */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition,
                            int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill,
                            List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {

        int oldHealth = enemyPokemon.getCurrentHealth();
        enemyPokemon.subtractHealth(skillUser.getLevel());
        List<String> results = new ArrayList<String>();
        results.add("Dealt " + (oldHealth - enemyPokemon.getCurrentHealth()) + " damage.");
        return super.use(skillUser, enemyPokemon, skillUserPartyPosition, enemyPokemonPartyPosition,
                field, userField, enemyField, isFirstAttack, targetSkill, skillUserParty,
                enemyPokemonParty);
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
