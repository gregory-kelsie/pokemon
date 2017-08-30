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
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
//Places

import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.PlaceDetectionClient;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceLikelihood;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.PlaceLikelihoodBufferResponse;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.PlaceDetectionApi;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.pokemon.toronto.game.pokemonToronto;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

public class AndroidLauncher extends AndroidApplication implements pokemonToronto.MyGameCallBack,
		GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener{

	/** Instance Variables */

	//Android variables & LibGDX Application variable
	private int uiOptions;
	private View decorView;
	private Intent i;
	private WildPokemonReceiver receiver;
	private pokemonToronto pToronto;

	//GPS and Google API Variables
	private LocationManager locationManager;
	private LocationListener locationListener;
	private boolean mRequestingLocationUpdates = false;
	private LocationRequest mLocationRequest;
	private GoogleApiClient mGoogleApiClient;
	private Location mLastLocation;

	//The Player's coordinates
	private double latitude;
	private double longitude;

	//Google Places
	private GeoDataClient mGeoDataClient;
	private PlaceDetectionClient pdc;

	private String name;

	private double[] pokemonLatitude;
	private double[] pokemonLongitude;
	private String[] pokemonIcon;

	private double pokemonLatitude2;
	private double pokemonLongitude2;
	private String pokemonIcon2;
	private int distance2;

	/**
	 * Called when starting up the application.
	 * Initialize the views, default coordinates for the user,
	 * Google API, Wild Pokemon Receiver and LibGDX application.
	 * @param savedInstanceState Previous state of the app, never used.
	 */
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
		initDefaultCoordinates();
		initGoogleApi();
		initReceiver();
		initLibgdxApplication();
	}

	/**
	 * Initialize the view for the application. Full screen & hidden
	 * navigation.
	 */
	private void initView() {
		uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
				| View.SYSTEM_UI_FLAG_FULLSCREEN |
				View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
		decorView = getWindow().getDecorView();
		decorView.setSystemUiVisibility(uiOptions);
	}

	/**
	 * Initialize the starting coordinate for the player.
	 * (Latitude and Longitude)
	 */
	private void initDefaultCoordinates() {
		latitude = 0;
		longitude = 0;
	}

	/**
	 * Initialize the Google API for Google Maps
	 */
	private void initGoogleApi() {
		mGoogleApiClient = new GoogleApiClient.Builder(this)
				.addConnectionCallbacks(this)
				.addOnConnectionFailedListener(this)
				.addApi(LocationServices.API).build();
		mGoogleApiClient.connect();
		initGooglePlaces();
	}

	private void initGooglePlaces() {
		mGeoDataClient = Places.getGeoDataClient(this, null);
		pdc = Places.getPlaceDetectionClient(this, null);
	}

	/**
	 * Initialize the Wild Pokemon Receiver that will listen
	 * for new Pokemon broadcasts. As well as the broadcaster.
	 */
	private void initReceiver() {
		//Make sure there is only one receiver.
		if (receiver == null) {
			Log.i("INITIATE", "RECEIVER");
			receiver = new WildPokemonReceiver();
			IntentFilter iFilter = new IntentFilter("com.pokemon.toronto.game.sendWildPokemonBroadcast");
			registerReceiver(receiver, iFilter);
		} else {
			Log.i("ERROR", "RECEIVER ALREADY REGISTERED");
		}
		//TODO: Should make sure there is only one broadcaster as well.
		i = new Intent(this, WildPokemonService.class);
		startService(i);
	}

	/**
	 * Set LibGDX configurations, set give the application a callback to
	 * the AndroidLauncher and start the app.
	 */
	private void initLibgdxApplication() {
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		//Set the number of bits per colour channel.
		//https://libgdx.badlogicgames.com/nightlies/docs/api/com/
		//badlogic/gdx/backends/android/AndroidApplicationConfiguration.html
		config.a = 8;
		pToronto = new pokemonToronto();
		pToronto.setGameCallBack(this);
		initialize(pToronto, config);
	}

	/**
	 * Sets up the location request from the Google Service API.
	 */
	protected void createLocationRequest() {
		mLocationRequest = new LocationRequest();
		mLocationRequest.setInterval(10000);
		mLocationRequest.setFastestInterval(5000);
		mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
		//mLocationRequest.setSmallestDisplacement(10); // 10 m
		startLocationUpdates();
	}

	/**
	 * Override the Back button so it does not close the app when
	 * pressed.
	 */
	@Override
	public void onBackPressed() {
		initView();
	}

	/**
	 * Reconnect the Google Service API if necessary, on startup.
	 */
	@Override
	protected void onStart() {
		super.onStart();
		if (mGoogleApiClient != null) {
			mGoogleApiClient.connect();
		}
	}

	/**
	 * onResume, set the view again.
	 */
	@Override
	protected void onResume() {
		super.onResume();
		decorView.setSystemUiVisibility(uiOptions);
	}

	/**
	 * onDestroy, stop the broadcaster and unregister the receiver.
	 */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i("onDestroy: ", "Android Launcher");
		stopService(i);
		unregisterReceiver(receiver);
	}

	/**
	 * onRestart for the Android lifecycle
	 */
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i("onRestart: ", "Android Launcher");
	}

	/**
	 * onStop for the Android lifecycle.
	 */
	@Override
	protected void onStop() {
		super.onStop();
		Log.i("onStop: ", "Android Launcher");
	}

	/**
	 * onRestore, for the android lifecycle.
	 * @param saved
	 */
	@Override
	protected void onRestoreInstanceState(Bundle saved) {
		super.onRestoreInstanceState(saved);
		Log.i("onRestoreIS: ", "Android Launcher");
	}


	/**
	 * Set the Google Service to start receiving location updates.
	 */
	private void startLocationUpdates() {
		if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
			// TODO: Consider calling
			//    ActivityCompat#requestPermissions
			// here to request the missing permissions, and then overriding
			//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
			//                                          int[] grantResults)
			// to handle the case where the user grants the permission. See the documentation
			// for ActivityCompat#requestPermissions for more details.
			return;
		}
		mGoogleApiClient.connect();
		LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest,
				this); //this is a LocationListener
	}


	@Override
	public void onRequestPermissionsResult(int requestCode,
										   String permissions[], int[] grantResults) {
		switch (requestCode) {
			case 1: {
				// If request is cancelled, the result arrays are empty.
				if (grantResults.length > 0
						&& grantResults[0] == PackageManager.PERMISSION_GRANTED) {

					// permission was granted, yay! Do the
					// contacts-related task you need to do.
					startMapActivity(pokemonLatitude, pokemonLongitude, pokemonIcon);

				} else {
					//permission denied.
				}
				return;
			}
			case 2: {
				// If request is cancelled, the result arrays are empty.
				if (grantResults.length > 0
						&& grantResults[0] == PackageManager.PERMISSION_GRANTED) {

					// permission was granted, yay! Do the
					// contacts-related task you need to do.
					this.startPokemonMapActivity(pokemonLatitude2, pokemonLongitude2, pokemonIcon2, distance2);

				} else {
					//permission denied.
				}
				return;
			}
		}
	}

	/**
	 * Start up the MapsActivity where it displays the player and all of the Wild Pokemon
	 * that the user has been notified of.
	 * @param pokemonLatitude An array of Pokemon latitudes
	 * @param pokemonLongitude An array of Pokemon longitudes
	 * @param pokemonIcon A String array of Pokemon icon paths.
	 */
	@Override
	public void startMapActivity(double[] pokemonLatitude, double[] pokemonLongitude,
								 String[] pokemonIcon) {
		if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
				PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
						this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
				PackageManager.PERMISSION_GRANTED) {
			// TODO: Consider calling
			//    ActivityCompat#requestPermissions
			// here to request the missing permissions, and then overriding
			//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
			//                                          int[] grantResults)
			// to handle the case where the user grants the permission. See the documentation
			// for ActivityCompat#requestPermissions for more details.
			ActivityCompat.requestPermissions(this,
					new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
					1);
			this.pokemonLatitude = pokemonLatitude;
			this.pokemonLongitude = pokemonLongitude;
			this.pokemonIcon = pokemonIcon;
			Log.i("MapState", "Permission required");
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

	/**
	 * Start up the PokemonMapActivity which displays the Player and an individual
	 * Pokemon on the Google Maps.
	 * @param pokemonLatitude The Pokemon's latitude coordinate.
	 * @param pokemonLongitude The Pokemon's longitude coordinate.
	 * @param pokemonIcon The Pokemon's icon path.
	 * @param distance The distance between the player and the Pokemon in metres
	 */
	@Override
	public void startPokemonMapActivity(double pokemonLatitude, double pokemonLongitude,
										String pokemonIcon, int distance) {
		if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
				PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
						this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
				PackageManager.PERMISSION_GRANTED) {
			// TODO: Consider calling
			//    ActivityCompat#requestPermissions
			// here to request the missing permissions, and then overriding
			//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
			//                                          int[] grantResults)
			// to handle the case where the user grants the permission. See the documentation
			// for ActivityCompat#requestPermissions for more details.
			ActivityCompat.requestPermissions(this,
					new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
					1);
			this.pokemonLatitude2 = pokemonLatitude;
			this.pokemonLongitude2 = pokemonLongitude;
			this.pokemonIcon2 = pokemonIcon;
			this.distance2 = distance;
			Log.i("PokemonMapActivity", "Permission required");
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

	/**
	 * Set your new latitude and longitude coordinate if the GPS, not the
	 * Google Service, detects a change in your location.
	 * @param location Your new location.
	 */
	@Override
	public void onLocationChanged(Location location) {
		mLastLocation = location;
		latitude = mLastLocation.getLatitude();
		longitude = mLastLocation.getLongitude();
		try {
			//Make sure the pokemonToronto's game state manager
			//exists before updating the player's coordinates.
			if (pToronto.getGsm() != null) {
				pToronto.setLatitude(latitude);
				pToronto.setLongitude(longitude);
			}
		} catch (Exception e) {
			Log.i("Location", "Location Change Error: " + e.getMessage());
		}
	}

	/**
	 * Allows the pokemonToronto class to grab your location so that
	 * it can create new Pokemon around you.
	 */
	@Override
	public void spawnNewGamePokemon() {
		Geocoder gc = new Geocoder(getContext(), Locale.getDefault());
		String country = "";
		String stateName = "";
		String cityName = "";

		try {
			List<Address> address = gc.getFromLocation(latitude, longitude, 3);
			Log.i("Geocoder", "Addresses: " + address.size());


			for (int i = 0; i < address.size(); i++) {
				if (address.get(i) != null) {
					Log.i("Geocoder", "zz-------------------------------------------------------");
					for (int j = 0; i < address.get(i).getMaxAddressLineIndex(); j++) {
						Log.i("Geocoder", "Addresses Line: " + address.get(i).getAddressLine(j));
					}
					Log.i("Geocoder", "Feature (" + i + "):" + address.get(i).getFeatureName());
					Log.i("Geocoder", "Premises: " + address.get(i).getPremises());
					Log.i("Geocoder", "Sub-Admin Area: " + address.get(i).getSubAdminArea());
					Log.i("Geocoder", "Locality: " + address.get(i).getLocality());
					Log.i("Geocoder", "Sub-Locality: " + address.get(i).getSubLocality());
					Log.i("Geocoder", "SubthoroughFare: " + address.get(i).getSubThoroughfare());
					Log.i("Geocoder", "ThoroughFare: " + address.get(i).getThoroughfare());
					Log.i("Geocoder", "Address: " + address.get(i).getAddressLine(1));
				}
			}

			if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
				Log.e("not granted", "Permission is not granted");

				ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
				return;
			}

			Task<PlaceLikelihoodBufferResponse> placeResult = pdc.getCurrentPlace(null);

			placeResult.addOnCompleteListener(new OnCompleteListener<PlaceLikelihoodBufferResponse>() {
				@Override
				public void onComplete(@NonNull Task<PlaceLikelihoodBufferResponse> task) {
					PlaceLikelihoodBufferResponse likelyPlaces = task.getResult();
					for (PlaceLikelihood placeLikelihood : likelyPlaces) {
						name = placeLikelihood.getPlace().getName().toString();
						Log.i("osgh", String.format("Place '%s' has likelihood: %g",
								placeLikelihood.getPlace().getName(),
								placeLikelihood.getLikelihood()));
					}
					likelyPlaces.release();
				}
			});

			country = address.get(0).getCountryName();
			stateName = address.get(0).getAdminArea();
			cityName = address.get(0).getAddressLine(1).substring(0,
					address.get(0).getAddressLine(1).indexOf(","));

		} catch (Exception e) { Log.i("WildRec Trycatch ", e.getMessage());}
		try {
			Log.i("Geocoder", cityName);
		} catch (Exception e) { Log.i("Geocoder", e.getMessage());}
		Log.i("Geocoder", "messed up baby");
		pToronto.wildPokemonNotification(latitude, longitude, country, stateName, cityName);
	}

	/**
	 * Failed to connect the app to the Google Service.
	 * @param connectionResult
	 */
	@Override
	public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
		Log.i("GoogleService", "Failed to connect.");
	}

	/**
	 * Successfully connected the app to the Google Service.
	 * @param bundle
	 */
	@Override
	public void onConnected(@Nullable Bundle bundle) {
		createLocationRequest();
	}

	/**
	 * Called when the app disconnects from the Google Service.
	 * @param i The cause of the suspension.
	 */
	@Override
	public void onConnectionSuspended(int i) {
		Log.i("GoogleService", "Suspended Connection: " + i);
		mGoogleApiClient.connect(); //Reconnect
	}

	/**
	 * An embedded class for the WildPokemonReceiver
	 */
	public class WildPokemonReceiver extends BroadcastReceiver {

		/**
		 * Tell the pokemonToronto class where the new Pokemon is going to be located
		 * around. Gives city, state and country so it determines which kind of pokemon
		 * show up.
		 * @param context
		 * @param intent
		 */
		@Override
		public void onReceive(Context context, Intent intent) {
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

			} catch (Exception e) { Log.i("WildReceiver", e.getMessage());}
			pToronto.wildPokemonNotification(latitude, longitude, country, stateName, cityName);
		}

	}


}
