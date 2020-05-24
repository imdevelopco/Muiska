package com.example.muiska.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.muiska.R;

import static android.content.Intent.EXTRA_TEXT;

public class StationResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_result);
        Bundle extras = getIntent().getExtras();
        String resultado = extras.getString("EXTRA_RESULT_STATION");
        String tituloEstacion = extras.getString("EXTRA_TITLE_STATION");
        TextView stationName = (TextView) findViewById(R.id.StationNameTextView);
        TextView resultStation = (TextView) findViewById(R.id.calificacionTextView);
        stationName.setText(tituloEstacion);
        resultStation.setText(resultado);
    }
}
