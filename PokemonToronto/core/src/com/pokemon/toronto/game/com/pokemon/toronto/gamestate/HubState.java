package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.WildPokemonCreator;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer;

/**
 * Created by gregorykelsie on 2018-01-19.
 */

public class HubState extends GameState {

    private GameStateManager gsm;
    private Texture background;
    private Texture checkmark;
    private Texture popupWindow;
    private Texture popupTexture;

    private Trainer randomTrainer;
    private Pokemon randomPokemon;

    private boolean receivedPlacePokemon;
    private boolean receivedGeographicalPokemon;

    private int placePokemonId;
    private int geographicalPokemonId;

    private int windowState;

    private final int NO_WINDOW = 0;
    private final int POKEMON_WINDOW = 1;
    private final int TRAINER_WINDOW = 2;
    private boolean loadedPopupTexture;

    public HubState(GameStateManager gsm) {
        this.gsm = gsm;
        background = new Texture("hub.png");
        checkmark = new Texture("checkmark.png");
        popupWindow = new Texture("battlepopup.png");
        windowState = NO_WINDOW;
        loadedPopupTexture = false;
        resetWildPokemon();
    }

    private void resetWildPokemon() {
        receivedPlacePokemon = false;
        receivedGeographicalPokemon = false;
        placePokemonId = -1;
        geographicalPokemonId = -1;
    }
    @Override
    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 0);
        drawCheckmarks(batch);
        if (windowState != NO_WINDOW) {
            batch.draw(popupWindow, 162, 935);
            if (loadedPopupTexture) {
                batch.draw(popupTexture, 609, 954, 330, 330);
            } else {
                if (windowState == TRAINER_WINDOW) {
                    popupTexture = new Texture(randomTrainer.getIconPath());
                } else {
                    popupTexture = new Texture(randomPokemon.getMapIconPath());
                }
                loadedPopupTexture = true;
            }
        }

    }

    private void drawCheckmarks(SpriteBatch batch) {
        if (gsm.hasTrainerChecked()) {
            batch.draw(checkmark, 509, 13);
        }
        if (gsm.hasWildChecked()) {
            batch.draw(checkmark, 509, 111);
        }
    }

    public void openTrainerPopUp(Trainer t) {
        if (windowState == NO_WINDOW && gsm.hasTrainerChecked()) {
            randomTrainer = t;
            Gdx.app.log("trainer", t.getIconPath());
            windowState = TRAINER_WINDOW;
            gsm.getGameCallBack().vibrate();
        }
    }

    public void addPokemonPlace(int pokemonId) {
        Gdx.app.log("hub", "pokemonplace: " + pokemonId);
        if (windowState == NO_WINDOW && gsm.hasWildChecked()) {
            if (!receivedPlacePokemon) {
                receivedPlacePokemon = true;
                placePokemonId = pokemonId;
                gsm.getGameCallBack().vibrate();
            }
        }
    }

    public void addPokemonGeographic(int pokemonId) {
        Gdx.app.log("hub", "pokemonGeo: " + pokemonId);
        if (windowState == NO_WINDOW && gsm.hasWildChecked()) {
            if (!receivedGeographicalPokemon) {
                receivedGeographicalPokemon = true;
                geographicalPokemonId = pokemonId;
            }
        }
    }

    private void disposeWindow() {
        windowState = NO_WINDOW;
        receivedGeographicalPokemon = false;
        receivedPlacePokemon = false;

        popupTexture.dispose();
        loadedPopupTexture = false;
    }

    @Override
    public void update(double dt) {
        if (receivedGeographicalPokemon && receivedPlacePokemon && windowState == NO_WINDOW) {
            windowState = POKEMON_WINDOW;
            double rand = Math.random();
            WildPokemonCreator wpc = new WildPokemonCreator();
            if (rand <= 1 && placePokemonId != -1) {
                randomPokemon = wpc.createPokemon(placePokemonId, 5, 5, 0);
            } else {
                randomPokemon = wpc.createPokemon(geographicalPokemonId, 5, 5, 0);
                resetWildPokemon();
            }
        }
        if (MyInput.clicked()) {
            int x = MyInput.getX();
            int y = MyInput.getY();
            Gdx.app.log("hub", x + "," + y);
            if (x >= 288 && x <= 514 && y >= 861 && y <= 933 && windowState != NO_WINDOW) {
                disposeWindow();
            } else if (x >= 472 && x <= 610 && y >= 1698 && y <= 1769 && windowState == NO_WINDOW) {
                gsm.toggleWildCheck();
            } else if (x >= 472 && x <= 610 && y >= 1830 && y <= 1920 && windowState == NO_WINDOW) {
                gsm.toggleTrainerCheck();
            } else if (x >= 24 && x <= 655 && y >= 159 && y <= 313 && windowState == NO_WINDOW) {
                //World Map
                gsm.setState(new LoadingState(gsm, LoadingState.MAP_STATE));
                dispose();
            } else if (x >= 24 && x <= 655 && y >= 376 && y <= 480 && windowState == NO_WINDOW) {
                //PokeCenter
                gsm.stopBgm();
                gsm.setState(new LoadingState(gsm, LoadingState.POKECENTER_STATE));
                dispose();
            } else if (x >= 24 && x <= 655 && y >= 572 && y <= 699 && windowState == NO_WINDOW) {
                //PokeMart
                gsm.stopBgm();
                gsm.setState(new PokeMartState(gsm));
                dispose();
            } else if (x >= 24 && x <= 655 && y >= 820 && y <= 929 && windowState == NO_WINDOW) {
                //PokeNet
            } else if (x >= 24 && x <= 655 && y >= 1043 && y <= 1193 && windowState == NO_WINDOW) {
                //Simulator
                gsm.setState(new SimulatorState(gsm));
                dispose();
            } else if (x >= 797 && x <= 999 && y >= 30 && y <= 184 && windowState == NO_WINDOW) {
                //PokeDex
            } else if (x >= 823 && x <= 1009 && y >= 289 && y <= 491 && windowState == NO_WINDOW) {
                //PC
                gsm.setState(new BoxState(gsm, true));
                gsm.stopBgm();
                dispose();
            } else if (x >= 825 && x <= 1003 && y >= 582 && y <= 763 && windowState == NO_WINDOW) {
                //Bag
                gsm.setState(new BagState(gsm, true));
                dispose();
            } else if (x >= 749 && x <= 1000 && y >= 1680 && y <= 1878 && windowState == NO_WINDOW) {
                //Profile
                gsm.setState(new ProfileState(gsm));
                dispose();
            } else if (x >= 353 && x <= 564 && y >= 670 && y <= 753 && windowState == POKEMON_WINDOW) {
                gsm.stopBgm();
                Music wildBgm = Gdx.audio.newMusic(Gdx.files.internal("sounds/wildBgm.mp3"));
                wildBgm.play();
                gsm.setState(new BattleState(gsm, randomPokemon, wildBgm));
                dispose();
            } else if (x >= 353 && x <= 564 && y >= 670 && y <= 753 && windowState == TRAINER_WINDOW) {
                gsm.stopBgm();
                Music trainerBgm = Gdx.audio.newMusic(Gdx.files.internal("bgm/trainer.mp3"));
                trainerBgm.play();
                gsm.setState(new BattleState(gsm, trainerBgm, randomTrainer));
                dispose();

            }
        }
    }

    @Override
    protected void dispose() {
        background.dispose();
        checkmark.dispose();
        popupWindow.dispose();
        if (popupTexture != null) {
            popupTexture.dispose();
        }
    }

}
