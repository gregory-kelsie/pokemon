package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon;

import com.badlogic.gdx.Gdx;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Gregory on 6/11/2017.
 */
public abstract class Pokemon {
    protected int pokemonId;
    protected String name;
    protected Nature nature;
    protected ExpType expType;
    protected Status status;
    protected Status preStatus;
    protected Type typeOne;
    protected Type typeTwo;
    protected int level;
    protected int captureRate;
    protected int currentHealth;
    protected int animationHealth;
    protected int baseExp;
    protected int[] evYield;
    protected Ability ability;
    protected char gender;
    protected int[] ivs;
    protected int[] evs;
    protected int[] baseStats;
    protected String mapIconPath;
    protected String backPath;
    protected String miniPath;
    protected HashMap<Integer, List<Integer>> levelUpSkills;
    protected List<Skill> skills;

    //Battle Variables
    protected boolean flinch;
    protected boolean focused;
    protected boolean wrapped;
    protected int wrapTurns;
    protected boolean fainted;
    private HashMap<Type, Double> resistances;

    //Stage Variables
    protected int attackStage;
    protected int defenseStage;
    protected int specialDefenseStage;
    protected int specialAttackStage;
    protected int speedStage;

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

    //Constants
    protected final int MAX_LEVEL = 100;
    protected final int MIN_LEVEL = 1;
    protected final int MAX_IV = 31;
    protected final int MIN_IV = 1;
    protected final int MAX_EV = 255;
    protected final int MIN_EV = 0;
    protected final int TOTAL_EV = 510;
    protected final int NO_EXP = 0;
    protected final int HEALTH = 0;
    protected final int ATTACK = 1;
    protected final int SPECIAL_ATTACK = 2;
    protected final int DEFENSE = 3;
    protected final int SPECIAL_DEFENSE = 4;
    protected final int SPEED = 5;

    protected final int INITIAL_STAT_STAGE = 0;

    protected final double NORMAL_MULTIPLIER = 1;
    protected final double REDUCED_MULTIPLIER = 0.9;
    protected final double INCREASED_MULTIPLIER = 1.1;

    protected final int PLAYER_NORMAL_X = 122;
    protected final int PLAYER_NORMAL_Y = 1231;
    protected final int FAINTED_PLAYER_Y = 1100;
    protected final int ENEMY_NORMAL_X = 591;
    protected final int ENEMY_NORMAL_Y = 1460;
    protected final int FAINTED_ENEMY_Y = 1300;

    public enum ExpType {
        ERRATIC, FAST, MEDIUM_FAST, MEDIUM_SLOW, SLOW, FLUCTUATING
    }

    public enum Status {
        STATUS_FREE, POISON, BURN, PARALYSIS, FROZEN, SLEEP
    }

    public enum Ability {
        INTIMIDATE, SHED_SKIN, UNNERVE, RUN_AWAY, QUICK_FEET, RATTLED, GUTS, HUSTLE, SNIPER,
        SUPER_LUCK, SWARM, INSOMNIA, INNER_FOCUS, STATIC, KEEN_EYE, TANGLED_FEET, BIG_PECKS,
        LIGHTNINGROD, TORRENT, RAIN_DISH, BLAZE, SOLAR_POWER, OVERGROW, CHLOROPHYLL, SHIELD_DUST,
        POISON_POINT, RIVALRY, ADAPTABILITY, THICK_FAT, DRY_SKIN, HEATPROOF, FILTER, TINTED_LENS,
        SOLID_ROCK
    }

    public enum Type {
        NONE, BUG, DARK, DRAGON, ELECTRIC, FAIRY, FIGHTING, FIRE, FLYING, GHOST, GRASS, GROUND,
        ICE, NORMAL, POISON, PSYCHIC, ROCK, STEEL, WATER
    }

    public Pokemon(int pokemonId, String name, int level, Type typeOne, Type typeTwo, Ability ability, ExpType expType,
                   int baseExp, int[] evYield, int[] baseStats, String mapIconPath, String backPath, String miniPath, int captureRate) {
        this.pokemonId = pokemonId;
        this.name = name;
        this.gender = gender;
        this.level = level;
        this.baseStats = baseStats;
        this.baseExp = baseExp;
        this.evYield = evYield;
        this.expType = expType;
        this.mapIconPath = mapIconPath;
        this.backPath = backPath;
        this.miniPath = miniPath;
        this.typeOne = typeOne;
        this.typeTwo = typeTwo;
        this.ability = ability;
        this.captureRate = captureRate;
        this.fainted = false;
        this.focused = false;
        status = Status.STATUS_FREE;
        preStatus = Status.STATUS_FREE;
        currentExp = NO_EXP;
        displayedExp = NO_EXP;
        levelUpSkills = new HashMap<Integer, List<Integer>>();
        skills = new ArrayList<Skill>();
        resetCoordinates();
        setRandomNature();
        initRandomIVs();
        initBlankEVs();
        initBattleVariables();
        initializeResistances();
    }

    private void resetCoordinates() {
        this.playerX = PLAYER_NORMAL_X;
        this.playerY = PLAYER_NORMAL_Y;
        this.enemyX = ENEMY_NORMAL_X;
        this.enemyY = ENEMY_NORMAL_Y;
    }

    protected abstract void initLevelUpSkills();

    public void addExp(double amt) {
        currentExp += amt;
    }

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

    public int[] getEvYield() {
        return evYield;
    }


    public boolean hasMaxEvs() {
        int sum = getTotalEvs();
        if (sum == TOTAL_EV) {
            return true;
        }
        return false;
    }

    public int getTotalEvs() {
        return evs[0] + evs[1] + evs[2] + evs[3] + evs[4] + evs[5];
    }

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

    public void setExp(int amt) {
        currentExp = amt;
        displayedExp = amt;
    }

    public void transferOverflow() {
        currentExp = NO_EXP;
        displayedExp = NO_EXP;
        currentExp += overflownExp;
        overflownExp = 0;
        if (currentExp > getNextLevelExp()) {
            overflownExp = Math.round(currentExp) - getNextLevelExp();
            currentExp = getNextLevelExp();
        }
    }

    public void levelUp() {

        level = Math.min(100, level + 1);
        currentExp = 0;
    }

    public long getOverflownExp() {
        return overflownExp;
    }

    public double getDisplayedExp() {
        return currentExp;
    }


    protected void initWildSkills() {
        int currentSkill = 0;
        SkillFactory skillFactory = new SkillFactory();
        for (int i = 0; i < level; i++) {
            if (levelUpSkills.containsKey(i)) {
                for (int j = 0; j < levelUpSkills.get(i).size(); j++) {
                    skills.add(currentSkill, skillFactory.createSkill(levelUpSkills.get(i).get(j)));
                    currentSkill++;
                    if (currentSkill == 4) {
                        currentSkill = 0;
                    }
                }
            }
        }
    }

    public HashMap<Integer, List<Integer>> getLevelUpSkills() {
        return levelUpSkills;
    }

    public List<Integer> getCurrentLevelUpSkills() {
        if (levelUpSkills.containsKey(level)) {
            return levelUpSkills.get(level);
        }
        return null;
    }

    public void addMove(Skill newMove) {
        if (skills.size() < 4) {
            skills.add(newMove);
        }
    }
    protected abstract void initGender();

    private void initBattleVariables() {
        resetStages();
        currentHealth = getHealthStat();
        animationHealth = currentHealth;
        initNatureMultipliers();
    }

    public void resetStages() {
        attackStage = INITIAL_STAT_STAGE;
        specialAttackStage = INITIAL_STAT_STAGE;
        defenseStage = INITIAL_STAT_STAGE;
        specialDefenseStage = INITIAL_STAT_STAGE;
        speedStage = INITIAL_STAT_STAGE;
    }

    public void decreaseAttackStage(int amount) {
        attackStage -= amount;
        attackStage = Math.max(attackStage, -6);
    }

    public void decreaseDefenseStage(int amount) {
        defenseStage -= amount;
        defenseStage = Math.max(defenseStage, -6);
    }
    public void decreaseSpAttackStage(int amount) {
        specialAttackStage -= amount;
        specialAttackStage = Math.max(specialAttackStage, -6);
    }
    public void decreaseSpDefenseStage(int amount) {
        specialDefenseStage -= amount;
        specialDefenseStage = Math.max(specialDefenseStage, -6);
    }
    public void decreaseSpeedStage(int amount) {
        speedStage -= amount;
        speedStage = Math.max(speedStage, -6);
    }

    public void increaseAttackStage(int amount) {
        attackStage += amount;
        attackStage = Math.max(attackStage, 6);
    }

    public void increaseDefenseStage(int amount) {
        defenseStage += amount;
        defenseStage = Math.max(defenseStage, 6);
    }
    public void increaseSpAttackStage(int amount) {
        specialAttackStage += amount;
        specialAttackStage = Math.max(specialAttackStage, 6);
    }
    public void increaseSpDefenseStage(int amount) {
        specialDefenseStage += amount;
        specialDefenseStage = Math.max(specialDefenseStage, 6);
    }
    public void increaseSpeedStage(int amount) {
        speedStage += amount;
        speedStage = Math.min(speedStage, 6);
    }

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

    private void initRandomIVs() {
        ivs = new int[6];
        ivs[HEALTH] = createRandomIV();
        ivs[ATTACK] = createRandomIV();
        ivs[SPECIAL_ATTACK] = createRandomIV();
        ivs[DEFENSE] = createRandomIV();
        ivs[SPECIAL_DEFENSE] = createRandomIV();
        ivs[SPEED] = createRandomIV();
    }

    public int getHealthIV() {
        return ivs[HEALTH];
    }

    public int getAttackIV() {
        return ivs[ATTACK];
    }

    public int getDefenseIV() {
        return ivs[DEFENSE];
    }

    public int getSpAttackIV() {
        return ivs[SPECIAL_ATTACK];
    }

    public int getSpDefenseIV() {
        return ivs[SPECIAL_DEFENSE];
    }

    public int getSpeedIV() {
        return ivs[SPEED];
    }

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

    public HashMap<Type, Double> getResistances() {
        return resistances;
    }

    private int createRandomIV() {
        return (int)(Math.round(Math.random() * 30)) + 1;
    }

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

    public int getHealthEV() {
        return evs[HEALTH];
    }

    public int getAttackEV() {
        return evs[ATTACK];
    }

    public int getDefenseEV() {
        return evs[DEFENSE];
    }

    public int getSpAttackEV() {
        return evs[SPECIAL_ATTACK];
    }

    public int getSpDefenseEV() {
        return evs[SPECIAL_DEFENSE];
    }

    public int getSpeedEV() {
        return evs[SPEED];
    }

    private void setRandomNature() {
        Nature[] natureList = Nature.values();
        int value = (int)Math.round(Math.random() * (natureList.length - 1));
        nature = natureList[value];
    }

    public int getCaptureRate() { return captureRate; }
    public int getBaseStatHealth() {
        return baseStats[HEALTH];
    }

    public int getBaseStatAttack() {
        return baseStats[ATTACK];
    }

    public int getBaseStatSpeicialAttack() {
        return baseStats[SPECIAL_ATTACK];
    }

    public int getBaseStatDefense() {
        return baseStats[DEFENSE];
    }

    public int getBaseStatSpecialDefense() {
        return baseStats[SPECIAL_DEFENSE];
    }

    public int getBaseStatSpeed() {
        return baseStats[SPEED];
    }

    public int getHealthStat() {
        return (int)Math.round(((2 * baseStats[HEALTH]+ ivs[HEALTH] + (evs[HEALTH] / 4.0) + 100) * level) / 100.0) + 10;
    }

    public int getAttackStat() {
        return (int)Math.round(((((2 * baseStats[ATTACK] + ivs[ATTACK] + (evs[ATTACK] / 4.0)) * level)
                / 100.0) + 5) * natureAttackMultiplier);
    }

    public int getSpecialAttackStat() {
        return (int)Math.round(((((2 * baseStats[SPECIAL_ATTACK] + ivs[SPECIAL_ATTACK] + (evs[SPECIAL_ATTACK] / 4.0)) * level)
                / 100.0) + 5) * natureSpecialAttackMultiplier);
    }

    public int getDefenseStat() {
        return (int)Math.round(((((2 * baseStats[DEFENSE] + ivs[DEFENSE] + (evs[DEFENSE] / 4.0)) * level)
                / 100.0) + 5) * natureDefenseMultiplier);
    }

    public int getSpecialDefenseStat() {
        return (int)Math.round(((((2 * baseStats[SPECIAL_DEFENSE] + ivs[SPECIAL_DEFENSE] + (evs[SPECIAL_DEFENSE] / 4.0)) * level)
                / 100.0) + 5) * natureSpecialDefenseMultiplier);
    }

    public int getSpeedStat() {
        return (int)Math.round(((((2 * baseStats[SPEED] + ivs[SPEED] + (evs[SPEED] / 4.0)) * level)
                / 100.0) + 5) * natureSpeedMultiplier);
    }

    public int getTotalExp(int level) {
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
        else { //expType == ExpType.FAST
            return getFastTotalExp(level);
        }
    }

    public int getNextLevelExp() {
        if (level == 100) {
            return 0;
        } else {
            return getTotalExp(level + 1) - getTotalExp(level);
        }
    }

    public int getAttackStage() {
        return attackStage;
    }

    public int getDefenseStage() {
        return defenseStage;
    }

    public int getSpecialAttackStage() {
        return specialAttackStage;
    }

    public int getSpecialDefenseStage() {
        return specialDefenseStage;
    }

    public int getSpeedStage() {
        return speedStage;
    }

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

    private int getMediumFastTotalExp(int level) {
        return (int)Math.round(Math.pow(level, 3));
    }

    private int getMediumSlowTotalExp(int level) {
        if (level == 1) {
            return 0;
        }
        else {
            return (int)Math.round((6/5.0 * Math.pow(level, 3)) - (15 * Math.pow(level, 2)) + (100 * level) - 140);
        }
    }

    private int getSlowTotalExp(int level) {
        return (int)Math.round(5 * Math.pow(level, 3) / 4.0);
    }

    private int getFastTotalExp(int level) {
        return (int)Math.round(4 * Math.pow(level, 3) / 5.0);
    }

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

    public int getBaseExp() {
        return baseExp;
    }

    public void fullyHeal() {
        currentHealth = getHealthStat();
        animationHealth = currentHealth;
        fainted = false;
    }
    public int getPlayerX() { return playerX; }
    public int getPlayerNormalX() { return PLAYER_NORMAL_X; }
    public void setPlayerX(int amt) { playerX = amt; }
    public int getPlayerY() { return playerY; }
    public int getPlayerNormalY() { return PLAYER_NORMAL_Y; }
    public int getFaintedPlayerY() { return FAINTED_PLAYER_Y; }
    public int getFaintedEnemyY() { return FAINTED_ENEMY_Y; }
    public void setFaint(boolean fainted) {
        this.fainted = fainted;
    }
    public boolean isFainted() {
        return fainted;
    }
    public void setPlayerY(int amt) { playerY = amt; }
    public int getEnemyX() { return enemyX; }
    public void setEnemyX(int amt) { enemyX = amt; }
    public int getEnemyY() { return enemyY; }
    public void setEnemyY(int amt) { enemyY = amt; }
    public List<Skill> getSkills() { return skills; }
    public String getMapIconPath() {
        return mapIconPath;
    }
    public String getBackPath() { return backPath; }
    public String getMiniIconPath() {
        return miniPath;
    }
    public boolean isFocused() { return focused; }
    public String getName() { return name; }
    public int getLevel() { return level; }
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
            default:
                return "Ability Error";

        }
    }
    public Ability getAbility() { return ability; }
    public int getCurrentHealth() { return currentHealth; }
    public Status getStatus() { return status; }
    public boolean isStatused() {
        if (status != Status.STATUS_FREE) {
            return true;
        } else {
            return false;
        }
    }
    public void setStatus(Status newStatus) {
        this.status = newStatus;
    }
    public void setPreStatus(Status newStatus) { this.preStatus = newStatus; }
    public Type getTypeOne() { return typeOne; }
    public Type getTypeTwo() { return typeTwo; }
    public int getId() { return pokemonId; }
    public boolean matchingAnimationHealth() {
        if (animationHealth == currentHealth) {
            return true;
        }
        return false;
    }
    public int getAnimationHealth() {
        return animationHealth;
    }
    public void subtractAnimationHealth(int amt) {
        animationHealth -= amt;
        animationHealth = Math.max(currentHealth, animationHealth);
    }
    public void addAnimationHealth(int amt) {
        animationHealth += amt;
        animationHealth = Math.min(currentHealth, animationHealth);
    }
    public void adjustAnimationHealth(int rate) {
        if (animationHealth > currentHealth) {
            subtractAnimationHealth(rate);
        } else if (animationHealth < currentHealth) {
            addAnimationHealth(rate);
        }
    }
    public void subtractHealth(int amt) {
        currentHealth = Math.max(0, currentHealth  - amt);
        Gdx.app.log("Subtract", "" + amt);
    }

    public void transferPreStatus() {
        if (preStatus != Status.STATUS_FREE) {
            status = preStatus;
            preStatus = Status.STATUS_FREE;
        }
    }
}
