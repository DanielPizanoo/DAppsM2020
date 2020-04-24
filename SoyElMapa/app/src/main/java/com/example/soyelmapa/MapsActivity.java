package com.example.soyelmapa;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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

        // Add a markers
        LatLng school = new LatLng(19.2616991,-103.7235446);
        LatLng casino = new LatLng(19.2546147,-103.7128776);
        LatLng gym = new LatLng(19.2715714,-103.713525);
        LatLng fly = new LatLng(19.2805675,-103.5795521);
        LatLng hotel = new LatLng(19.2487113,-103.7079968);
        LatLng banco = new LatLng(19.2398422,-103.7280384);
        LatLng cine = new LatLng(19.2400306,-103.7805698);
        LatLng rest = new LatLng(19.2555021,-103.7068396);
        LatLng supermarket = new LatLng(19.2808843,-103.7333031);
        LatLng hospital = new LatLng(19.2581459,-103.6920233);

        // Asignar posiciones a cada marcador
        mMap.addMarker(new MarkerOptions().position(school));
        mMap.addMarker(new MarkerOptions().position(casino));
        mMap.addMarker(new MarkerOptions().position(gym));
        mMap.addMarker(new MarkerOptions().position(fly));
        mMap.addMarker(new MarkerOptions().position(hotel));
        mMap.addMarker(new MarkerOptions().position(banco));
        mMap.addMarker(new MarkerOptions().position(cine));
        mMap.addMarker(new MarkerOptions().position(rest));
        mMap.addMarker(new MarkerOptions().position(supermarket));
        mMap.addMarker(new MarkerOptions().position(hospital));

        //mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_tecc)).anchor(0.0f, 1.0f).position(school));
        //mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_casino)).anchor(0.0f, 1.0f).position(casino));
        //mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_gym)).anchor(0.0f, 1.0f).position(gym));
        //mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_fly)).anchor(0.0f, 1.0f).position(fly));
        //mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_hotel)).anchor(0.0f, 1.0f).position(hotel));
        //mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_banco)).anchor(0.0f, 1.0f).position(banco));
        //mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_cine)).anchor(0.0f, 1.0f).position(cine));
        //mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_restaurant)).anchor(0.0f, 1.0f).position(rest));
        //mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_store)).anchor(0.0f, 1.0f).position(supermarket));
        //mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_hospital)).anchor(0.0f, 1.0f).position(hospital));

        //Modificar el valor de Zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(school, 10));
    }
}
