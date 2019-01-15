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

public class Regigigas extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 486;
    public static final String NAME = "Regigigas";
    public static final String TYPE_OF_POKEMON = "Colossal";
    public static final String DESCRIPTION = "It is said to have made Pokémon that look like " +
            "itself from a special ice mountain, rocks, and magma.";
    public static final int BASE_EXP = 302;
    public static final int[] EV_YIELD = {0, 3, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 3;
    public static final double WEIGHT = 420;
    public static final double HEIGHT = 3.7;

    public static final Ability FIRST_ABILITY = new Ability.SlowStart();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    public static final int BASE_HEALTH = 110;
    public static final int BASE_ATTACK = 160;
    public static final int BASE_DEFENSE = 110;
    public static final int BASE_SPECIAL_ATTACK = 80;
    public static final int BASE_SPECIAL_DEFENSE = 110;
    public static final int BASE_SPEED = 100;

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/regigigas.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/regigigas.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/regigigas.png";
    public static final String CRY_PATH = "sounds/cry/486.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/regigigas.png";

    /**
     * Create a regigigas
     */
    public Regigigas() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init regigigas's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.HEAVY_SLAM);
        beginnerSkills.add(SkillFactory.CRUSH_GRIP);
        beginnerSkills.add(SkillFactory.FIRE_PUNCH);
        beginnerSkills.add(SkillFactory.ICE_PUNCH);
        beginnerSkills.add(SkillFactory.THUNDER_PUNCH);
        beginnerSkills.add(SkillFactory.DIZZY_PUNCH);
        beginnerSkills.add(SkillFactory.KNOCK_OFF);
        beginnerSkills.add(SkillFactory.CONFUSE_RAY);
        //FORESIGHT
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.REVENGE)));
        //40 WIDE GUARD
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.ZEN_HEADBUTT)));
        levelUpSkills.put(65, new ArrayList<Integer>(Arrays.asList(SkillFactory.PAYBACK)));
        levelUpSkills.put(75, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUSH_GRIP)));
        levelUpSkills.put(90, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEAVY_SLAM)));
        levelUpSkills.put(100, new ArrayList<Integer>(Arrays.asList(SkillFactory.GIGA_IMPACT)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SMACK_DOWN.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.ROCK_POLISH.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }
}
