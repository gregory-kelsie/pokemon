package com.pokemon.toronto.game.com.pokemon.toronto.skill;

import com.badlogic.gdx.graphics.Texture;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.WeatherType;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.Ability.AbilityId;
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
    protected final int NO_MISS_RECOIL = 0;
    protected final int HALF_MISS_RECOIL = 1;

    //Instance Variables
    protected int id;
    protected String name;
    protected String description;
    protected int maxPP;
    protected int currentPP;
    protected Pokemon.Type type;
    protected SkillCategory category;
    protected int priority;
    protected int accuracy;
    protected boolean targetsEnemy;
    protected boolean makesPhysicalContact;
    protected boolean damagesEnemy;
    protected boolean punchSkill;
    protected int missRecoil;
    protected int damage;

    //Multi-Hit Move Variables
    protected boolean isMultiStrikeMove;
    protected int strikesLeft;
    protected int damageTally; //Counter to tally up damage.
    protected boolean continuesUseThroughNoEffect;

    protected boolean ignoreTargetStatChanges; //Moves like Sacred Sword
    protected boolean hitFlyingPokemon; //Moves like sky uppercut hit Pokemon if semi-invulnerable during fly
    protected boolean hitUnderwaterPokemon;
    protected boolean hitUndergroundPokemon;

    /**
     * Create a Skill.
     * @param id The skill's id
     * @param name The skill's name
     * @param maxPP The maximum PP for the skill
     * @param type The skill's type.
     * @param category The skill's category (physical, special or misc)
     * @param accuracy The accuracy level for the skill.
     */
    public Skill(int id, String name, String description, int maxPP, Pokemon.Type type,
                 SkillCategory category, int accuracy) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.maxPP = maxPP;
        this.currentPP = maxPP;
        this.type = type;
        this.category = category;
        damage = 0;
        priority = 0;
        this.accuracy = accuracy;
        targetsEnemy = true; //default
        makesPhysicalContact = false;
        damagesEnemy = false;
        isMultiStrikeMove = false;
        strikesLeft = -1;
        damageTally = 0;
        continuesUseThroughNoEffect = false;
        punchSkill = false;
        missRecoil = NO_MISS_RECOIL;
        ignoreTargetStatChanges = false;
        hitFlyingPokemon = false;
        hitUndergroundPokemon = false;
        hitUnderwaterPokemon = false;
    }

    /**
     * Return the skill's description.
     * @return The skill's description.
     */
    public String getDescription() {
        return description;
    }


    /**
     * Return the skill's base damage.
     * @return The skill's base damage.
     */
    public int getBaseDamage() {
        return damage;
    }

    /**
     * Return the skill's category texture.
     * @return The skill's category texture.
     */
    public Texture getCategoryTexture() {
        if (category == Skill.SkillCategory.PHYSICAL) {
            return new Texture("bag/gui/skill/physical.png");
        } else if (category == Skill.SkillCategory.SPECIAL) {
            return new Texture("bag/gui/skill/special.png");
        } else {
            return new Texture("bag/gui/skill/other.png");
        }
    }

    public Texture getSkillTypeTexture() {
        if (type == Pokemon.Type.BUG) {
            return new Texture("bag/gui/skill/bug.png");
        } else if (type == Pokemon.Type.DARK) {
            return new Texture("bag/gui/skill/dark.png");
        } else if (type == Pokemon.Type.DRAGON) {
            return new Texture("bag/gui/skill/dragon.png");
        } else if (type == Pokemon.Type.ELECTRIC) {
            return new Texture("bag/gui/skill/electric.png");
        } else if (type == Pokemon.Type.FIGHTING) {
            return new Texture("bag/gui/skill/fighting.png");
        } else if (type == Pokemon.Type.FIRE) {
            return new Texture("bag/gui/skill/fire.png");
        } else if (type == Pokemon.Type.FLYING) {
            return new Texture("bag/gui/skill/flying.png");
        } else if (type == Pokemon.Type.GHOST) {
            return new Texture("bag/gui/skill/ghost.png");
        } else if (type == Pokemon.Type.GRASS) {
            return new Texture("bag/gui/skill/grass.png");
        } else if (type == Pokemon.Type.GROUND) {
            return new Texture("bag/gui/skill/ground.png");
        } else if (type == Pokemon.Type.ICE) {
            return new Texture("bag/gui/skill/ice.png");
        } else if (type == Pokemon.Type.NORMAL) {
            return new Texture("bag/gui/skill/normal.png");
        } else if (type == Pokemon.Type.POISON) {
            return new Texture("bag/gui/skill/poison.png");
        } else if (type == Pokemon.Type.PSYCHIC) {
            return new Texture("bag/gui/skill/psychic.png");
        } else if (type == Pokemon.Type.ROCK) {
            return new Texture("bag/gui/skill/rock.png");
        } else if (type == Pokemon.Type.STEEL) {
            return new Texture("bag/gui/skill/steel.png");
        } else if (type == Pokemon.Type.WATER) {
            return new Texture("bag/gui/skill/water.png");
        }
        else if (type == Pokemon.Type.FAIRY) {
            return new Texture("bag/gui/skill/fairy.png");
        }
        else {
            return new Texture("bag/gui/skill/normal.png");
        }
    }
    /**
     * Return the Texture for the skill's border/panel.
     * @return The Texture for the skill's border/panel.
     */
    public Texture getSkillBorderTexture() {
        if (type == Pokemon.Type.BUG) {
            return new Texture("battle/skillBorders/bug.png");
        } else if (type == Pokemon.Type.DARK) {
            return new Texture("battle/skillBorders/dark.png");
        } else if (type == Pokemon.Type.DRAGON) {
            return new Texture("battle/skillBorders/dragon.png");
        } else if (type == Pokemon.Type.ELECTRIC) {
            return new Texture("battle/skillBorders/electric.png");
        } else if (type == Pokemon.Type.FIGHTING) {
            return new Texture("battle/skillBorders/fighting.png");
        } else if (type == Pokemon.Type.FIRE) {
            return new Texture("battle/skillBorders/fire.png");
        } else if (type == Pokemon.Type.FLYING) {
            return new Texture("battle/skillBorders/flying.png");
        } else if (type == Pokemon.Type.GHOST) {
            return new Texture("battle/skillBorders/ghost.png");
        } else if (type == Pokemon.Type.GRASS) {
            return new Texture("battle/skillBorders/grass.png");
        } else if (type == Pokemon.Type.GROUND) {
            return new Texture("battle/skillBorders/ground.png");
        } else if (type == Pokemon.Type.ICE) {
            return new Texture("battle/skillBorders/ice.png");
        } else if (type == Pokemon.Type.NORMAL) {
            return new Texture("battle/skillBorders/normal.png");
        } else if (type == Pokemon.Type.POISON) {
            return new Texture("battle/skillBorders/poison.png");
        } else if (type == Pokemon.Type.PSYCHIC) {
            return new Texture("battle/skillBorders/psychic.png");
        } else if (type == Pokemon.Type.ROCK) {
            return new Texture("battle/skillBorders/rock.png");
        } else if (type == Pokemon.Type.STEEL) {
            return new Texture("battle/skillBorders/steel.png");
        } else if (type == Pokemon.Type.WATER) {
            return new Texture("battle/skillBorders/water.png");
        }
        else if (type == Pokemon.Type.FAIRY) {
            return new Texture("battle/skillBorders/fairy.png");
        }
        else {
            return new Texture("battle/skillBorders/normal.png");
        }
    }

    /**
     * Return whether or not this skill ignores the target's stat
     * changes when it is used. (Defense and Evasion)
     * @return Whether or not this skill ignore's the target's stat
     * changes when it it used.
     */
    public boolean ignoresTargetStatChanges() {
        return ignoreTargetStatChanges;
    }

    /**
     * Return the skill's id
     * @return The skill id.
     */
    public int getId() {
        return id;
    }

    /**
     * Return the skill's category.
     * @return The skill's category - Physical Special Misc
     */
    public SkillCategory getCategory() {
        return category;
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
     * Set the current pp of the skill to the specified amount.
     * @param newPP The new amount of current pp.
     */
    public void setCurrentPP(int newPP) {
        this.currentPP = newPP;
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
     * Return whether or not the Skill has recoil.
     * @return Whether or not the Skill has recoil
     * or drain effects after usage.
     */
    public boolean hasRecoil() {
        return false;
    }

    /**
     * Return the amount of recoil damage the user will take
     * if this skill misses.
     * @return The amount of recoil damage the user will take
     * if this skill misses. (0 = none, 1 = half etc)
     */
    public int getMissRecoil() {
        return missRecoil;
    }


    /**
     * Use the skill on an enemy pokemon.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition The position of the skill user in their party.
     * @param enemyPokemonPartyPosition The position of the enemy pokemon in their party.
     * @param field The field for the battle.
     * @param userField The field for the battle.
     * @param enemyField The field for the battle.
     * @param isFirstAttack Whether or not the skill was used first in the clash
     * @param targetSkill
     * @param skillUserParty The party for the skill user.
     * @param enemyPokemonParty The party for the skill receiver.
     * @return List of Strings that display the result of using the move. The first list
     * displays misses, and the second
     */
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon,
                            int skillUserPartyPosition, int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack,
                            Skill targetSkill, List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        skillUser.removeRage();
        return null;
    }

    /**
     * Return whether or not the move will hit the enemy.
     * @param skillUser The Pokemon using the skill.
     * @param enemyPokemon The Pokemon receiving the skill.
     * @param field The field for the battle.
     * @param userField The field for the battle.
     * @param enemyField The field for the battle.
     * @param isFirstAttack Whether or not the skill was used first in the clash
     * @return Whether or not the skill hits the enemy.
     */
    public boolean willHitEnemy(Pokemon skillUser, Pokemon enemyPokemon,
                                Field field, SubField userField, SubField enemyField, boolean isFirstAttack) {
        if (accuracy != -1) {
            if (skillUser.isSkyDropped() && !hitFlyingPokemon) {
                return false;
            }
            //Init Modifiers
            if (enemyPokemon.isUnderwater() && !hitUnderwaterPokemon) {
                return false;
            }
            if (enemyPokemon.isFlying() && !hitFlyingPokemon) {
                return false;
            }
            if (enemyPokemon.isUnderground() && !hitUndergroundPokemon) {
                return false;
            }
            int accuracyStage = skillUser.getAccuracyStage();
            double attackerAccuracyMod = skillUser.getAccuracyModifier(accuracyStage);
            if (enemyPokemon.getBattleAbility().getId() == AbilityId.SAND_VEIL &&
                    field.getWeatherType() == WeatherType.SAND) {
                attackerAccuracyMod *= 0.8;
            } else if (enemyPokemon.getBattleAbility().getId() == AbilityId.SNOW_CLOAK &&
                    field.getWeatherType() == WeatherType.HAIL) {
                attackerAccuracyMod *= 0.8;
            }
            if (skillUser.getBattleAbility().getId() == AbilityId.HUSTLE) {
                attackerAccuracyMod *= 0.8;
            }
            int evasionStage = 0;
            if (!ignoreTargetStatChanges) {
                evasionStage = enemyPokemon.getEvasionStage();
                if (enemyPokemon.isConfused() && enemyPokemon.getBattleAbility().getId() ==
                        AbilityId.TANGLED_FEET) {
                    evasionStage++;
                    evasionStage = Math.min(6, evasionStage);
                }
            }
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
     * @param field The field for the battle.
     * @param userField The field for the battle.
     * @param enemyField The field for the battle.
     * @param isFirstAttack Whether or not the skill was used first in the clash
     * @param targetsSkill
     * @return Whether or not the skill will fail.
     */
    //TODO: Refactor signature to include pokemon parties and a boolean to represent is a wild battle. (Whirlwind on 1 pokemon in a trainer battle will fail but will
    //TODO: blow away the enemy in a wild battle.
    //TODO: Add general fail scenarios - Water types fail when the field is Desolate Land etc.
    public FailResult willFail(Pokemon skillUser, Pokemon enemyPokemon,
                               Field field, SubField userField, SubField enemyField,
                               boolean isFirstAttack, Skill targetsSkill) {
        return new FailResult(false);
    }

    /**
     * Cancel the effects that get cancelled when the
     * Pokemon misses their target. Ex: Rollout.
     * @param skillUser The Pokemon who missed.
     * @param target The Pokemon who was targeted by the skill.
     */
    public void miss(Pokemon skillUser, Pokemon target) {
        //TODO: Override for moves that do something when they miss Rollout, Fury Cutter, Surf, etc.
    }

    /**
     * Return whether or not the skill targets the enemy.
     * For example, swords dance targets self, tackle targets enemy.
     * @param skillUser The Pokemon using the Skill
     * @param field
     * @return Whether or not the skill targets the enemy.
     */
    public boolean targetsEnemy(Pokemon skillUser, Field field) {
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
     * Return whether or not the skill gets used even if it doesn't
     * effect the enemy.
     * Ex: Self-Destruct gets used even if it's done on a Ghost type.
     * It simply kills the user and doesn't effect the enemy.
     * @return
     */
    public boolean continuesUseThroughNoEffect() {
        return continuesUseThroughNoEffect;
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
     * Return whether or not the skill is a Punching skill.
     * @return Whether or not the skill is a punching skill.
     */
    public boolean isPunchSkill() { return punchSkill; }

    /**
     * Return the animation of the Skill
     * @param userAnimation Whether or not the skill's animation is from the user
     *                      using the skill or the enemy using the skill.
     * @return The skill animation.
     */
    public abstract SkillAnimation getAnimation(boolean userAnimation);
}
