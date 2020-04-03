package com.example.mibitacora;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText txt;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Relacionamos componentes
        txt = (EditText) findViewById(R.id.txtCampo);
        btn = (Button) findViewById(R.id.btnGuardar);
        String bitacoraCompleta = "";

        //Rutina para leer el archivo bitacora
        String [] archivos = fileList(); //Lee los nombres de los archivos de texto de la app

        try {
            if (fileExiste(archivos, "bitacora.txt")) {
                InputStreamReader archivo = new InputStreamReader(openFileInput("bitacora.txt"));
                BufferedReader br = new BufferedReader(archivo);
                //Verficiar si el archivo tiene datos
                String linea = br.readLine();

                while (linea != null) {
                    bitacoraCompleta = bitacoraCompleta + linea + "\n";
                    linea = br.readLine();
                }
                br.close();
                archivo.close();

                //Copiamos el contenido del archivo bitacora.txt al campo de texto multilinea
                txt.setText(bitacoraCompleta);
            }
        } catch (IOException ex) {

        }
    }

    //Funcion para validar si existe el archivo bitacora.txt dentro de la lista de archivos creados por la app
    private boolean fileExiste(String [] archivos, String nameFile) {
        for (int i = 0; i < archivos.length; i++)
            if (nameFile.equals(archivos[i]))
                return true;
        return false;
    }

    //Metodo para guardar la bitacora tecleada por el usuario en el campo de texto en un archivo bitacora.txt
    public void Guardar(View vista) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Importante");
        builder.setMessage("¿Quiere guardar los cambios?");
        builder.setCancelable(false);
        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface builder, int id) {
                aceptar();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cancelar();
            }
        });
        builder.show();
    }
    public void aceptar() {
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("bitacora.txt", Activity.MODE_PRIVATE));
            archivo.write(txt.getText().toString());
            archivo.flush();
            archivo.close();
        } catch (IOException closed) {

        }
        finish();
    }

    public void cancelar() {

    }
}
