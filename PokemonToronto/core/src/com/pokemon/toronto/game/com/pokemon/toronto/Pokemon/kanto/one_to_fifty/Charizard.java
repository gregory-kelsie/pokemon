package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 6/14/2017.
 */
public class Charizard extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 6;
    private static final String NAME = "Charizard";
    private static final int BASE_EXP = 54;
    private static final int[] EV_YIELD = {0, 0, 0, 3, 0, 0};
    private static final int CAPTURE_RATE = 45;
    private static final double WEIGHT = 90.5;

    private static final Ability FIRST_ABILITY = new Ability.Blaze();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = new Ability.SolarPower();


    //Base Stats
    private static final int BASE_HEALTH = 78;
    private static final int BASE_ATTACK = 84;
    private static final int BASE_DEFENSE = 78;
    private static final int BASE_SPECIAL_ATTACK = 109;
    private static final int BASE_SPECIAL_DEFENSE = 85;
    private static final int BASE_SPEED = 100;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/charizard/charizard.png";
    private static final String BACK_PATH = "battle/backs/charizard.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/charizard.png";
    private static final String CRY_PATH = "sounds/cry/006.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/006.png";

    /**
     * Create a Charizard
     **/
    public Charizard() {
        super(NUMBER, NAME, Type.FIRE, Type.FLYING, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Charizard's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.FLARE_BLITZ);
        beginnerSkills.add(SkillFactory.HEAT_WAVE);
        beginnerSkills.add(SkillFactory.DRAGON_CLAW);
        beginnerSkills.add(SkillFactory.SHADOW_CLAW);
        beginnerSkills.add(SkillFactory.AIR_SLASH);
        beginnerSkills.add(SkillFactory.SCRATCH);
        beginnerSkills.add(SkillFactory.GROWL);
        beginnerSkills.add(SkillFactory.EMBER);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.EMBER)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.SMOKESCREEN)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAGON_RAGE)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCARY_FACE)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.FIRE_FANG)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAME_BURST)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLASH)));
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAMETHROWER)));
        levelUpSkills.put(56, new ArrayList<Integer>(Arrays.asList(SkillFactory.FIRE_SPIN)));
        levelUpSkills.put(62, new ArrayList<Integer>(Arrays.asList(SkillFactory.INFERNO)));
        levelUpSkills.put(71, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEAT_WAVE)));
        levelUpSkills.put(77, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLARE_BLITZ)));
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.WING_ATTACK);
    }

    /**
     * Init Charizard's gender.
     */
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
