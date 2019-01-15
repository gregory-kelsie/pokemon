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

public class Stunfisk extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 618;
    public static final String NAME = "Stunfisk";
    public static final String TYPE_OF_POKEMON = "Trap";
    public static final String DESCRIPTION = "Its skin is very hard, so it is unhurt even if " +
            "stepped on by sumo wrestlers. It smiles when transmitting electricity.";
    public static final double HEIGHT = 0.7;
    public static final int BASE_EXP = 165;
    public static final int[] EV_YIELD = {2, 0, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 75;
    public static final double WEIGHT = 11;

    public static final Ability FIRST_ABILITY = new Ability.Static();
    public static final Ability SECOND_ABILITY = new Ability.Limber();
    public static final Ability HIDDEN_ABILITY = new Ability.SandVeil();

    //Base Stats
    public static final int BASE_HEALTH = 109;
    public static final int BASE_ATTACK = 66;
    public static final int BASE_DEFENSE = 84;
    public static final int BASE_SPECIAL_ATTACK = 81;
    public static final int BASE_SPECIAL_DEFENSE = 99;
    public static final int BASE_SPEED = 32;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/stunfisk.png";
    public static final String BACK_PATH = "battle/backs/unova/stunfisk.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/stunfisk.png";
    public static final String CRY_PATH = "sounds/cry/618.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/stunfisk.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GROUND;
    public static final Type TYPE_TWO = Type.ELECTRIC;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a stunfisk
     */
    public Stunfisk() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init stunfisk's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.FISSURE);
        beginnerSkills.add(SkillFactory.FLAIL);
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.WATER_GUN);
        beginnerSkills.add(SkillFactory.MUD_SLAP);
        //MUD SPORT
        levelUpSkills.put(0, beginnerSkills);
        //5 BIDE
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDER_SHOCK)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_SHOT)));
        //17 CAMOUFLAGE
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_BOMB)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.DISCHARGE)));
        //30 ENDURE
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.BOUNCE)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUDDY_WATER)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDERBOLT)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.REVENGE)));
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAIL)));
        levelUpSkills.put(61, new ArrayList<Integer>(Arrays.asList(SkillFactory.FISSURE)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SLUDGE_WAVE.getValue());
        tmSkills.add(TmId.SLUDGE_BOMB.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.SCALD.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.INFESTATION.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SURF.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init stunfisk's gender.
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
