package com.pokemon.toronto.game.com.pokemon.toronto.factory;

import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemId;
import com.pokemon.toronto.game.com.pokemon.toronto.item.PlayerItem;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.DawnStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.DuskStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.FireStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.IceStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.LeafStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.MoonStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.ShinyStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.SunStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.ThunderStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.stone.WaterStone;
import com.pokemon.toronto.game.com.pokemon.toronto.item.usable.Calcium;
import com.pokemon.toronto.game.com.pokemon.toronto.item.usable.Carbos;
import com.pokemon.toronto.game.com.pokemon.toronto.item.usable.HealthRestoreItem;
import com.pokemon.toronto.game.com.pokemon.toronto.item.usable.HpUp;
import com.pokemon.toronto.game.com.pokemon.toronto.item.usable.Iron;
import com.pokemon.toronto.game.com.pokemon.toronto.item.usable.MaxPotion;
import com.pokemon.toronto.game.com.pokemon.toronto.item.usable.Protein;
import com.pokemon.toronto.game.com.pokemon.toronto.item.usable.RareCandy;
import com.pokemon.toronto.game.com.pokemon.toronto.item.usable.StatusHealItem;
import com.pokemon.toronto.game.com.pokemon.toronto.item.usable.Zinc;

/**
 * Created by Gregory on 8/17/2017.
 */

public class ItemFactory {


    public ItemFactory() {

    }

    public PlayerItem createStone(ItemId stoneId, int amount) {
        if (stoneId == ItemId.LEAF_STONE) {
            return new PlayerItem(amount, new LeafStone());
        } else if (stoneId == ItemId.FIRE_STONE) {
            return new PlayerItem(amount, new FireStone());
        } else if (stoneId == ItemId.WATER_STONE) {
            return new PlayerItem(amount, new WaterStone());
        } else if (stoneId == ItemId.THUNDER_STONE) {
            return new PlayerItem(amount, new ThunderStone());
        } else if (stoneId == ItemId.SUN_STONE) {
            return new PlayerItem(amount, new SunStone());
        } else if (stoneId == ItemId.DUSK_STONE) {
            return new PlayerItem(amount, new DuskStone());
        } else if (stoneId == ItemId.SUN_STONE) {
            return new PlayerItem(amount, new ShinyStone());
        } else if (stoneId == ItemId.DAWN_STONE) {
            return new PlayerItem(amount, new DawnStone());
        } else if (stoneId == ItemId.MOON_STONE) {
            return new PlayerItem(amount, new MoonStone());
        } else if (stoneId == ItemId.ICE_STONE) {
            return new PlayerItem(amount, new IceStone());
        }
        return null;
    }

    public PlayerItem createUsable(ItemId id, int amount) {
        if (id == ItemId.POTION) {
            return new PlayerItem(amount, new HealthRestoreItem.Potion());
        } else if (id == ItemId.SUPER_POTION) {
            return new PlayerItem(amount, new HealthRestoreItem.SuperPotion());
        } else if (id == ItemId.HYPER_POTION) {
            return new PlayerItem(amount, new HealthRestoreItem.HyperPotion());
        } else if (id == ItemId.MAX_POTION) {
            return new PlayerItem(amount, new MaxPotion());
        } else if (id == ItemId.ANTIDOTE) {
            return new PlayerItem(amount, new StatusHealItem.Antidote());
        } else if (id == ItemId.AWAKENING) {
            return new PlayerItem(amount, new StatusHealItem.Awakening());
        } else if (id == ItemId.BURN_HEAL) {
            return new PlayerItem(amount, new StatusHealItem.BurnHeal());
        } else if (id == ItemId.ICE_HEAL) {
            return new PlayerItem(amount, new StatusHealItem.IceHeal());
        } else if (id == ItemId.HP_UP) {
            return new PlayerItem(amount, new HpUp());
        } else if (id == ItemId.PROTEIN) {
            return new PlayerItem(amount, new Protein());
        } else if (id == ItemId.IRON) {
            return new PlayerItem(amount, new Iron());
        } else if (id == ItemId.CALCIUM) {
            return new PlayerItem(amount, new Calcium());
        } else if (id == ItemId.ZINC) {
            return new PlayerItem(amount, new Zinc());
        } else if (id == ItemId.CARBOS) {
            return new PlayerItem(amount, new Carbos());
        } else if (id == ItemId.RARE_CANDY) {
            return new PlayerItem(amount, new RareCandy());
        }
        return null;
    }
}
