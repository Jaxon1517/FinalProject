package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class chat extends AppCompatActivity {

    EditText editText;
    MessageAdapter messagesAdapter;

    ArrayList<com.example.finalproject.Message> MessagesList = new ArrayList<>();
    DatabaseReference databaseMessages;
    boolean clicked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        editText = findViewById(R.id.edit_text);
        ListView listView = findViewById(R.id.list_view);

        messagesAdapter = new MessageAdapter(this, MessagesList);
        listView.setAdapter(messagesAdapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseMessages = database.getReference().child("messages");

        final LottieAnimationView lottieClickSent = findViewById(R.id.lottieClickSent);
        lottieClickSent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clicked = true){
                    String message = editText.getText().toString();
                    MessagesList.add(new com.example.finalproject.Message(message));
                    editText.setText("");
                    com.example.finalproject.Message chatMessage = new Message(message);
                    databaseMessages.push().setValue(chatMessage);
                    closeKeyboard();
                    clicked = false;
                }
            }
        });

    }

    public void closeKeyboard(){
        View view = this.getCurrentFocus();
        if (view != null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }

}
