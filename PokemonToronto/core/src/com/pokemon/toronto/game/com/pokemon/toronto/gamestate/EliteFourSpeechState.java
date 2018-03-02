package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.TrainerFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;
import com.pokemon.toronto.game.com.pokemon.toronto.textbox.TextBoxFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.textbox.TextBoxText;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer;

import java.util.List;

/**
 * Created by gregorykelsie on 2018-02-20.
 */

public class EliteFourSpeechState extends GameState {
    private GameStateManager gsm;
    private Texture background;
    private Texture trainerRender;
    private Texture headerTextBox;
    private Texture textBox;
    private List<TextBoxText> text;
    private int currentTextBox;
    private Sound clickSound;
    private Trainer.Badge badgeType;

    public EliteFourSpeechState(GameStateManager gsm, Trainer.Badge badgeType) {
        this.gsm = gsm;
        this.badgeType = badgeType;
        background = new Texture("backgrounds/elite4bg.png");
        init();
        headerTextBox = new Texture("textbox_header.png");
        textBox = new Texture("textbox.png");
        currentTextBox = 0;
        clickSound = Gdx.audio.newSound(Gdx.files.internal(("sounds/click.wav")));
    }


    private void init() {
        if (badgeType == Trainer.Badge.KANTO_LORELEI) {
            trainerRender = new Texture("trainers/big/lorelei.png");
            text = TextBoxFactory.getLoreleiText();
        } else if (badgeType == Trainer.Badge.KANTO_BRUNO) {
            trainerRender = new Texture("trainers/big/bruno.png");
            text = TextBoxFactory.getKantoBrunoText();
        } else if (badgeType == Trainer.Badge.KANTO_AGATHA) {
            trainerRender = new Texture("trainers/big/agatha.png");
            text = TextBoxFactory.getAgathaText();
        } else if (badgeType == Trainer.Badge.KANTO_LANCE) {
            trainerRender = new Texture("trainers/big/lance.png");
            text = TextBoxFactory.getKantoLanceText();
        } else {
            trainerRender = new Texture("trainers/big/blue.png");
            text = TextBoxFactory.getChampionBlueText();
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 0);
        batch.draw(trainerRender, 0, 0);
        batch.draw(headerTextBox, 0, 0);
        batch.draw(textBox, 0, 0);
        text.get(currentTextBox).render(batch);
    }

    private void startBattleState() {
        TrainerFactory ttf = new TrainerFactory();
        Trainer trainer;
        Music wildBgm;
        if (badgeType == Trainer.Badge.KANTO_LORELEI) {
            //Start Lorelei battle.
            trainer = ttf.getLorelei();
            wildBgm = Gdx.audio.newMusic(Gdx.files.internal("bgm/kantogym.mp3"));
        } else if (badgeType == Trainer.Badge.KANTO_BRUNO) {
            trainer = ttf.getKantoBruno();
            wildBgm = Gdx.audio.newMusic(Gdx.files.internal("bgm/kantogym.mp3"));
        } else if (badgeType == Trainer.Badge.KANTO_AGATHA) {
            trainer = ttf.getAgatha();
            wildBgm = Gdx.audio.newMusic(Gdx.files.internal("bgm/kantogym.mp3"));
        } else if (badgeType == Trainer.Badge.KANTO_LANCE) {
            trainer = ttf.getKantoLance();
            wildBgm = Gdx.audio.newMusic(Gdx.files.internal("bgm/kantogym.mp3"));
        } else if (badgeType == Trainer.Badge.KANTO_CHAMPION) {
            trainer = ttf.getChampionBlue();
            wildBgm = Gdx.audio.newMusic(Gdx.files.internal("bgm/kantochampion.mp3"));
        } else {
            trainer = ttf.getChampionBlue();
            wildBgm = Gdx.audio.newMusic(Gdx.files.internal("bgm/kantochampion.mp3"));
        }

        wildBgm.setVolume(0.5f);
        wildBgm.play();
        gsm.setState(new BattleState(gsm, wildBgm, trainer));
    }

    @Override
    public void update(double dt) {
        text.get(currentTextBox).update(dt);
        if (MyInput.clicked()) {
            if (MyInput.getX() >= 0 && MyInput.getX() <= 1080 && MyInput.getY() >= 1324 && MyInput.getY() <= 1920) {
                if (text.get(currentTextBox).finishedUpdating()) {
                    if (currentTextBox == text.size() - 1) {
                        //TODO: Set battle state based on badgeType
                        startBattleState();
                        dispose();
                    } else {
                        clickSound.play();
                        currentTextBox++;
                    }
                } else {
                    text.get(currentTextBox).quickUpdate();
                }
            }
        }
    }

    @Override
    protected void dispose() {
        background.dispose();
        trainerRender.dispose();
        textBox.dispose();
        headerTextBox.dispose();
        clickSound.dispose();
        for (int i = 0; i < text.size(); i++) {
            text.get(i).dispose();
        }

    }
}
