package com.pokemon.toronto.game.com.pokemon.toronto.skill.Dark;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.EffectSkill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SecondaryEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.AttackEffect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.skill_effects.SpecialAttackEffect;

import java.util.List;

/**
 * Created by Gregory on 10/21/2017.
 */

public class Memento extends EffectSkill {
    /**
     * - Name: Memento
     * - Type: Dark
     * - PP: 10
     * - Cat: Misc
     * - Accuracy: 100
     */
    public Memento() {
        super(SkillFactory.MEMENTO, "Memento", 10, Pokemon.Type.DARK, 100);
        effects.add(new AttackEffect(SecondaryEffect.Target.ENEMY, 2, SecondaryEffect.StatDirection.DECREASE));
        effects.add(new SpecialAttackEffect(SecondaryEffect.Target.ENEMY, 2, SecondaryEffect.StatDirection.DECREASE));
    }

    /**
     * Deal double damage if the target received damage already this turn (Ex: Recoil, Life Orb, Confusion)
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
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition, int enemyPokemonPartyPosition, Field field,
                            SubField userField, SubField enemyField, boolean isFirstAttack, Skill targetSkill, List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {

        List<String> results = super.use(skillUser, enemyPokemon, skillUserPartyPosition, enemyPokemonPartyPosition, field,
                userField, enemyField, isFirstAttack, targetSkill, skillUserParty, enemyPokemonParty);
        skillUser.subtractHealth(skillUser.getCurrentHealth());
        return results;
    }

    /**
     * Return Memento's skill animation.
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return Memento's skill animation.
     */
    @Override
    public SkillAnimation getAnimation(boolean userAnimation) {
        return new TackleAnimation(userAnimation);
    }
}
