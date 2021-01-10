package com.example.mathsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class result_Activity extends AppCompatActivity {
    Button reset_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_);

       reset_btn =(Button) findViewById(R.id.reset);

      reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_game();



            }
        });

    }



    public void start_game(){

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);


    }


}
