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

public class Vivillon extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 666;
    public static final String NAME = "Vivillon";
    public static final String TYPE_OF_POKEMON = "Scale";
    public static final String DESCRIPTION = "The patterns on this Pokémon's wings depend on " +
            "the climate and topography of its habitat. It scatters colorful scales.";
    public static final double HEIGHT = 1.2;
    public static final int BASE_EXP = 185;
    public static final int[] EV_YIELD = {1, 0, 0, 1, 0, 1};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 17;

    public static final Ability FIRST_ABILITY = new Ability.ShieldDust();
    public static final Ability SECOND_ABILITY = new Ability.Compoundeyes();
    public static final Ability HIDDEN_ABILITY = new Ability.FriendGuard();

    //Base Stats
    public static final int BASE_HEALTH = 80;
    public static final int BASE_ATTACK = 52;
    public static final int BASE_DEFENSE = 50;
    public static final int BASE_SPECIAL_ATTACK = 90;
    public static final int BASE_SPECIAL_DEFENSE = 50;
    public static final int BASE_SPEED = 89;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/vivillon.png";
    public static final String BACK_PATH = "battle/backs/kalos/vivillon.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/vivillon.png";
    public static final String CRY_PATH = "sounds/cry/666.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/vivillon.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.BUG;
    public static final Type TYPE_TWO = Type.FLYING;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a vivillon
     */
    public Vivillon() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init vivillon's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.POISON_POWDER);
        beginnerSkills.add(SkillFactory.STUN_SPORE);
        beginnerSkills.add(SkillFactory.SLEEP_POWDER);
        beginnerSkills.add(SkillFactory.STRUGGLE_BUG);
        beginnerSkills.add(SkillFactory.POWDER);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.LIGHT_SCREEN)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYBEAM)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUPERSONIC)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAINING_KISS)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.AROMATHERAPY)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUG_BUZZ)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAFEGUARD)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUIVER_DANCE)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.HURRICANE)));
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.POWDER)));
        initEvolutionSkills();
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
        tmSkills.add(TmId.ROOST.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.ACROBATICS.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.INFESTATION.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.GUST);
    }

    /**
     * Init vivillon's gender.
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
