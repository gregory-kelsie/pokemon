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

public class Floette extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 670;
    private static final String NAME = "Floette";
    private static final int BASE_EXP = 130;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 2, 0};
    private static final int CAPTURE_RATE = 120;
    private static final double WEIGHT = 0.9;

    private static final Ability FIRST_ABILITY = new Ability.FlowerVeil();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = new Ability.Symbiosis();

    //Base Stats
    private static final int BASE_HEALTH = 54;
    private static final int BASE_ATTACK = 45;
    private static final int BASE_DEFENSE = 47;
    private static final int BASE_SPECIAL_ATTACK = 75;
    private static final int BASE_SPECIAL_DEFENSE = 98;
    private static final int BASE_SPEED = 52;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/kalos/floette.png";
    private static final String BACK_PATH = "battle/backs/kalos/floette.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/kalos/floette.png";
    private static final String CRY_PATH = "sounds/cry/670.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kalos/floette.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.FAIRY;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a floette
     */
    public Floette() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init floette's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.VINE_WHIP);
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.FAIRY_WIND);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.FAIRY_WIND)));
        //10 LUCKY CHANT
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAZOR_LEAF)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.WISH)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.MAGICAL_LEAF)));
        //27 GRASSY TERRAIN
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.PETAL_BLIZZARD)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.AROMATHERAPY)));
        //43 MISTY TERRAIN
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.MOONBLAST)));
        levelUpSkills.put(51, new ArrayList<Integer>(Arrays.asList(SkillFactory.PETAL_DANCE)));
        levelUpSkills.put(58, new ArrayList<Integer>(Arrays.asList(SkillFactory.SOLAR_BEAM)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.DAZZLING_GLEAM.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init floette's gender.
     */
    @Override
    protected void initGender() {
        gender = 'F';
    }

    /**
     * Return Florges
     * @return Florges
     */
    @Override
    public int getShinyStoneEvolutionId() {
        return PokemonId.FLORGES.getValue();
    }
}