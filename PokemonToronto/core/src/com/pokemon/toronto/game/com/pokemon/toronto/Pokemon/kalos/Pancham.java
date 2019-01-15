package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kalos;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-02-02.
 */

public class Pancham extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 674;
    public static final String NAME = "Pancham";
    public static final String TYPE_OF_POKEMON = "Playful";
    public static final String DESCRIPTION = "It does its level best to glare and pull a scary" +
            " face, but it can't help grinning if anyone pats its head.";
    public static final double HEIGHT = 0.6;
    public static final int BASE_EXP = 70;
    public static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 220;
    public static final double WEIGHT = 8;

    public static final Ability FIRST_ABILITY = new Ability.IronFist();
    public static final Ability SECOND_ABILITY = new Ability.MoldBreaker();
    public static final Ability HIDDEN_ABILITY = new Ability.Scrappy();

    //Base Stats
    public static final int BASE_HEALTH = 67;
    public static final int BASE_ATTACK = 82;
    public static final int BASE_DEFENSE = 62;
    public static final int BASE_SPECIAL_ATTACK = 46;
    public static final int BASE_SPECIAL_DEFENSE = 48;
    public static final int BASE_SPEED = 43;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/pancham.png";
    public static final String BACK_PATH = "battle/backs/kalos/pancham.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/pancham.png";
    public static final String CRY_PATH = "sounds/cry/674.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/pancham.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.FIGHTING;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a pancham
     */
    public Pancham() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init pancham's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.LEER);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.ARM_THRUST)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.WORK_UP)));
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.KARATE_CHOP)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.COMET_PUNCH)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLASH)));
        //25 CIRCLE THROW
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.VITAL_THROW)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.BODY_SLAM)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        //42 ENTERTAINMENT
        //45 PARTING SHOT
        levelUpSkills.put(48, new ArrayList<Integer>(Arrays.asList(SkillFactory.SKY_UPPERCUT)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.BULK_UP.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SLUDGE_BOMB.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.LOW_SWEEP.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.FALSE_SWIPE.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SURF.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init pancham's gender.
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
     * Return Pangoro if the pancham is above level 32.
     * @return Pangoro if pancham is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 32) {
            return PokemonId.PANGORO.getValue();
        }
        return -1;
    }
}
