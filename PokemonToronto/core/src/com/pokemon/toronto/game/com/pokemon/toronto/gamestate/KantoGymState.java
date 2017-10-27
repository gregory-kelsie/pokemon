package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.trivial.TrainerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 7/25/2017.
 */

public class KantoGymState extends GameState {
    private GameStateManager gsm;
    private Texture background;
    private Texture title;
    private int badges;
    private List<Texture> gymTextures;
    private Sound clickSound;

    public KantoGymState(GameStateManager gsm) {
        this.gsm = gsm;
        badges = 7;
        gymTextures = new ArrayList<Texture>();
        background = new Texture("simulator/background.png");
        title = new Texture("simulator/gym_leaders/kanto/title.png");
        gymTextures.add(new Texture("simulator/gym_leaders/kanto/brock.png"));
        clickSound = Gdx.audio.newSound(Gdx.files.internal("sounds/click.wav"));
        addLitTextures();
        addGrayTextures();

    }

    private void addLitTextures() {
        if (badges >= 1) {
            gymTextures.add(new Texture("simulator/gym_leaders/kanto/misty.png"));
            if (badges >= 2) {
                gymTextures.add(new Texture("simulator/gym_leaders/kanto/ltsurge.png"));
                if (badges >= 3) {
                    gymTextures.add(new Texture("simulator/gym_leaders/kanto/erika.png"));
                    if (badges >= 4) {
                        gymTextures.add(new Texture("simulator/gym_leaders/kanto/janine.png"));
                        if (badges >= 5) {
                            gymTextures.add(new Texture("simulator/gym_leaders/kanto/sabrina.png"));
                            if (badges >= 6) {
                                gymTextures.add(new Texture("simulator/gym_leaders/kanto/blaine.png"));
                                if (badges >= 7) {
                                    gymTextures.add(new Texture("simulator/gym_leaders/kanto/gary.png"));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    private void addGrayTextures() {
        if (badges < 1) {
            gymTextures.add(new Texture("simulator/gym_leaders/kanto/misty_gray.png"));
        }
        if (badges < 2) {
            gymTextures.add(new Texture("simulator/gym_leaders/kanto/ltsurge_gray.png"));
        }
        if (badges < 3) {
            gymTextures.add(new Texture("simulator/gym_leaders/kanto/erika_gray.png"));
        }
        if (badges < 4) {
            gymTextures.add(new Texture("simulator/gym_leaders/kanto/janine_gray.png"));
        }
        if (badges < 5) {
            gymTextures.add(new Texture("simulator/gym_leaders/kanto/sabrina_gray.png"));
        }
        if (badges < 6) {
            gymTextures.add(new Texture("simulator/gym_leaders/kanto/blaine_gray.png"));
        }
        if (badges < 7) {
            gymTextures.add(new Texture("simulator/gym_leaders/kanto/gary_gray.png"));
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 0);
        batch.draw(title, 120, 1764);
        batch.draw(gymTextures.get(0), 50, 1359);
        batch.draw(gymTextures.get(1), 546, 1359);
        batch.draw(gymTextures.get(2), 50, 909);
        batch.draw(gymTextures.get(3), 546, 909);
        batch.draw(gymTextures.get(4), 50, 474);
        batch.draw(gymTextures.get(5), 546, 474);
        batch.draw(gymTextures.get(6), 50, 40);
        batch.draw(gymTextures.get(7), 546, 40);
    }

    @Override
    public void update(double dt) {
        if (MyInput.clicked()) {
            int x = MyInput.getX();
            int y = MyInput.getY();
            if (x >= 911 && x <= 1080 && y >= 0 && y <= 136) {
                clickedPowerButton();
            } else if (x >= 89 && x <= 439 && y >= 207 && y <= 522) {
                //Clicked Brock
                TrainerFactory ttf = new TrainerFactory();
                loadGymLeader(ttf.getGymLeaderBrock());
                dispose();
            } else if (x >= 534 && x <= 901 && y >= 221 && y <= 457) {
                //Clicked Misty
                TrainerFactory ttf = new TrainerFactory();
                loadGymLeader(ttf.getGymLeaderMisty());
            } else if (x >= 89 && x <= 439 && y >= 702 && y <= 964) {
                //Clicked Lt Surge
                TrainerFactory ttf = new TrainerFactory();
                loadGymLeader(ttf.getGymLeaderLtSurge());
            } else if (x >= 534 && x <= 901 && y >= 702 && y <= 964) {
                //Clicked Erika
                TrainerFactory ttf = new TrainerFactory();
                loadGymLeader(ttf.getGymLeaderErika());
            } else if (x >= 89 && x <= 439 && y >= 1165 && y <= 1386) {
                //Clicked Janine
                TrainerFactory ttf = new TrainerFactory();
                loadGymLeader(ttf.getGymLeaderJanine());
            } else if (x >= 534 && x <= 901 && y >= 1165 && y <= 1386) {
                //Clicked Sabrina
                TrainerFactory ttf = new TrainerFactory();
                loadGymLeader(ttf.getGymLeaderSabrina());
            } else if (x >= 89 && x <= 439 && y >= 1575 && y <= 1800) {
                //Clicked Blaine
                TrainerFactory ttf = new TrainerFactory();
                loadGymLeader(ttf.getGymLeaderBlaine());
            } else if (x >= 534 && x <= 901 && y >= 1575 && y <= 1800) {
                //Clicked Blue
                TrainerFactory ttf = new TrainerFactory();
                loadGymLeader(ttf.getGymLeaderBlue());
            }
            Gdx.app.log("coords", "x: " + x + ", y: " + y);
        }
    }

    private void loadGymLeader(Trainer leader) {
        gsm.stopBgm();
        Music wildBgm = Gdx.audio.newMusic(Gdx.files.internal("bgm/kantogym.mp3"));
        wildBgm.setVolume(0.5f);
        wildBgm.play();
        gsm.setState(new BattleState(gsm, wildBgm, leader));
        dispose();
    }
    private void clickedPowerButton() {
        clickSound.play();
        gsm.setState(new RegionMenu(gsm, 0)); //0 brings back to kanto region menu
        dispose();
    }
    @Override
    protected void dispose() {
        background.dispose();
        title.dispose();
        for (Texture gymTexture: gymTextures) {
            gymTexture.dispose();
        }
        clickSound.dispose();
    }
}
