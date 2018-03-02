package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.area.RouteStateModel;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.TrainerFactory;

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

    private int routeNumber;
    private int region;

    public KantoGymState(GameStateManager gsm, int routeNumber, int region) {
        this.gsm = gsm;
        this.routeNumber = routeNumber; //The route number the player was on in the simulator.
        this.region = region;
        gymTextures = new ArrayList<Texture>();
        if (region == RouteStateModel.JOHTO) {
            badges = gsm.getPlayer().getJohtoBadges();
            addJohtoBadges();
        } else {
            badges = gsm.getPlayer().getKantoBadges();
            addBadges();
        }

        background = new Texture("simulator/background.png");
        title = new Texture("simulator/gym_leaders/kanto/title.png");
        clickSound = Gdx.audio.newSound(Gdx.files.internal("sounds/click.wav"));


    }

    private void addJohtoBadges() {
        if (badges == 0) {
            gymTextures.add(new Texture("simulator/gym_leaders/johto/falkner.png"));
        } else {
            gymTextures.add(new Texture("simulator/gym_leaders/johto/falkner_gray.png"));
        }

        if (badges == 1) {
            gymTextures.add(new Texture("simulator/gym_leaders/johto/bugsy.png"));
        } else {
            gymTextures.add(new Texture("simulator/gym_leaders/johto/bugsy_gray.png"));
        }

        if (badges == 2) {
            gymTextures.add(new Texture("simulator/gym_leaders/johto/whitney.png"));
        } else {
            gymTextures.add(new Texture("simulator/gym_leaders/johto/whitney_gray.png"));
        }

        if (badges == 3) {
            gymTextures.add(new Texture("simulator/gym_leaders/johto/morty.png"));
        } else {
            gymTextures.add(new Texture("simulator/gym_leaders/johto/morty_gray.png"));
        }

        if (badges == 4) {
            gymTextures.add(new Texture("simulator/gym_leaders/johto/chuck.png"));
        } else {
            gymTextures.add(new Texture("simulator/gym_leaders/johto/chuck_gray.png"));
        }

        if (badges == 5) {
            gymTextures.add(new Texture("simulator/gym_leaders/johto/jasmine.png"));
        } else {
            gymTextures.add(new Texture("simulator/gym_leaders/johto/jasmine_gray.png"));
        }


        if (badges == 6) {
            gymTextures.add(new Texture("simulator/gym_leaders/johto/pryce.png"));
        } else {
            gymTextures.add(new Texture("simulator/gym_leaders/johto/pryce_gray.png"));
        }

        if (badges == 7) {
            gymTextures.add(new Texture("simulator/gym_leaders/johto/clair.png"));
        } else {
            gymTextures.add(new Texture("simulator/gym_leaders/johto/clair_gray.png"));
        }
    }

    private void addBadges() {
        if (badges == 0) {
            gymTextures.add(new Texture("simulator/gym_leaders/kanto/brock.png"));
        } else {
            gymTextures.add(new Texture("simulator/gym_leaders/kanto/brock_gray.png"));
        }

        if (badges == 1) {
            gymTextures.add(new Texture("simulator/gym_leaders/kanto/misty.png"));
        } else {
            gymTextures.add(new Texture("simulator/gym_leaders/kanto/misty_gray.png"));
        }

        if (badges == 2) {
            gymTextures.add(new Texture("simulator/gym_leaders/kanto/ltsurge.png"));
        } else {
            gymTextures.add(new Texture("simulator/gym_leaders/kanto/ltsurge_gray.png"));
        }

        if (badges == 3) {
            gymTextures.add(new Texture("simulator/gym_leaders/kanto/erika.png"));
        } else {
            gymTextures.add(new Texture("simulator/gym_leaders/kanto/erika_gray.png"));
        }

        if (badges == 4) {
            gymTextures.add(new Texture("simulator/gym_leaders/kanto/janine.png"));
        } else {
            gymTextures.add(new Texture("simulator/gym_leaders/kanto/janine_gray.png"));
        }

        if (badges == 5) {
            gymTextures.add(new Texture("simulator/gym_leaders/kanto/sabrina.png"));
        } else {
            gymTextures.add(new Texture("simulator/gym_leaders/kanto/sabrina_gray.png"));
        }


        if (badges == 6) {
            gymTextures.add(new Texture("simulator/gym_leaders/kanto/blaine.png"));
        } else {
            gymTextures.add(new Texture("simulator/gym_leaders/kanto/blaine_gray.png"));
        }

        if (badges == 7) {
            gymTextures.add(new Texture("simulator/gym_leaders/kanto/gary.png"));
        } else {
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
                clickedFirstGym();
            } else if (x >= 534 && x <= 901 && y >= 221 && y <= 457) {
                clickedSecondGym();
            } else if (x >= 89 && x <= 439 && y >= 702 && y <= 964) {
                clickedThirdGym();
            } else if (x >= 534 && x <= 901 && y >= 702 && y <= 964) {
                clickedFourthGym();
            } else if (x >= 89 && x <= 439 && y >= 1165 && y <= 1386) {
                clickedFifthGym();
            } else if (x >= 534 && x <= 901 && y >= 1165 && y <= 1386) {
                clickedSixthGym();
            } else if (x >= 89 && x <= 439 && y >= 1575 && y <= 1800) {
                clickedSeventhGym();
            } else if (x >= 534 && x <= 901 && y >= 1575 && y <= 1800) {
                clickedEightGym();
            }
            Gdx.app.log("coords", "x: " + x + ", y: " + y);
        }
    }

    private void clickedFirstGym() {
        if (region == RouteStateModel.KANTO && gsm.getPlayer().getKantoBadges() == 0) {
            TrainerFactory ttf = new TrainerFactory();
            loadGymLeader(ttf.getGymLeaderBrock());
            dispose();
        } else if (region == RouteStateModel.JOHTO && gsm.getPlayer().getJohtoBadges() == 0) {
            TrainerFactory ttf = new TrainerFactory();
            loadGymLeader(ttf.getGymLeaderFalkner());
            dispose();
        }
    }

    private void clickedSecondGym() {
        if (region == RouteStateModel.KANTO && gsm.getPlayer().getKantoBadges() == 1) {
            TrainerFactory ttf = new TrainerFactory();
            loadGymLeader(ttf.getGymLeaderMisty());
        } else if (region == RouteStateModel.JOHTO && gsm.getPlayer().getJohtoBadges() == 1) {
            TrainerFactory ttf = new TrainerFactory();
            loadGymLeader(ttf.getGymLeaderBugsy());
        }
    }

    private void clickedThirdGym() {
        if (region == RouteStateModel.KANTO && gsm.getPlayer().getKantoBadges() == 2) {
            TrainerFactory ttf = new TrainerFactory();
            loadGymLeader(ttf.getGymLeaderLtSurge());
        } else if (region == RouteStateModel.JOHTO && gsm.getPlayer().getJohtoBadges() == 2) {
            TrainerFactory ttf = new TrainerFactory();
            loadGymLeader(ttf.getGymLeaderWhitney());
        }
    }

    private void clickedFourthGym() {
        if (region == RouteStateModel.KANTO && gsm.getPlayer().getKantoBadges() == 3) {
            TrainerFactory ttf = new TrainerFactory();
            loadGymLeader(ttf.getGymLeaderErika());
        } else if (region == RouteStateModel.JOHTO && gsm.getPlayer().getJohtoBadges() == 3) {
            TrainerFactory ttf = new TrainerFactory();
            loadGymLeader(ttf.getGymLeaderMorty());
        }
    }

    private void clickedFifthGym() {
        if (region == RouteStateModel.KANTO && gsm.getPlayer().getKantoBadges() == 4) {
            TrainerFactory ttf = new TrainerFactory();
            loadGymLeader(ttf.getGymLeaderJanine());
        } else if (region == RouteStateModel.JOHTO && gsm.getPlayer().getJohtoBadges() == 4) {
            TrainerFactory ttf = new TrainerFactory();
            loadGymLeader(ttf.getGymLeaderChuck());
        }
    }

    private void clickedSixthGym() {
        if (region == RouteStateModel.KANTO && gsm.getPlayer().getKantoBadges() == 5) {
            TrainerFactory ttf = new TrainerFactory();
            loadGymLeader(ttf.getGymLeaderSabrina());
        } else if (region == RouteStateModel.JOHTO && gsm.getPlayer().getJohtoBadges() == 5) {
            TrainerFactory ttf = new TrainerFactory();
            loadGymLeader(ttf.getGymLeaderJasmine());
        }
    }

    private void clickedSeventhGym() {
        if (region == RouteStateModel.KANTO && gsm.getPlayer().getKantoBadges() == 6) {
            TrainerFactory ttf = new TrainerFactory();
            loadGymLeader(ttf.getGymLeaderBlaine());
        } else if (region == RouteStateModel.JOHTO && gsm.getPlayer().getJohtoBadges() == 6) {
            TrainerFactory ttf = new TrainerFactory();
            loadGymLeader(ttf.getGymLeaderPryce());
        }
    }

    private void clickedEightGym() {
        if (region == RouteStateModel.KANTO && gsm.getPlayer().getKantoBadges() == 7) {
            TrainerFactory ttf = new TrainerFactory();
            loadGymLeader(ttf.getGymLeaderBlue());
        } else if (region == RouteStateModel.JOHTO && gsm.getPlayer().getJohtoBadges() == 7) {
            TrainerFactory ttf = new TrainerFactory();
            loadGymLeader(ttf.getGymLeaderClair());
        }
    }

    private void loadGymLeader(Trainer leader) {
        gsm.stopBgm();
        Music wildBgm;
        if (region == RouteStateModel.KANTO) {
            wildBgm = Gdx.audio.newMusic(Gdx.files.internal("bgm/kantogym.mp3"));
        } else {
            wildBgm = Gdx.audio.newMusic(Gdx.files.internal("bgm/johtogym.mp3"));
        }
        wildBgm.setVolume(0.5f);
        wildBgm.play();
        gsm.setState(new BattleState(gsm, wildBgm, leader));
        dispose();
    }
    private void clickedPowerButton() {
        clickSound.play();
        gsm.setState(new SimulatorState(gsm, region, routeNumber));
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
