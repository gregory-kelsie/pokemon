package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SpriteDynamicAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.playertraineranimation.PlayerTrainerAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;
import com.pokemon.toronto.game.com.pokemon.toronto.stateupdater.BattleUpdater;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/15/2017.
 */
public class BattleState extends GameState implements BattleInterface {

    private final int WILD_BATTLE = 0;
    private final int TRAINER_BATTLE = 1;
    private final int SIMULATED_WILD_BATTLE = 2;
    private final int PLAYER_BATTLE = 3;

    private final int ITEMS_PER_PAGE = 4; //4 items on an item page
    private final int FIRST_ITEM_PAGE = 0;
    private int currentItemPage;

    private final int FIRST_PANEL = 0;
    private final int BATTLE_PANEL = 1;
    private final int BAG_OPTION_PANEL = 2;
    private final int POKEBALL_BAG = 3;
    private final int POKEMON_SELECT_PANEL = 4;

    //States


    private GameStateManager gsm;
    private int panelPosition;
    private Pokemon enemyPokemon;
    private Pokemon currentPokemon;
    private int currentPokemonPosition;
    private boolean battling;
    private BattleUpdater battleUpdater;
    private Texture battleBackground;
    private Texture initPanel;
    private Texture battlePanel;
    private Texture bagOptionPanel;
    private Texture pokemonSelectPanel;
    private Texture pokemonPanel;
    private Texture healthBorder; //for pokemon select screen
    private Texture pokeSelectGreenHealth;
    private Texture leftArrow;
    private Texture rightArrow;
    private Texture itemSlotPanel;
    private Texture expBar;
    private Texture userHealthPanel;
    private Texture enemyHealthPanel;
    private Texture textArea;
    private Texture greenHealth;
    private Texture yesNo;

    //Pokemon Icon Textures
    private List<Texture> iconTextures;

    private BitmapFont healthText;
    private BitmapFont regularFont; //Textbox and Skill
    private BitmapFont itemDescFont;
    private BitmapFont smallFont; //Pokemon panel font


    private Texture userPokemonTexture;
    private Texture enemyPokemonTexture;

    private Texture firstSkill;
    private Texture secondSkill;
    private Texture thirdSkill;
    private Texture fourthSkill;

    private Texture firstItem;
    private Texture secondItem;
    private Texture thirdItem;
    private Texture fourthItem;

    private Music bgm;
    private Sound clickSound;
    List<List<String>> battleTextList;
    //Move Animation Stuff
    private boolean flashUserPokemon;
    private int battleType;

    //Beginning of a battle variables.
    boolean inBeginning;
    //Text for the beginning of the battle. "A wild x appeared!" "Go y!!"
    private String beginningText;
    private int beginningTextIndex;
    private double beginningTextCounter;
    //States for beginning
    private int beginningState;
    private final int WILD_POKEMON_APPEARS_TEXT = 0;

    private PlayerTrainerAnimation pta;


    public BattleState(GameStateManager gsm, Pokemon enemyPokemon, Music bgm) {
        this.gsm = gsm;
        this.battleType = WILD_BATTLE;
        panelPosition = FIRST_PANEL;
        currentItemPage = FIRST_ITEM_PAGE;
        this.enemyPokemon = enemyPokemon;
        for (int i = 0; i < gsm.getParty().size(); i++) {
            if (gsm.getParty().get(i).getCurrentHealth() > 0) {
                currentPokemon = gsm.getParty().get(i);
                currentPokemonPosition = i;
                break;
            }
        }
        this.bgm = bgm;
        healthText = new BitmapFont(Gdx.files.internal("battle/healthFont.fnt"));
        healthText.setColor(Color.BLACK);
        regularFont = new BitmapFont(Gdx.files.internal("battle/font/regularFont.fnt"));
        itemDescFont = new BitmapFont(Gdx.files.internal("battle/itemDesc.fnt"));
        smallFont = new BitmapFont(Gdx.files.internal("battle/textFont.fnt"));
        clickSound = gsm.getLoader().get("sounds/click.wav");
        regularFont.setColor(Color.WHITE);
        battling = false;
        flashUserPokemon = false;

        battleUpdater = new BattleUpdater(this, regularFont);
        pta = new PlayerTrainerAnimation(gsm.getLoader(), currentPokemon.getName(), enemyPokemon.getName());
        initTextures();
        Gdx.app.log("CurrentExp: ", "" + currentPokemon.getNextLevelExp());


    }

    private void initTextures() {
        battleBackground = new Texture("battle/field.png");
        battlePanel = new Texture("battle/battlePanel.png");
        initPanel = new Texture("battle/firstBottomPanel.png");
        pokemonSelectPanel = new Texture("battle/pokemonSelect/pokeSelectPanel.png");
        pokemonPanel = new Texture("battle/pokemonSelect/pokemonPanel.png");
        healthBorder = new Texture("battle/pokemonSelect/healthBorder.png");
        pokeSelectGreenHealth = new Texture("battle/pokemonSelect/greenHealth.png");
        textArea = new Texture("battle/textarea.png");
        userPokemonTexture = new Texture(currentPokemon.getBackPath());
        enemyPokemonTexture = new Texture(enemyPokemon.getMapIconPath());
        expBar = new Texture("battle/expBar.png");
        greenHealth = new Texture("battle/greenHealth.png");
        userHealthPanel = new Texture("battle/userHealthBar.png");
        enemyHealthPanel = new Texture("battle/enemyHealthBar.png");
        bagOptionPanel = new Texture("battle/bagOptions.png");
        leftArrow = new Texture("battle/leftArrow.png");
        rightArrow = new Texture("battle/rightArrow.png");
        itemSlotPanel = new Texture("battle/itemSlot.png");
        yesNo = new Texture("battle/yesno.png");

        //Init Pokemon Icon Textures
        iconTextures = new ArrayList<Texture>();
        for (int i = 0; i < gsm.getParty().size(); i++) {
            iconTextures.add(new Texture(gsm.getParty().get(i).getMiniIconPath()));
        }

        secondSkill = null;
        thirdSkill = null;
        fourthSkill = null;
        createSkillButtonTextures();

    }


    @Override
    public void render(SpriteBatch batch) {
        //Render top panel
        renderBattleScreen(batch);
        //Render text panel in the middle.
        renderTextPanel(batch);
        //Render bottom panel
        renderBottomScreen(batch);
    }

    private void renderBattleScreen(SpriteBatch batch) {
        //Render battle scene on top
        renderBackground(batch);
        //Draw Pokemon
        renderBattlingPokemon(batch);

        renderUI(batch);

        //battleUpdater.renderSwitchBall(batch);
        //Render the skill animation going on if it is happening.
        renderSkillAnimation(batch);
        battleUpdater.renderExtras(batch);
    }
    private void renderBottomScreen(SpriteBatch batch) {
        if (panelPosition == FIRST_PANEL) {
            batch.draw(initPanel, 0, 0);
        } else if (panelPosition == BATTLE_PANEL) {
            drawMovesPanel(batch);
        } else if (panelPosition == BAG_OPTION_PANEL) {
            batch.draw(bagOptionPanel, 0, 0);
        } else if (panelPosition == POKEBALL_BAG) {
            drawPokeballBag(batch);
        } else if (panelPosition == POKEMON_SELECT_PANEL) {
            drawPokemonSelectPanel(batch);
        }
        if (battleUpdater.displayingYesNo()) {
            batch.draw(yesNo, 760, 950);
        }
    }
    private void renderBackground(SpriteBatch batch) {
        //Draw Background
        batch.draw(battleBackground, 0, 1205);

        //Draw animation background when the health bars disappear and the field disappears
        //momentarily.
        battleUpdater.renderAnimationBackground(batch);
    }
    private void renderUI(SpriteBatch batch) {
        renderHealthUI(batch);

    }
    private void renderBattlingPokemon(SpriteBatch batch) {
        if (pta.isFinished()) {
            if (!battleUpdater.started() || battleUpdater.getSkillAnimation() == null
                    || battleUpdater.getSkillAnimation().displayEnemyPokemon()) {

            }
            if (!battleUpdater.started() || battleUpdater.getSkillAnimation() == null) {
                if (!battleUpdater.hidingUserPokemon()) {
                    batch.draw(userPokemonTexture, 122, 1231, 394, 394);
                }
                if (!battleUpdater.isHidingEnemyPokemon()) {
                    batch.draw(enemyPokemonTexture, 591, 1460, 394, 394);
                }
            } else {
                if (battleUpdater.getSkillAnimation().displayUserPokemon()) {
                    if (!currentPokemon.isFainted()) {
                        if (!battleUpdater.hidingUserPokemon()) {
                            batch.draw(userPokemonTexture, currentPokemon.getPlayerX(),
                                    currentPokemon.getPlayerY(), 394, 394);
                        }
                    }
                }
                if (!battleUpdater.isHidingEnemyPokemon() && battleUpdater.getSkillAnimation().displayEnemyPokemon()) {
                    if (!enemyPokemon.isFainted()) {
                        batch.draw(enemyPokemonTexture, enemyPokemon.getEnemyX(), enemyPokemon.getEnemyY(), 394, 394);
                    }
                }
            }
        } else {
            batch.draw(enemyPokemonTexture, 591, 1460, 394, 394);
            pta.render(batch);
        }
    }
    private void renderSkillAnimation(SpriteBatch batch) {
        //Draw the animation
        try {
            //Skill animation may be null.
            battleUpdater.getSkillAnimation().drawAnimation(batch);
        } catch (Exception e) {}
    }

    private void renderHealthUI(SpriteBatch batch) {
        //Draw Health HUD
        batch.draw(enemyHealthPanel, 15, 1779);
        if (pta.isFinished()) {
            batch.draw(userHealthPanel, 432, 1266);
            //User total health, current health, level
            healthText.draw(batch, Integer.toString(currentPokemon.getHealthStat()), 888,1325);
            if (currentPokemon.getAnimationHealth() >= 100) {
                healthText.draw(batch, Integer.toString(currentPokemon.getAnimationHealth()), 750, 1325);
            } else {
                healthText.draw(batch, Integer.toString(currentPokemon.getAnimationHealth()), 785, 1325);
            }
            healthText.draw(batch, Integer.toString(currentPokemon.getLevel()), 900,1398);
            batch.draw(greenHealth, 712, 1340, Math.round(261 *((1.0 * currentPokemon.getAnimationHealth()) / currentPokemon.getHealthStat())), 14);
            batch.draw(expBar, 578, 1271, (int)((1.0 * currentPokemon.getDisplayedExp() / currentPokemon.getNextLevelExp()) * 441.0), 12); //439 14 width height
        }
        //Enemy level
        healthText.draw(batch, Integer.toString(enemyPokemon.getLevel()), 488,1874);
        //Enemy Healthbar
        batch.draw(greenHealth, 221, 1818,  Math.round(261 *((1.0 * enemyPokemon.getAnimationHealth()) / enemyPokemon.getHealthStat())), 14);

    }
    private void renderTextPanel(SpriteBatch batch) {
        //Render text panel in the middle
        batch.draw(textArea, 0, 954);

        if (pta.isFinished()) {
            if (!battleUpdater.started()) {
                if (!battleUpdater.caughtThePokemon()) {
                    regularFont.draw(batch, "What will " + currentPokemon.getName() + " do?", 54, 1143);
                }
            } else {
                battleUpdater.renderText(batch);
            }
        } else {
            pta.renderText(batch);
        }
    }
    private void drawPokeballBag(SpriteBatch batch) {
        batch.draw(battlePanel, 0,0);
        drawPokeballs(batch);
        drawNavigationArrows(batch);
    }
    private void drawPokemonSelectPanel(SpriteBatch batch) {
        batch.draw(pokemonSelectPanel, 0, 0);
        drawPokemonPanels(batch);
        drawPokemonIcons(batch);
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
            batch.draw(iconTextures.get(i), xPos, yPos, 128, 128);
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
    private void drawNavigationArrows(SpriteBatch batch) {
        //Check if there is another item past the current page.
       // if (currentItemPage * 4 + 4 < gsm.getBag().getPokeballBag().size()) {
            batch.draw(rightArrow, 600, 40);
       // }

        //Check if not on the very first page
        //if (currentItemPage * 4 - 1 > 0) {
            batch.draw(leftArrow, 200, 40);
       // }
    }
    private void drawPokeballs(SpriteBatch batch) {
        if (hasFirstItem()) {
            //Draw first item
            batch.draw(itemSlotPanel, 30, 565);
            batch.draw(firstItem, 415, 665, 80, 80);
            itemDescFont.draw(batch, gsm.getBag().getPokeballBag().get(currentItemPage * 4).getName().toUpperCase() +
                            "x " + gsm.getBag().getPokeballBag().get(currentItemPage * 4).getQuantity(), 60, 720);
            itemDescFont.draw(batch, gsm.getBag().getPokeballBag().get(currentItemPage * 4).getDescription(),
                    60, 677);
            if (hasSecondItem()) {
                //Draw second item
                batch.draw(itemSlotPanel, 548, 565);
                batch.draw(secondItem, 848, 715, 80, 80);
                if (hasThirdItem()) {
                    //Draw third item
                    batch.draw(itemSlotPanel, 30, 348);
                    if (hasFourthItem()) {
                        //Draw fourth item
                        batch.draw(itemSlotPanel, 548, 348);
                    }
                }
            }
        }
    }
    private void drawMovesPanel(SpriteBatch batch) {
        //Draw battle panel
        batch.draw(battlePanel, 0, 0);
        drawSkills(batch);
        drawSkillNames(batch);
    }
    private void drawSkills(SpriteBatch batch) {
        batch.draw(firstSkill, 6, 555);
        if (secondSkill != null) {
            batch.draw(secondSkill, 548, 555);
        }
        if (thirdSkill != null) {
            batch.draw(thirdSkill, 6, 348);
        }
        if (fourthSkill != null) {
            batch.draw(fourthSkill, 548, 348);
        }
    }
    private void drawSkillNames(SpriteBatch batch) {
        //Move names
        regularFont.draw(batch, currentPokemon.getSkills().get(0).getName(), 141, 708);
        regularFont.draw(batch, currentPokemon.getSkills().get(0).getCurrentPP() + " / " +
                currentPokemon.getSkills().get(0).getMaxPP(), 320, 630);
        if (currentPokemon.getSkills().size() > 1) {
            regularFont.draw(batch, currentPokemon.getSkills().get(1).getName(), 676, 708);
            regularFont.draw(batch, currentPokemon.getSkills().get(1).getCurrentPP() + " / " +
                    currentPokemon.getSkills().get(1).getMaxPP(), 860, 630);
            if (currentPokemon.getSkills().size() > 2) {
                regularFont.draw(batch, currentPokemon.getSkills().get(2).getName(), 141, 498);
                regularFont.draw(batch, currentPokemon.getSkills().get(2).getCurrentPP() + " / " +
                        currentPokemon.getSkills().get(2).getMaxPP(), 320, 423);
                if (currentPokemon.getSkills().size() > 3) {
                    regularFont.draw(batch, currentPokemon.getSkills().get(3).getName(), 676, 498);
                    regularFont.draw(batch, currentPokemon.getSkills().get(3).getCurrentPP() + " / " +
                            currentPokemon.getSkills().get(3).getMaxPP(), 860, 423);
                }
            }
        }
    }
    private void createSkillButtonTextures() {
        Gdx.app.log("Skills", currentPokemon.getName() + ": " + currentPokemon.getSkills().size());
        firstSkill = initTypeTexture(currentPokemon.getSkills().get(0).getType());
        if (currentPokemon.getSkills().size() > 1) {
            secondSkill = initTypeTexture(currentPokemon.getSkills().get(1).getType());
            if (currentPokemon.getSkills().size() > 2) {
                thirdSkill = initTypeTexture(currentPokemon.getSkills().get(2).getType());
                if (currentPokemon.getSkills().size() > 3) {
                    fourthSkill = initTypeTexture(currentPokemon.getSkills().get(3).getType());

                }
            }
        }

    }
    private void resetSkillButtonTextures() {
        try {
            firstSkill.dispose();
            secondSkill.dispose();
            thirdSkill.dispose();
            fourthSkill.dispose();
        } catch (Exception e) { }
        secondSkill = null;
        thirdSkill = null;
        fourthSkill = null;
        createSkillButtonTextures();
    }
    private boolean hasFirstItem() {
        if (currentItemPage * 4 < gsm.getBag().getPokeballBag().size()) {
            return true;
        } else {
            return false;
        }
    }
    private boolean hasSecondItem() {
        if (currentItemPage * 4 + 1 < gsm.getBag().getPokeballBag().size()) {
            return true;
        }
        return false;
    }
    private boolean hasThirdItem() {
        if (currentItemPage * 4 + 2 < gsm.getBag().getPokeballBag().size()) {
            return true;
        }
        return false;
    }
    private boolean hasFourthItem() {
        if (currentItemPage * 4 + 3 < gsm.getBag().getPokeballBag().size()) {
            return true;
        }
        return false;
    }
    private void initPokeballIconTextures() {
        disposeItemTextures();
        if (hasFirstItem()) {
            firstItem = new Texture(gsm.getBag().getPokeballBag()
                    .get(currentItemPage * 4).getIconPath());
            if (hasSecondItem()) {
                secondItem = new Texture(gsm.getBag().getPokeballBag()
                        .get(currentItemPage * 4 + 1).getIconPath());
                if (hasThirdItem()) {
                    thirdItem = new Texture(gsm.getBag().getPokeballBag()
                            .get(currentItemPage * 4 + 2).getIconPath());
                    if (hasFourthItem()) {
                        fourthItem = new Texture(gsm.getBag().getPokeballBag()
                                .get(currentItemPage * 4 + 3).getIconPath());
                    }
                }
            }
        }
    }

    private void disposeItemTextures() {
        try {
            firstItem.dispose();
        } catch (Exception e) {}
        try {
            secondItem.dispose();
        } catch (Exception e) { }
        try {
            thirdItem.dispose();
        } catch (Exception e) { }
        try {
            fourthItem.dispose();
        } catch (Exception e) { }
    }
    private Texture initTypeTexture(Pokemon.Type type) {
        if (type == Pokemon.Type.BUG) {
            return new Texture("battle/skillBorders/bug.png");
        } else if (type == Pokemon.Type.DARK) {
            return new Texture("battle/skillBorders/dark.png");
        } else if (type == Pokemon.Type.DRAGON) {
            return new Texture("battle/skillBorders/dragon.png");
        } else if (type == Pokemon.Type.ELECTRIC) {
            return new Texture("battle/skillBorders/electric.png");
        } else if (type == Pokemon.Type.FIGHTING) {
            return new Texture("battle/skillBorders/fighting.png");
        } else if (type == Pokemon.Type.FIRE) {
            return new Texture("battle/skillBorders/fire.png");
        } else if (type == Pokemon.Type.FLYING) {
            return new Texture("battle/skillBorders/flying.png");
        } else if (type == Pokemon.Type.GHOST) {
            return new Texture("battle/skillBorders/ghost.png");
        } else if (type == Pokemon.Type.GRASS) {
            return new Texture("battle/skillBorders/grass.png");
        } else if (type == Pokemon.Type.GROUND) {
            return new Texture("battle/skillBorders/ground.png");
        } else if (type == Pokemon.Type.ICE) {
            return new Texture("battle/skillBorders/ice.png");
        } else if (type == Pokemon.Type.NORMAL) {
            return new Texture("battle/skillBorders/normal.png");
        } else if (type == Pokemon.Type.POISON) {
            return new Texture("battle/skillBorders/poison.png");
        } else if (type == Pokemon.Type.PSYCHIC) {
            return new Texture("battle/skillBorders/psychic.png");
        } else if (type == Pokemon.Type.ROCK) {
            return new Texture("battle/skillBorders/rock.png");
        } else if (type == Pokemon.Type.STEEL) {
            return new Texture("battle/skillBorders/steel.png");
        } else if (type == Pokemon.Type.WATER) {
            return new Texture("battle/skillBorders/water.png");
        } else {
            return new Texture("battle/skillBorders/normal.png");
        }
    }

    @Override
    public void update(double dt) {
        if (bgm.getPosition() >= 113.979f) {
            bgm.setPosition(12.889f);
        }
        if (!pta.isFinished()) {
           pta.update(dt);
        }
        else {
            if (battleUpdater.started()) {
                battleUpdater.update(dt);
                if (battleUpdater.waitingForNextPokemon()) {
                    panelPosition = POKEMON_SELECT_PANEL;
                }
                if (battleUpdater.isDisplayingNewPokemon()) {
                    userPokemonTexture.dispose();
                    userPokemonTexture = new Texture(gsm.getParty().get(currentPokemonPosition).getBackPath());
                    currentPokemon = gsm.getParty().get(currentPokemonPosition);
                    resetSkillButtonTextures();
                }


            } else {
                if (battleUpdater.caughtThePokemon()) {
                    gsm.setState(new LoadingState(gsm, LoadingState.WILD_POKEMON_LIST));
                    dispose();
                }
            }


        }

        if (MyInput.clicked()) {
            int x = MyInput.getX();
            int y = MyInput.getY();
            if (pta.isFinished()) {
                if (battleUpdater.waitingForFaintClick()) {
                    battleUpdater.goToExpGainState();
                }
                if (battleUpdater.waitingForExpClick()) {
                    battleUpdater.goToExpGraphicsState();
                }
                if (battleUpdater.displayingYesNo()) {
                    Gdx.app.log("Coords", "X: " + x + ", Y: " + y);
                    if (x >= 813 && x <= 1005 && y >= 754 && y <= 841) {
                        battleUpdater.acceptedNewMove();
                    } else if (x >= 813 && x <= 1005 && y >= 899 && y <= 994) {
                        battleUpdater.declinedNewMove();
                    }
                }
                if (battleUpdater.waitingForMoveDeletion()) {
                    panelPosition = BATTLE_PANEL;
                }
                if (x >= 309 && x <= 776 && y >= 1107 && y <= 1243) {
                    if (panelPosition == FIRST_PANEL && !battleUpdater.started()) {
                        panelPosition = BATTLE_PANEL;
                        clickSound.play();
                    }
                } else if (x >= 0 && x <= 421 && y >= 1361 && y <= 1441 && panelPosition == FIRST_PANEL && !battleUpdater.started()) {
                    //Clicked Bag
                    panelPosition = BAG_OPTION_PANEL;
                    clickSound.play();
                } else if (x >= 627 && x <= 1051 && y >= 1353 && y <= 1464 && panelPosition == FIRST_PANEL && !battleUpdater.started()) {
                    //Clicked Pokemon
                    panelPosition = POKEMON_SELECT_PANEL;
                    clickSound.play();
                } else if (x >= 0 && x <= 180 && y >= 1830 && y <= 1920 && panelPosition == POKEMON_SELECT_PANEL) {
                    //Clicked back on pokemon select screen
                    if (!battleUpdater.waitingForNextPokemon()) {
                        panelPosition = FIRST_PANEL;
                        clickSound.play();
                    }
                } else if (x >= 777 && x <= 1080 && y >= 1703 && y <= 1920 && (panelPosition == BATTLE_PANEL
                        || panelPosition == BAG_OPTION_PANEL || panelPosition == POKEBALL_BAG)) {
                    //Clicked Back
                    if (panelPosition == POKEBALL_BAG) {
                        panelPosition = BAG_OPTION_PANEL;
                        currentItemPage = FIRST_ITEM_PAGE;
                    } else {
                        //Don't allow back button when the battle is ongoing.
                        if (!battleUpdater.started()) {
                            panelPosition = FIRST_PANEL;
                        }
                    }
                    clickSound.play();
                } else if (x >= 147 && x <= 879 && y >= 1204 && y <= 1329 && panelPosition == BAG_OPTION_PANEL) {
                    //Clicked Usable Items
                    clickSound.play();
                } else if (x >= 200 && x <= 919 && y >= 1441 && y <= 1583 && panelPosition == BAG_OPTION_PANEL) {
                    //Clicked Pokeballs
                    panelPosition = POKEBALL_BAG;
                    initPokeballIconTextures();
                    clickSound.play();
                } else if (x >= 0 && x <= 473 && y >= 1203 && y <= 1337 && panelPosition == POKEBALL_BAG) {
                    //Clicked Pokeballs
                    if (gsm.getBag().getPokeballBag().size() >= 1) {
                        battleUpdater.start(gsm.getParty(), currentPokemon, enemyPokemon,
                                0, enemyPokemon.getSkills().get(0));// 0 is speedcheck phase
                        gsm.getBag().getPokeballBag().get(0).subtractQuantity(1);
                        if (gsm.getBag().getPokeballBag().get(0).getQuantity() == 0) {
                            gsm.getBag().getPokeballBag().remove(0);
                        }
                        clickSound.play();
                        panelPosition = FIRST_PANEL;
                    }

                } else if (x >= 81 && x <= 479 && y >= 1217 && y <= 1337 && panelPosition == BATTLE_PANEL) {
                    //Clicked First Skill
                    Gdx.app.log("Battle Log", "Clicked first skill");
                    if (battleUpdater.waitingForMoveDeletion()) {
                        battleUpdater.removeFirstSkill();
                    }
                    panelPosition = FIRST_PANEL;
                    clickSound.play();

                } else if (x >= 577 && x <= 1017 && y >= 1205 && y <= 1340 && panelPosition == BATTLE_PANEL) {
                    //Clicked Second Skill
                    Gdx.app.log("Battle Log", "Clicked second skill");
                    if (currentPokemon.getSkills().size() > 1) {
                        if (battleUpdater.waitingForMoveDeletion()) {
                            battleUpdater.removeSecondSkill();
                        }
                        panelPosition = FIRST_PANEL;
                        clickSound.play();
                    }
                } else if (x >= 26 && x <= 485 && y >= 1443 && y <= 1555 && panelPosition == BATTLE_PANEL) {
                    //Clicked third skill
                    Gdx.app.log("Battle Log", "Clicked third skill");
                    if (currentPokemon.getSkills().size() > 2) {
                        if (battleUpdater.waitingForMoveDeletion()) {
                            battleUpdater.removeThirdSkill();
                        }
                        if (!battleUpdater.started()) {
                            panelPosition = FIRST_PANEL;
                            battleUpdater.start(gsm.getParty(), currentPokemon, enemyPokemon,
                                    currentPokemon.getSkills().get(2), enemyPokemon.getSkills().get(0));// 0 is speedcheck phase
                        }
                        clickSound.play();
                    }
                } else if (x >= 577 && x <= 1017 && y >= 1443 && y <= 1555 && panelPosition == BATTLE_PANEL) {
                    //Clicked fourth skill
                    Gdx.app.log("Battle Log", "Clicked fourth skill");
                    if (currentPokemon.getSkills().size() > 3) {
                        if (battleUpdater.waitingForMoveDeletion()) {
                            battleUpdater.removeFourthSkill();
                        }
                        panelPosition = FIRST_PANEL;
                        clickSound.play();
                    }
                } else if (x >= 272 && x <= 759 && y >= 1540 && y <= 1674 && panelPosition == FIRST_PANEL && !battleUpdater.started()) {
                    //Clicked Run
                    gsm.setState(new MainMenuState(gsm));
                    dispose();
                } else if (x >= 88 && x <= 411 && y >= 1186 && y <= 1302 && panelPosition == POKEMON_SELECT_PANEL && currentPokemonPosition != 0) {
                    //First Pokemon
                    if (gsm.getParty().get(0).getCurrentHealth() > 0) {
                        currentPokemonPosition = 0;
                        if (battleUpdater.waitingForNextPokemon()) {
                            switchCurrentPokemon();
                        } else {
                            battleUpdater.start(gsm.getParty(), currentPokemon, enemyPokemon,
                                    gsm.getParty().get(0), enemyPokemon.getSkills().get(0));
                        }
                        panelPosition = FIRST_PANEL;
                        clickSound.play();
                    }
                } else if (x >= 594 && x <= 916 && y >= 1268 && y <= 1431 && panelPosition == POKEMON_SELECT_PANEL && currentPokemonPosition != 1) {
                    //Second Pokemon
                    if (gsm.getParty().size() > 1) {
                        if (gsm.getParty().get(1).getCurrentHealth() > 0) {
                            currentPokemonPosition = 1;
                            if (battleUpdater.waitingForNextPokemon()) {
                                switchCurrentPokemon();
                            } else {
                                battleUpdater.start(gsm.getParty(), currentPokemon, enemyPokemon,
                                        gsm.getParty().get(1), enemyPokemon.getSkills().get(0));
                            }
                            panelPosition = FIRST_PANEL;
                            clickSound.play();
                        }
                    }
                } else if (x >= 88 && x <= 411 && y >= 1422 && y <= 1554 && panelPosition == POKEMON_SELECT_PANEL && currentPokemonPosition != 2) {
                    //Third Pokemon
                    if (gsm.getParty().size() > 2) {
                        if (gsm.getParty().get(2).getCurrentHealth() > 0) {
                            currentPokemonPosition = 2;
                            if (battleUpdater.waitingForNextPokemon()) {
                                switchCurrentPokemon();
                            } else {
                                battleUpdater.start(gsm.getParty(), currentPokemon, enemyPokemon,
                                        gsm.getParty().get(2), enemyPokemon.getSkills().get(0));

                            }
                            clickSound.play();
                            panelPosition = FIRST_PANEL;
                        }
                    }
                } else if (x >= 594 && x <= 916 && y >= 1498 && y <= 1662 && panelPosition == POKEMON_SELECT_PANEL && currentPokemonPosition != 3) {
                    //Fourth Pokemon
                    if (gsm.getParty().size() > 3) {
                        if (gsm.getParty().get(3).getCurrentHealth() > 0) {
                            currentPokemonPosition = 3;
                            if (battleUpdater.waitingForNextPokemon()) {
                                switchCurrentPokemon();
                            } else {
                                battleUpdater.start(gsm.getParty(), currentPokemon, enemyPokemon,
                                        gsm.getParty().get(3), enemyPokemon.getSkills().get(0));

                            }
                            clickSound.play();
                            panelPosition = FIRST_PANEL;
                        }
                    }
                } else if (x >= 88 && x <= 411 && y >= 1662 && y <= 1823 && panelPosition == POKEMON_SELECT_PANEL && currentPokemonPosition != 4) {
                    //Fifth Pokemon
                    if (gsm.getParty().size() > 4) {
                        if (gsm.getParty().get(4).getCurrentHealth() > 0) {
                            currentPokemonPosition = 4;
                            if (battleUpdater.waitingForNextPokemon()) {
                                switchCurrentPokemon();
                            } else {
                                battleUpdater.start(gsm.getParty(), currentPokemon, enemyPokemon,
                                        gsm.getParty().get(4), enemyPokemon.getSkills().get(0));
                            }
                            clickSound.play();
                            panelPosition = FIRST_PANEL;

                        }
                    }
                } else if (x >= 594 && x <= 916 && y >= 1749 && y <= 1907 && panelPosition == POKEMON_SELECT_PANEL && currentPokemonPosition != 5) {
                    //Sixth Pokemon
                    if (gsm.getParty().size() > 5) {
                        if (gsm.getParty().get(5).getCurrentHealth() > 0) {
                            currentPokemonPosition = 5;
                            if (battleUpdater.waitingForNextPokemon()) {
                                switchCurrentPokemon();
                            } else {
                                battleUpdater.start(gsm.getParty(), currentPokemon, enemyPokemon,
                                        gsm.getParty().get(5), enemyPokemon.getSkills().get(0));
                            }
                            clickSound.play();
                            panelPosition = FIRST_PANEL;
                        }
                    }

                }
                else if (y > 900 && y <= 1920) {
                    Gdx.app.log("Coordinates", "X: " + x + ", Y: " + y);
                }
            } else {
                if (pta.isPaused() && pta.finishedPauseText()) {
                    pta.unPause();
                    clickSound.play();
                }
            }
        }
    }


    private void switchCurrentPokemon() {
        userPokemonTexture.dispose();
        userPokemonTexture = new Texture(gsm.getParty().get(currentPokemonPosition).getBackPath());
        currentPokemon = gsm.getParty().get(currentPokemonPosition);
        resetSkillButtonTextures();
        battleUpdater.finishedFaintSwitch();
    }
    public void endBattle() {
        gsm.setState(new LoadingState(gsm, LoadingState.MAP_STATE));
        dispose();
    }

    public void blackedOut() {
        gsm.setState(new LoadingState(gsm, LoadingState.POKECENTER_STATE));
        dispose();
    }

    @Override
    protected void dispose() {
        battleBackground.dispose();
        battlePanel.dispose();
        initPanel.dispose();
        bagOptionPanel.dispose();
        leftArrow.dispose();
        rightArrow.dispose();
        itemSlotPanel.dispose();
        textArea.dispose();
        itemDescFont.dispose();
        userPokemonTexture.dispose();
        enemyPokemonTexture.dispose();
        expBar.dispose();
        userHealthPanel.dispose();
        enemyHealthPanel.dispose();
        healthText.dispose();
        regularFont.dispose();
        smallFont.dispose();
        firstSkill.dispose();
        yesNo.dispose();
        try {
            secondSkill.dispose();
            thirdSkill.dispose();
            fourthSkill.dispose();
        } catch (Exception e) { }
        for (int i = 0; i < iconTextures.size(); i++) {
            iconTextures.get(i).dispose();
        }

       disposeItemTextures();
        bgm.stop();
        bgm.dispose();
    }



    //INTERFACE METHODS

    @Override
    public void setIsBattling(boolean battling) {
        this.battling = battling;
    }

    @Override
    public void setBattleTextList(List<List<String>> bList) {
        battleTextList = bList;
    }

    @Override
    public boolean isBattling() {
        return battling;
    }


    public void setCurrentPokemon(Pokemon poke) { this.currentPokemon = poke; }



}
