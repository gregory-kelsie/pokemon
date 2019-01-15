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

public class Darumaka extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 554;
    public static final String NAME = "Darumaka";
    public static final String TYPE_OF_POKEMON = "Zen Charm";
    public static final String DESCRIPTION = "When its internal fire is burning, it cannot calm" +
            " down and it runs around. When the fire diminishes, it falls asleep.";
    public static final double HEIGHT = 0.6;
    public static final int BASE_EXP = 63;
    public static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 120;
    public static final double WEIGHT = 37.5;

    public static final Ability FIRST_ABILITY = new Ability.Hustle();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.InnerFocus();

    //Base Stats
    public static final int BASE_HEALTH = 70;
    public static final int BASE_ATTACK = 90;
    public static final int BASE_DEFENSE = 45;
    public static final int BASE_SPECIAL_ATTACK = 15;
    public static final int BASE_SPECIAL_DEFENSE = 45;
    public static final int BASE_SPEED = 50;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/darumaka.png";
    public static final String BACK_PATH = "battle/backs/unova/darumaka.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/darumaka.png";
    public static final String CRY_PATH = "sounds/cry/554.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/darumaka.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.FIRE;
    public static final Type TYPE_TWO = Type.NONE  ;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a darumaka
     */
    public Darumaka() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init darumaka's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROLLOUT)));
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.INCINERATE)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAGE)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.FIRE_FANG)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEADBUTT)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.UPROAR)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.FACADE)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.FIRE_PUNCH)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.WORK_UP)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.THRASH)));
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.BELLY_DRUM)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLARE_BLITZ)));
        //35 TAUNT
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUPERPOWER)));
        levelUpSkills.put(42, new ArrayList<Integer>(Arrays.asList(SkillFactory.OVERHEAT)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FLAMETHROWER.getValue());
        tmSkills.add(TmId.FIRE_BLAST.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.FLAME_CHARGE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.OVERHEAT.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.WILL_O_WISP.getValue());
        tmSkills.add(TmId.GYRO_BALL.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init darumaka's gender.
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
     * Return Darmanitan if the darumaka is above level 35.
     * @return Darmanitan if darumaka is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 35) {
            return PokemonId.DARMANITAN.getValue();
        }
        return -1;
    }
}
