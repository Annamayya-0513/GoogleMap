package com.example.googlemap;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;


import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final int REQUEST_CODE = 101 ;
    GoogleMap map;
    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

//        fetchLocation();
        initialize();

    }

//    private void fetchLocation() {
//
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);
//            return;
//        }
//        Task<Location> task = fusedLocationProviderClient.getLastLocation();
//        task.addOnSuccessListener(new OnSuccessListener<Location>() {
//            @Override
//            public void onSuccess(Location location) {
//
//                if (location != null){
//                    Toast.makeText(MainActivity.this, currentLocation.getLatitude()+" "+ currentLocation.getLongitude(), Toast.LENGTH_SHORT).show();
//                    SupportMapFragment supportMapFragment =(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
//                    assert supportMapFragment != null;
//                    supportMapFragment.getMapAsync(MainActivity.this);
//                }
//
//
//            }
//        });
//    }

    private void initialize() {

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        supportMapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

//        LatLng latLng = new LatLng(currentLocation.getLatitude()  ,currentLocation.getLongitude());
//        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("aaaaaaaaaaa");
//        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
//        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,5));
//        googleMap.addMarker(markerOptions);



        map = googleMap;

        LatLng Mumbai = new LatLng(19.0760, 72.8777 );
        map.addMarker(new MarkerOptions().position(Mumbai).title("Mumbai"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Mumbai));

    }

//    public void onRequestPermissionResult(int requestCode, String [] permission , int[] grantResult){
//        switch (requestCode){
//            case REQUEST_CODE:
//                if (grantResult.length > 0 && grantResult[0] == PackageManager.PERMISSION_GRANTED){
//                    fetchLocation();
//        }
//
//        break;
//
//        }
//    }


}
