package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 6/14/2017.
 */
public class Eevee extends Pokemon {
    private static final int EEVEE_NUMBER = 133;
    private static final String EEVEE_NAME = "Eevee";
    private static final int EEVEE_BASE_EXP = 54;
    private static final int[] EEVEE_EV_YIELD = {0, 0, 0, 0, 1, 0};
    private static final int CAPTURE_RATE = 55;
    private static final int EEVEE_BASE_HEALTH = 55;
    private static final int EEVEE_BASE_ATTACK = 50;
    private static final int EEVEE_BASE_DEFENSE = 52;
    private static final int EEVEE_BASE_SPECIAL_ATTACK = 45;
    private static final int EEVEE_BASE_SPECIAL_DEFENSE = 65;
    private static final int EEVEE_BASE_SPEED = 55;

    private static final String EEVEE_ICON_PATH = "pokemonSprites/eevee/eevee.png";
    private static final String EEVEE_BACK_PATH = "battle/backs/eevee.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/eevee.png";
    public Eevee(int level) {
        super(EEVEE_NUMBER, EEVEE_NAME, level, Type.NORMAL, Type.NONE, Ability.RUN_AWAY, ExpType.MEDIUM_FAST,
                EEVEE_BASE_EXP, EEVEE_EV_YIELD, new int[]{EEVEE_BASE_HEALTH, EEVEE_BASE_ATTACK, EEVEE_BASE_DEFENSE,
                        EEVEE_BASE_SPECIAL_ATTACK, EEVEE_BASE_SPECIAL_DEFENSE, EEVEE_BASE_SPEED}, EEVEE_ICON_PATH,
                EEVEE_BACK_PATH, MINI_PATH, CAPTURE_RATE);
        initLevelUpSkills();
        initWildSkills();
    }
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.COVET);
        beginnerSkills.add(SkillFactory.GROWL);
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.TAIL_WHIP);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAND_ATTACK)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
    }
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .875) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }
}