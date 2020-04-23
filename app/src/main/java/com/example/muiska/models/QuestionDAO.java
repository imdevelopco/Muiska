package com.example.muiska.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class QuestionDAO {

    private DatabaseOpenHelper databaseOpenHelper;
    private SQLiteDatabase db;

    public QuestionDAO(Context context){
        databaseOpenHelper = new DatabaseOpenHelper(context);
        db = databaseOpenHelper.getWritableDatabase();
    }

    public ArrayList<String> getQuestion(int id_narracion,int id_pregunta){
        ArrayList<String> pregunta = new ArrayList<String>();
        Cursor cursor = db.rawQuery("SELECT " +
                UtilitiesDatabase.Tabla_Pregunta.ENUNCIADO + " FROM " + UtilitiesDatabase.Tabla_Pregunta.TABLE_NAME +
                " WHERE id_narracion = ? AND id = ?",new String [] {String.valueOf(id_narracion),String.valueOf(id_pregunta)} );
        if(cursor.moveToFirst()){
            pregunta.add(cursor.getString(0));
        }
        db.close();
        return pregunta;
    }
}
