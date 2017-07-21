package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
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
    private Texture popUp;
    private Texture selector;
    private Texture selectedPokemonTexture;
    private List<Texture> partyTextures;
    private List<Texture> boxTextures;

    private boolean openPopUp;
    private int selectedPartySlot;
    private int selectedBoxSlot;
    private int justClickedSlot;

    public BoxState(GameStateManager gsm) {
        this.gsm = gsm;
        setNoPokemonSelection();
        openPopUp = false;
        initTextures();
    }

    private void initTextures() {
        background = new Texture("pokemonpc/boxbackground.png");
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
        for (int i = 0; i <gsm.getBox().size(); i++) {
            boxTextures.add(new Texture(gsm.getBox().get(i).getMiniIconPath()));
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        //Render Background
        batch.draw(background, 0, 0);
        //Render Selector
        renderSelector(batch);
        //Render Mini Pokemon
        renderMiniPokemon(batch);
        //Render Selected Pokemon
        renderSelectedPokemon(batch);
        //Render Pop up
        renderPopUp(batch);
    }

    private void renderSelectedPokemon(SpriteBatch batch) {
        if (selectedPokemonTexture != null) {
            batch.draw(selectedPokemonTexture, 624, 1460, 394, 394);
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
            int y = getYFromRow(getPokemonBoxPositionRow(i));
            int x = getXFromColumn(getPokemonBoxPositionColumn(i));
            batch.draw(boxTextures.get(i), x, y, 160, 160);
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

    private void renderPopUp(SpriteBatch batch) {
        if (openPopUp) {
            batch.draw(popUp, 22, 500);
        }
    }

    @Override
    public void update(double dt) {
        if (MyInput.clicked()) {
            int x = MyInput.getX();
            int y = MyInput.getY();
            Gdx.app.log("Coords", "x: " + x + ", y: " + y);
            if (openPopUp) {
                if (clickedSummary(x, y)) {
                    openSummaryPage();
                } else if (clickedRelease(x, y)) {
                    openReleasePage();
                } else if (clickedCancel(x, y)) {
                    openPopUp = false;
                    setNoPokemonSelection();
                }
            }
            else {
                if (clickedLogout(x, y)) {
                    logOut();
                }
                checkPartyClick(x, y);
                checkBoxClick(x, y);

            }
        }
    }

    private boolean clickedSummary(int x, int y) {
        return false;
    }

    private boolean clickedRelease(int x, int y) {
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

    }

    private void openReleasePage() {

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
        /*
        if (x >= 30 && x <= 135 && y >= 1090 && y <= 1174) {
            justClickedSlot(CLICKED_BOX_POKEMON, 0);
        } else if (x >= 233 && x <= 330 && y >= 1090 && y <= 1174) {
            justClickedSlot(CLICKED_BOX_POKEMON, 1);
        }  else if (x >= 30 && x <= 135 && y >= 1267 && y <= 1364) {
            justClickedSlot(CLICKED_BOX_POKEMON, 6);
        }*/
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
                selectedPartySlot = clickPosition;
            } else if (clickZone == CLICKED_BOX_POKEMON) {
                selectedBoxSlot = clickPosition;
            }
            setSelectedPokemonTexture(clickZone, clickPosition);
        } else {
            if (selectedTheSamePokemon(clickZone, clickPosition)) {
                openPopUp = true;
            } else {
                //Swap pokemon.
                swap(clickZone, clickPosition);
            }
        }
    }

    private void swap(int clickZone, int clickPosition) {
        if (selectedAPartyPokemon() && clickZone == CLICKED_PARTY_POKEMON) {
            //Swap party with another party member
            Texture temp = partyTextures.get(selectedPartySlot);
            Pokemon tempPokemon = gsm.getParty().get(selectedPartySlot);
            partyTextures.set(selectedPartySlot, partyTextures.get(clickPosition));
            partyTextures.set(clickPosition, temp);
            gsm.getParty().set(selectedPartySlot, gsm.getParty().get(clickPosition));
            gsm.getParty().set(clickPosition, tempPokemon);
            setNoPokemonSelection();
        } else if (selectedAPartyPokemon() && clickZone == CLICKED_BOX_POKEMON) {
            //Swap party to box
            Texture temp = partyTextures.get(selectedPartySlot);
            Pokemon tempPokemon = gsm.getParty().get(selectedPartySlot);
            partyTextures.set(selectedPartySlot, boxTextures.get(clickPosition));
            boxTextures.set(clickPosition, temp);
            gsm.getParty().set(selectedPartySlot, gsm.getBox().get(clickPosition));
            gsm.getBox().set(clickPosition, tempPokemon);
            setNoPokemonSelection();
        } else if (selectedABoxPokemon() && clickZone == CLICKED_BOX_POKEMON) {
            //Swap box to box
            Texture temp = boxTextures.get(selectedBoxSlot);
            Pokemon tempPokemon = gsm.getBox().get(selectedBoxSlot);
            boxTextures.set(selectedBoxSlot, boxTextures.get(clickPosition));
            boxTextures.set(clickPosition, temp);
            gsm.getBox().set(selectedBoxSlot, gsm.getBox().get(clickPosition));
            gsm.getBox().set(clickPosition, tempPokemon);
            setNoPokemonSelection();
        } else if (selectedABoxPokemon() && clickZone == CLICKED_PARTY_POKEMON) {
            Texture temp = boxTextures.get(selectedBoxSlot);
            Pokemon tempPokemon = gsm.getBox().get(selectedBoxSlot);
            boxTextures.set(selectedBoxSlot, partyTextures.get(clickPosition));
            partyTextures.set(clickPosition, temp);
            gsm.getBox().set(selectedBoxSlot, gsm.getParty().get(clickPosition));
            gsm.getParty().set(clickPosition, tempPokemon);
            setNoPokemonSelection();
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
            setSelectedPokemonTexture(gsm.getBox().get(clickPosition).getMapIconPath());
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
        gsm.setState(new LoadingState(gsm, LoadingState.POKENAV_MENU));
        dispose();
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
        popUp.dispose();
        selector.dispose();
        disposePartyTextures();
        disposeBoxTextures();
        disposeSelectedPokemonTexture();
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
            boxTextures.get(i).dispose();
        }
    }
}
