package com.pokemon.toronto.game.com.pokemon.toronto.database;

import com.badlogic.gdx.Gdx;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.box.BoxLocation;
import com.pokemon.toronto.game.com.pokemon.toronto.box.PokemonBox;
import com.pokemon.toronto.game.com.pokemon.toronto.net.JSONParser;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-05-09.
 */

public class DatabaseUpdater {
    public static void saveParty(int uid, List<Pokemon> party) {
        JSONParser jp = new JSONParser();
        List<NameValuePair> paramsDelete = new ArrayList<NameValuePair>();

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
            params.add(new BasicNameValuePair("ability", Integer.toString(party.get(i).getAbilityPosition())));
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

    public static void updateBoxes(int uid, PokemonBox pc, List<BoxLocation> updateLocations) {
        JSONParser jp = new JSONParser();

        for (int i = 0; i < updateLocations.size(); i++) {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            Pokemon updatingPokemon = pc.getBox(updateLocations.get(i).getBoxNumber())
                    .get(updateLocations.get(i).getBoxPosition()).getPokemon();
            params.add(new BasicNameValuePair("uid", String.valueOf(uid)));
            params.add(new BasicNameValuePair("pid", Integer.toString(updatingPokemon.getId())));
            params.add(new BasicNameValuePair("level", Integer.toString(updatingPokemon.getLevel())));
            params.add(new BasicNameValuePair("health", Integer.toString(updatingPokemon.getCurrentHealth())));
            params.add(new BasicNameValuePair("currentExp", Integer.toString((int)updatingPokemon.getDisplayedExp())));
            params.add(new BasicNameValuePair("nature", Integer.toString(updatingPokemon.getNature().getValue())));
            params.add(new BasicNameValuePair("ability", Integer.toString(updatingPokemon.getAbilityPosition())));
            params.add(new BasicNameValuePair("boxNumber", Integer.toString(updateLocations.get(i).getBoxNumber())));
            params.add(new BasicNameValuePair("boxPosition", Integer.toString(updateLocations.get(i).getBoxPosition())));
            params.add(new BasicNameValuePair("pokemonGender", String.valueOf(updatingPokemon.getGender())));
            params.add(new BasicNameValuePair("status", Integer.toString(updatingPokemon.getStatus().getValue()))); //0 is status free
            params.add(new BasicNameValuePair("iv_hp", Integer.toString(updatingPokemon.getHealthIV())));
            params.add(new BasicNameValuePair("iv_atk", Integer.toString(updatingPokemon.getAttackIV())));
            params.add(new BasicNameValuePair("iv_def", Integer.toString(updatingPokemon.getDefenseIV())));
            params.add(new BasicNameValuePair("iv_spatk", Integer.toString(updatingPokemon.getSpAttackIV())));
            params.add(new BasicNameValuePair("iv_spdef", Integer.toString(updatingPokemon.getSpDefenseIV())));
            params.add(new BasicNameValuePair("iv_spd", Integer.toString(updatingPokemon.getSpeedIV())));
            params.add(new BasicNameValuePair("ev_hp", Integer.toString(updatingPokemon.getHealthEV())));
            params.add(new BasicNameValuePair("ev_atk", Integer.toString(updatingPokemon.getAttackEV())));
            params.add(new BasicNameValuePair("ev_def", Integer.toString(updatingPokemon.getDefenseEV())));
            params.add(new BasicNameValuePair("ev_spatk", Integer.toString(updatingPokemon.getSpAttackEV())));
            params.add(new BasicNameValuePair("ev_spdef", Integer.toString(updatingPokemon.getSpDefenseEV())));
            params.add(new BasicNameValuePair("ev_spd", Integer.toString(updatingPokemon.getSpeedEV())));
            params.add(new BasicNameValuePair("skill1_id", Integer.toString(updatingPokemon.getSkills().get(0).getId())));
            params.add(new BasicNameValuePair("skill1_pp", Integer.toString(updatingPokemon.getSkills().get(0).getCurrentPP())));
            if (updatingPokemon.getSkills().size() > 1) {
                params.add(new BasicNameValuePair("skill2_id", Integer.toString(updatingPokemon.getSkills().get(1).getId())));
                params.add(new BasicNameValuePair("skill2_pp", Integer.toString(updatingPokemon.getSkills().get(1).getCurrentPP())));
                if (updatingPokemon.getSkills().size() > 2) {
                    params.add(new BasicNameValuePair("skill3_id", Integer.toString(updatingPokemon.getSkills().get(2).getId())));
                    params.add(new BasicNameValuePair("skill3_pp", Integer.toString(updatingPokemon.getSkills().get(2).getCurrentPP())));
                    if (updatingPokemon.getSkills().size() > 3) {
                        params.add(new BasicNameValuePair("skill4_id", Integer.toString(updatingPokemon.getSkills().get(3).getId())));
                        params.add(new BasicNameValuePair("skill4_pp", Integer.toString(updatingPokemon.getSkills().get(3).getCurrentPP())));
                    }
                }
            }
            JSONObject obj = jp.makeHttpRequest("http://kelsiegr.com/pokemononline/updateBoxPokemon.php", "POST", params);
            try {
                Gdx.app.log("updateBoxes", obj.getString("message"));
            } catch (JSONException e) {
                Gdx.app.log("updateBoxes", "Catch: " + e.getMessage());
            }
        }
    }

    /**
     * Delete entries from the Box db based on the deleteLocations
     * @param deleteLocations A list of BoxLocations of spots to delete from the db
     */
    public static void deleteBoxes(int uid, List<BoxLocation> deleteLocations) {
        JSONParser jp = new JSONParser();
        for (int i = 0; i < deleteLocations.size(); i++) {
            List<NameValuePair> paramsDelete = new ArrayList<NameValuePair>();
            paramsDelete.add(new BasicNameValuePair("uid", String.valueOf(uid)));
            paramsDelete.add(new BasicNameValuePair("boxNumber", String.valueOf(deleteLocations.get(i).getBoxNumber())));
            paramsDelete.add(new BasicNameValuePair("boxPosition", String.valueOf(deleteLocations.get(i).getBoxPosition())));
            JSONObject obj = jp.makeHttpRequest("http://kelsiegr.com/pokemononline/deleteBoxPokemon.php", "POST", paramsDelete);
            try {
                Gdx.app.log("deleteBoxes", obj.getString("message"));
            } catch (Exception e){
                Gdx.app.log("deleteBoxes", "Catch: " + e.getMessage());
            }
        }
    }

    public static void updateBadges(int uid, int kantoBadges) {
        JSONParser jp = new JSONParser();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("uid", String.valueOf(uid)));
        params.add(new BasicNameValuePair("kanto_badges", String.valueOf(kantoBadges)));
        JSONObject obj = jp.makeHttpRequest("http://kelsiegr.com/pokemononline/updateBadges.php", "POST", params);
        try {
            Gdx.app.log("updateBadges", obj.getString("message"));
        } catch (JSONException e) {
            Gdx.app.log("updateBadges", e.getMessage());
        }
    }

    public static void updateJohtoBadges(int uid, int johtoBadges) {
        JSONParser jp = new JSONParser();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("uid", String.valueOf(uid)));
        params.add(new BasicNameValuePair("johto_badges", String.valueOf(johtoBadges)));
        JSONObject obj = jp.makeHttpRequest("http://kelsiegr.com/pokemononline/updateJohtoBadges.php", "POST", params);
        try {
            Gdx.app.log("updateJohtoBadges", obj.getString("message"));
        } catch (JSONException e) {
            Gdx.app.log("updateJohtoBadges", e.getMessage());
        }
    }
}
