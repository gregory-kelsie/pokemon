package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.hoenn;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-07-16.
 */

public class Registeel extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 379;
    public static final String NAME = "Registeel";
    public static final String TYPE_OF_POKEMON = "Iron";
    public static final String DESCRIPTION = "Tempered by pressure underground over tens of " +
            "thousands of years, its body cannot be scratched.";
    public static final int BASE_EXP = 261;
    public static final int[] EV_YIELD = {0, 0, 2, 0, 1, 0};
    public static final int CAPTURE_RATE = 3;
    public static final double WEIGHT = 205;
    public static final double HEIGHT = 1.9;

    public static final Ability FIRST_ABILITY = new Ability.ClearBody();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.LightMetal();

    //Base Stats
    public static final int BASE_HEALTH = 80;
    public static final int BASE_ATTACK = 75;
    public static final int BASE_DEFENSE = 150;
    public static final int BASE_SPECIAL_ATTACK = 75;
    public static final int BASE_SPECIAL_DEFENSE = 150;
    public static final int BASE_SPEED = 50;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/hoenn/registeel.png";
    public static final String BACK_PATH = "battle/backs/hoenn/registeel.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/hoenn/registeel.png";
    public static final String CRY_PATH = "sounds/cry/379.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/hoenn/registeel.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.STEEL;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    /**
     * Create a registeel
     */
    public Registeel() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init registeel's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.EXPLOSION);
        beginnerSkills.add(SkillFactory.STOMP);
        beginnerSkills.add(SkillFactory.METAL_CLAW);
        beginnerSkills.add(SkillFactory.CHARGE_BEAM);
        beginnerSkills.add(SkillFactory.BULLDOZE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.METAL_CLAW)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARGE_BEAM)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.BULLDOZE)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.CURSE)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.ANCIENT_POWER)));
        List<Integer> defenseSkills = new ArrayList<Integer>();
        defenseSkills.add(SkillFactory.IRON_DEFENSE);
        defenseSkills.add(SkillFactory.AMNESIA);
        levelUpSkills.put(37, defenseSkills);
        List<Integer> ironSkills = new ArrayList<Integer>();
        ironSkills.add(SkillFactory.IRON_HEAD);
        ironSkills.add(SkillFactory.FLASH_CANNON);
        levelUpSkills.put(43, ironSkills);
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.HAMMER_ARM)));
        List<Integer> lockSkills = new ArrayList<Integer>();
        lockSkills.add(SkillFactory.LOCK_ON);
        lockSkills.add(SkillFactory.ZAP_CANNON);
        levelUpSkills.put(55, lockSkills);
        levelUpSkills.put(61, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUPERPOWER)));
        levelUpSkills.put(67, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPER_BEAM)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.EXPLOSION.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.ROCK_POLISH.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.FLASH_CANNON.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }
}
