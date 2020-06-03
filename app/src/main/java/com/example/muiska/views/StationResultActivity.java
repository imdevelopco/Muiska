package com.example.muiska.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.muiska.R;

import static android.content.Intent.EXTRA_TEXT;

public class StationResultActivity extends AppCompatActivity {

    private String resultado;
    private String idEstacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_result);
        Bundle extras = getIntent().getExtras();
        resultado = extras.getString("EXTRA_RESULT_STATION");
        String tituloEstacion = extras.getString("EXTRA_TITLE_STATION");
        idEstacion = extras.getString("EXTRA_ID_STATION");
        TextView stationName = (TextView) findViewById(R.id.StationNameTextView);
        TextView resultStation = (TextView) findViewById(R.id.calificacionTextView);
        stationName.setText(tituloEstacion);
        resultStation.setText(resultado);
    }

    public void setScoreStation(View view){
        switch (Integer.parseInt(idEstacion)){
            case 1:{
                DashboardActivity.setStationOnePlayed(true);
            }
            break;
            case 2:{
                DashboardActivity.setStationTwoPlayed(true);
            }
            break;
            case 3:{
                DashboardActivity.setStationThreePlayed(true);
            }
            break;
            case 4:{
                DashboardActivity.setStationFourPlayed(true);
            }
            break;
        }
        Intent intent = new Intent(this, DashboardActivity.class);
        Bundle extras = new Bundle();
        extras.putString("EXTRA_RESULT_STATION",resultado);
        extras.putInt("EXTRA_ID_STATION",Integer.parseInt(this.idEstacion));
        intent.putExtras(extras);
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        MainActivity.popup("Lo sentimos, no puedes volver.",getApplicationContext());
    }
}
