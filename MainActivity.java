package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    // this method reset score and answers and allows to start quiz again
    public void reset(View view){
        setContentView(R.layout.activity_main);

    }


    public void submitAnswers(View view) {

        CheckBox bassador = findViewById(R.id.bassador);
        boolean bassadorIsChecked = bassador.isChecked();
        CheckBox cockapoo = findViewById(R.id.cockapoo);
        boolean cockapooIsChecked = cockapoo.isChecked();


        // the following methods add points if answer is true

        if (cockapooIsChecked & bassadorIsChecked) {
            score = score + 1;

        }

        RadioButton eelFish = findViewById(R.id.eel_fish);
        boolean eelFishIsChecked = eelFish.isChecked();
        if (eelFishIsChecked) {
            score = score + 1;
        }

        RadioButton penguin = findViewById(R.id.penguin);
        boolean penguinIsChecked = penguin.isChecked();
        if (penguinIsChecked) {
            score = score + 1;
        }

        RadioButton vienna = findViewById(R.id.vienna);
        boolean viennaIsChecked = vienna.isChecked();
        if (viennaIsChecked) {
            score = score + 1;
        }

        RadioButton whale = findViewById(R.id.whale);
        boolean whaleIsChecked = whale.isChecked();
        if (whaleIsChecked) {
            score = score + 1;
        }


        displayPoints(score);


        Context context = getApplicationContext();
        CharSequence text5 = "Well done! You got maximum  " + score + "/5 Points! Your knowledge is really impressive :)";
        CharSequence text4 = "Bravo! You got " + score + "/5 Points and it is a good result! ";
        CharSequence text3 = "It could be better. You got " + score + "/5 Points!";
        CharSequence text2 = "It is not your lucky day. You got only " + score + "/5 Points! Give it another try :)";
        CharSequence text1 = "Please check the answers and try once again. You got only  " + score + "/5 Points! Don't give up!";
        int duration = Toast.LENGTH_LONG;


        if (score == 5) {
            Toast toast5 = Toast.makeText(context, text5, duration);
            toast5.show();
        }

        if (score == 4) {
            Toast toast4 = Toast.makeText(context, text4, duration);
            toast4.show();
        }
        if (score == 3) {
            Toast toast3 = Toast.makeText(context, text3, duration);
            toast3.show();
        }

        if (score == 2) {
            Toast toast2 = Toast.makeText(context, text2, duration);
            toast2.show();

        }

        if (score == 1) {
            Toast toast1 = Toast.makeText(context, text1, duration);
            toast1.show();


        }


        score = 0;


    }

    private void displayPoints(int score) {
        TextView pointsTextView = findViewById(R.id.points);
        pointsTextView.setText("Your score: " + score + " Points");
    }
}
