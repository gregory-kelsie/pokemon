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
 * Created by gregorykelsie on 2018-05-06.
 */

public class Venipede extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 543;
    public static final String NAME = "Venipede";
    public static final String TYPE_OF_POKEMON = "Centipede";
    public static final String DESCRIPTION = "It discovers what is going on around it by using" +
            " the feelers on its head and tail. It is brutally aggressive.";
    public static final double HEIGHT = 0.4;
    public static final int BASE_EXP = 52;
    public static final int[] EV_YIELD = {0, 0, 1, 0, 0, 0};
    public static final int CAPTURE_RATE = 255;
    public static final double WEIGHT = 5.3;

    public static final Ability FIRST_ABILITY = new Ability.PoisonPoint();
    public static final Ability SECOND_ABILITY = new Ability.Swarm();
    public static final Ability HIDDEN_ABILITY = new Ability.SpeedBoost();

    //Base Stats
    public static final int BASE_HEALTH = 30;
    public static final int BASE_ATTACK = 45;
    public static final int BASE_DEFENSE = 59;
    public static final int BASE_SPECIAL_ATTACK = 30;
    public static final int BASE_SPECIAL_DEFENSE = 39;
    public static final int BASE_SPEED = 57;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/venipede.png";
    public static final String BACK_PATH = "battle/backs/unova/venipede.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/venipede.png";
    public static final String CRY_PATH = "sounds/cry/543.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/venipede.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.BUG;
    public static final Type TYPE_TWO = Type.POISON;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a venipede
     */
    public Venipede() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init venipede's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.DEFENSE_CURL);
        beginnerSkills.add(SkillFactory.ROLLOUT);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_STING)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCREECH)));
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.PURSUIT)));
        //15 PROTECT
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_TAIL)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUG_BITE)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.VENOSHOCK)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.AGILITY)));
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.STEAMROLLER)));
        //36 TOXIC
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.VENOM_DRENCH)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_CLIMB)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.VENOSHOCK.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SLUDGE_BOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GYRO_BALL.getValue());
        tmSkills.add(TmId.INFESTATION.getValue());
        tmSkills.add(TmId.POISON_JAB.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init venipede's gender.
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
     * Return Whirlipede if the venipede is above level 22.
     * @return Whirlipede if venipede is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 22) {
            return PokemonId.WHIRLIPEDE.getValue();
        }
        return -1;
    }
}
