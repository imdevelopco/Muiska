package com.example.muiska.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class AnswerDAO {
    private DatabaseOpenHelper databaseOpenHelper;
    private SQLiteDatabase db;

    public AnswerDAO(Context context){
        databaseOpenHelper = new DatabaseOpenHelper(context);
        db = databaseOpenHelper.getWritableDatabase();
    }

    public ArrayList<ArrayList<String>> getAnswers(int id_pregunta){

        ArrayList<ArrayList<String>> respuestas = new ArrayList<>();
        ArrayList<String> respuesta = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT " + UtilitiesDatabase.Tabla_Respuesta.ENUNCIADO + "," + UtilitiesDatabase.Tabla_Respuesta.CORRECTA
                + " FROM " + UtilitiesDatabase.Tabla_Respuesta.TABLE_NAME +
                " WHERE id_pregunta = ?",new String [] {String.valueOf(id_pregunta)} );

        if (cursor.moveToFirst()) {
            do {
                respuesta.add(cursor.getString(0));
                respuesta.add(cursor.getString(1));
                respuestas.add(respuesta);
                respuesta = new ArrayList<>();
            } while (cursor.moveToNext());
        }
        db.close();
        return respuestas;
    }
}
