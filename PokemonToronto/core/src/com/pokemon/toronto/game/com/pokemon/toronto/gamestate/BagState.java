package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokemonFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;
import com.pokemon.toronto.game.com.pokemon.toronto.pokemart.ItemTab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 8/18/2017.
 */

public class BagState extends GameState {
    private GameStateManager gsm;

    private Texture topBackground;
    private Texture evolutionPanel;
    private Texture berryPanel;
    private Texture pokeballPanel;
    private Texture potionPanel;
    private Texture holdItemPanel;
    private Texture tmPanel;

    private Texture leftArrow;
    private Texture rightArrow;
    private Texture upArrow;
    private Texture downArrow;
    private Texture useButton;
    private Texture giveButton;
    private Texture xButton;

    private Texture itemNamePanel;
    private Texture selectedItemNamePanel;
    private BitmapFont font;

    private Texture itemIcon;

    private ItemTab currentBag;

    private int currentIndex;
    private int scrollAmount;
    private Sound clickSound;

    private boolean cameFromMenu;

    private boolean displayPokemonPanel;

    //Pokemon Part
    private Texture pokemonSelectPanel;
    private Texture pokemonPanel;
    //Pokemon Icon Textures
    private List<Texture> iconTextures;
    private BitmapFont smallFont; //Pokemon panel font
    private Texture healthBorder; //for pokemon select screen
    private Texture pokeSelectGreenHealth;
    private String panelText;

    //Evolution Variables
    List<Pokemon> preEvolution;
    List<Pokemon> evolvedPokemon;
    List<Integer> evolutionIndex;

    private boolean waitEvolutionClick;
    private boolean waitNoEffectClick;
    private boolean waitFinishedUseClick;

    public BagState(GameStateManager gsm, boolean cameFromMenu) {
        this.gsm = gsm;
        initTextures();

        currentBag = ItemTab.POKEBALL;
        currentIndex = -1;
        if (gsm.getBag().getPokeballBag().size() > 0) {
            currentIndex = 0;
            setItemIconTexture();
        }
        scrollAmount = 0;
        font = new BitmapFont(Gdx.files.internal("battle/font/regularFont.fnt"));
        clickSound = Gdx.audio.newSound(Gdx.files.internal("sounds/click.wav"));
        font.setColor(Color.WHITE);
        this.cameFromMenu = cameFromMenu;
        displayPokemonPanel = false;
        panelText = "";
        waitEvolutionClick = false;
        waitNoEffectClick = false;
        waitFinishedUseClick = false;
    }

    private void initTextures() {
        topBackground = new Texture("bag/gui/toppanel.png");
        evolutionPanel = new Texture("bag/gui/evolutionpanel.png");
        berryPanel = new Texture("bag/gui/berrypanel.png");
        pokeballPanel = new Texture("bag/gui/pokeballpanel.png");
        potionPanel = new Texture("bag/gui/potionpanel.png");
        holdItemPanel = new Texture("bag/gui/holditempanel.png");
        tmPanel = new Texture("bag/gui/tmpanel.png");
        leftArrow = new Texture("bag/gui/leftarrow.png");
        rightArrow = new Texture("bag/gui/rightarrow.png");
        upArrow = new Texture("bag/gui/uparrow.png");
        downArrow = new Texture("bag/gui/downarrow.png");
        useButton = new Texture("bag/gui/usebutton.png");
        giveButton = new Texture("bag/gui/givebutton.png");
        xButton = new Texture("bag/gui/backx.png");

        itemNamePanel = new Texture("bag/gui/namepanel.png");
        selectedItemNamePanel = new Texture("bag/gui/selectednamepanel.png");

        pokemonSelectPanel = new Texture("bag/gui/pokemonpanel.png");
        pokemonPanel = new Texture("battle/pokemonSelect/pokemonPanel.png");
        smallFont = new BitmapFont(Gdx.files.internal("battle/textFont.fnt"));
        healthBorder = new Texture("battle/pokemonSelect/healthBorder.png");
        pokeSelectGreenHealth = new Texture("battle/pokemonSelect/greenHealth.png");
        iconTextures = new ArrayList<Texture>();
        for (Pokemon p: gsm.getParty()) {
            iconTextures.add(new Texture(p.getMiniIconPath()));
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(topBackground, 0, 1057);
        drawBottomBackground(batch);
        batch.draw(xButton, 964, 15);
        batch.draw(leftArrow, 17, 19);
        batch.draw(rightArrow, 567, 19);
        batch.draw(downArrow, 799, 238);
        batch.draw(upArrow, 799, 960);


        drawUseGiveButtons(batch);
        /*batch.draw(useButton, 507, 1779);
        batch.draw(giveButton, 792, 1779);*/

        drawItemPanels(batch);

        drawSelectedItem(batch);
        if (displayPokemonPanel) {
            batch.draw(pokemonSelectPanel, 0,0);
            font.draw(batch, panelText, 20, 1030);
            drawPokemonPanels(batch);
            drawPokemonIcons(batch);
        }
    }

    private void drawUseGiveButtons(SpriteBatch batch) {
        if (currentIndex != -1) {
            if (currentBag == ItemTab.EVOLUTION_STONE) {
                batch.draw(useButton, 792, 1779);
            } else if (currentBag == ItemTab.POTION) {
                batch.draw(useButton, 792, 1779);
            }
        }
    }

    private void drawSelectedItem(SpriteBatch batch) {
        if (currentIndex != -1) {
            batch.draw(itemIcon, 500, 1485, 80, 80);
            if (currentBag == ItemTab.POKEBALL) {
                font.draw(batch, gsm.getBag().getPokeballBag().get(currentIndex).getName(), 525 - (
                        10 * gsm.getBag().getPokeballBag().get(currentIndex).getName().length()), 1650);
                font.draw(batch, "x " + gsm.getBag().getPokeballBag().get(currentIndex).getQuantity(), 693, 1554);
                font.draw(batch, formatDescription(gsm.getBag().getPokeballBag().get(currentIndex).getDescription()), 30, 1428);
            } else if (currentBag == ItemTab.EVOLUTION_STONE) {
                font.draw(batch, gsm.getBag().getStoneBag().get(currentIndex).getItem().getName(), 525 - (
                        10 * gsm.getBag().getStoneBag().get(currentIndex).getItem().getName().length()), 1650);
                font.draw(batch, "x " + gsm.getBag().getStoneBag().get(currentIndex).getQuantity(), 693, 1554);
                font.draw(batch, formatDescription(gsm.getBag().getStoneBag().get(currentIndex).getItem().getDescription()), 30, 1428);
            } else if (currentBag == ItemTab.POTION) {
                font.draw(batch, gsm.getBag().getUsables().get(currentIndex).getItem().getName(), 525 - (
                        10 * gsm.getBag().getUsables().get(currentIndex).getItem().getName().length()), 1650);
                font.draw(batch, "x " + gsm.getBag().getUsables().get(currentIndex).getQuantity(), 693, 1554);
                font.draw(batch, formatDescription(gsm.getBag().getUsables().get(currentIndex).getItem().getDescription()), 30, 1428);
            }
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
            if ((lineCurrentValue + 1 + getWordLengthValue(splitDescription[i])) <= 45.0) {
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

    private void drawItemPanels(SpriteBatch batch) {
        if (currentBag == ItemTab.POKEBALL) {
            drawPokeballPanels(batch);
        } else if (currentBag == ItemTab.EVOLUTION_STONE) {
            drawEvolutionStonePanels(batch);
        } else if (currentBag == ItemTab.POTION) {
            drawUsablePanels(batch);
        }
    }

    private void drawPokeballPanels(SpriteBatch batch) {
        for (int i = 0; i < 6; i++) {
            drawPokeballPanel(batch, i);
        }
    }

    private void drawEvolutionStonePanels(SpriteBatch batch) {
        for (int i = 0; i < 6; i++) {
            drawEvolutionPanel(batch, i);
        }
    }

    private void drawUsablePanels(SpriteBatch batch) {
        for (int i = 0; i < 6; i++) {
            drawUsablePanel(batch, i);
        }
    }

    private void drawEvolutionPanel(SpriteBatch batch, int panelNum) {
        if (gsm.getBag().getStoneBag().size() > panelNum) {
            if (currentIndex == scrollAmount + panelNum) {
                batch.draw(selectedItemNamePanel,627, 821 - (92 * panelNum));
            } else {
                batch.draw(itemNamePanel, 627, 821 - (92 * panelNum));
            }
            font.draw(batch, gsm.getBag().getStoneBag().get(scrollAmount + panelNum).getItem().getName(), 708, 885 - (92 * panelNum));
        }
    }

    private void drawPokeballPanel(SpriteBatch batch, int panelNum) {
        if (gsm.getBag().getPokeballBag().size() > panelNum) {
            if (currentIndex == scrollAmount + panelNum) {
                batch.draw(selectedItemNamePanel,627, 821 - (92 * panelNum));
            } else {
                batch.draw(itemNamePanel, 627, 821 - (92 * panelNum));
            }

            font.draw(batch, gsm.getBag().getPokeballBag().get(scrollAmount + panelNum).getName(), 708, 885 - (92 * panelNum));
        }
    }

    private void drawUsablePanel(SpriteBatch batch, int panelNum) {
        if (gsm.getBag().getUsables().size() > panelNum) {
            if (currentIndex == scrollAmount + panelNum) {
                batch.draw(selectedItemNamePanel, 627, 821 - (92 * panelNum));
            } else {
                batch.draw(itemNamePanel, 627, 821 - (92 * panelNum));
            }

            font.draw(batch, gsm.getBag().getUsables().get(scrollAmount + panelNum).getItem().getName(), 708, 885 - (92 * panelNum));
        }
    }


    private void drawBottomBackground(SpriteBatch batch) {
        if (currentBag == ItemTab.POKEBALL) {
            batch.draw(pokeballPanel, 0,0);
        } else if (currentBag == ItemTab.EVOLUTION_STONE) {
            batch.draw(evolutionPanel, 0, 0);
        } else if (currentBag == ItemTab.BERRY) {
            batch.draw(berryPanel, 0, 0);
        } else if (currentBag == ItemTab.POTION) {
            batch.draw(potionPanel, 0, 0);
        } else if (currentBag == ItemTab.TM) {
            batch.draw(tmPanel, 0, 0);
        } else if (currentBag == ItemTab.HOLD_ITEM) {
            batch.draw(holdItemPanel, 0, 0);
        }
    }

    private void drawPokemonIcons(SpriteBatch batch) {
        for (int i = 0; i < iconTextures.size(); i++) {
            int xPos;
            int yPos;
            if (i == 0 || i == 2 || i == 4) {
                xPos = 124;
                if (i == 0) {
                    yPos = 653;
                } else if (i == 2) {
                    yPos = 431;
                } else {
                    yPos = 203;
                }
            } else {
                xPos =  582;
                if (i == 1) {
                    yPos = 559;
                } else if (i == 3) {
                    yPos = 337;
                } else {
                    yPos = 104;
                }

            }
            batch.draw(iconTextures.get(i),
                    xPos, yPos, 128, 128);
        }
    }
    private void drawPokemonPanels(SpriteBatch batch) {
        batch.draw(pokemonPanel, 30, 577);
        batch.draw(healthBorder, 146, 620);
        batch.draw(pokeSelectGreenHealth, 147, 621, (int)(318 *
                (1.0 * gsm.getParty().get(0).getCurrentHealth() / gsm.getParty().get(0).getHealthStat())), 25);
        smallFont.draw(batch, gsm.getParty().get(0).getName() + "\nLv. " +
                gsm.getParty().get(0).getLevel(), 239, 748);
        if (gsm.getParty().size() > 1) {
            batch.draw(pokemonPanel, 490, 477);
            batch.draw(healthBorder, 600, 524);
            batch.draw(pokeSelectGreenHealth, 601, 525,(int)(318 *
                    (1.0 * gsm.getParty().get(1).getCurrentHealth() / gsm.getParty().get(1).getHealthStat())), 25);
            smallFont.draw(batch, gsm.getParty().get(1).getName() + "\nLv. " +
                    gsm.getParty().get(1).getLevel(), 700, 648);
            if (gsm.getParty().size() > 2) {
                batch.draw(pokemonPanel, 30, 352);
                batch.draw(healthBorder, 146, 393);
                batch.draw(pokeSelectGreenHealth, 147, 394,(int)(318 *
                        (1.0 * gsm.getParty().get(2).getCurrentHealth() / gsm.getParty().get(2).getHealthStat())), 25);
                smallFont.draw(batch, gsm.getParty().get(2).getName() + "\nLv. " +
                        gsm.getParty().get(2).getLevel(), 239, 523);
                if (gsm.getParty().size() > 3) {
                    batch.draw(pokemonPanel, 490, 252);
                    batch.draw(healthBorder, 600, 295);
                    batch.draw(pokeSelectGreenHealth, 601, 296,(int)(318 *
                            (1.0 * gsm.getParty().get(3).getCurrentHealth() / gsm.getParty().get(3).getHealthStat())), 25);
                    smallFont.draw(batch, gsm.getParty().get(3).getName() + "\nLv. " +
                            gsm.getParty().get(3).getLevel(), 700, 423);
                    if (gsm.getParty().size() > 4) {
                        batch.draw(pokemonPanel, 30, 127);
                        batch.draw(healthBorder, 146, 165);
                        batch.draw(pokeSelectGreenHealth, 147, 166,(int)(318 *
                                (1.0 * gsm.getParty().get(4).getCurrentHealth() / gsm.getParty().get(4).getHealthStat())), 25);
                        smallFont.draw(batch, gsm.getParty().get(4).getName() + "\nLv. " +
                                gsm.getParty().get(4).getLevel(), 239, 298);
                        if (gsm.getParty().size() > 5) {
                            batch.draw(pokemonPanel, 490, 27);
                            batch.draw(healthBorder, 600, 69);
                            batch.draw(pokeSelectGreenHealth, 601, 70, (int)(318 *
                                    (1.0 * gsm.getParty().get(5).getCurrentHealth() / gsm.getParty().get(5).getHealthStat())), 25);
                            smallFont.draw(batch, gsm.getParty().get(5).getName() + "\nLv. " +
                                    gsm.getParty().get(5).getLevel(), 700, 198);
                        }
                    }
                }
            }
        }
    }

    private void clickedTopRight() {
        if (currentIndex != -1) {
            //DISPLAY PARTY.
            if (currentBag == ItemTab.EVOLUTION_STONE) {
                displayPokemonPanel = true;
                panelText = "Select a Pokemon to use the " +
                        gsm.getBag().getStoneBag().get(currentIndex)
                                .getItem().getName() + " on.";
            } else if (currentBag == ItemTab.POTION) {
                displayPokemonPanel = true;
                panelText = "Select a Pokemon to use the " +
                        gsm.getBag().getUsables().get(currentIndex)
                                .getItem().getName() + " on.";
            }
        }
    }

    private void clickedPokemon(int pokemonIndex) {
        if (currentBag == ItemTab.POTION) {
            if (gsm.getBag().getUsables().get(currentIndex)
                    .getItem().ableToUse(gsm.getParty().get(pokemonIndex))) {
                gsm.getBag().getUsables().get(currentIndex)
                        .getItem().use(gsm.getParty().get(pokemonIndex));
                panelText = "You used the item!!";
                gsm.getBag().getUsables().get(currentIndex).discard();
                if (gsm.getBag().getUsables().size() > 1) {
                    gsm.getBag().getUsables().remove(currentIndex);
                    if (currentIndex != 0) {
                        currentIndex--;
                    } else {
                        currentIndex = -1;
                    }
                } else {
                    gsm.getBag().getUsables().remove(currentIndex);
                    currentIndex = -1;
                }
                waitFinishedUseClick = true;
            } else {
                panelText = "The " + gsm.getBag().getUsables()
                        .get(currentIndex).getItem().getName() + " has no effect.";
                waitNoEffectClick = true;
            }
        } else if (currentBag == ItemTab.EVOLUTION_STONE) {
            if (gsm.getBag().getStoneBag().get(currentIndex)
                    .getItem().ableToUse(gsm.getParty().get(pokemonIndex))) {
                panelText = "What? " + gsm.getParty().get(pokemonIndex).getName() + " is evolving!";
                gsm.getBag().getStoneBag().get(currentIndex).discard();
                waitEvolutionClick = true;
                preEvolution = new ArrayList<Pokemon>();
                evolvedPokemon = new ArrayList<Pokemon>();
                PokemonFactory pf = new PokemonFactory();
                Pokemon temp = pf.createPokemon(gsm.getBag().getStoneBag()
                        .get(currentIndex).getItem().getEvolutionId(gsm.getParty()
                                .get(pokemonIndex)), gsm.getParty().get(pokemonIndex));
                preEvolution.add(gsm.getParty().get(pokemonIndex));
                evolvedPokemon.add(temp);
                evolutionIndex = new ArrayList<Integer>();
                evolutionIndex.add(pokemonIndex);
                gsm.getParty().set(pokemonIndex, temp);
                //Check if there are any more stones after using this one.
                if (gsm.getBag().getStoneBag().get(currentIndex).getQuantity() == 0) {
                    if (hasExtraStone()) {
                        gsm.getBag().getStoneBag().remove(currentIndex);
                        if (currentIndex != 0) {
                            currentIndex--;
                        } else {
                            currentIndex = -1;
                        }
                    } else {
                        gsm.getBag().getStoneBag().remove(currentIndex);
                        currentIndex = -1;
                    }
                }
            } else {
                panelText = "The " + gsm.getBag().getStoneBag()
                        .get(currentIndex).getItem().getName() + " has no effect.";
                waitNoEffectClick = true;
            }
        }
    }

    private boolean hasExtraStone() {
        if (gsm.getBag().getStoneBag().size() > 1) {
            return true;
        }
        return false;
    }


    @Override
    public void update(double dt) {
        if (MyInput.clicked()) {
            int x = MyInput.getX();
            int y = MyInput.getY();
            Gdx.app.log("bagcoord", x + ", " + y);
            if (waitEvolutionClick) {
                waitEvolutionClick = false;
                gsm.stopBgm();
                gsm.setState(new EvolutionState(gsm, preEvolution, evolvedPokemon, evolutionIndex, cameFromMenu));
                dispose();
            } else if (waitNoEffectClick) {
                waitNoEffectClick = false;
                if (currentBag == ItemTab.EVOLUTION_STONE) {
                    panelText = "Select a Pokemon to use the " +
                            gsm.getBag().getStoneBag().get(currentIndex)
                                    .getItem().getName() + " on.";
                } else if (currentBag == ItemTab.POTION) {
                    panelText = "Select a Pokemon to use the " +
                            gsm.getBag().getUsables().get(currentIndex)
                                    .getItem().getName() + " on.";
                }

            } else if (waitFinishedUseClick) {
                waitFinishedUseClick = false;
                displayPokemonPanel = false;
            }
            else if (x >= 0 && x <= 161 && y >= 1792 && y <= 1920 && !displayPokemonPanel) {
                clickedLeft();
            } else if (x >= 519 && x <= 680 && y >= 1792 && y <= 1920 && !displayPokemonPanel) {
                clickedRight();
            } else if (x >= 885 && x <= 1080 && y >= 1835 && y <= 1920 && !displayPokemonPanel) {
                clickedX();
            } else if (x >= 734 && x <= 902 && y >= 1625 && y <= 1690 && !displayPokemonPanel) {
                clickedDown();
            } else if (x >= 734 && x <= 902 && y >= 869 && y <= 948 && !displayPokemonPanel) {
                clickedUp();
            } else if (x >= 760 && x <= 1080 && y >= 0 && y <= 165 && !displayPokemonPanel) {
                //Clicked top right button.
                clickedTopRight();
            } else if (x >= 0 && x <= 147 && y >= 1786 && y <= 1920 && displayPokemonPanel) {
                displayPokemonPanel = false;
            } else if (x >= 88 && x <= 411 && y >= 1186 && y <= 1302 && displayPokemonPanel) {
                //First Pokemon
                clickedPokemon(0);
            } else if (x >= 594 && x <= 916 && y >= 1268 && y <= 1431 && displayPokemonPanel && gsm.getParty().size() > 1) {
                //Second Pokemon
                clickedPokemon(1);
            } else if (x >= 88 && x <= 411 && y >= 1422 && y <= 1554 && displayPokemonPanel && gsm.getParty().size() > 2) {
                //Third Pokemon
                clickedPokemon(2);
            } else if (x >= 594 && x <= 916 && y >= 1498 && y <= 1662 && displayPokemonPanel && gsm.getParty().size() > 3) {
                //Fourth Pokemon
                clickedPokemon(3);
            } else if (x >= 88 && x <= 411 && y >= 1662 && y <= 1823 && displayPokemonPanel && gsm.getParty().size() > 4) {
                //Fifth Pokemon
                clickedPokemon(4);
            } else if (x >= 594 && x <= 916 && y >= 1749 && y <= 1907 && displayPokemonPanel && gsm.getParty().size() > 5) {
                //Sixth Pokemon
                clickedPokemon(5);
            }
        }
    }


    private void setNewBag(ItemTab newBag) {
        currentBag = newBag;
        resetScrollAndSelectedItem();
        clickSound.play();
    }

    private void resetScrollAndSelectedItem() {
        scrollAmount = 0;
        currentIndex = -1;
    }

    private void clickedLeft() {
        if (currentBag == ItemTab.POKEBALL) {
            setNewBag(ItemTab.POTION);
            if (gsm.getBag().getUsables().size() > 0) {
                currentIndex = 0;
                setItemIconTexture();
            }
        } else if (currentBag == ItemTab.POTION) {
            setNewBag(ItemTab.TM);
        } else if (currentBag == ItemTab.TM) {
            setNewBag(ItemTab.BERRY);
        } else if (currentBag == ItemTab.BERRY) {
            setNewBag(ItemTab.HOLD_ITEM);
        } else if (currentBag == ItemTab.HOLD_ITEM) {
            setNewBag(ItemTab.EVOLUTION_STONE);
            if (gsm.getBag().getStoneBag().size() > 0) {
                currentIndex = 0;
                setItemIconTexture();
            }
        } else if (currentBag == ItemTab.EVOLUTION_STONE) {
            setNewBag(ItemTab.POKEBALL);
            if (gsm.getBag().getPokeballBag().size() > 0) {
                currentIndex = 0;
                setItemIconTexture();
            }
        }
    }

    private void clickedRight() {
        if (currentBag == ItemTab.POKEBALL) {
            setNewBag(ItemTab.EVOLUTION_STONE);
            if (gsm.getBag().getStoneBag().size() > 0) {
                currentIndex = 0;
                setItemIconTexture();
            }
        } else if (currentBag == ItemTab.POTION) {
            setNewBag(ItemTab.POKEBALL);
            if (gsm.getBag().getPokeballBag().size() > 0) {
                currentIndex = 0;
                setItemIconTexture();
            }
        } else if (currentBag == ItemTab.TM) {
            setNewBag(ItemTab.POTION);
            if (gsm.getBag().getUsables().size() > 0) {
                currentIndex = 0;
                setItemIconTexture();
            }
        } else if (currentBag == ItemTab.BERRY) {
            setNewBag(ItemTab.TM);
        } else if (currentBag == ItemTab.HOLD_ITEM) {
            setNewBag(ItemTab.BERRY);
        } else if (currentBag == ItemTab.EVOLUTION_STONE) {
            setNewBag(ItemTab.HOLD_ITEM);
        }
    }

    private void clickedDown() {

        if (bagHasItem(currentIndex + 1)) {
            if (currentIndex >= 5) {
                scrollAmount++;
            }
            currentIndex++;
            setItemIconTexture();
            clickSound.play();
        }
    }

    private void clickedUp() {
        if (scrollAmount > 0) {
            scrollAmount--;
        }
        if (currentIndex > 0) {
            currentIndex--;
            setItemIconTexture();
            clickSound.play();
        }
    }

    private void clickedX() {
        if (cameFromMenu) {
            gsm.setState(new LoadingState(gsm, LoadingState.POKENAV_MENU));
        } else {
            gsm.setState(new PokeMartState(gsm));
        }
        dispose();
    }

    private boolean bagHasItem(int index) {
            if (currentBag == ItemTab.POKEBALL) {
                if (index < gsm.getBag().getPokeballBag().size()) {
                    return true;
                }
                return false;
            } else if (currentBag == ItemTab.EVOLUTION_STONE) {
                if (index < gsm.getBag().getStoneBag().size()) {
                    return true;
                }
                return false;
            } else if (currentBag == ItemTab.POTION) {
                if (index < gsm.getBag().getUsables().size()) {
                    return true;
                }
                return false;
            }
            return false;
    }

    private void setItemIconTexture() {
        if (itemIcon != null) {
            itemIcon.dispose();
        }
        if (currentBag == ItemTab.POKEBALL) {
            itemIcon = new Texture(gsm.getBag().getPokeballBag().get(currentIndex).getImage());
        } else if (currentBag == ItemTab.EVOLUTION_STONE) {
            itemIcon = new Texture(gsm.getBag().getStoneBag().get(currentIndex).getItem().getImage());
        } else if (currentBag == ItemTab.POTION) {
            itemIcon = new Texture(gsm.getBag().getUsables().get(currentIndex).getItem().getImage());
        }
    }
    private void clickedFirstItem() {
        if (bagHasItem(scrollAmount * 6)) {
            clickSound.play();
            currentIndex = scrollAmount * 6;
            setItemIconTexture();
        }
    }

    private void clickedSecondItem() {
        if (bagHasItem(scrollAmount * 6 + 1)) {
            clickSound.play();
            currentIndex = scrollAmount * 6 + 1;
            setItemIconTexture();
        }
    }

    private void clickedThirdItem() {
        if (bagHasItem(scrollAmount * 6 + 2)) {
            clickSound.play();
            currentIndex = scrollAmount * 6 + 2;
            setItemIconTexture();
        }
    }

    private void clickedFourthItem() {
        if (bagHasItem(scrollAmount * 6 + 3)) {
            clickSound.play();
            currentIndex = scrollAmount * 6 + 3;
            setItemIconTexture();
        }
    }

    private void clickedFifthItem() {
        if (bagHasItem(scrollAmount * 6 + 4)) {
            clickSound.play();
            currentIndex = scrollAmount * 6 + 4;
            setItemIconTexture();
        }
    }

    private void clickedSixthItem() {
        if (bagHasItem(scrollAmount * 6 + 5)) {
            clickSound.play();
            currentIndex = scrollAmount * 6 + 5;
            setItemIconTexture();
        }
    }

    @Override
    protected void dispose() {
        topBackground.dispose();
        evolutionPanel.dispose();
        berryPanel.dispose();
        pokeballPanel.dispose();
        potionPanel.dispose();
        holdItemPanel.dispose();
        tmPanel.dispose();

        leftArrow.dispose();
        rightArrow.dispose();
        upArrow.dispose();
        downArrow.dispose();
        useButton.dispose();
        giveButton.dispose();
        xButton.dispose();

        selectedItemNamePanel.dispose();
        itemNamePanel.dispose();
        if (itemIcon != null) {
            itemIcon.dispose();
        }
        font.dispose();
        clickSound.dispose();
        //Pokemon Part
        pokemonSelectPanel.dispose();
        pokemonPanel.dispose();
        //Pokemon Icon Textures
        for (Texture t: iconTextures) {
            t.dispose();
        }
        smallFont.dispose();
        healthBorder.dispose();
        pokeSelectGreenHealth.dispose();
    }
}
