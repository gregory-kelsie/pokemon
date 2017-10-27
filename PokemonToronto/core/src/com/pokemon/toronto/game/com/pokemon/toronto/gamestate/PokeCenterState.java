package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;
import com.pokemon.toronto.game.com.pokemon.toronto.textbox.TextBoxFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.textbox.TextBoxText;

import java.util.List;

/**
 * Created by Gregory on 6/21/2017.
 */
public class PokeCenterState extends GameState{
    private GameStateManager gsm;
    private Texture background;
    private Texture nurseJoyRender;
    private Texture headerTextBox;
    private Texture textBox;
    private List<TextBoxText> text;
    private int currentTextBox;
    private boolean startedJingle;
    private boolean finishedJingle = false;
    private Music bgm;
    private Music jingle;
    private Sound clickSound;
    private final int WAITING_TEXT_BOX = 2;

    public PokeCenterState(GameStateManager gsm, boolean blackedOut) {
        this.gsm = gsm;
        background = gsm.getLoader().get("pokecenter/background.png");
        nurseJoyRender = gsm.getLoader().get("pokecenter/nursejoy.png");
        headerTextBox = gsm.getLoader().get("textbox_header.png");
        textBox = gsm.getLoader().get("textbox.png");
        text = TextBoxFactory.getPokeCenterText(blackedOut);
        currentTextBox = 0;
        startedJingle = false;
        finishedJingle = false;
        bgm =  gsm.getLoader().get("pokecenter/bgm.mp3");
        jingle =  gsm.getLoader().get("pokecenter/fanfare.mp3");
        clickSound =  gsm.getLoader().get("sounds/click.wav");
        bgm.setLooping(true);
        jingle.setLooping(false);
        bgm.play();
        Gdx.app.log("MUSIC", "PLAYING");
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 0);
        batch.draw(nurseJoyRender, 0, 0);
        batch.draw(headerTextBox, 0, 0);
        batch.draw(textBox, 0, 0);
        text.get(currentTextBox).render(batch);
    }

    @Override
    public void update(double dt) {
        text.get(currentTextBox).update(dt);
        if (startedJingle) {
            if (!jingle.isPlaying()) {
                finishedJingle = true;
                recoverParty();
                bgm.play();
                startedJingle = false;
            }
        }
        if (MyInput.clicked()) {
            if (MyInput.getX() >= 0 && MyInput.getX() <= 1080 && MyInput.getY() >= 1324 && MyInput.getY() <= 1920) {
                if (text.get(currentTextBox).finishedUpdating()) {
                    if (currentTextBox == text.size() - 1) {
                        gsm.saveParty();
                        bgm.stop();
                        gsm.setState(new LoadingState(gsm, LoadingState.POKENAV_MENU));
                        gsm.playBgm();
                        dispose();
                    } else {
                        if (currentTextBox == 1) {
                            startedJingle = true;
                            bgm.pause();
                            jingle.play();
                            currentTextBox++;
                        } else if (currentTextBox == 2) {
                            if (finishedJingle) {
                                clickSound.play();
                                currentTextBox++;
                            }
                        } else {
                            clickSound.play();
                            currentTextBox++;
                        }
                    }
                } else {
                    text.get(currentTextBox).quickUpdate();
                }
            }
        }
    }

    private void recoverParty() {
        for (int i = 0; i < gsm.getParty().size(); i++) {
            gsm.getParty().get(i).fullyHeal();
        }
    }

    @Override
    protected void dispose() {

        bgm.stop();
        gsm.getLoader().unload("pokecenter/background.png");
        gsm.getLoader().unload("pokecenter/nursejoy.png");
        gsm.getLoader().unload("textbox_header.png");
        gsm.getLoader().unload("textbox.png");

        gsm.getLoader().unload("pokecenter/bgm.mp3");
        gsm.getLoader().unload("pokecenter/fanfare.mp3");
        gsm.getLoader().unload("sounds/click.wav");
        for (int i = 0; i < text.size(); i++) {
            text.get(i).dispose();
        }

    }
}
