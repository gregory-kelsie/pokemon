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

public class Popplio extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 728;
    public static final String NAME = "Popplio";
    public static final String TYPE_OF_POKEMON = "Sea Lion";
    public static final String DESCRIPTION = "This Pokémon can control water bubbles. It " +
            "practices diligently so it can learn to make big bubbles.";
    public static final double HEIGHT = 0.4;
    public static final int BASE_EXP = 64;
    public static final int[] EV_YIELD = {0, 0, 0, 1, 0, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 7.5;

    public static final Ability FIRST_ABILITY = new Ability.Torrent();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.LiquidVoice();

    //Base Stats
    public static final int BASE_HEALTH = 50;
    public static final int BASE_ATTACK = 54;
    public static final int BASE_DEFENSE = 54;
    public static final int BASE_SPECIAL_ATTACK = 66;
    public static final int BASE_SPECIAL_DEFENSE = 56;
    public static final int BASE_SPEED = 40;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/alola/popplio.png";
    public static final String BACK_PATH = "battle/backs/alola/popplio.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/alola/popplio.png";
    public static final String CRY_PATH = "sounds/cry/728.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/alola/popplio.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.WATER;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a popplio
     */
    public Popplio() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init popplio's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.POUND);
        beginnerSkills.add(SkillFactory.WATER_GUN);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWL)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.DISARMING_VOICE)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.BABY_DOLL_EYES)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.AQUA_JET)));
        //18 ENCORE
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUBBLEBEAM)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.SING)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_SLAP)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPER_VOICE)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.MOONBLAST)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.CAPTIVATE)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYDRO_PUMP)));
        //46 MISTY TERRAIN
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HAIL.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.BLIZZARD.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.SCALD.getValue());
        tmSkills.add(TmId.ACROBATICS.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SURF.getValue());
        tmSkills.add(TmId.WATERFALL.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init popplio's gender.
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
     * Return Brionne if the popplio is above level 17.
     * @return Brionne if popplio is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 17) {
            return PokemonId.BRIONNE.getValue();
        }
        return -1;
    }
}
