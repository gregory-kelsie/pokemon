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
 * Created by gregorykelsie on 2018-05-04.
 */

public class Blitzle extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 522;
    public static final String NAME = "Blitzle";
    public static final String TYPE_OF_POKEMON = "Electrified";
    public static final String DESCRIPTION = "Its mane shines when it discharges electricity. " +
            "They use their flashing manes to communicate with one another.";
    public static final double HEIGHT = 0.8;
    public static final int BASE_EXP = 59;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    public static final int CAPTURE_RATE = 190;
    public static final double WEIGHT = 29.8;

    public static final Ability FIRST_ABILITY = new Ability.Lightningrod();
    public static final Ability SECOND_ABILITY = new Ability.MotorDrive();
    public static final Ability HIDDEN_ABILITY = new Ability.SapSipper();

    //Base Stats
    public static final int BASE_HEALTH = 45;
    public static final int BASE_ATTACK = 60;
    public static final int BASE_DEFENSE = 32;
    public static final int BASE_SPECIAL_ATTACK = 50;
    public static final int BASE_SPECIAL_DEFENSE = 32;
    public static final int BASE_SPEED = 76;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/blitzle.png";
    public static final String BACK_PATH = "battle/backs/unova/blitzle.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/blitzle.png";
    public static final String CRY_PATH = "sounds/cry/522.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/blitzle.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.ELECTRIC;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a blitzle
     */
    public Blitzle() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init blitzle's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.QUICK_ATTACK);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAIL_WHIP)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARGE)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHOCK_WAVE)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDER_WAVE)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAME_CHARGE)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.PURSUIT)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.SPARK)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.STOMP)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.DISCHARGE)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.AGILITY)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.WILD_CHARGE)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.THRASH)));
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
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.FLAME_CHARGE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.VOLT_SWITCH.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.WILD_CHARGE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init blitzle's gender.
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
     * Return Zebstrika if the blitzle is above level 27.
     * @return Zebstrika if blitzle is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 27) {
            return PokemonId.ZEBSTRIKA.getValue();
        }
        return -1;
    }
}
