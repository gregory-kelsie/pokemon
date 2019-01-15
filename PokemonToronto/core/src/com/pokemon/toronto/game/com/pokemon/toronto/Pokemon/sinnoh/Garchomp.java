package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-04-25.
 */

public class Garchomp extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 445;
    public static final String NAME = "Garchomp";
    public static final String TYPE_OF_POKEMON = "Mach";
    public static final String DESCRIPTION = "It is said that when one runs at high speed, its" +
            " wings create blades of wind that can fell nearby trees.";
    public static final double HEIGHT = 1.9;
    public static final int BASE_EXP = 270;
    public static final int[] EV_YIELD = {0, 3, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 95;

    public static final Ability FIRST_ABILITY = new Ability.SandVeil();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.RoughSkin();

    //Base Stats
    public static final int BASE_HEALTH = 108;
    public static final int BASE_ATTACK = 130;
    public static final int BASE_DEFENSE = 95;
    public static final int BASE_SPECIAL_ATTACK = 80;
    public static final int BASE_SPECIAL_DEFENSE = 85;
    public static final int BASE_SPEED = 102;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/garchomp.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/garchomp.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/garchomp.png";
    public static final String CRY_PATH = "sounds/cry/445.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/garchomp.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.DRAGON;
    public static final Type TYPE_TWO = Type.GROUND;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    /**
     * Create a garchomp
     */
    public Garchomp() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init garchomp's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.DUAL_CHOP);
        beginnerSkills.add(SkillFactory.FIRE_FANG);
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.SAND_ATTACK);
        beginnerSkills.add(SkillFactory.DRAGON_RAGE);
        beginnerSkills.add(SkillFactory.SANDSTORM);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAND_ATTACK)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAGON_RAGE)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.SANDSTORM)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAND_TOMB)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLASH)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAGON_CLAW)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.DIG)));
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAGON_RUSH)));
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.CRUNCH);
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.DRAGON_CLAW.getValue());
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());;
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FLAMETHROWER.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.FIRE_BLAST.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FALSE_SWIPE.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.BRUTAL_SWING.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.DRAGON_TAIL.getValue());
        tmSkills.add(TmId.POISON_JAB.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SURF.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init garchomp's gender.
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
