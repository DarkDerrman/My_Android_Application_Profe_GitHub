package com.example.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.Contactos;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {
    Context context;
    public DataBase(@Nullable Context context) {
        super(context, "ContactoDB", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE Contactos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT," +
                "direccion TEXT," +
                "correo TEXT );";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP IF EXISTE Contactos");
    }

    public ArrayList<Contactos> obtenerContactos(){
        String query = "SELECT * FROM Contactos";
        ArrayList<Contactos> listaContactos = new ArrayList<Contactos>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        while (registros.moveToNext()){
            Contactos contactoTemp = new Contactos();
            contactoTemp.setId(registros.getInt(0));
            contactoTemp.setNombre(registros.getString(1));
            contactoTemp.setDireccion(registros.getString(2));
            contactoTemp.setCorreo(registros.getString(3));
            listaContactos.add(contactoTemp);
        }
        db.close();
        return listaContactos;
    }

    public void agregarContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("Contactos", null, contentValues);
        db.close();
    }
}
