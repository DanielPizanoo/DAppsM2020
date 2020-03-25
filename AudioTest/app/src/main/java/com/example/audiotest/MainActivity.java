package com.example.audiotest;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ImageButton b1, b2, b3, b4, b5, b6;
    private SoundPool sp;
    private int son;
    private ProgressBar simpleProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (ImageButton) findViewById(R.id.btnPig);
        b2 = (ImageButton) findViewById(R.id.btnSeal);
        b3 = (ImageButton) findViewById(R.id.btnFox);
        b4 = (ImageButton) findViewById(R.id.btnWolf);
        b5 = (ImageButton) findViewById(R.id.btnDog);
        b6 = (ImageButton) findViewById(R.id.btnTiger);

        simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);

        //Cargamos el audio en el manejador
        sp = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
        son = sp.load(this, R.raw.dog, 1);
    }

    public void playBoton1(View view) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.pig);
        final int duration = mp.getDuration();
        simpleProgressBar.setProgress(duration);
        mp.start();
    }
    public void playBoton2(View view) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.foca);
        mp.start();
    }
    public void playBoton3(View view) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.fox);
        mp.start();
    }
    public void playBoton4(View view) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.wolf);
        mp.start();
    }
    public void playBoton5(View view) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.dog);
        mp.start();
    }
    public void playBoton6(View view) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.tiger);
        mp.start();
    }
}
