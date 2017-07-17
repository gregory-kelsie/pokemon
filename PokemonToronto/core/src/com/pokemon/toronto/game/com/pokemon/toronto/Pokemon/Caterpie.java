package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/14/2017.
 */
public class Caterpie extends Pokemon {
    private static final int CATERPIE_NUMBER = 10;
    private static final String CATERPIE_NAME = "Caterpie";
    private static final int CATERPIE_BASE_EXP = 54;
    private static final int[] CATERPIE_EV_YIELD = {1, 0, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 255;
    private static final int CATERPIE_BASE_HEALTH = 45;
    private static final int CATERPIE_BASE_ATTACK = 30;
    private static final int CATERPIE_BASE_DEFENSE = 35;
    private static final int CATERPIE_BASE_SPECIAL_ATTACK = 20;
    private static final int CATERPIE_BASE_SPECIAL_DEFENSE = 20;
    private static final int CATERPIE_BASE_SPEED = 45;

    private static final String CATERPIE_ICON_PATH = "pokemonSprites/caterpie/caterpie.png";
    private static final String CATERPIE_BACK_PATH = "battle/backs/caterpie.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/caterpie.png";
    public Caterpie(int level) {
        super(CATERPIE_NUMBER, CATERPIE_NAME, level, Type.BUG, Type.NONE, Ability.SHIELD_DUST, ExpType.MEDIUM_FAST,
                CATERPIE_BASE_EXP, CATERPIE_EV_YIELD, new int[]{CATERPIE_BASE_HEALTH, CATERPIE_BASE_ATTACK, CATERPIE_BASE_DEFENSE,
                        CATERPIE_BASE_SPECIAL_ATTACK, CATERPIE_BASE_SPECIAL_DEFENSE, CATERPIE_BASE_SPEED}, CATERPIE_ICON_PATH,
                CATERPIE_BACK_PATH, MINI_PATH, CAPTURE_RATE);
        initLevelUpSkills();
        initWildSkills();
    }
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
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
