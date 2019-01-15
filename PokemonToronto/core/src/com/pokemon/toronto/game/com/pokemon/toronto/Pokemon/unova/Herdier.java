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
 * Created by gregorykelsie on 2018-05-04.
 */

public class Herdier extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 507;
    public static final String NAME = "Herdier";
    public static final String TYPE_OF_POKEMON = "Loyal Dog";
    public static final String DESCRIPTION = "This very loyal Pokémo helps trainers, and it also" +
            " takes care of other Pokémon.";
    public static final double HEIGHT = 0.9;
    public static final int BASE_EXP = 130;
    public static final int[] EV_YIELD = {0, 2, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 120;
    public static final double WEIGHT = 14.7;

    public static final Ability FIRST_ABILITY = new Ability.Intimidate();
    public static final Ability SECOND_ABILITY = new Ability.SandRush();
    public static final Ability HIDDEN_ABILITY = new Ability.Scrappy();

    //Base Stats
    public static final int BASE_HEALTH = 65;
    public static final int BASE_ATTACK = 80;
    public static final int BASE_DEFENSE = 65;
    public static final int BASE_SPECIAL_ATTACK = 35;
    public static final int BASE_SPECIAL_DEFENSE = 65;
    public static final int BASE_SPEED = 60;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/herdier.png";
    public static final String BACK_PATH = "battle/backs/unova/herdier.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/herdier.png";
    public static final String CRY_PATH = "sounds/cry/507.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/herdier.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a herdier
     */
    public Herdier() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init herdier's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.LEER);
        beginnerSkills.add(SkillFactory.TACKLE);
        //ODOR SLEUTH
        beginnerSkills.add(SkillFactory.BITE);
        levelUpSkills.put(0, beginnerSkills);
        //5 ODOR SLEUTH
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        //12 HELPING HAND
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.WORK_UP)));
        levelUpSkills.put(24, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        //29 ROAR
        //33 RETALIATE
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.REVERSAL)));
        //42 LAST RESORT
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.GIGA_IMPACT)));
        levelUpSkills.put(52, new ArrayList<Integer>(Arrays.asList(SkillFactory.PLAY_ROUGH)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.WILD_CHARGE.getValue());
        tmSkills.add(TmId.SURF.getValue());
        tmSkills.add(TmId.SNARL.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init herdier's gender.
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

    /**
     * Return Stoutland if the herdier is above level 32.
     * @return Stoutland if herdier is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 32) {
            return PokemonId.STOUTLAND.getValue();
        }
        return -1;
    }
}
