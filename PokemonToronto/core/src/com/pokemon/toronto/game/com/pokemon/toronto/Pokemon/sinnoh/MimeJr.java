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
 * Created by gregorykelsie on 2018-04-25.
 */

public class MimeJr extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 439;
    public static final String NAME = "Mime Jr";
    public static final String TYPE_OF_POKEMON = "Mime";
    public static final String DESCRIPTION = "It mimics the expressions and motions of those it" +
            " sees to understand the feelings of others.";
    public static final double HEIGHT = 0.6;
    public static final int BASE_EXP = 62;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 1, 0};
    public static final int CAPTURE_RATE = 145;
    public static final double WEIGHT = 13;

    public static final Ability FIRST_ABILITY = new Ability.Soundproof();
    public static final Ability SECOND_ABILITY = new Ability.Filter();
    public static final Ability HIDDEN_ABILITY = new Ability.Technician();

    //Base Stats
    public static final int BASE_HEALTH = 20;
    public static final int BASE_ATTACK = 25;
    public static final int BASE_DEFENSE = 45;
    public static final int BASE_SPECIAL_ATTACK = 70;
    public static final int BASE_SPECIAL_DEFENSE = 90;
    public static final int BASE_SPEED = 60;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/mimejr.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/mimejr.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/mimejr.png";
    public static final String CRY_PATH = "sounds/cry/439.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/mimejr.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.PSYCHIC;
    public static final Type TYPE_TWO = Type.FAIRY;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a mimejr
     */
    public MimeJr() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init mimejr's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TICKLE);
        beginnerSkills.add(SkillFactory.BARRIER);
        beginnerSkills.add(SkillFactory.CONFUSION);
        levelUpSkills.put(0, beginnerSkills);
        //TODO: COPYCAT 4
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEDITATE)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_SLAP)));
        //TODO: MIMIC 15
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYWAVE)));
        //TODO: ENCORE 18
        ArrayList<Integer> screens = new ArrayList<Integer>();
        screens.add(SkillFactory.LIGHT_SCREEN);
        screens.add(SkillFactory.REFLECT);
        levelUpSkills.put(22, screens);
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYBEAM)));
        //TODO: SUBSTITUTE 29
        //TODO: RECYCLE 32
        //TODO: TRICK 36
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCHIC)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROLE_PLAY)));
        //TODO: BATON PASS 46
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAFEGUARD)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.PSYSHOCK.getValue());
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.INFESTATION.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.TRICK_ROOM.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init Mime Jr's gender.
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
     * Return Mr Mime if the Mime Jr is above level 15.
     * @return Mr Mime if Mime Jr is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 15) { //TODO: Check mimic when implemented
            return PokemonId.MR_MIME.getValue();
        }
        return -1;
    }

}
