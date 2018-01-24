package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 8/16/2017.
 */

public class Raichu extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 26;
    private static final String NAME = "Raichu";
    private static final int BASE_EXP = 122;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 3};
    private static final int CAPTURE_RATE = 75;
    private static final double WEIGHT = 30;

    private static final Ability FIRST_ABILITY = new Ability.Static();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = new Ability.Lightningrod();

    //Base Stats
    private static final int BASE_HEALTH = 60;
    private static final int BASE_ATTACK = 90;
    private static final int BASE_DEFENSE = 55;
    private static final int BASE_SPECIAL_ATTACK = 90;
    private static final int BASE_SPECIAL_DEFENSE = 80;
    private static final int BASE_SPEED = 110;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/raichu.png";
    private static final String BACK_PATH = "battle/backs/raichu.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/raichu.png";
    private static final String CRY_PATH = "sounds/cry/026.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/026.png";

    /**
     * Create a Raichu
     */
    public Raichu() {
        super(NUMBER, NAME, Type.ELECTRIC, Type.NONE, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH, BACK_PATH, MINI_PATH,
                CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY, SECOND_ABILITY,
                HIDDEN_ABILITY);
    }

    /**
     * Init Raichu's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.THUNDER_SHOCK);
        beginnerSkills.add(SkillFactory.TAIL_WHIP);
        beginnerSkills.add(SkillFactory.QUICK_ATTACK);
        beginnerSkills.add(SkillFactory.THUNDERBOLT);
        levelUpSkills.put(0, beginnerSkills);
    }
}
