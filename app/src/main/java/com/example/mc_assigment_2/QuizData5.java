package com.example.mc_assigment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizData5 extends AppCompatActivity {
int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_data5);
        Intent prev_data=getIntent();
        String msg=prev_data.getStringExtra("score");
        score= Integer.valueOf(msg);  //converting to a value the score
        TextView textScore=findViewById(R.id.TextScore);
        textScore.setText("Score: "+msg);
        Button btn=findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendd=new Intent();
                sendd.setAction(Intent.ACTION_SEND);
                sendd.putExtra(Intent.EXTRA_TEXT,"my scores for Quiz are:"+msg);
                sendd.setType("text/plain");
                Intent sharee=Intent.createChooser(sendd,null);
                startActivity(sharee);
            }
        });
    }
}