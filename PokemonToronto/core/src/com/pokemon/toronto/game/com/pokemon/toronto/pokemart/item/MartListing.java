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
     *                                      TMs
     * ********************************************************************************************
     */

    public static class MartTM01 extends MartListing {
        public MartTM01() {
            super(new ItemBlob.TM01Blob(), 5000, 1, "pokemart/items/normaltm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM02 extends MartListing {
        public MartTM02() {
            super(new ItemBlob.TM02Blob(), 8000, 1, "pokemart/items/dragontm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM03 extends MartListing {
        public MartTM03() {
            super(new ItemBlob.TM03Blob(), 8000, 1, "pokemart/items/psychictm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM04 extends MartListing {
        public MartTM04() {
            super(new ItemBlob.TM04Blob(), 8000, 1, "pokemart/items/psychictm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM07 extends MartListing {
        public MartTM07() {
            super(new ItemBlob.TM07Blob(), 8000, 1, "pokemart/items/icetm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM08 extends MartListing {
        public MartTM08() {
            super(new ItemBlob.TM08Blob(), 8000, 1, "pokemart/items/fightingtm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM09 extends MartListing {
        public MartTM09() {
            super(new ItemBlob.TM09Blob(), 8000, 1, "pokemart/items/poisontm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM10 extends MartListing {
        public MartTM10() {
            super(new ItemBlob.TM10Blob(), 8000, 1, "pokemart/items/normaltm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM11 extends MartListing {
        public MartTM11() {
            super(new ItemBlob.TM11Blob(), 8000, 1, "pokemart/items/firetm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM13 extends MartListing {
        public MartTM13() {
            super(new ItemBlob.TM13Blob(), 8000, 1, "pokemart/items/icetm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM14 extends MartListing {
        public MartTM14() {
            super(new ItemBlob.TM14Blob(), 8000, 1, "pokemart/items/icetm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM15 extends MartListing {
        public MartTM15() {
            super(new ItemBlob.TM15Blob(), 8000, 1, "pokemart/items/normaltm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM16 extends MartListing {
        public MartTM16() {
            super(new ItemBlob.TM16Blob(), 8000, 1, "pokemart/items/psychictm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM18 extends MartListing {
        public MartTM18() {
            super(new ItemBlob.TM18Blob(), 8000, 1, "pokemart/items/watertm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM19 extends MartListing {
        public MartTM19() {
            super(new ItemBlob.TM19Blob(), 8000, 1, "pokemart/items/flyingtm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM20 extends MartListing {
        public MartTM20() {
            super(new ItemBlob.TM20Blob(), 8000, 1, "pokemart/items/normaltm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM22 extends MartListing {
        public MartTM22() {
            super(new ItemBlob.TM22Blob(), 8000, 1, "pokemart/items/grasstm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM24 extends MartListing {
        public MartTM24() {
            super(new ItemBlob.TM24Blob(), 8000, 1, "pokemart/items/electrictm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM25 extends MartListing {
        public MartTM25() {
            super(new ItemBlob.TM25Blob(), 8000, 1, "pokemart/items/electrictm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM26 extends MartListing {
        public MartTM26() {
            super(new ItemBlob.TM26Blob(), 8000, 1, "pokemart/items/groundtm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM28 extends MartListing {
        public MartTM28() {
            super(new ItemBlob.TM28Blob(), 8000, 1, "pokemart/items/bugtm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM29 extends MartListing {
        public MartTM29() {
            super(new ItemBlob.TM29Blob(), 8000, 1, "pokemart/items/psychictm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM30 extends MartListing {
        public MartTM30() {
            super(new ItemBlob.TM30Blob(), 8000, 1, "pokemart/items/ghosttm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM31 extends MartListing {
        public MartTM31() {
            super(new ItemBlob.TM31Blob(), 8000, 1, "pokemart/items/fightingtm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM32 extends MartListing {
        public MartTM32() {
            super(new ItemBlob.TM32Blob(), 8000, 1, "pokemart/items/normaltm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM33 extends MartListing {
        public MartTM33() {
            super(new ItemBlob.TM33Blob(), 8000, 1, "pokemart/items/psychictm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM34 extends MartListing {
        public MartTM34() {
            super(new ItemBlob.TM34Blob(), 8000, 1, "pokemart/items/poisontm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM35 extends MartListing {
        public MartTM35() {
            super(new ItemBlob.TM35Blob(), 8000, 1, "pokemart/items/firetm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM36 extends MartListing {
        public MartTM36() {
            super(new ItemBlob.TM36Blob(), 8000, 1, "pokemart/items/poisontm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM37 extends MartListing {
        public MartTM37() {
            super(new ItemBlob.TM37Blob(), 8000, 1, "pokemart/items/rocktm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM38 extends MartListing {
        public MartTM38() {
            super(new ItemBlob.TM38Blob(), 8000, 1, "pokemart/items/firetm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM39 extends MartListing {
        public MartTM39() {
            super(new ItemBlob.TM39Blob(), 8000, 1, "pokemart/items/rocktm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM40 extends MartListing {
        public MartTM40() {
            super(new ItemBlob.TM40Blob(), 8000, 1, "pokemart/items/flyingtm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM42 extends MartListing {
        public MartTM42() {
            super(new ItemBlob.TM42Blob(), 8000, 1, "pokemart/items/normaltm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM43 extends MartListing {
        public MartTM43() {
            super(new ItemBlob.TM43Blob(), 8000, 1, "pokemart/items/firetm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM44 extends MartListing {
        public MartTM44() {
            super(new ItemBlob.TM44Blob(), 8000, 1, "pokemart/items/psychictm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM46 extends MartListing {
        public MartTM46() {
            super(new ItemBlob.TM46Blob(), 8000, 1, "pokemart/items/darktm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM47 extends MartListing {
        public MartTM47() {
            super(new ItemBlob.TM47Blob(), 8000, 1, "pokemart/items/fightingtm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM48 extends MartListing {
        public MartTM48() {
            super(new ItemBlob.TM48Blob(), 8000, 1, "pokemart/items/normaltm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM49 extends MartListing {
        public MartTM49() {
            super(new ItemBlob.TM49Blob(), 8000, 1, "pokemart/items/normaltm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM50 extends MartListing {
        public MartTM50() {
            super(new ItemBlob.TM50Blob(), 8000, 1, "pokemart/items/firetm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM51 extends MartListing {
        public MartTM51() {
            super(new ItemBlob.TM51Blob(), 8000, 1, "pokemart/items/steeltm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM52 extends MartListing {
        public MartTM52() {
            super(new ItemBlob.TM52Blob(), 8000, 1, "pokemart/items/fightingtm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM53 extends MartListing {
        public MartTM53() {
            super(new ItemBlob.TM53Blob(), 8000, 1, "pokemart/items/grasstm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM54 extends MartListing {
        public MartTM54() {
            super(new ItemBlob.TM54Blob(), 8000, 1, "pokemart/items/normaltm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM55 extends MartListing {
        public MartTM55() {
            super(new ItemBlob.TM55Blob(), 8000, 1, "pokemart/items/watertm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM57 extends MartListing {
        public MartTM57() {
            super(new ItemBlob.TM57Blob(), 8000, 1, "pokemart/items/electrictm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM58 extends MartListing {
        public MartTM58() {
            super(new ItemBlob.TM58Blob(), 8000, 1, "pokemart/items/flyingtm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM59 extends MartListing {
        public MartTM59() {
            super(new ItemBlob.TM59Blob(), 8000, 1, "pokemart/items/darktm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM61 extends MartListing {
        public MartTM61() {
            super(new ItemBlob.TM61Blob(), 8000, 1, "pokemart/items/firetm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM62 extends MartListing {
        public MartTM62() {
            super(new ItemBlob.TM62Blob(), 8000, 1, "pokemart/items/flyingtm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM64 extends MartListing {
        public MartTM64() {
            super(new ItemBlob.TM64Blob(), 8000, 1, "pokemart/items/normaltm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM65 extends MartListing {
        public MartTM65() {
            super(new ItemBlob.TM65Blob(), 8000, 1, "pokemart/items/ghosttm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM66 extends MartListing {
        public MartTM66() {
            super(new ItemBlob.TM66Blob(), 8000, 1, "pokemart/items/darktm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM67 extends MartListing {
        public MartTM67() {
            super(new ItemBlob.TM67Blob(), 8000, 1, "pokemart/items/steeltm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM68 extends MartListing {
        public MartTM68() {
            super(new ItemBlob.TM68Blob(), 8000, 1, "pokemart/items/normaltm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM69 extends MartListing {
        public MartTM69() {
            super(new ItemBlob.TM69Blob(), 8000, 1, "pokemart/items/rocktm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM71 extends MartListing {
        public MartTM71() {
            super(new ItemBlob.TM71Blob(), 8000, 1, "pokemart/items/rocktm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM73 extends MartListing {
        public MartTM73() {
            super(new ItemBlob.TM73Blob(), 8000, 1, "pokemart/items/electrictm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM74 extends MartListing {
        public MartTM74() {
            super(new ItemBlob.TM74Blob(), 8000, 1, "pokemart/items/steeltm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM75 extends MartListing {
        public MartTM75() {
            super(new ItemBlob.TM75Blob(), 8000, 1, "pokemart/items/normaltm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM76 extends MartListing {
        public MartTM76() {
            super(new ItemBlob.TM76Blob(), 8000, 1, "pokemart/items/flyingtm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM77 extends MartListing {
        public MartTM77() {
            super(new ItemBlob.TM77Blob(), 8000, 1, "pokemart/items/normaltm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM78 extends MartListing {
        public MartTM78() {
            super(new ItemBlob.TM78Blob(), 8000, 1, "pokemart/items/groundtm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }


    public static class MartTM79 extends MartListing {
        public MartTM79() {
            super(new ItemBlob.TM79Blob(), 8000, 1, "pokemart/items/icetm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM80 extends MartListing {
        public MartTM80() {
            super(new ItemBlob.TM80Blob(), 8000, 1, "pokemart/items/rocktm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM81 extends MartListing {
        public MartTM81() {
            super(new ItemBlob.TM81Blob(), 8000, 1, "pokemart/items/bugtm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM83 extends MartListing {
        public MartTM83() {
            super(new ItemBlob.TM83Blob(), 8000, 1, "pokemart/items/bugtm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM84 extends MartListing {
        public MartTM84() {
            super(new ItemBlob.TM84Blob(), 8000, 1, "pokemart/items/poisontm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM85 extends MartListing {
        public MartTM85() {
            super(new ItemBlob.TM85Blob(), 8000, 1, "pokemart/items/psychictm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }


    public static class MartTM86 extends MartListing {
        public MartTM86() {
            super(new ItemBlob.TM86Blob(), 8000, 1, "pokemart/items/grasstm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM87 extends MartListing {
        public MartTM87() {
            super(new ItemBlob.TM87Blob(), 8000, 1, "pokemart/items/normaltm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM91 extends MartListing {
        public MartTM91() {
            super(new ItemBlob.TM91Blob(), 8000, 1, "pokemart/items/steeltm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM92 extends MartListing {
        public MartTM92() {
            super(new ItemBlob.TM92Blob(), 8000, 1, "pokemart/items/psychictm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM93 extends MartListing {
        public MartTM93() {
            super(new ItemBlob.TM93Blob(), 8000, 1, "pokemart/items/electrictm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM94 extends MartListing {
        public MartTM94() {
            super(new ItemBlob.TM94Blob(), 8000, 1, "pokemart/items/watertm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM95 extends MartListing {
        public MartTM95() {
            super(new ItemBlob.TM95Blob(), 8000, 1, "pokemart/items/darktm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM97 extends MartListing {
        public MartTM97() {
            super(new ItemBlob.TM97Blob(), 8000, 1, "pokemart/items/darktm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM98 extends MartListing {
        public MartTM98() {
            super(new ItemBlob.TM98Blob(), 8000, 1, "pokemart/items/watertm.png",
                    "pokemart/itemNames/pokeball.png", 1);
        }
    }

    public static class MartTM99 extends MartListing {
        public MartTM99() {
            super(new ItemBlob.TM99Blob(), 8000, 1, "pokemart/items/fairytm.png",
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
