package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Gregory on 6/14/2017.
 */
public class Wartortle extends Pokemon {
    private static final int WARTORTLE_NUMBER = 8;
    private static final String WARTORTLE_NAME = "Wartortle";
    private static final int WARTORTLE_BASE_EXP = 54;
    private static final int[] WARTORTLE_EV_YIELD = {0, 0, 1, 0, 1, 0};
    private static final int CAPTURE_RATE = 45;
    private static final int WARTORTLE_BASE_HEALTH = 59;
    private static final int WARTORTLE_BASE_ATTACK = 63;
    private static final int WARTORTLE_BASE_DEFENSE = 80;
    private static final int WARTORTLE_BASE_SPECIAL_ATTACK = 65;
    private static final int WARTORTLE_BASE_SPECIAL_DEFENSE = 80;
    private static final int WARTORTLE_BASE_SPEED = 58;

    private static final String WARTORTLE_ICON_PATH = "pokemonSprites/wartortle/wartortle.png";
    private static final String BACK_PATH = "battle/backs/wartortle.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/wartortle.png";
    public Wartortle(int level) {
        super(WARTORTLE_NUMBER, WARTORTLE_NAME, level, Type.WATER, Type.NONE, Ability.TORRENT, ExpType.MEDIUM_SLOW,
                WARTORTLE_BASE_EXP, WARTORTLE_EV_YIELD, new int[]{WARTORTLE_BASE_HEALTH, WARTORTLE_BASE_ATTACK, WARTORTLE_BASE_DEFENSE,
                        WARTORTLE_BASE_SPECIAL_ATTACK, WARTORTLE_BASE_SPECIAL_DEFENSE, WARTORTLE_BASE_SPEED}, WARTORTLE_ICON_PATH,
                BACK_PATH, MINI_PATH, CAPTURE_RATE);
        initLevelUpSkills();
        initWildSkills();
    }

    @Override
    protected void initLevelUpSkills() {
        levelUpSkills.put(0, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCRATCH)));
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAIL_WHIP)));
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
