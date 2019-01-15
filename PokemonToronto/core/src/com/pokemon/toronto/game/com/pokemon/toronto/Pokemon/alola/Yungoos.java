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
 * Created by gregorykelsie on 2018-01-29.
 */

public class Yungoos extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 734;
    public static final String NAME = "Yungoos";
    public static final String TYPE_OF_POKEMON = "Loitering";
    public static final String DESCRIPTION = "With its sharp fangs, it will bite anything. It " +
            "did not originally live in Alola but was imported from another region.";
    public static final double HEIGHT = 0.4;
    public static final int BASE_EXP = 51;
    public static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 255;
    public static final double WEIGHT = 6;

    public static final Ability FIRST_ABILITY = new Ability.Stakeout();
    public static final Ability SECOND_ABILITY = new Ability.StrongJaw();
    public static final Ability HIDDEN_ABILITY = new Ability.Adaptability();

    //Base Stats
    public static final int BASE_HEALTH = 48;
    public static final int BASE_ATTACK = 70;
    public static final int BASE_DEFENSE = 30;
    public static final int BASE_SPECIAL_ATTACK = 30;
    public static final int BASE_SPECIAL_DEFENSE = 30;
    public static final int BASE_SPEED = 45;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/alola/yungoos.png";
    public static final String BACK_PATH = "battle/backs/alola/yungoos.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/alola/yungoos.png";
    public static final String CRY_PATH = "sounds/cry/734.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/alola/yungoos.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a yungoos
     */
    public Yungoos() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init yungoos's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEER)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.PURSUIT)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAND_ATTACK)));
        //13 ODOR SLEUTH
        //16 BIDE
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_SLAP)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUPER_FANG)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCARY_FACE)));
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPER_VOICE)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.YAWN)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.THRASH)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.REST)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init yungoos's gender.
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
     * Return Gumshoos if the yungoos is above level 20.
     * @return Gumshoos if yungoos is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 20) {
            return PokemonId.GUMSHOOS.getValue();
        }
        return -1;
    }
}
