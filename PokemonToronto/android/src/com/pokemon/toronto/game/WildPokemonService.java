package com.pokemon.toronto.game;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Binder;
import android.util.Log;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class WildPokemonService extends Service {

    /**
     * Create the Service.
     */
    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * Start the service.
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Runnable r = new Runnable() {
            public void run() {
                while (true) {
                    try {
                        //10 minutes spawn a new set of Pokemon.
                        long futureTime = System.currentTimeMillis() + (60000 * 10);
                        while (System.currentTimeMillis() < futureTime) {
                            synchronized (this) {
                                try {
                                    wait(futureTime - System.currentTimeMillis());
                                } catch(Exception e) {}
                            }
                        }
                        //Send the receiver that it found new Pokemon.
                        Intent i = new Intent();
                        i.setAction("com.pokemon.toronto.game.sendWildPokemonBroadcast");
                        i.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                        sendBroadcast(i);

                    } catch (Exception e) { Log.i("ERROR 2:", e.getMessage()); }
                }
            }
        };
        //Start the runnable thread.
        Thread t = new Thread(r);
        t.start();
        return Service.START_STICKY;

    }

    /**
     * Destroy the service.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * Bind the service.
     * @param intent
     * @return
     */
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }


}
