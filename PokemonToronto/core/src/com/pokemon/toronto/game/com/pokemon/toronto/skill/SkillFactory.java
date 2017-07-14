package com.pokemon.toronto.game.com.pokemon.toronto.skill;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug.StringShot;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Electric.ThunderShock;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.Peck;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ground.SandAttack;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Covet;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Growl;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Leer;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.QuickAttack;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Scratch;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Tackle;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.TailWhip;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Poison.PoisonSting;

/**
 * Created by Gregory on 6/15/2017.
 */
public class SkillFactory {

    public static final int SCRATCH = 0;
    public static final int TACKLE = 1;
    public static final int QUICK_ATTACK = 2;
    public static final int GROWL = 3;
    public static final int LEER = 4;
    public static final int TAIL_WHIP = 5;
    public static final int SAND_ATTACK = 6;
    public static final int PECK = 7;
    public static final int STRING_SHOT = 8;
    public static final int POISON_STING = 9;
    public static final int COVET = 10;
    public static final int THUNDER_SHOCK = 11;

    public SkillFactory() {

    }

    public Skill createSkill(int skillId) {
        if (skillId == SCRATCH) {
            return new Scratch();
        } else if (skillId == TACKLE) {
            return new Tackle();
        } else if (skillId == QUICK_ATTACK) {
            return new QuickAttack();
        }  else if (skillId == GROWL) {
            return new Growl();
        }  else if (skillId == LEER) {
            return new Leer();
        }  else if (skillId == TAIL_WHIP) {
            return new TailWhip();
        }  else if (skillId == SAND_ATTACK) {
            return new SandAttack();
        }  else if (skillId == PECK) {
            return new Peck();
        }  else if (skillId == STRING_SHOT) {
            return new StringShot();
        }  else if (skillId == POISON_STING) {
            return new PoisonSting();
        } else if (skillId == THUNDER_SHOCK) {
            return new ThunderShock();
        }else {
            return new Covet();
        }
    }
}
