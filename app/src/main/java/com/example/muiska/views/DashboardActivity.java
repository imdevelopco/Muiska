package com.example.muiska.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.muiska.R;
import com.example.muiska.models.StationDAO;
import com.example.muiska.models.UserDAO;

import static android.content.Intent.EXTRA_TEXT;

public class DashboardActivity extends AppCompatActivity {
    private static boolean stationOnePlayed = false;
    private CharSequence nombreEstacionOne;
    private String stationToPlay,idStationToPlay;
    private boolean created;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        setTitleStationOne();
    }
    @Override
    protected void onResume(){
        super.onResume();
        if(stationOnePlayed){
            Bundle extra = getIntent().getExtras();
            String data = extra.getString("EXTRA_RESULT_STATION");
            int id = extra.getInt("EXTRA_ID_STATION");
            this.setScoreStation(id,data);
        }

    }
    public void check(View view){
        UserDAO userDAO = new UserDAO(getApplicationContext());
        MainActivity.popup(String.valueOf(userDAO.getUsers()),getApplicationContext());
    }
    public static void setStationOnePlayed(boolean value){
        stationOnePlayed = value;
    }
    public void setScoreStation(int idStation,String data){
        /* Método para calificar el juego por estación */
        if(idStation == 1){
            TextView scoreStationOne = findViewById(R.id.scoreStationOne);
            scoreStationOne.setText(data);
        }
    }
    public  void cambiarActivity(View view){
        ImageView stationOne = findViewById(R.id.imageStationOne);
        Intent intent = new Intent(this, NarrationActivity.class);
        Bundle extras = new Bundle();
        if(!stationOnePlayed) {
            if (stationOne.isPressed()) {
                this.idStationToPlay = "1";
            }

            extras.putString("EXTRA_TITLE_STATION", String.valueOf(this.nombreEstacionOne));
            extras.putString("EXTRA_ID_STATION", idStationToPlay);
            intent.putExtras(extras);
            startActivity(intent);
        }else{
            MainActivity.popup("Ya jugaste esta estación",getApplicationContext());
        }
    }
    public void goToRanking(View view){
        Intent intent = new Intent(this, RankingActivity.class);
        startActivity(intent);

    }
    public  void cambiarActivityMap(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
    public void setTitleStationOne(){
        TextView StationOneTv =  (TextView) findViewById(R.id.stationOneTextView);
        StationDAO stationDAO = new StationDAO(getApplicationContext());
        nombreEstacionOne = stationDAO.getStation(1).get(0);
        StationOneTv.setText(nombreEstacionOne);
    }
    @Override
    public void onBackPressed(){
        MainActivity.popup("Lo sentimos, no puedes volver.",getApplicationContext());
    }
}
