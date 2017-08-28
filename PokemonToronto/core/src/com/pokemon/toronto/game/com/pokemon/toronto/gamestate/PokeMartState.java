package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.ItemFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;
import com.pokemon.toronto.game.com.pokemon.toronto.item.PlayerItem;
import com.pokemon.toronto.game.com.pokemon.toronto.pokemart.ItemTab;
import com.pokemon.toronto.game.com.pokemon.toronto.pokemart.PokeMart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 8/18/2017.
 */

public class PokeMartState extends GameState{
    private GameStateManager gsm;
    private PokeMart pokeMart;
    
    private Texture background;
    private Texture leftArrow;
    private Texture rightArrow;
    private Texture brownPanel;
    private Texture yellowPanel;
    private Texture miniCurrencyLogos;
    private Texture buyNowTexture;
    private Texture headerTexture;
    private Texture bagPanelTexture;

    private List<Texture> itemNameTextures;
    private List<Texture> itemTextures;
    
    private BitmapFont currencyFont;
    private BitmapFont costFont;
    private BitmapFont bubbleFont;
    private BitmapFont bubbleHeaderFont;

    private Music bgm;
    private Sound clickSound;
    private Sound moneySound;

    private String bubbleHeader;
    private String bubbleText;
    
    public PokeMartState(GameStateManager gsm) {
        this.gsm = gsm;
        pokeMart = new PokeMart();
        initTextures();
        initFonts();
        bgm = Gdx.audio.newMusic(Gdx.files.internal("bgm/pokemart.mp3"));
        bgm.setLooping(true);
        bgm.play();
        clickSound = Gdx.audio.newSound(Gdx.files.internal("sounds/click.wav"));
        moneySound = Gdx.audio.newSound(Gdx.files.internal("sounds/money.wav"));
        initEvolutionBubbleText();

    }

    private void initFonts() {
        currencyFont =
                new BitmapFont(Gdx.files.internal("pokemart/font/moneyFont/moneyFont.fnt"));
        currencyFont.setColor(Color.BLACK);
        costFont =
                new BitmapFont(Gdx.files.internal("pokemart/font/itemCost/itemCost.fnt"));
        costFont.setColor(Color.BLACK);
        bubbleFont =
                new BitmapFont(Gdx.files.internal("pokemart/font/bubbleText/bubbleText.fnt"));
        bubbleFont.setColor(Color.BLACK);
        bubbleHeaderFont =
                new BitmapFont(Gdx.files.internal("pokemart/font/bubbleHeader/bubbleHeader.fnt"));
        bubbleHeaderFont.setColor(Color.BLACK);
    }

    private void initTextures() {
        background = new Texture("pokemart/gui/background.png");
        rightArrow = new Texture("pokemart/gui/rightArrow.png");
        leftArrow = new Texture("pokemart/gui/leftArrow.png");
        brownPanel = new Texture("pokemart/gui/brownPanel.png");
        yellowPanel = new Texture("pokemart/gui/yellowPanel.png");
        miniCurrencyLogos = new Texture("pokemart/gui/currency.png");
        buyNowTexture = new Texture("pokemart/gui/buyNow.png");
        bagPanelTexture = new Texture("pokemart/gui/bagPanel.png");
        setHeaderTexture();
        itemNameTextures = new ArrayList<Texture>();
        itemTextures = new ArrayList<Texture>();
        initItemTextures();

    }

    private void initItemTextures() {
        if (itemNameTextures.size() > 0) {
            itemNameTextures.get(0).dispose();
        }
        if (pokeMart.getFirstItem() != null) {
            if (itemNameTextures.size() < 1) {
                itemNameTextures.add(new Texture(pokeMart.getFirstItem().getHeaderImage()));
                itemTextures.add(new Texture(pokeMart.getFirstItem().getStoreImage()));
            } else {
                itemNameTextures.set(0, new Texture(pokeMart.getFirstItem().getHeaderImage()));
                itemTextures.set(0,new Texture(pokeMart.getFirstItem().getStoreImage()));
            }
            if (itemNameTextures.size() > 1) {
                itemNameTextures.get(1).dispose();
            }
            if (pokeMart.getSecondItem() != null) {
                if (itemNameTextures.size() < 2) {
                    itemNameTextures.add(new Texture(pokeMart.getSecondItem().getHeaderImage()));
                    itemTextures.add(new Texture(pokeMart.getSecondItem().getStoreImage()));
                } else {
                    itemNameTextures.set(1, new Texture(pokeMart.getSecondItem().getHeaderImage()));
                    itemTextures.set(1, new Texture(pokeMart.getSecondItem().getStoreImage()));;
                }

                if (itemNameTextures.size() > 2) {
                    itemNameTextures.get(2).dispose();
                }
                if (pokeMart.getThirdItem() != null) {
                    if (itemNameTextures.size() < 3) {
                        itemNameTextures.add(new Texture(pokeMart.getThirdItem().getHeaderImage()));
                        itemTextures.add(new Texture(pokeMart.getThirdItem().getStoreImage()));
                    } else {
                        itemNameTextures.set(2, new Texture(pokeMart.getThirdItem().getHeaderImage()));
                        itemTextures.set(2, new Texture(pokeMart.getThirdItem().getStoreImage()));
                    }
                    if (itemNameTextures.size() > 3) {
                        itemNameTextures.get(3).dispose();
                    }
                    if (pokeMart.getFourthItem() != null) {
                        if (itemNameTextures.size() < 4) {
                            itemNameTextures.add(new Texture(pokeMart.getFourthItem().getHeaderImage()));
                            itemTextures.add(new Texture(pokeMart.getFourthItem().getStoreImage()));
                        } else {
                            itemNameTextures.set(3, new Texture(pokeMart.getFourthItem().getHeaderImage()));
                            itemTextures.set(3, new Texture(pokeMart.getFourthItem().getStoreImage()));
                        }
                    }
                }
            }
        }
    }

    private void setHeaderTexture() {
        if (headerTexture != null) {
            headerTexture.dispose();
        }
        if (pokeMart.getCurrentTab() == ItemTab.EVOLUTION_STONE) {
            headerTexture = new Texture("pokemart/headers/evolutionStones.png");
        } else if (pokeMart.getCurrentTab() == ItemTab.POKEBALL) {
            Gdx.app.log("mart", "pokeballheader");
            headerTexture = new Texture("pokemart/headers/pokeballs.png");
        } else if (pokeMart.getCurrentTab() == ItemTab.POTION) {
            headerTexture = new Texture("pokemart/headers/potions.png");
        } else if (pokeMart.getCurrentTab() == ItemTab.BERRY) {
            headerTexture = new Texture("pokemart/headers/berries.png");
        } else if (pokeMart.getCurrentTab() == ItemTab.TM) {
            headerTexture = new Texture("pokemart/headers/tms.png");
        } else if (pokeMart.getCurrentTab() == ItemTab.HOLD_ITEM) {
            headerTexture = new Texture("pokemart/headers/holditems.png");
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 0);
        batch.draw(bagPanelTexture, 126, 1827);
        batch.draw(headerTexture, 352, 1224);
        drawItems(batch);
        currencyFont.draw(batch, "54,000", 144, 80);
        currencyFont.draw(batch, "25", 852, 80);
        bubbleHeaderFont.draw(batch, bubbleHeader, 483, 1824);
        bubbleFont.draw(batch, bubbleText, 480, 1773);
        if (pokeMart.displayingBuyNow()) {
            batch.draw(buyNowTexture, 849, 1329);
        }
    }

    private void drawItems(SpriteBatch batch) {
        drawPanels(batch);
        drawItemNames(batch);
        drawArrows(batch);
    }

    private void drawArrows(SpriteBatch batch) {
        batch.draw(leftArrow, 372, 160);
        batch.draw(rightArrow, 860, 160);
        costFont.draw(batch, pokeMart.getCurrentPage() + 1 + "/" + pokeMart.getTotalPages(),621, 228);
    }

    private void drawItemNames(SpriteBatch batch) {
        batch.draw(itemNameTextures.get(0), 310, 1062);
        batch.draw(itemTextures.get(0), 310, 858);
        batch.draw(miniCurrencyLogos, 310, 734);
        costFont.draw(batch, Integer.toString(pokeMart.getFirstItem().getPrice()),490, 834);
        costFont.draw(batch, Integer.toString(pokeMart.getFirstItem().getRubyPrice()),490, 782);
        if (pokeMart.hasSecondItem()) {
            batch.draw(itemNameTextures.get(1), 686, 1062);
            batch.draw(itemTextures.get(1), 686, 858);
            batch.draw(miniCurrencyLogos, 686, 734);
            costFont.draw(batch, Integer.toString(pokeMart.getSecondItem().getPrice()),870, 834);
            costFont.draw(batch, Integer.toString(pokeMart.getSecondItem().getRubyPrice()),870, 782);
            if (pokeMart.hasThirdItem()) {
                batch.draw(itemNameTextures.get(2), 310, 614);
                batch.draw(itemTextures.get(2), 310, 416);
                batch.draw(miniCurrencyLogos, 310, 286);
                costFont.draw(batch, Integer.toString(pokeMart.getThirdItem().getPrice()),490, 399);
                costFont.draw(batch, Integer.toString(pokeMart.getThirdItem().getRubyPrice()),490, 347);
                if (pokeMart.hasFourthItem()) {
                    batch.draw(itemNameTextures.get(3), 686, 614);
                    batch.draw(itemTextures.get(3), 686, 416);
                    batch.draw(miniCurrencyLogos, 686, 286);
                    costFont.draw(batch, Integer.toString(pokeMart.getFourthItem().getPrice()),870, 399);
                    costFont.draw(batch, Integer.toString(pokeMart.getFourthItem().getRubyPrice()),870, 347);
                }
            }
        }
    }

    private void drawPanels(SpriteBatch batch) {
        //Always draw the first panel.
        if (pokeMart.getCurrentItem() != 0) {
            batch.draw(brownPanel, 308, 730);
        } else {
            batch.draw(yellowPanel, 308, 730);
        }

        if (pokeMart.getCurrentItem() == 1) {
            batch.draw(yellowPanel, 684, 730);
        } else if (pokeMart.hasSecondItem()) {
            batch.draw(brownPanel, 684, 730);
        }

        if (pokeMart.getCurrentItem() == 2) {
            batch.draw(yellowPanel, 308, 282);
        } else if (pokeMart.hasThirdItem()) {
            batch.draw(brownPanel, 308, 282);
        }
        if (pokeMart.getCurrentItem() == 3) {
            batch.draw(yellowPanel, 684, 282);
        } else if (pokeMart.hasFourthItem()) {
            batch.draw(brownPanel, 684, 282);
        }
    }

    @Override
    public void update(double dt) {
        if (MyInput.clicked()) {
            int x = MyInput.getX();
            int y = MyInput.getY();
            Gdx.app.log("martxy", x + "," + y);
            if (x >= 0 && x <= 105 && y >= 0 && y <= 93) {
                clickSound.play();
                gsm.setState(new LoadingState(gsm, LoadingState.POKENAV_MENU));
                bgm.stop();
                gsm.playBgm();
                dispose();
            } else if (x >= 322 && x <= 622 && y >= 800 && y <= 1193) {
                clickedFirstItem();
            } else if (x >= 684 && x <= 997 && y >= 800 && y <= 1193) {
                clickedSecondItem();
            } else if (x >= 322 && x <= 622 && y >= 1291 && y <= 1615) {
                clickedThirdItem();
            } else if (x >= 684 && x <= 997 && y >= 1291 && y <= 1615) {
                clickedFourthItem();
            } else if (x >= 309 && x <= 449 && y >= 1697 && y <= 1775) {
                clickedLeft();
            } else if (x >= 807 && x <= 929 && y >= 1697 && y <= 1775) {
                clickedRight();
            } else if (x >= 125 && x <= 241 && y >= 745 && y <= 885) {
                clickedPokeballTab();
            } else if (x >= 125 && x <= 241 && y >= 1656 && y <= 1776) {
                clickedEvolutionStoneTab();
            } else if (x >= 838 && x <= 1016 && y >= 421 && y <= 556) {
                clickedBuyNow();
            } else if (x >= 126 && x <= 429 && y >= 0 && y <= 93) {
                clickSound.play();
                gsm.setState(new BagState(gsm, false));
                dispose();
            }
        }
    }

    private void clickedRight() {
        if (pokeMart.hasNextPage()) {
            clickSound.play();
            pokeMart.goToNextPage();
            initItemTextures();
            initBubbleText();
        }
    }

    private void initBubbleText() {
        if (pokeMart.getCurrentTab() == ItemTab.EVOLUTION_STONE) {
            initEvolutionBubbleText();
        } else if (pokeMart.getCurrentTab() == ItemTab.POKEBALL) {
            initPokeballBubbleText();
        }
    }

    private void clickedLeft() {
        if (pokeMart.hasPreviousPage()) {
            clickSound.play();
            pokeMart.goToPreviousPage();
            initItemTextures();
            initBubbleText();
        }
    }

    private void clickedFirstItem() {
        clickSound.play();
        pokeMart.setCurrentItem(0);
        bubbleHeader = pokeMart.getFirstItem().getItem().getName();
        bubbleText = formatDescription(pokeMart.getFirstItem().getItem().getDescription());

    }

    private void clickedSecondItem() {
        if (pokeMart.hasSecondItem()) {
            clickSound.play();
            pokeMart.setCurrentItem(1);
            bubbleHeader = pokeMart.getSecondItem().getItem().getName();
            bubbleText = formatDescription(pokeMart.getSecondItem().getItem().getDescription());
        }
    }

    private void clickedThirdItem() {
        if (pokeMart.hasThirdItem()) {
            clickSound.play();
            pokeMart.setCurrentItem(2);
            bubbleHeader = pokeMart.getThirdItem().getItem().getName();
            bubbleText = formatDescription(pokeMart.getThirdItem().getItem().getDescription());
        }
    }

    private void clickedFourthItem() {
        if (pokeMart.hasFourthItem()) {
            clickSound.play();
            pokeMart.setCurrentItem(3);
            bubbleHeader = pokeMart.getFourthItem().getItem().getName();
            bubbleText = formatDescription(pokeMart.getFourthItem().getItem().getDescription());
        }
    }

    /**
     * Return a formatted description String that has new lines in the correct
     * places so it doesn't overflow out of the speech bubble.
     * @param description The description before formatting.
     * @return A String of the formatted description with new lines so it doesn't overflow out
     * of the speech bubble.
     */
    private String formatDescription(String description) {
        String[] splitDescription = description.split(" ");
        String newDescription = "";
        double lineCurrentValue = 0;
        for (int i = 0; i < splitDescription.length; i++) {
            if ((lineCurrentValue + 1 + getWordLengthValue(splitDescription[i])) <= 30.0) {
                newDescription = newDescription + splitDescription[i] + " ";
                lineCurrentValue = lineCurrentValue + 1 + getWordLengthValue(splitDescription[i]);
            } else {
                newDescription = newDescription + "\n" + splitDescription[i] + " ";
                lineCurrentValue = getWordLengthValue(splitDescription[i]) + 1; //+1 for the space
            }
        }
        return newDescription;
    }

    private double getWordLengthValue(String word) {
        double value = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'i' || word.charAt(i) == 'l' || word.charAt(i) == '!' ||
                    word.charAt(i) == '.') {
                value += 0.5;
            } else {
                value++;
            }
        }
        return value;
    }

    private void clickedBuyNow() {
        if (pokeMart.getCurrentItem() == 0) {
            if (pokeMart.getCurrentTab() == ItemTab.EVOLUTION_STONE) {
                gsm.getBag().addStone(pokeMart.getFirstItem().getItemId());
                moneySound.play();
            } else if (pokeMart.getCurrentTab() == ItemTab.POKEBALL) {
                gsm.getBag().addPokeball(pokeMart.getFirstItem().getItemId(), pokeMart.getFirstItem().getQuantity());
                moneySound.play();
            }
        } else if (pokeMart.getCurrentItem() == 1) {
            if (pokeMart.getCurrentTab() == ItemTab.EVOLUTION_STONE) {
                gsm.getBag().addStone(pokeMart.getSecondItem().getItemId());
                moneySound.play();
            } else if (pokeMart.getCurrentTab() == ItemTab.POKEBALL) {
                gsm.getBag().addPokeball(pokeMart.getSecondItem().getItemId(), pokeMart.getSecondItem().getQuantity());
                moneySound.play();
            }
        } else if (pokeMart.getCurrentItem() == 2) {
            if (pokeMart.getCurrentTab() == ItemTab.EVOLUTION_STONE) {
                gsm.getBag().addStone(pokeMart.getThirdItem().getItemId());
                moneySound.play();
            } else if (pokeMart.getCurrentTab() == ItemTab.POKEBALL) {
                gsm.getBag().addPokeball(pokeMart.getThirdItem().getItemId(), pokeMart.getThirdItem().getQuantity());
                moneySound.play();
            }
        } else if (pokeMart.getCurrentItem() == 3) {
            if (pokeMart.getCurrentTab() == ItemTab.EVOLUTION_STONE) {
                gsm.getBag().addStone(pokeMart.getFourthItem().getItemId());
                moneySound.play();
            } else if (pokeMart.getCurrentTab() == ItemTab.POKEBALL) {
                gsm.getBag().addPokeball(pokeMart.getFourthItem().getItemId(), pokeMart.getFourthItem().getQuantity());
                moneySound.play();
            }
        }
    }

    private void clickedPokeballTab() {
        if (pokeMart.getCurrentTab() != ItemTab.POKEBALL) {
            clickSound.play();
            pokeMart.setCurrentTab(ItemTab.POKEBALL);
            setHeaderTexture();
            initItemTextures();
            initPokeballBubbleText();
        }
    }

    private void initPokeballBubbleText() {
        bubbleHeader = "Pokeballs";
        bubbleText = "Capture wild Pokemon with\nthese! The balls won't work in\nthe simulator though...";
    }

    private void initEvolutionBubbleText() {
        bubbleHeader = "Evolution Stones";
        bubbleText = "Using these stones on certain\nPokemon will evolve them!";
    }

    private void clickedEvolutionStoneTab() {
        if (pokeMart.getCurrentTab() != ItemTab.EVOLUTION_STONE) {
            clickSound.play();
            pokeMart.setCurrentTab(ItemTab.EVOLUTION_STONE);
            setHeaderTexture();
            initItemTextures();
            initEvolutionBubbleText();
        }
    }

    @Override
    protected void dispose() {
        background.dispose();
        leftArrow.dispose();
        rightArrow.dispose();
        brownPanel.dispose();
        yellowPanel.dispose();
        miniCurrencyLogos.dispose();
        buyNowTexture.dispose();
        headerTexture.dispose();
        for (int i = 0; i < itemNameTextures.size(); i++) {
            itemNameTextures.get(i).dispose();
        }
        currencyFont.dispose();
        costFont.dispose();
        bubbleFont.dispose();
        bubbleHeaderFont.dispose();
        bgm.dispose();
        clickSound.dispose();
        moneySound.dispose();
        bagPanelTexture.dispose();
    }
}
