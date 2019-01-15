package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-08-16.
 */

public class Phione extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 489;
    public static final String NAME = "Phione";
    public static final String TYPE_OF_POKEMON = "Sea Drifter";
    public static final String DESCRIPTION = "It drifts in warm seas. It always returns to " +
            "where it was born, no matter how far it may have drifted.";
    public static final int BASE_EXP = 216;
    public static final int[] EV_YIELD = {1, 0, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 30;
    public static final double WEIGHT = 3.1;
    public static final double HEIGHT = 0.4;

    public static final Ability FIRST_ABILITY = new Ability.Hydration();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    public static final int BASE_HEALTH = 80;
    public static final int BASE_ATTACK = 80;
    public static final int BASE_DEFENSE = 80;
    public static final int BASE_SPECIAL_ATTACK = 80;
    public static final int BASE_SPECIAL_DEFENSE = 80;
    public static final int BASE_SPEED = 80;

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.WATER;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/phione.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/phione.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/phione.png";
    public static final String CRY_PATH = "sounds/cry/489.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/phione.png";

    /**
     * Create a phione
     */
    public Phione() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init phione's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.BUBBLE);
        beginnerSkills.add(SkillFactory.WATER_SPORT);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARM)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUPERSONIC)));
        levelUpSkills.put(24, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUBBLEBEAM)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.ACID_ARMOR)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.WHIRLPOOL)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_PULSE)));
        levelUpSkills.put(54, new ArrayList<Integer>(Arrays.asList(SkillFactory.AQUA_RING)));
        levelUpSkills.put(61, new ArrayList<Integer>(Arrays.asList(SkillFactory.DIVE)));
        levelUpSkills.put(69, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAIN_DANCE)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HAIL.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.BLIZZARD.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.SCALD.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SURF.getValue());
        tmSkills.add(TmId.WATERFALL.getValue());
        tmSkills.add(TmId.DAZZLING_GLEAM.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }
}
