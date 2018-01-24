package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty;

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
 * Created by Gregory on 8/16/2017.
 */

public class Oddish extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 43;
    private static final String NAME = "Oddish";
    private static final int BASE_EXP = 78;
    private static final int[] EV_YIELD = {0, 0, 0, 1, 0, 0};
    private static final int CAPTURE_RATE = 255;
    private static final double WEIGHT = 5.4;

    private static final Ability FIRST_ABILITY = new Ability.Chlorophyll();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = new Ability.RunAway();

    //Base Stats
    private static final int BASE_HEALTH = 45;
    private static final int BASE_ATTACK = 50;
    private static final int BASE_DEFENSE = 55;
    private static final int BASE_SPECIAL_ATTACK = 75;
    private static final int BASE_SPECIAL_DEFENSE = 65;
    private static final int BASE_SPEED = 30;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/oddish.png";
    private static final String BACK_PATH = "battle/backs/oddish.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/oddish.png";
    private static final String CRY_PATH = "sounds/cry/043.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/043.png";

    /**
     * Create a Oddish
     */
    public Oddish() {
        super(NUMBER, NAME, Pokemon.Type.GRASS, Pokemon.Type.POISON, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Oddish's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.ABSORB);
        beginnerSkills.add(SkillFactory.GROWTH);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWEET_SCENT)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.ACID)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_POWDER)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.STUN_SPORE)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLEEP_POWDER)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEGA_DRAIN)));
        //TODO: LUCKY CHANT 23
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.MOONLIGHT)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.GIGA_DRAIN)));
        //TODO: TOXIC 35
        //TODO: NATURAL GIFT 39
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.MOONBLAST)));
        //TODO: GRASSY TERRAIN 47
        levelUpSkills.put(51, new ArrayList<Integer>(Arrays.asList(SkillFactory.PETAL_DANCE)));
    }

    /**
     * Return Gloom if the Oddish is above level 21.
     * @return Gloom if Oddish is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 21) {
            return PokemonId.GLOOM.getValue();
        }
        return -1;
    }
}
