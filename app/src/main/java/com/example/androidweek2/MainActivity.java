package com.example.androidweek2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    RadioButton radioButtonYes = null;
    RadioButton radioButtonNo = null;
    RadioGroup rg = null;
    String choice = null;
    Bundle extras = new Bundle();
    CheckBox checkBox = null;
    Switch switch1 = null;
    String[] things = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    Spinner spinner = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = (RadioGroup) findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(this);
        radioButtonYes = findViewById(R.id.radioButtonYes);
        radioButtonNo = findViewById(R.id.radioButtonNo);
        checkBox = findViewById(R.id.checkBox);
        switch1 = findViewById(R.id.switch1);
        spinner = findViewById(R.id.spinner);

        ArrayAdapter spinnerAd = new ArrayAdapter(this, android.R.layout.simple_spinner_item, things);
        spinner.setAdapter(spinnerAd);
    }

    public void sendMessage(View view){

        EditText editText = findViewById(R.id.editTextText);
        String message = editText.getText().toString();
        EditText editPassword = findViewById(R.id.passwordText);
        String password = editPassword.getText().toString();

        String task;
        if(checkBox.isChecked()){
            task = "Task complete";
        }
        else{
            task = "Task not complete";
        }

        String switchChoice;
        if(switch1.isChecked()){
            switchChoice = "Switch Checked";
        }
        else{
            switchChoice = "Switch Not Checked";
        }

        String spinnerValue = spinner.getSelectedItem().toString();

        extras.putString("TASK", task);
        extras.putString("MESSAGE", message);
        extras.putString("PASSWORD", password);
        extras.putString("SWITCHCHOICE", switchChoice);
        extras.putString("SPINNER", spinnerValue);

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtras(extras);

        startActivity(intent);
    }

    public void onCheckedChanged(RadioGroup rg, int i){
        if(i == radioButtonYes.getId()){
            choice = "Radio Button Yes";
            extras.putString("CHOICE", choice);
        }
        else if(i == radioButtonNo.getId()){
            choice = "Radio Button No";
            extras.putString("CHOICE", choice);
        }
    }
}