package com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 10/25/2017.
 */

public class HealBell extends Skill {
    /**
     * - Name: Heal Bell
     * - Type: Normal
     * - PP: 5
     * - Cat: Misc
     * - Accuracy: n/a
     */
    public HealBell() {
        super(SkillFactory.HEAL_BELL, "Heal Bell", SkillDescription.HEAL_BELL, 5,
                Pokemon.Type.NORMAL, Skill.SkillCategory.MISC, -1);
        targetsEnemy = false;
    }

    /**
     * Use Heal Bell on the party.
     * - Remove all negative status ailments from the party.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     * @param enemyPokemonPartyPosition
     * @param field The field of the battle.
     * @param targetSkill
     * @param skillUserParty
     * @param enemyPokemonParty    @return Heal Bell's move results.
     * */
    @Override
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition,
                            int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill,
                            List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        List<String> results = new ArrayList<String>();
        results.add("A bell chimed!");
        for (int i = 0; i < skillUserParty.size(); i++) {
            if (skillUserParty.get(i).isStatused() &&
                    skillUserParty.get(i).getCurrentHealth() > 0) {
                skillUserParty.get(i).wakeUp();//Wake up removes status ailments and sleep timer.
            }
        }

        return results;
    }

    /**
     * Return Heal Bell's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Heal Bell's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
