package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtE, txtP;
    Button btnC, btnB, btnS;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Igualar componentes
        btnC = (Button) findViewById(R.id.btnIMC);
        btnB = (Button) findViewById(R.id.btnClean);
        btnS = (Button) findViewById(R.id.btnSalir);

        txtE = (EditText) findViewById(R.id.txtEst);
        txtP = (EditText) findViewById(R.id.txtPeso);

        imagen = (ImageView) findViewById(R.id.pizarron);
    }
    //Metodo para calcular IMC
    public void getIMC(View v) {
        float resp;
        float peso = Float.parseFloat(txtP.getText().toString());
        float est = Float.parseFloat(txtE.getText().toString());

        if(txtE.getText().toString().trim().isEmpty() || txtP.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Favor de ingresar datos", Toast.LENGTH_SHORT).show();
        } else {
            if(peso != 0 && est != 0) {
                float imc = peso/(float)(Math.pow(est, 2));

                //Imprimimos resultado
                Toast.makeText(this, "Tu IMC es igual a " + imc, Toast.LENGTH_SHORT).show();

                if(imc < 18.5) {
                    imagen.setImageResource(R.drawable.insuficiente);
                }
                if(imc>=18.5 && imc<24.9) {
                    imagen.setImageResource(R.drawable.normal);
                }
                if (imc>25 && imc<=29.9) {
                    imagen.setImageResource(R.drawable.sobrepeso);
                }
                if (imc>30 && imc<=34.5) {
                    imagen.setImageResource(R.drawable.obesidad);
                }
                if (imc > 35) {
                    imagen.setImageResource(R.drawable.extrema);
                }

                imagen.setVisibility(View.VISIBLE);

            } else {
                Toast.makeText(this, "No puede ser 0 ninguno de los campos", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //Metodo de borrar
    public void clearField(View v) {
        txtE.setText("");
        txtP.setText("");
        imagen.setVisibility(View.INVISIBLE);
    }

    //Metodo de salir
    public void salir(View v) {
        System.exit(0);
    }
}
