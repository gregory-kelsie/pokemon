package com.pokemon.toronto.game.com.pokemon.toronto.skill;

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

    /**
     * Create a Skill.
     * @param name The skill's name
     * @param maxPP The maximum PP for the skill
     * @param type The skill's type.
     * @param category The skill's category (physical, special or misc)
     */
    public Skill(String name, int maxPP, Pokemon.Type type, SkillCategory category) {
        this.name = name;
        this.maxPP = maxPP;
        this.currentPP = maxPP;
        this.type = type;
        this.category = category;
        priority = 0;
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
    public List<List<String>> use(Pokemon skillUser, Pokemon enemyPokemon) {
        return null;
    }

    /**
     * Return the animation of the Skill
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return The skill animation.
     */
    public abstract SkillAnimation getAnimation(boolean userAnimation);
}
