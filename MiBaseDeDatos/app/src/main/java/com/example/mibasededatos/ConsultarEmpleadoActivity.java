package com.example.mibasededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mibasededatos.utilidades.Utilidades;

public class ConsultarEmpleadoActivity extends AppCompatActivity {

    Button btnB;
    TextView txtName, txtSalary;
    EditText txtClave;
    ConexionSQLiteHelper con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_empleado);

        btnB = (Button) findViewById(R.id.btnBuscar);
        txtName = (TextView) findViewById(R.id.txtNombre);
        txtSalary = (TextView) findViewById(R.id.txtSueldo);
        txtClave = (EditText) findViewById(R.id.txtClave);

        //Declarar el objeto conexion
        con = new ConexionSQLiteHelper(this, "bdEmpleados", null, 1);
    }

    /**
     * Metodo para buscar un empleado en la tabla empleados
     */
    public void consultarEmpleado(View v) {
        //Declaramos objetco SqlLitedatabase y abrimos en forma de lectura
        SQLiteDatabase db = con.getReadableDatabase();
        //Arreglo String para usarlo como parametro de busqueda
        String [] parametros = {txtClave.getText().toString()};
        String [] campos = {Utilidades.CAMPO_NOMBRE, Utilidades.CAMPO_SUELDO};

        //Colocamos un manejador de excepciones
        try {

            //Objeto cursor para realizar busqueda del registro
            Cursor cursor = db.query(Utilidades.TABLA_EMPLEADOS, campos, Utilidades.CAMPO_CLAVE + "=?", parametros, null, null, null);
            //Mover el puntero de la tabla al primer registro
            cursor.moveToFirst();
            //Asignamos los campos del registro a los TextView
            txtName.setText(cursor.getString(0));
            txtSalary.setText(cursor.getString(1));
            cursor.close();
        } catch (Exception e) {
            Toast.makeText(this, "Empleado no existe", Toast.LENGTH_SHORT).show();
            limpiarCampos();
        }
    }

    private void limpiarCampos() {
        txtName.setText(null);
        txtSalary.setText(null);
    }
}
