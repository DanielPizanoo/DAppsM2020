package com.example.pesosadolares;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtC;
    private ImageButton btnC;
    private CheckBox bD, bE, bL, bY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtC = (EditText) findViewById(R.id.txtCantidad);
        btnC = (ImageButton) findViewById(R.id.imageButton);
        bD = (CheckBox) findViewById(R.id.chDolares);
        bE = (CheckBox) findViewById(R.id.chEuros);
        bL = (CheckBox) findViewById(R.id.chLibras);
        bY = (CheckBox) findViewById(R.id.chYenes);

        //Deshabilitamos boton
        btnC.setEnabled(false);

        txtC.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btnC.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {
                btnC.setEnabled(true);
            }
        });
    }

    /**
     * Metodo para calcular conversion
     */
    public void calcularConversion(View v) {
        //Leer propiedad text del campo del texto
        float cant = Float.parseFloat(txtC.getText().toString());
        float total = 0.0f;

        if (bD.isChecked()) {
            total = cant/19;

            //Invocamos metodo display
            this.display(total, "dolares");
        }

        if (bE.isChecked()) {
            total = cant/21;

            //Invocamos metodo display
            this.display(total, "euros");
        }

        if (bL.isChecked()) {
            total = cant/25;

            //Invocamos metodo display
            this.display(total, "libras");
        }

        if (bY.isChecked()) {
            total = (cant*6);

            //Invocamos metodo display
            this.display(total, "euros");
        }
    }

    /**
     * Metodo para visualizar conversion en una ventana
     */
    public void display(float tt, String moneda) {

        //tomado de https://www.tutorialesprogramacionya.com/javaya/androidya/detalleconcepto.php?codigo=164&inicio=

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Resultado");
        builder.setMessage(tt + " " + moneda);
        builder.setPositiveButton("Aceptar",null);
        builder.create();
        builder.show();

        //Deseleccionar los botones checkbox
        bD.setChecked(false);
        bE.setChecked(false);
        bL.setChecked(false);
        bY.setChecked(false);
    }
}
