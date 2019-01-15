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

public class Spritzee extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 682;
    public static final String NAME = "Spritzee";
    public static final String TYPE_OF_POKEMON = "Perfume";
    public static final String DESCRIPTION = "It emits a scent that enraptures those who smell" +
            " it. This fragance changes depending on what it has eaten.";
    public static final double HEIGHT = 0.2;
    public static final int BASE_EXP = 68;
    public static final int[] EV_YIELD = {1, 0, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 200;
    public static final double WEIGHT = 0.5;

    public static final Ability FIRST_ABILITY = new Ability.Healer();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.AromaVeil();

    //Base Stats
    public static final int BASE_HEALTH = 78;
    public static final int BASE_ATTACK = 52;
    public static final int BASE_DEFENSE = 60;
    public static final int BASE_SPECIAL_ATTACK = 63;
    public static final int BASE_SPECIAL_DEFENSE = 65;
    public static final int BASE_SPEED = 23;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/spritzee.png";
    public static final String BACK_PATH = "battle/backs/kalos/spritzee.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/spritzee.png";
    public static final String CRY_PATH = "sounds/cry/682.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/spritzee.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.FAIRY;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a spritzee
     */
    public Spritzee() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init spritzee's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SWEET_SCENT);
        beginnerSkills.add(SkillFactory.FAIRY_WIND);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWEET_KISS)));
        //8 ODOR SLEUTH
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.ECHOED_VOICE)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.CALM_MIND)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAINING_KISS)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.AROMATHERAPY)));
        //29 ATTRACT
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.MOONBLAST)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARM)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAIL)));
        //42 MISTY TERRAIN
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.SKILL_SWAP)));
        levelUpSkills.put(48, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCHIC)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.DISARMING_VOICE)));
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
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.GYRO_BALL.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.FLASH_CANNON.getValue());
        tmSkills.add(TmId.TRICK_ROOM.getValue());
        tmSkills.add(TmId.DAZZLING_GLEAM.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init spritzee's gender.
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
     * Return Aromatisse
     * @return Aromatisse
     */
    @Override
    public int getShinyStoneEvolutionId() {
        return PokemonId.AROMATISSE.getValue();
    }
}
