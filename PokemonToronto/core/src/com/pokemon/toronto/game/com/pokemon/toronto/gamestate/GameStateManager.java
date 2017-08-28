package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AssetLoader;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Ball.Ball;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Blastoise;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Bulbasaur;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Charizard;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Charmander;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Eevee;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pidgey;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pikachu;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Venusaur;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Weedle;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.WildPokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Arbok;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Beedrill;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Butterfree;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Diglett;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Ekans;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Fearow;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Gloom;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Golbat;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Kakuna;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Metapod;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Nidoking;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Nidoqueen;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Nidorina;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Nidorino;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Ninetales;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Oddish;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Paras;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Parasect;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Pidgeot;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Pidgeotto;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Raichu;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Sandshrew;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Sandslash;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Spearow;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Venomoth;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Venonat;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Vileplume;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Vulpix;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Zubat;
import com.pokemon.toronto.game.com.pokemon.toronto.bag.Bag;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokemonLookup;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokemonLookupPackage;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.WildPokemonCreator;
import com.pokemon.toronto.game.pokemonToronto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Gregory on 6/5/2017.
 */
public class GameStateManager {
    private GameState currentState;
    private pokemonToronto.MyGameCallBack gameCallBack;
    private double latitude;
    private double longitude;
    private boolean gotCoordinates;
    private AssetManager loader;
    private WildPokemonCreator wpc;
    private Sound notificationSound;
    private List<Pokemon> party;
    private List<Pokemon> box;
    private Bag bag;
    private int kantoBadges;
    private Music menubgm;

    private List<WildPokemon> nearbyPokemon;
    public GameStateManager() {
        //currentState = new IntroductionState(this);
       // currentState = new MainMenuState(this);
        latitude = 0;
        longitude = 0;
        gotCoordinates = true;
        loader = new AssetManager();
        loadData();
        menubgm = Gdx.audio.newMusic(Gdx.files.internal("bgm/menu.mp3"));
        wpc = new WildPokemonCreator();
        nearbyPokemon = new ArrayList<WildPokemon>();
        party = new ArrayList<Pokemon>();
        box = new ArrayList<Pokemon>();
        notificationSound = Gdx.audio.newSound(Gdx.files.internal("sounds/notification.wav"));
        bag = new Bag();
        bag.addPokeball(Ball.POKEBALL, 5);
        kantoBadges = 0;
        menubgm.setLooping(true);
        //menubgm.play();
    }

    public int getNumKantoBadges() {
        return kantoBadges;
    }

    public Bag getBag() {
        return bag;
    }
    public void setNotificationSound() {
        notificationSound = loader.get("sounds/notification.wav", Sound.class);
    }

    public void addToParty(Pokemon p) {
        if (party.size() < 6) {
            party.add(p);
        }
    }

    public void addToBox(Pokemon p) {
        if (box.size() < 30) {
            box.add(p);
        }
    }

    public boolean isBoxFull() {
        if (box.size() < 30) {
            return false;
        }
        return true;
    }

    public boolean isPartyFull() {
        if (party.size() < 6) {
            return false;
        }
        return true;
    }

    private void loadData() {
        loadTextures();
        loadSounds();
        loadMusic();
    }

    private void loadTextures() {
        /*
        loader.load("pokemonSprites/rattata/rattata.png", Texture.class);
        loader.load("pokemonSprites/pidgey/pidgey.png", Texture.class);
        loader.load("pokemonSprites/pikachu/pikachu.png", Texture.class);*/
    }

    private void loadSounds() {
        loader.load("sounds/click.wav", Sound.class);

        loader.load("sounds/notification.wav", Sound.class);
    }

    public List<Pokemon> getParty() {
        return party;
    }

    public List<Pokemon> getBox() { return box; }

    public void stopBgm() {
        menubgm.pause();
    }

    public void playBgm() {
        menubgm.play();
    }

    private void loadMusic() {

    }

    public void setInitialState() {
        currentState = new LoadingState(this, LoadingState.INTRODUCTION);
        //currentState = new LoadingState(this, LoadingState.POKENAV_MENU);
        addToParty(new Charmander(7));

        //getParty().get(0).setCurrentHealth(1);
        addToParty(new Weedle(5));
        getParty().get(0).setExp(70);
        //getParty().get(0).addEvs(new int[]{255,0,0,0,0,254});
        /*addToParty(new Charizard(5));
        addToParty(new Venusaur(5));
        addToParty(new Blastoise(5));
        addToParty(new Pikachu(5));*/
        //addToParty(new Charmander(5));
        addToBox(new Pidgeotto(5));
        addToBox(new Pidgeot(5));
        addToBox(new Ekans(5));
        addToBox(new Arbok(5));
        addToBox(new Sandshrew(5));
        addToBox(new Sandslash(5));
        addToBox(new Raichu(5));
        addToBox(new Nidorino(5));
        addToBox(new Nidorina(5));
        addToBox(new Nidoking(5));
        addToBox(new Nidoqueen(5));
        addToBox(new Vulpix(5));
        addToBox(new Ninetales(5));
        addToBox(new Zubat(5));
        addToBox(new Golbat(5));
        addToBox(new Diglett(5));
        addToBox(new Venomoth(5));
        addToBox(new Venonat(5));
        addToBox(new Paras(5));
        addToBox(new Parasect(30));
        addToBox(new Oddish(5));
        addToBox(new Gloom(5));
        addToBox(new Vileplume(5));
        addToBox(new Beedrill(5));
        addToBox(new Kakuna(5));
        addToBox(new Metapod(5));
        addToBox(new Butterfree(5));
        addToBox(new Spearow(5));
        addToBox(new Fearow(5));
        //addToBox(new Pikachu(5));
    }

    public void setGameCallBack(pokemonToronto.MyGameCallBack gameCallBack) {
        this.gameCallBack = gameCallBack;
    }

    public pokemonToronto.MyGameCallBack getGameCallBack() {
        return gameCallBack;
    }

    public void addNewWildPokemon(double longitude, double latitude, String country,
                                  String state, String city) {
            PokemonLookup pl = new PokemonLookup(city, state, country, latitude, longitude, 5);
            List<PokemonLookupPackage> plp = pl.getPokemon();
            if (plp != null) {

                for (int i = 0; i < plp.size(); i++) {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                    Date date = new Date();
                    String text = dateFormat.format(date);

                    nearbyPokemon.add(wpc.createPokemon(plp.get(i).getPokemonId(), plp.get(i).getLatitude(),
                            plp.get(i).getLongitude(), date, text));


                }
                notificationSound.play();
                Gdx.app.log("Expiration: ", nearbyPokemon.get(0).getExpirationString());
            } else {
                Gdx.app.log("PLP ERROR: ", "NULL");
                //getGameCallBack().spawnNewGamePokemon();
            }


    }

    public List<WildPokemon> getNearbyPokemon() {
        return nearbyPokemon;
    }
    public AssetManager getLoader() {
        return loader;
    }

    public boolean gotCoordinates() {
        return gotCoordinates;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double lat) { this.latitude = lat; }

    public void setLongitude(double longitude) { this.longitude = longitude; }



    public void render(SpriteBatch batch) {
        currentState.render(batch);
    }

    public void update(double dt) {

        currentState.update(dt);
    }

    public void setState(GameState newState) {
        currentState = newState;
    }

    public void dispose() {
        loader.dispose();
        notificationSound.dispose();
        menubgm.dispose();
    }
}
