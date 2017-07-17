package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/14/2017.
 */
public class Charizard extends Pokemon {
    private static final int NUMBER = 6;
    private static final String NAME = "Charizard";
    private static final int BASE_EXP = 54;
    private static final int[] EV_YIELD = {0, 0, 0, 3, 0, 0};
    private static final int CAPTURE_RATE = 45;
    private static final int BASE_HEALTH = 78;
    private static final int BASE_ATTACK = 84;
    private static final int BASE_DEFENSE = 78;
    private static final int BASE_SPECIAL_ATTACK = 109;
    private static final int BASE_SPECIAL_DEFENSE = 85;
    private static final int BASE_SPEED = 100;

    private static final String ICON_PATH = "pokemonSprites/charizard/charizard.png";
    private static final String BACK_PATH = "battle/backs/charizard.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/charizard.png";
    public Charizard(int level) {
        super(NUMBER, NAME, level, Type.FIRE, Type.FLYING, Ability.BLAZE, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CAPTURE_RATE);
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
