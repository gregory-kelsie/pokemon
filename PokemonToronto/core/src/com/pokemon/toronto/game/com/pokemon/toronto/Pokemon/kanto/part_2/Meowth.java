package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 9/15/2017.
 */

public class Meowth extends Pokemon {

    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 52;
    private static final String NAME = "Meowth";
    private static final int BASE_EXP = 58;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    private static final int CAPTURE_RATE = 255;

    //Base Stats
    private static final int BASE_HEALTH = 40;
    private static final int BASE_ATTACK = 45;
    private static final int BASE_DEFENSE = 35;
    private static final int BASE_SPECIAL_ATTACK = 40;
    private static final int BASE_SPECIAL_DEFENSE = 40;
    private static final int BASE_SPEED = 90;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/meowth.png";
    private static final String BACK_PATH = "battle/backs/meowth.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/meowth.png";
    private static final String CRY_PATH = "sounds/cry/052.wav";

    /**
     * Create a Meowth with the specified level.
     * @param level The level of the Meowth.
     */
    public Meowth(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.NORMAL, Pokemon.Type.NONE, Ability.UNNERVE, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Meowth from the database.
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
    public Meowth(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                   Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                   Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.NORMAL, Type.NONE, ability, nature, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Meowth's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SCRATCH);
        beginnerSkills.add(SkillFactory.GROWL);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.FAKE_OUT)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_SWIPES)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCREECH)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT_ATTACK)));
        //TODO: TAUNT 25
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.PAY_DAY)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLASH)));
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.NASTY_PLOT)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.ASSURANCE)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.CAPTIVATE)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.NIGHT_SLASH)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT)));
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.DARK_PULSE)));
    }

    /**
     * Return Persian if the Meowth is above level 28.
     * @return Persian if Meowth is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 28) {
            return PokemonId.PERSIAN.getValue();
        }
        return -1;
    }

}
