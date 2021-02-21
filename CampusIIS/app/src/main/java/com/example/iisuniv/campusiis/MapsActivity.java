package com.example.iisuniv.campusiis;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

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
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private GoogleMap mMap;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    LocationRequest mLocationRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission();
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        //Initialize Google Play Services
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
        }
        else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }
        LatLng entry = new LatLng(26.837743, 75.769951);
        mMap.addMarker(new MarkerOptions().position(entry)
                .title("Entry "));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(entry ));
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);


        LatLng blockA = new LatLng(26.837068, 75.770131);
        mMap.addMarker(new MarkerOptions().position(blockA)
                .title("BlockA"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(blockA));
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);

        LatLng reception = new LatLng(26.837360, 75.770073);
        mMap.addMarker(new MarkerOptions().position(reception)
                .title("Reception"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(reception));
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);

        LatLng cit = new LatLng(26.837023, 75.769992);
        mMap.addMarker(new MarkerOptions().position(cit)
                .title("CIT"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cit));
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);

        LatLng blockC = new LatLng(26.837146, 75.770430);
        mMap.addMarker(new MarkerOptions().position(blockC)
                .title("BlockC"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(blockC));
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);

        LatLng blockD = new LatLng(26.837286, 75.770628);
        mMap.addMarker(new MarkerOptions().position(blockD)
                .title("BlockD"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(blockD));
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);

        LatLng blockE = new LatLng(26.837716, 75.770433);
        mMap.addMarker(new MarkerOptions().position(blockE)
                .title("BlockE"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(blockE));
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);

        LatLng blockF = new LatLng(26.837282, 75.770853);
        mMap.addMarker(new MarkerOptions().position(blockF)
                .title("BlockF"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(blockF));
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);

        LatLng canteen = new LatLng(26.837365, 75.770971);
        mMap.addMarker(new MarkerOptions().position(canteen)
                .title("Canteen"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(canteen));
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);

        LatLng lawn = new LatLng(26.837626, 75.770807);
        mMap.addMarker(new MarkerOptions().position(lawn)
                .title("Lawn"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lawn));
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);

        LatLng aanchal = new LatLng(26.838000, 75.771060);
        mMap.addMarker(new MarkerOptions().position(aanchal)
                .title("Aanchal"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(aanchal));
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);

        LatLng saanchal = new LatLng(26.837916, 75.771041);
        mMap.addMarker(new MarkerOptions().position(saanchal)
                .title("Saraswati Aanchal"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(saanchal));
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);

        LatLng gym = new LatLng(26.837758, 75.771092);
        mMap.addMarker(new MarkerOptions().position(gym)
                .title("Gym"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(gym));
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);

        LatLng express = new LatLng(26.838000, 75.770904);
        mMap.addMarker(new MarkerOptions().position(express)
                .title("Express Cafe"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(express));
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);

        LatLng adityahall = new LatLng(26.837976, 75.770767);
        mMap.addMarker(new MarkerOptions().position(adityahall)
                .title("Aditya Hall"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(adityahall));
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);

        LatLng ojashall = new LatLng(26.837913, 75.770607);
        mMap.addMarker(new MarkerOptions().position(ojashall)
                .title("Ojas Hall"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ojashall));
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);


        LatLng amul = new LatLng(26.837712, 75.770182);
        mMap.addMarker(new MarkerOptions().position(amul)
                .title("Amul Canteen"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(amul));
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);

        LatLng visitor = new LatLng(26.837626, 75.769863);
        mMap.addMarker(new MarkerOptions().position(visitor)
                .title("Visitor Room"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(visitor));
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);

        LatLng gate1 = new LatLng(26.837595, 75.770126);
        mMap.addMarker(new MarkerOptions().position(gate1)
                .title("MainBlock Gate1"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(gate1));
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);

        LatLng stage = new LatLng(26.837547, 75.770470);
        mMap.addMarker(new MarkerOptions().position(stage)
                .title("Stage"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(stage));
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);


        LatLng gate2 = new LatLng(26.837248, 75.7701880);
        mMap.addMarker(new MarkerOptions().position(gate2)
                .title("MainBlock Gate2"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(gate2));
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onLocationChanged(Location location) {

        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }

        //Place current location marker
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Your Position");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        mCurrLocationMarker = mMap.addMarker(markerOptions);

        //move map camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11));

        //stop location updates
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    public boolean checkLocationPermission(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted. Do the
                    // contacts-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }

                } else {

                    // Permission denied, Disable the functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }

            // other 'case' lines to check for other permissions this app might request.
            // You can add here other case statements according to your requirement.
        }
    }
}