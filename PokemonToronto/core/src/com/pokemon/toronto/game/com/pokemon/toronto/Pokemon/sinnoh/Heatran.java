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

public class Heatran extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 485;
    public static final String NAME = "Heatran";
    public static final String TYPE_OF_POKEMON = "Lava Dome";
    public static final String DESCRIPTION = "Its body is made of rugged steel. However, it is" +
            " partially melted in spots because of its own heat.";
    public static final int BASE_EXP = 270;
    public static final int[] EV_YIELD = {0, 0, 0, 3, 0, 0};
    public static final int CAPTURE_RATE = 3;
    public static final double WEIGHT = 430;
    public static final double HEIGHT = 1.7;

    public static final Ability FIRST_ABILITY = new Ability.FlashFire();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.FlameBody();

    //Base Stats
    public static final int BASE_HEALTH = 91;
    public static final int BASE_ATTACK = 90;
    public static final int BASE_DEFENSE = 106;
    public static final int BASE_SPECIAL_ATTACK = 130;
    public static final int BASE_SPECIAL_DEFENSE = 106;
    public static final int BASE_SPEED = 77;

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.FIRE;
    public static final Type TYPE_TWO = Type.STEEL;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/heatran.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/heatran.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/heatran.png";
    public static final String CRY_PATH = "sounds/cry/485.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/heatran.png";

    /**
     * Create a heatran
     */
    public Heatran() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Heatran's gender.
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
     * Init heatran's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.MAGMA_STORM);
        beginnerSkills.add(SkillFactory.HEAT_WAVE);
        beginnerSkills.add(SkillFactory.EARTH_POWER);
        beginnerSkills.add(SkillFactory.IRON_HEAD);
        beginnerSkills.add(SkillFactory.FIRE_SPIN);
        beginnerSkills.add(SkillFactory.ANCIENT_POWER);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEER)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.FIRE_FANG)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.METAL_SOUND)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCARY_FACE)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.LAVA_PLUME)));
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.FIRE_SPIN)));
        levelUpSkills.put(65, new ArrayList<Integer>(Arrays.asList(SkillFactory.IRON_HEAD)));
        levelUpSkills.put(73, new ArrayList<Integer>(Arrays.asList(SkillFactory.EARTH_POWER)));
        levelUpSkills.put(81, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEAT_WAVE)));
        levelUpSkills.put(88, new ArrayList<Integer>(Arrays.asList(SkillFactory.STONE_EDGE)));
        levelUpSkills.put(96, new ArrayList<Integer>(Arrays.asList(SkillFactory.MAGMA_STORM)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FLAMETHROWER.getValue());
        tmSkills.add(TmId.FIRE_BLAST.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.FLAME_CHARGE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.OVERHEAT.getValue());
        tmSkills.add(TmId.WILL_O_WISP.getValue());
        tmSkills.add(TmId.EXPLOSION.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.FLASH_CANNON.getValue());
        tmSkills.add(TmId.NATURE_POWER.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }
}
