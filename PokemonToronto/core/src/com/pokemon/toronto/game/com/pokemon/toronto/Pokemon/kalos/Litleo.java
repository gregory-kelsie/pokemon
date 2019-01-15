package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kalos;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-02-02.
 */

public class Litleo extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 667;
    public static final String NAME = "Litleo";
    public static final String TYPE_OF_POKEMON = "Lion Cub";
    public static final String DESCRIPTION = "The stronger the opponent it faces, the more heat" +
            " surges from its mane and the more power flows through its body.";
    public static final double HEIGHT = 0.6;
    public static final int BASE_EXP = 74;
    public static final int[] EV_YIELD = {0, 0, 0, 1, 0, 0};
    public static final int CAPTURE_RATE = 220;
    public static final double WEIGHT = 13.5;

    public static final Ability FIRST_ABILITY = new Ability.Rivalry();
    public static final Ability SECOND_ABILITY = new Ability.Unnerve();
    public static final Ability HIDDEN_ABILITY = new Ability.Moxie();

    //Base Stats
    public static final int BASE_HEALTH = 62;
    public static final int BASE_ATTACK = 50;
    public static final int BASE_DEFENSE = 58;
    public static final int BASE_SPECIAL_ATTACK = 73;
    public static final int BASE_SPECIAL_DEFENSE = 54;
    public static final int BASE_SPEED = 72;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/litleo.png";
    public static final String BACK_PATH = "battle/backs/kalos/litleo.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/litleo.png";
    public static final String CRY_PATH = "sounds/cry/667.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/litleo.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.FIRE;
    public static final Type TYPE_TWO = Type.NORMAL;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a litleo
     */
    public Litleo() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init litleo's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.LEER);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.EMBER)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.WORK_UP)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEADBUTT)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.NOBLE_ROAR)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.FIRE_FANG)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.ENDEAVOR)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.ECHOED_VOICE)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAMETHROWER)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPER_VOICE)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.INCINERATE)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.OVERHEAT)));
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
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FLAMETHROWER.getValue());
        tmSkills.add(TmId.FIRE_BLAST.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.FLAME_CHARGE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.OVERHEAT.getValue());
        tmSkills.add(TmId.WILL_O_WISP.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.WILD_CHARGE.getValue());
        tmSkills.add(TmId.SNARL.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init litleo's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .125) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }

    /**
     * Return Pyroar if the litleo is above level 35.
     * @return Pyroar if litleo is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 35) {
            return PokemonId.PYROAR.getValue();
        }
        return -1;
    }
}
