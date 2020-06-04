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
    private static boolean stationOnePlayed = false,stationTwoPlayed = false,stationThreePlayed = false,stationFourPlayed = false;
    private CharSequence nameStationOne,nameStationTwo,nameStationThree,nameStationFour;
    private String currentUser,idStationToPlay;
    private boolean created;
    private ImageView stationOne,stationTwo,stationThree,stationFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Bundle extras = getIntent().getExtras();
        currentUser = extras.getString("EXTRA_CURRENT_USER");
        stationOne = findViewById(R.id.imageStationOne);
        stationTwo = findViewById(R.id.imageStationTwo);
        stationThree = findViewById(R.id.imageStationThree);
        stationFour = findViewById(R.id.imageStationFour);
        setTitleStationOne();
        setTitleStationTwo();
        setTitleStationThree();
        setTitleStationFour();

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
    public static void setStationTwoPlayed(boolean value){
        stationTwoPlayed = value;
    }
    public static void setStationThreePlayed(boolean value){
        stationThreePlayed = value;
    }
    public static void setStationFourPlayed(boolean value){
        stationFourPlayed = value;
    }
    public void setScoreStation(int idStation,String data){
        /* Método para calificar el juego por estación */
        if(idStation == 1){
            TextView scoreStationOne = findViewById(R.id.scoreStationOne);
            scoreStationOne.setText(data);
        }
        if(idStation == 2){
            TextView scoreStationTwo = findViewById(R.id.scoreStationTwo);
            scoreStationTwo.setText(data);
        }
        if(idStation == 3){
            TextView scoreStationThree = findViewById(R.id.scoreStationThree);
            scoreStationThree.setText(data);
        }
        if(idStation == 4){
            TextView scoreStationFour = findViewById(R.id.scoreStationFour);
            scoreStationFour.setText(data);
        }

    }
    public  void cambiarActivityOne(View view){
        Intent intent = new Intent(this, NarrationActivity.class);
        Bundle extras = new Bundle();
        if(!stationOnePlayed) {
            if (stationOne.isPressed()) {
                this.idStationToPlay = "1";
            }
            extras.putString("EXTRA_TITLE_STATION", String.valueOf(this.nameStationOne));
            extras.putString("EXTRA_ID_STATION", idStationToPlay);
            extras.putString("EXTRA_CURRENT_USER",this.currentUser);
            intent.putExtras(extras);
            startActivity(intent);
        }else{
            MainActivity.popup("Ya jugaste esta estación",getApplicationContext());
        }
    }
    public  void cambiarActivityTwo(View view){
        Intent intent = new Intent(this, NarrationActivity.class);
        Bundle extras = new Bundle();
        if(!stationTwoPlayed) {
            if (stationTwo.isPressed()) {
                this.idStationToPlay = "2";
            }
            extras.putString("EXTRA_TITLE_STATION", String.valueOf(this.nameStationTwo));
            extras.putString("EXTRA_ID_STATION", idStationToPlay);
            extras.putString("EXTRA_CURRENT_USER",this.currentUser);
            intent.putExtras(extras);
            startActivity(intent);
        }else{
            MainActivity.popup("Ya jugaste esta estación",getApplicationContext());
        }
    }

    public  void cambiarActivityThree(View view){
        Intent intent = new Intent(this, NarrationActivity.class);
        Bundle extras = new Bundle();
        if(!stationThreePlayed) {
            if (stationThree.isPressed()) {
                this.idStationToPlay = "3";
            }
            extras.putString("EXTRA_TITLE_STATION", String.valueOf(this.nameStationThree));
            extras.putString("EXTRA_ID_STATION", idStationToPlay);
            extras.putString("EXTRA_CURRENT_USER",this.currentUser);
            intent.putExtras(extras);
            startActivity(intent);
        }else{
            MainActivity.popup("Ya jugaste esta estación",getApplicationContext());
        }
    }
    public  void cambiarActivityFour(View view){
        Intent intent = new Intent(this, NarrationActivity.class);
        Bundle extras = new Bundle();
        if(!stationFourPlayed) {
            if (stationFour.isPressed()) {
                this.idStationToPlay = "4";
            }
            extras.putString("EXTRA_TITLE_STATION", String.valueOf(this.nameStationFour));
            extras.putString("EXTRA_ID_STATION", idStationToPlay);
            extras.putString("EXTRA_CURRENT_USER",this.currentUser);
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
        nameStationOne = stationDAO.getStation(1).get(0);
        StationOneTv.setText(nameStationOne);
    }
    public void setTitleStationTwo(){
        TextView StationTwoTv =  (TextView) findViewById(R.id.stationTwoTextView);
        StationDAO stationDAO = new StationDAO(getApplicationContext());
        nameStationTwo = stationDAO.getStation(2).get(0);
        StationTwoTv.setText(nameStationTwo);
    }
    public void setTitleStationThree(){
        TextView StationThreeTv =  (TextView) findViewById(R.id.stationThreeTextView);
        StationDAO stationDAO = new StationDAO(getApplicationContext());
        nameStationThree = stationDAO.getStation(3).get(0);
        StationThreeTv.setText(nameStationThree);
    }
    public void setTitleStationFour(){
        TextView StationFourTv =  (TextView) findViewById(R.id.stationFourTextView);
        StationDAO stationDAO = new StationDAO(getApplicationContext());
        nameStationFour = stationDAO.getStation(4).get(0);
        StationFourTv.setText(nameStationFour);
    }


    @Override
    public void onBackPressed(){
        MainActivity.popup("Lo sentimos, no puedes volver.",getApplicationContext());
    }
}
