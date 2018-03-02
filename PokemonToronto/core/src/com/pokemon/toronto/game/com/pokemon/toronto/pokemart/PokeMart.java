package com.pokemon.toronto.game.com.pokemon.toronto.pokemart;

import com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item.MartListing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 8/17/2017.
 */

public class PokeMart {
    private List<MartListing> evolutionStones;
    private List<MartListing> pokeballs;
    private List<MartListing> usableItems;
    private List<MartListing> tms;

    private int currentPage; //0-n
    private int currentItem; //0-3, -1 for none
    private ItemTab currentTab;

    private List<MartListing> currentList;
    public PokeMart() {
        initEvolutionStones();
        initPokeballs();
        initUsableItems();
        initTMs();
        currentTab = ItemTab.EVOLUTION_STONE;
        currentPage = 0;
        currentItem = -1;
        currentList = new ArrayList<MartListing>();
        transferEvolutionStones();
    }

    private void transferEvolutionStones(){
        currentList.clear();
        for (int i = 0; i < evolutionStones.size(); i++) {
            currentList.add(evolutionStones.get(i));
        }
    }

    private void transferPokeballs() {
        currentList.clear();
        for (int i = 0; i < pokeballs.size(); i++) {
            currentList.add(pokeballs.get(i));
        }
    }

    private void transferUsableItems() {
        currentList.clear();
        for (int i = 0; i < usableItems.size(); i++) {
            currentList.add(usableItems.get(i));
        }
    }

    private void transferTMs() {
        currentList.clear();
        for (int i = 0; i < tms.size(); i++) {
            currentList.add(tms.get(i));
        }
    }

    private void initPokeballs() {
        pokeballs = new ArrayList<MartListing>();
        pokeballs.add(new MartListing.MartPokeball());
    }
    private void initEvolutionStones() {
        evolutionStones = new ArrayList<MartListing>();
        evolutionStones.add(new MartListing.MartLeafStone());
        evolutionStones.add(new MartListing.MartFireStone());
        evolutionStones.add(new MartListing.MartWaterStone());
        evolutionStones.add(new MartListing.MartThunderStone());
        evolutionStones.add(new MartListing.MartSunStone());
        evolutionStones.add(new MartListing.MartDuskStone());
        evolutionStones.add(new MartListing.MartShinyStone());
        evolutionStones.add(new MartListing.MartDawnStone());
        evolutionStones.add(new MartListing.MartMoonStone());
        evolutionStones.add(new MartListing.MartIceStone());
    }

    private void initUsableItems() {
        usableItems = new ArrayList<MartListing>();
        usableItems.add(new MartListing.MartPotion());
        usableItems.add(new MartListing.MartSuperPotion());
        usableItems.add(new MartListing.MartHyperPotion());
        usableItems.add(new MartListing.MartMaxPotion());
        usableItems.add(new MartListing.MartAntidote());
        usableItems.add(new MartListing.MartAwakening());
        usableItems.add(new MartListing.MartBurnHeal());
        usableItems.add(new MartListing.MartIceHeal());
        usableItems.add(new MartListing.HpUp());
        usableItems.add(new MartListing.Protein());
        usableItems.add(new MartListing.Iron());
        usableItems.add(new MartListing.Calcium());
        usableItems.add(new MartListing.Zinc());
        usableItems.add(new MartListing.Carbos());
        usableItems.add(new MartListing.RareCandy());
    }

    private void initTMs() {
        tms = new ArrayList<MartListing>();
        tms.add(new MartListing.MartTM01());
        tms.add(new MartListing.MartTM02());
    }

    public List<MartListing> getItems() {
        if (currentTab == ItemTab.EVOLUTION_STONE) {
            return evolutionStones;
        }
        return null;
    }

    public ItemTab getCurrentTab() {
        return currentTab;
    }

    public void setCurrentItem(int itemIndex) {
        if (itemIndex >= -1 && itemIndex <= 3) {
            currentItem = itemIndex;
        }
    }

    public boolean displayingBuyNow() {
        if (currentItem != -1) {
            return true;
        }
        return false;
    }

    public MartListing getItem(int itemIndex) {
        if (itemIndex == 0) {
            return currentList.get(currentPage * 4 + itemIndex);
        } else {
            if (currentPage * 4 + itemIndex < currentList.size()) {
                return currentList.get(currentPage * 4 + itemIndex);
            } else {
                return null;
            }
        }
    }

    public MartListing getFirstItem() {
        return currentList.get(currentPage * 4);
    }

    public MartListing getSecondItem() {
        if (currentPage * 4 + 1 < currentList.size()) {
            return currentList.get(currentPage * 4 + 1);
        }
        return null;
    }

    public MartListing getThirdItem() {
        if (currentPage * 4 + 2 < currentList.size()) {
            return currentList.get(currentPage * 4 + 2);
        }
        return null;
    }

    public MartListing getFourthItem() {
        if (currentPage * 4 + 3 < currentList.size()) {
            return currentList.get(currentPage * 4 + 3);
        }
        return null;
    }

    public boolean hasSecondItem() {
        if (currentPage * 4 + 1 < currentList.size()) {
            return true;
        }
        return false;
    }

    public boolean hasThirdItem() {
        if (currentPage * 4 + 2 < currentList.size()) {
            return true;
        }
        return false;
    }

    public boolean hasFourthItem() {
        if (currentPage * 4 + 3 < currentList.size()) {
            return true;
        }
        return false;
    }

    public boolean hasNextPage() {
        if ((currentPage * 4) + 4 < currentList.size()) {
            return true;
        }
        return false;
    }

    public boolean hasPreviousPage() {
        if (currentPage > 0) {
            return true;
        }
        return false;
    }

    public int getTotalPages() {
        return (int)Math.ceil(currentList.size() / 4.0);
    }

    public void goToNextPage() {
        currentPage++;
        currentItem = -1;
    }

    public void goToPreviousPage() {
        currentPage--;
        currentItem = -1;
    }

    public void setCurrentTab(ItemTab newTab) {
        if (newTab == ItemTab.POKEBALL) {
            transferPokeballs();
            switchTabs(ItemTab.POKEBALL);
        } else if (newTab == ItemTab.EVOLUTION_STONE) {
            transferEvolutionStones();
            switchTabs(ItemTab.EVOLUTION_STONE);
        } else if (newTab == ItemTab.POTION) {
            transferUsableItems();
            switchTabs(ItemTab.POTION);
        } else if (newTab == ItemTab.TM) {
            transferTMs();
            switchTabs(ItemTab.TM);
        }
    }

    private void switchTabs(ItemTab newTab) {
        currentItem = -1;
        currentPage = 0;
        currentTab = newTab;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getCurrentItem() {
        return currentItem;
    }
}
