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
 * Created by gregorykelsie on 2018-05-04.
 */

public class Pidove extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 519;
    public static final String NAME = "Pidove";
    public static final String TYPE_OF_POKEMON = "Tiny Pigeon";
    public static final String DESCRIPTION = "These Pokémon live in cities. They are accustomed" +
            " to people. Flocks often gather in parks and plazas.";
    public static final double HEIGHT = 0.3;
    public static final int BASE_EXP = 53;
    public static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 255;
    public static final double WEIGHT = 2.1;

    public static final Ability FIRST_ABILITY = new Ability.BigPecks();
    public static final Ability SECOND_ABILITY = new Ability.SuperLuck();
    public static final Ability HIDDEN_ABILITY = new Ability.Rivalry();

    //Base Stats
    public static final int BASE_HEALTH = 50;
    public static final int BASE_ATTACK = 55;
    public static final int BASE_DEFENSE = 50;
    public static final int BASE_SPECIAL_ATTACK = 36;
    public static final int BASE_SPECIAL_DEFENSE = 30;
    public static final int BASE_SPEED = 43;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/pidove.png";
    public static final String BACK_PATH = "battle/backs/unova/pidove.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/pidove.png";
    public static final String CRY_PATH = "sounds/cry/519.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/pidove.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    public static final Type TYPE_TWO = Type.FLYING;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a pidove
     */
    public Pidove() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init pidove's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.GUST);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWL)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEER)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.AIR_CUTTER)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROOST)));
        //22 DETECT
        //25 TAUNT
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.AIR_SLASH)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAZOR_WIND)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEATHER_DANCE)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWAGGER)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.FACADE)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAILWIND)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.SKY_ATTACK)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
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
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.STEEL_WING.getValue());
        tmSkills.add(TmId.FLY.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init pidove's gender.
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
     * Return Tranquill if the Pidove is above level 21.
     * @return Tranquill if Pidove is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 21) {
            return PokemonId.TRANQUILL.getValue();
        }
        return -1;
    }
}
