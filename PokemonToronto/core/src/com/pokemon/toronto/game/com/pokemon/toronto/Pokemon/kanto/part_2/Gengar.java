package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 9/16/2017.
 */

public class Gengar extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 94;
    private static final String NAME = "Gengar";
    private static final int BASE_EXP = 190;
    private static final int[] EV_YIELD = {0, 0, 0, 3, 0, 0};
    private static final int CAPTURE_RATE = 45;

    //Base Stats
    private static final int BASE_HEALTH = 60;
    private static final int BASE_ATTACK = 65;
    private static final int BASE_DEFENSE = 60;
    private static final int BASE_SPECIAL_ATTACK = 130;
    private static final int BASE_SPECIAL_DEFENSE = 75;
    private static final int BASE_SPEED = 110;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/gengar.png";
    private static final String BACK_PATH = "battle/backs/gengar.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/gengar.png";
    private static final String CRY_PATH = "sounds/cry/094.wav";

    /**
     * Create a Gengar with the specified level.
     * @param level The level of the Gengar.
     */
    public Gengar(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.GHOST, Type.POISON, Ability.LEVITATE, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Gengar from the database.
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
    public Gengar(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                  Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                  Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.GHOST, Type.POISON, ability, nature, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Gengar's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.HYPNOSIS);
        beginnerSkills.add(SkillFactory.LICK);
        //TODO: SPITE
        levelUpSkills.put(0, beginnerSkills);
        //TODO: SPITE 5
        //TODO: MEAN LOOK 8
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.CURSE)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.NIGHT_SHADE)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.CONFUSE_RAY)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUCKER_PUNCH)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.PAYBACK)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHADOW_BALL)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.DREAM_EATER)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.DARK_PULSE)));
        //TODO: DESTINY BOND 50
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEX)));
        levelUpSkills.put(61, new ArrayList<Integer>(Arrays.asList(SkillFactory.NIGHTMARE)));
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.SHADOW_PUNCH);
    }

}
