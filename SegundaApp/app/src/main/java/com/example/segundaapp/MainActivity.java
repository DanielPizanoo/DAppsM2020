package com.example.segundaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Primro se ejecuta

    EditText txtC;
    Button btnM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //igualamos componentes

        txtC = (EditText)findViewById(R.id.txtCampo);
        btnM = (Button)findViewById(R.id.btnMensaje);
    }

    //Metodo para poner un mensaje en el campo del texto

    public void printMensaje(View vista){
        txtC.setText("Saludos desde Android");
    }

}
