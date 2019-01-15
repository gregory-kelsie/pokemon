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

public class Trevenant extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 709;
    public static final String NAME = "Trevenant";
    public static final String TYPE_OF_POKEMON = "Elder Tree";
    public static final String DESCRIPTION = "It can control trees at will. It will trap people" +
            " who harm the forest, so they can never leave.";
    public static final double HEIGHT = 1.5;
    public static final int BASE_EXP = 166;
    public static final int[] EV_YIELD = {0, 2, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 60;
    public static final double WEIGHT = 71;

    public static final Ability FIRST_ABILITY = new Ability.NaturalCure();
    public static final Ability SECOND_ABILITY = new Ability.Frisk();
    public static final Ability HIDDEN_ABILITY = new Ability.Harvest();

    //Base Stats
    public static final int BASE_HEALTH = 85;
    public static final int BASE_ATTACK = 110;
    public static final int BASE_DEFENSE = 76;
    public static final int BASE_SPECIAL_ATTACK = 65;
    public static final int BASE_SPECIAL_DEFENSE = 82;
    public static final int BASE_SPEED = 56;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/trevenant.png";
    public static final String BACK_PATH = "battle/backs/kalos/trevenant.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/trevenant.png";
    public static final String CRY_PATH = "sounds/cry/709.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/trevenant.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GHOST;
    public static final Type TYPE_TWO = Type.GRASS;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a trevenant
     */
    public Trevenant() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init trevenant's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.GROWTH);
        beginnerSkills.add(SkillFactory.CONFUSE_RAY);
        beginnerSkills.add(SkillFactory.ASTONISH);
        beginnerSkills.add(SkillFactory.HORN_LEECH);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.ASTONISH)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWTH)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.INGRAIN)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT_ATTACK)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEECH_SEED)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.CURSE)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.WILL_O_WISP)));
        //35 FOREST'S CURSE
        //39 DESTINY BOND
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.PHANTOM_FORCE)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.WOOD_HAMMER)));
        levelUpSkills.put(54, new ArrayList<Integer>(Arrays.asList(SkillFactory.HORN_LEECH)));
        initEvolutionSkills();
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.BRUTAL_SWING.getValue());
        tmSkills.add(TmId.WILL_O_WISP.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.X_SCISSOR.getValue());
        tmSkills.add(TmId.POISON_JAB.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.TRICK_ROOM.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.SHADOW_CLAW);
    }

    /**
     * Init trevenant's gender.
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
