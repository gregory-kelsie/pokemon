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
 * Created by gregorykelsie on 2018-01-30.
 */

public class Minior extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 774;
    public static final String NAME = "Minior";
    public static final String TYPE_OF_POKEMON = "Meteor";
    public static final String DESCRIPTION = "Originally making its home in the ozone layer, " +
            "it hurtles to the ground when the shell enclosing its body grows too heavy.";
    public static final double HEIGHT = 0.3;
    public static final int BASE_EXP = 154;
    public static final int[] EV_YIELD = {0, 0, 1, 0, 1, 0};
    public static final int CAPTURE_RATE = 30;
    public static final double WEIGHT = 40;

    public static final Ability FIRST_ABILITY = new Ability.ShieldsDown();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    public static final int BASE_HEALTH = 60;
    public static final int BASE_ATTACK = 60;
    public static final int BASE_DEFENSE = 100;
    public static final int BASE_SPECIAL_ATTACK = 60;
    public static final int BASE_SPECIAL_DEFENSE = 100;
    public static final int BASE_SPEED = 60;

    //Core Form Base Stats
    private final int[] CORE_BASE_STATS = {60, 100, 60, 100, 60, 120};

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/alola/minior.png";
    public static final String BACK_PATH = "battle/backs/alola/minior.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/alola/minior.png";
    public static final String CRY_PATH = "sounds/cry/774.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/alola/minior.png";

    //Core Paths
    private final String CORE_ICON_PATH = "pokemonSprites/alola/minior.png";
    private final String CORE_BACK_PATH = "battle/backs/alola/minior.png";
    private final String CORE_MINI_PATH = "pokemonMenu/sprites/alola/minior.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.ROCK;
    public static final Type TYPE_TWO = Type.FLYING;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a minior
     */
    public Minior() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Return the Pokemon's base attack stat.
     * @return Base Attack
     */
    @Override
    public int getBaseStatAttack() {
        if (currentHealth < getHealthStat() * 0.5) {
            return CORE_BASE_STATS[ATTACK];
        }
        return baseStats[ATTACK];
    }

    /**
     * Return the Pokemon's base special attack
     * @return Base Special Attack
     */
    @Override
    public int getBaseStatSpeicialAttack() {
        if (currentHealth < getHealthStat() * 0.5) {
            return CORE_BASE_STATS[SPECIAL_ATTACK];
        }
        return baseStats[SPECIAL_ATTACK];
    }

    /**
     * Return the Pokemon's base defense.
     * @return Base Defense
     */
    @Override
    public int getBaseStatDefense() {
        if (currentHealth < getHealthStat() * 0.5) {
            return CORE_BASE_STATS[DEFENSE];
        }
        return baseStats[DEFENSE];
    }

    /**
     * Return the Pokemon's base special defense.
     * @return Base Special Defense
     */
    @Override
    public int getBaseStatSpecialDefense() {
        if (currentHealth < getHealthStat() * 0.5) {
            return CORE_BASE_STATS[SPECIAL_DEFENSE];
        }
        return baseStats[SPECIAL_DEFENSE];
    }

    /**
     * Return the Pokemon's base speed.
     * @return Base Speed
     */
    @Override
    public int getBaseStatSpeed() {
        if (currentHealth < getHealthStat() * 0.5) {
            return CORE_BASE_STATS[SPEED];
        }
        return baseStats[SPEED];
    }

    /**
     * Return the Pokemon's Front Image path
     * @return The path for the Pokemon's front image.
     */
    @Override
    public String getMapIconPath() {
        try {
            if (currentHealth < getHealthStat() * 0.5) {
                return CORE_ICON_PATH;
            }
            return mapIconPath;
        } catch (Exception e) {
            return mapIconPath;
        }
    }

    /**
     * Return the Pokemon's Back Image Path
     * @return The path for the Pokemon's back image.
     */
    @Override
    public String getBackPath() {
        try {
            if (currentHealth < getHealthStat() * 0.5) {
                return CORE_BACK_PATH;
            }
            return backPath;
        } catch (Exception e) {
            return backPath;
        }
    }

    /**
     * Return the Pokemon's mini image path.
     * @return The path for the Pokemon's mini image.
     */
    @Override
    public String getMiniIconPath() {
        try {
            if (currentHealth < getHealthStat() * 0.5) {
                return CORE_MINI_PATH;
            }
            return miniPath;
        } catch (Exception e) {
            return miniPath;
        }
    }

    /**
     * Init minior's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.DEFENSE_CURL)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROLLOUT)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.CONFUSE_RAY)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWIFT)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.ANCIENT_POWER)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.SELF_DESTRUCT)));
        levelUpSkills.put(24, new ArrayList<Integer>(Arrays.asList(SkillFactory.STEALTH_ROCK)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.AUTOTOMIZE)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.COSMIC_POWER)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.POWER_GEM)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHELL_SMASH)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.EXPLOSION)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.ACROBATICS.getValue());
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
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.DAZZLING_GLEAM.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init minior's gender.
     */
    @Override
    protected void initGender() {
        gender = 'U';

    }

    /**
     * Return Bewear if the minior is above level 27.
     * @return Bewear if minior is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 27) {
            return PokemonId.BEWEAR.getValue();
        }
        return -1;
    }
}
