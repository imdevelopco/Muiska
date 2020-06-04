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
    private String idEstacion,currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_narration);
        Bundle extra = getIntent().getExtras();
        tituloStation = extra.getString("EXTRA_TITLE_STATION");
        idEstacion = extra.getString("EXTRA_ID_STATION");
        currentUser = extra.getString("EXTRA_CURRENT_USER");
        setTextNarration();
    }

    public void setTextNarration(){
        TextView enunciadoTextView = (TextView) findViewById(R.id.titleStation);
        NarrationDAO narrationDAO = new NarrationDAO(getApplicationContext());
        enunciado = narrationDAO.getNarration(Integer.parseInt(idEstacion)).get(0);
        enunciadoTextView.setText(enunciado);
    }

    public  void cambiarActivity(View view){
        Intent intent = new Intent(this, QuestionActivity.class);
        Bundle extras = new Bundle();
        extras.putString("EXTRA_ID_STATION",this.idEstacion);
        extras.putString("EXTRA_TITLE_STATION", String.valueOf(this.tituloStation));
        extras.putString("EXTRA_CURRENT_USER",this.currentUser);
        intent.putExtras(extras);
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        MainActivity.popup("Lo sentimos, no puedes volver.",getApplicationContext());
    }
}
