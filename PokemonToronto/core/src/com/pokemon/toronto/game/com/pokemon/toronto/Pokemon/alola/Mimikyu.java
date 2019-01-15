package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alola;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-30.
 */

public class Mimikyu extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 778;
    public static final String NAME = "Mimikyu";
    public static final String TYPE_OF_POKEMON = "Disguise";
    public static final String DESCRIPTION = "Its actual appearance is unknown. A scholar who saw" +
            " what was under its rag was overwhelmed by terror and died from the shock.";
    public static final double HEIGHT = 0.2;
    public static final int BASE_EXP = 167;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 2, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 0.7;

    public static final Ability FIRST_ABILITY = new Ability.Disguise();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    public static final int BASE_HEALTH = 55;
    public static final int BASE_ATTACK = 90;
    public static final int BASE_DEFENSE = 80;
    public static final int BASE_SPECIAL_ATTACK = 50;
    public static final int BASE_SPECIAL_DEFENSE = 105;
    public static final int BASE_SPEED = 96;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/alola/mimikyu.png";
    public static final String BACK_PATH = "battle/backs/alola/mimikyu.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/alola/mimikyu.png";
    public static final String CRY_PATH = "sounds/cry/778.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/alola/mimikyu.png";

    private final String BROKEN_DISGUISE_ICON_PATH = "pokemonSprites/alola/mimikyu.png";
    private final String BROKEN_DISGUISE_BACK_PATH = "battle/backs/alola/mimikyu.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.GHOST;
    public static final Type TYPE_TWO = Type.FAIRY;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    private boolean hasDisguise;

    /**
     * Create a mimikyu
     */
    public Mimikyu() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
        hasDisguise = true;
    }

    @Override
    public void resetEndBattleVariables() {
        super.resetEndBattleVariables();
        hasDisguise = true;
    }

    @Override
    public boolean hasDisguise() {
        return hasDisguise;
    }
    @Override
    public void removeDisguise() {
        hasDisguise = false;
    }

    /**
     * Return the Pokemon's Front Image path
     * @return The path for the Pokemon's front image.
     */
    @Override
    public String getMapIconPath() {
        if (!hasDisguise) {
            return BROKEN_DISGUISE_ICON_PATH;
        }
        return mapIconPath;
    }

    /**
     * Return the Pokemon's Back Image Path
     * @return The path for the Pokemon's back image.
     */
    @Override
    public String getBackPath() {
        if (!hasDisguise) {
            return BROKEN_DISGUISE_BACK_PATH;
        }
        return backPath;
    }

    /**
     * Init mimikyu's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.WOOD_HAMMER);
        beginnerSkills.add(SkillFactory.SPLASH);
        beginnerSkills.add(SkillFactory.SCRATCH);
        beginnerSkills.add(SkillFactory.ASTONISH);
        //COPYCAT
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_TEAM)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.BABY_DOLL_EYES)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHADOW_SNEAK)));
        //19 MIMIC
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT_ATTACK)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARM)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLASH)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHADOW_CLAW)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.HONE_CLAWS)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.PLAY_ROUGH)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.PAIN_SPLIT)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.BULK_UP.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.LEECH_LIFE.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FLING.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.WILL_O_WISP.getValue());
        tmSkills.add(TmId.EMBARGO.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.X_SCISSOR.getValue());
        tmSkills.add(TmId.INFESTATION.getValue());
        tmSkills.add(TmId.DREAM_EATER.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.TRICK_ROOM.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.DAZZLING_GLEAM.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init mimikyu's gender.
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
