package com.example.micontador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button btnI, btnR, btnD;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Igualar los componentes entre la vista y el controlador
        txt = (TextView)findViewById(R.id.textCampo);
        btnI = (Button) findViewById(R.id.btnInt);
        btnR = (Button) findViewById(R.id.btnRest);
        btnD = (Button) findViewById(R.id.btnDec);
    }

    public void incrementar(View v) {
        contador++;
        this.display(v);
    }

    public void decrementar(View v) {
        contador--;
        this.display(v);
    }

    public void reiniciar(View v) {
        contador = 0;
        this.display(v);
    }

    public void display(View vista){
        txt.setText(String.valueOf(contador));
    }
}
