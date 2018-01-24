package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 8/16/2017.
 */

public class Metapod extends Pokemon {

    /** Init Variables */
    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 11;
    private static final String NAME = "Metapod";
    private static final int BASE_EXP = 72;
    private static final int[] EV_YIELD = {0, 0, 2, 0, 0, 0};
    private static final int CAPTURE_RATE = 120;
    private static final double WEIGHT = 9.9;

    private static final Ability FIRST_ABILITY = new Ability.ShedSkin();
    private static final Ability SECOND_ABILITY = null;
    private static final Ability HIDDEN_ABILITY = null;


    //Base Stats
    private static final int BASE_HEALTH = 50;
    private static final int BASE_ATTACK = 20;
    private static final int BASE_DEFENSE = 55;
    private static final int BASE_SPECIAL_ATTACK = 25;
    private static final int BASE_SPECIAL_DEFENSE = 25;
    private static final int BASE_SPEED = 30;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/metapod.png";
    private static final String BACK_PATH = "battle/backs/metapod.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/metapod.png";
    private static final String CRY_PATH = "sounds/cry/011.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/011.png";

    /**
     * Create a Metapod
     */
    public Metapod() {
        super(NUMBER, NAME, Type.BUG, Type.NONE, ExpType.MEDIUM_FAST,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init Metapod's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.HARDEN);
        levelUpSkills.put(0, beginnerSkills);
        initEvolutionSkills();
    }

    @Override
    protected void initEvolutionSkills() {
        evolutionSkills.add(SkillFactory.HARDEN);
    }

    /**
     * Return Butterfree if the Metapod is above level 10.
     * @return Butterfree if Metapod is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 10) {
            return PokemonId.BUTTERFREE.getValue();
        }
        return -1;
    }

}
