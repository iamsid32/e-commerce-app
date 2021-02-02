package com.example.e_commerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ActionBar;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LoginActivity extends AppCompatActivity {

    LocationManager locationManager;
    LocationListener locationListener;

    TextView adrressText;
    Toolbar toolbar;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){

                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar = findViewById(R.id.toolbar);
        adrressText = findViewById(R.id.addressText);

        locationCall();

    }

    private void locationCall() {

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                Log.i("LocationInfo",location.toString());

                Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

                try {
                    String address = "Coudn't Find";
                    List<Address> listAddresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                    if (listAddresses!=null && listAddresses.size()>0){

                        address = "";

                        Log.i("PlaceInfo",listAddresses.get(0).toString());
                        if (listAddresses.get(0).getAddressLine(0)!=null){
                            address+=listAddresses.get(0).getAddressLine(0);
                        }

                    }
                    adrressText.setText(address);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);

        }else{
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);
        }
    }
}