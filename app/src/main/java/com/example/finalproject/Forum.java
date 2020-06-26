package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databasePosts = database.getReference().child("Posts");

        databasePosts.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Posts.add(dataSnapshot.getValue(forumPosts.class));
                ForumPostsAdapter.notifyDataSetChanged();
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });


    }

    public void floatButt(View view){
        Intent intent = new Intent( this, makePost.class);
        startActivity(intent);
    }


}
