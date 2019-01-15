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
 * Created by gregorykelsie on 2018-04-25.
 */

public class Stunky extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    private static final int NUMBER = 434;
    private static final String NAME = "Stunky";
    public static final String TYPE_OF_POKEMON = "Skunk";
    public static final String DESCRIPTION = "It sprays a foul fluid from its rear. Its stench " +
            "spreads over a mile radius, driving Pokémon away.";
    public static final double HEIGHT = 0.4;
    private static final int BASE_EXP = 66;
    private static final int[] EV_YIELD = {0, 0, 0, 0, 0, 1};
    private static final int CAPTURE_RATE = 225;
    private static final double WEIGHT = 19.2;

    private static final Ability FIRST_ABILITY = new Ability.Stench();
    private static final Ability SECOND_ABILITY = new Ability.Aftermath();
    private static final Ability HIDDEN_ABILITY = new Ability.KeenEye();

    //Base Stats
    private static final int BASE_HEALTH = 63;
    private static final int BASE_ATTACK = 63;
    private static final int BASE_DEFENSE = 47;
    private static final int BASE_SPECIAL_ATTACK = 41;
    private static final int BASE_SPECIAL_DEFENSE = 41;
    private static final int BASE_SPEED = 74;

    //Image Paths
    private static final String ICON_PATH = "pokemonSprites/sinnoh/stunky.png";
    private static final String BACK_PATH = "battle/backs/sinnoh/stunky.png";
    private static final String MINI_PATH = "pokemonMenu/sprites/sinnoh/stunky.png";
    private static final String CRY_PATH = "sounds/cry/434.wav";
    private static final String PROFILE_PATH = "trainercard/pokemon/sinnoh/stunky.png";

    //Typing
    private static final Pokemon.Type TYPE_ONE = Type.POISON;
    private static final Type TYPE_TWO = Type.DARK;

    //Exp
    private static final ExpType EXP_TYPE = ExpType.MEDIUM_FAST;

    /**
     * Create a stunky
     */
    public Stunky() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init stunky's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.SCRATCH);
        beginnerSkills.add(SkillFactory.FOCUS_ENERGY);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(3, new ArrayList<Integer>(Arrays.asList(SkillFactory.POISON_GAS)));
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.SCREECH)));
        levelUpSkills.put(9, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_SWIPES)));
        levelUpSkills.put(13, new ArrayList<Integer>(Arrays.asList(SkillFactory.SMOKESCREEN)));
        levelUpSkills.put(15, new ArrayList<Integer>(Arrays.asList(SkillFactory.FEINT)));
        levelUpSkills.put(19, new ArrayList<Integer>(Arrays.asList(SkillFactory.ACID_SPRAY)));
        levelUpSkills.put(21, new ArrayList<Integer>(Arrays.asList(SkillFactory.BITE)));
        levelUpSkills.put(25, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLASH)));
        //27 TOXIC
        levelUpSkills.put(31, new ArrayList<Integer>(Arrays.asList(SkillFactory.NIGHT_SLASH)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.MEMENTO)));
        levelUpSkills.put(37, new ArrayList<Integer>(Arrays.asList(SkillFactory.VENOM_DRENCH)));
        levelUpSkills.put(39, new ArrayList<Integer>(Arrays.asList(SkillFactory.SUCKER_PUNCH)));
        //43 BELCH
        levelUpSkills.put(45, new ArrayList<Integer>(Arrays.asList(SkillFactory.EXPLOSION)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.ROAR.getValue());
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.VENOSHOCK.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.SUNNY_DAY.getValue());
        tmSkills.add(TmId.TAUNT.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.RAIN_DANCE.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.SHADOW_BALL.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.FLAMETHROWER.getValue());
        tmSkills.add(TmId.SLUDGE_BOMB.getValue());
        tmSkills.add(TmId.FIRE_BLAST.getValue());
        tmSkills.add(TmId.TORMENT.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ATTRACT.getValue());
        tmSkills.add(TmId.THIEF.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.EXPLOSION.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
        tmSkills.add(TmId.PAYBACK.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.SNARL.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }

    /**
     * Init stunky's gender.
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
     * Return Skuntank if the stunky is above level 34.
     * @return Skuntank if stunky is the right level.
     */
    @Override
    public int getLevelUpEvolutionId() {
        if (level >= 34) {
            return PokemonId.SKUNTANK.getValue();
        }
        return -1;
    }
}
