package com.pokemon.toronto.game.com.pokemon.toronto.skill;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.WeatherType;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/18/2017.
 */
public abstract class DamageSkill extends Skill {

    //Instance Variables
    private int crit; //Initial Crit Stage
    private int damage;

    /**
     * Create a Damage oriented skill.
     * @param name The name of the skill
     * @param maxPP The maximum amount of PP for the skill
     * @param type The type of skill (Grass, Water, Fire etc)
     * @param category The category of the skill (Physical, Special or Misc)
     * @param damage The base damage for the skill
     * @param crit The crit stage for the skill
     */
    public DamageSkill(String name, int maxPP, Pokemon.Type type, SkillCategory category, int damage, int crit) {
        super(name, maxPP, type, category);
        this.crit = crit;
        this.damage = damage;
    }

    /**
     * Use the damage skill on the enemy pokemon.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @return The skill results.
     */
    @Override
    public List<List<String>> use(Pokemon skillUser, Pokemon enemyPokemon) {
        super.use(skillUser, enemyPokemon);
        List<List<String>> fullList = new ArrayList<List<String>>();

        //The list that says if the pokemon missed or failed. The text before the move animation.
        List<String> firstList = new ArrayList<String>();

        //The list that says if the pokemon crit or if the move was super effective or if the pokemon fainted
        //It comes after the animation
        List<String> secondList = new ArrayList<String>();

        //Determine if the skill missed or failed.
        boolean skillMissed = checkMiss();
        boolean skillFailed = checkFail();

        if (!skillMissed && !skillFailed) {
            boolean hasCrit = false;

            //Add Effectiveness results
            if (moveIsSuperEffective(enemyPokemon)) {
                secondList.add("It was super effective!");
            } else if (moveIsNotVeryEffective(enemyPokemon)) {
                secondList.add("It was not very effective...");
            }

            //Add critical hit text
            if (hasCrit) {
                secondList.add("Critical Hit!");
            }

            //Calculate the damage results
            int damage = getDamage(skillUser, enemyPokemon, new Field(), hasCrit);
            enemyPokemon.subtractHealth(damage);
            secondList.add("Dealt " + damage + " damage.");
        } else {
            //Add miss and fail results
            if (skillFailed) {
                firstList.add("It failed...");
            } else {
                firstList.add("It missed...");
            }
            fullList.add(firstList);
            return fullList;
        }

        //Add results to the final list
        fullList.add(firstList);
        fullList.add(secondList);
        return fullList;
    }


    /**
     * Determine if the move is super effective on the enemy pokemon
     * @param enemyPokemon The pokemon we are comparing the move to.
     * @return Whether or not the move is super effective on the enemy
     * Pokemon.
     */
    private boolean moveIsSuperEffective(Pokemon enemyPokemon) {
        if (enemyPokemon.getResistances().get(this.type) > 1) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Determine if the move is not very effective on the enemy pokemon
     * @param enemyPokemon The pokemon we are comparing the move to.
     * @return Whether or not the move is not very effective on the enemy
     * Pokemon.
     */
    private boolean moveIsNotVeryEffective(Pokemon enemyPokemon) {
        if (enemyPokemon.getResistances().get(this.type) < 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Return whether or not the move missed.
     * @return Whether or not the move missed.
     */
    private boolean checkMiss() {
        return false;
    }

    /**
     * Return whether or not the move failed.
     * @return Whether or not the move failed.
     */
    private boolean checkFail() {
        return false;
    }


    /**
     * Return whether or not the move crit.
     * @param user The skill's user
     * @return Whether or not the move crit.
     */
    private boolean calcCrit(Pokemon user) {
        int critStage = crit;
        if (user.isFocused()) {
            critStage += 2;
        }
        if (user.getAbility() == Pokemon.Ability.SUPER_LUCK) {
            critStage *= 2;
        }
        //TODO: Add hold item bonus.
        double rand = Math.random();

        switch(critStage) {
            case 1:
                if (rand <= 0.0625) {
                    return true;
                }
                return false;
            case 2:
                if (rand <= 0.125) {
                    return true;
                }
                return false;
            case 3:
                if (rand <= 0.5) {
                    return true;
                }
                return false;
            case 4:
                return true;

        }
        return false;



    }

    /**
     * Return the skill's base damage.
     * @return The skill's base damage.
     */
    public int getBaseDamage() {
        return damage;
    }

    /**
     * Calculate the modifier in the damage calculation formula
     * http://bulbapedia.bulbagarden.net/wiki/Damage
     * @param user The skill user
     * @param enemy The skill receiver
     * @param field The battle field.
     * @param hasCrit Whether or not the skill crit.
     * @return The modifier value in the damage calculation formula.
     */
    private double getModifier(Pokemon user, Pokemon enemy, Field field, boolean hasCrit) {
        double crit = this.getCritMultiplier(user, hasCrit);

        double resistMod = getResistModifier(user, enemy);
        double stabMod = getStabModifier(user);
        double abilityMod = getAbilityMod(user);
        double defenseAbilityMod = getDefenseAbilityMod(enemy);
        double weatherMod = getWeatherMod(field);
        double randVal = Math.random() * (0.15) + 0.85;
        return  (stabMod * resistMod * crit * abilityMod * defenseAbilityMod * weatherMod * randVal);
    }

	/**
	* 	Return the attacker's STAB modifier
	*	@param user - The Attacker
	*/
    public double getStabModifier(Pokemon user) {
        //Check if the user's type is the same as the move type.
        if (user.getTypeOne() == this.getType() || user.getTypeTwo() == this.getType()) {
            if (user.getAbility() == Pokemon.Ability.ADAPTABILITY) {
                //Adaptability makes the STAB bonus 2 instead of 1
                return 2;
            }
            return 1.5;
        } else {
            return 1;
        }
    }

	/**
	* 	Return the effectiveness modifier (0.25, 0.5, 1, 2, 4)
	*	@param user - The Attacker
	*	@param enemy - The pokemon that gets attacked
	*/
    private double getResistModifier(Pokemon user, Pokemon enemy) {
        double resistMod = enemy.getResistances().get(this.getType());
        boolean superEffective = false;
        boolean notVeryEffective = false;
        if (resistMod > 1) {
            superEffective = true;
        } else if (resistMod < 1) {
            notVeryEffective = true;
        }
        if (enemy.getAbility() == Pokemon.Ability.FILTER || enemy.getAbility() == Pokemon.Ability.SOLID_ROCK) {
            //Filter and Solid Rock reduce super effective moves by 1/4
            if (superEffective) {
                resistMod *= 0.75;
            }
        }
        if (user.getAbility() == Pokemon.Ability.TINTED_LENS) {
            //Power of not very effective moves is doubled.
            if (notVeryEffective) {
                resistMod *= 2;
            }
        }
        return resistMod;
    }


	/**
	* 	Return the crit multiplier when determining the damage dealt.
	*	@param user - The Attacker
	*	@param hasCrit - Whether or not the attacker got a crit
	 */
    private double getCritMultiplier(Pokemon user, boolean hasCrit) {
        if (hasCrit) {
            if (user.getAbility() == Pokemon.Ability.SNIPER) {
                return 2.25;
            }  else {
                return 1.5;
            }
        } else {
            return 1;
        }
    }

	/**
	* 	Return the attacker's ability multiplier when determining the damage dealt.
	*	@param user - The Attacker
	*/
    private double getAbilityMod (Pokemon user) {
        //Health below 1/3 ability mods
        if (user.getCurrentHealth() <= user.getHealthStat() * 0.33) {
            if (this.getType() == Pokemon.Type.FIRE) {
                if (user.getAbility() == Pokemon.Ability.BLAZE) {
                    return 1.5;
                }
            } else if (this.getType() == Pokemon.Type.WATER) {
                if (user.getAbility() == Pokemon.Ability.TORRENT) {
                    return 1.5;
                }
            }	else if (this.getType() == Pokemon.Type.GRASS) {
                if (user.getAbility() == Pokemon.Ability.OVERGROW) {
                    return 1.5;
                }
            }	else if (this.getType()== Pokemon.Type.BUG) {
                if (user.getAbility() == Pokemon.Ability.SWARM) {
                    return 1.5;
                }
            }
        }
        //Status ability mods
        if (user.getAbility() == Pokemon.Ability.GUTS && (user.getStatus() == Pokemon.Status.BURN
                || user.getStatus() == Pokemon.Status.PARALYSIS || user.getStatus() == Pokemon.Status.POISON)) {
            return 1.5;
        }

        //Regular ability mods.
        if (user.getAbility() == Pokemon.Ability.HUSTLE) {
            return 1.5;
        }

        //No ability mods
        return 1;
    }

	/**
	* 	Return the defender's ability multiplier when determining the damage taken.
	*	@param enemy - The pokemon that's getting attacked
	*/
    private double getDefenseAbilityMod(Pokemon enemy) {
        //Ability mods when getting hit by fire
        if (this.getType() == Pokemon.Type.FIRE) {
            if (enemy.getAbility() == Pokemon.Ability.THICK_FAT || enemy.getAbility()
                    == Pokemon.Ability.DRY_SKIN || enemy.getAbility() == Pokemon.Ability.HEATPROOF) {
                return 0.5;
            }
        }
        //Ability mods when getting hit by ice
        else if (this.getType() == Pokemon.Type.ICE) {
            if (enemy.getAbility() == Pokemon.Ability.THICK_FAT) {
                return 0.5;
            }
        }

        //No defense ability mods
        return 1;
    }


    /**
     * Return the weather modifier
     * @param field The current battle field.
     * @return Return the weather modifier
     */
    private double getWeatherMod(Field field) {
        if (field.getWeatherType() == WeatherType.SUN) {
            //Fire increase and Water decrease in damage during sunlight.
            if (this.getType() == Pokemon.Type.FIRE) {
                return 1.5;
            } else if (this.getType() == Pokemon.Type.WATER) {
                return 0.5;
            }
        } else if (field.getWeatherType() == WeatherType.RAIN) {
            //Fire decrease and water increase in rain
            if (this.getType() == Pokemon.Type.FIRE) {
                return 0.5;
            } else if (this.getType() == Pokemon.Type.WATER) {
                return 1.5;
            }
        }
        //1 is the default mod
        return 1;
    }

    /**
     * Return the amount of damage the skill will do to the enemy on the current
     * field.
     * @param user The skill user
     * @param enemy The skill receiver
     * @param field The current battle field
     * @param hasCrit Whether or not the skill will crit.
     * @return
     */
    private int getDamage(Pokemon user, Pokemon enemy, Field field, boolean hasCrit) {
        double atkStat;
        double defStat;

        if (this.category == SkillCategory.PHYSICAL) {
            atkStat = user.getAttackStat();
            //Attack stage is above the normal
            if (user.getAttackStage() >= 0) {
                atkStat = atkStat * (1 + (0.5 * user.getAttackStage()));
            }
            //Attack stage is below the normal
            else {
                //Ignore negative attack stage
                if (!hasCrit) {
                    if (user.getAttackStage() == -1) {
                        atkStat *= 0.66;
                    } else if (user.getAttackStage() == -2) {
                        atkStat *= 0.5;
                    } else if (user.getAttackStage() == -3) {
                        atkStat *= 0.4;
                    } else if (user.getAttackStage() == -4) {
                        atkStat *= 0.33;
                    } else if (user.getAttackStage() == -5) {
                        atkStat *= 0.29;
                    } else {
                        atkStat *= 0.25;
                    }
                }
            }

            defStat = enemy.getDefenseStat();
            //Defense stage is above normal
            if (enemy.getDefenseStage() >= 0) {
                //Ignore defense bonus on crit
                if (!hasCrit) {
                    defStat = defStat * (1 + (0.5 * enemy.getDefenseStage()));
                }
            }
            //Defense stage is below normal
            else {
                if (enemy.getDefenseStage() == -1) {
                    defStat *= 0.66;
                } else if (enemy.getDefenseStage() == -2) {
                    defStat *= 0.5;
                } else if (enemy.getDefenseStage() == -3) {
                    defStat *= 0.4;
                } else if (enemy.getDefenseStage() == -4) {
                    defStat *= 0.33;
                } else if (enemy.getDefenseStage() == -5) {
                    defStat *= 0.29;
                } else {
                    defStat *= 0.25;
                }
            }
        }
        //The skill is in the special attack category
        else {
            atkStat = user.getSpecialAttackStat();
            //Attack stage is above the normal
            if (user.getSpecialAttackStat() >= 0) {
                atkStat = atkStat * (1 + (0.5 * user.getSpecialAttackStat()));
            }
            //Attack stage is below the normal
            else {
                //Ignore negative attack stage
                if (!hasCrit) {
                    if (user.getSpecialAttackStat() == -1) {
                        atkStat *= 0.66;
                    } else if (user.getSpecialAttackStat() == -2) {
                        atkStat *= 0.5;
                    } else if (user.getSpecialAttackStat() == -3) {
                        atkStat *= 0.4;
                    } else if (user.getSpecialAttackStat() == -4) {
                        atkStat *= 0.33;
                    } else if (user.getSpecialAttackStat() == -5) {
                        atkStat *= 0.29;
                    } else {
                        atkStat *= 0.25;
                    }
                }
            }
            defStat = enemy.getSpecialDefenseStat();
            if (enemy.getSpecialDefenseStat() >= 0) {
                //Ignore defense bonus on crit
                if (!hasCrit) {
                    defStat = defStat * (1 + (0.5 * enemy.getSpecialDefenseStat()));
                }
            }
            //Defense stage is below normal
            else {
                if (enemy.getSpecialDefenseStat() == -1) {
                    defStat *= 0.66;
                } else if (enemy.getSpecialDefenseStat() == -2) {
                    defStat *= 0.5;
                } else if (enemy.getSpecialDefenseStat() == -3) {
                    defStat *= 0.4;
                } else if (enemy.getSpecialDefenseStat() == -4) {
                    defStat *= 0.33;
                } else if (enemy.getSpecialDefenseStat() == -5) {
                    defStat *= 0.29;
                } else {
                    defStat *= 0.25;
                }
            }
        }

        //Sub values into the formulas from bulbapedia.
        double ls = (((((2 * user.getLevel()) / 5) + 2) * (atkStat / defStat) * damage) / 50) + 2;
        double mod = getModifier(user, enemy, field, hasCrit);
        double dmg = ls * mod;
        return (int)Math.round(dmg);
    }

}
