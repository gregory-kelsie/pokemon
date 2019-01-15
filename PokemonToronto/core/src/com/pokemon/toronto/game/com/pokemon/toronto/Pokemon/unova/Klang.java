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

public class Klang extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 600;
    public static final String NAME = "Klang";
    public static final String TYPE_OF_POKEMON = "Gear";
    public static final String DESCRIPTION = "By changing the direction in which it rotates, it" +
            " communicates its feelings to others. When angry, it rotates faster.";
    public static final double HEIGHT = 0.6;
    public static final int BASE_EXP = 154;
    public static final int[] EV_YIELD = {0, 0, 2, 0, 0, 0};
    public static final int CAPTURE_RATE = 60;
    public static final double WEIGHT = 51;

    public static final Ability FIRST_ABILITY = new Ability.Plus();
    public static final Ability SECOND_ABILITY = new Ability.Minus();
    public static final Ability HIDDEN_ABILITY = new Ability.ClearBody();

    //Base Stats
    public static final int BASE_HEALTH = 60;
    public static final int BASE_ATTACK = 80;
    public static final int BASE_DEFENSE = 95;
    public static final int BASE_SPECIAL_ATTACK = 70;
    public static final int BASE_SPECIAL_DEFENSE = 85;
    public static final int BASE_SPEED = 50;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/klang.png";
    public static final String BACK_PATH = "battle/backs/unova/klang.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/klang.png";
    public static final String CRY_PATH = "sounds/cry/600.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/klang.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.STEEL;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a klang
     */
    public Klang() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init klang's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
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
        levelUpSkills.put(52, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHIFT_GEAR)));
        levelUpSkills.put(56, new ArrayList<Integer>(Arrays.asList(SkillFactory.LOCK_ON)));
        levelUpSkills.put(60, new ArrayList<Integer>(Arrays.asList(SkillFactory.ZAP_CANNON)));
        levelUpSkills.put(64, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPER_BEAM)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.ROCK_POLISH.getValue());
        tmSkills.add(TmId.VOLT_SWITCH.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.FLASH_CANNON.getValue());
        tmSkills.add(TmId.WILD_CHARGE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Return Klinklang if the klang is above level 49.
     * @return Klinklang if klang is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 49) {
            return PokemonId.KLINKLANG.getValue();
        }
        return -1;
    }
}
