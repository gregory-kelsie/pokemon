package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 6/11/2017.
 */
public class Pikachu extends Pokemon {
    private static final int NUMBER = 25;
    private static final String NAME = "Pikachu";
    private static final int BASE_EXP = 82;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 2};
    private static final int CAPTURE_RATE = 190;
    private static final int BASE_HEALTH = 35;
    private static final int BASE_ATTACK = 55;
    private static final int BASE_DEFENSE = 40;
    private static final int BASE_SPECIAL_ATTACK = 50;
    private static final int BASE_SPECIAL_DEFENSE = 50;
    private static final int BASE_SPEED = 90;

    private static final String ICON_PATH = "pokemonSprites/pikachu/pikachu.png";
    private static final String BACK_PATH = "battle/backs/pikachu.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/pikachu.png";
    public Pikachu(int level) {
        super(NUMBER, NAME, level, Type.ELECTRIC, Type.NONE, Ability.STATIC, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH, BACK_PATH, MINI_PATH,
                CAPTURE_RATE);
        initLevelUpSkills();
        initWildSkills();
    }
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TAIL_WHIP);
        beginnerSkills.add(SkillFactory.THUNDER_SHOCK);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
    }
    @Override
    protected void initGender() {
        int genderProbability = (int)(Math.round(Math.random() * 100));
        if (genderProbability <= 50) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }
}
