package com.example.muiska.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class UserDAO {
    private DatabaseOpenHelper databaseOpenHelper;
    private SQLiteDatabase db;

    public  UserDAO(Context context){
        databaseOpenHelper = new DatabaseOpenHelper(context);
        db = databaseOpenHelper.getWritableDatabase();
    }

    public void insertUser(String nickname, String edad){
        databaseOpenHelper.insertUsuario(databaseOpenHelper.getWritableDatabase(),nickname,edad);
    }

    public ArrayList<String> getUsers(){
        ArrayList<String> user = new ArrayList<String>();
        Cursor cursor = db.rawQuery("SELECT " + UtilitiesDatabase.Tabla_Usuario.NICK_NAME
                + " FROM "+ UtilitiesDatabase.Tabla_Usuario.TABLE_NAME + " LIMIT ?",new String[]{"5"});
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
