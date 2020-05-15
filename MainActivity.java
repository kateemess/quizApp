package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showCorrectAnswers = findViewById(R.id.show_answers_button);
        showCorrectAnswers.setVisibility(View.GONE);

        TextView answersTextView = findViewById(R.id.answers_text_view);
        answersTextView.setVisibility(View.GONE);


    }

    // this method reset score and answers and allows to start quiz again
    public void reset(View view) {
        setContentView(R.layout.activity_main);
        Button showCorrectAnswers = findViewById(R.id.show_answers_button);
        showCorrectAnswers.setVisibility(View.GONE);

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


        EditText question6 = findViewById(R.id.question6);
        String answer = question6.getText().toString();
        if (answer.equals("elephant") | answer.equals("ELEPHANT") | answer.equals("Elephant")) {
            score = score + 2;
        }


        displayPoints(score);

//this method display "Show Correct Answers" button after submiting answers.
        Button showCorrectAnswers = findViewById(R.id.show_answers_button);
        showCorrectAnswers.setVisibility(View.VISIBLE);


        Context context = getApplicationContext();
        CharSequence text6 = "Congratulations! You got maximum number of points: " + score + " /7 Points! Your knowledge is really impressive :) ";
        CharSequence text5 = "Well done! You got  " + score + "/7 Points! Points and it is a very good result!";
        CharSequence text4 = "Bravo! You got " + score + "/7 ";
        CharSequence text3 = "It could be better. You got " + score + "/7 Points!";
        CharSequence text2 = "It is not your lucky day. You got only " + score + "/7 Points! Give it another try :)";
        CharSequence text1 = "Please check the answers and try once again. You got only  " + score + "/7 Points! Don't give up!";
        int duration = Toast.LENGTH_LONG;

        if (score == 7) {
            Toast toast6 = Toast.makeText(context, text6, duration);
            toast6.show();
        }

        if (score == 5 | score == 6) {
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

    public void answers(View view) {
        String a1 = "1. Eel fish", a2 = "2. Penguin", a3 = "3.Bassador & Cockapoo",
                a4 = "4. Vienna", a5 = "5. Blue Whale", a6 = "6. Elephant";
        String correctAnswers = a1 + "\t\t" + a2 + "\t\t" + a3 + "\n\n"
                + a4 + "\t\t" + a5 + "\t\t" + a6;


        TextView answerTextView = findViewById(R.id.answers_text_view);
        answerTextView.setVisibility(View.VISIBLE);
        answerTextView.setText(correctAnswers);

        Button showCorrectAnswers = findViewById(R.id.show_answers_button);
        showCorrectAnswers.setVisibility(View.GONE);

    }


    private void displayPoints(int score) {
        TextView pointsTextView = findViewById(R.id.points);
        pointsTextView.setText("Your score: " + score + " Points");
    }
}
