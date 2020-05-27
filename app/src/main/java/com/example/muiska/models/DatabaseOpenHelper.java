package com.example.muiska.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.security.PublicKey;

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
        /* inserts*/
        /*Inicio Estacion # 1*/
        this.insertEstacion(db,"Costumbres y modos de vida");
        this.insertNarracion(db,(
                        "Los muiscas,  eran grandes agricultores, cuidan la tierra y el agua como regalos que les habían dado los dioses. En la ubicación dónde vivían hacía mucho frío, y eso les ayudaba a poder cultivar frijoles, tomates, papas, yucas, guayabas y muchas frutas deliciosas, pero lo que más les gusta era el maíz, porque pensaban que era el alimentos de los Dioses. \n" +
                        "Por el frio que hacía, los muiscas vestían con  ropa larga, y gorros, pero no como la que tu y yo usamos, ellos utilizaban túnicas hechas en algodon, esas túnicas eran como una sábana blanca con decoraciones muy lindas, que cubrían su cuerpo, y en momentos de celebraciones como festivales, se ponían  aretes,  coronas, pulseras hechas de oro, y esmeraldas, y un instrumento  musical muy  utilizado es el siku, un instrumentos de viento hecho de caña, que suena muy bonito. \n" +
                         "Ellos eran muy inteligentes, entonces se dieron cuenta que algunas veces ellos tenían mucha comida o animales que no iban a utilizar, entonces hablan con otras personas y les ofrecían un intercambio, a esto se le llama trueque, esta era la manera en que ellos comercializaban, porque daban una parte de lo que les sobraba por algo que necesitaban, ejemplo, tu tienes 5 bombones pero quieres un paquete de galletas, entonces le ofreces a un amigo 2 bombones por ese paquete de galletas, eso es un trueque. \n"
                        ),
                1);
        this.insertPregunta(db,"¿Cual es el alimento sagrado de los muiscas?",1);
        this.insertRespuesta(db,"Papas",1,0);
        this.insertRespuesta(db,"Yuca",1,0);
        this.insertRespuesta(db,"Maíz",1,1);
        this.insertRespuesta(db,"Bananos",1,0);
        this.insertPregunta(db,"¿Cómo se llama la forma en que los Muiscas intercambian comida o animales  con otras personas?",1);
        this.insertRespuesta(db,"Trueque",2,1);
        this.insertRespuesta(db,"Compra",2,0);
        this.insertRespuesta(db,"Venta",2,0);
        this.insertRespuesta(db,"Préstamo",2,0);
        this.insertPregunta(db,"Señale verdadero o falso: ¿Los muiscas se vestían con ropa larga, y gorros, normalmente de algodón para cubrirse del frío?",1);
        this.insertRespuesta(db,"Verdadero",3,1);
        this.insertRespuesta(db,"Falso",3,0);
        this.insertPregunta(db,"¿Cómo se llamaba el instrumento musica que usaban los muiscas en las fiestas?",1);
        this.insertRespuesta(db,"Siku",4,1);
        this.insertRespuesta(db,"Flauta",4,0);
        this.insertRespuesta(db,"Arpa",4,0);
        this.insertRespuesta(db,"Oboe",4,0);
        this.insertPregunta(db,"¿Qué cultivaban los muiscas  para alimentarse?",1);
        this.insertRespuesta(db,"Frijol, papas, yucas, frutas",5,1);
        this.insertRespuesta(db,"Zanahorias, lechuga,  frutas",5,0);
        this.insertRespuesta(db,"Peces, ganado y frijoles",5,0);
        this.insertRespuesta(db,"Chontaduro, Borojo y Mandarinas",5,0);
        /*Fin Estacion # 1*/

    }

    /*Funciona como hashtable {'clave': valor}.
    * Estructura de Inserts:
    */

    public void insertEstacion(SQLiteDatabase db,String nombre_estacion ){
        ContentValues valores = new ContentValues();
        valores.put(UtilitiesDatabase.Tabla_Estacion.NOMBRE_ESTACION,nombre_estacion);
        db.insert(UtilitiesDatabase.Tabla_Estacion.TABLE_NAME,null,valores);
    }
    public void insertUsuario(SQLiteDatabase db, String nickname, String edad ){
        ContentValues valores = new ContentValues();
        valores.put(UtilitiesDatabase.Tabla_Usuario.NICK_NAME,nickname);
        valores.put(UtilitiesDatabase.Tabla_Usuario.EDAD,edad);
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
        valores.put(UtilitiesDatabase.Tabla_Respuesta_Pregunta.ID_ESTACION,id_estacion);
        valores.put(UtilitiesDatabase.Tabla_Respuesta_Pregunta.RESPUESTAS_VALIDAS,respuesta_valida);
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
