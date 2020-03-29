package com.example.actionbarexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Metodo construir el menu
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menuoverflow, menu);
        return true;
    }

    //Metodo del manejo de las opciones del menuoverflow
    public boolean onOptionsItemSelected(MenuItem item)
    {
        //Conocer la opcion seleccionada por el usuario
        int i = item.getItemId();

        //Comparar con los id de los items definidos en la vista de diseño
        if (i==R.id.opcion1) {
            Toast.makeText(this, "Selecciono la opcion Agregar", Toast.LENGTH_SHORT).show();
        }
        else if(i==R.id.opcion2) {
            Toast.makeText(this, "Selecciono la opcion Buscar", Toast.LENGTH_SHORT).show();
        }
        else if(i==R.id.opcion3) {
            //Invocar metodo para salir de la app
            salir();
        }
        else if(i==R.id.campana)
        {
            Toast.makeText(this, "Oprimio el icono de la campana", Toast.LENGTH_SHORT).show();
        }
        else if(i==R.id.location)
        {
            Toast.makeText(this, "Oprimio el icono de localizacion", Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }

    public void salir()
    {
        finish();
    }
}
