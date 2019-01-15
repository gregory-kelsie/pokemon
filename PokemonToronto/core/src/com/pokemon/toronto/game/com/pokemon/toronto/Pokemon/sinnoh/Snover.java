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
 * Created by gregorykelsie on 2018-04-29.
 */

public class Snover extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 459;
    public static final String NAME = "Snover";
    public static final String TYPE_OF_POKEMON = "Frosted Tree";
    public static final String DESCRIPTION = "Seemingly curious about people, they gather around" +
            " footsteps they find on snowy mountains.";
    public static final double HEIGHT = 1;
    public static final int BASE_EXP = 67;
    public static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 120;
    public static final double WEIGHT = 50.5;

    public static final Ability FIRST_ABILITY = new Ability.SnowWarning();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.Soundproof();

    //Base Stats
    public static final int BASE_HEALTH = 60;
    public static final int BASE_ATTACK = 62;
    public static final int BASE_DEFENSE = 50;
    public static final int BASE_SPECIAL_ATTACK = 62;
    public static final int BASE_SPECIAL_DEFENSE = 60;
    public static final int BASE_SPEED = 40;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/snover.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/snover.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/snover.png";
    public static final String CRY_PATH = "sounds/cry/459.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/snover.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GRASS;
    public static final Type TYPE_TWO = Type.ICE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    /**
     * Create a snover
     */
    public Snover() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init snover's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.POWDER_SNOW);
        beginnerSkills.add(SkillFactory.LEER);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAZOR_LEAF)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.ICY_WIND)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.GRASS_WHISTLE)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWAGGER)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.MIST)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.ICE_SHARD)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.INGRAIN)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.WOOD_HAMMER)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.BLIZZARD)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHEER_COLD)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HAIL.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.BLIZZARD.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.FROST_BREATH.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init snover's gender.
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
     * Return Abomasnow if the snover is above level 40.
     * @return Abomasnow if snover is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 40) {
            return PokemonId.ABOMASNOW.getValue();
        }
        return -1;
    }
}
