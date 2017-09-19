package com.pokemon.toronto.game.com.pokemon.toronto.skill;

import com.badlogic.gdx.Gdx;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 8/31/2017.
 */

public abstract class SecondaryEffectSkill extends DamageSkill {
    protected List<SecondaryEffect> secondaryEffects;
    protected double chance;

    /**
     * Create a Secondary Effect skill for recoil/draining attacks. A skill that hits damage and also
     * has a chance to proc a secondary effect.
     * @param id The skill id.
     * @param name The name of the skill
     * @param maxPP The maximum amount of PP for the skill
     * @param type The type of skill (Grass, Water, Fire etc)
     * @param category The category of the skill (Physical, Special or Misc)
     * @param damage The base damage for the skill
     * @param crit The crit stage for the skill
     * @param accuracy The accuracy level for the skill.
     * @param recoilLevel The amount of recoil damage the user will take.
     * @param chance The chance the Secondary effect will occur
     *                    none, 1/2, 1/3, 1/4.
     */
    public SecondaryEffectSkill(int id, String name, int maxPP, Pokemon.Type type, SkillCategory category, int accuracy, int damage, int crit, int recoilLevel,
                                double chance) {
        super(id, name, maxPP, type, category, accuracy, damage, crit, recoilLevel);
        this.chance = chance;
        secondaryEffects = new ArrayList<SecondaryEffect>();
    }

    /**
     * Create a Secondary Effect skill for non-recoil attacks. A skill that hits damage and also
     * has a chance to proc a secondary effect.
     * @param id The skill id.
     * @param name The name of the skill
     * @param maxPP The maximum amount of PP for the skill
     * @param type The type of skill (Grass, Water, Fire etc)
     * @param category The category of the skill (Physical, Special or Misc)
     * @param damage The base damage for the skill
     * @param crit The crit stage for the skill
     * @param accuracy The accuracy level for the skill.
     */
    public SecondaryEffectSkill(int id, String name, int maxPP, Pokemon.Type type, SkillCategory category, int accuracy, int damage, int crit, double chance) {
        super(id, name, maxPP, type, category, accuracy, damage, crit);
        this.chance = chance;
        secondaryEffects = new ArrayList<SecondaryEffect>();
    }

    /**
     * Damage the enemy, but also use the secondary effects.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     *@param enemyPokemonPartyPosition
     * @param field The field of the battle.
     * @param skillUserParty
     * @param enemyPokemonParty    @return The results of using the move.
     */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition, int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        //Use the damage part of the move.
        List<String> results = super.use(skillUser, enemyPokemon, skillUserPartyPosition, enemyPokemonPartyPosition, field,
                userField, enemyField, isFirstAttack, skillUserParty, enemyPokemonParty);

        double rand = Math.random();
        if (chance >= rand) {
            for (int i = 0; i < secondaryEffects.size(); i++) {
                secondaryEffects.get(i).use(results, skillUser, enemyPokemon, field, userField, enemyField, isFirstAttack);
            }
        }
        return results;
    }
}
