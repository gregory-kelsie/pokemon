package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alola;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-30.
 */

public class Steenee extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 762;
    public static final String NAME = "Steenee";
    public static final String TYPE_OF_POKEMON = "Fruit";
    public static final String DESCRIPTION = "This Pokémon is always bouncing around " +
            "energetically. Other Pokémon are attracted by its lively appearance and pleasant aroma.";
    public static final double HEIGHT = 0.7;
    public static final int BASE_EXP = 102;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 2};
    public static final int CAPTURE_RATE = 120;
    public static final double WEIGHT = 8.2;

    public static final Ability FIRST_ABILITY = new Ability.LeafGuard();
    public static final Ability SECOND_ABILITY = new Ability.Oblivious();
    public static final Ability HIDDEN_ABILITY = new Ability.SweetVeil();

    //Base Stats
    public static final int BASE_HEALTH = 52;
    public static final int BASE_ATTACK = 40;
    public static final int BASE_DEFENSE = 48;
    public static final int BASE_SPECIAL_ATTACK = 40;
    public static final int BASE_SPECIAL_DEFENSE = 48;
    public static final int BASE_SPEED = 62;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/alola/steenee.png";
    public static final String BACK_PATH = "battle/backs/alola/steenee.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/alola/steenee.png";
    public static final String CRY_PATH = "sounds/cry/762.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/alola/steenee.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GRASS;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a steenee
     */
    public Steenee() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init steenee's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SPLASH);
        beginnerSkills.add(SkillFactory.PLAY_NICE);
        beginnerSkills.add(SkillFactory.RAPID_SPIN);
        beginnerSkills.add(SkillFactory.RAZOR_LEAF);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.PLAY_NICE)));
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
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.DAZZLING_GLEAM.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.DOUBLE_SLAP);
    }

    /**
     * Init steenee's gender.
     */
    @Override
    protected void initGender() {
        gender = 'F';
    }

    /**
     * Return Tsareena if the steenee levels up with stomp.
     * @return Tsareena if steenee is the levels up with stomp.
     */
    @Override
    public int getLevelUpEvolutionId() {
        for (Skill skill: getSkills()) {
            if (skill.getId() == SkillFactory.STOMP) {
                return PokemonId.TSAREENA.getValue();
            }
        }
        return -1;
    }
}
