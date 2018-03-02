package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.box.BoxLocation;
import com.pokemon.toronto.game.com.pokemon.toronto.box.BoxPokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 7/19/2017.
 */

public class BoxState extends GameState {

    private final int CLICKED_PARTY_POKEMON = 0;
    private final int CLICKED_BOX_POKEMON = 1;

    private final int TOP_BOX_OFFSET = 1090;
    private final int LEFT_BOX_OFFSET = 30;
    private final int X_CLICK_SIZE = 160;
    private final int X_CLICK_OFFSET = 10;
    private final int Y_CLICK_SIZE = 160;
    private final int Y_CLICK_OFFSET = 10;
    private final int BOX_COLUMNS = 6;
    private final int BOX_ROWS = 5;


    private GameStateManager gsm;
    private Texture background;
    private Texture statusBackground;
    private Texture popUp;
    private Texture selector;
    private Pokemon selectedPokemon;
    private Texture selectedPokemonTexture;
    private List<Texture> partyTextures;
    private List<Texture> boxTextures;

    private boolean openPopUp;
    private int selectedPartySlot;
    private int selectedBoxSlot;

    private BitmapFont font;
    private Music bgm;
    private Sound clickSound;
    private Music bootingSound;
    private Sound logoutSound;
    private Sound errorSound;
    private Sound depositSound;
    private Sound switchSound;
    private boolean playedBootSound;
    private boolean startedBgm;
    private boolean displayingStatusWindow;

    private int currentBox;
    private List<BoxPokemon> partyBoxPokemon;

    public BoxState(GameStateManager gsm, boolean cameFromPokeNav) {
        this.gsm = gsm;
        initPartyBox();
        gsm.getPC().initNullLocations();
        currentBox = 0;
        setNoPokemonSelection();
        openPopUp = false;
        displayingStatusWindow = false;
        font = new BitmapFont(Gdx.files.internal("battle/font/regularFont.fnt"));
        bgm = Gdx.audio.newMusic(Gdx.files.internal("pokecenter/bgm.mp3"));
        clickSound = Gdx.audio.newSound(Gdx.files.internal("sounds/click.wav"));
        bootingSound = Gdx.audio.newMusic(Gdx.files.internal("sounds/bootpc.wav"));
        logoutSound = Gdx.audio.newSound(Gdx.files.internal("sounds/logout.wav"));
        errorSound = Gdx.audio.newSound(Gdx.files.internal("sounds/error.wav"));
        depositSound = Gdx.audio.newSound(Gdx.files.internal("sounds/deposit.wav"));
        switchSound = Gdx.audio.newSound(Gdx.files.internal("sounds/switch.wav"));
        if (!cameFromPokeNav) {
            playedBootSound = true;
        } else {
            playedBootSound = false;
        }
        startedBgm = false;
        bgm.setLooping(true);
        bgm.setVolume(0.25f);
        bootingSound.setLooping(false);

        font.setColor(Color.BLACK);
        selectedPokemon = null;
        initTextures();
    }

    private void initPartyBox() {

        partyBoxPokemon = new ArrayList<BoxPokemon>();
        for (int i = 0; i < gsm.getParty().size(); i++) {
                partyBoxPokemon.add(new BoxPokemon(gsm.getParty().get(i),
                        new BoxLocation(gsm.getPC().PARTY, i)));
        }
        for (int i = 0; i < 6 - gsm.getParty().size(); i++) {
            partyBoxPokemon.add(new BoxPokemon(null,
                    new BoxLocation(gsm.getPC().PARTY, i)));
        }
    }

    private void initTextures() {
        background = new Texture("pokemonpc/boxbackground.png");
        statusBackground = new Texture("pokemonMenu/statusScreen.png");
        popUp = new Texture("pokemonpc/popup.png");
        selector = new Texture("pokemonpc/selector.png");
        selectedPokemonTexture = null;
        initPartyTextures();
        initBoxTextures();
    }

    private void initPartyTextures() {
        partyTextures = new ArrayList<Texture>();
        for (int i = 0; i < gsm.getParty().size(); i++) {
            partyTextures.add(new Texture(gsm.getParty().get(i).getMiniIconPath()));
        }
    }

    private void initBoxTextures() {
        boxTextures = new ArrayList<Texture>();
        for (int i = 0; i < gsm.getPC().getBox(currentBox).size(); i++) {
            if (gsm.getPC().getBox(currentBox).get(i).getPokemon() != null) {
                boxTextures.add(new Texture(gsm.getPC().getBox(currentBox).get(i).getPokemon().getMiniIconPath()));
            } else {
                boxTextures.add(null);
            }
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        if (displayingStatusWindow) {
            renderStatusWindow(batch);
        } else {
            //Render Background
            batch.draw(background, 0, 0);
            //Render Selector
            renderSelector(batch);
            //Render Mini Pokemon
            renderMiniPokemon(batch);
            //Render Selected Pokemon
            renderSelectedPokemon(batch);
            //Render Description
            renderSelectedPokemonDescription(batch);
            //Render Pop up
            renderPopUp(batch);
        }
    }

    private void renderSelectedPokemon(SpriteBatch batch) {
        if (selectedPokemonTexture != null) {
            batch.draw(selectedPokemonTexture, 624, 1460, 394, 394);
        }
    }
    private void renderSelectedPokemonDescription(SpriteBatch batch) {
        if (selectedPokemon != null) {
            font.draw(batch, selectedPokemon.getName() +
                    "\nLv. " + selectedPokemon.getLevel() +
                    "\nNature: " + selectedPokemon.getNatureString() +
                    "\nAbility: " + selectedPokemon.getAbilityName() +
                    "\nItem: None" , 624, 1405);
        }
    }
    private void renderMiniPokemon(SpriteBatch batch) {
        renderPartyPokemon(batch);
        renderBoxPokemon(batch);
    }
    private void renderPartyPokemon(SpriteBatch batch) {
        batch.draw(partyTextures.get(0), 113, 1477, 128, 128);
        if (partyTextures.size() > 1) {
            batch.draw(partyTextures.get(1), 288, 1399, 128, 128);
            if (partyTextures.size() > 2) {
                batch.draw(partyTextures.get(2), 113, 1324, 128, 128);
                if (partyTextures.size() > 3) {
                    batch.draw(partyTextures.get(3), 288, 1252, 128, 128);
                    if (partyTextures.size() > 4) {
                        batch.draw(partyTextures.get(4), 113, 1183, 128, 128);
                        if (partyTextures.size() > 5) {
                            batch.draw(partyTextures.get(5), 288, 1108, 128, 128);
                        }
                    }
                }
            }
        }
    }
    private void renderBoxPokemon(SpriteBatch batch) {
        for (int i = 0; i < boxTextures.size(); i++) {
            if (boxTextures.get(i) != null) {
                int y = getYFromRow(getPokemonBoxPositionRow(i));
                int x = getXFromColumn(getPokemonBoxPositionColumn(i));
                batch.draw(boxTextures.get(i), x, y, 160, 160);
            }
        }
    }

    private int getXFromColumn(int column) {
        return 30 + (column * 165);
    }
    private int getYFromRow(int row) {
        return 700 - (row * 165);
    }

    /**
     * Return the row position of the Pokemon's texture in the box at
     * position index
     * @param index The position of the pokemon in the box.
     * @return
     */
    private int getPokemonBoxPositionRow(int index) {
        return index / 6;
    }

    /**
     * Return the column position of the Pokemon's texture in the box at
     * position index
     * @param index The position of the pokemon in the box.
     * @return
     */
    private int getPokemonBoxPositionColumn(int index) {
        return index % 6;
    }

    private void renderSelector(SpriteBatch batch) {
        if (selectedAPartyPokemon()) {
            if (selectedPartySlot == 0) {
                batch.draw(selector, 100, 1475);
            } else if (selectedPartySlot == 1) {
                batch.draw(selector, 277, 1399);
            } else if (selectedPartySlot == 2) {
                batch.draw(selector, 100, 1322);
            } else if (selectedPartySlot == 3) {
                batch.draw(selector, 277, 1252);
            } else if (selectedPartySlot == 4) {
                batch.draw(selector, 100, 1181);
            } else if (selectedPartySlot == 5) {
                batch.draw(selector, 277, 1108);
            }
        } else if (selectedABoxPokemon()) {
            int y = getYFromRow(getPokemonBoxPositionRow(selectedBoxSlot)) + 20;
            int x = getXFromColumn(getPokemonBoxPositionColumn(selectedBoxSlot));
            batch.draw(selector, x, y);

        }

    }
    
    private void renderStatusWindow(SpriteBatch batch) {
        batch.draw(statusBackground, 0, 0);
        batch.draw(selectedPokemonTexture, 75, 1338, 340, 340);
        renderNameAndItemBox(batch);
        renderStatBox(batch);
        renderInfoBox(batch);
        renderEvBox(batch);
        renderIvBox(batch);
        renderMoveNames(batch);
    }

    private void renderMoveNames(SpriteBatch batch) {
        font.draw(batch, selectedPokemon.getSkills().get(0).getName(), 20, 1008);
        font.draw(batch, "PP    " + selectedPokemon.getSkills().get(0).getCurrentPP() +
                "/" + selectedPokemon.getSkills().get(0).getCurrentPP(), 20, 948);
        if (selectedPokemon.getSkills().size() > 1) {
            font.draw(batch, selectedPokemon.getSkills().get(1).getName(), 20, 858);
            font.draw(batch, "PP    " + selectedPokemon.getSkills().get(1).getCurrentPP() +
                    "/" + selectedPokemon.getSkills().get(1).getCurrentPP(), 20, 798);
            if (selectedPokemon.getSkills().size() > 2) {
                font.draw(batch, selectedPokemon.getSkills().get(2).getName(), 20, 708);
                font.draw(batch, "PP    " + selectedPokemon.getSkills().get(2).getCurrentPP() +
                        "/" + selectedPokemon.getSkills().get(2).getCurrentPP(), 20, 648);
                if (selectedPokemon.getSkills().size() > 3) {
                    font.draw(batch, selectedPokemon.getSkills().get(3).getName(), 20, 558);
                    font.draw(batch, "PP    " + selectedPokemon.getSkills().get(3).getCurrentPP() +
                            "/" + selectedPokemon.getSkills().get(3).getCurrentPP(), 20, 498);
                }
            }
        }
    }
    private void renderEvBox(SpriteBatch batch) {
        font.draw(batch, selectedPokemon.getHealthEV() + "", 431, 342);
        font.draw(batch, selectedPokemon.getAttackEV() + "", 431, 294);
        font.draw(batch, selectedPokemon.getDefenseEV() + "", 431, 246);
        font.draw(batch, selectedPokemon.getSpAttackEV() + "", 431, 198);
        font.draw(batch, selectedPokemon.getSpDefenseEV() + "", 431, 156);
        font.draw(batch, selectedPokemon.getSpeedEV() + "", 431, 105);
    }

    private void renderIvBox(SpriteBatch batch) {
        font.draw(batch, selectedPokemon.getHealthIV() + "", 935, 342);
        font.draw(batch, selectedPokemon.getAttackIV() + "", 935, 294);
        font.draw(batch, selectedPokemon.getDefenseIV() + "", 935, 246);
        font.draw(batch, selectedPokemon.getSpAttackIV() + "", 935, 198);
        font.draw(batch, selectedPokemon.getSpDefenseIV() + "", 935, 156);
        font.draw(batch, selectedPokemon.getSpeedIV() + "", 935, 105);
    }

    private void renderNameAndItemBox(SpriteBatch batch) {
        font.draw(batch, selectedPokemon.getName() +
                "\nLv." + selectedPokemon.getLevel(), 42, 1812);
        font.draw(batch, selectedPokemon.getCurrentHealth() + "/" +
                selectedPokemon.getHealthStat(), 918, 1701);
        font.draw(batch, "None", 15, 1227);
    }

    private void renderInfoBox(SpriteBatch batch) {
        font.draw(batch, selectedPokemon.getId() +"", 828, 1062);
        font.draw(batch, selectedPokemon.getName(), 828, 993);
        font.draw(batch, selectedPokemon.getNatureString(), 828, 849);
        font.draw(batch, "" + Math.round(selectedPokemon.getDisplayedExp()), 828, 774);
        font.draw(batch, "" +  (selectedPokemon.getNextLevelExp()
                - Math.round(selectedPokemon.getDisplayedExp())), 828, 700);
        font.draw(batch, selectedPokemon.getAbilityName(), 828, 633);
    }
    private void renderStatBox(SpriteBatch batch) {
        font.draw(batch, selectedPokemon.getAttackStat() +"", 957, 1605);
        font.draw(batch, selectedPokemon.getDefenseStat() +"", 957, 1548);
        font.draw(batch, selectedPokemon.getSpecialAttackStat() +"", 957, 1491);
        font.draw(batch, selectedPokemon.getSpecialDefenseStat() +"", 957, 1422);
        font.draw(batch, selectedPokemon.getSpeedStat() +"", 957, 1365);
    }

    private void renderPopUp(SpriteBatch batch) {
        if (openPopUp) {
            batch.draw(popUp, 22, 500);
        }
    }

    @Override
    public void update(double dt) {
        if (!playedBootSound) {
            bootingSound.play();
            playedBootSound = true;
        }
        if (!startedBgm && playedBootSound && !bootingSound.isPlaying()) {
            startedBgm = false;
            bgm.play();
        }
        if (MyInput.clicked()) {
            int x = MyInput.getX();
            int y = MyInput.getY();
            Gdx.app.log("Coords", "x: " + x + ", y: " + y);
            if (!displayingStatusWindow) {
                if (openPopUp) {
                    if (clickedSummary(x, y)) {
                        openSummaryPage();
                    } else if (clickedRelease(x, y)) {
                        openReleasePage();
                    } else if (clickedCancel(x, y)) {
                        errorSound.play();
                        openPopUp = false;
                        setNoPokemonSelection();
                    }
                } else {
                    if (clickedLogout(x, y)) {
                        //testLogout();
                        logOut();
                    } else if (clickedDescriptionArea(x, y)) {
                        clickedDescriptionArea();
                    }
                    checkPartyClick(x, y);
                    checkBoxClick(x, y);

                }
            } else {
                if (clickedExitStatusWindow(x, y)) {
                    exitStatusWindow();
                }
            }
        }
    }

    private boolean clickedExitStatusWindow(int x, int y) {
       if (x >= 852 && x <= 1080 && y >= 0 && y <= 160) {
           return true;
       }
       return false;
    }

    private void exitStatusWindow() {
        errorSound.play();
        displayingStatusWindow = false;
        setNoPokemonSelection();
    }
    private boolean clickedDescriptionArea(int x, int y) {
        if (x >= 572 && x <= 1014 && y >= 54 && y <= 849) {
            return true;
        }
        return false;
    }

    private void clickedDescriptionArea() {
        if (selectedAPokemon()) {
            clickSound.play();
            openPopUp = true;
        }
    }
    private boolean clickedSummary(int x, int y) {
        if (x >= 128 && x <= 959 && y >= 818 && y <= 919) {
            return true;
        }
        return false;
    }

    private boolean clickedRelease(int x, int y) {
        if (x >= 44 && x <= 972 && y >= 998 && y <= 1101) {
            return true;
        }
        return false;
    }

    private boolean clickedCancel(int x, int y) {
        if (x >= 103 && x <= 944 && y >= 1218 && y <= 1309) {
            return true;
        }
        return false;
    }

    private boolean clickedLogout(int x, int y) {
        if (x >= 12 && x <= 332 && y >= 16 && y <= 157) {
            return true;
        }
        return false;
    }

    private void openSummaryPage() {
        clickSound.play();
        displayingStatusWindow = true;
        openPopUp = false;
        /*gsm.setState(new StatusState(gsm, selectedPokemon, true));
        dispose();*/
    }

    private void openReleasePage() {
        openPopUp = false;

        if (selectedABoxPokemon()) {
            //-2 is new null
            gsm.getPC().getBox(currentBox).set(selectedBoxSlot,
                    new BoxPokemon(null, new BoxLocation(-2, -2)));
            Texture temp = boxTextures.get(selectedBoxSlot);
            boxTextures.set(selectedBoxSlot, null);
            temp.dispose();
        } else if (selectedAPartyPokemon()) {
            if (gsm.getParty().size() != 1) {
                gsm.getParty().remove(selectedPartySlot);
                partyBoxPokemon.set(selectedPartySlot,
                        new BoxPokemon(null, new BoxLocation(-2, -2)));
                Texture temp = partyTextures.get(selectedPartySlot);
                partyTextures.remove(selectedPartySlot);
                temp.dispose();
            }
        }
        setNoPokemonSelection();
    }

    private void checkPartyClick(int x, int y) {
        if (x >= 112 && x <= 248 && y >= 323 && y <= 429) {
            justClickedSlot(CLICKED_PARTY_POKEMON, 0);
        } else if (x >= 306 && x <= 456 && y >= 424 && y <= 528) {
            justClickedSlot(CLICKED_PARTY_POKEMON, 1);
        } else if (x >= 112 && x <= 248 && y >= 487 && y <= 622) {
            justClickedSlot(CLICKED_PARTY_POKEMON, 2);
        } else if (x >= 306 && x <= 456 && y >= 577 && y <= 668) {
            justClickedSlot(CLICKED_PARTY_POKEMON, 3);
        } else if (x >= 112 && x <= 248 && y >= 634 && y <= 748) {
            justClickedSlot(CLICKED_PARTY_POKEMON, 4);
        } else if (x >= 306 && x <= 456 && y >= 717 && y <= 817) {
            justClickedSlot(CLICKED_PARTY_POKEMON, 5);
        }
    }

    private void checkBoxClick(int x, int y) {
        int clickIndex = getBoxClickIndex(x, y);
        if (clickIndex != -1) {
            justClickedSlot(CLICKED_BOX_POKEMON, clickIndex);
        }
    }

    /**
     * Execute a click after it was in position clickPosition in
     * the clickZone
     * @param clickZone Either the box or the party
     * @param clickPosition The index of the clicked pokemon
     */
    private void justClickedSlot(int clickZone, int clickPosition) {
        if (!selectedAPokemon()) {
            if (clickZone == CLICKED_PARTY_POKEMON) {
                if (gsm.getParty().size() >= clickPosition + 1) {
                    //Make sure that there is a pokemon in the slot before selecting.
                    selectedPartySlot = clickPosition;
                    selectedPokemon = gsm.getParty().get(clickPosition);
                    setSelectedPokemonTexture(clickZone, clickPosition);
                    clickSound.play();
                }
            } else if (clickZone == CLICKED_BOX_POKEMON) {
                selectedBoxSlot = clickPosition;
                if (gsm.getPC().getBox(currentBox).get(selectedBoxSlot).getPokemon() != null) {
                    selectedPokemon = gsm.getPC().getBox(currentBox).get(clickPosition).getPokemon();
                    setSelectedPokemonTexture(clickZone, clickPosition);
                    clickSound.play();
                } else {
                    selectedBoxSlot = -1;
                }

            }

        } else {
            if (selectedTheSamePokemon(clickZone, clickPosition)) {
                setNoPokemonSelection();
            } else {
                //Swap pokemon.
                swap(clickZone, clickPosition);
            }
        }
    }

    private void swap(int clickZone, int clickPosition) {
        if (selectedAPartyPokemon() && clickZone == CLICKED_PARTY_POKEMON) {
            //Swap party with another party member
            if (gsm.getParty().size() >= clickPosition + 1) {
                switchSound.play();
                Texture temp = partyTextures.get(selectedPartySlot);
                Pokemon tempPokemon = gsm.getParty().get(selectedPartySlot);
                BoxPokemon tempPartyPokemon = partyBoxPokemon.get(selectedPartySlot);
                partyTextures.set(selectedPartySlot, partyTextures.get(clickPosition));
                partyTextures.set(clickPosition, temp);
                gsm.getParty().set(selectedPartySlot, gsm.getParty().get(clickPosition));
                gsm.getParty().set(clickPosition, tempPokemon);
                partyBoxPokemon.set(selectedPartySlot, partyBoxPokemon.get(clickPosition));
                partyBoxPokemon.set(clickPosition, tempPartyPokemon);
                setNoPokemonSelection();
            }
        } else if (selectedAPartyPokemon() && clickZone == CLICKED_BOX_POKEMON) {
            //Swap party to box
            if (gsm.getPC().getBox(currentBox).get(clickPosition).getPokemon() != null) {
                switchSound.play();
                Texture temp = partyTextures.get(selectedPartySlot);
                Pokemon tempPokemon = gsm.getParty().get(selectedPartySlot);
                tempPokemon.fullyHeal();
                partyTextures.set(selectedPartySlot, boxTextures.get(clickPosition));
                boxTextures.set(clickPosition, temp);

                //Party gets Box Pokemon
                gsm.getParty().set(selectedPartySlot, gsm.getPC().getBox(currentBox).get(clickPosition).getPokemon());
                //Create temp of box BoxPokemon
                BoxPokemon tempWithdrawnPokemon = gsm.getPC().getBox(currentBox).get(clickPosition);
                //Box gets Party Pokemon.
                gsm.getPC().depositPartyPokemon(partyBoxPokemon.get(selectedPartySlot), currentBox, clickPosition);
                partyBoxPokemon.set(selectedPartySlot, tempWithdrawnPokemon);
                setNoPokemonSelection();
            } else {
                if (gsm.getParty().size() != 1) {
                    deposit(clickPosition);
                    setNoPokemonSelection();
                }
            }
        } else if (selectedABoxPokemon() && clickZone == CLICKED_BOX_POKEMON) {
            //Swap box to box
                switchSound.play();
                if (gsm.getPC().getBox(currentBox).get(clickPosition).getPokemon() == null) {
                    //Move the first Pokemon to the empty position
                    boxTextures.set(clickPosition, boxTextures.get(selectedBoxSlot));
                    boxTextures.set(selectedBoxSlot, null);
                    BoxPokemon tempPokemon = gsm.getPC().getBox(currentBox).get(selectedBoxSlot);
                    gsm.getPC().getBox(currentBox).set(selectedBoxSlot, gsm.getPC().getBox(currentBox).get(clickPosition));
                    gsm.getPC().getBox(currentBox).set(clickPosition, tempPokemon);
                } else {
                    //Swap the two Pokemon
                    Gdx.app.log("BoxState", "swap box");
                    Texture temp = boxTextures.get(selectedBoxSlot);
                    BoxPokemon tempPokemon = gsm.getPC().getBox(currentBox).get(selectedBoxSlot);
                    boxTextures.set(selectedBoxSlot, boxTextures.get(clickPosition));
                    boxTextures.set(clickPosition, temp);
                    gsm.getPC().getBox(currentBox).set(selectedBoxSlot, gsm.getPC().getBox(currentBox).get(clickPosition));
                    gsm.getPC().getBox(currentBox).set(clickPosition, tempPokemon);
                }
                setNoPokemonSelection();
        } else if (selectedABoxPokemon() && clickZone == CLICKED_PARTY_POKEMON) {
            if (gsm.getParty().size() >= clickPosition + 1) {
                switchSound.play();
                Texture temp = boxTextures.get(selectedBoxSlot);
                BoxPokemon tempPokemon = gsm.getPC().getBox(currentBox).get(selectedBoxSlot);
                boxTextures.set(selectedBoxSlot, partyTextures.get(clickPosition));
                partyTextures.set(clickPosition, temp);
                gsm.getPC().depositPartyPokemon(partyBoxPokemon.get(clickPosition), currentBox, selectedBoxSlot);
                gsm.getPC().getBox(currentBox).get(selectedBoxSlot).getPokemon().fullyHeal();
                gsm.getParty().set(clickPosition, tempPokemon.getPokemon());
                partyBoxPokemon.set(clickPosition, tempPokemon);
                setNoPokemonSelection();
            } else {
                withdraw();
                setNoPokemonSelection();
            }
        }
    }

    private void deposit(int clickPosition) {
        Gdx.app.log("BoxState", "deposit: " + selectedPartySlot);
        depositSound.play();
        gsm.getParty().get(selectedPartySlot).fullyHeal();
        Gdx.app.log("BoxState", "deposited " + partyBoxPokemon.get(selectedPartySlot).getPokemon().getName());
        gsm.getPC().depositPartyPokemon(partyBoxPokemon.get(selectedPartySlot), currentBox, clickPosition);
        gsm.getParty().remove(selectedPartySlot);
        //-2 is NOT_NULL
        partyBoxPokemon.remove(selectedPartySlot); //remove that so the rest can shoot up.
        partyBoxPokemon.add(new BoxPokemon(null, new BoxLocation(gsm.getPC().NEW_NULL, gsm.getPC().NEW_NULL)));
        boxTextures.set(clickPosition, partyTextures.get(selectedPartySlot));
        partyTextures.remove(selectedPartySlot);
    }

    private void withdraw() {
        depositSound.play();
        printPartyBoxPokemon();
        gsm.getParty().add(gsm.getPC().getBox(currentBox).get(selectedBoxSlot).getPokemon());
        partyBoxPokemon.set(gsm.getParty().size() - 1, gsm.getPC().getBox(currentBox).get(selectedBoxSlot));
        gsm.getPC().removePokemon(currentBox, selectedBoxSlot);
        gsm.getPC().printBox(currentBox);
        partyTextures.add(boxTextures.get(selectedBoxSlot));
        boxTextures.set(selectedBoxSlot, null);
        Gdx.app.log("pbpokemon", "" + selectedBoxSlot);
        printPartyBoxPokemon();


    }

    private void printPartyBoxPokemon() {
        for (int i = 0; i < partyBoxPokemon.size(); i++) {
            if (partyBoxPokemon.get(i).getPokemon() != null) {
                Gdx.app.log("pbpokemon", partyBoxPokemon.get(i).getPokemon().getName());
            } else {
                Gdx.app.log("pbpokemon", "null");
            }
        }
    }
    private boolean selectedTheSamePokemon(int clickZone, int clickPosition) {
        if (selectedAPartyPokemon() && clickZone == CLICKED_PARTY_POKEMON && clickPosition == selectedPartySlot) {
            return true;
        } else if (selectedABoxPokemon() && clickZone == CLICKED_BOX_POKEMON && clickPosition == selectedBoxSlot) {
            return true;
        }
        return false;
    }

    /**
     * Set the texture of the pokemon in the top right select box.
     * @param clickZone The pokemon's location, box or party
     * @param clickPosition The pokemon's index in the box or party
     */
    private void setSelectedPokemonTexture(int clickZone, int clickPosition) {
        if (clickZone == CLICKED_BOX_POKEMON) {
            setSelectedPokemonTexture(gsm.getPC().getBox(currentBox).get(clickPosition).getPokemon().getMapIconPath());
        } else if (clickZone == CLICKED_PARTY_POKEMON) {
            setSelectedPokemonTexture(gsm.getParty().get(clickPosition).getMapIconPath());
        }
    }

    /**
     * Set the texture of the pokemon in the top right select box.
     * @param path The path of the texture
     */
    private void setSelectedPokemonTexture(String path) {
        disposeSelectedPokemonTexture();
        selectedPokemonTexture = new Texture(path);
    }

    private void logOut() {
        gsm.getGameCallBack().createProgressDialog("Shutting Down PC",
                "Please wait while we save your Pokemon.");

        List<BoxLocation> lbl = gsm.getPC().getDeletableNulls();
        for (int i = 0; i < lbl.size(); i++) {
            gsm.deleteBoxes(lbl);
        }
        List<BoxLocation> updateLocations = gsm.getPC().logout();
        for (int i = 0; i < updateLocations.size(); i++) {
            gsm.updateBoxes(updateLocations);
        }
        //
        gsm.saveParty();
        gsm.getGameCallBack().dismissProgressDialog();
        logoutSound.play();
        //todo: save boxes if they were tampered.
        gsm.setState(new LoadingState(gsm, LoadingState.HUB_STATE));
        dispose();
        gsm.playBgm();
    }

    private void testLogout() {
        gsm.getPC().printBox(currentBox);
        List<BoxLocation> lbl = gsm.getPC().getDeletableNulls();
        for (int i = 0; i < lbl.size(); i++) {
            Gdx.app.log("dbx", "delete - box: " + lbl.get(i).getBoxNumber() + " pos: " +
                    lbl.get(i).getBoxPosition());
        }
        Gdx.app.log("testlogout", "done");
        for (int i = 0; i < gsm.getParty().size(); i++) {
            Gdx.app.log("testlogout", "poke: " + gsm.getParty().get(i).getName());
        }
        List<BoxLocation> updateLocations = gsm.getPC().logout();
        for (int i = 0; i < updateLocations.size(); i++) {
            Gdx.app.log("dbx", "update - box: " + updateLocations.get(i).getBoxNumber()
                    + " pos: " + updateLocations.get(i).getBoxPosition() + " {" +
                    gsm.getPC().getBox(updateLocations.get(i).getBoxNumber())
                            .get(updateLocations.get(i).getBoxPosition()).getPokemon().getName() + "}");
        }
        gsm.getPC().printBox(currentBox);
        initPartyBox();
        gsm.getPC().initNullLocations();
    }

    public boolean selectedAPokemon() {
        if (!selectedABoxPokemon() && !selectedAPartyPokemon()) {
            return false;
        }
        return true;
    }

    private boolean selectedAPartyPokemon() {
        if (selectedPartySlot != -1) {
            return true;
        }
        return false;
    }

    private boolean selectedABoxPokemon() {
        if (selectedBoxSlot != -1) {
            return true;
        }
        return false;
    }

    private void setNoPokemonSelection() {
        selectedPartySlot = -1;
        selectedBoxSlot = -1;
        selectedPokemon = null;
        disposeSelectedPokemonTexture();
    }


    /**
     * Return the index of the pokemon that was clicked in the box at the click
     * position (x, y). Return -1 if the click position is not on a pokemon.
     * @param x The x coordinate of the click
     * @param y The y position of the click
     * @return The index of the pokemon that was clicked on in the box
     */
    private int getBoxClickIndex(int x, int y) {
        if (clickedInRow(y) && clickedInColumn(x)) {
            int row = getRow(y);
            if (yCoordinateIsInClickZone(row, y)) {
                int col = getColumn(x);
                if (xCoordinateIsInClickZone(col, x)) {
                    return row * BOX_COLUMNS + col;
                }
            }

        }
        return -1;
    }

    private boolean clickedInColumn(int x) {
        if (x >= LEFT_BOX_OFFSET && x <= getBoxRightOffset()) {
            return true;
        }
        return false;
    }

    private boolean clickedInRow(int y) {
        if (y >= TOP_BOX_OFFSET && y <= getBoxBottomOffset()) {
            return true;
        }
        return false;
    }

    private int getRow(int y) {
        return (y - TOP_BOX_OFFSET) / getBoxPokemonTotalHeight();
    }

    private int getColumn(int x) {
        return (x - LEFT_BOX_OFFSET) / getBoxPokemonTotalWidth();
    }

    private boolean yCoordinateIsInClickZone(int row, int y) {
        if (y >= getLowerBoundY(row) && y <= getUpperBoundY(row)) {
            return true;
        }
        return false;
    }

    private int getLowerBoundY(int row) {
        return TOP_BOX_OFFSET + (getBoxPokemonTotalHeight() * row);
    }

    private int getUpperBoundY(int row) {
        return TOP_BOX_OFFSET + (getBoxPokemonTotalHeight() * row) + Y_CLICK_SIZE;
    }

    private boolean xCoordinateIsInClickZone(int col, int x) {
        if (x >= getLowerBoundX(col) && x <= getUpperBoundX(col)) {
            return true;
        }
        return false;
    }

    private int getLowerBoundX(int col) {
        return LEFT_BOX_OFFSET + (col * getBoxPokemonTotalWidth());
    }

    private int getUpperBoundX(int col) {
        return LEFT_BOX_OFFSET + (col * getBoxPokemonTotalWidth()) + X_CLICK_SIZE;
    }


    private int getBoxPokemonTotalWidth() {
        return X_CLICK_OFFSET + X_CLICK_SIZE;
    }

    private int getBoxPokemonTotalHeight() {
        return Y_CLICK_OFFSET + Y_CLICK_SIZE;
    }

    private int getBoxBottomOffset() {
        return TOP_BOX_OFFSET + (getBoxPokemonTotalHeight() * BOX_ROWS);
    }

    private int getBoxRightOffset() {
        return LEFT_BOX_OFFSET + (getBoxPokemonTotalWidth() * BOX_COLUMNS);
    }
    @Override
    protected void dispose() {
        background.dispose();
        statusBackground.dispose();
        popUp.dispose();
        selector.dispose();
        font.dispose();
        disposeSounds();
        bgm.stop();
        bgm.dispose();
        disposePartyTextures();
        disposeBoxTextures();
        disposeSelectedPokemonTexture();
    }

    private void disposeSounds() {
        clickSound.dispose();
        bootingSound.dispose();
        logoutSound.dispose();
        errorSound.dispose();
        depositSound.dispose();
        switchSound.dispose();
    }

    private void disposeSelectedPokemonTexture() {
        if (selectedPokemonTexture != null) {
            selectedPokemonTexture.dispose();
            selectedPokemonTexture = null;
        }
    }

    private void disposePartyTextures() {
        for (int i = 0; i < partyTextures.size(); i++) {
            partyTextures.get(i).dispose();
        }
    }

    private void disposeBoxTextures() {
        for (int i = 0; i < boxTextures.size(); i++) {
            if (boxTextures.get(i) != null) {
                boxTextures.get(i).dispose();
            }
        }
    }
}
