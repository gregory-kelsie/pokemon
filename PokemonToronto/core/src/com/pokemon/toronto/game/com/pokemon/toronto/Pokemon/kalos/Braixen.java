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

public class Braixen extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 654;
    public static final String NAME = "Braixen";
    public static final String TYPE_OF_POKEMON = "Fox";
    public static final String DESCRIPTION = "It has a twig stuck in its tail. With friction " +
            "from its tail fur, it sets the twig on fire and launches into battle.";
    public static final double HEIGHT = 1;
    public static final int BASE_EXP = 143;
    public static final int[] EV_YIELD = {0, 0, 0, 2, 0, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 14.5;

    public static final Ability FIRST_ABILITY = new Ability.Blaze();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.Magician();

    //Base Stats
    public static final int BASE_HEALTH = 59;
    public static final int BASE_ATTACK = 59;
    public static final int BASE_DEFENSE = 58;
    public static final int BASE_SPECIAL_ATTACK = 90;
    public static final int BASE_SPECIAL_DEFENSE = 70;
    public static final int BASE_SPEED = 73;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/braixen.png";
    public static final String BACK_PATH = "battle/backs/kalos/braixen.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/braixen.png";
    public static final String CRY_PATH = "sounds/cry/654.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/braixen.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.FIRE;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a braixen
     */
    public Braixen() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init braixen's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SCRATCH);
        beginnerSkills.add(SkillFactory.TAIL_WHIP);
        beginnerSkills.add(SkillFactory.EMBER);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.EMBER)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.HOWL)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAME_CHARGE)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYBEAM)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.FIRE_SPIN)));
        //28 LUCKY CHANT
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.LIGHT_SCREEN)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYSHOCK)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAMETHROWER)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.WILL_O_WISP)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCHIC)));
        levelUpSkills.put(52, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUNNY_DAY)));
        //56 MAGIC ROOM
        levelUpSkills.put(59, new ArrayList<Integer>(Arrays.asList(SkillFactory.FIRE_BLAST)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.PSYSHOCK.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FLAMETHROWER.getValue());
        tmSkills.add(TmId.FIRE_BLAST.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.FLAME_CHARGE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.OVERHEAT.getValue());
        tmSkills.add(TmId.WILL_O_WISP.getValue());
        tmSkills.add(TmId.EMBARGO.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init braixen's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .875) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }

    /**
     * Return Delphox if the braixen is above level 36.
     * @return Delphox if braixen is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 36) {
            return PokemonId.DELPHOX.getValue();
        }
        return -1;
    }
}
