package com.example.muiska.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.muiska.R;
import com.example.muiska.models.StationDAO;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        setTitleStationOne();
    }

    public  void cambiarActivity(View view){
        Intent intent = new Intent(this, NarrationActivity.class);
        startActivity(intent);
    }

    public void setTitleStationOne(){
        TextView StationOneTv =  (TextView) findViewById(R.id.stationOneTextView);
        StationDAO stationDAO = new StationDAO(getApplicationContext());
        CharSequence nombreEstacion = stationDAO.getStation(1).get(0);
        StationOneTv.setText(nombreEstacion);
    }

}
