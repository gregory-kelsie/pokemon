package com.pokemon.toronto.game.com.pokemon.toronto.skill;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug.StickyWeb;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug.StringShot;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Dark.Bite;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Electric.ThunderShock;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Fire.Ember;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.Acrobatics;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.AerialAce;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.Aeroblast;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.AirCutter;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.AirSlash;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.Bounce;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.BraveBird;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.Chatter;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.Defog;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.DrillPeck;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.FeatherDance;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.Fly;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.Gust;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.Hurricane;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.Peck;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.Pluck;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.Roost;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ghost.ConfuseRay;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ghost.Curse;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ghost.Nightmare;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.Absorb;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.Aromatherapy;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.BulletSeed;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.CottonGuard;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.CottonSpore;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.EnergyBall;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.FrenzyPlant;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.GigaDrain;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.GrassWhistle;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.HornLeech;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.Ingrain;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.LeafBlade;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.LeafStorm;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.LeafTornado;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.Leafage;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.LeechSeed;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.MagicalLeaf;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.MegaDrain;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.NeedleArm;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.PetalBlizzard;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.PetalDance;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.PowerWhip;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.RazorLeaf;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.SeedBomb;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.SeedFlare;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.SleepPowder;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.SolarBeam;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.SolarBlade;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.Spore;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.StrengthSap;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.StunSpore;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.Synthesis;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.TropKick;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.VineWhip;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.WoodHammer;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ground.SandAttack;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ground.Spikes;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.AuroraBeam;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.Avalanche;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.Blizzard;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.FreezeDry;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.FrostBreath;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.Hail;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.Haze;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.IceBall;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.IceBeam;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.IceFang;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.IceHammer;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.IcePunch;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.IceShard;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.IcicleCrash;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.IcicleSpear;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.IcyWind;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.Mist;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.PowderSnow;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.SheerCold;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Bind;
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
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.Accelerock;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.AncientPower;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.HeadSmash;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.PowerGem;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.RockBlast;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.RockPolish;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.RockSlide;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.RockThrow;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.RockTomb;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.RockWrecker;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.Rollout;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.Sandstorm;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.StealthRock;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.StoneEdge;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel.Autotomize;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel.BulletPunch;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel.DoomDesire;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel.FlashCannon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel.GearGrind;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel.GyroBall;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel.IronDefense;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel.IronHead;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel.IronTail;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel.MagnetBomb;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel.MetalBurst;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel.MetalClaw;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel.MetalSound;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel.MeteorMash;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel.MirrorShot;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel.ShiftGear;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel.SmartStrike;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel.SteelWing;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.AquaJet;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.AquaRing;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.AquaTail;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.Brine;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.Bubble;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.Bubblebeam;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.Clamp;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.Crabhammer;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.Dive;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.HydroCannon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.HydroPump;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.Liquidation;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.MuddyWater;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.Octazooka;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.RainDance;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.RazorShell;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.Scald;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.SparklingAria;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.Surf;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.WaterGun;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.WaterPulse;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.WaterShuriken;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.WaterSport;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.WaterSpout;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.Waterfall;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.Withdraw;

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
    public static final int BIND = 39;
    public static final int SURF = 40;
    public static final int WHIRLPOOL = 41;
    public static final int AQUA_JET = 42;
    public static final int AQUA_TAIL = 43;
    public static final int BRINE = 44;
    public static final int BUBBLE = 45;
    public static final int BUBBLEBEAM = 46;
    public static final int CLAMP = 47;
    public static final int CRABHAMMER = 48;
    public static final int DIVE = 49;
    public static final int HYDRO_CANNON = 50;
    public static final int HYDRO_PUMP = 51;
    public static final int LIQUIDATION = 52;
    public static final int MUDDY_WATER = 53;
    public static final int OCTAZOOKA = 54;
    public static final int RAIN_DANCE = 55;
    public static final int RAZOR_SHELL = 56;
    public static final int SCALD = 57;
    public static final int SPARKLING_ARIA = 58;
    public static final int WATER_GUN = 59;
    public static final int WATER_PULSE = 60;
    public static final int WATER_SHURIKEN = 61;
    public static final int WATER_SPOUT = 62;
    public static final int WATERFALL = 63;
    public static final int WITHDRAW = 64;
    public static final int WATER_SPORT = 65;
    public static final int ACCELEROCK = 66;
    public static final int ANCIENT_POWER = 67;
    public static final int HEAD_SMASH = 68;
    public static final int POWER_GEM = 69;
    public static final int ROCK_BLAST = 70;
    public static final int ROCK_POLISH = 71;
    public static final int ROCK_SLIDE = 72;
    public static final int ROCK_THROW = 73;
    public static final int ROCK_TOMB = 74;
    public static final int ROCK_WRECKER = 75;
    public static final int ROLLOUT = 76;
    public static final int SANDSTORM = 77;
    public static final int STONE_EDGE = 78;
    public static final int AUTOTOMIZE = 79;
    public static final int BULLET_PUNCH = 80;
    public static final int FLASH_CANNON = 81;
    public static final int GEAR_GRIND = 82;
    public static final int GYRO_BALL = 83;
    public static final int IRON_DEFENSE = 84;
    public static final int IRON_HEAD = 85;
    public static final int IRON_TAIL = 86;
    public static final int MAGNET_BOMB = 87;
    public static final int METAL_BURST = 88;
    public static final int METAL_CLAW = 89;
    public static final int METAL_SOUND = 90;
    public static final int METEOR_MASH = 91;
    public static final int MIRROR_SHOT = 92;
    public static final int SHIFT_GEAR = 93;
    public static final int SMART_STRIKE = 94;
    public static final int STEEL_WING = 95;
    public static final int AURORA_BEAM = 96;
    public static final int AVALANCHE = 97;
    public static final int BLIZZARD = 98;
    public static final int FREEZE_DRY = 99;
    public static final int FROST_BREATH = 100;
    public static final int HAZE = 101;
    public static final int ICE_BALL = 102;
    public static final int ICE_BEAM = 103;
    public static final int ICE_FANG = 104;
    public static final int ICE_HAMMER = 105;
    public static final int ICE_PUNCH = 106;
    public static final int ICE_SHARD = 107;
    public static final int ICICLE_CRASH = 108;
    public static final int ICICLE_SPEAR = 109;
    public static final int ICY_WIND = 110;
    public static final int MIST = 111;
    public static final int POWDER_SNOW = 112;
    public static final int SHEER_COLD = 113;
    public static final int ABSORB = 114;
    public static final int BULLET_SEED = 115;
    public static final int COTTON_GUARD = 116;
    public static final int COTTON_SPORE = 117;
    public static final int ENERGY_BALL = 118;
    public static final int FRENZY_PLANT = 119;
    public static final int GRASS_WHISTLE = 120;
    public static final int HORN_LEECH = 121;
    public static final int LEAFAGE = 122;
    public static final int LEAF_BLADE = 123;
    public static final int LEAF_STORM = 124;
    public static final int LEAF_TORNADO = 125;
    public static final int MAGICAL_LEAF = 126;
    public static final int MEGA_DRAIN = 127;
    public static final int NEEDLE_ARM = 128;
    public static final int PETAL_BLIZZARD = 129;
    public static final int POWER_WHIP = 130;
    public static final int RAZOR_LEAF = 131;
    public static final int SEED_BOMB = 132;
    public static final int SEED_FLARE = 133;
    public static final int SOLAR_BEAM = 134;
    public static final int SOLAR_BLADE = 135;
    public static final int SPORE = 136;
    public static final int SYNTHESIS = 137;
    public static final int STRENGTH_SAP = 138;
    public static final int STUN_SPORE = 139;
    public static final int TROP_KICK = 140;
    public static final int VINE_WHIP = 141;
    public static final int WOOD_HAMMER = 142;
    public static final int ACROBATICS = 143;
    public static final int AERIAL_ACE = 144;
    public static final int AEROBLAST = 145;
    public static final int AIR_CUTTER = 146;
    public static final int AIR_SLASH = 147;
    public static final int BOUNCE = 148;
    public static final int BRAVE_BIRD = 149;
    public static final int CHATTER = 150;
    public static final int DEFOG = 151;
    public static final int DRILL_PECK = 152;
    public static final int FEATHER_DANCE = 153;
    public static final int FLY = 154;
    public static final int GUST = 155;
    public static final int HURRICANE = 156;
    public static final int PLUCK = 157;
    public static final int ROOST = 158;

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
        } else if (skillId == BIND) {
            return new Bind();
        } else if (skillId == AQUA_JET) {
            return new AquaJet();
        } else if (skillId == AQUA_TAIL) {
            return new AquaTail();
        } else if (skillId == BRINE) {
            return new Brine();
        } else if (skillId == BUBBLE) {
            return new Bubble();
        } else if (skillId == BUBBLEBEAM) {
            return new Bubblebeam();
        } else if (skillId == CLAMP) {
            return new Clamp();
        } else if (skillId == CRABHAMMER) {
            return new Crabhammer();
        } else if (skillId == DIVE) {
            return new Dive();
        } else if (skillId == HYDRO_CANNON) {
            return new HydroCannon();
        } else if (skillId == HYDRO_PUMP) {
            return new HydroPump();
        } else if (skillId == LIQUIDATION) {
            return new Liquidation();
        } else if (skillId == MUDDY_WATER) {
            return new MuddyWater();
        } else if (skillId == OCTAZOOKA) {
            return new Octazooka();
        } else if (skillId == RAIN_DANCE) {
            return new RainDance();
        } else if (skillId == RAZOR_SHELL) {
            return new RazorShell();
        } else if (skillId == SCALD) {
            return new Scald();
        } else if (skillId == SPARKLING_ARIA) {
            return new SparklingAria();
        } else if (skillId == SURF) {
            return new Surf();
        } else if (skillId == WATER_GUN) {
            return new WaterGun();
        } else if (skillId == WATER_PULSE) {
            return new WaterPulse();
        } else if (skillId == WATER_SHURIKEN) {
            return new WaterShuriken();
        } else if (skillId == WATER_SPOUT) {
            return new WaterSpout();
        } else if (skillId == WATERFALL) {
            return new Waterfall();
        } else if (skillId == WITHDRAW) {
            return new Withdraw();
        } else if (skillId == WATER_SPORT) {
            return new WaterSport();
        } else if (skillId == ACCELEROCK) {
            return new Accelerock();
        } else if (skillId == ANCIENT_POWER) {
            return new AncientPower();
        } else if (skillId == HEAD_SMASH) {
            return new HeadSmash();
        } else if (skillId == POWER_GEM) {
            return new PowerGem();
        } else if (skillId == ROCK_BLAST) {
            return new RockBlast();
        } else if (skillId == ROCK_POLISH) {
            return new RockPolish();
        } else if (skillId == ROCK_SLIDE) {
            return new RockSlide();
        } else if (skillId == ROCK_THROW) {
            return new RockThrow();
        } else if (skillId == ROCK_TOMB) {
            return new RockTomb();
        } else if (skillId == ROCK_WRECKER) {
            return new RockWrecker();
        } else if (skillId == ROLLOUT) {
            return new Rollout();
        } else if (skillId == SANDSTORM) {
            return new Sandstorm();
        } else if (skillId == STONE_EDGE) {
            return new StoneEdge();
        } else if (skillId == AUTOTOMIZE) {
            return new Autotomize();
        } else if (skillId == BULLET_PUNCH) {
            return new BulletPunch();
        } else if (skillId == FLASH_CANNON) {
            return new FlashCannon();
        } else if (skillId == GEAR_GRIND) {
            return new GearGrind();
        } else if (skillId == GYRO_BALL) {
            return new GyroBall();
        } else if (skillId == IRON_DEFENSE) {
            return new IronDefense();
        } else if (skillId == IRON_HEAD) {
            return new IronHead();
        } else if (skillId == IRON_TAIL) {
            return new IronTail();
        } else if (skillId == MAGNET_BOMB) {
            return new MagnetBomb();
        } else if (skillId == METAL_BURST) {
            return new MetalBurst();
        } else if (skillId == METAL_CLAW) {
            return new MetalClaw();
        } else if (skillId == METAL_SOUND) {
            return new MetalSound();
        } else if (skillId == METEOR_MASH) {
            return new MeteorMash();
        } else if (skillId == MIRROR_SHOT) {
            return new MirrorShot();
        } else if (skillId == SHIFT_GEAR) {
            return new ShiftGear();
        } else if (skillId == SMART_STRIKE) {
            return new SmartStrike();
        } else if (skillId == STEEL_WING) {
            return new SteelWing();
        } else if (skillId == AURORA_BEAM) {
            return new AuroraBeam();
        } else if (skillId == AVALANCHE) {
            return new Avalanche();
        } else if (skillId == BLIZZARD) {
            return new Blizzard();
        } else if (skillId == FREEZE_DRY) {
            return new FreezeDry();
        } else if (skillId == FROST_BREATH) {
            return new FrostBreath();
        } else if (skillId == HAZE) {
            return new Haze();
        } else if (skillId == ICE_BALL) {
            return new IceBall();
        } else if (skillId == ICE_BEAM) {
            return new IceBeam();
        } else if (skillId == ICE_FANG) {
            return new IceFang();
        } else if (skillId == ICE_HAMMER) {
            return new IceHammer();
        } else if (skillId == ICE_PUNCH) {
            return new IcePunch();
        } else if (skillId == ICE_SHARD) {
            return new IceShard();
        } else if (skillId == ICICLE_CRASH) {
            return new IcicleCrash();
        } else if (skillId == ICICLE_SPEAR) {
            return new IcicleSpear();
        } else if (skillId == ICY_WIND) {
            return new IcyWind();
        } else if (skillId == MIST) {
            return new Mist();
        } else if (skillId == POWDER_SNOW) {
            return new PowderSnow();
        } else if (skillId == SHEER_COLD) {
            return new SheerCold();
        } else if (skillId == ABSORB) {
            return new Absorb();
        } else if (skillId == BULLET_SEED) {
            return new BulletSeed();
        } else if (skillId == COTTON_GUARD) {
            return new CottonGuard();
        } else if (skillId == COTTON_SPORE) {
            return new CottonSpore();
        } else if (skillId == ENERGY_BALL) {
            return new EnergyBall();
        } else if (skillId == FRENZY_PLANT) {
            return new FrenzyPlant();
        } else if (skillId == GRASS_WHISTLE) {
            return new GrassWhistle();
        } else if (skillId == HORN_LEECH) {
            return new HornLeech();
        } else if (skillId == LEAFAGE) {
            return new Leafage();
        } else if (skillId == LEAF_BLADE) {
            return new LeafBlade();
        } else if (skillId == LEAF_STORM) {
            return new LeafStorm();
        } else if (skillId == LEAF_TORNADO) {
            return new LeafTornado();
        } else if (skillId == MAGICAL_LEAF) {
            return new MagicalLeaf();
        } else if (skillId == MEGA_DRAIN) {
            return new MegaDrain();
        } else if (skillId == NEEDLE_ARM) {
            return new NeedleArm();
        } else if (skillId == PETAL_BLIZZARD) {
            return new PetalBlizzard();
        } else if (skillId == POWER_WHIP) {
            return new PowerWhip();
        } else if (skillId == RAZOR_LEAF) {
            return new RazorLeaf();
        } else if (skillId == SEED_BOMB) {
            return new SeedBomb();
        } else if (skillId == SEED_FLARE) {
            return new SeedFlare();
        } else if (skillId == SOLAR_BEAM) {
            return new SolarBeam();
        } else if (skillId == SOLAR_BLADE) {
            return new SolarBlade();
        } else if (skillId == SPORE) {
            return new Spore();
        } else if (skillId == SYNTHESIS) {
            return new Synthesis();
        } else if (skillId == STRENGTH_SAP) {
            return new StrengthSap();
        } else if (skillId == STUN_SPORE) {
            return new StunSpore();
        } else if (skillId == TROP_KICK) {
            return new TropKick();
        } else if (skillId == VINE_WHIP) {
            return new VineWhip();
        } else if (skillId == WOOD_HAMMER) {
            return new WoodHammer();
        } else if (skillId == ACROBATICS) {
            return new Acrobatics();
        } else if (skillId == AERIAL_ACE) {
            return new AerialAce();
        } else if (skillId == AEROBLAST) {
            return new Aeroblast();
        } else if (skillId == AIR_CUTTER) {
            return new AirCutter();
        } else if (skillId == AIR_SLASH) {
            return new AirSlash();
        } else if (skillId == BOUNCE) {
            return new Bounce();
        } else if (skillId == BRAVE_BIRD) {
            return new BraveBird();
        } else if (skillId == CHATTER) {
            return new Chatter();
        } else if (skillId == DEFOG) {
            return new Defog();
        } else if (skillId == DRILL_PECK) {
            return new DrillPeck();
        } else if (skillId == FEATHER_DANCE) {
            return new FeatherDance();
        } else if (skillId == FLY) {
            return new Fly();
        } else if (skillId == GUST) {
            return new Gust();
        } else if (skillId == HURRICANE) {
            return new Hurricane();
        } else if (skillId == PLUCK) {
            return new Pluck();
        } else if (skillId == ROOST) {
            return new Roost();
        }
        else {
            return new Covet();
        }
    }
}
