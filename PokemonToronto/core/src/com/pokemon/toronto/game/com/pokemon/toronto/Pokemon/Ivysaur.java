package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 6/14/2017.
 */
public class Ivysaur extends Pokemon {
    private static final int IVYSAUR_NUMBER = 2;
    private static final String IVYSAUR_NAME = "Ivysaur";
    private static final int IVYSAUR_BASE_EXP = 54;
    private static final int[] IVYSAUR_EV_YIELD = {0, 0, 0, 1, 1, 0};
    private static final int CAPTURE_RATE = 45;
    private static final int IVYSAUR_BASE_HEALTH = 60;
    private static final int IVYSAUR_BASE_ATTACK = 62;
    private static final int IVYSAUR_BASE_DEFENSE = 63;
    private static final int IVYSAUR_BASE_SPECIAL_ATTACK = 80;
    private static final int IVYSAUR_BASE_SPECIAL_DEFENSE = 80;
    private static final int IVYSAUR_BASE_SPEED = 60;

    private static final String IVYSAUR_ICON_PATH = "pokemonSprites/ivysaur/ivysaur.png";
    private static final String IVYSAUR_BACK_PATH = "battle/backs/ivysaur.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/ivysaur.png";
    public Ivysaur(int level) {
        super(IVYSAUR_NUMBER, IVYSAUR_NAME, level, Type.GRASS, Type.POISON, Ability.OVERGROW, ExpType.MEDIUM_SLOW,
                IVYSAUR_BASE_EXP, IVYSAUR_EV_YIELD, new int[]{IVYSAUR_BASE_HEALTH, IVYSAUR_BASE_ATTACK, IVYSAUR_BASE_DEFENSE,
                        IVYSAUR_BASE_SPECIAL_ATTACK, IVYSAUR_BASE_SPECIAL_DEFENSE, IVYSAUR_BASE_SPEED}, IVYSAUR_ICON_PATH,
                IVYSAUR_BACK_PATH, MINI_PATH, CAPTURE_RATE);
        initLevelUpSkills();
        initWildSkills();
    }

    @Override
    protected void initLevelUpSkills() {
        levelUpSkills.put(0, new ArrayList<Integer>(Arrays.asList(SkillFactory.TACKLE)));
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWL)));
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
