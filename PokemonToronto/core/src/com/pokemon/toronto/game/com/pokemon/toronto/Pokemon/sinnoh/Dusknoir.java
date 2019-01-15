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

public class Dusknoir extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 477;
    public static final String NAME = "Dusknoir";
    public static final String TYPE_OF_POKEMON = "Gripper";
    public static final String DESCRIPTION = "It is said to take lost spirits into its pliant " +
            "body and guide them home.";
    public static final double HEIGHT = 2.2;
    public static final int BASE_EXP = 236;
    public static final int[] EV_YIELD = {0, 0, 1, 0, 2, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 106.6;

    public static final Ability FIRST_ABILITY = new Ability.Pressure();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.Frisk();

    //Base Stats
    public static final int BASE_HEALTH = 45;
    public static final int BASE_ATTACK = 100;
    public static final int BASE_DEFENSE = 135;
    public static final int BASE_SPECIAL_ATTACK = 65;
    public static final int BASE_SPECIAL_DEFENSE = 135;
    public static final int BASE_SPEED = 45;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/dusknoir.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/dusknoir.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/dusknoir.png";
    public static final String CRY_PATH = "sounds/cry/477.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/dusknoir.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GHOST;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.FAST;

    /**
     * Create a dusknoir
     */
    public Dusknoir() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init dusknoir's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SHADOW_PUNCH);
        beginnerSkills.add(SkillFactory.FUTURE_SIGHT);
        beginnerSkills.add(SkillFactory.FIRE_PUNCH);
        beginnerSkills.add(SkillFactory.ICE_PUNCH);
        beginnerSkills.add(SkillFactory.THUNDER_PUNCH);
        //GRAVITY
        beginnerSkills.add(SkillFactory.BIND);
        beginnerSkills.add(SkillFactory.LEER);
        beginnerSkills.add(SkillFactory.NIGHT_SHADE);
        //DISABLE
        beginnerSkills.add(SkillFactory.ASTONISH);
        levelUpSkills.put(0, beginnerSkills);
        //6 DISABLE
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.ASTONISH)));
        //14 FORESIGHT
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHADOW_SNEAK)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.PURSUIT)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.WILL_O_WISP)));
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.CONFUSE_RAY)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.CURSE)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEX)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHADOW_BALL)));
        //52 MEAN LOOK
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.PAYBACK)));
        levelUpSkills.put(64, new ArrayList<Integer>(Arrays.asList(SkillFactory.FUTURE_SIGHT)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.BLIZZARD.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.WILL_O_WISP.getValue());
        tmSkills.add(TmId.EMBARGO.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.INFESTATION.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.TRICK_ROOM.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init dusknoir's gender.
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
