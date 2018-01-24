package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Ball.Ball;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.Field;
import com.pokemon.toronto.game.com.pokemon.toronto.Field.WeatherType;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SpriteDynamicAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.playertraineranimation.PlayerTrainerAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.playertraineranimation.TrainerAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.battle.BattleClickController;
import com.pokemon.toronto.game.com.pokemon.toronto.battle.BattleTextures;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokemonFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.stateupdater.BattleUpdater;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/15/2017.
 */
public class BattleState extends GameState implements BattleInterface {

    public final int WILD_BATTLE = 0;
    private final int TRAINER_BATTLE = 1;
    private final int SIMULATED_WILD_BATTLE = 2;
    private final int PLAYER_BATTLE = 3;

    private final int ITEMS_PER_PAGE = 4; //4 items on an item page
    public final int FIRST_ITEM_PAGE = 0;

    private int currentItemPage;

    public final int FIRST_PANEL = 0;
    public final int BATTLE_PANEL = 1;
    public final int BAG_OPTION_PANEL = 2;
    public final int POKEBALL_BAG = 3;
    public final int POKEMON_SELECT_PANEL = 4;

    //States
    private int panelPosition;
    private Pokemon enemyPokemon;
    private List<Pokemon> enemyParty;
    private Pokemon currentPokemon;
    private int currentPokemonPosition;
    private boolean battling;
    private BattleUpdater battleUpdater;
    private BattleTextures battleTextures;


    private Music bgm;
    private Music victoryBgm;
    private Sound clickSound;

    private Sound enemyPokemonCry;
    private List<Sound> playerCries;
    private List<Sound> trainerCries;

    List<List<String>> battleTextList;

    //Variables for Battles from the Simulator
    private int startingRoute;
    private int region;
    private boolean isRoute;

    private int battleType;

    private PlayerTrainerAnimation pta;
    private TrainerAnimation trainerAnimation;
    private boolean justFinishedPta;


    private GameStateManager gsm;
    private BattleClickController controller;
    private Field field;

    private String moveSelectText;

    private Trainer trainer;
    private int currentEnemyPosition;

    public BattleState(GameStateManager gsm, Pokemon enemyPokemon, Music bgm) {
        init(gsm, bgm);
        this.enemyPokemon = enemyPokemon;
        enemyPokemonCry = Gdx.audio.newSound(Gdx.files.internal(enemyPokemon.getCryPath()));
        pta = new PlayerTrainerAnimation(gsm.getLoader(), currentPokemon.getName(), enemyPokemon.getName(), this);
        startingRoute = -1;
        region = -1;
        field = new Field();
        initBattleTextures();
    }
    public BattleState(GameStateManager gsm, Music bgm, Trainer trainer) {
        init(gsm, bgm);
        startingRoute = -1;
        region = -1;
        field = new Field();
        this.trainer = trainer;
        loadTrainerCries();
        battleType = TRAINER_BATTLE;
        currentEnemyPosition = 0;
        trainerAnimation = new TrainerAnimation(this, gsm.getParty().get(currentPokemonPosition)
                .getName(), trainer, new Texture(trainer.getIconPath()), trainer.getParty().size());
        List<String> partyIconPaths = new ArrayList<String>();
        for (Pokemon p: gsm.getParty()) {
            partyIconPaths.add(p.getMiniIconPath());
        }
        enemyPokemon = trainer.getParty().get(0);
        enemyParty = trainer.getParty();
        battleTextures = new BattleTextures(currentPokemon.getBackPath(),
                trainer.getParty().get(0).getMapIconPath(), partyIconPaths, currentPokemon);
        battleUpdater = new BattleUpdater(this, battleTextures.getRegularFont());
    }

    public BattleState(GameStateManager gsm, Pokemon enemyPokemon, Music bgm, int startingRoute, int region, boolean isRoute) {
        init(gsm, bgm);
        this.enemyPokemon = enemyPokemon;
        enemyPokemonCry = Gdx.audio.newSound(Gdx.files.internal(enemyPokemon.getCryPath()));
        pta = new PlayerTrainerAnimation(gsm.getLoader(), currentPokemon.getName(), enemyPokemon.getName(), this);
        this.startingRoute = startingRoute;
        this.region = region;
        this.isRoute = isRoute;
        field = new Field();
        initBattleTextures();
    }

    private void init(GameStateManager gsm, Music bgm) {
        this.gsm = gsm;
        enemyParty = new ArrayList<Pokemon>();

        justFinishedPta = false;
        this.battleType = WILD_BATTLE;
        panelPosition = FIRST_PANEL;
        currentItemPage = FIRST_ITEM_PAGE;
        for (int i = 0; i < gsm.getParty().size(); i++) {
            if (gsm.getParty().get(i).getCurrentHealth() > 0) {
                currentPokemon = gsm.getParty().get(i);
                currentPokemonPosition = i;
                break;
            }
        }
        this.bgm = bgm;
        victoryBgm = Gdx.audio.newMusic(Gdx.files.internal("bgm/wildVictory.mp3"));
        clickSound = gsm.getLoader().get("sounds/click.wav");
        loadCries();
        battling = false;
        controller = new BattleClickController(this);
        moveSelectText = "What will " + currentPokemon.getName() + " do?";
    }

    private void initBattleTextures() {
        List<String> partyIconPaths = new ArrayList<String>();
        for (Pokemon p: gsm.getParty()) {
            partyIconPaths.add(p.getMiniIconPath());
        }
        battleTextures = new BattleTextures(currentPokemon.getBackPath(),
                enemyPokemon.getMapIconPath(), partyIconPaths, currentPokemon);
        battleUpdater = new BattleUpdater(this, battleTextures.getRegularFont());
    }

    private void loadCries() {
        playerCries = new ArrayList<Sound>();
        for (int i = 0; i < gsm.getParty().size(); i++) {
            playerCries.add(Gdx.audio.newSound(
                    Gdx.files.internal(gsm.getParty().get(i).getCryPath())));
        }
    }

    private void loadTrainerCries() {
        trainerCries = new ArrayList<Sound>();
        for (int i = 0; i < trainer.getParty().size(); i++) {
            trainerCries.add(Gdx.audio.newSound(
                    Gdx.files.internal(trainer.getParty().get(i).getCryPath())));
        }
    }

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
            batch.draw(battleTextures.getInitPanel(), 0, 0);
        } else if (panelPosition == BATTLE_PANEL) {
            drawMovesPanel(batch);
        } else if (panelPosition == BAG_OPTION_PANEL) {
            batch.draw(battleTextures.getBagOptionPanel(), 0, 0);
        } else if (panelPosition == POKEBALL_BAG) {
            drawPokeballBag(batch);
        } else if (panelPosition == POKEMON_SELECT_PANEL) {
            drawPokemonSelectPanel(batch);
        }
        if (battleUpdater.displayingYesNo()) {
            batch.draw(battleTextures.getYesNo(), 760, 950);
        }
    }
    private void renderBackground(SpriteBatch batch) {
        //Draw Background
        batch.draw(battleTextures.getBattleBackground(), 0, 1205);

        //Draw animation background when the health bars disappear and the field disappears
        //momentarily.
        battleUpdater.renderAnimationBackground(batch);
    }
    private void renderUI(SpriteBatch batch) {
        renderHealthUI(batch);

    }
    private void renderBattlingPokemon(SpriteBatch batch) {
        if ((battleType == WILD_BATTLE && pta.isFinished()) ||
                (battleType == TRAINER_BATTLE && trainerAnimation.isFinished())) {
            if (!battleUpdater.started() || battleUpdater.getSkillAnimation() == null
                    || battleUpdater.getSkillAnimation().displayEnemyPokemon()) {

            }
            if (!battleUpdater.started() || battleUpdater.getSkillAnimation() == null) {
                if (!battleUpdater.hidingUserPokemon()) {
                    if (!currentPokemon.isFainted()) {
                        batch.draw(battleTextures.getUserPokemonTexture(), currentPokemon.getPlayerX(), currentPokemon.getPlayerY(), 394, 394);
                    }
                }
                if (!battleUpdater.isHidingEnemyPokemon()) {
                    if (!enemyPokemon.isFainted()) {
                        batch.draw(battleTextures.getEnemyPokemonTexture(), enemyPokemon.getEnemyX(), enemyPokemon.getEnemyY(), 394, 394);
                    }
                }
            } else {
                if (battleUpdater.getSkillAnimation().displayUserPokemon()) {
                    if (!currentPokemon.isFainted()) {
                        if (!battleUpdater.hidingUserPokemon()) {
                            batch.draw(battleTextures.getUserPokemonTexture(), currentPokemon.getPlayerX(),
                                    currentPokemon.getPlayerY(), 394, 394);
                        }
                    }
                }
                if (!battleUpdater.isHidingEnemyPokemon() && battleUpdater.getSkillAnimation().displayEnemyPokemon()) {
                    if (!enemyPokemon.isFainted()) {
                        batch.draw(battleTextures.getEnemyPokemonTexture(), enemyPokemon.getEnemyX(), enemyPokemon.getEnemyY(), 394, 394);
                    }
                }
            }
        } else {
            if (battleType == WILD_BATTLE) {
                batch.draw(battleTextures.getEnemyPokemonTexture(), 591, 1460, 394, 394);
                pta.render(batch);
            } else if (battleType == TRAINER_BATTLE) {
                if (trainerAnimation.isDisplayingTrainerPokemon()) {
                    batch.draw(battleTextures.getEnemyPokemonTexture(), 591, 1460, 394, 394);
                }
                trainerAnimation.render(batch);
            }
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
        if ((battleType == WILD_BATTLE &&  pta.isFinished()) ||
                (battleType == TRAINER_BATTLE && trainerAnimation.isFinished())) {
            batch.draw(battleTextures.getUserHealthPanel(), 432, 1266);
            //User total health, current health, level
            battleTextures.getHealthText().draw(batch, Integer.toString(currentPokemon.getHealthStat()), 888,1325);
            if (currentPokemon.getAnimationHealth() >= 100) {
                battleTextures.getHealthText().draw(batch, Integer.toString(currentPokemon.getAnimationHealth()), 750, 1325);
            } else {
                battleTextures.getHealthText().draw(batch, Integer.toString(currentPokemon.getAnimationHealth()), 785, 1325);
            }
            battleTextures.getNameFont().draw(batch, currentPokemon.getName(), 530,1403);
            if (currentPokemon.getGender() == 'm' || currentPokemon.getGender() == 'M') {
                batch.draw(battleTextures.getMaleIcon(), 808, 1364);
            } else if (currentPokemon.getGender() == 'f' || currentPokemon.getGender() == 'F') {
                batch.draw(battleTextures.getFemaleIcon(), 808, 1364);
            }
            battleTextures.getHealthText().draw(batch, Integer.toString(currentPokemon.getLevel()), 900,1398);
            batch.draw(battleTextures.getGreenHealth(), 712, 1340, Math.round(261 *((1.0 * currentPokemon.getAnimationHealth()) / currentPokemon.getHealthStat())), 14);
            batch.draw(battleTextures.getExpBar(), 578, 1271, (int)((1.0 * currentPokemon.getDisplayedExp() / currentPokemon.getNextLevelExp()) * 441.0), 12); //439 14 width height
            renderPlayerStatus(batch);
        }
        if (battleType != TRAINER_BATTLE || (battleType == TRAINER_BATTLE && trainerAnimation.isDisplayingTrainerPokemon() && !enemyPokemon.isFainted())) {
            batch.draw(battleTextures.getEnemyHealthPanel(), 15, 1779);
            //Enemy level
            battleTextures.getNameFont().draw(batch, enemyPokemon.getName(), 105,1881);
            battleTextures.getHealthText().draw(batch, Integer.toString(enemyPokemon.getLevel()), 488, 1874);
            if (enemyPokemon.getGender() == 'm' || enemyPokemon.getGender() == 'M') {
                batch.draw(battleTextures.getMaleIcon(), 399, 1841);
            } else if (enemyPokemon.getGender() == 'f' || enemyPokemon.getGender() == 'F') {
                batch.draw(battleTextures.getFemaleIcon(), 399, 1841);
            }
            //Enemy Healthbar
            batch.draw(battleTextures.getGreenHealth(), 221, 1818, Math.round(261 * ((1.0 * enemyPokemon.getAnimationHealth()) / enemyPokemon.getHealthStat())), 14);
            //Render the statuses
            renderEnemyStatus(batch);
        }


    }

    @Override
    public void playVictoryBgm() {
        bgm.stop();
        bgm.dispose();
        victoryBgm.setLooping(true);
        victoryBgm.play();
    }

    @Override
    public void disposeBgm() {
        bgm.stop();
        bgm.dispose();
    }

    private void renderPlayerStatus(SpriteBatch batch) {
        if (currentPokemon.getStatus() == Pokemon.Status.BURN) {
            batch.draw(battleTextures.getBurnTexture(), 816, 1365, 80, 40);
        } else if (currentPokemon.getStatus() == Pokemon.Status.FROZEN) {
            batch.draw(battleTextures.getFrozenTexture(), 816, 1365, 80, 40);
        } else if (currentPokemon.getStatus() == Pokemon.Status.PARALYSIS) {
            batch.draw(battleTextures.getParalysisTexture(), 816, 1365, 80, 40);
        } else if (currentPokemon.getStatus() == Pokemon.Status.POISON) {
            batch.draw(battleTextures.getPoisonTexture(), 816, 1365, 80, 40);
        } else if (currentPokemon.getStatus() == Pokemon.Status.SLEEP) {
            batch.draw(battleTextures.getSleepTexture(), 816, 1365, 80, 40);
        }
    }

    private void renderEnemyStatus(SpriteBatch batch) {
        if (enemyPokemon.getStatus() == Pokemon.Status.BURN) {
            batch.draw(battleTextures.getBurnTexture(), 407, 1843, 80, 40);
        } else if (enemyPokemon.getStatus() == Pokemon.Status.FROZEN) {
            batch.draw(battleTextures.getFrozenTexture(), 407, 1843, 80, 40);
        } else if (enemyPokemon.getStatus() == Pokemon.Status.PARALYSIS) {
            batch.draw(battleTextures.getParalysisTexture(), 407, 1843, 80, 40);
        } else if (enemyPokemon.getStatus() == Pokemon.Status.POISON) {
            batch.draw(battleTextures.getPoisonTexture(), 407, 1843, 80, 40);
        } else if (enemyPokemon.getStatus() == Pokemon.Status.SLEEP) {
            batch.draw(battleTextures.getSleepTexture(), 407, 1843, 80, 40);
        }
    }
    private void renderTextPanel(SpriteBatch batch) {
        //Render text panel in the middle
        batch.draw(battleTextures.getTextArea(), 0, 954);

        if ((battleType == WILD_BATTLE && pta.isFinished()) ||
                (battleType == TRAINER_BATTLE && trainerAnimation.isFinished())) {
            if (!justFinishedPta) {
                justFinishedPta = true;
                battleUpdater.initiateFirstAbilities(currentPokemon, enemyPokemon, field);
            }
            if (!battleUpdater.started()) {
                if (!battleUpdater.caughtThePokemon()) {
                    if (!currentPokemon.isOutraging() && !currentPokemon.hasNextTurnSkill()) {
                        battleTextures.getRegularFont().draw(batch, moveSelectText, 54, 1143);
                    }
                }
            } else {
                battleUpdater.renderText(batch);
            }
        } else {
            if (battleType == WILD_BATTLE) {
                pta.renderText(batch);
            } else { //Must be a trainer battle
                trainerAnimation.renderText(batch);
            }
        }
    }
    private void drawPokeballBag(SpriteBatch batch) {
        batch.draw(battleTextures.getBattlePanel(), 0,0);
        drawPokeballs(batch);
        drawNavigationArrows(batch);
    }
    private void drawPokemonSelectPanel(SpriteBatch batch) {
        batch.draw(battleTextures.getPokemonSelectPanel(), 0, 0);
        drawPokemonPanels(batch);
        drawPokemonIcons(batch);
    }
    private void drawPokemonIcons(SpriteBatch batch) {
        for (int i = 0; i < battleTextures.getIconTextures().size(); i++) {
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
            batch.draw(battleTextures.getIconTextures().get(i),
                    xPos, yPos, 128, 128);
        }
    }

    private void drawStatusTexture(SpriteBatch batch, int partyPosition, int statusX, int statusY) {
        if (gsm.getParty().get(partyPosition).getStatus() == Pokemon.Status.BURN) {
            batch.draw(battleTextures.getBurnTexture(), statusX, statusY, 80, 40);
        } else if (gsm.getParty().get(partyPosition).getStatus() == Pokemon.Status.POISON) {
            batch.draw(battleTextures.getPoisonTexture(), statusX, statusY, 80, 40);
        } else if (gsm.getParty().get(partyPosition).getStatus() == Pokemon.Status.FROZEN) {
            batch.draw(battleTextures.getFrozenTexture(), statusX, statusY, 80, 40);
        } else if (gsm.getParty().get(partyPosition).getStatus() == Pokemon.Status.PARALYSIS) {
            batch.draw(battleTextures.getParalysisTexture(), statusX, statusY, 80, 40);
        } else if (gsm.getParty().get(partyPosition).getStatus() == Pokemon.Status.SLEEP) {
            batch.draw(battleTextures.getSleepTexture(), statusX, statusY, 80, 40);
        }
    }
    private void drawPokemonPanels(SpriteBatch batch) {
        batch.draw(battleTextures.getPokemonPanel(), 30, 577);
        batch.draw(battleTextures.getHealthBorder(), 146, 620);
        batch.draw(battleTextures.getPokeSelectGreenHealth(), 147, 621, (int)(318 *
                (1.0 * gsm.getParty().get(0).getCurrentHealth() / gsm.getParty().get(0).getHealthStat())), 25);
        battleTextures.getSmallFont().draw(batch, gsm.getParty().get(0).getName() + "\nLv. " +
                gsm.getParty().get(0).getLevel(), 239, 748);
        drawStatusTexture(batch, 0, 380, 668);
        if (gsm.getParty().size() > 1) {
            batch.draw(battleTextures.getPokemonPanel(), 490, 477);
            batch.draw(battleTextures.getHealthBorder(), 600, 524);
            batch.draw(battleTextures.getPokeSelectGreenHealth(), 601, 525,(int)(318 *
                    (1.0 * gsm.getParty().get(1).getCurrentHealth() / gsm.getParty().get(1).getHealthStat())), 25);
            battleTextures.getSmallFont().draw(batch, gsm.getParty().get(1).getName() + "\nLv. " +
                    gsm.getParty().get(1).getLevel(), 700, 648);
            drawStatusTexture(batch, 1, 850, 568);
            if (gsm.getParty().size() > 2) {
                batch.draw(battleTextures.getPokemonPanel(), 30, 352);
                batch.draw(battleTextures.getHealthBorder(), 146, 393);
                batch.draw(battleTextures.getPokeSelectGreenHealth(), 147, 394,(int)(318 *
                        (1.0 * gsm.getParty().get(2).getCurrentHealth() / gsm.getParty().get(2).getHealthStat())), 25);
                battleTextures.getSmallFont().draw(batch, gsm.getParty().get(2).getName() + "\nLv. " +
                        gsm.getParty().get(2).getLevel(), 239, 523);
                drawStatusTexture(batch, 2, 380, 443);
                if (gsm.getParty().size() > 3) {
                    batch.draw(battleTextures.getPokemonPanel(), 490, 252);
                    batch.draw(battleTextures.getHealthBorder(), 600, 295);
                    batch.draw(battleTextures.getPokeSelectGreenHealth(), 601, 296,(int)(318 *
                            (1.0 * gsm.getParty().get(3).getCurrentHealth() / gsm.getParty().get(3).getHealthStat())), 25);
                    battleTextures.getSmallFont().draw(batch, gsm.getParty().get(3).getName() + "\nLv. " +
                            gsm.getParty().get(3).getLevel(), 700, 423);
                    drawStatusTexture(batch, 3, 850, 343);
                    if (gsm.getParty().size() > 4) {
                        batch.draw(battleTextures.getPokemonPanel(), 30, 127);
                        batch.draw(battleTextures.getHealthBorder(), 146, 165);
                        batch.draw(battleTextures.getPokeSelectGreenHealth(), 147, 166,(int)(318 *
                                (1.0 * gsm.getParty().get(4).getCurrentHealth() / gsm.getParty().get(4).getHealthStat())), 25);
                        battleTextures.getSmallFont().draw(batch, gsm.getParty().get(4).getName() + "\nLv. " +
                                gsm.getParty().get(4).getLevel(), 239, 298);
                        drawStatusTexture(batch, 4, 380, 218);
                        if (gsm.getParty().size() > 5) {
                            batch.draw(battleTextures.getPokemonPanel(), 490, 27);
                            batch.draw(battleTextures.getHealthBorder(), 600, 69);
                            batch.draw(battleTextures.getPokeSelectGreenHealth(), 601, 70, (int)(318 *
                                    (1.0 * gsm.getParty().get(5).getCurrentHealth() / gsm.getParty().get(5).getHealthStat())), 25);
                            battleTextures.getSmallFont().draw(batch, gsm.getParty().get(5).getName() + "\nLv. " +
                                    gsm.getParty().get(5).getLevel(), 700, 198);
                            drawStatusTexture(batch, 0, 850, 118);
                        }
                    }
                }
            }
        }
    }
    private void drawNavigationArrows(SpriteBatch batch) {
        //Check if there is another item past the current page.
        // if (currentItemPage * 4 + 4 < gsm.getBag().getPokeballBag().size()) {
        batch.draw(battleTextures.getRightArrow(), 600, 40);
        // }

        //Check if not on the very first page
        //if (currentItemPage * 4 - 1 > 0) {
        batch.draw(battleTextures.getLeftArrow(), 200, 40);
        // }
    }
    private void drawPokeballs(SpriteBatch batch) {
        if (hasFirstItem()) {
            //Draw first item
            batch.draw(battleTextures.getItemSlotPanel(), 30, 565);
            batch.draw(battleTextures.getFirstItem(), 415, 665, 80, 80);
            battleTextures.getItemDescFont().draw(batch, gsm.getBag().getPokeballBag().get(currentItemPage * 4).getName().toUpperCase() +
                    "x " + gsm.getBag().getPokeballBag().get(currentItemPage * 4).getQuantity(), 60, 720);
            battleTextures.getItemDescFont().draw(batch, gsm.getBag().getPokeballBag().get(currentItemPage * 4).getDescription(),
                    60, 677);
            if (hasSecondItem()) {
                //Draw second item
                batch.draw(battleTextures.getItemSlotPanel(), 548, 565);
                batch.draw(battleTextures.getSecondItem(), 848, 715, 80, 80);
                if (hasThirdItem()) {
                    //Draw third item
                    batch.draw(battleTextures.getItemSlotPanel(), 30, 348);
                    if (hasFourthItem()) {
                        //Draw fourth item
                        batch.draw(battleTextures.getItemSlotPanel(), 548, 348);
                    }
                }
            }
        }
    }
    private void drawMovesPanel(SpriteBatch batch) {
        //Draw battle panel
        batch.draw(battleTextures.getBattlePanel(), 0, 0);
        drawSkills(batch);
        drawSkillNames(batch);
    }
    private void drawSkills(SpriteBatch batch) {
        batch.draw(battleTextures.getFirstSkill(), 6, 555);
        if (battleTextures.getSecondSkill() != null) {
            batch.draw(battleTextures.getSecondSkill(), 548, 555);
        }
        if (battleTextures.getThirdSkill() != null) {
            batch.draw(battleTextures.getThirdSkill(), 6, 348);
        }
        if (battleTextures.getFourthSkill() != null) {
            batch.draw(battleTextures.getFourthSkill(), 548, 348);
        }
    }
    private void drawSkillNames(SpriteBatch batch) {
        //Move names
        battleTextures.getRegularFont().draw(batch,
                currentPokemon.getSkills().get(0).getName(), 141, 708);
        battleTextures.getRegularFont().draw(batch,
                currentPokemon.getSkills().get(0).getCurrentPP() + " / " +
                currentPokemon.getSkills().get(0).getMaxPP(), 320, 630);
        if (currentPokemon.getSkills().size() > 1) {
            battleTextures.getRegularFont().draw(batch,
                    currentPokemon.getSkills().get(1).getName(), 676, 708);
            battleTextures.getRegularFont().draw(batch,
                    currentPokemon.getSkills().get(1).getCurrentPP() + " / " +
                    currentPokemon.getSkills().get(1).getMaxPP(), 860, 630);
            if (currentPokemon.getSkills().size() > 2) {
                battleTextures.getRegularFont().draw(batch,
                        currentPokemon.getSkills().get(2).getName(), 141, 498);
                battleTextures.getRegularFont().draw(batch,
                        currentPokemon.getSkills().get(2).getCurrentPP() + " / " +
                        currentPokemon.getSkills().get(2).getMaxPP(), 320, 423);
                if (currentPokemon.getSkills().size() > 3) {
                    battleTextures.getRegularFont().draw(batch,
                            currentPokemon.getSkills().get(3).getName(), 676, 498);
                    battleTextures.getRegularFont().draw(batch,
                            currentPokemon.getSkills().get(3).getCurrentPP() + " / " +
                            currentPokemon.getSkills().get(3).getMaxPP(), 860, 423);
                }
            }
        }
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



    @Override
    public void update(double dt) {
        if (bgm.getPosition() >= 113.979f) {
            bgm.setPosition(12.889f);
        }
        if (battleType == WILD_BATTLE && !pta.isFinished()) {
           pta.update(dt);
        } else if (battleType == TRAINER_BATTLE && !trainerAnimation.isFinished()) {
            trainerAnimation.update(dt);
        }
        else {
            if (battleUpdater.started()) {
                battleUpdater.update(dt);
                if (isWaitingForNextPokemon()) {
                    panelPosition = POKEMON_SELECT_PANEL;
                }
                if (isWaitingForMoveDeletion()) {
                    panelPosition = BATTLE_PANEL;
                }

            } else {

                if (battleUpdater.caughtThePokemon()) {
                    if (!gsm.isPartyFull()) {
                        gsm.getParty().add(enemyPokemon);
                    } else if (!gsm.isBoxFull()) {
                        enemyPokemon.fullyHeal();
                        gsm.getBox().add(enemyPokemon);
                        //TODO: Save the caught pokemon to the appropriate box in db
                    }
                    if (region != -1) {
                        gsm.saveParty();
                        gsm.setState(new RouteState(gsm, startingRoute, region, isRoute));
                        gsm.playBgm();
                    } else {
                        gsm.saveParty();
                        gsm.setState(new LoadingState(gsm, LoadingState.HUB_STATE));
                        gsm.playBgm();
                    }
                    dispose();
                }
            }
        }

        if (MyInput.clicked()) {
            int x = MyInput.getX();
            int y = MyInput.getY();
            controller.clicked(x, y);
        }
    }


    public void switchUserPokemonTextures() {
        battleTextures.setUserPokemonTexture(new Texture(
                gsm.getParty().get(currentPokemonPosition).getBackPath()));
        currentPokemon = gsm.getParty().get(currentPokemonPosition);
        enemyPokemon.freeFromBinds();
        playUserPokemonCry();
        setNormalMoveSelectText();
        battleTextures.resetSkillButtonTextures(currentPokemon);

    }

    public void switchCurrentPokemon() {
        battleTextures.setUserPokemonTexture(new Texture(
                gsm.getParty().get(currentPokemonPosition).getBackPath()));
        currentPokemon = gsm.getParty().get(currentPokemonPosition);
        enemyPokemon.freeFromBinds();
        battleTextures.resetSkillButtonTextures(currentPokemon);
        setNormalMoveSelectText();
        playUserPokemonCry();
        battleUpdater.finishedFaintSwitch(currentPokemon);
    }

    public void endBattle() {
        victoryBgm.stop();
        gsm.getParty().get(currentPokemonPosition).resetBattleVariables();
        List<Pokemon> preEvolution = new ArrayList<Pokemon>();
        List<Pokemon> evolvedPokemon = new ArrayList<Pokemon>();
        PokemonFactory pf = new PokemonFactory();
        List<Integer> partyIndicies = new ArrayList<Integer>();
            for (int i = 0; i < gsm.getParty().size(); i++) {
            if (gsm.getParty().get(i).hasJustLeveled() &&
                    gsm.getParty().get(i).getLevelUpEvolutionId() != -1) {
                preEvolution.add(gsm.getParty().get(i));
                Pokemon temp = pf.createPokemon(gsm.getParty().get(i)
                        .getLevelUpEvolutionId(), gsm.getParty().get(i));
                Gdx.app.log("evolvename:", temp.getName());
                partyIndicies.add(new Integer(i));
                evolvedPokemon.add(temp);
                gsm.getParty().set(i, temp);
            }
            gsm.getParty().get(i).resetJustLeveled();
        }
        if (battleType != WILD_BATTLE && trainer.givesKantoBadge()) {
            gsm.getPlayer().addKantoBadge();
            gsm.updateBadges();
        }
        if (region != -1) {
            if (evolvedPokemon.size() > 0) {
                gsm.saveParty();
                gsm.setState(new EvolutionState(gsm, preEvolution, evolvedPokemon, partyIndicies, startingRoute, region, isRoute));
            } else {
                gsm.saveParty();
                gsm.playBgm();
                gsm.setState(new RouteState(gsm, startingRoute, region, isRoute));
            }
        } else {
            if (evolvedPokemon.size() > 0) {
                gsm.saveParty();
                gsm.setState(new EvolutionState(gsm, preEvolution, evolvedPokemon, partyIndicies));
            } else {
                gsm.saveParty();
                gsm.playBgm();
                gsm.setState(new LoadingState(gsm, LoadingState.HUB_STATE));
            }
        }
        dispose();
    }

    public void blackedOut() {
        gsm.saveParty();
        gsm.getParty().get(currentPokemonPosition).resetBattleVariables();
        gsm.setState(new LoadingState(gsm, LoadingState.POKECENTER_STATE));
        dispose();
    }

    @Override
    public void dispose() {
        battleUpdater.dispose();
        battleTextures.dispose();
        if (battleType == WILD_BATTLE) {
            pta.dispose();
        } else {
            //DISPOSE TRAINER THINGS.
            if (trainerAnimation != null) {
                trainerAnimation.dispose();
            }
            for (Sound sound: trainerCries) {
                sound.dispose();
            }
        }
        victoryBgm.stop();
        victoryBgm.dispose();
        bgm.stop();
        bgm.dispose();
        for (int i = 0; i < playerCries.size(); i++) {
            playerCries.get(i).dispose();
        }
        if (enemyPokemonCry != null) {
            enemyPokemonCry.dispose();
        }
    }


    public void playEnemyCry() {
        enemyPokemonCry.play();
    }

    public void playUserPokemonCry() {
        playerCries.get(currentPokemonPosition).play();
    }

    public void playTrainerEnemyCry() { trainerCries.get(currentEnemyPosition).play(); }
    public PlayerTrainerAnimation getPlayerTrainerAnimation() {
        return pta;
    }

    public boolean isDisplayingNewMoveYesNoOptions() {
        if (battleUpdater.displayingYesNo()) {
            return true;
        }
        return false;
    }

    public boolean isWaitingForMoveDeletion() {
        if (battleUpdater.waitingForMoveDeletion()) {
            return true;
        }
        return false;
    }

    public boolean isWaitingForNextPokemon() {
        return battleUpdater.waitingForNextPokemon();
    }

    public boolean isOnMainPanel() {
        if (panelPosition == FIRST_PANEL) {
            return true;
        }
        return false;
    }

    public boolean isOnPartyPanel() {
        if (panelPosition == POKEMON_SELECT_PANEL) {
            return true;
        }
        return false;
    }

    public boolean isOnBagOptionPanel() {
        if (panelPosition == BAG_OPTION_PANEL) {
            return true;
        }
        return false;
    }

    public boolean isOnPokeballBagPanel() {
        if (panelPosition == POKEBALL_BAG) {
            return true;
        }
        return false;
    }

    public boolean isOnMoveSelectPanel() {
        if (panelPosition == BATTLE_PANEL) {
            return true;
        }
        return false;
    }


    public boolean hasFirstPokemonOnField() {
        if (currentPokemonPosition == 0) {
            return true;
        }
        return false;
    }

    public boolean hasSecondPokemonOnField() {
        if (currentPokemonPosition == 1) {
            return true;
        }
        return false;
    }

    public boolean hasThirdPokemonOnField() {
        if (currentPokemonPosition == 2) {
            return true;
        }
        return false;
    }

    public boolean hasFourthPokemonOnField() {
        if (currentPokemonPosition == 3) {
            return true;
        }
        return false;
    }

    public boolean hasFifthPokemonOnField() {
        if (currentPokemonPosition == 4) {
            return true;
        }
        return false;
    }

    public boolean hasSixthPokemonOnField() {
        if (currentPokemonPosition == 5) {
            return true;
        }
        return false;
    }

    public boolean hasAFullParty() {
        if (gsm.isPartyFull()) {
            return true;
        }
        return false;
    }

    public boolean hasFullBoxes() {
        if (gsm.isBoxFull()) {
            return true;
        }
        return false;
    }

    public boolean startedAttack() {
        return battleUpdater.started();
    }

    public void setPanelPosition(int newPanel) {
        panelPosition = newPanel;
    }

    public void setCurrentItemPage(int newItemPage) {
        currentItemPage = newItemPage;
    }

    public int getCurrentItemPage() {
        return currentItemPage;
    }

    public void goToMainMenuState() {
        gsm.saveParty();
        gsm.setState(new LoadingState(gsm, LoadingState.POKENAV_MENU));
        gsm.playBgm();
    }

    public void goToRouteState() {
        gsm.saveParty();
        gsm.setState(new RouteState(gsm, startingRoute, region, isRoute));
        gsm.playBgm();
    }

    public boolean cameFromSimulator() {
        if (region != -1) {
            return true;
        }
        return false;
    }

    public void acceptedNewMove() {
        battleUpdater.acceptedNewMove();
    }

    public void declinedNewMove() {
        battleUpdater.declinedNewMove();
    }

    public void playClickSound() {
        clickSound.play();
    }

    public List<Ball> getPokeballBag() {
        return gsm.getBag().getPokeballBag();
    }

    public List<Pokemon> getParty() {
        return gsm.getParty();
    }

    public Pokemon getCurrentPokemon() {
        return currentPokemon;
    }

    public Field getField() { return field; }

    public Pokemon getEnemyPokemon() {
        return enemyPokemon;
    }

    public void removeFirstSkill() {
        battleUpdater.removeFirstSkill();
        panelPosition = FIRST_PANEL;
    }
    public void removeSecondSkill() {
        battleUpdater.removeSecondSkill();
        panelPosition = FIRST_PANEL;
    }
    public void removeThirdSkill() {
        battleUpdater.removeThirdSkill();
        panelPosition = FIRST_PANEL;
    }
    public void removeFourthSkill() {
        battleUpdater.removeFourthSkill();
        panelPosition = FIRST_PANEL;
    }



    public void start(int partyPosition, Skill enemySkill) {
        battleUpdater.start(getParty(), currentPokemon, enemyPokemon,
                currentPokemonPosition, 0, getParty().get(partyPosition),
                enemySkill, field);
    }

    public void start(Skill userSkill, Skill enemySkill) {
        battleUpdater.start(getParty(), currentPokemon, enemyPokemon,
                currentPokemonPosition, 0, userSkill, enemySkill, field);
    }

    public void startPokeballThrow(ItemId pokeballType, Skill enemySkill) {
        battleUpdater.start(getParty(), currentPokemon, enemyPokemon,
                currentPokemonPosition, 0, pokeballType, enemySkill, field);// 0 is speedcheck phase
    }

    public BattleTextures getBattleTextures() {
        return battleTextures;
    }



    //INTERFACE METHODS

    public void stopBgm() {
        bgm.stop();
    }

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

    public void setCurrentPokemonPosition(int newPosition) {
        currentPokemonPosition = newPosition;
    }

    public void setCurrentPokemon(Pokemon poke) {
        this.currentPokemon = poke;
        setNormalMoveSelectText();
    }

    @Override
    public void removeBattleVariablesFromCurrentPokemon() {
        gsm.getParty().get(currentPokemonPosition).resetBattleVariables();
    }

    /**
     * Transfer the Battle Variables that say even when a Pokemon faints
     * or switches out (Future Sight, Wish, Doom Desire, etc)
     * @param newCurrentPokemonPosition The Pokemon receiving the Battle Variables
     */
    @Override
    public void transferPositionalBattleVariables(int newCurrentPokemonPosition) {
        gsm.getParty().get(newCurrentPokemonPosition).receiveTransferrableBattleVariables(
                gsm.getParty().get(currentPokemonPosition));
    }

    @Override
    public void setNoSwitchText() {
        moveSelectText = currentPokemon.getName() + " cannot switch out!";
    }

    @Override
    public void setNormalMoveSelectText() {
        moveSelectText = "What will " + currentPokemon.getName() + " do?";
    }

    @Override
    public boolean isFinishedIntroAnimation() {
        if (battleType == WILD_BATTLE && pta.isFinished()) {
            return true;
        } else if (battleType == TRAINER_BATTLE && trainerAnimation.isFinished()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean hasWipedOutTrainer() {
        for (int i = 0; i < enemyParty.size(); i++) {
            if (enemyParty.get(i).getCurrentHealth() != 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int getBattleType() {
        return battleType;
    }

    @Override
    public boolean isWildBattle() {
        if (battleType == TRAINER_BATTLE) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Trainer getTrainer() {
        return trainer;
    }

    @Override
    public String getNextPokemonName() {
        for (int i = 0; i < 6; i++) {
            if (enemyParty.get(i).getCurrentHealth() != 0) {
                return enemyParty.get(i).getName();
            }
        }
        return "error";
    }

    @Override
    public Pokemon setNextEnemyPokemon() {
        for (int i = 0; i < enemyParty.size(); i++) {
            if (enemyParty.get(i).getCurrentHealth() != 0) {
                currentEnemyPosition = i;
                enemyPokemon = enemyParty.get(i);
                battleTextures.disposeEnemyPokemonTexture();
                battleTextures.setNewEnemyPokemonTexture(enemyPokemon.getMapIconPath());
                trainerCries.get(i).play();
                return enemyPokemon;
            }
        }
        return null;
    }



}
