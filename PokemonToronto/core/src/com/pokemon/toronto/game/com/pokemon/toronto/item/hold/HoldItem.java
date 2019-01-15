package com.pokemon.toronto.game.com.pokemon.toronto.item.hold;

import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemBlob;

/**
 * Created by gregorykelsie on 2018-08-23.
 */

public class HoldItem extends Item {

    protected int maxUsage;
    private int currentUsage;
    private boolean deleteAfterUse;
    public HoldItem(ItemBlob blob, String image) {
        super(blob, image);
        maxUsage = 0;
        currentUsage = 0;
        deleteAfterUse = false;
    }

    public boolean willDeleteAfterUse() {
        return deleteAfterUse;
    }

    public int getMaxUsage() {
        return maxUsage;
    }

    public int getCurrentUsage() {
        return currentUsage;
    }

    public boolean canUseHoldItem() {
        if (maxUsage == 0 || currentUsage != 0) {
            return true;
        }
        return false;
    }

    public boolean isDepletableHoldItem() {
        if (maxUsage != 0) {
            return true;
        }
        return false;
    }

    public void useHoldItem() {
        currentUsage = Math.max(0, currentUsage - 1);
    }

    public void resetUsages() {
        currentUsage = maxUsage;
    }
}
