package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.WeatherType;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialAttackEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 10/25/2017.
 */

public class Growth extends EffectSkill {

    private List<SecondaryEffect> sunlightEffects;
    /**
     * - Name: Growth
     * - Type: Normal
     * - PP: 20
     * - Cat: Misc
     * - Accuracy: N/A
     * - Increase user atk and sp atk by 1 stage, 2 stages in sunlight
     */
    public Growth() {
        super(SkillFactory.GROWTH, "Growth", 20, Pokemon.Type.NORMAL, -1);
        sunlightEffects = new ArrayList<SecondaryEffect>();
        effects.add(new AttackEffect(SecondaryEffect.Target.SELF, 1,
                SecondaryEffect.StatDirection.INCREASE));
        effects.add(new SpecialAttackEffect(SecondaryEffect.Target.SELF, 1,
                SecondaryEffect.StatDirection.INCREASE));

        sunlightEffects.add(new AttackEffect(SecondaryEffect.Target.SELF, 2,
                SecondaryEffect.StatDirection.INCREASE));
        sunlightEffects.add(new SpecialAttackEffect(SecondaryEffect.Target.SELF, 2,
                SecondaryEffect.StatDirection.INCREASE));
        targetsEnemy = false;
    }

    /**
     * Use Endeavor, equalize target health to user health.
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
     * @return The move results.
     * */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition,
                            int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill,
                            List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {

        if (field.getWeatherType() != WeatherType.SUN) {
            return super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                    enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack,
                    targetSkill, skillUserParty, enemyPokemonParty);
        } else {
            List<String> results = new ArrayList<String>();
            for (int i = 0; i < effects.size(); i++) {
                sunlightEffects.get(i).use(results, skillUser, enemyPokemon, field, userField,
                        enemyField, isFirstAttack);
            }
            return results;
        }
    }

    /**
     * Return Growth's move animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Growth's move animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
