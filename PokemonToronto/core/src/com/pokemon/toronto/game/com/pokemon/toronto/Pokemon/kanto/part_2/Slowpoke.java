package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 9/16/2017.
 */

public class Slowpoke extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 79;
    private static final String NAME = "Slowpoke";
    private static final int BASE_EXP = 99;
    private static final int[] EV_YIELD = {1, 0, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 190;

    //Base Stats
    private static final int BASE_HEALTH = 90;
    private static final int BASE_ATTACK = 65;
    private static final int BASE_DEFENSE = 65;
    private static final int BASE_SPECIAL_ATTACK = 40;
    private static final int BASE_SPECIAL_DEFENSE = 40;
    private static final int BASE_SPEED = 15;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/slowpoke.png";
    private static final String BACK_PATH = "battle/backs/slowpoke.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/slowpoke.png";
    private static final String CRY_PATH = "sounds/cry/079.wav";

    /**
     * Create a Slowpoke with the specified level.
     * @param level The level of the Slowpoke.
     */
    public Slowpoke(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.WATER, Pokemon.Type.PSYCHIC, Ability.OWN_TEMPO, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Slowpoke from the database.
     * @param level The level of the Pokemon.
     * @param ivs  The array of set IVs
     * @param evs The array of set EVs
     * @param firstSkill The first move.
     * @param secondSkill The second move.
     * @param thirdSkill The third move.
     * @param fourthSkill The fourth move.
     * @param currentHealth The current health of the Pokemon.
     * @param currentExp The current exp of the Pokemon.
     * @param status The Pokemon's status.
     * @param nature The Pokemon's nature.
     * @param ability The Pokemon's ability.
     */
    public Slowpoke(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                  Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                  Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.WATER, Type.PSYCHIC, ability, nature, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Slowpoke's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.CURSE);
        beginnerSkills.add(SkillFactory.YAWN);
        beginnerSkills.add(SkillFactory.TACKLE);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.GROWL)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_GUN)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.CONFUSION)));
        //TODO: DISABLE 19
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEADBUTT)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.WATER_PULSE)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.ZEN_HEADBUTT)));
        levelUpSkills.put(36, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLACK_OFF)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.AMNESIA)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCHIC)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.RAIN_DANCE)));
        levelUpSkills.put(54, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCH_UP)));
    }

    /**
     * Return Slowbro if Slowpoke is 37
     * @return Slowbro if Slowpoke is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 37) {
            return PokemonId.SLOWBRO.getValue();
        }
        return -1;
    }
}
