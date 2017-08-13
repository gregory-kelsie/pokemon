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

    /**
     * Create a Nidoran m with the specified level.
     * @param level The level of the Nidoran m.
     */
    public NidoranM(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.POISON, Pokemon.Type.NONE, Pokemon.Ability.POISON_POINT, Pokemon.ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CAPTURE_RATE);
        initLevelUpSkills();
        initWildSkills();
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
    public NidoranM(int level, int[] ivs, int [] evs, Skill firstSkill,
                    Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                    Status status, Nature nature, Ability ability) {
        super(NUMBER, NAME, level, Type.POISON, Type.NONE, Ability.POISON_POINT, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CAPTURE_RATE);
        initLevelUpSkills();
        addSkills(firstSkill, secondSkill, thirdSkill, fourthSkill);
        setHealthAndExp(currentHealth, currentExp);
        this.evs = evs;
        this.ivs = ivs;
        this.status = status;
        this.nature = nature;
        this.ability = ability;
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
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_STING)));
    }

    /**
     * Init Nidoran M's gender.
     */
    @Override
    protected void initGender() {
        gender = 'M';
    }
}
