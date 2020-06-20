package com.example.finalproject;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ArrayAdapter;
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

        ArrayAdapter PostsAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, Posts);
        forumView.setAdapter(PostsAdapter);


    }
     public void attachReadListener() {
         if(PostsEventListener == null) {
             PostsEventListener = new ChildEventListener() {
                 @Override
                 public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                     Message chatMessage = dataSnapshot.getValue(Message.class);
                     Posts.add(chatMessage);
                 }
                 public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {}
                 public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {}
                 public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {}
                 public void onCancelled(@NonNull DatabaseError databaseError) {}
             };
             databasePosts.addChildEventListener(PostsEventListener);
         }
     }
     public void sendMessage(View view) {
         //get the string from the edittext field
         //push the message as a child to the messages object in the db
//         String message = editText.getText().toString();
//         editText.setText("");
//
//         //TODO: push the message as a child to the messages object in the db
//         Message chatMessage = new Message(username, message, profilePic);
//         databaseMessages.push().setValue(chatMessage);

     }
}
