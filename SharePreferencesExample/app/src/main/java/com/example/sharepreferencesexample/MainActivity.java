package com.example.sharepreferencesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txt;
    private Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (EditText) findViewById(R.id.txtCampo);
        btnsave = (Button) findViewById(R.id.btnGuardar);

        //Leemos la preferencia almacenadas al cierre de la app
        //Recuperar o leer los datos que guardo la clase SharedPreferences
        SharedPreferences preferencia = getSharedPreferences("datos", Context.MODE_PRIVATE);
        //Asignamos el correo recuperado de las preferencias del campo de texto
        txt.setText(preferencia.getString("correo", ""));
    }

    /**
     * Metodo para guardar las preferencias
     */
    public void guardar(View vista)
    {
        //Creamos un objeto SharedPreferences
        SharedPreferences preferencia = getSharedPreferences("datos", Context.MODE_PRIVATE);
        //Abrimos editor para escribir las preferencias que querramos
        SharedPreferences.Editor editor = preferencia.edit();
        //Escribimos datos en el archivo datos
        editor.putString("correo", txt.getText().toString());
        //Confirmamos almacenar los datos en el archivo datos
        editor.commit();

        //Salir de la aplicacion
        finish();
    }
}
