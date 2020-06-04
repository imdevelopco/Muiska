package com.example.muiska.models;

public class UtilitiesDatabase {

    static public String DATABASE_NAME = "Muiska";
    static final String INTEGER = " INTEGER ";
    static final String NOT_NULL = " NOT_NULL ";
    static final String PRIMARY_KEY = " PRIMARY KEY AUTOINCREMENT";
    static final String TEXT  = " TEXT ";
    static final String CREATE_TABLE  = "CREATE TABLE ";
    static final String FOREIGN_KEY = " FOREIGN KEY (";
    static final String REFERENCES = " ) REFERENCES ";
    static final String ID = "id";
    static final int VERSION = 1;

    public class Tabla_Usuario{

        static final  String TABLE_NAME = "usuario";
        static final  String EDAD = "edad";
        static final  String NICK_NAME = "nick_name";
        static final  String CREATE_TABLE_USUARIO = CREATE_TABLE + TABLE_NAME + " ("
                                                    + ID + INTEGER + PRIMARY_KEY + ","
                                                    + EDAD + INTEGER + NOT_NULL + ","
                                                    + NICK_NAME + TEXT + NOT_NULL +" UNIQUE );";
    }

    public class Tabla_Estacion{
        static final  String TABLE_NAME = "estacion";
        static final  String NOMBRE_ESTACION = "nombre_estacion";
        static final  String CREATE_TABLE_ESTACION = CREATE_TABLE + TABLE_NAME +
                                                    "(" + ID + INTEGER + PRIMARY_KEY + ","
                                                    + NOMBRE_ESTACION + TEXT + NOT_NULL + ");";
    }

    public class Tabla_Narracion{
        static final  String TABLE_NAME = "narracion";
        static final  String ENUNCIADO = "enunciado";
        static final  String ID_ESTACION = "id_estacion";
        static final  String CREATE_TABLE_NARRACION = CREATE_TABLE + TABLE_NAME +"("
                                                    + ID + INTEGER + PRIMARY_KEY + ","
                                                    + ENUNCIADO + TEXT + NOT_NULL + ","
                                                    + ID_ESTACION + INTEGER + NOT_NULL + ","
                                                    + FOREIGN_KEY + ID_ESTACION + REFERENCES +
                                                    Tabla_Estacion.TABLE_NAME + "(" + ID + "));";
    }

    public class Tabla_Pregunta{
        static final  String TABLE_NAME = "pregunta";
        static final  String ENUNCIADO = "enunciado";
        static final  String ID_NARRACION = "id_narracion";
        static final  String CREATE_TABLE_PREGUNTA =  CREATE_TABLE + TABLE_NAME + "("
                                                    + ID + INTEGER + PRIMARY_KEY + ","
                                                    + ENUNCIADO + TEXT + NOT_NULL + ","
                                                    + ID_NARRACION + INTEGER + NOT_NULL + "," +
                                                    FOREIGN_KEY + ID_NARRACION + REFERENCES +
                                                    Tabla_Narracion.TABLE_NAME + "(" + ID +"));";
    }

    public class Tabla_Respuesta{
        static final  String TABLE_NAME = "respuesta";
        static final  String ENUNCIADO = "enunciado";
        static final  String ID_PREGUNTA= "id_pregunta";
        static final  String CORRECTA= "correcta";
        static final  String CREATE_TABLE_RESPUESTA = CREATE_TABLE + TABLE_NAME + "("
                                                    + ID + INTEGER + PRIMARY_KEY + ","
                                                    + ENUNCIADO + TEXT + NOT_NULL + ","
                                                    + ID_PREGUNTA + INTEGER + NOT_NULL + ","
                                                    + CORRECTA + INTEGER + NOT_NULL + ","
                                                    + FOREIGN_KEY + ID_PREGUNTA + REFERENCES
                                                    + Tabla_Pregunta.TABLE_NAME + "("+ ID +"));";
    }

    public class Tabla_Respuesta_Pregunta{
        static final  String TABLE_NAME = "respuesta_pregunta";
        static final  String ID_ESTACION="id_estacion";
        static final  String NICKNAME="nickname";
        static final  String RESPUESTAS_VALIDAS ="respuestas_validas";
        static final  String CREATE_TABLE_RESPUESTA_PREGUNTA    = CREATE_TABLE + TABLE_NAME + "("
                                                                + ID_ESTACION + INTEGER + NOT_NULL + ","
                                                                + RESPUESTAS_VALIDAS + INTEGER + NOT_NULL + ","
                                                                + NICKNAME + TEXT + NOT_NULL + ","
                                                                + FOREIGN_KEY + ID_ESTACION + REFERENCES
                                                                + Tabla_Estacion.TABLE_NAME + "(" + ID + "));";
    }
}
