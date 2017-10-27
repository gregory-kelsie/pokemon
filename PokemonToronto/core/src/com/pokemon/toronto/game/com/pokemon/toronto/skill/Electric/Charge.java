package com.pokemon.toronto.game.com.pokemon.toronto.skill.Electric;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialDefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpeedEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 10/22/2017.
 */

public class Charge extends EffectSkill {

    /**
     * - Name: Charge
     * - Type: Electric
     * - PP: 20
     * - Cat: Misc
     * - Accuracy: 100
     * - Increase power of next electric attack and increase sp. def by 1 stage.
     */
    public Charge() {
        super(SkillFactory.CHARGE, "Charge", 20, Pokemon.Type.ELECTRIC, -1);
        effects.add(new SpecialDefenseEffect(SecondaryEffect.Target.SELF,
                1, SecondaryEffect.StatDirection.INCREASE));
        targetsEnemy = false;
    }
    
    /**
     * Use the effects and return the move results
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
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition, int enemyPokemonPartyPosition, Field field,
                            SubField userField, SubField enemyField, boolean isFirstAttack, Skill targetSkill, List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        List<String> results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack, targetSkill,
                skillUserParty, enemyPokemonParty);
        skillUser.applyCharge();
        results.add(0, skillUser.getName() + " began\ncharging power!");
        return results;
    }

    /**
     * Return Charge's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Charge's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
