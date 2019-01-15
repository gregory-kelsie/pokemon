package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.unova;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-05-05.
 */

public class Leavanny extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 542;
    public static final String NAME = "Leavanny";
    public static final String TYPE_OF_POKEMON = "Nurturing";
    public static final String DESCRIPTION = "Upon finding a small Pokémon, it weaves clothing " +
            "for it from leaves, using the cutters on its arms and sticky silk.";
    public static final double HEIGHT = 1.2;
    public static final int BASE_EXP = 225;
    public static final int[] EV_YIELD = {0, 3, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 20.5;

    public static final Ability FIRST_ABILITY = new Ability.Swarm();
    public static final Ability SECOND_ABILITY = new Ability.Chlorophyll();
    public static final Ability HIDDEN_ABILITY = new Ability.Overcoat();

    //Base Stats
    public static final int BASE_HEALTH = 75;
    public static final int BASE_ATTACK = 103;
    public static final int BASE_DEFENSE = 80;
    public static final int BASE_SPECIAL_ATTACK = 70;
    public static final int BASE_SPECIAL_DEFENSE = 80;
    public static final int BASE_SPEED = 92;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/leavanny.png";
    public static final String BACK_PATH = "battle/backs/unova/leavanny.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/leavanny.png";
    public static final String CRY_PATH = "sounds/cry/542.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/leavanny.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.BUG;
    public static final Type TYPE_TWO = Type.GRASS;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a leavanny
     */
    public Leavanny() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init leavanny's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.FALSE_SWIPE);
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.STRING_SHOT);
        beginnerSkills.add(SkillFactory.BUG_BITE);
        beginnerSkills.add(SkillFactory.RAZOR_LEAF);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUG_BITE)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAZOR_LEAF)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.STRUGGLE_BUG)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.FELL_STINGER)));
        //32 HELPING HAND
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEAF_BLADE)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.X_SCISSOR)));
        //43 ENTERTAINMENT
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWORDS_DANCE)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEAF_STORM)));
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.SLASH);
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
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.STEEL_WING.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.FALSE_SWIPE.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.X_SCISSOR.getValue());
        tmSkills.add(TmId.POISON_JAB.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init leavanny's gender.
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
}
