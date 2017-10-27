package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.BurnEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.FlinchEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.FreezeEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ParalysisEffect;

import java.util.List;

/**
 * Created by Gregory on 10/26/2017.
 */

public class TriAttack extends DamageSkill {

    private SecondaryEffect paralysisEffect;
    private SecondaryEffect burnEffect;
    private SecondaryEffect freezeEffect;
    /**
     * - Name: Tri Attack
     * - Type: Normal
     * - Base Damage: 80
     * - PP: 10
     * - Cat: Special
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public TriAttack() {
        super(SkillFactory.TRI_ATTACK, "Tri Attack", 15, Pokemon.Type.NORMAL,
                SkillCategory.SPECIAL, 100, 80, 1);
        paralysisEffect = new ParalysisEffect(SecondaryEffect.Target.ENEMY);
        burnEffect = new BurnEffect(SecondaryEffect.Target.ENEMY);
        freezeEffect = new FreezeEffect(SecondaryEffect.Target.ENEMY);

    }

    /**
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
     */
    @Override
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition,
                            int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill,
                            List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {

        List<String> results;
        results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack,
                targetSkill, skillUserParty, enemyPokemonParty);
        double rand = Math.random();
        if (rand <= .0667) {
            paralysisEffect.use(results, skillUser, enemyPokemon, field, userField,
                    enemyField, isFirstAttack);
        } else if (rand <= .133333334) {
            burnEffect.use(results, skillUser, enemyPokemon, field, userField,
                    enemyField, isFirstAttack);
        } else if (rand <= .2) {
            freezeEffect.use(results, skillUser, enemyPokemon, field, userField,
                    enemyField, isFirstAttack);
        }
        return results;
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
