package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

 public class Forum extends AppCompatActivity {
     DatabaseReference databasePosts;
     //FirebaseAuth firebaseAuth;
     //FirebaseAuth.AuthStateListener authStateListener;
     ChildEventListener PostsEventListener;
     ForumPostAdapter ForumPostsAdapter;
     ArrayList<forumPosts> Posts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        ListView forumView = findViewById(R.id.forum_view);

        ForumPostsAdapter = new ForumPostAdapter(this, Posts);
        forumView.setAdapter(ForumPostsAdapter);

    }
    public void floatButt(View view){
        Intent intent = new Intent( this, makePost.class);
        startActivity(intent);
    }


}
