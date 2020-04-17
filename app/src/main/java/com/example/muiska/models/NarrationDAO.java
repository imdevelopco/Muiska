package com.example.muiska.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NarrationDAO {
    private DatabaseOpenHelper databaseOpenHelper;
    private SQLiteDatabase db;


    public NarrationDAO(Context context){
        databaseOpenHelper = new DatabaseOpenHelper(context);
        db = databaseOpenHelper.getWritableDatabase();

    }

    public ArrayList<String> getNarration(int id_estacion){
        ArrayList<String> narracion = new ArrayList<String>();
        String[] ID_ESTACION = new String[]{String.valueOf(id_estacion)};
        Cursor cursor = db.rawQuery("SELECT " + UtilitiesDatabase.Tabla_Narracion.ENUNCIADO + " FROM " + UtilitiesDatabase.Tabla_Narracion.TABLE_NAME +
                                        " WHERE id_estacion = ? ",ID_ESTACION);
        if(cursor.moveToFirst()){
                narracion.add(cursor.getString(0));
        }
        db.close();
        return narracion;
    }

}
