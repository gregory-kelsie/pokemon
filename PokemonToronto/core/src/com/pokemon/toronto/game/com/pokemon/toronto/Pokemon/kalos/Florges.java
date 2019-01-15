package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kalos;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-02-02.
 */

public class Florges extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 671;
    public static final String NAME = "Florges";
    public static final String TYPE_OF_POKEMON = "Garden";
    public static final String DESCRIPTION = "It claims exquisite flower gardens as its " +
            "territory, and it obtains power from basking in the energy emitted by flowering plants.";
    public static final double HEIGHT = 1.1;
    public static final int BASE_EXP = 248;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 3, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 10;

    public static final Ability FIRST_ABILITY = new Ability.FlowerVeil();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.Symbiosis();

    //Base Stats
    public static final int BASE_HEALTH = 78;
    public static final int BASE_ATTACK = 65;
    public static final int BASE_DEFENSE = 68;
    public static final int BASE_SPECIAL_ATTACK = 112;
    public static final int BASE_SPECIAL_DEFENSE = 154;
    public static final int BASE_SPEED = 75;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/florges.png";
    public static final String BACK_PATH = "battle/backs/kalos/florges.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/florges.png";
    public static final String CRY_PATH = "sounds/cry/671.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/florges.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.FAIRY;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a florges
     */
    public Florges() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init florges's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.PETAL_DANCE);
        beginnerSkills.add(SkillFactory.WISH);
        beginnerSkills.add(SkillFactory.AROMATHERAPY);
        beginnerSkills.add(SkillFactory.MAGICAL_LEAF);
        //LUCKY CHANT
        beginnerSkills.add(SkillFactory.GRASS_KNOT);
        beginnerSkills.add(SkillFactory.PETAL_BLIZZARD);
        beginnerSkills.add(SkillFactory.DISARMING_VOICE);
        //FLOWER SHIELD
        //GRASSY TERRAIN
        //MISTY TERAIN
        beginnerSkills.add(SkillFactory.MOONBLAST);
        levelUpSkills.put(0, beginnerSkills);
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
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
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.DAZZLING_GLEAM.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init florges's gender.
     */
    @Override
    protected void initGender() {
        gender = 'F';
    }
}
