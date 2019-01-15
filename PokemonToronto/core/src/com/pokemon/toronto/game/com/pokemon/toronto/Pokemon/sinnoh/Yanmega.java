package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-04-29.
 */

public class Yanmega extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 469;
    public static final String NAME = "Yanmega";
    public static final String TYPE_OF_POKEMON = "Ogre Darner";
    public static final String DESCRIPTION = "Its jaw power is incredible. It is adept at biting" +
            " apart foes while flying by at high speed.";
    public static final double HEIGHT = 1.9;
    public static final int BASE_EXP = 180;
    public static final int[] EV_YIELD = {0, 2, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 30;
    public static final double WEIGHT = 51.5;

    public static final Ability FIRST_ABILITY = new Ability.SpeedBoost();
    public static final Ability SECOND_ABILITY = new Ability.TintedLens();
    public static final Ability HIDDEN_ABILITY = new Ability.Frisk();

    //Base Stats
    public static final int BASE_HEALTH = 86;
    public static final int BASE_ATTACK = 76;
    public static final int BASE_DEFENSE = 86;
    public static final int BASE_SPECIAL_ATTACK = 116;
    public static final int BASE_SPECIAL_DEFENSE = 56;
    public static final int BASE_SPEED = 95;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/yanmega.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/yanmega.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/yanmega.png";
    public static final String CRY_PATH = "sounds/cry/469.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/yanmega.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.BUG;
    public static final Type TYPE_TWO = Type.FLYING;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a yanmega
     */
    public Yanmega() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init yanmega's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.BUG_BUZZ);
        beginnerSkills.add(SkillFactory.AIR_SLASH);
        beginnerSkills.add(SkillFactory.NIGHT_SLASH);
        beginnerSkills.add(SkillFactory.BUG_BITE);
        beginnerSkills.add(SkillFactory.TACKLE);
        //FORESIGHT
        beginnerSkills.add(SkillFactory.QUICK_ATTACK);
        beginnerSkills.add(SkillFactory.DOUBLE_TEAM);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_TEAM)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.SONIC_BOOM)));
        //TODO DETECT 17
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUPERSONIC)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.UPROAR)));
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.PURSUIT)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.ANCIENT_POWER)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLASH)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCREECH)));
        //TODO U-TURN 49
        levelUpSkills.put(54, new ArrayList<Integer>(Arrays.asList(SkillFactory.AIR_SLASH)));
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUG_BUZZ)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.ROOST.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.LEECH_LIFE.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.STEEL_WING.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init yanmega's gender.
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
