package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.RouteFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;

/**
 * Created by Gregory on 7/27/2017.
 */

public class RouteState extends GameState {

    private final int KANTO = 0;
    private final int JOHTO = 1;
    private final int HOENN = 2;

    private final int FIRST_BANNER_Y = 630;
    private final int SECOND_BANNER_Y = 435;
    private final int THIRD_BANNER_Y = 219;
    private final int FOURTH_BANNER_Y = 9;

    private final int GRASS_ICON_X = 56;
    private final int SURF_ICON_X = 41;
    private final int ROD_ICON_X = 65;
    private final int TRAINERS_ICON_X = 40;

    private final int HEADER_X = 306;

    private final int FIRST_HEADER_Y = 683;
    private final int SECOND_HEADER_Y = 491;
    private final int THIRD_HEADER_Y = 275;
    private final int FOURTH_HEADER_Y = 59;

    private GameStateManager gsm;
    private Route currentRoute;
    private int currentRoutePosition; //current index in route list
    private boolean isRoute;
    private int[] routeList;
    private Sound clickSound;
    private Music wildBgm;
    private int region;
    private boolean startedABattle;
    private Texture background;
    private Texture title;
    private Texture routePicture;
    private Texture banner;

    private Texture grassIcon;
    private Texture surfIcon;
    private Texture fishingIcon;
    private Texture trainerIcon;

    private Texture grassTitle;
    private Texture surfTitle;
    private Texture fishingTitle;
    private Texture trainerTitle;

    public RouteState(GameStateManager gsm, int startingRoute, int region, boolean isRoute) {
        initMain(gsm, startingRoute, region, isRoute);
        initBackgroundAndRoute();
        initIcons();
        initTitles();
    }

    private void initMain(GameStateManager gsm, int startingRoute, int region, boolean isRoute) {
        this.gsm = gsm;
        currentRoutePosition = 0;
        this.isRoute = isRoute;
        initRouteList(startingRoute, region, isRoute);
        RouteFactory rf = new RouteFactory();
        if (isRoute) {
            currentRoute = rf.createRoute(startingRoute);
        } else {
            currentRoute = rf.createDungeon(startingRoute);
        }
        clickSound = Gdx.audio.newSound(Gdx.files.internal("sounds/click.wav"));
        wildBgm = Gdx.audio.newMusic(Gdx.files.internal("sounds/wildBgm.mp3"));
        startedABattle = false;
        this.region = region;
    }

    private void initRouteList(int startingRoute, int region, boolean isRoute) {
        if (region == KANTO) {
            if (isRoute) {
                initKantoRoutes(startingRoute);
            } else {
                initKantoDungeons(startingRoute);
            }
        }
    }

    private void initKantoRoutes(int startingRoute) {
        routeList = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
        for (int i = 0; i < routeList.length; i++) {
            if (routeList[i] == startingRoute) {
                currentRoutePosition = i;
                break;
            }
        }
    }

    private void initKantoDungeons(int dungeonId) {
        routeList = new int[] {1};
        for (int i = 0; i < routeList.length; i++) {
            if (routeList[i] == dungeonId) {
                currentRoutePosition = i;
                break;
            }
        }
    }

    private void initBackgroundAndRoute() {
        background = new Texture("simulator/background.png");
        routePicture = new Texture(currentRoute.getImagePath());
    }

    private void initIcons() {
        banner = new Texture("simulator/battle_menu/arrow.png");
        grassIcon = new Texture("simulator/battle_menu/grass.png");
        surfIcon = new Texture("simulator/battle_menu/surf.png");
        fishingIcon = new Texture("simulator/battle_menu/rod.png");
        trainerIcon = new Texture("simulator/battle_menu/trainer.png");
    }

    private void initTitles() {
        title = new Texture("simulator/battle_menu/title.png");
        grassTitle = new Texture("simulator/battle_menu/wild_text.png");
        surfTitle = new Texture("simulator/battle_menu/surf_text.png");
        fishingTitle = new Texture("simulator/battle_menu/rod_text.png");
        trainerTitle = new Texture("simulator/battle_menu/trainer_text.png");
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 0);
        batch.draw(title, 180, 1764);
        batch.draw(routePicture, 24, 882);
        renderBottomButtons(batch);
    }

    private void renderBottomButtons(SpriteBatch batch) {
        renderBanners(batch);
        renderIcons(batch);
        renderHeaders(batch);
    }

    private void renderHeaders(SpriteBatch batch) {
        batch.draw(grassTitle, HEADER_X, FIRST_HEADER_Y);
        batch.draw(surfTitle, HEADER_X, SECOND_HEADER_Y);
        batch.draw(fishingTitle, HEADER_X, THIRD_HEADER_Y);
        batch.draw(trainerTitle, HEADER_X, FOURTH_HEADER_Y);

    }
    private void renderBanners(SpriteBatch batch) {
        batch.draw(banner, 0, FIRST_BANNER_Y);
        batch.draw(banner, 0, SECOND_BANNER_Y);
        batch.draw(banner, 0, THIRD_BANNER_Y);
        batch.draw(banner, 0, FOURTH_BANNER_Y);
    }

    private void renderIcons(SpriteBatch batch) {
        batch.draw(grassIcon, GRASS_ICON_X, getGrassIconY(FIRST_BANNER_Y));
        batch.draw(surfIcon, SURF_ICON_X, getSurfIconY(SECOND_BANNER_Y));
        batch.draw(fishingIcon, ROD_ICON_X, getRodIconY(THIRD_BANNER_Y));
        batch.draw(trainerIcon, TRAINERS_ICON_X, getTrainerIconY(FOURTH_BANNER_Y));
    }


    private int getGrassIconY(int bannerY) {
        return bannerY + 55;
    }

    private int getSurfIconY(int bannerY) {
        return bannerY + 20;
    }

    private int getRodIconY(int bannerY) {
        return bannerY + 5;
    }

    private int getTrainerIconY(int bannerY) {
        return bannerY - 9;
    }


    @Override
    public void update(double dt) {
        if (MyInput.clicked()) {
            int x = MyInput.getX();
            int y = MyInput.getY();
            Gdx.app.log("MyClick", "X: " + x + ", Y: " + y);
            if (x >= 911 && x <= 1080 && y >= 0 && y <= 136) {
                clickedPowerButton();
            } else if (clickedGrassButton(x, y)) {
                clickedGrassButton();
            } else if (clickedSurfButton(x, y)) {
                clickedSurfButton();
            } else if (clickedFishingButton(x, y)) {
                clickedFishingButton();
            } else if (clickedTrainerButton(x, y)) {
                clickedTrainerButton();
            }
        }
    }

    private boolean clickedGrassButton(int x, int y) {
        if (x >= 128 && x <= 924 && y >= 1109 && y <= 1256) {
            return true;
        }
        return false;
    }

    private void clickedGrassButton() {
        clickSound.play();
        startedABattle = true;
        wildBgm.play();
        if (isRoute) {
            gsm.setState(new BattleState(gsm, currentRoute.getAGrassPokemon(), wildBgm, routeList[currentRoutePosition], region, isRoute));
        } else {
            gsm.setState(new BattleState(gsm, currentRoute.getAGrassPokemon(), wildBgm, routeList[currentRoutePosition], region, isRoute));
        }
        dispose();
    }
    private boolean clickedSurfButton(int x, int y) {
        if (x >= 128 && x <= 924 && y >= 1325 && y <= 1460) {
            return true;
        }
        return false;
    }

    private void clickedSurfButton() {
        clickSound.play();
    }
    private boolean clickedFishingButton(int x, int y) {
        if (x >= 128 && x <= 924 && y >= 1592 && y <= 1673) {
            return true;
        }
        return false;
    }

    private void clickedFishingButton() {
        clickSound.play();
    }
    private boolean clickedTrainerButton(int x, int y) {
        if (x >= 128 && x <= 924 && y >= 1772 && y <= 1868) {
            return true;
        }
        return false;
    }

    private void clickedTrainerButton() {
        clickSound.play();
    }
    private void clickedPowerButton() {
        clickSound.play();
        gsm.setState(new RegionMenu(gsm, 0));
        dispose();
    }

    @Override
    protected void dispose() {
        background.dispose();
        title.dispose();
        routePicture.dispose();
        banner.dispose();
        grassIcon.dispose();
        surfIcon.dispose();
        fishingIcon.dispose();
        trainerIcon.dispose();
        grassTitle.dispose();
        surfTitle.dispose();
        fishingTitle.dispose();
        trainerTitle.dispose();
        clickSound.dispose();
        if (!startedABattle) {
            wildBgm.dispose();
        }
    }

}
