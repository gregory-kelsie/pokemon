package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-04-25.
 */

public class Glameow extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 431;
    public static final String NAME = "Glameow";
    public static final String TYPE_OF_POKEMON = "Catty";
    public static final String DESCRIPTION = "It hides its spiteful tendency of hooking its " +
            "claws into the nose of its Trainer if it isn't fed.";
    public static final double HEIGHT = 0.5;
    public static final int BASE_EXP = 62;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    public static final int CAPTURE_RATE = 190;
    public static final double WEIGHT = 3.9;

    public static final Ability FIRST_ABILITY = new Ability.Limber();
    public static final Ability SECOND_ABILITY = new Ability.OwnTempo();
    public static final Ability HIDDEN_ABILITY = new Ability.KeenEye();

    //Base Stats
    public static final int BASE_HEALTH = 49;
    public static final int BASE_ATTACK = 55;
    public static final int BASE_DEFENSE = 42;
    public static final int BASE_SPECIAL_ATTACK = 42;
    public static final int BASE_SPECIAL_DEFENSE = 37;
    public static final int BASE_SPEED = 85;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/glameow.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/glameow.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/glameow.png";
    public static final String CRY_PATH = "sounds/cry/431.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/glameow.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.FAST;

    /**
     * Create a glameow
     */
    public Glameow() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init glameow's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.FAKE_OUT);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCRATCH)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWL)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPNOSIS)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT_ATTACK)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_SWIPES)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARM)));
        //29 ASSIST
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.CAPTIVATE)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLASH)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUCKER_PUNCH)));
        //44 ATTRACT
        levelUpSkills.put(48, new ArrayList<Integer>(Arrays.asList(SkillFactory.HONE_CLAWS)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.PLAY_ROUGH)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.TOXIC.getValue());;
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init glameow's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .246) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }

    /**
     * Return Purugly if the glameow is above level 38.
     * @return Purugly if glameow is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 38) {
            return PokemonId.PURUGLY.getValue();
        }
        return -1;
    }
}
