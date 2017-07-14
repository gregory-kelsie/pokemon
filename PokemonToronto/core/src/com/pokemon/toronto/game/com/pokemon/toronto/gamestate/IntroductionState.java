package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Bulbasaur;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Charmander;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Squirtle;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.Animation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.AnimationFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.StraightLineAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;
import com.pokemon.toronto.game.com.pokemon.toronto.textbox.TextBoxFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.textbox.TextBoxText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/5/2017.
 */
public class IntroductionState extends GameState {

    private Texture background;
    private Texture genderImages;
    private Texture yesNoImages;
    private Texture textBox;
    private Texture textBoxHeader;
    private Animation bulbasaurAnimation;
    private Animation charmanderAnimation;
    private Animation squirtleAnimation;
    private Texture starterPokeballsTexture;
    private List<TextBoxText> tbts;
    private TextBoxText genderText;
    private TextBoxText maleResponseText;
    private TextBoxText femaleResponseText;
    private TextBoxText genderResponseText;
    private TextBoxText pokeballSelectText;
    private TextBoxText congratsText;
    private List<TextBoxText> bulbasaurDexText;
    private List<TextBoxText> charmanderDexText;
    private List<TextBoxText> squirtleDexText;
    private Animation ivyAnimation;
    private StraightLineAnimation droppingPokeballAnimation;
    private Texture ivyWink;
    private int currentTextBox;

    private Sound clickSound;
    private Sound bulbasaurCry;
    private Sound charmanderCry;
    private Sound squirtleCry;
    private Sound throwPokeballSound;
    private Sound wooshSound;
    private Sound caughtPokemonSound;
    private Music ivyTheme;

    //Quick Switches
    private boolean crySwitch;

    //Counters
    //Count time when the caught sound is played
    //When the sound played for it's duration, unpause the ivy theme.
    private double caughtSoundCounter;
    private float fadingCounter;
    private double fadingRate = (0.0033333f / 2.0f);
    private final double caughtSoundDuration = 3; //2.009 seconds of play time
    //FLAGS
    private boolean firstDialogue;
    private boolean genderDialogue;
    private boolean genderResponseDialogue;
    private boolean pokemonSelectDialogue;
    private boolean drawGenderOptions;
    private boolean drawYesNoOptions;
    private boolean choseMale;
    private boolean choseFemale;
    private boolean drawPokeballs;
    private boolean displayBulbasaurIntroduction;
    private boolean displayCharmanderIntroduction;
    private boolean displaySquirtleIntroduction;
    private boolean drawDroppingPokeballAnimation;
    private boolean justFinishedDroppingPokeball;
    private boolean startedFadingPokemon;
    private boolean finishedFadingPokemon;
    private boolean justFinishedFadingPokemon;
    private boolean startedCaughtSound;
    private boolean obtainedPokemon;
    private boolean startedFading;
    private ShapeRenderer shapeRenderer;
    private GameStateManager gsm;
    //Newly Set Variables
    private char gender;

    public IntroductionState(GameStateManager gsm) {
        this.gsm = gsm;
        gsm.setNotificationSound();
        tbts = TextBoxFactory.getFirstBox();
        genderText = TextBoxFactory.getGenderText();
        maleResponseText = TextBoxFactory.getMaleResponseText();
        femaleResponseText = TextBoxFactory.getFemaleResponseText();
        genderResponseText = TextBoxFactory.getGenderResponseText();
        pokeballSelectText = TextBoxFactory.getPokeballSelectText();
        bulbasaurDexText = TextBoxFactory.getStarterBulbasaurText();
        charmanderDexText = TextBoxFactory.getStarterCharmanderText();
        squirtleDexText = TextBoxFactory.getStarterSquirtleText();
        congratsText = TextBoxFactory.getCongratsText();
        background = gsm.getLoader().get("nature_background.png");
        genderImages = gsm.getLoader().get("genderOptions.png");
        yesNoImages = gsm.getLoader().get("yesNoOptions.png");
        starterPokeballsTexture = gsm.getLoader().get("starterPokeballs.png");
        charmanderAnimation = AnimationFactory.getCharmanderAnimation(gsm.getLoader());
        bulbasaurAnimation = AnimationFactory.getBulbasaurAnimation(gsm.getLoader());
        squirtleAnimation = AnimationFactory.getSquirtleAnimation(gsm.getLoader());
        ivyAnimation = AnimationFactory.getIvyAnimation(gsm.getLoader());
        droppingPokeballAnimation = AnimationFactory.getDroppingPokeballAnimation(gsm.getLoader());
        ivyWink = gsm.getLoader().get("professor_ivy3.png");
        textBox = gsm.getLoader().get("textbox.png");
        textBoxHeader = gsm.getLoader().get("textbox_header.png");
        currentTextBox = 0;
        fadingCounter = 0;
        crySwitch = false;
        initAudio();
        initFlags();
        initCounters();
        shapeRenderer = new ShapeRenderer();
    }

    private void initCounters() {
        caughtSoundCounter = 0;
    }

    private void initAudio() {
        //clickSound = Gdx.audio.newSound(Gdx.files.internal("sounds/click.wav"));
        clickSound = gsm.getLoader().get("sounds/click.wav");
        bulbasaurCry = gsm.getLoader().get("sounds/cry/01.wav");
        charmanderCry = gsm.getLoader().get("sounds/cry/04.wav");
        squirtleCry = gsm.getLoader().get("sounds/cry/07.wav");
        throwPokeballSound = gsm.getLoader().get("sounds/throwPokeball.wav");
        wooshSound = gsm.getLoader().get("sounds/woosh.wav");
        caughtPokemonSound = gsm.getLoader().get("sounds/caughtPokemon.wav");
        ivyTheme = gsm.getLoader().get("bgm/professorIvyTheme.mp3", Music.class);
        //ivyTheme = Gdx.audio.newMusic(Gdx.files.internal("bgm/professorIvyTheme.mp3"));
        ivyTheme.setLooping(true);
        ivyTheme.play();
    }

    private void initFlags() {
        firstDialogue = true;
        genderDialogue = false;
        genderResponseDialogue = false;
        pokemonSelectDialogue = false;
        drawGenderOptions = false;
        drawYesNoOptions = false;
        choseMale = false;
        choseFemale = false;
        drawPokeballs = false;
        displayBulbasaurIntroduction = false;
        displayCharmanderIntroduction = false;
        displaySquirtleIntroduction = false;
        drawDroppingPokeballAnimation = false;
        justFinishedDroppingPokeball = false;
        startedFadingPokemon = false;
        finishedFadingPokemon = false;
        justFinishedFadingPokemon = false;
        startedCaughtSound = false;
        obtainedPokemon = false;
        startedFading = false;
    }
    private boolean selectedGender() {
        return (choseMale || choseFemale);
    }
    private void firstDialogueClickedTextBox() {
        if (!tbts.get(currentTextBox).finishedUpdating()) {
            tbts.get(currentTextBox).quickUpdate();
        } else {
            //Get next textbox.
            if (currentTextBox == tbts.size() - 1) {
                firstDialogue = false;
                genderDialogue = true;
            } else {
                currentTextBox++;
            }
            clickSound.play();
        }
    }

    private void genderDialogueClickedTextBox() {
        if (!genderText.finishedUpdating()) {
            genderText.quickUpdate();
        }
        if (choseMale && !maleResponseText.finishedUpdating()) {
            maleResponseText.quickUpdate();
        }
        if (choseFemale && !femaleResponseText.finishedUpdating()) {
            femaleResponseText.quickUpdate();
        }
        if (MyInput.getX() >= 75 && MyInput.getX() <= 333 && MyInput.getY() >= 1579 && MyInput.getY() <= 1795) {
            //Chose Male
            if (drawGenderOptions) {
                choseMale = true;
                drawGenderOptions = false;
                clickSound.play();
            }
        }
        if (MyInput.getX() >= 639 && MyInput.getX() <= 935 && MyInput.getY() >= 1630 && MyInput.getY() <= 1804) {
            //Chose Female
            if (drawGenderOptions) {
                choseFemale = true;
                drawGenderOptions = false;
                clickSound.play();
            }
        }
        if (MyInput.getX() >= 69 && MyInput.getX() <= 414 && MyInput.getY() >= 1582 && MyInput.getY() <= 1760) {
            //Chose Yes
            if (drawYesNoOptions) {
                if (choseMale) {
                    gender = 'm';
                } else if (choseFemale) {
                    gender = 'f';
                }
                genderResponseDialogue = true;
                genderDialogue = false;
                drawYesNoOptions = false;
                clickSound.play();
            }

        }
        if (MyInput.getX() >= 658 && MyInput.getX() <= 996 && MyInput.getY() >= 1626 && MyInput.getY() <= 1785) {
            //Chose No
            if (drawYesNoOptions) {
                genderText.resetLines();
                choseMale = false;
                choseFemale = false;
                drawYesNoOptions = false;
                maleResponseText.resetLines();
                femaleResponseText.resetLines();
                clickSound.play();
            }
        }
    }

    private void genderResponseDialogueClickedTextBox() {
        if (!genderResponseText.finishedUpdating()) {
            genderResponseText.quickUpdate();
        } else {
            genderResponseDialogue = false;
            pokemonSelectDialogue = true;
            clickSound.play();
        }
    }

    private void pokemonSelectDialogueClickedTextBox() {
        if (!pokeballSelectText.finishedUpdating()) {
            pokeballSelectText.quickUpdate();
        } else {
            //Check to see if clicked on a Pokeball
            if (MyInput.getX() >= 10 && MyInput.getX() <= 306 && MyInput.getY() >= 1646 && MyInput.getY() <= 1916) {
                //Left Pokeball
                displayBulbasaurIntroduction = true;
                pokemonSelectDialogue = false;
                drawPokeballs = false;
                crySwitch = true;
                currentTextBox = 0;
            } else if (MyInput.getX() >= 403 && MyInput.getX() <= 615 && MyInput.getY() >= 1646 && MyInput.getY() <= 1916) {
                //Middle Pokeball
                displayCharmanderIntroduction = true;
                pokemonSelectDialogue = false;
                drawPokeballs = false;
                crySwitch = true;
                currentTextBox = 0;
            } else if (MyInput.getX() >= 765 && MyInput.getX() <= 996 && MyInput.getY() >= 1646 && MyInput.getY() <= 1916) {
                //Right Pokeball
                displaySquirtleIntroduction = true;
                pokemonSelectDialogue = false;
                crySwitch = true;
                drawPokeballs = false;
                currentTextBox = 0;
            }
        }
    }

    private void charmanderClicked() {
        if (!charmanderDexText.get(currentTextBox).finishedUpdating()) {
            charmanderDexText.get(currentTextBox).quickUpdate();
        } else {
            boolean exited = false;
            if (currentTextBox != charmanderDexText.size() - 1) {
                currentTextBox++;
                clickSound.play();
            }

            if (MyInput.getX() >= 69 && MyInput.getX() <= 414 && MyInput.getY() >= 1582 && MyInput.getY() <= 1760) {
                //Clicked yes
                if (drawYesNoOptions) {
                    gsm.addToParty(new Charmander(5));
                    drawDroppingPokeballAnimation = true;
                    drawYesNoOptions = false;
                    throwPokeballSound.play();
                }
            } else if (MyInput.getX() >= 658 && MyInput.getX() <= 996 && MyInput.getY() >= 1626 && MyInput.getY() <= 1785) {
                //Chose No
                if (drawYesNoOptions) {
                    exited = true;
                    pokemonSelectDialogue = true;
                    pokeballSelectText.resetLines();
                    for (int i = 0; i < charmanderDexText.size(); i++) {
                        charmanderDexText.get(i).resetLines();
                    }
                    drawYesNoOptions = false;
                    displayCharmanderIntroduction = false;
                    clickSound.play();
                }
            }

            if (exited) {
                currentTextBox = 0;
            }
        }
    }

    private void bulbasaurClicked() {
        if (!bulbasaurDexText.get(currentTextBox).finishedUpdating()) {
            bulbasaurDexText.get(currentTextBox).quickUpdate();
        } else {
            boolean exited = false;
            if (currentTextBox != bulbasaurDexText.size() - 1) {
                currentTextBox++;
                clickSound.play();
            }

            if (MyInput.getX() >= 69 && MyInput.getX() <= 414 && MyInput.getY() >= 1582 && MyInput.getY() <= 1760) {
                //Clicked yes
                if (drawYesNoOptions) {
                    gsm.addToParty(new Bulbasaur(5));
                    drawDroppingPokeballAnimation = true;
                    drawYesNoOptions = false;
                    throwPokeballSound.play();
                }
            } else if (MyInput.getX() >= 658 && MyInput.getX() <= 996 && MyInput.getY() >= 1626 && MyInput.getY() <= 1785) {
                //Chose No
                if (drawYesNoOptions) {
                    exited = true;
                    pokemonSelectDialogue = true;
                    pokeballSelectText.resetLines();
                    for (int i = 0; i < bulbasaurDexText.size(); i++) {
                        bulbasaurDexText.get(i).resetLines();
                    }
                    drawYesNoOptions = false;
                    displayBulbasaurIntroduction = false;
                    clickSound.play();
                }
            }

            if (exited) {
                currentTextBox = 0;
            }
        }
    }

    private void squirtleClicked() {
        if (!squirtleDexText.get(currentTextBox).finishedUpdating()) {
            squirtleDexText.get(currentTextBox).quickUpdate();
        } else {
            boolean exited = false;
            if (currentTextBox != squirtleDexText.size() - 1) {
                currentTextBox++;
                clickSound.play();
            }

            if (MyInput.getX() >= 69 && MyInput.getX() <= 414 && MyInput.getY() >= 1582 && MyInput.getY() <= 1760) {
                //Clicked yes
                if (drawYesNoOptions) {
                    gsm.addToParty(new Squirtle(5));
                    drawYesNoOptions = false;
                    drawDroppingPokeballAnimation = true;
                    throwPokeballSound.play();
                }
            } else if (MyInput.getX() >= 658 && MyInput.getX() <= 996 && MyInput.getY() >= 1626 && MyInput.getY() <= 1785) {
                //Chose No
                if (drawYesNoOptions) {
                    exited = true;
                    pokemonSelectDialogue = true;
                    pokeballSelectText.resetLines();
                    for (int i = 0; i < squirtleDexText.size(); i++) {
                        squirtleDexText.get(i).resetLines();
                    }
                    drawYesNoOptions = false;
                    displaySquirtleIntroduction = false;
                    clickSound.play();
                }
            }

            if (exited) {
                currentTextBox = 0;
            }
        }
    }

    private void obtainedPokemonClicked() {
        if (!congratsText.finishedUpdating()) {
            congratsText.quickUpdate();
        } else {
            //Open new gamestate
            startedFading = true;
            obtainedPokemon = false;
            clickSound.play();
        }
    }

    private boolean isDisplayingStarter() {
        if (displaySquirtleIntroduction || displayCharmanderIntroduction || displayBulbasaurIntroduction) {
            return true;
        }
        return false;
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 0);
        if (genderResponseDialogue) {
            batch.draw(ivyWink, 0, 0);
        } else if (!isDisplayingStarter()){
            ivyAnimation.render(batch);
        }
        if (!drawDroppingPokeballAnimation && !startedFading) {
            batch.draw(textBox, 0, 0);
            batch.draw(textBoxHeader, 0, 0);
        }
        if (firstDialogue) {
            tbts.get(currentTextBox).render(batch);
        } else if (genderDialogue) {
            if (!selectedGender()) {
                genderText.render(batch);
            } else if (choseMale) {
                maleResponseText.render(batch);
            } else if (choseFemale) {
                femaleResponseText.render(batch);
            }
        } else if (genderResponseDialogue) {
            genderResponseText.render(batch);
        } else if (pokemonSelectDialogue) {
            pokeballSelectText.render(batch);
        } else if (obtainedPokemon) {
            congratsText.render(batch);
        } else if (startedFading) {
            batch.end();
            Gdx.gl.glEnable(GL20.GL_BLEND);
            Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(0,0,0, this.fadingCounter);
            shapeRenderer.rect(0,0,1080, 1920);
            shapeRenderer.end();
            Gdx.gl.glDisable(GL20.GL_BLEND);
            batch.begin();
        }
        if (drawGenderOptions) {
            batch.draw(genderImages, 0, 0);
        }

        if (drawYesNoOptions) {
            batch.draw(yesNoImages, 0, 0);
        }

        if (drawPokeballs) {
            batch.draw(starterPokeballsTexture, 0, 0);
        }

        if (displayBulbasaurIntroduction) {
            if (!finishedFadingPokemon) {
                bulbasaurAnimation.render(batch);
            }
            if (!drawDroppingPokeballAnimation) {
                bulbasaurDexText.get(currentTextBox).render(batch);
            }
            if (crySwitch) {
                crySwitch = false;
                bulbasaurCry.play();
            }
        }
        if (displayCharmanderIntroduction) {
            if (!finishedFadingPokemon) {
                charmanderAnimation.render(batch);
            }
            if (!drawDroppingPokeballAnimation) {
                charmanderDexText.get(currentTextBox).render(batch);
            }
            if (crySwitch) {
                crySwitch = false;
                charmanderCry.play();
            }
        }
        if (displaySquirtleIntroduction) {
            if (!finishedFadingPokemon) {
                squirtleAnimation.render(batch);
            }
            if (!drawDroppingPokeballAnimation) {
                squirtleDexText.get(currentTextBox).render(batch);
            }
            if (crySwitch) {
                crySwitch = false;
                squirtleCry.play();
            }
        }

        if (drawDroppingPokeballAnimation) {
            droppingPokeballAnimation.render(batch);
        }

    }

    @Override
    public void update(double dt) {
        if (startedCaughtSound) {
            caughtSoundCounter += dt;
            if (caughtSoundCounter >= caughtSoundDuration) {
                ivyTheme.play();
                obtainedPokemon = true;
                drawDroppingPokeballAnimation = false;
                startedCaughtSound = false;
                displayCharmanderIntroduction = false;
                displayBulbasaurIntroduction = false;
                displaySquirtleIntroduction = false;
            }
        }
        if (!genderResponseDialogue) {
            ivyAnimation.update(dt);
        }
        if (this.firstDialogue) {
            tbts.get(currentTextBox).update(dt);
        } else if (genderDialogue) {
            genderText.update(dt);
            if (genderText.finishedUpdating()) {
                //Draw the gender select images when the gender
                //hasn't been selected.
                if (!selectedGender()) {
                    drawGenderOptions = true;
                } else {
                    //Draw the response text for the chosen gender.
                    if (choseMale) {
                        maleResponseText.update(dt);
                        if (maleResponseText.finishedUpdating()) {
                            drawYesNoOptions = true;
                        }
                    } else if (choseFemale) {
                        femaleResponseText.update(dt);
                        if (femaleResponseText.finishedUpdating()) {
                            drawYesNoOptions = true;
                        }
                    }
                }
            }
        } else if (genderResponseDialogue) {
            genderResponseText.update(dt);
        } else if (pokemonSelectDialogue) {
            pokeballSelectText.update(dt);
            if (pokeballSelectText.finishedUpdating()) {
                drawPokeballs = true;
            }
        } else if (displayCharmanderIntroduction) {
            if (startedFadingPokemon) {
                charmanderAnimation.update(dt);
            }
            if (charmanderAnimation.finishedAnimation() && !justFinishedFadingPokemon) {
                finishedFadingPokemon = true;
                justFinishedFadingPokemon = true;
                droppingPokeballAnimation.setInitialFrame();
                caughtPokemonSound.play();
                startedCaughtSound = true;
                caughtPokemonSound.play();
                charmanderAnimation.reset();
                ivyTheme.pause();
            }
            charmanderDexText.get(currentTextBox).update(dt);
            if (currentTextBox == charmanderDexText.size() - 1 &&
                    charmanderDexText.get(currentTextBox).finishedUpdating()) {
                if (!drawDroppingPokeballAnimation) {
                    drawYesNoOptions = true;
                }
            }

        } else if (displayBulbasaurIntroduction) {
            if (startedFadingPokemon) {
                bulbasaurAnimation.update(dt);
            }
            if (bulbasaurAnimation.finishedAnimation() && !justFinishedFadingPokemon) {
                finishedFadingPokemon = true;
                justFinishedFadingPokemon = true;
                droppingPokeballAnimation.setInitialFrame();
                startedCaughtSound = true;
                caughtPokemonSound.play();
                bulbasaurAnimation.reset();
                ivyTheme.pause();
            }
            bulbasaurDexText.get(currentTextBox).update(dt);
            if (currentTextBox == bulbasaurDexText.size() - 1 &&
                    bulbasaurDexText.get(currentTextBox).finishedUpdating()) {
                if (!drawDroppingPokeballAnimation) {
                    drawYesNoOptions = true;
                }
            }
        } else if (displaySquirtleIntroduction) {
            if (startedFadingPokemon) {
                squirtleAnimation.update(dt);
            }
            if (squirtleAnimation.finishedAnimation() && !justFinishedFadingPokemon) {
                finishedFadingPokemon = true;
                justFinishedFadingPokemon = true;
                droppingPokeballAnimation.setInitialFrame();
                startedCaughtSound = true;
                caughtPokemonSound.play();
                squirtleAnimation.reset();
                ivyTheme.pause();
            }
            squirtleDexText.get(currentTextBox).update(dt);
            if (currentTextBox == squirtleDexText.size() - 1 &&
                    squirtleDexText.get(currentTextBox).finishedUpdating()) {
                if (!drawDroppingPokeballAnimation) {
                    drawYesNoOptions = true;
                }
            }
        } else if (obtainedPokemon) {
            congratsText.update(dt);
        } else if (startedFading) {
            fadingCounter += fadingRate;
            ivyTheme.setVolume(Math.max(0,1 - fadingCounter));
            if (fadingCounter >= 1) {
                //Switch states
                gsm.getGameCallBack().spawnNewGamePokemon();
                gsm.setState(new LoadingState(gsm, LoadingState.MAIN_MENU));
                dispose();
            }
        }
        if (drawDroppingPokeballAnimation) {
            droppingPokeballAnimation.update(dt);
            if (droppingPokeballAnimation.ended()) {
                if (!justFinishedDroppingPokeball) {
                    justFinishedDroppingPokeball = true;
                    startedFadingPokemon = true;
                    wooshSound.play();
                }

            }

        }
        if (MyInput.clicked()) {
            if (MyInput.getX() >= 0 && MyInput.getX() <= 1080 && MyInput.getY() >= 1324 && MyInput.getY() <= 1920) {
                if (this.firstDialogue) {
                    firstDialogueClickedTextBox();
                } else if (genderDialogue) {
                    genderDialogueClickedTextBox();
                } else if (genderResponseDialogue) {
                    genderResponseDialogueClickedTextBox();
                } else if (pokemonSelectDialogue) {
                    pokemonSelectDialogueClickedTextBox();
                } else if (displayCharmanderIntroduction) {
                    charmanderClicked();
                } else if (displayBulbasaurIntroduction) {
                    bulbasaurClicked();
                } else if (displaySquirtleIntroduction) {
                    squirtleClicked();
                } else if (obtainedPokemon) {
                    obtainedPokemonClicked();
                }
            }
            Gdx.app.log("GDX LOGGERs - ", "X: " + MyInput.getX() + ", Y: " + MyInput.getY());
        }
    }

    @Override
    protected void dispose() {
        textBox.dispose();
        textBoxHeader.dispose();
        ivyTheme.stop();

        shapeRenderer.dispose();
        for (int i = 0; i < tbts.size(); i++) {
            tbts.get(i).dispose();
        }
        gsm.getLoader().unload("nature_background.png");
        gsm.getLoader().unload("genderOptions.png");
        gsm.getLoader().unload("yesNoOptions.png");
        gsm.getLoader().unload("starterPokeballs.png");
        gsm.getLoader().unload("professor_ivy3.png");
        gsm.getLoader().unload("textbox.png");
        gsm.getLoader().unload("textbox_header.png");
        gsm.getLoader().unload("professor_ivy.png");
        gsm.getLoader().unload("professor_ivy2.png");
        gsm.getLoader().unload("starterImages/charmander.png");
        gsm.getLoader().unload("starterImages/charmander02.png");
        gsm.getLoader().unload("starterImages/charmander03.png");
        gsm.getLoader().unload("starterImages/charmander04.png");
        gsm.getLoader().unload("starterImages/charmander05.png");
        gsm.getLoader().unload("starterImages/bulbasaur.png");
        gsm.getLoader().unload("starterImages/bulbasaur02.png");
        gsm.getLoader().unload("starterImages/bulbasaur03.png");
        gsm.getLoader().unload("starterImages/bulbasaur04.png");
        gsm.getLoader().unload("starterImages/bulbasaur05.png");
        gsm.getLoader().unload("starterImages/squirtle.png");
        gsm.getLoader().unload("starterImages/squirtle02.png");
        gsm.getLoader().unload("starterImages/squirtle03.png");
        gsm.getLoader().unload("starterImages/squirtle04.png");
        gsm.getLoader().unload("starterImages/squirtle05.png");
        gsm.getLoader().unload("closedPokeball.png");
        gsm.getLoader().unload("openPokeball.png");

        gsm.getLoader().unload("sounds/cry/01.wav");
        gsm.getLoader().unload("sounds/cry/04.wav");
        gsm.getLoader().unload("sounds/cry/07.wav");
        gsm.getLoader().unload("sounds/throwPokeball.wav");
        gsm.getLoader().unload("sounds/woosh.wav");
        gsm.getLoader().unload("sounds/caughtPokemon.wav");

        gsm.getLoader().unload("bgm/professorIvyTheme.mp3");
    }
}
