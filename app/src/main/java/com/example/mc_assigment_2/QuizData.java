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

public class QuizData extends AppCompatActivity {
    int qCounter=1;
    int totalQuestions=5;
    TextView textt,textQNo,textScore;
    RadioButton rb1,rb2,rb3;
    RadioGroup radiogroup;
    Button btn_next;
    int score;
    boolean answered;
    int randomNumber;
    String i_alpha;
    String throat[]={ "ہ", "ع","ح","أ","غ","خ"};
    int m_throat=1,e_throat=2,s_throat=3;
    String middle_t[]={"ح","ع"};
    String start_t[]={"خ","غ"};
    String end_t[]={"أ","ة"};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_data);

        Random r=new Random();
        randomNumber=r.nextInt(throat.length);
         i_alpha=	throat[randomNumber]; //saving in string

        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        rb3=findViewById(R.id.rb3);
        textQNo=findViewById(R.id.textQuestionNo);
        textScore=findViewById(R.id.TextScore);
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
                        String s=Integer.toString(score);//sending data
                        Intent intt=new Intent(QuizData.this,QuizData1.class);
                        intt.putExtra("score",s);
                        intt.putExtra("question_left",qCounter);
                        startActivity(intt);
                    }
                    else{
                        Toast.makeText(QuizData.this,"please select an option",Toast.LENGTH_SHORT).show();
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

    private int getCorrectAnswer() { //change kroo
        for(int j=0;j<start_t.length;j++)
        {
            if(i_alpha==start_t[j])
            {
                return 1;
            }

        }
        for(int j=0;j<middle_t.length;j++)
        {
            if(i_alpha==middle_t[j])
            {
                return 2;
            }

        }
        for(int j=0;j<end_t.length;j++)
        {
            if(i_alpha==end_t[j])
            {
                return 3;
            }

        }
        return -1;
    }
}