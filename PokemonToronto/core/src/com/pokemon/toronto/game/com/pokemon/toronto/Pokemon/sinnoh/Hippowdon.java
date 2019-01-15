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

public class Hippowdon extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 450;
    public static final String NAME = "Hippowdon";
    public static final String TYPE_OF_POKEMON = "Heavyweight";
    public static final String DESCRIPTION = "It is surprisingly quick to anger. It holds its " +
            "mouth agape as a display of its strength.";
    public static final double HEIGHT = 2;
    public static final int BASE_EXP = 184;
    public static final int[] EV_YIELD = {0, 0, 2, 0, 0, 0};
    public static final int CAPTURE_RATE = 60;
    public static final double WEIGHT = 300;

    public static final Ability FIRST_ABILITY = new Ability.SandStream();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.SandForce();

    //Base Stats
    public static final int BASE_HEALTH = 108;
    public static final int BASE_ATTACK = 112;
    public static final int BASE_DEFENSE = 118;
    public static final int BASE_SPECIAL_ATTACK = 68;
    public static final int BASE_SPECIAL_DEFENSE = 72;
    public static final int BASE_SPEED = 47;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/hippowdon.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/hippowdon.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/hippowdon.png";
    public static final String CRY_PATH = "sounds/cry/450.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/hippowdon.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GROUND;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    /**
     * Create a hippowdon
     */
    public Hippowdon() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init hippowdon's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.ICE_FANG);
        beginnerSkills.add(SkillFactory.FIRE_FANG);
        beginnerSkills.add(SkillFactory.THUNDER_FANG);
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.SAND_ATTACK);
        beginnerSkills.add(SkillFactory.BITE);
        beginnerSkills.add(SkillFactory.YAWN);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.YAWN)));
        List<Integer> thirteen = new ArrayList<Integer>();
        thirteen.add(SkillFactory.TAKE_DOWN);
        thirteen.add(SkillFactory.DIG);
        levelUpSkills.put(19, thirteen);
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAND_TOMB)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.EARTHQUAKE)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
        levelUpSkills.put(60, new ArrayList<Integer>(Arrays.asList(SkillFactory.FISSURE)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init hippowdon's gender.
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
