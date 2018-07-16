package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.WeatherType;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability.AbilityId;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.AbsorbResult;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Gregory on 6/11/2017.
 */
public abstract class Pokemon {

    /** Instance Variables */

    //Basic
    protected int pokemonId;
    protected String name;
    protected String classification;
    protected String description;

    protected Nature nature;
    protected ExpType expType;

    //Abilities
    protected Ability firstAbility;
    protected Ability secondAbility;
    protected Ability hiddenAbility;
    protected Ability ability;
    protected int abilityPosition;

    protected char gender;
    protected Type typeOne;
    protected Type typeTwo;

    protected double weight;
    protected double battleWeight;

    protected double height;

    //Some moves override the actual types and abilities
    //during battle.
    protected Type battleTypeOne;
    protected Type battleTypeTwo;
    protected Ability battleAbility;

    protected int level;
    protected int captureRate;

    //Stat Numbers
    protected int[] ivs;
    protected int[] evs;
    protected int[] baseStats;
    protected int baseExp;
    protected int[] evYield;

    //Image Paths
    protected String mapIconPath;
    protected String cryPath;
    protected String backPath;
    protected String miniPath;
    protected String profilePath;

    protected HashMap<Integer, List<Integer>> levelUpSkills;
    protected List<Integer> tmSkills;
    protected List<Integer> evolutionSkills;
    protected List<Skill> skills;

    protected Item holdItem;
    //The item checked during battle. It can also change and move around with skills like thief.
    protected Item battleItem;

    //Battle Variables
    protected boolean flinched;
    protected boolean focused;
    protected boolean wrapped;
    protected int wrapTurns;
    protected boolean fainted;
    private HashMap<Type, Double> resistances;

    //Status Variables
    protected Status status;
    protected Status preStatus;

    //Health Variables
    protected int currentHealth;
    protected int animationHealth;

    //Stage Variables
    protected int attackStage;
    protected int defenseStage;
    protected int specialDefenseStage;
    protected int specialAttackStage;
    protected int speedStage;
    protected int accuracyStage;
    protected int evasionStage;

    //Nature Multiplier Variables
    protected double natureAttackMultiplier;
    protected double natureDefenseMultiplier;
    protected double natureSpecialAttackMultiplier;
    protected double natureSpecialDefenseMultiplier;
    protected double natureSpeedMultiplier;

    //Coordaintes
    protected int playerX;
    protected int playerY;
    protected int enemyX;
    protected int enemyY;

    //Exp Variables
    protected long overflownExp;
    protected double currentExp;
    protected int displayedExp;
    protected boolean justLeveled;

    //Battle Variables
    private boolean isTaunted;
    private int tauntTime;

    private boolean isEffectedByEncore;
    private int encoreTime;
    private int encoreSlot;
    private final int TOTAL_ENCORE_TIME = 3;

    private int disabledSlot;
    private int disabledTime;
    private final int TOTAL_DISABLE_TIME = 4;

    private boolean isMagnetRisen;
    private int magnetRisenTime;
    private final int TOTAL_MAGNET_RISE_TIME = 5;

    private boolean isLiftedByTelekinesis;
    private int telekinesisTime;
    private final int TOTAL_TELEKINESIS_TIME = 3;

    private boolean isHealBlocked;
    private int healBlockTime;
    private final int TOTAL_HEAL_BLOCK_TIME = 5;

    private boolean isEffectedByEmbargo;
    private int embargoTime;
    private final int TOTAL_EMBARGO_TIME = 5;

    private boolean justReceivedYawn;
    private boolean fallAsleepDueToYawnThisTurn;

    private boolean heardPerishSong;
    private int perishSongTime;
    private final int TOTAL_PERISH_SONG_TIME = 4;

    private boolean witnessedFutureSight;
    private int futureSightTime;
    private Pokemon futureSightUser;
    private final int TOTAL_FUTURE_SIGHT_TIME = 2;

    private boolean witnessedDoomDesire;
    private int doomDesireTime;
    private final int TOTAL_DOOM_DESIRE_TIME = 2;

    //The amount of damage the Pokemon took this turn. This is used for counter, mirror coat and metal burst.
    private int turnDamageTaken;
    private Skill.SkillCategory damageTakenCategory;
    private boolean tookDamageThisTurn; //For Assurance


    private boolean envelopedInAquaRing;
    private boolean isIngrained;
    private boolean isCursed;

    private boolean binded;
    private int bindedTurns;
    private boolean clamped;
    private int clampTurns;
    private boolean inWhirlpool;
    private int whirlpoolTurns;
    private boolean fireSpin;
    private int fireSpinTurns;
    private boolean infested;
    private int infestationTurns;
    private boolean sandTomb;
    private int sandTombTurns;

    private boolean isLeechSeeded;
    private boolean hasNightmares;
    private boolean receivingWish;
    private int wishTurns;
    private String wishUser;
    private final int TOTAL_WISH_TURNS = 1;

    private int confusionTime;
    private final int NOT_CONFUSED = 0;
    private boolean confused;

    private int sleepTime;

    private int rolloutTurns = 0;

    private Skill outrageSkill;
    private int outrageTurns;

    private int furyCutterStacks;
    private int echoedVoiceStacks;
    private int chargeTurns; //For move Charge

    private boolean powdered;

    private Skill nextTurnSkill;
    private boolean flying; //Fly
    private boolean underground; //Dig
    private boolean underwater; //Dive
    private boolean recharging;
    private boolean skyDrop;
    private boolean spiderWebbed;
    private boolean firstTurn;
    private int laserFocusTurns;
    private int lockOnTurns;
    private boolean usedRage;
    private int stockpileStacks;
    private boolean uproaring;

    /** Constants */

    //Mins and Maxes
    protected final int MAX_LEVEL = 100;
    protected final int MIN_LEVEL = 1;
    protected final int MAX_IV = 31;
    protected final int MIN_IV = 1;
    protected final int MAX_EV = 255;
    protected final int MIN_EV = 0;
    protected final int TOTAL_EV = 510;
    protected final int NO_EXP = 0;
    protected final int INITIAL_STAT_STAGE = 0;

    //
    protected final int HEALTH = 0;
    protected final int ATTACK = 1;
    protected final int SPECIAL_ATTACK = 3;
    protected final int DEFENSE = 2;
    protected final int SPECIAL_DEFENSE = 4;
    protected final int SPEED = 5;

    //Damage Multiplier Constants
    protected final double NORMAL_MULTIPLIER = 1;
    protected final double REDUCED_MULTIPLIER = 0.9;
    protected final double INCREASED_MULTIPLIER = 1.1;

    //Positional Constants
    protected final int PLAYER_NORMAL_X = 122;
    protected final int PLAYER_NORMAL_Y = 1231;
    protected final int FAINTED_PLAYER_Y = 1100;
    protected final int ENEMY_NORMAL_X = 591;
    protected final int ENEMY_NORMAL_Y = 1460;
    protected final int FAINTED_ENEMY_Y = 1300;

    /** Enums */

    /**
     * The exp growth rate for a Pokemon.
     */
    public enum ExpType {
        ERRATIC, FAST, MEDIUM_FAST, MEDIUM_SLOW, SLOW, FLUCTUATING
    }

    /**
     * Pokemon status conditions. (Poison, burn etc)
     * STATUS_FREE is when the Pokemon has no condition.
     */
    public enum Status {
        STATUS_FREE(0), POISON(1), BURN(2), PARALYSIS(3), FROZEN(4), SLEEP(5), RECOVER(6);
        private final int value;
        private Status(int value) {
            this.value = value;
        }
        public static Status fromInt(int i) {
            for (Status n : Status.values()) {
                if (n.getValue() == i) { return n; }
            }
            return null;
        }
        public int getValue() {
            return value;
        }
    }

    /**
     * Pokemon types, Fire, Grass, Water etc.
     * None is also a type when the Pokemon doesn't have a second type.
     */
    public enum Type {
        NONE, BUG, DARK, DRAGON, ELECTRIC, FAIRY, FIGHTING, FIRE, FLYING, GHOST, GRASS, GROUND,
        ICE, NORMAL, POISON, PSYCHIC, ROCK, STEEL, WATER;

        public static String toString(Type t) {
            if (t == NONE) {
                return "None";
            } else if (t == BUG) {
                return "Bug";
            } else if (t == DARK) {
                return "Dark";
            } else if (t == DRAGON) {
                return "Dragon";
            } else if (t == ELECTRIC) {
                return "Electric";
            } else if (t == FAIRY) {
                return "Fairy";
            } else if (t == FIGHTING) {
                return "Fighting";
            } else if (t == FIRE) {
                return "Fire";
            } else if (t == FLYING) {
                return "Flying";
            } else if (t == GHOST) {
                return "Ghost";
            } else if (t == GRASS) {
                return "Grass";
            } else if (t == GROUND) {
                return "Ground";
            } else if (t == ICE) {
                return "Ice";
            } else if (t == NORMAL) {
                return "Normal";
            } else if (t == POISON) {
                return "Poison";
            } else if (t == PSYCHIC) {
                return "Psychic";
            } else if (t == ROCK) {
                return "Rock";
            } else if (t == STEEL) {
                return "Steel";
            } else if (t == WATER) {
                return "Water";
            }
            return "None";
        }

    }

    /**
     * Create a fresh Pokemon given the parameters.
     * Fresh means that there are no current evs
     * @param pokemonId The Pokemon id, 1 is Bulbasaur, 2 is Ivysaur etc.
     * @param name The name of the Pokemon.
     * @param typeOne The Pokemon's type.
     * @param typeTwo The Pokemon's second type, could be NONE
     * @param expType The Pokemon's exp growth type
     * @param baseExp The base exp the Pokemon yields.
     * @param evYield The ev yield for the Pokemon.
     * @param baseStats The Pokemon's base stats.
     * @param mapIconPath The basic Pokemon image path.
     * @param backPath The back of the Pokemon image path.
     * @param miniPath The mini Pokemon image path.
     * @param profilePath The Pokemon's profile path that is displayed on the trainer card.
     * @param captureRate The Pokemon's capture rate.
     * @param weight The Pokemon's weight in KG
     */
    public Pokemon(int pokemonId, String name, Type typeOne, Type typeTwo,
                   ExpType expType, int baseExp, int[] evYield,
                   int[] baseStats, String mapIconPath, String backPath, String miniPath,
                   String cryPath, String profilePath, int captureRate, double weight,
                   Ability firstAbility, Ability secondAbility, Ability hiddenAbility) {

        init(pokemonId, name, typeOne, typeTwo, expType, baseExp,
                evYield, baseStats, mapIconPath, backPath, miniPath, cryPath, captureRate);
        this.weight = weight;
        this.profilePath = profilePath;
        this.firstAbility = firstAbility;
        this.secondAbility = secondAbility;
        this.hiddenAbility = hiddenAbility;
    }

    /**
     * Create a fresh Pokemon given the parameters.
     * Fresh means that there are no current evs
     * @param pokemonId The Pokemon id, 1 is Bulbasaur, 2 is Ivysaur etc.
     * @param name The name of the Pokemon.
     * @param typeOne The Pokemon's type.
     * @param typeTwo The Pokemon's second type, could be NONE
     * @param expType The Pokemon's exp growth type
     * @param baseExp The base exp the Pokemon yields.
     * @param evYield The ev yield for the Pokemon.
     * @param baseStats The Pokemon's base stats.
     * @param mapIconPath The basic Pokemon image path.
     * @param backPath The back of the Pokemon image path.
     * @param miniPath The mini Pokemon image path.
     * @param profilePath The Pokemon's profile path that is displayed on the trainer card.
     * @param captureRate The Pokemon's capture rate.
     * @param weight The Pokemon's weight in KG
     */
    public Pokemon(int pokemonId, String name, String classification, String description, Type typeOne, Type typeTwo,
                   ExpType expType, int baseExp, int[] evYield,
                   int[] baseStats, String mapIconPath, String backPath, String miniPath,
                   String cryPath, String profilePath, int captureRate, double weight, double height,
                   Ability firstAbility, Ability secondAbility, Ability hiddenAbility) {

        init(pokemonId, name, typeOne, typeTwo, expType, baseExp,
                evYield, baseStats, mapIconPath, backPath, miniPath, cryPath, captureRate);
        this.classification = classification;
        this.description = description;
        this.weight = weight;
        this.height = height;
        this.profilePath = profilePath;
        this.firstAbility = firstAbility;
        this.secondAbility = secondAbility;
        this.hiddenAbility = hiddenAbility;
    }


    private void init(int pokemonId, String name, Type typeOne, Type typeTwo,
                      ExpType expType, int baseExp, int[] evYield, int[] baseStats,
                      String mapIconPath, String backPath, String miniPath, String cryPath,
                      int captureRate) {
        this.pokemonId = pokemonId;
        this.name = name;
        this.baseStats = baseStats;
        this.baseExp = baseExp;
        this.evYield = evYield;
        this.expType = expType;
        this.mapIconPath = mapIconPath;
        this.backPath = backPath;
        this.miniPath = miniPath;
        this.cryPath = cryPath;
        this.typeOne = typeOne;
        this.typeTwo = typeTwo;
        battleTypeOne = typeOne;
        battleTypeTwo = typeTwo;
        this.captureRate = captureRate;
        this.fainted = false;
        status = Status.STATUS_FREE;
        preStatus = Status.STATUS_FREE;
        currentExp = NO_EXP;
        displayedExp = NO_EXP;
        levelUpSkills = new HashMap<Integer, List<Integer>>();
        tmSkills = new ArrayList<Integer>();
        evolutionSkills = new ArrayList<Integer>();
        skills = new ArrayList<Skill>();
        justLeveled = false;
        resetCoordinates();
        initializeResistances();
    }

    /**
     * Initialize the Pokemon's battle variables.
     * - Stages
     * - Health
     * - Animation Health
     * - Nature multipliers
     */
    private void initBattleVariables() {
        resetBattleVariables();
        sleepTime = 0;
        flinched = false;
    }

    /**
     * Reset the battle variables for the Pokemon.
     * Stages, Confusion etc. Basically the elements that
     * get reset when the Pokemon returns to their ball.
     */
    public void resetBattleVariables() {
        resetStages();
        //TODO: Create temporary ability for worry seed, mummy etc
        isTaunted = false;
        isEffectedByEmbargo = false;
        isEffectedByEncore = false;
        isHealBlocked = false;
        justReceivedYawn = false;
        fallAsleepDueToYawnThisTurn = false;
        isMagnetRisen = false;
        isLiftedByTelekinesis = false;
        heardPerishSong = false;
        witnessedFutureSight = false;
        witnessedDoomDesire = false;
        envelopedInAquaRing = false;
        isIngrained = false;
        isCursed = false;
        isLeechSeeded = false;
        hasNightmares = false;
        removeWish();

        //Trap Effects
        binded = false;
        bindedTurns = 0;
        clamped = false;
        clampTurns = 0;
        inWhirlpool = false;
        whirlpoolTurns = 0;
        fireSpin = false;
        fireSpinTurns = 0;
        infested = false;
        infestationTurns = 0;
        sandTomb = false;
        sandTombTurns = 0;

        tauntTime = -1;
        embargoTime = -1;
        encoreTime = -1;
        encoreSlot = -1;
        healBlockTime = -1;
        telekinesisTime = -1;
        magnetRisenTime = -1;
        futureSightTime = -1;
        futureSightUser = null;
        doomDesireTime = -1;
        disabledSlot = -1;
        disabledTime = -1;
        perishSongTime = -1;
        confusionTime = NOT_CONFUSED;
        confused = false;
        focused = false;
        outrageTurns = 0;
        outrageSkill = null;
        nextTurnSkill = null;
        flying = false; //Fly
        underground = false; //Dig
        underwater = false; //Dive
        skyDrop = false;
        recharging = false;
        rolloutTurns = 0;
        furyCutterStacks = 0;
        echoedVoiceStacks = 0;
        powdered = false;
        turnDamageTaken = 0;
        tookDamageThisTurn = false;
        spiderWebbed = false;
        chargeTurns = 0;
        laserFocusTurns = 0;
        lockOnTurns = 0;
        stockpileStacks = 0;
        firstTurn = true;
        damageTakenCategory = Skill.SkillCategory.MISC;
        usedRage = false;
        uproaring = false;

        //Reset the battle types and resistances if they were changed.
        if (battleTypeOne != typeOne || battleTypeTwo != typeTwo) {
            battleTypeOne = typeOne;
            battleTypeTwo = typeTwo;
            initializeResistances();
        }
        battleAbility = ability;
        battleWeight = weight;
    }

    /**
     * Reset the variables that only reset when the battle is over.
     * Ex: Mimikyu's disguise.
     */
    public void resetEndBattleVariables() {

    }

    /**
     * Change the Pokemon to blade form, only aegislash currently will use this method.
     */
    public void changeToBladeForm() {

    }

    /**
     * Change the Pokemon to shield form, only aegislash currently will use this method.
     */
    public void changeToShieldForm() {

    }

    public boolean isInBladeForm() {
        return false;
    }

    public boolean isInShieldForm() {
        return false;
    }

    /**
     * Return the battle weight of the Pokemon in KG
     * @return The weight of the Pokemon in KG
     */
    public double getBattleWeight() {
        return battleWeight;
    }

    /**
     * Insert data into the Pokemon class. Usually from a DB or from a pre-evolved Pokemon.
     * @param level The Pokemon's level.
     * @param gender The Pokemon's gender.
     * @param ivs The Pokemon's array of IVs
     * @param evs The Pokemon's array of EVs
     * @param firstSkill The Pokemon's first skill
     * @param secondSkill The Pokemon's second skill
     * @param thirdSkill The Pokemon's third skill
     * @param fourthSkill The Pokemon's fourth skill
     * @param currentHealth The Pokemon's current health
     * @param currentExp The Pokemon's current exp
     * @param status The Pokemon's status (Burn, Paralyzed normal etc)
     * @param nature The Pokemon's nature.
     * @param abilityPosition The Pokemon's ability position
     */
    public void insertData(int level, char gender, int[] ivs, int [] evs, Skill firstSkill,
                           Skill secondSkill, Skill thirdSkill, Skill fourthSkill, int currentHealth, int currentExp,
                           Pokemon.Status status, Nature nature, int abilityPosition) {
        this.level = level;
        this.gender = gender;
        this.ivs = ivs;
        this.evs = evs;
        this.currentHealth = currentHealth;
        this.currentExp = currentExp;
        this.status = status;
        this.nature = nature;
        this.abilityPosition = abilityPosition;
        if (abilityPosition == 1 && secondAbility != null) {
            this.ability = secondAbility;
        } else if (abilityPosition == 2 && hiddenAbility != null) {
            this.ability = hiddenAbility;
        } else {
            this.ability = firstAbility;
        }
        this.battleAbility = ability;
        setHealthAndExp(currentHealth, currentExp);
        addSkills(firstSkill, secondSkill, thirdSkill, fourthSkill);
        initNatureMultipliers();
        initLevelUpSkills();
        initTMSkills();
        initBattleVariables();
    }

    public void insertWildData(int level, int wildType) {
        //wildType 0 = Default 1 = Route Pokemon (low ivs) 2 = Map Pokemon (hidden ability chance)
        this.level = level;
        initRandomIVs(wildType);
        initBlankEVs();
        initGender();
        if (wildType == 2) {
            initMapPokemonAbility();
        } else {
            initAbility();
        }
        setRandomNature();
        initLevelUpSkills();
        initTMSkills();
        initWildSkills();
        currentHealth = getHealthStat();
        animationHealth = currentHealth;
        initNatureMultipliers();
        initializeHoldItem();

        initBattleVariables();
    }

    protected void initializeHoldItem() {
        //No hold item is default.
    }

    /**
     * Set a new battle weight for the Pokemon. Moves like Autotomize change this.
     * @param newWeight The new weight for the Pokemon.
     */
    public void setBattleWeight(double newWeight) {
        battleWeight = newWeight;
    }

    /**
     * Return what ability the Pokemon has. The first ability = 0, The second ability = 1, or
     * the hidden ability = 2
     * @return The ability position.
     */
    public int getAbilityPosition() {
        return abilityPosition;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public int getFuryCutterStacks() {
        return furyCutterStacks;
    }

    public int getEchoedVoiceStacks() { return echoedVoiceStacks; }

    /**
     * Return whether or not the Pokemon is powered up by the move Charge.
     * @return Whether or not the Pokemon is powered up by the move Charge.
     */
    public boolean isCharged() {
        if (chargeTurns > 0) {
            return true;
        }
        return false;
    }

    /**
     * Start uproar, prevents sleep for all Pokemon on the field.
     */
    public void uproar() {
        uproaring = true;
    }

    /**
     * Stop the uproar.
     */
    public void stopUproar() {
        uproaring = false;
    }

    /**
     * Return whether or not the Pokemon is Uproaring.
     * @return Whether or not the Pokemon is Uproaring.
     */
    public boolean isUproaring() {
        return uproaring;
    }
    /**
     * Return whether or not the Pokemon just used the move Rage.
     * @return Whether or not the Pokemon just used the move Rage.
     */
    public boolean usedRage() {
        return usedRage;
    }


    /**
     * Set that the Pokemon just used the move Rage.
     */
    public void useRage() {
        usedRage = true;
    }

    /**
     * Remove the Rage effect from the move Rage from the Pokemon
     */
    public void removeRage() {
        usedRage = false;
    }

    /**
     * Adjust the Pokemon's Charge from the move charge if they have the Charge.
     */
    public void adjustCharge() {
        if (chargeTurns > 0) {
            chargeTurns--;
        }
    }

    /**
     * Apply Charge effect to the Pokemon.
     */
    public void applyCharge() {
        chargeTurns = 2; //Two turns, one for charge, one for the next move.
    }

    /**
     * Return whether or not this will be/is the first turn the Pokemon is on the Field.
     * @return Whether or not this will be/is the first turn the Pokemon is on the Field.
     */
    public boolean isFirstTurn() {
        return firstTurn;
    }

    /**
     * Return whether or not the Pokemon has a crit available for their next attack.
     * @return Whether or not the Pokemon will crit their next attack.
     */
    public boolean hasCrit() {
        if (laserFocusTurns > 0) {
            return true;
        }
        return false;
    }

    /**
     * Set the amount of turns laser focus is active. 2 because laser focus uses the first turn
     * and the second turn is the crit turn.
     */
    public void useLaserFocus() {
        laserFocusTurns = 2;
    }

    /**
     * Adjust the Laser Focus effect duration.
     */
    public void adjustLaserFocus() {
        if (laserFocusTurns > 0) {
            laserFocusTurns--;
        }
    }

    public boolean isLockedOn() {
        if (lockOnTurns > 0) {
            return true;
        }
        return false;
    }

    public void lockOn() {
        lockOnTurns = 2;
    }

    public void removeLockOn() {
        lockOnTurns = 0;
    }

    public void adjustLockOn() {
        if (lockOnTurns > 0) {
            lockOnTurns--;
        }
    }

    /**
     * Set whether or not this is this first turn the Pokemon is on the Field.
     * @param firstTurn Whether or not this is the first turn the Pokemon is on the Field.
     */
    public void setFirstTurn(boolean firstTurn) {
        this.firstTurn = firstTurn;
    }

    public void setFuryCutterStacks(int stacks) {
        furyCutterStacks = Math.min(3, stacks);
    }

    public void setEchoedVoiceStacks(int stacks) {
        echoedVoiceStacks = Math.min(4, stacks);
    }

    public void receiveTransferrableBattleVariables(Pokemon transferPokemon) {
        if (transferPokemon.isReceivingWish()) {
            wishTurns = transferPokemon.getWishTurns();
            wishUser = transferPokemon.getWishUser();
            receivingWish = true;
        }
        if (transferPokemon.witnessedFutureSight()) {
            futureSightTime = transferPokemon.getFutureSightTime();
            witnessedFutureSight = true;
            futureSightUser = transferPokemon.getFutureSightUser();
        } else if (transferPokemon.witnessedDoomDesire()) {
            doomDesireTime = transferPokemon.getDoomDesireTime();
            witnessedDoomDesire = true;
            futureSightUser = transferPokemon.getFutureSightUser();
        }

    }

    public void setTurnDamageTaken(int damageAmount, Skill.SkillCategory damageCategory) {
        this.turnDamageTaken = damageAmount;
        this.damageTakenCategory = damageCategory;
        tookDamageThisTurn = true;
    }

    public boolean tookPhysicalDamageThisTurn() {
        if (turnDamageTaken > 0 && damageTakenCategory == Skill.SkillCategory.PHYSICAL) {
            return true;
        }
        return false;
    }

    public boolean tookSpecialDamageThisTurn() {
        if (turnDamageTaken > 0 && damageTakenCategory == Skill.SkillCategory.SPECIAL) {
            return true;
        }
        return false;
    }

    public boolean tookEnemyDamageThisTurn() {
        if (turnDamageTaken > 0) {
            return true;
        }
        return false;
    }

    public boolean tookDamageThisTurn() {
        return tookDamageThisTurn;
    }

    public void takeDamageThisTurn() {
        tookDamageThisTurn = true;
    }

    public int getDamageTakenThisTurn() {
        return turnDamageTaken;
    }

    /**
     * Apply the move Powder to the Pokemon.
     */
    public void applyPowder() {
        powdered = true;
    }
    /**
     * Return whether or not this Pokemon is affected by the move
     * Powder.
     * @return
     */
    public boolean isPowdered() {
        return powdered;
    }

    /**
     * Remove the Powder effect from the Pokemon.
     */
    public void removePowder() {
        powdered = false;
    }

    /**
     * Remove all of the Stockpile stacks.
     */
    public void removeStockpileStacks() {
        stockpileStacks = 0;
    }

    /**
     * Add a Stockpile stack. Maxes out at 3.
     */
    public void stockpile() {
        stockpileStacks++;
        stockpileStacks = Math.min(stockpileStacks, 3);
    }

    /**
     * Return whether or not the Pokemon has any Stockpile stacks.
     * @return Whether or not the Pokemon has any Stockpile stacks.
     */
    public boolean hasStockpileStacks() {
        if (stockpileStacks > 0) {
            return true;
        }
        return false;
    }

    /**
     * Return the number of stockpile stacks the Pokemon has.
     * @return
     */
    public int getStockpileStacks() {
        return stockpileStacks;
    }

    public void resetDamageTakenThisTurn() {
        turnDamageTaken = 0;
        damageTakenCategory = Skill.SkillCategory.MISC;
    }

    /**
     * Set the Pokemon to be sky dropped for the next turn.
     */
    public void setSkyDrop() {
        skyDrop = true;
    }

    /**
     * Remove the Pokemon from being sky dropped the next turn.
     */
    public void removeSkyDrop() {
        skyDrop = false;
    }

    /**
     * Return whether or not the Pokemon is in the air after being
     * hit by Sky Drop.
     * @return Whether or not the Pokemon is in the air after being
     * hit by Sky Drop.
     */
    public boolean isSkyDropped() {
        return skyDrop;
    }


    /**
     * Return the number of rollout turns left.
     * 0 if there Pokemon hasn't started rolling out yet.
     * @return The number of rollout turns left.
     */
    public int getRolloutTurns() {
        return rolloutTurns;
    }

    /**
     * Cancel the Pokemon from Rolling out if it is
     * using rollout.
     */
    public void cancelRollout() {
        if (rolloutTurns > 0) {
            nextTurnSkill = null;
            rolloutTurns = 0;
        }
    }

    /**
     * Add a turn to the rollout chain.
     */
    public void addRolloutTurn() {
        rolloutTurns++;
    }

    /**
     * Cancel the effects that get cancelled when the
     * Pokemon misses their target. Ex: Rollout.
     */
    public void cancelMissSkills(Pokemon target) {
        cancelRollout();
        furyCutterStacks = 0;
        nextTurnSkill = null;
        flying = false;
        underground = false;
        underwater = false;
        target.removeSkyDrop();
    }

    /**
     * Cancel the effects that get cancelled when the
     * Pokemon flinches. Ex: Rollout
     */
    public void cancelFlinchSkills() {
        cancelRollout();
    }

    /**
     * Start using rollout.
     * @param rollout The rollout skill that will be used on the next
     *                turn.
     */
    public void startRollout(Skill rollout) {
        rolloutTurns = 1;
        nextTurnSkill = rollout;
    }
    /**
     * Return whether or not the Pokemon is Binded by
     * the move Bind.
     * @return
     */
    public boolean isBinded() {
        return binded;
    }


    /**
     * Return whether or not the Pokemon is in a Whirlpool.
     * @return Whether or not the Pokemon is in the Whirlpool
     * vortex.
     */
    public boolean inWhirlpool() { return inWhirlpool; }

    /**
     * Return whether or not the Pokemon is in a Fire Spin.
     * @return Whether or not the Pokemon is trapped in Fire
     * Spin.
     */
    public boolean inFireSpin() { return fireSpin; }


    /**
     * Return whether or not the Pokemon is infested by Infestation
     * @return Whether or not the Pokemon is infested by
     * the move Infestation.
     */
    public boolean isInfested() { return infested; }


    /**
     * Return whether or not the Pokemon is trapped in Sand Tomb.
     * @return Whether or not the Pokemon is trapped in Sand Tomb.
     */
    public boolean inSandTomb() { return sandTomb; }


    /**
     * Return whether or not the Pokemon is Clamped by the move Clamp.
     * @return Whether or not the Pokemon is Clamped.
     */
    public boolean isClamped() {
        return clamped;
    }

    /**
     * Return whether or not the Pokemon is wrapped.
     * @return Whether or not the Pokemon is wrapped.
     */
    public boolean isWrapped() { return wrapped; }

    /**
     * Bind the Pokemon with the skill effect from the move
     * Bind.
     */
    public void bind() {
        binded = true;
        if (Math.random() < .5) {
            bindedTurns = 4;
        } else {
            bindedTurns = 5;
        }
    }

    public void whirlpool() {
        inWhirlpool = true;
        if (Math.random() < .5) {
            whirlpoolTurns = 4;
        } else {
            whirlpoolTurns = 5;
        }
    }

    /**
     * Clamp the Pokemon with the skill effect from the move
     * Clamp.
     */
    public void clamp() {
        clamped = true;
        double rand = Math.random();
        if (rand < .375) {
            clampTurns = 2;
        } else if (rand <= .75) {
            clampTurns = 3;
        } else if (rand <= .875) {
            clampTurns = 4;
        } else {
            clampTurns = 5;
        }
    }

    /**
     * Trap the Pokemon in Fire Spin.
     */
    public void trapInFireSpin() {
        fireSpin = true;
        if (Math.random() < .5) {
            fireSpinTurns = 4;
        } else {
            fireSpinTurns = 5;
        }
    }

    /**
     * Trap the Pokemon in Infestation
     */
    public void trapInInfestation() {
        infested = true;
        if (Math.random() < .5) {
            infestationTurns = 4;
        } else {
            infestationTurns = 5;
        }
    }

    /**
     * Trap the Pokemon in Sand Tomb.
     */
    public void trapInSandTomb() {
        sandTomb = true;
        if (Math.random() < .5) {
            sandTombTurns = 4;
        } else {
            sandTombTurns = 5;
        }
    }

    /**
     * Trap the Pokemon in Wrap.
     */
    public void wrap() {
        wrapped = true;
        if (Math.random() < .5) {
            wrapTurns = 4;
        } else {
            wrapTurns = 5;
        }
    }

    /**
     * Remove the clamp effect from the Pokemon.
     */
    public void removeClamp() {
        clamped = false;
    }

    /**
     * Remove the Bind effect from the Pokemon.
     */
    public void removeBind() {
        binded = false;
    }


    /**
     * Remove Whirlpool effect.
     */
    public void removeWhirlpool() { inWhirlpool = false; }

    /**
     * Remove the Pokemon from Fire Spin.
     */
    public void removeFireSpin() {
        fireSpin = false;
    }

    /**
     * Remove the Pokemon from Infestation.
      */
    public void removeInfestation() {
        infested = false;
    }

    /**
     * Remove the Pokemon from Sand Tomb.
     */
    public void removeSandTomb() {
        sandTomb = false;
    }

    /**
     * Remove the Pokemon from Wrap.
     */
    public void removeWrap() { wrapped = false; }

    /**
     * Remove all Bind effects from the Pokemon. (Bind, Wrap, Fire Spin etc)
     */
    public void freeFromBinds() {
        binded = false;
        bindedTurns = 0;
        clamped = false;
        clampTurns = 0;
        inWhirlpool = false;
        whirlpoolTurns = 0;
        fireSpin = false;
        fireSpinTurns = 0;
        infested = false;
        infestationTurns = 0;
        sandTomb = false;
        sandTombTurns = 0;
        wrapped = false;
        wrapTurns = 0;
    }

    /**
     * Return the number of turns left until Bind expires.
     * @return The number of turns left until Bind expires.
     */
    public int getBindTurns() {
        return bindedTurns;
    }

    /**
     * Return the number of turns left until Clamp expires.
     * @return The number of turns left until Clamp expires.
     */
    public int getClampTurns() { return clampTurns; }

    /**
     * Return the number of turns left until Whirlpool expires.
     * @return The number of turns left until Whirlpool expires.
     */
    public int getWhirlpoolTurns() { return whirlpoolTurns; }

    /**
     * Return the number of turns left until Fire Spin expires.
     * @return The number of turns left until Fire Spin expires.
     */
    public int getFireSpinTurns() { return fireSpinTurns; }

    /**
     * Return the number of turns left until Infestation expires.
     * @return The number of turns left until Infestation expires.
     */
    public int getInfestationTurns() { return infestationTurns; }

    /**
     * Return the number of turns left until Sand Tomb expires.
     * @return The number of turns left until Sand Tomb expires.
     */
    public int getSandTombTurns() { return sandTombTurns; }

    /**
     * Return the number of turns left until Wrap expires.
     * @return The number of turns left until Wrap expires.
     */
    public int getWrapTurns() { return wrapTurns; }

    /**
     * Adjust the number of Clamp turns left.
     */
    public void adjustClampTurns() {
        clampTurns--;
    }

    /**
     * Adjust the number of Bind turns left.
     */
    public void adjustBindTurns() {
        bindedTurns--;
    }

    /**
     * Adjust the number of Whirlpool turns left.
     */
    public void adjustWhirlpoolTurns() { whirlpoolTurns--; }

    /**
     * Adjust the number of Fire Spin turns left.
     */
    public void adjustFireSpinTurns() { fireSpinTurns--; }

    /**
     * Adjust the number of Infestation turns left.
     */
    public void adjustInfestationTurns() { infestationTurns--; }

    /**
     * Adjust the number of Sand Tomb turns left.
     */
    public void adjustSandTombTurns() {
        sandTombTurns--;
    }

    /**
     * Adjust the number of Wrap turns left.
     */
    public void adjustWrapTurns() { wrapTurns--; }

    /**
     * Return whether or not this Pokemon will receive
     * wish.
     * @return Whether or not this Pokemon will receive Wish.
     */
    public boolean isReceivingWish() {
        return receivingWish;
    }

    /**
     * The number of turns until Wish effects the Pokemon.
     * @return The number of turns until Wish effects the
     * Pokemon.
     */
    public int getWishTurns() {
        return wishTurns;
    }

    /**
     * Adjust the number of turns left until Wish is
     * activated.
     */
    public void adjustWishTurns() {
        wishTurns--;
        wishTurns = Math.max(0, wishTurns);
    }

    /**
     * Remove the Wish effect from the Pokemon.
     */
    public void removeWish() {
        receivingWish = false;
        wishTurns = -1;
        wishUser = "";
    }

    /**
     * Return the name of the Pokemon who used Wish.
     * @return The name of the Pokemon who used Wish;
     */
    public String getWishUser() {
        return wishUser;
    }

    /**
     * Use the Wish effect on the Pokemon.
     * - They will receive the heal after a turn.
     */
    public void receiveWish(String wishUser) {
        receivingWish = true;
        wishTurns = TOTAL_WISH_TURNS;
        this.wishUser = wishUser;
    }

    /**
     * Return whether or not the Pokemon has flinched.
     * @return Whether or not the Pokemon flinched.
     */
    public boolean hasFlinched() {
        return flinched;
    }

    /**
     * Make the Pokemon flinch.
     */
    public void flinch() {
        flinched = true;
    }

    /**
     * Remove the flinch status from the Pokemon.
     */
    public void removeFlinch() {
        flinched = false;
    }

    /**
     * Get taunted and set the time the Pokemon is taunted
     * to the maximum taunt time.
     */
    public void receiveTaunt() {
        isTaunted = true;
        tauntTime = 3;
    }

    /**
     * Return whether or not the Pokemon is taunted.
     * @return Whether or not the Pokemon is taunted.
     */
    public boolean isTaunted() {
        return isTaunted;
    }

    /**
     * Receive the Embargo status.
     */
    public void receiveEmbargo() {
        isEffectedByEmbargo = true;
        embargoTime = TOTAL_EMBARGO_TIME;
    }

    /**
     * Return whether or not the Pokemon is effected by
     * the Embargo move.
     * @return Whether or not the Pokemon is effected by
     * the Embargo move.
     */
    public boolean isEffectedByEmbargo() {
        return isEffectedByEmbargo;
    }

    /**
     * Make the skill at the index slot get encored.
     * @param slot The move slot that gets encored.
     */
    public void receiveEncore(int slot) {
        isEffectedByEncore = true;
        encoreSlot = slot;
        encoreTime = TOTAL_ENCORE_TIME;
    }

    /**
     * Return whether or not the Pokemon is encored.
     * @return Whether or not the Pokemon is encored.
     */
    public boolean isEncored() {
        return isEffectedByEncore;
    }

    /**
     * Return which move slot is encored. -1 if the
     * Pokemon is not effected by encore.
     * @return Which move slot is encored. -1 if the
     * Pokemon is not encored.
     */
    public int getEncoredSlot() {
        return encoreSlot;
    }

    /**
     * Use the Heal Block effect on the Pokemon.
     */
    public void receiveHealBlock() {
        isHealBlocked = true;
        healBlockTime = TOTAL_HEAL_BLOCK_TIME;
    }

    /**
     * Return whether or not the Pokemon is heal blocked.
     * @return Whether or not the Pokemon is heal blocked.
     */
    public boolean isHealBlocked() {
        return isHealBlocked;
    }

    /**
     * Lift the Pokemon by the Telekinesis effect.
     */
    public void receiveTelekinesis() {
        isLiftedByTelekinesis = true;
        telekinesisTime = TOTAL_TELEKINESIS_TIME;
    }

    /**
     * Return whether or not the Pokemon is effected by
     * the Telekinesis move.
     * @return Whether or not the Pokemon is effected by
     * the Telekinesis move.
     */
    public boolean isLiftedByTelekinesis() {
        return isLiftedByTelekinesis;
    }

    /**
     * Use the Magnet Rise move effect on the Pokemon.
     */
    public void receiveMagnetRise() {
        isMagnetRisen = true;
        magnetRisenTime = TOTAL_MAGNET_RISE_TIME;
    }

    /**
     * Return whether or not the Pokemon is effected by
     * Magnet Rise.
     * @return Whether or not the Pokemon is effected by
     * Magnet Rise.
     */
    public boolean isMagnetRisen() {
        return isMagnetRisen;
    }

    /**
     * Get the Yawn effect.
     */
    public void receiveYawn() {
        justReceivedYawn = true;
        fallAsleepDueToYawnThisTurn = false;
    }

    /**
     * Return whether or not the Pokemon is effected by Yawn.
     * @return Whether or not the Pokemon is effected by Yawn.
     */
    public boolean isYawned() {
        return (justReceivedYawn || fallAsleepDueToYawnThisTurn);
    }

    /**
     * Return whether or not the Pokemon just received the yawn effect.
     * @return Whether or not the Pokemon just received the yawn effect.
     */
    public boolean justReceivedYawn() {
        return justReceivedYawn;
    }

    /**
     * Change the yawn variables so that when the next turn ends, the Pokemon will fall asleep.
     */
    public void passFirstYawnTurn() {
        justReceivedYawn = false;
        fallAsleepDueToYawnThisTurn = true;
    }

    /**
     * Use Nightmare on the Pokemon.
     */
    public void receiveNightmare() {
        hasNightmares = true;
    }

    /**
     * Remove Nightmares from the Pokemon.
     */
    public void removeNightmare() { hasNightmares = false; }

    /**
     * Return whether or not the Pokemon is effected by
     * Nightmare.
     * @return Whether or not the Pokemon is effected by
     * Nightmare.
     */
    public boolean hasNightmares() {
        return hasNightmares;
    }


    /**
     * Give the Pokemon the Curse effect.
     */
    public void giveCurse() {
        isCursed = true;
    }

    /**
     * Return whether or not the Pokemon is affected by Curse.
     * @return Whether or not the Pokemon is affected by Curse.
     */
    public boolean isCursed() {
        return isCursed;
    }

    /**
     * Remove curse from the Pokemon.
     */
    public void removeCurse() {
        isCursed = false;
    }

    /**
     * Use the Ingrain move on the Pokemon.
     */
    public void receiveIngrain() {
        isIngrained = true;
    }

    /**
     * Return whether or not the Pokemon is ingrained.
     * @return Whether or not the Pokemon is ingrained.
     */
    public boolean isIngrained() {
        return isIngrained;
    }

    /**
     * Apply the Spider Web to the Pokemon.
     */
    public void applySpiderWeb() {
        spiderWebbed = true;
    }

    /**
     * Return whether or not the Pokemon is trapped in
     * Spider Web.
     * @return
     */
    public boolean isSpiderWebbed() {
        return spiderWebbed;
    }

    /**
     * Remove the Spider Web effect from the Pokemon.
     */
    public void removeSpiderWeb() {
        spiderWebbed = false;
    }

    /**
     * Let the Pokemon get leech seeded.
     */
    public void receiveLeechSeed() {
        isLeechSeeded = true;
    }

    /**
     * Return whether or not the Pokemon is effected
     * by Leech Seed.
     * @return Whether or not the Pokemon is effected by
     * Leech Seed.
     */
    public boolean isSeeded() {
        return isLeechSeeded;
    }

    /**
     * Remove Leech Seed from the Pokemon.
     */
    public void removeLeechSeed() {
        isLeechSeeded = false;
    }

    /**
     * Envelop the Pokemon in Aqua Ring.
     */
    public void receiveAquaRing() {
        envelopedInAquaRing = true;
    }

    /**
     * Return whether or not the Pokemon has Aqua Ring
     * activated.
     * @return Whether or not the Pokemon has Aqua Ring
     * activated.
     */
    public boolean isEnvelopedInAquaRing() {
        return envelopedInAquaRing;
    }

    /**
     * Set the Pokemon to receive Future Sight damage after
     * a few turns.
     */
    public void receiveFutureSight(Pokemon skillUser) {
        witnessedFutureSight = true;
        futureSightTime = TOTAL_FUTURE_SIGHT_TIME;
        futureSightUser = skillUser;
    }

    /**
     * Return the Pokemon who casted Future Sight on this one.
     * @return The Pokemon who casted Future Sight on this Pokemon.
     */
    public Pokemon getFutureSightUser() {
        return futureSightUser;
    }

    /**
     * Return the number of turns left until future sight hits.
     * @return The number of turns left until future sight hits.
     */
    public int getFutureSightTime() {
        return futureSightTime;
    }

    /**
     * Adjust the number of turns left until future sight
     * hits.
     */
    public void adjustFutureSightTime() {
        futureSightTime--;
        futureSightTime = Math.max(0, futureSightTime);
    }

    public void removeFutureSight() {
        witnessedFutureSight = false;
        futureSightUser = null;
        futureSightTime = -1;
    }

    /**
     * Return whether or not the Pokemon has been hit by
     * Future Sight and hasn't received the damage yet.
     * @return Whether or not the Pokemon has been hit by
     * Future Sight and hasn't received the damage yet.
     */
    public boolean witnessedFutureSight() {
        return witnessedFutureSight;
    }

    /**
     * Adjust the number of turns left until Doom Desire
     * hits.
     */
    public void adjustDoomDesireTime() {
        doomDesireTime--;
        doomDesireTime = Math.max(0, doomDesireTime);
    }

    /**
     * Return the number of turns left until Doom Desire hits.
     * @return The number of turns left until Doom Desire hits.
     */
    public int getDoomDesireTime() {
        return doomDesireTime;
    }

    /**
     * Set the Pokemon to receive Doom Desire damage after
     * a few turns.
     */
    public void receiveDoomDesire(Pokemon skillUser) {
        witnessedDoomDesire = true;
        doomDesireTime = TOTAL_DOOM_DESIRE_TIME;
        futureSightUser = skillUser;
    }

    public void removeDoomDesire() {
        witnessedDoomDesire = false;
        futureSightUser = null;
        doomDesireTime = -1;
    }

    /**
     * Return whether or not the Pokemon has been hit by
     * Doom Desire and hasn't received the damage yet.
     * @return Whether or not the Pokemon has been hit by
     * Doom Desire  and hasn't received the damage yet.
     */
    public boolean witnessedDoomDesire() {
        return witnessedDoomDesire;
    }

    /**
     * Set the move slot that gets disabled.
     * @param slot The move at index slot that gets disabled.
     */
    public void receiveDisable(int slot) {
        disabledSlot = slot;
        disabledTime = TOTAL_DISABLE_TIME;
    }

    /**
     * Return whether or not the first move is disabled.
     * @return Whether or not the first move is diabled.
     */
    public boolean isFirstMoveDisabled() {
        if (disabledSlot == 0) {
            return true;
        }
        return false;
    }

    /**
     * Return whether or not the second move is disabled.
     * @return Whether or not the second move is diabled.
     */
    public boolean isSecondMoveDisabled() {
        if (disabledSlot == 1) {
            return true;
        }
        return false;
    }

    /**
     * Return whether or not the third move is disabled.
     * @return Whether or not the third move is diabled.
     */
    public boolean isThirdMoveDisabled() {
        if (disabledSlot == 2) {
            return true;
        }
        return false;
    }

    /**
     * Return whether or not the fourth move is disabled.
     * @return Whether or not the fourth move is diabled.
     */
    public boolean isFourthMoveDisabled() {
        if (disabledSlot == 3) {
            return true;
        }
        return false;
    }

    /**
     * Let the Pokemon hear Perish Song.
     */
    public void receivePerishSong() {
        heardPerishSong = true;
        perishSongTime = TOTAL_PERISH_SONG_TIME;
    }

    /**
     * Return whether or not the Pokemon heard Perish Song.
     * @return Whether or not the Pokemon heard Perish Song.
     */
    public boolean heardPerishSong() {
        return heardPerishSong;
    }

    public int getPerishSongTime() {
        return perishSongTime;
    }

    public void adjustPerishSongDuration() {
        perishSongTime--;
    }

    public void removePerishSong() {
        perishSongTime = -1;
        heardPerishSong = false;
    }


    /**
     * Put the Pokemon to sleep and give it a random sleep time.
     */
    public void induceSleep() {
        preStatus = Status.SLEEP;
        double rand = Math.random();
        if (rand <= .33) {
            sleepTime = 2;
        } else if (rand <= .67) {
            sleepTime = 3;
        } else {
            sleepTime = 4;
        }
    }

    /**
     * Put the Pokemon to sleep for 2 turns.
     */
    public void induceRestSleep() {
        preStatus = Status.SLEEP;
        sleepTime = 2; //Sleep for rest is always 2 turns.
    }

    /**
     * Reduce the amount of turns the Pokemon is asleep for by
     * 1 turn.
     */
    public void reduceSleepTime() {
        sleepTime--;
        sleepTime = Math.max(sleepTime, 0);
    }

    /**
     * Return the amount of turns the Pokemon is asleep for.
     * @return The amount of turns the Pokemon is asleep for.
     */
    public int getSleepTime() {
        return sleepTime;
    }

    /**
     * Remove the Sleep status from the Pokemon and reset the sleepTime.
     */
    public void wakeUp() {
        sleepTime = 0;
        status = Status.STATUS_FREE;
        //Reset yawn
        justReceivedYawn = false;
        fallAsleepDueToYawnThisTurn = false;
    }
    
    /**
     * Apply confusion to the Pokemon that will last 1-4 attacking turns.
     */
    public void induceConfusion() {
        double rand = Math.random();
        if (rand <= .25) {
            confusionTime = 1;
        } else if (rand <= .5) {
            confusionTime = 2;
        } else if (rand <= .75) {
            confusionTime = 3;
        } else {
            confusionTime = 4;
        }
        confused = true;
    }

    /**
     * Reduce the confusion time by 1 turn.
     */
    public void reduceConfusionTime() {
        confusionTime--;
        confusionTime = Math.max(confusionTime, NOT_CONFUSED);
    }

    /**
     * Return how many turns of confusion are left.
     * @return Number of confusion turns left.
     */
    public int getConfusionTime() {
        return confusionTime;
    }

    /**
     * Remove confusion from the Pokemon.
     */
    public void removeConfusion() {
        confusionTime = 0;
        confused = false;
    }

    /**
     * Return whether or not the Pokemon is confused.
     * @return Whether or not the Pokemon is confused.
     */
    public boolean isConfused() {
        return confused;
    }

    /**
     * Return whether or not the Pokemon is outraging.
     * Ex: When they are locked into Thrash, Petal Dance, Outrage etc.
     * @return Whether or not the Pokemon is outraging.
     */
    public boolean isOutraging() {
        if (outrageTurns == 0) {
            return false;
        }
        return true;
    }

    /**
     * Set the outrage skill for the Pokemon.
     * When the Pokemon first uses Outrage/Thrash this is called.
     * @param outrageSkill The skill they are outraging with.
     * @param outrageTurns The time left for the outrage.
     */
    public void activateOutrage(Skill outrageSkill, int outrageTurns) {
        this.outrageSkill = outrageSkill;
        this.outrageTurns = outrageTurns;
    }

    /**
     * Reduce the amount of time the Pokemon is outraging for
     * by 1 turn.
     */
    public void reduceOutrageTime() {
        outrageTurns--;
    }

    /**
     * Return the amount of turns left for the outrage.
     * @return The amount of turns left for the outrage.
     */
    public int getOutrageTime() {
        return outrageTurns;
    }

    /**
     * Return the outrage skill, otherwise return null.
     * @return The outraging skill.
     */
    public Skill getOutrageSkill() {
        return outrageSkill;
    }

    /**
     * Remove the outrage skill from the Pokemon.
     * (They are no longer stuck in it!)
     */
    public void removeOutrageSkill() {
        outrageSkill = null;
    }

    /**
     * Return the skill that will be used next turn.
     * Ex: When fly is first used the next turn skill is fly.
     * @return The skill that will be used in the next turn.
     */
    public Skill getNextTurnSkill() {
        return nextTurnSkill;
    }

    /**
     * Return whether or not the Pokemon has a skill ready for
     * the next turn.
     * Ex: Fly, Dig, Sky Attack etc.
     * @return Whether or not the Pokemon has a skill ready for
     * the next turn.
     */
    public boolean hasNextTurnSkill() {
        if (nextTurnSkill != null) {
            return true;
        }
        return false;
    }

    /**
     * Remove the next turn skill.
     */
    public void removeNextTurnSkill() {
        nextTurnSkill = null;
    }

    /**
     * Set the next turn skill to the argument.
     * @param nextTurnSkill The new next turn skill.
     */
    public void setNextTurnSkill(Skill nextTurnSkill) {
        this.nextTurnSkill = nextTurnSkill;
    }

    /**
     * Return whether or not the Pokemon is in the air after using
     * Fly.
     * @return Whether or not the Pokemon is in the air flying.
     */
    public boolean isFlying() {
        return flying;
    }

    /**
     * Return whether or not the Pokemon is underground after
     * using Dig.
     * @return Whether or not the Pokemon is underground.
     */
    public boolean isUnderground() {
        return underground;
    }

    /**
     * Return whether or not the Pokemon is underwater after using
     * Dive.
     * @return Whether or not the Pokemon is underwater.
     */
    public boolean isUnderwater() {
        return underwater;
    }

    /**
     * Finish using the Dive skill by removing the next turn skill
     * and come up from underwater.
     */
    public void finishDive() {
        setNextTurnSkill(null);
        underwater = false;
    }

    /**
     * Finish using Fly or Bounce by removing the next turn skill and come down.
     */
    public void flyDown() {
        setNextTurnSkill(null);
        flying = false;
    }

    /**
     * Finish using Dig by removing the next turn skill and come up.
     */
    public void finishDig() {
        setNextTurnSkill(null);
        underground = false;
    }

    /**
     * Use fly or bounce
     */
    public void fly() {
        flying = true;
    }

    /**
     * Use dig.
     */
    public void dig() { underground = true; }

    public boolean isSemiInvulnerable() {
        if (underwater || underground || flying) {
            return true;
        }
        return false;
    }

    /**
     * Return whether or not the Pokemon is recharging after using
     * a Hyper Beam or similar move.
     * @return
     */
    public boolean isRecharging() {
        return recharging;
    }

    /**
     * Initiate recharging after using a Hyper Beam.
     */
    public void initiateRecharge() {
        recharging = true;
    }

    /**
     * Recharge the Pokemon from recharging after a Hyper Beam or
     * similar move.
     */
    public void recharge() {
        recharging = false;
    }

    /**
     * Make the Pokemon go underwater using Dive's effect.
     */
    public void dive() {
        underwater = true;
    }


    /**
     * Reset the coordaintes of the Pokemon, both enemy and
     * player positions to their original spots.
     */
    private void resetCoordinates() {
        this.playerX = PLAYER_NORMAL_X;
        this.playerY = PLAYER_NORMAL_Y;
        this.enemyX = ENEMY_NORMAL_X;
        this.enemyY = ENEMY_NORMAL_Y;
    }

    public boolean canLearnTM(int tmId) {
        for (int i = 0; i < tmSkills.size(); i++) {
            if (tmId == tmSkills.get(i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Init the Pokemon's level up skills.
     */
    protected abstract void initLevelUpSkills();

    /**
     * Init the Pokemon's TM skills
     */
    protected void initTMSkills() {
    }

    /**
     * Init the Pokemon's evolution skills.
     */
    protected void initEvolutionSkills() {
    }

    /**
     * Init the Pokemon's gender.
     */
    protected void initGender() {
        double genderProbability = Math.random();
        if (genderProbability <= .5) {
            gender = 'M';
        } else {
            gender = 'F';
        }
    }

    /**
     * Init the Pokemon's ability.
     */
    private void initAbility() {
        if (secondAbility != null) {
            double rand = Math.random();
            if (rand < .5) {
                ability = firstAbility;
                abilityPosition = 0;
            } else {
                ability = secondAbility;
                abilityPosition = 1;
            }
        } else {
            ability = firstAbility;
            abilityPosition = 0;
        }
        battleAbility = ability;
    }

    private void initMapPokemonAbility() {
        double rand = Math.random();
        if (hiddenAbility != null && secondAbility != null) {
            if (rand <= .33) {
                ability = firstAbility;
                abilityPosition = 0;
            } else if (rand <= .66) {
                ability = secondAbility;
                abilityPosition = 1;
            } else {
                ability = hiddenAbility;
                abilityPosition = 2;
            }
        } else if (hiddenAbility != null) {
            if (rand <= .66) {
                ability = firstAbility;
                abilityPosition = 0;
            } else {
                ability = hiddenAbility;
                abilityPosition = 2;
            }
        } else {
            ability = firstAbility;
            abilityPosition = 0;
        }
        battleAbility = ability;
    }



    /**
     * Return the Pokemon's gender.
     * @return The Pokemon's gender char.
     */
    public char getGender() {
        return gender;
    }

    /**
     * Add evs to the Pokemon based on the enemyEvYield
     * @param enemyEvYield The enemy's evYield that gets added
     *                     to the Pokemons ev pool.
     */
    public void addEvs(int[] enemyEvYield) {
        int availableEvs = TOTAL_EV - getTotalEvs();
        for (int i = 0; i < evs.length; i++) {
            if (!hasMaxEvs() && availableEvs > 0) {
                //Make sure the ev count is under the maximum evs
                if (evs[i] < MAX_EV) {
                    //Check if the yield is more than what's available to the total evs
                    if (enemyEvYield[i] > availableEvs) {
                        //Check if the yield is more than what's available to the current ev
                        if (evs[i] + enemyEvYield[i] > MAX_EV) {
                            //Determine the number of evs to reach the maximum
                            int toMax = MAX_EV - evs[i];
                            if (toMax < availableEvs) {
                                //Cap off the ev to the max
                                availableEvs -= toMax;
                                evs[i] += toMax;
                            } else {
                                //Just add the available evs left to the stat.
                                availableEvs = 0;
                                evs[i] = Math.min(MAX_EV, evs[i] + availableEvs);
                            }
                        } else {
                            //The stat won't get maxed so just add the remaining evs to the stat
                            evs[i] = Math.min(MAX_EV, evs[i] + availableEvs);
                            availableEvs = 0;
                        }

                    } else {
                        //Add ev yield to the pokemon.
                        if (evs[i] + enemyEvYield[i] > MAX_EV) {
                            availableEvs -= (MAX_EV - evs[i]);
                            evs[i] = MAX_EV;
                        } else {
                            evs[i] += enemyEvYield[i];
                            availableEvs -= enemyEvYield[i];
                        }

                    }
                }
            }
        }

    }

    /**
     * Return the Pokemon's EV yield.
     * @return The evYield for the Pokemon as an integer array.
     */
    public int[] getEvYield() {
        return evYield;
    }


    /**
     * Return whether or not the Pokemon has the total amount of
     * possible EVs (510)
     * @return Whether or not the Pokemon has the total amount of
     * possible EVs.
     */
    public boolean hasMaxEvs() {
        int sum = getTotalEvs();
        if (sum == TOTAL_EV) {
            return true;
        }
        return false;
    }

    /**
     * Return the total amount of EVs the Pokemon has.
     * @return The total amount of EVs the Pokemon has.
     */
    public int getTotalEvs() {
        return evs[0] + evs[1] + evs[2] +
                evs[3] + evs[4] + evs[5];
    }


    /**
     * Return the amount of exp this Pokemon gives based on the number
     * of participants in the battle.
     * @param numberOfBattleParticipants The number of participants in the
     *                                   battle.
     * @param a Whether or not the battle was a trainer battle or not. (1 for wild 1.5 for trainer)
     * @return The amount of exp the Pokemon will give.
     */
    public long calculateExp(int numberOfBattleParticipants, double a) {
        int b = getBaseExp();
        double e = 1; //1.5 if holding lucky egg
        int l = getLevel();
        int t = 1; //1.5 if the pokemon was traded.
        int s = 1; //The number of pokemon who participated in the party

        long exp = Math.round((a * b * e * l * t) / (7 * s));
        Gdx.app.log("Experience: ", "" + exp);
        return exp;
    }

    /**
     * Add exp to the Pokemon
     * @param amt The amount of exp to be added.
     */
    public void addExp(double amt) {
        currentExp += amt;
    }

    /**
     * Set the amount of exp to amt.
     * @param amt The amount of exp getting set to the currentExp
     */
    public void setExp(int amt) {
        currentExp = amt;
        displayedExp = amt;
    }

    /**
     * The the amount of current health and current exp to the specified
     * values.
     * @param newHealth The new amount of current health.
     * @param newExp The new amount of current exp.
     */
    protected void setHealthAndExp(int newHealth, int newExp) {
        currentHealth = newHealth;
        animationHealth = newHealth;
        if (currentHealth == 0) {
            fainted = true;
        }
        currentExp = newExp;
        displayedExp = newExp;
    }

    /**
     * Level up the Pokemon. Can't exceed the max level of 100.
     */
    public void levelUp() {

        level = Math.min(100, level + 1);
        currentExp = 0;
        justLeveled = true;
    }

    /**
     * Return whether or not the Pokemon just leveled up in a
     * battle.
     * @return Whether or not the Pokemon just leveled up in a battle.
     */
    public boolean hasJustLeveled() {
        return justLeveled;
    }

    /**
     * Set the Pokemon to have not just leveled up. This is called
     * after a battle ends and the Pokemon finished evolving or does
     * not evolve at that time.
     */
    public void resetJustLeveled() {
        justLeveled = false;
    }

    /**
     * Return the amount of exp the Pokemon has.
     * @return The amount of exp the Pokemon has.
     */
    public double getDisplayedExp() {
        return currentExp;
    }

    /**
     * Return whether or not the Pokemon has a disguise active. Should only work
     * for Mimikyu.
     * @return Whether or not the Pokemon has a disguise active.
     */
    public boolean hasDisguise() {
        return false;
    }

    public void removeDisguise() { }


    /**
     * Initialize the moves the wild version of this Pokemon would have.
     */
    protected void initWildSkills() {
        int currentSkill = 0;
        SkillFactory skillFactory = new SkillFactory();
        for (int i = 0; i <= level; i++) {
            //Check if the Pokemon learns a move at the level i
            if (levelUpSkills.containsKey(i)) {
                for (int j = 0; j < levelUpSkills.get(i).size(); j++) {
                    if (!hasSkill(levelUpSkills.get(i).get(j))) {
                        if (skills.size() > currentSkill) {
                            skills.set(currentSkill, skillFactory.createSkill(levelUpSkills.get(i).get(j)));
                        } else {
                            skills.add(skillFactory.createSkill(levelUpSkills.get(i).get(j)));
                        }
                        currentSkill++;
                    }
                    if (currentSkill == 4) {
                        //Start adding moves from the oldest to the newest since the
                        //move list is full.
                        currentSkill = 0;
                    }
                }
            }
        }
    }

    /**
     * Return whether or not the Pokemon has the skill with
     * skill id.
     * @param skillId The skill id that's being searched for in the Pokemon's
     *                moveset.
     * @return Whether or not the Pokemon has the skill with
     * skill id.
     */
    public boolean hasSkill(int skillId) {
        for (int i = 0; i < skills.size(); i++) {
            if (skills.get(i).getId() == skillId) {
                return true;
            }
        }
        return false;
    }

    /**
     * Add the specified skills in the arguments to the Pokemon's skillset.
     * @param firstSkill The skill to be added in the first slot.
     * @param secondSkill The skill to be added in the second slot.
     * @param thirdSkill The skill to be added in the third slot.
     * @param fourthSkill The skill to be added in the fourth slot.
     */
    protected void addSkills(Skill firstSkill, Skill secondSkill, Skill thirdSkill,
                             Skill fourthSkill) {
        skills.clear();
        skills.add(firstSkill);
        if (secondSkill != null) {
            skills.add(secondSkill);
            if (thirdSkill != null) {
                skills.add(thirdSkill);
                if (fourthSkill != null) {
                    skills.add(fourthSkill);
                }
            }
        }
    }

    public void addSkill(Skill s) {
        if (skills.size() < 4) {
            skills.add(s);
        }
    }

    /**
     * Empty the current skillset for the Pokemon.
     */
    public void clearSkills() {
        skills.clear();
    }

    /**
     * Return the hash map of level up skills. (level to list of learnable skills at that
     * level.
     * @return The HashMap of level up skills (Level to List of Learnable skills at that
     * level)
     */
    public HashMap<Integer, List<Integer>> getLevelUpSkills() {
        return levelUpSkills;
    }


    /**
     * Return the level up skills at the Pokemon's current level. Null if there
     * are no level up skills at the current level.
     * @return The level up skills at the Pokemon's current level.
     */
    public List<Integer> getCurrentLevelUpSkills() {
        if (levelUpSkills.containsKey(level)) {
            return levelUpSkills.get(level);
        }
        return null;
    }

    /**
     * Return the evolution skills this Pokemon learns when
     * a preevolution evolves into this Pokemon.
     * @return A List of Skill id's that represent the evolution
     * skills this Pokemon learns when a preevolution evolves
     * into this Pokemon.
     */
    public List<Integer> getEvolutionSkills() {
        return evolutionSkills;
    }

    /**
     * Return whether or not the Pokemon learns a move when a
     * preevolution evolves into this Pokemon.
     * @return Whether or not the Pokemon learns a new move when
     * their preevolution evolves into it.
     */
    public boolean hasEvolutionSkills() {
        if (evolutionSkills.size() > 0) {
            return true;
        }
        return false;
    }

    /**
     * Add a new move to the list of skills if there is space available.
     * @param newMove The move to be added.
     */
    public void addMove(Skill newMove) {
        if (skills.size() < 4) {
            skills.add(newMove);
        }
    }

    /**
     * Set all of the battle stages to default.
     * - Attack, Sp. Atk, ... Speed.
     */
    public void resetStages() {
        attackStage = INITIAL_STAT_STAGE;
        specialAttackStage = INITIAL_STAT_STAGE;
        defenseStage = INITIAL_STAT_STAGE;
        specialDefenseStage = INITIAL_STAT_STAGE;
        speedStage = INITIAL_STAT_STAGE;
        accuracyStage = INITIAL_STAT_STAGE;
        evasionStage = INITIAL_STAT_STAGE;
    }


    /**
     * Decrease the attack stage by amount stages.
     * The stage can't go below -6
     * @param amount The amount of stages to decrease
     */
    public void decreaseAttackStage(int amount) {
        attackStage -= amount;
        attackStage = Math.max(attackStage, -6);
    }

    /**
     * Decrease the defense stage by amount stages.
     * The stage can't go below -6
     * @param amount The amount of stages to decrease
     */
    public void decreaseDefenseStage(int amount) {
        defenseStage -= amount;
        defenseStage = Math.max(defenseStage, -6);
    }

    /**
     * Decrease the special attack stage by amount stages.
     * The stage can't go below -6
     * @param amount The amount of stages to decrease
     */
    public void decreaseSpAttackStage(int amount) {
        specialAttackStage -= amount;
        specialAttackStage = Math.max(specialAttackStage, -6);
    }

    /**
     * Decrease the special defense stage by amount stages.
     * The stage can't go below -6
     * @param amount The amount of stages to decrease
     */
    public void decreaseSpDefenseStage(int amount) {
        specialDefenseStage -= amount;
        specialDefenseStage = Math.max(specialDefenseStage, -6);
    }

    /**
     * Decrease the speed stage by amount stages.
     * The stage can't go below -6
     * @param amount The amount of stages to decrease
     */
    public void decreaseSpeedStage(int amount) {
        speedStage -= amount;
        speedStage = Math.max(speedStage, -6);
    }

    /**
     * Decrease the accuracy stage by amount stages.
     * The stage can't go below -6
     * @param amount The amount of stages to decrease
     */
    public void decreaseAccuracyStage(int amount) {
        accuracyStage -= amount;
        accuracyStage = Math.max(accuracyStage, -6);
    }

    /**
     * Decrease the evasion stage by amount stages.
     * The stage can't go below -6
     * @param amount The amount of stages to decrease
     */
    public void decreaseEvasionStage(int amount) {
        evasionStage -= amount;
        evasionStage = Math.max(evasionStage, -6);
    }

    /**
     * Return whether or not the Pokemon's defense can be lowered
     * due to their ability.
     * @return Whether or not the Pokemon's defense can be lowered
     * due to their ability.
     */
    public boolean isProtectedByDefenseLoweringEffects() {
        if (ability.getId() == AbilityId.BIG_PECKS) {
            return true;
        }
        return false;
    }

    /**
     * Return whether or not the Pokemon is holding an item.
     * @return Whether or not the Pokemon is holding an item.
     */
    public boolean isHoldingItem() {
        if (holdItem != null) {
            return true;
        }
        return false;
    }

    public boolean isHoldingBattleItem() {
        if (battleItem != null) {
            return true;
        }
        return false;
    }

    public void giveItem(Item newItem) {
        holdItem = newItem;
    }

    /**
     * Return whether or not the Pokemon's accuracy can be lowered
     * due to their ability.
     * @return Whether or not the Pokemon's accuracy can be lowered
     * due to their ability.
     */
    public boolean isProtectedByAccuracyLoweringEffects() {
        if (ability.getId() == AbilityId.KEEN_EYE) {
            return true;
        }
        return false;
    }

    /**
     * Increase the attack stage by amount stages.
     * The stage can't go above 6
     * @param amount The amount of stages to increase.
     */
    public void increaseAttackStage(int amount) {
        attackStage += amount;
        attackStage = Math.min(attackStage, 6);
    }

    /**
     * Increase the defense stage by amount stages.
     * The stage can't go above 6
     * @param amount The amount of stages to increase.
     */
    public void increaseDefenseStage(int amount) {
        defenseStage += amount;
        defenseStage = Math.min(defenseStage, 6);
    }

    /**
     * Increase the special attack stage by amount stages.
     * The stage can't go above 6
     * @param amount The amount of stages to increase.
     */
    public void increaseSpAttackStage(int amount) {
        specialAttackStage += amount;
        specialAttackStage = Math.min(specialAttackStage, 6);
    }

    /**
     * Increase the special defense stage by amount stages.
     * The stage can't go above 6
     * @param amount The amount of stages to increase.
     */
    public void increaseSpDefenseStage(int amount) {
        specialDefenseStage += amount;
        specialDefenseStage = Math.min(specialDefenseStage, 6);
    }

    /**
     * Increase the speed stage by amount stages.
     * The stage can't go above 6
     * @param amount The amount of stages to increase.
     */
    public void increaseSpeedStage(int amount) {
        speedStage += amount;
        speedStage = Math.min(speedStage, 6);
    }

    /**
     * Increase the accuracy stage by amount stages.
     * The stage can't go above 6
     * @param amount The amount of stages to increase.
     */
    public void increaseAccuracyStage(int amount) {
        accuracyStage += amount;
        accuracyStage = Math.min(accuracyStage, 6);
    }

    /**
     * Increase the evasion stage by amount stages.
     * The stage can't go above 6
     * @param amount The amount of stages to increase.
     */
    public void increaseEvasionStage(int amount) {
        evasionStage += amount;
        evasionStage = Math.min(evasionStage, 6);
    }

    /**
     * Set the attack stage by amount stages.
     * The stage can't go above 6
     * @param amount The new stage amount
     */
    public void setAttackStage(int amount) {
        attackStage = amount;
        if (amount < 0) {
            attackStage = Math.max(-6, attackStage);
        } else {
            attackStage = Math.min(6, attackStage);
        }
    }

    /**
     * Set the defense stage by amount stages.
     * The stage can't go above 6 or below -6
     * @param amount The new stage amount
     */
    public void setDefenseStage(int amount) {
        defenseStage = amount;
        if (amount < 0) {
            defenseStage = Math.max(-6, defenseStage);
        } else {
            defenseStage = Math.min(6, defenseStage);
        }
    }

    /**
     * Set the special attack stage by amount stages.
     * The stage can't go above 6 or below -6
     * @param amount The new stage amount
     */
    public void setSpAttackStage(int amount) {
        specialAttackStage = amount;
        if (amount < 0) {
            specialAttackStage = Math.max(-6, specialAttackStage);
        } else {
            specialAttackStage = Math.min(6, specialAttackStage);
        }
    }

    /**
     * Set the special defense stage by amount stages.
     * The stage can't go above 6 or below -6
     * @param amount The new stage amount
     */
    public void setSpDefenseStage(int amount) {
        specialDefenseStage = amount;
        if (amount < 0) {
            specialDefenseStage = Math.max(-6, specialDefenseStage);
        } else {
            specialDefenseStage = Math.min(6, specialDefenseStage);
        }
    }

    /**
     * Set the speed stage by amount stages.
     * The stage can't go above 6 or below -6
     * @param amount The new stage amount
     */
    public void setSpeedStage(int amount) {
        speedStage = amount;
        if (amount < 0) {
            speedStage = Math.max(-6, speedStage);
        } else {
            speedStage = Math.min(6, speedStage);
        }
    }

    /**
     * Set the accuracy stage by amount stages.
     * The stage can't go above 6 or below -6
     * @param amount The new stage amount
     */
    public void setAccuracyStage(int amount) {
        accuracyStage = amount;
        if (amount < 0) {
            accuracyStage = Math.max(-6, accuracyStage);
        } else {
            accuracyStage = Math.min(6, accuracyStage);
        }
    }

    /**
     * Set the evasion stage by amount stages.
     * The stage can't go above 6 or below -6
     * @param amount The new stage amount
     */
    public void setEvasionStage(int amount) {
        evasionStage = amount;
        if (amount < 0) {
            evasionStage = Math.max(-6, evasionStage);
        } else {
            evasionStage = Math.min(6, evasionStage);
        }
    }


    /**
     * Initialize the Nature multipliers
     */
    private void initNatureMultipliers() {
        natureAttackMultiplier = NORMAL_MULTIPLIER;
        natureDefenseMultiplier = NORMAL_MULTIPLIER;
        natureSpecialAttackMultiplier = NORMAL_MULTIPLIER;
        natureSpecialDefenseMultiplier = NORMAL_MULTIPLIER;
        natureSpeedMultiplier = NORMAL_MULTIPLIER;
        //Attack Bonus
        if(nature  == com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature.LONELY) { natureAttackMultiplier = INCREASED_MULTIPLIER;
            natureDefenseMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature.ADAMANT) { natureAttackMultiplier = INCREASED_MULTIPLIER;
            natureSpecialAttackMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature.NAUGHTY) { natureAttackMultiplier = INCREASED_MULTIPLIER;
            natureSpecialDefenseMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature.BRAVE) { natureAttackMultiplier = INCREASED_MULTIPLIER;
            natureSpeedMultiplier = REDUCED_MULTIPLIER; }
        //Defense Bonus
        else if(nature  == com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature.BOLD) { natureDefenseMultiplier = INCREASED_MULTIPLIER;
            natureAttackMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature.IMPISH) { natureDefenseMultiplier = INCREASED_MULTIPLIER;
            natureSpecialAttackMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature.LAX) { natureDefenseMultiplier = INCREASED_MULTIPLIER;
            natureSpecialDefenseMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature.RELAXED) { natureDefenseMultiplier = INCREASED_MULTIPLIER;
            natureSpeedMultiplier = REDUCED_MULTIPLIER; }
        //Sp Attack Bonus
        else if(nature  == com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature.MODEST) { natureSpecialAttackMultiplier = INCREASED_MULTIPLIER;
            natureAttackMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature.MILD) { natureSpecialAttackMultiplier = INCREASED_MULTIPLIER;
            natureDefenseMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature.RASH) { natureSpecialAttackMultiplier = INCREASED_MULTIPLIER;
            natureSpecialDefenseMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature.QUIET) { natureSpecialAttackMultiplier = INCREASED_MULTIPLIER;
            natureSpeedMultiplier = REDUCED_MULTIPLIER; }
        //Sp Defense Bonus
        else if(nature  == com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature.CALM) { natureSpecialDefenseMultiplier = INCREASED_MULTIPLIER;
            natureAttackMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature.GENTLE) { natureSpecialDefenseMultiplier = INCREASED_MULTIPLIER;
            natureDefenseMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature.CAREFUL) { natureSpecialDefenseMultiplier = INCREASED_MULTIPLIER;
            natureSpecialAttackMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature.SASSY) { natureSpecialDefenseMultiplier = INCREASED_MULTIPLIER;
            natureSpeedMultiplier = REDUCED_MULTIPLIER; }
        //Speed Bonus
        else if(nature  == com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature.TIMID) { natureSpeedMultiplier = INCREASED_MULTIPLIER;
            natureAttackMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature.HASTY) { natureSpeedMultiplier = INCREASED_MULTIPLIER;
            natureDefenseMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature.JOLLY) { natureSpeedMultiplier = INCREASED_MULTIPLIER;
            natureSpecialAttackMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature.NAIVE) { natureSpeedMultiplier = INCREASED_MULTIPLIER;
            natureSpecialDefenseMultiplier = REDUCED_MULTIPLIER; }
    }

    /**
     * Create random IVs for the Pokemon
     */
    private void initRandomIVs(int wildType) {
        ivs = new int[6];
        ivs[HEALTH] = createRandomIV(wildType);
        ivs[ATTACK] = createRandomIV(wildType);
        ivs[SPECIAL_ATTACK] = createRandomIV(wildType);
        ivs[DEFENSE] = createRandomIV(wildType);
        ivs[SPECIAL_DEFENSE] = createRandomIV(wildType);
        ivs[SPEED] = createRandomIV(wildType);
    }


    /**
     * Return the Pokemon's Health IV
     * @return Health IV
     */
    public int getHealthIV() {
        return ivs[HEALTH];
    }

    /**
     * Return the Pokemon's Attack IV
     * @return Attack IV
     */
    public int getAttackIV() {
        return ivs[ATTACK];
    }

    /**
     * Return the Pokemon's Defense IV
     * @return Defense IV
     */
    public int getDefenseIV() {
        return ivs[DEFENSE];
    }

    /**
     * Return the Pokemon's Special Attack IV
     * @return Special Attack IV
     */
    public int getSpAttackIV() {
        return ivs[SPECIAL_ATTACK];
    }

    /**
     * Return the Pokemon's Special Defense IV
     * @return Special Defense IV
     */
    public int getSpDefenseIV() {
        return ivs[SPECIAL_DEFENSE];
    }

    /**
     * Return the Pokemon's Speed IV
     * @return Speed IV
     */
    public int getSpeedIV() {
        return ivs[SPEED];
    }

    /**
     * Return the Pokemon's IVs
     * @return The Pokemons IVs
     */
    public int[] getIVs() { return ivs; }

    /**
     * Return the total speed this Pokemon has at the time of an
     * attack.
     * @param field The total field at the time of the attack.
     * @param pokemonField The Pokemon's side of the field at the time
     *                     of the attack.
     * @return The total speed this Pokemon has when it attacks.
     */
    public double getTotalSpeed(Field field, SubField pokemonField) {
        double userSpeed = getSpeedStat();
        int stage = getSpeedStage();
        if (stage > 0) {
            userSpeed = userSpeed * ((2.0 + stage) / 2.0);
        } else if (stage < 0) {
            userSpeed = userSpeed * (2.0 / (Math.abs(stage) + 2.0));
        }
        if (isParalyzed()) {
            userSpeed *= 0.5;
        }
        if (ability.getId() == AbilityId.SAND_RUSH &&
                field.getWeatherType() == WeatherType.SAND) {
            userSpeed *= 2;
        } else if (ability.getId() == AbilityId.SWIFT_SWIM &&
                (field.getWeatherType() == WeatherType.RAIN ||
                        field.getWeatherType() == WeatherType.HEAVY_RAIN)) {
            userSpeed *= 2;
        } else if (ability.getId() == AbilityId.CHLOROPHYLL &&
                (field.getWeatherType() == WeatherType.SUN ||
                        field.getWeatherType() == WeatherType.HARSH_SUNSHINE)) {
            userSpeed *= 2;
        }
        if (pokemonField.hasTailwind()) {
            userSpeed *= 2;
        }
        return userSpeed;
    }



    /**
     * Initialize the Pokemon's resistances.
     */
    private void initializeResistances() {
        resistances = new HashMap<Type, Double>();
        resistances.put(Pokemon.Type.NORMAL, 1.0);
        resistances.put(Pokemon.Type.FIGHTING, 1.0);
        resistances.put(Pokemon.Type.FLYING, 1.0);
        resistances.put(Pokemon.Type.POISON, 1.0);
        resistances.put(Pokemon.Type.GROUND, 1.0);
        resistances.put(Pokemon.Type.ROCK, 1.0);
        resistances.put(Pokemon.Type.BUG, 1.0);
        resistances.put(Pokemon.Type.GHOST, 1.0);
        resistances.put(Pokemon.Type.STEEL, 1.0);
        resistances.put(Pokemon.Type.FAIRY, 1.0);
        resistances.put(Pokemon.Type.FIRE, 1.0);
        resistances.put(Pokemon.Type.WATER, 1.0);
        resistances.put(Pokemon.Type.GRASS, 1.0);
        resistances.put(Pokemon.Type.ELECTRIC, 1.0);
        resistances.put(Pokemon.Type.PSYCHIC, 1.0);
        resistances.put(Pokemon.Type.ICE, 1.0);
        resistances.put(Pokemon.Type.DRAGON, 1.0);
        resistances.put(Pokemon.Type.DARK, 1.0);
        initializeResistances(battleTypeOne);
        if (typeTwo != Type.NONE) {
            initializeResistances(battleTypeTwo);
        }
    }

    /**
     * Initialize the Pokemon's resistances for the specified
     * type.
     * This method gets called twice. Once for typeOne,
     * second for typeTwo.
     * @param type The type of the Pokemon, either one or two.
     */
    private void initializeResistances(Type type) {
        if (type == Pokemon.Type.NORMAL) {
            resistances.put(Pokemon.Type.FIGHTING, 
                    resistances.get(Pokemon.Type.FIGHTING) *  2);
            resistances.put(Pokemon.Type.GHOST, 
                    resistances.get(Pokemon.Type.GHOST) *  0);
        } else if (type == Pokemon.Type.FIGHTING) {
            resistances.put(Pokemon.Type.FLYING, 
                    resistances.get(Pokemon.Type.FLYING) * 2);
            resistances.put(Pokemon.Type.ROCK, 
                    resistances.get(Pokemon.Type.ROCK) * 0.5);
            resistances.put(Pokemon.Type.BUG,
                    resistances.get(Pokemon.Type.BUG) * 0.5);
            resistances.put(Pokemon.Type.PSYCHIC,  
                    resistances.get(Pokemon.Type.PSYCHIC) * 2);
            resistances.put(Pokemon.Type.DARK, 
                    resistances.get(Pokemon.Type.DARK) * 0.5);
            resistances.put(Pokemon.Type.FAIRY, resistances.get(Pokemon.Type.FAIRY) * 2);
        } else if (type == Pokemon.Type.FLYING) {
            resistances.put(Pokemon.Type.FIGHTING, 
                    resistances.get(Pokemon.Type.FIGHTING)  * 0.5);
            resistances.put(Pokemon.Type.GROUND, 0.0);
            resistances.put(Pokemon.Type.ROCK, 
                    resistances.get(Pokemon.Type.ROCK) * 2);
            resistances.put(Pokemon.Type.BUG, 
                    resistances.get(Pokemon.Type.BUG) * 0.5);
            resistances.put(Pokemon.Type.GRASS, 
                    resistances.get(Pokemon.Type.GRASS) * 0.5);
            resistances.put(Pokemon.Type.ELECTRIC, 
                    resistances.get(Pokemon.Type.ELECTRIC) * 2);
            resistances.put(Pokemon.Type.ICE, 
                    resistances.get(Pokemon.Type.ICE) * 2);
        } else if (type == Pokemon.Type.POISON) {
            resistances.put(Pokemon.Type.FIGHTING, resistances.get(Pokemon.Type.FIGHTING)  * 0.5);
            resistances.put(Pokemon.Type.POISON, resistances.get(Pokemon.Type.POISON) * 0.5);
            resistances.put(Pokemon.Type.GROUND, resistances.get(Pokemon.Type.GROUND) * 2);
            resistances.put(Pokemon.Type.BUG, resistances.get(Pokemon.Type.BUG) * 0.5);
            resistances.put(Pokemon.Type.GRASS, resistances.get(Pokemon.Type.GRASS) * 0.5);
            resistances.put(Pokemon.Type.PSYCHIC, resistances.get(Pokemon.Type.PSYCHIC) * 2);
            resistances.put(Pokemon.Type.FAIRY, resistances.get(Pokemon.Type.FAIRY) * 0.5);
        } else if (type == Pokemon.Type.GROUND) {
            resistances.put(Pokemon.Type.POISON, resistances.get(Pokemon.Type.POISON) * 0.5);
            resistances.put(Pokemon.Type.ROCK, resistances.get(Pokemon.Type.ROCK) * 0.5);
            resistances.put(Pokemon.Type.WATER, resistances.get(Pokemon.Type.WATER) * 2);
            resistances.put(Pokemon.Type.GRASS, resistances.get(Pokemon.Type.GRASS) * 2);
            resistances.put(Pokemon.Type.ELECTRIC, 0.0);
            resistances.put(Pokemon.Type.ICE, resistances.get(Pokemon.Type.ICE) * 2);
        } else if (type == Pokemon.Type.ROCK) {
            resistances.put(Pokemon.Type.NORMAL, resistances.get(Pokemon.Type.NORMAL) * 0.5);
            resistances.put(Pokemon.Type.FIGHTING, resistances.get(Pokemon.Type.FIGHTING) * 2);
            resistances.put(Pokemon.Type.FLYING, resistances.get(Pokemon.Type.FLYING) * 0.5);
            resistances.put(Pokemon.Type.POISON, resistances.get(Pokemon.Type.POISON) * 0.5);
            resistances.put(Pokemon.Type.GROUND, resistances.get(Pokemon.Type.GROUND) * 2);
            resistances.put(Pokemon.Type.STEEL, resistances.get(Pokemon.Type.STEEL) * 2);
            resistances.put(Pokemon.Type.FIRE, resistances.get(Pokemon.Type.FIRE) * 0.5);
            resistances.put(Pokemon.Type.WATER, resistances.get(Pokemon.Type.WATER) * 2);
            resistances.put(Pokemon.Type.GRASS, resistances.get(Pokemon.Type.GRASS) * 2);
        } else if (type == Pokemon.Type.BUG) {
            resistances.put(Pokemon.Type.FIGHTING, resistances.get(Pokemon.Type.FIGHTING) * 0.5);
            resistances.put(Pokemon.Type.FLYING, resistances.get(Pokemon.Type.FLYING) * 2);
            resistances.put(Pokemon.Type.GROUND, resistances.get(Pokemon.Type.GROUND) * 0.5);
            resistances.put(Pokemon.Type.ROCK, resistances.get(Pokemon.Type.ROCK) * 2);
            resistances.put(Pokemon.Type.FIRE, resistances.get(Pokemon.Type.FIRE) * 2);
            resistances.put(Pokemon.Type.GRASS, resistances.get(Pokemon.Type.GRASS) * 0.5);
        } else if (type == Pokemon.Type.GHOST) {
            resistances.put(Pokemon.Type.NORMAL, 0.0);
            resistances.put(Pokemon.Type.FIGHTING, 0.0);
            resistances.put(Pokemon.Type.POISON, resistances.get(Pokemon.Type.POISON) * 0.5);
            resistances.put(Pokemon.Type.BUG, resistances.get(Pokemon.Type.BUG) * 0.5);
            resistances.put(Pokemon.Type.GHOST, resistances.get(Pokemon.Type.GHOST) * 2);
            resistances.put(Pokemon.Type.DARK, resistances.get(Pokemon.Type.DARK) * 2);
        } else if (type == Pokemon.Type.STEEL) {
            resistances.put(Pokemon.Type.NORMAL, resistances.get(Pokemon.Type.NORMAL) * 0.5);
            resistances.put(Pokemon.Type.FIGHTING, resistances.get(Pokemon.Type.FIGHTING) * 2);
            resistances.put(Pokemon.Type.FLYING, resistances.get(Pokemon.Type.FLYING) * 0.5);
            resistances.put(Pokemon.Type.POISON, 0.0);
            resistances.put(Pokemon.Type.GROUND, resistances.get(Pokemon.Type.GROUND) * 2);
            resistances.put(Pokemon.Type.ROCK, resistances.get(Pokemon.Type.ROCK) * 0.5);
            resistances.put(Pokemon.Type.BUG, resistances.get(Pokemon.Type.BUG) * 0.5);
            resistances.put(Pokemon.Type.STEEL, resistances.get(Pokemon.Type.STEEL) * 0.5);
            resistances.put(Pokemon.Type.FIRE, resistances.get(Pokemon.Type.FIRE) * 2);
            resistances.put(Pokemon.Type.GRASS, resistances.get(Pokemon.Type.GRASS) * 0.5);
            resistances.put(Pokemon.Type.PSYCHIC, resistances.get(Pokemon.Type.PSYCHIC) * 0.5);
            resistances.put(Pokemon.Type.ICE, resistances.get(Pokemon.Type.ICE) * 0.5);
            resistances.put(Pokemon.Type.DRAGON, resistances.get(Pokemon.Type.DRAGON) * 0.5);
            resistances.put(Pokemon.Type.FAIRY, resistances.get(Pokemon.Type.FAIRY) * 0.5);
        } else if (type == Pokemon.Type.FIRE) {
            resistances.put(Pokemon.Type.GROUND, resistances.get(Pokemon.Type.GROUND) * 2);
            resistances.put(Pokemon.Type.ROCK, resistances.get(Pokemon.Type.ROCK) * 2);
            resistances.put(Pokemon.Type.BUG, resistances.get(Pokemon.Type.BUG) * 0.5);
            resistances.put(Pokemon.Type.STEEL, resistances.get(Pokemon.Type.STEEL) * 0.5);
            resistances.put(Pokemon.Type.FIRE, resistances.get(Pokemon.Type.FIRE) * 0.5);
            resistances.put(Pokemon.Type.WATER, resistances.get(Pokemon.Type.WATER) * 2);
            resistances.put(Pokemon.Type.GRASS, resistances.get(Pokemon.Type.GRASS) * 0.5);
            resistances.put(Pokemon.Type.ICE, resistances.get(Pokemon.Type.ICE) * 0.5);
            resistances.put(Pokemon.Type.FAIRY, resistances.get(Pokemon.Type.FAIRY) * 0.5);
        } else if (type == Pokemon.Type.WATER) {
            resistances.put(Pokemon.Type.STEEL, resistances.get(Pokemon.Type.STEEL) * 0.5);
            resistances.put(Pokemon.Type.FIRE, resistances.get(Pokemon.Type.FIRE) * 0.5);
            resistances.put(Pokemon.Type.WATER, resistances.get(Pokemon.Type.WATER) * 0.5);
            resistances.put(Pokemon.Type.GRASS, resistances.get(Pokemon.Type.GRASS) * 2);
            resistances.put(Pokemon.Type.ELECTRIC, resistances.get(Pokemon.Type.ELECTRIC) * 2);
            resistances.put(Pokemon.Type.ICE, resistances.get(Pokemon.Type.ICE) * 0.5);
        } else if (type == Pokemon.Type.GRASS) {
            resistances.put(Pokemon.Type.FLYING, resistances.get(Pokemon.Type.FLYING) * 2);
            resistances.put(Pokemon.Type.POISON, resistances.get(Pokemon.Type.POISON) * 2);
            resistances.put(Pokemon.Type.GROUND, resistances.get(Pokemon.Type.GROUND) * 0.5);
            resistances.put(Pokemon.Type.BUG, resistances.get(Pokemon.Type.BUG) * 2);
            resistances.put(Pokemon.Type.FIRE, resistances.get(Pokemon.Type.FIRE) * 2);
            resistances.put(Pokemon.Type.WATER, resistances.get(Pokemon.Type.WATER) * 0.5);
            resistances.put(Pokemon.Type.GRASS, resistances.get(Pokemon.Type.GRASS) * 0.5);
            resistances.put(Pokemon.Type.ELECTRIC, resistances.get(Pokemon.Type.ELECTRIC) * 0.5);
            resistances.put(Pokemon.Type.ICE, resistances.get(Pokemon.Type.ICE) * 2);
        } else if (type == Pokemon.Type.ELECTRIC) {
            resistances.put(Pokemon.Type.FLYING, resistances.get(Pokemon.Type.FLYING) * 0.5);
            resistances.put(Pokemon.Type.GROUND, resistances.get(Pokemon.Type.GROUND) * 2);
            resistances.put(Pokemon.Type.STEEL, resistances.get(Pokemon.Type.STEEL) * 0.5);
            resistances.put(Pokemon.Type.ELECTRIC, resistances.get(Pokemon.Type.ELECTRIC) * 0.5);
        } else if (type == Pokemon.Type.PSYCHIC) {
            resistances.put(Pokemon.Type.FIGHTING, resistances.get(Pokemon.Type.FIGHTING) * 0.5);
            resistances.put(Pokemon.Type.BUG, resistances.get(Pokemon.Type.BUG) * 2);
            resistances.put(Pokemon.Type.GHOST, resistances.get(Pokemon.Type.GHOST) * 2);
            resistances.put(Pokemon.Type.PSYCHIC, resistances.get(Pokemon.Type.PSYCHIC) * 0.5);
            resistances.put(Pokemon.Type.DARK, resistances.get(Pokemon.Type.DARK) * 2);
        } else if (type == Pokemon.Type.ICE) {
            resistances.put(Pokemon.Type.FIGHTING, resistances.get(Pokemon.Type.FIGHTING) * 2);
            resistances.put(Pokemon.Type.ROCK, resistances.get(Pokemon.Type.ROCK) * 2);
            resistances.put(Pokemon.Type.STEEL, resistances.get(Pokemon.Type.STEEL) * 2);
            resistances.put(Pokemon.Type.FIRE, resistances.get(Pokemon.Type.FIRE) * 2);
            resistances.put(Pokemon.Type.ICE, resistances.get(Pokemon.Type.ICE) * 0.5);
        } else if (type == Pokemon.Type.DRAGON) {
            resistances.put(Pokemon.Type.FIRE, resistances.get(Pokemon.Type.FIRE) * 0.5);
            resistances.put(Pokemon.Type.WATER, resistances.get(Pokemon.Type.WATER) * 0.5);
            resistances.put(Pokemon.Type.GRASS, resistances.get(Pokemon.Type.GRASS) * 0.5);
            resistances.put(Pokemon.Type.ELECTRIC, resistances.get(Pokemon.Type.ELECTRIC) * 0.5);
            resistances.put(Pokemon.Type.ICE, resistances.get(Pokemon.Type.ICE) * 2);
            resistances.put(Pokemon.Type.DRAGON, resistances.get(Pokemon.Type.DRAGON) * 2);
            resistances.put(Pokemon.Type.FAIRY, resistances.get(Pokemon.Type.FAIRY) * 2);
        } else if (type == Pokemon.Type.DARK) {
            resistances.put(Pokemon.Type.FIGHTING, resistances.get(Pokemon.Type.FIGHTING) * 2);
            resistances.put(Pokemon.Type.BUG, resistances.get(Pokemon.Type.BUG) * 2);
            resistances.put(Pokemon.Type.GHOST, resistances.get(Pokemon.Type.GHOST) * 0.5);
            resistances.put(Pokemon.Type.FAIRY, resistances.get(Pokemon.Type.FAIRY) * 2);
            resistances.put(Pokemon.Type.PSYCHIC,  0.0);
            resistances.put(Pokemon.Type.DARK, resistances.get(Pokemon.Type.DARK) * 0.5);
        } else if (type == Type.FAIRY) {
            resistances.put(Pokemon.Type.FIGHTING, resistances.get(Pokemon.Type.FIGHTING) * 0.5);
            resistances.put(Type.POISON, resistances.get(Type.POISON) * 2);
            resistances.put(Type.BUG, resistances.get(Type.BUG) * 0.5);
            resistances.put(Type.DRAGON, 0.0);
            resistances.put(Type.STEEL,  resistances.get(Type.STEEL) * 2);
            resistances.put(Pokemon.Type.DARK, resistances.get(Pokemon.Type.DARK) * 0.5);
        }
    }

    /**
     * Return the Pokemon's resistance hash map.
      * @return A hash map of the Pokemon's resistances. The
     * attack type is the key, and the resist modifier for the value.
     */
    public HashMap<Type, Double> getResistances() {
        return resistances;
    }

    /**
     * Return a random IV value, 1-31
     * @return A random IV value
     */
    private int createRandomIV(int wildType) {
        if (wildType == 1) {
            return (int)(Math.round(Math.random() * 9)) + 1;
        } else if (wildType == 2) {
            return (int)(Math.round(Math.random() * (31 - 20))) + 20;
        }
        return (int)(Math.round(Math.random() * 30)) + 1;
    }

    /**
     * Initialize an empty EV set. (All = 0)
     */
    private void initBlankEVs() {
        evs = new int[6];
        evs[HEALTH] = 0;
        evs[ATTACK] = 0;
        evs[SPECIAL_ATTACK] = 0;
        evs[SPECIAL_DEFENSE] = 0;
        evs[DEFENSE] = 0;
        evs[SPECIAL_DEFENSE] = 0;
        evs[SPEED] = 0;
    }


    /**
     * Return the amount of Health EVs the Pokemon has.
     * @return Amount of Health EVs
     */
    public int getHealthEV() {
        return evs[HEALTH];
    }

    /**
     * Return the amount of Attack EVs the Pokemon has.
     * @return Amount of Attack EVs
     */
    public int getAttackEV() {
        return evs[ATTACK];
    }

    /**
     * Return the amount of Defense EVs the Pokemon has.
     * @return Amount of Defense EVs.
     */
    public int getDefenseEV() {
        return evs[DEFENSE];
    }

    /**
     * Return the amount of Special Attack EVs the Pokemon has.
     * @return Amount of Special Attack EVs.
     */
    public int getSpAttackEV() {
        return evs[SPECIAL_ATTACK];
    }

    /**
     * Return the amount of Special Defense EVs the Pokemon has.
     * @return Amount of Special Defense EVs.
     */
    public int getSpDefenseEV() {
        return evs[SPECIAL_DEFENSE];
    }

    /**
     * Return the amount of Speed EVs the Pokemon has.
     * @return Amount of Speed EVs.
     */
    public int getSpeedEV() {
        return evs[SPEED];
    }

    /**
     * Return the Pokemon's EVs
     * @return The Pokemon's EVs
     */
    public int[] getEVs() { return evs; }

    /**
     * Set a random nature for the Pokemon.
     */
    private void setRandomNature() {
        com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature[] natureList = com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature.values();
        int value = (int)Math.round(Math.random() * (natureList.length - 1));
        nature = natureList[value];
    }

    /**
     * Return the Pokemon's capture rate.
     * @return The capture rate
     */
    public int getCaptureRate() { return captureRate; }

    /**
     * Return the Pokemon's base heatlh stat.
     * @return Base Health
     */
    public int getBaseStatHealth() {
        return baseStats[HEALTH];
    }

    /**
     * Return the Pokemon's base attack stat.
     * @return Base Attack
     */
    public int getBaseStatAttack() {
        return baseStats[ATTACK];
    }

    /**
     * Return the Pokemon's base special attack
     * @return Base Special Attack
     */
    public int getBaseStatSpeicialAttack() {
        return baseStats[SPECIAL_ATTACK];
    }

    /**
     * Return the Pokemon's base defense.
     * @return Base Defense
     */
    public int getBaseStatDefense() {
        return baseStats[DEFENSE];
    }

    /**
     * Return the Pokemon's base special defense.
     * @return Base Special Defense
     */
    public int getBaseStatSpecialDefense() {
        return baseStats[SPECIAL_DEFENSE];
    }

    /**
     * Return the Pokemon's base speed.
     * @return Base Speed
     */
    public int getBaseStatSpeed() {
        return baseStats[SPEED];
    }

    /**
     * Return the Pokemon's health stat, total health
     * @return Total Health stat
     */
    public int getHealthStat() {
        return (int)Math.round(((2 * getBaseStatHealth() + ivs[HEALTH] + (evs[HEALTH] / 4.0) + 100) * level) / 100.0) + 10;
    }

    /**
     * Return the Pokemon's attack stat
     * @return Attack Stat
     */
    public int getAttackStat() {
        return (int)Math.round(((((2 * getBaseStatAttack() + ivs[ATTACK] + (evs[ATTACK] / 4.0)) * level)
                / 100.0) + 5) * natureAttackMultiplier);
    }

    /**
     * Return the Pokemon's special attack stat.
     * @return Special Attack Stat
     */
    public int getSpecialAttackStat() {
        return (int)Math.round(((((2 * getBaseStatSpeicialAttack() + ivs[SPECIAL_ATTACK] + (evs[SPECIAL_ATTACK] / 4.0)) * level)
                / 100.0) + 5) * natureSpecialAttackMultiplier);
    }

    /**
     * Return the Pokemon's defense stat.
     * @return Defense Stat
     */
    public int getDefenseStat() {
        return (int)Math.round(((((2 * getBaseStatDefense() + ivs[DEFENSE] + (evs[DEFENSE] / 4.0)) * level)
                / 100.0) + 5) * natureDefenseMultiplier);
    }

    /**
     * Return the Pokemon's special defense stat.
     * @return Special Defense Stat
     */
    public int getSpecialDefenseStat() {
        return (int)Math.round(((((2 * getBaseStatSpecialDefense() + ivs[SPECIAL_DEFENSE] + (evs[SPECIAL_DEFENSE] / 4.0)) * level)
                / 100.0) + 5) * natureSpecialDefenseMultiplier);
    }

    /**
     * Return the Pokemon's speed stat.
     * @return Speed Stat
     */
    public int getSpeedStat() {
        return (int)Math.round(((((2 * getBaseStatSpeed() + ivs[SPEED] + (evs[SPEED] / 4.0)) * level)
                / 100.0) + 5) * natureSpeedMultiplier);
    }

    /**
     * Return the Pokemon's attack stage.
     * @return Attack Stage
     */
    public int getAttackStage() {
        return attackStage;
    }

    /**
     * Return the Pokemon's defense stage.
     * @return Defense Stage
     */
    public int getDefenseStage() {
        return defenseStage;
    }

    /**
     * Return the Pokemon's special attack stage.
     * @return Special Attack Stage
     */
    public int getSpecialAttackStage() {
        return specialAttackStage;
    }

    /**
     * Return the Pokemon's special defense stage.
     * @return Special Defense Stage
     */
    public int getSpecialDefenseStage() {
        return specialDefenseStage;
    }

    /**
     * Return the Pokemon's speed stage.
     * @return Speed Stage
     */
    public int getSpeedStage() {
        return speedStage;
    }

    /**
     * Return the Pokemon's accuracy stage.
     * @return Accuracy Stage
     */
    public int getAccuracyStage() { return accuracyStage; }

    /**
     * Return the Pokemon's evasion stage.
     * @return Evasion Stage.
     */
    public int getEvasionStage() { return evasionStage; }

    /**
     * Convert the accuracy stage into the modifier and return it.
     * @return The accuracy modifier.
     */
    public double getAccuracyModifier(int accuracyStage) {
        if (accuracyStage >= 0) {
            return 1 + (1 / 3.0) * accuracyStage;
        } else {
            if (accuracyStage == -1) {
                return .75;
            } else if (accuracyStage == -2) {
                return .6;
            } else if (accuracyStage == -3) {
                return .5;
            } else if (accuracyStage == -4) {
                return .428;
            } else if (accuracyStage == -5) {
                return .375;
            } else if (accuracyStage == -6) {
                return .33;
            }
        }
        return 1; //default
    }

    /**
     * Convert the evasion stage into the modifier and return it.
     * @return The evasion modifier.
     */
    public double getEvasionModifier(int evasionStage) {
        if (evasionStage < 0) {
            return Math.abs(evasionStage) * (1 / 3.0) + 1;
        } else {
            if (evasionStage == 1) {
                return .75;
            } else if (evasionStage == 2) {
                return .6;
            } else if (evasionStage == 3) {
                return .5;
            } else if (evasionStage == 4) {
                return .428;
            } else if (evasionStage == 5) {
                return .375;
            } else if (evasionStage == 6) {
                return .33;
            }
        }
        return 1; //default
    }

    /**
     * Return the exp required to reach the next level.
     * @return The exp required to reach the next level.
     */
    public int getNextLevelExp() {
        if (level == 100) {
            return 0;
        } else {
            return getTotalExp(level + 1) - getTotalExp(level);
        }
    }

    /**
     * Return the total amount of exp at the specified level
     * @param level The level in which we are looking at for total exp
     * @return The total exp at level level.
     */
    public int getTotalExp(int level) {
        //Determine the exp growth rate and then get the total exp.
        if (expType == ExpType.FLUCTUATING) {
            return getFluctuatingTotalExp(level);
        }
        else if (expType == ExpType.MEDIUM_FAST) {
            return getMediumFastTotalExp(level);
        }
        else if (expType == ExpType.MEDIUM_SLOW) {
            return getMediumSlowTotalExp(level);
        }
        else if (expType == ExpType.ERRATIC) {
            return getErraticTotalExp(level);
        }
        else if (expType == ExpType.SLOW) {
            return getSlowTotalExp(level);
        }
        else {
            //The last exp growth rate is ExpType.FAST
            return getFastTotalExp(level);
        }
    }

    /**
     * Return the total amount of exp at the specified level
     * for a fluctuating exp growth rate.
     * @param level The level in which we are looking at for total exp
     * @return The total exp at level level.
     */
    private int getFluctuatingTotalExp(int level) {
        if (level <= 15)
        {
            return (int)Math.round(Math.pow(level, 3) * ((Math.floor((level + 1) / 3) + 24) / 50.0));
        }
        else if(level > 15 && level <= 36)
        {
            return (int)Math.round(Math.pow(level, 3) * ((level + 14) / 50.0));
        }
        else
        {
            return (int)Math.round(Math.pow(level, 3) * ((Math.floor(level / 2) + 32) / 50.0));
        }
    }

    /**
     * Return the total amount of exp at the specified level
     * for a medium fast exp growth rate.
     * @param level The level in which we are looking at for total exp
     * @return The total exp at level level.
     */
    private int getMediumFastTotalExp(int level) {
        return (int)Math.round(Math.pow(level, 3));
    }

    /**
     * Return the total amount of exp at the specified level
     * for a medium slow exp growth rate.
     * @param level The level in which we are looking at for total exp
     * @return The total exp at level level.
     */
    private int getMediumSlowTotalExp(int level) {
        if (level == 1) {
            return 0;
        }
        else {
            return (int)Math.round((6/5.0 * Math.pow(level, 3)) - (15 * Math.pow(level, 2)) + (100 * level) - 140);
        }
    }

    /**
     * Return the total amount of exp at the specified level
     * for a slow exp growth rate.
     * @param level The level in which we are looking at for total exp
     * @return The total exp at level level.
     */
    private int getSlowTotalExp(int level) {
        return (int)Math.round(5 * Math.pow(level, 3) / 4.0);
    }

    /**
     * Return the total amount of exp at the specified level
     * for a fast exp growth rate.
     * @param level The level in which we are looking at for total exp
     * @return The total exp at level level.
     */
    private int getFastTotalExp(int level) {
        return (int)Math.round(4 * Math.pow(level, 3) / 5.0);
    }

    /**
     * Return the total amount of exp at the specified level
     * for an erratic exp growth rate.
     * @param level The level in which we are looking at for total exp
     * @return The total exp at level level.
     */
    private int getErraticTotalExp(int level) {
        if (level <= 50)
        {
            return (int)Math.round((Math.pow(level, 3) * (100 - level)) / 50.0);
        }
        else if (level > 50 && level <= 68)
        {
            return (int)Math.round((Math.pow(level, 3) * (150 - level)) / 100.0);
        }
        else if (level > 68 && level <= 98)
        {
            return (int)Math.round(Math.pow(level, 3) * Math.floor((1911 - 10 * level) / 3) / 500.0);
        }
        else
        {
            return (int)Math.round((Math.pow(level, 3) * (160 - level)) / 100.0);
        }
    }

    /**
     * Return the Pokemon's base exp
     * @return Base Exp
     */
    public int getBaseExp() {
        return baseExp;
    }

    /**
     * Completely heal the Pokemon. (Nurse Joy style)
     * - Revive
     * - Full Health
     * - Remove Status Condition
     */
    public void fullyHeal() {
        currentHealth = getHealthStat();
        animationHealth = currentHealth;
        fainted = false;
        sleepTime = 0;
        status = Status.STATUS_FREE;
        preStatus = Status.STATUS_FREE;

        //Make them go up.
        playerX = PLAYER_NORMAL_X;
        playerY = PLAYER_NORMAL_Y;
        enemyX = ENEMY_NORMAL_X;
        enemyY = ENEMY_NORMAL_Y;
    }

    /**
     * Return the texture of the Pokemon's first type.
     * @return The texture of the Pokemon's first type.
     */
    public Texture getTypeOneTexture() {
        if (typeOne == Pokemon.Type.BUG) {
            return new Texture("bag/gui/skill/bug.png");
        } else if (typeOne == Pokemon.Type.DARK) {
            return new Texture("bag/gui/skill/dark.png");
        } else if (typeOne == Pokemon.Type.DRAGON) {
            return new Texture("bag/gui/skill/dragon.png");
        } else if (typeOne == Pokemon.Type.ELECTRIC) {
            return new Texture("bag/gui/skill/electric.png");
        } else if (typeOne == Pokemon.Type.FIGHTING) {
            return new Texture("bag/gui/skill/fighting.png");
        } else if (typeOne == Pokemon.Type.FIRE) {
            return new Texture("bag/gui/skill/fire.png");
        } else if (typeOne == Pokemon.Type.FLYING) {
            return new Texture("bag/gui/skill/flying.png");
        } else if (typeOne == Pokemon.Type.GHOST) {
            return new Texture("bag/gui/skill/ghost.png");
        } else if (typeOne == Pokemon.Type.GRASS) {
            return new Texture("bag/gui/skill/grass.png");
        } else if (typeOne == Pokemon.Type.GROUND) {
            return new Texture("bag/gui/skill/ground.png");
        } else if (typeOne == Pokemon.Type.ICE) {
            return new Texture("bag/gui/skill/ice.png");
        } else if (typeOne == Pokemon.Type.NORMAL) {
            return new Texture("bag/gui/skill/normal.png");
        } else if (typeOne == Pokemon.Type.POISON) {
            return new Texture("bag/gui/skill/poison.png");
        } else if (typeOne == Pokemon.Type.PSYCHIC) {
            return new Texture("bag/gui/skill/psychic.png");
        } else if (typeOne == Pokemon.Type.ROCK) {
            return new Texture("bag/gui/skill/rock.png");
        } else if (typeOne == Pokemon.Type.STEEL) {
            return new Texture("bag/gui/skill/steel.png");
        } else if (typeOne == Pokemon.Type.WATER) {
            return new Texture("bag/gui/skill/water.png");
        }
        else if (typeOne == Pokemon.Type.FAIRY) {
            return new Texture("bag/gui/skill/fairy.png");
        }
        else {
            return new Texture("bag/gui/skill/normal.png");
        }
    }

    /**
     * Return the texture of the Pokemon's second type.
     * @return The texture of the Pokemon's second type.
     */
    public Texture getTypeTwoTexture() {
        if (typeTwo == Pokemon.Type.BUG) {
            return new Texture("bag/gui/skill/bug.png");
        } else if (typeTwo == Pokemon.Type.DARK) {
            return new Texture("bag/gui/skill/dark.png");
        } else if (typeTwo == Pokemon.Type.DRAGON) {
            return new Texture("bag/gui/skill/dragon.png");
        } else if (typeTwo == Pokemon.Type.ELECTRIC) {
            return new Texture("bag/gui/skill/electric.png");
        } else if (typeTwo == Pokemon.Type.FIGHTING) {
            return new Texture("bag/gui/skill/fighting.png");
        } else if (typeTwo == Pokemon.Type.FIRE) {
            return new Texture("bag/gui/skill/fire.png");
        } else if (typeTwo == Pokemon.Type.FLYING) {
            return new Texture("bag/gui/skill/flying.png");
        } else if (typeTwo == Pokemon.Type.GHOST) {
            return new Texture("bag/gui/skill/ghost.png");
        } else if (typeTwo == Pokemon.Type.GRASS) {
            return new Texture("bag/gui/skill/grass.png");
        } else if (typeTwo == Pokemon.Type.GROUND) {
            return new Texture("bag/gui/skill/ground.png");
        } else if (typeTwo == Pokemon.Type.ICE) {
            return new Texture("bag/gui/skill/ice.png");
        } else if (typeTwo == Pokemon.Type.NORMAL) {
            return new Texture("bag/gui/skill/normal.png");
        } else if (typeTwo == Pokemon.Type.POISON) {
            return new Texture("bag/gui/skill/poison.png");
        } else if (typeTwo == Pokemon.Type.PSYCHIC) {
            return new Texture("bag/gui/skill/psychic.png");
        } else if (typeTwo == Pokemon.Type.ROCK) {
            return new Texture("bag/gui/skill/rock.png");
        } else if (typeTwo == Pokemon.Type.STEEL) {
            return new Texture("bag/gui/skill/steel.png");
        } else if (typeTwo == Pokemon.Type.WATER) {
            return new Texture("bag/gui/skill/water.png");
        }
        else if (typeTwo == Pokemon.Type.FAIRY) {
            return new Texture("bag/gui/skill/fairy.png");
        }
        else {
            return new Texture("bag/gui/skill/normal.png");
        }
    }

    public AbsorbResult getAbsorbResults(Skill usedSkill) {
        if (usedSkill.getType() == Type.ELECTRIC) {
            if (ability.getId() == AbilityId.LIGHTNINGROD) {
                getLightningRodAbsorbEffect();
            } else if (ability.getId() == AbilityId.MOTOR_DRIVE) {
                return getMotorDriveAbsorbEffect();
            } else if (ability.getId() == AbilityId.VOLT_ABSORB) {
                return getVoltAbsorbAbsorbEffect();
            }
        } else if (usedSkill.getType() == Type.WATER) {
            if (ability.getId() == AbilityId.DRY_SKIN) {
                return getDrySkinAbsorbEffect();
            } else if (ability.getId() == AbilityId.WATER_ABSORB) {
                return getWaterAbsorbAbsorbEffect();
            }
        }
        return new AbsorbResult(false);
    }

    /**
     * Return the AbsorbResults when Lightning Rod absorbs an
     * attack successfully while gaining Lightning Rod's absorbtion
     * effects.
     * @return Volt Absorbs successful AbsorbResults.
     */
    private AbsorbResult getLightningRodAbsorbEffect() {
        List<String> absorbText = new ArrayList<String>();
        absorbText.add(name + " takes no damage\ndue to their ability Lightning Rod.");
        if (specialAttackStage < 6) {
            absorbText.add(name + "'s Special Attack rose!");
            increaseSpAttackStage(1);
        } else {
            absorbText.add(name + "'s Special Attack cannot go higher.");
        }
        return new AbsorbResult(absorbText);
    }

    /**
     * Return the AbsorbResults when Motor Drive absorbs an
     * attack successfully while gaining Motor Drive's absorbtion
     * effects.
     * @return Motor Drive's successful AbsorbResults.
     */
    private AbsorbResult getMotorDriveAbsorbEffect() {
        List<String> absorbText = new ArrayList<String>();
        absorbText.add(name + " takes no damage\ndue to their ability Motor Drive.");
        if (speedStage < 6) {
            absorbText.add(name + "'s Speed rose!");
            increaseSpeedStage(1);
        } else {
            absorbText.add(name + "'s Speed cannot go higher.");
        }
        return new AbsorbResult(absorbText);
    }

    /**
     * Return the AbsorbResults when Dry Skin absorbs an
     * attack successfully while gaining Dry Skin's absorbtion
     * effects.
     * @return Dry Skin's successful AbsorbResults.
     */
    private AbsorbResult getDrySkinAbsorbEffect() {
        List<String> absorbText = new ArrayList<String>();

        if (!hasFullHealth()) {
            absorbText.add(name + " recovered health\ndue to their ability Dry Skin.");
            addHealth((int)Math.round(getHealthStat() / 4.0));
        } else {
            absorbText.add("Absorbed attack using Dry Skin");
        }
        return new AbsorbResult(absorbText);
    }

    /**
     * Return the AbsorbResults when Water Absorb absorbs an
     * attack successfully while gaining Water Absorb's absorbtion
     * effects.
     * @return Water Absorbs successful AbsorbResults.
     */
    private AbsorbResult getWaterAbsorbAbsorbEffect() {
        List<String> absorbText = new ArrayList<String>();

        if (!hasFullHealth()) {
            absorbText.add(name + " recovered health\ndue to their ability Water Absorb.");
            addHealth((int)Math.round(getHealthStat() / 4.0));
        } else {
            absorbText.add("Absorbed attack using Water Absorb.");
        }
        return new AbsorbResult(absorbText);
    }

    /**
     * Return the AbsorbResults when Volt Absorb absorbs an
     * attack successfully while gaining Volt Absorb's absorbtion
     * effects.
     * @return Volt Absorbs successful AbsorbResults.
     */
    private AbsorbResult getVoltAbsorbAbsorbEffect() {
        List<String> absorbText = new ArrayList<String>();

        if (!hasFullHealth()) {
            absorbText.add(name + " recovered health\ndue to their ability Volt Absorb.");
            addHealth((int)Math.round(getHealthStat() / 4.0));
        } else {
            absorbText.add("Absorbed attack using Volt Absorb.");
        }
        return new AbsorbResult(absorbText);
    }


    /**
     * Revive the Pokemon with a specific amount of health.
     * @param health The health the Pokemon will be revived
     *               with.
     */
    public void revive(int health) {
        currentHealth = Math.min(health, getHealthStat());
        animationHealth = currentHealth;
        fainted = false;
        status = Status.STATUS_FREE;
        preStatus = Status.STATUS_FREE;
        //Make them go up.
        playerX = PLAYER_NORMAL_X;
        playerY = PLAYER_NORMAL_Y;
        enemyX = ENEMY_NORMAL_X;
        enemyY = ENEMY_NORMAL_Y;
    }

    /**
     * Return the Pokemon's X position from a Player perspective. (Back)
     * @return The x position of the back image.
     */
    public int getPlayerX() { return playerX; }

    /**
     * Return the Pokemon's default X position from a Player perspective. (Back)
     * @return The default x position of the back image.
     */
    public int getPlayerNormalX() { return PLAYER_NORMAL_X; }

    /**
     * Set the Pokemon's X position to newX
     * @param newX The new x position.
     */
    public void setPlayerX(int newX) { playerX = newX; }

    /**
     * Return the Pokemon's Y position from a Player perspective. (Back)
     * @return The Y position of the back image.
     */
    public int getPlayerY() { return playerY; }

    /**
     * Return the Pokemon's default Y position from a Player perspective. (Back)
     * @return The default Y position of the back image.
     */
    public int getPlayerNormalY() { return PLAYER_NORMAL_Y; }

    /**
     * Set the Pokemon's Y position to newY
     * @param newY The new Y position.
     */
    public void setPlayerY(int newY) { playerY = newY; }

    /**
     * Return the Pokemon's X position from a Enemy perspective. (Front)
     * @return The x position of the front image.
     */
    public int getEnemyX() { return enemyX; }

    /**
     * Set the Pokemon's X position to newX for the enemy sprite
     * @param newX The new x position for the enemy sprite.
     */
    public void setEnemyX(int newX) { enemyX = newX; }

    /**
     * Return the Pokemon's Y position from an enemy perspective. (front)
     * @return The Y position of the front image.
     */
    public int getEnemyY() { return enemyY; }

    /**
     * Set the Pokemon's Y position to newY for the enemy sprite
     * @param newY The new Y position for the enemy sprite.
     */
    public void setEnemyY(int newY) { enemyY = newY; }

    /**
     * Return the Player's fainted Y position.
     * When the player faints, the sprite goes down. This
     * value is the minimum y amount during a faint.
     * @return Fainted Y position for the Player side.
     */
    public int getFaintedPlayerY() { return FAINTED_PLAYER_Y; }

    /**
     * Return the Enemy's fainted Y position.
     * When the enemy faints, the sprite goes down. This
     * value is the minimum y amount during a faint.
     * @return Fainted Y position for the Enemy side.
     */
    public int getFaintedEnemyY() { return FAINTED_ENEMY_Y; }

    /**
     * Make the Pokemon faint. Based on fainted boolean
     * @param fainted Whether or not the Pokemon faints
     */
    public void setFaint(boolean fainted) {
        this.fainted = fainted;
        resetBattleVariables(); //They died to reset all variables for the battle.
        if (fainted) {
            //Remove all status conditions when fainted.
            status = Status.STATUS_FREE;
            preStatus = Status.STATUS_FREE;
        }
    }

    /**
     * Return whether or not the Pokemon has fainted.
     * @return Whether or not the Pokemon has fainted.
     */
    public boolean isFainted() {
        return fainted;
    }

    public void setSkillset(List<Skill> newSkills) {
        skills = newSkills;
    }

    /**
     * Return the Pokemon's list of skills.
     * @return The Pokemon's list of moves.
     */
    public List<Skill> getSkills() { return skills; }

    /**
     * Return the Pokemon's first skill.
     * @return First Skill
     */
    public Skill getFirstSkill() {
        return skills.get(0);
    }

    /**
     * Return the Pokemon's second skill.
     * @return Second Skill, null if no second skill.
     */
    public Skill getSecondSkill() {
        if (skills.size() > 1) {
            return skills.get(1);
        }
        return null;
    }

    /**
     * Return the Pokemon's third skill.
     * @return Third Skill, null if no third skill.
     */
    public Skill getThirdSkill() {
        if (skills.size() > 2) {
            return skills.get(2);
        }
        return null;
    }

    /**
     * Return the Pokemon's fourth skill.
     * @return Fourth Skill, null if no fourth skill.
     */
    public Skill getFourthSkill() {
        if (skills.size() > 3) {
            return skills.get(3);
        }
        return null;
    }

    /**
     * Return the Pokemon's Front Image path
     * @return The path for the Pokemon's front image.
     */
    public String getMapIconPath() {
        return mapIconPath;
    }

    /**
     * Return the Pokemon's Profile Image path.
     * @return The path for the Pokemon's profile image.
     */
    public String getProfileIcon() { return profilePath; }

    /**
     * Return the Pokemon's Cry Sound path.
     * @return The path for the Pokemon's cry sound.
     */
    public String getCryPath() {
        return cryPath;
    }

    /**
     * Return the Pokemon's Back Image Path
     * @return The path for the Pokemon's back image.
     */
    public String getBackPath() { return backPath; }

    /**
     * Return the Pokemon's mini image path.
     * @return The path for the Pokemon's mini image.
     */
    public String getMiniIconPath() {
        return miniPath;
    }

    /**
     * Return whether or not the Pokemon is focused.
     * @return Whether or not the Pokemon is focused (Focus Energy)
     */
    public boolean isFocused() { return focused; }

    /**
     * Make the Pokemon focus. (From focus energy)
     */
    public void focus() { focused = true; }


    /**
     * Return the Pokemon's name
     * @return Pokemon's name
     */
    public String getName() { return name; }

    /**
     * Return the Pokemon's classifiation. Ex: Moltres is the Flame Pokemon
     * @return The Pokemon's classification
     */
    public String getClassification() {
        return classification;
    }

    /**
     * Return the Pokemon's description.
     * @return The Pokemon's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Return the Pokemon's level.
     * @return Pokemon's level.
     */
    public int getLevel() { return level; }

    /**
     * Return the String representation for the Pokemon's nature.
     * @return A String representing the Pokemon's nature.
     */
    public String getNatureString() {
        switch(nature) {
            case ADAMANT:
                return "Adamant";
            case HARDY:
                return "Hardy";
            case LONELY:
                return "Lonely";
            case BRAVE:
                return "Brave";
            case NAUGHTY:
                return "Naughty";
            case BOLD:
                return "Bold";
            case DOCILE:
                return "Docile";
            case RELAXED:
                return "Relaxed";
            case IMPISH:
                return "Impish";
            case LAX:
                return "Lax";
            case TIMID:
                return "Timid";
            case HASTY:
                return "Hasty";
            case SERIOUS:
                return "Serious";
            case JOLLY:
                return "Jolly";
            case NAIVE:
                return "Naive";
            case MODEST:
                return "Modest";
            case MILD:
                return "Mild";
            case QUIET:
                return "Quiet";
            case BASHFUL:
                return "Bashful";
            case RASH:
                return "Rash";
            case CALM:
                return "Calm";
            case GENTLE:
                return "Gentle";
            case SASSY:
                return "Sassy";
            case CAREFUL:
                return "Careful";
            case QUIRKY:
                return "Quirky";
            default:
                return "NATURE ERROR";
        }
    }

    /**
     * Return the String representation for the Pokemon's ability.
     * @return A String representing the Pokemon's ability.
     */
    public String getAbilityName() {
       return ability.getName();
    }

    /**
     * Return the Pokemon's ability
     * @return The Pokemon's ability
     */
    public Ability getAbility() { return ability; }

    /**
     * Return the Pokemon's battle ability.
     * @return The Pokemon's battle ability.
     */
    public Ability getBattleAbility() { return battleAbility; }


    /**
     * Set the Pokemon's current battling ability to
     * ability.
     * @param ability The ability the battle ability will be
     *                set to.
     */
    public void setBattleAbility(Ability ability) {
        this.battleAbility = ability;
    }

    /**
     * Return the Pokemon's nature.
     * @return The Pokemon's nature.
     */
    public com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Nature getNature() { return nature; }

    /**
     * Return the Pokemon's current health.
     * @return The current health
     */
    public int getCurrentHealth() { return currentHealth; }

    /**
     * Return whether or not the Pokemon has full health.
     * @return Whether or not the Pokemon has full health.
     */
    public boolean hasFullHealth() {
        if (currentHealth == getHealthStat()) {
            return true;
        }
        return false;
    }

    /**
     * Return the Status of the Pokemon.
     * @return The Pokemon's Status.
     */
    public Status getStatus() { return status; }

    /**
     * Return whether or not the Pokemon is paralyzed.
     * @return Whether or not the Pokemon is paralyzed.
     */
    public boolean isParalyzed() {
        if (status == Status.PARALYSIS) {
            return true;
        }
        return false;
    }

    /**
     * Return whether or not the Pokemon is burned.
     * @return Whether or not the Pokemon is burned.
     */
    public boolean isBurned() {
        if (status == Status.BURN) {
            return true;
        }
        return false;
    }

    /**
     * Return whether or not the Pokemon is sleeping.
     * @return Whether or not the Pokemon is sleeping.
     */
    public boolean isSleeping() {
        if (status == Status.SLEEP) {
            return true;
        }
        return false;
    }

    /**
     * Return whether or not the Pokemon is poisoned.
     * @return Whether or not the Pokemon is poisoned.
     */
    public boolean isPoisoned() {
        if (status == Status.POISON) {
            return true;
        }
        return false;
    }

    /**
     * Return whether or not the Pokemon is frozen.
     * @return Whether or not the Pokemon is frozen.
     */
    public boolean isFrozen() {
        if (status == Status.FROZEN) {
            return true;
        }
        return false;
    }

    /**
     * Return whether or not the Pokemon is afflicted by a
     * status condition.
     * @return Whether or not the Pokemon is afflicted by a
     * status condition.
     */
    public boolean isStatused() {
        if (status != Status.STATUS_FREE) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPoisonable() {
        if (!isStatused() && currentHealth != 0 &&
                battleAbility.getId() != AbilityId.SHIELD_DUST && !(battleTypeOne == Type.POISON ||
                battleTypeTwo == Type.POISON) && !(battleTypeOne == Type.STEEL ||
                battleTypeTwo == Type.STEEL)) {
            return true;
        }
        return false;
    }

    public boolean isParalyzable() {
        if (!isStatused() && currentHealth != 0 && battleAbility.getId() != AbilityId.SHIELD_DUST &&
                battleAbility.getId() != AbilityId.LIMBER && !(battleTypeOne == Type.ELECTRIC ||
                battleTypeTwo == Type.ELECTRIC)) {
            return true;
        }
        return false;
    }

    public boolean isSleepable() {
        if (!isStatused() && battleAbility.getId() != AbilityId.INSOMNIA && !uproaring) {
            return true;
        }
        return false;
    }
    public boolean isFreezable() {
        if (!isStatused() && currentHealth != 0 && battleAbility.getId() != AbilityId.SHIELD_DUST &&
                !(battleTypeOne == Type.ICE || battleTypeTwo == Type.ICE)) {
            return true;
        }
        return false;
    }

    public boolean isBurnable() {
        if (!isStatused() && currentHealth != 0 && battleAbility.getId() != AbilityId.SHIELD_DUST &&
                !(battleTypeOne == Type.FIRE || battleTypeTwo == Type.FIRE)) {
            return true;
        }
        return false;
    }

    public boolean isConfusable() {
        if (!confused && battleAbility.getId() != AbilityId.OWN_TEMPO) {
            return true;
        }
        return false;
    }

    public boolean isFlinchable() {
        if (battleAbility.getId() != AbilityId.INNER_FOCUS && battleAbility.getId() !=
                AbilityId.SHIELD_DUST) {
            return true;
        }
        return false;
    }

    /**
     * Set the Pokemon's status to newStatus
     * @param newStatus The status that will override the current status.
     */
    public void setStatus(Status newStatus) {
        this.status = newStatus;
    }

    /**
     * Set the Pokemon's preStatus to newStatus.
     * @param newStatus The status that will override the preStatus.
     */
    public void setPreStatus(Status newStatus) { this.preStatus = newStatus; }

    /**
     * Transfer the preStatus to the currentStatus.
     */
    public void transferPreStatus() {
        if (preStatus != Status.STATUS_FREE) {
            if (preStatus == Status.RECOVER) {
                status = Status.STATUS_FREE;
                sleepTime = 0;
            } else {
                status = preStatus;
            }
            preStatus = Status.STATUS_FREE;
        }
    }

    /**
     * Set the current health of the Pokemon to a new health
     * amount.
     * @param newHealth The new health amount.
     */
    public void setCurrentHealth(int newHealth) {
        currentHealth = newHealth;
        animationHealth = newHealth;
    }

    /**
     * Return the Pokemon's first type.
     * @return The Pokemon's first type.
     */
    public Type getTypeOne() { return typeOne; }

    /**
     * Return the Pokemon's second type
     * @return The Pokemon's second type.
     */
    public Type getTypeTwo() { return typeTwo; }

    /**
     * Return the Pokemon's battling second type.
     * @return The Pokemon's battling second type.
     */
    public Type getBattleTypeTwo() {
        return battleTypeTwo;
    }

    /**
     * Return the Pokemon's battling first type.
     * @return The Pokemon's battling first type.
     */
    public Type getBattleTypeOne() {
        return battleTypeOne;
    }

    /**
     * Set the battling first type to a new type.
     * @param newType The new type of the first battling
     *                type.
     */
    public void setBattleTypeOne(Type newType) {
        battleTypeOne = newType;
        initializeResistances();
    }

    /**
     * set the battling second type to a new type.
     * @param newType The new type of the second battling
     *                type.
     */
    public void setBattleTypeTwo(Type newType) {
        battleTypeTwo = newType;
        initializeResistances();
    }

    /**
     * Return the Pokemon's ID (0 for Bulbasaur etc)
     * @return The Pokemon's ID
     */
    public int getId() { return pokemonId; }

    /**
     * Return whether or not the animation bar's displayed health
     * matches the actual current health of the Pokemon.
     * @return Whether or not the animation health matches the
     * current health.
     */
    public boolean matchingAnimationHealth() {
        if (animationHealth == currentHealth) {
            return true;
        }
        return false;
    }

    /**
     * Return the animation health bar's health value.
     * @return The animation health bar's health value.
     */
    public int getAnimationHealth() {
        return animationHealth;
    }

    /**
     * Subtract an amount of animation health
     * @param amt The amount of animation health to subtract.
     */
    public void subtractAnimationHealth(int amt) {
        animationHealth -= amt;
        animationHealth = Math.max(currentHealth, animationHealth);
    }

    /**
     * Add an amount of animation health.
     * @param amt The amount of animation health to add.
     */
    public void addAnimationHealth(int amt) {
        animationHealth += amt;
        animationHealth = Math.min(currentHealth, animationHealth);
    }

    /**
     * Add or subtract the animation health in order to make it
     * equivalent to the current health.
     * @param rate The amount to add or subtract from the animation health
     */
    public void adjustAnimationHealth(int rate) {
        if (animationHealth > currentHealth) {
            subtractAnimationHealth(rate);
        } else if (animationHealth < currentHealth) {
            addAnimationHealth(rate);
        }
    }

    /**
     * Subtract an amount from the current health
     * @param amt The amount to subtract from current health.
     */
    public void subtractHealth(int amt) {
        currentHealth = Math.max(0, currentHealth  - amt);
        Gdx.app.log("Subtract", "" + amt);
    }

    /**
     * Add an amount to the current health.
     * @param amt The amount to add to current health.
     */
    public void addHealth(int amt) {
        currentHealth = Math.min(getHealthStat(), currentHealth + amt);
    }



    /**
     * Return the Pokemon's id that this Pokemon would evolve into
     * at the Pokemon's current level.
     * @return The id of the Pokemon this Pokemon would evolve into at
     * the Pokemon's current level.
     * Return -1 if the Pokemon wouldn't evolve into a Pokemon at this level.
     * Ex: Return 2 if this Pokemon is Bulbasaur and Bulbasaur is level 16.
     */
    public int getLevelUpEvolutionId() {
        return -1;
    }

    /**
     * Return the Pokemon's id that this Pokemon would evolve into using
     * a Fire Stone. -1 if it doesn't evolve into a Pokemon using a Fire Stone.
     * @return The id of the Pokemon this Pokemon would evolve into using
     * a Fire Stone.
     */
    public int getFireStoneEvolutionId() {
        return -1;
    }

    /**
     * Return the Pokemon's id that this Pokemon would evolve into using
     * a Leaf Stone. -1 if it doesn't evolve into a Pokemon using a Leaf Stone.
     * @return The id of the Pokemon this Pokemon would evolve into using
     * a Leaf Stone.
     */
    public int getLeafStoneEvolutionId() {
        return -1;
    }

    /**
     * Return the Pokemon's id that this Pokemon would evolve into using
     * a Water Stone. -1 if it doesn't evolve into a Pokemon using a Water Stone.
     * @return The id of the Pokemon this Pokemon would evolve into using
     * a Water Stone.
     */
    public int getWaterStoneEvolutionId() {
        return -1;
    }

    /**
     * Return the Pokemon's id that this Pokemon would evolve into using
     * a Sun Stone. -1 if it doesn't evolve into a Pokemon using a Sun Stone.
     * @return The id of the Pokemon this Pokemon would evolve into using
     * a Sun Stone.
     */
    public int getSunStoneEvolutionId() {
        return -1;
    }

    /**
     * Return the Pokemon's id that this Pokemon would evolve into using
     * a Moon Stone. -1 if it doesn't evolve into a Pokemon using a Moon Stone.
     * @return The id of the Pokemon this Pokemon would evolve into using
     * a Moon Stone.
     */
    public int getMoonStoneEvolutionId() {
        return -1;
    }

    /**
     * Return the Pokemon's id that this Pokemon would evolve into using
     * a Shiny Stone. -1 if it doesn't evolve into a Pokemon using a Shiny Stone.
     * @return The id of the Pokemon this Pokemon would evolve into using
     * a Shiny Stone.
     */
    public int getShinyStoneEvolutionId() {
        return -1;
    }

    /**
     * Return the Pokemon's id that this Pokemon would evolve into using
     * a Thunder Stone. -1 if it doesn't evolve into a Pokemon using a Thunder Stone.
     * @return The id of the Pokemon this Pokemon would evolve into using
     * a Thunder Stone.
     */
    public int getThunderStoneEvolutionId() {
        return -1;
    }

    /**
     * Return the Pokemon's id that this Pokemon would evolve into using
     * a Dawn Stone. -1 if it doesn't evolve into a Pokemon using a Dawn Stone.
     * @return The id of the Pokemon this Pokemon would evolve into using
     * a Dawn Stone.
     */
    public int getDawnStoneEvolutionId() {
        return -1;
    }

    /**
     * Return the Pokemon's id that this Pokemon would evolve into using
     * a Dusk Stone. -1 if it doesn't evolve into a Pokemon using a Dusk Stone.
     * @return The id of the Pokemon this Pokemon would evolve into using
     * a Dusk Stone.
     */
    public int getDuskStoneEvolutionId() {
        return -1;
    }

    /**
     * Return the Pokemon's id that this Pokemon would evolve into using
     * a Ice Stone. -1 if it doesn't evolve into a Pokemon using a Ice Stone.
     * @return The id of the Pokemon this Pokemon would evolve into using
     * a Ice Stone.
     */
    public int getIceStoneEvolutionId() {
        return -1;
    }

    /**
     * Return the Pokemon's id that this Pokemon would evolve into through
     * a trade. -1 if it doesn't evolve into a Pokemon through a trade.
     * @return The id of the Pokemon this Pokemon would evolve into through
     * a trade.
     */
    public int getRegularTradeEvolutionId() {
        return -1;
    }


}
