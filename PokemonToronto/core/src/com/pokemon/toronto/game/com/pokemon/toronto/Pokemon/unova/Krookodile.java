package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.unova;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-05-06.
 */

public class Krookodile extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 553;
    public static final String NAME = "Krookodile";
    public static final String TYPE_OF_POKEMON = "Indimidation";
    public static final String DESCRIPTION = "They never allow prey to escape. Their jaws are" +
            " so powerful, they can crush the body of an automobile.";
    public static final double HEIGHT = 1.5;
    public static final int BASE_EXP = 234;
    public static final int[] EV_YIELD = {0, 3, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 96.3;

    public static final Ability FIRST_ABILITY = new Ability.Intimidate();
    public static final Ability SECOND_ABILITY = new Ability.Moxie();
    public static final Ability HIDDEN_ABILITY = new Ability.AngerPoint();

    //Base Stats
    public static final int BASE_HEALTH = 95;
    public static final int BASE_ATTACK = 117;
    public static final int BASE_DEFENSE = 80;
    public static final int BASE_SPECIAL_ATTACK = 65;
    public static final int BASE_SPECIAL_DEFENSE = 70;
    public static final int BASE_SPEED = 92;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/krookodile.png";
    public static final String BACK_PATH = "battle/backs/unova/krookodile.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/krookodile.png";
    public static final String CRY_PATH = "sounds/cry/553.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/krookodile.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GROUND;
    public static final Type TYPE_TWO = Type.DARK;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a krookodile
     */
    public Krookodile() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init krookodile's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //power trip
        beginnerSkills.add(SkillFactory.LEER);
        beginnerSkills.add(SkillFactory.RAGE);
        beginnerSkills.add(SkillFactory.BITE);
        beginnerSkills.add(SkillFactory.SAND_ATTACK);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAND_ATTACK)));
        //10 TORMENT
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAND_TOMB)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.ASSURANCE)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUD_SLAP)));
        //22 EMBARGO
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWAGGER)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.DIG)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCARY_FACE)));
        levelUpSkills.put(42, new ArrayList<Integer>(Arrays.asList(SkillFactory.FOUL_PLAY)));
        levelUpSkills.put(48, new ArrayList<Integer>(Arrays.asList(SkillFactory.SANDSTORM)));
        levelUpSkills.put(54, new ArrayList<Integer>(Arrays.asList(SkillFactory.EARTHQUAKE)));
        levelUpSkills.put(60, new ArrayList<Integer>(Arrays.asList(SkillFactory.OUTRAGE)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.DRAGON_CLAW.getValue());
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.BULK_UP.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SMACK_DOWN.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SLUDGE_BOMB.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.LOW_SWEEP.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.BRUTAL_SWING.getValue());
        tmSkills.add(TmId.EMBARGO.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.DRAGON_TAIL.getValue());
        tmSkills.add(TmId.GRASS_KNOT.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SNARL.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init krookodile's gender.
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
