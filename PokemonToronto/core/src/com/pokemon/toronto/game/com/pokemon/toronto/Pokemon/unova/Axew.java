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

public class Axew extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 610;
    public static final String NAME = "Axew";
    public static final String TYPE_OF_POKEMON = "Tusk";
    public static final String DESCRIPTION = "They use their tusks to crush the berries they " +
            "eat. Repeated regrowth makes their tusks strong and sharp.";
    public static final double HEIGHT = 0.6;
    public static final int BASE_EXP = 64;
    public static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 75;
    public static final double WEIGHT = 18;

    public static final Ability FIRST_ABILITY = new Ability.Rivalry();
    public static final Ability SECOND_ABILITY = new Ability.MoldBreaker();
    public static final Ability HIDDEN_ABILITY = new Ability.Unnerve();

    //Base Stats
    public static final int BASE_HEALTH = 46;
    public static final int BASE_ATTACK = 87;
    public static final int BASE_DEFENSE = 60;
    public static final int BASE_SPECIAL_ATTACK = 30;
    public static final int BASE_SPECIAL_DEFENSE = 40;
    public static final int BASE_SPEED = 57;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/axew.png";
    public static final String BACK_PATH = "battle/backs/unova/axew.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/axew.png";
    public static final String CRY_PATH = "sounds/cry/610.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/axew.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.DRAGON;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    /**
     * Create a axew
     */
    public Axew() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init axew's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SCRATCH);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEER)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.ASSURANCE)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAGON_RAGE)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.DUAL_CHOP)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCARY_FACE)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLASH)));
        levelUpSkills.put(24, new ArrayList<Integer>(Arrays.asList(SkillFactory.FALSE_SWIPE)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAGON_CLAW)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAGON_DANCE)));
        //36 TAUNT
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAGON_PULSE)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWORDS_DANCE)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.GUILLOTINE)));
        levelUpSkills.put(56, new ArrayList<Integer>(Arrays.asList(SkillFactory.OUTRAGE)));
        levelUpSkills.put(61, new ArrayList<Integer>(Arrays.asList(SkillFactory.GIGA_IMPACT)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.DRAGON_CLAW.getValue());
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FALSE_SWIPE.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.X_SCISSOR.getValue());
        tmSkills.add(TmId.POISON_JAB.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init axew's gender.
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
     * Return Fraxure if the axew is above level 38.
     * @return Fraxure if axew is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 38) {
            return PokemonId.FRAXURE.getValue();
        }
        return -1;
    }
}
