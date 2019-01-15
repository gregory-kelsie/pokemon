package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.unova;

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

public class Meloetta extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 648;
    public static final String NAME = "Meloetta";
    public static final String TYPE_OF_POKEMON = "Melody";
    public static final String DESCRIPTION = "Its melodies are sung with a special vocalization" +
            " method that can control the feelings of those who hear it.";
    public static final double HEIGHT = 0.6;
    public static final int BASE_EXP = 270;
    public static final int[] EV_YIELD = {0, 0, 0, 1, 1, 1};
    public static final int CAPTURE_RATE = 3;
    public static final double WEIGHT = 6.5;

    public static final Ability FIRST_ABILITY = new Ability.SereneGrace();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    public static final int BASE_HEALTH = 100;
    public static final int BASE_ATTACK = 77;
    public static final int BASE_DEFENSE = 77;
    public static final int BASE_SPECIAL_ATTACK = 128;
    public static final int BASE_SPECIAL_DEFENSE = 128;
    public static final int BASE_SPEED = 90;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/meloetta.png";
    public static final String BACK_PATH = "battle/backs/unova/meloetta.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/meloetta.png";
    public static final String CRY_PATH = "sounds/cry/648.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/meloetta.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    public static final Type TYPE_TWO = Type.PSYCHIC;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    /**
     * Create a meloetta
     */
    public Meloetta() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init meloetta's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.ROUND);
        beginnerSkills.add(SkillFactory.QUICK_ATTACK);
        beginnerSkills.add(SkillFactory.CONFUSION);
        beginnerSkills.add(SkillFactory.SING);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.CONFUSION)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.SING)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.TEETER_DANCE)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.ACROBATICS)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYBEAM)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.ECHOED_VOICE)));
        //43 U-TURN
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.WAKE_UP_SLAP)));
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCHIC)));
        levelUpSkills.put(64, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPER_VOICE)));
        levelUpSkills.put(71, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROLE_PLAY)));
        levelUpSkills.put(78, new ArrayList<Integer>(Arrays.asList(SkillFactory.CLOSE_COMBAT)));
        levelUpSkills.put(85, new ArrayList<Integer>(Arrays.asList(SkillFactory.PERISH_SONG)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.PSYSHOCK.getValue());
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.LOW_SWEEP.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.ACROBATICS.getValue());
        tmSkills.add(TmId.EMBARGO.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.TRICK_ROOM.getValue());
        tmSkills.add(TmId.DAZZLING_GLEAM.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }
}
