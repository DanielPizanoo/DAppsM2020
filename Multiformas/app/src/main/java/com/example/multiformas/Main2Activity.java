package com.example.multiformas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Leer datos enviados por la actividad 1
        Bundle bundle = getIntent().getExtras();

        //Declaramos variables para recibir los datos
        String log = bundle.getString("login");
        String pas = bundle.getString("clave");

        //Toast.makeText(this, "login: "+log+"\n"+"password: "+pas, Toast.LENGTH_SHORT).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Validar Usuario");
        builder.setMessage("login: "+log+"\n"+"password: "+pas);
        builder.setPositiveButton("Aceptar", null);
        builder.create();
        builder.show();

        //Validar Usuario

        if (log.equals("peludo") && pas.equals("peludo") ) {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Validar Usuario");
            builder1.setMessage("Usuario Valido en el Sistema");
            builder1.setPositiveButton("Aceptar", null);
            builder1.create();
            builder1.show();
        } else {
            Intent intent = new Intent(this.getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }
}
