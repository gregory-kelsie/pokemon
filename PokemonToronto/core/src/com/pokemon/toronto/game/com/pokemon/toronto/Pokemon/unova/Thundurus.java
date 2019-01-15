package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.unova;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-08-20.
 */

public class Thundurus extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 642;
    public static final String NAME = "Thundurus";
    public static final String TYPE_OF_POKEMON = "Bolt Strike";
    public static final String DESCRIPTION = "The spikes on its tail discharge immense bolts of" +
            " lightning. It flies around the Unova region firing off lightning bolts.";
    public static final double HEIGHT = 1.5;
    public static final int BASE_EXP = 261;
    public static final int[] EV_YIELD = {0, 3, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 3;
    public static final double WEIGHT = 61;

    public static final Ability FIRST_ABILITY = new Ability.Prankster();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.Defiant();

    //Base Stats
    public static final int BASE_HEALTH = 79;
    public static final int BASE_ATTACK = 115;
    public static final int BASE_DEFENSE = 70;
    public static final int BASE_SPECIAL_ATTACK = 125;
    public static final int BASE_SPECIAL_DEFENSE = 80;
    public static final int BASE_SPEED = 111;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/thundurus.png";
    public static final String BACK_PATH = "battle/backs/unova/thundurus.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/thundurus.png";
    public static final String CRY_PATH = "sounds/cry/642.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/thundurus.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.ELECTRIC;
    public static final Type TYPE_TWO = Type.FLYING;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    /**
     * Create a thundurus
     */
    public Thundurus() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }


    /**
     * Init thundurus's gender.
     */
    @Override
    protected void initGender() {
        gender = 'M';
    }

    /**
     * Init thundurus's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.THRASH);
        beginnerSkills.add(SkillFactory.HAMMER_ARM);
        beginnerSkills.add(SkillFactory.NASTY_PLOT);
        beginnerSkills.add(SkillFactory.UPROAR);
        beginnerSkills.add(SkillFactory.ASTONISH);
        beginnerSkills.add(SkillFactory.THUNDER_SHOCK);
        beginnerSkills.add(SkillFactory.SWAGGER);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.REVENGE)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHOCK_WAVE)));
        //25 HEAL BLOCK
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.AGILITY)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.DISCHARGE)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARGE)));
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.NASTY_PLOT)));
        levelUpSkills.put(61, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDER)));
        levelUpSkills.put(67, new ArrayList<Integer>(Arrays.asList(SkillFactory.DARK_PULSE)));
        levelUpSkills.put(73, new ArrayList<Integer>(Arrays.asList(SkillFactory.HAMMER_ARM)));
        levelUpSkills.put(79, new ArrayList<Integer>(Arrays.asList(SkillFactory.THRASH)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.BULK_UP.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SMACK_DOWN.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SLUDGE_WAVE.getValue());
        tmSkills.add(TmId.SLUDGE_BOMB.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.SKY_DROP.getValue());
        tmSkills.add(TmId.BRUTAL_SWING.getValue());
        tmSkills.add(TmId.ACROBATICS.getValue());
        tmSkills.add(TmId.EMBARGO.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.SMART_STRIKE.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.VOLT_SWITCH.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.FLY.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.FLASH_CANNON.getValue());
        tmSkills.add(TmId.WILD_CHARGE.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }
}
