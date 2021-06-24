package com.example.iqtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button start_button;
    ImageView logo_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_button = findViewById(R.id.start_button);
        logo_image = findViewById(R.id.logo_image);
    }

    public void start_test(View view) {
        start_button.setVisibility(View.INVISIBLE);
        logo_image.setVisibility(View.INVISIBLE);
    }
}