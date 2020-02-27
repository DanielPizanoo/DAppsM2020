package com.example.botonesradio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtn1, txtn2;
    private Button btnC;
    private RadioButton rs, rr, rm, rd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Igualarlos
        txtn1 = (EditText) findViewById(R.id.txtNum1);
        txtn2 = (EditText) findViewById(R.id.txtNum2);
        btnC = (Button) findViewById(R.id.btnCalcular);
        rs = (RadioButton) findViewById(R.id.brSuma);
        rr = (RadioButton) findViewById(R.id.brResta);
        rm = (RadioButton) findViewById(R.id.brMulti);
        rd = (RadioButton) findViewById(R.id.brDiv);

    }

    public void calcular(View v) {
        //Leemos datos tecleados por el usuario
        int n1 = Integer.parseInt(txtn1.getText().toString());
        int n2 = Integer.parseInt(txtn2.getText().toString());

        if(rs.isChecked() == true) {
            Toast.makeText(this, "La suma es: "+ (n1+n2), Toast.LENGTH_SHORT).show();
        }

        if(rr.isChecked() == true) {
            Toast.makeText(this, "La resta es: "+ (n1-n2), Toast.LENGTH_SHORT).show();
        }

        if(rm.isChecked() == true) {
            Toast.makeText(this, "La multiplicacion es: "+ (n1*n2), Toast.LENGTH_SHORT).show();
        }

        if(rd.isChecked() == true) {
            Toast.makeText(this, "La division es: "+ (float)(n1/n2), Toast.LENGTH_SHORT).show();
        }
    }
}
