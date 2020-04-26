package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-08-16.
 */

public class Shaymin extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 492;
    public static final String NAME = "Shaymin";
    public static final String TYPE_OF_POKEMON = "Gratitude";
    public static final String DESCRIPTION = "The flowers all over its body burst into bloom if" +
            " it is lovingly hugged and senses gratitude.";
    public static final int BASE_EXP = 270;
    public static final int[] EV_YIELD = {3, 0, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 2.1;
    public static final double HEIGHT = 0.2;

    public static final Ability FIRST_ABILITY = new Ability.NaturalCure();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    public static final int BASE_HEALTH = 100;
    public static final int BASE_ATTACK = 100;
    public static final int BASE_DEFENSE = 100;
    public static final int BASE_SPECIAL_ATTACK = 100;
    public static final int BASE_SPECIAL_DEFENSE = 100;
    public static final int BASE_SPEED = 100;

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GRASS;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/shaymin.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/shaymin.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/shaymin.png";
    public static final String CRY_PATH = "sounds/cry/492.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/shaymin.png";

    /**
     * Create a shaymin
     */
    public Shaymin() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init shaymin's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.GROWTH);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.MAGICAL_LEAF)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEECH_SEED)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.SYNTHESIS)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWEET_SCENT)));
        //46 NATURAL GIFT
        //55 WORRY SEED
        levelUpSkills.put(64, new ArrayList<Integer>(Arrays.asList(SkillFactory.AROMATHERAPY)));
        levelUpSkills.put(73, new ArrayList<Integer>(Arrays.asList(SkillFactory.ENERGY_BALL)));
        levelUpSkills.put(82, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWEET_KISS)));
        //91 HEALING WISH
        levelUpSkills.put(100, new ArrayList<Integer>(Arrays.asList(SkillFactory.SEED_FLARE)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.DAZZLING_GLEAM.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }
}