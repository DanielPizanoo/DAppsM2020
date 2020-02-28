package com.example.spinnerexample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtn1, txtn2;
    private Spinner sp;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtn1 = (EditText)findViewById(R.id.txtN1);
        txtn2 = (EditText)findViewById(R.id.txtN2);
        sp = (Spinner)findViewById(R.id.spOp);
        btn = (Button)findViewById(R.id.btnC);

        //Configurar el Spinner
        String [] operacion = {"Suma", "Resta", "Multiplicacion", "Division"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_spinner_elements, operacion);
        sp.setAdapter(adapter);
    }

    public void operaciones(View v) {
        //Leer campos de texto
        int n1 = Integer.parseInt(txtn1.getText().toString());
        int n2 = Integer.parseInt(txtn2.getText().toString());

        //Leemos la seleccion del usuario en el Spinner
        String op = sp.getSelectedItem().toString();

        //Seleccionamos la operacion: Suma, Resta...
        if (op.equals("Suma"))
        {
            int res = n1 + n2;
            String r = String.valueOf(res);
            this.printResultado("Suma", r);
        }
        else if (op.equals("Resta"))
        {
            int res = n1 - n2;
            String r = String.valueOf(res);
            this.printResultado("Resta", r);
        }
        else if (op.equals("Multiplicacion"))
        {
            int res = n1 * n2;
            String r = String.valueOf(res);
            this.printResultado("Multiplicacion", r);
        }
        else if (op.equals("Division"))
        {
            if (n1 == 0 || n2 == 0) {
                Toast.makeText(this, "Introduce numeros mayores que cero", Toast.LENGTH_SHORT).show();
        } else
            {
                float res = n1 / n2;
                String r = String.valueOf(res);
                this.printResultado("Division", r);
            }
        }
    }

    public void printResultado(String op, String res) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Resultado");
        builder.setMessage("El resultado de la "+op+" es: "+res);
        builder.setPositiveButton("Confirmar",null);
        builder.create();
        builder.show();
    }
}
