package com.pokemon.toronto.game.com.pokemon.toronto.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Ariados;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Crobat;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Forretress;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Hitmontop;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Houndoom;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Kingdra;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Miltank;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Murkrow;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Piloswine;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Steelix;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Umbreon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.johto.Xatu;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Arbok;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Blastoise;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Charizard;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Clefairy;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Golbat;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Kakuna;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Metapod;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Pidgeotto;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Pidgey;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Pikachu;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes.PokemonId;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Pidgeot;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Raichu;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Venomoth;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Vileplume;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Alakazam;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Arcanine;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Cloyster;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Dewgong;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Gastly;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Gengar;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Geodude;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Growlithe;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Haunter;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Kadabra;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Machamp;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Magnemite;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Muk;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Onix;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Poliwrath;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Ponyta;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Primeape;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Rapidash;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Seel;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Slowbro;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Victreebel;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Voltorb;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Aerodactyl;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Dragonair;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Dragonite;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Exeggutor;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Gyarados;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Hitmonchan;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Hitmonlee;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Jynx;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Koffing;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Lapras;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.MrMime;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Rhydon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Scyther;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Starmie;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Staryu;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Tangela;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Weezing;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug.LeechLife;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Bug.SpiderWeb;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Dark.Bite;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Dark.Crunch;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Dark.DarkPulse;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Dark.FeintAttack;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Dark.NastyPlot;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Dark.Payback;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Dark.SuckerPunch;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Dragon.DragonBreath;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Dragon.DragonClaw;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Dragon.DragonPulse;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Dragon.DragonRage;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Dragon.DragonRush;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Dragon.Outrage;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Dragon.Twister;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Electric.Thunder;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Electric.ThunderFang;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Electric.ThunderPunch;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Electric.ThunderShock;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Electric.ThunderWave;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Electric.Thunderbolt;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Fairy.Moonlight;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting.BrickBreak;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting.BulkUp;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting.CrossChop;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting.FocusBlast;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting.HighJumpKick;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting.MachPunch;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting.Revenge;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting.SkyUppercut;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Fighting.TripleKick;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Fire.BlazeKick;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Fire.FireBlast;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Fire.FireFang;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Fire.FirePunch;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Fire.FireSpin;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Fire.Flamethrower;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Fire.SunnyDay;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.AerialAce;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.AirCutter;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.AirSlash;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.Bounce;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.FeatherDance;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.Gust;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.Pluck;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.Roost;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Flying.WingAttack;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ghost.ConfuseRay;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ghost.Curse;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ghost.Lick;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ghost.NightShade;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ghost.Nightmare;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ghost.OminousWind;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ghost.ShadowBall;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ghost.ShadowClaw;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ghost.ShadowPunch;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.GigaDrain;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.PetalDance;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.SleepPowder;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.SolarBeam;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Grass.StunSpore;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ground.Dig;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ground.Earthquake;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ground.MudBomb;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ground.SandAttack;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ground.SandTomb;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ground.Spikes;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.AuroraBeam;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.Blizzard;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.Hail;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.IceBeam;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.IceFang;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.IcePunch;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.IceShard;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Ice.IcyWind;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Bind;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.BodySlam;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.DoubleEdge;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.DoubleSlap;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.DoubleTeam;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.EggBomb;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Explosion;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.ExtremeSpeed;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Facade;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Flail;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.FocusEnergy;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Growl;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Harden;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.HyperBeam;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Leer;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.LovelyKiss;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.MegaKick;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.MilkDrink;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Minimize;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.QuickAttack;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Recover;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Safeguard;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.ScaryFace;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Screech;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.SelfDestruct;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.SkullBash;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Slam;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Smokescreen;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Snore;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.SonicBoom;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.SpikeCannon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Stomp;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Supersonic;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Swagger;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Swift;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Tackle;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.TakeDown;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.Yawn;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Poison.Acid;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Poison.GunkShot;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Poison.PoisonFang;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Poison.PoisonJab;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Poison.PoisonSting;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Poison.SludgeBomb;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Poison.ToxicSpikes;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic.Amnesia;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic.DreamEater;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic.FutureSight;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic.Hypnosis;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic.LightScreen;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic.Psychic;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic.Reflect;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Psychic.Rest;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.AncientPower;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.RockSlide;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.RockThrow;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.RockTomb;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.Rollout;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Rock.Sandstorm;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel.BulletPunch;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Steel.IronTail;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.AquaTail;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.Clamp;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.Dive;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.HydroPump;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.RainDance;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.Surf;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.WaterPulse;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Water.Waterfall;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.TrainerId;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.WildTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Gregory on 9/5/2017.
 */

public class TrainerFactory {

    private final int MAX_POKEMON = 3;
    private final int MAX_LEVEL = 6;

    public TrainerFactory() {

    }

    private String getMaleName() {
        FileHandle file = Gdx.files.internal("text/male.txt");
        String text = file.readString();
        String[] names = text.split("\n");
        Random r = new Random();
        return names[r.nextInt(names.length)];
    }

    private String getFemaleName() {
        FileHandle file = Gdx.files.internal("text/female.txt");
        String text = file.readString();
        String[] names = text.split("\n");
        Random r = new Random();
        return names[r.nextInt(names.length)];
    }

    private String getVictoryText() {
        FileHandle file = Gdx.files.internal("text/victory.txt");
        String text = file.readString();
        String[] names = text.split("\n");
        Random r = new Random();
        return names[r.nextInt(names.length)];
    }
    
    public List<Pokemon> initParty(List<Integer> pool, double difficulty) {
        int lowLevel = getLowLevel(difficulty);
        int highLevel = getHighLevel(difficulty);
        WildPokemonCreator wpc = new WildPokemonCreator();
        List<Pokemon> party = new ArrayList<Pokemon>();
        int maxNumPokemon = getMaxNumberOfPokemon(difficulty);
        int numPokemon = (int)Math.round(Math.random() * (maxNumPokemon - 1)) + 1;
        if (numPokemon == 1) {
            int poolIndex = (int)Math.round(Math.random() * (pool.size() - 1));
            party.add(wpc.createPokemon(pool.get(poolIndex), highLevel, highLevel, 0));
        } else {
            for (int i = 0; i < numPokemon; i++) {
                int poolIndex = (int)Math.round(Math.random() * (pool.size() - 1));
                party.add(wpc.createPokemon(pool.get(poolIndex), lowLevel, highLevel, 0));
            }
        }
        return party;
    } 

    private int getMaxNumberOfPokemon(double difficulty) {
        if (difficulty == 0.5) {
            return 3;
        } else if (difficulty >= 1 && difficulty <= 3) {
            return 4;
        } else if (difficulty > 3 && difficulty <= 4) {
            return 5;
        } else {
            return 6;
        }
    }

    private int getHighLevel(double difficulty) {
        if (difficulty == 0.5) {
            return 5;
        } else if (difficulty == 1) {
            return 10;
        }  else if (difficulty == 1.5) {
            return 15;
        } else if (difficulty == 2) {
            return 19;
        } else if (difficulty == 2.5) {
            return 24;
        } else if (difficulty == 3) {
            return 30;
        } else if (difficulty == 3.5) {
            return 36;
        } else if (difficulty == 4) {
            return 42;
        } else if (difficulty == 4.5) {
            return 48;
        } else if (difficulty == 5) {
            return 54;
        } else if (difficulty == 5.5) {
            return 60;
        } else if (difficulty == 6) {
            return 67;
        } else if (difficulty == 6.5) {
            return 74;
        } else if (difficulty == 7) {
            return 81;
        } else if (difficulty == 7.5) {
            return 87;
        } else if (difficulty == 8) {
            return 93;
        } else if (difficulty == 8.5) {
            return 99;
        } else if (difficulty == 9) {
            return 99;
        } else if (difficulty == 9.5) {
            return 100;
        } else if (difficulty >= 10) {
            return 100;
        } else {
            return 100;
        }
    }

    private int getLowLevel(double difficulty) {
        if (difficulty == 0.5) {
            return 3;
        } else if (difficulty == 1) {
            return 6;
        }  else if (difficulty == 1.5) {
            return 11;
        } else if (difficulty == 2) {
            return 15;
        } else if (difficulty == 2.5) {
            return 19;
        } else if (difficulty == 3) {
            return 25;
        } else if (difficulty == 3.5) {
            return 31;
        } else if (difficulty == 4) {
            return 37;
        } else if (difficulty == 4.5) {
            return 43;
        } else if (difficulty == 5) {
            return 49;
        } else if (difficulty == 5.5) {
            return 55;
        } else if (difficulty == 6) {
            return 61;
        } else if (difficulty == 6.5) {
            return 68;
        } else if (difficulty == 7) {
            return 75;
        } else if (difficulty == 7.5) {
            return 81;
        } else if (difficulty == 8) {
            return 88;
        } else if (difficulty == 8.5) {
            return 94;
        } else if (difficulty == 9) {
            return 95;
        } else if (difficulty == 9.5) {
            return 95;
        } else if (difficulty >= 10) {
            return 100;
        } else {
            return 5;
        }
    }

    public WildTrainer getTrainer(double difficulty, double latitude, double longitude) {
        double rand = Math.random();
        double[] latlng = PokemonLookup.getRandomLocation(latitude, longitude, 200);
        if (rand <= .33) {
            return getBugCatcher(difficulty, latlng[0], latlng[1]);
        } else if (rand <= .66) {
            return getLass(difficulty, latlng[0], latlng[1]);
        } else {
            return getYoungster(difficulty, latlng[0], latlng[1]);
        }
    }

    public WildTrainer getTrainer(int id, double difficulty, double latitude, double longitude) {
        double[] latlng = PokemonLookup.getRandomLocation(latitude, longitude, 200);
        if (id == TrainerId.BUG_CATCHER.getValue()) {
            return getBugCatcher(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.LASS.getValue()) {
            return getLass(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.ACE_TRAINER_MALE.getValue()) {
            return getAceTrainerMale(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.ACE_TRAINER_FEMALE.getValue()) {
            return getAceTrainerFemale(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.AROMA_LADY.getValue()) {
            return getAromaLady(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.BATTLE_GIRL.getValue()) {
            return getBattleGirl(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.BEAUTY.getValue()) {
            return getBeauty(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.BIRD_KEEPER.getValue()) {
            return getBirdKeeper(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.BLACKBELT.getValue()) {
            return getBlackbelt(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.DOCTOR.getValue()) {
            return getDoctor(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.FIRE_BREATHER.getValue()) {
            return getFirebreather(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.FISHERMAN.getValue()) {
            return getFisherman(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.GAMBLER.getValue()) {
            return getGambler(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.GENTLEMAN.getValue()) {
            return getGentleman(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.HIKER.getValue()) {
            return getHiker(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.JUGGLER.getValue()) {
            return getJuggler(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.KIMONO_GIRL.getValue()) {
            return getKimonoGirl(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.LADY.getValue()) {
            return getLady(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.MEDIUM.getValue()) {
            return getMedium(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.NURSE.getValue()) {
            return getNurse(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.PARASOL_LADY.getValue()) {
            return getParasolLady(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.PICNICKER_MALE.getValue()) {
            return getPicnickerMale(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.PICNICKER_FEMALE.getValue()) {
            return getPicnickerFemale(difficulty, latlng[0], latlng[1]);
        }   else if (id == TrainerId.YOUNGSTER.getValue()) {
            return getYoungster(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.WAITER.getValue() ||
                id == TrainerId.WAITRESS.getValue()) {
            return getWaiter(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.DRAGON_TAMER.getValue()) {
            return getDragonTamer(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.BAKER.getValue()) {
            return getBaker(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.POLICEMAN.getValue()) {
            return getPolice(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.CUE_BALL.getValue()) {
            return getCueBall(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.BIKER.getValue()) {
            return getBiker(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.BURGLAR.getValue()) {
            return getBurglar(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.JANITOR.getValue()) {
            return getJanitor(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.CONDUCTOR.getValue()) {
            return getConductorPokemon(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.PILOT.getValue()) {
            return getPilotPokemon(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.SAGE.getValue()) {
            return getSage(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.SAILOR.getValue()) {
            return getSailor(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.VETERAN_MALE.getValue()) {
            return getVeteranMale(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.VETERAN_FEMALE.getValue()) {
            return getVeteranFemale(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.RUNE_MANIAC.getValue()) {
            return getRuneManiac(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.PSYCHIC.getValue()) {
            return getPsychic(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.RANGER.getValue()) {
            return getRanger(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.RICH_BOY.getValue()) {
            return getRichBoy(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.SCHOOL_KID.getValue()) {
            return getSchoolKid(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.SCIENTIST.getValue()) {
            return getScientist(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.SWIMMER.getValue()) {
            return getSwimmer(difficulty, latlng[0], latlng[1]);
        } else if (id == TrainerId.TEACHER.getValue()) {
            return getTeacher(difficulty, latlng[0], latlng[1]);
        } else {
            return getYoungster(difficulty, latlng[0], latlng[1]);
        }
    }
    public List<Integer> getYoungsterPokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        if (difficulty <= 4) {
            bugCatcherPokemon.add(PokemonId.RATTATA.getValue());
        }
        if (difficulty <= 3.5) {
            bugCatcherPokemon.add(PokemonId.PIDGEY.getValue());
        }
        if (difficulty >= 1.5 && difficulty <= 3.5) {
            bugCatcherPokemon.add(PokemonId.EKANS.getValue());
            bugCatcherPokemon.add(PokemonId.SANDSHREW.getValue());
            bugCatcherPokemon.add(PokemonId.DIGLETT.getValue());
            bugCatcherPokemon.add(PokemonId.PIKACHU.getValue());
            bugCatcherPokemon.add(PokemonId.PARAS.getValue());
            bugCatcherPokemon.add(PokemonId.SPEAROW.getValue());
        }
        if (difficulty >= 2) {
            bugCatcherPokemon.add(PokemonId.PIDGEOTTO.getValue());
        }
        if (difficulty >= 2.5) {
            bugCatcherPokemon.add(PokemonId.RATICATE.getValue());
            bugCatcherPokemon.add(PokemonId.SANDSLASH.getValue());
            bugCatcherPokemon.add(PokemonId.FEAROW.getValue());
            bugCatcherPokemon.add(PokemonId.ARBOK.getValue());
        }
        if (difficulty >= 3) {
            bugCatcherPokemon.add(PokemonId.PARASECT.getValue());
        }
        if (difficulty >= 4) {
            bugCatcherPokemon.add(PokemonId.PIDGEOT.getValue());
        }
        return bugCatcherPokemon;
    }

    public List<Integer> getBugCatcherPokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        if (difficulty <= 3) {
            bugCatcherPokemon.add(PokemonId.CATERPIE.getValue());
            bugCatcherPokemon.add(PokemonId.WEEDLE.getValue());
            bugCatcherPokemon.add(PokemonId.LEDYBA.getValue());
            bugCatcherPokemon.add(PokemonId.GRUBBIN.getValue());
        }
        if (difficulty >= 1.5 && difficulty <= 3) {
            bugCatcherPokemon.add(PokemonId.PARAS.getValue());
        }
        if (difficulty >= 2.5 && difficulty <= 4) {
            bugCatcherPokemon.add(PokemonId.VENONAT.getValue());
            bugCatcherPokemon.add(PokemonId.PINECO.getValue());
            bugCatcherPokemon.add(PokemonId.DEWPIDER.getValue());
            bugCatcherPokemon.add(PokemonId.CHARJABUG.getValue());
        }
        if (difficulty <= 4) {
            bugCatcherPokemon.add(PokemonId.KAKUNA.getValue());
            bugCatcherPokemon.add(PokemonId.METAPOD.getValue());
            bugCatcherPokemon.add(PokemonId.SPINARAK.getValue());
        }
        if (difficulty > 2) {
            bugCatcherPokemon.add(PokemonId.BEEDRILL.getValue());
            bugCatcherPokemon.add(PokemonId.BUTTERFREE.getValue());
            bugCatcherPokemon.add(PokemonId.YANMA.getValue());
        }
        if (difficulty > 2.5) {
            bugCatcherPokemon.add(PokemonId.PARASECT.getValue());
            bugCatcherPokemon.add(PokemonId.ARIADOS.getValue());
        }
        if (difficulty > 3) {
            bugCatcherPokemon.add(PokemonId.VENOMOTH.getValue());
            bugCatcherPokemon.add(PokemonId.PINSIR.getValue());
            bugCatcherPokemon.add(PokemonId.SCYTHER.getValue());
            bugCatcherPokemon.add(PokemonId.HERACROSS.getValue());
        }
        if (difficulty >= 4) {
            bugCatcherPokemon.add(PokemonId.VIKAVOLT.getValue());
            bugCatcherPokemon.add(PokemonId.ARAQUANID.getValue());
        }

        if (difficulty >= 5) {
            bugCatcherPokemon.add(PokemonId.SCIZOR.getValue());
            bugCatcherPokemon.add(PokemonId.FORRETRESS.getValue());
        }

        return bugCatcherPokemon;
    }

    public List<Integer> getLassPokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        bugCatcherPokemon.add(PokemonId.PIKACHU.getValue());
        if (difficulty <= 4) {
            bugCatcherPokemon.add(PokemonId.PIDGEY.getValue());
            bugCatcherPokemon.add(PokemonId.MAREEP.getValue());
            bugCatcherPokemon.add(PokemonId.MARILL.getValue());
        }
        if (difficulty <= 2.5) {
            bugCatcherPokemon.add(PokemonId.SENTRET.getValue());
            bugCatcherPokemon.add(PokemonId.CUTIEFLY.getValue());
            bugCatcherPokemon.add(PokemonId.BONUSWEET.getValue());
        }
        if (difficulty >= 1.5 && difficulty <= 2.5) {
            bugCatcherPokemon.add(PokemonId.NIDORANF.getValue());
            bugCatcherPokemon.add(PokemonId.ODDISH.getValue());
            bugCatcherPokemon.add(PokemonId.CHIKORITA.getValue());
        }
        if (difficulty >= 1.5 && difficulty <= 3.5) {
            bugCatcherPokemon.add(PokemonId.PARAS.getValue());
            bugCatcherPokemon.add(PokemonId.CLEFAIRY.getValue());
            bugCatcherPokemon.add(PokemonId.JIGGLYPUFF.getValue());
            bugCatcherPokemon.add(PokemonId.STUFFUL.getValue());
        }
        if (difficulty >= 2) {
            bugCatcherPokemon.add(PokemonId.PIDGEOTTO.getValue());
            bugCatcherPokemon.add(PokemonId.BAYLEEF.getValue());
            bugCatcherPokemon.add(PokemonId.FURRET.getValue());
            bugCatcherPokemon.add(PokemonId.FLAFFY.getValue());
            bugCatcherPokemon.add(PokemonId.STEENEE.getValue());

        }
        if (difficulty >= 2.5) {
            bugCatcherPokemon.add(PokemonId.NIDORINA.getValue());
            bugCatcherPokemon.add(PokemonId.GLOOM.getValue());
            bugCatcherPokemon.add(PokemonId.AZUMARILL.getValue());
        }
        if (difficulty >= 3) {
            bugCatcherPokemon.add(PokemonId.PARASECT.getValue());
            bugCatcherPokemon.add(PokemonId.BELLOSSOM.getValue());
            bugCatcherPokemon.add(PokemonId.MILTANK.getValue());
            bugCatcherPokemon.add(PokemonId.RIBOMBEE.getValue());
        }
        if (difficulty >= 4) {
            bugCatcherPokemon.add(PokemonId.PIDGEOT.getValue());
            bugCatcherPokemon.add(PokemonId.CLEFABLE.getValue());
            bugCatcherPokemon.add(PokemonId.WIGGLYTUFF.getValue());
            bugCatcherPokemon.add(PokemonId.VILEPLUME.getValue());
            bugCatcherPokemon.add(PokemonId.AMPHAROS.getValue());
            bugCatcherPokemon.add(PokemonId.BEWEAR.getValue());
        }
        if (difficulty >= 5) {
            bugCatcherPokemon.add(PokemonId.NIDOQUEEN.getValue());
            bugCatcherPokemon.add(PokemonId.TSAREENA.getValue());
        }
        return bugCatcherPokemon;
    }

    public List<Integer> getAceTrainerMalePokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        if (difficulty <= 2.5) {
            bugCatcherPokemon.add(PokemonId.CHARMANDER.getValue());
            bugCatcherPokemon.add(PokemonId.SQUIRTLE.getValue());
            bugCatcherPokemon.add(PokemonId.BULBASAUR.getValue());
            bugCatcherPokemon.add(PokemonId.CYNDAQUIL.getValue());
            bugCatcherPokemon.add(PokemonId.TOTODILE.getValue());
            bugCatcherPokemon.add(PokemonId.NIDORANM.getValue());
            bugCatcherPokemon.add(PokemonId.AIPOM.getValue());
            bugCatcherPokemon.add(PokemonId.YANMA.getValue());
            bugCatcherPokemon.add(PokemonId.PINECO.getValue());
        }

        if (difficulty <= 2.5) {
            bugCatcherPokemon.add(PokemonId.HOUNDOUR.getValue());
            bugCatcherPokemon.add(PokemonId.GLIGAR.getValue());
        }

        if (difficulty >= 2 && difficulty <= 4) {
            bugCatcherPokemon.add(PokemonId.PIDGEOTTO.getValue());
            bugCatcherPokemon.add(PokemonId.CHARMELEON.getValue());
            bugCatcherPokemon.add(PokemonId.WARTORTLE.getValue());
            bugCatcherPokemon.add(PokemonId.DARTRIX.getValue());
            bugCatcherPokemon.add(PokemonId.TRUMBEAK.getValue());
            bugCatcherPokemon.add(PokemonId.TORRACAT.getValue());
            bugCatcherPokemon.add(PokemonId.IVYSAUR.getValue());
            bugCatcherPokemon.add(PokemonId.NOCTOWL.getValue());
            bugCatcherPokemon.add(PokemonId.QUILAVA.getValue());
            bugCatcherPokemon.add(PokemonId.CROCONAW.getValue());
            bugCatcherPokemon.add(PokemonId.HAKAMOO.getValue());
        }

        if (difficulty >= 2.5) {
            bugCatcherPokemon.add(PokemonId.SANDSLASH.getValue());
            bugCatcherPokemon.add(PokemonId.BEEDRILL.getValue());
            bugCatcherPokemon.add(PokemonId.STANTLER.getValue());
            bugCatcherPokemon.add(PokemonId.TYPE_NULL.getValue());
        }
        if (difficulty >= 3) {
            bugCatcherPokemon.add(PokemonId.PARASECT.getValue());
            bugCatcherPokemon.add(PokemonId.SEADRA.getValue());
            bugCatcherPokemon.add(PokemonId.GYARADOS.getValue());
            bugCatcherPokemon.add(PokemonId.TAUROS.getValue());
            bugCatcherPokemon.add(PokemonId.PINSIR.getValue());
            bugCatcherPokemon.add(PokemonId.SCYTHER.getValue());
            bugCatcherPokemon.add(PokemonId.HERACROSS.getValue());
            bugCatcherPokemon.add(PokemonId.TENTACRUEL.getValue());
            bugCatcherPokemon.add(PokemonId.MAROWAK.getValue());
            bugCatcherPokemon.add(PokemonId.DONPHAN.getValue());
            bugCatcherPokemon.add(PokemonId.TURTONATOR.getValue());
            bugCatcherPokemon.add(PokemonId.DRAMPA.getValue());

        }
        if (difficulty >= 3.5) {
            bugCatcherPokemon.add(PokemonId.KINGLER.getValue());
            bugCatcherPokemon.add(PokemonId.GOLDUCK.getValue());
            bugCatcherPokemon.add(PokemonId.MACHOKE.getValue());
            bugCatcherPokemon.add(PokemonId.SKARMORY.getValue());
            bugCatcherPokemon.add(PokemonId.LYCANROC_NIGHT.getValue());
            bugCatcherPokemon.add(PokemonId.LYCANROC_DAY.getValue());


        }

        if (difficulty >= 2.5 && difficulty <= 5) {
            bugCatcherPokemon.add(PokemonId.NIDORINO.getValue());
            bugCatcherPokemon.add(PokemonId.RHYHORN.getValue());

        }
        if (difficulty >= 4) {
            bugCatcherPokemon.add(PokemonId.PIDGEOT.getValue());
            bugCatcherPokemon.add(PokemonId.DODRIO.getValue());
            bugCatcherPokemon.add(PokemonId.FEAROW.getValue());
            bugCatcherPokemon.add(PokemonId.KANGASKHAN.getValue());
            bugCatcherPokemon.add(PokemonId.CHARIZARD.getValue());
            bugCatcherPokemon.add(PokemonId.BLASTOISE.getValue());
            bugCatcherPokemon.add(PokemonId.VENUSAUR.getValue());
            bugCatcherPokemon.add(PokemonId.POLIWRATH.getValue());
            bugCatcherPokemon.add(PokemonId.ARCANINE.getValue());
            bugCatcherPokemon.add(PokemonId.RAPIDASH.getValue());
            bugCatcherPokemon.add(PokemonId.MACHAMP.getValue());
            bugCatcherPokemon.add(PokemonId.DRAGONAIR.getValue());
            bugCatcherPokemon.add(PokemonId.RHYDON.getValue());
            bugCatcherPokemon.add(PokemonId.JOLTEON.getValue());
            bugCatcherPokemon.add(PokemonId.FLAREON.getValue());
            bugCatcherPokemon.add(PokemonId.FORRETRESS.getValue());
            bugCatcherPokemon.add(PokemonId.URSARING.getValue());
            bugCatcherPokemon.add(PokemonId.HOUNDOOM.getValue());
            bugCatcherPokemon.add(PokemonId.MUDSDALE.getValue());
            bugCatcherPokemon.add(PokemonId.SILVALLY.getValue());
        }
        if (difficulty >= 5) {
            bugCatcherPokemon.add(PokemonId.NIDOKING.getValue());
            bugCatcherPokemon.add(PokemonId.SNORLAX.getValue());
            bugCatcherPokemon.add(PokemonId.POLITOED.getValue());
            bugCatcherPokemon.add(PokemonId.KINGDRA.getValue());
            bugCatcherPokemon.add(PokemonId.SCIZOR.getValue());
            bugCatcherPokemon.add(PokemonId.VIKAVOLT.getValue());
            bugCatcherPokemon.add(PokemonId.KOMMOO.getValue());
        }
        return bugCatcherPokemon;
    }

    public List<Integer> getAceTrainerFemalePokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        if (difficulty <= 2.5) {
            bugCatcherPokemon.add(PokemonId.CHARMANDER.getValue());
            bugCatcherPokemon.add(PokemonId.SQUIRTLE.getValue());
            bugCatcherPokemon.add(PokemonId.BULBASAUR.getValue());
            bugCatcherPokemon.add(PokemonId.ROWLET.getValue());
            bugCatcherPokemon.add(PokemonId.CHIKORITA.getValue());
            bugCatcherPokemon.add(PokemonId.POPPLIO.getValue());
            bugCatcherPokemon.add(PokemonId.NIDORANF.getValue());
            bugCatcherPokemon.add(PokemonId.CHINCHOU.getValue());
            bugCatcherPokemon.add(PokemonId.MAREEP.getValue());
            bugCatcherPokemon.add(PokemonId.HOPPIP.getValue());
        }
        if (difficulty >= 2 && difficulty <= 4) {
            bugCatcherPokemon.add(PokemonId.PIDGEOTTO.getValue());
            bugCatcherPokemon.add(PokemonId.CHARMELEON.getValue());
            bugCatcherPokemon.add(PokemonId.WARTORTLE.getValue());
            bugCatcherPokemon.add(PokemonId.IVYSAUR.getValue());
            bugCatcherPokemon.add(PokemonId.BAYLEEF.getValue());
            bugCatcherPokemon.add(PokemonId.DARTRIX.getValue());
            bugCatcherPokemon.add(PokemonId.BRIONNE.getValue());
            bugCatcherPokemon.add(PokemonId.FLAFFY.getValue());
            bugCatcherPokemon.add(PokemonId.SKIPLOOM.getValue());
        }

        if (difficulty >= 2.5) {
            bugCatcherPokemon.add(PokemonId.GLOOM.getValue());
            bugCatcherPokemon.add(PokemonId.BUTTERFREE.getValue());
            bugCatcherPokemon.add(PokemonId.MILTANK.getValue());
        }
        if (difficulty >= 3) {
            bugCatcherPokemon.add(PokemonId.WIGGLYTUFF.getValue());
            bugCatcherPokemon.add(PokemonId.SEADRA.getValue());
            bugCatcherPokemon.add(PokemonId.CLEFABLE.getValue());
            bugCatcherPokemon.add(PokemonId.JYNX.getValue());
            bugCatcherPokemon.add(PokemonId.TENTACRUEL.getValue());
            bugCatcherPokemon.add(PokemonId.LANTURN.getValue());
            bugCatcherPokemon.add(PokemonId.TOGETIC.getValue());
        }
        if (difficulty >= 3.5) {
            bugCatcherPokemon.add(PokemonId.STARMIE.getValue());
            bugCatcherPokemon.add(PokemonId.GOLDUCK.getValue());
            bugCatcherPokemon.add(PokemonId.WEEPINBELL.getValue());
            bugCatcherPokemon.add(PokemonId.JUMPLUFF.getValue());

        }

        if (difficulty >= 2.5 && difficulty <= 5) {
            bugCatcherPokemon.add(PokemonId.NIDORINA.getValue());
            bugCatcherPokemon.add(PokemonId.SEEL.getValue());
        }
        if (difficulty >= 4) {
            bugCatcherPokemon.add(PokemonId.PIDGEOT.getValue());
            bugCatcherPokemon.add(PokemonId.DODRIO.getValue());
            bugCatcherPokemon.add(PokemonId.CHARIZARD.getValue());
            bugCatcherPokemon.add(PokemonId.BLASTOISE.getValue());
            bugCatcherPokemon.add(PokemonId.VENUSAUR.getValue());
            bugCatcherPokemon.add(PokemonId.POLIWRATH.getValue());
            bugCatcherPokemon.add(PokemonId.NINETALES.getValue());
            bugCatcherPokemon.add(PokemonId.RAPIDASH.getValue());
            bugCatcherPokemon.add(PokemonId.DEWGONG.getValue());
            bugCatcherPokemon.add(PokemonId.DRAGONAIR.getValue());
            bugCatcherPokemon.add(PokemonId.JOLTEON.getValue());
            bugCatcherPokemon.add(PokemonId.FLAREON.getValue());
            bugCatcherPokemon.add(PokemonId.VAPOREON.getValue());
            bugCatcherPokemon.add(PokemonId.AMPHAROS.getValue());
            bugCatcherPokemon.add(PokemonId.ESPEON.getValue());
            bugCatcherPokemon.add(PokemonId.UMBREON.getValue());
            bugCatcherPokemon.add(PokemonId.MEGANIUM.getValue());
            bugCatcherPokemon.add(PokemonId.PRIMARINA.getValue());
        }
        if (difficulty >= 5) {
            bugCatcherPokemon.add(PokemonId.NIDOKING.getValue());
            bugCatcherPokemon.add(PokemonId.SNORLAX.getValue());
        }
        return bugCatcherPokemon;
    }

    public List<Integer> getAromaLadyPokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        bugCatcherPokemon.add(PokemonId.COMFEY.getValue());
        if (difficulty < 2) {
            bugCatcherPokemon.add(PokemonId.SUNKERN.getValue());
            bugCatcherPokemon.add(PokemonId.HOPPIP.getValue());
            bugCatcherPokemon.add(PokemonId.BONUSWEET.getValue());
        }
        if (difficulty <= 3) {
            bugCatcherPokemon.add(PokemonId.ODDISH.getValue());
            bugCatcherPokemon.add(PokemonId.BELLSPROUT.getValue());
            bugCatcherPokemon.add(PokemonId.BULBASAUR.getValue());
            bugCatcherPokemon.add(PokemonId.CHIKORITA.getValue());
            bugCatcherPokemon.add(PokemonId.FOMANTIS.getValue());
        }
        if (difficulty >= 2 && difficulty <= 4) {
            bugCatcherPokemon.add(PokemonId.WEEPINBELL.getValue());
            bugCatcherPokemon.add(PokemonId.GLOOM.getValue());
            bugCatcherPokemon.add(PokemonId.IVYSAUR.getValue());
            bugCatcherPokemon.add(PokemonId.BAYLEEF.getValue());
            bugCatcherPokemon.add(PokemonId.SKIPLOOM.getValue());
            bugCatcherPokemon.add(PokemonId.STEENEE.getValue());
        }
        if (difficulty >= 3) {
            bugCatcherPokemon.add(PokemonId.TANGELA.getValue());
            bugCatcherPokemon.add(PokemonId.BUTTERFREE.getValue());
            bugCatcherPokemon.add(PokemonId.BELLOSSOM.getValue());
            bugCatcherPokemon.add(PokemonId.SUNFLORA.getValue());
        }
        if (difficulty >= 4) {
            bugCatcherPokemon.add(PokemonId.VENUSAUR.getValue());
            bugCatcherPokemon.add(PokemonId.MEGANIUM.getValue());
            bugCatcherPokemon.add(PokemonId.VICTREEBEL.getValue());
            bugCatcherPokemon.add(PokemonId.JUMPLUFF.getValue());
            bugCatcherPokemon.add(PokemonId.VILEPLUME.getValue());
            bugCatcherPokemon.add(PokemonId.CHANSEY.getValue());
            bugCatcherPokemon.add(PokemonId.TSAREENA.getValue());
            bugCatcherPokemon.add(PokemonId.LURANTIS.getValue());
        }
        return bugCatcherPokemon;
    }

    public List<Integer> getBattleGirlPokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        if (difficulty <= 2) {
            bugCatcherPokemon.add(PokemonId.TYROGUE.getValue());
        }
        if (difficulty <= 3.5) {
            bugCatcherPokemon.add(PokemonId.MACHOP.getValue());
            bugCatcherPokemon.add(PokemonId.MANKEY.getValue());
        }
        if (difficulty >= 2.5) {
            bugCatcherPokemon.add(PokemonId.PASSIMIAN.getValue());
        }
        if (difficulty >= 3) {
            bugCatcherPokemon.add(PokemonId.PRIMEAPE.getValue());
            bugCatcherPokemon.add(PokemonId.MACHOKE.getValue());
        }
        if (difficulty <= 3.5) {
            bugCatcherPokemon.add(PokemonId.HITMONLEE.getValue());
            bugCatcherPokemon.add(PokemonId.HITMONCHAN.getValue());
        }
        if (difficulty >= 4) {
            bugCatcherPokemon.add(PokemonId.MACHAMP.getValue());
        }
        return bugCatcherPokemon;
    }

    public List<Integer> getBeautyPokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        bugCatcherPokemon.add(PokemonId.ORICORIO_SENSU.getValue());
        bugCatcherPokemon.add(PokemonId.ORICORIO_PAU.getValue());
        bugCatcherPokemon.add(PokemonId.ORICORIO_BAILE.getValue());
        bugCatcherPokemon.add(PokemonId.ORICORIO_POM.getValue());
        bugCatcherPokemon.add(PokemonId.COMFEY.getValue());
        if (difficulty <= 2) {
            bugCatcherPokemon.add(PokemonId.SMOOCHUM.getValue());
            bugCatcherPokemon.add(PokemonId.TOGEPI.getValue());
            bugCatcherPokemon.add(PokemonId.HOPPIP.getValue());
            bugCatcherPokemon.add(PokemonId.PICHU.getValue());
            bugCatcherPokemon.add(PokemonId.CLEFFA.getValue());
            bugCatcherPokemon.add(PokemonId.IGGLYBUFF.getValue());
            bugCatcherPokemon.add(PokemonId.SUNKERN.getValue());
            bugCatcherPokemon.add(PokemonId.CUTIEFLY.getValue());
            bugCatcherPokemon.add(PokemonId.BONUSWEET.getValue());
        }
        if (difficulty <= 3) {
            bugCatcherPokemon.add(PokemonId.ODDISH.getValue());
            bugCatcherPokemon.add(PokemonId.BELLSPROUT.getValue());
            bugCatcherPokemon.add(PokemonId.BULBASAUR.getValue());
            bugCatcherPokemon.add(PokemonId.CHIKORITA.getValue());
            bugCatcherPokemon.add(PokemonId.CLEFAIRY.getValue());
            bugCatcherPokemon.add(PokemonId.JIGGLYPUFF.getValue());
            bugCatcherPokemon.add(PokemonId.MARILL.getValue());
            bugCatcherPokemon.add(PokemonId.POLIWAG.getValue());
            bugCatcherPokemon.add(PokemonId.MEOWTH.getValue());
            bugCatcherPokemon.add(PokemonId.PSYDUCK.getValue());
            bugCatcherPokemon.add(PokemonId.EEVEE.getValue());
            bugCatcherPokemon.add(PokemonId.SNUBBULL.getValue());
            bugCatcherPokemon.add(PokemonId.TEDDIURSA.getValue());
            bugCatcherPokemon.add(PokemonId.FOMANTIS.getValue());
            bugCatcherPokemon.add(PokemonId.STUFFUL.getValue());
        }
        if (difficulty >= 2 && difficulty <= 4) {
            bugCatcherPokemon.add(PokemonId.WEEPINBELL.getValue());
            bugCatcherPokemon.add(PokemonId.GLOOM.getValue());
            bugCatcherPokemon.add(PokemonId.IVYSAUR.getValue());
            bugCatcherPokemon.add(PokemonId.HORSEA.getValue());
            bugCatcherPokemon.add(PokemonId.GOLDEEN.getValue());
            bugCatcherPokemon.add(PokemonId.SKIPLOOM.getValue());
            bugCatcherPokemon.add(PokemonId.BAYLEEF.getValue());
            bugCatcherPokemon.add(PokemonId.BRIONNE.getValue());
            bugCatcherPokemon.add(PokemonId.MAREANIE.getValue());
            bugCatcherPokemon.add(PokemonId.STEENEE.getValue());

        }
        if (difficulty >= 3) {
            bugCatcherPokemon.add(PokemonId.TANGELA.getValue());
            bugCatcherPokemon.add(PokemonId.BUTTERFREE.getValue());
            bugCatcherPokemon.add(PokemonId.PERSIAN.getValue());
            bugCatcherPokemon.add(PokemonId.AZUMARILL.getValue());
            bugCatcherPokemon.add(PokemonId.GRANBULL.getValue());
            bugCatcherPokemon.add(PokemonId.RIBOMBEE.getValue());
            bugCatcherPokemon.add(PokemonId.KOMALA.getValue());
            bugCatcherPokemon.add(PokemonId.BRUXISH.getValue());
        }
        if (difficulty >= 3.5) {
            bugCatcherPokemon.add(PokemonId.SALAZZLE.getValue());
        }
        if (difficulty >= 4) {
            bugCatcherPokemon.add(PokemonId.BEWEAR.getValue());
            bugCatcherPokemon.add(PokemonId.VENUSAUR.getValue());
            bugCatcherPokemon.add(PokemonId.LURANTIS.getValue());
            bugCatcherPokemon.add(PokemonId.VICTREEBEL.getValue());
            bugCatcherPokemon.add(PokemonId.PRIMARINA.getValue());
            bugCatcherPokemon.add(PokemonId.VILEPLUME.getValue());
            bugCatcherPokemon.add(PokemonId.CHANSEY.getValue());
            bugCatcherPokemon.add(PokemonId.JOLTEON.getValue());
            bugCatcherPokemon.add(PokemonId.FLAREON.getValue());
            bugCatcherPokemon.add(PokemonId.VAPOREON.getValue());
            bugCatcherPokemon.add(PokemonId.ESPEON.getValue());
            bugCatcherPokemon.add(PokemonId.UMBREON.getValue());
            bugCatcherPokemon.add(PokemonId.JUMPLUFF.getValue());
            bugCatcherPokemon.add(PokemonId.TOXAPEX.getValue());
        }
        if (difficulty >= 5) {
            bugCatcherPokemon.add(PokemonId.BLISSEY.getValue());
            bugCatcherPokemon.add(PokemonId.TSAREENA.getValue());
        }
        return bugCatcherPokemon;
    }

    public List<Integer> getBikerPokemon(double difficulty) {
        List<Integer> bikerPokemon = new ArrayList<Integer>();
        if (difficulty <= 2.5) {
            bikerPokemon.add(PokemonId.EKANS.getValue());
        }
        if (difficulty <= 4.5) {
            bikerPokemon.add(PokemonId.GRIMER.getValue());
            bikerPokemon.add(PokemonId.KOFFING.getValue());
            bikerPokemon.add(PokemonId.SLUGMA.getValue());
            bikerPokemon.add(PokemonId.HOUNDOUR.getValue());
        }
        if (difficulty >= 2 && difficulty <= 4.5) {
            bikerPokemon.add(PokemonId.CHARMELEON.getValue());
            bikerPokemon.add(PokemonId.QWILFISH.getValue());
        }
        if (difficulty >= 2.5) {
            bikerPokemon.add(PokemonId.ARBOK.getValue());
        }
        if (difficulty >= 3.5) {
            bikerPokemon.add(PokemonId.MUK.getValue());
            bikerPokemon.add(PokemonId.WEEZING.getValue());
            bikerPokemon.add(PokemonId.MAGCARGO.getValue());
        }
        if (difficulty >= 4.5) {
            bikerPokemon.add(PokemonId.TENTACRUEL.getValue());
            bikerPokemon.add(PokemonId.HOUNDOOM.getValue());
        }
        if (difficulty >= 5) {
            bikerPokemon.add(PokemonId.FLAREON.getValue());
            bikerPokemon.add(PokemonId.MAGMAR.getValue());

        }
        return bikerPokemon;
    }

    public List<Integer> getBirdKeeperPokemon(double difficulty) {
        List<Integer> bikerPokemon = new ArrayList<Integer>();
        if (difficulty <= 3) {
            bikerPokemon.add(PokemonId.PIDGEY.getValue());
            bikerPokemon.add(PokemonId.SPEAROW.getValue());
            bikerPokemon.add(PokemonId.HOOTHOOT.getValue());
            bikerPokemon.add(PokemonId.PIKIPEK.getValue());
            bikerPokemon.add(PokemonId.ROWLET.getValue());
        }
        if (difficulty >= 3) {
            bikerPokemon.add(PokemonId.FARFETCHD.getValue());

        }
        if (difficulty >= 2.5 && difficulty <= 4) {
            bikerPokemon.add(PokemonId.DODUO.getValue());
            bikerPokemon.add(PokemonId.MURKROW.getValue());
        }
        if (difficulty >= 2.5) {
            bikerPokemon.add(PokemonId.PIDGEOTTO.getValue());
            bikerPokemon.add(PokemonId.FEAROW.getValue());
            bikerPokemon.add(PokemonId.TRUMBEAK.getValue());
            bikerPokemon.add(PokemonId.NOCTOWL.getValue());
            bikerPokemon.add(PokemonId.DARTRIX.getValue());
            bikerPokemon.add(PokemonId.SKARMORY.getValue());
            bikerPokemon.add(PokemonId.DELIBIRD.getValue());
        }
        if (difficulty >= 3.5) {
            bikerPokemon.add(PokemonId.PIDGEOT.getValue());
            bikerPokemon.add(PokemonId.DODRIO.getValue());
            bikerPokemon.add(PokemonId.TOUCANNON.getValue());
        }
        return bikerPokemon;
    }

    public List<Integer> getBlackbeltPokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        if (difficulty <= 2) {
            bugCatcherPokemon.add(PokemonId.TYROGUE.getValue());
        }
        if (difficulty <= 3.5) {
            bugCatcherPokemon.add(PokemonId.MACHOP.getValue());
            bugCatcherPokemon.add(PokemonId.MANKEY.getValue());
        }
        if (difficulty >= 2.5) {
            bugCatcherPokemon.add(PokemonId.PASSIMIAN.getValue());
        }
        if (difficulty >= 3) {
            bugCatcherPokemon.add(PokemonId.PRIMEAPE.getValue());
            bugCatcherPokemon.add(PokemonId.MACHOKE.getValue());
        }
        if (difficulty <= 3.5) {
            bugCatcherPokemon.add(PokemonId.HITMONLEE.getValue());
            bugCatcherPokemon.add(PokemonId.HITMONCHAN.getValue());
        }
        if (difficulty >= 4) {
            bugCatcherPokemon.add(PokemonId.MACHAMP.getValue());
        }
        return bugCatcherPokemon;
    }

    public List<Integer> getBurglarPokemon(double difficulty) {
        List<Integer> burglarPokemon = new ArrayList<Integer>();
        if (difficulty <= 2.5) {
            burglarPokemon.add(PokemonId.CHARMANDER.getValue());
            burglarPokemon.add(PokemonId.CYNDAQUIL.getValue());
            burglarPokemon.add(PokemonId.LITTEN.getValue());
        }
        if (difficulty >= 2.5 && difficulty < 4.5) {
            burglarPokemon.add(PokemonId.CHARMELEON.getValue());
            burglarPokemon.add(PokemonId.QUILAVA.getValue());
            burglarPokemon.add(PokemonId.TORRACAT.getValue());
        }
        if (difficulty <= 4.5) {
            burglarPokemon.add(PokemonId.GROWLITHE.getValue());
            burglarPokemon.add(PokemonId.HOUNDOUR.getValue());
            burglarPokemon.add(PokemonId.SLUGMA.getValue());
            burglarPokemon.add(PokemonId.VULPIX.getValue());
        }
        if (difficulty >= 3 && difficulty <= 4.5) {
            burglarPokemon.add(PokemonId.PONYTA.getValue());
            burglarPokemon.add(PokemonId.MAGMAR.getValue());
        }
        if (difficulty >= 3) {
            burglarPokemon.add(PokemonId.TURTONATOR.getValue());
        }
        if (difficulty >= 3.5) {
            burglarPokemon.add(PokemonId.ARCANINE.getValue());
            burglarPokemon.add(PokemonId.NINETALES.getValue());
            burglarPokemon.add(PokemonId.MAGCARGO.getValue());

        }
        if (difficulty >= 4) {
            burglarPokemon.add(PokemonId.RAPIDASH.getValue());
            burglarPokemon.add(PokemonId.FLAREON.getValue());
        }
        if (difficulty >= 5) {
            burglarPokemon.add(PokemonId.CHARIZARD.getValue());
            burglarPokemon.add(PokemonId.TYPHLOSION.getValue());
        }

        return burglarPokemon;
    }

    public List<Integer> getCueBallPokemon(double difficulty) {
        List<Integer> cueBallPokemon = new ArrayList<Integer>();
        if (difficulty <= 2) {
            cueBallPokemon.add(PokemonId.YUNGOOS.getValue());
        }
        if (difficulty <= 3.5) {
            cueBallPokemon.add(PokemonId.MACHOP.getValue());
            cueBallPokemon.add(PokemonId.MANKEY.getValue());
        }
        if (difficulty >= 3) {
            cueBallPokemon.add(PokemonId.MACHOKE.getValue());
            cueBallPokemon.add(PokemonId.PRIMEAPE.getValue());
            cueBallPokemon.add(PokemonId.GUMSHOOS.getValue());
            cueBallPokemon.add(PokemonId.GLIGAR.getValue());
        }
        if (difficulty <= 4.5) {
            cueBallPokemon.add(PokemonId.GRIMER.getValue());
            cueBallPokemon.add(PokemonId.KOFFING.getValue());
        }
        if (difficulty >= 3.5) {
            cueBallPokemon.add(PokemonId.MUK.getValue());
            cueBallPokemon.add(PokemonId.WEEZING.getValue());
        }
        if (difficulty >= 4.5) {
            cueBallPokemon.add(PokemonId.MACHAMP.getValue());
        }
        if (difficulty >= 5) {
            cueBallPokemon.add(PokemonId.GYARADOS.getValue());
        }
        return cueBallPokemon;
    }

    public List<Integer> getDoctorPokemon(double difficulty) {
        List<Integer> cueBallPokemon = new ArrayList<Integer>();
        cueBallPokemon.add(PokemonId.CHANSEY.getValue());
        if (difficulty <= 3.5) {
            cueBallPokemon.add(PokemonId.DROWZEE.getValue());
        }
        if (difficulty >= 3) {
            cueBallPokemon.add(PokemonId.HYPNO.getValue());
            cueBallPokemon.add(PokemonId.TOGETIC.getValue());
        }
        if (difficulty >= 5) {
            cueBallPokemon.add(PokemonId.BLISSEY.getValue());
        }
        return cueBallPokemon;
    }

    public List<Integer> getDragonTamerPokemon(double difficulty) {
        List<Integer> dragonTamerPokemon = new ArrayList<Integer>();
        if (difficulty <= 2.5) {
            dragonTamerPokemon.add(PokemonId.CHARMANDER.getValue());
            dragonTamerPokemon.add(PokemonId.EKANS.getValue());
        }
        if (difficulty >= 1 && difficulty <= 5) {
            dragonTamerPokemon.add(PokemonId.DRATINI.getValue());
            dragonTamerPokemon.add(PokemonId.JANGMOO.getValue());
        }
        if (difficulty >= 2 && difficulty <= 4.5) {
            dragonTamerPokemon.add(PokemonId.CHARMELEON.getValue());
        }
        if (difficulty >= 2.5) {
            dragonTamerPokemon.add(PokemonId.ARBOK.getValue());
        }
        if (difficulty >= 3) {
            dragonTamerPokemon.add(PokemonId.SEADRA.getValue());
            dragonTamerPokemon.add(PokemonId.GYARADOS.getValue());
            dragonTamerPokemon.add(PokemonId.TURTONATOR.getValue());
            dragonTamerPokemon.add(PokemonId.DRAMPA.getValue());
        }
        if (difficulty >= 3.5) {
            dragonTamerPokemon.add(PokemonId.DRAGONAIR.getValue());
            dragonTamerPokemon.add(PokemonId.HAKAMOO.getValue());
        }
        if (difficulty >= 4) {
            dragonTamerPokemon.add(PokemonId.CHARIZARD.getValue());
        }
        if (difficulty >= 5) {
            dragonTamerPokemon.add(PokemonId.AERODACTYL.getValue());
            dragonTamerPokemon.add(PokemonId.DRAGONITE.getValue());
            dragonTamerPokemon.add(PokemonId.KINGDRA.getValue());
            dragonTamerPokemon.add(PokemonId.KOMMOO.getValue());

        }
        return dragonTamerPokemon;
    }

    public List<Integer> getFirebreatherPokemon(double difficulty) {
        List<Integer> burglarPokemon = new ArrayList<Integer>();
        if (difficulty >= 2) {
            burglarPokemon.add(PokemonId.MAGMAR.getValue());
        }
        if (difficulty <= 2.5) {
            burglarPokemon.add(PokemonId.CHARMANDER.getValue());
            burglarPokemon.add(PokemonId.CYNDAQUIL.getValue());
        }
        if (difficulty <= 4.5) {
            burglarPokemon.add(PokemonId.GROWLITHE.getValue());
            burglarPokemon.add(PokemonId.VULPIX.getValue());
            burglarPokemon.add(PokemonId.KOFFING.getValue());
            burglarPokemon.add(PokemonId.SLUGMA.getValue());
            burglarPokemon.add(PokemonId.HOUNDOUR.getValue());
            burglarPokemon.add(PokemonId.SALANDIT.getValue());
        }
        if (difficulty >= 3 && difficulty <= 4.5) {
            burglarPokemon.add(PokemonId.PONYTA.getValue());
        }
        if (difficulty >= 3.5) {
            burglarPokemon.add(PokemonId.ARCANINE.getValue());
            burglarPokemon.add(PokemonId.NINETALES.getValue());
            burglarPokemon.add(PokemonId.MAGCARGO.getValue());
            burglarPokemon.add(PokemonId.HOUNDOOM.getValue());
            burglarPokemon.add(PokemonId.TURTONATOR.getValue());

        }
        if (difficulty >= 4) {
            burglarPokemon.add(PokemonId.RAPIDASH.getValue());
            burglarPokemon.add(PokemonId.FLAREON.getValue());
            burglarPokemon.add(PokemonId.WEEZING.getValue());
            burglarPokemon.add(PokemonId.SALAZZLE.getValue());
        }
        if (difficulty >= 5) {
            burglarPokemon.add(PokemonId.CHARIZARD.getValue());
            burglarPokemon.add(PokemonId.TYPHLOSION.getValue());
        }
        return burglarPokemon;
    }

    public List<Integer> getFishermanPokemon(double difficulty) {
        List<Integer> burglarPokemon = new ArrayList<Integer>();
        burglarPokemon.add(PokemonId.WISHIWASHI.getValue());
        if (difficulty <= 3) {
            burglarPokemon.add(PokemonId.MAGIKARP.getValue());
            burglarPokemon.add(PokemonId.POLIWAG.getValue());
            burglarPokemon.add(PokemonId.CHINCHOU.getValue());
            burglarPokemon.add(PokemonId.REMORAID.getValue());
        }
        if (difficulty <= 3.5) {
            burglarPokemon.add(PokemonId.GOLDEEN.getValue());
            burglarPokemon.add(PokemonId.SHELLDER.getValue());
            burglarPokemon.add(PokemonId.HORSEA.getValue());
            burglarPokemon.add(PokemonId.STARYU.getValue());
            burglarPokemon.add(PokemonId.TENTACOOL.getValue());
        }
        if (difficulty >= 2) {
            burglarPokemon.add(PokemonId.GYARADOS.getValue());
            burglarPokemon.add(PokemonId.QWILFISH.getValue());
            burglarPokemon.add(PokemonId.BRUXISH.getValue());
        }
        if (difficulty >= 3) {
            burglarPokemon.add(PokemonId.SEAKING.getValue());
            burglarPokemon.add(PokemonId.POLIWHIRL.getValue());
            burglarPokemon.add(PokemonId.STARMIE.getValue());
            burglarPokemon.add(PokemonId.SEADRA.getValue());
            burglarPokemon.add(PokemonId.LANTURN.getValue());
            burglarPokemon.add(PokemonId.OCTILLERY.getValue());
            burglarPokemon.add(PokemonId.MANTINE.getValue());
        }
        if (difficulty >= 3.5) {
            burglarPokemon.add(PokemonId.TENTACRUEL.getValue());
            burglarPokemon.add(PokemonId.CLOYSTER.getValue());
        }
        if (difficulty >= 4) {
            burglarPokemon.add(PokemonId.POLIWRATH.getValue());
        }
        if (difficulty >= 5) {
            burglarPokemon.add(PokemonId.KINGDRA.getValue());
        }
        return burglarPokemon;
    }

    public List<Integer> getGamblerPokemon(double difficulty) {
        List<Integer> burglarPokemon = new ArrayList<Integer>();
        if (difficulty <= 3) {
            burglarPokemon.add(PokemonId.NIDORANM.getValue());
            burglarPokemon.add(PokemonId.NIDORANF.getValue());
            burglarPokemon.add(PokemonId.POLIWAG.getValue());
            burglarPokemon.add(PokemonId.WOOPER.getValue());
            burglarPokemon.add(PokemonId.SNUBBULL.getValue());
            burglarPokemon.add(PokemonId.SWINUB.getValue());
            burglarPokemon.add(PokemonId.PHANPY.getValue());
        }
        if (difficulty <= 3.5) {
            burglarPokemon.add(PokemonId.VOLTORB.getValue());
            burglarPokemon.add(PokemonId.MAGNEMITE.getValue());
            burglarPokemon.add(PokemonId.HORSEA.getValue());
            burglarPokemon.add(PokemonId.GOLDEEN.getValue());
            burglarPokemon.add(PokemonId.GEODUDE.getValue());
            burglarPokemon.add(PokemonId.ALOLAN_GEODUDE.getValue());
            burglarPokemon.add(PokemonId.KRABBY.getValue());
            burglarPokemon.add(PokemonId.DIGLETT.getValue());
            burglarPokemon.add(PokemonId.AIPOM.getValue());
        }

        if (difficulty >= 2.5) {
            burglarPokemon.add(PokemonId.DUGTRIO.getValue());
            burglarPokemon.add(PokemonId.NIDORINO.getValue());
            burglarPokemon.add(PokemonId.NIDORINA.getValue());
            burglarPokemon.add(PokemonId.QUAGSIRE.getValue());
            burglarPokemon.add(PokemonId.GIRAFARIG.getValue());
            burglarPokemon.add(PokemonId.GRANBULL.getValue());
            burglarPokemon.add(PokemonId.MINIOR.getValue());
        }
        if (difficulty >= 3) {
            burglarPokemon.add(PokemonId.POLIWHIRL.getValue());
            burglarPokemon.add(PokemonId.SEADRA.getValue());
            burglarPokemon.add(PokemonId.SEAKING.getValue());
            burglarPokemon.add(PokemonId.MAGNETON.getValue());
            burglarPokemon.add(PokemonId.ELECTRODE.getValue());
            burglarPokemon.add(PokemonId.GRAVELER.getValue());
            burglarPokemon.add(PokemonId.ALOLAN_GRAVELER.getValue());
            burglarPokemon.add(PokemonId.SUDOWOODO.getValue());
            burglarPokemon.add(PokemonId.SHUCKLE.getValue());
            burglarPokemon.add(PokemonId.DONPHAN.getValue());
        }

        if (difficulty >= 2 && difficulty <= 4) {
            burglarPokemon.add(PokemonId.RHYHORN.getValue());
            burglarPokemon.add(PokemonId.TYPE_NULL.getValue());
        }

        if (difficulty >= 4) {
            burglarPokemon.add(PokemonId.RHYDON.getValue());
            burglarPokemon.add(PokemonId.PILOSWINE.getValue());
        }

        if (difficulty >= 5) {
            burglarPokemon.add(PokemonId.NIDOQUEEN.getValue());
            burglarPokemon.add(PokemonId.NIDOKING.getValue());
            burglarPokemon.add(PokemonId.GOLEM.getValue());
            burglarPokemon.add(PokemonId.ALOLAN_GOLEM.getValue());
            burglarPokemon.add(PokemonId.SILVALLY.getValue());
        }
        return burglarPokemon;
    }

    public List<Integer> getGentlemanPokemon(double difficulty) {
        List<Integer> burglarPokemon = new ArrayList<Integer>();
        if (difficulty <= 3) {
            burglarPokemon.add(PokemonId.NIDORANM.getValue());
            burglarPokemon.add(PokemonId.LEDYBA.getValue());
            burglarPokemon.add(PokemonId.NIDORANF.getValue());
            burglarPokemon.add(PokemonId.HOOTHOOT.getValue());
            burglarPokemon.add(PokemonId.SNUBBULL.getValue());
            burglarPokemon.add(PokemonId.TEDDIURSA.getValue());
            burglarPokemon.add(PokemonId.SWINUB.getValue());
        }
        if (difficulty <= 3.5) {
            burglarPokemon.add(PokemonId.MAGNEMITE.getValue());
            burglarPokemon.add(PokemonId.VOLTORB.getValue());
            burglarPokemon.add(PokemonId.MUDBRAY.getValue());
            burglarPokemon.add(PokemonId.ROCKRUFF.getValue());
        }
        if (difficulty <= 4) {
            burglarPokemon.add(PokemonId.PIKACHU.getValue());
            burglarPokemon.add(PokemonId.GROWLITHE.getValue());
            burglarPokemon.add(PokemonId.HOUNDOUR.getValue());
            burglarPokemon.add(PokemonId.STUFFUL.getValue());
        }
        if (difficulty >= 2 && difficulty <= 4) {
            burglarPokemon.add(PokemonId.PONYTA.getValue());
        }
        if (difficulty >= 2.5) {
            burglarPokemon.add(PokemonId.NIDORINO.getValue());
            burglarPokemon.add(PokemonId.NIDORINA.getValue());
            burglarPokemon.add(PokemonId.NOCTOWL.getValue());
            burglarPokemon.add(PokemonId.LEDIAN.getValue());
            burglarPokemon.add(PokemonId.GRANBULL.getValue());
        }

        if (difficulty >= 3) {
            burglarPokemon.add(PokemonId.MAGNETON.getValue());
            burglarPokemon.add(PokemonId.ELECTRODE.getValue());
            burglarPokemon.add(PokemonId.RAICHU.getValue());
            burglarPokemon.add(PokemonId.ALOLAN_RAICHU.getValue());
            burglarPokemon.add(PokemonId.SKARMORY.getValue());
            burglarPokemon.add(PokemonId.LYCANROC_DAY.getValue());
            burglarPokemon.add(PokemonId.LYCANROC_NIGHT.getValue());
            burglarPokemon.add(PokemonId.DRAMPA.getValue());
        }

        if (difficulty >= 4.5) {
            burglarPokemon.add(PokemonId.URSARING.getValue());
            burglarPokemon.add(PokemonId.ARCANINE.getValue());
            burglarPokemon.add(PokemonId.HOUNDOOM.getValue());
            burglarPokemon.add(PokemonId.BEWEAR.getValue());
            burglarPokemon.add(PokemonId.RAPIDASH.getValue());
            burglarPokemon.add(PokemonId.PILOSWINE.getValue());
        }

        if (difficulty >= 5) {
            burglarPokemon.add(PokemonId.NIDOQUEEN.getValue());
            burglarPokemon.add(PokemonId.NIDOKING.getValue());
        }
        return burglarPokemon;
    }

    public List<Integer> getHikerPokemon(double difficulty) {
        List<Integer> burglarPokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            burglarPokemon.add(PokemonId.GEODUDE.getValue());
            burglarPokemon.add(PokemonId.ALOLAN_GEODUDE.getValue());
            burglarPokemon.add(PokemonId.DIGLETT.getValue());
            burglarPokemon.add(PokemonId.ALOLAN_DIGLETT.getValue());
            burglarPokemon.add(PokemonId.MACHOP.getValue());
            burglarPokemon.add(PokemonId.PHANPY.getValue());
            burglarPokemon.add(PokemonId.ROCKRUFF.getValue());
        }
        if (difficulty >= 1.5) {
            burglarPokemon.add(PokemonId.ONIX.getValue());
        }

        if (difficulty >= 3) {
            burglarPokemon.add(PokemonId.DUGTRIO.getValue());
            burglarPokemon.add(PokemonId.ALOLAN_DUGTRIO.getValue());
            burglarPokemon.add(PokemonId.GRAVELER.getValue());
            burglarPokemon.add(PokemonId.ALOLAN_GRAVELER.getValue());
            burglarPokemon.add(PokemonId.MACHOKE.getValue());
            burglarPokemon.add(PokemonId.DONPHAN.getValue());

        }
        if (difficulty >= 4) {
            burglarPokemon.add(PokemonId.PUPITAR.getValue());
            burglarPokemon.add(PokemonId.LYCANROC_NIGHT.getValue());
            burglarPokemon.add(PokemonId.LYCANROC_DAY.getValue());
        }

        if (difficulty >= 5) {
            burglarPokemon.add(PokemonId.GOLEM.getValue());
            burglarPokemon.add(PokemonId.MACHAMP.getValue());
            burglarPokemon.add(PokemonId.STEELIX.getValue());
            burglarPokemon.add(PokemonId.TYRANITAR.getValue());
        }
        return burglarPokemon;
    }

    public List<Integer> getJanitorPokemon(double difficulty) {
        List<Integer> janitorPokemon = new ArrayList<Integer>();
        if (difficulty <= 2) {
            janitorPokemon.add(PokemonId.GRUBBIN.getValue());
        }
        if (difficulty <= 4.5) {
            janitorPokemon.add(PokemonId.RATTATA.getValue());
            janitorPokemon.add(PokemonId.ALOLAN_RATTATA.getValue());
            janitorPokemon.add(PokemonId.GRIMER.getValue());
        }
        if (difficulty >= 2.5) {
            janitorPokemon.add(PokemonId.RATICATE.getValue());
            janitorPokemon.add(PokemonId.ALOLAN_RATICATE.getValue());
        }
        if (difficulty >= 3.5) {
            janitorPokemon.add(PokemonId.MUK.getValue());

        }
        return janitorPokemon;
    }

    public List<Integer> getJugglerPokemon(double difficulty) {
        List<Integer> janitorPokemon = new ArrayList<Integer>();
        if (difficulty <= 4) {
            janitorPokemon.add(PokemonId.DROWZEE.getValue());
        }
        if (difficulty >= 2.5 && difficulty <= 5) {
            janitorPokemon.add(PokemonId.KADABRA.getValue());
        }
        if (difficulty >= 2.5) {
            janitorPokemon.add(PokemonId.MR_MIME.getValue());
        }
        if (difficulty >= 3.5) {
            janitorPokemon.add(PokemonId.HYPNO.getValue());
            janitorPokemon.add(PokemonId.ORANGURU.getValue());
        }
        if (difficulty >= 5) {
            janitorPokemon.add(PokemonId.ALAKAZAM.getValue());
        }
        return janitorPokemon;
    }

    public List<Integer> getKimonoGirlPokemon(double difficulty) {
        List<Integer> janitorPokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            janitorPokemon.add(PokemonId.EEVEE.getValue());
        }
        if (difficulty >= 2.5) {
            janitorPokemon.add(PokemonId.FLAREON.getValue());
            janitorPokemon.add(PokemonId.JOLTEON.getValue());
            janitorPokemon.add(PokemonId.VAPOREON.getValue());
            janitorPokemon.add(PokemonId.ESPEON.getValue());
            janitorPokemon.add(PokemonId.UMBREON.getValue());

        }
        return janitorPokemon;
    }

    public List<Integer> getLadyPokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        bugCatcherPokemon.add(PokemonId.PIKACHU.getValue());
        if (difficulty >= 1.5 && difficulty <= 2.5) {
            bugCatcherPokemon.add(PokemonId.ODDISH.getValue());
        }
        if (difficulty >= 1.5 && difficulty <= 3.5) {
            bugCatcherPokemon.add(PokemonId.CLEFAIRY.getValue());
            bugCatcherPokemon.add(PokemonId.JIGGLYPUFF.getValue());
        }
        if (difficulty <= 3) {
            bugCatcherPokemon.add(PokemonId.MEOWTH.getValue());
            bugCatcherPokemon.add(PokemonId.VULPIX.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_VULPIX.getValue());
            bugCatcherPokemon.add(PokemonId.EEVEE.getValue());
        }
        if (difficulty >= 2.5) {
            bugCatcherPokemon.add(PokemonId.GLOOM.getValue());
        }
        if (difficulty >= 3) {
            bugCatcherPokemon.add(PokemonId.PERSIAN.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_PERSIAN.getValue());
        }
        if (difficulty >= 3.5) {
            bugCatcherPokemon.add(PokemonId.FLAREON.getValue());
            bugCatcherPokemon.add(PokemonId.JOLTEON.getValue());
            bugCatcherPokemon.add(PokemonId.VAPOREON.getValue());
        }
        if (difficulty >= 4) {
            bugCatcherPokemon.add(PokemonId.CLEFABLE.getValue());
            bugCatcherPokemon.add(PokemonId.WIGGLYTUFF.getValue());
            bugCatcherPokemon.add(PokemonId.VILEPLUME.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_NINETALES.getValue());
        }
        return bugCatcherPokemon;
    }

    public List<Integer> getMediumPokemon(double difficulty) {
        List<Integer> janitorPokemon = new ArrayList<Integer>();
        janitorPokemon.add(PokemonId.ORICORIO_SENSU.getValue());
        if (difficulty <= 3) {
            janitorPokemon.add(PokemonId.GASTLY.getValue());
            janitorPokemon.add(PokemonId.MISDREAVUS.getValue());
            janitorPokemon.add(PokemonId.NATU.getValue());
        }
        if (difficulty >= 2.5) {
            janitorPokemon.add(PokemonId.HAUNTER.getValue());

        }
        if (difficulty >= 3 && difficulty <= 4.5) {
            janitorPokemon.add(PokemonId.SLOWPOKE.getValue());
            janitorPokemon.add(PokemonId.DROWZEE.getValue());
            janitorPokemon.add(PokemonId.SANDYGAST.getValue());
        }
        if (difficulty >= 3.5) {
            janitorPokemon.add(PokemonId.SLOWBRO.getValue());
            janitorPokemon.add(PokemonId.SLOWKING.getValue());
            janitorPokemon.add(PokemonId.HYPNO.getValue());
            janitorPokemon.add(PokemonId.MIMIKYU.getValue());
            janitorPokemon.add(PokemonId.XATU.getValue());
            janitorPokemon.add(PokemonId.ORANGURU.getValue());
        }
        if (difficulty >= 4.5) {
            janitorPokemon.add(PokemonId.GENGAR.getValue());
            janitorPokemon.add(PokemonId.PALOSSAND.getValue());
            janitorPokemon.add(PokemonId.DHELMISE.getValue());
        }
        return janitorPokemon;
    }

    public List<Integer> getNursePokemon(double difficulty) {
        List<Integer> janitorPokemon = new ArrayList<Integer>();
        janitorPokemon.add(PokemonId.CHANSEY.getValue());
        if (difficulty >= 5) {
            janitorPokemon.add(PokemonId.BLISSEY.getValue());
        }
        return janitorPokemon;
    }

    public List<Integer> getParasolLadyPokemon(double difficulty) {
        List<Integer> janitorPokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            janitorPokemon.add(PokemonId.WOOPER.getValue());
            janitorPokemon.add(PokemonId.MARILL.getValue());
            janitorPokemon.add(PokemonId.DEWPIDER.getValue());
            janitorPokemon.add(PokemonId.CHINCHOU.getValue());
        }
        if (difficulty <= 4) {
            janitorPokemon.add(PokemonId.GOLDEEN.getValue());
            janitorPokemon.add(PokemonId.PSYDUCK.getValue());
            janitorPokemon.add(PokemonId.STARYU.getValue());
            janitorPokemon.add(PokemonId.POLIWAG.getValue());
        }
        if (difficulty >= 3) {
            janitorPokemon.add(PokemonId.SEAKING.getValue());
            janitorPokemon.add(PokemonId.POLIWHIRL.getValue());
            janitorPokemon.add(PokemonId.STARMIE.getValue());
            janitorPokemon.add(PokemonId.GOLDUCK.getValue());
            janitorPokemon.add(PokemonId.AZUMARILL.getValue());
            janitorPokemon.add(PokemonId.LANTURN.getValue());
            janitorPokemon.add(PokemonId.QUAGSIRE.getValue());
            janitorPokemon.add(PokemonId.ARAQUANID.getValue());
            janitorPokemon.add(PokemonId.PYUKUMUKU.getValue());
            janitorPokemon.add(PokemonId.CORSOLA.getValue());
        }
        if (difficulty >= 4.5) {
            janitorPokemon.add(PokemonId.JOLTEON.getValue());
            janitorPokemon.add(PokemonId.POLITOED.getValue());

        }
        return janitorPokemon;
    }

    public List<Integer> getPicnickerMalePokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        if (difficulty <= 2.5) {
            bugCatcherPokemon.add(PokemonId.CHARMANDER.getValue());
            bugCatcherPokemon.add(PokemonId.SQUIRTLE.getValue());
            bugCatcherPokemon.add(PokemonId.BULBASAUR.getValue());
            bugCatcherPokemon.add(PokemonId.NIDORANM.getValue());
            bugCatcherPokemon.add(PokemonId.WEEDLE.getValue());
            bugCatcherPokemon.add(PokemonId.CATERPIE.getValue());
            bugCatcherPokemon.add(PokemonId.PIDGEY.getValue());
        }
        if (difficulty <= 3.5) {
            bugCatcherPokemon.add(PokemonId.SPEAROW.getValue());
            bugCatcherPokemon.add(PokemonId.MANKEY.getValue());
            bugCatcherPokemon.add(PokemonId.DIGLETT.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_DIGLETT.getValue());
            bugCatcherPokemon.add(PokemonId.PIKACHU.getValue());
            bugCatcherPokemon.add(PokemonId.MEOWTH.getValue());
            bugCatcherPokemon.add(PokemonId.RATTATA.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_RATTATA.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_MEOWTH.getValue());
            bugCatcherPokemon.add(PokemonId.SANDSHREW.getValue());
            bugCatcherPokemon.add(PokemonId.ODDISH.getValue());
            bugCatcherPokemon.add(PokemonId.BELLSPROUT.getValue());
        }
        if (difficulty >= 1 && difficulty <= 2) {
            bugCatcherPokemon.add(PokemonId.METAPOD.getValue());
            bugCatcherPokemon.add(PokemonId.KAKUNA.getValue());
        }
        if (difficulty >= 2 && difficulty <= 4) {
            bugCatcherPokemon.add(PokemonId.PIDGEOTTO.getValue());
            bugCatcherPokemon.add(PokemonId.CHARMELEON.getValue());
            bugCatcherPokemon.add(PokemonId.WARTORTLE.getValue());
            bugCatcherPokemon.add(PokemonId.IVYSAUR.getValue());
            bugCatcherPokemon.add(PokemonId.VENONAT.getValue());
            bugCatcherPokemon.add(PokemonId.EXEGGCUTE.getValue());
        }
        if (difficulty >= 2.5) {
            bugCatcherPokemon.add(PokemonId.SANDSLASH.getValue());
            bugCatcherPokemon.add(PokemonId.BEEDRILL.getValue());
            bugCatcherPokemon.add(PokemonId.BUTTERFREE.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_DUGTRIO.getValue());
            bugCatcherPokemon.add(PokemonId.DUGTRIO.getValue());
            bugCatcherPokemon.add(PokemonId.RATICATE.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_RATICATE.getValue());
            bugCatcherPokemon.add(PokemonId.GLOOM.getValue());
            bugCatcherPokemon.add(PokemonId.WEEPINBELL.getValue());
            bugCatcherPokemon.add(PokemonId.FARFETCHD.getValue());
            bugCatcherPokemon.add(PokemonId.NIDORINO.getValue());
        }
        if (difficulty >= 3) {
            bugCatcherPokemon.add(PokemonId.PARASECT.getValue());
            bugCatcherPokemon.add(PokemonId.VENOMOTH.getValue());
            bugCatcherPokemon.add(PokemonId.PERSIAN.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_PERSIAN.getValue());
        }

        if (difficulty >= 4) {
            bugCatcherPokemon.add(PokemonId.PIDGEOT.getValue());
            bugCatcherPokemon.add(PokemonId.FEAROW.getValue());
            bugCatcherPokemon.add(PokemonId.VILEPLUME.getValue());
            bugCatcherPokemon.add(PokemonId.VICTREEBEL.getValue());
            bugCatcherPokemon.add(PokemonId.EXEGGUTOR.getValue());
            bugCatcherPokemon.add(PokemonId.PINSIR.getValue());
            bugCatcherPokemon.add(PokemonId.SCYTHER.getValue());
            bugCatcherPokemon.add(PokemonId.MAROWAK.getValue());
            bugCatcherPokemon.add(PokemonId.PRIMEAPE.getValue());
        }
        if (difficulty >= 5) {
            bugCatcherPokemon.add(PokemonId.NIDOKING.getValue());
        }
        return bugCatcherPokemon;
    }

    public List<Integer> getPicnickerFemalePokemon(double difficulty) {
        List<Integer> bugCatcherPokemon = new ArrayList<Integer>();
        if (difficulty <= 2.5) {
            bugCatcherPokemon.add(PokemonId.CHARMANDER.getValue());
            bugCatcherPokemon.add(PokemonId.SQUIRTLE.getValue());
            bugCatcherPokemon.add(PokemonId.BULBASAUR.getValue());
            bugCatcherPokemon.add(PokemonId.NIDORANM.getValue());
            bugCatcherPokemon.add(PokemonId.WEEDLE.getValue());
            bugCatcherPokemon.add(PokemonId.CATERPIE.getValue());
            bugCatcherPokemon.add(PokemonId.PIDGEY.getValue());
        }
        if (difficulty <= 3.5) {
            bugCatcherPokemon.add(PokemonId.CLEFAIRY.getValue());
            bugCatcherPokemon.add(PokemonId.JIGGLYPUFF.getValue());
            bugCatcherPokemon.add(PokemonId.DIGLETT.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_DIGLETT.getValue());
            bugCatcherPokemon.add(PokemonId.PIKACHU.getValue());
            bugCatcherPokemon.add(PokemonId.MEOWTH.getValue());
            bugCatcherPokemon.add(PokemonId.RATTATA.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_RATTATA.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_MEOWTH.getValue());
            bugCatcherPokemon.add(PokemonId.SANDSHREW.getValue());
            bugCatcherPokemon.add(PokemonId.ODDISH.getValue());
            bugCatcherPokemon.add(PokemonId.BELLSPROUT.getValue());
            bugCatcherPokemon.add(PokemonId.VULPIX.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_VULPIX.getValue());
        }

        if (difficulty >= 1 && difficulty <= 2) {
            bugCatcherPokemon.add(PokemonId.METAPOD.getValue());
            bugCatcherPokemon.add(PokemonId.KAKUNA.getValue());
        }
        if (difficulty >= 2 && difficulty <= 4) {
            bugCatcherPokemon.add(PokemonId.PIDGEOTTO.getValue());
            bugCatcherPokemon.add(PokemonId.CHARMELEON.getValue());
            bugCatcherPokemon.add(PokemonId.WARTORTLE.getValue());
            bugCatcherPokemon.add(PokemonId.IVYSAUR.getValue());
            bugCatcherPokemon.add(PokemonId.VENONAT.getValue());
            bugCatcherPokemon.add(PokemonId.EXEGGCUTE.getValue());
        }
        if (difficulty >= 2.5) {
            bugCatcherPokemon.add(PokemonId.SANDSLASH.getValue());
            bugCatcherPokemon.add(PokemonId.BEEDRILL.getValue());
            bugCatcherPokemon.add(PokemonId.BUTTERFREE.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_DUGTRIO.getValue());
            bugCatcherPokemon.add(PokemonId.DUGTRIO.getValue());
            bugCatcherPokemon.add(PokemonId.RATICATE.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_RATICATE.getValue());
            bugCatcherPokemon.add(PokemonId.GLOOM.getValue());
            bugCatcherPokemon.add(PokemonId.WEEPINBELL.getValue());
            bugCatcherPokemon.add(PokemonId.FARFETCHD.getValue());
            bugCatcherPokemon.add(PokemonId.NIDORINA.getValue());
        }
        if (difficulty >= 3) {
            bugCatcherPokemon.add(PokemonId.PARASECT.getValue());
            bugCatcherPokemon.add(PokemonId.VENOMOTH.getValue());
            bugCatcherPokemon.add(PokemonId.PERSIAN.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_PERSIAN.getValue());
        }
        if (difficulty >= 4) {
            bugCatcherPokemon.add(PokemonId.PIDGEOT.getValue());
            bugCatcherPokemon.add(PokemonId.VILEPLUME.getValue());
            bugCatcherPokemon.add(PokemonId.VICTREEBEL.getValue());
            bugCatcherPokemon.add(PokemonId.EXEGGUTOR.getValue());
            bugCatcherPokemon.add(PokemonId.WIGGLYTUFF.getValue());
            bugCatcherPokemon.add(PokemonId.CLEFABLE.getValue());
            bugCatcherPokemon.add(PokemonId.RAICHU.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_RAICHU.getValue());
            bugCatcherPokemon.add(PokemonId.NINETALES.getValue());
            bugCatcherPokemon.add(PokemonId.ALOLAN_NINETALES.getValue());
        }
        if (difficulty >= 5) {
            bugCatcherPokemon.add(PokemonId.NIDORINA.getValue());
        }
        return bugCatcherPokemon;
    }

    public List<Integer> getWaiterPokemon(double difficulty) {
        List<Integer> waiterPokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            waiterPokemon.add(PokemonId.KRABBY.getValue());
        }
        if (difficulty <= 4) {
            waiterPokemon.add(PokemonId.SHELLDER.getValue());
            waiterPokemon.add(PokemonId.EXEGGCUTE.getValue());
        }
        if (difficulty >= 3) {
            waiterPokemon.add(PokemonId.KINGLER.getValue());
        }
        if (difficulty >= 3.5) {
            waiterPokemon.add(PokemonId.CLOYSTER.getValue());
            waiterPokemon.add(PokemonId.EXEGGUTOR.getValue());
        }
        return waiterPokemon;
    }

    public List<Integer> getBakerPokemon(double difficulty) {
        List<Integer> bakerPokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            bakerPokemon.add(PokemonId.MEOWTH.getValue());
            bakerPokemon.add(PokemonId.PIKACHU.getValue());
        }
        if (difficulty >= 3) {
            bakerPokemon.add(PokemonId.PERSIAN.getValue());
            bakerPokemon.add(PokemonId.RAICHU.getValue());
        }
        if (difficulty >= 3.5) {
            bakerPokemon.add(PokemonId.LICKITUNG.getValue());
            bakerPokemon.add(PokemonId.SNORLAX.getValue());
        }
        return bakerPokemon;
    }

    public List<Integer> getPolicePokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.MACHOP.getValue());
        }
        if (difficulty <= 4.5) {
            policePokemon.add(PokemonId.GROWLITHE.getValue());
        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.MACHOKE.getValue());
        }
        if (difficulty >= 3.5) {
            policePokemon.add(PokemonId.ARCANINE.getValue());
        }
        if (difficulty >= 4.5) {
            policePokemon.add(PokemonId.MACHAMP.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getPsychicPokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 2) {
            policePokemon.add(PokemonId.ABRA.getValue());
        }
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.GASTLY.getValue());
            policePokemon.add(PokemonId.EXEGGCUTE.getValue());
        }
        if (difficulty <= 4) {
            policePokemon.add(PokemonId.DROWZEE.getValue());
            policePokemon.add(PokemonId.SLOWPOKE.getValue());
        }
        if (difficulty >= 2) {
            policePokemon.add(PokemonId.KADABRA.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.HAUNTER.getValue());
            policePokemon.add(PokemonId.MR_MIME.getValue());
        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.HYPNO.getValue());
        }
        if (difficulty >= 3.5) {
            policePokemon.add(PokemonId.SLOWBRO.getValue());
            policePokemon.add(PokemonId.STARMIE.getValue());
        }
        if (difficulty >= 4) {
            policePokemon.add(PokemonId.ALOLAN_RAICHU.getValue());
        }
        if (difficulty >= 4.5) {
            policePokemon.add(PokemonId.GENGAR.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getRangerPokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 3) {
            policePokemon.add(PokemonId.PARAS.getValue());
            policePokemon.add(PokemonId.ODDISH.getValue());
            policePokemon.add(PokemonId.BELLSPROUT.getValue());
            policePokemon.add(PokemonId.EXEGGCUTE.getValue());
        }
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.BULBASAUR.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.TANGELA.getValue());
            policePokemon.add(PokemonId.PARASECT.getValue());
            policePokemon.add(PokemonId.CHANSEY.getValue());
        }
        if (difficulty >= 2.5 && difficulty <= 4.5) {
            policePokemon.add(PokemonId.IVYSAUR.getValue());
            policePokemon.add(PokemonId.WEEPINBELL.getValue());
            policePokemon.add(PokemonId.GLOOM.getValue());

        }
        if (difficulty >= 3 && difficulty <= 4.5) {
            policePokemon.add(PokemonId.RHYHORN.getValue());
        }

        if (difficulty >= 3.5) {
            policePokemon.add(PokemonId.VICTREEBEL.getValue());
            policePokemon.add(PokemonId.VILEPLUME.getValue());
            policePokemon.add(PokemonId.EXEGGUTOR.getValue());
        }
        if (difficulty >= 4.5) {
            policePokemon.add(PokemonId.RHYDON.getValue());
            policePokemon.add(PokemonId.ALOLAN_EXEGGUTOR.getValue());
            policePokemon.add(PokemonId.VENUSAUR.getValue());
        }
        return policePokemon;

    }

    public List<Integer> getRichBoyPokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 3) {
            policePokemon.add(PokemonId.SANDSHREW.getValue());
            policePokemon.add(PokemonId.ALOLAN_SANDSHREW.getValue());
            policePokemon.add(PokemonId.NIDORANF.getValue());
            policePokemon.add(PokemonId.NIDORANM.getValue());
            policePokemon.add(PokemonId.CUBONE.getValue());
            policePokemon.add(PokemonId.EKANS.getValue());
        }
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.GROWLITHE.getValue());
            policePokemon.add(PokemonId.EEVEE.getValue());
            policePokemon.add(PokemonId.VULPIX.getValue());
            policePokemon.add(PokemonId.ALOLAN_VULPIX.getValue());
            policePokemon.add(PokemonId.PSYDUCK.getValue());
            policePokemon.add(PokemonId.MEOWTH.getValue());
            policePokemon.add(PokemonId.ALOLAN_MEOWTH.getValue());
            policePokemon.add(PokemonId.PIKACHU.getValue());
            policePokemon.add(PokemonId.ZUBAT.getValue());
        }
        if (difficulty <= 4) {
            policePokemon.add(PokemonId.DRATINI.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.ARBOK.getValue());
            policePokemon.add(PokemonId.SANDSLASH.getValue());
            policePokemon.add(PokemonId.ALOLAN_SANDSLASH.getValue());
            policePokemon.add(PokemonId.GOLBAT.getValue());
            policePokemon.add(PokemonId.FARFETCHD.getValue());
        }
        if (difficulty >= 2.5 && difficulty <= 5) {
            policePokemon.add(PokemonId.NIDORINA.getValue());
            policePokemon.add(PokemonId.NIDORINO.getValue());
        }

        if (difficulty >= 3) {
            policePokemon.add(PokemonId.MAROWAK.getValue());
            policePokemon.add(PokemonId.PERSIAN.getValue());
            policePokemon.add(PokemonId.ALOLAN_PERSIAN.getValue());
        }
        if (difficulty >= 3.5) {
            policePokemon.add(PokemonId.RAICHU.getValue());
            policePokemon.add(PokemonId.SCYTHER.getValue());
            policePokemon.add(PokemonId.PINSIR.getValue());
            policePokemon.add(PokemonId.GOLDUCK.getValue());
        }
        if (difficulty >= 4.5) {
            policePokemon.add(PokemonId.NINETALES.getValue());
            policePokemon.add(PokemonId.ALOLAN_NINETALES.getValue());
            policePokemon.add(PokemonId.ARCANINE.getValue());
            policePokemon.add(PokemonId.JOLTEON.getValue());
            policePokemon.add(PokemonId.VAPOREON.getValue());
            policePokemon.add(PokemonId.FLAREON.getValue());
        }
        if (difficulty >= 5) {
            policePokemon.add(PokemonId.NIDOKING.getValue());
            policePokemon.add(PokemonId.NIDOQUEEN.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getRuneManiacPokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 3) {
            policePokemon.add(PokemonId.SANDSHREW.getValue());
            policePokemon.add(PokemonId.DIGLETT.getValue());
            policePokemon.add(PokemonId.ALOLAN_DIGLETT.getValue());
            policePokemon.add(PokemonId.CUBONE.getValue());
            policePokemon.add(PokemonId.GEODUDE.getValue());
            policePokemon.add(PokemonId.ALOLAN_GEODUDE.getValue());
        }
        if (difficulty >= 1.5) {
            policePokemon.add(PokemonId.ONIX.getValue());
        }
        if (difficulty >= 2 && difficulty <= 4.5) {
            policePokemon.add(PokemonId.KABUTO.getValue());
            policePokemon.add(PokemonId.OMANYTE.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.SANDSLASH.getValue());
            policePokemon.add(PokemonId.ALOLAN_SANDSLASH.getValue());
        }
        if (difficulty >= 3 && difficulty <= 5) {
            policePokemon.add(PokemonId.GRAVELER.getValue());
            policePokemon.add(PokemonId.ALOLAN_GRAVELER.getValue());
        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.MAROWAK.getValue());
            policePokemon.add(PokemonId.DUGTRIO.getValue());
            policePokemon.add(PokemonId.ALOLAN_DUGTRIO.getValue());
        }

        if (difficulty >= 4) {
            policePokemon.add(PokemonId.KABUTOPS.getValue());
            policePokemon.add(PokemonId.OMASTAR.getValue());
        }
        if (difficulty >= 4.5) {
            policePokemon.add(PokemonId.GOLEM.getValue());
            policePokemon.add(PokemonId.ALOLAN_GOLEM.getValue());
            policePokemon.add(PokemonId.AERODACTYL.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getSagePokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.BELLSPROUT.getValue());
            policePokemon.add(PokemonId.GASTLY.getValue());
            policePokemon.add(PokemonId.ZUBAT.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.GOLBAT.getValue());
        }
        if (difficulty >= 2.5 && difficulty <= 5) {
            policePokemon.add(PokemonId.WEEPINBELL.getValue());
            policePokemon.add(PokemonId.HAUNTER.getValue());
        }

        if (difficulty >= 4) {
            policePokemon.add(PokemonId.VICTREEBEL.getValue());
        }
        if (difficulty >= 4.5) {
            policePokemon.add(PokemonId.GENGAR.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getSailorPokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.MACHOP.getValue());
            policePokemon.add(PokemonId.MANKEY.getValue());
            policePokemon.add(PokemonId.KRABBY.getValue());
            policePokemon.add(PokemonId.PSYDUCK.getValue());
            policePokemon.add(PokemonId.POLIWAG.getValue());
            policePokemon.add(PokemonId.TENTACOOL.getValue());
            policePokemon.add(PokemonId.HORSEA.getValue());
            policePokemon.add(PokemonId.SHELLDER.getValue());
            policePokemon.add(PokemonId.STARYU.getValue());
            policePokemon.add(PokemonId.SQUIRTLE.getValue());
            policePokemon.add(PokemonId.SEEL.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.RATICATE.getValue());
            policePokemon.add(PokemonId.ALOLAN_RATICATE.getValue());
            policePokemon.add(PokemonId.PRIMEAPE.getValue());
        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.TENTACRUEL.getValue());
            policePokemon.add(PokemonId.KINGLER.getValue());
            policePokemon.add(PokemonId.MACHOKE.getValue());
            policePokemon.add(PokemonId.GOLDUCK.getValue());
            policePokemon.add(PokemonId.SEADRA.getValue());
        }
        if (difficulty >= 2.5 && difficulty <= 4) {
            policePokemon.add(PokemonId.WARTORTLE.getValue());
            policePokemon.add(PokemonId.POLIWHIRL.getValue());
        }

        if (difficulty >= 4) {
            policePokemon.add(PokemonId.DEWGONG.getValue());
            policePokemon.add(PokemonId.STARMIE.getValue());
        }
        if (difficulty >= 4.5) {
            policePokemon.add(PokemonId.KANGASKHAN.getValue());
            policePokemon.add(PokemonId.BLASTOISE.getValue());
            policePokemon.add(PokemonId.GYARADOS.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getSchoolKidPokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        policePokemon.add(PokemonId.TANGELA.getValue());
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.MAGNEMITE.getValue());
            policePokemon.add(PokemonId.PARAS.getValue());
            policePokemon.add(PokemonId.POLIWAG.getValue());
            policePokemon.add(PokemonId.GROWLITHE.getValue());
            policePokemon.add(PokemonId.VOLTORB.getValue());
            policePokemon.add(PokemonId.EXEGGCUTE.getValue());
            policePokemon.add(PokemonId.DITTO.getValue());
            policePokemon.add(PokemonId.BELLSPROUT.getValue());
            policePokemon.add(PokemonId.ABRA.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.POLIWHIRL.getValue());
            policePokemon.add(PokemonId.KADABRA.getValue());
            policePokemon.add(PokemonId.PARASECT.getValue());
            policePokemon.add(PokemonId.GLOOM.getValue());
        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.MAGMAR.getValue());
            policePokemon.add(PokemonId.ELECTABUZZ.getValue());
            policePokemon.add(PokemonId.JYNX.getValue());
            policePokemon.add(PokemonId.MR_MIME.getValue());
            policePokemon.add(PokemonId.ELECTRODE.getValue());
            policePokemon.add(PokemonId.MAGNETON.getValue());
        }

        if (difficulty >= 4) {
            policePokemon.add(PokemonId.EXEGGUTOR.getValue());
            policePokemon.add(PokemonId.VILEPLUME.getValue());
            policePokemon.add(PokemonId.VICTREEBEL.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getScientistPokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.MAGNEMITE.getValue());
            policePokemon.add(PokemonId.VOLTORB.getValue());
            policePokemon.add(PokemonId.GRIMER.getValue());
            policePokemon.add(PokemonId.ALOLAN_GRIMER.getValue());
            policePokemon.add(PokemonId.KOFFING.getValue());

        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.ELECTRODE.getValue());
            policePokemon.add(PokemonId.MAGNETON.getValue());
        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.WEEZING.getValue());
            policePokemon.add(PokemonId.MUK.getValue());
            policePokemon.add(PokemonId.ALOLAN_MUK.getValue());
        }

        if (difficulty >= 4) {
            policePokemon.add(PokemonId.DITTO.getValue());
            policePokemon.add(PokemonId.PORYGON.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getSocialitePokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.MEOWTH.getValue());
            policePokemon.add(PokemonId.ALOLAN_MEOWTH.getValue());
            policePokemon.add(PokemonId.EEVEE.getValue());
            policePokemon.add(PokemonId.DRATINI.getValue());
            policePokemon.add(PokemonId.VULPIX.getValue());
            policePokemon.add(PokemonId.ALOLAN_VULPIX.getValue());
            policePokemon.add(PokemonId.PONYTA.getValue());
            policePokemon.add(PokemonId.EKANS.getValue());
            policePokemon.add(PokemonId.ODDISH.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.BUTTERFREE.getValue());
            policePokemon.add(PokemonId.PERSIAN.getValue());
            policePokemon.add(PokemonId.ALOLAN_PERSIAN.getValue());
            policePokemon.add(PokemonId.ARBOK.getValue());
        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.NINETALES.getValue());
            policePokemon.add(PokemonId.ALOLAN_NINETALES.getValue());
            policePokemon.add(PokemonId.DRAGONAIR.getValue());
        }
        if (difficulty >= 2.5 && difficulty <= 4.5) {
            policePokemon.add(PokemonId.GLOOM.getValue());
        }

        if (difficulty >= 3.5) {
            policePokemon.add(PokemonId.RAPIDASH.getValue());
        }
        if (difficulty >= 4) {
            policePokemon.add(PokemonId.LAPRAS.getValue());
            policePokemon.add(PokemonId.JOLTEON.getValue());
            policePokemon.add(PokemonId.FLAREON.getValue());
            policePokemon.add(PokemonId.VAPOREON.getValue());
            policePokemon.add(PokemonId.VILEPLUME.getValue());
        }
        if (difficulty >= 5) {
            policePokemon.add(PokemonId.DRAGONITE.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getSwimmerPokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.TENTACOOL.getValue());
            policePokemon.add(PokemonId.SQUIRTLE.getValue());
            policePokemon.add(PokemonId.GOLDEEN.getValue());
            policePokemon.add(PokemonId.SHELLDER.getValue());
            policePokemon.add(PokemonId.HORSEA.getValue());
            policePokemon.add(PokemonId.POLIWAG.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.TENTACRUEL.getValue());
            policePokemon.add(PokemonId.SEAKING.getValue());
            policePokemon.add(PokemonId.ALOLAN_PERSIAN.getValue());
            policePokemon.add(PokemonId.ARBOK.getValue());
        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.SEADRA.getValue());
            policePokemon.add(PokemonId.CLOYSTER.getValue());
        }
        if (difficulty >= 2.5 && difficulty <= 4.5) {
            policePokemon.add(PokemonId.WARTORTLE.getValue());
            policePokemon.add(PokemonId.POLIWHIRL.getValue());
        }
        if (difficulty >= 4) {
            policePokemon.add(PokemonId.POLIWRATH.getValue());
            policePokemon.add(PokemonId.LAPRAS.getValue());
            policePokemon.add(PokemonId.GYARADOS.getValue());
        }
        if (difficulty >= 5) {
            policePokemon.add(PokemonId.BLASTOISE.getValue());
            policePokemon.add(PokemonId.VAPOREON.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getTeacherPokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.CLEFAIRY.getValue());
            policePokemon.add(PokemonId.JIGGLYPUFF.getValue());
            policePokemon.add(PokemonId.CUBONE.getValue());
            policePokemon.add(PokemonId.ALOLAN_MEOWTH.getValue());
            policePokemon.add(PokemonId.MEOWTH.getValue());
            policePokemon.add(PokemonId.ABRA.getValue());
            policePokemon.add(PokemonId.EEVEE.getValue());
            policePokemon.add(PokemonId.PIKACHU.getValue());
            policePokemon.add(PokemonId.HORSEA.getValue());
            policePokemon.add(PokemonId.VENONAT.getValue());
            policePokemon.add(PokemonId.ALOLAN_VULPIX.getValue());
            policePokemon.add(PokemonId.VULPIX.getValue());
            policePokemon.add(PokemonId.SANDSHREW.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.MR_MIME.getValue());
            policePokemon.add(PokemonId.ALOLAN_PERSIAN.getValue());
            policePokemon.add(PokemonId.SANDSLASH.getValue());
            policePokemon.add(PokemonId.PERSIAN.getValue());
        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.SEADRA.getValue());
            policePokemon.add(PokemonId.VENOMOTH.getValue());
            policePokemon.add(PokemonId.RAICHU.getValue());
            policePokemon.add(PokemonId.ALOLAN_RAICHU.getValue());
            policePokemon.add(PokemonId.CLEFABLE.getValue());
            policePokemon.add(PokemonId.WIGGLYTUFF.getValue());
            policePokemon.add(PokemonId.MAROWAK.getValue());
        }
        if (difficulty >= 2.5 && difficulty <= 4.5) {
            policePokemon.add(PokemonId.KADABRA.getValue());
        }
        if (difficulty >= 4) {
            policePokemon.add(PokemonId.LAPRAS.getValue());
            policePokemon.add(PokemonId.JOLTEON.getValue());
            policePokemon.add(PokemonId.FLAREON.getValue());
            policePokemon.add(PokemonId.VAPOREON.getValue());
            policePokemon.add(PokemonId.ALAKAZAM.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getVeteranMalePokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        policePokemon.add(PokemonId.ELECTABUZZ.getValue());
        policePokemon.add(PokemonId.MAGMAR.getValue());
        policePokemon.add(PokemonId.TAUROS.getValue());
        policePokemon.add(PokemonId.SCYTHER.getValue());
        policePokemon.add(PokemonId.PINSIR.getValue());
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.MACHOP.getValue());
            policePokemon.add(PokemonId.ALOLAN_SANDSHREW.getValue());
            policePokemon.add(PokemonId.ALOLAN_VULPIX.getValue());
            policePokemon.add(PokemonId.ALOLAN_GRIMER.getValue());
            policePokemon.add(PokemonId.ALOLAN_GEODUDE.getValue());
            policePokemon.add(PokemonId.DRATINI.getValue());
            policePokemon.add(PokemonId.ZUBAT.getValue());
            policePokemon.add(PokemonId.EKANS.getValue());
            policePokemon.add(PokemonId.GROWLITHE.getValue());
            policePokemon.add(PokemonId.PONYTA.getValue());
            policePokemon.add(PokemonId.VULPIX.getValue());
            policePokemon.add(PokemonId.SANDSHREW.getValue());
            policePokemon.add(PokemonId.GRIMER.getValue());
            policePokemon.add(PokemonId.ALOLAN_RATTATA.getValue());
            policePokemon.add(PokemonId.RATTATA.getValue());
            policePokemon.add(PokemonId.RHYHORN.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.RATICATE.getValue());
            policePokemon.add(PokemonId.ALOLAN_RATICATE.getValue());
            policePokemon.add(PokemonId.SANDSLASH.getValue());
            policePokemon.add(PokemonId.ALOLAN_SANDSLASH.getValue());
            policePokemon.add(PokemonId.ARBOK.getValue());
            policePokemon.add(PokemonId.PARASECT.getValue());
            policePokemon.add(PokemonId.PRIMEAPE.getValue());

        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.GOLBAT.getValue());
            policePokemon.add(PokemonId.MUK.getValue());
            policePokemon.add(PokemonId.ALOLAN_MUK.getValue());
            policePokemon.add(PokemonId.TENTACRUEL.getValue());
            policePokemon.add(PokemonId.CLOYSTER.getValue());
            policePokemon.add(PokemonId.VENOMOTH.getValue());
            policePokemon.add(PokemonId.KANGASKHAN.getValue());
            policePokemon.add(PokemonId.KINGLER.getValue());
            policePokemon.add(PokemonId.SEADRA.getValue());

        }
        if (difficulty >= 3.5) {
            policePokemon.add(PokemonId.ARCANINE.getValue());
            policePokemon.add(PokemonId.RAPIDASH.getValue());
            policePokemon.add(PokemonId.NINETALES.getValue());
            policePokemon.add(PokemonId.ALOLAN_NINETALES.getValue());
            policePokemon.add(PokemonId.RHYDON.getValue());
            policePokemon.add(PokemonId.PIDGEOT.getValue());
            policePokemon.add(PokemonId.STARMIE.getValue());
        }
        if (difficulty >= 2.5 && difficulty <= 4.5) {
            policePokemon.add(PokemonId.ALOLAN_GRAVELER.getValue());
            policePokemon.add(PokemonId.MACHOKE.getValue());
            policePokemon.add(PokemonId.WEEPINBELL.getValue());
            policePokemon.add(PokemonId.PIDGEOTTO.getValue());
            policePokemon.add(PokemonId.NIDORINO.getValue());
            policePokemon.add(PokemonId.NIDORINA.getValue());
            policePokemon.add(PokemonId.HAUNTER.getValue());
        }

        if (difficulty >= 3 && difficulty <= 5) {
            policePokemon.add(PokemonId.DRAGONAIR.getValue());
        }
        if (difficulty >= 4) {
            policePokemon.add(PokemonId.GYARADOS.getValue());
            policePokemon.add(PokemonId.MACHAMP.getValue());
            policePokemon.add(PokemonId.FLAREON.getValue());
            policePokemon.add(PokemonId.VAPOREON.getValue());
            policePokemon.add(PokemonId.ALAKAZAM.getValue());
            policePokemon.add(PokemonId.SNORLAX.getValue());
            policePokemon.add(PokemonId.DRAGONITE.getValue());
            policePokemon.add(PokemonId.NIDOKING.getValue());
            policePokemon.add(PokemonId.NIDOQUEEN.getValue());
            policePokemon.add(PokemonId.LAPRAS.getValue());
            policePokemon.add(PokemonId.GENGAR.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getVeteranFemalePokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        policePokemon.add(PokemonId.ELECTABUZZ.getValue());
        policePokemon.add(PokemonId.MAGMAR.getValue());
        policePokemon.add(PokemonId.LICKITUNG.getValue());
        policePokemon.add(PokemonId.TANGELA.getValue());
        policePokemon.add(PokemonId.CHANSEY.getValue());

        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.JIGGLYPUFF.getValue());
            policePokemon.add(PokemonId.ALOLAN_SANDSHREW.getValue());
            policePokemon.add(PokemonId.ALOLAN_VULPIX.getValue());
            policePokemon.add(PokemonId.CLEFAIRY.getValue());
            policePokemon.add(PokemonId.ALOLAN_GEODUDE.getValue());
            policePokemon.add(PokemonId.DRATINI.getValue());
            policePokemon.add(PokemonId.ZUBAT.getValue());
            policePokemon.add(PokemonId.EKANS.getValue());
            policePokemon.add(PokemonId.GROWLITHE.getValue());
            policePokemon.add(PokemonId.PONYTA.getValue());
            policePokemon.add(PokemonId.VULPIX.getValue());
            policePokemon.add(PokemonId.SANDSHREW.getValue());
            policePokemon.add(PokemonId.GRIMER.getValue());
            policePokemon.add(PokemonId.ALOLAN_RATTATA.getValue());
            policePokemon.add(PokemonId.RATTATA.getValue());
            policePokemon.add(PokemonId.RHYHORN.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.RATICATE.getValue());
            policePokemon.add(PokemonId.ALOLAN_RATICATE.getValue());
            policePokemon.add(PokemonId.SANDSLASH.getValue());
            policePokemon.add(PokemonId.ALOLAN_SANDSLASH.getValue());
            policePokemon.add(PokemonId.ARBOK.getValue());
            policePokemon.add(PokemonId.PARASECT.getValue());
            policePokemon.add(PokemonId.PRIMEAPE.getValue());

        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.GOLBAT.getValue());
            policePokemon.add(PokemonId.MUK.getValue());
            policePokemon.add(PokemonId.ALOLAN_MUK.getValue());
            policePokemon.add(PokemonId.TENTACRUEL.getValue());
            policePokemon.add(PokemonId.CLOYSTER.getValue());
            policePokemon.add(PokemonId.VENOMOTH.getValue());
            policePokemon.add(PokemonId.KANGASKHAN.getValue());
            policePokemon.add(PokemonId.SEADRA.getValue());

        }

        if (difficulty >= 3.5) {
            policePokemon.add(PokemonId.WIGGLYTUFF.getValue());
            policePokemon.add(PokemonId.RAPIDASH.getValue());
            policePokemon.add(PokemonId.NINETALES.getValue());
            policePokemon.add(PokemonId.ALOLAN_NINETALES.getValue());
            policePokemon.add(PokemonId.CLEFABLE.getValue());
            policePokemon.add(PokemonId.VICTREEBEL.getValue());
            policePokemon.add(PokemonId.VILEPLUME.getValue());
            policePokemon.add(PokemonId.PIDGEOT.getValue());
            policePokemon.add(PokemonId.STARMIE.getValue());

        }
        if (difficulty >= 2.5 && difficulty <= 4.5) {
            policePokemon.add(PokemonId.ALOLAN_GRAVELER.getValue());
            policePokemon.add(PokemonId.MACHOKE.getValue());
            policePokemon.add(PokemonId.GLOOM.getValue());
            policePokemon.add(PokemonId.WEEPINBELL.getValue());
            policePokemon.add(PokemonId.PIDGEOTTO.getValue());
            policePokemon.add(PokemonId.NIDORINO.getValue());
            policePokemon.add(PokemonId.NIDORINA.getValue());
            policePokemon.add(PokemonId.HAUNTER.getValue());
        }

        if (difficulty >= 3 && difficulty <= 5) {
            policePokemon.add(PokemonId.DRAGONAIR.getValue());
        }
        if (difficulty >= 4) {
            policePokemon.add(PokemonId.GYARADOS.getValue());
            policePokemon.add(PokemonId.MACHAMP.getValue());
            policePokemon.add(PokemonId.FLAREON.getValue());
            policePokemon.add(PokemonId.VAPOREON.getValue());
            policePokemon.add(PokemonId.ALAKAZAM.getValue());
            policePokemon.add(PokemonId.SNORLAX.getValue());
            policePokemon.add(PokemonId.DRAGONITE.getValue());
            policePokemon.add(PokemonId.NIDOKING.getValue());
            policePokemon.add(PokemonId.NIDOQUEEN.getValue());
            policePokemon.add(PokemonId.LAPRAS.getValue());
            policePokemon.add(PokemonId.GENGAR.getValue());
        }
        return policePokemon;
    }

    public List<Integer> getPilotPokemon(double difficulty) {
        List<Integer> bikerPokemon = new ArrayList<Integer>();
        if (difficulty <= 3) {
            bikerPokemon.add(PokemonId.PIDGEY.getValue());
            bikerPokemon.add(PokemonId.SPEAROW.getValue());
            bikerPokemon.add(PokemonId.MAGNEMITE.getValue());
            bikerPokemon.add(PokemonId.VOLTORB.getValue());
            bikerPokemon.add(PokemonId.ALOLAN_GEODUDE.getValue());
            bikerPokemon.add(PokemonId.PIKACHU.getValue());
        }
        if (difficulty >= 3) {
            bikerPokemon.add(PokemonId.FARFETCHD.getValue());
            bikerPokemon.add(PokemonId.RAICHU.getValue());
            bikerPokemon.add(PokemonId.MAGNETON.getValue());
            bikerPokemon.add(PokemonId.ELECTRODE.getValue());
        }
        if (difficulty >= 2.5 && difficulty <= 4) {
            bikerPokemon.add(PokemonId.DODUO.getValue());
            bikerPokemon.add(PokemonId.ALOLAN_GRAVELER.getValue());
        }
        if (difficulty >= 2.5) {
            bikerPokemon.add(PokemonId.PIDGEOTTO.getValue());
            bikerPokemon.add(PokemonId.FEAROW.getValue());
        }
        if (difficulty >= 3.5) {
            bikerPokemon.add(PokemonId.PIDGEOT.getValue());
            bikerPokemon.add(PokemonId.DODRIO.getValue());
        }
        if (difficulty >= 4) {
            bikerPokemon.add(PokemonId.ALOLAN_GOLEM.getValue());
        }
        return bikerPokemon;
    }

    public List<Integer> getConductorPokemon(double difficulty) {
        List<Integer> policePokemon = new ArrayList<Integer>();
        if (difficulty <= 3.5) {
            policePokemon.add(PokemonId.MAGNEMITE.getValue());
            policePokemon.add(PokemonId.VOLTORB.getValue());
            policePokemon.add(PokemonId.GRIMER.getValue());
            policePokemon.add(PokemonId.ALOLAN_GRIMER.getValue());
            policePokemon.add(PokemonId.KOFFING.getValue());
            policePokemon.add(PokemonId.ALOLAN_GEODUDE.getValue());
            policePokemon.add(PokemonId.SANDSHREW.getValue());
            policePokemon.add(PokemonId.DIGLETT.getValue());
            policePokemon.add(PokemonId.ALOLAN_RATTATA.getValue());
            policePokemon.add(PokemonId.RATTATA.getValue());
        }
        if (difficulty >= 2.5) {
            policePokemon.add(PokemonId.ELECTRODE.getValue());
            policePokemon.add(PokemonId.MAGNETON.getValue());
            policePokemon.add(PokemonId.DUGTRIO.getValue());
            policePokemon.add(PokemonId.SANDSLASH.getValue());
            policePokemon.add(PokemonId.ALOLAN_RATICATE.getValue());
            policePokemon.add(PokemonId.RATICATE.getValue());
        }

        if (difficulty >= 2.5 && difficulty <= 4.5) {
            policePokemon.add(PokemonId.ALOLAN_GRAVELER.getValue());
        }
        if (difficulty >= 3) {
            policePokemon.add(PokemonId.WEEZING.getValue());
            policePokemon.add(PokemonId.MUK.getValue());
            policePokemon.add(PokemonId.ALOLAN_MUK.getValue());
        }

        if (difficulty >= 4) {
            policePokemon.add(PokemonId.ALOLAN_GOLEM.getValue());
        }
        return policePokemon;
    }



    public Trainer getGymLeaderBrock() {
        String victoryText = "I took you for granted, and so I lost. As proof of\nyour victory" +
                "I confer on you this...the official\nPokémon League BoulderBadge.";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Geodude g = new Geodude();
        g.insertWildData(12, 0);
        List<Skill> gSkills = new ArrayList<Skill>();
        gSkills.add(new Tackle());
        g.setSkillset(gSkills);

        Onix o = new Onix();
        o.insertWildData(14, 0);
        List<Skill> oSkills = new ArrayList<Skill>();
        oSkills.add(new Tackle());
        oSkills.add(new Bind());
        oSkills.add(new RockTomb());
        o.setSkillset(oSkills);

        party.add(g);
        party.add(o);
        return new Trainer(0, "Gym Leader", "Brock", victoryText, "trainers/small/brock.png", party,
                Trainer.Badge.KANTO_BADGE);
    }

    public Trainer getGymLeaderMisty() {
        String victoryText = "Wow! You're too much, all right! You can have\n" +
                "the CascadeBadge to show that you beat me.";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Staryu g = new Staryu();
        g.insertWildData(18, 0);

        List<Skill> gSkills = new ArrayList<Skill>();
        gSkills.add(new Tackle());
        gSkills.add(new Harden());
        gSkills.add(new WaterPulse());
        g.setSkillset(gSkills);

        Starmie o = new Starmie();
        o.insertWildData(21, 0);
        List<Skill> oSkills = new ArrayList<Skill>();
        oSkills.add(new WaterPulse());
        o.setSkillset(oSkills);

        party.add(g);
        party.add(o);
        return new Trainer(0, "Gym Leader", "Misty", victoryText, "trainers/small/misty.png", party,
                Trainer.Badge.KANTO_BADGE);
    }

    public Trainer getGymLeaderLtSurge() {
        String victoryText = "Now that's a shocker! You're the real deal, kid!\n" +
                " Fine, then, take the ThunderBadge!";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Voltorb g = new Voltorb();
        g.insertWildData(21, 0);
        List<Skill> gSkills = new ArrayList<Skill>();
        gSkills.add(new ThunderShock());
        g.setSkillset(gSkills);

        Pikachu o = new Pikachu();
        o.insertWildData(18, 0);
        List<Skill> oSkills = new ArrayList<Skill>();
        oSkills.add(new WaterPulse());
        o.setSkillset(oSkills);

        Raichu r = new Raichu();
        r.insertWildData(24, 0);
        List<Skill> rSkills = new ArrayList<Skill>();
        rSkills.add(new ThunderShock());
        r.setSkillset(rSkills);

        party.add(g);
        party.add(o);
        party.add(r);
        return new Trainer(0, "Gym Leader", "Lt. Surge", victoryText, "trainers/small/ltsurge.png",
                party, Trainer.Badge.KANTO_BADGE);
    }

    public Trainer getGymLeaderErika() {
        String victoryText = "Oh! I concede defeat. You are remarkably strong.\n" +
                "I must confer on you the RainbowBadge.";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Victreebel g = new Victreebel();
        g.insertWildData(29, 0);
        List<Skill> gSkills = new ArrayList<Skill>();
        gSkills.add(new GigaDrain());
        g.setSkillset(gSkills);

        Tangela o = new Tangela();
        o.insertWildData(24, 0);
        List<Skill> oSkills = new ArrayList<Skill>();
        oSkills.add(new WaterPulse());
        o.setSkillset(oSkills);

        Vileplume r = new Vileplume();
        r.insertWildData(29, 0);
        List<Skill> rSkills = new ArrayList<Skill>();
        rSkills.add(new GigaDrain());
        r.setSkillset(rSkills);

        party.add(g);
        party.add(o);
        party.add(r);
        return new Trainer(0, "Gym Leader", "Erika", victoryText, "trainers/small/erika.png", party,
                Trainer.Badge.KANTO_BADGE);
    }

    public Trainer getGymLeaderSabrina() {
        String victoryText = "This loss shocks me! But a loss is a loss. I admit\n" +
                "I didn't work hard enough to win. You earned the MarshBadge.";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Kadabra g = new Kadabra();
        g.insertWildData(38, 0);
        List<Skill> gSkills = new ArrayList<Skill>();
        gSkills.add(new FutureSight());
        g.setSkillset(gSkills);

        MrMime o = new MrMime();
        o.insertWildData(37, 0);
        List<Skill> oSkills = new ArrayList<Skill>();
        oSkills.add(new Tackle());
        o.setSkillset(oSkills);

        Venomoth r = new Venomoth();
        r.insertWildData(38, 0);
        List<Skill> rSkills = new ArrayList<Skill>();
        rSkills.add(new LeechLife());
        rSkills.add(new Gust());
        r.setSkillset(rSkills);

        Alakazam alakazam = new Alakazam();
        alakazam.insertWildData(43, 0);
        List<Skill> alakazamSkills = new ArrayList<Skill>();
        alakazamSkills.add(new FutureSight());
        alakazam.setSkillset(alakazamSkills);

        party.add(g);
        party.add(o);
        party.add(r);
        party.add(alakazam);
        return new Trainer(0, "Gym Leader", "Sabrina", victoryText, "trainers/small/sabrina.png",
                party, Trainer.Badge.KANTO_BADGE);
    }

    public Trainer getGymLeaderJanine() {
        String victoryText = "...!!! So... So strong!";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Koffing g = new Koffing();
        g.insertWildData(37, 0);
        List<Skill> gSkills = new ArrayList<Skill>();
        gSkills.add(new SelfDestruct());
        g.setSkillset(gSkills);

        Muk o = new Muk();
        o.insertWildData(39, 0);
        List<Skill> oSkills = new ArrayList<Skill>();
        oSkills.add(new Tackle());
        o.setSkillset(oSkills);

        Koffing r = new Koffing();
        r.insertWildData(37, 0);
        List<Skill> rSkills = new ArrayList<Skill>();
        rSkills.add(new SelfDestruct());
        r.setSkillset(rSkills);

        Weezing weezing = new Weezing();
        weezing.insertWildData(43, 0);
        List<Skill> weezingSkills = new ArrayList<Skill>();
        weezingSkills.add(new Tackle());
        weezing.setSkillset(weezingSkills);

        party.add(g);
        party.add(o);
        party.add(r);
        party.add(weezing);
        return new Trainer(0, "Gym Leader", "Janine", victoryText, "trainers/small/janine.png",
                party, Trainer.Badge.KANTO_BADGE);
    }

    public Trainer getGymLeaderBlaine() {
        String victoryText = "I have burned down to nothing! Not even ashes remain!\n" +
                "You have earned the VolcanoBadge.";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Growlithe g = new Growlithe();
        g.insertWildData(42, 0);
        List<Skill> gSkills = new ArrayList<Skill>();
        gSkills.add(new Bite());
        gSkills.add(new TakeDown());
        gSkills.add(new FireBlast());
        g.setSkillset(gSkills);

        Ponyta o = new Ponyta();
        o.insertWildData(40, 0);
        List<Skill> oSkills = new ArrayList<Skill>();
        oSkills.add(new Bounce());
        oSkills.add(new FireSpin());
        oSkills.add(new FireBlast());
        o.setSkillset(oSkills);

        Rapidash r = new Rapidash();
        r.insertWildData(42, 0);
        List<Skill> rSkills = new ArrayList<Skill>();
        rSkills.add(new Bounce());
        rSkills.add(new FireSpin());
        rSkills.add(new FireBlast());
        r.setSkillset(rSkills);

        Arcanine arcanine = new Arcanine();
        arcanine.insertWildData(47, 0);
        List<Skill> arcanineSkills = new ArrayList<Skill>();
        arcanineSkills.add(new Bite());
        arcanineSkills.add(new TakeDown());
        arcanineSkills.add(new FireBlast());
        arcanine.setSkillset(arcanineSkills);

        party.add(g);
        party.add(o);
        party.add(r);
        party.add(arcanine);
        return new Trainer(0, "Gym Leader", "Blaine", victoryText, "trainers/small/blaine.png",
                party, Trainer.Badge.KANTO_BADGE);
    }

    public Trainer getGymLeaderBlue() {
        String victoryText = "What? How the heck did I lose to you? … \n" +
                "Tch, all right… Here, take this-- it's EarthBadge.";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Pidgeot g = new Pidgeot();
        g.insertWildData(56, 0);
        List<Skill> gSkills = new ArrayList<Skill>();
        gSkills.add(new QuickAttack());
        gSkills.add(new WingAttack());
        g.setSkillset(gSkills);

        Alakazam o = new Alakazam();
        o.insertWildData(54, 0);
        List<Skill> oSkills = new ArrayList<Skill>();
        oSkills.add(new Tackle());
        o.setSkillset(oSkills);

        Rhydon r = new Rhydon();
        r.insertWildData(56, 0);
        List<Skill> rSkills = new ArrayList<Skill>();
        rSkills.add(new Sandstorm());
        rSkills.add(new RockSlide());
        r.setSkillset(rSkills);

        Gyarados gyarados = new Gyarados();
        gyarados.insertWildData(58, 0);
        List<Skill> gyaradosSkills = new ArrayList<Skill>();
        gyaradosSkills.add(new Twister());
        gyaradosSkills.add(new HydroPump());
        gyaradosSkills.add(new RainDance());
        gyarados.setSkillset(gyaradosSkills);

        Exeggutor exeggutor = new Exeggutor();
        exeggutor.insertWildData(58, 0);
        List<Skill> exeggutorSkills = new ArrayList<Skill>();
        exeggutorSkills.add(new SunnyDay());
        exeggutorSkills.add(new LeechLife());
        exeggutorSkills.add(new SolarBeam());
        exeggutor.setSkillset(exeggutorSkills);

        Arcanine arcanine = new Arcanine();
        arcanine.insertWildData(58, 0);
        List<Skill> arcanineSkills = new ArrayList<Skill>();
        arcanineSkills.add(new Flamethrower());
        arcanine.setSkillset(arcanineSkills);

        party.add(g);
        party.add(o);
        party.add(r);
        party.add(gyarados);
        party.add(exeggutor);
        party.add(arcanine);
        return new Trainer(0, "Gym Leader", "Blue", victoryText, "trainers/small/blue.png", party,
                Trainer.Badge.KANTO_BADGE);
    }

    public Trainer getLorelei() {
        String victoryText = "You're better than I thought. Go on ahead.\n" +
                "You only got a taste of the Pokémon League's power.";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Dewgong g = new Dewgong();
        g.insertWildData(54, 0);
        List<Skill> gSkills = new ArrayList<Skill>();
        gSkills.add(new Surf());
        gSkills.add(new IceBeam());
        gSkills.add(new Hail());
        gSkills.add(new Safeguard());
        g.setSkillset(gSkills);

        Cloyster o = new Cloyster();
        o.insertWildData(53, 0);
        List<Skill> oSkills = new ArrayList<Skill>();
        oSkills.add(new Spikes());
        oSkills.add(new Dive());
        oSkills.add(new Hail());
        //TODO: Protect
        o.setSkillset(oSkills);

        Slowbro r = new Slowbro();
        r.insertWildData(54, 0);
        List<Skill> rSkills = new ArrayList<Skill>();
        rSkills.add(new IceBeam());
        rSkills.add(new Surf());
        rSkills.add(new Amnesia());
        rSkills.add(new Yawn());
        r.setSkillset(rSkills);

        Jynx jynx = new Jynx();
        jynx.insertWildData(54, 0);
        List<Skill> jynxSkills = new ArrayList<Skill>();
        jynxSkills.add(new DoubleSlap());
        jynxSkills.add(new LovelyKiss());
        jynxSkills.add(new IcePunch());
        //TODO: Attract
        jynx.setSkillset(jynxSkills);

        Lapras lapras = new Lapras();
        lapras.insertWildData(56, 0);
        List<Skill> laprasSkills = new ArrayList<Skill>();
        laprasSkills.add(new BodySlam());
        laprasSkills.add(new ConfuseRay());
        laprasSkills.add(new Surf());
        laprasSkills.add(new IceBeam());
        lapras.setSkillset(laprasSkills);

        Arcanine arcanine = new Arcanine();
        arcanine.insertWildData(58, 0);
        List<Skill> arcanineSkills = new ArrayList<Skill>();
        arcanineSkills.add(new Flamethrower());
        arcanine.setSkillset(arcanineSkills);

        party.add(g);
        party.add(o);
        party.add(r);
        party.add(jynx);
        party.add(lapras);
        return new Trainer(0, "Elite 4", "Lorelei", victoryText,
                "trainers/small/lorelei.png", party, Trainer.Badge.KANTO_LORELEI);
    }

    public Trainer getKantoBruno() {
        String victoryText = "My job is done.\nGo face your next challenge.";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Onix firstOnix = new Onix();
        firstOnix.insertWildData(51, 0);
        List<Skill> firstOnixSkills = new ArrayList<Skill>();
        firstOnixSkills.add(new Earthquake());
        firstOnixSkills.add(new RockTomb());
        firstOnixSkills.add(new IronTail());
        //TODO: Roar
        firstOnix.setSkillset(firstOnixSkills);

        Hitmonchan hitmonchan = new Hitmonchan();
        hitmonchan.insertWildData(53, 0);
        List<Skill> hitmonchanSkills = new ArrayList<Skill>();
        hitmonchanSkills.add(new SkyUppercut());
        hitmonchanSkills.add(new MachPunch());
        hitmonchanSkills.add(new RockTomb());
        //TODO: Counter
        hitmonchan.setSkillset(hitmonchanSkills);

        Hitmonlee hitmonlee = new Hitmonlee();
        hitmonlee.insertWildData(53, 0);
        List<Skill> hitmonleeSkills = new ArrayList<Skill>();
        hitmonleeSkills.add(new MegaKick());
        hitmonleeSkills.add(new BrickBreak());
        hitmonleeSkills.add(new Facade());
        //TODO: Foresight
        hitmonlee.setSkillset(hitmonleeSkills);

        Onix secondOnix = new Onix();
        secondOnix.insertWildData(54, 0);
        List<Skill> secondOnixSkills = new ArrayList<Skill>();
        secondOnixSkills.add(new DoubleEdge());
        secondOnixSkills.add(new IronTail());
        secondOnixSkills.add(new Earthquake());
        secondOnixSkills.add(new SandTomb());
        secondOnix.setSkillset(secondOnixSkills);

        Machamp machamp = new Machamp();
        machamp.insertWildData(56, 0);
        List<Skill> machampSkills = new ArrayList<Skill>();
        machampSkills.add(new BulkUp());
        machampSkills.add(new CrossChop());
        machampSkills.add(new ScaryFace());
        machampSkills.add(new RockTomb());
        machamp.setSkillset(machampSkills);

        party.add(firstOnix);
        party.add(hitmonchan);
        party.add(hitmonlee);
        party.add(secondOnix);
        party.add(machamp);
        return new Trainer(0, "Elite 4", "Bruno", victoryText,
                "trainers/small/bruno.png", party, Trainer.Badge.KANTO_BRUNO);
    }

    public Trainer getAgatha() {
        String victoryText = "You win! I see what the old duff sees in you now.\n" +
                "I've nothing else to say. Run along now, child!";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Gengar firstGengar = new Gengar();
        firstGengar.insertWildData(54, 0);
        List<Skill> firstGengarSkills = new ArrayList<Skill>();
        firstGengarSkills.add(new ConfuseRay());
        firstGengarSkills.add(new ShadowPunch());
        firstGengarSkills.add(new DoubleTeam());
        //TODO: Toxic
        firstGengar.setSkillset(firstGengarSkills);

        Golbat golbat = new Golbat();
        golbat.insertWildData(54, 0);
        List<Skill> golbatSkills = new ArrayList<Skill>();
        golbatSkills.add(new ConfuseRay());
        golbatSkills.add(new Bite());
        golbatSkills.add(new AirCutter());
        golbatSkills.add(new PoisonFang());
        golbat.setSkillset(golbatSkills);

        Haunter haunter = new Haunter();
        haunter.insertWildData(53, 0);
        List<Skill> haunterSkills = new ArrayList<Skill>();
        haunterSkills.add(new Curse());
        haunterSkills.add(new Hypnosis());
        haunterSkills.add(new DreamEater());
        //TODO: Mean Look
        haunter.setSkillset(haunterSkills);

        Arbok arbok  = new Arbok();
        arbok.insertWildData(56, 0);
        List<Skill> arbokSkills = new ArrayList<Skill>();
        arbokSkills.add(new Bite());
        arbokSkills.add(new SludgeBomb());
        arbokSkills.add(new Screech());
        arbokSkills.add(new IronTail());
        arbok.setSkillset(arbokSkills);

        Gengar secondGengar = new Gengar();
        secondGengar.insertWildData(58, 0);
        List<Skill> secondGengarSkills = new ArrayList<Skill>();
        secondGengarSkills.add(new ShadowBall());
        secondGengarSkills.add(new SludgeBomb());
        secondGengarSkills.add(new Hypnosis());
        secondGengarSkills.add(new Nightmare());
        secondGengar.setSkillset(secondGengarSkills);

        party.add(firstGengar);
        party.add(golbat);
        party.add(haunter);
        party.add(arbok);
        party.add(secondGengar);
        return new Trainer(0, "Elite 4", "Agatha", victoryText,
                "trainers/small/agatha.png", party, Trainer.Badge.KANTO_AGATHA);
    }

    public Trainer getKantoLance() {
        String victoryText = "I still can’t believe my dragons lost to you.\n" +
                "There is one more Trainer to face! His name is Blue!\n" +
                "He beat the Elite Four before you. He is the real Pokémon League Champion.";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Gyarados gyarados = new Gyarados();
        gyarados.insertWildData(56, 0);
        List<Skill> gyaradosSkills = new ArrayList<Skill>();
        gyaradosSkills.add(new Bite());
        gyaradosSkills.add(new DragonRage());
        gyaradosSkills.add(new Twister());
        gyaradosSkills.add(new HyperBeam());
        gyarados.setSkillset(gyaradosSkills);

        Dragonair firstDragonair = new Dragonair();
        firstDragonair.insertWildData(54, 0);
        List<Skill> firstDragonairSkills = new ArrayList<Skill>();
        firstDragonairSkills.add(new Safeguard());
        firstDragonairSkills.add(new Outrage());
        firstDragonairSkills.add(new DragonRage());
        firstDragonairSkills.add(new HyperBeam());
        firstDragonair.setSkillset(firstDragonairSkills);

        Dragonair secondDragonair = new Dragonair();
        secondDragonair.insertWildData(54, 0);
        List<Skill> secondDragonairSkills = new ArrayList<Skill>();
        secondDragonairSkills.add(new Safeguard());
        secondDragonairSkills.add(new Outrage());
        secondDragonairSkills.add(new ThunderWave());
        secondDragonairSkills.add(new HyperBeam());
        secondDragonair.setSkillset(secondDragonairSkills);

        Aerodactyl aerodactyl = new Aerodactyl();
        aerodactyl.insertWildData(58, 0);
        List<Skill> aerodactylSkills = new ArrayList<Skill>();
        aerodactylSkills.add(new WingAttack());
        aerodactylSkills.add(new AncientPower());
        aerodactylSkills.add(new ScaryFace());
        aerodactylSkills.add(new HyperBeam());
        aerodactyl.setSkillset(aerodactylSkills);

        Dragonite dragonite = new Dragonite();
        dragonite.insertWildData(60, 0);
        List<Skill> dragoniteSkills = new ArrayList<Skill>();
        dragoniteSkills.add(new Safeguard());
        dragoniteSkills.add(new Outrage());
        dragoniteSkills.add(new WingAttack());
        dragoniteSkills.add(new HyperBeam());
        dragonite.setSkillset(dragoniteSkills);

        party.add(gyarados);
        party.add(firstDragonair);
        party.add(secondDragonair);
        party.add(aerodactyl);
        party.add(dragonite);
        return new Trainer(0, "Elite 4", "Lance", victoryText,
                "trainers/small/lance.png", party, Trainer.Badge.KANTO_LANCE);
    }

    public Trainer getChampionBlue() {
        String victoryText = "Why? Why did I lose? I never made any mistakes raising my Pokémon…" +
                "\nDarn it! You're the new Pokémon League Champion!\n" +
                "Although I don't like to admit it.";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Pidgeot pidgeot = new Pidgeot();
        pidgeot.insertWildData(59, 0);
        List<Skill> pidgeotSkills = new ArrayList<Skill>();
        pidgeotSkills.add(new AerialAce());
        pidgeotSkills.add(new FeatherDance());
        pidgeotSkills.add(new SandAttack());
        //TODO: Whirlwind
        pidgeot.setSkillset(pidgeotSkills);

        Alakazam alakazam = new Alakazam();
        alakazam.insertWildData(57, 0);
        List<Skill> alakazamSkills = new ArrayList<Skill>();
        alakazamSkills.add(new Psychic());
        alakazamSkills.add(new FutureSight());
        alakazamSkills.add(new Recover());
        alakazamSkills.add(new Reflect());
        alakazam.setSkillset(alakazamSkills);

        Rhydon rhydon = new Rhydon();
        rhydon.insertWildData(59, 0);
        List<Skill> rhydonSkills = new ArrayList<Skill>();
        rhydonSkills.add(new TakeDown());
        rhydonSkills.add(new Earthquake());
        rhydonSkills.add(new RockTomb());
        rhydonSkills.add(new ScaryFace());
        rhydon.setSkillset(rhydonSkills);

        Arcanine arcanine = new Arcanine();
        arcanine.insertWildData(59, 0);
        List<Skill> arcanineSkills = new ArrayList<Skill>();
        arcanineSkills.add(new ExtremeSpeed());
        arcanineSkills.add(new Flamethrower());
        arcanineSkills.add(new Bite());
        //TODO: Roar
        arcanine.setSkillset(arcanineSkills);

        Exeggutor exeggutor = new Exeggutor();
        exeggutor.insertWildData(61, 0);
        List<Skill> exeggutorSkills = new ArrayList<Skill>();
        exeggutorSkills.add(new GigaDrain());
        exeggutorSkills.add(new EggBomb());
        exeggutorSkills.add(new SleepPowder());
        exeggutorSkills.add(new LightScreen());
        exeggutor.setSkillset(exeggutorSkills);

        Blastoise blastoise = new Blastoise();
        blastoise.insertWildData(63, 0);
        List<Skill> blastoiseSkills = new ArrayList<Skill>();
        blastoiseSkills.add(new HydroPump());
        blastoiseSkills.add(new RainDance());
        blastoiseSkills.add(new SkullBash());
        blastoiseSkills.add(new Bite());
        blastoise.setSkillset(blastoiseSkills);

        party.add(pidgeot);
        party.add(alakazam);
        party.add(rhydon);
        party.add(arcanine);
        party.add(exeggutor);
        party.add(blastoise);
        return new Trainer(0, "Champion", "Blue", victoryText,
                "trainers/small/blue.png", party, Trainer.Badge.KANTO_CHAMPION);
    }

    public Trainer getGymLeaderFalkner() {
        String victoryText = "..Darn! My Dad's cherished bird Pokémon... All right.\n" +
                "Take this. It's the official Pokémon League\nZephyrBadge.";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Pidgey pidgey = new Pidgey();
        pidgey.insertWildData(9, 0);
        List<Skill> pidgeySkills = new ArrayList<Skill>();
        pidgeySkills.add(new Tackle());
        pidgeySkills.add(new SandAttack());
        pidgey.setSkillset(pidgeySkills);

        Pidgeotto pidgeotto = new Pidgeotto();
        pidgeotto.insertWildData(13, 0);
        List<Skill> pidgeottoSkills = new ArrayList<Skill>();
        pidgeottoSkills.add(new Tackle());
        pidgeottoSkills.add(new Gust());
        pidgeottoSkills.add(new Roost());
        pidgeotto.setSkillset(pidgeottoSkills);

        party.add(pidgey);
        party.add(pidgeotto);
        return new Trainer(0, "Gym Leader", "Falkner", victoryText,
                "trainers/small/falkner.png", party, Trainer.Badge.JOHTO_BADGE);
    }

    public Trainer getGymLeaderBugsy() {
        String victoryText = "Whoa, amazing! You're an expert on Pokémon! My research\n" +
                "isn't complete yet. Ok, you win.\nTake this Badge.";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Metapod metapod = new Metapod();
        metapod.insertWildData(15, 0);
        List<Skill> metapodSkills = new ArrayList<Skill>();
        metapodSkills.add(new Tackle());
        metapod.setSkillset(metapodSkills);

        Kakuna kakuna = new Kakuna();
        kakuna.insertWildData(15, 0);
        List<Skill> kakunaSkills = new ArrayList<Skill>();
        kakunaSkills.add(new PoisonSting());
        kakuna.setSkillset(kakunaSkills);

        Scyther scyther = new Scyther();
        scyther.insertWildData(17, 0);
        List<Skill> scytherSkills = new ArrayList<Skill>();
        //TODO: U-Turn
        scytherSkills.add(new QuickAttack());
        scytherSkills.add(new Leer());
        scytherSkills.add(new FocusEnergy());
        scyther.setSkillset(scytherSkills);

        party.add(metapod);
        party.add(kakuna);
        party.add(scyther);
        return new Trainer(0, "Gym Leader", "Bugsy", victoryText,
                "trainers/small/bugsy.png", party, Trainer.Badge.JOHTO_BADGE);
    }

    public Trainer getGymLeaderWhitney() {
        String victoryText = "Waaaaah! Waaaaah! Snivel, hic...\nYou meanie!";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Clefairy clefairy = new Clefairy();
        clefairy.insertWildData(18, 0);
        List<Skill> clefairySkills = new ArrayList<Skill>();
        //TODO: ENCORE, MIMIC, METRONOME
        clefairySkills.add(new DoubleSlap());
        clefairy.setSkillset(clefairySkills);

        Miltank miltank = new Miltank();
        miltank.insertWildData(20, 0);
        List<Skill> miltankSkills = new ArrayList<Skill>();
        miltankSkills.add(new Stomp());
        miltankSkills.add(new Rollout());
        miltankSkills.add(new MilkDrink());
        //TODO: Attract
        miltank.setSkillset(miltankSkills);

        party.add(clefairy);
        party.add(miltank);
        return new Trainer(0, "Gym Leader", "Whitney", victoryText,
                "trainers/small/whitney.png", party, Trainer.Badge.JOHTO_BADGE);
    }

    public Trainer getGymLeaderMorty() {
        String victoryText = "I'm not good enough yet...\nAll right. This Badge is yours.";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Gastly gastly = new Gastly();
        gastly.insertWildData(21, 0);
        List<Skill> firstGastlySkills = new ArrayList<Skill>();
        //TODO: Mean Look, Spite
        firstGastlySkills.add(new Lick());
        firstGastlySkills.add(new Curse());
        gastly.setSkillset(firstGastlySkills);

        Haunter firstHaunter = new Haunter();
        firstHaunter.insertWildData(21, 0);
        List<Skill> firstHaunterSkills = new ArrayList<Skill>();
        firstHaunterSkills.add(new Hypnosis());
        firstHaunterSkills.add(new DreamEater());
        firstHaunterSkills.add(new Curse());
        firstHaunterSkills.add(new Nightmare());
        firstHaunter.setSkillset(firstHaunterSkills);

        Gengar gengar = new Gengar();
        gengar.insertWildData(25, 0);
        List<Skill> gengarSkills = new ArrayList<Skill>();
        gengarSkills.add(new Hypnosis());
        gengarSkills.add(new ShadowBall());
        gengarSkills.add(new SuckerPunch());
        //TODO: Mean Look
        gengar.setSkillset(gengarSkills);

        Haunter secondHaunter = new Haunter();
        secondHaunter.insertWildData(23, 0);
        List<Skill> secondHaunterSkills = new ArrayList<Skill>();
        secondHaunterSkills.add(new SuckerPunch());
        secondHaunterSkills.add(new NightShade());
        secondHaunterSkills.add(new Curse());
        //TODO: Mean Look
        secondHaunter.setSkillset(secondHaunterSkills);

        party.add(gastly);
        party.add(firstHaunter);
        party.add(gengar);
        party.add(secondHaunter);
        return new Trainer(0, "Gym Leader", "Morty", victoryText,
                "trainers/small/morty.png", party, Trainer.Badge.JOHTO_BADGE);
    }

    public Trainer getGymLeaderChuck() {
        String victoryText = "Wha? Huh? I lost? How about that!\nYou're worthy of StormBadge!";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Primeape primeape = new Primeape();
        primeape.insertWildData(29, 0);
        List<Skill> primeapeSkills = new ArrayList<Skill>();
        //TODO: Focus Punch
        primeapeSkills.add(new Leer());
        primeapeSkills.add(new DoubleTeam());
        primeapeSkills.add(new RockSlide());
        primeape.setSkillset(primeapeSkills);

        Poliwrath poliwrath = new Poliwrath();
        poliwrath.insertWildData(31, 0);
        List<Skill> poliwrathSkills = new ArrayList<Skill>();
        poliwrathSkills.add(new Hypnosis());
        poliwrathSkills.add(new Surf());
        poliwrathSkills.add(new BodySlam());
        //TODO: Focus Punch
        poliwrath.setSkillset(poliwrathSkills);

        party.add(primeape);
        party.add(poliwrath);
        return new Trainer(0, "Gym Leader", "Chuck", victoryText,
                "trainers/small/chuck.png", party, Trainer.Badge.JOHTO_BADGE);
    }

    public Trainer getGymLeaderJasmine() {
        String victoryText = "...You are a better trainer than me, in both skill\n" +
                "and kindness. In accordance with League rules,\nI confer upon you this Badge.";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Magnemite firstMagnemite = new Magnemite();
        firstMagnemite.insertWildData(30, 0);
        List<Skill> firstMagnemiteSkills = new ArrayList<Skill>();
        firstMagnemiteSkills.add(new ThunderWave());
        firstMagnemiteSkills.add(new Thunderbolt());
        firstMagnemiteSkills.add(new Supersonic());
        firstMagnemiteSkills.add(new SonicBoom());
        firstMagnemite.setSkillset(firstMagnemiteSkills);

        Magnemite secondMagnemite = new Magnemite();
        secondMagnemite.insertWildData(30, 0);
        List<Skill> secondMagnemiteSkills = new ArrayList<Skill>();
        secondMagnemiteSkills.add(new ThunderWave());
        secondMagnemiteSkills.add(new Thunderbolt());
        secondMagnemiteSkills.add(new Supersonic());
        secondMagnemiteSkills.add(new SonicBoom());
        secondMagnemite.setSkillset(secondMagnemiteSkills);

        Steelix steelix = new Steelix();
        steelix.insertWildData(35, 0);
        List<Skill> steelixSkills = new ArrayList<Skill>();
        steelixSkills.add(new RockThrow());
        steelixSkills.add(new Screech());
        steelixSkills.add(new Sandstorm());
        steelixSkills.add(new IronTail());
        steelix.setSkillset(steelixSkills);

        party.add(firstMagnemite);
        party.add(secondMagnemite);
        party.add(steelix);
        return new Trainer(0, "Gym Leader", "Jasmine", victoryText,
                "trainers/small/jasmine.png", party, Trainer.Badge.JOHTO_BADGE);
    }

    public Trainer getGymLeaderPryce() {
        String victoryText = "Hmm. Seems as if my luck has run out.";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Seel seel = new Seel();
        seel.insertWildData(30, 0);
        List<Skill> seelSkills = new ArrayList<Skill>();
        seelSkills.add(new IcyWind());
        seelSkills.add(new Rest());
        seelSkills.add(new Snore());
        seelSkills.add(new Hail());
        seel.setSkillset(seelSkills);

        Dewgong dewgong = new Dewgong();
        dewgong.insertWildData(32, 0);
        List<Skill> dewgongSkills = new ArrayList<Skill>();
        dewgongSkills.add(new AuroraBeam());
        dewgongSkills.add(new Rest());
        dewgongSkills.add(new IceShard());
        //TODO: Sleep Talk
        dewgong.setSkillset(dewgongSkills);

        Piloswine piloswine = new Piloswine();
        piloswine.insertWildData(34, 0);
        List<Skill> piloswineSkills = new ArrayList<Skill>();
        piloswineSkills.add(new MudBomb());
        piloswineSkills.add(new Blizzard());
        piloswineSkills.add(new IceFang());
        piloswineSkills.add(new Hail());
        piloswine.setSkillset(piloswineSkills);

        party.add(seel);
        party.add(dewgong);
        party.add(piloswine);
        return new Trainer(0, "Gym Leader", "Pryce", victoryText,
                "trainers/small/pryce.png", party, Trainer.Badge.JOHTO_BADGE);
    }

    public Trainer getGymLeaderClair() {
        String victoryText = "I lost... I don't believe it.\nThere must be some mistake...";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Gyarados gyarados = new Gyarados();
        gyarados.insertWildData(38, 0);
        List<Skill> gyaradosSkills = new ArrayList<Skill>();
        gyaradosSkills.add(new Bite());
        gyaradosSkills.add(new Twister());
        gyaradosSkills.add(new DragonRage());
        gyaradosSkills.add(new DragonPulse());
        gyarados.setSkillset(gyaradosSkills);

        Dragonair firstDragonair = new Dragonair();
        firstDragonair.insertWildData(38, 0);
        List<Skill> firstDragonairSkills = new ArrayList<Skill>();
        firstDragonairSkills.add(new ThunderWave());
        firstDragonairSkills.add(new Slam());
        firstDragonairSkills.add(new DragonPulse());
        firstDragonairSkills.add(new AquaTail());
        firstDragonair.setSkillset(firstDragonairSkills);

        Dragonair secondDragonair = new Dragonair();
        secondDragonair.insertWildData(38, 0);
        List<Skill> secondDragonairSkills = new ArrayList<Skill>();
        secondDragonairSkills.add(new ThunderWave());
        secondDragonairSkills.add(new Slam());
        secondDragonairSkills.add(new DragonPulse());
        secondDragonairSkills.add(new FireBlast());
        secondDragonair.setSkillset(secondDragonairSkills);

        Kingdra kingdra = new Kingdra();
        kingdra.insertWildData(41, 0);
        List<Skill> kingdraSkills = new ArrayList<Skill>();
        kingdraSkills.add(new HydroPump());
        kingdraSkills.add(new Smokescreen());
        kingdraSkills.add(new HyperBeam());
        kingdraSkills.add(new DragonPulse());
        kingdra.setSkillset(kingdraSkills);

        party.add(gyarados);
        party.add(firstDragonair);
        party.add(secondDragonair);
        party.add(kingdra);
        return new Trainer(0, "Gym Leader", "Clair", victoryText,
                "trainers/small/clair.png", party, Trainer.Badge.JOHTO_BADGE);
    }

    public Trainer getElite4Will() {
        String victoryText = "I lost... I don't believe it.\nThere must be some mistake...";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Xatu firstXatu = new Xatu();
        firstXatu.insertWildData(40, 0);
        List<Skill> firstXatuSkills = new ArrayList<Skill>();
        firstXatuSkills.add(new ConfuseRay());
        firstXatuSkills.add(new Psychic());
        //TODO: Me First, U-Turn
        firstXatu.setSkillset(firstXatuSkills);

        Jynx jynx = new Jynx();
        jynx.insertWildData(41, 0);
        List<Skill> jynxSkills = new ArrayList<Skill>();
        jynxSkills.add(new LovelyKiss());
        jynxSkills.add(new DoubleSlap());
        jynxSkills.add(new IcePunch());
        jynxSkills.add(new Psychic());
        jynx.setSkillset(jynxSkills);

        Slowbro slowbro = new Slowbro();
        slowbro.insertWildData(41, 0);
        List<Skill> slowbroSkills = new ArrayList<Skill>();
        slowbroSkills.add(new Curse());
        slowbroSkills.add(new Amnesia());
        slowbroSkills.add(new WaterPulse());
        slowbroSkills.add(new Psychic());
        slowbro.setSkillset(slowbroSkills);

        Exeggutor exeggutor = new Exeggutor();
        exeggutor.insertWildData(41, 0);
        List<Skill> exeggutorSkills = new ArrayList<Skill>();
        exeggutorSkills.add(new Reflect());
        exeggutorSkills.add(new Hypnosis());
        exeggutorSkills.add(new EggBomb());
        exeggutorSkills.add(new Psychic());
        exeggutor.setSkillset(exeggutorSkills);

        Xatu secondXatu = new Xatu();
        secondXatu.insertWildData(42, 0);
        List<Skill> secondXatuSkills = new ArrayList<Skill>();
        secondXatuSkills.add(new ConfuseRay());
        secondXatuSkills.add(new OminousWind());
        secondXatuSkills.add(new AerialAce());
        secondXatuSkills.add(new Psychic());
        secondXatu.setSkillset(secondXatuSkills);

        party.add(firstXatu);
        party.add(jynx);
        party.add(slowbro);
        party.add(exeggutor);
        party.add(secondXatu);
        return new Trainer(0, "Elite 4", "Will", victoryText,
                "trainers/small/will.png", party, Trainer.Badge.JOHTO_WILL);
    }

    public Trainer getElite4Koga() {
        String victoryText = "Ah! You've proven your worth!";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Ariados ariados = new Ariados();
        ariados.insertWildData(40, 0);
        List<Skill> ariadosSkills = new ArrayList<Skill>();
        ariadosSkills.add(new SpiderWeb());
        ariadosSkills.add(new GigaDrain());
        ariadosSkills.add(new PoisonJab());
        //TODO: Baton Pass
        ariados.setSkillset(ariadosSkills);

        Forretress forretress = new Forretress();
        forretress.insertWildData(43, 0);
        List<Skill> forretressSkills = new ArrayList<Skill>();
        forretressSkills.add(new Swift());
        forretressSkills.add(new Explosion());
        forretressSkills.add(new ToxicSpikes());
        //TODO: Protect
        forretress.setSkillset(forretressSkills);

        Muk muk = new Muk();
        muk.insertWildData(42, 0);
        List<Skill> mukSkills = new ArrayList<Skill>();
        mukSkills.add(new GunkShot());
        mukSkills.add(new Screech());
        mukSkills.add(new Minimize());
        //TODO: Toxic
        muk.setSkillset(mukSkills);

        Venomoth venomoth = new Venomoth();
        venomoth.insertWildData(41, 0);
        List<Skill> venomothSkills = new ArrayList<Skill>();
        venomothSkills.add(new Psychic());
        venomothSkills.add(new Gust());
        venomothSkills.add(new Supersonic());
        //TODO: Toxic
        venomoth.setSkillset(venomothSkills);

        Crobat crobat = new Crobat();
        crobat.insertWildData(44, 0);
        List<Skill> crobatSkills = new ArrayList<Skill>();
        crobatSkills.add(new QuickAttack());
        crobatSkills.add(new WingAttack());
        crobatSkills.add(new PoisonFang());
        crobatSkills.add(new DoubleTeam());
        crobat.setSkillset(crobatSkills);

        party.add(ariados);
        party.add(forretress);
        party.add(muk);
        party.add(venomoth);
        party.add(crobat);
        return new Trainer(0, "Elite 4", "Koga", victoryText,
                "trainers/small/koga.png", party, Trainer.Badge.JOHTO_KOGA);
    }

    public Trainer getElite4JohtoBruno() {
        String victoryText = "Ah! You've proven your worth!";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Hitmontop hitmontop = new Hitmontop();
        hitmontop.insertWildData(42, 0);
        List<Skill> hitmontopSkills = new ArrayList<Skill>();
        hitmontopSkills.add(new Dig());
        hitmontopSkills.add(new TripleKick());
        hitmontopSkills.add(new QuickAttack());
        //TODO: Counter
        hitmontop.setSkillset(hitmontopSkills);

        Hitmonlee hitmonlee = new Hitmonlee();
        hitmonlee.insertWildData(42, 0);
        List<Skill> hitmonleeSkills = new ArrayList<Skill>();
        hitmonleeSkills.add(new HighJumpKick());
        hitmonleeSkills.add(new BlazeKick());
        hitmonleeSkills.add(new FocusEnergy());
        hitmonleeSkills.add(new Swagger());
        hitmonlee.setSkillset(hitmonleeSkills);

        Hitmonchan hitmonchan = new Hitmonchan();
        hitmonchan.insertWildData(42, 0);
        List<Skill> hitmonchanSkills = new ArrayList<Skill>();
        hitmonchanSkills.add(new ThunderPunch());
        hitmonchanSkills.add(new IcePunch());
        hitmonchanSkills.add(new FirePunch());
        hitmonchanSkills.add(new BulletPunch());
        hitmonchan.setSkillset(hitmonchanSkills);

        Onix onix = new Onix();
        onix.insertWildData(43, 0);
        List<Skill> onixSkills = new ArrayList<Skill>();
        onixSkills.add(new Sandstorm());
        onixSkills.add(new DragonBreath());
        onixSkills.add(new RockSlide());
        onixSkills.add(new Earthquake());
        onix.setSkillset(onixSkills);

        Machamp machamp = new Machamp();
        machamp.insertWildData(46, 0);
        List<Skill> machampSkills = new ArrayList<Skill>();
        machampSkills.add(new Revenge());
        machampSkills.add(new CrossChop());
        machampSkills.add(new RockSlide());
        //TODO: Foresight
        machamp.setSkillset(machampSkills);

        party.add(hitmontop);
        party.add(hitmonlee);
        party.add(hitmonchan);
        party.add(onix);
        party.add(machamp);
        return new Trainer(0, "Elite 4", "Bruno", victoryText,
                "trainers/small/bruno.png", party, Trainer.Badge.JOHTO_BRUNO);
    }

    public Trainer getElite4Karen() {
        String victoryText = "Well, aren't you good. I like that in a trainer.";
        List<Pokemon> party = new ArrayList<Pokemon>();
        Umbreon umbreon = new Umbreon();
        umbreon.insertWildData(42, 0);
        List<Skill> umbreonSkills = new ArrayList<Skill>();
        umbreonSkills.add(new DoubleTeam());
        umbreonSkills.add(new ConfuseRay());
        umbreonSkills.add(new FeintAttack());
        umbreonSkills.add(new Payback());
        umbreon.setSkillset(umbreonSkills);

        Vileplume vileplume = new Vileplume();
        vileplume.insertWildData(42, 0);
        List<Skill> vilplumeSkills = new ArrayList<Skill>();
        vilplumeSkills.add(new StunSpore());
        vilplumeSkills.add(new PetalDance());
        vilplumeSkills.add(new Acid());
        vilplumeSkills.add(new Moonlight());
        vileplume.setSkillset(vilplumeSkills);

        Murkrow murkrow = new Murkrow();
        murkrow.insertWildData(44, 0);
        List<Skill> murkrowSkills = new ArrayList<Skill>();
        murkrowSkills.add(new SuckerPunch());
        murkrowSkills.add(new FeintAttack());
        murkrowSkills.add(new Pluck());
        //TODO: Whirlwind
        murkrow.setSkillset(murkrowSkills);

        Gengar gengar = new Gengar();
        gengar.insertWildData(45, 0);
        List<Skill> gengarSkills = new ArrayList<Skill>();
        gengarSkills.add(new FocusBlast());
        gengarSkills.add(new Lick());
        //TODO: Destiny Bond, Spite
        gengar.setSkillset(gengarSkills);

        Houndoom houndoom = new Houndoom();
        houndoom.insertWildData(47, 0);
        List<Skill> houndoomSkills = new ArrayList<Skill>();
        houndoomSkills.add(new NastyPlot());
        houndoomSkills.add(new DarkPulse());
        houndoomSkills.add(new Crunch());
        houndoomSkills.add(new Flamethrower());
        houndoom.setSkillset(houndoomSkills);

        party.add(umbreon);
        party.add(vileplume);
        party.add(murkrow);
        party.add(gengar);
        party.add(houndoom);
        return new Trainer(0, "Elite 4", "Karen", victoryText,
                "trainers/small/karen.png", party, Trainer.Badge.JOHTO_KAREN);
    }

    public Trainer getChampionLance() {
        String victoryText = "…It's over. But it’s an odd feeling. I'm not angry\n" +
                "that I lost. In fact, I feel happy. Happy\nthat I witnessed the rise of a great new Champion!";
        List<Pokemon> party = new ArrayList<Pokemon>();

        Gyarados gyarados = new Gyarados();
        gyarados.insertWildData(46, 0);
        List<Skill> gyaradosSkills = new ArrayList<Skill>();
        gyaradosSkills.add(new Waterfall());
        gyaradosSkills.add(new DragonPulse());
        gyaradosSkills.add(new IceFang());
        gyaradosSkills.add(new Flail());
        gyarados.setSkillset(gyaradosSkills);

        Dragonite firstDragonite = new Dragonite();
        firstDragonite.insertWildData(49, 0);
        List<Skill> firstDragoniteSkills = new ArrayList<Skill>();
        firstDragoniteSkills.add(new DragonRush());
        firstDragoniteSkills.add(new ThunderWave());
        firstDragoniteSkills.add(new Thunder());
        firstDragoniteSkills.add(new HyperBeam());
        firstDragonite.setSkillset(firstDragoniteSkills);

        Dragonite secondDragonite = new Dragonite();
        secondDragonite.insertWildData(49, 0);
        List<Skill> secondDragoniteSkills = new ArrayList<Skill>();
        secondDragoniteSkills.add(new DragonRush());
        secondDragoniteSkills.add(new ThunderWave());
        secondDragoniteSkills.add(new Blizzard());
        secondDragoniteSkills.add(new HyperBeam());
        secondDragonite.setSkillset(secondDragoniteSkills);

        Aerodactyl aerodactyl = new Aerodactyl();
        aerodactyl.insertWildData(48, 0);
        List<Skill> aerodactylSkills = new ArrayList<Skill>();
        aerodactylSkills.add(new RockSlide());
        aerodactylSkills.add(new AerialAce());
        aerodactylSkills.add(new Crunch());
        aerodactylSkills.add(new ThunderFang());
        aerodactyl.setSkillset(aerodactylSkills);

        Charizard charizard = new Charizard();
        charizard.insertWildData(48, 0);
        List<Skill> charizardSkills = new ArrayList<Skill>();
        charizardSkills.add(new AirSlash());
        charizardSkills.add(new FireFang());
        charizardSkills.add(new ShadowClaw());
        charizardSkills.add(new DragonClaw());
        charizard.setSkillset(charizardSkills);

        Dragonite thirdDragonite = new Dragonite();
        thirdDragonite.insertWildData(50, 0);
        List<Skill> thirdDragoniteSkills = new ArrayList<Skill>();
        thirdDragoniteSkills.add(new Outrage());
        thirdDragoniteSkills.add(new Safeguard());
        thirdDragoniteSkills.add(new HyperBeam());
        thirdDragoniteSkills.add(new FireBlast());
        thirdDragonite.setSkillset(thirdDragoniteSkills);

        party.add(gyarados);
        party.add(firstDragonite);
        party.add(secondDragonite);
        party.add(aerodactyl);
        party.add(charizard);
        party.add(thirdDragonite);
        return new Trainer(0, "Champion", "Lance", victoryText,
                "trainers/small/lance.png", party, Trainer.Badge.JOHTO_CHAMPION);
    }


    public WildTrainer getBugCatcher(double difficulty, double latitude, double longitude) {
        String title = "Bug Catcher";
        String name = getMaleName();
        List<Integer> pool = getBugCatcherPokemon(difficulty);
        double rand = Math.random();
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(),"trainers/small/bugcatcher.png",
                initParty(pool, difficulty));
    }

    public WildTrainer getTeacher(double difficulty, double latitude, double longitude) {
        String title = "Teacher";
        String name = getFemaleName();
        List<Integer> pool = getTeacherPokemon(difficulty);
        double rand = Math.random();
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(),"trainers/small/teacher.png",
                initParty(pool, difficulty));
    }

    public WildTrainer getLass(double difficulty, double latitude, double longitude) {
        String title = "Lass";
        String name = getFemaleName();
        List<Integer> pool = getLassPokemon(difficulty);
        String iconPath;
        double rand = Math.random();
        if (rand <= .33) {
            iconPath = "trainers/small/lass.png";
        } else if (rand <= .66) {
            iconPath = "trainers/small/lass2.png";
        } else {
            iconPath = "trainers/small/lass3.png";
        }
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(),iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getYoungster(double difficulty, double latitude, double longitude) {
        String title = "Youngster";
        String name = getMaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            iconPath = "trainers/small/youngster.png";
        } else {
            iconPath = "trainers/small/youngster2.png";
        }
        List<Integer> pool = getYoungsterPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getScientist(double difficulty, double latitude, double longitude) {
        String title = "Scientist";
        String name = getMaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .33) {
            iconPath = "trainers/small/scientist.png";
        } else if (rand <= .66){
            iconPath = "trainers/small/scientist2.png";
        } else {
            iconPath = "trainers/small/scientist3.png";
        }
        List<Integer> pool = getScientistPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getPsychic(double difficulty, double latitude, double longitude) {
        String title = "Psychic";
        String name;
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            name = getMaleName();
            iconPath = "trainers/small/psychicm.png";
        } else {
            name = getFemaleName();
            iconPath = "trainers/small/psychicf.png";
        }
        List<Integer> pool = getPsychicPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getSwimmer(double difficulty, double latitude, double longitude) {
        String title = "Swimmer";
        String name;
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            name = getMaleName();
            if (rand <= .25) {
                iconPath = "trainers/small/swimmer.png";
            } else {
                iconPath = "trainers/small/swimmer2.png";
            }
        } else {
            name = getFemaleName();
            if (rand <= .75) {
                iconPath = "trainers/small/swimmerf.png";
            } else {
                iconPath = "trainers/small/swimmer2f.png";
            }
        }
        List<Integer> pool = getSwimmerPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getSchoolKid(double difficulty, double latitude, double longitude) {
        String title;
        String name;
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            title = "School Boy";
            name = getMaleName();
            iconPath = "trainers/small/schoolboy.png";
        } else {
            title = "School Girl";
            name = getFemaleName();
            iconPath = "trainers/small/schoolgirl.png";
        }
        List<Integer> pool = getSchoolKidPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getRanger(double difficulty, double latitude, double longitude) {
        String title = "Ranger";
        String name;
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            name = getMaleName();
            iconPath = "trainers/small/ranger.png";
        } else {
            name = getFemaleName();
            iconPath = "trainers/small/rangerf.png";
        }
        List<Integer> pool = getRangerPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getWaiter(double difficulty, double latitude, double longitude) {
        String title;
        String name;
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            title = "Waiter";
            name = getMaleName();
            iconPath = "trainers/small/waiter.png";
        } else {
            title = "Waitress";
            name = getFemaleName();
            iconPath = "trainers/small/waitress.png";
        }
        List<Integer> pool = getWaiterPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getDragonTamer(double difficulty, double latitude, double longitude) {
        String title = "Dragon Tamer";
        String name = getMaleName();
        String iconPath = "trainers/small/dragontamer.png";

        List<Integer> pool = getDragonTamerPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getPilotPokemon(double difficulty, double latitude, double longitude) {
        String title = "Pilot";
        String name = getMaleName();
        String iconPath = "trainers/small/pilot.png";

        List<Integer> pool = getPilotPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getConductorPokemon(double difficulty, double latitude, double longitude) {
        String title = "Conductor";
        String name = getMaleName();
        String iconPath = "trainers/small/conductor.png";

        List<Integer> pool = getConductorPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getVeteranMale(double difficulty, double latitude, double longitude) {
        String title = "Veteran";
        String name = getMaleName();
        String iconPath = "trainers/small/veteran.png";

        List<Integer> pool = getVeteranMalePokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getVeteranFemale(double difficulty, double latitude, double longitude) {
        String title = "Veteran";
        String name = getFemaleName();
        String iconPath = "trainers/small/veteranf.png";

        List<Integer> pool = getVeteranFemalePokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getSocialite(double difficulty, double latitude, double longitude) {
        String title = "Socialite";
        String name = getFemaleName();
        String iconPath = "trainers/small/socialite.png";

        List<Integer> pool = getSocialitePokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getRichBoy(double difficulty, double latitude, double longitude) {
        String title = "Rich Boy";
        String name = getMaleName();
        String iconPath = "trainers/small/richboy.png";

        List<Integer> pool = getRichBoyPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getRuneManiac(double difficulty, double latitude, double longitude) {
        String title = "Rune Maniac";
        String name = getMaleName();
        String iconPath = "trainers/small/runemaniac.png";

        List<Integer> pool = getRuneManiacPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getSage(double difficulty, double latitude, double longitude) {
        String title = "Sage";
        String name = getMaleName();
        String iconPath = "trainers/small/sage.png";

        List<Integer> pool = getSagePokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getSailor(double difficulty, double latitude, double longitude) {
        String title = "Sailor";
        String name = getMaleName();
        String iconPath = "trainers/small/sailor.png";

        List<Integer> pool = getSailorPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getFirebreather(double difficulty, double latitude, double longitude) {
        String title = "Firebreather";
        String name = getMaleName();
        String iconPath = "trainers/small/firebreather.png";

        List<Integer> pool = getFirebreatherPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getHiker(double difficulty, double latitude, double longitude) {
        String title = "Hiker";
        String name = getMaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            iconPath = "trainers/small/hiker.png";
        } else {
            iconPath = "trainers/small/hiker2.png";
        }
        List<Integer> pool = getHikerPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getFisherman(double difficulty, double latitude, double longitude) {
        String title = "Fisherman";
        String name = getMaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            iconPath = "trainers/small/fisherman.png";
        } else {
            iconPath = "trainers/small/fisherman2.png";
        }
        List<Integer> pool = getFishermanPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getKimonoGirl(double difficulty, double latitude, double longitude) {
        String title = "Kimono Girl";
        String name = getFemaleName();
        String iconPath = "trainers/small/kimonogirl.png";

        List<Integer> pool = getKimonoGirlPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getAromaLady(double difficulty, double latitude, double longitude) {
        String title = "Aroma Lady";
        String name = getFemaleName();
        String iconPath = "trainers/small/aromalady.png";

        List<Integer> pool = getAromaLadyPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getBlackbelt(double difficulty, double latitude, double longitude) {
        String title = "Blackbelt";
        String name = getMaleName();
        String iconPath = "trainers/small/blackbelt.png";

        List<Integer> pool = getBlackbeltPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getPicnickerMale(double difficulty, double latitude, double longitude) {
        String title = "Picnicker";
        String name = getMaleName();
        String iconPath = "trainers/small/picnickerm.png";
        List<Integer> pool = getPicnickerMalePokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getPicnickerFemale(double difficulty, double latitude, double longitude) {
        String title = "Picnicker";
        String name = getMaleName();
        String iconPath = "trainers/small/picnickerf.png";
        List<Integer> pool = getPicnickerFemalePokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getDoctor(double difficulty, double latitude, double longitude) {
        String title = "Doctor";
        String name = getMaleName();
        String iconPath = "trainers/small/doctor.png";

        List<Integer> pool = getDoctorPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getBirdKeeper(double difficulty, double latitude, double longitude) {
        String title = "Bird Keeper";
        String name = getMaleName();
        String iconPath = "trainers/small/birdkeeper.png";

        List<Integer> pool = getBirdKeeperPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getGambler(double difficulty, double latitude, double longitude) {
        String title = "Gambler";
        String name = getMaleName();
        String iconPath = "trainers/small/gambler.png";

        List<Integer> pool = getGamblerPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getGentleman(double difficulty, double latitude, double longitude) {
        String title = "Gentleman";
        String name = getMaleName();
        String iconPath = "trainers/small/gentleman.png";

        List<Integer> pool = getGentlemanPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getJuggler(double difficulty, double latitude, double longitude) {
        String title = "Juggler";
        String name = getMaleName();
        String iconPath = "trainers/small/juggler.png";

        List<Integer> pool = getJugglerPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getNurse(double difficulty, double latitude, double longitude) {
        String title = "Nurse";
        String name = getFemaleName();
        String iconPath = "trainers/small/nurse.png";

        List<Integer> pool = getNursePokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getAceTrainerMale(double difficulty, double latitude, double longitude) {
        String title = "Ace Trainer";
        String name = getMaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .33) {
            iconPath = "trainers/small/acetrainer.png";
        } else if (rand <= .66){
            iconPath = "trainers/small/acetrainer2.png";
        } else {
            iconPath = "trainers/small/acetrainer3.png";
        }

        List<Integer> pool = getAceTrainerMalePokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getAceTrainerFemale(double difficulty, double latitude, double longitude) {
        String title = "Ace Trainer";
        String name = getFemaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .33) {
            iconPath = "trainers/small/acetrainerf.png";
        } else if (rand <= .66){
            iconPath = "trainers/small/acetrainerf2.png";
        } else {
            iconPath = "trainers/small/acetrainerf3.png";
        }

        List<Integer> pool = getAceTrainerFemalePokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getBattleGirl(double difficulty, double latitude, double longitude) {
        String title = "Battle Girl";
        String name = getFemaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            iconPath = "trainers/small/battlegirl.png";
        } else {
            iconPath = "trainers/small/battlegirl2.png";
        }

        List<Integer> pool = getBattleGirlPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getBeauty(double difficulty, double latitude, double longitude) {
        String title = "Beauty";
        String name = getFemaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            iconPath = "trainers/small/beauty.png";
        } else {
            iconPath = "trainers/small/beauty2.png";
        }

        List<Integer> pool = getBeautyPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getLady(double difficulty, double latitude, double longitude) {
        String title = "Lady";
        String name = getFemaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            iconPath = "trainers/small/lady.png";
        } else {
            iconPath = "trainers/small/lady2.png";
        }

        List<Integer> pool = getLadyPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getParasolLady(double difficulty, double latitude, double longitude) {
        String title = "Parasol Lady";
        String name = getFemaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            iconPath = "trainers/small/parasollady.png";
        } else {
            iconPath = "trainers/small/parasollady2.png";
        }

        List<Integer> pool = getParasolLadyPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getBaker(double difficulty, double latitude, double longitude) {
        String title = "Baker";
        String name = getFemaleName();
        String iconPath = "trainers/small/baker.png";

        List<Integer> pool = getBakerPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getMedium(double difficulty, double latitude, double longitude) {
        String title = "Medium";
        String name = getFemaleName();
        String iconPath = "trainers/small/medium.png";

        List<Integer> pool = getMediumPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getPolice(double difficulty, double latitude, double longitude) {
        String title = "Police Officer";
        String name = getMaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .7) {
            iconPath = "trainers/small/policeman2.png";
        } else {
            iconPath = "trainers/small/policeman.png";
        }
        List<Integer> pool = getPolicePokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getCueBall(double difficulty, double latitude, double longitude) {
        String title = "Cue Ball";
        String name = getMaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            iconPath = "trainers/small/cueball.png";
        } else {
            iconPath = "trainers/small/cueball2.png";
        }

        List<Integer> pool = getCueBallPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getBiker(double difficulty, double latitude, double longitude) {
        String title = "Biker";
        String name = getMaleName();
        String iconPath;
        double rand = Math.random();
        if (rand <= .5) {
            iconPath = "trainers/small/biker.png";
        } else {
            iconPath = "trainers/small/biker2.png";
        }

        List<Integer> pool = getBikerPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getBurglar(double difficulty, double latitude, double longitude) {
        String title = "Burglar";
        String name = getMaleName();
        String iconPath = "trainers/small/burglar.png";

        List<Integer> pool = getBurglarPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public WildTrainer getJanitor(double difficulty, double latitude, double longitude) {
        String title = "Janitor";
        String name = getMaleName();
        String iconPath = "trainers/small/janitor.png";

        List<Integer> pool = getJanitorPokemon(difficulty);
        return new WildTrainer(latitude, longitude, difficulty, title, name,
                getVictoryText(), iconPath, initParty(pool, difficulty));
    }

    public void getPicnickerMale() {
        String title = "Picnicker";
        String name = getMaleName();
    }

    public void getPicnickerFemale() {
        String title = "Picnicker";
        String name = getFemaleName();
    }
}
