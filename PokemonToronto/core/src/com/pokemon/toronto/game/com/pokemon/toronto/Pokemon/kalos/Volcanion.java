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

public class Volcanion extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 721;
    public static final String NAME = "Volcanion";
    public static final String TYPE_OF_POKEMON = "Steam";
    public static final String DESCRIPTION = "It expels its internal steam from the arms on " +
            "its back. It has enough power to blow away a mountain.";
    public static final double HEIGHT = 1.7;
    public static final int BASE_EXP = 270;
    public static final int[] EV_YIELD = {0, 0, 0, 3, 0, 0};
    public static final int CAPTURE_RATE = 3;
    public static final double WEIGHT = 195;

    public static final Ability FIRST_ABILITY = new Ability.WaterAbsorb();
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
    public static final String ICON_PATH = "pokemonSprites/kalos/volcanion.png";
    public static final String BACK_PATH = "battle/backs/kalos/volcanion.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/volcanion.png";
    public static final String CRY_PATH = "sounds/cry/721.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/volcanion.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.FIRE;
    public static final Pokemon.Type TYPE_TWO = Type.WATER;

    //Exp
    public static final Pokemon.ExpType EXP_TYPE = Pokemon.ExpType.SLOW;

    /**
     * Create a volcanion
     */
    public Volcanion() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init volcanion's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //STEAM ERUPTION
        beginnerSkills.add(SkillFactory.FLARE_BLITZ);
        beginnerSkills.add(SkillFactory.TAKE_DOWN);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.MIST)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.HAZE)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAME_CHARGE)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_PULSE)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.STOMP)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCALD)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.WEATHER_BALL)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.BODY_SLAM)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYDRO_PUMP)));
        levelUpSkills.put(58, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLARE_BLITZ)));
        levelUpSkills.put(65, new ArrayList<Integer>(Arrays.asList(SkillFactory.OVERHEAT)));
        levelUpSkills.put(76, new ArrayList<Integer>(Arrays.asList(SkillFactory.EXPLOSION)));
        //85 STEAM ERUPTION
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.SMACK_DOWN.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SLUDGE_WAVE.getValue());
        tmSkills.add(TmId.FLAMETHROWER.getValue());
        tmSkills.add(TmId.SLUDGE_BOMB.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.FIRE_BLAST.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.FLAME_CHARGE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.OVERHEAT.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.SCALD.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.WILL_O_WISP.getValue());
        tmSkills.add(TmId.EXPLOSION.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.GYRO_BALL.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.FLASH_CANNON.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }
}
