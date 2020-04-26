package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-04-29.
 */

public class Croagunk extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 453;
    public static final String NAME = "Croagunk";
    public static final String TYPE_OF_POKEMON = "Toxic Mouth";
    public static final String DESCRIPTION = "It rarely fights fairly, but that is strictly to" +
            " ensure survival. It is popular as a mascot.";
    public static final double HEIGHT = 0.7;
    public static final int BASE_EXP = 60;
    public static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 140;
    public static final double WEIGHT = 23;

    public static final Ability FIRST_ABILITY = new Ability.Anticipation();
    public static final Ability SECOND_ABILITY = new Ability.DrySkin();
    public static final Ability HIDDEN_ABILITY = new Ability.PoisonTouch();

    //Base Stats
    public static final int BASE_HEALTH = 48;
    public static final int BASE_ATTACK = 61;
    public static final int BASE_DEFENSE = 40;
    public static final int BASE_SPECIAL_ATTACK = 61;
    public static final int BASE_SPECIAL_DEFENSE = 40;
    public static final int BASE_SPEED = 50;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/croagunk.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/croagunk.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/croagunk.png";
    public static final String CRY_PATH = "sounds/cry/453.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/croagunk.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.POISON;
    public static final Type TYPE_TWO = Type.FIGHTING;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a croagunk
     */
    public Croagunk() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init croagunk's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.ASTONISH);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_SLAP)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_STING)));
        //10 TAUNT
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.PURSUIT)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT_ATTACK)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.REVENGE)));
        levelUpSkills.put(24, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWAGGER)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_BOMB)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUCKER_PUNCH)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.VENOSHOCK)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.NASTY_PLOT)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_JAB)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLUDGE_BOMB)));
        //47 BELCH
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLATTER)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.BULK_UP.getValue());
        tmSkills.add(TmId.VENOSHOCK.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SLUDGE_WAVE.getValue());
        tmSkills.add(TmId.SLUDGE_BOMB.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.LOW_SWEEP.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.EMBARGO.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.X_SCISSOR.getValue());
        tmSkills.add(TmId.POISON_JAB.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init croagunk's gender.
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
     * Return Toxicroak if the Croagunk is above level 37.
     * @return Toxicroak if Croagunk is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 37) {
            return PokemonId.TOXICROAK.getValue();
        }
        return -1;
    }
}