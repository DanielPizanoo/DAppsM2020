package com.example.listviewexamples;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    ArrayList<Datos> municipios = new ArrayList<Datos>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.listview);

        /**
        String [] municipios = {"Armeria", "Colima", "Coquimatlan", "Comala", "Cuauhtemoc", "Ixtlahuacan", "Manzanillo",
                "Minatitlan", "Tecoman", "Villa de Alvarez"};
        */

        Datos A = new Datos();
        A.setNmunicipio(1);
        A.setNombre("Armeria");
        A.setExtension("232 km2");
        A.setExtension("www.armeria.com");
        municipios.add(A);

        final ArrayAdapter <Datos> adapter = new ArrayAdapter<Datos>(this, R.layout.list_item_listview, municipios);

        lista.setAdapter(adapter);

        //Agregar un listener
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                int mun = Integer.parseInt(adapterView.getItemAtPosition(i).toString());
                printInfo(i);
            }
        });
    } // Fin de metodo OnCreate

    /**
     * Metodo para imprimir el municipio con alertdialog
     */
    public void printInfo(int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Información");
        builder.setMessage(municipios[i].toString());
        builder.setPositiveButton("Aceptar",null);
        builder.create();
        builder.show();
    }
}
