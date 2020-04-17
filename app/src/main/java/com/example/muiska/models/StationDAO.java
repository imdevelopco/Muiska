package com.example.muiska.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class StationDAO {
    private DatabaseOpenHelper databaseOpenHelper;
    private SQLiteDatabase db;

    public  StationDAO(Context context){
        databaseOpenHelper = new DatabaseOpenHelper(context);
        db = databaseOpenHelper.getWritableDatabase();
    }


    public ArrayList<String> getStation(int id){
        ArrayList<String> estacion = new ArrayList<String>();
        String[] ID = new String[]{String.valueOf(id)};
        Cursor cursor = db.rawQuery("SELECT " + UtilitiesDatabase.Tabla_Estacion.NOMBRE_ESTACION + " FROM "+
                UtilitiesDatabase.Tabla_Estacion.TABLE_NAME + " WHERE id = ?", ID);
        if (cursor.moveToFirst()){
            estacion.add(cursor.getString(0));
        }
        db.close();
        return  estacion;
    }
}
