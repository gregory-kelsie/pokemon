package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.unova;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-05-07.
 */

public class Beheeyem extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 606;
    public static final String NAME = "Beheeyem";
    public static final String TYPE_OF_POKEMON = "Cerebral";
    public static final String DESCRIPTION = "It uses psychic power to control an opponent's " +
            "brain and tamper with its memories.";
    public static final double HEIGHT = 1;
    public static final int BASE_EXP = 170;
    public static final int[] EV_YIELD = {0, 0, 0, 2, 0, 0};
    public static final int CAPTURE_RATE = 90;
    public static final double WEIGHT = 34.5;

    public static final Ability FIRST_ABILITY = new Ability.Telepathy();
    public static final Ability SECOND_ABILITY = new Ability.Synchronize();
    public static final Ability HIDDEN_ABILITY = new Ability.Analytic();

    //Base Stats
    public static final int BASE_HEALTH = 75;
    public static final int BASE_ATTACK = 75;
    public static final int BASE_DEFENSE = 75;
    public static final int BASE_SPECIAL_ATTACK = 125;
    public static final int BASE_SPECIAL_DEFENSE = 95;
    public static final int BASE_SPEED = 40;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/beheeyem.png";
    public static final String BACK_PATH = "battle/backs/unova/beheeyem.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/beheeyem.png";
    public static final String CRY_PATH = "sounds/cry/606.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/beheeyem.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.PSYCHIC;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a beheeyem
     */
    public Beheeyem() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init beheeyem's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //PSYCHIC TERRAIN
        //WONDER ROOM
        beginnerSkills.add(SkillFactory.SYNCHRONOISE);
        beginnerSkills.add(SkillFactory.CONFUSION);
        beginnerSkills.add(SkillFactory.GROWL);
        //HEAL BLOCK
        //MIRACLE EYE
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWL)));
        //8 HEAL BLOCK
        //11 MIRACLE EYE
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYBEAM)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEADBUTT)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.HIDDEN_POWER)));
        //25 IMPRISON
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.SIMPLE_BEAM)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.ZEN_HEADBUTT)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCH_UP)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCHIC)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.CALM_MIND)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.RECOVER)));
        //56 GUARD SPLIT
        //58 POWER SPLIT
        levelUpSkills.put(63, new ArrayList<Integer>(Arrays.asList(SkillFactory.SYNCHRONOISE)));
        //68 WONDER ROOM
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.PSYSHOCK.getValue());
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.STEEL_WING.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.EMBARGO.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.TRICK_ROOM.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init beheeyem's gender.
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
