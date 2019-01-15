package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alola;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-30.
 */

public class Morelull extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 755;
    public static final String NAME = "Morelull";
    public static final String TYPE_OF_POKEMON = "Illuminating";
    public static final String DESCRIPTION = "It scatters spores that flicker and glow. Anyone " +
            "seeing these lights falls into a deep slumber.";
    public static final double HEIGHT = 0.2;
    public static final int BASE_EXP = 57;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 1, 0};
    public static final int CAPTURE_RATE = 190;
    public static final double WEIGHT = 1.5;

    public static final Ability FIRST_ABILITY = new Ability.Illuminate();
    public static final Ability SECOND_ABILITY = new Ability.EffectSpore();
    public static final Ability HIDDEN_ABILITY = new Ability.RainDish();

    //Base Stats
    public static final int BASE_HEALTH = 40;
    public static final int BASE_ATTACK = 35;
    public static final int BASE_DEFENSE = 55;
    public static final int BASE_SPECIAL_ATTACK = 65;
    public static final int BASE_SPECIAL_DEFENSE = 75;
    public static final int BASE_SPEED = 15;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/alola/morelull.png";
    public static final String BACK_PATH = "battle/backs/alola/morelull.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/alola/morelull.png";
    public static final String CRY_PATH = "sounds/cry/755.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/alola/morelull.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GRASS;
    public static final Type TYPE_TWO = Type.FAIRY;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a morelull
     */
    public Morelull() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init morelull's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.ABSORB);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.ASTONISH)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLASH)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.MOONLIGHT)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEGA_DRAIN)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLEEP_POWDER)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.INGRAIN)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.CONFUSE_RAY)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.GIGA_DRAIN)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.STRENGTH_SAP)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.SPORE)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.MOONBLAST)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.DREAM_EATER)));
        //46 SPOTLIGHT
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SLUDGE_BOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.DAZZLING_GLEAM.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init morelull's gender.
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
     * Return Shiinotic if the morelull is above level 34.
     * @return Shiinotic if morelull is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 24) {
            return PokemonId.SHIINOTIC.getValue();
        }
        return -1;
    }
}
