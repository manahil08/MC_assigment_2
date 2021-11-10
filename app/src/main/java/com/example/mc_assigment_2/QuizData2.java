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

public class QuizData2 extends AppCompatActivity {
    int qCounter=3;

    int totalQuestions=5;
    TextView textt,textQNo;
    RadioButton rb1,rb2,rb3,rb4;
    RadioGroup radiogroup;
    Button btn_next;
    int score;
    boolean answered;
    int randomNumber;
    String i_alpha;

    String lip[]={ "ف","ب","م","و"};
    String tip="ف";
    String in_both="ب";
   String  out_both="م";
   String roud_both="و";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_data2);

        Intent prev_data=getIntent();
        String msg=prev_data.getStringExtra("score");
        score= Integer.valueOf(msg);  //converting to a value the score
        TextView   textScore=findViewById(R.id.TextScore);
        textScore.setText("Score: "+msg);




        Random r=new Random();
        randomNumber=r.nextInt(lip.length);
        i_alpha=	lip[randomNumber]; //saving in string

        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        rb3=findViewById(R.id.rb3);
        rb4=findViewById(R.id.rb4);
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
                        Intent intt=new Intent(QuizData2.this,QuizData3.class);
                        intt.putExtra("score",score);
                        intt.putExtra("question_left",qCounter);
                        startActivity(intt);
                    }
                    else{
                        Toast.makeText(QuizData2.this,"please select an option",Toast.LENGTH_SHORT).show();
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
        rb4.setTextColor(Color.RED);
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
            case 4:
                rb4.setTextColor(Color.GREEN);

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
        if(i_alpha==tip)
        {
            return 1;
        }
        if(i_alpha==in_both)
        {
            return 2;
        }
        if(i_alpha==out_both)
        {
            return 3;
        }
        if(i_alpha==roud_both)
        {
            return 4;
        }
        return -1;
    }
}