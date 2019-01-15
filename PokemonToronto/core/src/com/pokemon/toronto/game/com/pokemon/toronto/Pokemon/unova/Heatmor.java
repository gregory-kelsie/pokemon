package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.unova;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-05-07.
 */

public class Heatmor extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 631;
    public static final String NAME = "Heatmor";
    public static final String TYPE_OF_POKEMON = "Anteater";
    public static final String DESCRIPTION = "It breathes through a hole in its tail while it " +
            "burns with an internal fire. Durant is its prey.";
    public static final double HEIGHT = 1.4;
    public static final int BASE_EXP = 169;
    public static final int[] EV_YIELD = {0, 0, 0, 2, 0, 0};
    public static final int CAPTURE_RATE = 90;
    public static final double WEIGHT = 58;

    public static final Ability FIRST_ABILITY = new Ability.Gluttony();
    public static final Ability SECOND_ABILITY = new Ability.FlashFire();
    public static final Ability HIDDEN_ABILITY = new Ability.WhiteSmoke();

    //Base Stats
    public static final int BASE_HEALTH = 85;
    public static final int BASE_ATTACK = 97;
    public static final int BASE_DEFENSE = 66;
    public static final int BASE_SPECIAL_ATTACK = 105;
    public static final int BASE_SPECIAL_DEFENSE = 66;
    public static final int BASE_SPEED = 65;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/heatmor.png";
    public static final String BACK_PATH = "battle/backs/unova/heatmor.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/heatmor.png";
    public static final String CRY_PATH = "sounds/cry/631.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/heatmor.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.FIRE;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a heatmor
     */
    public Heatmor() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init heatmor's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.HONE_CLAWS);
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.INCINERATE);
        beginnerSkills.add(SkillFactory.LICK);
        levelUpSkills.put(0, beginnerSkills);
        //6 ODOR SLEUTH
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.BIND)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.FIRE_SPIN)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_SWIPES)));
        //26 SNATCH
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAME_BURST)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUG_BITE)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLASH)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.FIRE_LASH)));
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.AMNESIA)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAMETHROWER)));
        List<Integer> stockpileSkills = new ArrayList<Integer>();
        stockpileSkills.add(SkillFactory.STOCKPILE);
        stockpileSkills.add(SkillFactory.SPIT_UP);
        stockpileSkills.add(SkillFactory.SWALLOW);
        levelUpSkills.put(56, stockpileSkills);
        levelUpSkills.put(61, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLARE_BLITZ)));
        levelUpSkills.put(66, new ArrayList<Integer>(Arrays.asList(SkillFactory.INFERNO)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FLAMETHROWER.getValue());
        tmSkills.add(TmId.FIRE_BLAST.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.OVERHEAT.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.WILL_O_WISP.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init heatmor's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .5) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }
}
