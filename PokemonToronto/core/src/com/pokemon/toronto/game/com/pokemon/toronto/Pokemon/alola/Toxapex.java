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

public class Toxapex extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 748;
    public static final String NAME = "Toxapex";
    public static final String TYPE_OF_POKEMON = "Brutal Star";
    public static final String DESCRIPTION = "Toxapex crawls along the ocean floor on its 12 " +
            "legs. It leaves a trail of Corsola bits scattered in its wake.";
    public static final double HEIGHT = 0.7;
    public static final int BASE_EXP = 173;
    public static final int[] EV_YIELD = {0, 0, 2, 0, 0, 0};
    public static final int CAPTURE_RATE = 75;
    public static final double WEIGHT = 14.5;

    public static final Ability FIRST_ABILITY = new Ability.Merciless();
    public static final Ability SECOND_ABILITY = new Ability.Limber();
    public static final Ability HIDDEN_ABILITY = new Ability.Regenerator();

    //Base Stats
    public static final int BASE_HEALTH = 50;
    public static final int BASE_ATTACK = 63;
    public static final int BASE_DEFENSE = 152;
    public static final int BASE_SPECIAL_ATTACK = 53;
    public static final int BASE_SPECIAL_DEFENSE = 142;
    public static final int BASE_SPEED = 35;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/alola/toxapex.png";
    public static final String BACK_PATH = "battle/backs/alola/toxapex.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/alola/toxapex.png";
    public static final String CRY_PATH = "sounds/cry/748.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/alola/toxapex.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.POISON;
    public static final Type TYPE_TWO = Type.WATER;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a toxapex
     */
    public Toxapex() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init toxapex's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.POISON_STING);
        beginnerSkills.add(SkillFactory.PECK);
        beginnerSkills.add(SkillFactory.BITE);
        beginnerSkills.add(SkillFactory.TOXIC_SPIKES);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.PECK)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.TOXIC_SPIKES)));
        //17 WIDE GUARD
        //21 TOXIC
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.VENOSHOCK)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.SPIKE_CANNON)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.RECOVER)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_JAB)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.VENOM_DRENCH)));
        levelUpSkills.put(51, new ArrayList<Integer>(Arrays.asList(SkillFactory.PIN_MISSILE)));
        levelUpSkills.put(58, new ArrayList<Integer>(Arrays.asList(SkillFactory.LIQUIDATION)));
        //BANEFUL BUNKER EVOLUTION SKILL
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HAIL.getValue());
        tmSkills.add(TmId.VENOSHOCK.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.BLIZZARD.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SMACK_DOWN.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SLUDGE_WAVE.getValue());
        tmSkills.add(TmId.SLUDGE_BOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.SCALD.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.FROST_BREATH.getValue());
        tmSkills.add(TmId.INFESTATION.getValue());
        tmSkills.add(TmId.POISON_JAB.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SURF.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init toxapex's gender.
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
