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

    public ArrayList<String> getAnswers(int id_pregunta){
        ArrayList<String> respuestas = new ArrayList<String>();
        Cursor cursor = db.rawQuery("SELECT " + UtilitiesDatabase.Tabla_Respuesta.ENUNCIADO
                + " FROM " + UtilitiesDatabase.Tabla_Respuesta.TABLE_NAME +
                " WHERE id_pregunta = ?",new String [] {String.valueOf(id_pregunta)} );
        cursor.moveToFirst();
        respuestas.add(cursor.getString(0));
        while(cursor.moveToNext()){
            // Siempre son 4 respuestas por pregunta
            respuestas.add(cursor.getString(0));
        }
        db.close();
        return respuestas;
    }
}
