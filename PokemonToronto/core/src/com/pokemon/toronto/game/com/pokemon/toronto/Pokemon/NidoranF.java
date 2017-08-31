package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 6/14/2017.
 */
public class NidoranF extends Pokemon {

    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 29;
    private static final String NAME = "Nidoran (f)";
    private static final int BASE_EXP = 54;
    private static final int[] EV_YIELD = {1, 0, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 235;

    //Base Stats
    private static final int BASE_HEALTH = 55;
    private static final int BASE_ATTACK = 47;
    private static final int BASE_DEFENSE = 52;
    private static final int BASE_SPECIAL_ATTACK = 40;
    private static final int BASE_SPECIAL_DEFENSE = 40;
    private static final int BASE_SPEED = 41;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/nidoran-f/nidoran-f.png";
    private static final String BACK_PATH = "battle/backs/nidoran-f.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/nidoran-f.png";
    private static final String CRY_PATH = "sounds/cry/029.wav";

    /**
     * Create a Nidoran f with the specified level.
     * @param level The level of the Nidoran f.
     */
    public NidoranF(int level) {
        super(NUMBER, NAME, level, Type.POISON, Type.NONE, Ability.POISON_POINT, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
        initLevelUpSkills();
        initWildSkills();
    }

    /**
     * Create a Nidoran f from the database.
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
    public NidoranF(int level, int[] ivs, int [] evs, Skill firstSkill,
                   Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                   Status status, Nature nature, Ability ability) {
        super(NUMBER, NAME, level, Type.POISON, Type.NONE, Ability.POISON_POINT, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
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
     * Init Nidoran F's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.GROWL);
        beginnerSkills.add(SkillFactory.SCRATCH);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAIL_WHIP)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_STING)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
    }

    /**
     * Init Nidoran F's gender.
     */
    @Override
    protected void initGender() {
        gender = 'F';
    }

    /**
     * Return Nidorina if the Nidoran (f) is above level 16.
     * @return Nidorina if Nidoran (f) is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 16) {
            return PokemonId.NIDORINA.getValue();
        }
        return -1;
    }
}
