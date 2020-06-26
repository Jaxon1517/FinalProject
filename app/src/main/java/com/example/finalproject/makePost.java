package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class makePost extends AppCompatActivity {
    ArrayList<forumPosts> Posts = new ArrayList<>();
    EditText TitleView;
    EditText PostView;
    DatabaseReference databasePosts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_post);
        TitleView = findViewById(R.id.TitleView);
        PostView = findViewById(R.id.PostView);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databasePosts = database.getReference().child("Posts");
    }

    public void sendMessage(View view) {
        //get the string from the edittext field
        //push the message as a child to the messages object in the db
         String title = TitleView.getText().toString();
         TitleView.setText("");
         String post = PostView.getText().toString();
         PostView.setText("");
         Posts.add(new com.example.finalproject.forumPosts(title, post));

        Intent intent = new Intent( this, Forum.class);
        startActivity(intent);



         //TODO: push the message as a child to the messages object in the db
        forumPosts postMessage  = new forumPosts(title,post);
         databasePosts.push().setValue(postMessage);

    }
}
