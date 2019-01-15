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

public class Spiritomb extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 442;
    public static final String NAME = "Spiritomb";
    public static final String TYPE_OF_POKEMON = "Forbidden";
    public static final String DESCRIPTION = "Its constant mischief and misdeeds resulted in it" +
            " being bound to an Odd Keystone by a mysterious spell.";
    public static final double HEIGHT = 1;
    public static final int BASE_EXP = 170;
    public static final int[] EV_YIELD = {0, 0, 1, 0, 1, 0};
    public static final int CAPTURE_RATE = 100;
    public static final double WEIGHT = 108;

    public static final Ability FIRST_ABILITY = new Ability.Pressure();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.Infiltrator();

    //Base Stats
    public static final int BASE_HEALTH = 50;
    public static final int BASE_ATTACK = 92;
    public static final int BASE_DEFENSE = 108;
    public static final int BASE_SPECIAL_ATTACK = 92;
    public static final int BASE_SPECIAL_DEFENSE = 108;
    public static final int BASE_SPEED = 35;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/spiritomb.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/spiritomb.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/spiritomb.png";
    public static final String CRY_PATH = "sounds/cry/442.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/spiritomb.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GHOST;
    public static final Type TYPE_TWO = Type.DARK;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a spiritomb
     */
    public Spiritomb() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init spiritomb's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.CURSE);
        beginnerSkills.add(SkillFactory.PURSUIT);
        beginnerSkills.add(SkillFactory.CONFUSE_RAY);
        //SPITE
        beginnerSkills.add(SkillFactory.SHADOW_SNEAK);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT_ATTACK)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPNOSIS)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.DREAM_EATER)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.OMINOUS_WIND)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUCKER_PUNCH)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.NASTY_PLOT)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEMENTO)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.DARK_PULSE)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());;
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.QUASH.getValue());
        tmSkills.add(TmId.WILL_O_WISP.getValue());
        tmSkills.add(TmId.EMBARGO.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.INFESTATION.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SNARL.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init spiritomb's gender.
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
