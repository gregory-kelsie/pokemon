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

public class Goodra extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 706;
    public static final String NAME = "Goodra";
    public static final String TYPE_OF_POKEMON = "Dragon";
    public static final String DESCRIPTION = "It attacks with retractable horns. It throws a " +
            "punch that's the equivalent of the force of a hundred pro boxers.";
    public static final double HEIGHT = 2;
    public static final int BASE_EXP = 270;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 3, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 150.5;

    public static final Ability FIRST_ABILITY = new Ability.SapSipper();
    public static final Ability SECOND_ABILITY = new Ability.Hydration();
    public static final Ability HIDDEN_ABILITY = new Ability.Gooey();

    //Base Stats
    public static final int BASE_HEALTH = 90;
    public static final int BASE_ATTACK = 100;
    public static final int BASE_DEFENSE = 70;
    public static final int BASE_SPECIAL_ATTACK = 110;
    public static final int BASE_SPECIAL_DEFENSE = 150;
    public static final int BASE_SPEED = 80;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/goodra.png";
    public static final String BACK_PATH = "battle/backs/kalos/goodra.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/goodra.png";
    public static final String CRY_PATH = "sounds/cry/706.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/goodra.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.DRAGON;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    /**
     * Create a goodra
     */
    public Goodra() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init goodra's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.ABSORB);
        beginnerSkills.add(SkillFactory.BUBBLE);
        //PROTECT
        beginnerSkills.add(SkillFactory.OUTRAGE);
        beginnerSkills.add(SkillFactory.FEINT);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.ABSORB)));
        //9 PROTECT
        //13 BIDE
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAGON_BREATH)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAIN_DANCE)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAIL)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.BODY_SLAM)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.MUDDY_WATER)));
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAGON_PULSE)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.POWER_WHIP)));
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.OUTRAGE)));
        initEvolutionSkills();
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.BLIZZARD.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SLUDGE_WAVE.getValue());
        tmSkills.add(TmId.FLAMETHROWER.getValue());
        tmSkills.add(TmId.SLUDGE_BOMB.getValue());
        tmSkills.add(TmId.FIRE_BLAST.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.BRUTAL_SWING.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.DRAGON_TAIL.getValue());
        tmSkills.add(TmId.INFESTATION.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.AQUA_TAIL);
    }

    /**
     * Init goodra's gender.
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
