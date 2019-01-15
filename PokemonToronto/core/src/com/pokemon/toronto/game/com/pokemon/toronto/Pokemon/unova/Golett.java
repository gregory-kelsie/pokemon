package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.unova;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-05-07.
 */

public class Golett extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 622;
    public static final String NAME = "Golett";
    public static final String TYPE_OF_POKEMON = "Automation";
    public static final String DESCRIPTION = "Ancient science fashioned this Pokémon from clay. " +
            "It's been active for thousands of years.";
    public static final double HEIGHT = 1;
    public static final int BASE_EXP = 61;
    public static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 190;
    public static final double WEIGHT = 92;

    public static final Ability FIRST_ABILITY = new Ability.IronFist();
    public static final Ability SECOND_ABILITY = new Ability.Klutz();
    public static final Ability HIDDEN_ABILITY = new Ability.NoGuard();

    //Base Stats
    public static final int BASE_HEALTH = 59;
    public static final int BASE_ATTACK = 74;
    public static final int BASE_DEFENSE = 50;
    public static final int BASE_SPECIAL_ATTACK = 35;
    public static final int BASE_SPECIAL_DEFENSE = 50;
    public static final int BASE_SPEED = 35;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/golett.png";
    public static final String BACK_PATH = "battle/backs/unova/golett.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/golett.png";
    public static final String CRY_PATH = "sounds/cry/622.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/golett.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GROUND;
    public static final Type TYPE_TWO = Type.GHOST;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a golett
     */
    public Golett() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init golett's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.POUND);
        beginnerSkills.add(SkillFactory.ASTONISH);
        beginnerSkills.add(SkillFactory.DEFENSE_CURL);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_SLAP)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROLLOUT)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHADOW_PUNCH)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.IRON_DEFENSE)));
        //21 STOMPING TANTRUM
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEGA_PUNCH)));
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.MAGNITUDE)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.DYNAMIC_PUNCH)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.NIGHT_SHADE)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.CURSE)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.EARTHQUAKE)));
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.HAMMER_ARM)));
        //61 FOCUS PUNCH
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.LOW_SWEEP.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.ROCK_POLISH.getValue());
        tmSkills.add(TmId.GYRO_BALL.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }


    /**
     * Return Golurk if the golett is above level 43.
     * @return Golurk if golett is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 43) {
            return PokemonId.GOLURK.getValue();
        }
        return -1;
    }
}
