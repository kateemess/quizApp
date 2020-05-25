package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapp.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    int score = 0;

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        //"Show Correct Answers" buuton is Invisible by default
        // Corect answers are hidden by defaulf

        binding.showAnswersButton.setVisibility(View.GONE);
        binding.resetButton.setVisibility(View.GONE);
        binding.answersTextView.setVisibility(View.GONE);

        binding.showAnswersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a1 = getString(R.string.answer1), a2 = getString(R.string.answer2), a3 = getString(R.string.answer3),
                        a4 = getString(R.string.asnwer4), a5 = getString(R.string.answer5), a6 = getString(R.string.answer6);
                String correctAnswers = "\t\t" + a1 + "\t\t" + a2 + "\t\t" + a3 + "\n\n" + "\t\t"
                        + a4 + "\t\t" + a5 + "\t\t" + a6;

                binding.answersTextView.setVisibility(View.VISIBLE);
                binding.answersTextView.setText(correctAnswers);

                //"Show Correct Answers" button disappear when clicked and correct answers are displayed
                binding.showAnswersButton.setVisibility(View.GONE);


            }

        });
        binding.submitAnswersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox bassador = binding.bassador;
                boolean bassadorIsChecked = bassador.isChecked();
                CheckBox cockapoo = binding.cockapoo;
                boolean cockapooIsChecked = cockapoo.isChecked();
                CheckBox devon = binding.devon;
                boolean devonischecked = devon.isChecked();


                // the following methods add points if answer is correct ;

                if (cockapooIsChecked && bassadorIsChecked && !devonischecked) {
                    score = score + 1;

                }

                RadioButton eelFish = binding.eelFish;
                boolean eelFishIsChecked = eelFish.isChecked();
                if (eelFishIsChecked) {
                    score = score + 1;
                }

                RadioButton penguin = binding.penguin;
                boolean penguinIsChecked = penguin.isChecked();
                if (penguinIsChecked) {
                    score = score + 1;
                }

                RadioButton vienna = binding.vienna;
                boolean viennaIsChecked = vienna.isChecked();
                if (viennaIsChecked) {
                    score = score + 1;
                }

                RadioButton whale = binding.whale;
                boolean whaleIsChecked = whale.isChecked();
                if (whaleIsChecked) {
                    score = score + 1;
                }


                EditText question6 = binding.question6;
                String answer = question6.getText().toString();
                if (answer.trim().equalsIgnoreCase("elephant")) {
                    score = score + 2;  // +2 Points for open question

                }


                displayPoints(score);

                //this method displays "Show Correct Answers" button after submiting answers.
                binding.showAnswersButton.setVisibility(View.VISIBLE);


                CharSequence text0 = getString(R.string.toast_0_points);
                CharSequence text6 = getString(R.string.text6_part1) + score + getString(R.string.text6_part2);
                CharSequence text5 = getString(R.string.text5_part1) + score + getString(R.string.text5_part2);
                CharSequence text4 = getString(R.string.text4_part1) + score + getString(R.string.text4_part2);
                CharSequence text3 = getString(R.string.text3_part1) + score + getString(R.string.text3_part2);
                CharSequence text2 = getString(R.string.text2_part1) + score + getString(R.string.text2_part2);
                CharSequence text1 = getString(R.string.text1_part1) + score + getString(R.string.text1_part2);

                //these methods display correct toast message according to scored points

                if (score == 7) {
                    showToast(text6.toString());
                } else {
                    showToast(text0.toString()); // displays Toast message when all of the answers are wrong
                }

                if (score == 5 | score == 6) {
                    showToast(text5.toString());
                }

                if (score == 4) {
                    showToast(text4.toString());
                }
                if (score == 3) {
                    showToast(text3.toString());
                }

                if (score == 2) {
                    showToast(text2.toString());
                }

                if (score == 1) {
                    showToast(text1.toString());
                }

                score = 0;

                binding.resetButton.setVisibility(View.VISIBLE);

            }
        });
        // this method reset score and answers and scroll to top of the screen.

        binding.resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.resetButton.setVisibility(View.GONE);
                binding.answersTextView.setVisibility(View.GONE);
                binding.scrollView.scrollTo(0, 0);

            }
        });

    }

    private void showToast(String toastMessage) {
        Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();
    }


    // this method displays scored points when called
    private void displayPoints(int score) {
        StringBuilder string = new StringBuilder("Your score: ");
        string.append(score);
        string.append(" Points");
        TextView pointsTextView = binding.points;

        pointsTextView.setText(string);
        pointsTextView.setTextSize(20);

        if (score < 3) {
            pointsTextView.setTextColor(Color.RED);
        }

        if (score >= 3) {
            pointsTextView.setTextColor(Color.CYAN);
        }
        if (score >= 5) {
            pointsTextView.setTextColor(Color.GREEN);


        }

    }
}