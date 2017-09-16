package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;
import com.pokemon.toronto.game.com.pokemon.toronto.pokenav.PokeNavScreen;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.trivial.TrainerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/8/2017.
 */
public class PokeNavState extends GameState{

    /** Constants */

    //Screen Position Values
    private final int POKEDEX_SCREEN = 0;
    private final int PARTY_SCREEN = 1;
    private final int BAG_SCREEN = 2;
    private final int MAP_SCREEN = 3;
    private final int SIMULATOR_SCREEN = 4;
    private final int COMMUNITY_SCREEN = 5;
    private final int PROFILE_SCREEN = 6;
    private final int PC_SCREEN = 7;
    private final int POKECENTER_SCREEN = 8;
    private final int POKEMART_SCREEN = 9;




    /** Instance Variables */

    private GameStateManager gsm;
    private Texture background;
    private List<PokeNavScreen> pokeNavScreens;
    private int currentScreen;
    private Sound clickSound;

    /**
     * Create the PokeNav navigational menu
     * @param gsm A callback to the GameStateManager to switch states.
     */
    public PokeNavState(GameStateManager gsm) {
        this.gsm = gsm;
        background = gsm.getLoader().get("pokeNav/background.png", Texture.class);
        clickSound = gsm.getLoader().get("sounds/click.wav", Sound.class);
        initPokeNavScreens();
    }

    /**
     * Initialize each of the different PokeNav screens and set the current
     * screen.
     */
    private void initPokeNavScreens() {
        pokeNavScreens = new ArrayList<PokeNavScreen>();
        pokeNavScreens.add(new PokeNavScreen(gsm.getLoader()
                .get("pokeNav/pokedex.png", Texture.class),
                gsm.getLoader().get("pokeNav/pokedex_text.png", Texture.class)));
        pokeNavScreens.add(new PokeNavScreen(gsm.getLoader()
                .get("pokeNav/party.png", Texture.class),
                gsm.getLoader().get("pokeNav/party_text.png", Texture.class)));
        pokeNavScreens.add(new PokeNavScreen(gsm.getLoader()
                .get("pokeNav/bag.png", Texture.class),
                gsm.getLoader().get("pokeNav/bag_text.png", Texture.class)));
        pokeNavScreens.add(new PokeNavScreen(gsm.getLoader()
                .get("pokeNav/worldmap.png", Texture.class),
                gsm.getLoader().get("pokeNav/worldmap_text.png", Texture.class)));
        pokeNavScreens.add(new PokeNavScreen(gsm.getLoader()
                .get("pokeNav/battlesimulator.png", Texture.class),
                gsm.getLoader().get("pokeNav/battlesimulator_text.png", Texture.class)));
        pokeNavScreens.add(new PokeNavScreen(gsm.getLoader()
                .get("pokeNav/community.png", Texture.class),
                gsm.getLoader().get("pokeNav/community_text.png", Texture.class)));
        pokeNavScreens.add(new PokeNavScreen(gsm.getLoader()
                .get("pokeNav/profile.png", Texture.class),
                gsm.getLoader().get("pokeNav/profile_text.png", Texture.class)));
        pokeNavScreens.add(new PokeNavScreen(gsm.getLoader()
                .get("pokeNav/pokemonpc.png", Texture.class),
                gsm.getLoader().get("pokeNav/pokemonpc_text.png", Texture.class)));
        pokeNavScreens.add(new PokeNavScreen(gsm.getLoader()
                .get("pokeNav/blissey.png", Texture.class),
                gsm.getLoader().get("pokeNav/pokemoncenter_text.png", Texture.class)));
        pokeNavScreens.add(new PokeNavScreen(gsm.getLoader()
                .get("pokeNav/pokemart.png", Texture.class),
                gsm.getLoader().get("pokeNav/pokemart_text.png", Texture.class)));
        currentScreen = POKEDEX_SCREEN;
    }

    /**
     * Go to the previous PokeNav screen if the player isn't on the first
     * screen.
     */
    private void clickedLeft() {
        clickSound.play();
        if (currentScreen != 0) {
            currentScreen--;
        }
    }

    /**
     * Return whether or not the player clicked on the left button.
     * @param x The x coordinate of the player click.
     * @param y The y coordinate of the player click.
     * @return Whether or not the playe rclicked the left button.
     */
    private boolean clickedLeft(int x, int y) {
        if (x >= 0 && x <= 128 && y >= 1617 && y <= 1737) {
            return true;
        }
        return false;
    }

    /**
     * Go to the next PokeNav screen if the player isn't on the last
     * screen.
     */
    private void clickedRight() {
        clickSound.play();
        if (currentScreen != pokeNavScreens.size() - 1) {
            currentScreen++;
        }
    }

    /**
     * Return whether or not the player clicked on the right button.
     * @param x The x coordinate of the player click.
     * @param y The y coordinate of the player click.
     * @return Whether or not the player clicked on the right button.
     */
    private boolean clickedRight(int x, int y) {
        if (x >= 218 && x <= 305 && y >= 1612 && y <= 1788) {
            return true;
        }
        return false;
    }

    /**
     * Return whether or not the player clicked the red back button.
     * @param x The x coordinate the player clicked.
     * @param y The y coordinate the player clicked.
     * @return Whether or not the player clicked the back button.
     */
    private boolean clickedBack(int x, int y) {
        if (x >= 808 && x <= 974 && y >= 1530 && y <= 1666) {
            return true;
        }
        return false;
    }

    /**
     * Start the selected state on the PokeNav menu.
     */
    private void clickedSelect() {
        clickSound.play();
        switch (currentScreen) {
            case POKEDEX_SCREEN:
                break;
            case PC_SCREEN:
                executePokemonBoxScreen();
                break;
            case MAP_SCREEN:
                executeMapScreen();
                break;
            case SIMULATOR_SCREEN:
                executeSimulator();
                break;
            case COMMUNITY_SCREEN:
                break;
            case POKECENTER_SCREEN:
                executePokeCenterScreen();
                break;
            case POKEMART_SCREEN:
                executePokeMartScreen();
                break;
            case PARTY_SCREEN:
                executePartyScreen();
                break;
            case BAG_SCREEN:
                executeBagScreen();
                break;
            case PROFILE_SCREEN:
                break;
        }
    }

    /**
     * Go to the RegionSelect state to execute the battle simulator.
     */
    private void executeSimulator() {
        gsm.setState(new RegionSelect(gsm));
        dispose();
    }

    /**
     * Go to the PokemonCenter state to heal the player's pokemon.
     */
    private void executePokeCenterScreen() {
        /*
        gsm.setState(new LoadingState(gsm, LoadingState.POKECENTER_STATE));
        */
        gsm.stopBgm();
        TrainerFactory ttf = new TrainerFactory();
        Trainer t = ttf.getTrainer(3, gsm.getLatitude(), gsm.getLongitude());
        Gdx.app.log("Trainer", t.toString());
        Music wildBgm = Gdx.audio.newMusic(Gdx.files.internal("bgm/trainer.mp3"));
        wildBgm.setVolume(0.5f);
        wildBgm.play();
        gsm.setState(new BattleState(gsm, wildBgm, t));
        dispose();
    }

    /**
     * Go to PokeMart state to buy items.
     */
    private void executePokeMartScreen() {
        gsm.stopBgm();
        gsm.setState(new PokeMartState(gsm));
        dispose();
    }

    /**
     * Go to the Pokemon Box state to move around and release pokemon.
     */
    private void executePokemonBoxScreen() {
        gsm.setState(new BoxState(gsm, true));
        gsm.stopBgm();
        dispose();
    }

    /**
     * Go to the Map state where the playe rcan look at their wild pokemon
     * available to them or view their current location.
     */
    private void executeMapScreen() {
        gsm.setState(new LoadingState(gsm, LoadingState.MAP_STATE));
        dispose();
    }

    /**
     * Go to the party state.
     */
    private void executePartyScreen() {
        gsm.setState(new PokemonPartyState(gsm));
        dispose();
    }

    /**
     * Go to the bag state.
     */
    private void executeBagScreen() {
        gsm.setState(new BagState(gsm, true));
        dispose();
    }

    /**
     * Return whether or not the player clicked the green select button.
     * @param x The x coordinate where the player clicked.
     * @param y The y coordinate where the player clicked.
     * @return Whether or not the player clicked the select button.
     */
    private boolean clickedSelect(int x, int y) {
        if (x >= 882 && x <= 1033 && y >= 1687 && y <= 1808) {
            return true;
        }
        return false;
    }

    /**
     * Render the PokeNav
     * @param batch The SpriteBatch the PokeNav state gets rendered to.
     */
    @Override
    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 0);
        pokeNavScreens.get(currentScreen).render(batch);
    }

    /**
     * Update the PokeNav state.
     * @param dt The time elapsed.
     */
    @Override
    public void update(double dt) {
        if (MyInput.clicked()) {
            int x = MyInput.getX();
            int y = MyInput.getY();
            if (clickedLeft(x, y)) {
                clickedLeft();
            } else if (clickedRight(x, y)) {
                clickedRight();
            } else if (clickedSelect(x, y)) {
                clickedSelect();
            }
        }
    }

    /**
     * Dispose of the textures and sounds for the PokeNav.
     */
    @Override
    protected void dispose() {
        gsm.getLoader().unload("pokeNav/background.png");
        gsm.getLoader().unload("pokeNav/pokedex.png");
        gsm.getLoader().unload("pokeNav/pokedex_text.png");
        gsm.getLoader().unload("pokeNav/pokemonpc.png");
        gsm.getLoader().unload("pokeNav/pokemonpc_text.png");
        gsm.getLoader().unload("pokeNav/worldmap.png");
        gsm.getLoader().unload("pokeNav/worldmap_text.png");
        gsm.getLoader().unload("pokeNav/battlesimulator.png");
        gsm.getLoader().unload("pokeNav/battlesimulator_text.png");
        gsm.getLoader().unload("pokeNav/community.png");
        gsm.getLoader().unload("pokeNav/community_text.png");
        gsm.getLoader().unload("pokeNav/blissey.png");
        gsm.getLoader().unload("pokeNav/pokemoncenter_text.png");
        gsm.getLoader().unload("pokeNav/pokemart.png");
        gsm.getLoader().unload("pokeNav/pokemart_text.png");
        gsm.getLoader().unload("pokeNav/party.png");
        gsm.getLoader().unload("pokeNav/party_text.png");
        gsm.getLoader().unload("pokeNav/bag.png");
        gsm.getLoader().unload("pokeNav/bag_text.png");
        gsm.getLoader().unload("pokeNav/profile.png");
        gsm.getLoader().unload("pokeNav/profile_text.png");
        gsm.getLoader().unload("sounds/click.wav");
    }
}
