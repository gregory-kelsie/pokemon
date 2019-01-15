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

public class Pangoro extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 675;
    public static final String NAME = "Pangoro";
    public static final String TYPE_OF_POKEMON = "Daunting";
    public static final String DESCRIPTION = "Although it posses a violent temperament, it won't" +
            " put up with bullying. It uses the leaf in its mouth to sense the movements of its enemies.";
    public static final double HEIGHT = 2.1;
    public static final int BASE_EXP = 173;
    public static final int[] EV_YIELD = {0, 2, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 65;
    public static final double WEIGHT = 136;

    public static final Ability FIRST_ABILITY = new Ability.IronFist();
    public static final Ability SECOND_ABILITY = new Ability.MoldBreaker();
    public static final Ability HIDDEN_ABILITY = new Ability.Scrappy();

    //Base Stats
    public static final int BASE_HEALTH = 95;
    public static final int BASE_ATTACK = 124;
    public static final int BASE_DEFENSE = 78;
    public static final int BASE_SPECIAL_ATTACK = 69;
    public static final int BASE_SPECIAL_DEFENSE = 71;
    public static final int BASE_SPEED = 58;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/pangoro.png";
    public static final String BACK_PATH = "battle/backs/kalos/pangoro.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/pangoro.png";
    public static final String CRY_PATH = "sounds/cry/675.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/pangoro.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.FIGHTING;
    public static final Type TYPE_TWO = Type.DARK;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a pangoro
     */
    public Pangoro() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init pangoro's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.LEER);
        beginnerSkills.add(SkillFactory.ARM_THRUST);
        beginnerSkills.add(SkillFactory.HAMMER_ARM);
        beginnerSkills.add(SkillFactory.LOW_SWEEP);
        //ENTERTAINMENT
        beginnerSkills.add(SkillFactory.WORK_UP);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.ARM_THRUST)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.WORK_UP)));
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.KARATE_CHOP)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.COMET_PUNCH)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLASH)));
        //25 CIRCLE THROW
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.VITAL_THROW)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.BODY_SLAM)));
        levelUpSkills.put(42, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        //45 ENTERTAINMENT
        //48 PARTING SHOT
        levelUpSkills.put(52, new ArrayList<Integer>(Arrays.asList(SkillFactory.SKY_UPPERCUT)));
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.LOW_SWEEP)));
        //65 TAUNT
        levelUpSkills.put(70, new ArrayList<Integer>(Arrays.asList(SkillFactory.HAMMER_ARM)));
        initEvolutionSkills();
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.DRAGON_CLAW.getValue());
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.BULK_UP.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SLUDGE_BOMB.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.LOW_SWEEP.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.FALSE_SWIPE.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.QUASH.getValue());
        tmSkills.add(TmId.EMBARGO.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.X_SCISSOR.getValue());
        tmSkills.add(TmId.INFESTATION.getValue());
        tmSkills.add(TmId.POISON_JAB.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SURF.getValue());
        tmSkills.add(TmId.SNARL.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.BULLET_PUNCH);
    }

    /**
     * Init pangoro's gender.
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
}
