package com.example.mibasededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
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
    EditText txtClave, txtName, txtSalary;
    ConexionSQLiteHelper con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_empleado);

        btnB = (Button) findViewById(R.id.btnBuscar);
        txtClave = (EditText) findViewById(R.id.txtClave);
        txtName = (EditText) findViewById(R.id.txtNombre);
        txtSalary = (EditText) findViewById(R.id.txtSueldo);

        //Declarar el objeto conexion
        con = new ConexionSQLiteHelper(this, "bdEmpleados", null, 1);
    }

    /**
     * Metodo para identificar que el boton ha sido pulsado
     */
    public void onClick(View vista) {
        switch (vista.getId()) {
            case R.id.btnBuscar:
                this.consultarEmpleado();
                break;
            case R.id.btnCambiar:
                this.cambiarEmpleado();
                break;
            case R.id.btnEliminar:
                this.eliminarEmpleado();
                break;
        }
    }

    /**
     * Metodo para eliminar registros en la tabla empleado
     */
    private void eliminarEmpleado() {
        //Crear el objeto conexion
        SQLiteDatabase db = con.getWritableDatabase();
        String [] parametros = {txtClave.getText().toString()};
        db.delete(Utilidades.TABLA_EMPLEADOS, Utilidades.CAMPO_CLAVE+"=?", parametros);
        Toast.makeText(this, "Empleado borrado...", Toast.LENGTH_SHORT).show();
        db.close();
        this.limpiarCampos();
    }

    /**
     * Metdo para cambiar el registro del empleado
     */
    private void cambiarEmpleado() {
        SQLiteDatabase db = con.getWritableDatabase();
        String [] parametros = {txtClave.getText().toString()};
        //Creamos objeto contentValues para almacenar nombre y sueldo
        ContentValues content = new ContentValues();
        content.put(Utilidades.CAMPO_NOMBRE, txtName.getText().toString());
        content.put(Utilidades.CAMPO_SUELDO, txtSalary.getText().toString());

        db.update(Utilidades.TABLA_EMPLEADOS, content, Utilidades.CAMPO_CLAVE+"=?", parametros);
        Toast.makeText(this, "Empleado actualizado...", Toast.LENGTH_SHORT).show();
        db.close();
        this.limpiarCampos();
    }


    /**
     * Metodo para buscar un empleado en la tabla empleados
     */
    public void consultarEmpleado() {
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
        txtClave.setText(null);
        txtName.setText(null);
        txtSalary.setText(null);
    }
}
