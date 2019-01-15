package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.unova;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-05-07.
 */

public class Rufflet extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 627;
    public static final String NAME = "Rufflet";
    public static final String TYPE_OF_POKEMON = "Eaglet";
    public static final String DESCRIPTION = "They crush berries with their talons. They bravely" +
            " stand up to any opponent, no matter how strong it is.";
    public static final double HEIGHT = 0.5;
    public static final int BASE_EXP = 70;
    public static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 190;
    public static final double WEIGHT = 10.5;

    public static final Ability FIRST_ABILITY = new Ability.KeenEye();
    public static final Ability SECOND_ABILITY = new Ability.SheerForce();
    public static final Ability HIDDEN_ABILITY = new Ability.Hustle();

    //Base Stats
    public static final int BASE_HEALTH = 70;
    public static final int BASE_ATTACK = 83;
    public static final int BASE_DEFENSE = 50;
    public static final int BASE_SPECIAL_ATTACK = 37;
    public static final int BASE_SPECIAL_DEFENSE = 50;
    public static final int BASE_SPEED = 60;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/rufflet.png";
    public static final String BACK_PATH = "battle/backs/unova/rufflet.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/rufflet.png";
    public static final String CRY_PATH = "sounds/cry/627.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/rufflet.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.NORMAL;
    public static final Type TYPE_TWO = Type.FLYING;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    /**
     * Create a rufflet
     */
    public Rufflet() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init rufflet's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.PECK);
        beginnerSkills.add(SkillFactory.LEER);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(5, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_ATTACK)));
        levelUpSkills.put(10, new ArrayList<Integer>(Arrays.asList(SkillFactory.WING_ATTACK)));
        levelUpSkills.put(14, new ArrayList<Integer>(Arrays.asList(SkillFactory.HONE_CLAWS)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCARY_FACE)));
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.AERIAL_ACE)));
        levelUpSkills.put(28, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLASH)));
        levelUpSkills.put(32, new ArrayList<Integer>(Arrays.asList(SkillFactory.DEFOG)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.TAILWIND)));
        levelUpSkills.put(41, new ArrayList<Integer>(Arrays.asList(SkillFactory.AIR_SLASH)));
        levelUpSkills.put(46, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUSH_CLAW)));
        levelUpSkills.put(50, new ArrayList<Integer>(Arrays.asList(SkillFactory.SKY_DROP)));
        //55 WHIRLWIND
        levelUpSkills.put(59, new ArrayList<Integer>(Arrays.asList(SkillFactory.BRAVE_BIRD)));
        levelUpSkills.put(64, new ArrayList<Integer>(Arrays.asList(SkillFactory.THRASH)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.BULK_UP.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.ROOST.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.STEEL_WING.getValue());
        tmSkills.add(TmId.SKY_DROP.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
        tmSkills.add(TmId.FLY.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init rufflet's gender.
     */
    @Override
    protected void initGender() {
        gender = 'M';
    }

    /**
     * Return Braviary if the rufflet is above level 54.
     * @return Braviary if rufflet is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 54) {
            return PokemonId.BRAVIARY.getValue();
        }
        return -1;
    }
}
