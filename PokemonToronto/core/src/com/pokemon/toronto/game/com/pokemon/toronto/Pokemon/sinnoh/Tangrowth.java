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

public class Tangrowth extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 465;
    public static final String NAME = "Tangrowth";
    public static final String TYPE_OF_POKEMON = "Vine";
    public static final String DESCRIPTION = "Its arms are made of plants that bind themselves " +
            "to things. They grow back right away if cut.";
    public static final double HEIGHT = 2;
    public static final int BASE_EXP = 187;
    public static final int[] EV_YIELD = {0, 0, 2, 0, 0, 0};
    public static final int CAPTURE_RATE = 30;
    public static final double WEIGHT = 128.6;

    public static final Ability FIRST_ABILITY = new Ability.Chlorophyll();
    public static final Ability SECOND_ABILITY = new Ability.LeafGuard();
    public static final Ability HIDDEN_ABILITY = new Ability.Regenerator();

    //Base Stats
    public static final int BASE_HEALTH = 100;
    public static final int BASE_ATTACK = 100;
    public static final int BASE_DEFENSE = 125;
    public static final int BASE_SPECIAL_ATTACK = 110;
    public static final int BASE_SPECIAL_DEFENSE = 50;
    public static final int BASE_SPEED = 50;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/tangrowth.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/tangrowth.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/tangrowth.png";
    public static final String CRY_PATH = "sounds/cry/465.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/tangrowth.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GRASS;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a tangrowth
     */
    public Tangrowth() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init tangrowth's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //BLOCK
        beginnerSkills.add(SkillFactory.INGRAIN);
        beginnerSkills.add(SkillFactory.CONSTRICT);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLEEP_POWDER)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.VINE_WHIP)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.ABSORB)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_POWDER)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.BIND)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWTH)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEGA_DRAIN)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.KNOCK_OFF)));
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.STUN_SPORE)));
        //TODO: NATURAL GIFT 33
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.GIGA_DRAIN)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.ANCIENT_POWER)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLAM)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.TICKLE)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.WRING_OUT)));
        //TODO: GRASSY TERRAIN 50
        levelUpSkills.put(53, new ArrayList<Integer>(Arrays.asList(SkillFactory.POWER_WHIP)));
        //56 BLOCK
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.SLUDGE_BOMB.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.INFESTATION.getValue());
        tmSkills.add(TmId.POISON_JAB.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }
}
