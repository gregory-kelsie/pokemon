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

    /** Constants */
    private final int KANTO = 0;

    /** Instance Variables */
    private GameStateManager gsm;
    private int region;
    private Texture background;
    private Sound clickSound;

    /**
     * Create a navigation menu for the region.
     * Ex: Routes, Dungeons, Gyms, Special Trainers.
     * @param gsm A callback to the GameStateManager to switch states.
     * @param region The region in which the navigation menu is built
     *               around.
     */
    public RegionMenu(GameStateManager gsm, int region) {
        this.gsm = gsm;
        this.region = region;
        background = new Texture("simulator/region_menu/menu.png");
        clickSound = Gdx.audio.newSound(Gdx.files.internal("sounds/click.wav"));
    }

    /**
     * Render the RegionMenu.
     * @param batch The SpriteBatch the RegionMenu state is drawn to.
     */
    @Override
    public void render(SpriteBatch batch) {
        if (region == KANTO) {
            batch.draw(background, 0, 0);
        }
    }

    /**
     * Update the RegionMenu over time or after click.
     * @param dt The time elapsed.
     */
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

    /**
     * Go to a route RouteState.
     */
    private void clickedRoutes() {
        clickSound.play();
        gsm.setState(new RouteState(gsm, 1, KANTO, true));
        dispose();
    }

    /**
     * Execute clicking on the gym button.
     */
    private void clickedGyms() {
        clickSound.play();
        gsm.setState(new KantoGymState(gsm));
        dispose();
    }

    /**
     * Go to the cave RouteState
     */
    private void clickedCaves() {
        clickSound.play();
        gsm.setState(new RouteState(gsm, 1, KANTO, false));
        dispose();
    }

    /**
     * Go to the page of special trainers for the selected region.
     */
    private void clickedSpecialBattles() {
        clickSound.play();
    }

    /**
     * Return to the RegionSelect state.
     */
    private void clickedPowerButton() {
        clickSound.play();
        gsm.setState(new RegionSelect(gsm));
        dispose();
    }

    /**
     * Dispose of the textures and sounds for the RegionMenu.
     */
    @Override
    protected void dispose() {
        background.dispose();
        clickSound.dispose();
    }
}
