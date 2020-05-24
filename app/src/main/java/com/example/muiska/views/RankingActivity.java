package com.example.muiska.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.muiska.R;

import static android.content.Intent.EXTRA_TEXT;

public class RankingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle extra = getIntent().getExtras();
        String mensaje = extra.getString(EXTRA_TEXT);
        TextView textView = (TextView) findViewById(R.id.textView4);
        textView.setText(mensaje);
    }
}
