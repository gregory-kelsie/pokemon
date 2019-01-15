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
 * Created by gregorykelsie on 2018-05-05.
 */

public class Roggenrola extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 524;
    public static final String NAME = "Roggenrola";
    public static final String TYPE_OF_POKEMON = "Mantle";
    public static final String DESCRIPTION = "Its ear is hexagonal in shape. Compressed " +
            "underground, its body is as hard as steel.";
    public static final double HEIGHT = 0.4;
    public static final int BASE_EXP = 56;
    public static final int[] EV_YIELD = {0, 0, 1, 0, 0, 0};
    public static final int CAPTURE_RATE = 255;
    public static final double WEIGHT = 18;

    public static final Ability FIRST_ABILITY = new Ability.Sturdy();
    public static final Ability SECOND_ABILITY = new Ability.WeakArmor();
    public static final Ability HIDDEN_ABILITY = new Ability.SandForce();

    //Base Stats
    public static final int BASE_HEALTH = 55;
    public static final int BASE_ATTACK = 75;
    public static final int BASE_DEFENSE = 85;
    public static final int BASE_SPECIAL_ATTACK = 25;
    public static final int BASE_SPECIAL_DEFENSE = 25;
    public static final int BASE_SPEED = 15;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/roggenrola.png";
    public static final String BACK_PATH = "battle/backs/unova/roggenrola.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/roggenrola.png";
    public static final String CRY_PATH = "sounds/cry/524.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/roggenrola.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.ROCK;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a roggenrola
     */
    public Roggenrola() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init roggenrola's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.HARDEN)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAND_ATTACK)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEADBUTT)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_BLAST)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_SLAP)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.IRON_DEFENSE)));
        //23 SMACK DOWN
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_SLIDE)));
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.STEALTH_ROCK)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.SANDSTORM)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.STONE_EDGE)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.EXPLOSION)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SMACK_DOWN.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.EXPLOSION.getValue());
        tmSkills.add(TmId.ROCK_POLISH.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.FLASH_CANNON.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init roggenrola's gender.
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
     * Return Boldore if the roggenrola is above level 25.
     * @return Boldore if roggenrola is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 25) {
            return PokemonId.BOLDORE.getValue();
        }
        return -1;
    }
}
