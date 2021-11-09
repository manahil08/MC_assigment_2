package com.example.mc_assigment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
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
}