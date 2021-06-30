package com.example.iqtrainer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView sumTextView;
    Button start_button;
    Button button0, button1, button2, button3;
    ImageView logo_image;
    TextView timer;
    TextView scoreTextView;
    Button startAgain;
    ArrayList<Integer> answers = new ArrayList<>();
    int locationOfCorrectAnswer;
    TextView resultTextView;
    int score = 0;
    ConstraintLayout gameLayout;
    int numberOfQuestions = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_button = findViewById(R.id.start_button);
        logo_image = findViewById(R.id.logo_image);
        sumTextView = findViewById(R.id.sumTextView);
        button0 = findViewById(R.id.button1);
        resultTextView = findViewById(R.id.resultTextView);
        button1 = findViewById(R.id.button2);
        button2 = findViewById(R.id.button3);
        button3 = findViewById(R.id.button4);
        scoreTextView = findViewById(R.id.scoreTextView);
        timer = findViewById(R.id.timer_textview);
        startAgain = findViewById(R.id.startAgain);
        gameLayout = findViewById(R.id.gameLayout);

        start_button.setVisibility(View.VISIBLE);
        logo_image.setVisibility(View.VISIBLE);
        gameLayout.setVisibility(View.INVISIBLE);
        answers.clear();
        newQuestion();


    }

    public void start_test(View view) {
        start_button.setVisibility(View.INVISIBLE);
        logo_image.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        startAgain(findViewById(R.id.timer_textview));
    }

    public void chooseAnswer(View view) {
        if ((Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString()))) {
            resultTextView.setText(" Correct!");
            score = score + 1;
        } else {
            resultTextView.setText("  Wrong!");
        }
        numberOfQuestions = numberOfQuestions + 1;
        scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        newQuestion();

    }

    public void newQuestion() {

        Random rand = new Random();
        locationOfCorrectAnswer = rand.nextInt(4);

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        sumTextView.setText(Integer.toString(a) + "  +  " + Integer.toString(b));
        answers.clear();
        for (int i = 0; i < 4; i++) {

            if (i == locationOfCorrectAnswer) {
                answers.add(a + b);
            } else {
                int worngAnswer = rand.nextInt(41);
                while (worngAnswer == a + b) {
                    worngAnswer = rand.nextInt(41);
                }
                answers.add(worngAnswer);
            }

        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }

    public void startAgain(View view){
        score = 0;
        numberOfQuestions = 0;
        timer.setText("30");
        startAgain.setVisibility(View.INVISIBLE);
        scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long l) {
                timer.setText(String.valueOf(l/1000)+"s");
            }

            @Override
            public void onFinish() {
                resultTextView.setText(" Done!");
                startAgain.setVisibility(View.VISIBLE);
            }
        }.start();
        newQuestion();
    }

}