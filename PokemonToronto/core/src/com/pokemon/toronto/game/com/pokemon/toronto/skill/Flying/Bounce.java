package com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.ParalysisEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 9/20/2017.
 */

public class Bounce extends SecondaryEffectSkill {
    /**
     * - Name: Bounce
     * - Type: Flying
     * - Base Damage: 85
     * - PP: 5
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 85
     */
    public Bounce() {
        super(SkillFactory.BOUNCE, "Bounce", SkillDescription.BOUNCE, 5, Pokemon.Type.FLYING,
                Skill.SkillCategory.PHYSICAL, 85, 85, 1, .3);
        makesPhysicalContact = true;
        secondaryEffects.add(new ParalysisEffect(SecondaryEffect.Target.ENEMY));
    }


    /**
     * Damage the enemy for 2-3 turns. Once finished confuses the user.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     * @param enemyPokemonPartyPosition
     * @param field The field for the battle.
     * @param userField The field for the battle.
     * @param enemyField The field for the battle.
     * @param targetSkill
     * @param skillUserParty
     * @param enemyPokemonParty      @return The results of using the move.
     * */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition,
                            int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill,
                            List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {

        //Use the damage part of the move.
        if (!skillUser.isFlying()) {
            skillUser.fly();
            skillUser.setNextTurnSkill(this);
            List<String> results = new ArrayList<String>();
            results.add(skillUser.getName() + " sprang up!");
            return results;
        } else {
            skillUser.flyDown();
            return super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                    enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack,
                    targetSkill, skillUserParty, enemyPokemonParty);
        }
    }

    @Override
    public boolean targetsEnemy(Pokemon skillUser, Field field) {
        if (skillUser.isFlying()) {
            return true;
        } else {
            return false;
        }
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
