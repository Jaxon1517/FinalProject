package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class Main2Activity extends AppCompatActivity {

    boolean clicked = false;
    boolean clickedChat = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final LottieAnimationView lottieClickNews = findViewById(R.id.lottieClickNews);
        lottieClickNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clicked = true){
                    Intent intent = new Intent( Main2Activity.this, Forum.class);
                    startActivity(intent);
                    clicked = true;
                }
            }
        });

        final LottieAnimationView lottieClickChat = findViewById(R.id.lottieClickChat);
        lottieClickChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickedChat = true){
                    Intent intent = new Intent( Main2Activity.this, chat.class);
                    startActivity(intent);
                    clickedChat = true;
                }
            }
        });
    }

}
