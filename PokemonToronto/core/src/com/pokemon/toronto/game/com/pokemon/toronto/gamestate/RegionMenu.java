package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;

/**
 * Created by Gregory on 7/25/2017.
 */

public class RegionMenu extends GameState {
    private final int KANTO = 0;
    private GameStateManager gsm;
    private int region;

    private Texture background;
    private Sound clickSound;

    public RegionMenu(GameStateManager gsm, int region) {
        this.gsm = gsm;
        this.region = region;
        background = new Texture("simulator/region_menu/menu.png");
        clickSound = Gdx.audio.newSound(Gdx.files.internal("sounds/click.wav"));
    }

    @Override
    public void render(SpriteBatch batch) {
        if (region == KANTO) {
            batch.draw(background, 0, 0);
        }
    }

    @Override
    public void update(double dt) {
        if (MyInput.clicked()) {
            int x = MyInput.getX();
            int y = MyInput.getY();
            if (x >= 911 && x <= 1080 && y >= 0 && y <= 136) {
                clickedPowerButton();
            } else if (y >= 341 && y <= 562) {
                clickedRoutes();
            } else if (y >= 654 && y <= 838) {
                clickedCaves();
            } else if (y >= 978 && y <= 1187) {
                clickedGyms();
            } else if (y >= 1303 && y <= 1513) {
                clickedSpecialBattles();
            }
            Gdx.app.log("Region", "x: " + MyInput.getX() + ", y: " + MyInput.getY());
        }
    }

    private void clickedRoutes() {
        clickSound.play();
        gsm.setState(new RouteState(gsm, 1, KANTO, true));
        dispose();
    }

    private void clickedGyms() {
        clickSound.play();
        gsm.setState(new KantoGymState(gsm));
        dispose();
    }

    private void clickedCaves() {
        clickSound.play();
        gsm.setState(new RouteState(gsm, 1, KANTO, false));
        dispose();
    }

    private void clickedSpecialBattles() {
        clickSound.play();
    }

    private void clickedPowerButton() {
        clickSound.play();
        gsm.setState(new RegionSelect(gsm));
        dispose();
    }

    @Override
    protected void dispose() {
        background.dispose();
        clickSound.dispose();
    }
}
