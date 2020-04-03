package com.example.sharepreferencesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private EditText nc, name, tel, email;
    private Button btnsave;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nc = (EditText) findViewById(R.id.txtNumControl);
        name = (EditText) findViewById(R.id.txtNombre);
        tel = (EditText) findViewById(R.id.txtTelefono);
        email = (EditText) findViewById(R.id.txtCampo);
        image = (ImageView) findViewById(R.id.imageView);
        btnsave = (Button) findViewById(R.id.btnGuardar);

        //Leemos la preferencia almacenadas al cierre de la app
        //Recuperar o leer los datos que guardo la clase SharedPreferences
        SharedPreferences preferencia = getSharedPreferences("datos", Context.MODE_PRIVATE);
        //Asignamos el correo recuperado de las preferencias del campo de texto
        nc.setText(preferencia.getString("numero control", ""));
        name.setText(preferencia.getString("nombre", ""));
        tel.setText(preferencia.getString("telefono", ""));
        email.setText(preferencia.getString("correo", ""));

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
        editor.putString("numero control", nc.getText().toString());
        editor.putString("nombre", name.getText().toString());
        editor.putString("telefono", tel.getText().toString());
        editor.putString("correo", email.getText().toString());
        //Confirmamos almacenar los datos en el archivo datos
        editor.commit();

        //Salir de la aplicacion
        finish();
    }
}
