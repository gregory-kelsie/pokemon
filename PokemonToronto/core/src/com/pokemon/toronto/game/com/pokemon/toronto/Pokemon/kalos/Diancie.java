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

public class Diancie extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 719;
    public static final String NAME = "Diancie";
    public static final String TYPE_OF_POKEMON = "Jewel";
    public static final String DESCRIPTION = "When the Kalos region's ecosystem falls into " +
            "disarray, it appears and reveals its secret power.";
    public static final double HEIGHT = 0.7;
    public static final int BASE_EXP = 270;
    public static final int[] EV_YIELD = {0, 0, 1, 0, 2, 0};
    public static final int CAPTURE_RATE = 3;
    public static final double WEIGHT = 8.8;

    public static final Ability FIRST_ABILITY = new Ability.ClearBody();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    public static final int BASE_HEALTH = 50;
    public static final int BASE_ATTACK = 100;
    public static final int BASE_DEFENSE = 150;
    public static final int BASE_SPECIAL_ATTACK = 100;
    public static final int BASE_SPECIAL_DEFENSE = 150;
    public static final int BASE_SPEED = 50;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/diancie.png";
    public static final String BACK_PATH = "battle/backs/kalos/diancie.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/diancie.png";
    public static final String CRY_PATH = "sounds/cry/719.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/diancie.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Pokemon.Type.ROCK;
    public static final Pokemon.Type TYPE_TWO = Type.FAIRY;

    //Exp
    public static final Pokemon.ExpType EXP_TYPE = Pokemon.ExpType.SLOW;

    /**
     * Create a diancie
     */
    public Diancie() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init diancie's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.HARDEN);
        beginnerSkills.add(SkillFactory.ROCK_THROW);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHARPEN)));
        //8 SMACK DOWN
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.REFLECT)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.STEALTH_ROCK)));
        //21 GUARD SPLIT
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.ANCIENT_POWER)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAIL)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.SKILL_SWAP)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.POWER_GEM)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.TRICK_ROOM)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.STONE_EDGE)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.MOONBLAST)));
        //50 DIAMOND STORM
        levelUpSkills.put(60, new ArrayList<Integer>(Arrays.asList(SkillFactory.LIGHT_SCREEN)));
        levelUpSkills.put(70, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAFEGUARD)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.PSYSHOCK.getValue());
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HAIL.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SMACK_DOWN.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.EXPLOSION.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.ROCK_POLISH.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.GYRO_BALL.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.TRICK_ROOM.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.DAZZLING_GLEAM.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }
}
