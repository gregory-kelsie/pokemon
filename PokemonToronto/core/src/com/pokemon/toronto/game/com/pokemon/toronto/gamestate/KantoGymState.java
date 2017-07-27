package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;

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
            }
        }
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
