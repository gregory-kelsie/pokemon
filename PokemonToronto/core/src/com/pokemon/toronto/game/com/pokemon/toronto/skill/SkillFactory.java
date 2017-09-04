package com.pokemon.toronto.game.com.pokemon.toronto.skill;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug.StickyWeb;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug.StringShot;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Dark.Bite;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Electric.ThunderShock;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Fire.Ember;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.Peck;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ghost.ConfuseRay;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ghost.Curse;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ghost.Nightmare;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.Aromatherapy;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.GigaDrain;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.Ingrain;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.LeechSeed;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.PetalDance;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.SleepPowder;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ground.SandAttack;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ground.Spikes;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.Hail;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Covet;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.DoubleSlap;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.FocusEnergy;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Growl;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Harden;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Leer;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.QuickAttack;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Scratch;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.SelfDestruct;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.SkullBash;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Tackle;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.TailWhip;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.TakeDown;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Wish;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Poison.PoisonPowder;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Poison.PoisonSting;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Poison.ToxicSpikes;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic.FutureSight;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.StealthRock;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel.DoomDesire;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.AquaRing;

/**
 * Created by Gregory on 6/15/2017.
 */
public class SkillFactory {

    //Skill IDs
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
    public static final int TAKE_DOWN = 12;
    public static final int DOUBLE_SLAP = 13;
    public static final int CONFUSE_RAY = 14;
    public static final int SLEEP_POWDER = 15;
    public static final int EMBER = 16;
    public static final int BITE = 17;
    public static final int FOCUS_ENERGY = 18;
    public static final int HAIL = 19;
    public static final int SELF_DESTRUCT = 20;
    public static final int PETAL_DANCE = 21;
    public static final int SKULL_BASH = 22;
    public static final int GIGA_DRAIN = 23;
    public static final int STEALTH_ROCK = 24;
    public static final int SPIKES = 25;
    public static final int TOXIC_SPIKES = 26;
    public static final int STICKY_WEB = 27;
    public static final int HARDEN = 28;
    public static final int FUTURE_SIGHT = 29;
    public static final int DOOM_DESIRE = 30;
    public static final int WISH = 31;
    public static final int AQUA_RING = 32;
    public static final int INGRAIN = 33;
    public static final int LEECH_SEED = 34;
    public static final int POISON_POWDER = 35;
    public static final int NIGHTMARE = 36;
    public static final int CURSE = 37;
    public static final int AROMATHERAPY = 38;

    public SkillFactory() {

    }

    /**
     * Return a new skill based on the skill id.
     * @param skillId The skill id of the skill to be created.
     * @return A new skill with skillId
     */
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
        } else if (skillId == TAKE_DOWN) {
            return new TakeDown();
        } else if (skillId == DOUBLE_SLAP) {
            return new DoubleSlap();
        } else if (skillId == CONFUSE_RAY) {
            return new ConfuseRay();
        } else if (skillId == SLEEP_POWDER) {
            return new SleepPowder();
        } else if (skillId == EMBER) {
            return new Ember();
        } else if (skillId == BITE) {
            return new Bite();
        } else if (skillId == FOCUS_ENERGY) {
            return new FocusEnergy();
        } else if (skillId == HAIL) {
            return new Hail();
        } else if (skillId == SELF_DESTRUCT) {
            return new SelfDestruct();
        } else if (skillId == PETAL_DANCE) {
            return new PetalDance();
        } else if (skillId == SKULL_BASH) {
            return new SkullBash();
        } else if (skillId == GIGA_DRAIN) {
            return new GigaDrain();
        } else if (skillId == STEALTH_ROCK) {
            return new StealthRock();
        } else if (skillId == SPIKES) {
            return new Spikes();
        } else if (skillId == TOXIC_SPIKES) {
            return new ToxicSpikes();
        } else if (skillId == STICKY_WEB) {
            return new StickyWeb();
        } else if (skillId == HARDEN) {
            return new Harden();
        } else if (skillId == FUTURE_SIGHT) {
            return new FutureSight();
        } else if (skillId == DOOM_DESIRE) {
            return new DoomDesire();
        } else if (skillId == WISH) {
            return new Wish();
        } else if (skillId == AQUA_RING) {
            return new AquaRing();
        } else if (skillId == INGRAIN) {
            return new Ingrain();
        } else if (skillId == LEECH_SEED) {
            return new LeechSeed();
        } else if (skillId == POISON_POWDER) {
            return new PoisonPowder();
        } else if (skillId == NIGHTMARE) {
            return new Nightmare();
        } else if (skillId == CURSE) {
            return new Curse();
        } else if (skillId == AROMATHERAPY) {
            return new Aromatherapy();
        }
        else {
            return new Covet();
        }
    }
}
