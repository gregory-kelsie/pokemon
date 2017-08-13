package com.pokemon.toronto.game.com.pokemon.toronto.skill;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;

import java.util.List;

/**
 * Created by Gregory on 6/15/2017.
 */
public abstract class Skill {

    /**
     * An enum for Skill Categories
     * Physical, Special or Misc
     */
    public enum SkillCategory {
        PHYSICAL, SPECIAL, MISC
    }

    //Constants
    protected final int MIN_PP = 0;

    //Instance Variables
    protected String name;
    protected int maxPP;
    protected int currentPP;
    protected Pokemon.Type type;
    protected SkillCategory category;
    protected int priority;
    private int accuracy;
    private boolean targetsEnemy;
    protected boolean makesPhysicalContact;
    protected boolean damagesEnemy;

    //Multi-Hit Move Variables
    protected boolean isMultiStrikeMove;
    protected int strikesLeft;
    protected int damageTally; //Counter to tally up damage.

    /**
     * Create a Skill.
     * @param name The skill's name
     * @param maxPP The maximum PP for the skill
     * @param type The skill's type.
     * @param category The skill's category (physical, special or misc)
     * @param accuracy The accuracy level for the skill.
     */
    public Skill(String name, int maxPP, Pokemon.Type type, SkillCategory category, int accuracy) {
        this.name = name;
        this.maxPP = maxPP;
        this.currentPP = maxPP;
        this.type = type;
        this.category = category;
        priority = 0;
        this.accuracy = accuracy;
        targetsEnemy = true; //default
        makesPhysicalContact = false;
        damagesEnemy = false;
        isMultiStrikeMove = false;
        strikesLeft = -1;
        damageTally = 0;
    }

    /**
     * Return whether or not the skill deals damage to the
     * enemy Pokemon.
     * @return Whether or not the skill deals damage to the enemy.
     */
    public boolean doesDamageToEnemy() {
        return damagesEnemy;
    }

    /**
     * Return the base accuracy for the skill.
     * @return The skill's accuracy.
     */
    public int getAccuracy() {
        return accuracy;
    }

    /**
     * Return the accuracy modifier for the skill.
     * Ex: Accuracy 95 has a modifier of 0.95
     * @return The accuracy modifier for the skill.
     */
    public double getAccuracyMod() {
        return accuracy / 100.0;
    }

    /**
     * Return the skill's priority.
     * @return The skill's priority.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Set the skill's priority to priority.
     * @param priority The new skill priority.
     */
    protected void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Return the name of the skill.
     * @return The skill name.
     */
    public String getName() {
        return name;
    }


    /**
     * Return the maximum PP for the skill.
     * @return The skill's maximum PP.
     */
    public int getMaxPP() {
        return maxPP;
    }


    /**
     * Return the skill's current PP
     * @return The skill's current PP.
     */
    public int getCurrentPP() {
        return currentPP;
    }

    /**
     * Decrease the skill's current PP by 1
     */
    public void decreasePP() {
        currentPP--;
        currentPP = Math.max(currentPP, MIN_PP);
    }

    /**
     * Decrease the skill's current PP by an amount.
     * @param amount The amount to decrease the current PP by.
     */
    public void decreasePP(int amount) {
        currentPP -= amount;
        currentPP = Math.max(currentPP, MIN_PP);
    }

    /**
     * Increase the skill's current PP by 1.
     */
    public void increasePP() {
        currentPP++;
        currentPP = Math.min(currentPP, maxPP);
    }

    /**
     * Increase the skill's current PP by an amount.
     * @param amount The amount to increase the current PP by.
     */
    public void increasePP(int amount) {
        currentPP += amount;
        currentPP = Math.min(currentPP, maxPP);
    }

    /**
     * Set the current PP to the total amount.
     */
    public void setFullPP() {
        currentPP = maxPP;
    }


    /**
     * Return the type of the skill.
     * @return The skill's type (Fire, Water Grass etc)
     */
    public Pokemon.Type getType() {
        return type;
    }

    /**
     * Use the skill on an enemy pokemon.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @return A List of a List of Strings that display the result of
     * using the move. The first list displays misses, and the second
     * list displays the rest (crit, effectiveness, faints etc)
     */
    public List<List<String>> use(Pokemon skillUser, Pokemon enemyPokemon, Field field) {
        return null;
    }

    /**
     * Return whether or not the move will hit the enemy.
     * @param skillUser The Pokemon using the skill.
     * @param enemyPokemon The Pokemon receiving the skill.
     * @return Whether or not the skill hits the enemy.
     */
    public boolean willHitEnemy(Pokemon skillUser, Pokemon enemyPokemon) {
        if (accuracy != -1) {
            //Init Modifiers
            int accuracyStage = skillUser.getAccuracyStage();
            double attackerAccuracyMod = skillUser.getAccuracyModifier(accuracyStage);
            int evasionStage = enemyPokemon.getEvasionStage();
            double enemyEvasionMod = enemyPokemon.getEvasionModifier(evasionStage);
            double result = getAccuracyMod() * attackerAccuracyMod * enemyEvasionMod;

            //Check if hit.
            double rand = Math.random();
            if (rand > result) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    /**
     * Return whether or not the skill will fail.
     * @param skillUser The skill's user.
     * @param enemyPokemon The Pokemon on the receiving end.
     * @return Whether or not the skill will fail.
     */
    public boolean willFail(Pokemon skillUser, Pokemon enemyPokemon) {
        return false;
    }

    /**
     * Return whether or not the skill targets the enemy.
     * For example, swords dance targets self, tackle targets enemy.
     * @return Whether or not the skill targets the enemy.
     */
    public boolean targetsEnemy() {
        return targetsEnemy;
    }

    /**
     * Return whether or not the skill makes physical contact with the enemy.
     * @return Whether or not the skill makes physical contact with the
     * enemy.
     */
    public boolean makesPhysicalContact() {
        if (makesPhysicalContact) {
            return true;
        }
        return false;
    }

    /**
     * Return the number of strikes left for a multi-hit move.
     * @return The number of strikes left for a multi-hit move.
     * -1 for non multi strike moves.
     */
    public int getStrikesLeft() {
        return strikesLeft;
    }

    /**
     * Return the animation of the Skill
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return The skill animation.
     */
    public abstract SkillAnimation getAnimation(boolean userAnimation);
}
