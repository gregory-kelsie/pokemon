package com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item;

import com.pokemon.toronto.game.com.pokemon.toronto.Ball.Pokeball;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemBlob;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.DuskStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.FireStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.LeafStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.ShinyStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.SunStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.ThunderStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.WaterStone;

/**
 * Created by Gregory on 8/18/2017.
 */

public class MartListing {
    protected int price;
    protected int rubyPrice;
    protected String storeImage;
    protected String headerImage;
    protected int quantity;
    protected ItemBlob info;

    public MartListing(ItemBlob info, int price, int rubyPrice, String storeImage,
                       String headerImage, int quantity) {
        this.info = info;
        this.price = price;
        this.rubyPrice = rubyPrice;
        this.storeImage = storeImage;
        this.headerImage = headerImage;
        this.quantity = quantity;
    }

    public ItemId getItemId() {
        return info.getId();
    }

    public String getName() {
        return info.getName();
    }

    public String getDescription() {
        return info.getDescription();
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getRubyPrice() {
        return rubyPrice;
    }

    public String getStoreImage() {
        return storeImage;
    }

    public String getHeaderImage() {
        return headerImage;
    }

    /**
     * ********************************************************************************************
     *                                      POKEBALL
     * ********************************************************************************************
     */

    public static class MartPokeball extends MartListing {
        public MartPokeball() {
            super(new ItemBlob.PokeballBlob(), 500, 1, "pokemart/items/pokeball.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    /**
     * ********************************************************************************************
     *                                      STONES
     * ********************************************************************************************
     */

    public static class MartDuskStone extends MartListing {
        public MartDuskStone() {
            super(new ItemBlob.DuskStoneBlob(), 4000, 1, "pokemart/items/duskStone.png",
                    "pokemart/itemNames/duskStone.png", 1);
        }
    }

    public static class MartFireStone extends MartListing {
        public MartFireStone() {
            super(new ItemBlob.FireStoneBlob(), 4000, 1,"pokemart/items/fireStone.png",
                    "pokemart/itemNames/fireStone.png", 1);
        }
    }

    public static class MartLeafStone extends MartListing {
        public MartLeafStone() {
            super(new ItemBlob.LeafStoneBlob(), 4000, 1,"pokemart/items/leafStone.png",
                    "pokemart/itemNames/leafStone.png", 1);
        }
    }

    public static class MartShinyStone extends MartListing {
        public MartShinyStone() {
            super(new ItemBlob.ShinyStoneBlob(), 4000, 1,"pokemart/items/shinyStone.png",
                    "pokemart/itemNames/shinyStone.png", 1);
        }
    }

    public static class MartSunStone extends MartListing {
        public MartSunStone() {
            super(new ItemBlob.SunStoneBlob(), 4000, 1,"pokemart/items/sunStone.png",
                    "pokemart/itemNames/sunStone.png", 1);
        }
    }

    public static class MartThunderStone extends MartListing {
        public MartThunderStone() {
            super(new ItemBlob.ThunderStoneBlob(), 4000, 1,"pokemart/items/thunderStone.png",
                    "pokemart/itemNames/thunderStone.png", 1);
        }
    }

    public static class MartWaterStone extends MartListing {
        public MartWaterStone() {
            super(new ItemBlob.WaterStoneBlob(), 4000, 1,"pokemart/items/waterStone.png",
                    "pokemart/itemNames/waterStone.png", 1);
        }
    }

    public static class MartMoonStone extends MartListing {
        public MartMoonStone() {
            super(new ItemBlob.MoonStoneBlob(), 4000, 1,"pokemart/items/moonStone.png",
                    "pokemart/itemNames/moonStone.png", 1);
        }
    }

    public static class MartDawnStone extends MartListing {
        public MartDawnStone() {
            super(new ItemBlob.DawnStoneBlob(), 4000, 1,"pokemart/items/dawnStone.png",
                    "pokemart/itemNames/dawnStone.png", 1);
        }
    }

    public static class MartIceStone extends MartListing {
        public MartIceStone() {
            super(new ItemBlob.IceStoneBlob(), 4000, 1,"pokemart/items/iceStone.png",
                    "pokemart/itemNames/iceStone.png", 1);
        }
    }

    /**
     * ********************************************************************************************
     *                                      USABLES
     * ********************************************************************************************
     */

    public static class MartPotion extends MartListing {
        public MartPotion() {
            super(new ItemBlob.Potion(), 4000, 1,"pokemart/items/potion.png",
                    "pokemart/itemNames/potion.png", 1);
        }
    }

    public static class MartSuperPotion extends MartListing {
        public MartSuperPotion() {
            super(new ItemBlob.SuperPotion(), 4000, 1,"pokemart/items/superPotion.png",
                    "pokemart/itemNames/superPotion.png", 1);
        }
    }

    public static class MartHyperPotion extends MartListing {
        public MartHyperPotion() {
            super(new ItemBlob.HyperPotion(), 4000, 1,"pokemart/items/hyperPotion.png",
                    "pokemart/itemNames/hyperPotion.png", 1);
        }
    }

    public static class MartMaxPotion extends MartListing {
        public MartMaxPotion() {
            super(new ItemBlob.MaxPotion(), 4000, 1,"pokemart/items/maxPotion.png",
                    "pokemart/itemNames/maxPotion.png", 1);
        }
    }

    public static class MartAntidote extends MartListing {
        public MartAntidote() {
            super(new ItemBlob.Antidote(), 4000, 1,"pokemart/items/antidote.png",
                    "pokemart/itemNames/antidote.png", 1);
        }
    }

    public static class MartAwakening extends MartListing {
        public MartAwakening() {
            super(new ItemBlob.Awakening(), 4000, 1,"pokemart/items/awakening.png",
                    "pokemart/itemNames/awakening.png", 1);
        }
    }

    public static class MartBurnHeal extends MartListing {
        public MartBurnHeal() {
            super(new ItemBlob.BurnHeal(), 4000, 1,"pokemart/items/burnHeal.png",
                    "pokemart/itemNames/burnHeal.png", 1);
        }
    }

    public static class MartIceHeal extends MartListing {
        public MartIceHeal() {
            super(new ItemBlob.IceHeal(), 4000, 1,"pokemart/items/iceHeal.png",
                    "pokemart/itemNames/iceHeal.png", 1);
        }
    }

    public static class RareCandy extends MartListing {
        public RareCandy() {
            super(new ItemBlob.RareCandy(), 9800, 1, "pokemart/items/rareCandy.png",
                    "pokemart/itemNames/rareCandy.png", 1);
        }
    }

    public static class HpUp extends MartListing {
        public HpUp() {
            super(new ItemBlob.HpUp(), 9800, 1, "pokemart/items/hpup.png",
                    "pokemart/itemNames/hpup.png", 1);
        }
    }

    public static class Protein extends MartListing {
        public Protein() {
            super(new ItemBlob.Protein(), 9800, 1, "pokemart/items/protein.png",
                    "pokemart/itemNames/protein.png", 1);
        }
    }

    public static class Iron extends MartListing {
        public Iron() {
            super(new ItemBlob.Iron(), 9800, 1, "pokemart/items/iron.png",
                    "pokemart/itemNames/iron.png", 1);
        }
    }

    public static class Calcium extends MartListing {
        public Calcium() {
            super(new ItemBlob.Calcium(), 9800, 1, "pokemart/items/calcium.png",
                    "pokemart/itemNames/calcium.png", 1);
        }
    }

    public static class Zinc extends MartListing {
        public Zinc() {
            super(new ItemBlob.Zinc(), 9800, 1, "pokemart/items/zinc.png",
                    "pokemart/itemNames/zinc.png", 1);
        }
    }

    public static class Carbos extends MartListing {
        public Carbos() {
            super(new ItemBlob.Carbos(), 9800, 1, "pokemart/items/carbos.png",
                    "pokemart/itemNames/carbos.png", 1);
        }
    }


}
