package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kalos;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-08-20.
 */

public class Xerneas extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 716;
    public static final String NAME = "Xerneas";
    public static final String TYPE_OF_POKEMON = "Life";
    public static final String DESCRIPTION = "Legends say it can share eternal life. It slept " +
            "for a thousand years in the form of a tree before its revival.";
    public static final double HEIGHT = 3;
    public static final int BASE_EXP = 306;
    public static final int[] EV_YIELD = {3, 0, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 215;

    public static final Ability FIRST_ABILITY = new Ability.FairyAura();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    public static final int BASE_HEALTH = 126;
    public static final int BASE_ATTACK = 131;
    public static final int BASE_DEFENSE = 95;
    public static final int BASE_SPECIAL_ATTACK = 131;
    public static final int BASE_SPECIAL_DEFENSE = 98;
    public static final int BASE_SPEED = 99;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/xerneas.png";
    public static final String BACK_PATH = "battle/backs/kalos/xerneas.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/xerneas.png";
    public static final String CRY_PATH = "sounds/cry/716.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/xerneas.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Pokemon.Type.FAIRY;
    public static final Pokemon.Type TYPE_TWO = Type.NONE;

    //Exp
    public static final Pokemon.ExpType EXP_TYPE = ExpType.SLOW;

    /**
     * Create a xerneas
     */
    public Xerneas() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init xerneas's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //HEAL PULSE
        beginnerSkills.add(SkillFactory.AROMATHERAPY);
        beginnerSkills.add(SkillFactory.INGRAIN);
        beginnerSkills.add(SkillFactory.TAKE_DOWN);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.LIGHT_SCREEN)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.AURORA_BEAM)));
        //18 GRAVITY
        //26 GEOMANCY
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.MOONBLAST)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEGAHORN)));
        levelUpSkills.put(51, new ArrayList<Integer>(Arrays.asList(SkillFactory.NIGHT_SLASH)));
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.HORN_LEECH)));
        levelUpSkills.put(59, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCH_UP)));
        //63 MISTY TERRAIN
        //72 NATURE POWER
        levelUpSkills.put(80, new ArrayList<Integer>(Arrays.asList(SkillFactory.CLOSE_COMBAT)));
        levelUpSkills.put(88, new ArrayList<Integer>(Arrays.asList(SkillFactory.GIGA_IMPACT)));
        levelUpSkills.put(93, new ArrayList<Integer>(Arrays.asList(SkillFactory.OUTRAGE)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.PSYSHOCK.getValue());
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HAIL.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.FLASH_CANNON.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.DAZZLING_GLEAM.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }
}
