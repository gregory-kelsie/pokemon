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

public class Mamoswine extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 473;
    public static final String NAME = "Mamoswine";
    public static final String TYPE_OF_POKEMON = "Twin Tusk";
    public static final String DESCRIPTION = "When the temperature rose at the end of the ice " +
            "age, most Mamoswine disappeared.";
    public static final double HEIGHT = 2.5;
    public static final int BASE_EXP = 239;
    public static final int[] EV_YIELD = {0, 3, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 50;
    public static final double WEIGHT = 291;

    public static final Ability FIRST_ABILITY = new Ability.Oblivious();
    public static final Ability SECOND_ABILITY = new Ability.SnowCloak();
    public static final Ability HIDDEN_ABILITY = new Ability.ThickFat();

    //Base Stats
    public static final int BASE_HEALTH = 110;
    public static final int BASE_ATTACK = 130;
    public static final int BASE_DEFENSE = 80;
    public static final int BASE_SPECIAL_ATTACK = 70;
    public static final int BASE_SPECIAL_DEFENSE = 60;
    public static final int BASE_SPEED = 80;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/mamoswine.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/mamoswine.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/mamoswine.png";
    public static final String CRY_PATH = "sounds/cry/473.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/mamoswine.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.ICE;
    public static final Type TYPE_TWO = Type.GROUND;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    /**
     * Create a mamoswine
     */
    public Mamoswine() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init mamoswine's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.FURY_ATTACK);
        beginnerSkills.add(SkillFactory.SCARY_FACE);
        beginnerSkills.add(SkillFactory.ANCIENT_POWER);
        beginnerSkills.add(SkillFactory.PECK);
        //ODOR SLEUTH
        //MUD SPORT
        beginnerSkills.add(SkillFactory.POWDER_SNOW);
        levelUpSkills.put(0, beginnerSkills);
        //TODO MUD SPORT 5
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.POWDER_SNOW)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_SLAP)));
        //TODO ENDURE 14
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_BOMB)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.HAIL)));
        levelUpSkills.put(24, new ArrayList<Integer>(Arrays.asList(SkillFactory.ICE_FANG)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_HIT)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.MIST)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.THRASH)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.EARTHQUAKE)));
        levelUpSkills.put(52, new ArrayList<Integer>(Arrays.asList(SkillFactory.BLIZZARD)));
        levelUpSkills.put(58, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCARY_FACE)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HAIL.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.BLIZZARD.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init mamoswine's gender.
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
