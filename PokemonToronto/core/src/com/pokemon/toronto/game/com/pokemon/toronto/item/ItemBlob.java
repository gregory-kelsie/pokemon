package com.pokemon.toronto.game.com.pokemon.toronto.item;

import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillDescription;

/**
 * Created by Gregory on 11/6/2017.
 */

public class ItemBlob {
    protected String name;
    protected String description;
    protected ItemId id;
    public ItemBlob(ItemId id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public ItemId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    /**
     * *******************************************************************************************
     *                                      POKEBALLS
     * *******************************************************************************************
     */
    public static class PokeballBlob extends ItemBlob {
        public PokeballBlob() {
            super(ItemId.POKEBALL, "Pokeball", "A device for catching wild Pokemon. " +
                    "It’s thrown like a ball at a Pokemon, comfortably encapsulating" +
                    " its target.");
        }
    }

    /**
     * *******************************************************************************************
     *                                          TMS
     * *******************************************************************************************
     */

    public static class TM01Blob extends ItemBlob {
        public TM01Blob () {
            super(ItemId.TM01, "No. 01 Work Up", SkillDescription.WORK_UP);
        }
    }

    public static class TM02Blob extends ItemBlob {
        public TM02Blob () {
            super(ItemId.TM02, "No. 02 Dragon Claw", SkillDescription.DRAGON_CLAW);
        }
    }

    public static class TM03Blob extends ItemBlob {
        public TM03Blob () {
            super(ItemId.TM03, "No. 03 Psyshock", SkillDescription.PSYSHOCK);
        }
    }

    public static class TM04Blob extends ItemBlob {
        public TM04Blob () {
            super(ItemId.TM04, "No. 04 Calm Mind", SkillDescription.CALM_MIND);
        }
    }

    public static class TM07Blob extends ItemBlob {
        public TM07Blob () {
            super(ItemId.TM07, "No. 07 Hail", SkillDescription.HAIL);
        }
    }

    public static class TM08Blob extends ItemBlob {
        public TM08Blob () {
            super(ItemId.TM08, "No. 08 Bulk Up", SkillDescription.BULK_UP);
        }
    }

    public static class TM09Blob extends ItemBlob {
        public TM09Blob () {
            super(ItemId.TM09, "No. 09 Venoshock", SkillDescription.VENOSHOCK);
        }
    }

    public static class TM10Blob extends ItemBlob {
        public TM10Blob () {
            super(ItemId.TM10, "No. 10 Hidden Power", SkillDescription.HIDDEN_POWER);
        }
    }

    public static class TM11Blob extends ItemBlob {
        public TM11Blob () {
            super(ItemId.TM11, "No. 11 Sunny Day", SkillDescription.SUNNY_DAY);
        }
    }

    public static class TM13Blob extends ItemBlob {
        public TM13Blob () {
            super(ItemId.TM13, "No. 13 Ice Beam", SkillDescription.ICE_BEAM);
        }
    }

    public static class TM14Blob extends ItemBlob {
        public TM14Blob () {
            super(ItemId.TM14, "No. 14 Blizzard", SkillDescription.BLIZZARD);
        }
    }

    public static class TM15Blob extends ItemBlob {
        public TM15Blob () {
            super(ItemId.TM15, "No. 15 Hyper Beam", SkillDescription.HYPER_BEAM);
        }
    }

    public static class TM16Blob extends ItemBlob {
        public TM16Blob () {
            super(ItemId.TM16, "No. 16 Light Screen", SkillDescription.LIGHT_SCREEN);
        }
    }

    public static class TM18Blob extends ItemBlob {
        public TM18Blob () {
            super(ItemId.TM18, "No. 18 Rain Dance", SkillDescription.RAIN_DANCE);
        }
    }

    public static class TM19Blob extends ItemBlob {
        public TM19Blob () {
            super(ItemId.TM19, "No. 19 Roost", SkillDescription.ROOST);
        }
    }

    public static class TM20Blob extends ItemBlob {
        public TM20Blob () {
            super(ItemId.TM20, "No. 20 Safeguard", SkillDescription.SAFEGUARD);
        }
    }

    public static class TM22Blob extends ItemBlob {
        public TM22Blob () {
            super(ItemId.TM22, "No. 22 Solar Beam", SkillDescription.SOLAR_BEAM);
        }
    }

    public static class TM24Blob extends ItemBlob {
        public TM24Blob () {
            super(ItemId.TM24, "No. 24 Thunderbolt", SkillDescription.THUNDERBOLT);
        }
    }

    public static class TM25Blob extends ItemBlob {
        public TM25Blob () {
            super(ItemId.TM25, "No. 25 Thunder", SkillDescription.THUNDER);
        }
    }

    public static class TM26Blob extends ItemBlob {
        public TM26Blob () {
            super(ItemId.TM26, "No. 26 Earthquake", SkillDescription.EARTHQUAKE);
        }
    }

    public static class TM28Blob extends ItemBlob {
        public TM28Blob () {
            super(ItemId.TM28, "No. 28 Leech Life", SkillDescription.leechLife);
        }
    }

    public static class TM29Blob extends ItemBlob {
        public TM29Blob () {
            super(ItemId.TM29, "No. 29 Psychic", SkillDescription.PSYCHIC);
        }
    }

    public static class TM30Blob extends ItemBlob {
        public TM30Blob () {
            super(ItemId.TM30, "No. 30 Shadow Ball", SkillDescription.SHADOW_BALL);
        }
    }

    public static class TM31Blob extends ItemBlob {
        public TM31Blob () {
            super(ItemId.TM31, "No. 31 Brick Break", SkillDescription.BRICK_BREAK);
        }
    }

    public static class TM32Blob extends ItemBlob {
        public TM32Blob () {
            super(ItemId.TM32, "No. 32 Double Team", SkillDescription.DOUBLE_TEAM);
        }
    }

    public static class TM33Blob extends ItemBlob {
        public TM33Blob () {
            super(ItemId.TM33, "No. 33 Reflect", SkillDescription.REFLECT);
        }
    }

    public static class TM34Blob extends ItemBlob {
        public TM34Blob () {
            super(ItemId.TM34, "No. 34 Sludge Wave", SkillDescription.SLUDGE_WAVE);
        }
    }

    public static class TM35Blob extends ItemBlob {
        public TM35Blob () {
            super(ItemId.TM35, "No. 35 Flamethrower", SkillDescription.FLAMETHROWER);
        }
    }

    public static class TM36Blob extends ItemBlob {
        public TM36Blob () {
            super(ItemId.TM36, "No. 36 Sludge Bomb", SkillDescription.SLUDGE_BOMB);
        }
    }

    public static class TM37Blob extends ItemBlob {
        public TM37Blob () {
            super(ItemId.TM37, "No. 37 Sandstorm", SkillDescription.SANDSTORM);
        }
    }

    public static class TM38Blob extends ItemBlob {
        public TM38Blob () {
            super(ItemId.TM38, "No. 38 Fire Blast", SkillDescription.FIRE_BLAST);
        }
    }

    public static class TM39Blob extends ItemBlob {
        public TM39Blob () {
            super(ItemId.TM39, "No. 39 Rock Tomb", SkillDescription.ROCK_TOMB);
        }
    }

    public static class TM40Blob extends ItemBlob {
        public TM40Blob () {
            super(ItemId.TM40, "No. 40 Aerial Ace", SkillDescription.AERIAL_ACE);
        }
    }

    public static class TM42Blob extends ItemBlob {
        public TM42Blob () {
            super(ItemId.TM42, "No. 42 Facade", SkillDescription.FACADE);
        }
    }

    public static class TM43Blob extends ItemBlob {
        public TM43Blob () {
            super(ItemId.TM43, "No. 43 Flame Charge", SkillDescription.FLAME_CHARGE);
        }
    }

    public static class TM44Blob extends ItemBlob {
        public TM44Blob () {
            super(ItemId.TM44, "No. 44 Rest", SkillDescription.REST);
        }
    }

    public static class TM46Blob extends ItemBlob {
        public TM46Blob () {
            super(ItemId.TM46, "No. 46 Thief", SkillDescription.THIEF);
        }
    }

    public static class TM47Blob extends ItemBlob {
        public TM47Blob () {
            super(ItemId.TM47, "No. 47 Low Sweep", SkillDescription.LOW_SWEEP);
        }
    }

    public static class TM48Blob extends ItemBlob {
        public TM48Blob () {
            super(ItemId.TM48, "No. 48 Round", SkillDescription.ROUND);
        }
    }

    public static class TM49Blob extends ItemBlob {
        public TM49Blob () {
            super(ItemId.TM49, "No. 48 Echoed Voice", SkillDescription.ECHOED_VOICE);
        }
    }

    public static class TM50Blob extends ItemBlob {
        public TM50Blob () {
            super(ItemId.TM50, "No. 50 Overheat", SkillDescription.OVERHEAT);
        }
    }

    public static class TM51Blob extends ItemBlob {
        public TM51Blob () {
            super(ItemId.TM51, "No. 51 Steel Wing", SkillDescription.STEEL_WING);
        }
    }

    public static class TM52Blob extends ItemBlob {
        public TM52Blob () {
            super(ItemId.TM52, "No. 52 Focus Blast", SkillDescription.FOCUS_BLAST);
        }
    }

    public static class TM53Blob extends ItemBlob {
        public TM53Blob () {
            super(ItemId.TM53, "No. 53 Energy Ball", SkillDescription.ENERGY_BALL);
        }
    }

    public static class TM54Blob extends ItemBlob {
        public TM54Blob () {
            super(ItemId.TM54, "No. 54 False Swipe", SkillDescription.FALSE_SWIPE);
        }
    }

    public static class TM55Blob extends ItemBlob {
        public TM55Blob () {
            super(ItemId.TM55, "No. 55 Scald", SkillDescription.SCALD);
        }
    }

    public static class TM57Blob extends ItemBlob {
        public TM57Blob () {
            super(ItemId.TM57, "No. 57 Charge Beam", SkillDescription.CHARGE_BEAM);
        }
    }

    public static class TM58Blob extends ItemBlob {
        public TM58Blob () {
            super(ItemId.TM58, "No. 58 Sky Drop", SkillDescription.SKY_DROP);
        }
    }

    public static class TM59Blob extends ItemBlob {
        public TM59Blob () {
            super(ItemId.TM59, "No. 59 Brutal Swing", SkillDescription.BRUTAL_SWING);
        }
    }

    public static class TM61Blob extends ItemBlob {
        public TM61Blob () {
            super(ItemId.TM61, "No. 61 Will-O-Wisp", SkillDescription.WILL_O_WISP);
        }
    }

    public static class TM62Blob extends ItemBlob {
        public TM62Blob () {
            super(ItemId.TM62, "No. 62 Acrobatics", SkillDescription.ACROBATICS);
        }
    }

    public static class TM64Blob extends ItemBlob {
        public TM64Blob () {
            super(ItemId.TM64, "No. 64 Explosion", SkillDescription.EXPLOSION);
        }
    }

    public static class TM65Blob extends ItemBlob {
        public TM65Blob () {
            super(ItemId.TM65, "No. 65 Shadow Claw", SkillDescription.SHADOW_CLAW);
        }
    }

    public static class TM66Blob extends ItemBlob {
        public TM66Blob () {
            super(ItemId.TM66, "No. 66 Payback", SkillDescription.PAYBACK);
        }
    }

    public static class TM67Blob extends ItemBlob {
        public TM67Blob () {
            super(ItemId.TM67, "No. 67 Smart Strike", SkillDescription.SMART_STRIKE);
        }
    }

    public static class TM68Blob extends ItemBlob {
        public TM68Blob () {
            super(ItemId.TM68, "No. 68 Giga Impact", SkillDescription.GIGA_IMPACT);
        }
    }

    public static class TM69Blob extends ItemBlob {
        public TM69Blob () {
            super(ItemId.TM69, "No. 69 Rock Polish", SkillDescription.ROCK_POLISH);
        }
    }

    public static class TM71Blob extends ItemBlob {
        public TM71Blob () {
            super(ItemId.TM71, "No. 71 Stone Edge", SkillDescription.STONE_EDGE);
        }
    }

    public static class TM73Blob extends ItemBlob {
        public TM73Blob () {
            super(ItemId.TM73, "No. 73 Thunder Wave", SkillDescription.THUNDER_WAVE);
        }
    }

    public static class TM74Blob extends ItemBlob {
        public TM74Blob () {
            super(ItemId.TM74, "No. 74 Gyro Ball", SkillDescription.GYRO_BALL);
        }
    }

    public static class TM75Blob extends ItemBlob {
        public TM75Blob () {
            super(ItemId.TM75, "No. 75 Swords Dance", SkillDescription.SWORDS_DANCE);
        }
    }

    public static class TM76Blob extends ItemBlob {
        public TM76Blob () {
            super(ItemId.TM76, "No. 76 Fly", SkillDescription.FLY);
        }
    }

    public static class TM77Blob extends ItemBlob {
        public TM77Blob () {
            super(ItemId.TM77, "No. 77 Psych Up", SkillDescription.PSYCH_UP);
        }
    }

    public static class TM78Blob extends ItemBlob {
        public TM78Blob () {
            super(ItemId.TM78, "No. 78 Bulldoze", SkillDescription.BULLDOZE);
        }
    }

    public static class TM79Blob extends ItemBlob {
        public TM79Blob () {
            super(ItemId.TM79, "No. 79 Frost Breath", SkillDescription.FROST_BREATH);
        }
    }

    public static class TM80Blob extends ItemBlob {
        public TM80Blob () {
            super(ItemId.TM80, "No. 80 Rock Slide", SkillDescription.ROCK_SLIDE);
        }
    }

    public static class TM81Blob extends ItemBlob {
        public TM81Blob () {
            super(ItemId.TM81, "No. 81 X-Scissor", SkillDescription.xScissor);
        }
    }

    public static class TM83Blob extends ItemBlob {
        public TM83Blob () {
            super(ItemId.TM83, "No. 83 Infestation", SkillDescription.infestation);
        }
    }

    public static class TM84Blob extends ItemBlob {
        public TM84Blob () {
            super(ItemId.TM84, "No. 84 Poison Jab", SkillDescription.POISON_JAB);
        }
    }

    public static class TM85Blob extends ItemBlob {
        public TM85Blob () {
            super(ItemId.TM85, "No. 85 Dream Eater", SkillDescription.DREAM_EATER);
        }
    }

    public static class TM86Blob extends ItemBlob {
        public TM86Blob () {
            super(ItemId.TM86, "No. 86 Grass Knot", SkillDescription.GRASS_KNOT);
        }
    }

    public static class TM87Blob extends ItemBlob {
        public TM87Blob () {
            super(ItemId.TM87, "No. 87 Swagger", SkillDescription.SWAGGER);
        }
    }

    public static class TM91Blob extends ItemBlob {
        public TM91Blob () {
            super(ItemId.TM91, "No. 91 Flash Cannon", SkillDescription.FLASH_CANNON);
        }
    }

    public static class TM92Blob extends ItemBlob {
        public TM92Blob () {
            super(ItemId.TM92, "No. 92 Trick Room", SkillDescription.TRICK_ROOM);
        }
    }

    public static class TM93Blob extends ItemBlob {
        public TM93Blob () {
            super(ItemId.TM93, "No. 93 Wild Charge", SkillDescription.WILD_CHARGE);
        }
    }

    public static class TM94Blob extends ItemBlob {
        public TM94Blob () {
            super(ItemId.TM94, "No. 94 Surf", SkillDescription.SURF);
        }
    }

    public static class TM95Blob extends ItemBlob {
        public TM95Blob () {
            super(ItemId.TM95, "No. 95 Snarl", SkillDescription.SNARL);
        }
    }

    public static class TM97Blob extends ItemBlob {
        public TM97Blob () {
            super(ItemId.TM97, "No. 97 Dark Pulse", SkillDescription.DARK_PULSE);
        }
    }

    public static class TM98Blob extends ItemBlob {
        public TM98Blob () {
            super(ItemId.TM98, "No. 98 Waterfall", SkillDescription.WATERFALL);
        }
    }

    public static class TM99Blob extends ItemBlob {
        public TM99Blob () {
            super(ItemId.TM99, "No. 99 Dazzling Gleam", SkillDescription.DAZZLING_GLEAM);
        }
    }

    /**
     * *******************************************************************************************
     *                                      STONES
     * *******************************************************************************************
     */

    public static class DuskStoneBlob extends ItemBlob {
        public DuskStoneBlob() {
            super(ItemId.DUSK_STONE, "Dusk Stone", "A peculiar stone that can make certain " +
                    "species of Pokemon evolve. It holds shadows as dark as can be.");
        }
    }

    public static class FireStoneBlob extends ItemBlob {
        public FireStoneBlob() {
            super(ItemId.FIRE_STONE, "Fire Stone", "A peculiar stone that can make certain " +
                    "species of Pokémon evolve. The stone has a fiery orange heart.");
        }
    }

    public static class LeafStoneBlob extends ItemBlob {
        public LeafStoneBlob() {
            super(ItemId.LEAF_STONE, "Leaf Stone", "A peculiar stone that can make certain " +
                    "species of Pokémon evolve. It has an unmistakable leaf pattern.");
        }
    }

    public static class ShinyStoneBlob extends ItemBlob {
        public ShinyStoneBlob() {
            super(ItemId.SHINY_STONE, "Shiny Stone", "A peculiar stone that can make certain " +
                    "species of Pokemon evolve. It shines with a dazzling light.");
        }
    }

    public static class SunStoneBlob extends ItemBlob {
        public SunStoneBlob() {
            super(ItemId.SUN_STONE, "Sun Stone", "A peculiar stone that can make certain " +
                    "species of Pokémon evolve. It burns as red as the evening sun.");
        }
    }

    public static class ThunderStoneBlob extends ItemBlob {
        public ThunderStoneBlob() {
            super(ItemId.THUNDER_STONE, "Thunder Stone", "A peculiar stone that can make certain " +
                    "species of Pokémon evolve. It has a distinct thunderbolt pattern.");
        }
    }

    public static class WaterStoneBlob extends ItemBlob {
        public WaterStoneBlob() {
            super(ItemId.WATER_STONE, "Water Stone", "A peculiar stone that can make certain " +
                    "species of Pokémon evolve. It is the blue of a pool of clear water.");
        }
    }

    public static class MoonStoneBlob extends ItemBlob {
        public MoonStoneBlob() {
            super(ItemId.MOON_STONE, "Moon Stone", "A peculiar stone that can make certain " +
                    "species of Pokémon evolve. It is as black as the night sky.");
        }
    }

    public static class IceStoneBlob extends ItemBlob {
        public IceStoneBlob() {
            super(ItemId.ICE_STONE, "Ice Stone", "A peculiar stone that can make certain " +
                    "species of Pokémon evolve. It has an unmistakable snowflake pattern.");
        }
    }

    public static class DawnStoneBlob extends ItemBlob {
        public DawnStoneBlob() {
            super(ItemId.DAWN_STONE, "Dawn Stone", "A peculiar stone that can make certain " +
                    "species of Pokémon evolve. It sparkles like a glittering eye.");
        }
    }



    /**
     * *******************************************************************************************
     *                                      USABLES
     * *******************************************************************************************
     */
    public static class Antidote extends ItemBlob {
        public Antidote() {
            super(ItemId.ANTIDOTE, "Antidote", "A spray-type medicine for poisoning. It can be " +
                    "used once to lift the effects of being poisoned from a Pokémon.");
        }
    }

    public static class Awakening extends ItemBlob {
        public Awakening() {
            super(ItemId.AWAKENING, "Awakening", "A spray-type medicine used against sleep. It " +
                    "can be used once to rouse a Pokémon from the clutches of sleep.");
        }
    }

    public static class BurnHeal extends ItemBlob {
        public BurnHeal() {
            super(ItemId.BURN_HEAL, "Burn Heal", "A spray-type medicine for treating burns. It " +
                    "can be used once to heal a Pokémon suffering from a burn.");
        }
    }

    public static class IceHeal extends ItemBlob {
        public IceHeal() {
            super(ItemId.ICE_HEAL, "Ice Heal", "A spray-type medicine for freezing. It can " +
                    "be used once to defrost a Pokémon that has been frozen solid.");
        }
    }

    public static class Potion extends ItemBlob {
        public Potion() {
            super(ItemId.POTION, "Potion", "A spray-type medicine for treating wounds. It can " +
                    "be used to restore 20 HP to an injured Pokémon.");
        }
    }

    public static class SuperPotion extends ItemBlob {
        public SuperPotion() {
            super(ItemId.SUPER_POTION, "Super Potion", "A spray-type medicine for treating " +
                    "wounds. It can be used to restore 60 HP to an injured Pokémon.");
        }
    }

    public static class HyperPotion extends ItemBlob {
        public HyperPotion() {
            super(ItemId.HYPER_POTION, "Hyper Potion", "A spray-type medicine for treating " +
                    "wounds. It can be used to restore 120 HP to an injured Pokémon.");
        }
    }

    public static class MaxPotion extends ItemBlob {
        public MaxPotion() {
            super(ItemId.MAX_POTION, "Max Potion", "A spray-type medicine for treating wounds. " +
                    "It will completely restore the max HP of a single Pokémon.");
        }
    }

    public static class RareCandy extends ItemBlob {
        public RareCandy() {
            super(ItemId.RARE_CANDY, "Rare Candy", "A candy that is packed with energy. When " +
                    "consumed, it will instantly raise the level of a single Pokémon by one.");
        }
    }

    public static class HpUp extends ItemBlob {
        public HpUp() {
            super(ItemId.HP_UP, "HP Up", "A nutritious drink for Pokémon. When consumed, it " +
                    "raises the base HP of a single Pokémon.");
        }
    }

    public static class Protein extends ItemBlob {
        public Protein() {
            super(ItemId.PROTEIN, "Protein", "A nutritious drink for Pokémon. When consumed, " +
                    "it raises the base Attack stat of a single Pokémon.");
        }
    }

    public static class Iron extends ItemBlob {
        public Iron() {
            super(ItemId.IRON, "Iron", "A nutritious drink for Pokémon. When consumed, it " +
                    "raises the base Defense stat of a single Pokémon.");
        }
    }

    public static class Calcium extends ItemBlob {
        public Calcium() {
            super(ItemId.CALCIUM, "Calcium", "A nutritious drink for Pokémon. When consumed, " +
                    "it raises the base Sp. Atk stat of a single Pokémon.");
        }
    }

    public static class Zinc extends ItemBlob {
        public Zinc() {
            super(ItemId.ZINC, "Zinc", "A nutritious drink for Pokémon. When consumed, it " +
                    "raises the base Sp. Def stat of a single Pokémon.");
        }
    }

    public static class Carbos extends ItemBlob {
        public Carbos() {
            super(ItemId.CARBOS, "Carbos", "A nutritious drink for Pokémon. When consumed, " +
                    "it raises the base Speed stat of a single Pokémon.");
        }
    }


}
