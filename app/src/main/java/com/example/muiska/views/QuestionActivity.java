package com.example.muiska.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.muiska.R;
import com.example.muiska.models.AnswerDAO;

import com.example.muiska.models.QuestionDAO;

import java.util.ArrayList;
import java.util.Collections;

import static android.content.Intent.EXTRA_TEXT;


public class QuestionActivity extends AppCompatActivity {

    private ArrayList<ArrayList<String>> respuestas;
    private AnswerController answerCtrlOne,answerCtrlTwo,answerCtrlThree,answerCtrlFour;
    private TextView tituloPreguntaTextView;
    private TextView answerOneTextView;
    private TextView answerTwoTextView;
    private TextView answerThreeTextView;
    private TextView answerFourTextView;
    private int preguntaActual, playAcierto, playError,preguntasCorrectas;
    private int[] questionStationOne = azar(1,5,5);
    private int[] questionStationTwo = azar(6,10,5);;
    private int[] questionStationThree = azar(11,15,5);;
    private int[] questionStationFour = azar(16,20,5);
    private SoundPool aciertoSound, errorSound;
    private ImageView imageAnswerOne,imageAnswerTwo, imageAnswerThree,imageAnswerFour;
    private String tituloEstacion,idEstacion, currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extra = getIntent().getExtras();
        tituloEstacion = extra.getString("EXTRA_TITLE_STATION");
        idEstacion = extra.getString("EXTRA_ID_STATION");
        currentUser = extra.getString("EXTRA_CURRENT_USER");
        setContentView(R.layout.activity_question);
        tituloPreguntaTextView  = (TextView) findViewById(R.id.titleQuestiontextView);
        answerOneTextView       = (TextView) findViewById(R.id.answerOnetextView);
        answerTwoTextView       = (TextView) findViewById(R.id.answerTwotextView);
        answerThreeTextView     = (TextView) findViewById(R.id.answerThreetextView);
        answerFourTextView      = (TextView) findViewById(R.id.answerFourtextView);

        /* Images*/
        imageAnswerOne          = (ImageView) findViewById(R.id.imageAnswer1);
        imageAnswerTwo          = (ImageView) findViewById(R.id.imageAnswer2);
        imageAnswerThree        = (ImageView) findViewById(R.id.imageAnswer3);
        imageAnswerFour         = (ImageView) findViewById(R.id.imageAnswer4);
        /* Carga de arhivos de sonido*/
        aciertoSound            = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
        playAcierto             = aciertoSound.load(this,R.raw.acierto,1);
        errorSound              = new SoundPool(1,AudioManager.STREAM_MUSIC,1);
        playError               = errorSound.load(this,R.raw.error,1);
        /* Inicializar componentes */
        setContentQuestion();
    }
    public void setContentQuestion(){
        /* Se toma el arreglo de pregutas*/
        int[] preguntas = arrayQuestions(Integer.parseInt(idEstacion));
        if(preguntaActual < preguntas.length){
            /* Question*/
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            QuestionDAO questionDAO= new QuestionDAO(getApplicationContext());
            AnswerDAO answerDAO= new AnswerDAO (getApplicationContext());
            CharSequence tituloPregunta = questionDAO.getQuestion(Integer.parseInt(idEstacion),preguntas[preguntaActual]).get(0);
            initAnswers(answerDAO, preguntas);
            /* set text content of TextViews */
            tituloPreguntaTextView.setText(tituloPregunta);
            tituloPreguntaTextView.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
            preguntaActual++;
        }else{
            /*Accion a ejecutar cuando termine las preguntas*/
            cambiarActivity();
        }
    }

    public int[] arrayQuestions(int idQuestion){
        switch (idQuestion){
            case 1:{
                return questionStationOne;
            }
            case 2:{
                return questionStationTwo;
            }
            case 3:{
                return questionStationThree;
            }
            case 4:{
                return questionStationFour;
            }
        }
        return  questionStationOne;
    }
    public void initAnswers(AnswerDAO answerDAO,int[] questions){
        /* Answer */
        respuestas = answerDAO.getAnswers(questions[preguntaActual]);
        for (int i=0; i<respuestas.size();i++){
            switch (i){
                case 0:
                    showAnwerOne(i);
                    break;
                case 1:
                    showAnwerTwo(i);
                    // en caso de que sea pregunta tipo verdadero o falso se ocultan las otras repsuestas
                    isTrueOrFalse(respuestas.size());
                    break;
                case 2:
                    showAnwerThree(i);
                    break;
                case 3:
                    showAnwerFour(i);
                    break;
            }
        }
    }
    public void showAnwerOne(int iterador){
        answerCtrlOne = new AnswerController(respuestas.get(iterador).get(0),Integer.parseInt(respuestas.get(iterador).get(1)));
        answerOneTextView.setText(answerCtrlOne.getEnunciado());
        answerOneTextView.setTextColor(Color.BLACK);
        imageAnswerOne.setVisibility(View.VISIBLE);
        imageAnswerOne.setImageResource(changeImage(answerCtrlOne.getEnunciado()));
    }
    public void showAnwerTwo(int iterador){
        answerCtrlTwo = new AnswerController(respuestas.get(iterador).get(0),Integer.parseInt(respuestas.get(iterador).get(1)));
        answerTwoTextView.setText(answerCtrlTwo.getEnunciado());
        answerTwoTextView.setTextColor(Color.BLACK);
        imageAnswerTwo.setVisibility(View.VISIBLE);
        imageAnswerTwo.setImageResource(changeImage(answerCtrlTwo.getEnunciado()));
    }
    public void isTrueOrFalse(int sizeAnswers){
        if(sizeAnswers == 2){
            answerThreeTextView.setText("");
            answerFourTextView.setText("");
            imageAnswerThree.setVisibility(View.INVISIBLE);
            imageAnswerFour.setVisibility(View.INVISIBLE);
        }
    }
    public void showAnwerThree(int iterador){
        answerCtrlThree = new AnswerController(respuestas.get(iterador).get(0),Integer.parseInt(respuestas.get(iterador).get(1)));
        answerThreeTextView.setText(answerCtrlThree.getEnunciado());
        answerThreeTextView.setTextColor(Color.BLACK);
        imageAnswerThree.setVisibility(View.VISIBLE);
        imageAnswerThree.setImageResource(changeImage(answerCtrlThree.getEnunciado()));
    }
    public void showAnwerFour(int iterador){
        answerCtrlFour = new AnswerController(respuestas.get(iterador).get(0),Integer.parseInt(respuestas.get(iterador).get(1)));
        answerFourTextView.setText(answerCtrlFour.getEnunciado());
        answerFourTextView.setTextColor(Color.BLACK);
        imageAnswerFour.setVisibility(View.VISIBLE);
        imageAnswerFour.setImageResource(changeImage(answerCtrlFour.getEnunciado()));
    }
    public void validateAnswerOne(View view) {
        if (answerCtrlOne.getRespuesta() == 1) {
            preguntasCorrectas++;
            answerOneTextView.setTextColor(Color.GREEN);
        } else {
            answerOneTextView.setTextColor(Color.RED);
        }

        feedbackAnswer(answerCtrlOne.getRespuesta());
        setContentQuestion();
    }
    public void validateAnswerTwo(View view) {
        if (answerCtrlTwo.getRespuesta() == 1) {
            preguntasCorrectas++;
            answerTwoTextView.setTextColor(Color.GREEN);
        } else {
            answerTwoTextView.setTextColor(Color.RED);
        }

        feedbackAnswer(answerCtrlTwo.getRespuesta());
        setContentQuestion();
    }
    public void validateAnswerThree(View view) {
        if (answerThreeTextView.getText().length() > 0) {
            if (answerCtrlThree.getRespuesta() == 1) {
                preguntasCorrectas++;
                answerThreeTextView.setTextColor(Color.GREEN);
            } else {
                answerThreeTextView.setTextColor(Color.RED);
            }

            feedbackAnswer(answerCtrlThree.getRespuesta());
            setContentQuestion();
        }
    }
    public void validateAnswerFour(View view) {
        if(answerFourTextView.getText().length() > 0){
            if(answerCtrlFour.getRespuesta() == 1 ){
                answerFourTextView.setTextColor(Color.GREEN);
                preguntasCorrectas++;
            }else{
                answerFourTextView.setTextColor(Color.RED);
            }
            feedbackAnswer(answerCtrlFour.getRespuesta());
            setContentQuestion();
        }
    }
    /* Metodo para generar preguntas de orden aleatorio */
    public int[] azar(int inicio,int fin,int tam) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = inicio; i <= fin; i++) {
            array.add(i);
        }
        Collections.shuffle(array);
        int [] numeros = new int[tam];
        for(int i = 0; i<numeros.length; i++){
            numeros[i]=array.get(i);
        }
        return numeros;
    }
    public int changeImage(CharSequence imageName){

        /*Inicio Estacion # 1*/
        if(imageName.equals("1500 años")){
            return R.drawable.s1p1_1500;
        }
        if(imageName.equals("200 años")){
            return R.drawable.s1p1_200;
        }
        if(imageName.equals("3100 años")){
            return R.drawable.s1p1_3100;
        }
        if(imageName.equals("30 años")){
            return R.drawable.s1p1_30;
        }
        if(imageName.equals("Norte")){
            return R.drawable.s1p2_norte;
        }
        if(imageName.equals("Sur")){
            return R.drawable.s1p2_sur;
        }
        if(imageName.equals("Este")){
            return R.drawable.s1p2_este;
        }
        if(imageName.equals("Oeste")){
            return R.drawable.s1p2_oeste;
        }
        if(imageName.equals("Templado")){
            return R.drawable.s1p3_templado;
        }
        if(imageName.equals("Caluroso")){
            return R.drawable.s1p3_caluroso;
        }
        if(imageName.equals("Frío")){
            return R.drawable.s1p3_frio;
        }
        if(imageName.equals("Tropical")){
            return R.drawable.s1p3_tropical;
        }
        if(imageName.equals("El Cacique")){
            return R.drawable.s1p4_cacique;
        }
        if(imageName.equals("El Zipa")){
            return R.drawable.s1p4_zipa;
        }
        if(imageName.equals("El Sacerdote")){
            return R.drawable.s1p4_sacerdote;
        }
        if(imageName.equals("Los Güechas")){
            return R.drawable.s1p4_guecha;
        }
        if(imageName.equals("Los animales")){
            return R.drawable.s1p5_animales;
        }
        if(imageName.equals("El sol")){
            return R.drawable.s1p5_sol;
        }
        if(imageName.equals("El agua")){
            return R.drawable.s1p5_agua;
        }
        if(imageName.equals("Todas las anteriores")){
            return R.drawable.s1p5_todas;
        }

        /*Inicio Estacion # 2*/
        if(imageName.equals("Papas")){
            return R.drawable.s2p1_papa;
        }
        if(imageName.equals("Yuca")){
            return R.drawable.s2p1_yuca;
        }
        if(imageName.equals("Maíz")){
            return R.drawable.s2p1_maiz;
        }
        if(imageName.equals("Bananos")){
            return R.drawable.s2p1_bananos;
        }
        if(imageName.equals("Trueque")){
            return R.drawable.s2p2_trueque;
        }
        if(imageName.equals("Compra")){
            return R.drawable.s2p2_compra;
        }
        if(imageName.equals("Venta")){
            return R.drawable.s2p2_venta;
        }
        if(imageName.equals("Préstamo")){
            return R.drawable.s2p2_prestamo;
        }
        if(imageName.equals("Verdadero")){
            return R.drawable.s2verdadero;
        }
        if(imageName.equals("Falso")){
            return R.drawable.s2falso;
        }
        if(imageName.equals("Siku")){
            return R.drawable.s2p3_siku;
        }
        if(imageName.equals("Flauta")){
            return R.drawable.s2p3_flauta;
        }
        if(imageName.equals("Arpa")){
            return R.drawable.s2p3_arpa;
        }
        if(imageName.equals("Oboe")){
            return R.drawable.s2p3_oboe;
        }
        if(imageName.equals("Frijol, papas, yucas, frutas")){
            return R.drawable.s2p4_1;
        }
        if(imageName.equals("Zanahorias, lechuga,  frutas")){
            return R.drawable.s2p4_2;
        }
        if(imageName.equals("Peces, ganado y frijoles")){
            return R.drawable.s2p4_3;
        }
        if(imageName.equals("Chontaduro, Borojo y Mandarinas")){
            return R.drawable.s2p4_4;
        }

        /*Inicio Estacion # 3*/
        if(imageName.equals("5")){
            return R.drawable.s3p1_5;
        }
        if(imageName.equals("4")){
            return R.drawable.s3p1_4;
        }
        if(imageName.equals("6")){
            return R.drawable.s3p1_6;
        }
        if(imageName.equals("7")){
            return R.drawable.s3p1_7;
        }
        if(imageName.equals("Bachue")){
            return R.drawable.s3p2_bachue;
        }
        if(imageName.equals("Chie")){
            return R.drawable.s3p2_chie;
        }
        if(imageName.equals("Sue")){
            return R.drawable.s3p2_sue;
        }
        if(imageName.equals("Cuchavira")){
            return R.drawable.s3p2_cuchavira;
        }
        if(imageName.equals("Chaquen y Zipa")){
            return R.drawable.s3p3_chaquenzipa;
        }
        if(imageName.equals("Pachamama y Sie")){
            return R.drawable.s3p3_pachamamasie;
        }
        if(imageName.equals("Sue y Chie")){
            return R.drawable.s3p3_suechie;
        }
        if(imageName.equals("Cacique y Zipa")){
            return R.drawable.s3p3_caciquezipa;
        }
        if(imageName.equals("Ofrendas hechas en arcilla")){
            return R.drawable.s3p4_arcilla;
        }
        if(imageName.equals("Ofrendas con comida")){
            return R.drawable.s3p4_comida;
        }
        if(imageName.equals("Ofrendas hechas en oro")){
            return R.drawable.s3p4_oro;
        }
        if(imageName.equals("Ofrendas con animales")){
            return R.drawable.s3p4_animales;
        }
        if(imageName.equals("Les enseñaban a cuidar a los niños, y los animales")){
            return R.drawable.s3p5_ninos;
        }
        if(imageName.equals("Los cuidaban de los problemas climáticos")){
            return R.drawable.s3p5_clima;
        }
        if(imageName.equals("Les daban sus alimentos")){
            return R.drawable.s3p5_alimentos;
        }
        if(imageName.equals("Pensaban que eran sus padres")){
            return R.drawable.s3p5_padres;
        }

        /*Inicio Estacion # 4*/
        if(imageName.equals("5")){
            return R.drawable.s4p1_5;
        }
        if(imageName.equals("4")){
            return R.drawable.s4p1_4;
        }
        if(imageName.equals("6")){
            return R.drawable.s4p1_6;
        }
        if(imageName.equals("7")){
            return R.drawable.s4p1_7;
        }
        if(imageName.equals("Cundinamarca")){
            return R.drawable.s4p2_cundinamarca;
        }
        if(imageName.equals("Caqueta")){
            return R.drawable.s4p2_caqueta;
        }
        if(imageName.equals("Putumayo")){
            return R.drawable.s4p2_putumayo;
        }
        if(imageName.equals("Choco")){
            return R.drawable.s4p2_choco;
        }
        if(imageName.equals("Iguaque")){
            return R.drawable.s4p3_iguaque;
        }
        if(imageName.equals("Ubaque")){
            return R.drawable.s4p3_ubaque;
        }
        if(imageName.equals("Tota")){
            return R.drawable.s4p3_tota;
        }
        if(imageName.equals("Guatavita")){
            return R.drawable.s4p3_guatavita;
        }
        if(imageName.equals("Guasca")){
            return R.drawable.s4p4_guasca;
        }
        if(imageName.equals("Teusacá")){
            return R.drawable.s4p4_teusaca;
        }
        if(imageName.equals("Siecha")){
            return R.drawable.s4p4_siecha;
        }
        if(imageName.equals("Pescar")){
            return R.drawable.s4p5_pescar;
        }
        if(imageName.equals("Nadar")){
            return R.drawable.s4p5_nadar;
        }
        if(imageName.equals("Cocinar para toda la comunidad")){
            return R.drawable.s4p5_cocinar;
        }
        if(imageName.equals("Rituales y cantos")){
            return R.drawable.s4p5_ritual;
        }

        return R.drawable.logo100x100;

    }
    /* Metodo de implementacion de Sonido */
    public void feedbackAnswer(int valorRespuesta){
        if (valorRespuesta == 1){
            aciertoSound.play(playAcierto,1,1,1,0,0);
        }else {
            errorSound.play(playError,1,1,1,0,0);
        }
    }

    public  void cambiarActivity(){
        Intent intent = new Intent(this, StationResultActivity.class);
        Bundle extras = new Bundle();
        extras.putString("EXTRA_RESULT_STATION",String.valueOf(preguntasCorrectas));
        extras.putString("EXTRA_TITLE_STATION",this.tituloEstacion);
        extras.putString("EXTRA_ID_STATION",this.idEstacion);
        extras.putString("EXTRA_CURRENT_USER",this.currentUser);
        intent.putExtras(extras);
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        MainActivity.popup("Lo sentimos, no puedes volver.",getApplicationContext());
    }
}
