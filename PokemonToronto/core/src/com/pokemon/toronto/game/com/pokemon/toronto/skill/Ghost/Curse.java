package com.pokemon.toronto.game.com.pokemon.toronto.skill.Ghost;

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
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.DefenseEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpeedEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 9/4/2017.
 */

public class Curse extends EffectSkill {
    /**
     * - Name: Curse
     * - Type: Ghost
     * - PP: 10
     * - Cat: Misc
     * - Accuracy: 100
     */
    public Curse() {
        super(37, "Curse", SkillDescription.CURSE, 10, Pokemon.Type.GHOST, 100);
        effects.add(new SpeedEffect(SecondaryEffect.Target.SELF, 1,
                SecondaryEffect.StatDirection.DECREASE));
        effects.add(new AttackEffect(SecondaryEffect.Target.SELF, 1,
                SecondaryEffect.StatDirection.INCREASE));
        effects.add(new DefenseEffect(SecondaryEffect.Target.SELF, 1,
                SecondaryEffect.StatDirection.INCREASE));
        targetsEnemy = false;
    }

    /**
     * Use Curse and return the move results
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

        if (skillUser.getBattleTypeOne() == Pokemon.Type.GHOST ||
                skillUser.getBattleTypeTwo() == Pokemon.Type.GHOST) {
            List<String> results = new ArrayList<String>();
            enemyPokemon.giveCurse();
            int damage = (int)Math.floor(skillUser.getHealthStat() / 2.0);
            skillUser.subtractHealth(damage);
            results.add(skillUser.getName() + " cut its own HP and" +
                    "\nlaid a curse on " + enemyPokemon.getName());
            return results;
        } else {
            return super.use(skillUser, enemyPokemon, skillUserPartyPosition,
                    enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack,
                    targetSkill, skillUserParty, enemyPokemonParty);
        }

    }

    /**
     * Return Curse's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Curse's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        //TODO: Check the user type
        return new TackleAnimation(userAnimation);
    }

    @Override
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon, Field field,
                               SubField userField, SubField enemyField, boolean isFirstAttacker,
                               Skill targetsSkill) {
        if ((skillUser.getBattleTypeOne() == Pokemon.Type.GHOST ||
                skillUser.getBattleTypeTwo() == Pokemon.Type.GHOST) &&
                enemyPokemon.isCursed()) {
            return new FailResult("It failed...");
        }
        return new FailResult(false);
    }
}
