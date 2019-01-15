package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-04-29.
 */

public class Lickilicky extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 463;
    private static final String NAME = "Lickilicky";
    public static final String TYPE_OF_POKEMON = "Licking";
    public static final String DESCRIPTION = "The long tongue is always soggy with slobber. The" +
            " saliva contains a solvent that causes numbness.";
    public static final double HEIGHT = 1.7;
    private static final int BASE_EXP = 180;
    private static final int[] EV_YIELD = {3, 0, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 30;
    private static final double WEIGHT = 140;

    private static final Ability FIRST_ABILITY = new Ability.OwnTempo();
    private static final Ability SECOND_ABILITY = new Ability.Oblivious();
    private static final Ability HIDDEN_ABILITY = new Ability.CloudNine();

    //Base Stats
    private static final int BASE_HEALTH = 110;
    private static final int BASE_ATTACK = 85;
    private static final int BASE_DEFENSE = 95;
    private static final int BASE_SPECIAL_ATTACK = 80;
    private static final int BASE_SPECIAL_DEFENSE = 95;
    private static final int BASE_SPEED = 50;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/sinnoh/lickilicky.png";
    private static final String BACK_PATH = "battle/backs/sinnoh/lickilicky.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/lickilicky.png";
    private static final String CRY_PATH = "sounds/cry/463.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/lickilicky.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a lickilicky
     */
    public Lickilicky() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init lickilicky's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.WRING_OUT);
        beginnerSkills.add(SkillFactory.POWER_WHIP);
        beginnerSkills.add(SkillFactory.LICK);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUPERSONIC)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.DEFENSE_CURL)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.KNOCK_OFF)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.WRAP)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.STOMP)));
        //TODO: DISABLE 25
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLAM)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROLLOUT)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHIP_AWAY)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.REFRESH)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCREECH)));
        levelUpSkills.put(53, new ArrayList<Integer>(Arrays.asList(SkillFactory.POWER_WHIP)));
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.WRING_OUT)));
        levelUpSkills.put(61, new ArrayList<Integer>(Arrays.asList(SkillFactory.GYRO_BALL)));
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
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FLAMETHROWER.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.FIRE_BLAST.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.BRUTAL_SWING.getValue());
        tmSkills.add(TmId.EXPLOSION.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.GYRO_BALL.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.DRAGON_TAIL.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SURF.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }
}
