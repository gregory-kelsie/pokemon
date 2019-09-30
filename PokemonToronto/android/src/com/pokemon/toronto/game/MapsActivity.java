package com.pokemon.toronto.game;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    //Instance Variables
    private GoogleMap mMap;
    private double latitude;
    private double longitude;
    private double[] pokemonLatitude;
    private double[] pokemonLongitude;
    private String[] pokemonIcon;
    private double[] trainerLatitude;
    private double[] trainerLongitude;
    private String[] trainerIcon;
    private int[] id;

    private Bitmap temp;
    private List<Marker> markers;
    private List<Bitmap> icons;
    private List<Bitmap> icons2;

    /**
     * Create a Google Map Activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        markers = new ArrayList<Marker>();
        //References to used bitmaps to dispose of them later.
        icons = new ArrayList<Bitmap>();
        icons2 = new ArrayList<Bitmap>();
        initReceivedData();
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Receive the Player and Pokemon information from the AndroidLauncher
     * Activity.
     */
    private void initReceivedData() {
        Intent i = getIntent();
        initPlayerLocation(i);
        initPokemon(i);
        initTrainers(i);
    }

    /**
     * Set the Player's location from the AndroidLauncher activity.
     * @param i The intent the AndroidLauncher activity passes to this
     *          Activity.
     */
    private void initPlayerLocation(Intent i) {
        latitude =  i.getDoubleExtra("latitude", 0);
        longitude = i.getDoubleExtra("longitude", 0);
    }

    /**
     * Set the Pokemon information arrays from the Android Launcher Activity.
     * @param i The intent the AndroidLauncher activity passes to this
     *          Activity.
     */
    private void initPokemon(Intent i) {
        pokemonLatitude = i.getDoubleArrayExtra("pokemonLatitude");
        pokemonLongitude = i.getDoubleArrayExtra("pokemonLongitude");
        pokemonIcon = i.getStringArrayExtra("pokemonIcon");
        id = i.getIntArrayExtra("id");
    }

    /**
     * Set the Trainer information arrays from the Android Launcher Activity.
     * @param i The intent the AndroidLauncher activity passes to this
     *          Activity.
     */
    private void initTrainers(Intent i) {
        trainerLatitude = i.getDoubleArrayExtra("trainerLatitude");
        trainerLongitude = i.getDoubleArrayExtra("trainerLongitude");
        trainerIcon = i.getStringArrayExtra("trainerIcon");
    }

    /**
     * onPause, from activity lifecycle.
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * Destroy this activity and return to the AndroidLauncher when the
     * back button is pressed.
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        for (Marker m: markers) {
            m.remove();
        }
        for (Bitmap b: icons) {
            b.recycle();
        }
        for (Bitmap b: icons2) {
            b.recycle();
        }
        markers.clear();
        finish();
    }

    /**
     * Go back to the game screen and start a battle with the selected pokemon.
     * @param marker The clicked marker.
     * @return
     */
    @Override
    public boolean onMarkerClick(Marker marker) {
        marker.showInfoWindow();
        Intent i = new Intent();
        i.putExtra("pokemonIndex", Integer.parseInt(marker.getTitle()));
        setResult(RESULT_OK, i);
        onBackPressed();
        return true;
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near the Player's position.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        //Initialize the Google map
        mMap = googleMap;
        mMap.clear();
        mMap.setOnMarkerClickListener(this);

        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = mMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.go));


            if (!success) {
                Log.e("onMapReady", "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("OnMapReady", "Can't find style. Error: ", e);
        }

        //Create a marker for the player's position
        LatLng playerPos = new LatLng(latitude, longitude);
        temp = resizeBitmap("maletrainer.png", 78, 100);

        markers.add(mMap.addMarker(new MarkerOptions().position(playerPos).title("Lat: " + latitude + ", Lon: " + longitude)
                .icon(BitmapDescriptorFactory.fromBitmap(
                temp))));

        //Create markers for each of the Wild Pokemon the player has been
        //notified of and hasn't ran into yet.
        for (int i = 0; i < pokemonLatitude.length; i++) {
            temp = resizeBitmap(pokemonIcon[i], 200, 200);
            Marker m;
            markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(
                    pokemonLatitude[i], pokemonLongitude[i]))
                    .title("" + id[i])
                    .icon(BitmapDescriptorFactory.fromBitmap(
                            temp))));
        }

        //Create markers for each of the nearby Trainers
        for (int i = 0; i < trainerLatitude.length; i++) {
            temp = resizeBitmap(trainerIcon[i], 200, 200);
            Marker m;
            markers.add(mMap.addMarker(new MarkerOptions().position(new LatLng(
                    trainerLatitude[i], trainerLongitude[i]))
                    .title("Trainer XYZ")
                    .snippet("Difficulty: 0.5")
                    .icon(BitmapDescriptorFactory.fromBitmap(
                            temp))));
        }

        //Move the camera to the player's position and zoom in.
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(playerPos, 16.0f));
    }

    /**
     * Return a resized Bitmap to the specified dimensions
     * @param location The path to the Bitmap that will get resized.
     * @param width The new width of the Bitmap.
     * @param height The new height of the Bitmap.
     * @return A resized Bitmap
     */
    private Bitmap resizeBitmap(String location, int width, int height) {
        AssetManager assetManager = getAssets();
        InputStream istr = null;
        try {
            istr = assetManager.open(location);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap initialImage = BitmapFactory.decodeStream(istr);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(initialImage, width, height, false);
        icons2.add(initialImage);
        icons.add(resizedBitmap);
        return resizedBitmap;
    }
}
