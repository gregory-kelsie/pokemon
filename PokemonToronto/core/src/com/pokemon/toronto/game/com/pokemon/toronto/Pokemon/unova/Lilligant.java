package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.unova;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-05-06.
 */

public class Lilligant extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 549;
    public static final String NAME = "Lilligant";
    public static final String TYPE_OF_POKEMON = "Flowering";
    public static final String DESCRIPTION = "The fragrance of the garland on its head has a" +
            " relaxing effect, but taking care of it is very difficult.";
    public static final double HEIGHT = 1.1;
    public static final int BASE_EXP = 168;
    public static final int[] EV_YIELD = {0, 0, 0, 2, 0, 0};
    public static final int CAPTURE_RATE = 75;
    public static final double WEIGHT = 16.3;

    public static final Ability FIRST_ABILITY = new Ability.Chlorophyll();
    public static final Ability SECOND_ABILITY = new Ability.OwnTempo();
    public static final Ability HIDDEN_ABILITY = new Ability.LeafGuard();

    //Base Stats
    public static final int BASE_HEALTH = 70;
    public static final int BASE_ATTACK = 60;
    public static final int BASE_DEFENSE = 75;
    public static final int BASE_SPECIAL_ATTACK = 110;
    public static final int BASE_SPECIAL_DEFENSE = 75;
    public static final int BASE_SPEED = 90;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/lilligant.png";
    public static final String BACK_PATH = "battle/backs/unova/lilligant.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/lilligant.png";
    public static final String CRY_PATH = "sounds/cry/549.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/lilligant.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GRASS;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a lilligant
     */
    public Lilligant() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init lilligant's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.GROWTH);
        beginnerSkills.add(SkillFactory.LEECH_SEED);
        beginnerSkills.add(SkillFactory.MEGA_DRAIN);
        beginnerSkills.add(SkillFactory.SYNTHESIS);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.TEETER_DANCE)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUIVER_DANCE)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.PETAL_DANCE)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.PETAL_BLIZZARD)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init lilligant's gender.
     */
    @Override
    protected void initGender() {
        gender = 'F';
    }

}
