package com.example.muiska.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    public DatabaseOpenHelper(@Nullable Context context) {
        super(context, UtilitiesDatabase.DATABASE_NAME, null, UtilitiesDatabase.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UtilitiesDatabase.Tabla_Estacion.CREATE_TABLE_ESTACION);
        db.execSQL(UtilitiesDatabase.Tabla_Narracion.CREATE_TABLE_NARRACION);
        db.execSQL(UtilitiesDatabase.Tabla_Usuario.CREATE_TABLE_USUARIO);
        db.execSQL(UtilitiesDatabase.Tabla_Respuesta.CREATE_TABLE_RESPUESTA);
        db.execSQL(UtilitiesDatabase.Tabla_Pregunta.CREATE_TABLE_PREGUNTA);
        db.execSQL(UtilitiesDatabase.Tabla_Respuesta_Pregunta.CREATE_TABLE_RESPUESTA_PREGUNTA);
        /* insert*/
        this.insertEstacion(db,"Costumbres y modos de vida");
        this.insertNarracion(db,(
                "Los muiscas, eran grandes agricultores, cuidan la tierra y el agua como regalos que les habían dado los dioses."
                +"\n" +"Donde vivían hacía mucho,  y eso les ayudaba a poder cultivar frijoles, tomates, papas, yucas, guayabas y muchas frutas deliciosas, pero lo que más les gusta era la Maiz, porque pensaban que era el alimentos de los Dioses." +
                        "\n" +  "Por el frio que hacia, los muiscas vestían con  ropa larga, y gorros, pero no como la que tu y yo usamos, ellos utilizaban túnicas hechas en algodon, esas túnicas eran como una sábana blanca con decoraciones muuy lindas, que cubrian su cuerpo, y en momentos de celebraciones como festivales, se ponian  aretes,  coronas, pulseras, hechas de oro, y esmeraldas. y un instrumento  musical muy  utilizado es el SIKU un instrumentos de viento como la hecho de caña, que suena muy bonito. \n" +
                        "\n" +"Ellos eran muy inteligentes, entonces se dieron cuenta que algunas veces ellos tenían mucha comida o animales que no iban a utilizar, entonces hablan con otra persona y le decían, yo te doy tres tomates y tu me das  2 manzanas, a esto se le llama TRUEQUE, esta era la manera en que ellos comercializaban. \n"),
                1);
        this.insertPregunta(db,"¿Cual es el alimento sagrado de los muiscas?",1);
        this.insertRespuesta(db,"Papas",1,0);
        this.insertRespuesta(db,"Yuca",1,0);
        this.insertRespuesta(db,"Maiz",1,1);
        this.insertRespuesta(db,"Bananos",1,0);

    }

    /*Funciona como hashtable {'clave': valor}.
    * Estructura de Inserts:
    */

    public void insertEstacion(SQLiteDatabase db,String nombre_estacion ){
        ContentValues valores = new ContentValues();
        valores.put(UtilitiesDatabase.Tabla_Estacion.NOMBRE_ESTACION,nombre_estacion);
        db.insert(UtilitiesDatabase.Tabla_Estacion.TABLE_NAME,null,valores);
    }
    public void insertUsuario(SQLiteDatabase db,String nombre_usuario, String nickname ){
        ContentValues valores = new ContentValues();
        valores.put(UtilitiesDatabase.Tabla_Usuario.NOMBRE_USUARIO,nombre_usuario);
        valores.put(UtilitiesDatabase.Tabla_Usuario.NICK_NAME,nickname);
        db.insert(UtilitiesDatabase.Tabla_Usuario.TABLE_NAME,null,valores);
    }
    public void insertNarracion(SQLiteDatabase db,String enunciado, int id_estacion){
        ContentValues valores = new ContentValues();
        valores.put(UtilitiesDatabase.Tabla_Narracion.ENUNCIADO,enunciado);
        valores.put(UtilitiesDatabase.Tabla_Narracion.ID_ESTACION,id_estacion);
        db.insert(UtilitiesDatabase.Tabla_Narracion.TABLE_NAME,null,valores);
    }
    public void insertPregunta(SQLiteDatabase db, String enunciado,int id_narracion){
        ContentValues valores = new ContentValues();
        valores.put(UtilitiesDatabase.Tabla_Pregunta.ENUNCIADO,enunciado);
        valores.put(UtilitiesDatabase.Tabla_Pregunta.ID_NARRACION,id_narracion);
        db.insert(UtilitiesDatabase.Tabla_Pregunta.TABLE_NAME,null,valores);
    }
    public void insertRespuesta(SQLiteDatabase db,String enunciado,int id_pregunta, int correcta ){
        ContentValues valores = new ContentValues();
        valores.put(UtilitiesDatabase.Tabla_Respuesta.ENUNCIADO,enunciado);
        valores.put(UtilitiesDatabase.Tabla_Respuesta.ID_PREGUNTA,id_pregunta);
        valores.put(UtilitiesDatabase.Tabla_Respuesta.CORRECTA,correcta);
        db.insert(UtilitiesDatabase.Tabla_Respuesta.TABLE_NAME,null,valores);
    }
    public void insertRespuestaPreguntas(SQLiteDatabase db,int id_pregunta,int id_respuesta,int id_usuario, int id_estacion,int respuesta_valida ){
        ContentValues valores = new ContentValues();
        valores.put(UtilitiesDatabase.Tabla_Respuesta_Pregunta.ID_PREGUNTA,id_pregunta);
        valores.put(UtilitiesDatabase.Tabla_Respuesta_Pregunta.ID_RESPUESTA,id_respuesta);
        valores.put(UtilitiesDatabase.Tabla_Respuesta_Pregunta.ID_USUARIO,id_usuario);
        valores.put(UtilitiesDatabase.Tabla_Respuesta_Pregunta.ID_ESTACION,id_estacion);
        valores.put(UtilitiesDatabase.Tabla_Respuesta_Pregunta.RESPUESTA_VALIDA,respuesta_valida);
        db.insert(UtilitiesDatabase.Tabla_Respuesta_Pregunta.TABLE_NAME,null,valores);
    }

    /*
     * Fin de Estructura de Inserts
     */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + UtilitiesDatabase.Tabla_Estacion.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + UtilitiesDatabase.Tabla_Usuario.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + UtilitiesDatabase.Tabla_Respuesta.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + UtilitiesDatabase.Tabla_Pregunta.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + UtilitiesDatabase.Tabla_Respuesta_Pregunta.TABLE_NAME);
        this.onCreate(db);
    }
}
