package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kalos;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-02-02.
 */

public class Aegislash extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 681;
    private static final String NAME = "Aegislash";
    private static final int BASE_EXP = 234;
    private static final int[] EV_YIELD = {0, 2, 0, 1, 0, 0};
    private static final int CAPTURE_RATE = 45;
    private static final double WEIGHT = 53;

    private static final Ability FIRST_ABILITY = new Ability.StanceChange();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    private static final int BASE_HEALTH = 60;
    private static final int BASE_ATTACK = 150;
    private static final int BASE_DEFENSE = 50;
    private static final int BASE_SPECIAL_ATTACK = 150;
    private static final int BASE_SPECIAL_DEFENSE = 50;
    private static final int BASE_SPEED = 60;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/kalos/aegislash.png";
    private static final String BACK_PATH = "battle/backs/kalos/aegislash.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/kalos/aegislash.png";
    private static final String CRY_PATH = "sounds/cry/680.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kalos/aegislash.png";

    private String SHIELD_ICON_PATH = "pokemonSprites/kalos/aegislash-shield.png";
    private String SHIELD_BACK_PATH = "battle/backs/kalos/aegislash-shield.png";
    private String SHIELD_MINI_PATH = "pokemonMenu/sprites/kalos/aegislash-shield.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.STEEL;
    private static final Type TYPE_TWO = Type.GHOST;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    private final int BLADE_FORM = 0;
    private final int SHIELD_FORM = 1;
    private int aegislashForm;

    /**
     * Create a aegislash
     */
    public Aegislash() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
        aegislashForm = SHIELD_FORM;
    }

    /**
     * Init aegislash's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.FURY_CUTTER);
        beginnerSkills.add(SkillFactory.PURSUIT);
        beginnerSkills.add(SkillFactory.AUTOTOMIZE);
        beginnerSkills.add(SkillFactory.SHADOW_SNEAK);
        beginnerSkills.add(SkillFactory.SLASH);
        beginnerSkills.add(SkillFactory.IRON_DEFENSE);
        beginnerSkills.add(SkillFactory.NIGHT_SLASH);
        //POWER TRICK
        beginnerSkills.add(SkillFactory.IRON_HEAD);
        beginnerSkills.add(SkillFactory.HEAD_SMASH);
        beginnerSkills.add(SkillFactory.SWORDS_DANCE);
        beginnerSkills.add(SkillFactory.AERIAL_ACE);
        //KING'S SHIELD
        beginnerSkills.add(SkillFactory.SACRED_SWORD);
        levelUpSkills.put(0, beginnerSkills);
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FALSE_SWIPE.getValue());
        tmSkills.add(TmId.BRUTAL_SWING.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.GYRO_BALL.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.FLASH_CANNON.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Return the Pokemon's base attack stat.
     * @return Base Attack
     */
    @Override
    public int getBaseStatAttack() {
        if (aegislashForm == SHIELD_FORM) {
            return 50;
        }
        return baseStats[ATTACK];
    }

    /**
     * Return the Pokemon's base special attack
     * @return Base Special Attack
     */
    @Override
    public int getBaseStatSpeicialAttack() {
        if (aegislashForm == SHIELD_FORM) {
            return 50;
        }
        return baseStats[SPECIAL_ATTACK];
    }

    /**
     * Return the Pokemon's base defense.
     * @return Base Defense
     */
    @Override
    public int getBaseStatDefense() {
        if (aegislashForm == SHIELD_FORM) {
            return 150;
        }
        return baseStats[DEFENSE];
    }

    /**
     * Return the Pokemon's base special defense.
     * @return Base Special Defense
     */
    @Override
    public int getBaseStatSpecialDefense() {
        if (aegislashForm == SHIELD_FORM) {
            return 150;
        }
        return baseStats[SPECIAL_DEFENSE];
    }

    /**
     * Reset the variables that only reset when the battle is over.
     * Ex: Mimikyu's disguise.
     */
    public void resetEndBattleVariables() {
        aegislashForm = SHIELD_FORM;
    }

    /**
     * Return the Pokemon's Front Image path
     * @return The path for the Pokemon's front image.
     */
    @Override
    public String getMapIconPath() {
        if (aegislashForm == SHIELD_FORM) {
            return SHIELD_ICON_PATH;
        }
        return mapIconPath;
    }

    /**
     * Return the Pokemon's Back Image Path
     * @return The path for the Pokemon's back image.
     */
    @Override
    public String getBackPath() {
        if (aegislashForm == SHIELD_FORM) {
            return SHIELD_BACK_PATH;
        }
        return backPath;
    }

    /**
     * Return the Pokemon's mini image path.
     * @return The path for the Pokemon's mini image.
     */
    @Override
    public String getMiniIconPath() {
        if (aegislashForm == SHIELD_FORM) {
            return SHIELD_ICON_PATH;
        }
        return miniPath;
    }


    /**
     * Change the Pokemon to blade form, only aegislash currently will use this method.
     */
    @Override
    public void changeToBladeForm() {
        aegislashForm = BLADE_FORM;
    }

    /**
     * Change the Pokemon to shield form, only aegislash currently will use this method.
     */
    @Override
    public void changeToShieldForm() {
        aegislashForm = SHIELD_FORM;
    }

    @Override
    public boolean isInBladeForm() {
        if (aegislashForm == BLADE_FORM) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isInShieldForm() {
        if (aegislashForm == SHIELD_FORM) {
            return true;
        }
        return false;
    }

    /**
     * Init aegislash's gender.
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
