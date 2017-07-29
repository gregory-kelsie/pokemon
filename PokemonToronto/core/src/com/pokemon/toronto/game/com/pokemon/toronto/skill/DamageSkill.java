package com.pokemon.toronto.game.com.pokemon.toronto.skill;

import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.skill.TackleAnimation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/18/2017.
 */
public abstract class DamageSkill extends Skill {
    private int crit; //Initial Crit Stage
    private int damage;
    public DamageSkill(String name, int maxPP, Pokemon.Type type, SkillCategory category, int damage, int crit) {
        super(name, maxPP, type, category);
        this.crit = crit;
        this.damage = damage;
    }

    @Override
    public List<List<String>> use(Pokemon skillUser, Pokemon enemyPokemon) {
        super.use(skillUser, enemyPokemon);
        List<List<String>> fullList = new ArrayList<List<String>>();
        //The list that says if the pokemon missed or failed. The text before the move animation.
        List<String> firstList = new ArrayList<String>();
        //The list that says if the pokemon crit or if the move was super effective or if the pokemon fainted
        //It comes after the animation
        List<String> secondList = new ArrayList<String>();
        boolean skillMissed = checkMiss();
        boolean skillFailed = checkFail();

        if (!skillMissed && !skillFailed) {
            boolean hasCrit = false;

            if (moveIsSuperEffective(enemyPokemon)) {
                secondList.add("It was super effective!");
            } else if (moveIsNotVeryEffective(enemyPokemon)) {
                secondList.add("It was not very effective...");
            }
            if (hasCrit) {
                secondList.add("Critical Hit!");
            }
            int damage = getDamage(skillUser, enemyPokemon, new Field(), hasCrit);
            enemyPokemon.subtractHealth(damage);

            secondList.add("Dealt " + damage + " damage.");
            if (enemyPokemon.getCurrentHealth() == 0) {
                secondList.add(enemyPokemon.getName() + " fainted.");
            }

        } else {
            if (skillFailed) {
                firstList.add("It failed...");
            } else {
                firstList.add("It missed...");
            }
            fullList.add(firstList);
            return fullList;
        }
        fullList.add(firstList);
        fullList.add(secondList);
        return fullList;
    }

    private boolean moveIsSuperEffective(Pokemon enemyPokemon) {
        if (enemyPokemon.getResistances().get(this.type) > 1) {
            return true;
        } else {
            return false;
        }
    }

    private boolean moveIsNotVeryEffective(Pokemon enemyPokemon) {
        if (enemyPokemon.getResistances().get(this.type) < 1) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkMiss() {
        return false;
    }

    private boolean checkFail() {
        return false;
    }


    private boolean calcCrit(Pokemon user) {
        //return true;
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

    public int getBaseDamage() {
        return damage;
    }

    //Calculate the modifier in the damage calculation formula http://bulbapedia.bulbagarden.net/wiki/Damage
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

	/*
	* 	Return the attacker's STAB modifier
	*	@param Pokemon user - The Attacker
	*/
    public double getStabModifier(Pokemon user) {
        if (user.getTypeOne() == this.getType() || user.getTypeTwo() == this.getType()) {
            if (user.getAbility() == Pokemon.Ability.ADAPTABILITY) {
                return 2;
            }
            return 1.5;
        } else {
            return 1;
        }
    }

	/*
	* 	Return the effectiveness modifier (0.25, 0.5, 1, 2, 4)
	*	@param Pokemon user - The Attacker
	*	@param Pokemon enemy - The pokemon that gets attacked
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


	/*
	* 	Return the crit multiplier when determining the damage dealt.
	*	@param Pokemon user - The Attacker
	*	@param Boolean crit - Whether or not the attacker got a crit
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

	/*
	* 	Return the attacker's ability multiplier when determining the damage dealt.
	*	@param Pokemon user - The Attacker
	*/
    private double getAbilityMod (Pokemon user) {
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
        if (user.getAbility() == Pokemon.Ability.GUTS && (user.getStatus() == Pokemon.Status.BURN
                || user.getStatus() == Pokemon.Status.PARALYSIS || user.getStatus() == Pokemon.Status.POISON)) {
            return 1.5;
        }
        if (user.getAbility() == Pokemon.Ability.HUSTLE) {
            return 1.5;
        }
        return 1;
    }

	/*
	* 	Return the defender's ability multiplier when determining the damage taken.
	*	@param Pokemon enemy - The pokemon that's getting attacked
	*/
    private double getDefenseAbilityMod(Pokemon enemy) {
        //Dry skin thick fat, heatproof
        if (this.getType() == Pokemon.Type.FIRE) {
            if (enemy.getAbility() == Pokemon.Ability.THICK_FAT || enemy.getAbility()
                    == Pokemon.Ability.DRY_SKIN || enemy.getAbility() == Pokemon.Ability.HEATPROOF) {
                return 0.5;
            }
        } else if (this.getType() == Pokemon.Type.ICE) {
            if (enemy.getAbility() == Pokemon.Ability.THICK_FAT) {
                return 0.5;
            }
        }
        return 1;
    }


    private double getWeatherMod(Field field) {
        if (field.getWeatherType() == Field.WeatherType.SUN) {
            if (this.getType() == Pokemon.Type.FIRE) {
                return 1.5;
            } else if (this.getType() == Pokemon.Type.WATER) {
                return 0.5;
            }
        } else if (field.getWeatherType() == Field.WeatherType.RAIN) {
            if (this.getType() == Pokemon.Type.FIRE) {
                return 0.5;
            } else if (this.getType() == Pokemon.Type.WATER) {
                return 1.5;
            }
        }
        return 1;
    }

    private int getDamage(Pokemon user, Pokemon enemy, Field field, boolean hasCrit) {
        double atkStat;
        double defStat;

        if (this.category == SkillCategory.PHYSICAL) {
            atkStat = user.getAttackStat();
            if (user.getAttackStage() >= 0) {
                atkStat = atkStat * (1 + (0.5 * user.getAttackStage()));
            }
            else {
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

            if (enemy.getDefenseStage() >= 0) {
                if (!hasCrit) {
                    defStat = defStat * (1 + (0.5 * enemy.getDefenseStage()));
                }
            }
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
        else {
            atkStat = user.getSpecialAttackStat();
            atkStat = atkStat * (1 + (0.5 * user.getSpecialAttackStage()));
            defStat = enemy.getSpecialDefenseStat();
            defStat = defStat * (1 + (0.5 * enemy.getSpecialDefenseStage()));
        }

        double ls = (((((2 * user.getLevel()) / 5) + 2) * (atkStat / defStat) * damage) / 50) + 2;
        double mod = getModifier(user, enemy, field, hasCrit);
        double dmg = ls * mod;
        return (int)Math.round(dmg);
    }

}
