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

public class Genesect extends Pokemon {
    /** Init Variables */

    //Basic (id, name, exp, ev yield, capture rate)
    public static final int NUMBER = 649;
    public static final String NAME = "Genesect";
    public static final String TYPE_OF_POKEMON = "Paleozoic";
    public static final String DESCRIPTION = "This ancient bug Pokémon was altered by Team Plasma." +
            " They upgraded the cannon on its back.";
    public static final double HEIGHT = 1.5;
    public static final int BASE_EXP = 270;
    public static final int[] EV_YIELD = {0, 1, 0, 1, 0, 1};
    public static final int CAPTURE_RATE = 3;
    public static final double WEIGHT = 82.5;

    public static final Ability FIRST_ABILITY = new Ability.Download();
    public static final Ability SECOND_ABILITY = null;
    public static final Ability HIDDEN_ABILITY = null;

    //Base Stats
    public static final int BASE_HEALTH = 71;
    public static final int BASE_ATTACK = 120;
    public static final int BASE_DEFENSE = 95;
    public static final int BASE_SPECIAL_ATTACK = 120;
    public static final int BASE_SPECIAL_DEFENSE = 95;
    public static final int BASE_SPEED = 99;

    //Image Paths
    public static final String ICON_PATH = "pokemonSprites/unova/genesect.png";
    public static final String BACK_PATH = "battle/backs/unova/genesect.png";
    public static final String MINI_PATH = "pokemonMenu/sprites/unova/genesect.png";
    public static final String CRY_PATH = "sounds/cry/649.wav";
    public static final String PROFILE_PATH = "trainercard/pokemon/unova/genesect.png";

    //Typing
    public static final Pokemon.Type TYPE_ONE = Type.BUG;
    public static final Type TYPE_TWO = Type.STEEL;

    //Exp
    public static final ExpType EXP_TYPE = ExpType.SLOW;

    /**
     * Create a genesect
     */
    public Genesect() {
        super(NUMBER, NAME, TYPE_OF_POKEMON, DESCRIPTION, TYPE_ONE, TYPE_TWO, EXP_TYPE,
                BASE_EXP, EV_YIELD, new int[]{BASE_HEALTH, BASE_ATTACK, BASE_DEFENSE,
                        BASE_SPECIAL_ATTACK, BASE_SPECIAL_DEFENSE, BASE_SPEED}, ICON_PATH,
                BACK_PATH, MINI_PATH, CRY_PATH, PROFILE_PATH, CAPTURE_RATE, WEIGHT, HEIGHT, FIRST_ABILITY,
                SECOND_ABILITY, HIDDEN_ABILITY);
    }

    /**
     * Init genesect's level up skills.
     */
    @Override
    protected void initLevelUpSkills() {
        List<Integer> beginnerSkills = new ArrayList<Integer>();
        beginnerSkills.add(SkillFactory.FELL_STINGER);
        //TECHNO BLAST
        beginnerSkills.add(SkillFactory.QUICK_ATTACK);
        //MAGNET RISE
        beginnerSkills.add(SkillFactory.METAL_CLAW);
        beginnerSkills.add(SkillFactory.SCREECH);
        levelUpSkills.put(0, beginnerSkills);
        levelUpSkills.put(7, new ArrayList<Integer>(Arrays.asList(SkillFactory.FURY_CUTTER)));
        levelUpSkills.put(11, new ArrayList<Integer>(Arrays.asList(SkillFactory.LOCK_ON)));
        levelUpSkills.put(18, new ArrayList<Integer>(Arrays.asList(SkillFactory.FLAME_CHARGE)));
        levelUpSkills.put(22, new ArrayList<Integer>(Arrays.asList(SkillFactory.MAGNET_BOMB)));
        levelUpSkills.put(29, new ArrayList<Integer>(Arrays.asList(SkillFactory.SLASH)));
        levelUpSkills.put(33, new ArrayList<Integer>(Arrays.asList(SkillFactory.METAL_SOUND)));
        levelUpSkills.put(40, new ArrayList<Integer>(Arrays.asList(SkillFactory.SIGNAL_BEAM)));
        levelUpSkills.put(44, new ArrayList<Integer>(Arrays.asList(SkillFactory.TRI_ATTACK)));
        levelUpSkills.put(51, new ArrayList<Integer>(Arrays.asList(SkillFactory.X_SCISSOR)));
        levelUpSkills.put(55, new ArrayList<Integer>(Arrays.asList(SkillFactory.BUG_BUZZ)));
        levelUpSkills.put(62, new ArrayList<Integer>(Arrays.asList(SkillFactory.SIMPLE_BEAM)));
        levelUpSkills.put(66, new ArrayList<Integer>(Arrays.asList(SkillFactory.ZAP_CANNON)));
        levelUpSkills.put(73, new ArrayList<Integer>(Arrays.asList(SkillFactory.HYPER_BEAM)));
        levelUpSkills.put(77, new ArrayList<Integer>(Arrays.asList(SkillFactory.SELF_DESTRUCT)));
    }

    @Override
    protected void initTMSkills() {
        tmSkills.add(TmId.TOXIC.getValue());
        tmSkills.add(TmId.HIDDEN_POWER.getValue());
        tmSkills.add(TmId.ICE_BEAM.getValue());
        tmSkills.add(TmId.BLIZZARD.getValue());
        tmSkills.add(TmId.HYPER_BEAM.getValue());
        tmSkills.add(TmId.LIGHT_SCREEN.getValue());
        tmSkills.add(TmId.PROTECT.getValue());
        tmSkills.add(TmId.FRUSTRATION.getValue());
        tmSkills.add(TmId.SOLAR_BEAM.getValue());
        tmSkills.add(TmId.THUNDERBOLT.getValue());
        tmSkills.add(TmId.THUNDER.getValue());
        tmSkills.add(TmId.RETURN.getValue());
        tmSkills.add(TmId.PSYCHIC.getValue());
        tmSkills.add(TmId.DOUBLE_TEAM.getValue());
        tmSkills.add(TmId.REFLECT.getValue());
        tmSkills.add(TmId.FLAMETHROWER.getValue());
        tmSkills.add(TmId.AERIAL_ACE.getValue());
        tmSkills.add(TmId.FACADE.getValue());
        tmSkills.add(TmId.FLAME_CHARGE.getValue());
        tmSkills.add(TmId.REST.getValue());
        tmSkills.add(TmId.ROUND.getValue());
        tmSkills.add(TmId.ENERGY_BALL.getValue());
        tmSkills.add(TmId.CHARGE_BEAM.getValue());
        tmSkills.add(TmId.EXPLOSION.getValue());
        tmSkills.add(TmId.SHADOW_CLAW.getValue());
        tmSkills.add(TmId.GIGA_IMPACT.getValue());
        tmSkills.add(TmId.ROCK_POLISH.getValue());
        tmSkills.add(TmId.THUNDER_WAVE.getValue());
        tmSkills.add(TmId.FLY.getValue());
        tmSkills.add(TmId.X_SCISSOR.getValue());
        tmSkills.add(TmId.INFESTATION.getValue());
        tmSkills.add(TmId.SWAGGER.getValue());
        tmSkills.add(TmId.SLEEP_TALK.getValue());
        tmSkills.add(TmId.U_TURN.getValue());
        tmSkills.add(TmId.SUBSTITUTE.getValue());
        tmSkills.add(TmId.FLASH_CANNON.getValue());
        tmSkills.add(TmId.DARK_PULSE.getValue());
        tmSkills.add(TmId.CONFIDE.getValue());
    }
}
