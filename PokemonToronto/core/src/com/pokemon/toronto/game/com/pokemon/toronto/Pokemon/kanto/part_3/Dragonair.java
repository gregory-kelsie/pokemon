package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 9/21/2017.
 */

public class Dragonair extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 148;
    private static final String NAME = "Dragonair";
    private static final int BASE_EXP = 144;
    private static final int[] EV_YIELD = {0, 2, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 45;
    private static final double WEIGHT = 16.5;

    private static final Ability FIRST_ABILITY = new Ability.ShedSkin();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = new Ability.MarvelScale();

    //Base Stats
    private static final int BASE_HEALTH = 61;
    private static final int BASE_ATTACK = 84;
    private static final int BASE_DEFENSE = 65;
    private static final int BASE_SPECIAL_ATTACK = 70;
    private static final int BASE_SPECIAL_DEFENSE = 70;
    private static final int BASE_SPEED = 70;

    //Typing
    private static final Type TYPE_ONE = Type.DRAGON;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.SLOW;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/dragonair.png";
    private static final String BACK_PATH = "battle/backs/dragonair.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/dragonair.png";
    private static final String CRY_PATH = "sounds/cry/148.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/148.png";

    /**
     * Create a Dragonair
     */
    public Dragonair() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Dragonair's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.WRAP);
        beginnerSkills.add(SkillFactory.LEER);
        beginnerSkills.add(SkillFactory.THUNDER_WAVE);
        beginnerSkills.add(SkillFactory.TWISTER);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.THUNDER_WAVE)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.TWISTER)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAGON_RAGE)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLAM)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.AGILITY)));
        //TODO: DRAGON TAIL 33
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.AQUA_TAIL)));
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAGON_RUSH)));
        levelUpSkills.put(53, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAFEGUARD)));
        levelUpSkills.put(61, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAGON_DANCE)));
        levelUpSkills.put(67, new ArrayList<Integer>(Arrays.asList(SkillFactory.OUTRAGE)));
        levelUpSkills.put(75, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPER_BEAM)));
    }

    /**
     * Return Dragonite if Dragonair is 55
     * @return Dragonite if Dragonair is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 55) {
            return PokemonId.DRAGONITE.getValue();
        }
        return -1;
    }
}
