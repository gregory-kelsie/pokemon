package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 6/11/2017.
 */
public class Rattata extends Pokemon {
    private static final int RATTATA_NUMBER = 19;
    private static final String RATTATA_NAME = "Rattata";
    private static final int RATTATA_BASE_EXP = 54;
    private static final int[] RATTATA_EV_YIELD = {0, 0, 0, 0, 0, 1};
    private static final int RATTATA_CAPTURE_RATE = 255;
    private static final int RATTATA_BASE_HEALTH = 30;
    private static final int RATTATA_BASE_ATTACK = 1000; //56
    private static final int RATTATA_BASE_DEFENSE = 35;
    private static final int RATTATA_BASE_SPECIAL_ATTACK = 25;
    private static final int RATTATA_BASE_SPECIAL_DEFENSE = 35;
    private static final int RATTATA_BASE_SPEED = 72;

    private static final String RATTATA_ICON_PATH = "pokemonSprites/rattata/rattata.png";
    private static final String BACK_PATH = "battle/backs/rattata.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/rattata.png";
    public Rattata(int level) {
        super(RATTATA_NUMBER, RATTATA_NAME, level, Type.NORMAL, Type.NONE, Ability.GUTS, ExpType.MEDIUM_FAST,
                RATTATA_BASE_EXP, RATTATA_EV_YIELD, new int[]{RATTATA_BASE_HEALTH, RATTATA_BASE_ATTACK, RATTATA_BASE_DEFENSE,
                RATTATA_BASE_SPECIAL_ATTACK, RATTATA_BASE_SPECIAL_DEFENSE, RATTATA_BASE_SPEED}, RATTATA_ICON_PATH,
                BACK_PATH, MINI_PATH);
        initLevelUpSkills();
        initWildSkills();
    }

    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.TAIL_WHIP);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
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
