package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
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
    public static final int NUMBER = 133;
    public static final String NAME = "Eevee";
    public static final String TYPE_OF_POKEMON = "Evolution";
    public static final String DESCRIPTION = "Thanks to its unstable genetic makeup, this" +
            " special Pokémon conceals many different possible evolutions.";

    public static final int BASE_EXP = 54;
    public static final int[] EV_YIELD = {0, 0, 0, 0, 1, 0};
    public static final int CAPTURE_RATE = 55;
    public static final double WEIGHT = 6.5;
    public static final double HEIGHT = 0.3;

    public static final Ability FIRST_ABILITY = new Ability.RunAway();
    public static final Ability SECOND_ABILITY = new Ability.Adaptability();
    public static final Ability HIDDEN_ABILITY = new Ability.Anticipation();

    //Base Stats
    public static final int BASE_HEALTH = 55;
    public static final int BASE_ATTACK = 50;
    public static final int BASE_DEFENSE = 52;
    public static final int BASE_SPECIAL_ATTACK = 45;
    public static final int BASE_SPECIAL_DEFENSE = 65;
    public static final int BASE_SPEED = 55;

    //Typing
    public static final Type TYPE_ONE = Type.NORMAL;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/eevee/eevee.png";
    public static final String BACK_PATH = "battle/backs/eevee.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/eevee.png";
    public static final String CRY_PATH = "sounds/cry/133.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/kanto/133.png";

    /**
     * Create a Eevee
     */
    public Eevee() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
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

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.WORK_UP.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
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

    /**
     * Return Glaceon
     * @return Glaceon
     */
    @Override
    public int getIceStoneEvolutionId() {
        return PokemonId.GLACEON.getValue();
    }

    /**
     * Return LEAFEON
     * @return Leafeon
     */
    @Override
    public int getLeafStoneEvolutionId() {
        return PokemonId.LEAFEON.getValue();
    }

    /**
     * Return Sylveon
     * @return Sylveon
     */
    @Override
    public int getShinyStoneEvolutionId() {
        return PokemonId.SYLVEON.getValue();
    }

}
