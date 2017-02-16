package com.example.haams.geomapactivity;

import android.*;
import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    final private int MY_PERMISSION_REQUEST_LOCATION = 100;
    private Button btnLoc;
    private EditText edtLoc;
    private GoogleApiClient mGoogleApiClient;
    private Location mCurrentLocation;
    private LocationListener mLocationListener;
    private boolean mRequestingLocationUpdates;
    Geocoder gc;
    double lat, lon;
    private String Location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initApiClient();
    }

    private void initViews() {
        edtLoc = (EditText) findViewById(R.id.edtLocation);
        findViewById(R.id.btnLoc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchLocation(edtLoc.getText().toString());
            }
        });
    }

    public void searchLocation(String searchStr) {
        List<Address> addressList = null;
        gc = new Geocoder(getApplicationContext(), Locale.KOREAN);
        try {
            addressList = gc.getFromLocationName(searchStr, 3);
            if (addressList != null) {
                Log.d("address", "주소입력되나여?");
                // contentsText.append("\nCount of Addresses for [" + searchStr + "] : " + addressList.size());
                for (int i = 0; i < addressList.size(); i++) {
                    android.location.Address outAddr = addressList.get(i);
                    int addrCount = outAddr.getMaxAddressLineIndex() + 1;
                    StringBuffer outAddrStr = new StringBuffer();
                    for (int k = 0; k < addrCount; k++) {
                        outAddrStr.append(outAddr.getAddressLine(k));
                        Log.d("append", outAddr.getAddressLine(k));
                    }


                    Log.d("위도", String.valueOf(outAddr.getLatitude()));
                    Log.d("경도", String.valueOf(outAddr.getLongitude()));

                    outAddrStr.append("\n\tLatitude : " + outAddr.getLatitude());
                    outAddrStr.append("\n\tLongitude : " + outAddr.getLongitude());

                    Log.d("주소", outAddrStr.toString());


                    lat = outAddr.getLatitude();
                    lon = outAddr.getLongitude();
                    Location = outAddrStr.toString();

                    Log.d("lat3", String.valueOf(lat) + "searchLocation 부분");
                    Log.d("lon3", String.valueOf(lon) + "searchLocation 부분");
                }

            }
        } catch (IOException ex) {
            Log.d("위치파악", "예외 : " + ex.toString());
        }

    }

    private void initApiClient() {
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(new MyConnectionCallBack())
                    .addOnConnectionFailedListener(new MyConnectionFailedListener())
                    .addApi(LocationServices.API)
                    .build();
        }
    }

    private class MyConnectionCallBack implements GoogleApiClient.ConnectionCallbacks {

        @Override
        public void onConnected(Bundle bundle) {
            if (isPermissionGranted())
                if (ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
            mCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            updateUI();
        }

        @Override
        public void onConnectionSuspended(int i) {

        }
    }

    private boolean isPermissionGranted() {
        String[] PERMISSIONS_STORAGE = {
                Manifest.permission.ACCESS_FINE_LOCATION
        };
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    MainActivity.this,            // MainActivity 액티비티의 객체 인스턴스를 나타냄
                    PERMISSIONS_STORAGE,        // 요청할 권한 목록을 설정한 String 배열
                    MY_PERMISSION_REQUEST_LOCATION    // 사용자 정의 int 상수. 권한 요청 결과를 받을 때
            );
            return false;
        } else
            return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case MY_PERMISSION_REQUEST_LOCATION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
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
                    mCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
                    updateUI();
                } else {
                    Toast.makeText(this, "Permission required", Toast.LENGTH_SHORT);
                }
            }
        }
    }

    private class MyConnectionFailedListener implements GoogleApiClient.OnConnectionFailedListener {
        @Override
        public void onConnectionFailed(ConnectionResult connectionResult) {

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mRequestingLocationUpdates && mGoogleApiClient.isConnected() && isPermissionGranted())
            startLocationUpdates();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mGoogleApiClient.isConnected())
            stopLocationUpdates();
    }

    @Override
    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    private void stopLocationUpdates() {
        if (mLocationListener != null && mGoogleApiClient != null)
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, (com.google.android.gms.location.LocationListener) mLocationListener);
    }

    private void startLocationUpdates() {
        LocationRequest locRequest = new LocationRequest();
        locRequest.setInterval(10000);
        locRequest.setFastestInterval(5000);
        locRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        mLocationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                mCurrentLocation = location;
                updateUI();
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
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient,
                locRequest,
                (com.google.android.gms.location.LocationListener) mLocationListener);
    }

    private void updateUI() {
        double latitude = 0.0;
        double longitude = 0.0;
        float precision = 0.0f;
        if (mCurrentLocation != null) {
            latitude = mCurrentLocation.getLatitude();
            longitude = mCurrentLocation.getLongitude();
            precision = mCurrentLocation.getAccuracy();
        }
    }
}
