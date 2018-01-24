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
 * Created by Gregory on 6/14/2017.
 */
public class Eevee extends Pokemon {

    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 133;
    private static final String NAME = "Eevee";
    private static final int BASE_EXP = 54;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 1, 0};
    private static final int CAPTURE_RATE = 55;
    private static final double WEIGHT = 6.5;

    private static final Ability FIRST_ABILITY = new Ability.RunAway();
    private static final Ability SECOND_ABILITY = new Ability.Adaptability();
    private static final Ability HIDDEN_ABILITY = new Ability.Anticipation();

    //Base Stats
    private static final int BASE_HEALTH = 55;
    private static final int BASE_ATTACK = 50;
    private static final int BASE_DEFENSE = 52;
    private static final int BASE_SPECIAL_ATTACK = 45;
    private static final int BASE_SPECIAL_DEFENSE = 65;
    private static final int BASE_SPEED = 55;

    //Typing
    private static final Type TYPE_ONE = Type.NORMAL;
    private static final Type TYPE_TWO = Type.NONE;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/eevee/eevee.png";
    private static final String BACK_PATH = "battle/backs/eevee.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/eevee.png";
    private static final String CRY_PATH = "sounds/cry/133.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/133.png";

    /**
     * Create a Eevee
     */
    public Eevee() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Eevee's gender.
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

    /**
     * Init Eevee's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.COVET);
        beginnerSkills.add(SkillFactory.GROWL);
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.TAIL_WHIP);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAND_ATTACK)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.BABY_DOLL_EYES)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
        ArrayList<Integer> seventeen = new ArrayList<Integer>();
        seventeen.add(SkillFactory.BITE);
        seventeen.add(SkillFactory.SWIFT);
        levelUpSkills.put(17, seventeen);
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.REFRESH)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARM)));
        //TODO: BATON PASS 33
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.DOUBLE_EDGE)));
        //TODO: LAST RESORT 41
        //TODO: TRUMP CARD 45
    }

    /**
     * Return Vaporeon
     * @return Vaporeon
     */
    @Override
    public int getWaterStoneEvolutionId() {
        return PokemonId.VAPOREON.getValue();
    }

    /**
     * Return Flareon
     * @return Flareon
     */
    @Override
    public int getFireStoneEvolutionId() {
        return PokemonId.FLAREON.getValue();
    }

    /**
     * Return Jolteon
     * @return Jolteon
     */
    @Override
    public int getThunderStoneEvolutionId() {
        return PokemonId.JOLTEON.getValue();
    }

    /**
     * Return Espeon
     * @return Espeon
     */
    @Override
    public int getSunStoneEvolutionId() {
        return PokemonId.ESPEON.getValue();
    }

    /**
     * Return Umbreon
     * @return Umbreon
     */
    @Override
    public int getDuskStoneEvolutionId() {
        return PokemonId.UMBREON.getValue();
    }

}
