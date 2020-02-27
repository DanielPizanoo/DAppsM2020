package com.example.multiformas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtL, txtP;
    Button btnV, btnS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Igualar los componentes
        txtL = (EditText)findViewById(R.id.txtLogin);
        txtP = (EditText)findViewById(R.id.txtPass);

        btnV = (Button)findViewById(R.id.btnValidar);
        btnS = (Button)findViewById(R.id.btnSalir);
    }

    /**
     * Metodo para salir de la APP
     */
    public void salir(View view) {
        finish();
    }

    /**
     * Metodo para saltar a la actividad 3
     */
    public void validar(View vista) {
        //Leemos datos capturados por el usuario
        String login = txtL.getText().toString();
        String pass = txtP.getText().toString();

        // Para saltar a la actividad 2
        //Creamos un objeto intencion
        Intent i = new Intent(this.getApplicationContext(), Main2Activity.class);

        //Incluimos los datos a enviar (login y pass)
        i.putExtra("login", login);
        i.putExtra("clave", pass);

        //Lanzamos el intent
        startActivity(i);
    }
}