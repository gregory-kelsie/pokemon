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

public class Pumpkaboo extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 710;
    public static final String NAME = "Pumpkaboo";
    public static final String TYPE_OF_POKEMON = "Pumpkin";
    public static final String DESCRIPTION = "The pumpkin body is inhabited by a spirit trapped " +
            "in this world. As the sun sets, it becomes restless and active.";
    public static final double HEIGHT = 0.8;
    public static final int BASE_EXP = 67;
    public static final int[] EV_YIELD = {0, 0, 1, 0, 0, 0};
    public static final int CAPTURE_RATE = 120;
    public static final double WEIGHT = 5;

    public static final Ability FIRST_ABILITY = new Ability.Pickup();
    public static final Ability SECOND_ABILITY = new Ability.Frisk();
    public static final Ability HIDDEN_ABILITY = new Ability.Insomnia();

    //Base Stats
    public static final int BASE_HEALTH = 49;
    public static final int BASE_ATTACK = 66;
    public static final int BASE_DEFENSE = 70;
    public static final int BASE_SPECIAL_ATTACK = 44;
    public static final int BASE_SPECIAL_DEFENSE = 55;
    public static final int BASE_SPEED = 51;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/pumpkaboo.png";
    public static final String BACK_PATH = "battle/backs/kalos/pumpkaboo.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/pumpkaboo.png";
    public static final String CRY_PATH = "sounds/cry/710.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/pumpkaboo.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GHOST;
    public static final Type TYPE_TWO = Type.GRASS;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a pumpkaboo
     */
    public Pumpkaboo() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init pumpkaboo's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.CONFUSE_RAY);
        //TRICK
        beginnerSkills.add(SkillFactory.ASTONISH);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCARY_FACE)));
        //6 TRICK OR TREAT
        //11 WORRY SEED
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAZOR_LEAF)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEECH_SEED)));
        //23 TRICK OR TREAT
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.BULLET_SEED)));
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHADOW_SNEAK)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHADOW_BALL)));
        //40 TRICK OR TREAT
        levelUpSkills.put(42, new ArrayList<Integer>(Arrays.asList(SkillFactory.PAIN_SPLIT)));
        levelUpSkills.put(48, new ArrayList<Integer>(Arrays.asList(SkillFactory.SEED_BOMB)));
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
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FLAMETHROWER.getValue());
        tmSkills.add(TmId.SLUDGE_BOMB.getValue());
        tmSkills.add(TmId.FIRE_BLAST.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.FLAME_CHARGE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.WILL_O_WISP.getValue());
        tmSkills.add(TmId.EXPLOSION.getValue());
        tmSkills.add(TmId.GYRO_BALL.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.TRICK_ROOM.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init pumpkaboo's gender.
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
     * Return Gourgeist
     * @return Gourgeist
     */
    @Override
    public int getDuskStoneEvolutionId() {
        return PokemonId.GOURGEIST.getValue();
    }
}
