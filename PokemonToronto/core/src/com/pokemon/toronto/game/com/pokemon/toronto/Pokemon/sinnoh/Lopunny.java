package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-04-24.
 */

public class Lopunny extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 428;
    public static final String NAME = "Lopunny";
    public static final String TYPE_OF_POKEMON = "Rabbit";
    public static final String DESCRIPTION = "The ears appear to be delicate. If they are touched" +
            " roughly, it kicks with its graceful legs.";
    public static final double HEIGHT = 1.2;
    public static final int BASE_EXP = 168;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 2};
    public static final int CAPTURE_RATE = 60;
    public static final double WEIGHT = 33.3;

    public static final Ability FIRST_ABILITY = new Ability.CuteCharm();
    public static final Ability SECOND_ABILITY = new Ability.Klutz();
    public static final Ability HIDDEN_ABILITY = new Ability.Limber();

    //Base Stats
    public static final int BASE_HEALTH = 65;
    public static final int BASE_ATTACK = 76;
    public static final int BASE_DEFENSE = 84;
    public static final int BASE_SPECIAL_ATTACK = 54;
    public static final int BASE_SPECIAL_DEFENSE = 96;
    public static final int BASE_SPEED = 105;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/lopunny.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/lopunny.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/lopunny.png";
    public static final String CRY_PATH = "sounds/cry/428.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/lopunny.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a lopunny
     */
    public Lopunny() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init lopunny's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //HEALING WISH
        beginnerSkills.add(SkillFactory.BOUNCE);
        //ROTOTILLER
        //MIRROR COAT
        //MAGIC COAT
        beginnerSkills.add(SkillFactory.DEFENSE_CURL);
        beginnerSkills.add(SkillFactory.SPLASH);
        beginnerSkills.add(SkillFactory.POUND);
        //FORESIGHT
        levelUpSkills.put(0, beginnerSkills);
        //6 ENDURE
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.BABY_DOLL_EYES)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.JUMP_KICK)));
        //26 BATON PASS
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.AGILITY)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.DIZZY_PUNCH)));
        //43 AFTER YOU
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARM)));
        //50 ENTERTAINMENT
        levelUpSkills.put(56, new ArrayList<Integer>(Arrays.asList(SkillFactory.BOUNCE)));
        //63 HEALING WISH
        levelUpSkills.put(66, new ArrayList<Integer>(Arrays.asList(SkillFactory.HIGH_JUMP_KICK)));
        //TODO: EVOLVE SKILL - RETURN
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.BLIZZARD.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.LOW_SWEEP.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.BRUTAL_SWING.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init lopunny's gender.
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
