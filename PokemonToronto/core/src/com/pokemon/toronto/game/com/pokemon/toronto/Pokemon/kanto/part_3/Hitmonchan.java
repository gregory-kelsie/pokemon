package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 9/21/2017.
 */

public class Hitmonchan extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 107;
    public static final String NAME = "Hitmonchan";
    public static final String TYPE_OF_POKEMON = "Punching";
    public static final String DESCRIPTION = "The spirit of a pro boxer has infused this" +
            " Pokémon. It throws punches that are faster than a bullet train.";

    public static final int BASE_EXP = 140;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 2, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 50.2;
    public static final double HEIGHT = 1.4;

    public static final Ability FIRST_ABILITY = new Ability.KeenEye();
    public static final Ability SECOND_ABILITY = new Ability.IronFist();
    public static final Ability HIDDEN_ABILITY = new Ability.InnerFocus();

    //Base Stats
    public static final int BASE_HEALTH = 50;
    public static final int BASE_ATTACK = 105;
    public static final int BASE_DEFENSE = 79;
    public static final int BASE_SPECIAL_ATTACK = 35;
    public static final int BASE_SPECIAL_DEFENSE = 110;
    public static final int BASE_SPEED = 76;

    //Typing
    public static final Type TYPE_ONE = Type.FIGHTING;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/hitmonchan.png";
    public static final String BACK_PATH = "battle/backs/hitmonchan.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/hitmonchan.png";
    public static final String CRY_PATH = "sounds/cry/107.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kanto/107.png";

    /**
     * Create a Hitmonchan
     */
    public Hitmonchan() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    @Override
    protected void initGender() {
        gender = 'M';
    }

    /**
     * Init Hitmonchan's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.CLOSE_COMBAT);
        //TODO: COUNTER
        //TODO: FOCUS PUNCH
        beginnerSkills.add(SkillFactory.REVENGE);
        beginnerSkills.add(SkillFactory.AGILITY);
        beginnerSkills.add(SkillFactory.PURSUIT);
        beginnerSkills.add(SkillFactory.MACH_PUNCH);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.AGILITY)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.PURSUIT)));
        List<Integer> speedPunches = new ArrayList<Integer>();
        speedPunches.add(SkillFactory.MACH_PUNCH);
        speedPunches.add(SkillFactory.BULLET_PUNCH);
        levelUpSkills.put(16, speedPunches);
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.VACUUM_WAVE)));
        //TODO: QUICK GUARD 31
        ArrayList<Integer> elementalPunches = new ArrayList<Integer>();
        elementalPunches.add(SkillFactory.THUNDER_PUNCH);
        elementalPunches.add(SkillFactory.ICE_PUNCH);
        elementalPunches.add(SkillFactory.FIRE_PUNCH);
        levelUpSkills.put(36, elementalPunches);
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.SKY_UPPERCUT)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEGA_PUNCH)));
        //TODO: DETECT 50
        //TODO: FOCUS PUNCH 56
        //TODO: COUNTER 61
        levelUpSkills.put(66, new ArrayList<Integer>(Arrays.asList(SkillFactory.CLOSE_COMBAT)));
        initEvolutionSkills();
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.BULK_UP.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.LOW_SWEEP.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.POISON_JAB.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.COMET_PUNCH);
    }
}
