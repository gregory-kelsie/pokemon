package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-04-24.
 */

public class Drifloon extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 425;
    public static final String NAME = "Drifloon";
    public static final String TYPE_OF_POKEMON = "Balloon";
    public static final String DESCRIPTION = "Because of the way it floats aimlessly, an old " +
            "folktale calls it a Signpost for Wandering Spirits.";
    public static final double HEIGHT = 0.4;
    public static final int BASE_EXP = 70;
    public static final int[] EV_YIELD = {1, 0, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 125;
    public static final double WEIGHT = 1.2;

    public static final Ability FIRST_ABILITY = new Ability.Aftermath();
    public static final Ability SECOND_ABILITY = new Ability.Unburden();
    public static final Ability HIDDEN_ABILITY = new Ability.FlareBoost();

    //Base Stats
    public static final int BASE_HEALTH = 90;
    public static final int BASE_ATTACK = 50;
    public static final int BASE_DEFENSE = 34;
    public static final int BASE_SPECIAL_ATTACK = 60;
    public static final int BASE_SPECIAL_DEFENSE = 44;
    public static final int BASE_SPEED = 70;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/drifloon.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/drifloon.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/drifloon.png";
    public static final String CRY_PATH = "sounds/cry/425.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/drifloon.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GHOST;
    public static final Type TYPE_TWO = Type.FLYING;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.FLUCTUATING;

    /**
     * Create a drifloon
     */
    public Drifloon() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init drifloon's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.CONSTRICT);
        beginnerSkills.add(SkillFactory.MINIMIZE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.ASTONISH)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.GUST)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.FOCUS_ENERGY)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.PAYBACK)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.OMINOUS_WIND)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.STOCKPILE)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEX)));
        List<Integer> thirteen = new ArrayList<Integer>();
        thirteen.add(SkillFactory.SWALLOW);
        thirteen.add(SkillFactory.SPIT_UP);
        levelUpSkills.put(32, thirteen);
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHADOW_BALL)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.AMNESIA)));
        //44 BATON PASS
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.EXPLOSION)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.WILL_O_WISP.getValue());
        tmSkills.add(TmId.ACROBATICS.getValue());
        tmSkills.add(TmId.EMBARGO.getValue());
        tmSkills.add(TmId.EXPLOSION.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.GYRO_BALL.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init drifloon's gender.
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

    /**
     * Return Drifblim if the drifloon is above level 28.
     * @return Drifblim if drifloon is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 28) {
            return PokemonId.DRIFBLIM.getValue();
        }
        return -1;
    }
}
