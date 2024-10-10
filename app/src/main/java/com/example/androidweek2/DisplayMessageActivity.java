package com.example.androidweek2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String message = extras.getString("MESSAGE");
        String password = extras.getString("PASSWORD");
        String choice = extras.getString("CHOICE");
        String task = extras.getString("TASK");
        String switchChoice = extras.getString("SWITCHCHOICE");
        String spinner = extras.getString("SPINNER");

        TextView textView6 = findViewById(R.id.textView6);
        textView6.setText(spinner);
        TextView textView5 = findViewById(R.id.textView5);
        textView5.setText(switchChoice);
        TextView textView4 = findViewById(R.id.textView4);
        textView4.setText(task);
        TextView textView3 = findViewById(R.id.textView3);
        textView3.setText(password);
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(choice);
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }
}