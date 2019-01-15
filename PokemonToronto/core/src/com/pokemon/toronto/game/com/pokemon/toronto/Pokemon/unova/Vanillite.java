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

public class Vanillite extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 582;
    public static final String NAME = "Vanillite";
    public static final String TYPE_OF_POKEMON = "Fresh Snow";
    public static final String DESCRIPTION = "This Pokémon formed from icicles bathed in " +
            "energy from the morning sun. It sleeps buried in snow.";
    public static final double HEIGHT = 0.4;
    public static final int BASE_EXP = 61;
    public static final int[] EV_YIELD = {0, 0, 0, 1, 0, 0};
    public static final int CAPTURE_RATE = 255;
    public static final double WEIGHT = 5.7;

    public static final Ability FIRST_ABILITY = new Ability.IceBody();
    public static final Ability SECOND_ABILITY = new Ability.SnowCloak();
    public static final Ability HIDDEN_ABILITY = new Ability.WeakArmor();

    //Base Stats
    public static final int BASE_HEALTH = 36;
    public static final int BASE_ATTACK = 50;
    public static final int BASE_DEFENSE = 50;
    public static final int BASE_SPECIAL_ATTACK = 65;
    public static final int BASE_SPECIAL_DEFENSE = 60;
    public static final int BASE_SPEED = 44;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/vanillite.png";
    public static final String BACK_PATH = "battle/backs/unova/vanillite.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/vanillite.png";
    public static final String CRY_PATH = "sounds/cry/582.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/vanillite.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.ICE;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    /**
     * Create a vanillite
     */
    public Vanillite() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init vanillite's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.ICICLE_SPEAR);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.HARDEN)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.ASTONISH)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.UPROAR)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.ICY_WIND)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.MIST)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.AVALANCHE)));
        //22 TAUNT
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.MIRROR_SHOT)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.ACID_ARMOR)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.ICE_BEAM)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.HAIL)));
        //44 MIRROR COAT
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.BLIZZARD)));
        levelUpSkills.put(53, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHEER_COLD)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HAIL.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.BLIZZARD.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.EXPLOSION.getValue());
        tmSkills.add(TmId.FROST_BREATH.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.FLASH_CANNON.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init vanillite's gender.
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
     * Return Vanillish if the vanillite is above level 35.
     * @return Vanillish if vanillite is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 35) {
            return PokemonId.VANILLISH.getValue();
        }
        return -1;
    }
}
