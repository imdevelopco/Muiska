package com.example.muiska.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.muiska.R;
import com.example.muiska.models.StationDAO;
import com.example.muiska.models.UserDAO;

import static android.content.Intent.EXTRA_TEXT;

public class DashboardActivity extends AppCompatActivity {
    private CharSequence nombreEstacionOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        setTitleStationOne();

    }

    public void check(View view){
        UserDAO userDAO = new UserDAO(getApplicationContext());
        MainActivity.popup(String.valueOf(userDAO.getUsers()),getApplicationContext());
    }

    public  void cambiarActivityCostumbres(View view){

        Intent intent = new Intent(this, NarrationActivity.class);
        intent.putExtra(EXTRA_TEXT,this.nombreEstacionOne);
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
