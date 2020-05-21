package com.example.mibasededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mibasededatos.basededatos.Empleados;
import com.example.mibasededatos.utilidades.Utilidades;

import java.util.ArrayList;

public class ConsultarListViewEmpleado extends AppCompatActivity {

    ConexionSQLiteHelper con;

    ListView lv;
    ArrayList<String> listaInformacion;
    ArrayList<Empleados> listaEmpleados;
    ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_list_view_empleado);

        //Igualar componentes
        lv = (ListView) findViewById(R.id.listview);

        //Declarar el objeto conexion
        con = new ConexionSQLiteHelper(this, "bdEmpleados", null, 1);
        this.consultarEmpleado();

        //Declarar un arrayadapter para un listview

        final ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaInformacion);
        lv.setAdapter(adaptador);
    }

    private void consultarEmpleado() {
        //Declaramos objeto tipo base de datos
        SQLiteDatabase db = con.getReadableDatabase();
        Empleados emp = null;
        //Instanciamos un arraylist de tipo objetos Empleados
        listaEmpleados = new ArrayList<Empleados>();
        //Declara la cadena sql
        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_EMPLEADOS, null);
        //Ciclo de lectura para registros y carga los datos en un tipo cursor
        while (cursor.moveToNext()) {
            //Creamos un objeto tipo Empleados
            emp = new Empleados();
            emp.setClave(cursor.getInt(0));
            emp.setNombre(cursor.getString(1));
            emp.setSueldo(cursor.getFloat(2));

            listaEmpleados.add(emp);
        }

        //Llamar a un metodo obtenerLista
        this.obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion = new ArrayList<String>();
        //Llenar lista informacion con los datos
        for (int i = 0; i < listaEmpleados.size(); i++) {
            listaInformacion.add(listaEmpleados.get(i).getClave()+ " "+ listaEmpleados.get(i).getNombre()+ " "+ listaEmpleados.get(i).getSueldo());
        }
    }
}
