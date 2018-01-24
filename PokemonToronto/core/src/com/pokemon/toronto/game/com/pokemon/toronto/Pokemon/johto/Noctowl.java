package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-22.
 */

public class Noctowl extends Pokemon {

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 164;
    private static final String NAME = "Noctowl";
    private static final int BASE_EXP = 162;
    private static final int[] EV_YIELD = {2, 0, 0, 0, 0, 0};
    private static final int CAPTURE_RATE = 90;
    private static final double WEIGHT = 40.8;

    private static final Ability FIRST_ABILITY = new Ability.Insomnia();
    private static final Ability SECOND_ABILITY = new Ability.KeenEye();
    private static final Ability HIDDEN_ABILITY = new Ability.TintedLens();

    //Base Stats
    private static final int BASE_HEALTH = 100;
    private static final int BASE_ATTACK = 50;
    private static final int BASE_DEFENSE = 50;
    private static final int BASE_SPECIAL_ATTACK = 86;
    private static final int BASE_SPECIAL_DEFENSE = 96;
    private static final int BASE_SPEED = 70;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/johto/noctowl.png";
    private static final String BACK_PATH = "battle/backs/johto/noctowl.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/johto/noctowl.png";
    private static final String CRY_PATH = "sounds/cry/164.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/johto/noctowl.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    private static final Type TYPE_TWO = Type.FLYING;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a noctowl
     */
    public Noctowl() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init noctowl's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.DREAM_EATER);
        beginnerSkills.add(SkillFactory.SKY_ATTACK);
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.GROWL);
        //todo: foresight
        beginnerSkills.add(SkillFactory.HYPNOSIS);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPNOSIS)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.PECK)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.CONFUSION)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.ECHOED_VOICE)));
        levelUpSkills.put(16, new ArrayList<Integer>(Arrays.asList(SkillFactory.ZEN_HEADBUTT)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.PSYCHO_SHIFT)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.EXTRASENSORY)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.REFLECT)));
        levelUpSkills.put(35, new ArrayList<Integer>(Arrays.asList(SkillFactory.AIR_SLASH)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.UPROAR)));
        levelUpSkills.put(43, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROOST)));
        levelUpSkills.put(47, new ArrayList<Integer>(Arrays.asList(SkillFactory.MOONBLAST)));
        levelUpSkills.put(51, new ArrayList<Integer>(Arrays.asList(SkillFactory.SYNCHRONOISE)));
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.DREAM_EATER)));
    }

    /**
     * Init noctowl's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .5) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }
    
}
