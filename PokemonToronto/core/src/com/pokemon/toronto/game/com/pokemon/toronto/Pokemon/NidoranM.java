package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 6/14/2017.
 */
public class NidoranM extends Pokemon {

    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 32;
    private static final String NAME = "Nidoran (m)";
    private static final int BASE_EXP = 54;
    private static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 235;

    //Base Stats
    private static final int BASE_HEALTH = 46;
    private static final int BASE_ATTACK = 57;
    private static final int BASE_DEFENSE = 40;
    private static final int BASE_SPECIAL_ATTACK = 40;
    private static final int BASE_SPECIAL_DEFENSE = 40;
    private static final int BASE_SPEED = 50;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/nidoran-m/nidoran-m.png";
    private static final String BACK_PATH = "battle/backs/nidoran-m.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/nidoran-m.png";
    private static final String CRY_PATH = "sounds/cry/032.wav";

    /**
     * Create a Nidoran m with the specified level.
     * @param level The level of the Nidoran m.
     */
    public NidoranM(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.POISON, Pokemon.Type.NONE, Pokemon.Ability.POISON_POINT, Pokemon.ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create a Nidoran m from the database.
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
    public NidoranM(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                    Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                    Status status, Nature nature, Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.POISON, Type.NONE, ability, nature, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Nidoran M's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.LEER);
        beginnerSkills.add(SkillFactory.PECK);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.FOCUS_ENERGY)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_KICK)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_STING)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_ATTACK)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.HORN_ATTACK)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.TOXIC_SPIKES)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLATTER)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_JAB)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.CAPTIVATE)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.HORN_DRILL)));
    }

    /**
     * Init Nidoran M's gender.
     */
    @Override
    protected void initGender() {
        gender = 'M';
    }

    /**
     * Return Nidorino the Nidoran (m) is above level 16.
     * @return Nidorino if Nidoran (m) is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 16) {
            return PokemonId.NIDORINO.getValue();
        }
        return -1;
    }
}
