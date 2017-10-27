package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Ball.Ball;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Weedle;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.WildPokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Arbok;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Diglett;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Ekans;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Gloom;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Golbat;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Nidoking;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Nidoqueen;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Nidorina;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Nidorino;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Ninetales;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Parasect;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Pidgeot;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Pidgeotto;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Raichu;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Sandshrew;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Sandslash;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Venomoth;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Vulpix;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.one_to_fifty.Zubat;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Machamp;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Magnemite;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_2.Magneton;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Aerodactyl;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Dragonite;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Exeggutor;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Kabutops;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.MrMime;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.kanto.part_3.Scyther;
import com.pokemon.toronto.game.com.pokemon.toronto.bag.Bag;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokemonLookup;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokemonLookupPackage;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.WildPokemonCreator;
import com.pokemon.toronto.game.com.pokemon.toronto.net.JSONParser;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.WildTrainer;
import com.pokemon.toronto.game.pokemonToronto;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

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

    private boolean loggedIn;
    private Player player;
    private List<WildPokemon> nearbyPokemon;
    private List<WildTrainer> nearbyTrainers;
    public GameStateManager() {
        latitude = 0;
        longitude = 0;
        gotCoordinates = true;
        loader = new AssetManager();
        loadData();
        menubgm = Gdx.audio.newMusic(Gdx.files.internal("bgm/menu.mp3"));
        wpc = new WildPokemonCreator();
        nearbyPokemon = new ArrayList<WildPokemon>();
        nearbyTrainers = new ArrayList<WildTrainer>();
        party = new ArrayList<Pokemon>();
        box = new ArrayList<Pokemon>();
        notificationSound = Gdx.audio.newSound(Gdx.files.internal("sounds/notification.wav"));
        bag = new Bag();
        bag.addPokeball(Ball.POKEBALL, 5);
        kantoBadges = 0;
        menubgm.setLooping(true);
    }

    public void saveParty() {
        JSONParser jp = new JSONParser();
        List<NameValuePair> paramsDelete = new ArrayList<NameValuePair>();
        int uid = player.getId();

        int emptySlots = 6 - party.size();
        int currentEmptySlot = 5;
        while (emptySlots != 0) {
            paramsDelete.add(new BasicNameValuePair("uid", String.valueOf(uid)));
            paramsDelete.add(new BasicNameValuePair("partyPosition", String.valueOf(currentEmptySlot)));
            jp.makeHttpRequest("http://kelsiegr.com/pokemononline/deletePartyPokemon.php", "POST", paramsDelete);
            emptySlots--;
            currentEmptySlot--;
        }

        for (int i = 0; i < party.size(); i++) {
            Gdx.app.log("Update", "uid: " + uid + " partypos: " + i + "name: " + party.get(i).getName());
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("uid", String.valueOf(uid)));
            params.add(new BasicNameValuePair("pid", Integer.toString(party.get(i).getId())));
            params.add(new BasicNameValuePair("level", Integer.toString(party.get(i).getLevel())));
            params.add(new BasicNameValuePair("health", Integer.toString(party.get(i).getCurrentHealth())));
            params.add(new BasicNameValuePair("currentExp", Integer.toString((int)party.get(i).getDisplayedExp())));
            params.add(new BasicNameValuePair("nature", Integer.toString(party.get(i).getNature().getValue())));
            params.add(new BasicNameValuePair("ability", Integer.toString(party.get(i).getBattleAbility().getValue())));
            params.add(new BasicNameValuePair("partyPosition", Integer.toString(i))); //first slot in party
            params.add(new BasicNameValuePair("pokemonGender", String.valueOf(party.get(i).getGender())));
            params.add(new BasicNameValuePair("status", Integer.toString(party.get(i).getStatus().getValue()))); //0 is status free
            params.add(new BasicNameValuePair("iv_hp", Integer.toString(party.get(i).getHealthIV())));
            params.add(new BasicNameValuePair("iv_atk", Integer.toString(party.get(i).getAttackIV())));
            params.add(new BasicNameValuePair("iv_def", Integer.toString(party.get(i).getDefenseIV())));
            params.add(new BasicNameValuePair("iv_spatk", Integer.toString(party.get(i).getSpAttackIV())));
            params.add(new BasicNameValuePair("iv_spdef", Integer.toString(party.get(i).getSpDefenseIV())));
            params.add(new BasicNameValuePair("iv_spd", Integer.toString(party.get(i).getSpeedIV())));
            params.add(new BasicNameValuePair("ev_hp", Integer.toString(party.get(i).getHealthEV())));
            params.add(new BasicNameValuePair("ev_atk", Integer.toString(party.get(i).getAttackEV())));
            params.add(new BasicNameValuePair("ev_def", Integer.toString(party.get(i).getDefenseEV())));
            params.add(new BasicNameValuePair("ev_spatk", Integer.toString(party.get(i).getSpAttackEV())));
            params.add(new BasicNameValuePair("ev_spdef", Integer.toString(party.get(i).getSpDefenseEV())));
            params.add(new BasicNameValuePair("ev_spd", Integer.toString(party.get(i).getSpeedEV())));
            params.add(new BasicNameValuePair("skill1_id", Integer.toString(party.get(i).getSkills().get(0).getId())));
            params.add(new BasicNameValuePair("skill1_pp", Integer.toString(party.get(i).getSkills().get(0).getCurrentPP())));
            Gdx.app.log("Update", "skillsetsize: " + party.get(i).getSkills().size());
            if (party.get(i).getSkills().size() > 1) {
                params.add(new BasicNameValuePair("skill2_id", Integer.toString(party.get(i).getSkills().get(1).getId())));
                params.add(new BasicNameValuePair("skill2_pp", Integer.toString(party.get(i).getSkills().get(1).getCurrentPP())));
                if (party.get(i).getSkills().size() > 2) {
                    params.add(new BasicNameValuePair("skill3_id", Integer.toString(party.get(i).getSkills().get(2).getId())));
                    params.add(new BasicNameValuePair("skill3_pp", Integer.toString(party.get(i).getSkills().get(2).getCurrentPP())));
                    if (party.get(i).getSkills().size() > 3) {
                        params.add(new BasicNameValuePair("skill4_id", Integer.toString(party.get(i).getSkills().get(3).getId())));
                        params.add(new BasicNameValuePair("skill4_pp", Integer.toString(party.get(i).getSkills().get(3).getCurrentPP())));
                    }
                }
            }
            JSONObject obj = jp.makeHttpRequest("http://kelsiegr.com/pokemononline/updatePartyPokemon.php", "POST", params);
            Gdx.app.log("Update", "xyz");
            try {
                Gdx.app.log("Update", obj.getString("message"));
            } catch (JSONException e) {
                Gdx.app.log("Update", e.getMessage());
            }
        } // end for

    }
    public int getNumKantoBadges() {
        return kantoBadges;
    }

    public void setPlayer(Player p) {
        this.player = p;
    }

    public Player getPlayer() {
        return player;
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
        menubgm.stop();
    }

    public void playBgm() {
        Gdx.app.log("MAINBGM", "CALLED");
        menubgm.play();
    }

    private void loadMusic() {

    }

    public void setInitialState() {
        currentState = new LoginState(this);
        loggedIn = false;
        //currentState = new LoadingState(this, LoadingState.INTRODUCTION);
        //currentState = new LoadingState(this, LoadingState.POKENAV_MENU);
        /*addToParty(new Charmander(7));

        //getParty().get(0).setCurrentHealth(1);
        addToParty(new Weedle(5));
        getParty().get(0).setExp(70);*/
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
        addToBox(new Magnemite(5));
        addToBox(new Magneton(5));
        addToBox(new Parasect(3));
        addToBox(new Machamp(5));
        addToBox(new Gloom(5));
        addToBox(new MrMime(5));
        addToBox(new Exeggutor(5));
        Pokemon weedle = new Weedle(6);
        weedle.setExp(100);
        addToBox(weedle);
        addToBox(new Scyther(5));
        addToBox(new Aerodactyl(5));
        Pokemon dragonite = new Dragonite(100);
        dragonite.setCurrentHealth(1);
        addToBox(dragonite);
        addToBox(new Kabutops(5));
        //addToBox(new Pikachu(5));
    }

    public void setGameCallBack(pokemonToronto.MyGameCallBack gameCallBack) {
        this.gameCallBack = gameCallBack;
    }

    public pokemonToronto.MyGameCallBack getGameCallBack() {
        return gameCallBack;
    }

    public void logIn() {
        loggedIn = true;
    }

    public boolean isLoggedIn() {
        return loggedIn;
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

    public List<WildTrainer> getNearbyTrainers() { return nearbyTrainers; }
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

    public void drawStage() {
        currentState.drawStage();
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
