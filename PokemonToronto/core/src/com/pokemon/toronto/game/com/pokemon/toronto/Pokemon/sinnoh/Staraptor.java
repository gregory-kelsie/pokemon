package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-04-23.
 */

public class Staraptor extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 398;
    public static final String NAME = "Staraptor";
    public static final String TYPE_OF_POKEMON = "Predator";
    public static final String DESCRIPTION = "It never stops attacking even if it is injured." +
            " It fusses over the shape of its comb.";
    public static final double HEIGHT = 1.2;
    public static final int BASE_EXP = 218;
    public static final int[] EV_YIELD = {0, 3, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 24.9;

    public static final Ability FIRST_ABILITY = new Ability.Intimidate();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.Reckless();

    //Base Stats
    public static final int BASE_HEALTH = 85;
    public static final int BASE_ATTACK = 120;
    public static final int BASE_DEFENSE = 70;
    public static final int BASE_SPECIAL_ATTACK = 50;
    public static final int BASE_SPECIAL_DEFENSE = 60;
    public static final int BASE_SPEED = 100;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/staraptor.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/staraptor.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/staraptor.png";
    public static final String CRY_PATH = "sounds/cry/398.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/staraptor.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    public static final Type TYPE_TWO = Type.FLYING;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a staraptor
     */
    public Staraptor() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init staraptor's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.GROWL);
        beginnerSkills.add(SkillFactory.QUICK_ATTACK);
        beginnerSkills.add(SkillFactory.WING_ATTACK);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.WING_ATTACK)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_TEAM)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.ENDEAVOR)));
        //23 WHIRLWIND
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.AERIAL_ACE)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.AGILITY)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.BRAVE_BIRD)));
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.FINAL_GAMBIT)));
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.CLOSE_COMBAT);
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
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
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.FLY.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init staraptor's gender.
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
