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
 * Created by gregorykelsie on 2018-04-23.
 */

public class Starly extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 396;
    public static final String NAME = "Starly";
    public static final String TYPE_OF_POKEMON = "Starling";
    public static final String DESCRIPTION = "Because they are weak individually, they form " +
            "groups. However, they bicker if the group grows too big.";
    public static final double HEIGHT = 0.3;
    public static final int BASE_EXP = 49;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    public static final int CAPTURE_RATE = 255;
    public static final double WEIGHT = 2;

    public static final Ability FIRST_ABILITY = new Ability.KeenEye();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.Reckless();

    //Base Stats
    public static final int BASE_HEALTH = 40;
    public static final int BASE_ATTACK = 55;
    public static final int BASE_DEFENSE = 30;
    public static final int BASE_SPECIAL_ATTACK = 30;
    public static final int BASE_SPECIAL_DEFENSE = 30;
    public static final int BASE_SPEED = 60;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/starly.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/starly.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/starly.png";
    public static final String CRY_PATH = "sounds/cry/396.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/starly.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    public static final Type TYPE_TWO = Type.FLYING;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a starly
     */
    public Starly() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init starly's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.GROWL);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.WING_ATTACK)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_TEAM)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.ENDEAVOR)));
        //21 WHIRLWIND
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.AERIAL_ACE)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.AGILITY)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.BRAVE_BIRD)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.FINAL_GAMBIT)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.ROOST.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.STEEL_WING.getValue());
        tmSkills.add(TmId.FLY.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init starly's gender.
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
     * Return Staravia if the starly is above level 14.
     * @return Staravia if starly is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 14) {
            return PokemonId.STARAVIA.getValue();
        }
        return -1;
    }
}
