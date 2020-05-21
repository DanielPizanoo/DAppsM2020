package com.example.mibasededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnR, btnB, btnL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnR = (Button) findViewById(R.id.btnCallRegistrar);
        btnB = (Button) findViewById(R.id.btnBuscar);
        btnL = (Button) findViewById(R.id.btnReporte);
    }

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
}
