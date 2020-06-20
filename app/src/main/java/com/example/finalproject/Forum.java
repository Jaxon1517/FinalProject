package com.example.finalproject;

import android.os.Bundle;
import android.os.Message;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

 public class Forum extends AppCompatActivity {
     DatabaseReference databasePosts;
     //FirebaseAuth firebaseAuth;
     //FirebaseAuth.AuthStateListener authStateListener;
     ArrayList<Message> Posts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        ListView forumView = findViewById(R.id.forum_view);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //firebaseAuth = FirebaseAuth.getInstance();


        //TODO: Instantiate the DatabaseReference to the messages object here
        databasePosts = database.getReference().child("Posts");

        ArrayAdapter messagesAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, Posts);
        forumView.setAdapter(messagesAdapter);


    }
}
