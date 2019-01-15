package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kalos;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-02-02.
 */

public class Tyrunt extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 696;
    public static final String NAME = "Tyrunt";
    public static final String TYPE_OF_POKEMON = "Royal Heir";
    public static final String DESCRIPTION = "Its immense jaws have enough destructive force " +
            "that it can chew up an automobile. It lived 100 million years ago.";
    public static final double HEIGHT = 0.8;
    public static final int BASE_EXP = 72;
    public static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 45;
    public static final double WEIGHT = 26;

    public static final Ability FIRST_ABILITY = new Ability.StrongJaw();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = new Ability.Sturdy();

    //Base Stats
    public static final int BASE_HEALTH = 58;
    public static final int BASE_ATTACK = 89;
    public static final int BASE_DEFENSE = 77;
    public static final int BASE_SPECIAL_ATTACK = 45;
    public static final int BASE_SPECIAL_DEFENSE = 45;
    public static final int BASE_SPEED = 48;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/kalos/tyrunt.png";
    public static final String BACK_PATH = "battle/backs/kalos/tyrunt.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/kalos/tyrunt.png";
    public static final String CRY_PATH = "sounds/cry/696.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kalos/tyrunt.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.ROCK;
    public static final Type TYPE_TWO = Type.DRAGON;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a tyrunt
     */
    public Tyrunt() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init tyrunt's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.TAIL_WHIP);
        levelUpSkills.put(0, beginnerSkills);
        //6 ROAR
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.STOMP)));
        //12 BIDE
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.STEALTH_ROCK)));
        levelUpSkills.put(17, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        levelUpSkills.put(20, new ArrayList<Integer>(Arrays.asList(SkillFactory.CHARM)));
        levelUpSkills.put(26, new ArrayList<Integer>(Arrays.asList(SkillFactory.ANCIENT_POWER)));
        //30 DRAGON TAIL
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.DRAGON_CLAW)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.THRASH)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.EARTHQUAKE)));
        levelUpSkills.put(49, new ArrayList<Integer>(Arrays.asList(SkillFactory.HORN_DRILL)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.DRAGON_CLAW.getValue());
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.EARTHQUAKE.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.BRICK_BREAK.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.SANDSTORM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ROCK_POLISH.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.BULLDOZE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.DRAGON_TAIL.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init tyrunt's gender.
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
     * Return Tyrantrum if the tyrunt is above level 39.
     * @return Tyrantrum if tyrunt is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 39) {
            return PokemonId.TYRANTRUM.getValue();
        }
        return -1;
    }
}
