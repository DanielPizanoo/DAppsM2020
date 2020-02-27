package com.example.spinnerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

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

        //
    }
}
