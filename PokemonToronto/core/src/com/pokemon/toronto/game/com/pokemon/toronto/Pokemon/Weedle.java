package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/14/2017.
 */
public class Weedle extends Pokemon {
    private static final int WEEDLE_NUMBER = 13;
    private static final String WEEDLE_NAME = "Weedle";
    private static final int WEEDLE_BASE_EXP = 54;
    private static final int[] WEEDLE_EV_YIELD = {0, 0, 0, 0, 0, 1};
    private static final int CAPTURE_RATE = 255;
    private static final int WEEDLE_BASE_HEALTH = 40;
    private static final int WEEDLE_BASE_ATTACK = 35;
    private static final int WEEDLE_BASE_DEFENSE = 30;
    private static final int WEEDLE_BASE_SPECIAL_ATTACK = 20;
    private static final int WEEDLE_BASE_SPECIAL_DEFENSE = 20;
    private static final int WEEDLE_BASE_SPEED = 50;

    private static final String WEEDLE_ICON_PATH = "pokemonSprites/weedle/weedle.png";
    private static final String BACK_PATH = "battle/backs/weedle.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/weedle.png";
    public Weedle(int level) {
        super(WEEDLE_NUMBER, WEEDLE_NAME, level, Type.BUG, Type.POISON, Ability.SHIELD_DUST, ExpType.MEDIUM_FAST,
                WEEDLE_BASE_EXP, WEEDLE_EV_YIELD, new int[]{WEEDLE_BASE_HEALTH, WEEDLE_BASE_ATTACK, WEEDLE_BASE_DEFENSE,
                        WEEDLE_BASE_SPECIAL_ATTACK, WEEDLE_BASE_SPECIAL_DEFENSE, WEEDLE_BASE_SPEED}, WEEDLE_ICON_PATH,
                BACK_PATH, MINI_PATH, CAPTURE_RATE);
        initLevelUpSkills();
        initWildSkills();
    }
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.POISON_STING);
        beginnerSkills.add(SkillFactory.STRING_SHOT);
        levelUpSkills.put(0, beginnerSkills);
    }
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .5) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }
}
