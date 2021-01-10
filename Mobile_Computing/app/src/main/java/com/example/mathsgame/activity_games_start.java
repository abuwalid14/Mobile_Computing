package com.example.mathsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static com.example.mathsgame.R.id.first_number;
import static com.example.mathsgame.R.id.one;

import static com.example.mathsgame.R.id.second_number;
import static com.example.mathsgame.R.id.six;
import static com.example.mathsgame.R.id.visible;

public class activity_games_start extends AppCompatActivity {

    private ImageView[] apples = new ImageView[10];
    private ImageView[] nums = new ImageView[10];
    private int score;



  private int i;
  private int a;
    private Object view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_start);


        Button btn_begin = (Button) findViewById(R.id.btn_begin);
       btn_begin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               generate();


           }
       });

       Button check = (Button) findViewById(R.id.check);
       check.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               CheckAnswer();
               end_game();
           }
       });

        apples = new ImageView[]{findViewById(R.id.apple_1), findViewById(R.id.apple_2), findViewById(R.id.apple_3),
                findViewById(R.id.apple_4), findViewById(R.id.apple_5), findViewById(R.id.apple_6), findViewById(R.id.apple_7),
                findViewById(R.id.apple_8), findViewById(R.id.apple_9), findViewById(R.id.apple_10)};

        for (i = 0; i < apples.length; i++) {
            apples[i].setOnTouchListener(handleTouch);
        }
        nums = new ImageView[]{findViewById(R.id.one), findViewById(R.id.two), findViewById(R.id.three),
                findViewById(R.id.four), findViewById(R.id.five), findViewById(R.id.six), findViewById(R.id.seven),
                findViewById(R.id.eight), findViewById(R.id.nine), findViewById(R.id.ten)};

        findViewById(R.id.one).setOnClickListener(clickListener);
        findViewById(R.id.two).setOnClickListener(clickListener);
        findViewById(R.id.three).setOnClickListener(clickListener);
        findViewById(R.id.four).setOnClickListener(clickListener);
        findViewById(R.id.five).setOnClickListener(clickListener);
        findViewById(R.id.six).setOnClickListener(clickListener);
        findViewById(R.id.seven).setOnClickListener(clickListener);
        findViewById(R.id.eight).setOnClickListener(clickListener);
        findViewById(R.id.nine).setOnClickListener(clickListener);
        findViewById(R.id.ten).setOnClickListener(clickListener);



    }





    private final View.OnClickListener clickListener = new View.OnClickListener() {
        @SuppressLint("WrongConstant")
        @Override
        public void onClick(View v) {

            int image_id;

            switch (v.getId()) {
                case R.id.one:
                    image_id = 1;
                    break;
                case R.id.two:
                    image_id = 2;
                    break;
                case R.id.three:
                    image_id = 3;
                    break;
                case R.id.four:
                    image_id = 4;
                    break;
                case R.id.five:
                    image_id = 5;
                    break;
                case R.id.six:
                    image_id = 6;

                    break;
                case R.id.seven:
                    image_id = 7;
                    break;
                case R.id.eight:
                    image_id = 8;
                    break;
                case R.id.nine:
                    image_id = 9;
                    break;
                case R.id.ten:
                    image_id = 10;
                    break;
                default:


            }




        }};



        private View.OnTouchListener handleTouch = new View.OnTouchListener() {
            float dX, dY;

            @Override
            public boolean onTouch(View view, MotionEvent event) {


                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dX = view.getX() - event.getRawX();
                        dY = view.getY() - event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        view.animate()
                                .x(event.getRawX() + dX)
                                .y(event.getRawY() + dY)
                                .setDuration(0)
                                .start();
                        break;
                    default:
                        return false;
                }
                return true;
            }
        };

        private void generate() {
            Random random = new Random();
            ArrayList[] result = new ArrayList[0];
            int first_num = random.nextInt(4) + 1;
            int second_num = random.nextInt(4) + 1;
            int score = first_num + second_num;
            TextView first_number = (TextView) findViewById(R.id.first_number);
            TextView second_number = (TextView) findViewById(R.id.second_number);

            String one = String.valueOf(first_num);
            String two = String.valueOf(second_num);

            first_number.setText(one);
            second_number.setText(two);





        }
        private void CheckAnswer(){
            int result = Integer.parseInt(String.valueOf(R.id.check));
            int num_1 = Integer.parseInt(String.valueOf(R.id.first_number));
            int num_2 = Integer.parseInt(String.valueOf(R.id.second_number));
            int total = num_1+ num_2;
            if (total==result){
                end_game();
            }
        }


    public void end_game(){

        Intent intent = new Intent(this,result_Activity.class);
        startActivity(intent);


    }


}