package com.pokemon.toronto.game;

/**
 * Created by Gregory on 6/14/2017.
 */

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.io.InputStream;


import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.io.InputStream;

public class PokemonMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private double latitude;
    private double longitude;
    private double pokemonLatitude;
    private double pokemonLongitude;
    private String pokemonIcon;
    private int distance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        latitude =  i.getDoubleExtra("latitude", 0);
        longitude = i.getDoubleExtra("longitude", 0);
        pokemonLatitude = i.getDoubleExtra("pokemonLatitude", 0);
        pokemonLongitude = i.getDoubleExtra("pokemonLongitude", 0);
        pokemonIcon = i.getStringExtra("pokemonIcon");
        distance = i.getIntExtra("distance", -1);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.clear();
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Lat: " + latitude + ", Lon: " + longitude)
                .icon(BitmapDescriptorFactory.fromBitmap(
                        resizeBitmap("maletrainer.png", 78, 100))));
            mMap.addMarker(new MarkerOptions().position(new LatLng(pokemonLatitude, pokemonLongitude))
                    .title("Distance: " + distance + "m")
                    .icon(BitmapDescriptorFactory.fromBitmap(
                            resizeBitmap(pokemonIcon, 200, 200))));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 14.0f));
    }

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
        return resizedBitmap;
    }
}
