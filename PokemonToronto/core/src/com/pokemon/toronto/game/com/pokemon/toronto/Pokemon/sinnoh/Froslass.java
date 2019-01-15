package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-04-29.
 */

public class Froslass extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 478;
    public static final String NAME = "Froslass";
    public static final String TYPE_OF_POKEMON = "Snow Land";
    public static final String DESCRIPTION = "It freezes prey by blowing its -58 degrees F " +
            "breath. It is said to then secretly display its prey.";
    public static final double HEIGHT = 1.3;
    public static final int BASE_EXP = 168;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 2};
    public static final int CAPTURE_RATE = 75;
    public static final double WEIGHT = 26.6;

    public static final Ability FIRST_ABILITY = new Ability.SnowCloak();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.CursedBody();

    //Base Stats
    public static final int BASE_HEALTH = 70;
    public static final int BASE_ATTACK = 80;
    public static final int BASE_DEFENSE = 70;
    public static final int BASE_SPECIAL_ATTACK = 80;
    public static final int BASE_SPECIAL_DEFENSE = 70;
    public static final int BASE_SPEED = 110;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/froslass.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/froslass.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/froslass.png";
    public static final String CRY_PATH = "sounds/cry/478.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/froslass.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.ICE;
    public static final Type TYPE_TWO = Type.GHOST;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;
    
    /**
     *  Create a froslass
     */
    public Froslass() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init froslass's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //DESTINY BOND
        beginnerSkills.add(SkillFactory.POWDER_SNOW);
        beginnerSkills.add(SkillFactory.LEER);
        beginnerSkills.add(SkillFactory.DOUBLE_TEAM);
        beginnerSkills.add(SkillFactory.ICE_SHARD);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_TEAM)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.ICE_SHARD)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.ICY_WIND)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.ASTONISH)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAINING_KISS)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.WILL_O_WISP)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.CONFUSE_RAY)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.WAKE_UP_SLAP)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.CAPTIVATE)));
        levelUpSkills.put(42, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHADOW_BALL)));
        levelUpSkills.put(48, new ArrayList<Integer>(Arrays.asList(SkillFactory.BLIZZARD)));
        levelUpSkills.put(54, new ArrayList<Integer>(Arrays.asList(SkillFactory.HAIL)));
        //61 DESTINY BOND
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.OMINOUS_WIND);
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HAIL.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.BLIZZARD.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.WILL_O_WISP.getValue());
        tmSkills.add(TmId.EMBARGO.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.AURORA_VEIL.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.FROST_BREATH.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init froslass's gender.
     */
    @Override
    protected void initGender() {
        gender = 'F';
    }
}
