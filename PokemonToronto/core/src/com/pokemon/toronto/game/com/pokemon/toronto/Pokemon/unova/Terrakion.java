package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.unova;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-08-20.
 */

public class Terrakion extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 639;
    public static final String NAME = "Terrakion";
    public static final String TYPE_OF_POKEMON = "Cavern";
    public static final String DESCRIPTION = "Its charge is strong enough to break through a" +
            " giant castle wall in one blow. This Pokémon is spoken of in legends.";
    public static final double HEIGHT = 1.9;
    public static final int BASE_EXP = 261;
    public static final int[] EV_YIELD = {0, 3, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 3;
    public static final double WEIGHT = 260;

    public static final Ability FIRST_ABILITY = new Ability.Justified();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    public static final int BASE_HEALTH = 91;
    public static final int BASE_ATTACK = 129;
    public static final int BASE_DEFENSE = 90;
    public static final int BASE_SPECIAL_ATTACK = 72;
    public static final int BASE_SPECIAL_DEFENSE = 90;
    public static final int BASE_SPEED = 108;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/terrakion.png";
    public static final String BACK_PATH = "battle/backs/unova/terrakion.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/terrakion.png";
    public static final String CRY_PATH = "sounds/cry/639.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/terrakion.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.ROCK;
    public static final Type TYPE_TWO = Type.FIGHTING;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    /**
     * Create a Terrakion
     */
    public Terrakion() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init terrakion's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.CLOSE_COMBAT);
        beginnerSkills.add(SkillFactory.QUICK_ATTACK);
        beginnerSkills.add(SkillFactory.LEER);
        beginnerSkills.add(SkillFactory.DOUBLE_KICK);
        //SMACK DOWN
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAKE_DOWN)));
        //13 HELPING HAND
        //19 RETALIATE
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_SLIDE)));
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.SACRED_SWORD)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.SWORDS_DANCE)));
        //42 QUICK GUARD
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.WORK_UP)));
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.STONE_EDGE)));
        levelUpSkills.put(61, new ArrayList<Integer>(Arrays.asList(SkillFactory.CLOSE_COMBAT)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.CALM_MIND.getValue());
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.SAFEGUARD.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SMACK_DOWN.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.FOCUS_BLAST.getValue());
        tmSkills.add(TmId.FALSE_SWIPE.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.ROCK_POLISH.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.SWORDS_DANCE.getValue());
        tmSkills.add(TmId.PSYCH_UP.getValue());
        tmSkills.add(TmId.X_SCISSOR.getValue());
        tmSkills.add(TmId.POISON_JAB.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }
}
