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

        /*Inicio Estacion # 1*/
        this.insertEstacion(db,"Ubicación geográfica y estructura político-administrativa");
        this.insertNarracion(db,(
                        "Mensaje de prueba, porque la narracion es muy larga y pues ajam."
                ),
                1);
        this.insertPregunta(db,"¿Hace cuántos años vivió la cultura Muisca?",1);
        this.insertRespuesta(db,"1500 años",1,1);
        this.insertRespuesta(db,"200 años",1,0);
        this.insertRespuesta(db,"3100 años",1,0);
        this.insertRespuesta(db,"30 años",1,0);
        this.insertPregunta(db,"¿En qué parte del departamento de santander vivía la tribu?",1);
        this.insertRespuesta(db,"Norte",2,0);
        this.insertRespuesta(db,"Sur",2,1);
        this.insertRespuesta(db,"Este",2,0);
        this.insertRespuesta(db,"Oeste",2,0);
        this.insertPregunta(db,"El clima donde habitaban los muiscas era:",1);
        this.insertRespuesta(db,"Templado",3,0);
        this.insertRespuesta(db,"Caluroso",3,0);
        this.insertRespuesta(db,"Frío",3,1);
        this.insertRespuesta(db,"Tropical",3,0);
        this.insertPregunta(db,"¿Quién era considerado el jefe de la tribu?",1);
        this.insertRespuesta(db,"El Cacique",4,0);
        this.insertRespuesta(db,"El Zipa",4,1);
        this.insertRespuesta(db,"El Sacerdote",4,0);
        this.insertRespuesta(db,"Los Güechas",4,0);
        this.insertPregunta(db,"¿Qué era más lo importante para ellos?",1);
        this.insertRespuesta(db,"Los animales",5,0);
        this.insertRespuesta(db,"El sol",5,0);
        this.insertRespuesta(db,"El agua",5,0);
        this.insertRespuesta(db,"Todas las anteriores",5,1);
        /*Fin Estacion # 1*/


        /* inserts*/
        /*Inicio Estacion # 2*/
        this.insertEstacion(db,"Costumbres y modos de vida");
        this.insertNarracion(db,(
                        "Los muiscas,  eran grandes agricultores, cuidan la tierra y el agua como regalos que les habían dado los dioses. En la ubicación dónde vivían hacía mucho frío, y eso les ayudaba a poder cultivar frijoles, tomates, papas, yucas, guayabas y muchas frutas deliciosas, pero lo que más les gusta era el maíz, porque pensaban que era el alimentos de los Dioses. \n" +
                                "Por el frio que hacía, los muiscas vestían con  ropa larga, y gorros, pero no como la que tu y yo usamos, ellos utilizaban túnicas hechas en algodon, esas túnicas eran como una sábana blanca con decoraciones muy lindas, que cubrían su cuerpo, y en momentos de celebraciones como festivales, se ponían  aretes,  coronas, pulseras hechas de oro, y esmeraldas, y un instrumento  musical muy  utilizado es el siku, un instrumentos de viento hecho de caña, que suena muy bonito. \n" +
                                "Ellos eran muy inteligentes, entonces se dieron cuenta que algunas veces ellos tenían mucha comida o animales que no iban a utilizar, entonces hablan con otras personas y les ofrecían un intercambio, a esto se le llama trueque, esta era la manera en que ellos comercializaban, porque daban una parte de lo que les sobraba por algo que necesitaban, ejemplo, tu tienes 5 bombones pero quieres un paquete de galletas, entonces le ofreces a un amigo 2 bombones por ese paquete de galletas, eso es un trueque. \n"
                ),
                2);
        this.insertPregunta(db,"¿Cual es el alimento sagrado de los muiscas?",2);
        this.insertRespuesta(db,"Papas",6,0);
        this.insertRespuesta(db,"Yuca",6,0);
        this.insertRespuesta(db,"Maíz",6,1);
        this.insertRespuesta(db,"Bananos",6,0);
        this.insertPregunta(db,"¿Cómo se llama la forma en que los Muiscas intercambian comida o animales  con otras personas?",2);
        this.insertRespuesta(db,"Trueque",7,1);
        this.insertRespuesta(db,"Compra",7,0);
        this.insertRespuesta(db,"Venta",7,0);
        this.insertRespuesta(db,"Préstamo",7,0);
        this.insertPregunta(db,"Señale verdadero o falso: ¿Los muiscas se vestían con ropa larga, y gorros, normalmente de algodón para cubrirse del frío?",2);
        this.insertRespuesta(db,"Verdadero",8,1);
        this.insertRespuesta(db,"Falso",8,0);
        this.insertPregunta(db,"¿Cómo se llamaba el instrumento musica que usaban los muiscas en las fiestas?",2);
        this.insertRespuesta(db,"Siku",9,1);
        this.insertRespuesta(db,"Flauta",9,0);
        this.insertRespuesta(db,"Arpa",9,0);
        this.insertRespuesta(db,"Oboe",9,0);
        this.insertPregunta(db,"¿Qué cultivaban los muiscas  para alimentarse?",2);
        this.insertRespuesta(db,"Frijol, papas, yucas, frutas",10,1);
        this.insertRespuesta(db,"Zanahorias, lechuga,  frutas",10,0);
        this.insertRespuesta(db,"Peces, ganado y frijoles",10,0);
        this.insertRespuesta(db,"Chontaduro, Borojo y Mandarinas",10,0);
        /*Fin Estacion # 2*/

        /* inserts*/
        /*Inicio Estacion # 3*/
        this.insertEstacion(db,"Mitología");
        this.insertNarracion(db,(
                        "En la cultura Muisca, sus creencias espirituales eran muy importantes porque eso definía la forma como ellos vivían, pensaban, y realizaban diferentes actividades en su vida, además. \n" +
                                "creían que los dioses eran sus padres. Para ellos, existían diferentes dioses femeninos y masculinos de donde ellos habían nacido y que les brindaban cada una de las cosas que podían disfrutar de la tierra, como el agua, la agricultura, el dia y la noche. Cada uno de estos dioses tenía un nombre diferente, y hoy los conocerás: El primero se llama SUE, es el dios sol, el que da la luz del dia, el segundo es CHIE la diosa de la luna, el complemento del dios sol. \n" +
                                "el tercero es SIE  la diosa del agua, una de las más importantes dentro de su cultura, el cuarto es CUCHAVIRA el dios de la agricultura, ellos creían que cuando él estaba feliz con ellos, las cosechas de frutas y verduras eran mucho más grande, el quinto es BACHUE la madre de la humanidad y por eso era una de las más respetadas de la cultura Muisca, además se dice que ella nació del agua y el sexto es la PACHAMAMA, la madre Tierra, el lugar sagrado donde ellos vivían, donde cultivan,  y crecieron como una cultura.  Y en modo de agradecimiento a los dioses, los muiscas les daban ofrendas hechas en oro. \n"
                ),
                3);
        this.insertPregunta(db,"¿Cuántos dioses principales tenían  los muiscas?",3);
        this.insertRespuesta(db,"5",11,0);
        this.insertRespuesta(db,"6",11,1);
        this.insertRespuesta(db,"4",11,0);
        this.insertRespuesta(db,"7",11,0);
        this.insertPregunta(db,"¿Cuál era el nombre de la madre de la humanidad según la mitología muisca?",3);
        this.insertRespuesta(db,"Bachue",12,1);
        this.insertRespuesta(db,"Chie",12,0);
        this.insertRespuesta(db,"Sue",12,0);
        this.insertRespuesta(db,"Cuchavira",12,0);
        this.insertPregunta(db,"¿Cómo se llamaba el dios del sol y de la luna ?",3);
        this.insertRespuesta(db,"Chaquen y Zipa",13,0);
        this.insertRespuesta(db,"Pachamama y Sie",13,0);
        this.insertRespuesta(db,"Sue y Chie",13,1);
        this.insertRespuesta(db,"Cacique y Zipa",13,0);
        this.insertPregunta(db,"En modo de agradecimiento, ¿Qué le daban los muiscas a los dioses?",3);
        this.insertRespuesta(db,"Ofrendas hechas en arcilla",14,0);
        this.insertRespuesta(db,"Ofrendas con comida",14,0);
        this.insertRespuesta(db,"Ofrendas hechas en oro",14,1);
        this.insertRespuesta(db,"Ofrendas con animales",14,0);
        this.insertPregunta(db,"¿Por qué los muiscas creían en los dioses?",3);
        this.insertRespuesta(db,"Les enseñaban a cuidar a los niños, y los animales",15,0);
        this.insertRespuesta(db,"Los cuidaban de los problemas climáticos",15,0);
        this.insertRespuesta(db,"Les daban sus alimentos",15,0);
        this.insertRespuesta(db,"Pensaban que eran sus padres",15,1);
        /*Fin Estacion # 3*/

        /* inserts*/
        /*Inicio Estacion # 4*/
        this.insertEstacion(db,"Lagunas");
        this.insertNarracion(db,(
                        "El agua es uno de los recursos más importantes para la vida, y los Muiscas sabían eso, ellos tienen 7 lagunas sagradas. En la mitología de los muiscas, las lagunas son muy importantes, porque ellos decían que de allí nacieron algunos de los dioses más. \n" +
                                "mportantes de su cultura como lo es la diosa Bachué, la madre de la humanidad el nombre de la laguna de donde nació es Iguaque, y esa es la primera laguna, la segunda la de Guatavita, la tercera la de Guasca, la cuarta la de Siecha, la quinta la de Teusacá, la sexta la de  Tota, y la séptima la de Ubaque. Dentro de estas lagunas se realizaron diferentes. \n" +
                                "rituales donde se tiraban piezas de oro con diferentes formas de personas, animales y  barcas, como modo de ofrenda a los dioses por todo lo bueno que les daban, y de eso nace la famoso leyenda del Dorado en la laguna de Guatavita, donde se han encontrado piezas de oro  representantes de la cultura muisca, además de las ofrendas de oro, también hacían rituales, y cantos.  Todas estas lagunas están ubicadas en el departamento de Cundinamarca. \n"
                ),
                4);
        this.insertPregunta(db,"¿Cuántas lagunas sagradas tenían los muiscas?",4);
        this.insertRespuesta(db,"5",12,0);
        this.insertRespuesta(db,"6",12,0);
        this.insertRespuesta(db,"4",12,0);
        this.insertRespuesta(db,"7",12,1);
        this.insertPregunta(db,"¿En dónde están ubicadas las lagunas?",4);
        this.insertRespuesta(db,"Cundinamarca",13,1);
        this.insertRespuesta(db,"Caqueta",13,0);
        this.insertRespuesta(db,"Putumayo",13,0);
        this.insertRespuesta(db,"Choco",13,0);
        this.insertPregunta(db,"¿Cuál es el nombre de la laguna donde nació la diosa Bachué?",4);
        this.insertRespuesta(db,"Iguaque",14,1);
        this.insertRespuesta(db,"Ubaque",14,0);
        this.insertRespuesta(db,"Tota",14,0);
        this.insertRespuesta(db,"Guatavita",14,0);
        this.insertPregunta(db,"¿En que laguna se dice que está el tesoro El dorado?",4);
        this.insertRespuesta(db,"Guatavita",15,1);
        this.insertRespuesta(db,"Guasca",15,0);
        this.insertRespuesta(db,"Teusacá",15,0);
        this.insertRespuesta(db,"Siecha",15,0);
        this.insertPregunta(db,"En las lagunas, además de ofrendas a los dioses ¿qué más se hacía?",4);
        this.insertRespuesta(db,"Pescar",16,0);
        this.insertRespuesta(db,"Nadar",16,0);
        this.insertRespuesta(db,"Cocinar para toda la comunidad",16,0);
        this.insertRespuesta(db,"Rituales y cantos",16,1);
        /*Fin Estacion # 4*/



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
