package com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.attributes;

/**
 * Created by Gregory on 2017-12-31.
 */

public class Ability {
    private AbilityId id;
    private String name;
    private String description;
    public Ability(AbilityId id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public AbilityId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    /*********************************************************************************************
     *                                  Ability IDs
     * *******************************************************************************************/


    public enum AbilityId {
        ADAPTABILITY(0),
        AERILATE(1),
        AFTERMATH(2),
        AIR_LOCK(3),
        ANALYTIC(4),
        ANGER_POINT(5),
        ANTICIPATION(6),
        ARENA_TRAP(7),
        AROMA_VEIL(8),
        AURA_BREAK(9),

        BAD_DREAMS(10),
        BATTERY(11),
        BATTLE_ARMOR(12),
        BEAST_BOOST(13),
        BERSERK(14),
        BIG_PECKS(15),
        BLAZE(16),
        BULLETPROOF(17),

        CHEEK_POUCH(18),
        CHLOROPHYLL(19),
        CLEAR_BODY(20),
        CLOUD_NINE(21),
        COLOR_CHANGE(22),
        COMATOSE(23),
        COMPETITIVE(24),
        COMPOUNDEYES(25),
        CONTRARY(26),
        CORROSION(27),
        CURSED_BODY(28),
        CUTE_CHARM(29),

        DAMP(30),
        DANCER(31),
        DARK_AURA(32),
        DAZZLING(33),
        DEFEATIST(34),
        DEFIANT(35),
        DELTA_STREAM(36),
        DISGUISE(37),
        DESOLATE_LAND(38),
        DOWNLOAD(39),
        DRIZZLE(40),
        DROUGHT(41),
        DRY_SKIN(42),

        EARLY_BIRD(43),
        EFFECT_SPORE(44),
        ELECTRIC_SURGE(45),
        EMERGENCY_EXIT(46),

        FAIRY_AURA(47),
        FILTER(48),
        FLAME_BODY(49),
        FLARE_BOOST(50),
        FLASH_FIRE(51),
        FLOWER_GIFT(52),
        FLOWER_VEIL(53),
        FLUFFY(54),
        FORECAST(55),
        FOREWARN(56),
        FRIEND_GUARD(57),
        FRISK(58),
        FULL_METAL_BODY(59),
        FUR_COAT(60),

        GALE_WINGS(61),
        GALVANIZE(62),
        GLUTTONY(63),
        GOOEY(64),
        GRASS_PELT(65),
        GRASSY_SURGE(66),
        GUTS(67),

        HARVEST(68),
        HEALER(69),
        HEATPROOF(70),
        HEAVY_METAL(71),
        HONEY_GATHER(72),
        HUGE_POWER(73),
        HUSTLE(74),
        HYDRATION(75),
        HYPER_CUTTER(76),

        ICE_BODY(77),
        ILLUMINATE(78),
        ILLUSION(79),
        IMMUNITY(80),
        IMPOSTER(81),
        INFILTRATOR(82),
        INNARDS_OUT(83),
        INNER_FOCUS(84),
        INSOMNIA(85),
        INTIMIDATE(86),
        IRON_BARBS(87),
        IRON_FIST(88),

        JUSTIFIED(89),

        KEEN_EYE(90),
        KLUTZ(91),

        LEAF_GUARD(92),
        LEVITATE(93),
        LIGHT_METAL(94),
        LIGHTNINGROD(95),
        LIMBER(96),
        LIQUID_OOZE(97),
        LIQUID_VOICE(98),
        LONG_REACH(99),

        MAGIC_GUARD(100),
        MAGIC_BOUNCE(101),
        MAGICIAN(102),
        MAGMA_ARMOR(103),
        MAGNET_PULL(104),
        MARVEL_SCALE(105),
        MEGA_LAUNCHER(106),
        MERCILESS(107),
        MINUS(108),
        MISTY_SURGE(109),
        MOLD_BREAKER(110),
        MOODY(111),
        MOTOR_DRIVE(112),
        MOXIE(113),
        MULTISCALE(114),
        MULTITYPE(115),
        MUMMY(116),

        NATURAL_CURE(117),
        NO_GUARD(118),
        NORMALIZE(119),

        OBLIVIOUS(120),
        OVERCOAT(121),
        OVERGROW(122),
        OWN_TEMPO(123),

        PARENTAL_BOND(124),
        PICKPOCKET(125),
        PICKUP(126),
        PIXILATE(127),
        PLUS(128),
        POISON_HEAL(129),
        POISON_POINT(130),
        POISON_TOUCH(131),
        POWER_OF_ALCHEMY(132),
        PRANKSTER(133),
        PRESSURE(134),
        PRIMORDIAL_SEA(135),
        PRISM_ARMOR(136),
        PROTEAN(137),
        PSYCHIC_SURGE(138),
        PURE_POWER(139),

        QUEENLY_MAJESTY(140),
        QUICK_FEET(141),

        RAIN_DISH(142),
        RATTLED(143),
        RECEIVER(144),
        RECKLESS(145),
        REFRIGERATE(146),
        REGENERATOR(147),
        RIVALRY(148),
        RKS_SYSTEM(149),
        ROCK_HEAD(150),
        ROUGH_SKIN(151),
        RUN_AWAY(152),

        SAND_FORCE(153),
        SAND_RUSH(154),
        SAND_STREAM(155),
        SAND_VEIL(156),
        SAP_SIPPER(157),
        SCHOOLING(158),
        SCRAPPY(159),
        SERENE_GRACE(160),
        SHADOW_SHIELD(161),
        SHADOW_TAG(162),
        SHED_SKIN(163),
        SHEER_FORCE(164),
        SHELL_ARMOR(165),
        SHIELD_DUST(166),
        SHIELDS_DOWN(167),
        SIMPLE(168),
        SKILL_LINK(169),
        SLOW_START(170),
        SLUSH_RUSH(171),
        SNIPER(172),
        SNOW_CLOAK(173),
        SNOW_WARNING(174),
        SOLAR_POWER(175),
        SOLID_ROCK(176),
        SOUL_HEART(177),
        SOUNDPROOF(178),
        SPEED_BOOST(179),
        STAKEOUT(180),
        STALL(181),
        STAMINA(182),
        STANCE_CHANGE(183),
        STATIC(184),
        STEADFAST(185),
        STEELWORKER(186),
        STENCH(187),
        STICKY_HOLD(188),
        STORM_DRAIN(189),
        STRONG_JAW(190),
        STURDY(191),
        SUCTION_CUPS(192),
        SUPER_LUCK(193),
        SURGE_SURFER(194),
        SWARM(195),
        SWEET_VEIL(196),
        SWIFT_SWIM(197),
        SYMBIOSIS(198),
        SYNCHRONIZE(199),

        TANGLED_FEET(200),
        TANGLING_HAIR(201),
        TECHNICIAN(202),
        TELEPATHY(203),
        TERAVOLT(204),
        THICK_FAT(205),
        TINTED_LENS(206),
        TORRENT(207),
        TOUGH_CLAWS(208),
        TOXIC_BOOST(209),
        TRACE(210),
        TRIAGE(211),
        TRUANT(212),
        TURBOBLAZE(213),

        UNAWARE(214),
        UNBURDEN(215),
        UNNERVE(216),

        VICTORY_STAR(217),
        VITAL_SPIRIT(218),
        VOLT_ABSORB(219),

        WATER_ABSORB(220),
        WATER_BUBBLE(221),
        WATER_COMPACTION(222),
        WATER_VEIL(223),
        WEAK_ARMOR(224),
        WHITE_SMOKE(225),
        WIMP_OUT(226),
        WONDER_GUARD(227),
        WONDER_SKIN(228),

        ZEN_MODE(229),
        NONE(230);
        private final int value;
        private AbilityId(int value) {
            this.value = value;
        }
        public static AbilityId fromInt(int i) {
            for (AbilityId n : AbilityId.values()) {
                if (n.getValue() == i) { return n; }
            }
            return null;
        }

        public int getValue() {
            return value;
        }
    }

    /*********************************************************************************************
     *                                  Ability Subclasses
     * *******************************************************************************************/

    /*
    ****************** A ***************
     */

    public static class Adaptability extends Ability {
        public Adaptability() {
            super(AbilityId.ADAPTABILITY, "Adaptability", "Powers up moves of the same " +
                    "type as the Pokémon.");
        }
    }

    public static class Aerilate extends Ability {
        public Aerilate() {
            super(AbilityId.AERILATE, "Aerilate", "Normal-type moves become Flying-type " +
                    "moves. The power of those moves is boosted a little.");
        }
    }

    public static class Aftermath extends Ability {
        public Aftermath() {
            super(AbilityId.AFTERMATH, "Aftermath", "Damages the attacker if it contacts" +
                    " the Pokémon with a finishing hit.");
        }
    }

    public static class AirLock extends Ability {
        public AirLock() {
            super(AbilityId.AIR_LOCK, "Air Lock", "All weather effects are negated while " +
                    "the Pokémon is on the field.");
        }
    }

    public static class Analytic extends Ability {
        public Analytic() {
            super(AbilityId.ANALYTIC, "Analytic", "Boosts move power when the Pokémon moves" +
                    " last.");
        }
    }

    public static class AngerPoint extends Ability {
        public AngerPoint() {
            super(AbilityId.ANGER_POINT, "Anger Point", "The Pokémon is angered when it takes" +
                    " a critical hit, and that maxes its Attack stat.");
        }
    }

    public static class Anticipation extends Ability {
        public Anticipation() {
            super(AbilityId.ANTICIPATION, "Anticipation", "The Pokémon can sense an opposing" +
                    " Pokémon's dangerous moves.");
        }
    }

    public static class ArenaTrap extends Ability {
        public ArenaTrap() {
            super(AbilityId.ARENA_TRAP, "Arena Trap", "Prevents opposing Pokémon from" +
                    " fleeing.");
        }
    }

    public static class AromaVeil extends Ability {
        public AromaVeil() {
            super(AbilityId.AROMA_VEIL, "Aroma Veil", "Protects itself and its allies from" +
                    " attacks that limit their move choices.");
        }
    }

    public static class AuraBreak extends Ability {
        public AuraBreak() {
            super(AbilityId.AURA_BREAK, "Aura Break", "The effects of Aura Abilities are" +
                    " reversed to lower the power of affected moves.");
        }
    }

    /*
    ****************** B ***************
    */

    public static class BadDreams extends Ability {
        public BadDreams() {
            super(AbilityId.BAD_DREAMS, "Bad Dreams", "Reduces the HP of sleeping" +
                    " opposing Pokémon.");
        }
    }

    public static class Battery extends Ability {
        public Battery() {
            super(AbilityId.BATTERY, "Battery", "Powers up ally Pokémon's special moves." +
                    " Boosts Ally Pokémon's Special Attack by 30%.");
        }
    }

    public static class BattleArmor extends Ability {
        public BattleArmor() {
            super(AbilityId.BATTLE_ARMOR, "Battle Armor", "Hard armor protects the Pokémon" +
                    " from critical hits.");
        }
    }

    public static class BeastBoost extends Ability {
        public BeastBoost() {
            super(AbilityId.BEAST_BOOST, "Beast Boost", "The Pokémon boosts its most " +
                    "proficient stat each time it knocks out a Pokémon.");
        }
    }

    public static class Berserk extends Ability {
        public Berserk() {
            super(AbilityId.BERSERK, "Berserk", "Boosts the Pokémon's Sp. Atk stat when" +
                    " it takes a hit that causes its HP to become half or less.");
        }
    }

    public static class BigPecks extends Ability {
        public BigPecks() {
            super(AbilityId.BIG_PECKS, "Big Pecks", "Protects the Pokémon from " +
                    "Defense-lowering effects.");
        }
    }

    public static class Blaze extends Ability {
        public Blaze() {
            super(AbilityId.BLAZE, "Blaze", "Powers up Fire-type moves when the" +
                    " Pokémon's HP is low.");
        }
    }

    public static class Bulletproof extends Ability {
        public Bulletproof() {
            super(AbilityId.BULLETPROOF, "Bulletproof", "Protects the Pokémon from some ball" +
                    " and bomb moves.");
        }
    }

    /*
    ****************** C ***************
    */


    public static class CheekPouch extends Ability {
        public CheekPouch() {
            super(AbilityId.CHEEK_POUCH, "Cheek Pouch", "Restores HP as well when the Pokémon" +
                    " eats a Berry.");
        }
    }

    public static class Chlorophyll extends Ability {
        public Chlorophyll() {
            super(AbilityId.CHLOROPHYLL, "Chlorophyll", "Boosts the Pokémon's Speed stat" +
                    " in sunshine.");
        }
    }

    public static class ClearBody extends Ability {
        public ClearBody() {
            super(AbilityId.CLEAR_BODY, "Clear Body", "Prevents other Pokémon's moves or" +
                    " Abilities from lowering the Pokémon's stats.");
        }
    }

    public static class CloudNine extends Ability {
        public CloudNine() {
            super(AbilityId.CLOUD_NINE, "Cloud Nine", "Eliminates the effects of weather.");
        }
    }

    public static class ColorChange extends Ability {
        public ColorChange() {
            super(AbilityId.COLOR_CHANGE, "Color Change", "The Pokémon's type becomes the type" +
                    " of the move used on it.");
        }
    }

    public static class Comatose extends Ability {
        public Comatose() {
            super(AbilityId.COMATOSE, "Comatose", "It's always drowsing and will never" +
                    " wake up. It can attack without waking up.");
        }
    }

    public static class Competitive extends Ability {
        public Competitive() {
            super(AbilityId.COMPETITIVE, "Competitive", "Boosts the Sp. Atk stat sharply" +
                    " when a stat is lowered.");
        }
    }

    public static class Compoundeyes extends Ability {
        public Compoundeyes() {
            super(AbilityId.COMPOUNDEYES, "Compoundeyes", "The Pokémon's compound eyes boost" +
                    " its accuracy.");
        }
    }

    public static class Contrary extends Ability {
        public Contrary() {
            super(AbilityId.CONTRARY, "Contrary", "Makes stat changes have an opposite" +
                    " effect.");
        }
    }

    public static class Corrosion extends Ability {
        public Corrosion() {
            super(AbilityId.CORROSION, "Corrosion", "The Pokémon can poison the target even" +
                    " if it's a Steel or Poison type.");
        }
    }

    public static class CursedBody extends Ability {
        public CursedBody() {
            super(AbilityId.CURSED_BODY, "Cursed Body", "May disable a move used on the" +
                    " Pokémon.");
        }
    }

    public static class CuteCharm extends Ability {
        public CuteCharm() {
            super(AbilityId.CUTE_CHARM, "Cute Charm", "Contact with the Pokémon may cause" +
                    " infatuation.");
        }
    }

    /*
    ****************** D ***************
    */


    public static class Damp extends Ability {
        public Damp() {
            super(AbilityId.DAMP, "Damp", "Prevents the use of explosive moves such" +
                    " as Self-Destruct by dampening its surroundings.");
        }
    }

    public static class Dancer extends Ability {
        public Dancer() {
            super(AbilityId.DANCER, "Dancer", "When another Pokémon uses a dance move," +
                    " it can use a dance move following it regardless of its Speed.");
        }
    }

    public static class DarkAura extends Ability {
        public DarkAura() {
            super(AbilityId.DARK_AURA, "Dark Aura", "Powers up each Pokémon's Dark-type" +
                    " moves.");
        }
    }

    public static class Dazzling extends Ability {
        public Dazzling() {
            super(AbilityId.DAZZLING, "Dazzling", "Surprises the opposing Pokémon, making" +
                    " it unable to attack using priority moves.");
        }
    }

    public static class Defeatist extends Ability {
        public Defeatist() {
            super(AbilityId.DEFEATIST, "Defeatist", "Halves the Pokémon's Attack and Sp. Atk"
                    + " stats when its HP becomes half or less.");
        }
    }

    public static class Defiant extends Ability {
        public Defiant() {
            super(AbilityId.DEFIANT, "Defiant", "Boosts the Pokémon's Attack stat sharply" +
                    " when its stats are lowered.");
        }
    }

    public static class DeltaStream extends Ability {
        public DeltaStream() {
            super(AbilityId.DELTA_STREAM, "Delta Stream", "The Pokémon changes the weather" +
                            " to eliminate all of the Flying type's weaknesses.");
        }
    }

    public static class Disguise extends Ability {
        public Disguise() {
            super(AbilityId.DISGUISE, "Disguise", "Once per battle, the shroud that covers" +
                    " the Pokémon can protect it from an attack.");
        }
    }

    public static class DesolateLand extends Ability {
        public DesolateLand() {
            super(AbilityId.DESOLATE_LAND, "Desolate Land", "The Pokémon changes the weather to" +
                    " nullify Water-type attacks.");
        }
    }

    public static class Download extends Ability {
        public Download() {
            super(AbilityId.DOWNLOAD, "Download", "Compares an opposing Pokémon's " +
                    "Defense and Sp. Def stats before raising its own Attack or Sp. Atk stat " +
                    "whichever will be more effective.");
        }
    }

    public static class Drizzle extends Ability {
        public Drizzle() {
            super(AbilityId.DRIZZLE, "Drizzle", "The Pokémon makes it rain when it enters" +
                    " a battle.");
        }
    }

    public static class Drought extends Ability {
        public Drought() {
            super(AbilityId.DROUGHT, "Drought", "Turns the sunlight harsh when the" +
                    " Pokémon enters a battle.");
        }
    }

    public static class DrySkin extends Ability {
        public DrySkin() {
            super(AbilityId.DRY_SKIN, "Dry Skin", "Restores HP in rain or when hit by" +
                    " Water-type moves. Reduces HP in sunshine, and increases the damage" +
                    " received from Fire-type moves.");
        }
    }

    /*
    ****************** E ***************
    */

    public static class EarlyBird extends Ability {
        public EarlyBird() {
            super(AbilityId.EARLY_BIRD, "Early Bird", "The Pokémon awakens twice as fast as"
                    + " other Pokémon from sleep.");
        }
    }

    public static class EffectSpore extends Ability {
        public EffectSpore() {
            super(AbilityId.EFFECT_SPORE, "Effect Spore", "    Contact with the Pokémon may"
                    + " inflict poison, sleep, or paralysis on its attacker.");
        }
    }

    public static class ElectricSurge extends Ability {
        public ElectricSurge() {
            super(AbilityId.ELECTRIC_SURGE, "Electric Surge", "Turns the ground into " +
                            "Electric Terrain when the Pokémon enters a battle.");
        }
    }

    public static class EmergencyExit extends Ability {
        public EmergencyExit() {
            super(AbilityId.EMERGENCY_EXIT, "Emergency Exit", "The Pokémon, sensing danger,"
                    + " switches out when its HP becomes half or less.");
        }
    }

    /*
    ****************** F ***************
    */

    public static class FairyAura extends Ability {
        public FairyAura() {
            super(AbilityId.FAIRY_AURA, "Fairy Aura", "Powers up each Pokémon's Fairy-type" +
                    " moves.");
        }
    }

    public static class Filter extends Ability {
        public Filter() {
            super(AbilityId.FILTER, "Filter", "Reduces the power of supereffective" +
                    " attacks taken.");
        }
    }

    public static class FlameBody extends Ability {
        public FlameBody() {
            super(AbilityId.FLAME_BODY, "Flame Body", "Contact with the Pokémon may burn" +
                    " the attacker.");
        }
    }

    public static class FlareBoost extends Ability {
        public FlareBoost() {
            super(AbilityId.FLARE_BOOST, "Flare Boost", "Powers up special attacks when the"
                    + " Pokémon is burned.");
        }
    }

    public static class FlashFire extends Ability {
        public FlashFire() {
            super(AbilityId.FLASH_FIRE, "Flash Fire", "Powers up the Pokémon's Fire-type" +
                    " moves if it's hit by one.");
        }
    }

    public static class FlowerGift extends Ability {
        public FlowerGift() {
            super(AbilityId.FLOWER_GIFT, "Flower Gift", "Boosts the Attack and Sp. Def" +
                    " stats of itself and allies when it is sunny.");
        }

    }

    public static class FlowerVeil extends Ability {
        public FlowerVeil() {
            super(AbilityId.FLOWER_VEIL, "Flower Veil", "Ally Grass-type Pokémon are " +
                    "protected from status conditions and the lowering of their stats.");
        }

    }

    public static class Fluffy extends Ability {
        public Fluffy() {
            super(AbilityId.FLUFFY, "Fluffy", "Halves the damage taken from moves that" +
                    " make direct contact, but doubles that of Fire-type moves.");
        }

    }

    public static class Forecast extends Ability {
        public Forecast() {
            super(AbilityId.FORECAST, "Forecast", "The Pokémon transforms with the weather" +
                    " to change its type to Water, Fire, or Ice.");
        }

    }

    public static class Forewarn extends Ability {
        public Forewarn() {
            super(AbilityId.FOREWARN, "Forewarn", "When it enters a battle, the Pokémon" +
                    " can tell one of the moves an opposing Pokémon has.");
        }
    }

    public static class FriendGuard extends Ability {
        public FriendGuard() {
            super(AbilityId.FRIEND_GUARD, "Friend Guard", "Reduces damage done to allies.");
        }
    }

    public static class Frisk extends Ability {
        public Frisk() {
            super(AbilityId.FRISK, "Frisk", "When it enters a battle, the Pokémon can" +
                    " check an opposing Pokémon's held item.");
        }
    }

    public static class FullMetalBody extends Ability {
        public FullMetalBody() {
            super(AbilityId.FULL_METAL_BODY, "Full Metal Body", "Prevents other Pokémon's " +
                    "moves or Abilities from lowering the Pokémon's stats.");
        }
    }

    public static class FurCoat extends Ability {
        public FurCoat() {
            super(AbilityId.FUR_COAT, "Fur Coat", "Halves the damage from physical moves" +
                    " onto this Pokémon.");
        }
    }


    /*
    ****************** G ***************
    */

    public static class GaleWings extends Ability {
        public GaleWings() {
            super(AbilityId.GALE_WINGS, "Gale Wings", "Gives priority to Flying-type" +
                    " moves when the Pokémon's HP is full.");
        }
    }

    public static class Galvanize extends Ability {
        public Galvanize() {
            super(AbilityId.GALVANIZE, "Galvanize", "Normal-type moves become" +
                    " Electric-type moves. The power of those moves is boosted a little.");
        }
    }

    public static class Gluttony extends Ability {
        public Gluttony() {
            super(AbilityId.GLUTTONY, "Gluttony", "Makes the Pokémon eat a held Berry when" +
                    " its HP drops to half or less, which is sooner than usual.");
        }
    }

    public static class Gooey extends Ability {
        public Gooey() {
            super(AbilityId.GOOEY, "Gooey", "Contact with the Pokémon lowers the" +
                    " attacker's Speed stat.");
        }
    }

    public static class GrassPelt extends Ability {
        public GrassPelt() {
            super(AbilityId.GRASS_PELT, "Grass Pelt", "Boosts the Pokémon's Defense stat" +
                    " in Grassy Terrain.");
        }
    }

    public static class GrassySurge extends Ability {
        public GrassySurge() {
            super(AbilityId.GRASSY_SURGE, "Grassy Surge", "Turns the ground into Grassy" +
                    " Terrain when the Pokémon enters a battle.");
        }
    }

    public static class Guts extends Ability {
        public Guts() {
            super(AbilityId.GUTS, "Guts", "It's so gutsy that having a status condition" +
                    " boosts the Pokémon's Attack stat.");
        }
    }

    /*
    ****************** H ***************
    */

    public static class Harvest extends Ability {
        public Harvest() {
            super(AbilityId.HARVEST, "Harvest", "May create another Berry after one is" +
                    " used.");
        }
    }

    public static class Healer extends Ability {
        public Healer() {
            super(AbilityId.HEALER, "Healer", "Sometimes heals an ally's status condition.");
        }
    }

    public static class Heatproof extends Ability {
        public Heatproof() {
            super(AbilityId.HEATPROOF, "Heatproof", "The heatproof body of the Pokémon" +
                    " halves the damage from Fire-type moves that hit it.");
        }

    }
    public static class HeavyMetal extends Ability {
        public HeavyMetal() {
            super(AbilityId.HEAVY_METAL, "Heavy Metal", "Doubles the Pokémon's weight.");
        }

    }


    public static class HoneyGather extends Ability {
        public HoneyGather() {
            super(AbilityId.HONEY_GATHER, "Honey Gather", "The Pokémon may gather Honey" +
                    " after a battle.");
        }
    }

    public static class HugePower extends Ability {
        public HugePower() {
            super(AbilityId.HUGE_POWER, "Huge Power", "Doubles the Pokémon's Attack stat.");
        }
    }

    public static class Hustle extends Ability {
        public Hustle() {
            super(AbilityId.HUSTLE, "Hustle", "Boosts the Attack stat, but lowers " +
                    "accuracy.");
        }
    }

    public static class Hydration extends Ability {
        public Hydration() {
            super(AbilityId.HYDRATION, "Hydration", "Heals status conditions if it's" +
                    " raining.");
        }
    }

    public static class HyperCutter extends Ability {
        public HyperCutter() {
            super(AbilityId.HYPER_CUTTER, "Hyper Cutter", "The Pokémon's proud of its " +
                    "powerful pincers. They prevent other Pokémon from lowering its Attack stat.");
        }
    }

    /*
    ****************** I ***************
    */


    public static class IceBody extends Ability {
        public IceBody() {
            super(AbilityId.ICE_BODY, "Ice Body", "The Pokémon gradually regains HP" +
                    " in a hailstorm.");
        }
    }

    public static class Illuminate extends Ability {
        public Illuminate() {
            super(AbilityId.ILLUMINATE, "Illuminate", "Raises the likelihood of meeting" +
                    " wild Pokémon by illuminating the surroundings.");
        }
    }

    public static class Illusion extends Ability {
        public Illusion() {
            super(AbilityId.ILLUSION, "Illusion", "Comes out disguised as the Pokémon" +
                    " in the party's last spot.");
        }
    }

    public static class Immunity extends Ability {
        public Immunity() {
            super(AbilityId.IMMUNITY, "Immunity", "The immune system of the Pokémon" +
                    " prevents it from getting poisoned.");
        }
    }

    public static class Imposter extends Ability {
        public Imposter() {
            super(AbilityId.IMPOSTER, "Imposter", "The Pokémon transforms itself into" +
                    " the Pokémon it's facing.");
        }
    }

    public static class Infiltrator extends Ability {
        public Infiltrator() {
            super(AbilityId.INFILTRATOR, "Infiltrator", "Passes through the opposing" +
                    " Pokémon's barrier, substitute, and the like and strikes.");
        }
    }

    public static class InnardsOut extends Ability {
        public InnardsOut() {
            super(AbilityId.INNARDS_OUT, "Innards Out", "Damages the attacker landing" +
                    " the finishing hit by the amount equal to its last HP.");
        }
    }

    public static class InnerFocus extends Ability {
        public InnerFocus() {
            super(AbilityId.INNER_FOCUS, "Inner Focus", "The Pokémon's intensely " +
                    "focused, and that protects the Pokémon from flinching.");
        }
    }

    public static class Insomnia extends Ability {
        public Insomnia() {
            super(AbilityId.INSOMNIA, "Insomnia", "The Pokémon is suffering from" +
                    " insomnia and cannot fall asleep.");
        }
    }

    public static class Intimidate extends Ability {
        public Intimidate() {
            super(AbilityId.INTIMIDATE, "Intimidate", "The Pokémon intimidates opposing" +
                    " Pokémon upon entering battle, lowering their Attack stat.");
        }
    }

    public static class IronBarbs extends Ability {
        public IronBarbs() {
            super(AbilityId.IRON_BARBS, "Iron Barbs", "Inflicts damage to the attacker" +
                    " on contact with iron barbs.");
        }
    }

    public static class IronFist extends Ability {
        public IronFist() {
            super(AbilityId.IRON_FIST, "Iron Fist", "Powers up punching moves.");
        }
    }

    /*
    ****************** J ***************
    */

    public static class Justified extends Ability {
        public Justified() {
            super(AbilityId.JUSTIFIED, "Justified", "Being hit by a Dark-type move" +
                    " boosts the Attack stat of the Pokémon, for justice.");
        }
    }

    /*
    ****************** K ***************
    */

    public static class KeenEye extends Ability {
        public KeenEye() {
            super(AbilityId.KEEN_EYE, "Keen Eye", "Keen eyes prevent other Pokémon" +
                    " from lowering this Pokémon's accuracy.");
        }
    }

    public static class Klutz extends Ability {
        public Klutz() {
            super(AbilityId.KLUTZ, "Klutz", "The Pokémon can't use any held items.");
        }
    }

    /*
    ****************** L ***************
    */

    public static class LeafGuard extends Ability {
        public LeafGuard() {
            super(AbilityId.LEAF_GUARD, "Leaf Guard", "Prevents status conditions in" +
                    " sunny weather.");
        }
    }

    public static class Levitate extends Ability {
        public Levitate() {
            super(AbilityId.LEVITATE, "Levitate", "By floating in the air, the Pokémon" +
                    " receives full immunity to all Ground-type moves.");
        }
    }

    public static class LightMetal extends Ability {
        public LightMetal() {
            super(AbilityId.LIGHT_METAL, "Light Metal", "Halves the Pokémon's weight.");
        }
    }

    public static class Lightningrod extends Ability {
        public Lightningrod() {
            super(AbilityId.LIGHTNINGROD, "Lightningrod", "The Pokémon draws in all" +
                    " Electric-type moves. Instead of being hit by Electric-type moves, it" +
                    " boosts its Sp. Atk.");
        }
    }

    public static class Limber extends Ability {
        public Limber() {
            super(AbilityId.LIMBER, "Limber", "Its limber body protects the Pokémon" +
                    " from paralysis.");
        }
    }

    public static class LiquidOoze extends Ability {
        public LiquidOoze() {
            super(AbilityId.LIQUID_OOZE, "Liquid Ooze", "Oozed liquid has strong " +
                    "stench, which damages attackers using any draining move.");
        }
    }

    public static class LiquidVoice extends Ability {
        public LiquidVoice() {
            super(AbilityId.LIQUID_VOICE, "Liquid Voice", "All sound-based moves" +
                    " become Water-type moves.");
        }
    }

    public static class LongReach extends Ability {
        public LongReach() {
            super(AbilityId.LONG_REACH, "Long Reach", "The Pokémon uses its moves" +
                    " without making contact with the target.");
        }
    }

    /*
    ****************** M ***************
    */


    public static class MagicBounce extends Ability {
        public MagicBounce() {
            super(AbilityId.MAGIC_BOUNCE, "Magic Bounce", "Reflects status moves," +
                    " instead of getting hit by them.");
        }
    }

    public static class MagicGuard extends Ability {
        public MagicGuard() {
            super(AbilityId.MAGIC_GUARD, "Magic Guard", "The Pokémon only takes damage" +
                    " from attacks.");
        }
    }

    public static class Magician extends Ability {
        public Magician() {
            super(AbilityId.MAGICIAN, "Magician", "The Pokémon steals the held item" +
                    " of a Pokémon it hits with a move.");
        }
    }

    public static class MagmaArmor extends Ability {
        public MagmaArmor() {
            super(AbilityId.MAGMA_ARMOR, "Magma Armor", "The Pokémon is covered with hot" +
                    " magma, which prevents the Pokémon from becoming frozen.");
        }
    }

    public static class MagnetPull extends Ability {
        public MagnetPull() {
            super(AbilityId.MAGNET_PULL, "Magnet Pull", "Prevents Steel-type Pokémon" +
                    " from escaping using its magnetic force.");
        }
    }

    public static class MarvelScale extends Ability {
        public MarvelScale() {
            super(AbilityId.MARVEL_SCALE, "Marvel Scale", "The Pokémon's marvelous " +
                    "scales boost the Defense stat if it has a status condition.");
        }
    }

    public static class MegaLauncher extends Ability {
        public MegaLauncher() {
            super(AbilityId.MEGA_LAUNCHER, "Mega Launcher", "Powers up aura and pulse" +
                    " moves.");
        }
    }

    public static class Merciless extends Ability {
        public Merciless() {
            super(AbilityId.MERCILESS, "Merciless", "The Pokémon's attacks become" +
                    " critical hits if the target is poisoned.");
        }
    }

    public static class Minus extends Ability {
        public Minus() {
            super(AbilityId.MINUS, "Minus", "Boosts the Sp. Atk stat of the Pokémon if" +
                    " an ally with the Plus or Minus Ability is also in battle.");
        }
    }

    public static class MistySurge extends Ability {
        public MistySurge() {
            super(AbilityId.MISTY_SURGE, "Misty Surge", "Turns the ground into Misty" +
                    " Terrain when the Pokémon enters a battle.");
        }
    }

    public static class MoldBreaker extends Ability {
        public MoldBreaker() {
            super(AbilityId.MOLD_BREAKER, "Mold Breaker", "Moves can be used on the" +
                    " target regardless of its Abilities.");
        }
    }

    public static class Moody extends Ability {
        public Moody() {
            super(AbilityId.MOODY, "Moody", "Raises one stat sharply and lowers another" +
                    " every turn.");
        }
    }

    public static class MotorDrive extends Ability {
        public MotorDrive() {
            super(AbilityId.MOTOR_DRIVE, "Motor Drive", "Boosts its Speed stat if hit by" +
                    " an Electric-type move, instead of taking damage.");
        }
    }

    public static class Moxie extends Ability {
        public Moxie() {
            super(AbilityId.MOXIE, "Moxie", "The Pokémon shows moxie, and that boosts" +
                    " the Attack stat after knocking out any Pokémon.");
        }
    }

    public static class Multiscale extends Ability {
        public Multiscale() {
            super(AbilityId.MULTISCALE, "Multiscale", "Reduces the amount of damage" +
                    " the Pokémon takes when its HP is full.");
        }
    }

    public static class Multitype extends Ability {
        public Multitype() {
            super(AbilityId.MULTITYPE, "Multitype", "Changes the Pokémon's type to" +
                    " match the Plate or Z-Crystal it holds.");
        }
    }

    public static class Mummy extends Ability {
        public Mummy() {
            super(AbilityId.MUMMY, "Mummy", "Contact with the Pokémon changes the" +
                    " attacker's Ability to Mummy.");
        }
    }

    /*
    ****************** N ***************
    */

    public static class NaturalCure extends Ability {
        public NaturalCure() {
            super(AbilityId.NATURAL_CURE, "Natural Cure", "All status conditions heal" +
                    " when the Pokémon switches out.");
        }
    }

    public static class NoGuard extends Ability {
        public NoGuard() {
            super(AbilityId.NO_GUARD, "No Guard", "The Pokémon employs no-guard tactics" +
                    " to ensure incoming and outgoing attacks always land.");
        }
    }

    public static class Normalize extends Ability {
        public Normalize() {
            super(AbilityId.NORMALIZE, "Normalize", "All the Pokémon's moves become " +
                    "Normal type. The power of those moves is boosted a little.");
        }
    }

    /*
    ****************** O ***************
    */

    public static class Oblivious extends Ability {
        public Oblivious() {
            super(AbilityId.OBLIVIOUS, "Oblivious", "The Pokémon is oblivious, and that" +
                    " keeps it from being infatuated or falling for taunts.");
        }
    }

    public static class Overcoat extends Ability {
        public Overcoat() {
            super(AbilityId.OVERCOAT, "Overcoat", "Protects the Pokémon from things" +
                    " like sand, hail, and powder.");
        }
    }

    public static class Overgrow extends Ability {
        public Overgrow() {
            super(AbilityId.OVERGROW, "Overgrow", "Powers up Grass-type moves when " +
                    "the Pokémon's HP is low.");
        }
    }

    public static class OwnTempo extends Ability {
        public OwnTempo() {
            super(AbilityId.OWN_TEMPO, "Own Tempo", "This Pokémon has its own tempo," +
                    " and that prevents it from becoming confused.");
        }
    }


    /*
    ****************** P ***************
    */

    public static class ParentalBond extends Ability {
        public ParentalBond() {
            super(AbilityId.PARENTAL_BOND, "Parental Bond", "Parent and child each " +
                    "attacks.");
        }
    }

    public static class Pickpocket extends Ability {
        public Pickpocket() {
            super(AbilityId.PICKPOCKET, "Pickpocket", "Steals an item from an attacker" +
                    " that made direct contact.");
        }
    }

    public static class Pickup extends Ability {
        public Pickup() {
            super(AbilityId.PICKUP, "Pickup", "The Pokémon may pick up the item an" +
                    " opposing Pokémon used during a battle. It may pick up items outside of" +
                    " battle, too.");
        }
    }

    public static class Pixilate extends Ability {
        public Pixilate() {
            super(AbilityId.PIXILATE, "Pixilate", "Normal-type moves become Fairy-type" +
                    " moves. The power of those moves is boosted a little.");
        }
    }

    public static class Plus extends Ability {
        public Plus() {
            super(AbilityId.PLUS, "Plus", "Boosts the Sp. Atk stat of the Pokémon if an" +
                    " ally with the Plus or Minus Ability is also in battle.");
        }
    }

    public static class PoisonHeal extends Ability {
        public PoisonHeal() {
            super(AbilityId.POISON_HEAL, "Poison Heal", "Restores HP if the Pokémon is" +
                    " poisoned, instead of losing HP.");
        }
    }

    public static class PoisonPoint extends Ability {
        public PoisonPoint() {
            super(AbilityId.POISON_POINT, "Poison Point", "Contact with the Pokémon" +
                    " may poison the attacker.");
        }
    }

    public static class PoisonTouch extends Ability {
        public PoisonTouch() {
            super(AbilityId.POISON_TOUCH, "Poison Touch", "May poison a target when" +
                    " the Pokémon makes contact.");
        }
    }

    public static class PowerOfAlchemy extends Ability {
        public PowerOfAlchemy() {
            super(AbilityId.POWER_OF_ALCHEMY, "Power of Alchemy", "The Pokémon copies" +
                    " the Ability of a defeated ally.");
        }
    }

    public static class Prankster extends Ability {
        public Prankster() {
            super(AbilityId.PRANKSTER, "Prankster", "Gives priority to a status move.");
        }
    }

    public static class Pressure extends Ability {
        public Pressure() {
            super(AbilityId.PRESSURE, "Pressure", "By putting pressure on the opposing" +
                    " Pokémon, it raises their PP usage.");
        }
    }

    public static class PrimordialSea extends Ability {
        public PrimordialSea() {
            super(AbilityId.PRIMORDIAL_SEA, "Primordial Sea", "The Pokémon changes the" +
                    " weather to nullify Fire-type attacks.");
        }
    }

    public static class PrismArmor extends Ability {
        public PrismArmor() {
            super(AbilityId.PRISM_ARMOR, "Prism Armor", "Reduces the power of" +
                    " supereffective attacks taken.");
        }
    }

    public static class Protean extends Ability {
        public Protean() {
            super(AbilityId.PROTEAN, "Protean", "Changes the Pokémon's type to the type" +
                    " of the move it's about to use.");
        }
    }

    public static class PsychicSurge extends Ability {
        public PsychicSurge() {
            super(AbilityId.PSYCHIC_SURGE, "Psychic Surge", "Turns the ground into" +
                    " Psychic Terrain when the Pokémon enters a battle.");
        }
    }

    public static class PurePower extends Ability {
        public PurePower() {
            super(AbilityId.PURE_POWER, "Pure Power", "Using its pure power, the" +
                    " Pokémon doubles its Attack stat.");
        }
    }

    /*
    ****************** Q ***************
    */

    public static class QueenlyMajesty extends Ability {
        public QueenlyMajesty() {
            super(AbilityId.QUEENLY_MAJESTY, "Queenly Majesty", "Its majesty pressures" +
                    " the opposing Pokémon, making it unable to attack using priority moves.");
        }
    }

    public static class QuickFeet extends Ability {
        public QuickFeet() {
            super(AbilityId.QUICK_FEET, "Quick Feet", "Boosts the Speed stat if the" +
                    " Pokémon has a status condition.");
        }
    }

    /*
    ****************** R ***************
    */

    public static class RainDish extends Ability {
        public RainDish() {
            super(AbilityId.RAIN_DISH, "Rain Dish", "The Pokémon gradually regains HP" +
                    " in rain.");
        }
    }

    public static class Rattled extends Ability {
        public Rattled() {
            super(AbilityId.RATTLED, "Rattled", "Dark-, Ghost-, and Bug-type moves" +
                    " scare the Pokémon and boost its Speed stat.");
        }
    }

    public static class Receiver extends Ability {
        public Receiver() {
            super(AbilityId.RECEIVER, "Receiver", "The Pokémon copies the Ability of" +
                    " a defeated ally.");
        }
    }

    public static class Reckless extends Ability {
        public Reckless() {
            super(AbilityId.RECKLESS, "Reckless", "Powers up moves that have recoil" +
                    " damage.");
        }
    }

    public static class Refrigerate extends Ability {
        public Refrigerate() {
            super(AbilityId.REFRIGERATE, "Refrigerate", "Normal-type moves become" +
                    " Ice-type moves. The power of those moves is boosted a little.");
        }
    }

    public static class Regenerator extends Ability {
        public Regenerator() {
            super(AbilityId.REGENERATOR, "Regenerator", "Restores a little HP when" +
                    " withdrawn from battle.");
        }
    }

    public static class Rivalry extends Ability {
        public Rivalry() {
            super(AbilityId.RIVALRY, "Rivalry", "Becomes competitive and deals more" +
                    " damage to Pokémon of the same gender, but deals less to Pokémon of the" +
                    " opposite gender.");
        }
    }

    public static class RKSSystem extends Ability {
        public RKSSystem() {
            super(AbilityId.RKS_SYSTEM, "RKS System", "Changes the Pokémon's type to" +
                    " match the memory disc it holds.");
        }
    }

    public static class RockHead extends Ability {
        public RockHead() {
            super(AbilityId.ROCK_HEAD, "Rock Head", "Protects the Pokémon from recoil" +
                    " damage.");
        }
    }

    public static class RoughSkin extends Ability {
        public RoughSkin() {
            super(AbilityId.ROUGH_SKIN, "Rough Skin", "This Pokémon inflicts damage" +
                    " with its rough skin to the attacker on contact.");
        }
    }

    public static class RunAway extends Ability {
        public RunAway() {
            super(AbilityId.RUN_AWAY, "Run Away", "Enables a sure getaway from wild" +
                    " Pokémon.");
        }
    }

    /*
    ****************** S ***************
    */

    public static class SandForce extends Ability {
        public SandForce() {
            super(AbilityId.SAND_FORCE, "Sand Force", "Boosts the power of Rock-," +
                    " Ground-, and Steel-type moves in a sandstorm.");
        }
    }

    public static class SandRush extends Ability {
        public SandRush() {
            super(AbilityId.SAND_RUSH, "Sand Rush", "Boosts the Pokémon's Speed stat in" +
                    " a sandstorm.");
        }
    }

    public static class SandStream extends Ability {
        public SandStream() {
            super(AbilityId.SAND_STREAM, "Sand Stream", "The Pokémon summons a" +
                    " sandstorm when it enters a battle.");
        }
    }

    public static class SandVeil extends Ability {
        public SandVeil() {
            super(AbilityId.SAND_VEIL, "Sand Veil", "Boosts the Pokémon's evasion in" +
                    " a sandstorm.");
        }
    }

    public static class SapSipper extends Ability {
        public SapSipper() {
            super(AbilityId.SAP_SIPPER, "Sap Sipper", "Boosts the Attack stat if hit by" +
                    " a Grass-type move, instead of taking damage.");
        }
    }

    public static class Schooling extends Ability {
        public Schooling() {
            super(AbilityId.SCHOOLING, "Schooling", "When it has a lot of HP, the Pokémon" +
                    " forms a powerful school. It stops schooling when its HP is low.");
        }
    }

    public static class Scrappy extends Ability {
        public Scrappy() {
            super(AbilityId.SCRAPPY, "Scrappy", "The Pokémon can hit Ghost-type Pokémon" +
                    " with Normal- and Fighting-type moves.");
        }
    }

    public static class SereneGrace extends Ability {
        public SereneGrace() {
            super(AbilityId.SERENE_GRACE, "Serene Grace", "Boosts the likelihood of" +
                    " additional effects occurring when attacking.");
        }
    }

    public static class ShadowShield extends Ability {
        public ShadowShield() {
            super(AbilityId.SHADOW_SHIELD, "Shadow Shield", "Reduces the amount of" +
                    " damage the Pokémon takes while its HP is full.");
        }
    }

    public static class ShadowTag extends Ability {
        public ShadowTag() {
            super(AbilityId.SHADOW_TAG, "Shadow Tag", "This Pokémon steps on the" +
                    " opposing Pokémon's shadow to prevent it from escaping.");
        }
    }

    public static class ShedSkin extends Ability {
        public ShedSkin() {
            super(AbilityId.SHED_SKIN, "Shed Skin", "The Pokémon may heal its own status" +
                    " conditions by shedding its skin.");
        }
    }

    public static class SheerForce extends Ability {
        public SheerForce() {
            super(AbilityId.SHEER_FORCE, "Sheer Force", "Removes additional effects to" +
                    " increase the power of moves when attacking.");
        }
    }

    public static class ShellArmor extends Ability {
        public ShellArmor() {
            super(AbilityId.SHELL_ARMOR, "Shell Armor", "A hard shell protects the" +
                    " Pokémon from critical hits.");
        }
    }

    public static class ShieldDust extends Ability {
        public ShieldDust() {
            super(AbilityId.SHIELD_DUST, "Shield Dust", "This Pokémon's dust blocks" +
                    " the additional effects of attacks taken.");
        }
    }

    public static class ShieldsDown extends Ability {
        public ShieldsDown() {
            super(AbilityId.SHIELDS_DOWN, "Shields Down", "When its HP becomes half or" +
                    " less, the Pokémon's shell breaks and it becomes aggressive.");
        }
    }

    public static class Simple extends Ability {
        public Simple() {
            super(AbilityId.SIMPLE, "Simple", "The stat changes the Pokémon receives" +
                    " are doubled.");
        }
    }

    public static class SkillLink extends Ability {
        public SkillLink() {
            super(AbilityId.SKILL_LINK, "Skill Link", "Maximizes the number of times" +
                    " multi-strike moves hit.");
        }
    }

    public static class SlowStart extends Ability {
        public SlowStart() {
            super(AbilityId.SLOW_START, "Slow Start", "For five turns, the Pokémon's" +
                    " Attack and Speed stats are halved.");
        }
    }

    public static class SlushRush extends Ability {
        public SlushRush() {
            super(AbilityId.SLUSH_RUSH, "Slush Rush", "Boosts the Pokémon's Speed stat" +
                    " in a hailstorm.");
        }
    }

    public static class Sniper extends Ability {
        public Sniper() {
            super(AbilityId.SNIPER, "Sniper", "Powers up moves if they become critical" +
                    " hits when attacking.");
        }
    }

    public static class SnowCloak extends Ability {
        public SnowCloak() {
            super(AbilityId.SNOW_CLOAK, "Snow Cloak", "Boosts evasion in a hailstorm.");
        }
    }

    public static class SnowWarning extends Ability {
        public SnowWarning() {
            super(AbilityId.SNOW_WARNING, "Snow Warning", "The Pokémon summons a " +
                    "hailstorm when it enters a battle.");
        }
    }

    public static class SolarPower extends Ability {
        public SolarPower() {
            super(AbilityId.SOLAR_POWER, "Solar Power", "Boosts the Sp. Atk stat in" +
                    " sunny weather, but HP decreases every turn.");
        }
    }

    public static class SolidRock extends Ability {
        public SolidRock() {
            super(AbilityId.SOLID_ROCK, "Solid Rock", "Reduces the power of" +
                    " supereffective attacks taken.");
        }
    }

    public static class SoulHeart extends Ability {
        public SoulHeart() {
            super(AbilityId.SOUL_HEART, "Soul-Heart", "Boosts its Sp. Atk stat every" +
                    " time a Pokémon faints.");
        }
    }

    public static class Soundproof extends Ability {
        public Soundproof() {
            super(AbilityId.SOUNDPROOF, "Soundproof", "Soundproofing of the Pokémon" +
                    " itself gives full immunity to all sound-based moves.");
        }
    }

    public static class SpeedBoost extends Ability {
        public SpeedBoost() {
            super(AbilityId.SPEED_BOOST, "Speed Boost", "Its Speed stat is boosted" +
                    " every turn.");
        }
    }

    public static class Stakeout extends Ability {
        public Stakeout() {
            super(AbilityId.STAKEOUT, "Stakeout", "Doubles the damage dealt to the" +
                    " target's replacement if the target switches out.");
        }
    }

    public static class Stall extends Ability {
        public Stall() {
            super(AbilityId.STALL, "Stall", "The Pokémon moves after all other Pokémon do.");
        }
    }

    public static class Stamina extends Ability {
        public Stamina() {
            super(AbilityId.STAMINA, "Stamina", "Boosts the Defense stat when hit by" +
                    " an attack.");
        }
    }

    public static class StanceChange extends Ability {
        public StanceChange() {
            super(AbilityId.STANCE_CHANGE, "Stance Change", "The Pokémon changes its" +
                    " form to Blade Forme when it uses an attack move, and changes to Shield" +
                    " Forme when it uses King's Shield.");
        }
    }

    public static class Static extends Ability {
        public Static() {
            super(AbilityId.STATIC, "Static", "The Pokémon is charged with static" +
                    " electricity, so contact with it may cause paralysis.");
        }
    }

    public static class Steadfast extends Ability {
        public Steadfast() {
            super(AbilityId.STEADFAST, "Steadfast", "The Pokémon's determination boosts" +
                    " the Speed stat each time the Pokémon flinches.");
        }
    }

    public static class Steelworker extends Ability {
        public Steelworker() {
            super(AbilityId.STEELWORKER, "Steelworker", "Powers up Steel-type moves.");
        }
    }

    public static class Stench extends Ability {
        public Stench() {
            super(AbilityId.STENCH, "Stench", "By releasing stench when attacking," +
                    " this Pokémon may cause the target to flinch.");
        }
    }

    public static class StickyHold extends Ability {
        public StickyHold() {
            super(AbilityId.STICKY_HOLD, "Sticky Hold", "Items held by the Pokémon are" +
                    " stuck fast and cannot be removed by other Pokémon.");
        }
    }

    public static class StormDrain extends Ability {
        public StormDrain() {
            super(AbilityId.STORM_DRAIN, "Storm Drain", "Draws in all Water-type moves." +
                    " Instead of being hit by Water-type moves, it boosts its Sp. Atk.");
        }
    }

    public static class StrongJaw extends Ability {
        public StrongJaw() {
            super(AbilityId.STRONG_JAW, "Strong Jaw", "The Pokémon's strong jaw boosts" +
                    " the power of its biting moves.");
        }
    }

    public static class Sturdy extends Ability {
        public Sturdy() {
            super(AbilityId.STURDY, "Sturdy", "It cannot be knocked out with one hit." +
                    " One-hit KO moves cannot knock it out, either.");
        }
    }

    public static class SuctionCups extends Ability {
        public SuctionCups() {
            super(AbilityId.SUCTION_CUPS, "Suction Cups", "This Pokémon uses suction" +
                    " cups to stay in one spot to negate all moves and items that force" +
                    " switching out.");
        }
    }

    public static class SuperLuck extends Ability {
        public SuperLuck() {
            super(AbilityId.SUPER_LUCK, "Super Luck", "The Pokémon is so lucky that the" +
                    " critical-hit ratios of its moves are boosted.");
        }
    }

    public static class SurgeSurfer extends Ability {
        public SurgeSurfer() {
            super(AbilityId.SURGE_SURFER, "Surge Surfer", "Doubles the Pokémon's Speed" +
                    " stat on Electric Terrain.");
        }
    }

    public static class Swarm extends Ability {
        public Swarm() {
            super(AbilityId.SWARM, "Swarm", "Powers up Bug-type moves when the Pokémon's" +
                    " HP is low.");
        }
    }

    public static class SweetVeil extends Ability {
        public SweetVeil() {
            super(AbilityId.SWEET_VEIL, "Sweet Veil", "Prevents itself and ally Pokémon" +
                    " from falling asleep.");
        }
    }

    public static class SwiftSwim extends Ability {
        public SwiftSwim() {
            super(AbilityId.SWIFT_SWIM, "Swift Swim", "Boosts the Pokémon's Speed stat" +
                    " in rain.");
        }
    }

    public static class Symbiosis extends Ability {
        public Symbiosis() {
            super(AbilityId.SYMBIOSIS, "Symbiosis", "The Pokémon passes its item to an" +
                    " ally that has used up an item.");
        }
    }

    public static class Synchronize extends Ability {
        public Synchronize() {
            super(AbilityId.SYNCHRONIZE, "Syncrhonize", "The attacker will receive the" +
                    " same status condition if it inflicts a burn, poison, or paralysis" +
                    " to the Pokémon.");
        }
    }


    /*
    ****************** T ***************
    */

    public static class TangledFeet extends Ability {
        public TangledFeet() {
            super(AbilityId.TANGLED_FEET, "Tangled Feet", "Raises evasion if the Pokémon" +
                    " is confused.");
        }
    }

    public static class TanglingHair extends Ability {
        public TanglingHair() {
            super(AbilityId.TANGLING_HAIR, "Tangling Hair", "Contact with the" +
                    " Pokémon lowers the attacker's Speed stat.");
        }
    }

    public static class Technician extends Ability {
        public Technician() {
            super(AbilityId.TECHNICIAN, "Technician", "Powers up the Pokémon's weaker" +
                    " moves.");
        }
    }

    public static class Telepathy extends Ability {
        public Telepathy() {
            super(AbilityId.TELEPATHY, "Telepathy", "Anticipates an ally's attack and" +
                    " dodges it.");
        }
    }

    public static class Teravolt extends Ability {
        public Teravolt() {
            super(AbilityId.TERAVOLT, "Teravolt", "Moves can be used on the target" +
                    " regardless of its Abilities.");
        }
    }


    public static class ThickFat extends Ability {
        public ThickFat() {
            super(AbilityId.THICK_FAT, "Thick Fat", "The Pokémon is protected by a layer" +
                    " of thick fat, which halves the damage taken from Fire- and Ice-type moves.");
        }
    }

    public static class TintedLens extends Ability {
        public TintedLens() {
            super(AbilityId.TINTED_LENS, "Tinted Lens", "The Pokémon can use not very" +
                    " effective moves to deal regular damage.");
        }
    }

    public static class Torrent extends Ability {
        public Torrent() {
            super(AbilityId.TORRENT, "Torrent", "Powers up Water-type moves when the" +
                    " Pokémon's HP is low.");
        }
    }

    public static class ToughClaws extends Ability {
        public ToughClaws() {
            super(AbilityId.TOUGH_CLAWS, "Tough Claws", "Powers up moves that make direct" +
                    " contact.");
        }
    }

    public static class ToxicBoost extends Ability {
        public ToxicBoost() {
            super(AbilityId.TOXIC_BOOST, "Toxic Boost", "Powers up physical attacks when" +
                    " the Pokémon is poisoned.");
        }
    }

    public static class Trace extends Ability {
        public Trace() {
            super(AbilityId.TRACE, "Trace", "PWhen it enters a battle, the Pokémon" +
                    " copies an opposing Pokémon's Ability.");
        }
    }

    public static class Triage extends Ability {
        public Triage() {
            super(AbilityId.TRIAGE, "Triage", "Healing moves have +3 Priority when used" +
                    " by this Pokémon.");
        }
    }

    public static class Truant extends Ability {
        public Truant() {
            super(AbilityId.TRUANT, "Truant", "The Pokémon can't use a move the following" +
                    " turn if it uses one.");
        }
    }

    public static class Turboblaze extends Ability {
        public Turboblaze() {
            super(AbilityId.TURBOBLAZE, "Turboblaze", "Moves can be used on the target" +
                    " regardless of its Abilities.");
        }
    }


    /*
    ****************** U ***************
    */

    public static class Unaware extends Ability {
        public Unaware() {
            super(AbilityId.UNAWARE, "Unaware", "When attacking, the Pokémon ignores" +
                    " the target Pokémon's stat changes.");
        }
    }

    public static class Unburden extends Ability {
        public Unburden() {
            super(AbilityId.UNBURDEN, "Unburden", "Boosts the Speed stat if the " +
                    "Pokémon's held item is used or lost.");
        }
    }

    public static class Unnerve extends Ability {
        public Unnerve() {
            super(AbilityId.UNNERVE, "Unnerve", "Unnerves opposing Pokémon and makes" +
                    " them unable to eat Berries.");
        }
    }

    /*
    ****************** V ***************
    */

    public static class VictoryStar extends Ability {
        public VictoryStar() {
            super(AbilityId.VICTORY_STAR, "Victory Star", "Boosts the accuracy of its" +
                    " allies and itself.");
        }
    }

    public static class VitalSpirit extends Ability {
        public VitalSpirit() {
            super(AbilityId.VITAL_SPIRIT, "Vital Spirit", "The Pokémon is full of " +
                    "vitality, and that prevents it from falling asleep.");
        }
    }

    public static class VoltAbsorb extends Ability {
        public VoltAbsorb() {
            super(AbilityId.VOLT_ABSORB, "Volt Absorb", "Restores HP if hit by an" +
                    " Electric-type move, instead of taking damage.");
        }
    }


    /*
    ****************** W ***************
    */

    public static class WaterAbsorb extends Ability {
        public WaterAbsorb() {
            super(AbilityId.WATER_ABSORB, "Water Absorb", "Restores HP if hit by a" +
                    " Water-type move, instead of taking damage.");
        }
    }

    public static class WaterBubble extends Ability {
        public WaterBubble() {
            super(AbilityId.WATER_BUBBLE, "Water Bubble", "Lowers the power of Fire-type" +
                    " moves done to the Pokémon and prevents the Pokémon from getting a burn.");
        }
    }

    public static class WaterCompaction extends Ability {
        public WaterCompaction() {
            super(AbilityId.WATER_COMPACTION, "Water Compaction", "Boosts the Pokémon's" +
                    " Defense stat sharply when hit by a Water-type move.");
        }
    }

    public static class WaterVeil extends Ability {
        public WaterVeil() {
            super(AbilityId.WATER_VEIL, "Water Veil", "The Pokémon is covered with a" +
                    " water veil, which prevents the Pokémon from getting a burn.");
        }
    }

    public static class WeakArmor extends Ability {
        public WeakArmor() {
            super(AbilityId.WEAK_ARMOR, "Weak Armor", "Physical attacks to the Pokémon" +
                    " lower its Defense stat but sharply raise its Speed stat.");
        }
    }

    public static class WhiteSmoke extends Ability {
        public WhiteSmoke() {
            super(AbilityId.WHITE_SMOKE, "White Smoke", "The Pokémon is protected by its" +
                    " white smoke, which prevents other Pokémon from lowering its stats.");
        }
    }

    public static class WimpOut extends Ability {
        public WimpOut() {
            super(AbilityId.WIMP_OUT, "Wimp Out", "The Pokémon cowardly switches out" +
                    " when its HP becomes half or less.");
        }
    }

    public static class WonderGuard extends Ability {
        public WonderGuard() {
            super(AbilityId.WONDER_GUARD, "Wonder Guard", "Its mysterious power only " +
                    "lets supereffective moves hit the Pokémon.");
        }
    }

    public static class WonderSkin extends Ability {
        public WonderSkin() {
            super(AbilityId.WONDER_SKIN, "Wonder Skin", "Makes status moves more likely" +
                    " to miss.");
        }
    }

    /*
    ****************** Z ***************
    */

    public static class ZenMode extends Ability {
        public ZenMode() {
            super(AbilityId.ZEN_MODE, "Zen Mode", "Changes the Pokémon's shape when HP" +
                    " is half or less.");
        }
    }

    public static class None extends Ability {
        public None() {
            super(AbilityId.NONE, "No Ability", "No ability on this Pokemon.");
        }
    }



}
