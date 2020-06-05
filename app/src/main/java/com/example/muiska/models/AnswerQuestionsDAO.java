package com.example.muiska.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class AnswerQuestionsDAO {
    private DatabaseOpenHelper databaseOpenHelper;
    private SQLiteDatabase db;

    public  AnswerQuestionsDAO(Context context){
        databaseOpenHelper = new DatabaseOpenHelper(context);
        db = databaseOpenHelper.getWritableDatabase();
    }
    public void insertResult(String nickname, int puntaje,int idStation){
        databaseOpenHelper.insertRespuestaPreguntas(databaseOpenHelper.getWritableDatabase(),nickname,puntaje,idStation);
    }
    public ArrayList<ArrayList<String>> getRanking(){
        ArrayList<ArrayList<String>> row = new ArrayList<>();
        ArrayList<String> data = new ArrayList<String>();
        Cursor cursor = db.rawQuery("SELECT A."+ UtilitiesDatabase.Tabla_Respuesta_Pregunta.NICKNAME + ", B."+
                UtilitiesDatabase.Tabla_Usuario.EDAD + ", SUM("+ UtilitiesDatabase.Tabla_Respuesta_Pregunta.RESPUESTAS_VALIDAS+")"
                +" FROM "+ UtilitiesDatabase.Tabla_Respuesta_Pregunta.TABLE_NAME + " as A"
                + " INNER JOIN " + UtilitiesDatabase.Tabla_Usuario.TABLE_NAME + " as B ON A.nickname = B.nick_name"
                + " GROUP BY A." +UtilitiesDatabase.Tabla_Respuesta_Pregunta.NICKNAME ,null);
        if (cursor.moveToFirst()){
            do {
                data.add(cursor.getString(0));
                data.add(cursor.getString(1));
                data.add(cursor.getString(2));
                row.add(data);
                data = new ArrayList<String>();
            }
            while (cursor.moveToNext());
        }
        db.close();
        return  row;
    }
}
