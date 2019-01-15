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
 * Created by gregorykelsie on 2018-05-06.
 */

public class Yamask extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 562;
    public static final String NAME = "Yamask";
    public static final String TYPE_OF_POKEMON = "Spirit";
    public static final String DESCRIPTION = "Each of them carries a mask that used to be its" +
            " face when it was human. Sometimes they look at it and cry.";
    public static final double HEIGHT = 0.5;
    public static final int BASE_EXP = 61;
    public static final int[] EV_YIELD = {0, 0, 1, 0, 0, 0};
    public static final int CAPTURE_RATE = 190;
    public static final double WEIGHT = 1.5;

    public static final Ability FIRST_ABILITY = new Ability.Mummy();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    public static final int BASE_HEALTH = 38;
    public static final int BASE_ATTACK = 30;
    public static final int BASE_DEFENSE = 85;
    public static final int BASE_SPECIAL_ATTACK = 55;
    public static final int BASE_SPECIAL_DEFENSE = 65;
    public static final int BASE_SPEED = 30;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/yamask.png";
    public static final String BACK_PATH = "battle/backs/unova/yamask.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/yamask.png";
    public static final String CRY_PATH = "sounds/cry/562.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/yamask.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GHOST;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a yamask
     */
    public Yamask() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init yamask's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.ASTONISH);
        //PROTECT
        levelUpSkills.put(0, beginnerSkills);
        //5 DISABLE
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.HAZE)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.NIGHT_SHADE)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEX)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.WILL_O_WISP)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.OMINOUS_WIND)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.CURSE)));
        //33 POWER SPLIT AND GUARD SPLIT
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHADOW_BALL)));
        //41 GRUDGE
        //45 MEAN LOOK
        //49 DESTINY BOND
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.WILL_O_WISP.getValue());
        tmSkills.add(TmId.EMBARGO.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.INFESTATION.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.TRICK_ROOM.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init yamask's gender.
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
     * Return Cofagrigus if the yamask is above level 34.
     * @return Cofagrigus if yamask is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 34) {
            return PokemonId.COFAGRIGUS.getValue();
        }
        return -1;
    }
}
