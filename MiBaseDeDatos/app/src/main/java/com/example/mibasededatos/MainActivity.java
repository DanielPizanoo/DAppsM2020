package com.example.mibasededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Button btnR, btnB, btnL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
        btnR = (Button) findViewById(R.id.btnCallRegistrar);
        btnB = (Button) findViewById(R.id.btnBuscar);
        btnL = (Button) findViewById(R.id.btnReporte);
         */
    }

    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menuoverflow, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opcion1:
                Intent a = new Intent(MainActivity.this, RegistrarEmpleadoActivity.class);
                startActivity(a);
                return true;
            case R.id.opcion2:
                Intent b = new Intent(MainActivity.this, ConsultarEmpleadoActivity.class);
                startActivity(b);
                return true;
            case R.id.opcion3:
                Intent c = new Intent(MainActivity.this, ConsultarListViewEmpleado.class);
                startActivity(c);
                return true;
            case R.id.opcion4:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
    public void insertarEmpleado(View v) {
        Intent i = new Intent(MainActivity.this, RegistrarEmpleadoActivity.class);
        startActivity(i);
    }

    public void buscarEmpleado(View v) {
        Intent i = new Intent(MainActivity.this, ConsultarEmpleadoActivity.class);
        startActivity(i);
    }

    public void listarEmpleado(View v) {
        Intent i = new Intent(MainActivity.this, ConsultarListViewEmpleado.class);
        startActivity(i);
    }
     */
}
