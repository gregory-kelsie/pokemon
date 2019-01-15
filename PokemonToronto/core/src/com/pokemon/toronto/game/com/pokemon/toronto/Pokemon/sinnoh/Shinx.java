package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-04-23.
 */

public class Shinx extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 403;
    public static final String NAME = "Shinx";
    public static final String TYPE_OF_POKEMON = "Flash";
    public static final String DESCRIPTION = "The extension and contraction of its muscles " +
            "generates electricity. It glows when in trouble.";
    public static final double HEIGHT = 0.5;
    public static final int BASE_EXP = 53;
    public static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 235;
    public static final double WEIGHT = 9.5;

    public static final Ability FIRST_ABILITY = new Ability.Rivalry();
    public static final Ability SECOND_ABILITY = new Ability.Intimidate();
    public static final Ability HIDDEN_ABILITY = new Ability.Guts();

    //Base Stats
    public static final int BASE_HEALTH = 45;
    public static final int BASE_ATTACK = 65;
    public static final int BASE_DEFENSE = 34;
    public static final int BASE_SPECIAL_ATTACK = 40;
    public static final int BASE_SPECIAL_DEFENSE = 34;
    public static final int BASE_SPEED = 45;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/shinx.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/shinx.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/shinx.png";
    public static final String CRY_PATH = "sounds/cry/403.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/shinx.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.ELECTRIC;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a shinx
     */
    public Shinx() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init shinx's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEER)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARGE)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.BABY_DOLL_EYES)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.SPARK)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        //21 ROAR
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWAGGER)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDER_FANG)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCARY_FACE)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.DISCHARGE)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.WILD_CHARGE)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.VOLT_SWITCH.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.WILD_CHARGE.getValue());
        tmSkills.add(TmId.SNARL.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init shinx's gender.
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
     * Return Luxio if the shinx is above level 15.
     * @return Luxio if shinx is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 15) {
            return PokemonId.LUXIO.getValue();
        }
        return -1;
    }
}
