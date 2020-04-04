package com.example.fragmentosdinamicosexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //Declarar los objetos tipo fragmentos
    FragmentoRojo fragmentoRojo;
    FragmentoAzul fragmentoAzul;
    FragmentoVerde fragmentoVerde;
    FragmentoCafe fragmentoCafe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instanciar los fragmentos
        fragmentoRojo = new FragmentoRojo();
        fragmentoAzul = new FragmentoAzul();
        fragmentoVerde = new FragmentoVerde();
        fragmentoCafe = new FragmentoCafe();

        //Desplegar el fragmento por defecto
        getSupportFragmentManager().beginTransaction().add(R.id.ContenedorFragmento, fragmentoRojo);
    }

    /**
     * Metodo para cambiar los fragmentos en el contenedor
     */
    public void OnClick(View vista) {
        FragmentTransaction transaccion = getSupportFragmentManager().beginTransaction();
        switch (vista.getId()) {
            case R.id.btnRojo:
                //Asignar el fragmento rojo al contenedor
                transaccion.replace(R.id.ContenedorFragmento, fragmentoRojo);
                break;

            case R.id.btnVerde:
                transaccion.replace(R.id.ContenedorFragmento, fragmentoVerde);
                break;

            case R.id.btnAzul:
                transaccion.replace(R.id.ContenedorFragmento, fragmentoAzul);
                break;

            case R.id.btnCafe:
                transaccion.replace(R.id.ContenedorFragmento, fragmentoCafe);
                break;
        }
        transaccion.commit();
    }
}
