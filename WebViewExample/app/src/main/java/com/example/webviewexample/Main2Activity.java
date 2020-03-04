package com.example.webviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    WebView web;
    Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        web = (WebView) findViewById(R.id.webview);
        btnClose = (Button) findViewById(R.id.btnClose);

        //Recibir la cadena url
        String cad = getIntent().getStringExtra("url");
        //Agregar cad al componente WebView
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("http://"+cad);
    }

    //Metodo para cerrar Actividad 2
    public void closeapp(View v) {
        finish();
    }
}
