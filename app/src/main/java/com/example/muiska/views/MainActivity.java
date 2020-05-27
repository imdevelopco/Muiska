package com.example.muiska.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.example.muiska.R;
import com.example.muiska.models.UserDAO;
import com.example.muiska.views.DashboardActivity;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText inputEdad;
    TextInputEditText inputName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEdad = (TextInputEditText)findViewById(R.id.inputEdad);
        inputName = (TextInputEditText)findViewById(R.id.inputTextNick);
    }

    public  void cambiarActivity(View view){
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }

    public  void  registerUser(String name,String edad){
        UserDAO userDAO = new UserDAO(this.getApplicationContext());
        userDAO.insertUser(name,edad);
    }

    public static void popup(String textToView,Context context){
        CharSequence text = textToView;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void validation(View view){
        int edadUser = 0;

        if (String.valueOf(inputEdad.getText()).length() == 0){
            edadUser = 0;
        }else{
            edadUser = Integer.parseInt(String.valueOf(inputEdad.getText()));
        }

        if(inputName.getText().length()<1){
            this.popup("El nick no debe estar vacio",this.getApplicationContext());
        }
        if((edadUser > 99) || (edadUser < 1)){
            this.popup("Edad no valida",this.getApplicationContext());

        }else{
            registerUser(String.valueOf(inputName.getText()),String.valueOf(inputEdad.getText()));
            this.cambiarActivity(view);
        }

    }
}
