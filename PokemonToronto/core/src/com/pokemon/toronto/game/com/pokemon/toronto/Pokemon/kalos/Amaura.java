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

public class Amaura extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 698;
    public static final String NAME = "Amaura";
    public static final String TYPE_OF_POKEMON = "Tundra";
    public static final String DESCRIPTION = "This ancient Pokémon was restored from part of " +
            "its body that had been frozen in ice for over 100 million years.";
    public static final double HEIGHT = 1.3;
    public static final int BASE_EXP = 72;
    public static final int[] EV_YIELD = {1, 0, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 25.2;

    public static final Ability FIRST_ABILITY = new Ability.Refrigerate();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.SnowWarning();

    //Base Stats
    public static final int BASE_HEALTH = 77;
    public static final int BASE_ATTACK = 59;
    public static final int BASE_DEFENSE = 50;
    public static final int BASE_SPECIAL_ATTACK = 67;
    public static final int BASE_SPECIAL_DEFENSE = 63;
    public static final int BASE_SPEED = 46;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/amaura.png";
    public static final String BACK_PATH = "battle/backs/kalos/amaura.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/amaura.png";
    public static final String CRY_PATH = "sounds/cry/698.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/amaura.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.ROCK;
    public static final Type TYPE_TWO = Type.ICE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a amaura
     */
    public Amaura() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init amaura's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.GROWL);
        beginnerSkills.add(SkillFactory.POWDER_SNOW);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDER_WAVE)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_THROW)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.ICY_WIND)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.MIST)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.AURORA_BEAM)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.ANCIENT_POWER)));
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROUND)));
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.AVALANCHE)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.HAIL)));
        //41 NATURE POWER
        //44 ENCORE
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.LIGHT_SCREEN)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.ICE_BEAM)));
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPER_BEAM)));
        levelUpSkills.put(65, new ArrayList<Integer>(Arrays.asList(SkillFactory.BLIZZARD)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HAIL.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.BLIZZARD.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.ROCK_POLISH.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.FROST_BREATH.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.DRAGON_TAIL.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.FLASH_CANNON.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init amaura's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .875) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }

    /**
     * Return Aurorus if the amaura is above level 39.
     * @return Aurorus if amaura is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 39) {
            return PokemonId.AURORUS.getValue();
        }
        return -1;
    }
}
