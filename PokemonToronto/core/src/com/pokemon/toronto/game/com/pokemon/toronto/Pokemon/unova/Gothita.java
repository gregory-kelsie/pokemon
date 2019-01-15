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

public class Gothita extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 574;
    public static final String NAME = "Gothita";
    public static final String TYPE_OF_POKEMON = "Fixation";
    public static final String DESCRIPTION = "It stares intently at everything. It can become so" +
            " obsessed with watching that it doesn't notice attacks.";
    public static final double HEIGHT = 0.4;
    public static final int BASE_EXP = 58;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 1, 0};
    public static final int CAPTURE_RATE = 200;
    public static final double WEIGHT = 5.8;

    public static final Ability FIRST_ABILITY = new Ability.Frisk();
    public static final Ability SECOND_ABILITY = new Ability.Competitive();
    public static final Ability HIDDEN_ABILITY = new Ability.ShadowTag();

    //Base Stats
    public static final int BASE_HEALTH = 45;
    public static final int BASE_ATTACK = 30;
    public static final int BASE_DEFENSE = 50;
    public static final int BASE_SPECIAL_ATTACK = 55;
    public static final int BASE_SPECIAL_DEFENSE = 65;
    public static final int BASE_SPEED = 45;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/gothita.png";
    public static final String BACK_PATH = "battle/backs/unova/gothita.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/gothita.png";
    public static final String CRY_PATH = "sounds/cry/574.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/gothita.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.PSYCHIC;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a gothita
     */
    public Gothita() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init gothita's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.POUND);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.CONFUSION)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.TICKLE)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.PLAY_NICE)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.FAKE_TEARS)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_SLAP)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYBEAM)));
        //19 EMBARGO
        levelUpSkills.put(24, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT_ATTACK)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYSHOCK)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLATTER)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.FUTURE_SIGHT)));
        //33 HEAL BLOCK
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCHIC)));
        //40 TELEKINESIS
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARM)));
        //48 MAGIC ROOM
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.PSYSHOCK.getValue());
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.EMBARGO.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.TRICK_ROOM.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init gothita's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .246) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }

    /**
     * Return Gothorita if the gothita is above level 32.
     * @return Gothorita if gothita is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 32) {
            return PokemonId.GOTHORITA.getValue();
        }
        return -1;
    }
}
