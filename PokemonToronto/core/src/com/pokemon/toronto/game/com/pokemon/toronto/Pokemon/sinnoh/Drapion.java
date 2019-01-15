package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-04-29.
 */

public class Drapion extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 452;
    public static final String NAME = "Drapion";
    public static final String TYPE_OF_POKEMON = "Ogre Scorp";
    public static final String DESCRIPTION = "Possessing a sturdy build, it takes pride in its" +
            " strength, taking down foes without using toxins.";
    public static final double HEIGHT = 1.3;
    public static final int BASE_EXP = 175;
    public static final int[] EV_YIELD = {0, 0, 2, 0, 0, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 61.5;

    public static final Ability FIRST_ABILITY = new Ability.BattleArmor();
    public static final Ability SECOND_ABILITY = new Ability.Sniper();
    public static final Ability HIDDEN_ABILITY = new Ability.KeenEye();

    //Base Stats
    public static final int BASE_HEALTH = 70;
    public static final int BASE_ATTACK = 90;
    public static final int BASE_DEFENSE = 110;
    public static final int BASE_SPECIAL_ATTACK = 60;
    public static final int BASE_SPECIAL_DEFENSE = 75;
    public static final int BASE_SPEED = 95;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/drapion.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/drapion.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/drapion.png";
    public static final String CRY_PATH = "sounds/cry/452.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/drapion.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.POISON;
    public static final Type TYPE_TWO = Type.DARK;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    /**
     * Create a drapion
     */
    public Drapion() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init drapion's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.THUNDER_FANG);
        beginnerSkills.add(SkillFactory.ICE_FANG);
        beginnerSkills.add(SkillFactory.FIRE_FANG);
        beginnerSkills.add(SkillFactory.BITE);
        beginnerSkills.add(SkillFactory.POISON_STING);
        beginnerSkills.add(SkillFactory.LEER);
        beginnerSkills.add(SkillFactory.KNOCK_OFF);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.KNOCK_OFF)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.PIN_MISSILE)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.ACUPRESSURE)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.PURSUIT)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUG_BITE)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_FANG)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.VENOSHOCK)));
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.HONE_CLAWS)));
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.TOXIC_SPIKES)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.NIGHT_SLASH)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCARY_FACE)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(53, new ArrayList<Integer>(Arrays.asList(SkillFactory.FELL_STINGER)));
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.CROSS_POISON)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.VENOSHOCK.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SLUDGE_BOMB.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FALSE_SWIPE.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.BRUTAL_SWING.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.X_SCISSOR.getValue());
        tmSkills.add(TmId.INFESTATION.getValue());
        tmSkills.add(TmId.POISON_JAB.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SNARL.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init drapion's gender.
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
