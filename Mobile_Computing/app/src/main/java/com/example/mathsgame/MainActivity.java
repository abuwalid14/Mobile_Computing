package com.example.mathsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button start_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         start_btn =(Button) findViewById(R.id.start_btn);

         start_btn.setOnClickListener(new OnClickListener() {
             @Override
             public void onClick(View v) {
                 start_game();



             }
         });

    }



    public void start_game(){

       Intent intent = new Intent(this,activity_games_start.class);
       startActivity(intent);


  }

}