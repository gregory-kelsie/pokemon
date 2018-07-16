package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.area.RouteStateModel;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer;

/**
 * Created by gregorykelsie on 2018-02-03.
 */

public class SimulatorState extends GameState {
    private GameStateManager gsm;

    private Texture background;
    private Texture gymIcon;
    private Texture hamburgerIcon;
    private Texture wildButton;
    private Texture surfButton;
    private Texture rodButton;

    private Texture regionSelectIcon;
    private Texture regionSelectWindow;
    private Texture slider;

    private Texture routeNameLabel;
    private Texture routeImage;
    private Texture lock;

    private BitmapFont routeNumberFont;
    private BitmapFont routeFont;

    private Music wildBgm;

    private RouteStateModel routeStateModel;
    private boolean updateRouteImage;
    private boolean startedBattle;

    public SimulatorState(GameStateManager gsm) {
        this.gsm = gsm;
        initResources();
        routeStateModel = new RouteStateModel();
        routeImage = new Texture(routeStateModel.getRoute().getImagePath());
        updateRouteImage = false;
        startedBattle = false;
    }

    public SimulatorState(GameStateManager gsm, int region, int routeNumber) {
        this.gsm = gsm;
        initResources();
        routeStateModel = new RouteStateModel(region, routeNumber);
        routeImage = new Texture(routeStateModel.getRoute().getImagePath());
        updateRouteImage = false;
        startedBattle = false;
    }

    private void initResources() {
        Gdx.app.log("simulator", "init resources");
        background = new Texture("simulator/background.png");
        gymIcon = new Texture("simulator/gymicon.png");
        hamburgerIcon = new Texture("simulator/hamburgermenu.png");
        wildButton = new Texture("simulator/wildbutton.png");
        surfButton = new Texture("simulator/surfbutton.png");
        rodButton = new Texture("simulator/rodbutton.png");

        regionSelectIcon = new Texture("simulator/selector.png");
        regionSelectWindow = new Texture("simulator/regionselect.png");
        slider = new Texture("simulator/slider.png");

        routeNameLabel = new Texture("simulator/banner.png");
        lock = new Texture("simulator/lock.png");
        wildBgm = Gdx.audio.newMusic(Gdx.files.internal("sounds/wildBgm.mp3"));

        routeNumberFont = new BitmapFont(Gdx.files.internal("simulator/routeNumberFont.fnt"));
        routeFont = new BitmapFont(Gdx.files.internal("simulator/routeFont.fnt"));
    }
    public void render(SpriteBatch batch) {
        Gdx.app.log("simulator", "render");
        batch.draw(background, 0, 0);
        batch.draw(hamburgerIcon, 29, 1791);
        batch.draw(gymIcon, 274, 1765);
        batch.draw(rodButton, 51, 7);
        batch.draw(surfButton, 51, 246);
        batch.draw(wildButton, 51, 472);
        batch.draw(slider, 59, 699);
        batch.draw(routeImage, 35, 849);
        batch.draw(routeNameLabel, 48, 1187);
        routeFont.draw(batch, routeStateModel.getRoute().getName(), getRouteNameOffset(), 1316);
        drawSliderInfo(batch);
        if (routeStateModel.isWindowOpened()) {
            drawWindow(batch);
        }
        if (!routeStateModel.getRoute().isAvailable(gsm.getPlayer())) {
            batch.draw(lock, 85, 1438);
        }
    }

    private int getRouteNameOffset() {
        int namePixelLength = getNamePixelLength();
        if (namePixelLength >= 990) {
            return 49;
        } else {
            int difference = 990 - namePixelLength;
            return 49 + (int) Math.round(difference / 2.0);
        }
    }

    private int getNamePixelLength() {
        String name = routeStateModel.getRoute().getName();
        int length = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ' ') {
                length += 10;
            } else if (name.charAt(i) == 'l' || name.charAt(i) == '1' || name.charAt(i) == 'i') {
                length += 20;
            } else {
                length += 50;
            }
        }
        return length;
    }

    private void drawSliderInfo(SpriteBatch batch) {
        String routeNumber;
        String length;
        if (routeStateModel.getRouteNumber() + 1 < 10) {
            routeNumber = "0" + Integer.toString(routeStateModel.getRouteNumber() + 1);
        } else {
            routeNumber = Integer.toString(routeStateModel.getRouteNumber() + 1);
        }
        if (routeStateModel.getNumRoutes() < 10) {
            length = "0" + Integer.toString(routeStateModel.getNumRoutes());
        } else {
            length = Integer.toString(routeStateModel.getNumRoutes());
        }
        routeNumberFont.draw(batch, routeNumber + "/" + length, 457, 779);
    }

    private void drawWindow(SpriteBatch batch) {
        batch.draw(regionSelectWindow, 0, 465);
        if (routeStateModel.getRegion() == routeStateModel.KANTO) {
            batch.draw(regionSelectIcon, 70, 1497);
        } else if (routeStateModel.getRegion() == routeStateModel.JOHTO) {
            batch.draw(regionSelectIcon, 70, 1357);
        }
    }

    public void update(double dt) {
        if (updateRouteImage) {
            routeImage.dispose();
            routeImage = new Texture(routeStateModel.getRoute().getImagePath());
            updateRouteImage = false;
        }
        if (MyInput.clicked()) {
            int x = MyInput.getX();
            int y = MyInput.getY();
            Gdx.app.log("simulator", "x: " + x +", y: " + y);
            if (x >= 0 && x <= 160 && y >= 0 && y <= 137 && !startedBattle) {
                clickedHamburgerMenu();
            }
            if (!routeStateModel.isWindowOpened() && !startedBattle) {
                if (x >= 15 && x <= 991 && y >= 1270 && y <= 1417) {
                    clickedWildButton();
                } else if (x >= 15 && x <= 991 && y >= 1504 && y <= 1661) {
                    clickedSurfButton();
                } else if (x >= 15 && x <= 991 && y >= 1730 && y <= 1860) {
                    clickedFishingButton();
                } else if (x >= 15 && x <= 168 && y >= 1097 && y <= 1205) {
                    clickedLeftArrow();
                } else if (x >= 878 && x <= 1001 && y >= 1097 && y <= 1205) {
                    clickedRightArrow();
                } else if (x >= 234 && x <= 382 && y >= 0 && y <= 122) {
                    clickedGymButton();
                } else if (x >= 905 && x <= 1050 && y >= 0 && y <= 108) {
                    clickedPowerButton();
                }
            } else if (routeStateModel.isWindowOpened() && !startedBattle) {
                 if (x >= 210 && x <= 469 && y >= 315 && y <= 406) {
                    Gdx.app.log("kanto", "windowclose");
                    if (routeStateModel.isWindowOpened()) {
                        Gdx.app.log("kanto", "windowopen");
                        routeStateModel.setRegion(RouteStateModel.KANTO);
                        updateRouteImage = true;
                        routeStateModel.closeWindow();
                    }
                } else if (x >= 210 && x <= 469 && y >= 471 && y <= 541) {
                    if (routeStateModel.isWindowOpened()) {
                        routeStateModel.setRegion(RouteStateModel.JOHTO);
                        updateRouteImage = true;
                        routeStateModel.closeWindow();
                    }
                }
            }


        }
    }

    private void clickedPowerButton() {
        gsm.getGameCallBack().pulsate();
        gsm.setState(new LoadingState(gsm, LoadingState.HUB_STATE));
        dispose();
        wildBgm.dispose();
    }

    private void clickedLeftArrow() {
        gsm.getGameCallBack().pulsate();
        if (routeStateModel.hasPreviousRoute()) {
            routeStateModel.setPreviousRoute();
            updateRouteImage = true;
        }
    }

    private void clickedRightArrow() {
        gsm.getGameCallBack().pulsate();
        Gdx.app.log("simulator", "clickedrightarrow");
        if (routeStateModel.hasNextRoute()) {
            routeStateModel.setNextRoute();
            updateRouteImage = true;
        } else {
            Gdx.app.log("simulator", "clickedrightarrow - no next route");
        }
    }

    public void clickedHamburgerMenu() {
        gsm.getGameCallBack().pulsate();
        if (routeStateModel.isWindowOpened()) {
            routeStateModel.closeWindow();
        } else {
            routeStateModel.openWindow();
        }
    }

    public void clickedGymButton() {
        gsm.getGameCallBack().pulsate();
        if (routeStateModel.getRegion() == routeStateModel.KANTO) {
            if (gsm.getPlayer().getKantoBadges() >= 8) {
                gsm.stopBgm();
                gsm.setState(new EliteFourSpeechState(gsm, Trainer.Badge.KANTO_LORELEI));
            } else {
                gsm.setState(new KantoGymState(gsm, routeStateModel.getRouteNumber(),
                        routeStateModel.getRegion()));
            }
            dispose();
            wildBgm.dispose();
        } else if (routeStateModel.getRegion() == routeStateModel.JOHTO) {
            gsm.setState(new KantoGymState(gsm, routeStateModel.getRouteNumber(),
                    routeStateModel.getRegion()));
            dispose();
            wildBgm.dispose();
        }
    }

    public void clickedWildButton() {
        gsm.getGameCallBack().pulsate();
        if (routeStateModel.getRoute().isAvailable(gsm.getPlayer()) &&
                routeStateModel.getRoute().hasGrass()) {
            gsm.stopBgm();
            wildBgm.play();
            startedBattle = true;
            gsm.setState(new BattleState(gsm, routeStateModel.getRoute().getAPokemon(Route.GRASS),
                    wildBgm, routeStateModel.getRouteNumber(), routeStateModel.getRegion(),
                    true, routeStateModel.getRoute().getBackground()));
            dispose();
        } else {
            //play error sound
        }
    }

    public void clickedSurfButton() {
        gsm.getGameCallBack().pulsate();
        if (routeStateModel.getRoute().isAvailable(gsm.getPlayer()) &&
                routeStateModel.getRoute().hasSurf()) {
            gsm.stopBgm();
            wildBgm.play();
            startedBattle = true;
            gsm.setState(new BattleState(gsm, routeStateModel.getRoute().getAPokemon(Route.SURF),
                    wildBgm, routeStateModel.getRouteNumber(), routeStateModel.getRegion(),
                    true, routeStateModel.getRoute().getWaterBackground()));
            dispose();
        } else {
            //play error sound
        }
    }

    public void clickedFishingButton() {
        gsm.getGameCallBack().pulsate();
        if (routeStateModel.getRoute().isAvailable(gsm.getPlayer()) &&
                routeStateModel.getRoute().hasFishing()) {
            gsm.stopBgm();
            wildBgm.play();
            startedBattle = true;
            gsm.setState(new BattleState(gsm, routeStateModel.getRoute().getAPokemon(Route.FISHING),
                    wildBgm, routeStateModel.getRouteNumber(), routeStateModel.getRegion(),
                    true, routeStateModel.getRoute().getWaterBackground()));
            dispose();
        } else {
            //play error sound
        }
    }



    public void dispose() {
        background.dispose();
        gymIcon.dispose();
        hamburgerIcon.dispose();
        wildButton.dispose();
        surfButton.dispose();
        rodButton.dispose();
        regionSelectIcon.dispose();
        regionSelectWindow.dispose();
        slider.dispose();
        routeNameLabel.dispose();
        routeImage.dispose();
        routeNumberFont.dispose();
        routeFont.dispose();
        lock.dispose();
    }

}
