package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2;

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
 * Created by Gregory on 9/16/2017.
 */

public class Haunter extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 93;
    private static final String NAME = "Haunter";
    private static final int BASE_EXP = 126;
    private static final int[] EV_YIELD = {0, 0, 0, 2, 0, 0};
    private static final int CAPTURE_RATE = 90;
    private static final double WEIGHT = 0.1;

    private static final Ability FIRST_ABILITY = new Ability.Levitate();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    private static final int BASE_HEALTH = 45;
    private static final int BASE_ATTACK = 50;
    private static final int BASE_DEFENSE = 45;
    private static final int BASE_SPECIAL_ATTACK = 115;
    private static final int BASE_SPECIAL_DEFENSE = 55;
    private static final int BASE_SPEED = 95;

    //Typing
    private static final Type TYPE_ONE = Type.GHOST;
    private static final Type TYPE_TWO = Type.POISON;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/haunter.png";
    private static final String BACK_PATH = "battle/backs/haunter.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/haunter.png";
    private static final String CRY_PATH = "sounds/cry/093.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/093.png";

    /**
     * Create a Haunter
     */
    public Haunter() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Haunter's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.HYPNOSIS);
        beginnerSkills.add(SkillFactory.LICK);
        //TODO: SPITE
        levelUpSkills.put(0, beginnerSkills);
        //TODO: SPITE 5
        //TODO: MEAN LOOK 8
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.CURSE)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.NIGHT_SHADE)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.CONFUSE_RAY)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUCKER_PUNCH)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.PAYBACK)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHADOW_BALL)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.DREAM_EATER)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.DARK_PULSE)));
        //TODO: DESTINY BOND 50
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEX)));
        levelUpSkills.put(61, new ArrayList<Integer>(Arrays.asList(SkillFactory.NIGHTMARE)));
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.SHADOW_PUNCH);
    }

    /**
     * Return Gengar if Haunter is 45
     * @return Gengar if Haunter is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 45) {
            return PokemonId.GENGAR.getValue();
        }
        return -1;
    }
}
