package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;

import java.util.List;

/**
 * Created by Gregory on 8/16/2017.
 */

public class EvolutionState extends GameState {

    private GameStateManager gsm;
    private List<Pokemon> preEvolutions;
    private List<Pokemon> evolvedPokemon;
    private int evolvedListPosition;

    private Texture lowerPanel;
    private Texture textPanel;
    private Texture background;

    private Texture preEvolutionTexture;
    private Texture evolutionTexture;

    private String text;
    private double counter;
    private int textPosition;
    private BitmapFont textFont =
            new BitmapFont(Gdx.files.internal("battle/font/regularFont.fnt"));

    private int currentState;
    private int afterTextState;
    private final int TEXT_STATE = 0;
    private final int EVOLVING = 1;
    private final int CONGRATS = 2;
    private final int WAIT_FOR_EVOLUTION_CLICK = 3;
    private final int WAIT_FOR_CONGRATS_CLICK = 4;

    private int displayPokemon;
    private final int DISPLAY_PREEVOLUTION = 0;
    private final int DISPLAY_EVOLUTION = 1;

    private double displayTime;
    private boolean finishedFlip;

    //Whether or not after evolution it goes to map or simulator.
    private boolean goToMapState;
    private int startingRoute;
    private int region;
    private boolean isRoute;

    //Music and Sounds
    private Music evolvingMusic;
    private Music evolvingStartSound;
    private Music evolutionFanfare;
    private Sound clickSound;

    //Music Flags
    private boolean startSoundFinished;

    public EvolutionState(GameStateManager gsm, List<Pokemon> preEvolutions,
                          List<Pokemon> evolvedPokemon) {
        init(gsm, preEvolutions, evolvedPokemon);
        goToMapState = true;
        startingRoute = -1;
        region = -1;
        isRoute = false;

    }

    public EvolutionState(GameStateManager gsm, List<Pokemon> preEvolutions,
                          List<Pokemon> evolvedPokemon, int startingRoute, int region, boolean isRoute) {
        init(gsm, preEvolutions, evolvedPokemon);
        goToMapState = false;
        this.startingRoute = startingRoute;
        this.region = region;
        this.isRoute = isRoute;

    }

    private void init(GameStateManager gsm, List<Pokemon> preEvolutions, List<Pokemon> evolvedPokemon) {
        this.gsm = gsm;
        this.preEvolutions = preEvolutions;
        this.evolvedPokemon = evolvedPokemon;
        evolvedListPosition = 0;
        text = "What?\n" + preEvolutions.get(0).getName() + " is evolving!";
        counter = 0;
        textPosition = 0;
        displayPokemon = DISPLAY_PREEVOLUTION;
        displayTime = 0.8;
        finishedFlip = false;
        currentState = TEXT_STATE;
        afterTextState = WAIT_FOR_EVOLUTION_CLICK;
        startSoundFinished = false;
        initTextures();
        initMusic();
        evolvingStartSound.play();
        evolvingStartSound.setLooping(false);
    }

    private void initTextures() {
        lowerPanel = new Texture("battle/emptyBottomPanel.png");
        textPanel = new Texture("battle/textarea.png");
        background = new Texture("battle/evolutionStage.png");

        preEvolutionTexture = new Texture(preEvolutions.get(0).getMapIconPath());
        evolutionTexture = new Texture(evolvedPokemon.get(0).getMapIconPath());
    }

    private void initMusic() {
        evolvingMusic = Gdx.audio.newMusic(Gdx.files.internal("bgm/evolving.mp3"));
        evolvingStartSound = Gdx.audio.newMusic(Gdx.files.internal("sounds/evolutionStart.mp3"));
        evolutionFanfare = Gdx.audio.newMusic(Gdx.files.internal("sounds/evolvedFanfare.mp3"));
        clickSound = Gdx.audio.newSound(Gdx.files.internal("sounds/click.wav"));
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 1205);
        batch.draw(textPanel, 0, 954);
        batch.draw(lowerPanel, 0, 0);
        renderPokemon(batch);
        renderText(batch);
    }

    private void renderPokemon(SpriteBatch batch) {
        if (displayPokemon == DISPLAY_PREEVOLUTION) {
            batch.draw(preEvolutionTexture, 358, 1391, 394, 394);
        } else {
            //Draw Evolved Pokemon
            batch.draw(evolutionTexture, 358, 1391, 394, 394);
        }
    }

    private void renderText(SpriteBatch batch) {
        textFont.draw(batch, text.substring(0, textPosition), 54, 1143);
    }

    @Override
    public void update(double dt) {
        if (currentState == TEXT_STATE) {
            updateText(dt);
        } else if (currentState == EVOLVING) {
            updateEvolution(dt);
        } else if (currentState == CONGRATS) {

        }
        if (!evolvingStartSound.isPlaying()) {
            if (!startSoundFinished) {
                startSoundFinished = true;
                evolvingMusic.setLooping(true);
                evolvingMusic.play();
            }
        }
        if (MyInput.clicked()) {
            if (currentState == WAIT_FOR_EVOLUTION_CLICK) {
                clickSound.play();
                currentState = EVOLVING;
            } else if (currentState == WAIT_FOR_CONGRATS_CLICK) {
                clickSound.play();
                checkForNewMoves();
            }
        }
    }

    private void checkForNewMoves() {
        if (goToMapState) {
            //Go to Map State
            gsm.setState(new LoadingState(gsm, LoadingState.MAP_STATE));
        } else {
            //Go back to last simulator page
            gsm.setState(new RouteState(gsm, startingRoute, region, isRoute));
        }
        dispose();
    }

    private void updateEvolution(double dt) {
        counter += dt;
        if (counter >= displayTime) {
            counter = 0;
            if (finishedFlip) {
                displayTime -= 0.05;
            }
            flipPokemonTexture();
            if (displayTime <= 0) {
                displayTime = 0.8; //reset displayTime for next evolution.
                displayPokemon = DISPLAY_EVOLUTION;
                afterTextState = WAIT_FOR_CONGRATS_CLICK;
                currentState = TEXT_STATE;
                if (evolvingMusic.isPlaying()) {
                    evolvingMusic.stop();
                }
                evolutionFanfare.setLooping(false);
                evolutionFanfare.play();
                text = "Congratulations! Your " + preEvolutions.get(evolvedListPosition).getName() +
                        "\nevolved into " + evolvedPokemon.get(evolvedListPosition).getName() + "!";
                textPosition = 0;
                counter = 0;
            }
        }
    }

    private void flipPokemonTexture() {
        if (displayPokemon == DISPLAY_PREEVOLUTION) {
            displayPokemon = DISPLAY_EVOLUTION;
        } else {
            displayPokemon = DISPLAY_PREEVOLUTION;
        }
        finishedFlip = !finishedFlip;
    }

    private void updateText(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            if (textPosition < text.length()) {
                textPosition++;
                counter = 0;
            }
        }
        if (counter >= 1.5) {
            counter = 0;
            currentState = afterTextState;
        }
    }


    @Override
    protected void dispose() {
        lowerPanel.dispose();
        textPanel.dispose();
        background.dispose();
        preEvolutionTexture.dispose();
        evolutionTexture.dispose();
        textFont.dispose();
        evolvingMusic.dispose();
        evolvingStartSound.dispose();
        evolutionFanfare.dispose();
        clickSound.dispose();
    }
}
