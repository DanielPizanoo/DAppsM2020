package com.example.mibasededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mibasededatos.utilidades.Utilidades;

public class RegistrarEmpleadoActivity extends AppCompatActivity {

    private EditText txtC, txtN, txtS;
    private Button btnG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_empleado);

        txtC = (EditText) findViewById(R.id.txtClave);
        txtN = (EditText) findViewById(R.id.txtNombre);
        txtS = (EditText) findViewById(R.id.txtSueldo);
        btnG = (Button) findViewById(R.id.btnRegistrar);
    }

    /**
     * Metodo para guardar los datos del empleado
     */
    public void guardarEmpleado(View v) {
        //Abrimos conexion a la base de datos
        //Instanciamos la clase Conexion
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this, "bdEmpleados", null, 1);
        //Creamos un objeto de base de datos
        SQLiteDatabase db = conexion.getWritableDatabase();
        //Objeto ContentValues
        ContentValues values = new ContentValues();

        //Rellenamos el objeto ContentValues
        values.put(Utilidades.CAMPO_CLAVE, txtC.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE, txtN.getText().toString());
        values.put(Utilidades.CAMPO_SUELDO, txtS.getText().toString());

        //Seleccionamos uno de los tres campos para validar la escritura de datos en la tabla
        Long idRes = db.insert(Utilidades.TABLA_EMPLEADOS, Utilidades.CAMPO_CLAVE, values);
        //Mensaje
        Toast.makeText(this, "Guardado: " + idRes, Toast.LENGTH_LONG).show();

        txtC.getText().clear();
        txtN.getText().clear();
        txtS.getText().clear();

        //Cerrar tabla
        db.close();


    }
}
