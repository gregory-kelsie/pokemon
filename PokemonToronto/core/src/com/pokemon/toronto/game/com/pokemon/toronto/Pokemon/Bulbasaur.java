package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 6/14/2017.
 */
public class Bulbasaur extends Pokemon {
    private static final int BULBASAUR_NUMBER = 1;
    private static final String BULBASAUR_NAME = "Bulbasaur";
    private static final int BULBASAUR_BASE_EXP = 54;
    private static final int[] BULBASAUR_EV_YIELD = {0, 0, 0, 1, 0, 0};
    private static final int CAPTURE_RATE = 45;
    private static final int BULBASAUR_BASE_HEALTH = 45;
    private static final int BULBASAUR_BASE_ATTACK = 49;
    private static final int BULBASAUR_BASE_DEFENSE = 49;
    private static final int BULBASAUR_BASE_SPECIAL_ATTACK = 65;
    private static final int BULBASAUR_BASE_SPECIAL_DEFENSE = 65;
    private static final int BULBASAUR_BASE_SPEED = 45;

    private static final String BULBASAUR_ICON_PATH = "pokemonSprites/bulbasaur/bulbasaur.png";
    private static final String BULBASAUR_BACK_PATH = "battle/backs/bulbasaur.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/bulbasaur.png";
    public Bulbasaur(int level) {
        super(BULBASAUR_NUMBER, BULBASAUR_NAME, level, Type.GRASS, Type.POISON, Ability.OVERGROW, ExpType.MEDIUM_SLOW,
                BULBASAUR_BASE_EXP, BULBASAUR_EV_YIELD, new int[]{BULBASAUR_BASE_HEALTH, BULBASAUR_BASE_ATTACK, BULBASAUR_BASE_DEFENSE,
                        BULBASAUR_BASE_SPECIAL_ATTACK, BULBASAUR_BASE_SPECIAL_DEFENSE, BULBASAUR_BASE_SPEED}, BULBASAUR_ICON_PATH,
                BULBASAUR_BACK_PATH, MINI_PATH, CAPTURE_RATE);
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
