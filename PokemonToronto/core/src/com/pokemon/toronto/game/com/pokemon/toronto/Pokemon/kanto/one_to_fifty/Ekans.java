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

public class Ekans extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 23;
    private static final String NAME = "Ekans";
    private static final int BASE_EXP = 62;
    private static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 255;
    private static final double WEIGHT = 6.9;

    private static final Ability FIRST_ABILITY = new Ability.Intimidate();
    private static final Ability SECOND_ABILITY = new Ability.ShedSkin();
    private static final Ability HIDDEN_ABILITY = new Ability.Unnerve();

    //Base Stats
    private static final int BASE_HEALTH = 35;
    private static final int BASE_ATTACK = 60;
    private static final int BASE_DEFENSE = 44;
    private static final int BASE_SPECIAL_ATTACK = 40;
    private static final int BASE_SPECIAL_DEFENSE = 54;
    private static final int BASE_SPEED = 55;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/ekans.png";
    private static final String BACK_PATH = "battle/backs/ekans.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/ekans.png";
    private static final String CRY_PATH = "sounds/cry/023.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/023.png";

    /**
     * Create a Ekans
     */
    public Ekans() {
        super(NUMBER, NAME, Type.POISON, Pokemon.Type.NONE, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Ekans's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.WRAP);
        beginnerSkills.add(SkillFactory.LEER);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_STING)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.GLARE)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCREECH)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.ACID)));
        ArrayList<Integer> stockpileSkills = new ArrayList<Integer>();
        stockpileSkills.add(SkillFactory.STOCKPILE);
        stockpileSkills.add(SkillFactory.SWALLOW);
        stockpileSkills.add(SkillFactory.SPIT_UP);
        levelUpSkills.put(25, stockpileSkills);
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.ACID_SPRAY)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_BOMB)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.GASTRO_ACID)));
        //TODO: BELCH 38
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.HAZE)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.COIL)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.GUNK_SHOT)));
    }

    /**
     * Return Arbok if the Ekans is above level 22.
     * @return Arbok if Ekans is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 22) {
            return PokemonId.ARBOK.getValue();
        }
        return -1;
    }
}
