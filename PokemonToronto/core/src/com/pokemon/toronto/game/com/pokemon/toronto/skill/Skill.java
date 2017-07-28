package com.pokemon.toronto.game.com.pokemon.toronto.skill;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;

import java.util.List;

/**
 * Created by Gregory on 6/15/2017.
 */
public abstract class Skill {

    public enum SkillCategory {
        PHYSICAL, SPECIAL, MISC
    }
    protected String name;
    protected int maxPP;
    protected final int MIN_PP = 0;
    protected int currentPP;
    protected Pokemon.Type type;
    protected SkillCategory category;
    protected int priority;

    public Skill(String name, int maxPP, Pokemon.Type type, SkillCategory category) {
        this.name = name;
        this.maxPP = maxPP;
        this.currentPP = maxPP;
        this.type = type;
        this.category = category;
        priority = 0;
    }

    public int getPriority() {
        return priority;
    }

    protected void setPriority(int priority) {
        this.priority = priority;
    }
    public String getName() {
        return name;
    }

    public int getMaxPP() {
        return maxPP;
    }

    public int getCurrentPP() {
        return currentPP;
    }

    public Pokemon.Type getType() {
        return type;
    }

    public List<List<String>> use(Pokemon skillUser, Pokemon enemyPokemon) {
        return null;
    }

    protected void decreaseEnemyAttack(Pokemon enemyPokemon, int amount) {
    }

    //Player side animation if userAnimation, enemy side otherwise.
    public abstract SkillAnimation getAnimation(boolean userAnimation);
}
