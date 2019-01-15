package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kalos;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-08-20.
 */

public class Zygarde extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 718;
    public static final String NAME = "Zygarde";
    public static final String TYPE_OF_POKEMON = "Order";
    public static final String DESCRIPTION = "When the Kalos region's ecosystem falls into " +
            "disarray, it appears and reveals its secret power.";
    public static final double HEIGHT = 5;
    public static final int BASE_EXP = 270;
    public static final int[] EV_YIELD = {3, 0, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 3;
    public static final double WEIGHT = 284.6;

    public static final Ability FIRST_ABILITY = new Ability.AuraBreak();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    public static final int BASE_HEALTH = 108;
    public static final int BASE_ATTACK = 100;
    public static final int BASE_DEFENSE = 121;
    public static final int BASE_SPECIAL_ATTACK = 81;
    public static final int BASE_SPECIAL_DEFENSE = 95;
    public static final int BASE_SPEED = 95;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/zygarde.png";
    public static final String BACK_PATH = "battle/backs/kalos/zygarde.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/zygarde.png";
    public static final String CRY_PATH = "sounds/cry/718.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/zygarde.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.DRAGON;
    public static final Pokemon.Type TYPE_TWO = Type.GROUND;

    //Exp
    public static final Pokemon.ExpType EXP_TYPE = ExpType.SLOW;

    /**
     * Create a zygarde
     */
    public Zygarde() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init zygarde's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.GLARE);
        beginnerSkills.add(SkillFactory.BULLDOZE);
        beginnerSkills.add(SkillFactory.DRAGON_BREATH);
        beginnerSkills.add(SkillFactory.BITE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAFEGUARD)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.DIG)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.BIND)));
        //26 LAND'S WRATH
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.SANDSTORM)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.HAZE)));
        levelUpSkills.put(51, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.EARTHQUAKE)));
        //59 CAMOUFLAGE
        levelUpSkills.put(63, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAGON_PULSE)));
        levelUpSkills.put(72, new ArrayList<Integer>(Arrays.asList(SkillFactory.COIL)));
        levelUpSkills.put(80, new ArrayList<Integer>(Arrays.asList(SkillFactory.OUTRAGE)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SLUDGE_WAVE.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.DRAGON_TAIL.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }
}
