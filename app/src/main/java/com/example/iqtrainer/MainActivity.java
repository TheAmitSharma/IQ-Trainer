package com.example.iqtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView sumTextView;
    Button start_button;
    Button button0, button1, button2,button3;
    ImageView logo_image;
    TextView scoreTextView;
    ArrayList<Integer> answers = new ArrayList<>();
    int locationOfCorrectAnswer;
    TextView resultTextView;
    int score = 0;
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

        Random rand = new Random();
        locationOfCorrectAnswer = rand.nextInt(4);

        int a =rand.nextInt(21);
        int b =rand.nextInt(21);
        sumTextView.setText(Integer.toString(a) + "  +  " + Integer.toString(b));
        for (int i = 0; i < 4; i++){
            if(i == locationOfCorrectAnswer){
                answers.add(a + b);
            }else {
                int worngAnswer = rand.nextInt(41);
                while (worngAnswer == a+b){
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

    public void start_test(View view) {
        start_button.setVisibility(View.INVISIBLE);
        logo_image.setVisibility(View.INVISIBLE);
    }

    public void chooseAnswer(View view) {
         if ((Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString()))){
             resultTextView.setText("Correct!");
             score = score + 1;
        }
        else{
            resultTextView.setText("Wrong!");
        }
        numberOfQuestions = numberOfQuestions + 1;
        scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));

    }

    public void newQuestion(View view){
        Random rand = new Random();
        locationOfCorrectAnswer = rand.nextInt(4);

        int a =rand.nextInt(21);
        int b =rand.nextInt(21);
        sumTextView.setText(Integer.toString(a) + "  +  " + Integer.toString(b));
        for (int i = 0; i < 4; i++){
            if(i == locationOfCorrectAnswer){
                answers.add(a + b);
            }else {
                int worngAnswer = rand.nextInt(41);
                while (worngAnswer == a+b){
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
}