package com.example.muiska.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import com.example.muiska.R;
import com.example.muiska.models.NarrationDAO;

public class NarrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_narration);
        setTextNarration();
    }

    public void setTextNarration(){
        TextView enunciadoTextView = (TextView) findViewById(R.id.titleStation);
        NarrationDAO narrationDAO = new NarrationDAO(getApplicationContext());
        CharSequence enunciado = narrationDAO.getNarration(1).get(0);
        enunciadoTextView.setText(enunciado);
    }

    public  void cambiarActivity(View view){
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }
}
