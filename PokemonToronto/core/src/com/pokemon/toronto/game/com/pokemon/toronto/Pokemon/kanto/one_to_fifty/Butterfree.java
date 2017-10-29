package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 8/16/2017.
 */

public class Butterfree extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 12;
    private static final String NAME = "Butterfree";
    private static final int BASE_EXP = 160;
    private static final int[] EV_YIELD = {0, 0, 0, 2, 1, 0};
    private static final int CAPTURE_RATE = 45;
    private static final double WEIGHT = 32;


    //Base Stats
    private static final int BASE_HEALTH = 60;
    private static final int BASE_ATTACK = 45;
    private static final int BASE_DEFENSE = 50;
    private static final int BASE_SPECIAL_ATTACK = 90;
    private static final int BASE_SPECIAL_DEFENSE = 80;
    private static final int BASE_SPEED = 70;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/butterfree.png";
    private static final String BACK_PATH = "battle/backs/butterfree.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/butterfree.png";
    private static final String CRY_PATH = "sounds/cry/012.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/012.png";

    /**
     * Create a Butterfree with the specified level.
     * @param level The level of the Butterfree.
     */
    public Butterfree(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.BUG, Pokemon.Type.FLYING, Pokemon.ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT);
    }

    /**
     * Create an Butterfree from the database.
     * @param level The level of the Pokemon.
     * @param ivs  The array of set IVs
     * @param evs The array of set EVs
     * @param firstSkill The first move.
     * @param secondSkill The second move.
     * @param thirdSkill The third move.
     * @param fourthSkill The fourth move.
     * @param currentHealth The current health of the Pokemon.
     * @param currentExp The current exp of the Pokemon.
     * @param status The Pokemon's status.
     * @param nature The Pokemon's nature.
     * @param ability The Pokemon's ability.
     */
    public Butterfree(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                   Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                   Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Pokemon.Type.BUG, Pokemon.Type.FLYING, ability, nature, Pokemon.ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT,
                firstSkill, secondSkill, thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Butterfree's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.CONFUSION);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.CONFUSION)));
        ArrayList<Integer> thirteen = new ArrayList<Integer>();
        thirteen.add(SkillFactory.POISON_POWDER);
        thirteen.add(SkillFactory.STUN_SPORE);
        thirteen.add(SkillFactory.SLEEP_POWDER);
        levelUpSkills.put(13, thirteen);
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYBEAM)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.SILVER_WIND)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUPERSONIC)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAFEGUARD)));
        //TODO: WHIRLWIND 29
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUG_BUZZ)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.CAPTIVATE)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAILWIND)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.AIR_SLASH)));
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUIVER_DANCE)));
    }

    //TODO: HIDDEN ABILITY = TINTED LENS AND NORMAL ABILITY = COMPOUND EYES
    @Override
    protected void initAbility() {
        ability = Ability.TINTED_LENS;
    }

    /**
     * Butterfree learns Gust when Metapod evolves into it.
     */
    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.GUST);
    }
}
