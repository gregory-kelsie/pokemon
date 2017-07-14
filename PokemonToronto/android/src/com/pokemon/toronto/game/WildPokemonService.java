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
    //private Sound notificationSound;

    @Override
    public void onCreate() {
        super.onCreate();
        //notificationSound = Gdx.audio.newSound(Gdx.files.internal("sounds/notification.wav"));
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Runnable r = new Runnable() {
            public void run() {
                while (true) {
                    try {
                        long futureTime = System.currentTimeMillis() + (60000 * 10); //10 minutes spawn
                        while (System.currentTimeMillis() < futureTime) {
                            synchronized (this) {
                                try {
                                    wait(futureTime - System.currentTimeMillis());
                                } catch(Exception e) {}
                            }
                        }
                        //Thread.sleep(60000 * 10);
                        //notificationSound.play();
                        Intent i = new Intent();
                        i.setAction("com.pokemon.toronto.game.sendWildPokemonBroadcast");
                        i.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                        sendBroadcast(i);

                    } catch (Exception e) { Log.i("ERROR 2:", e.getMessage()); }
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
        return Service.START_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


}
