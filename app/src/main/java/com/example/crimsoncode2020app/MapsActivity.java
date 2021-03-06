package com.example.crimsoncode2020app;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;


import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;

public class MapsActivity extends FragmentActivity
{

    private FusedLocationProviderClient userLocation;
    MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        NavController navController = Navigation.findNavController(this, R.id.my_nav_host_fragment);
        NavigationView navView = findViewById(R.id.nav_view);
        NavigationUI.setupWithNavController(navView, navController);


        userLocation = LocationServices.getFusedLocationProviderClient(this);

        mapFragment = new MapFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.my_nav_host_fragment, mapFragment);
        transaction.commit();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        if (requestCode == MapFragment.MY_PERMISSIONS_REQUEST_LOCATION){
            mapFragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
        else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
/*
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnMapLongClickListener(this);
        mMap.setOnMarkerClickListener(this);
        // Add a marker in Sydney and move the camera
        LatLng spark = new LatLng(46.727396, -117.164676);
        mMap.addMarker(new MarkerOptions().position(spark).title("Marker in P-Town"));

        getLocationPermission();

        userLocation.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            return;
                        }

                        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(), location.getLongitude())));

                    }
                });



    }

    private void getLocationPermission() {

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationPermission = true;
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }


    @Override
    public void onMapLongClick(LatLng latLng) {
        mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title("You are here")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
    }

    public boolean onMarkerClick(Marker marker){

        return false;
    }
    */


}
