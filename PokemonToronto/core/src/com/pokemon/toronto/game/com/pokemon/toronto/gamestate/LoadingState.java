package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Gregory on 6/9/2017.
 */
public class LoadingState extends GameState {
    private GameStateManager gsm;
    public static final int INTRODUCTION = 0;
    public static final int MAIN_MENU = 1;
    public static final int POKENAV_MENU = 2;
    public static final int MAP_STATE = 3;
    public static final int EMPTY_WILD_POKEMON_SCREEN = 4;
    public static final int WILD_POKEMON_LIST = 5;
    public static final int POKEMON_MENU = 6;
    public static final int POKECENTER_STATE = 7;
    public static final int HUB_STATE = 8;
    public static final int SIMULATOR_STATE = 9;
    private Texture background;
    private int nextState;

    //Route Variables
    private int route;
    private int region;

    public LoadingState(GameStateManager gsm, int nextState) {
        this.gsm = gsm;
        background = new Texture("loadingBackground.png");
        this.nextState = nextState;
        loadData(nextState);
    }

    public LoadingState(GameStateManager gsm, int nextState, int region, int route) {
        this.gsm = gsm;
        background = new Texture("loadingBackground.png");
        this.nextState = nextState;
        loadData(nextState);
        this.region = region;
        this.route = route;
    }
    
    private void loadData(int nextState) {
        if (nextState == INTRODUCTION) {
            loadIntroductionResources();
        }
        if (nextState == POKENAV_MENU) {
            loadPokeNavResources();
        }
        if (nextState == MAIN_MENU) {
            loadMainMenuResources();
        }
        if (nextState == MAP_STATE) {
            loadMapStateResources();
        }
        if (nextState == EMPTY_WILD_POKEMON_SCREEN) {
            loadEmptyWildPokemonScreenResources();
        }
        if (nextState == WILD_POKEMON_LIST) {
            loadWildPokemonListResources();
        }
        if (nextState == POKEMON_MENU) {
            loadPokemonMenuResources();
        }
        if (nextState == POKECENTER_STATE) {
            loadPokeCenterResources();
        }
        if (nextState == HUB_STATE) {

        }
    }

    private void loadPokeCenterResources() {
        gsm.getLoader().load("pokecenter/background.png", Texture.class);
        gsm.getLoader().load("pokecenter/nursejoy.png", Texture.class);
        gsm.getLoader().load("textbox_header.png", Texture.class);
        gsm.getLoader().load("textbox.png", Texture.class);

        gsm.getLoader().load("pokecenter/bgm.mp3", Music.class);
        gsm.getLoader().load("pokecenter/fanfare.mp3", Music.class);
        gsm.getLoader().load("sounds/click.wav", Sound.class);
    }
    private void loadPokemonMenuResources() {
        gsm.getLoader().load("pokemonMenu/background.png", Texture.class);
        gsm.getLoader().load("pokemonMenu/panel.png", Texture.class);
        gsm.getLoader().load("pokemonMenu/emptyHealthBar.png", Texture.class);
        gsm.getLoader().load("pokemonMenu/greenLife.png", Texture.class);
        gsm.getLoader().load("pokemonMenu/healthCap.png", Texture.class);
        gsm.getLoader().load("pokemonMenu/grayButton.png", Texture.class);
        gsm.getLoader().load("pokemonMenu/greenButton.png", Texture.class);

    }
    private void loadWildPokemonListResources() {
        gsm.getLoader().load("wildPokemonList/backwardsArrow.png", Texture.class);
        gsm.getLoader().load("wildPokemonList/forwardArrow.png", Texture.class);
        gsm.getLoader().load("wildPokemonList/pokemonListPanel.png", Texture.class);
        gsm.getLoader().load("wildPokemonList/wildPokemonListBackground.png", Texture.class);
    }
    private void loadEmptyWildPokemonScreenResources() {
        gsm.getLoader().load("noNewPokemon.png", Texture.class);
    }
    private void loadMapStateResources() {
        gsm.getLoader().load("mapMenu.png", Texture.class);
    }
    private void loadMainMenuResources() {
        gsm.getLoader().load("mainMenu.png", Texture.class);
    }
    
    private void loadIntroductionResources() {
        gsm.getLoader().load("nature_background.png", Texture.class);
        gsm.getLoader().load("genderOptions.png", Texture.class);
        gsm.getLoader().load("yesNoOptions.png", Texture.class);
        gsm.getLoader().load("starterPokeballs.png", Texture.class);
        gsm.getLoader().load("professor_ivy3.png", Texture.class);
        gsm.getLoader().load("textbox.png", Texture.class);
        gsm.getLoader().load("textbox_header.png", Texture.class);
        gsm.getLoader().load("professor_ivy.png", Texture.class);
        gsm.getLoader().load("professor_ivy2.png", Texture.class);
        gsm.getLoader().load("starterImages/charmander.png", Texture.class);
        gsm.getLoader().load("starterImages/charmander02.png", Texture.class);
        gsm.getLoader().load("starterImages/charmander03.png", Texture.class);
        gsm.getLoader().load("starterImages/charmander04.png", Texture.class);
        gsm.getLoader().load("starterImages/charmander05.png", Texture.class);
        gsm.getLoader().load("starterImages/bulbasaur.png", Texture.class);
        gsm.getLoader().load("starterImages/bulbasaur02.png", Texture.class);
        gsm.getLoader().load("starterImages/bulbasaur03.png", Texture.class);
        gsm.getLoader().load("starterImages/bulbasaur04.png", Texture.class);
        gsm.getLoader().load("starterImages/bulbasaur05.png", Texture.class);
        gsm.getLoader().load("starterImages/squirtle.png", Texture.class);
        gsm.getLoader().load("starterImages/squirtle02.png", Texture.class);
        gsm.getLoader().load("starterImages/squirtle03.png", Texture.class);
        gsm.getLoader().load("starterImages/squirtle04.png", Texture.class);
        gsm.getLoader().load("starterImages/squirtle05.png", Texture.class);
        gsm.getLoader().load("closedPokeball.png", Texture.class);
        gsm.getLoader().load("openPokeball.png", Texture.class);

        gsm.getLoader().load("sounds/cry/001.wav", Sound.class);
        gsm.getLoader().load("sounds/cry/004.wav", Sound.class);
        gsm.getLoader().load("sounds/cry/007.wav", Sound.class);
        gsm.getLoader().load("sounds/throwPokeball.wav", Sound.class);
        gsm.getLoader().load("sounds/woosh.wav", Sound.class);
        gsm.getLoader().load("sounds/caughtPokemon.wav", Sound.class);
        gsm.getLoader().load("sounds/notification.wav", Sound.class);
        gsm.getLoader().load("bgm/professorIvyTheme.mp3", Music.class);
    }
    
    private void loadPokeNavResources() {
        gsm.getLoader().load("pokeNav/background.png", Texture.class);
        gsm.getLoader().load("pokeNav/pokedex.png", Texture.class);
        gsm.getLoader().load("pokeNav/pokedex_text.png", Texture.class);
        gsm.getLoader().load("pokeNav/pokemonpc.png", Texture.class);
        gsm.getLoader().load("pokeNav/pokemonpc_text.png", Texture.class);
        gsm.getLoader().load("pokeNav/worldmap.png", Texture.class);
        gsm.getLoader().load("pokeNav/worldmap_text.png", Texture.class);
        gsm.getLoader().load("pokeNav/battlesimulator.png", Texture.class);
        gsm.getLoader().load("pokeNav/battlesimulator_text.png", Texture.class);
        gsm.getLoader().load("pokeNav/community.png", Texture.class);
        gsm.getLoader().load("pokeNav/community_text.png", Texture.class);
        gsm.getLoader().load("pokeNav/blissey.png", Texture.class);
        gsm.getLoader().load("pokeNav/pokemoncenter_text.png", Texture.class);
        gsm.getLoader().load("pokeNav/pokemart.png", Texture.class);
        gsm.getLoader().load("pokeNav/pokemart_text.png", Texture.class);
        gsm.getLoader().load("pokeNav/bag.png", Texture.class);
        gsm.getLoader().load("pokeNav/bag_text.png", Texture.class);
        gsm.getLoader().load("pokeNav/party.png", Texture.class);
        gsm.getLoader().load("pokeNav/party_text.png", Texture.class);
        gsm.getLoader().load("pokeNav/profile.png", Texture.class);
        gsm.getLoader().load("pokeNav/profile_text.png", Texture.class);
        gsm.getLoader().load("sounds/click.wav", Sound.class);
    }
    
    
    @Override
    public void render(SpriteBatch batch) {
        if (nextState == POKENAV_MENU || nextState == INTRODUCTION) {
            batch.draw(background, 0, 0);
        }
    }

    @Override
    public void update(double dt) {
        if (gsm.getLoader().update()) {
            if (nextState == INTRODUCTION) {
                gsm.setState(new IntroductionState(gsm));
            } else if (nextState == MAIN_MENU) {
                gsm.setState(new MainMenuState(gsm));
            } else if (nextState == POKENAV_MENU) {
                gsm.setState(new PokeNavState(gsm));
            } else if (nextState == POKEMON_MENU) {
                gsm.setState(new PokemonPartyState(gsm));
            } else if (nextState == MAP_STATE) {
                gsm.setState(new MapState(gsm));
            } else if (nextState == EMPTY_WILD_POKEMON_SCREEN) {
                gsm.setState(new NoWildPokemonState(gsm));
            } else if (nextState == WILD_POKEMON_LIST) {
                gsm.setState(new WildPokemonListState(gsm));
            } else if (nextState == POKECENTER_STATE) {
                gsm.setState(new PokeCenterState(gsm, false));
            } else if (nextState == HUB_STATE) {
                gsm.setState(new HubState((gsm)));
            } else if (nextState == SIMULATOR_STATE) {
                gsm.setState(new SimulatorState(gsm, region, route));
            }
            dispose();
        }
    }

    @Override
    protected void dispose() {
        background.dispose();
    }
}
