package com.example.muiska.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

import com.example.muiska.R;
import com.example.muiska.models.AnswerQuestionsDAO;

import java.util.ArrayList;

public class ScoresActivity extends AppCompatActivity {

    private TableLayout tb;
    private String[] header = {"Nickname","Edad","Puntaje"};
    private ArrayList<String[]> rows = new ArrayList<String[]>();
    private  TableResult tableResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        tb = findViewById(R.id.table);
        tb.setShrinkAllColumns(true);
        tb.bringToFront();
        tableResult = new TableResult(tb,getApplicationContext());
        tableResult.addHeader(header);

    }

    @Override
    protected void onResume(){
        super.onResume();
        tableResult.addData(fullRows());
    }

    private ArrayList<String[]> fullRows (){
        rows.add(new String[]{"Mauro","5","11"});
        rows.add(new String[]{"Andres","15","10"});
        rows.add(new String[]{"Andres","15","10"});
        return rows;
    }

    public void exitMuiska(View view){
        finishAffinity();
        System.exit(0);
    }

    @Override
    public void onBackPressed(){
        MainActivity.popup("Lo sentimos, no puedes volver.",getApplicationContext());
    }
}
