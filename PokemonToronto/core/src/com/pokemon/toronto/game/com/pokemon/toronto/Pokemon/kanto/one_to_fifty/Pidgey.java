package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Gregory on 6/11/2017.
 */
public class Pidgey extends Pokemon {

    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 16;
    private static final String NAME = "Pidgey";
    private static final int BASE_EXP = 55;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    private static final int CAPTURE_RATE = 255;
    private static final double WEIGHT = 1.8;

    private static final Ability FIRST_ABILITY = new Ability.KeenEye();
    private static final Ability SECOND_ABILITY = new Ability.TangledFeet();
    private static final Ability HIDDEN_ABILITY = new Ability.BigPecks();

    //Base Stats
    private static final int BASE_HEALTH = 40;
    private static final int BASE_ATTACK = 45;
    private static final int BASE_DEFENSE = 40;
    private static final int BASE_SPECIAL_ATTACK = 35;
    private static final int BASE_SPECIAL_DEFENSE = 35;
    private static final int BASE_SPEED = 56;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/pidgey/pidgey.png";
    private static final String BACK_PATH = "battle/backs/pidgey.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/pidgey.png";
    private static final String CRY_PATH = "sounds/cry/016.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/kanto/016.png";

    /**
     * Create a Pidgey
     */
    public Pidgey() {
        super(NUMBER, NAME, Type.NORMAL, Type.FLYING, ExpType.MEDIUM_SLOW,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH, BACK_PATH, MINI_PATH,
                CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, FIRST_ABILITY, SECOND_ABILITY,
                HIDDEN_ABILITY);
    }

    /**
     * Init Pidgey's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        levelUpSkills.put(0, new ArrayList<Integer>(Arrays.asList(SkillFactory.TACKLE)));
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAND_ATTACK)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.GUST)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.QUICK_ATTACK)));
        //TODO: WHIRLWIND 17
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.TWISTER)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEATHER_DANCE)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.AGILITY)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.WING_ATTACK)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROOST)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAILWIND)));
        //TODO: MIRROR MOVE 45
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.AIR_SLASH)));
        levelUpSkills.put(53, new ArrayList<Integer>(Arrays.asList(SkillFactory.HURRICANE)));

    }

    /**
     * Return Pidgeotto if the Pidgey is above level 18.
     * @return Pidgeotto if Pidgey is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 18) {
            return PokemonId.PIDGEOTTO.getValue();
        }
        return -1;
    }
}
