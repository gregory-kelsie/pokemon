package com.pokemon.toronto.game.com.pokemon.toronto.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.database.DatabaseUpdater;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokemonFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.gamestate.EliteFourSpeechState;
import com.pokemon.toronto.game.com.pokemon.toronto.gamestate.EvolutionState;
import com.pokemon.toronto.game.com.pokemon.toronto.gamestate.GameState;
import com.pokemon.toronto.game.com.pokemon.toronto.gamestate.GameStateManager;
import com.pokemon.toronto.game.com.pokemon.toronto.gamestate.LoadingInterface;
import com.pokemon.toronto.game.com.pokemon.toronto.gamestate.LoadingState;
import com.pokemon.toronto.game.com.pokemon.toronto.gamestate.SimulatorState;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-05-08.
 */

public class SaveThread implements Runnable {
    private int region;
    private Music victoryBgm;
    private LoadingInterface loadingInterface;
    private int currentPokemonPosition;
    private int battleType;
    private Trainer trainer;
    private int startingRoute;
    private boolean isRoute;
    private int uid;
    private int kantoBadges;
    private int johtoBadges;
    private List<Pokemon> party;
    private Player player;

    private boolean isFinished;

    private final int WILD_BATTLE = 0;
    public SaveThread(int uid, int kantoBadges, int johtoBadges, List<Pokemon> party, Player player, int region, Music victoryBgm,
                      LoadingInterface loadingInterface, int currentPokemonPosition,
                      int battleType, Trainer trainer, int startingRoute, boolean isRoute) {
        this.region = region;
        this.victoryBgm = victoryBgm;
        this.loadingInterface = loadingInterface;
        this.currentPokemonPosition = currentPokemonPosition;
        this.battleType = battleType;
        this.trainer = trainer;
        this.startingRoute = startingRoute;
        this.isRoute = isRoute;

        this.uid = uid;
        this.kantoBadges = kantoBadges;
        this.johtoBadges = johtoBadges;
        this.party = party;
        this.player = player;

        isFinished = false;
    }

    @Override
    public void run() {

        if (battleType != WILD_BATTLE && trainer.givesKantoBadge()) {
            player.addKantoBadge();
            DatabaseUpdater.updateBadges(uid, kantoBadges);
        } else if (battleType != WILD_BATTLE && trainer.givesJohtoBadge()) {
            player.addJohtoBadge();
            DatabaseUpdater.updateJohtoBadges(uid, johtoBadges);
        }
        if (battleType != WILD_BATTLE && trainer.isElite4Member()) {
            if (trainer.getBadgeType() == Trainer.Badge.KANTO_CHAMPION) {
                //Save party and exit.
                DatabaseUpdater.saveParty(uid, party);
            }
        } else {
            DatabaseUpdater.saveParty(uid, party);

        }
        victoryBgm.stop();
        isFinished = true;
        //loadingInterface.finishLoading();

    }

    public boolean isFinished() {
        return isFinished;
    }
}
