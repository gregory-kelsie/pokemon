package com.pokemon.toronto.game.com.pokemon.toronto.item.usable;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemBlob;

/**
 * Created by Gregory on 11/6/2017.
 */

public class HealthRestoreItem extends Item {
    protected int restoreAmount;
    public HealthRestoreItem(ItemBlob info, String image, int restoreAmount) {
        super(info, image);
        this.restoreAmount = restoreAmount;
    }

    public int getRestoreAmount() {
        return restoreAmount;
    }

    @Override
    public String use(Pokemon p) {
        // TODO Auto-generated method stub
        p.addHealth(restoreAmount);
        return p.getName() + "'s health was restored by " + restoreAmount;
    }

    @Override
    public boolean ableToUse(Pokemon p) {
        if (p.getCurrentHealth() < p.getHealthStat() && !p.isFainted()) {
            return true;
        }
        return false;
    }

    public static class Potion extends HealthRestoreItem {
        public Potion() {
            super(new ItemBlob.Potion(), "bag/icons/potion.png", 20);
        }
    }

    public static class SuperPotion extends HealthRestoreItem {
        public SuperPotion() {
            super(new ItemBlob.SuperPotion(), "bag/icons/superPotion.png", 60);
        }
    }

    public static class HyperPotion extends HealthRestoreItem {
        public HyperPotion() {
            super(new ItemBlob.HyperPotion(), "bag/icons/hyperPotion.png", 120);
        }
    }
}
