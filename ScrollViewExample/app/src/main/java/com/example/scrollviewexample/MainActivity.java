package com.example.scrollviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.speech.tts.TextToSpeech;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private Switch audioON;
    private boolean bandera = false;
    private TextToSpeech textToSpeech;
    private String mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Colocamos las instrucciones para poner el icono en la barra de actionbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        textToSpeech = new TextToSpeech(this, this);
        textToSpeech.setLanguage(new Locale("spa", "ESP"));

        audioON = (Switch) findViewById(R.id.audioonoff);
        audioON.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b==true) {
                    bandera=true;
                } else {
                    bandera=false;
                    textToSpeech.stop();
                }
            }
        });
    }

    public void getAnimalName(View v) {
        //Estructura Switch
        switch (v.getId()) {
            case R.id.alce:
                mensaje = "Alce";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                if (bandera == true) {
                    //Enviar string a la rutina de conversion de audio
                    speak(mensaje);
                }
                else {
                    bandera=false;
                    textToSpeech.stop();
                }
                break;
            case R.id.camaron:
                mensaje = "Camaron";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                if (bandera == true) {
                    //Enviar string a la rutina de conversion de audio
                    speak(mensaje);
                }
                else {
                    bandera=false;
                    textToSpeech.stop();
                }
                break;
            case R.id.gusano:
                mensaje = "Gusano";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                if (bandera == true) {
                    //Enviar string a la rutina de conversion de audio
                    speak(mensaje);
                }
                else {
                    bandera=false;
                    textToSpeech.stop();
                }
                break;
            case R.id.jirafa:
                mensaje = "Jirafa";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                if (bandera == true) {
                    //Enviar string a la rutina de conversion de audio
                    speak(mensaje);
                }
                else {
                    bandera=false;
                    textToSpeech.stop();
                }
                break;
            case R.id.lobo:
                mensaje = "Lobo";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                if (bandera == true) {
                    //Enviar string a la rutina de conversion de audio
                    speak(mensaje);
                }
                else {
                    bandera=false;
                    textToSpeech.stop();
                }
                break;
            case R.id.mono:
                mensaje = "Mono";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                if (bandera == true) {
                    //Enviar string a la rutina de conversion de audio
                    speak(mensaje);
                }
                else {
                    bandera=false;
                    textToSpeech.stop();
                }
                break;
            case R.id.pajaro:
                mensaje = "Pajaro";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                if (bandera == true) {
                    //Enviar string a la rutina de conversion de audio
                    speak(mensaje);
                }
                else {
                    bandera=false;
                    textToSpeech.stop();
                }
                break;
            case R.id.pato:
                mensaje = "Pato";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                if (bandera == true) {
                    //Enviar string a la rutina de conversion de audio
                    speak(mensaje);
                }
                else {
                    bandera=false;
                    textToSpeech.stop();
                }
                break;
            case R.id.perro:
                mensaje = "Perro";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                if (bandera == true) {
                    //Enviar string a la rutina de conversion de audio
                    speak(mensaje);
                }
                else {
                    bandera=false;
                    textToSpeech.stop();
                }
                break;
            case R.id.pinguino:
                mensaje = "Pinguino";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                if (bandera == true) {
                    //Enviar string a la rutina de conversion de audio
                    speak(mensaje);
                }
                else {
                    bandera=false;
                    textToSpeech.stop();
                }
                break;
            case R.id.raro:
                mensaje = "Raro";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                if (bandera == true) {
                    //Enviar string a la rutina de conversion de audio
                    speak(mensaje);
                }
                else {
                    bandera=false;
                    textToSpeech.stop();
                }
                break;
            case R.id.tortuga:
                mensaje = "Tortuga";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                if (bandera == true) {
                    //Enviar string a la rutina de conversion de audio
                    speak(mensaje);
                }
                else {
                    bandera=false;
                    textToSpeech.stop();
                }
                break;
            case R.id.vaca:
                mensaje = "Vaca";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                if (bandera == true) {
                    //Enviar string a la rutina de conversion de audio
                    speak(mensaje);
                }
                else {
                    bandera=false;
                    textToSpeech.stop();
                }
                break;
            case R.id.zebra:
                mensaje = "Zebra";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                if (bandera == true) {
                    //Enviar string a la rutina de conversion de audio
                    speak(mensaje);
                }
                else {
                    bandera=false;
                    textToSpeech.stop();
                }
                break;
            case R.id.zorro:
                mensaje = "Zorro";
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
                if (bandera == true) {
                    //Enviar string a la rutina de conversion de audio
                    speak(mensaje);
                }
                else {
                    bandera=false;
                    textToSpeech.stop();
                }
                break;
        }
    }

    @Override
    public void onInit(int status) {
        if ( status == TextToSpeech.LANG_MISSING_DATA | status == TextToSpeech.LANG_NOT_SUPPORTED )
        {
            Toast.makeText( this, "ERROR LANG_MISSING_DATA | LANG_NOT_SUPPORTED", Toast.LENGTH_SHORT ).show();
        }
    }

    private void speak( String str )
    {
        textToSpeech.speak( str, TextToSpeech.QUEUE_FLUSH, null );
        textToSpeech.setSpeechRate( 0.0f );
        textToSpeech.setPitch( 0.0f );
    }

    @Override
    protected void onDestroy()
    {
        if ( textToSpeech != null )
        {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
}
