package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.unova;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-05-04.
 */

public class Unfezant extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 521;
    public static final String NAME = "Unfezant";
    public static final String TYPE_OF_POKEMON = "Proud";
    public static final String DESCRIPTION = "Males swing the plumage on their heads to threaten" +
            " others, but females are better at flying.";
    public static final double HEIGHT = 1.2;
    public static final int BASE_EXP = 220;
    public static final int[] EV_YIELD = {0, 3, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 29;

    public static final Ability FIRST_ABILITY = new Ability.BigPecks();
    public static final Ability SECOND_ABILITY = new Ability.SuperLuck();
    public static final Ability HIDDEN_ABILITY = new Ability.Rivalry();

    //Base Stats
    public static final int BASE_HEALTH = 80;
    public static final int BASE_ATTACK = 115;
    public static final int BASE_DEFENSE = 80;
    public static final int BASE_SPECIAL_ATTACK = 65;
    public static final int BASE_SPECIAL_DEFENSE = 55;
    public static final int BASE_SPEED = 93;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/unfezant.png";
    public static final String BACK_PATH = "battle/backs/unova/unfezant.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/unfezant.png";
    public static final String CRY_PATH = "sounds/cry/521.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/unfezant.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    public static final Type TYPE_TWO = Type.FLYING;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a unfezant
     */
    public Unfezant() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init unfezant's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.GUST);
        beginnerSkills.add(SkillFactory.GROWL);
        beginnerSkills.add(SkillFactory.LEER);
        beginnerSkills.add(SkillFactory.QUICK_ATTACK);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWL)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEER)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.AIR_CUTTER)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROOST)));
        //23 DETECT
        //27 TAUNT
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.AIR_SLASH)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAZOR_WIND)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEATHER_DANCE)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWAGGER)));
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.FACADE)));
        levelUpSkills.put(60, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAILWIND)));
        levelUpSkills.put(66, new ArrayList<Integer>(Arrays.asList(SkillFactory.SKY_ATTACK)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.ROOST.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.STEEL_WING.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.FLY.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init unfezant's gender.
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
