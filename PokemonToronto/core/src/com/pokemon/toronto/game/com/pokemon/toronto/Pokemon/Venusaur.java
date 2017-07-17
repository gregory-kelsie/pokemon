package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 6/14/2017.
 */
public class Venusaur extends Pokemon {
    private static final int VENUSAUR_NUMBER = 3;
    private static final String VENUSAUR_NAME = "Venusaur";
    private static final int VENUSAUR_BASE_EXP = 54;
    private static final int[] VENUSAUR_EV_YIELD = {0, 0, 0, 2, 1, 0};
    private static final int CAPTURE_RATE = 45;
    private static final int VENUSAUR_BASE_HEALTH = 80;
    private static final int VENUSAUR_BASE_ATTACK = 82;
    private static final int VENUSAUR_BASE_DEFENSE = 83;
    private static final int VENUSAUR_BASE_SPECIAL_ATTACK = 100;
    private static final int VENUSAUR_BASE_SPECIAL_DEFENSE = 100;
    private static final int VENUSAUR_BASE_SPEED = 80;

    private static final String VENUSAUR_ICON_PATH = "pokemonSprites/venusaur/venusaur.png";
    private static final String BACK_PATH = "battle/backs/venusaur.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/venusaur.png";
    public Venusaur(int level) {
        super(VENUSAUR_NUMBER, VENUSAUR_NAME, level, Type.GRASS, Type.POISON, Ability.OVERGROW, ExpType.MEDIUM_SLOW,
                VENUSAUR_BASE_EXP, VENUSAUR_EV_YIELD, new int[]{VENUSAUR_BASE_HEALTH, VENUSAUR_BASE_ATTACK, VENUSAUR_BASE_DEFENSE,
                        VENUSAUR_BASE_SPECIAL_ATTACK, VENUSAUR_BASE_SPECIAL_DEFENSE, VENUSAUR_BASE_SPEED}, VENUSAUR_ICON_PATH,
                BACK_PATH, MINI_PATH, CAPTURE_RATE);
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
