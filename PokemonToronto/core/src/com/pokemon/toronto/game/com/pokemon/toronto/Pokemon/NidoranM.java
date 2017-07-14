package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 6/14/2017.
 */
public class NidoranM extends Pokemon {
    private static final int NIDORANM_NUMBER = 32;
    private static final String NIDORANM_NAME = "Nidoran (m)";
    private static final int NIDORANM_BASE_EXP = 54;
    private static final int[] NIDORANM_EV_YIELD = {0, 1, 0, 0, 0, 0};
    private static final int NIDORANM_CAPTURE_RATE = 235;
    private static final int NIDORANM_BASE_HEALTH = 46;
    private static final int NIDORANM_BASE_ATTACK = 57;
    private static final int NIDORANM_BASE_DEFENSE = 40;
    private static final int NIDORANM_BASE_SPECIAL_ATTACK = 40;
    private static final int NIDORANM_BASE_SPECIAL_DEFENSE = 40;
    private static final int NIDORANM_BASE_SPEED = 50;

    private static final String NIDORANM_ICON_PATH = "pokemonSprites/nidoran-m/nidoran-m.png";
    private static final String NIDORANM_BACK_PATH = "battle/backs/nidoran-m.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/nidoran-m.png";
    public NidoranM(int level) {
        super(NIDORANM_NUMBER, NIDORANM_NAME, level, Pokemon.Type.POISON, Pokemon.Type.NONE, Pokemon.Ability.POISON_POINT, Pokemon.ExpType.MEDIUM_SLOW,
                NIDORANM_BASE_EXP, NIDORANM_EV_YIELD, new int[]{NIDORANM_BASE_HEALTH, NIDORANM_BASE_ATTACK, NIDORANM_BASE_DEFENSE,
                        NIDORANM_BASE_SPECIAL_ATTACK, NIDORANM_BASE_SPECIAL_DEFENSE, NIDORANM_BASE_SPEED}, NIDORANM_ICON_PATH,
                NIDORANM_BACK_PATH, MINI_PATH);
        initLevelUpSkills();
        initWildSkills();
    }
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.LEER);
        beginnerSkills.add(SkillFactory.PECK);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_STING)));
    }
    @Override
    protected void initGender() {
        gender = 'M';
    }
}
