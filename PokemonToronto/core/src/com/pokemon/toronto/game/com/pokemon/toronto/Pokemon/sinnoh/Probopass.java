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

public class Probopass extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 476;
    public static final String NAME = "Probopass";
    public static final String TYPE_OF_POKEMON = "Compass";
    public static final String DESCRIPTION = "It freely controls three units called Mini-Noses" +
            " using magnetic force.";
    public static final double HEIGHT = 1.4;
    public static final int BASE_EXP = 184;
    public static final int[] EV_YIELD = {0, 0, 1, 0, 2, 0};
    public static final int CAPTURE_RATE = 60;
    public static final double WEIGHT = 340;

    public static final Ability FIRST_ABILITY = new Ability.Sturdy();
    public static final Ability SECOND_ABILITY = new Ability.MagnetPull();
    public static final Ability HIDDEN_ABILITY = new Ability.SandForce();

    //Base Stats
    public static final int BASE_HEALTH = 60;
    public static final int BASE_ATTACK = 55;
    public static final int BASE_DEFENSE = 145;
    public static final int BASE_SPECIAL_ATTACK = 75;
    public static final int BASE_SPECIAL_DEFENSE = 150;
    public static final int BASE_SPEED = 40;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/probopass.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/probopass.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/probopass.png";
    public static final String CRY_PATH = "sounds/cry/476.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/probopass.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.ROCK;
    public static final Type TYPE_TWO = Type.STEEL;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a probopass
     */
    public Probopass() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init probopass's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //MAGNETIC FLUX
        //MAGNET RISE
        //GRAVITY
        //WIDE GUARD
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.IRON_DEFENSE);
        //BLOCK
        beginnerSkills.add(SkillFactory.MAGNET_BOMB);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.IRON_DEFENSE)));
        //7 BLOCK
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.MAGNET_BOMB)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDER_WAVE)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.REST)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.SPARK)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_SLIDE)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.POWER_GEM)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_BLAST)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.DISCHARGE)));
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.SANDSTORM)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.EARTH_POWER)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.STONE_EDGE)));
        List<Integer> thirteen = new ArrayList<Integer>();
        thirteen.add(SkillFactory.LOCK_ON);
        thirteen.add(SkillFactory.ZAP_CANNON);
        levelUpSkills.put(43, thirteen);
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.TRI_ATTACK);
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SMACK_DOWN.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.EXPLOSION.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.ROCK_POLISH.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.VOLT_SWITCH.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.FLASH_CANNON.getValue());
        tmSkills.add(TmId.DAZZLING_GLEAM.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init probopass's gender.
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
