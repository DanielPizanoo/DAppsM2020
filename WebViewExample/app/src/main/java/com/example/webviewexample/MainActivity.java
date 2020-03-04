package com.example.webviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private EditText txtCampo;
    private Button btnIr;
    private Switch btnswitch;
    private Spinner sp;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCampo = (EditText) findViewById(R.id.txtUrl);
        btnIr = (Button) findViewById(R.id.btnGo);
        btnswitch = (Switch) findViewById(R.id.switch1);
        sp = (Spinner) findViewById(R.id.spinner);

        if (btnswitch.isChecked()) {
            sp.setEnabled(false);
            txtCampo.setEnabled(true);
        } else {
            sp.setEnabled(true);
            txtCampo.setEnabled(false);
        }

        String [] direcciones = {"www.google.com", "www.colima.tecnm.mx", "www.facebook.com"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, direcciones);
        sp.setAdapter(adapter);

        btnswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    /**
     * Metodo para pasar a la Actividad 2
     */

    public void irAlaURL(View v) {
        String url = txtCampo.getText().toString();
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("url", url);
        startActivity(i);
    }
}
