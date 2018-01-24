package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 8/16/2017.
 */

public class Kakuna extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 14;
    private static final String NAME = "Kakuna";
    private static final int BASE_EXP = 71;
    private static final int[] EV_YIELD = {0, 0, 2, 0, 0, 0};
    private static final int CAPTURE_RATE = 120;
    private static final double WEIGHT = 10;

    private static final Ability FIRST_ABILITY = new Ability.ShedSkin();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    private static final int BASE_HEALTH = 45;
    private static final int BASE_ATTACK = 25;
    private static final int BASE_DEFENSE = 50;
    private static final int BASE_SPECIAL_ATTACK = 25;
    private static final int BASE_SPECIAL_DEFENSE = 25;
    private static final int BASE_SPEED = 35;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/kakuna.png";
    private static final String BACK_PATH = "battle/backs/kakuna.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/kakuna.png";
    private static final String CRY_PATH = "sounds/cry/014.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/014.png";

    /**
     * Create a Kakuna
     */
    public Kakuna() {
        super(NUMBER, NAME, Pokemon.Type.BUG, Type.POISON, Pokemon.ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Kakuna's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.HARDEN);
        levelUpSkills.put(0, beginnerSkills);
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.HARDEN);
    }

    /**
     * Return Beedrill if the Kakuna is above level 10.
     * @return Beedrill if Kakuna is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 10) {
            return PokemonId.BEEDRILL.getValue();
        }
        return -1;
    }
}
