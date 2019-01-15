package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kalos;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-02-02.
 */

public class Helioptile extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 694;
    public static final String NAME = "Helioptile";
    public static final String TYPE_OF_POKEMON = "Generator";
    public static final String DESCRIPTION = "The frills on either side of its head have cells" +
            " that generate electricity when exposed to sunlight.";
    public static final double HEIGHT = 0.5;
    public static final int BASE_EXP = 58;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    public static final int CAPTURE_RATE = 190;
    public static final double WEIGHT = 6;

    public static final Ability FIRST_ABILITY = new Ability.DrySkin();
    public static final Ability SECOND_ABILITY = new Ability.SandVeil();
    public static final Ability HIDDEN_ABILITY = new Ability.SolarPower();

    //Base Stats
    public static final int BASE_HEALTH = 44;
    public static final int BASE_ATTACK = 38;
    public static final int BASE_DEFENSE = 33;
    public static final int BASE_SPECIAL_ATTACK = 61;
    public static final int BASE_SPECIAL_DEFENSE = 43;
    public static final int BASE_SPEED = 70;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/helioptile.png";
    public static final String BACK_PATH = "battle/backs/kalos/helioptile.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/helioptile.png";
    public static final String CRY_PATH = "sounds/cry/694.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/helioptile.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.ELECTRIC;
    public static final Type TYPE_TWO = Type.NORMAL;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a helioptile
     */
    public Helioptile() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init helioptile's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.POUND);
        beginnerSkills.add(SkillFactory.TAIL_WHIP);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDER_SHOCK)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARGE)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_SLAP)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAZOR_WIND)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.PARABOLIC_CHARGE)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDER_WAVE)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.BULLDOZE)));
        //40 VOLT SWITCH
        //45 ELECTRIFY
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDERBOLT)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.LOW_SWEEP.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.VOLT_SWITCH.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.DRAGON_TAIL.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.WILD_CHARGE.getValue());
        tmSkills.add(TmId.SURF.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init helioptile's gender.
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
     * Return Heliolisk
     * @return Heliolisk
     */
    @Override
    public int getSunStoneEvolutionId() {
        return PokemonId.HELIOLISK.getValue();
    }
}
