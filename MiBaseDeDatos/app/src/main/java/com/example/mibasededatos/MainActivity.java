package com.example.mibasededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnR, btnB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnR = (Button) findViewById(R.id.btnCallRegistrar);
        btnB = (Button) findViewById(R.id.btnBuscar);
    }

    public void insertarEmpleado(View v) {
        Intent i = new Intent(MainActivity.this, RegistrarEmpleadoActivity.class);
        startActivity(i);
    }

    public void buscarEmpleado(View v) {
        Intent i = new Intent(MainActivity.this, ConsultarEmpleadoActivity.class);
        startActivity(i);
    }
}
