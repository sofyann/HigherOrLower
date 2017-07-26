package com.example.sofyann.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText valueOfUser;
    Button button;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constructUI();
        constructListeners();
        this.number = generateNumber();
    }

    private void constructUI(){
        valueOfUser = (EditText)findViewById(R.id.valueOfUser);
        button = (Button) findViewById(R.id.button);
    }

    private void constructListeners(){
        button.setOnClickListener(this);
    }

    private int generateNumber(){
        Random r = new Random();
        int number = r.nextInt(20)+1;
        Log.i("info", String.valueOf(number));
        return number;
    }

    private int getNumberFromEditText(){
        String temp = this.valueOfUser.getText().toString();
        int numberEnter = Integer.parseInt(temp);
        return numberEnter;

    }

    private boolean isMyEditTextEmpty(){
        boolean state;
        state = this.valueOfUser.getText().length() ==0;
        return state;
    }

    private String compareNumber() {
        if (getNumberFromEditText() < this.number){
            return "Higher !";
        } else if (getNumberFromEditText() > this.number) {
            return "Lower !";
        } else {
            this.number = generateNumber();
            return "That's right! Try again";
        }
    }

    public void displayingReponse(){
        String temp;
        if (isMyEditTextEmpty()){
            temp = "You do not enter a value";
        } else {
            temp = compareNumber();
        }
        Toast.makeText(this, temp, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        displayingReponse();
    }
}
