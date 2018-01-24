package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 8/16/2017.
 */

public class Nidorino extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 33;
    private static final String NAME = "Nidorino";
    private static final int BASE_EXP = 118;
    private static final int[] EV_YIELD = {0, 2, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 120;
    private static final double WEIGHT = 19.5;

    private static final Ability FIRST_ABILITY = new Ability.PoisonPoint();
    private static final Ability SECOND_ABILITY = new Ability.Rivalry();
    private static final Ability HIDDEN_ABILITY = new Ability.Hustle();

    //Base Stats
    private static final int BASE_HEALTH = 61;
    private static final int BASE_ATTACK = 72;
    private static final int BASE_DEFENSE = 57;
    private static final int BASE_SPECIAL_ATTACK = 55;
    private static final int BASE_SPECIAL_DEFENSE = 55;
    private static final int BASE_SPEED = 65;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/nidorino.png";
    private static final String BACK_PATH = "battle/backs/nidorino.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/nidorino.png";
    private static final String CRY_PATH = "sounds/cry/033.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/033.png";

    /**
     * Create a Nidorino
     */
    public Nidorino() {
        super(NUMBER, NAME, Pokemon.Type.POISON, Pokemon.Type.NONE, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    @Override
    protected void initGender() {
        gender = 'M';
    }

    /**
     * Init Nidorino's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.LEER);
        beginnerSkills.add(SkillFactory.PECK);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.FOCUS_ENERGY)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_KICK)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_STING)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_ATTACK)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.HORN_ATTACK)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.TOXIC_SPIKES)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLATTER)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_JAB)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.CAPTIVATE)));
        levelUpSkills.put(58, new ArrayList<Integer>(Arrays.asList(SkillFactory.HORN_DRILL)));
    }

    /**
     * Return Nidoking's id when a Moon Stone is used
     * on Nidorino.
     * @return Nidoking's id.
     */
    @Override
    public int getMoonStoneEvolutionId() {
        return PokemonId.NIDOKING.getValue();
    }
}
