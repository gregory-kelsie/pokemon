package com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying;



import com.badlogic.gdx.Gdx;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.DamageSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.FailResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 9/29/2017.
 */

public class SkyDrop extends DamageSkill {
    /**
     * - Name: Sky Drop
     * - Type: Flying
     * - Base Damage: 60
     * - PP: 10
     * - Cat: Physical
     * - Crit Stage: 1
     * - Accuracy: 100
     */
    public SkyDrop() {
        super(SkillFactory.SKY_DROP, "Sky Drop", SkillDescription.SKY_DROP, 15, Pokemon.Type.FLYING,
                Skill.SkillCategory.PHYSICAL, 100, 60, 1);
        makesPhysicalContact = true;
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
     * @param enemyPokemonParty
     * @return The results of using the move.
     * */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition,
                            int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill,
                            List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {

        //Use the damage part of the move.
        if (!enemyPokemon.isSkyDropped()) {
            enemyPokemon.setSkyDrop();
            skillUser.setNextTurnSkill(this);
            List<String> results = new ArrayList<String>();
            results.add(skillUser.getName() + " took\n" + enemyPokemon.getName() +
                    " high into the air!");
            return results;
        } else {
            enemyPokemon.removeSkyDrop();
            skillUser.removeNextTurnSkill();
            Gdx.app.log("skydrop", "removed drop");
            List<String> results;
            //Only damage non flying types
            if (enemyPokemon.getBattleTypeOne() == Pokemon.Type.FLYING ||
                    enemyPokemon.getBattleTypeTwo() == Pokemon.Type.FLYING) {
                results = new ArrayList<String>();
            } else {
                Gdx.app.log("skydrop", "dmg");
                results = super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                        enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack,
                        targetSkill, skillUserParty, enemyPokemonParty);
            }
            results.add(0, enemyPokemon.getName() + " was freed\nfrom the Sky Drop!");
            return results;
        }
    }

    @Override
    public boolean targetsEnemy(Pokemon skillUser, Field field) {
        if (skillUser.hasNextTurnSkill()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon, Field field,
                               SubField userField, SubField enemyField, boolean isFirstAttacker,
                               Skill targetsSkill) {
        if (enemyPokemon.getBattleWeight() >= 200) {
            return new FailResult("The target is too heavy!");
        }
        return new FailResult(false);
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
