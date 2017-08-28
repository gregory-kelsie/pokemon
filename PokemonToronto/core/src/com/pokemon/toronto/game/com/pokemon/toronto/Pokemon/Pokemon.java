package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.badlogic.gdx.Gdx;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;
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
    protected Nature nature;
    protected ExpType expType;
    protected Ability ability;
    protected char gender;
    protected Type typeOne;
    protected Type typeTwo;
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
    protected HashMap<Integer, List<Integer>> levelUpSkills;
    protected List<Integer> evolutionSkills;
    protected List<Skill> skills;

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
    private final int TOTAL_PERISH_SONG_TIME = 3;

    private boolean witnessedFutureSight;
    private int futureSightTime;
    private final int TOTAL_FUTURE_SIGHT_TIME = 2;

    private boolean witnessedDoomDesire;
    private int doomDesireTime;
    private final int TOTAL_DOOM_DESIRE_TIME = 2;

    private boolean envelopedInAquaRing;
    private boolean isIngrained;
    private boolean isLeechSeeded;
    private boolean hasNightmares;

    private int confusionTime;
    private final int NOT_CONFUSED = 0;
    private boolean confused;

    private int sleepTime;

    private Skill outrageSkill;
    private int outrageTurns;

    private Skill nextTurnSkill;
    private boolean flying; //Fly
    private boolean underground; //Dig

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
    protected final int SPECIAL_ATTACK = 2;
    protected final int DEFENSE = 3;
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
        STATUS_FREE, POISON, BURN, PARALYSIS, FROZEN, SLEEP
    }

    /**
     * Pokemon abilities
     */
    public enum Ability {
        INTIMIDATE, SHED_SKIN, UNNERVE, RUN_AWAY, QUICK_FEET, RATTLED, GUTS, HUSTLE, SNIPER,
        SUPER_LUCK, SWARM, INSOMNIA, INNER_FOCUS, STATIC, KEEN_EYE, TANGLED_FEET, BIG_PECKS,
        LIGHTNINGROD, TORRENT, RAIN_DISH, BLAZE, SOLAR_POWER, OVERGROW, CHLOROPHYLL, SHIELD_DUST,
        POISON_POINT, RIVALRY, ADAPTABILITY, THICK_FAT, DRY_SKIN, HEATPROOF, FILTER, TINTED_LENS,
        SOLID_ROCK, POISON_TOUCH, FLAME_BODY, EFFECT_SPORE, OWN_TEMPO, BATTLE_ARMOR, SHELL_ARMOR,
        ICE_BODY, SNOW_CLOAK, MAGIC_GUARD, OVERCOAT, SAND_FORCE, SAND_RUSH, SAND_VEIL, HYDRATION,
        SWIFT_SWIM, DAMP, DRIZZLE, SAND_STREAM, DROUGHT, SNOW_WARNING, CLOUD_NINE, MOLD_BREAKER,
        PRESSURE, MOTOR_DRIVE, WATER_ABSORB, VOLT_ABSORB, LEVITATE, LEAF_GUARD, IMMUNITY
    }

    /**
     * Pokemon types, Fire, Grass, Water etc.
     * None is also a type when the Pokemon doesn't have a second type.
     */
    public enum Type {
        NONE, BUG, DARK, DRAGON, ELECTRIC, FAIRY, FIGHTING, FIRE, FLYING, GHOST, GRASS, GROUND,
        ICE, NORMAL, POISON, PSYCHIC, ROCK, STEEL, WATER
    }

    /**
     * Create a fresh Pokemon given the parameters.
     * Fresh means that there are no current evs
     * @param pokemonId The Pokemon id, 1 is Bulbasaur, 2 is Ivysaur etc.
     * @param name The name of the Pokemon.
     * @param level The Pokemon's level.
     * @param typeOne The Pokemon's type.
     * @param typeTwo The Pokemon's second type, could be NONE
     * @param ability The Pokemon's ability.
     * @param expType The Pokemon's exp growth type
     * @param baseExp The base exp the Pokemon yields.
     * @param evYield The ev yield for the Pokemon.
     * @param baseStats The Pokemon's base stats.
     * @param mapIconPath The basic Pokemon image path.
     * @param backPath The back of the Pokemon image path.
     * @param miniPath The mini Pokemon image path.
     * @param captureRate The Pokemon's capture rate.
     */
    public Pokemon(int pokemonId, String name, int level, Type typeOne, Type typeTwo, Ability ability, ExpType expType,
                   int baseExp, int[] evYield, int[] baseStats, String mapIconPath, String backPath, String miniPath, String cryPath, int captureRate) {
        this.pokemonId = pokemonId;
        this.name = name;
        this.level = level;
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
        this.ability = ability;
        this.captureRate = captureRate;
        this.fainted = false;
        status = Status.STATUS_FREE;
        preStatus = Status.STATUS_FREE;
        currentExp = NO_EXP;
        displayedExp = NO_EXP;
        levelUpSkills = new HashMap<Integer, List<Integer>>();
        evolutionSkills = new ArrayList<Integer>();
        skills = new ArrayList<Skill>();
        justLeveled = false;
        resetCoordinates();
        setRandomNature();
        initRandomIVs();
        initBlankEVs();
        initBattleVariables();
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
        currentHealth = getHealthStat();
        animationHealth = currentHealth;
        initNatureMultipliers();
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
        isLeechSeeded = false;
        hasNightmares = false;
        tauntTime = -1;
        embargoTime = -1;
        encoreTime = -1;
        encoreSlot = -1;
        healBlockTime = -1;
        telekinesisTime = -1;
        magnetRisenTime = -1;
        futureSightTime = -1;
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
     * Return whether or not the Pokemon just received
     * the yawn effect.
     * @return Whether or not the Pokemon just received
     * the yawn effect.
     */
    public boolean isYawned() {
        return justReceivedYawn;
    }

    /**
     * Use Nightmare on the Pokemon.
     */
    public void receiveNightmare() {
        hasNightmares = true;
    }

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
    public void receiveFutureSight() {
        witnessedFutureSight = true;
        futureSightTime = TOTAL_FUTURE_SIGHT_TIME;
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
     * Set the Pokemon to receive Doom Desire damage after
     * a few turns.
     */
    public void receiveDoomDesire() {
        witnessedDoomDesire = true;
        doomDesireTime = TOTAL_DOOM_DESIRE_TIME;
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


    /**
     * Put the Pokemon to sleep and give it a random sleep time.
     */
    public void induceSleep() {
        preStatus = Status.SLEEP;
        double rand = Math.random();
        if (rand <= .33) {
            sleepTime = 1;
        } else if (rand <= .67) {
            sleepTime = 2;
        } else {
            sleepTime = 3;
        }
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
     * Reset the coordaintes of the Pokemon, both enemy and
     * player positions to their original spots.
     */
    private void resetCoordinates() {
        this.playerX = PLAYER_NORMAL_X;
        this.playerY = PLAYER_NORMAL_Y;
        this.enemyX = ENEMY_NORMAL_X;
        this.enemyY = ENEMY_NORMAL_Y;
    }

    /**
     * Init the Pokemon's level up skills.
     */
    protected abstract void initLevelUpSkills();

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
     * @return The amount of exp the Pokemon will give.
     */
    public long calculateExp(int numberOfBattleParticipants) {
        double a = 1; //Wild pokemon 1, trainer 1.5
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
     * Initialize the moves the wild version of this Pokemon would have.
     */
    protected void initWildSkills() {
        int currentSkill = 0;
        SkillFactory skillFactory = new SkillFactory();
        for (int i = 0; i <= level; i++) {
            //Check if the Pokemon learns a move at the level i
            if (levelUpSkills.containsKey(i)) {
                for (int j = 0; j < levelUpSkills.get(i).size(); j++) {
                    skills.add(currentSkill, skillFactory.createSkill(levelUpSkills.get(i).get(j)));
                    currentSkill++;
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
     * Add the specified skills in the arguments to the Pokemon's skillset.
     * @param firstSkill The skill to be added in the first slot.
     * @param secondSkill The skill to be added in the second slot.
     * @param thirdSkill The skill to be added in the third slot.
     * @param fourthSkill The skill to be added in the fourth slot.
     */
    protected void addSkills(Skill firstSkill, Skill secondSkill, Skill thirdSkill,
                             Skill fourthSkill) {
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
        if (ability == Ability.BIG_PECKS) {
            return true;
        }
        return false;
    }

    /**
     * Return whether or not the Pokemon's accuracy can be lowered
     * due to their ability.
     * @return Whether or not the Pokemon's accuracy can be lowered
     * due to their ability.
     */
    public boolean isProtectedByAccuracyLoweringEffects() {
        if (ability == Ability.KEEN_EYE) {
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
     * Initialize the Nature multipliers
     */
    private void initNatureMultipliers() {
        natureAttackMultiplier = NORMAL_MULTIPLIER;
        natureDefenseMultiplier = NORMAL_MULTIPLIER;
        natureSpecialAttackMultiplier = NORMAL_MULTIPLIER;
        natureSpecialDefenseMultiplier = NORMAL_MULTIPLIER;
        natureSpeedMultiplier = NORMAL_MULTIPLIER;
        //Attack Bonus
        if(nature  == Nature.LONELY) { natureAttackMultiplier = INCREASED_MULTIPLIER;
            natureDefenseMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == Nature.ADAMANT) { natureAttackMultiplier = INCREASED_MULTIPLIER;
            natureSpecialAttackMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == Nature.NAUGHTY) { natureAttackMultiplier = INCREASED_MULTIPLIER;
            natureSpecialDefenseMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == Nature.BRAVE) { natureAttackMultiplier = INCREASED_MULTIPLIER;
            natureSpeedMultiplier = REDUCED_MULTIPLIER; }
        //Defense Bonus
        else if(nature  == Nature.BOLD) { natureDefenseMultiplier = INCREASED_MULTIPLIER;
            natureAttackMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == Nature.IMPISH) { natureDefenseMultiplier = INCREASED_MULTIPLIER;
            natureSpecialAttackMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == Nature.LAX) { natureDefenseMultiplier = INCREASED_MULTIPLIER;
            natureSpecialDefenseMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == Nature.RELAXED) { natureDefenseMultiplier = INCREASED_MULTIPLIER;
            natureSpeedMultiplier = REDUCED_MULTIPLIER; }
        //Sp Attack Bonus
        else if(nature  == Nature.MODEST) { natureSpecialAttackMultiplier = INCREASED_MULTIPLIER;
            natureAttackMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == Nature.MILD) { natureSpecialAttackMultiplier = INCREASED_MULTIPLIER;
            natureDefenseMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == Nature.RASH) { natureSpecialAttackMultiplier = INCREASED_MULTIPLIER;
            natureSpecialDefenseMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == Nature.QUIET) { natureSpecialAttackMultiplier = INCREASED_MULTIPLIER;
            natureSpeedMultiplier = REDUCED_MULTIPLIER; }
        //Sp Defense Bonus
        else if(nature  == Nature.CALM) { natureSpecialDefenseMultiplier = INCREASED_MULTIPLIER;
            natureAttackMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == Nature.GENTLE) { natureSpecialDefenseMultiplier = INCREASED_MULTIPLIER;
            natureDefenseMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == Nature.CAREFUL) { natureSpecialDefenseMultiplier = INCREASED_MULTIPLIER;
            natureSpecialAttackMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == Nature.SASSY) { natureSpecialDefenseMultiplier = INCREASED_MULTIPLIER;
            natureSpeedMultiplier = REDUCED_MULTIPLIER; }
        //Speed Bonus
        else if(nature  == Nature.TIMID) { natureSpeedMultiplier = INCREASED_MULTIPLIER;
            natureAttackMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == Nature.HASTY) { natureSpeedMultiplier = INCREASED_MULTIPLIER;
            natureDefenseMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == Nature.JOLLY) { natureSpeedMultiplier = INCREASED_MULTIPLIER;
            natureSpecialAttackMultiplier = REDUCED_MULTIPLIER; }
        else if(nature  == Nature.NAIVE) { natureSpeedMultiplier = INCREASED_MULTIPLIER;
            natureSpecialDefenseMultiplier = REDUCED_MULTIPLIER; }
    }

    /**
     * Create random IVs for the Pokemon
     */
    private void initRandomIVs() {
        ivs = new int[6];
        ivs[HEALTH] = createRandomIV();
        ivs[ATTACK] = createRandomIV();
        ivs[SPECIAL_ATTACK] = createRandomIV();
        ivs[DEFENSE] = createRandomIV();
        ivs[SPECIAL_DEFENSE] = createRandomIV();
        ivs[SPEED] = createRandomIV();
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
        initializeResistances(typeOne);
        if (typeTwo != Type.NONE) {
            initializeResistances(typeTwo);
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
            resistances.put(Pokemon.Type.FIGHTING, 
                    resistances.get(Pokemon.Type.FIGHTING)  * 0.5);
            resistances.put(Pokemon.Type.POISON, resistances.get(Pokemon.Type.POISON) * 0.5);
            resistances.put(Pokemon.Type.GROUND, resistances.get(Pokemon.Type.GROUND) * 2);
            resistances.put(Pokemon.Type.BUG, resistances.get(Pokemon.Type.BUG) * 0.5);
            resistances.put(Pokemon.Type.GRASS, resistances.get(Pokemon.Type.GRASS) * 0.5);
            resistances.put(Pokemon.Type.PSYCHIC, resistances.get(Pokemon.Type.PSYCHIC) * 2);
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
        } else if (type == Pokemon.Type.FIRE) {
            resistances.put(Pokemon.Type.GROUND, resistances.get(Pokemon.Type.GROUND) * 2);
            resistances.put(Pokemon.Type.ROCK, resistances.get(Pokemon.Type.ROCK) * 2);
            resistances.put(Pokemon.Type.BUG, resistances.get(Pokemon.Type.BUG) * 0.5);
            resistances.put(Pokemon.Type.STEEL, resistances.get(Pokemon.Type.STEEL) * 0.5);
            resistances.put(Pokemon.Type.FIRE, resistances.get(Pokemon.Type.FIRE) * 0.5);
            resistances.put(Pokemon.Type.WATER, resistances.get(Pokemon.Type.WATER) * 2);
            resistances.put(Pokemon.Type.GRASS, resistances.get(Pokemon.Type.GRASS) * 0.5);
            resistances.put(Pokemon.Type.ICE, resistances.get(Pokemon.Type.ICE) * 0.5);
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
    private int createRandomIV() {
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
        Nature[] natureList = Nature.values();
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
        return (int)Math.round(((2 * baseStats[HEALTH]+ ivs[HEALTH] + (evs[HEALTH] / 4.0) + 100) * level) / 100.0) + 10;
    }

    /**
     * Return the Pokemon's attack stat
     * @return Attack Stat
     */
    public int getAttackStat() {
        return (int)Math.round(((((2 * baseStats[ATTACK] + ivs[ATTACK] + (evs[ATTACK] / 4.0)) * level)
                / 100.0) + 5) * natureAttackMultiplier);
    }

    /**
     * Return the Pokemon's special attack stat.
     * @return Special Attack Stat
     */
    public int getSpecialAttackStat() {
        return (int)Math.round(((((2 * baseStats[SPECIAL_ATTACK] + ivs[SPECIAL_ATTACK] + (evs[SPECIAL_ATTACK] / 4.0)) * level)
                / 100.0) + 5) * natureSpecialAttackMultiplier);
    }

    /**
     * Return the Pokemon's defense stat.
     * @return Defense Stat
     */
    public int getDefenseStat() {
        return (int)Math.round(((((2 * baseStats[DEFENSE] + ivs[DEFENSE] + (evs[DEFENSE] / 4.0)) * level)
                / 100.0) + 5) * natureDefenseMultiplier);
    }

    /**
     * Return the Pokemon's special defense stat.
     * @return Special Defense Stat
     */
    public int getSpecialDefenseStat() {
        return (int)Math.round(((((2 * baseStats[SPECIAL_DEFENSE] + ivs[SPECIAL_DEFENSE] + (evs[SPECIAL_DEFENSE] / 4.0)) * level)
                / 100.0) + 5) * natureSpecialDefenseMultiplier);
    }

    /**
     * Return the Pokemon's speed stat.
     * @return Speed Stat
     */
    public int getSpeedStat() {
        return (int)Math.round(((((2 * baseStats[SPEED] + ivs[SPEED] + (evs[SPEED] / 4.0)) * level)
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

    public AbsorbResult getAbsorbResults(Skill usedSkill) {
        if (usedSkill.getType() == Type.ELECTRIC) {
            if (ability == Ability.LIGHTNINGROD) {
                getLightningRodAbsorbEffect();
            } else if (ability == Ability.MOTOR_DRIVE) {
                return getMotorDriveAbsorbEffect();
            } else if (ability == Ability.VOLT_ABSORB) {
                return getVoltAbsorbAbsorbEffect();
            }
        } else if (usedSkill.getType() == Type.WATER) {
            if (ability == Ability.DRY_SKIN) {
                return getDrySkinAbsorbEffect();
            } else if (ability == Ability.WATER_ABSORB) {
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
    public String getAbilityString() {
        switch(ability) {
            case INTIMIDATE:
                return "Intimidate";
            case SHED_SKIN:
                return "Shed Skin";
            case UNNERVE:
                return "Unnerve";
            case RUN_AWAY:
                return "Run Away";
            case QUICK_FEET:
                return "Quick Feet";
            case RATTLED:
                return "Rattled";
            case GUTS:
                return "Guts";
            case HUSTLE:
                return "Hustle";
            case SNIPER:
                return "Sniper";
            case SUPER_LUCK:
                return "Super Luck";
            case SWARM:
                return "Swarm";
            case INSOMNIA:
                return "Insomnia";
            case INNER_FOCUS:
                return "Inner Focus";
            case STATIC:
                return "Static";
            case BIG_PECKS:
                return "Big Pecks";
            case TANGLED_FEET:
                return "Tangled Feet";
            case KEEN_EYE:
                return "Keen Eye";
            case LIGHTNINGROD:
                return "Lightning Rod";
            case TORRENT:
                return "Torrent";
            case RAIN_DISH:
                return "Rain Dish";
            case BLAZE:
                return "Blaze";
            case SOLAR_POWER:
                return "Solar Power";
            case OVERGROW:
                return "Overgrow";
            case CHLOROPHYLL:
                return "Chlorophyll";
            case SHIELD_DUST:
                return "Shield Dust";
            case POISON_POINT:
                return "Poison Point";
            case RIVALRY:
                return "Rivalry";
            case ADAPTABILITY:
                return "Adaptability";
            case THICK_FAT:
                return "Thick Fat";
            case DRY_SKIN:
                return "Dry Skin";
            case HEATPROOF:
                return "Heatproof";
            case FILTER:
                return "Filter";
            case SOLID_ROCK:
                return "Solid Rock";
            case TINTED_LENS:
                return "Tinted Lens";
            case POISON_TOUCH:
                return "Poison Touch";
            case FLAME_BODY:
                return "Flame Body";
            case EFFECT_SPORE:
                return "Effect Spore";
            case OWN_TEMPO:
                return "Own Tempo";
            case BATTLE_ARMOR:
                return "Battle Armor";
            case SHELL_ARMOR:
                return "Shell Armor";
            case ICE_BODY:
                return "Ice Body";
            case SNOW_CLOAK:
                return "Snow Cloak";
            case MAGIC_GUARD:
                return "Magic Guard";
            case OVERCOAT:
                return "Overcoat";
            case SAND_FORCE:
                return "Sand Force";
            case SAND_RUSH:
                return "Sand Rush";
            case SAND_VEIL:
                return "Sand Veil";
            case HYDRATION:
                return "Hydration";
            case SWIFT_SWIM:
                return "Swift Swim";
            case DAMP:
                return "Damp";
            case DRIZZLE:
                return "Drizzle";
            case DROUGHT:
                return "Drought";
            case SAND_STREAM:
                return "Sand Stream";
            case SNOW_WARNING:
                return "Snow Warning";
            case MOLD_BREAKER:
                return "Mold Breaker";
            case CLOUD_NINE:
                return "Cloud Nine";
            case PRESSURE:
                return "Pressure";
            case MOTOR_DRIVE:
                return "Motor Drive";
            case WATER_ABSORB:
                return "Water Absorb";
            case VOLT_ABSORB:
                return "Volt Absorb";
            case LEVITATE:
                return "Levitate";
            case IMMUNITY:
                return "Immunity";
            case LEAF_GUARD:
                return "Leaf Guard";

            default:
                return "Ability Error";

        }
    }

    /**
     * Return the Pokemon's ability
     * @return The Pokemon's ability
     */
    public Ability getAbility() { return ability; }

    /**
     * Return the Pokemon's nature.
     * @return The Pokemon's nature.
     */
    public Nature getNature() { return nature; }

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
            status = preStatus;
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
     * Return the Pokemon's id that this Pokemon would evolve into through
     * a trade. -1 if it doesn't evolve into a Pokemon through a trade.
     * @return The id of the Pokemon this Pokemon would evolve into through
     * a trade.
     */
    public int getRegularTradeEvolutionId() {
        return -1;
    }


}
