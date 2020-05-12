package com.example.mibasededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mibasededatos.utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    //Constructor
    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Permite crear la tabla en el servidor, se invoca cuando instanciamos el servidor
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creamos tabla por primera vez
        db.execSQL(Utilidades.CREARTABLA_EMPLEADOS);
    }

    //Se invoca cuando hacemos un cambio de version de la tabla
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ Utilidades.TABLA_EMPLEADOS);
        //Invocamos metodo onCreate
        this.onCreate(db);
    }
}
