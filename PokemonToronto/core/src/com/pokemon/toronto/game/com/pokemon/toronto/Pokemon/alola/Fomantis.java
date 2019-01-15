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

public class Fomantis extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 753;
    public static final String NAME = "Fomantis";
    public static final String TYPE_OF_POKEMON = "Sickle Grass";
    public static final String DESCRIPTION = "During the day, it sleeps and soaks up light. " +
            "When night falls, it walks around looking for a safer place to sleep.";
    public static final double HEIGHT = 0.3;
    public static final int BASE_EXP = 50;
    public static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 190;
    public static final double WEIGHT = 1.5;

    public static final Ability FIRST_ABILITY = new Ability.LeafGuard();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.Contrary();

    //Base Stats
    public static final int BASE_HEALTH = 40;
    public static final int BASE_ATTACK = 55;
    public static final int BASE_DEFENSE = 35;
    public static final int BASE_SPECIAL_ATTACK = 50;
    public static final int BASE_SPECIAL_DEFENSE = 35;
    public static final int BASE_SPEED = 35;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/alola/fomantis.png";
    public static final String BACK_PATH = "battle/backs/alola/fomantis.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/alola/fomantis.png";
    public static final String CRY_PATH = "sounds/cry/753.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/alola/fomantis.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GRASS;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a fomantis
     */
    public Fomantis() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init fomantis's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.FURY_CUTTER);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEAFAGE)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAZOR_LEAF)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWTH)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.INGRAIN)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEAF_BLADE)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.SYNTHESIS)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLASH)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWEET_SCENT)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.SOLAR_BEAM)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUNNY_DAY)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.LEECH_LIFE.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.FALSE_SWIPE.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.X_SCISSOR.getValue());
        tmSkills.add(TmId.POISON_JAB.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init fomantis's gender.
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
     * Return Lurantis if the fomantis is above level 34.
     * @return Lurantis if fomantis is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 34) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            Date date = new Date();
            String text = dateFormat.format(date);
            int hourTime = new Integer(text.substring(11, 13));
            if (hourTime >= 6 && hourTime <= 17) {
                return PokemonId.LURANTIS.getValue();
            }
        }
        return -1;
    }
}
