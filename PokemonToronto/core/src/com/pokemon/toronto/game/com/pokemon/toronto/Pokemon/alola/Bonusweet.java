package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alola;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-30.
 */

public class Bonusweet extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 761;
    private static final String NAME = "Bonusweet";
    public static final String TYPE_OF_POKEMON = "Fruit";
    public static final String DESCRIPTION = "Although it’s too sugary for human consumption, " +
            "its sweat can be watered down into a juice with just the right amount of sweetness.";
    public static final double HEIGHT = 0.3;
    private static final int BASE_EXP = 42;
    private static final int[] EV_YIELD = {1, 0, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 235;
    private static final double WEIGHT = 3.2;

    private static final Ability FIRST_ABILITY = new Ability.LeafGuard();
    private static final Ability SECOND_ABILITY = new Ability.Oblivious();
    private static final Ability HIDDEN_ABILITY = new Ability.SweetVeil();

    //Base Stats
    private static final int BASE_HEALTH = 42;
    private static final int BASE_ATTACK = 30;
    private static final int BASE_DEFENSE = 38;
    private static final int BASE_SPECIAL_ATTACK = 30;
    private static final int BASE_SPECIAL_DEFENSE = 38;
    private static final int BASE_SPEED = 32;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/alola/bonusweet.png";
    private static final String BACK_PATH = "battle/backs/alola/bonusweet.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/alola/bonusweet.png";
    private static final String CRY_PATH = "sounds/cry/761.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/alola/bonusweet.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.GRASS;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a bonusweet
     */
    public Bonusweet() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init bonusweet's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SPLASH);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.PLAY_NICE)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAPID_SPIN)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAZOR_LEAF)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWEET_SCENT)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.MAGICAL_LEAF)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.TEETER_DANCE)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAIL)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.AROMATIC_MIST)));
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
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.DAZZLING_GLEAM.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init bonusweet's gender.
     */
    @Override
    protected void initGender() {
        gender = 'F';
    }

    /**
     * Return Steenee if the bonusweet is above level 18.
     * @return Steenee if bonusweet is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 18) {
            return PokemonId.STEENEE.getValue();
        }
        return -1;
    }
}
