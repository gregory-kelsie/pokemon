package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-08-16.
 */

public class Cresselia extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 488;
    public static final String NAME = "Cresselia";
    public static final String TYPE_OF_POKEMON = "Lunar";
    public static final String DESCRIPTION = "On nights around the quarter moon, the aurora from" +
            " its tail extends and undulates beautifully.";
    public static final int BASE_EXP = 270;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 3, 0};
    public static final int CAPTURE_RATE = 3;
    public static final double WEIGHT = 85.6;
    public static final double HEIGHT = 1.5;

    public static final Ability FIRST_ABILITY = new Ability.Levitate();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    public static final int BASE_HEALTH = 120;
    public static final int BASE_ATTACK = 70;
    public static final int BASE_DEFENSE = 120;
    public static final int BASE_SPECIAL_ATTACK = 75;
    public static final int BASE_SPECIAL_DEFENSE = 130;
    public static final int BASE_SPEED = 85;

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.PSYCHIC;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/cresselia.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/cresselia.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/cresselia.png";
    public static final String CRY_PATH = "sounds/cry/488.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/cresselia.png";

    /**
     * Create a cresselia
     */
    public Cresselia() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Cresselia's gender.
     */
    @Override
    protected void initGender() {
        gender = 'F';
    }

    /**
     * Init cresselia's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //LUNAR DANCE
        beginnerSkills.add(SkillFactory.PSYCHO_SHIFT);
        beginnerSkills.add(SkillFactory.PSYCHO_CUT);
        beginnerSkills.add(SkillFactory.MOONLIGHT);
        beginnerSkills.add(SkillFactory.CONFUSION);
        beginnerSkills.add(SkillFactory.DOUBLE_TEAM);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAFEGUARD)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.MIST)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.AURORA_BEAM)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.FUTURE_SIGHT)));
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLASH)));
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.MOONLIGHT)));
        levelUpSkills.put(66, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCHO_CUT)));
        levelUpSkills.put(75, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCHO_SHIFT)));
        //84 LUNAR DANCE
        levelUpSkills.put(93, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCHIC)));
        levelUpSkills.put(99, new ArrayList<Integer>(Arrays.asList(SkillFactory.MOONBLAST)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.PSYSHOCK.getValue());
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.TRICK_ROOM.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }
}
