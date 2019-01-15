package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.unova;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-05-07.
 */

public class Emolga extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 587;
    public static final String NAME = "Emolga";
    public static final String TYPE_OF_POKEMON = "Sky Squirrel";
    public static final String DESCRIPTION = "The energy made in its cheeks' electric pouches " +
            "is stored inside its membrane and released while it is gliding.";
    public static final double HEIGHT = 0.4;
    public static final int BASE_EXP = 150;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 2};
    public static final int CAPTURE_RATE = 200;
    public static final double WEIGHT = 5;

    public static final Ability FIRST_ABILITY = new Ability.Static();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.MotorDrive();

    //Base Stats
    public static final int BASE_HEALTH = 55;
    public static final int BASE_ATTACK = 75;
    public static final int BASE_DEFENSE = 60;
    public static final int BASE_SPECIAL_ATTACK = 75;
    public static final int BASE_SPECIAL_DEFENSE = 60;
    public static final int BASE_SPEED = 103;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/emolga.png";
    public static final String BACK_PATH = "battle/backs/unova/emolga.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/emolga.png";
    public static final String CRY_PATH = "sounds/cry/587.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/emolga.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.ELECTRIC;
    public static final Type TYPE_TWO = Type.FLYING;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a emolga
     */
    public Emolga() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init emolga's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.THUNDER_SHOCK);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAIL_WHIP)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARGE)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.SPARK)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.NUZZLE)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.PURSUIT)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_TEAM)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHOCK_WAVE)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.ELECTRO_BALL)));
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.ACROBATICS)));
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.LIGHT_SCREEN)));
        //38 ENCORE
        //42 VOLT SWITCH
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.AGILITY)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.DISCHARGE)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.ROOST.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.ACROBATICS.getValue());
        tmSkills.add(TmId.VOLT_SWITCH.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.WILD_CHARGE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init emolga's gender.
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
