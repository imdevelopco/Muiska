package com.example.muiska.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.muiska.R;
import com.example.muiska.models.UserDAO;

import java.util.ArrayList;

import static android.content.Intent.EXTRA_TEXT;

public class RankingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setUser();
        //Bundle extra = getIntent().getExtras();
        //String mensaje = extra.getString(EXTRA_TEXT);
        //TextView textView = (TextView) findViewById(R.id.textView4);
        //textView.setText(mensaje);
    }

    public void setUser(){
        TableLayout t = findViewById(R.id.containerResult);
        UserDAO userDAO = new UserDAO(getApplicationContext());
        TableRow row = new TableRow(this);
        row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT));
        TextView usuario = new TextView(this);
        TextView score = new TextView(this);
        usuario.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
        for (String user: userDAO.getUsers()){
            usuario.setText(user);
            row.addView(usuario,new TableRow.LayoutParams( TableRow.LayoutParams.WRAP_CONTENT));
            t.addView(row,new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }
}
