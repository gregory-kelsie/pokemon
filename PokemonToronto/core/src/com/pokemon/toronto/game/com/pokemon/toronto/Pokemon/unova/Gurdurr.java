package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.unova;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-05-05.
 */

public class Gurdurr extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 533;
    public static final String NAME = "Gurdurr";
    public static final String TYPE_OF_POKEMON = "Muscular";
    public static final String DESCRIPTION = "This Pokémon is so muscular and strongly built " +
            "that even a group of wrestlers could not make it budge an inch.";
    public static final double HEIGHT = 1.2;
    public static final int BASE_EXP = 142;
    public static final int[] EV_YIELD = {0, 2, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 90;
    public static final double WEIGHT = 40;

    public static final Ability FIRST_ABILITY = new Ability.Guts();
    public static final Ability SECOND_ABILITY = new Ability.SheerForce();
    public static final Ability HIDDEN_ABILITY = new Ability.IronFist();

    //Base Stats
    public static final int BASE_HEALTH = 85;
    public static final int BASE_ATTACK = 105;
    public static final int BASE_DEFENSE = 85;
    public static final int BASE_SPECIAL_ATTACK = 40;
    public static final int BASE_SPECIAL_DEFENSE = 50;
    public static final int BASE_SPEED = 40;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/gurdurr.png";
    public static final String BACK_PATH = "battle/backs/unova/gurdurr.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/gurdurr.png";
    public static final String CRY_PATH = "sounds/cry/533.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/gurdurr.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.FIGHTING;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a gurdurr
     */
    public Gurdurr() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init gurdurr's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.POUND);
        beginnerSkills.add(SkillFactory.LEER);
        beginnerSkills.add(SkillFactory.FOCUS_ENERGY);
        //BIDE
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.FOCUS_ENERGY)));
        //8 BIDE
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.LOW_KICK)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_THROW)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.WAKE_UP_SLAP)));
        levelUpSkills.put(24, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHIP_AWAY)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.BULK_UP)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_SLIDE)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.DYNAMIC_PUNCH)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCARY_FACE)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.HAMMER_ARM)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.STONE_EDGE)));
        //53 FOCUS PUNCH
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUPERPOWER)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.BULK_UP.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SMACK_DOWN.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.LOW_SWEEP.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.BRUTAL_SWING.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.POISON_JAB.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init gurdurr's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .754) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }

    /**
     * Return Conkeldurr if the gurdurr is above level 40.
     * @return Conkeldurr if gurdurr is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 40) {
            return PokemonId.CONKELDURR.getValue();
        }
        return -1;
    }
}
