package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-04-24.
 */

public class Wormadam extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 413;
    public static final String NAME = "Wormadam";
    public static final String TYPE_OF_POKEMON = "Bagworm";
    public static final String DESCRIPTION = "When evolving, its body takes in surrounding " +
            "materials. As a result, there are many body variations.";
    public static final double HEIGHT = 0.5;
    public static final int BASE_EXP = 148;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 2, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 6.5;

    public static final Ability FIRST_ABILITY = new Ability.Anticipation();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.Overcoat();

    //Base Stats
    public static final int BASE_HEALTH = 60;
    public static final int BASE_ATTACK = 59;
    public static final int BASE_DEFENSE = 85;
    public static final int BASE_SPECIAL_ATTACK = 79;
    public static final int BASE_SPECIAL_DEFENSE = 105;
    public static final int BASE_SPEED = 36;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/wormadam.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/wormadam.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/wormadam.png";
    public static final String CRY_PATH = "sounds/cry/413.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/wormadam.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.BUG;
    public static final Type TYPE_TWO = Type.GRASS;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a wormadam
     */
    public Wormadam() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init wormadam's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SUCKER_PUNCH);
        beginnerSkills.add(SkillFactory.TACKLE);
        //PROTECT
        beginnerSkills.add(SkillFactory.BUG_BITE);
        levelUpSkills.put(0, beginnerSkills);
        //10 PROTECT
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUG_BITE)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.HIDDEN_POWER)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.CONFUSION)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAZOR_LEAF)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWTH)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYBEAM)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.CAPTIVATE)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAIL)));
        //41 ATTRACT
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCHIC)));
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEAF_STORM)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUG_BUZZ)));
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.QUIVER_DANCE);
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.VENOSHOCK.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.GYRO_BALL.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.INFESTATION.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.FLASH_CANNON.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init wormadam's gender.
     */
    @Override
    protected void initGender() {
        gender = 'F';
    }
}
