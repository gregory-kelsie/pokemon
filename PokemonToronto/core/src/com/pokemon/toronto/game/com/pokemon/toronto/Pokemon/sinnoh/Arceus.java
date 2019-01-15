package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-08-16.
 */

public class Arceus extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 493;
    public static final String NAME = "Arceus";
    public static final String TYPE_OF_POKEMON = "Alpha";
    public static final String DESCRIPTION = "It is said to have emerged from an egg in a place" +
            " where there was nothing, then shaped the world.";
    public static final int BASE_EXP = 324;
    public static final int[] EV_YIELD = {3, 0, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 3;
    public static final double WEIGHT = 320;
    public static final double HEIGHT = 3.2;

    public static final Ability FIRST_ABILITY = new Ability.Multitype();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    public static final int BASE_HEALTH = 120;
    public static final int BASE_ATTACK = 120;
    public static final int BASE_DEFENSE = 120;
    public static final int BASE_SPECIAL_ATTACK = 120;
    public static final int BASE_SPECIAL_DEFENSE = 120;
    public static final int BASE_SPEED = 120;

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/arceus.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/arceus.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/arceus.png";
    public static final String CRY_PATH = "sounds/cry/493.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/arceus.png";

    /**
     * Create a arceus
     */
    public Arceus() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init arceus's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SEISMIC_TOSS);
        beginnerSkills.add(SkillFactory.COSMIC_POWER);
        //NATURAL GIFT
        beginnerSkills.add(SkillFactory.PUNISHMENT);
        levelUpSkills.put(0, beginnerSkills);
        //10 GRAVITY
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.EARTH_POWER)));
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPER_VOICE)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.EXTREME_SPEED)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.REFRESH)));
        levelUpSkills.put(60, new ArrayList<Integer>(Arrays.asList(SkillFactory.FUTURE_SIGHT)));
        levelUpSkills.put(70, new ArrayList<Integer>(Arrays.asList(SkillFactory.RECOVER)));
        levelUpSkills.put(80, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPER_BEAM)));
        levelUpSkills.put(90, new ArrayList<Integer>(Arrays.asList(SkillFactory.PERISH_SONG)));
        //100 JUDGMENT
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.DRAGON_CLAW.getValue());
        tmSkills.add(TmId.PSYSHOCK.getValue());
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HAIL.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.BLIZZARD.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.FLAMETHROWER.getValue());
        tmSkills.add(TmId.SLUDGE_BOMB.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.FIRE_BLAST.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.OVERHEAT.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.QUASH.getValue());
        tmSkills.add(TmId.WILL_O_WISP.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.FLY.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.X_SCISSOR.getValue());
        tmSkills.add(TmId.POISON_JAB.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.FLASH_CANNON.getValue());
        tmSkills.add(TmId.TRICK_ROOM.getValue());
        tmSkills.add(TmId.SURF.getValue());
        tmSkills.add(TmId.SNARL.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.WATERFALL.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }
}
