package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 7/25/2017.
 */

public class RegionSelect extends GameState {

    private final int KANTO_BUTTON = 0;
    private final int JOHTO_BUTTON = 1;
    private final int HOENN_BUTTON = 2;
    private final int SINNOH_BUTTON = 3;
    private final int UNOVA_BUTTON = 4;
    private final int KALOS_BUTTON = 5;
    private final int ALOLA_BUTTON = 6;

    private final int TOP_BUTTON_Y = 1167;
    private final int SPACE_BETWEEN_BUTTONS = 550;

    private GameStateManager gsm;
    private int scrollAmount;

    private Texture background;
    private Texture title;
    private Texture upArrow;
    private Texture downArrow;
    private List<Texture> regionButtons;

    private Sound clickSound;

    public RegionSelect(GameStateManager gsm) {
        this.gsm = gsm;
        scrollAmount = 0;
        background = new Texture("simulator/background.png");
        title = new Texture("simulator/gen_select/title.png");
        upArrow = new Texture("simulator/gen_select/up.png");
        downArrow = new Texture("simulator/gen_select/down.png");
        regionButtons = new ArrayList<Texture>();
        regionButtons.add(new Texture("simulator/gen_select/kanto.png"));
        regionButtons.add(new Texture("simulator/gen_select/johto.png"));
        regionButtons.add(new Texture("simulator/gen_select/hoenn.png"));
        clickSound = Gdx.audio.newSound(Gdx.files.internal("sounds/click.wav"));
    }
    @Override
    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 0);
        batch.draw(title, 240, 1744);
        renderArrows(batch);
        renderButtons(batch);

    }

    private void renderArrows(SpriteBatch batch) {
        if (scrollAmount != 0) {
            batch.draw(upArrow, 357, 1680);
        }
        if (scrollAmount + 3 < regionButtons.size()) {
            batch.draw(downArrow, 357, 0);
        }
    }

    private void renderButtons(SpriteBatch batch) {
        for (int i = 0; i < 3; i++) {
            batch.draw(regionButtons.get(scrollAmount + i), 0,
                    TOP_BUTTON_Y - (i * SPACE_BETWEEN_BUTTONS));
        }
    }

    @Override
    public void update(double dt) {
        if (MyInput.clicked()) {
            int x = MyInput.getX();
            int y = MyInput.getY();
            if (x >= 911 && x <= 1080 && y >= 0 && y <= 136) {
                clickedPowerButton();
            } else if (y >= 364 && y <= 707) {
                clickedTopButton();
            } else if (y >= 923 && y <= 1324) {
                clickedMiddleButton();
            } else if (y >= 1511 && y <= 1879) {
                clickedBottomButton();
            } else if (x >= 358 && x <= 722 && y >= 1880 && y <= 1920) {
                clickedDownArrow();
            } else if (x >= 337 && x <= 681 && y >= 174 && y <= 255) {
                clickedUpArrow();
            }
            Gdx.app.log("Region", "x: " + MyInput.getX() + ", y: " + MyInput.getY());

        }
    }

    private void clickedTopButton() {
        clickedButton(scrollAmount);
    }

    private void clickedMiddleButton() {
        clickedButton(scrollAmount + 1);
    }

    private void clickedBottomButton() {
        clickedButton(scrollAmount + 2);
    }

    private void clickedButton(int buttonLocation) {
        if (buttonLocation == KANTO_BUTTON) {
            clickSound.play();
            gsm.setState(new RegionMenu(gsm, KANTO_BUTTON));
            dispose();
        }
    }

    private void clickedDownArrow() {
        if (scrollAmount + 3 < regionButtons.size()) {
            scrollAmount++;
            clickSound.play();
        }
    }

    private void clickedUpArrow() {
        if (scrollAmount != 0) {
            scrollAmount--;
            clickSound.play();
        }
    }

    private void clickedPowerButton() {
        clickSound.play();
        gsm.setState(new LoadingState(gsm, LoadingState.POKENAV_MENU));
        dispose();
    }

    @Override
    protected void dispose() {
        background.dispose();
        title.dispose();
        upArrow.dispose();
        downArrow.dispose();
        for (Texture regionButton: regionButtons) {
            regionButton.dispose();
        }
        clickSound.dispose();
    }
}
