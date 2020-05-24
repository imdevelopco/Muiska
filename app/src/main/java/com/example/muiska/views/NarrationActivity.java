package com.example.muiska.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import com.example.muiska.R;
import com.example.muiska.models.NarrationDAO;

import static android.content.Intent.EXTRA_TEXT;

public class NarrationActivity extends AppCompatActivity {

    private CharSequence enunciado,tituloStation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_narration);
        Bundle extra = getIntent().getExtras();
        tituloStation = extra.getString(EXTRA_TEXT);
        setTextNarration();
    }

    public void setTextNarration(){
        TextView enunciadoTextView = (TextView) findViewById(R.id.titleStation);
        NarrationDAO narrationDAO = new NarrationDAO(getApplicationContext());
        enunciado = narrationDAO.getNarration(1).get(0);
        enunciadoTextView.setText(enunciado);
    }

    public  void cambiarActivity(View view){
        Intent intent = new Intent(this, QuestionActivity.class);
        intent.putExtra(EXTRA_TEXT,this.tituloStation);
        startActivity(intent);
    }
}
