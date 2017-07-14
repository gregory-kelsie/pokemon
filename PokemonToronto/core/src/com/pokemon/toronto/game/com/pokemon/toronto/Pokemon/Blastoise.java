package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Gregory on 6/14/2017.
 */
public class Blastoise extends Pokemon {

    private static final int BLASTOISE_NUMBER = 9;
    private static final String BLASTOISE_NAME = "Blastoise";
    private static final int BLASTOISE_BASE_EXP = 54;
    private static final int[] BLASTOISE_EV_YIELD = {0, 0, 0, 0, 3, 0};
    private static final int BLASTOISE_CAPTURE_RATE = 45;
    private static final int BLASTOISE_BASE_HEALTH = 79;
    private static final int BLASTOISE_BASE_ATTACK = 83;
    private static final int BLASTOISE_BASE_DEFENSE = 100;
    private static final int BLASTOISE_BASE_SPECIAL_ATTACK = 85;
    private static final int BLASTOISE_BASE_SPECIAL_DEFENSE = 105;
    private static final int BLASTOISE_BASE_SPEED = 78;

    private static final String BLASTOISE_ICON_PATH = "pokemonSprites/blastoise/blastoise.png";
    private static final String BLASTOISE_BACK_PATH = "battle/backs/blastoise.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/blastoise.png";
    public Blastoise(int level) {
        super(BLASTOISE_NUMBER, BLASTOISE_NAME, level, Type.WATER, Type.NONE, Ability.TORRENT, ExpType.MEDIUM_SLOW,
                BLASTOISE_BASE_EXP, BLASTOISE_EV_YIELD, new int[]{BLASTOISE_BASE_HEALTH, BLASTOISE_BASE_ATTACK, BLASTOISE_BASE_DEFENSE,
                        BLASTOISE_BASE_SPECIAL_ATTACK, BLASTOISE_BASE_SPECIAL_DEFENSE, BLASTOISE_BASE_SPEED}, BLASTOISE_ICON_PATH,
                BLASTOISE_BACK_PATH, MINI_PATH);
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
