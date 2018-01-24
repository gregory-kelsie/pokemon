package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability.AbilityId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 10/27/2017.
 */

public class AlolanDiglett extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = -50;
    private static final String NAME = "Diglett";
    private static final int BASE_EXP = 53;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    private static final int CAPTURE_RATE = 255;
    private static final double WEIGHT = 1;

    private static final Ability FIRST_ABILITY = new Ability.SandVeil();
    private static final Ability SECOND_ABILITY = new Ability.TanglingHair();
    private static final Ability HIDDEN_ABILITY = new Ability.SandForce();


    //Base Stats
    private static final int BASE_HEALTH = 10;
    private static final int BASE_ATTACK = 55;
    private static final int BASE_DEFENSE = 30;
    private static final int BASE_SPECIAL_ATTACK = 35;
    private static final int BASE_SPECIAL_DEFENSE = 45;
    private static final int BASE_SPEED = 90;

    //Typing
    private static final Type TYPE_ONE = Type.GROUND;
    private static final Type TYPE_TWO = Type.STEEL;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/alolan_kanto/diglett.png";
    private static final String BACK_PATH = "battle/backs/alolan_kanto/diglett.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/alolan_kanto/diglett.png";
    private static final String CRY_PATH = "sounds/cry/050.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/alolan_kanto/alolandiglett.png";

    /**
     * Create a Diglett
     */
    public AlolanDiglett() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Diglett's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SAND_ATTACK);
        beginnerSkills.add(SkillFactory.METAL_CLAW);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWL)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.ASTONISH)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_SLAP)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.MAGNITUDE)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.BULLDOZE)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUCKER_PUNCH)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_BOMB)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.EARTH_POWER)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.DIG)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.IRON_HEAD)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.EARTHQUAKE)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.FISSURE)));
    }

    /**
     * Return Alolan Dugtrio if the Alolan Diglett is 26+.
     * @return Alolan Dugtrio if the Alolan Diglett is 26+.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 26) {
            return PokemonId.ALOLAN_DUGTRIO.getValue();
        }
        return -1;
    }
}
