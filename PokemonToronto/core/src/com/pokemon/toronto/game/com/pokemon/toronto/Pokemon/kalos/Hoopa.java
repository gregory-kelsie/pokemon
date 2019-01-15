package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kalos;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-08-20.
 */

public class Hoopa extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 720;
    public static final String NAME = "Hoopa";
    public static final String TYPE_OF_POKEMON = "Mischief";
    public static final String DESCRIPTION = "It gathers things it likes and pushes them " +
            "through its loop to teleport them to a secret place.";
    public static final double HEIGHT = 0.5;
    public static final int BASE_EXP = 270;
    public static final int[] EV_YIELD = {0, 0, 0, 3, 0, 0};
    public static final int CAPTURE_RATE = 3;
    public static final double WEIGHT = 9;

    public static final Ability FIRST_ABILITY = new Ability.Magician();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    public static final int BASE_HEALTH = 80;
    public static final int BASE_ATTACK = 110;
    public static final int BASE_DEFENSE = 60;
    public static final int BASE_SPECIAL_ATTACK = 150;
    public static final int BASE_SPECIAL_DEFENSE = 130;
    public static final int BASE_SPEED = 70;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/hoopa.png";
    public static final String BACK_PATH = "battle/backs/kalos/hoopa.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/hoopa.png";
    public static final String CRY_PATH = "sounds/cry/720.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/hoopa.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.PSYCHIC;
    public static final Pokemon.Type TYPE_TWO = Type.GHOST;

    //Exp
    public static final Pokemon.ExpType EXP_TYPE = Pokemon.ExpType.SLOW;

    /**
     * Create a hoopa
     */
    public Hoopa() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init hoopa's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //HYPERSPACE HOLE
        //TRICK
        //DESTINY BOND
        //ALLY SWITCH
        beginnerSkills.add(SkillFactory.CONFUSION);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.ASTONISH)));
        //10 MAGIC COAT
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.LIGHT_SCREEN)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYBEAM)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.SKILL_SWAP)));
        //29 POWER SPLIT AND GUARD SPLIT
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.PHANTOM_FORCE)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.ZEN_HEADBUTT)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.TRICK_ROOM)));
        //50 WONDER ROOM
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHADOW_BALL)));
        levelUpSkills.put(68, new ArrayList<Integer>(Arrays.asList(SkillFactory.NASTY_PLOT)));
        levelUpSkills.put(75, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCHIC)));
        //85 HYPERSPACE HOLE
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.PSYSHOCK.getValue());
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.QUASH.getValue());
        tmSkills.add(TmId.EMBARGO.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.TRICK_ROOM.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }
}
