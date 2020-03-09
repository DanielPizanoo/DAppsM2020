package com.example.seekbarexample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar red, green, blue;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.manejabarra();
    }

    //Metodo para manejar los eventos del seekbar

    public void manejabarra() {
        boton = (Button) findViewById(R.id.button);
        red = (SeekBar) findViewById(R.id.seekbar);
        green = (SeekBar) findViewById(R.id.seekBar2);
        blue = (SeekBar) findViewById(R.id.seekBar3);
        red.setMax(255);
        green.setMax(255);
        blue.setMax(255);

        red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //txt.setText("Valor: "+i +" / "+seekBar.getMax());
                int rojo = red.getProgress();
                int verde = green.getProgress();
                int azul = blue.getProgress();

                boton.setBackgroundColor(Color.rgb(rojo, verde, azul));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int rojo = red.getProgress();
                int verde = green.getProgress();
                int azul = blue.getProgress();
                boton.setBackgroundColor(Color.rgb(rojo, verde, azul));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int rojo = red.getProgress();
                int verde = green.getProgress();
                int azul = blue.getProgress();
                boton.setBackgroundColor(Color.rgb(rojo, verde, azul));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
