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
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemId;
import com.pokemon.toronto.game.com.pokemon.toronto.pokemart.ItemTab;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;

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

    private Texture overrideMovePanel;
    private Texture litSkillPanel; //474 118
    private Texture skillPanel;
    private Texture firstSkillIcon;
    private Texture firstSkillType;
    private Texture secondSkillIcon;
    private Texture secondSkillType;
    private Texture thirdSkillIcon;
    private Texture thirdSkillType;
    private Texture fourthSkillIcon;
    private Texture fourthSkillType;
    private Texture newSkillIcon;
    private Texture newSkillType;

    private Texture tmSkillType;
    private Texture tmSkillCategory;
    private int tmPower;
    private int tmPP;
    private int tmAccuracy;

    private int selectedSkill;
    private Texture selectedPokemonImage;
    private int selectedSkillPower;
    private int selectedSkillAccuracy;
    private String selectedSkillDescription;
    private BitmapFont regularFont;
    private Texture selectedSkillCategory;
    private Texture selectedPokemonTypeOne;
    private Texture selectedPokemonTypeTwo;
    


    private Texture itemNamePanel;
    private Texture selectedItemNamePanel;
    private Texture yesNo;
    private BitmapFont font;

    private Texture itemIcon;

    private ItemTab currentBag;

    private int currentIndex;
    private int scrollAmount;
    private Sound clickSound;

    private boolean cameFromMenu;

    private boolean displayPokemonPanel;
    private boolean checkMovesAfterReplacing; //Check if the pokemon learns more moves after overriding.

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

    //Rare Candy variables
    private List<Integer> newSkillsForLevelUp;
    private Skill newMove;
    private int pokemonIndex;

    private boolean waitEvolutionClick;
    private boolean waitNoEffectClick;
    private boolean waitFinishedUseClick;
    private boolean learnedNewMove;
    private boolean displayingMoveYesNo;
    private boolean displayOverrideMove;

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
        learnedNewMove = false;
        displayingMoveYesNo = false;
        displayOverrideMove = false;
        selectedSkill = -1; //No skill is selected yet.
        selectedSkillAccuracy = 0;
        selectedSkillPower = 0;
        checkMovesAfterReplacing = false;

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
        yesNo = new Texture("battle/yesno.png");

        itemNamePanel = new Texture("bag/gui/namepanel.png");
        selectedItemNamePanel = new Texture("bag/gui/selectednamepanel.png");
        overrideMovePanel = new Texture("bag/gui/newmovepanel.png");
        pokemonSelectPanel = new Texture("bag/gui/pokemonpanel.png");
        pokemonPanel = new Texture("battle/pokemonSelect/pokemonPanel.png");
        smallFont = new BitmapFont(Gdx.files.internal("battle/textFont.fnt"));
        healthBorder = new Texture("battle/pokemonSelect/healthBorder.png");
        pokeSelectGreenHealth = new Texture("battle/pokemonSelect/greenHealth.png");
        iconTextures = new ArrayList<Texture>();
        for (Pokemon p: gsm.getParty()) {
            iconTextures.add(new Texture(p.getMiniIconPath()));
        }

        litSkillPanel = new Texture("bag/gui/skill/litpanel.png"); //474 118
        skillPanel = new Texture("bag/gui/skill/normalpanel.png");
        firstSkillIcon = new Texture("bag/gui/skill/firstskill.png");
        secondSkillIcon = new Texture("bag/gui/skill/secondskill.png");
        thirdSkillIcon = new Texture("bag/gui/skill/thirdskill.png");
        fourthSkillIcon = new Texture("bag/gui/skill/fourthskill.png");
        newSkillIcon = new Texture("bag/gui/skill/noskills.png");
        regularFont = new BitmapFont(Gdx.files.internal("battle/font/regularFont.fnt"));
        regularFont.setColor(Color.WHITE);
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
        if (displayingMoveYesNo) {
            batch.draw(yesNo, 760, 950);
        }
        if (displayOverrideMove) {
            batch.draw(overrideMovePanel, 0, 0);
            if (selectedSkill != 0) {
                batch.draw(skillPanel, 30, 580, 564, 145);
            } else {
                batch.draw(litSkillPanel, 30, 580, 564, 145);
            }

            if (selectedSkill != 1) {
                batch.draw(skillPanel, 30, 445, 564, 145);
            } else {
                batch.draw(litSkillPanel, 30, 445, 564, 145);
            }
            if (selectedSkill != 2) {
                batch.draw(skillPanel, 30, 310, 564, 145);
            } else {
                batch.draw(litSkillPanel, 30, 310, 564, 145);
            }
            if (selectedSkill != 3) {
                batch.draw(skillPanel, 30, 175, 564, 145);
            } else {
                batch.draw(litSkillPanel, 30, 175, 564, 145);
            }
            regularFont.setColor(Color.WHITE);
            batch.draw(litSkillPanel, 30, 10, 564, 145);
            if (selectedSkill == -1) {
                batch.draw(newSkillType, 85, 90, 125, 46);
                batch.draw(newSkillIcon, 104, 40, 77, 39);

                regularFont.draw(batch, newMove.getName(), 215, 135);
                regularFont.draw(batch, "PP", 255, 70);
                regularFont.draw(batch, Integer.toString(newMove.getMaxPP()), 365, 70);
                regularFont.draw(batch, "/", 415, 70);
                regularFont.draw(batch, Integer.toString(newMove.getMaxPP()), 440, 70);
            } else {
                regularFont.draw(batch, "FORGET", 215, 105);
            }

            batch.draw(firstSkillIcon, 104, 610, 77, 39);
            batch.draw(secondSkillIcon, 104, 475, 77, 39);
            batch.draw(thirdSkillIcon, 104, 340, 77, 39);
            batch.draw(fourthSkillIcon, 104, 205, 77, 39);

            batch.draw(firstSkillType, 85, 660, 125, 46);
            batch.draw(secondSkillType, 85, 525, 125, 46);
            batch.draw(thirdSkillType, 85, 390, 125, 46);
            batch.draw(fourthSkillType, 85, 255, 125, 46);

            batch.draw(selectedPokemonImage, 670, 280, 394, 394);
            if (gsm.getParty().get(pokemonIndex).getTypeTwo() != Pokemon.Type.NONE) {
                //Draw both type textures next to each other.
                batch.draw(selectedPokemonTypeOne, 740, 290, 125, 46);
                batch.draw(selectedPokemonTypeTwo, 895, 290, 125, 46);

            } else {
                //Draw the single texture in the center
                batch.draw(selectedPokemonTypeOne, 810, 290, 125, 46);
            }


            regularFont.draw(batch, gsm.getParty().get(pokemonIndex)
                    .getFirstSkill().getName(), 215, 705);
            regularFont.draw(batch, gsm.getParty().get(pokemonIndex)
                    .getSecondSkill().getName(), 215, 570);
            regularFont.draw(batch, gsm.getParty().get(pokemonIndex)
                    .getThirdSkill().getName(), 215, 435);
            regularFont.draw(batch, gsm.getParty().get(pokemonIndex)
                    .getFourthSkill().getName(), 215, 300);

            regularFont.draw(batch, "PP", 255, 645);
            regularFont.draw(batch, "PP", 255, 510);
            regularFont.draw(batch, "PP", 255, 375);
            regularFont.draw(batch, "PP", 255, 240);

            regularFont.draw(batch, Integer.toString(gsm.getParty().get(pokemonIndex)
                    .getFirstSkill().getCurrentPP()), 365, 645);
            regularFont.draw(batch, Integer.toString(gsm.getParty().get(pokemonIndex)
                    .getSecondSkill().getCurrentPP()), 365, 510);
            regularFont.draw(batch, Integer.toString(gsm.getParty().get(pokemonIndex)
                    .getThirdSkill().getCurrentPP()), 365, 375);
            regularFont.draw(batch, Integer.toString(gsm.getParty().get(pokemonIndex)
                    .getFourthSkill().getCurrentPP()), 365, 240);

            regularFont.draw(batch, "/", 415, 645);
            regularFont.draw(batch, "/", 415, 510);
            regularFont.draw(batch, "/", 415, 375);
            regularFont.draw(batch, "/", 415, 240);

            regularFont.draw(batch, Integer.toString(gsm.getParty().get(pokemonIndex)
                    .getFirstSkill().getMaxPP()), 440, 645);
            regularFont.draw(batch, Integer.toString(gsm.getParty().get(pokemonIndex)
                    .getSecondSkill().getMaxPP()), 440, 510);
            regularFont.draw(batch, Integer.toString(gsm.getParty().get(pokemonIndex)
                    .getThirdSkill().getMaxPP()), 440, 375);
            regularFont.draw(batch, Integer.toString(gsm.getParty().get(pokemonIndex)
                    .getFourthSkill().getMaxPP()), 440, 240);

            regularFont.setColor(Color.BLACK);

            //TODO: Equipped item name
            regularFont.draw(batch, "None", 690, 160);

            regularFont.draw(batch, Integer.toString(gsm.getParty().get(pokemonIndex).getLevel()),
                    750,725);

            regularFont.draw(batch, gsm.getParty().get(pokemonIndex).getName(), 680, 790);

            batch.draw(selectedSkillCategory, 730, 1550, 125, 46);
            //Draw Accuracy
            if (selectedSkillAccuracy <= 0 || selectedSkillAccuracy > 100) {
                regularFont.draw(batch, "--", 770, 1460);
            } else {
                regularFont.draw(batch, Integer.toString(selectedSkillAccuracy), 770, 1460);
            }
            //Draw Power
            if (selectedSkillPower <= 0) {
                regularFont.draw(batch, "--", 770, 1525);
            } else {
                regularFont.draw(batch, Integer.toString(selectedSkillPower), 770, 1525);
            }
            regularFont.draw(batch, formatDescription(selectedSkillDescription), 20, 1355);


        }
    }

    private void drawUseGiveButtons(SpriteBatch batch) {
        if (currentIndex != -1) {
            if (currentBag == ItemTab.EVOLUTION_STONE) {
                batch.draw(useButton, 792, 1779);
            } else if (currentBag == ItemTab.POTION) {
                batch.draw(useButton, 792, 1779);
            } else if (currentBag == ItemTab.TM) {
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
            } else if (currentBag == ItemTab.TM) {
                font.draw(batch, gsm.getBag().getTMBag().get(currentIndex).getItem().getName(), 525 - (
                        10 * gsm.getBag().getTMBag().get(currentIndex).getItem().getName().length()), 1650);
                font.draw(batch, "x " + gsm.getBag().getTMBag().get(currentIndex).getQuantity(), 693, 1554);
                font.draw(batch, formatDescription(gsm.getBag().getTMBag().get(currentIndex).getItem().getDescription()), 30, 1428);
                //Draw the skill type, pp, damage etc
                font.draw(batch, "TYPE\nCATEGORY", 30, 1228);
                font.draw(batch, "POWER\nACCURACY", 440, 1228);
                font.draw(batch, "PP", 830, 1228);
                batch.draw(tmSkillType, 270, 1180,125, 46);
                batch.draw(tmSkillCategory, 270, 1130,125, 46);
                if (tmPower <= 0) {
                    font.draw(batch, "--", 700, 1228);
                } else {
                    font.draw(batch, Integer.toString(tmPower), 700, 1228);
                }
                if (tmAccuracy <= 0 || tmAccuracy > 100) {
                    font.draw(batch, "--", 700, 1170);
                } else {
                    font.draw(batch, Integer.toString(tmAccuracy), 700, 1170);
                }
                font.draw(batch, Integer.toString(tmPP), 920, 1228);
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
        } else if (currentBag == ItemTab.TM) {
            drawTMPanels(batch);
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

    private void drawTMPanels(SpriteBatch batch) {
        for (int i = 0; i < 6; i++) {
            drawTMPanel(batch, i);
        }
    }

    private void drawTMPanel(SpriteBatch batch, int panelNum) {
        if (gsm.getBag().getTMBag().size() > panelNum) {
            if (currentIndex == scrollAmount + panelNum) {
                batch.draw(selectedItemNamePanel,627, 821 - (92 * panelNum));
            } else {
                batch.draw(itemNamePanel, 627, 821 - (92 * panelNum));
            }
            font.draw(batch, gsm.getBag().getTMBag().get(scrollAmount + panelNum).getItem().getName(), 708, 885 - (92 * panelNum));
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
            } else if (currentBag == ItemTab.TM) {
                displayPokemonPanel = true;
                panelText = "Teach " +
                        gsm.getBag().getTMBag().get(currentIndex)
                                .getItem().getName() + " to a Pokemon";
            }
        }
    }

    private void declinedNewMove() {
        displayingMoveYesNo = false;
        panelText = gsm.getParty().get(pokemonIndex).getName() + " did not learn " +
                newMove.getName() + ".";
        waitFinishedUseClick = true;
        checkRemainingLevelUpSkills();
    }

    private void acceptedNewMove() {
        //display panel.
        displayingMoveYesNo = false;
        displayPokemonPanel = false;
        displayOverrideMove = true;
        firstSkillType = gsm.getParty().get(pokemonIndex).getFirstSkill().getSkillTypeTexture();
        secondSkillType = gsm.getParty().get(pokemonIndex).getSecondSkill().getSkillTypeTexture();
        thirdSkillType = gsm.getParty().get(pokemonIndex).getThirdSkill().getSkillTypeTexture();
        fourthSkillType = gsm.getParty().get(pokemonIndex).getFourthSkill().getSkillTypeTexture();
        newSkillType = newMove.getSkillTypeTexture();
        selectedPokemonImage = new Texture(gsm.getParty().get(pokemonIndex).getMapIconPath());
        selectedPokemonTypeOne = gsm.getParty().get(pokemonIndex).getTypeOneTexture();
        if (gsm.getParty().get(pokemonIndex).getTypeTwo() != Pokemon.Type.NONE) {
            selectedPokemonTypeTwo = gsm.getParty().get(pokemonIndex).getTypeTwoTexture();
        }
        setNewSkillAttributes();
        //checkRemainingLevelUpSkills();
    }

    /**
     * Set the new move descriptors when overriding a new move. The category, power, accuracy
     * and description.
     */
    private void setNewSkillAttributes() {
        selectedSkillCategory = newMove.getCategoryTexture();
        selectedSkillPower = newMove.getBaseDamage();
        selectedSkillAccuracy = newMove.getAccuracy();
        selectedSkillDescription = newMove.getDescription();
    }



    /**
     * Attempt to learn the level up skills for the Pokemon at the index pokemonIndex in the
     * party.
     */
    private void initLevelUpSkills() {
        //Check for level up skills.
        if (gsm.getParty().get(pokemonIndex).getLevelUpEvolutionId() == -1) {
            newSkillsForLevelUp = gsm.getParty()
                    .get(pokemonIndex).getCurrentLevelUpSkills();
            if (newSkillsForLevelUp != null) {
                checkRemainingLevelUpSkills();
            }
        } else {
            initEvolution();
        }
    }

    private void checkRemainingLevelUpSkills() {
        //Has level up skills.
        checkMovesAfterReplacing = false; //Reset this in case coming after overriding.
        SkillFactory sf = new SkillFactory();
        if (newSkillsForLevelUp.size() > 0) {
            newMove = sf.createSkill(newSkillsForLevelUp.get(0));
            //Remove the first move from the list of moves the pokemon learns at this level.
            newSkillsForLevelUp.remove(0);
            if (gsm.getParty().get(pokemonIndex).getSkills().size() < 4) {
                gsm.getParty().get(pokemonIndex).addMove(newMove);
                panelText = "Learned " + newMove.getName() + "!";
                learnedNewMove = true;
            } else {
                //Attempt to override move.
                panelText = gsm.getParty().get(pokemonIndex).getName() + " wants to learn " + newMove.getName() +
                        ".\nDelete a move for " + newMove.getName() + "?";
                waitFinishedUseClick = false;
                displayingMoveYesNo = true;
            }
        }
    }


    private void clickedPokemon(int pokemonIndex) {
        this.pokemonIndex = pokemonIndex;
        if (currentBag == ItemTab.POTION) {
            if (gsm.getBag().getUsables().get(currentIndex)
                    .getItem().ableToUse(gsm.getParty().get(pokemonIndex))) {
                panelText = gsm.getBag().getUsables().get(currentIndex)
                        .getItem().use(gsm.getParty().get(pokemonIndex));
                waitFinishedUseClick = true;
                if (gsm.getBag().getUsables().get(currentIndex).getItem().getId() ==
                        ItemId.RARE_CANDY) {
                    initLevelUpSkills();

                }
                gsm.getBag().getUsables().get(currentIndex).discard();
                if (gsm.getBag().getUsables().get(currentIndex).getQuantity() == 0) {
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
                }


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

    private void initEvolution() {
        waitEvolutionClick = true;
        preEvolution = new ArrayList<Pokemon>();
        evolvedPokemon = new ArrayList<Pokemon>();
        PokemonFactory pf = new PokemonFactory();
        Pokemon temp = pf.createPokemon(gsm.getParty().get(pokemonIndex).getLevelUpEvolutionId(),
                gsm.getParty().get(pokemonIndex));
        preEvolution.add(gsm.getParty().get(pokemonIndex));
        evolvedPokemon.add(temp);
        evolutionIndex = new ArrayList<Integer>();
        evolutionIndex.add(pokemonIndex);
        gsm.getParty().set(pokemonIndex, temp);
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
                Gdx.app.log("clicx", "evolution");
                waitEvolutionClick = false;
                gsm.stopBgm();
                gsm.setState(new EvolutionState(gsm, preEvolution, evolvedPokemon, evolutionIndex, cameFromMenu));
                dispose();
            } else if (waitNoEffectClick) {
                waitNoEffectClick = false;
                if (currentBag == ItemTab.EVOLUTION_STONE) {
                    if (gsm.getBag().getStoneBag().size() > 0) {
                        panelText = "Select a Pokemon to use the " +
                                gsm.getBag().getStoneBag().get(currentIndex)
                                        .getItem().getName() + " on.";
                    } else {
                        panelText = "";
                    }
                } else if (currentBag == ItemTab.POTION) {
                    if (gsm.getBag().getUsables().size() > 0) {
                        panelText = "Select a Pokemon to use the " +
                                gsm.getBag().getUsables().get(currentIndex)
                                        .getItem().getName() + " on.";
                    } else {
                        panelText = "";
                    }
                }
                if (checkMovesAfterReplacing) {
                    checkRemainingLevelUpSkills();
                }

            } else if (waitFinishedUseClick) {
                Gdx.app.log("clicx", "finished use");
                waitFinishedUseClick = false;
                if (!learnedNewMove) {
                    displayPokemonPanel = false;
                } else {
                    panelText = "Learned " + newMove.getName() + "!";
                }
            } else if (learnedNewMove) {
                Gdx.app.log("clicx", "learn new move");
                panelText = "Learned " + newMove.getName() + "!";
                //TODO: Play fanfare
                learnedNewMove = false;
                if (newSkillsForLevelUp.size() != 0) {
                    checkRemainingLevelUpSkills();
                    //displayPokemonPanel = false;
                } else {
                    //Attempt to override old skill
                    displayPokemonPanel = false;
                }
            } else if (displayingMoveYesNo) {
                Gdx.app.log("clicx", "yesno");
                 if (x >= 813 && x <= 1005 && y >= 754 && y <= 841) {
                    acceptedNewMove();
                } else if (x >= 813 && x <= 1005 && y >= 899 && y <= 994) {
                    declinedNewMove();
                }
            } else if (displayOverrideMove) {
                if (x >= 50 && x <= 576 && y >= 1213 && y <= 1328) {
                    if (selectedSkill == 0) {
                        selectedSkill = -1;
                        setNewSkillAttributes();
                    } else {
                        selectedSkill = 0;
                        selectedSkillCategory.dispose();
                        selectedSkillCategory = gsm.getParty().get(pokemonIndex).getFirstSkill()
                                .getCategoryTexture();
                        selectedSkillAccuracy = gsm.getParty().get(pokemonIndex).getFirstSkill()
                                .getAccuracy();
                        selectedSkillPower = gsm.getParty().get(pokemonIndex).getFirstSkill()
                                .getBaseDamage();
                        selectedSkillDescription = gsm.getParty().get(pokemonIndex).getFirstSkill()
                                .getDescription();
                    }
                } else if (x >= 50 && x <= 576 && y >= 1344 && y <= 1440) {
                    if (selectedSkill == 1) {
                        selectedSkill = -1;
                        setNewSkillAttributes();
                    } else {
                        selectedSkill = 1;
                        selectedSkillCategory.dispose();
                        selectedSkillCategory = gsm.getParty().get(pokemonIndex).getSecondSkill()
                                .getCategoryTexture();
                        selectedSkillAccuracy = gsm.getParty().get(pokemonIndex).getSecondSkill()
                                .getAccuracy();
                        selectedSkillPower = gsm.getParty().get(pokemonIndex).getSecondSkill()
                                .getBaseDamage();
                        selectedSkillDescription = gsm.getParty().get(pokemonIndex).getSecondSkill()
                                .getDescription();
                    }
                } else if (x >= 50 && x <= 576 && y >= 1482 && y <= 1586) {
                    if (selectedSkill == 2) {
                        selectedSkill = -1;
                        setNewSkillAttributes();
                    } else {
                        selectedSkill = 2;
                        selectedSkillCategory.dispose();
                        selectedSkillCategory = gsm.getParty().get(pokemonIndex).getThirdSkill()
                                .getCategoryTexture();
                        selectedSkillAccuracy = gsm.getParty().get(pokemonIndex).getThirdSkill()
                                .getAccuracy();
                        selectedSkillPower = gsm.getParty().get(pokemonIndex).getThirdSkill()
                                .getBaseDamage();
                        selectedSkillDescription = gsm.getParty().get(pokemonIndex).getThirdSkill()
                                .getDescription();
                    }
                } else if (x >= 50 && x <= 576 && y >= 1635 && y <= 1728) {
                    if (selectedSkill == 3) {
                        selectedSkill = -1;
                        setNewSkillAttributes();
                    } else {
                        selectedSkill = 3;
                        selectedSkillCategory.dispose();
                        selectedSkillCategory = gsm.getParty().get(pokemonIndex).getFourthSkill()
                                .getCategoryTexture();
                        selectedSkillAccuracy = gsm.getParty().get(pokemonIndex).getFourthSkill()
                                .getAccuracy();
                        selectedSkillPower = gsm.getParty().get(pokemonIndex).getFourthSkill()
                                .getBaseDamage();
                        selectedSkillDescription = gsm.getParty().get(pokemonIndex).getFourthSkill()
                                .getDescription();
                    }
                } else if (x >= 50 && x <= 576 && y >= 1795 && y <= 1916) {
                    if (selectedSkill != -1) {
                        String oldMove = gsm.getParty().get(pokemonIndex).getSkills()
                                .get(selectedSkill).getName();
                        gsm.getParty().get(pokemonIndex).getSkills().set(selectedSkill, newMove);
                        displayOverrideMove = false;
                        displayPokemonPanel = true;
                        panelText = gsm.getParty().get(pokemonIndex).getName() + " forgot " +
                                oldMove + "\nand learned " + newMove.getName() + ".";
                        checkMovesAfterReplacing = true;
                        waitNoEffectClick = true;
                        selectedSkill = -1;
                    }
                } else if (x >= 969 && x <= 1080 && y >= 1868 && y <= 1919) {
                    displayOverrideMove = false;
                    displayPokemonPanel = true;
                    panelText = gsm.getParty().get(pokemonIndex).getName() + " did not learn " +
                            newMove.getName() + ".";
                    waitNoEffectClick = true;
                    checkMovesAfterReplacing = true;
                    selectedSkill = -1;

                }
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
            if (gsm.getBag().getTMBag().size() > 0) {
                currentIndex = 0;
                setItemIconTexture();
                setTMExtras();
            }
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
            if (gsm.getBag().getTMBag().size() > 0) {
                currentIndex = 0;
                setItemIconTexture();
                setTMExtras();
            }
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
            if (currentBag == ItemTab.TM) {
                setTMExtras();
            }
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
            if (currentBag == ItemTab.TM) {
                setTMExtras();
            }
            clickSound.play();
        }
    }

    private void clickedX() {
        if (cameFromMenu) {
            gsm.setState(new LoadingState(gsm, LoadingState.HUB_STATE));
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
            } else if (currentBag == ItemTab.TM) {
                if (index < gsm.getBag().getTMBag().size()) {
                    return true;
                }
            }
            return false;
    }

    private void setTMExtras() {
        if (tmSkillCategory != null) {
            tmSkillCategory.dispose();
        }
        if (tmSkillType != null) {
            tmSkillType.dispose();
        }
        if (gsm.getBag().getTMBag().size() > 0) {
            tmSkillCategory = gsm.getBag().getTMBag().get(currentIndex).getTm().getSkill()
                    .getCategoryTexture();
            tmSkillType = gsm.getBag().getTMBag().get(currentIndex).getTm().getSkill()
                    .getSkillTypeTexture();
            tmAccuracy = gsm.getBag().getTMBag().get(currentIndex).getTm().getSkill()
                    .getAccuracy();
            tmPP = gsm.getBag().getTMBag().get(currentIndex).getTm().getSkill()
                    .getMaxPP();
            tmPower = gsm.getBag().getTMBag().get(currentIndex).getTm().getSkill()
                    .getBaseDamage();
        }

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
        } else if (currentBag == ItemTab.TM) {
            itemIcon = new Texture(gsm.getBag().getTMBag().get(currentIndex).getItem().getImage());
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
        yesNo.dispose();

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
        overrideMovePanel.dispose();
        litSkillPanel.dispose();
        skillPanel.dispose();
        firstSkillIcon.dispose();
        secondSkillIcon.dispose();
        thirdSkillIcon.dispose();
        fourthSkillIcon.dispose();
        newSkillIcon.dispose();
        regularFont.dispose();
        if (firstSkillType != null) {
            firstSkillType.dispose();
        }
        if (secondSkillType != null) {
            secondSkillType.dispose();
        }
        if (thirdSkillType != null) {
            thirdSkillType.dispose();
        }
        if (fourthSkillType != null) {
            fourthSkillType.dispose();
        }
        if (newSkillType != null) {
            newSkillType.dispose();
        }
        if (selectedSkillCategory != null) {
            selectedSkillCategory.dispose();
        }
        if (selectedPokemonImage != null) {
            selectedPokemonImage.dispose();
        }
        if (selectedPokemonTypeOne != null) {
            selectedPokemonTypeOne.dispose();
        }
        if (selectedPokemonTypeTwo != null) {
            selectedPokemonTypeTwo.dispose();
        }
        if (tmSkillType != null) {
            tmSkillType.dispose();
        }
        if (tmSkillCategory != null) {
            tmSkillCategory.dispose();
        }
    }
}
