 package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

 public class Forum extends AppCompatActivity {

     ArrayList<Message> messages = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        ListView forumView = findViewById(R.id.forum_view);

        ArrayAdapter messagesAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, messages);
        forumView.setAdapter(messagesAdapter);


    }
}
