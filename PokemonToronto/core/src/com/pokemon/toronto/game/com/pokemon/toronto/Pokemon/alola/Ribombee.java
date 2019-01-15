package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alola;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-30.
 */

public class Ribombee extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 743;
    public static final String NAME = "Ribombee";
    public static final String TYPE_OF_POKEMON = "Bee Fly";
    public static final String DESCRIPTION = "It rolls up pollen into puffs. It makes many " +
            "different varieties, some used as food and others used in battle.";
    public static final double HEIGHT = 0.2;
    public static final int BASE_EXP = 162;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 2};
    public static final int CAPTURE_RATE = 75;
    public static final double WEIGHT = 2;

    public static final Ability FIRST_ABILITY = new Ability.HoneyGather();
    public static final Ability SECOND_ABILITY = new Ability.ShieldDust();
    public static final Ability HIDDEN_ABILITY = new Ability.SweetVeil();

    //Base Stats
    public static final int BASE_HEALTH = 60;
    public static final int BASE_ATTACK = 65;
    public static final int BASE_DEFENSE = 60;
    public static final int BASE_SPECIAL_ATTACK = 95;
    public static final int BASE_SPECIAL_DEFENSE = 70;
    public static final int BASE_SPEED = 124;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/alola/ribombee.png";
    public static final String BACK_PATH = "battle/backs/alola/ribombee.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/alola/ribombee.png";
    public static final String CRY_PATH = "sounds/cry/743.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/alola/ribombee.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.BUG;
    public static final Type TYPE_TWO = Type.FAIRY;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a ribombee
     */
    public Ribombee() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init ribombee's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.ABSORB);
        beginnerSkills.add(SkillFactory.FAIRY_WIND);
        beginnerSkills.add(SkillFactory.STUN_SPORE);
        beginnerSkills.add(SkillFactory.STRUGGLE_BUG);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.FAIRY_WIND)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.STUN_SPORE)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.STRUGGLE_BUG)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.SILVER_WIND)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAINING_KISS)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWEET_SCENT)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUG_BUZZ)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.DAZZLING_GLEAM)));
        levelUpSkills.put(42, new ArrayList<Integer>(Arrays.asList(SkillFactory.AROMATHERAPY)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUIVER_DANCE)));
        initEvolutionSkills();
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.ROOST.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.LEECH_LIFE.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.ACROBATICS.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.INFESTATION.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.DAZZLING_GLEAM.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.POLLEN_PUFF);
    }

    /**
     * Init ribombee's gender.
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
