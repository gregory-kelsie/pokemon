package com.pokemon.toronto.game.com.pokemon.toronto.skill;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
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
    private int recoilLevel;

    //Recoil Values
    protected final int NO_RECOIL = 0;
    protected final int ONE_FOURTH = 1;
    protected final int ONE_THIRD = 2;
    protected final int ONE_HALF = 3;
    protected final int GAIN_HALF = 4;

    /**
     * Create a Damage oriented skill.
     * @param id The skill id.
     * @param name The name of the skill
     * @param maxPP The maximum amount of PP for the skill
     * @param type The type of skill (Grass, Water, Fire etc)
     * @param category The category of the skill (Physical, Special or Misc)
     * @param damage The base damage for the skill
     * @param crit The crit stage for the skill
     * @param accuracy The accuracy level for the skill.
     * @param recoilLevel The amount of recoil damage the user will take.
     *                    none, 1/2, 1/3, 1/4.
     */
    public DamageSkill(int id, String name, int maxPP, Pokemon.Type type, SkillCategory category, int accuracy, int damage, int crit, int recoilLevel) {
        super(id, name, maxPP, type, category, accuracy);
        this.crit = crit;
        this.damage = damage;
        this.recoilLevel = recoilLevel;
        damagesEnemy = true;
    }

    /**
     * Create a Damage oriented skill.
     * @param id The skill id
     * @param name The name of the skill
     * @param maxPP The maximum amount of PP for the skill
     * @param type The type of skill (Grass, Water, Fire etc)
     * @param category The category of the skill (Physical, Special or Misc)
     * @param damage The base damage for the skill
     * @param crit The crit stage for the skill
     * @param accuracy The accuracy level for the skill.
     */
    public DamageSkill(int id, String name, int maxPP, Pokemon.Type type, SkillCategory category, int accuracy, int damage, int crit) {
        super(id, name, maxPP, type, category, accuracy);
        this.crit = crit;
        this.damage = damage;
        recoilLevel = NO_RECOIL;
        damagesEnemy = true;
    }

    /**
     * Use the damage skill on the enemy pokemon.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param field The field for the battle.
     * @param userField The field for the battle.
     * @param enemyField The field for the battle.
     * @param isFirstAttack Whether or not the skill was used first in the clash
     * @return The skill results.
     */
    @Override
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack) {
        super.use(skillUser, enemyPokemon, field, userField, enemyField, isFirstAttack);
        
        List<String> results = new ArrayList<String>();

        boolean hasCrit = calcCrit(skillUser, enemyPokemon, field);

        //Add Effectiveness results
        if (moveIsSuperEffective(enemyPokemon)) {
            results.add("It was super effective!");
        } else if (moveIsNotVeryEffective(enemyPokemon)) {
            results.add("It was not very effective...");
        }

        //Add critical hit text
        if (hasCrit) {
            results.add("Critical Hit!");
        }

        //Calculate the damage results
        int damage = getDamage(skillUser, enemyPokemon, field, hasCrit);
        //Prevent Overkill.
        if (damage > enemyPokemon.getCurrentHealth()) {
            damage = enemyPokemon.getCurrentHealth();
        }
        enemyPokemon.subtractHealth(damage);
        damageTally += damage; //Keep record of damage for multi-hit-moves
        results.add("Dealt " + damage + " damage.");

        //Subtract recoil damage.
        if (recoilLevel == ONE_THIRD) {
            skillUser.subtractHealth((int) Math.ceil(damage / 3.0));
        } else if (recoilLevel == ONE_HALF) {
            skillUser.subtractHealth((int) Math.ceil(damage / 2.0));
        } else if (recoilLevel == ONE_FOURTH) {
            skillUser.subtractHealth((int) Math.ceil(damage / 4.0));
        } else if (recoilLevel == GAIN_HALF) {
            skillUser.addHealth((int) Math.ceil(damage / 2.0));
        }
        return results;
    }

    /**
     * Return whether or not the skill has an effect on the
     * enemy Pokemon.
     * @param enemy The enemy pokemon the skill is being tested on.
     * @return Whether or not the skill has an effect on the
     * enemy Pokemon.
     */
    protected boolean effectsEnemy(Pokemon enemy) {
        //TODO: Implement Odor Sleuth and the ability that hits ghost pokemon here.
        if (enemy.getResistances().get(type) != 0) {
            return true;
        }
        return false;
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
     * Return whether or not the move crit.
     * @param user The skill's user
     * @param enemy The enemy pokemon
     * @param field The field for the battle
     * @return Whether or not the move crit.
     */
    private boolean calcCrit(Pokemon user, Pokemon enemy, Field field) {
        if (enemy.getAbility() == Pokemon.Ability.SHELL_ARMOR ||
                enemy.getAbility() == Pokemon.Ability.BATTLE_ARMOR) {
            return false;
        }
        int critStage = crit;
        if (user.isFocused()) {
            critStage += 2;
        }
        if (user.getAbility() == Pokemon.Ability.SUPER_LUCK) {
            critStage *= 2;
        }
        //TODO: Add hold item bonus, add lucky chant prevention.
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
        double abilityMod = getAbilityMod(user, field);
        double defenseAbilityMod = getDefenseAbilityMod(enemy);
        double weatherMod = getWeatherMod(field);
        double randVal = Math.random() * (0.15) + 0.85;
        double burnMod = getBurnMod(user);
        return  (stabMod * resistMod * crit * abilityMod * defenseAbilityMod * weatherMod * randVal * burnMod);
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
     * Return the burn damage reduction on the skill.
     * Only reduces damage if the attack is a physical attack or the user
     * doesn't have guts or the skill isn't facade.
     * @param user The Attacker
     * @return The burn modifier.
     */
    private double getBurnMod (Pokemon user) {
        if (user.getAbility() == Pokemon.Ability.GUTS ||
                name.equals("Facade") || category != SkillCategory.PHYSICAL) {
            return 1;
        }
        return 0.5;
    }
	/**
	* 	Return the attacker's ability multiplier when determining the damage dealt.
	*	@param user - The Attacker
	*/
    private double getAbilityMod (Pokemon user, Field field) {
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
        if (user.getAbility() == Pokemon.Ability.SAND_FORCE) {
            if (type == Pokemon.Type.GROUND ||
                    type == Pokemon.Type.STEEL ||
                    type == Pokemon.Type.ROCK) {
                return 1.3;
            }
        }

        if (user.getAbility() == Pokemon.Ability.SOLAR_POWER) {
            if (field.getWeatherType() == WeatherType.HARSH_SUNSHINE ||
                    field.getWeatherType() == WeatherType.SUN) {
                if (category == SkillCategory.SPECIAL) {
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
            if (enemy.getAbility() == Pokemon.Ability.THICK_FAT || enemy.getAbility() == Pokemon.Ability.HEATPROOF) {
                return 0.5;
            } else if (enemy.getAbility() == Pokemon.Ability.DRY_SKIN) {
                return 1.25;
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
    protected int getDamage(Pokemon user, Pokemon enemy, Field field, boolean hasCrit) {
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
            if (field.getWeatherType() == WeatherType.SAND &&
                    (enemy.getTypeOne() == Pokemon.Type.ROCK ||
                            enemy.getTypeTwo() == Pokemon.Type.ROCK)) {
                defStat *= 1.5;
            }
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
        return (int)Math.ceil(dmg);
    }

}
