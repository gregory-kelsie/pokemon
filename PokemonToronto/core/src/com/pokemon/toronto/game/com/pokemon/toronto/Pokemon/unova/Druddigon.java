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

public class Druddigon extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 621;
    public static final String NAME = "Druddigon";
    public static final String TYPE_OF_POKEMON = "Cave";
    public static final String DESCRIPTION = "It warms its body by absorbing sunlight with its " +
            "wings. When its body temperature falls, it can no longer move.";
    public static final double HEIGHT = 1.6;
    public static final int BASE_EXP = 170;
    public static final int[] EV_YIELD = {0, 2, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 139;

    public static final Ability FIRST_ABILITY = new Ability.RoughSkin();
    public static final Ability SECOND_ABILITY = new Ability.SheerForce();
    public static final Ability HIDDEN_ABILITY = new Ability.MoldBreaker();

    //Base Stats
    public static final int BASE_HEALTH = 77;
    public static final int BASE_ATTACK = 120;
    public static final int BASE_DEFENSE = 90;
    public static final int BASE_SPECIAL_ATTACK = 60;
    public static final int BASE_SPECIAL_DEFENSE = 90;
    public static final int BASE_SPEED = 48;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/druddigon.png";
    public static final String BACK_PATH = "battle/backs/unova/druddigon.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/druddigon.png";
    public static final String CRY_PATH = "sounds/cry/621.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/druddigon.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.DRAGON;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a druddigon
     */
    public Druddigon() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init druddigon's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.LEER);
        beginnerSkills.add(SkillFactory.SCRATCH);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.HONE_CLAWS)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCARY_FACE)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAGON_RAGE)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLASH)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAGON_CLAW)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHIP_AWAY)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.REVENGE)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.NIGHT_SLASH)));
        //45 DRAGON TAIL
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_CLIMB)));
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUPERPOWER)));
        levelUpSkills.put(62, new ArrayList<Integer>(Arrays.asList(SkillFactory.OUTRAGE)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.DRAGON_CLAW.getValue());
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SMACK_DOWN.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FLAMETHROWER.getValue());
        tmSkills.add(TmId.SLUDGE_BOMB.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.DRAGON_TAIL.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.FLASH_CANNON.getValue());
        tmSkills.add(TmId.SURF.getValue());
        tmSkills.add(TmId.SNARL.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init druddigon's gender.
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
