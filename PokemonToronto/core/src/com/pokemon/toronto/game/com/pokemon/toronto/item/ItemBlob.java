package com.pokemon.toronto.game.com.pokemon.toronto.item;

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


}
