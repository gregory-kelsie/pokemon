package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alola;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-29.
 */

public class Rowlet extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 722;
    public static final String NAME = "Rowlet";
    public static final String TYPE_OF_POKEMON = "Grass Quill";
    public static final String DESCRIPTION = "This wary Pokémon uses photosynthesis to store " +
            "up energy during the day, while becoming active at night.";
    public static final double HEIGHT = 0.3;
    public static final int BASE_EXP = 64;
    public static final int[] EV_YIELD = {1, 0, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 1.5;

    public static final Ability FIRST_ABILITY = new Ability.Overgrow();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.LongReach();

    //Base Stats
    public static final int BASE_HEALTH = 68;
    public static final int BASE_ATTACK = 55;
    public static final int BASE_DEFENSE = 55;
    public static final int BASE_SPECIAL_ATTACK = 50;
    public static final int BASE_SPECIAL_DEFENSE = 50;
    public static final int BASE_SPEED = 42;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/alola/rowlet.png";
    public static final String BACK_PATH = "battle/backs/alola/rowlet.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/alola/rowlet.png";
    public static final String CRY_PATH = "sounds/cry/722.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/alola/rowlet.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GRASS;
    public static final Type TYPE_TWO = Type.FLYING;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a rowlet
     */
    public Rowlet() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init rowlet's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.LEAFAGE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWL)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.PECK)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.ASTONISH)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAZOR_LEAF)));
        //18 foresight
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.PLUCK)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.SYNTHESIS)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_ATTACK)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUCKER_PUNCH)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEAF_BLADE)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEATHER_DANCE)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.BRAVE_BIRD)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.NASTY_PLOT)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.ROOST.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.STEEL_WING.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.FALSE_SWIPE.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init rowlet's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .881) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }

    /**
     * Return Dartrix if the rowlet is above level 17.
     * @return Dartrix if rowlet is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 17) {
            return PokemonId.DARTRIX.getValue();
        }
        return -1;
    }
}
