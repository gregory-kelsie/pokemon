package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alola;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-30.
 */

public class Araquanid extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 752;
    public static final String NAME = "Araquanid";
    public static final String TYPE_OF_POKEMON = "Water Bubble";
    public static final String DESCRIPTION = "It delivers headbutts with the water bubble on " +
            "its head. Small Pokémon get sucked into the bubble, where they drown.";
    public static final double HEIGHT = 1.8;
    public static final int BASE_EXP = 159;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 2, 0};
    public static final int CAPTURE_RATE = 100;
    public static final double WEIGHT = 82;

    public static final Ability FIRST_ABILITY = new Ability.WaterBubble();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.WaterAbsorb();

    //Base Stats
    public static final int BASE_HEALTH = 68;
    public static final int BASE_ATTACK = 70;
    public static final int BASE_DEFENSE = 92;
    public static final int BASE_SPECIAL_ATTACK = 50;
    public static final int BASE_SPECIAL_DEFENSE = 132;
    public static final int BASE_SPEED = 42;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/alola/araquanid.png";
    public static final String BACK_PATH = "battle/backs/alola/araquanid.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/alola/araquanid.png";
    public static final String CRY_PATH = "sounds/cry/752.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/alola/araquanid.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.WATER;
    public static final Type TYPE_TWO = Type.BUG;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a araquanid
     */
    public Araquanid() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init araquanid's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //wide guard
        //soak
        beginnerSkills.add(SkillFactory.BUBBLE);
        beginnerSkills.add(SkillFactory.INFESTATION);
        beginnerSkills.add(SkillFactory.SPIDER_WEB);
        beginnerSkills.add(SkillFactory.BUG_BITE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.INFESTATION)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.SPIDER_WEB)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUG_BITE)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUBBLEBEAM)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.AQUA_RING)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEECH_LIFE)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.LUNGE)));
        //50 MIRROR COAT
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.LIQUIDATION)));
        //62 ENTERTAINMENT
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.BLIZZARD.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.LEECH_LIFE.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.SCALD.getValue());
        tmSkills.add(TmId.FROST_BREATH.getValue());
        tmSkills.add(TmId.X_SCISSOR.getValue());
        tmSkills.add(TmId.INFESTATION.getValue());
        tmSkills.add(TmId.POISON_JAB.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SURF.getValue());
        tmSkills.add(TmId.WATERFALL.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init araquanid's gender.
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
