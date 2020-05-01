package com.example.ejemplomapagps;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import static android.content.ContentValues.TAG;

public class Localizacion implements LocationListener  {

    //Declara los siguientes objetos tipo MainActivity
    MainActivity mainActivity;
    TextView tvMensaje;

    //Agregar metodo get y set, para regresar y modificar los objetos MainActivity

    //Metodo Get
    public MainActivity getMainActivity() {
        return mainActivity;
    }

    //Metodo Set
    public void setMainActivity(MainActivity mainActivity, TextView tvMensaje) {
        this.mainActivity = mainActivity;
        this.tvMensaje = tvMensaje;
    }

    @Override
    public void onLocationChanged(Location location) {
        String texto = "Mi ubicacion actual es: \n" + location.getLatitude() + ", " + location.getLongitude();

        //Actualizamos objeto tvMensaje con los valores de lat y long
        tvMensaje.setText(texto);

        //Crear un objeto tipo mapa
        mapa(location.getLatitude(), location.getLongitude());
    }

    //Agregar metodo para manejar el fragmento del mapa
    public void mapa(double lat, double lon) {
        FragmentMaps fragment = new FragmentMaps();
        Bundle bundle = new Bundle();
        //Objeto que transporta los datos lat y lon al fragmento que despliegue el mapa
        bundle.putDouble("lat", new Double(lat));
        bundle.putDouble("lon", new Double(lon));
        //Asignamos al objeto fragment los datos
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getMainActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment, fragment, null);
        fragmentTransaction.commit();

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        //Estructura switch para determinar los tres casos de acceso al GPS
        switch (status) {
            case LocationProvider.AVAILABLE:
                Log.d(TAG, "LocationProvider.AVAILABLE");
                break;
            case LocationProvider.OUT_OF_SERVICE:
                Log.d(TAG, "LocationProvider.OUT_OF_SERVICE");
                break;
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                Log.d(TAG, "LocationProvider.TEMPORARILY_UNAVAILABLE");
                break;

        }
    }

    @Override
    public void onProviderEnabled(String s) {
        tvMensaje.setText("GPS Disponible");

    }

    @Override
    public void onProviderDisabled(String s) {
        tvMensaje.setText("GPS No Disponible");
    }
}
