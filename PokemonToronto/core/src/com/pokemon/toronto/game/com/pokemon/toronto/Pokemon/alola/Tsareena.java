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

public class Tsareena extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 763;
    public static final String NAME = "Tsareena";
    public static final String TYPE_OF_POKEMON = "Fruit";
    public static final String DESCRIPTION = "A Pokémon known for the beauty of its well-shaped" +
            " legs, it sometimes appears as a mascot in advertisements for beauty salons.";
    public static final double HEIGHT = 1.2;
    public static final int BASE_EXP = 230;
    public static final int[] EV_YIELD = {0, 3, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 21.4;

    public static final Ability FIRST_ABILITY = new Ability.LeafGuard();
    public static final Ability SECOND_ABILITY = new Ability.QueenlyMajesty();
    public static final Ability HIDDEN_ABILITY = new Ability.SweetVeil();

    //Base Stats
    public static final int BASE_HEALTH = 52;
    public static final int BASE_ATTACK = 40;
    public static final int BASE_DEFENSE = 48;
    public static final int BASE_SPECIAL_ATTACK = 40;
    public static final int BASE_SPECIAL_DEFENSE = 48;
    public static final int BASE_SPEED = 62;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/alola/tsareena.png";
    public static final String BACK_PATH = "battle/backs/alola/tsareena.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/alola/tsareena.png";
    public static final String CRY_PATH = "sounds/cry/763.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/alola/tsareena.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GRASS;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a tsareena
     */
    public Tsareena() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init tsareena's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.DOUBLE_SLAP);
        beginnerSkills.add(SkillFactory.SPLASH);
        beginnerSkills.add(SkillFactory.PLAY_NICE);
        beginnerSkills.add(SkillFactory.RAPID_SPIN);
        beginnerSkills.add(SkillFactory.RAZOR_LEAF);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWAGGER)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAPID_SPIN)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAZOR_LEAF)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWEET_SCENT)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.MAGICAL_LEAF)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.TEETER_DANCE)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.STOMP)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.AROMATIC_MIST)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.CAPTIVATE)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.AROMATHERAPY)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEAF_STORM)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.HIGH_JUMP_KICK)));
        initEvolutionSkills();
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.LOW_SWEEP.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.ACROBATICS.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
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
        evolutionSkills.add(SkillFactory.TROP_KICK);
    }

    /**
     * Init tsareena's gender.
     */
    @Override
    protected void initGender() {
        gender = 'F';
    }
}
