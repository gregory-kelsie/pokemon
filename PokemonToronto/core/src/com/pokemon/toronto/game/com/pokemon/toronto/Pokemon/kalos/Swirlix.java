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

public class Swirlix extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 684;
    public static final String NAME = "Swirlix";
    public static final String TYPE_OF_POKEMON = "Cotton Candy";
    public static final String DESCRIPTION = "To entangle its opponents in battle, it extrudes" +
            " white threads as sweet and sticky as cotton candy.";
    public static final double HEIGHT = 0.4;
    public static final int BASE_EXP = 68;
    public static final int[] EV_YIELD = {0, 0, 1, 0, 0, 0};
    public static final int CAPTURE_RATE = 200;
    public static final double WEIGHT = 3.5;

    public static final Ability FIRST_ABILITY = new Ability.SweetVeil();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.Unburden();

    //Base Stats
    public static final int BASE_HEALTH = 62;
    public static final int BASE_ATTACK = 48;
    public static final int BASE_DEFENSE = 66;
    public static final int BASE_SPECIAL_ATTACK = 59;
    public static final int BASE_SPECIAL_DEFENSE = 57;
    public static final int BASE_SPEED = 49;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/swirlix.png";
    public static final String BACK_PATH = "battle/backs/kalos/swirlix.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/swirlix.png";
    public static final String CRY_PATH = "sounds/cry/684.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/swirlix.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.FAIRY;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a swirlix
     */
    public Swirlix() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init swirlix's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.SWEET_SCENT);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.FAIRY_WIND)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.PLAY_NICE)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.FAKE_TEARS)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROUND)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.COTTON_SPORE)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.ENDEAVOR)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.AROMATHERAPY)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAINING_KISS)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.ENERGY_BALL)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.COTTON_GUARD)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.WISH)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.PLAY_ROUGH)));
        levelUpSkills.put(58, new ArrayList<Integer>(Arrays.asList(SkillFactory.LIGHT_SCREEN)));
        levelUpSkills.put(67, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAFEGUARD)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FLAMETHROWER.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SURF.getValue());
        tmSkills.add(TmId.DAZZLING_GLEAM.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init swirlix's gender.
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
     * Return Slurpuff
     * @return Slurpuff
     */
    @Override
    public int getShinyStoneEvolutionId() {
        return PokemonId.SLURPUFF.getValue();
    }

}
