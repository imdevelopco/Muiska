package com.example.muiska.views;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.muiska.R;
import com.example.muiska.models.AnswerDAO;

import com.example.muiska.models.QuestionDAO;

import java.util.ArrayList;
import java.util.Collections;


public class QuestionActivity extends AppCompatActivity {

    private ArrayList<ArrayList<String>> respuestas;
    private AnswerController answerCtrlOne,answerCtrlTwo,answerCtrlThree,answerCtrlFour;
    private TextView tituloPreguntaTextView;
    private TextView answerOneTextView;
    private TextView answerTwoTextView;
    private TextView answerThreeTextView;
    private TextView answerFourTextView;
    private int preguntaActual;
    private int[] preguntas = azar(1,5,5);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        tituloPreguntaTextView = (TextView) findViewById(R.id.titleQuestiontextView);
        answerOneTextView = (TextView) findViewById(R.id.answerOnetextView);
        answerTwoTextView = (TextView) findViewById(R.id.answerTwotextView);
        answerThreeTextView = (TextView) findViewById(R.id.answerThreetextView);
        answerFourTextView = (TextView) findViewById(R.id.answerFourtextView);
        setContentQuestion();
    }



    public void setContentQuestion(){
        if(preguntaActual < preguntas.length){
            /* Question*/
            QuestionDAO questionDAO= new QuestionDAO(getApplicationContext());
            AnswerDAO answerDAO= new AnswerDAO (getApplicationContext());
            CharSequence tituloPregunta = questionDAO.getQuestion(1,preguntas[preguntaActual]).get(0);
            initAnswers(answerDAO);
            /* set text content of TextViews */
            tituloPreguntaTextView.setText(tituloPregunta);
            preguntaActual++;
        }else{
            /*Accion a ejecutar cuando termine las preguntas*/
            MainActivity.popup("Ya se acabaron las preguntas",this.getApplicationContext());
        }
    }


    public  void changeQuestion(View view){
        this.setContentQuestion();
    }

    public void initAnswers(AnswerDAO answerDAO){
        /* Answer */
        respuestas = answerDAO.getAnswers(preguntas[preguntaActual]);
        for (int i=0; i<respuestas.size();i++){
            switch (i){
                case 0:
                    answerCtrlOne = new AnswerController(respuestas.get(i).get(0),Integer.parseInt(respuestas.get(i).get(1)));
                    answerOneTextView.setText(answerCtrlOne.getEnunciado());
                    break;
                case 1:
                    answerCtrlTwo = new AnswerController(respuestas.get(i).get(0),Integer.parseInt(respuestas.get(i).get(1)));
                    answerTwoTextView.setText(answerCtrlTwo.getEnunciado());
                    break;
                case 2:
                    answerCtrlThree = new AnswerController(respuestas.get(i).get(0),Integer.parseInt(respuestas.get(i).get(1)));
                    answerThreeTextView.setText(answerCtrlThree.getEnunciado());
                    break;
                case 3:
                    answerCtrlFour = new AnswerController(respuestas.get(i).get(0),Integer.parseInt(respuestas.get(i).get(1)));
                    answerFourTextView.setText(answerCtrlFour.getEnunciado());
                    break;
            }
        }
    }

    public void validateAnswer(View view){
        if(answerCtrlOne.getRespuesta() == 1){
            answerOneTextView.setTextColor(Color.GREEN);
        }else{
            answerOneTextView.setTextColor(Color.RED);
        }
        if(answerCtrlTwo.getRespuesta() == 1){
            answerTwoTextView.setTextColor(Color.GREEN);
        }else{
            answerTwoTextView.setTextColor(Color.RED);
        }
        if(answerCtrlThree.getRespuesta() == 1){
            answerThreeTextView.setTextColor(Color.GREEN);
        }else {
            answerThreeTextView.setTextColor(Color.RED);
        }
        if(answerCtrlFour.getRespuesta() == 1){
            answerFourTextView.setTextColor(Color.GREEN);
        }else{
            answerFourTextView.setTextColor(Color.RED);
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
}
