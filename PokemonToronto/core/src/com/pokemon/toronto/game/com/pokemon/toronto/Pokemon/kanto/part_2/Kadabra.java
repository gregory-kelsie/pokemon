package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 9/16/2017.
 */

public class Kadabra extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 64;
    private static final String NAME = "Kadabra";
    private static final int BASE_EXP = 140;
    private static final int[] EV_YIELD = {0, 0, 0, 2, 0, 0};
    private static final int CAPTURE_RATE = 100;

    //Base Stats
    private static final int BASE_HEALTH = 40;
    private static final int BASE_ATTACK = 35;
    private static final int BASE_DEFENSE = 30;
    private static final int BASE_SPECIAL_ATTACK = 120;
    private static final int BASE_SPECIAL_DEFENSE = 70;
    private static final int BASE_SPEED = 105;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/kadabra.png";
    private static final String BACK_PATH = "battle/backs/kadabra.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/kadabra.png";
    private static final String CRY_PATH = "sounds/cry/064.wav";

    /**
     * Create a Kadabra with the specified level.
     * @param level The level of the Kadabra.
     */
    public Kadabra(int level) {
        super(NUMBER, NAME, level, Pokemon.Type.PSYCHIC, Pokemon.Type.NONE, Ability.INNER_FOCUS, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE);
    }

    /**
     * Create an Kadabra from the database.
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
    public Kadabra(boolean fromDatabase, int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                Pokemon.Status status, Nature nature, Pokemon.Ability ability) {
        super(NUMBER, NAME, level, gender, status, ivs, evs, Type.PSYCHIC, Type.NONE, ability, nature, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, CAPTURE_RATE, firstSkill, secondSkill,
                thirdSkill, fourthSkill, currentHealth, currentExp);
    }

    /**
     * Init Kadabra's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        //TODO: TELEPORT
        beginnerSkills.add(SkillFactory.CONFUSION);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.CONFUSION)));
        //TODO: DISABLE 18
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYBEAM)));
        //TODO: MIRACLE EYE 23
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.REFLECT)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCHO_CUT)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.RECOVER)));
        //TODO: TELEKINESIS 33
        levelUpSkills.put(38, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCHIC)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROLE_PLAY)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.FUTURE_SIGHT)));
        //TODO: TRICK 46
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.KINESIS);
    }

    /**
     * Return Alakazam if Kadabra is 40
     * @return Alakazam if Kadabra is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 40) {
            return PokemonId.ALAKAZAM.getValue();
        }
        return -1;
    }
}
