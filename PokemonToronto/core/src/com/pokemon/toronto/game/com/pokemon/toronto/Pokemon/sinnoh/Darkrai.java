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

public class Darkrai extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 491;
    public static final String NAME = "Darkrai";
    public static final String TYPE_OF_POKEMON = "Pitch-Black";
    public static final String DESCRIPTION = "To protect itself, it afflicts those around it" +
            " with nightmares. However, it means no harm.";
    public static final int BASE_EXP = 270;
    public static final int[] EV_YIELD = {0, 0, 0, 2, 0, 1};
    public static final int CAPTURE_RATE = 3;
    public static final double WEIGHT = 50.5;
    public static final double HEIGHT = 1.5;

    public static final Ability FIRST_ABILITY = new Ability.BadDreams();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    public static final int BASE_HEALTH = 70;
    public static final int BASE_ATTACK = 90;
    public static final int BASE_DEFENSE = 90;
    public static final int BASE_SPECIAL_ATTACK = 135;
    public static final int BASE_SPECIAL_DEFENSE = 90;
    public static final int BASE_SPEED = 125;

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.DARK;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/darkrai.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/darkrai.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/darkrai.png";
    public static final String CRY_PATH = "sounds/cry/491.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/darkrai.png";

    /**
     * Create a darkrai
     */
    public Darkrai() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init darkrai's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.OMINOUS_WIND);
        //DISABLE
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPNOSIS)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT_ATTACK)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.NIGHTMARE)));
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_TEAM)));
        levelUpSkills.put(57, new ArrayList<Integer>(Arrays.asList(SkillFactory.HAZE)));
        levelUpSkills.put(66, new ArrayList<Integer>(Arrays.asList(SkillFactory.DARK_VOID)));
        levelUpSkills.put(75, new ArrayList<Integer>(Arrays.asList(SkillFactory.NASTY_PLOT)));
        levelUpSkills.put(84, new ArrayList<Integer>(Arrays.asList(SkillFactory.DREAM_EATER)));
        levelUpSkills.put(93, new ArrayList<Integer>(Arrays.asList(SkillFactory.DARK_PULSE)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.BLIZZARD.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SLUDGE_BOMB.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.WILL_O_WISP.getValue());
        tmSkills.add(TmId.EMBARGO.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.X_SCISSOR.getValue());
        tmSkills.add(TmId.POISON_JAB.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SNARL.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }
}
