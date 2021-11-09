package com.example.mc_assigment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Quiz extends AppCompatActivity {
    Button btn_start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        btn_start = (Button) findViewById(R.id.button_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotomyQuiz();
            }

            private void gotomyQuiz() {
                Intent my_intent = new Intent(Quiz.this, QuizData.class);
                startActivity(my_intent);
            }

        });
    }

    }