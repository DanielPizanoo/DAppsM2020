package com.example.webviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private EditText txtCampo;
    private Button btnIr;
    private Switch btnswitch;
    private Spinner sp;
    private KeyListener listener;
    private String url=null;
    private boolean bandera =  false;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCampo = (EditText) findViewById(R.id.txtUrl);
        btnIr = (Button) findViewById(R.id.btnGo);
        btnswitch = (Switch) findViewById(R.id.switch1);
        sp = (Spinner) findViewById(R.id.spinner);

        //Configuramos el Spinner
        String [] direcciones = {"www.google.com", "www.colima.tecnm.mx", "www.facebook.com"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, direcciones);
        sp.setAdapter(adapter);

        //Deshabilitamos caja de texto
        sp.setEnabled(true);
        txtCampo.setEnabled(false);

        //Manejamos el evento de boton de Switch
        btnswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                //Boton de Switch encendido
                if (b) {
                    listener = txtCampo.getKeyListener();
                    //Habilitar el spinner y deshabilitar la caja de texto
                    sp.setEnabled(true);
                    //Deshabilitar la caja de texto
                    txtCampo.setActivated(false);
                    txtCampo.setEnabled(false);
                    bandera = true;
                } else {
                    //El usuario quiere teclear una url
                    sp.setEnabled(false);
                    txtCampo.setEnabled(true);
                }
            }
        });
    }

    /**
     * Metodo para pasar a la Actividad 2
     */

    public void irAlaURL(View v) {
        if (bandera == true) {
            url = sp.getSelectedItem().toString();
        }
        else {
            String url = txtCampo.getText().toString();
            Intent i = new Intent(this, Main2Activity.class);
            i.putExtra("url", url);
            startActivity(i);
        }
    }
}
