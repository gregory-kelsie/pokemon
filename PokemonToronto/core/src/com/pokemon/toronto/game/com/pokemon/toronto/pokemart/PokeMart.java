package com.pokemon.toronto.game.com.pokemon.toronto.pokemart;

import com.pokemon.toronto.game.com.pokemon.toronto.bag.Bag;
import com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item.MartBall;
import com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item.MartDuskStone;
import com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item.MartFireStone;
import com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item.MartLeafStone;
import com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item.MartItem;
import com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item.MartListing;
import com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item.MartPokeball;
import com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item.MartPokeball10;
import com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item.MartPokeball20;
import com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item.MartPokeball5;
import com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item.MartShinyStone;
import com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item.MartSunStone;
import com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item.MartThunderStone;
import com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item.MartWaterStone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 8/17/2017.
 */

public class PokeMart {
    private List<MartItem> evolutionStones;
    private List<MartBall> pokeballs;

    private int currentPage; //0-n
    private int currentItem; //0-3, -1 for none
    private ItemTab currentTab;

    private List<MartItem> currentList;
    public PokeMart() {
        initEvolutionStones();
        initPokeballs();
        currentTab = ItemTab.EVOLUTION_STONE;
        currentPage = 0;
        currentItem = -1;
        currentList = new ArrayList<MartItem>();
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

    private void initPokeballs() {
        pokeballs = new ArrayList<MartBall>();
        pokeballs.add(new MartPokeball());
        pokeballs.add(new MartPokeball5());
        pokeballs.add(new MartPokeball10());
        pokeballs.add(new MartPokeball20());
    }
    private void initEvolutionStones() {
        evolutionStones = new ArrayList<MartItem>();
        evolutionStones.add(new MartLeafStone());
        evolutionStones.add(new MartFireStone());
        evolutionStones.add(new MartWaterStone());
        evolutionStones.add(new MartThunderStone());
        evolutionStones.add(new MartSunStone());
        evolutionStones.add(new MartDuskStone());
        evolutionStones.add(new MartShinyStone());

    }

    public List<MartItem> getItems() {
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

    public MartItem getFirstItem() {
        return currentList.get(currentPage * 4);
    }

    public MartItem getSecondItem() {
        if (currentPage * 4 + 1 < currentList.size()) {
            return currentList.get(currentPage * 4 + 1);
        }
        return null;
    }

    public MartItem getThirdItem() {
        if (currentPage * 4 + 2 < currentList.size()) {
            return currentList.get(currentPage * 4 + 2);
        }
        return null;
    }

    public MartItem getFourthItem() {
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

    public void buyItem(Bag playerBag) {
        if (currentTab == ItemTab.EVOLUTION_STONE) {
            buyStone(playerBag);
        }
    }

    public void setCurrentTab(ItemTab newTab) {
        if (newTab == ItemTab.POKEBALL) {
            transferPokeballs();
            switchTabs(ItemTab.POKEBALL);
        } else if (newTab == ItemTab.EVOLUTION_STONE) {
            transferEvolutionStones();
            switchTabs(ItemTab.EVOLUTION_STONE);
        }
    }

    private void switchTabs(ItemTab newTab) {
        currentItem = -1;
        currentPage = 0;
        currentTab = newTab;
    }

    public void buyStone(Bag playerBag) {
        playerBag.addStone(evolutionStones
                .get(currentPage * 4 + currentItem).getItemId());
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getCurrentItem() {
        return currentItem;
    }
}
