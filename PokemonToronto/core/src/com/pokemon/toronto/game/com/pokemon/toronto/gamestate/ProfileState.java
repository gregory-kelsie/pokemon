package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.TrainerFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 10/28/2017.
 */

public class ProfileState extends GameState {
    private GameStateManager gsm;
    private Texture card;
    private Texture background;
    private Texture trainer;
    private List<Texture> pokemonTeam;
    private List<Texture> badges;
    private int numBadges;


    public ProfileState(GameStateManager gsm) {
        this.gsm = gsm;
        gsm.forceLandscape();
        card = new Texture("trainercard/background/blue.png");
        background = new Texture("trainercard/background/bg.png");
        pokemonTeam = new ArrayList<Texture>();
        int count = 6;
        for (Pokemon partyMember: gsm.getParty()) {
            pokemonTeam.add(new Texture(partyMember.getProfileIcon()));
            count--;
        }
        for (int i = 0; i < count; i++) {
            pokemonTeam.add(new Texture("trainercard/pokemon/empty.png"));
        }
        if (gsm.getPlayer().getGender() == 'M' ||
                gsm.getPlayer().getGender() == 'm') {
            trainer = new Texture("trainers/small/defaultm.png");
        } else {
            trainer = new Texture("trainers/small/defaultf.png");
        }
        numBadges = gsm.getPlayer().getKantoBadges();
        initBadges();
    }

    private void initBadges() {
        badges = new ArrayList<Texture>();
        checkFirstGym();
    }

    private void checkFirstGym() {
        if (numBadges >= 1) {
            badges.add(new Texture("trainercard/badges/kanto/1.png"));
            checkSecondGym();
        }
    }

    private void checkSecondGym() {
        if (numBadges >= 2) {
            badges.add(new Texture("trainercard/badges/kanto/2.png"));
            checkThirdGym();
        }
    }

    private void checkThirdGym() {
        if (numBadges >= 3) {
            badges.add(new Texture("trainercard/badges/kanto/3.png"));
            checkFourthGym();
        }
    }

    private void checkFourthGym() {
        if (numBadges >= 4) {
            badges.add(new Texture("trainercard/badges/kanto/4.png"));
            checkFifthGym();
        }
    }

    private void checkFifthGym() {
        if (numBadges >= 5) {
            badges.add(new Texture("trainercard/badges/kanto/5.png"));
            checkSixthGym();
        }
    }

    private void checkSixthGym() {
        if (numBadges >= 6) {
            badges.add(new Texture("trainercard/badges/kanto/6.png"));
            checkSeventhGym();
        }
    }

    private void checkSeventhGym() {
        if (numBadges >= 7) {
            badges.add(new Texture("trainercard/badges/kanto/7.png"));
            checkEighthGym();
        }
    }

    private void checkEighthGym() {
        if (numBadges == 8) {
            badges.add(new Texture("trainercard/badges/kanto/8.png"));
        }
    }


    @Override
    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 0);
        batch.draw(card, 191, 44, 1541, 994);

        batch.draw(pokemonTeam.get(0), 228, 572, 265, 159);
        batch.draw(pokemonTeam.get(1), 520, 572, 265, 159);
        batch.draw(pokemonTeam.get(2), 812, 572, 265, 159);

        batch.draw(pokemonTeam.get(3), 228, 360, 265, 159);
        batch.draw(pokemonTeam.get(4), 520, 360, 265, 159);
        batch.draw(pokemonTeam.get(5), 812, 360, 265, 159);

        batch.draw(trainer, 1196, 280, 490, 490);

        for (int i = 0; i < badges.size(); i++) {
            batch.draw(badges.get(i), 446 + (i * 151), 115, 83, 83);
        }
    }

    @Override
    public void update(double dt) {
        if (MyInput.clicked()) {
            int x = MyInput.getX();
            int y = MyInput.getY();

            gsm.forcePortrait();
            gsm.setState(new LoadingState(gsm, LoadingState.HUB_STATE));
            dispose();
        }
    }
    @Override
    public void dispose() {
        card.dispose();
        background.dispose();
        for (Texture t: pokemonTeam) {
            t.dispose();
        }
        trainer.dispose();
        for (Texture t: badges) {
            t.dispose();
        }
    }
}
