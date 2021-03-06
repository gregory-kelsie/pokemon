package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 9/15/2017.
 */

public class Poliwhirl extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 61;
    public static final String NAME = "Poliwhirl";
    public static final String TYPE_OF_POKEMON = "Tadpole";
    public static final String DESCRIPTION = "Its two legs are well developed. Even though it" +
            " can live on the ground, it prefers living in water.";

    public static final int BASE_EXP = 135;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 2};
    public static final int CAPTURE_RATE = 120;

    public static final double HEIGHT = 1;
    public static final double WEIGHT = 20;

    public static final Ability FIRST_ABILITY = new Ability.WaterAbsorb();
    public static final Ability SECOND_ABILITY = new Ability.Damp();
    public static final Ability HIDDEN_ABILITY = new Ability.SwiftSwim();

    //Base Stats
    public static final int BASE_HEALTH = 65;
    public static final int BASE_ATTACK = 65;
    public static final int BASE_DEFENSE = 65;
    public static final int BASE_SPECIAL_ATTACK = 50;
    public static final int BASE_SPECIAL_DEFENSE = 50;
    public static final int BASE_SPEED = 90;

    //Typing
    public static final Type TYPE_ONE = Type.WATER;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/poliwhirl.png";
    public static final String BACK_PATH = "battle/backs/poliwhirl.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/poliwhirl.png";
    public static final String CRY_PATH = "sounds/cry/061.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kanto/061.png";

    /**
     * Create a Poliwhirl
     */
    public Poliwhirl() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Poliwhirl's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.WATER_SPORT);
        beginnerSkills.add(SkillFactory.WATER_GUN);
        beginnerSkills.add(SkillFactory.HYPNOSIS);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_GUN)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPNOSIS)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUBBLE)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_SLAP)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAIN_DANCE)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.BODY_SLAM)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUBBLEBEAM)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_SHOT)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.BELLY_DRUM)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.WAKE_UP_SLAP)));
        levelUpSkills.put(48, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYDRO_PUMP)));
        levelUpSkills.put(53, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_BOMB)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HAIL.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.BLIZZARD.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.SCALD.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SURF.getValue());
        tmSkills.add(TmId.WATERFALL.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    @Override
    public int getWaterStoneEvolutionId() {
        return PokemonId.POLIWRATH.getValue();
    }

    @Override
    public int getDawnStoneEvolutionId() {
        return PokemonId.POLITOED.getValue();
    }
}
