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

public class Klinklang extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 601;
    public static final String NAME = "Klinklang";
    public static final String TYPE_OF_POKEMON = "Gear";
    public static final String DESCRIPTION = "Its red core functions as an energy tank. It fires" +
            " the charged energy through its spikes into an area.";
    public static final double HEIGHT = 0.6;
    public static final int BASE_EXP = 234;
    public static final int[] EV_YIELD = {0, 0, 3, 0, 0, 0};
    public static final int CAPTURE_RATE = 30;
    public static final double WEIGHT = 81;

    public static final Ability FIRST_ABILITY = new Ability.Plus();
    public static final Ability SECOND_ABILITY = new Ability.Minus();
    public static final Ability HIDDEN_ABILITY = new Ability.ClearBody();

    //Base Stats
    public static final int BASE_HEALTH = 60;
    public static final int BASE_ATTACK = 100;
    public static final int BASE_DEFENSE = 115;
    public static final int BASE_SPECIAL_ATTACK = 70;
    public static final int BASE_SPECIAL_DEFENSE = 85;
    public static final int BASE_SPEED = 90;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/klinklang.png";
    public static final String BACK_PATH = "battle/backs/unova/klinklang.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/klinklang.png";
    public static final String CRY_PATH = "sounds/cry/601.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/klinklang.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.STEEL;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a klinklang
     */
    public Klinklang() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init klinklang's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //GEAR UP
        beginnerSkills.add(SkillFactory.VICEGRIP);
        beginnerSkills.add(SkillFactory.CHARGE);
        beginnerSkills.add(SkillFactory.THUNDER_SHOCK);
        beginnerSkills.add(SkillFactory.GEAR_GRIND);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARGE)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDER_SHOCK)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.GEAR_GRIND)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.BIND)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARGE_BEAM)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.AUTOTOMIZE)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.MIRROR_SHOT)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCREECH)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.DISCHARGE)));
        levelUpSkills.put(48, new ArrayList<Integer>(Arrays.asList(SkillFactory.METAL_SOUND)));
        levelUpSkills.put(54, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHIFT_GEAR)));
        levelUpSkills.put(60, new ArrayList<Integer>(Arrays.asList(SkillFactory.LOCK_ON)));
        levelUpSkills.put(66, new ArrayList<Integer>(Arrays.asList(SkillFactory.ZAP_CANNON)));
        levelUpSkills.put(72, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPER_BEAM)));
        //TODO: INIT EVOLUTION SKILL - MAGNETIC FLUX
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.ROCK_POLISH.getValue());
        tmSkills.add(TmId.VOLT_SWITCH.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.FLASH_CANNON.getValue());
        tmSkills.add(TmId.TRICK_ROOM.getValue());
        tmSkills.add(TmId.WILD_CHARGE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }
}
