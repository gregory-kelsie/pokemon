package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 10/29/2017.
 */

public class TrainerState extends GameState {
    private GameStateManager gsm;
    private Texture background;
    private Texture panel;
    private Texture pokeball;
    private Texture map;
    private Texture fullYellowStar;
    private Texture fullRedStar;
    private Texture halfYellow;
    private Texture halfRed;
    private int scrollAmount; //0 means haven't scrolled down at all.

    private Texture topTrainerTexture;
    private Texture midTrainerTexture;
    private Texture botTrainerTexture;

    public TrainerState(GameStateManager gsm) {
        this.gsm = gsm;
        scrollAmount = 0;
        background = new Texture("trainers/screen/background.png");
        panel = new Texture("trainers/screen/panel.png");
        pokeball = new Texture("trainers/screen/pokeball.png");
        map = new Texture("trainers/screen/map.png");
        fullYellowStar = new Texture("trainers/screen/yellowstar.png");
        fullRedStar = new Texture("trainers/screen/redstar.png");
        halfYellow = new Texture("trainers/screen/halfyellow.png");
        halfRed = new Texture("trainers/screen/halfred.png");
        if (gsm.getNearbyTrainers().size() > 0) {
            topTrainerTexture = new Texture(gsm.getNearbyTrainers().get(0).getIconPath());
            if (gsm.getNearbyTrainers().size() > 1) {
                midTrainerTexture = new Texture(gsm.getNearbyTrainers().get(1).getIconPath());
                if (gsm.getNearbyTrainers().size() > 2) {
                    botTrainerTexture = new Texture(gsm.getNearbyTrainers().get(2).getIconPath());
                }
            }
        }
    }



    @Override
    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 0);
        drawTopTrainer(batch);
        drawMiddleTrainer(batch);
        drawBottomTrainer(batch);
    }

    private void drawTopTrainer(SpriteBatch batch) {
        if (gsm.getNearbyTrainers().size() > 0) {
            //Drawable
            batch.draw(panel, 54, 1182);
            batch.draw(pokeball, 456, 1308);
            batch.draw(map, 720, 1308);
            Trainer t = gsm.getNearbyTrainers().get(scrollAmount);
            if (topTrainerTexture == null) {
               topTrainerTexture = new Texture(t.getIconPath());
            }
            batch.draw(topTrainerTexture, 72, 1275, 334, 334);
            drawStars(batch, t.getDifficulty(), 2);
        }
    }

    private void drawMiddleTrainer(SpriteBatch batch) {
        if (gsm.getNearbyTrainers().size() > 1) {
            //Drawable
            batch.draw(panel, 54, 694);
            batch.draw(pokeball, 456, 820);
            batch.draw(map, 720, 820);

            Trainer t = gsm.getNearbyTrainers().get(scrollAmount + 1);
            if (midTrainerTexture == null) {
                midTrainerTexture = new Texture(t.getIconPath());
            }
            batch.draw(midTrainerTexture, 72, 784, 334, 334);
            drawStars(batch, t.getDifficulty(), 1);
        }
    }

    private void drawBottomTrainer(SpriteBatch batch) {
        if (gsm.getNearbyTrainers().size() > 2) {
            //Drawable
            batch.draw(panel, 54, 201);
            batch.draw(pokeball, 456, 327);
            batch.draw(map, 720, 327);
            Trainer t = gsm.getNearbyTrainers().get(scrollAmount + 2);
            if (botTrainerTexture == null) {
                botTrainerTexture = new Texture(t.getIconPath());
            }
            batch.draw(botTrainerTexture, 72, 293, 334, 334);
            drawStars(batch, t.getDifficulty(), 0);
        }
    }

    private void drawStars(SpriteBatch batch, double trainerDifficulty, int position) {
        Texture starTexture;
        Texture halfStarTexture;
        double difficulty;
        if (trainerDifficulty > 5) {
            difficulty = trainerDifficulty - 5;
            starTexture = fullRedStar;
            halfStarTexture = halfRed;
        } else {
            difficulty = trainerDifficulty;
            starTexture = fullYellowStar;
            halfStarTexture = halfYellow;
        }
        int count = 0;

        Gdx.app.log("BDT", "" + difficulty);
        while (count < (int) difficulty) {
            //draw star
            batch.draw(starTexture, 80 + (count * 50), 213 + (position * 489));
            count++;
        }
        if (difficulty % 1 != 0) {
            //draw a half star, should be equal if it was a whole number
            batch.draw(halfStarTexture, 80 + (count * 50), 213 + (position * 489));
        }

    }

    private void refreshTrainerIcons() {
        topTrainerTexture.dispose();
        midTrainerTexture.dispose();
        botTrainerTexture.dispose();
        topTrainerTexture = new Texture(gsm.getNearbyTrainers().get(scrollAmount)
                .getIconPath());
        midTrainerTexture = new Texture(gsm.getNearbyTrainers().get(scrollAmount + 1)
                .getIconPath());
        botTrainerTexture = new Texture(gsm.getNearbyTrainers().get(scrollAmount + 2)
                .getIconPath());
    }
    private void clickedDown() {
        if (scrollAmount + 3 < gsm.getNearbyTrainers().size()) {
            //Scroll
            scrollAmount++;
            refreshTrainerIcons();
        }
    }

    private void clickedUp() {
        if (scrollAmount != 0) {
            scrollAmount--;
            refreshTrainerIcons();
        }
    }

    @Override
    public void update(double dt) {
        if (MyInput.clicked()) {
            int x = MyInput.getX();
            int y = MyInput.getY();
            Gdx.app.log("trainerstate", "x: " + x + ", y: " + y);
            if (x >= 35 && x <= 320 && y >= 1783 && y <= 1919) {
                gsm.setState(new LoadingState(gsm, LoadingState.POKENAV_MENU));
                dispose();
            } else if (x >= 929 && x <= 1080 && y >= 211 && y <= 301) {
                clickedUp();
            } else if (x >= 929 && x <= 1080 && y >= 1809 && y <= 1920) {
                clickedDown();
            } else if (x >= 455 && x <= 618 && y >= 486 && y <= 590) {
                //Top Trainer Battle
                if (gsm.getNearbyTrainers().size() > 0) {
                    battleTrainer(scrollAmount);
                }
            } else if (x >= 455 && x <= 618 && y >= 948 && y <= 1079) {
                //Mid Trainer Battle
                if (gsm.getNearbyTrainers().size() > scrollAmount + 1) {
                    battleTrainer(scrollAmount + 1);
                }
            } else if (x >= 455 && x <= 618 && y >= 1462 && y <= 1599) {
                //Bot Trainer Battle
                if (gsm.getNearbyTrainers().size() > scrollAmount + 2) {
                    battleTrainer(scrollAmount + 2);
                }
            }
        }
    }

    /**
     * Star the battle with the trainer at the index trainerIndex in the nearbyTrainers list
     * in the GameStateManager.
     * @param trainerIndex
     */
    public void battleTrainer(int trainerIndex) {
        gsm.stopBgm();
        Music wildBgm = Gdx.audio.newMusic(Gdx.files.internal("bgm/trainer.mp3"));
        wildBgm.setVolume(0.5f);
        wildBgm.play();

        gsm.setState(new BattleState(gsm, wildBgm, gsm.getNearbyTrainers().get(trainerIndex)));
        gsm.getNearbyTrainers().remove(trainerIndex);
        dispose();
    }

    @Override
    public void dispose() {
        background.dispose();
        panel.dispose();
        pokeball.dispose();
        map.dispose();
        fullYellowStar.dispose();
        fullRedStar.dispose();
        halfYellow.dispose();
        halfRed.dispose();
        if (topTrainerTexture != null) {
            topTrainerTexture.dispose();
        }
        if (midTrainerTexture != null) {
            midTrainerTexture.dispose();
        }
        if (botTrainerTexture != null) {
            botTrainerTexture.dispose();
        }

    }
}
