package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kalos;

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

public class Yveltal extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 717;
    public static final String NAME = "Yveltal";
    public static final String TYPE_OF_POKEMON = "Destruction";
    public static final String DESCRIPTION = "When this legendary Pokémon's wings and tail " +
            "feathers spread wide and glow red, it absorbs the life force of living creatures.";
    public static final double HEIGHT = 5.8;
    public static final int BASE_EXP = 306;
    public static final int[] EV_YIELD = {3, 0, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 203;

    public static final Ability FIRST_ABILITY = new Ability.DarkAura();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    public static final int BASE_HEALTH = 126;
    public static final int BASE_ATTACK = 131;
    public static final int BASE_DEFENSE = 95;
    public static final int BASE_SPECIAL_ATTACK = 131;
    public static final int BASE_SPECIAL_DEFENSE = 98;
    public static final int BASE_SPEED = 99;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/yveltal.png";
    public static final String BACK_PATH = "battle/backs/kalos/yveltal.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/yveltal.png";
    public static final String CRY_PATH = "sounds/cry/717.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/yveltal.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Pokemon.Type.DARK;
    public static final Pokemon.Type TYPE_TWO = Type.FLYING;

    //Exp
    public static final Pokemon.ExpType EXP_TYPE = ExpType.SLOW;

    /**
     * Create a yveltal
     */
    public Yveltal() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init yveltal's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.HURRICANE);
        beginnerSkills.add(SkillFactory.RAZOR_WIND);
        //TAUNT
        beginnerSkills.add(SkillFactory.ROOST);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_TEAM)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.AIR_SLASH)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.SNARL)));
        //26 OBLIVION WING
        //35 DISABLE
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.DARK_PULSE)));
        levelUpSkills.put(51, new ArrayList<Integer>(Arrays.asList(SkillFactory.FOUL_PLAY)));
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.PHANTOM_FORCE)));
        levelUpSkills.put(59, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCHIC)));
        levelUpSkills.put(63, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAGON_RUSH)));
        levelUpSkills.put(72, new ArrayList<Integer>(Arrays.asList(SkillFactory.FOCUS_BLAST)));
        levelUpSkills.put(80, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUCKER_PUNCH)));
        levelUpSkills.put(88, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPER_BEAM)));
        levelUpSkills.put(93, new ArrayList<Integer>(Arrays.asList(SkillFactory.SKY_ATTACK)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.DRAGON_CLAW.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.ROOST.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.STEEL_WING.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.SKY_DROP.getValue());
        tmSkills.add(TmId.ACROBATICS.getValue());
        tmSkills.add(TmId.EMBARGO.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.FLY.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SNARL.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }
}
