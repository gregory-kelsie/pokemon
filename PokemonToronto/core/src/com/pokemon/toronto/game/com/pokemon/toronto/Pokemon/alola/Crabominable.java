package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alola;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-29.
 */

public class Crabominable extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 740;
    public static final String NAME = "Crabominable";
    public static final String TYPE_OF_POKEMON = "Woolly Crab";
    public static final String DESCRIPTION = "It just throws punches indiscriminately. In times " +
            "of desperation, it can lop off its own pincers and fire them like rockets.";
    public static final double HEIGHT = 1.7;
    public static final int BASE_EXP = 167;
    public static final int[] EV_YIELD = {0, 2, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 60;
    public static final double WEIGHT = 180;

    public static final Ability FIRST_ABILITY = new Ability.HyperCutter();
    public static final Ability SECOND_ABILITY = new Ability.IronFist();
    public static final Ability HIDDEN_ABILITY = new Ability.AngerPoint();

    //Base Stats
    public static final int BASE_HEALTH = 97;
    public static final int BASE_ATTACK = 132;
    public static final int BASE_DEFENSE = 77;
    public static final int BASE_SPECIAL_ATTACK = 62;
    public static final int BASE_SPECIAL_DEFENSE = 67;
    public static final int BASE_SPEED = 43;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/alola/crabominable.png";
    public static final String BACK_PATH = "battle/backs/alola/crabominable.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/alola/crabominable.png";
    public static final String CRY_PATH = "sounds/cry/740.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/alola/crabominable.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.FIGHTING;
    public static final Type TYPE_TWO = Type.ICE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a crabominable
     */
    public Crabominable() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init crabominable's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.BUBBLE);
        beginnerSkills.add(SkillFactory.ROCK_SMASH);
        beginnerSkills.add(SkillFactory.LEER);
        beginnerSkills.add(SkillFactory.PURSUIT);
        beginnerSkills.add(SkillFactory.BUBBLE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_SMASH)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEER)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.PURSUIT)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUBBLEBEAM)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.POWER_UP_PUNCH)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.DIZZY_PUNCH)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.AVALANCHE)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.REVERSAL)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.ICE_HAMMER)));
        levelUpSkills.put(42, new ArrayList<Integer>(Arrays.asList(SkillFactory.IRON_DEFENSE)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.DYNAMIC_PUNCH)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.CLOSE_COMBAT)));
        initEvolutionSkills();
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HAIL.getValue());
        tmSkills.add(TmId.BULK_UP.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.BLIZZARD.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.SCALD.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.BRUTAL_SWING.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.FROST_BREATH.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }


    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.ICE_PUNCH);
    }

    /**
     * Init crabominable's gender.
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
