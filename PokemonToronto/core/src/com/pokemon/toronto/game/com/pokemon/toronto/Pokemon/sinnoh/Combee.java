package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.sinnoh;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-04-24.
 */

public class Combee extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 415;
    public static final String NAME = "Combee";
    public static final String TYPE_OF_POKEMON = "Tiny Bee";
    public static final String DESCRIPTION = "The trio is together from birth. It constantly" +
            " gathers honey from flowers to please Vespiquen.";
    public static final double HEIGHT = 0.3;
    public static final int BASE_EXP = 49;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    public static final int CAPTURE_RATE = 120;
    public static final double WEIGHT = 5.5;

    public static final Ability FIRST_ABILITY = new Ability.HoneyGather();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.Hustle();

    //Base Stats
    public static final int BASE_HEALTH = 30;
    public static final int BASE_ATTACK = 30;
    public static final int BASE_DEFENSE = 42;
    public static final int BASE_SPECIAL_ATTACK = 30;
    public static final int BASE_SPECIAL_DEFENSE = 42;
    public static final int BASE_SPEED = 70;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/sinnoh/combee.png";
    public static final String BACK_PATH = "battle/backs/sinnoh/combee.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/combee.png";
    public static final String CRY_PATH = "sounds/cry/415.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/combee.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.BUG;
    public static final Type TYPE_TWO = Type.FLYING;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_SLOW;

    /**
     * Create a combee
     */
    public Combee() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init combee's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SWEET_SCENT);
        beginnerSkills.add(SkillFactory.GUST);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUG_BITE)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUG_BUZZ)));
    }

    @Override
    protected void initTMSkills() {

    }

    /**
     * Init combee's gender.
     */
    @Override
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .881) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }

    /**
     * Return Vespiquen if the Combee is above level 21 and female.
     * @return Vespiquen if Combee is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 21 && (gender == 'F' || gender =='f')) {
            return PokemonId.VESPIQUEN.getValue();
        }
        return -1;
    }
}
