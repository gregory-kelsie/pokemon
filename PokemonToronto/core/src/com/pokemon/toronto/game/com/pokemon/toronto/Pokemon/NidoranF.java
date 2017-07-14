package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 6/14/2017.
 */
public class NidoranF extends Pokemon {
    private static final int NIDORANF_NUMBER = 29;
    private static final String NIDORANF_NAME = "Nidoran (f)";
    private static final int NIDORANF_BASE_EXP = 54;
    private static final int[] NIDORANF_EV_YIELD = {1, 0, 0, 0, 0, 0};
    private static final int NIDORANF_CAPTURE_RATE = 235;
    private static final int NIDORANF_BASE_HEALTH = 55;
    private static final int NIDORANF_BASE_ATTACK = 47;
    private static final int NIDORANF_BASE_DEFENSE = 52;
    private static final int NIDORANF_BASE_SPECIAL_ATTACK = 40;
    private static final int NIDORANF_BASE_SPECIAL_DEFENSE = 40;
    private static final int NIDORANF_BASE_SPEED = 41;

    private static final String NIDORANF_ICON_PATH = "pokemonSprites/nidoran-f/nidoran-f.png";
    private static final String NIDORANF_BACK_PATH = "battle/backs/nidoran-f.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/nidoran-f.png";
    public NidoranF(int level) {
        super(NIDORANF_NUMBER, NIDORANF_NAME, level, Type.POISON, Type.NONE, Ability.POISON_POINT, ExpType.MEDIUM_SLOW,
                NIDORANF_BASE_EXP, NIDORANF_EV_YIELD, new int[]{NIDORANF_BASE_HEALTH, NIDORANF_BASE_ATTACK, NIDORANF_BASE_DEFENSE,
                        NIDORANF_BASE_SPECIAL_ATTACK, NIDORANF_BASE_SPECIAL_DEFENSE, NIDORANF_BASE_SPEED}, NIDORANF_ICON_PATH,
                NIDORANF_BACK_PATH, MINI_PATH);
        initLevelUpSkills();
        initWildSkills();
    }
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.GROWL);
        beginnerSkills.add(SkillFactory.SCRATCH);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAIL_WHIP)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_STING)));
    }
    @Override
    protected void initGender() {
        gender = 'F';
    }
}
