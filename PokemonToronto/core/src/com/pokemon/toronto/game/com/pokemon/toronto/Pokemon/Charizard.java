package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/14/2017.
 */
public class Charizard extends Pokemon {
    private static final int CHARIZARD_NUMBER = 6;
    private static final String CHARIZARD_NAME = "Charizard";
    private static final int CHARIZARD_BASE_EXP = 54;
    private static final int[] CHARIZARD_EV_YIELD = {0, 0, 0, 3, 0, 0};
    private static final int CAPTURE_RATE = 45;
    private static final int CHARIZARD_BASE_HEALTH = 78;
    private static final int CHARIZARD_BASE_ATTACK = 84;
    private static final int CHARIZARD_BASE_DEFENSE = 78;
    private static final int CHARIZARD_BASE_SPECIAL_ATTACK = 109;
    private static final int CHARIZARD_BASE_SPECIAL_DEFENSE = 85;
    private static final int CHARIZARD_BASE_SPEED = 100;

    private static final String CHARIZARD_ICON_PATH = "pokemonSprites/charizard/charizard.png";
    private static final String CHARIZARD_BACK_PATH = "battle/backs/charizard.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/charizard.png";
    public Charizard(int level) {
        super(CHARIZARD_NUMBER, CHARIZARD_NAME, level, Type.FIRE, Type.FLYING, Ability.BLAZE, ExpType.MEDIUM_SLOW,
                CHARIZARD_BASE_EXP, CHARIZARD_EV_YIELD, new int[]{CHARIZARD_BASE_HEALTH, CHARIZARD_BASE_ATTACK, CHARIZARD_BASE_DEFENSE,
                        CHARIZARD_BASE_SPECIAL_ATTACK, CHARIZARD_BASE_SPECIAL_DEFENSE, CHARIZARD_BASE_SPEED}, CHARIZARD_ICON_PATH,
                CHARIZARD_BACK_PATH, MINI_PATH, CAPTURE_RATE);
        initLevelUpSkills();
        initWildSkills();
    }
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SCRATCH);
        beginnerSkills.add(SkillFactory.GROWL);
        levelUpSkills.put(0, beginnerSkills);
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
