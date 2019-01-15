package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.alola;

import com.badlogic.gdx.graphics.Texture;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.TmId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-01-30.
 */

public class Rockruff extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 744;
    public static final String NAME = "Rockruff";
    public static final String TYPE_OF_POKEMON = "Puppy";
    public static final String DESCRIPTION = "It’s considered to be a good Pokémon for beginners" +
            " because of its friendliness, but its disposition grows rougher as it grows up.";
    public static final double HEIGHT = 0.5;
    public static final int BASE_EXP = 56;
    public static final int[] EV_YIELD = {0, 1, 0, 0, 0, 0};
    public static final int CAPTURE_RATE = 190;
    public static final double WEIGHT = 9.2;

    public static final Ability FIRST_ABILITY = new Ability.KeenEye();
    public static final Ability SECOND_ABILITY = new Ability.VitalSpirit();
    public static final Ability HIDDEN_ABILITY = new Ability.Steadfast();

    //Base Stats
    public static final int BASE_HEALTH = 46;
    public static final int BASE_ATTACK = 65;
    public static final int BASE_DEFENSE = 40;
    public static final int BASE_SPECIAL_ATTACK = 30;
    public static final int BASE_SPECIAL_DEFENSE = 40;
    public static final int BASE_SPEED = 60;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/alola/rockruff.png";
    public static final String BACK_PATH = "battle/backs/alola/rockruff.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/alola/rockruff.png";
    public static final String CRY_PATH = "sounds/cry/744.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/alola/rockruff.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.ROCK;
    public static final Type TYPE_TWO = Type.NONE;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a rockruff
     */
    public Rockruff() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init rockruff's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.TACKLE);
        beginnerSkills.add(SkillFactory.LEER);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(4, new ArrayList<Integer>(Arrays.asList(SkillFactory.SAND_ATTACK)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        levelUpSkills.put(12, new ArrayList<Integer>(Arrays.asList(SkillFactory.HOWL)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_THROW)));
        //18 ODOR SLEUTH
        levelUpSkills.put(23, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_TOMB)));
        //26 ROAR
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.STEALTH_ROCK)));
        levelUpSkills.put(34, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_SLIDE)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCARY_FACE)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.CRUNCH)));
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.ROCK_CLIMB)));
        levelUpSkills.put(48, new ArrayList<Integer>(Arrays.asList(SkillFactory.STONE_EDGE)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.ROCK_TOMB.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ECHOED_VOICE.getValue());
        tmSkills.add(TmId.ROCK_POLISH.getValue());
        tmSkills.add(TmId.STONE_EDGE.getValue());
        tmSkills.add(TmId.ROCK_SLIDE.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SNARL.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init rockruff's gender.
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

    /**
     * Return Ribombee if the rockruff is above level 25.
     * @return Ribombee if rockruff is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 25) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            Date date = new Date();
            String text = dateFormat.format(date);
            int hourTime = new Integer(text.substring(11, 13));
            if (hourTime >= 6 && hourTime <= 17) {
                return PokemonId.LYCANROC_DAY.getValue();
            } else { //Night time
                return PokemonId.LYCANROC_NIGHT.getValue();
            }
        }
        return -1;
    }
}
