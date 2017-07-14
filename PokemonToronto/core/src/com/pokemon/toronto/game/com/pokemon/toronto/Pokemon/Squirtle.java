package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 6/14/2017.
 */
public class Squirtle extends Pokemon {
    private static final int SQUIRTLE_NUMBER = 7;
    private static final String SQUIRTLE_NAME = "Squirtle";
    private static final int SQUIRTLE_BASE_EXP = 54;
    private static final int[] SQUIRTLE_EV_YIELD = {0, 0, 1, 0, 0, 0};
    private static final int SQUIRTLE_CAPTURE_RATE = 45;
    private static final int SQUIRTLE_BASE_HEALTH = 44;
    private static final int SQUIRTLE_BASE_ATTACK = 48;
    private static final int SQUIRTLE_BASE_DEFENSE = 65;
    private static final int SQUIRTLE_BASE_SPECIAL_ATTACK = 50;
    private static final int SQUIRTLE_BASE_SPECIAL_DEFENSE = 64;
    private static final int SQUIRTLE_BASE_SPEED = 43;

    private static final String SQUIRTLE_ICON_PATH = "pokemonSprites/squirtle/squirtle.png";
    private static final String BACK_PATH = "battle/backs/squirtle.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/squirtle.png";
    public Squirtle(int level) {
        super(SQUIRTLE_NUMBER, SQUIRTLE_NAME, level, Type.WATER, Type.NONE, Ability.TORRENT, ExpType.MEDIUM_SLOW,
                SQUIRTLE_BASE_EXP, SQUIRTLE_EV_YIELD, new int[]{SQUIRTLE_BASE_HEALTH, SQUIRTLE_BASE_ATTACK, SQUIRTLE_BASE_DEFENSE,
                        SQUIRTLE_BASE_SPECIAL_ATTACK, SQUIRTLE_BASE_SPECIAL_DEFENSE, SQUIRTLE_BASE_SPEED}, SQUIRTLE_ICON_PATH,
                BACK_PATH, MINI_PATH);
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
