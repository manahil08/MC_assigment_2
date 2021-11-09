package com.example.mc_assigment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button button_1;
    Button button_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        button_1=(Button)findViewById(R.id.button2);
        button_2=(Button)findViewById(R.id.button3);

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoQuiz();
            }
        });
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://github.com/manahil08/MC_assigment_2.git");
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoWebsite();
            }
            public void gotoWebsite()
            {
                Intent my_intent=new Intent(MainActivity.this,HomeScreen.class);
                startActivity(my_intent);
            }
        });
    }

    private void gotoQuiz() {
        Intent my_intent=new Intent(MainActivity.this,Quiz.class);
        startActivity(my_intent);
    }

    private void gotoUrl(String s) {
        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}