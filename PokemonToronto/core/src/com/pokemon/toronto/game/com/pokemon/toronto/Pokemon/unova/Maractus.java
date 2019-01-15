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

public class Maractus extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 556;
    public static final String NAME = "Maractus";
    public static final String TYPE_OF_POKEMON = "Cactus";
    public static final String DESCRIPTION = "It uses an up-tempo song and dance to drive away" +
            " the bird Pokémon that prey on its flower seeds.";
    public static final double HEIGHT = 1;
    public static final int BASE_EXP = 161;
    public static final int[] EV_YIELD = {0, 0, 0, 2, 0, 0};
    public static final int CAPTURE_RATE = 255;
    public static final double WEIGHT = 28;

    public static final Ability FIRST_ABILITY = new Ability.WaterAbsorb();
    public static final Ability SECOND_ABILITY = new Ability.Chlorophyll();
    public static final Ability HIDDEN_ABILITY = new Ability.StormDrain();

    //Base Stats
    public static final int BASE_HEALTH = 75;
    public static final int BASE_ATTACK = 86;
    public static final int BASE_DEFENSE = 67;
    public static final int BASE_SPECIAL_ATTACK = 106;
    public static final int BASE_SPECIAL_DEFENSE = 67;
    public static final int BASE_SPEED = 60;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/maractus.png";
    public static final String BACK_PATH = "battle/backs/unova/maractus.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/maractus.png";
    public static final String CRY_PATH = "sounds/cry/556.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/maractus.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GRASS;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a maractus
     */
    public Maractus() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init maractus's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //SPIKY SHIELD
        beginnerSkills.add(SkillFactory.COTTON_GUARD);
        //AFTER YOU
        beginnerSkills.add(SkillFactory.PECK);
        beginnerSkills.add(SkillFactory.ABSORB);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWEET_SCENT)));
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWTH)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.PIN_MISSILE)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEGA_DRAIN)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.SYNTHESIS)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.COTTON_SPORE)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.NEEDLE_ARM)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.GIGA_DRAIN)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.ACUPRESSURE)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.INGRAIN)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.PETAL_DANCE)));
        levelUpSkills.put(42, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUCKER_PUNCH)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUNNY_DAY)));
        levelUpSkills.put(48, new ArrayList<Integer>(Arrays.asList(SkillFactory.PETAL_BLIZZARD)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.SOLAR_BEAM)));
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.COTTON_GUARD)));
        //57 AFTER YOU
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.POISON_JAB.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init maractus's gender.
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
