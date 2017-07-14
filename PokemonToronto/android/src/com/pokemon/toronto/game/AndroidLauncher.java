package com.pokemon.toronto.game;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
//import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.pokemon.toronto.game.pokemonToronto;

import java.util.List;
import java.util.Locale;

public class AndroidLauncher extends AndroidApplication implements pokemonToronto.MyGameCallBack,
		GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener{
	private int uiOptions;
	private View decorView;
	private Intent i;
	private WildPokemonReceiver receiver;
	private pokemonToronto pToronto;
	private LocationManager locationManager;
	private LocationListener locationListener;
	private double latitude;
	private double longitude;

	private boolean mRequestingLocationUpdates = false;
	private LocationRequest mLocationRequest;
	private GoogleApiClient mGoogleApiClient;
	private Location mLastLocation;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
				| View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
		decorView = getWindow().getDecorView();
		decorView.setSystemUiVisibility(uiOptions);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		latitude = 0;
		longitude = 0;
			buildGoogleApiClient();
			mGoogleApiClient.connect();
		if (receiver == null) {
			Log.i("INITIATE", "RECEIVER");
			receiver = new WildPokemonReceiver();
			IntentFilter iFilter = new IntentFilter("com.pokemon.toronto.game.sendWildPokemonBroadcast");
			registerReceiver(receiver, iFilter);
		} else {
			Log.i("ERROR", "RECEIVER ALREADY REGISTERED");
		}
		i = new Intent(this, WildPokemonService.class);
		startService(i);
		config.a = 8;
		pToronto= new pokemonToronto();
		pToronto.setGameCallBack(this);
		initialize(pToronto, config);

		//Maybe create a service (binding service perhaps) here that checks the new pokemonToronto object if it reached
		//the main game -- after introduction state
		//if it has then keep checking for wild pokemon nearby.
		//when the parameters for finding a wild pokemon are met (random time wait has been reached), send the data (longitude and latitude and time (night/day)) to new pokemon toronto()
		//new pokemon toronto() then creates the pokemon by looking in an area dictionary and relays it to the gsm and the gsm will relay it to the current state
		//the current state will then handle the data depending on what is happening ("in a battle, pokecenter etc")
		//different kind of relays could be vibrating or playing a fanfare or both.
	}

	protected void createLocationRequest() {
		mLocationRequest = new LocationRequest();
		mLocationRequest.setInterval(10000);
		mLocationRequest.setFastestInterval(5000);
		mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
		//mLocationRequest.setSmallestDisplacement(10); // 10 m
		startLocationUpdates();
	}

	private void buildGoogleApiClient() {
		mGoogleApiClient = new GoogleApiClient.Builder(this)
		.addConnectionCallbacks(this)
		.addOnConnectionFailedListener(this)
		.addApi(LocationServices.API).build();
	}

	@Override
	public void onBackPressed() {

	}
	@Override
	protected void onStart() {
		super.onStart();
		if (mGoogleApiClient != null) {
			mGoogleApiClient.connect();
		}
	}
	@Override
	protected void onResume() {
		super.onResume();
		decorView.setSystemUiVisibility(uiOptions);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("onDestroy: ", "Android Launcher");
		stopService(i);
		unregisterReceiver(receiver);
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i("onRestart: ", "Android Launcher");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i("onStop: ", "Android Launcher");
	}

	@Override
	protected void onRestoreInstanceState(Bundle saved) {
		super.onRestoreInstanceState(saved);
		Log.i("onRestoreIS: ", "Android Launcher");
	}
	private void startLocationUpdates() {
		if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
			// TODO: Consider calling
			//    ActivityCompat#requestPermissions
			// here to request the missing permissions, and then overriding
			//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
			//                                          int[] grantResults)
			// to handle the case where the user grants the permission. See the documentation
			// for ActivityCompat#requestPermissions for more details.
			Log.i("GOOF", "ya dun goofd boy");
			return;
		}
		mGoogleApiClient.connect();
		LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
	}
	@Override
	public void startMapActivity(double[] pokemonLatitude, double[] pokemonLongitude, String[] pokemonIcon) {
		if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
			// TODO: Consider calling
			//    ActivityCompat#requestPermissions
			// here to request the missing permissions, and then overriding
			//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
			//                                          int[] grantResults)
			// to handle the case where the user grants the permission. See the documentation
			// for ActivityCompat#requestPermissions for more details.
			Log.i("GOOF", "ya dun goofd boy");
			return;
		}
		mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
		if (mLastLocation != null) {
			Intent openSecondActivity = new Intent("com.pokemon.toronto.game.MAPSACTIVITY");
			openSecondActivity.putExtra("latitude", mLastLocation.getLatitude());
			openSecondActivity.putExtra("longitude", mLastLocation.getLongitude());
			openSecondActivity.putExtra("pokemonLatitude", pokemonLatitude);
			openSecondActivity.putExtra("pokemonLongitude", pokemonLongitude);
			openSecondActivity.putExtra("pokemonIcon", pokemonIcon);
			startActivity(openSecondActivity);

		} else {
			Log.i("mLastLocation: ", "is null");
		}

	}

	@Override
	public void startPokemonMapActivity(double pokemonLatitude, double pokemonLongitude, String pokemonIcon, int distance) {
		if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
			// TODO: Consider calling
			//    ActivityCompat#requestPermissions
			// here to request the missing permissions, and then overriding
			//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
			//                                          int[] grantResults)
			// to handle the case where the user grants the permission. See the documentation
			// for ActivityCompat#requestPermissions for more details.
			Log.i("GOOF", "ya dun goofd boy");
			return;
		}
		mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
		if (mLastLocation != null) {
			Intent openPokemonMapActivity = new Intent("com.pokemon.toronto.game.POKEMONMAPACTIVITY");
			openPokemonMapActivity.putExtra("latitude", mLastLocation.getLatitude());
			openPokemonMapActivity.putExtra("longitude", mLastLocation.getLongitude());
			openPokemonMapActivity.putExtra("pokemonLatitude", pokemonLatitude);
			openPokemonMapActivity.putExtra("pokemonLongitude", pokemonLongitude);
			openPokemonMapActivity.putExtra("pokemonIcon", pokemonIcon);
			openPokemonMapActivity.putExtra("distance", distance);

			startActivity(openPokemonMapActivity);

		} else {
			Log.i("mLastLocation: ", "is null");
		}

	}

	@Override
	public void spawnNewGamePokemon() {
		Geocoder gc = new Geocoder(getContext(), Locale.getDefault());
		String country = "";
		String stateName = "";
		String cityName = "";
		try {
			List<Address> address = gc.getFromLocation(latitude, longitude, 1);
			country = address.get(0).getCountryName();
			stateName = address.get(0).getAdminArea();
			cityName = address.get(0).getAddressLine(1).substring(0,
					address.get(0).getAddressLine(1).indexOf(","));

		} catch (Exception e) { Log.i("WildRec Trycatch ", e.getMessage());}
		pToronto.wildPokemonNotification(latitude, longitude, country, stateName, cityName);
	}

	@Override
	public void startWildPokemonService() {

	}

	@Override
	public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

	}

	@Override
	public void onConnected(@Nullable Bundle bundle) {
		createLocationRequest();
	}

	@Override
	public void onConnectionSuspended(int i) {
		mGoogleApiClient.connect();
	}

	@Override
	public void onLocationChanged(Location location) {
		mLastLocation = location;
		latitude = mLastLocation.getLatitude();
		longitude = mLastLocation.getLongitude();
		try {
			if (pToronto.getGsm() != null) {
				pToronto.setLatitude(latitude);
				pToronto.setLongitude(longitude);
			}
		} catch (Exception e) { Log.i("ERROR", e.getMessage()); }
	}

	public class WildPokemonReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			Log.i("PIKA PIKA: ", "RUNNING");
			Geocoder gc = new Geocoder(getContext(), Locale.getDefault());
			String country = "";
			String stateName = "";
			String cityName = "";
			try {
				List<Address> address = gc.getFromLocation(latitude, longitude, 1);
				country = address.get(0).getCountryName();
				stateName = address.get(0).getAdminArea();
				cityName = address.get(0).getAddressLine(1).substring(0,
						address.get(0).getAddressLine(1).indexOf(","));

			} catch (Exception e) { Log.i("WildRec Trycatch ", e.getMessage());}
			pToronto.wildPokemonNotification(latitude, longitude, country, stateName, cityName);
		}

	}


}
