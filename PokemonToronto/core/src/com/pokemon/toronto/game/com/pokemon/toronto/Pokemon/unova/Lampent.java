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

public class Lampent extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 608;
    public static final String NAME = "Lampent";
    public static final String TYPE_OF_POKEMON = "Lamp";
    public static final String DESCRIPTION = "It arrives near the moment of death and steals " +
            "spirit from the body.";
    public static final double HEIGHT = 0.6;
    public static final int BASE_EXP = 130;
    public static final int[] EV_YIELD = {0, 0, 0, 2, 0, 0};
    public static final int CAPTURE_RATE = 90;
    public static final double WEIGHT = 13;

    public static final Ability FIRST_ABILITY = new Ability.FlashFire();
    public static final Ability SECOND_ABILITY = new Ability.FlameBody();
    public static final Ability HIDDEN_ABILITY = new Ability.Infiltrator();

    //Base Stats
    public static final int BASE_HEALTH = 60;
    public static final int BASE_ATTACK = 40;
    public static final int BASE_DEFENSE = 60;
    public static final int BASE_SPECIAL_ATTACK = 95;
    public static final int BASE_SPECIAL_DEFENSE = 60;
    public static final int BASE_SPEED = 55;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/lampent.png";
    public static final String BACK_PATH = "battle/backs/unova/lampent.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/lampent.png";
    public static final String CRY_PATH = "sounds/cry/608.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/lampent.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GHOST;
    public static final Type TYPE_TWO = Type.FIRE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a lampent
     */
    public Lampent() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init lampent's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.EMBER);
        beginnerSkills.add(SkillFactory.ASTONISH);
        beginnerSkills.add(SkillFactory.MINIMIZE);
        beginnerSkills.add(SkillFactory.SMOG);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.MINIMIZE)));
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.SMOG)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.FIRE_SPIN)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.CONFUSE_RAY)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.NIGHT_SHADE)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.WILL_O_WISP)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAME_BURST)));
        //24 IMPRISON
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEX)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEMENTO)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.INFERNO)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.CURSE)));
        levelUpSkills.put(53, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHADOW_BALL)));
        levelUpSkills.put(61, new ArrayList<Integer>(Arrays.asList(SkillFactory.PAIN_SPLIT)));
        levelUpSkills.put(69, new ArrayList<Integer>(Arrays.asList(SkillFactory.OVERHEAT)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FLAMETHROWER.getValue());
        tmSkills.add(TmId.FIRE_BLAST.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.FLAME_CHARGE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.OVERHEAT.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.WILL_O_WISP.getValue());
        tmSkills.add(TmId.EMBARGO.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.TRICK_ROOM.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init lampent's gender.
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

    @Override
    public int getDuskStoneEvolutionId() {
        return PokemonId.CHANDELURE.getValue();
    }
}
