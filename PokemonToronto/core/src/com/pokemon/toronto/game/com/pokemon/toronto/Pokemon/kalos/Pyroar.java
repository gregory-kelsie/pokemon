package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kalos;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-02-02.
 */

public class Pyroar extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 668;
    public static final String NAME = "Pyroar";
    public static final String TYPE_OF_POKEMON = "Royal";
    public static final String DESCRIPTION = "The male with the largest mane of fire is the" +
            " leader of the pride.";
    public static final double HEIGHT = 1.5;
    public static final int BASE_EXP = 177;
    public static final int[] EV_YIELD = {0, 0, 0, 2, 0, 0};
    public static final int CAPTURE_RATE = 65;
    public static final double WEIGHT = 81.5;

    public static final Ability FIRST_ABILITY = new Ability.Rivalry();
    public static final Ability SECOND_ABILITY = new Ability.Unnerve();
    public static final Ability HIDDEN_ABILITY = new Ability.Moxie();

    //Base Stats
    public static final int BASE_HEALTH = 86;
    public static final int BASE_ATTACK = 68;
    public static final int BASE_DEFENSE = 72;
    public static final int BASE_SPECIAL_ATTACK = 109;
    public static final int BASE_SPECIAL_DEFENSE = 66;
    public static final int BASE_SPEED = 106;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/pyroar.png";
    public static final String BACK_PATH = "battle/backs/kalos/pyroar.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/pyroar.png";
    public static final String CRY_PATH = "sounds/cry/668.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/pyroar.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.FIRE;
    public static final Type TYPE_TWO = Type.NORMAL;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a pyroar
     */
    public Pyroar() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init pyroar's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.LEER);
        beginnerSkills.add(SkillFactory.EMBER);
        beginnerSkills.add(SkillFactory.HYPER_BEAM);
        beginnerSkills.add(SkillFactory.WORK_UP);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.EMBER)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.WORK_UP)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEADBUTT)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.NOBLE_ROAR)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.FIRE_FANG)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.ENDEAVOR)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.ECHOED_VOICE)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAMETHROWER)));
        levelUpSkills.put(42, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(48, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPER_VOICE)));
        levelUpSkills.put(51, new ArrayList<Integer>(Arrays.asList(SkillFactory.INCINERATE)));
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.OVERHEAT)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FLAMETHROWER.getValue());
        tmSkills.add(TmId.FIRE_BLAST.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.FLAME_CHARGE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.OVERHEAT.getValue());
        tmSkills.add(TmId.WILL_O_WISP.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.WILD_CHARGE.getValue());
        tmSkills.add(TmId.SNARL.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Return the Pokemon's Front Image path
     * @return The path for the Pokemon's front image.
     */
    @Override
    public String getMapIconPath() {
        if (gender == 'f' || gender == 'F') {
            return "pokemonSprites/kalos/pyroar-f.png";
        }
        return mapIconPath;
    }

    /**
     * Return the Pokemon's Profile Image path.
     * @return The path for the Pokemon's profile image.
     */
    @Override
    public String getProfileIcon() {
        if (gender == 'f' || gender == 'F') {
            return "trainercard/pokemon/kalos/pyroar-f.png";
        }
        return profilePath;
    }

    /**
     * Return the Pokemon's Back Image Path
     * @return The path for the Pokemon's back image.
     */
    @Override
    public String getBackPath() {
        if (gender == 'f' || gender == 'F') {
            return "battle/backs/kalos/pyroar-f.png";
        }
        return backPath;
    }

    /**
     * Return the Pokemon's mini image path.
     * @return The path for the Pokemon's mini image.
     */
    @Override
    public String getMiniIconPath() {
        if (gender == 'f' || gender == 'F') {
            return "pokemonMenu/sprites/kalos/pyroar-f.png";
        }
        return miniPath;

    }

    /**
     * Init pyroar's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .125) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }
}
