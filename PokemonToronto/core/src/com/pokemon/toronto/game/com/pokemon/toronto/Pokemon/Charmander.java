package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/14/2017.
 */
public class Charmander extends Pokemon {
    private static final int CHARMANDER_NUMBER = 4;
    private static final String CHARMANDER_NAME = "Charmander";
    private static final int CHARMANDER_BASE_EXP = 54;
    private static final int[] CHARMANDER_EV_YIELD = {0, 0, 0, 0, 0, 1};
    private static final int CHARMANDER_CAPTURE_RATE = 45;
    private static final int CHARMANDER_BASE_HEALTH = 39;
    private static final int CHARMANDER_BASE_ATTACK = 52;
    private static final int CHARMANDER_BASE_DEFENSE = 43;
    private static final int CHARMANDER_BASE_SPECIAL_ATTACK = 60;
    private static final int CHARMANDER_BASE_SPECIAL_DEFENSE = 50;
    private static final int CHARMANDER_BASE_SPEED = 65;

    private static final String CHARMANDER_ICON_PATH = "pokemonSprites/charmander/charmander.png";
    private static final String CHARMANDER_BACK_PATH = "battle/backs/charmander.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/charmander.png";
    public Charmander(int level) {
        super(CHARMANDER_NUMBER, CHARMANDER_NAME, level, Type.FIRE, Type.NONE, Ability.BLAZE, ExpType.MEDIUM_SLOW,
                CHARMANDER_BASE_EXP, CHARMANDER_EV_YIELD, new int[]{CHARMANDER_BASE_HEALTH, CHARMANDER_BASE_ATTACK, CHARMANDER_BASE_DEFENSE,
                        CHARMANDER_BASE_SPECIAL_ATTACK, CHARMANDER_BASE_SPECIAL_DEFENSE, CHARMANDER_BASE_SPEED}, CHARMANDER_ICON_PATH,
                CHARMANDER_BACK_PATH, MINI_PATH);
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
