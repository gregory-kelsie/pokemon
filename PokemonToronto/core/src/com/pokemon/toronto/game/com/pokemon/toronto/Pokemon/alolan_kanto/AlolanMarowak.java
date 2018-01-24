package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alolan_kanto;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gregory on 10/27/2017.
 */

public class AlolanMarowak extends Pokemon {
    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = -105;
    private static final String NAME = "Marowak";
    private static final int BASE_EXP = 124;
    private static final int[] EV_YIELD = {0, 0, 2, 0, 0, 0};
    private static final int CAPTURE_RATE = 75;
    private static final double WEIGHT = 34;

    private static final Ability FIRST_ABILITY = new Ability.CursedBody();
    private static final Ability SECOND_ABILITY = new Ability.Lightningrod();
    private static final Ability HIDDEN_ABILITY = new Ability.RockHead();

    //Base Stats
    private static final int BASE_HEALTH = 60;
    private static final int BASE_ATTACK = 80;
    private static final int BASE_DEFENSE = 110;
    private static final int BASE_SPECIAL_ATTACK = 50;
    private static final int BASE_SPECIAL_DEFENSE = 80;
    private static final int BASE_SPEED = 45;

    //Typing
    private static final Type TYPE_ONE = Type.FIRE;
    private static final Type TYPE_TWO = Type.GHOST;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/alolan_kanto/marowak.png";
    private static final String BACK_PATH = "battle/backs/alolan_kanto/marowak.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/alolan_kanto/marowak.png";
    private static final String CRY_PATH = "sounds/cry/105.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/alolan_kanto/alolanmarowak.png";

    /**
     * Create a Marowak
     */
    public AlolanMarowak() {
        super(NUMBER, NAME, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Marowak's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.GROWL);
        beginnerSkills.add(SkillFactory.TAIL_WHIP);
        beginnerSkills.add(SkillFactory.BONE_CLUB);
        beginnerSkills.add(SkillFactory.FLAME_WHEEL);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAIL_WHIP)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.BONE_CLUB)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAME_WHEEL)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.LEER)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.HEX)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.BONEMERANG)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.WILL_O_WISP)));
        levelUpSkills.put(27, new ArrayList<Integer>(Arrays.asList(SkillFactory.SHADOW_BONE)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.THRASH)));
        //TODO: FLING 37
        //TODO: STOMPING TANTRUM 43
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.ENDEAVOR)));
        levelUpSkills.put(53, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLARE_BLITZ)));
        //TODO: RETALIATE 59
        levelUpSkills.put(65, new ArrayList<Integer>(Arrays.asList(SkillFactory.BONE_RUSH)));
    }
}
