package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 9/21/2017.
 */

public class MrMime extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 122;
    private static final String NAME = "Mr. Mime";
    private static final int BASE_EXP = 136;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 2, 0};
    private static final int CAPTURE_RATE = 45;
    private static final double WEIGHT = 54.5;

    //Base Stats
    private static final int BASE_HEALTH = 40;
    private static final int BASE_ATTACK = 45;
    private static final int BASE_DEFENSE = 65;
    private static final int BASE_SPECIAL_ATTACK = 100;
    private static final int BASE_SPECIAL_DEFENSE = 120;
    private static final int BASE_SPEED = 90;

    //Typing
    private static final Type TYPE_ONE = Type.PSYCHIC;
    private static final Type TYPE_TWO = Type.FAIRY;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/mrmime.png";
    private static final String BACK_PATH = "battle/backs/mrmime.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/mrmime.png";
    private static final String CRY_PATH = "sounds/cry/122.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/122.png";

    /**
     * Create a MrMime with the specified level.
     * @param level The level of the MrMime.
     */
    public MrMime(int level) {
        super(NUMBER, NAME, level, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT);
    }

    /**
     * Create an MrMime from the database.
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
    public MrMime(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                  Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                  Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, TYPE_ONE, TYPE_TWO, ability, nature, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT,
                firstSkill, secondSkill, thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    //TODO: HIDDEN TECHNICIAN
    @Override
    protected void initAbility() {
        if (Math.random() <= .5) {
            //TODO: SOUNDPROOF
            ability = Ability.FILTER;
        } else {
            ability = Ability.FILTER;
        }
    }

    /**
     * Init MrMime's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //TODO: MISTY TERRAIN
        beginnerSkills.add(SkillFactory.MAGICAL_LEAF);
        //TODO: QUICK GUARD
        //TODO: WIDE GUARD
        //TODO: POWER SWAP
        //TODO: GUARD SWAP
        beginnerSkills.add(SkillFactory.BARRIER);
        beginnerSkills.add(SkillFactory.CONFUSION);
        levelUpSkills.put(0, beginnerSkills);
        //TODO: COPYCAT 4
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEDITATE)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_SLAP)));
        //TODO: MIMIC 15
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYWAVE)));
        //TODO: ENCORE 18
        ArrayList<Integer> screens = new ArrayList<Integer>();
        screens.add(SkillFactory.LIGHT_SCREEN);
        screens.add(SkillFactory.REFLECT);
        levelUpSkills.put(22, screens);
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYBEAM)));
        //TODO: SUBSTITUTE 29
        //TODO: RECYCLE 32
        //TODO: TRICK 36
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCHIC)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROLE_PLAY)));
        //TODO: BATON PASS 46
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAFEGUARD)));

    }

}
