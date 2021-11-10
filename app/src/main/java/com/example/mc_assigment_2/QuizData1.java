package com.example.mc_assigment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class QuizData1 extends AppCompatActivity {
    int qCounter=1;
    int totalQuestions=5;
    TextView textt,textQNo;
    RadioButton rb1,rb2,rb3;
    RadioGroup radiogroup;
    Button btn_next;
    int score;
    boolean answered;
    int randomNumber;
    String i_alpha;

    String nose[]={ "م","ن"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_data1);

        Intent prev_data=getIntent();
        String msg=prev_data.getStringExtra("score");
        //score= Integer.valueOf(msg);  //converting to a value the score
        TextView   textScore=findViewById(R.id.TextScore);
        textScore.setText(msg);




        Random r=new Random();
        randomNumber=r.nextInt(nose.length);
        i_alpha=	nose[randomNumber]; //saving in string

        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        rb3=findViewById(R.id.rb3);
        textQNo=findViewById(R.id.textQuestionNo);

        radiogroup=findViewById(R.id.radioGroup);
        btn_next=findViewById(R.id.btnNext);

        textt=findViewById(R.id.textQuestion);
        textt.setText(i_alpha);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered==false)
                {
                    if(rb1.isChecked()||rb2.isChecked()||rb3.isChecked())
                    {
                        checkAnswer();
                        Intent intt=new Intent(QuizData1.this,QuizData2.class);
                        intt.putExtra("score",score);
                        intt.putExtra("question_left",qCounter);
                        startActivity(intt);
                    }
                    else{
                        Toast.makeText(QuizData1.this,"please select an option",Toast.LENGTH_SHORT).show();
                    }
                }else
                {
                    //move to next page +send the score
                }
            }
        });




    }

    private void checkAnswer()
    {
        answered=true;
        qCounter++;
        RadioButton rbselected= findViewById(radiogroup.getCheckedRadioButtonId());
        int answer_no=radiogroup.indexOfChild(rbselected)+1;
        if(answer_no==getCorrectAnswer())
        {
            score++;
            TextView   textScore=findViewById(R.id.TextScore);
            textScore.setText("Score: "+score);

        }
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        switch(getCorrectAnswer())
        {
            case 1:
                rb1.setTextColor(Color.GREEN);

                break;
            case 2:
                rb2.setTextColor(Color.GREEN);

                break;

            case 3:
                rb3.setTextColor(Color.GREEN);

                break;

        }
        if(qCounter<totalQuestions)
        {
            btn_next.setText("Next");
        }
        else
        {
            btn_next.setText("Finish");
        }


    }

    private int getCorrectAnswer() {
  return 2;
    }



}