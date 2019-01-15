package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/14/2017.
 */
public class PokemonPartyState extends GameState {
    private GameStateManager gsm;
    private Texture background;
    private Texture panel;
    private Texture emptyPanel;
    private Texture healthBar;
    private Texture greenHealth;
    private Texture orangeHealth;
    private Texture redHealth;
    private Texture title;
    private List<Texture> pokemonIcons;
    private BitmapFont nameFont;
    private Texture popupWindow;
    private Texture selected;

    private int selectedPokemon;
    private boolean openedWindow;

    public PokemonPartyState(GameStateManager gsm) {
        this.gsm = gsm;
        initTextures();
        nameFont = new BitmapFont(Gdx.files.internal("pokemonMenu/nameFont.fnt"));
        nameFont.setColor(Color.WHITE);
        selectedPokemon = -1;
    }

    private void initTextures() {
        background = new Texture("simulator/background.png");
        panel = new Texture("pokemonMenu/pokeball.png");
        emptyPanel = new Texture("pokemonMenu/emptypokeball.png");
        healthBar = new Texture("pokemonMenu/healthbar.png");
        greenHealth = new Texture("pokemonMenu/green.png");
        orangeHealth = new Texture("pokemonMenu/orange.png");
        redHealth = new Texture("pokemonMenu/red.png");
        title = new Texture("pokemonMenu/title.png");
        popupWindow = new Texture("pokemonMenu/window.png");
        selected = new Texture("pokemonMenu/selected.png");
        pokemonIcons = new ArrayList<Texture>();
        pokemonIcons.add(new Texture(gsm.getParty().get(0).getMapIconPath()));
        for (int i = 1; i < gsm.getParty().size(); i++) {
            pokemonIcons.add(new Texture(gsm.getParty().get(i).getMapIconPath()));
        }
        openedWindow = false;
    }
    @Override
    public void render(SpriteBatch batch) {
        batch.draw(background, 0,0);
        batch.draw(title, 238, 1760);
        //Draw First Panel
        if (selectedPokemon == 0) {
            batch.draw(selected, 40, 1156);
        } else {
            batch.draw(panel, 40, 1156);
        }
        nameFont.draw(batch, "Lv. " + Integer.toString(gsm.getParty().get(0).getLevel()) + " " + gsm.getParty().get(0).getName(),
                formatNamePosition(0, "Lv. " + Integer.toString(gsm.getParty().get(0).getLevel()) + " " + gsm.getParty().get(0).getName()),1695);
        batch.draw(pokemonIcons.get(0), 101, 1212, 350, 350);
        int currentHealth = gsm.getParty().get(0).getCurrentHealth();
        int totalHealth = gsm.getParty().get(0).getHealthStat();
        batch.draw(healthBar, 48,1146);
        batch.draw(getHealthTexture(currentHealth, totalHealth), 57, 1156, (int)(465 *
                (1.0 * currentHealth / totalHealth)), 51);

        if (hasSecondPokemon()) {
            drawSecondPokemon(batch);
        } else {
            batch.draw(emptyPanel, 592, 1156);
        }

        if (hasThirdPokemon()) {
            drawThirdPokemon(batch);
        } else {
            batch.draw(emptyPanel, 40, 572);
        }

        if (hasFourthPokemon()) {
            drawFourthPokemon(batch);
        } else {
            batch.draw(emptyPanel, 592, 572);
        }

        if (hasFifthPokemon()) {
            drawFifthPokemon(batch);
        } else {
            batch.draw(emptyPanel, 40, 18);
        }

        if (hasSixthPokemon()) {
            drawSixthPokemon(batch);
        } else {
            batch.draw(emptyPanel, 592, 18);
        }

        if (openedWindow) {
            batch.draw(popupWindow, 274, 745);
        }
    }

    private int formatNamePosition(int position, String nameText) {
        int origin;
        if (position == 0 || position == 2 || position == 4) {
            origin = 284;
            origin -= getTextSizeValue(nameText);
        } else {
            origin = 816;
            origin -= getTextSizeValue(nameText);
        }
        return origin;
    }

    private int getTextSizeValue(String text) {
        int val = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'i' || text.charAt(i) == 'l' || text.charAt(i) == '.') {
                val += 8;
            } else {
                val += 16;
            }
        }
        return val;
    }
    private void drawSecondPokemon(SpriteBatch batch) {
        if (selectedPokemon == 1) {
            batch.draw(selected, 592, 1156);
        } else {
            batch.draw(panel, 592, 1156);
        }

        String nameText = "Lv. " + Integer.toString(gsm.getParty().get(1).getLevel()) +
                " " + gsm.getParty().get(1).getName();
        int currentHealth = gsm.getParty().get(1).getCurrentHealth();
        int totalHealth = gsm.getParty().get(1).getHealthStat();

        nameFont.draw(batch, nameText, formatNamePosition(1, nameText),1695);
        batch.draw(pokemonIcons.get(1), 640, 1212, 350, 350);
        batch.draw(healthBar, 600,1146);
        batch.draw(getHealthTexture(currentHealth, totalHealth), 609, 1156, (int)(465 *
                (1.0 * currentHealth / totalHealth)), 51);
    }

    private void drawThirdPokemon(SpriteBatch batch) {
        if (selectedPokemon == 2) {
            batch.draw(selected, 40, 578);
        } else {
            batch.draw(panel, 40, 578);
        }
        String name =  "Lv. " + Integer.toString(gsm.getParty().get(2).getLevel()) + " " + gsm.getParty().get(2).getName();
        int currentHealth = gsm.getParty().get(2).getCurrentHealth();
        int totalHealth = gsm.getParty().get(2).getHealthStat();
        nameFont.draw(batch, name, formatNamePosition(0, name), 1117);
        batch.draw(pokemonIcons.get(2), 101, 634, 350, 350);
        batch.draw(healthBar, 48, 568);
        batch.draw(getHealthTexture(currentHealth, totalHealth), 57, 578, (int)(465 *
                (1.0 * currentHealth / totalHealth)), 51);
    }

    private void drawFourthPokemon(SpriteBatch batch) {
        if (selectedPokemon == 3) {
            batch.draw(selected, 592, 578);
        } else {
            batch.draw(panel, 592, 578);
        }

        String nameText = "Lv. " + Integer.toString(gsm.getParty().get(3).getLevel()) +
                " " + gsm.getParty().get(3).getName();
        int currentHealth = gsm.getParty().get(3).getCurrentHealth();
        int totalHealth = gsm.getParty().get(3).getHealthStat();

        nameFont.draw(batch, nameText, formatNamePosition(3, nameText),1117);
        batch.draw(pokemonIcons.get(3), 640, 634, 350, 350);
        batch.draw(healthBar, 600, 568);
        batch.draw(getHealthTexture(currentHealth, totalHealth), 609, 578, (int)(465 *
                (1.0 * currentHealth / totalHealth)), 51);
    }


    private void drawFifthPokemon(SpriteBatch batch) {
        if (selectedPokemon == 4) {
            batch.draw(selected, 40, 18);
        } else {
            batch.draw(panel, 40, 18);
        }
        String name =  "Lv. " + Integer.toString(gsm.getParty().get(4).getLevel()) + " " + gsm.getParty().get(4).getName();
        int currentHealth = gsm.getParty().get(4).getCurrentHealth();
        int totalHealth = gsm.getParty().get(4).getHealthStat();
        nameFont.draw(batch, name, formatNamePosition(4, name), 557);
        batch.draw(pokemonIcons.get(4), 101, 74, 350, 350);
        batch.draw(healthBar, 48, 8);
        batch.draw(getHealthTexture(currentHealth, totalHealth), 57, 18, (int)(465 *
                (1.0 * currentHealth / totalHealth)), 51);
    }

    private void drawSixthPokemon(SpriteBatch batch) {
        if (selectedPokemon == 5) {
            batch.draw(selected, 592, 18);
        } else {
            batch.draw(panel, 592, 18);
        }

        String nameText = "Lv. " + Integer.toString(gsm.getParty().get(5).getLevel()) +
                " " + gsm.getParty().get(5).getName();
        int currentHealth = gsm.getParty().get(5).getCurrentHealth();
        int totalHealth = gsm.getParty().get(5).getHealthStat();

        nameFont.draw(batch, nameText, formatNamePosition(5, nameText), 557);
        batch.draw(pokemonIcons.get(5), 640, 74, 350, 350);
        batch.draw(healthBar, 600, 8);
        batch.draw(getHealthTexture(currentHealth, totalHealth), 609, 18, (int)(465 *
                (1.0 * currentHealth / totalHealth)), 51);
    }

    /**
     * Swap the pokemon in position's position and selectedPokemon
     * @param position
     */
    private void swapPokemon(int position) {
        Pokemon temp = gsm.getParty().get(selectedPokemon);
        gsm.getParty().set(selectedPokemon, gsm.getParty().get(position));
        gsm.getParty().set(position, temp);
        Texture textureTemp = pokemonIcons.get(selectedPokemon);
        pokemonIcons.set(selectedPokemon, pokemonIcons.get(position));
        pokemonIcons.set(position, textureTemp);
        selectedPokemon = -1;
    }

    private Texture getHealthTexture(int currentHealth, int totalHealth) {
        if (currentHealth > totalHealth * 0.4) {
            return greenHealth;
        } else if (currentHealth > totalHealth * 0.25) {
            return orangeHealth;
        } else {
            return redHealth;
        }
    }

    @Override
    public void update(double dt) {
        if (MyInput.clicked()) {
            int x = MyInput.getX();
            int y = MyInput.getY();
            Gdx.app.log("party", x + ", " + y);
            if (x >= 980 && x <= 1080 && y >= 0 && y <= 100) {
                gsm.saveParty();
                gsm.setState(new LoadingState(gsm, LoadingState.POKENAV_MENU));
                dispose();
            } else if (x >= 15 && x <= 479 && y >= 331 && y <= 714 && !openedWindow) {
                //clicked first pokemon
                clickedPokemon(0);
            } else if (x >= 579 && x <= 1080 && y >= 331 && y <= 714 && !openedWindow) {
                //clicked second pokemon
                clickedPokemon(1);
            } else if (x >= 15 && x <= 479 && y >= 965 && y <= 1283 && !openedWindow) {
                //clicked third pokemon
                clickedPokemon(2);
            } else if (x >= 579 && x <= 1080 && y >= 965 && y <= 1283 && !openedWindow) {
                //clicked fourth pokemon
                clickedPokemon(3);
            } else if (x >= 15 && x <= 479 && y >= 1560 && y <= 1920 && !openedWindow) {
                //clicked fifth pokemon
                clickedPokemon(4);
            } else if (x >= 579 && x <= 1080 && y >= 1560 && y <= 1920 && !openedWindow) {
                //clicked fifth pokemon
                clickedPokemon(5);
            } else if (x >= 269 && x <= 765 && y>= 1080 && y <= 1194 && openedWindow) {
                    openedWindow = false;
                    selectedPokemon = -1;
            } else if (x >= 269 && x <= 765 && y>= 924 && y <= 1031 && openedWindow) {
                    openedWindow = false;
            } else if (x >= 269 && x <= 765 && y>= 767 && y <= 900 && openedWindow) {
                    openedWindow = false;
                    gsm.setState(new StatusState(gsm, gsm.getParty().get(selectedPokemon), false));
                    dispose();
            }
        }
    }

    private void clickedPokemon(int position) {
        if (hasPokemon(position)) {
            if (selectedPokemon < 0) {
                if (!openedWindow) {
                    openedWindow = true;
                    selectedPokemon = position;
                }
            } else {
                swapPokemon(position);
            }
        }
    }

    private boolean hasPokemon(int position) {
        if (gsm.getParty().size() > position) {
            return true;
        }
        return false;
    }
    private boolean hasSecondPokemon() {
        if (gsm.getParty().size() > 1) {
            return true;
        }
        return false;
    }

    private boolean hasThirdPokemon() {
        if (gsm.getParty().size() > 2) {
            return true;
        }
        return false;
    }

    private boolean hasFourthPokemon() {
        if (gsm.getParty().size() > 3) {
            return true;
        }
        return false;
    }

    private boolean hasFifthPokemon() {
        if (gsm.getParty().size() > 4) {
            return true;
        }
        return false;
    }

    private boolean hasSixthPokemon() {
        if (gsm.getParty().size() > 5) {
            return true;
        }
        return false;
    }

    @Override
    public void dispose() {
        background.dispose();
        panel.dispose();
        emptyPanel.dispose();
        healthBar.dispose();
        greenHealth.dispose();
        orangeHealth.dispose();
        redHealth.dispose();
        title.dispose();
        nameFont.dispose();
        for (int i = 0; i < pokemonIcons.size(); i++) {
            pokemonIcons.get(i).dispose();
        }
        popupWindow.dispose();
        selected.dispose();

    }
}
