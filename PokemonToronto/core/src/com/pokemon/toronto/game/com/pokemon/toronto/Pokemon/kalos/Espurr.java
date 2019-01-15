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

public class Espurr extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 677;
    public static final String NAME = "Espurr";
    public static final String TYPE_OF_POKEMON = "Restraint";
    public static final String DESCRIPTION = "The organ that emits its intense psychic power is" +
            " sheltered by its ears to keep power from leaking out.";
    public static final double HEIGHT = 0.3;
    public static final int BASE_EXP = 71;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    public static final int CAPTURE_RATE = 190;
    public static final double WEIGHT = 3.5;

    public static final Ability FIRST_ABILITY = new Ability.KeenEye();
    public static final Ability SECOND_ABILITY = new Ability.Infiltrator();
    public static final Ability HIDDEN_ABILITY = new Ability.OwnTempo();

    //Base Stats
    public static final int BASE_HEALTH = 62;
    public static final int BASE_ATTACK = 48;
    public static final int BASE_DEFENSE = 54;
    public static final int BASE_SPECIAL_ATTACK = 63;
    public static final int BASE_SPECIAL_DEFENSE = 60;
    public static final int BASE_SPEED = 68;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/espurr.png";
    public static final String BACK_PATH = "battle/backs/kalos/espurr.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/espurr.png";
    public static final String CRY_PATH = "sounds/cry/677.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/espurr.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.PSYCHIC;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a espurr
     */
    public Espurr() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init espurr's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SCRATCH);
        beginnerSkills.add(SkillFactory.LEER);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.COVET)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.CONFUSION)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.LIGHT_SCREEN)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYBEAM)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.FAKE_OUT)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.DISARMING_VOICE)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYSHOCK)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.PSYSHOCK.getValue());
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
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.TRICK_ROOM.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init espurr's gender.
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
     * Return Meowstic if the espurr is above level 25.
     * @return Meowstic if espurr is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 25) {
            return PokemonId.MEOWSTIC.getValue();
        }
        return -1;
    }
}
