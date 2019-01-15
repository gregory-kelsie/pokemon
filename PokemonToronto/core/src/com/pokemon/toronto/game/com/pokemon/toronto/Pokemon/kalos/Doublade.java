package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kalos;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-02-02.
 */

public class Doublade extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 680;
    public static final String NAME = "Doublade";
    public static final String TYPE_OF_POKEMON = "Sword";
    public static final String DESCRIPTION = "The complex attack patterns of its two swords" +
            " are unstoppable, even for an opponent greatly accomplished at swordplay.";
    public static final double HEIGHT = 0.8;
    public static final int BASE_EXP = 157;
    public static final int[] EV_YIELD = {0, 0, 2, 0, 0, 0};
    public static final int CAPTURE_RATE = 90;
    public static final double WEIGHT = 4.5;

    public static final Ability FIRST_ABILITY = new Ability.NoGuard();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    public static final int BASE_HEALTH = 59;
    public static final int BASE_ATTACK = 110;
    public static final int BASE_DEFENSE = 150;
    public static final int BASE_SPECIAL_ATTACK = 45;
    public static final int BASE_SPECIAL_DEFENSE = 49;
    public static final int BASE_SPEED = 35;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/doublade.png";
    public static final String BACK_PATH = "battle/backs/kalos/doublade.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/doublade.png";
    public static final String CRY_PATH = "sounds/cry/680.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/doublade.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.STEEL;
    public static final Type TYPE_TWO = Type.GHOST;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a doublade
     */
    public Doublade() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init doublade's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SWORDS_DANCE);
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.FURY_CUTTER);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_CUTTER)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.METAL_SOUND)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.PURSUIT)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.AUTOTOMIZE)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHADOW_SNEAK)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.AERIAL_ACE)));
        //26 RETALIATE
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLASH)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.IRON_DEFENSE)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.NIGHT_SLASH)));
        //41 POWER TRICK
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.IRON_HEAD)));
        levelUpSkills.put(51, new ArrayList<Integer>(Arrays.asList(SkillFactory.SACRED_SWORD)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.FALSE_SWIPE.getValue());
        tmSkills.add(TmId.BRUTAL_SWING.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
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
     * Init doublade's gender.
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
     * Return Aegislash
     * @return Aegislash
     */
    @Override
    public int getDuskStoneEvolutionId() {
        return PokemonId.AEGISLASH.getValue();
    }
}
