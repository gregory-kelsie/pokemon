package com.pokemon.toronto.game.com.pokemon.toronto.skill;

import com.badlogic.gdx.Gdx;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.SubField;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.WeatherType;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/18/2017.
 */
public abstract class DamageSkill extends Skill {

    //Instance Variables
    private int crit; //Initial Crit Stage
    protected int damage;
    private int recoilLevel;
    protected double extraMod; //For skills that double damage for certain conditions ex: Brine
    protected boolean reverseCategory; //For Secred Sword (calculates user's special attack and hits defense instead of sp def)
    protected boolean usesEnemyAttack; //For moves like Foul play.

    //Recoil Values
    protected final int NO_RECOIL = 0;
    protected final int ONE_FOURTH = 1;
    protected final int ONE_THIRD = 2;
    protected final int ONE_HALF = 3;
    protected final int GAIN_HALF = 4;
    protected final int GAIN_THREE_QUARTERS = 5;

    protected final int DEFAULT_EXTRA_MOD = 1;

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
        extraMod = 1;
        ignoreTargetStatChanges = false;
        reverseCategory = false;
        usesEnemyAttack = false;
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
        extraMod = 1;
        ignoreTargetStatChanges = false;
        reverseCategory = false;
        usesEnemyAttack = false;
    }

    @Override
    public boolean hasRecoil() {
        if (recoilLevel != NO_RECOIL) {
            return true;
        }
        return false;
    }
    /**
     * Use the damage skill on the enemy pokemon.
     * @param skillUser The Pokemon using the skill
     * @param enemyPokemon The enemy receiving the skill
     * @param skillUserPartyPosition
     * @param enemyPokemonPartyPosition
     * @param field The field for the battle.
     * @param userField The field for the battle.
     * @param enemyField The field for the battle.
     * @param isFirstAttack Whether or not the skill was used first in the clash
     * @param targetSkill
     * @param skillUserParty
     * @param enemyPokemonParty       @return The skill results.
     * */
    @Override
    public List<String> use(Pokemon skillUser, Pokemon enemyPokemon, int skillUserPartyPosition, int enemyPokemonPartyPosition, Field field, SubField userField,
                            SubField enemyField, boolean isFirstAttack, Skill targetSkill, List<Pokemon> skillUserParty, List<Pokemon> enemyPokemonParty) {
        super.use(skillUser, enemyPokemon, skillUserPartyPosition, enemyPokemonPartyPosition, field, userField, enemyField, isFirstAttack, targetSkill, skillUserParty, enemyPokemonParty);
        
        List<String> results = new ArrayList<String>();
        boolean heldOnWithSturdy = false;
        boolean hasCrit = calcCrit(skillUser, enemyPokemon, field);

        //Add Effectiveness results
        if (moveIsSuperEffective(enemyPokemon) || (id == SkillFactory.FREEZE_DRY &&
                (enemyPokemon.getBattleTypeOne() == Pokemon.Type.WATER ||
                enemyPokemon.getBattleTypeTwo() == Pokemon.Type.WATER))) {
            results.add("It was super effective!");
        } else if (moveIsNotVeryEffective(enemyPokemon)) {
            results.add("It was not very effective...");
        }

        //Add critical hit text
        if (hasCrit) {
            results.add("Critical Hit!");
        }

        //Calculate the damage results
        int damage = getDamage(skillUser, enemyPokemon, field, userField, enemyField, hasCrit);

        //Prevent Overkill.
        if (damage > enemyPokemon.getCurrentHealth()) {
            if (enemyPokemon.hasFullHealth() && enemyPokemon.getBattleAbility() == Pokemon.Ability.STURDY) {
                damage = enemyPokemon.getCurrentHealth() - 1;
                heldOnWithSturdy = true;
            } else {
                damage = enemyPokemon.getCurrentHealth();
            }
        }

        //Let the Pokemon know how much damage they've taken in case
        //they can return 1.5x damage with a Counter/Metal Burst etc.
        if (isFirstAttack) {
            enemyPokemon.setTurnDamageTaken(damage, category);
        }
        enemyPokemon.subtractHealth(damage);
        damageTally += damage; //Keep record of damage for multi-hit-moves
        results.add("Dealt " + damage + " damage.");

        //Increase attack if the enemy previously used rage.
        if (enemyPokemon.usedRage()) {
            //Attempt to increase the attack stage.
            if (enemyPokemon.getAttackStage() < 6) {
                enemyPokemon.increaseAttackStage(1);
                results.add(enemyPokemon.getName() + "'s attack rose!");
            }
        }

        if (heldOnWithSturdy) {
            results.add(enemyPokemon.getName() + " held on\nwith Sturdy!");
        }
        //Subtract recoil damage.
        if (recoilLevel == ONE_THIRD && skillUser.getBattleAbility() != Pokemon.Ability.ROCK_HEAD) {
            skillUser.subtractHealth((int) Math.ceil(damage / 3.0));
            skillUser.takeDamageThisTurn();
        } else if (recoilLevel == ONE_HALF && skillUser.getBattleAbility() != Pokemon.Ability.ROCK_HEAD) {
            skillUser.subtractHealth((int) Math.ceil(damage / 2.0));
            skillUser.takeDamageThisTurn();
        } else if (recoilLevel == ONE_FOURTH && skillUser.getBattleAbility() != Pokemon.Ability.ROCK_HEAD) {
            skillUser.subtractHealth((int) Math.ceil(damage / 4.0));
            skillUser.takeDamageThisTurn();
        } else if (recoilLevel == GAIN_HALF) {
            skillUser.addHealth((int) Math.ceil(damage / 2.0));
        } else if (recoilLevel == GAIN_THREE_QUARTERS) {
            skillUser.addHealth((int) Math.ceil(damage * 0.75));
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
        if (enemy.getBattleAbility() == Pokemon.Ability.SHELL_ARMOR ||
                enemy.getBattleAbility() == Pokemon.Ability.BATTLE_ARMOR) {
            return false;
        }
        if (crit == -1 || user.hasCrit()) { //-1 Means always crits.
            return true;
        }
        int critStage = crit;
        if (user.isFocused()) {
            critStage += 2;
        }
        if (user.getBattleAbility() == Pokemon.Ability.SUPER_LUCK) {
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
        Gdx.app.log("CritMod", "" + crit);
        return  (stabMod * resistMod * crit * abilityMod * defenseAbilityMod * weatherMod * randVal * burnMod * extraMod);
    }

	/**
	* 	Return the attacker's STAB modifier
	*	@param user - The Attacker
	*/
    public double getStabModifier(Pokemon user) {
        //Check if the user's type is the same as the move type.
        if (user.getBattleTypeOne() == this.getType() || user.getBattleTypeTwo() == this.getType()) {
            if (user.getBattleAbility() == Pokemon.Ability.ADAPTABILITY) {
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
    protected double getResistModifier(Pokemon user, Pokemon enemy) {
        double resistMod = enemy.getResistances().get(this.getType());
        boolean superEffective = false;
        boolean notVeryEffective = false;
        if (resistMod > 1) {
            superEffective = true;
        } else if (resistMod < 1) {
            notVeryEffective = true;
        }
        if (enemy.getBattleAbility() == Pokemon.Ability.FILTER || enemy.getBattleAbility() == Pokemon.Ability.SOLID_ROCK) {
            //Filter and Solid Rock reduce super effective moves by 1/4
            if (superEffective) {
                resistMod *= 0.75;
            }
        }
        if (user.getBattleAbility() == Pokemon.Ability.TINTED_LENS) {
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
            if (user.getBattleAbility() == Pokemon.Ability.SNIPER) {
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
        if (user.getBattleAbility() == Pokemon.Ability.GUTS ||
                id == SkillFactory.FACADE || category != SkillCategory.PHYSICAL) {
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
                if (user.getBattleAbility() == Pokemon.Ability.BLAZE) {
                    return 1.5;
                }
            } else if (this.getType() == Pokemon.Type.WATER) {
                if (user.getBattleAbility() == Pokemon.Ability.TORRENT) {
                    return 1.5;
                }
            }	else if (this.getType() == Pokemon.Type.GRASS) {
                if (user.getBattleAbility() == Pokemon.Ability.OVERGROW) {
                    return 1.5;
                }
            }	else if (this.getType()== Pokemon.Type.BUG) {
                if (user.getBattleAbility() == Pokemon.Ability.SWARM) {
                    return 1.5;
                }
            }
        }
        if (user.getBattleAbility() == Pokemon.Ability.SAND_FORCE) {
            if (type == Pokemon.Type.GROUND ||
                    type == Pokemon.Type.STEEL ||
                    type == Pokemon.Type.ROCK) {
                return 1.3;
            }
        }

        if (user.getBattleAbility() == Pokemon.Ability.SOLAR_POWER) {
            if (field.getWeatherType() == WeatherType.HARSH_SUNSHINE ||
                    field.getWeatherType() == WeatherType.SUN) {
                if (category == SkillCategory.SPECIAL) {
                    return 1.5;
                }
            }
        }

        //Status ability mods
        if (user.getBattleAbility() == Pokemon.Ability.GUTS && (user.getStatus() == Pokemon.Status.BURN
                || user.getStatus() == Pokemon.Status.PARALYSIS || user.getStatus() == Pokemon.Status.POISON)) {
            return 1.5;
        }

        //Regular ability mods.
        if (user.getBattleAbility() == Pokemon.Ability.HUSTLE) {
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
            if (enemy.getBattleAbility() == Pokemon.Ability.THICK_FAT || enemy.getBattleAbility() == Pokemon.Ability.HEATPROOF) {
                return 0.5;
            } else if (enemy.getBattleAbility() == Pokemon.Ability.DRY_SKIN) {
                return 1.25;
            }
        }
        //Ability mods when getting hit by ice
        else if (this.getType() == Pokemon.Type.ICE) {
            if (enemy.getBattleAbility() == Pokemon.Ability.THICK_FAT) {
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
     * Calculate the Physical attack stat of the Pokemon after taking into account
     * stages and crit.
     * @param user The Pokemon's attack stat being calculated.
     * @param hasCrit Whether or not the attack crits.
     * @return The working attack stat of the attacker.
     */
    protected double getPhysicalAttack(Pokemon user, boolean hasCrit) {
        double atkStat = user.getAttackStat();
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
        return atkStat;
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
    protected int getDamage(Pokemon user, Pokemon enemy, Field field, SubField userField,
                            SubField targetField, boolean hasCrit) {
        double atkStat;
        double defStat;

        //CALCULATE ATTACK STAT
        if (this.category == SkillCategory.PHYSICAL) {
           if (usesEnemyAttack) {
               atkStat = getPhysicalAttack(enemy, hasCrit);
           } else {
               atkStat = getPhysicalAttack(user, hasCrit);
           }
        } else {
            atkStat = user.getSpecialAttackStat();
            //Attack stage is above the normal
            if (user.getSpecialAttackStage() >= 0) {
                atkStat = atkStat * (1 + (0.5 * user.getSpecialAttackStage()));
            }
            //Attack stage is below the normal
            else {
                //Ignore negative attack stage
                if (!hasCrit) {
                    if (user.getSpecialAttackStage() == -1) {
                        atkStat *= 0.66;
                    } else if (user.getSpecialAttackStage() == -2) {
                        atkStat *= 0.5;
                    } else if (user.getSpecialAttackStage() == -3) {
                        atkStat *= 0.4;
                    } else if (user.getSpecialAttackStage() == -4) {
                        atkStat *= 0.33;
                    } else if (user.getSpecialAttackStage() == -5) {
                        atkStat *= 0.29;
                    } else {
                        atkStat *= 0.25;
                    }
                }
            }
        }

        //CALCULATE DEFENSE STAT
        if ((category == SkillCategory.PHYSICAL && !reverseCategory) ||
                (category == SkillCategory.SPECIAL && reverseCategory)) {
            defStat = enemy.getDefenseStat();
            if (targetField != null && targetField.hasReflect()) {
                defStat *= 2;
            }
            if (!ignoreTargetStatChanges) {
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
        }
        else {
            defStat = enemy.getSpecialDefenseStat();
            if (targetField != null && targetField.hasLightScreen()) {
                defStat *= 2;
            }
            if (field.getWeatherType() == WeatherType.SAND &&
                    (enemy.getBattleTypeOne() == Pokemon.Type.ROCK ||
                            enemy.getBattleTypeTwo() == Pokemon.Type.ROCK)) {
                defStat *= 1.5;
            }
            if (!ignoreTargetStatChanges) {
                if (enemy.getSpecialDefenseStage() >= 0) {
                    //Ignore defense bonus on crit
                    if (!hasCrit) {
                        defStat = defStat * (1 + (0.5 * enemy.getSpecialDefenseStage()));
                    }
                }
                //Defense stage is below normal
                else {
                    if (enemy.getSpecialDefenseStage() == -1) {
                        defStat *= 0.66;
                    } else if (enemy.getSpecialDefenseStage() == -2) {
                        defStat *= 0.5;
                    } else if (enemy.getSpecialDefenseStage() == -3) {
                        defStat *= 0.4;
                    } else if (enemy.getSpecialDefenseStage() == -4) {
                        defStat *= 0.33;
                    } else if (enemy.getSpecialDefenseStage() == -5) {
                        defStat *= 0.29;
                    } else {
                        defStat *= 0.25;
                    }
                }
            }
        }

        //Sport modifiers
        double basePowerModifier = 1;
        if (type == Pokemon.Type.FIRE && field.hasWaterSport()) {
            basePowerModifier = .43;
        }

        //Sub values into the formulas from bulbapedia.
        double ls = (((((2 * user.getLevel()) / 5) + 2) * (atkStat / defStat) * damage * basePowerModifier) / 50) + 2;
        double mod = getModifier(user, enemy, field, hasCrit);
        double dmg = ls * mod;
        return (int)Math.ceil(dmg);
    }

}
