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

public class Flabebe extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 669;
    public static final String NAME = "Flabebe";
    public static final String TYPE_OF_POKEMON = "Single Bloom";
    public static final String DESCRIPTION = "It draws out and controls the hidden power of " +
            "flowers. The flower it holds is most likely part of its body.";
    public static final double HEIGHT = 0.1;
    public static final int BASE_EXP = 61;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 1, 0};
    public static final int CAPTURE_RATE = 225;
    public static final double WEIGHT = 0.1;

    public static final Ability FIRST_ABILITY = new Ability.FlowerVeil();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.Symbiosis();

    //Base Stats
    public static final int BASE_HEALTH = 44;
    public static final int BASE_ATTACK = 38;
    public static final int BASE_DEFENSE = 39;
    public static final int BASE_SPECIAL_ATTACK = 61;
    public static final int BASE_SPECIAL_DEFENSE = 79;
    public static final int BASE_SPEED = 42;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/flabebe.png";
    public static final String BACK_PATH = "battle/backs/kalos/flabebe.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/flabebe.png";
    public static final String CRY_PATH = "sounds/cry/669.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/flabebe.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.FAIRY;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a flabebe
     */
    public Flabebe() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init flabebe's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.VINE_WHIP);
        beginnerSkills.add(SkillFactory.TACKLE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.FAIRY_WIND)));
        //10 LUCKY CHANT
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAZOR_LEAF)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.WISH)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.MAGICAL_LEAF)));
        //24 GRASSY TERRAIN
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.PETAL_BLIZZARD)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.AROMATHERAPY)));
        //37 MISTY TERRAIN
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.MOONBLAST)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.PETAL_DANCE)));
        levelUpSkills.put(48, new ArrayList<Integer>(Arrays.asList(SkillFactory.SOLAR_BEAM)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
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
     * Init flabebe's gender.
     */
    @Override
    protected void initGender() {
        gender = 'F';
    }

    /**
     * Return Floette if the flabebe is above level 19.
     * @return Floette if flabebe is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 19) {
            return PokemonId.FLOETTE.getValue();
        }
        return -1;
    }
}
