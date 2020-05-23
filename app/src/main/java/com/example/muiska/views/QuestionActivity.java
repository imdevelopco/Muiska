package com.example.muiska.views;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.muiska.R;
import com.example.muiska.models.AnswerDAO;

import com.example.muiska.models.QuestionDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TimerTask;


public class QuestionActivity extends AppCompatActivity {

    private ArrayList<ArrayList<String>> respuestas;
    private AnswerController answerCtrlOne,answerCtrlTwo,answerCtrlThree,answerCtrlFour;
    private TextView tituloPreguntaTextView;
    private TextView answerOneTextView;
    private TextView answerTwoTextView;
    private TextView answerThreeTextView;
    private TextView answerFourTextView;
    private int preguntaActual, playAcierto, playError;
    private int[] preguntas = azar(1,5,5);
    private SoundPool aciertoSound, errorSound;
    private ImageView imageAnswerOne,imageAnswerTwo, imageAnswerThree,imageAnswerFour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        if(preguntaActual < preguntas.length){
            /* Question*/
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            QuestionDAO questionDAO= new QuestionDAO(getApplicationContext());
            AnswerDAO answerDAO= new AnswerDAO (getApplicationContext());
            CharSequence tituloPregunta = questionDAO.getQuestion(1,preguntas[preguntaActual]).get(0);
            initAnswers(answerDAO);
            /* set text content of TextViews */
            tituloPreguntaTextView.setText(tituloPregunta);
            tituloPreguntaTextView.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
            preguntaActual++;
        }else{
            /*Accion a ejecutar cuando termine las preguntas*/
            MainActivity.popup("Ya se acabaron las preguntas",this.getApplicationContext());
        }
    }
    public void initAnswers(AnswerDAO answerDAO){
        /* Answer */
        respuestas = answerDAO.getAnswers(preguntas[preguntaActual]);
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
            answerOneTextView.setTextColor(Color.GREEN);
        } else {
            answerOneTextView.setTextColor(Color.RED);
        }

        feedbackAnswer(answerCtrlOne.getRespuesta());
        setContentQuestion();
    }
    public void validateAnswerTwo(View view) {
        if (answerCtrlTwo.getRespuesta() == 1) {
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
        if(imageName.equals("Papas")){
            return R.drawable.p1_papa;
        }
        if(imageName.equals("Bananos")){
            return R.drawable.p1_banano;
        }
        if(imageName.equals("Maíz")){
            return R.drawable.p1_mazorca;
        }
        if(imageName.equals("Yuca")){
            return R.drawable.p1_yuca;
        }
        if(imageName.equals("Trueque")){
            return R.drawable.p2_trueque;
        }
        if(imageName.equals("Compra")){
            return R.drawable.p2_compra;
        }
        if(imageName.equals("Venta")){
            return R.drawable.p2_venta;
        }
        if(imageName.equals("Préstamo")){
            return R.drawable.p2_prestamo;
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
}
