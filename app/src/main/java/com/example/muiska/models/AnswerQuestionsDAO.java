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
    public ArrayList<String> getRanking(){
        ArrayList<String> user = new ArrayList<String>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ UtilitiesDatabase.Tabla_Respuesta_Pregunta.TABLE_NAME,null);
        if (cursor.moveToFirst()){
            user.add(cursor.getString(0));
            while (cursor.moveToNext()){
                user.add(cursor.getString(0));
            }
        }
        db.close();
        return  user;
    }
}
