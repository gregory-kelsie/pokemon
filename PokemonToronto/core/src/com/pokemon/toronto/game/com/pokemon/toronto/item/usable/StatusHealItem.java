package com.pokemon.toronto.game.com.pokemon.toronto.item.usable;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemBlob;

/**
 * Created by Gregory on 11/6/2017.
 */

public class StatusHealItem extends Item {
    protected Pokemon.Status recoverableStatus;
    public StatusHealItem(ItemBlob info, String image, Pokemon.Status recoverableStatus) {
        super(info, image);
        this.recoverableStatus = recoverableStatus;
    }

    public Pokemon.Status getRecoverableStatus() {
        return recoverableStatus;
    }

    @Override
    public void use(Pokemon p) {
        p.wakeUp();
    }

    @Override
    public boolean ableToUse(Pokemon p) {
        if (p.getStatus() == recoverableStatus) {
            return true;
        }
        return false;
    }

    public static class Antidote extends StatusHealItem {
        public Antidote() {
            super(new ItemBlob.Antidote(), "bag/icons/antidote.png", Pokemon.Status.POISON);
        }
    }

    public static class Awakening extends StatusHealItem {
        public Awakening() {
            super(new ItemBlob.Awakening(), "bag/icons/awakening.png", Pokemon.Status.SLEEP);
        }
    }

    public static class BurnHeal extends StatusHealItem {
        public BurnHeal() {
            super(new ItemBlob.BurnHeal(), "bag/icons/burnHeal.png", Pokemon.Status.BURN);
        }
    }

    public static class IceHeal extends StatusHealItem {
        public IceHeal() {
            super(new ItemBlob.IceHeal(), "bag/icons/iceHeal.png", Pokemon.Status.FROZEN);
        }
    }
}
