package com.example.muiska.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.muiska.R;
import com.example.muiska.models.AnswerDAO;

import com.example.muiska.models.QuestionDAO;

import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        setContentQuestion();
    }

    public void setContentQuestion(){
        TextView tituloPreguntaTextView = (TextView) findViewById(R.id.titleQuestiontextView);
        TextView answerOneTextView = (TextView) findViewById(R.id.questionOnetextView);
        TextView answerTwoTextView = (TextView) findViewById(R.id.questionTwotextView);
        TextView answerThreeTextView = (TextView) findViewById(R.id.questionThreetextView);
        TextView answerFourTextView = (TextView) findViewById(R.id.questionFourtextView);

        /* Question*/

        QuestionDAO questionDAO= new QuestionDAO(getApplicationContext());
        AnswerDAO answerDAO= new AnswerDAO (getApplicationContext());
        CharSequence tituloPregunta = questionDAO.getQuestion(1,1).get(0);

        /* Answer */

        ArrayList<String> respuestas = answerDAO.getAnswers(1);
        CharSequence  answerOne = respuestas.get(0);
        CharSequence  answerTwo = respuestas.get(1);
        CharSequence  answerThree = respuestas.get(2);
        CharSequence  answerFour = respuestas.get(3);

        /* set text content of TextViews */
        tituloPreguntaTextView.setText(tituloPregunta);
        answerOneTextView.setText(answerOne);
        answerTwoTextView.setText(answerTwo);
        answerThreeTextView.setText(answerThree);
        answerFourTextView.setText(answerFour);

    }
}
