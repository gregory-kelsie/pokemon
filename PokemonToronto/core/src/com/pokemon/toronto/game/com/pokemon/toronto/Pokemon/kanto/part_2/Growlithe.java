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
 * Created by Gregory on 9/15/2017.
 */

public class Growlithe extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 58;
    private static final String NAME = "Growlithe";
    private static final int BASE_EXP = 70;
    private static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 190;

    //Base Stats
    private static final int BASE_HEALTH = 55;
    private static final int BASE_ATTACK = 70;
    private static final int BASE_DEFENSE = 45;
    private static final int BASE_SPECIAL_ATTACK = 70;
    private static final int BASE_SPECIAL_DEFENSE = 50;
    private static final int BASE_SPEED = 60;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/growlithe.png";
    private static final String BACK_PATH = "battle/backs/growlithe.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/growlithe.png";
    private static final String CRY_PATH = "sounds/cry/058.wav";

    /**
     * Create a Growlithe with the specified level.
     * @param level The level of the Growlithe.
     */
    public Growlithe(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.FIRE, Pokemon.Type.NONE, Ability.INTIMIDATE, ExpType.SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Growlithe from the database.
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
    public Growlithe(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                  Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                  Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.FIRE, Type.NONE, ability, nature, ExpType.SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Growlithe's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.BITE);
        //TODO: ROAR
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(6, new ArrayList<Integer>(Arrays.asList(SkillFactory.EMBER)));
        levelUpSkills.put(8, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEER)));
        //TODO: ODOR SLEUTH 10
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAME_WHEEL)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.REVERSAL)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.FIRE_FANG)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAME_BURST)));
        levelUpSkills.put(30, new ArrayList<Integer>(Arrays.asList(SkillFactory.AGILITY)));
        //TODO: RETALIATE 32
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAMETHROWER)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEAT_WAVE)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.OUTRAGE)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLARE_BLITZ)));
    }

    /**
     * Return Arcanine when a Fire Stone is used on Growlithe.
     * @return
     */
    @Override
    public int getFireStoneEvolutionId() {
        return PokemonId.ARCANINE.getValue();
    }


}
