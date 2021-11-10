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

public class QuizData4 extends AppCompatActivity {
    int qCounter=5;

    int totalQuestions=5;
    TextView textt,textQNo;
    RadioButton rb1,rb2,rb3,rb4,rb5,rb6;
    RadioGroup radiogroup;
    Button btn_next;
    int score;
    boolean answered;
    int randomNumber;
    String i_alpha;

    String tounge[]={ "ر","ت د ط","ظ ذ ث","ص ز س","ل","ن"};
    String rt_8="ل";
    String rt_6="ن";
    String  rt_4="ر";
    String tt_2="ت د ط";
    String tt_22="ظ ذ ث";
    String tc="ص ز س";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_data4);
        Intent prev_data=getIntent();
        String msg=prev_data.getStringExtra("score");
        score= Integer.valueOf(msg);  //converting to a value the score
        TextView   textScore=findViewById(R.id.TextScore);
        textScore.setText("Score: "+msg);




        Random r=new Random();
        randomNumber=r.nextInt(tounge.length);
        i_alpha=	tounge[randomNumber]; //saving in string

        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        rb3=findViewById(R.id.rb3);
        rb4=findViewById(R.id.rb4);
        rb5=findViewById(R.id.rb5);
        rb6=findViewById(R.id.rb6);
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
                        String s=Integer.toString(score);//sending data
                        Intent intt=new Intent(QuizData4.this,QuizData5.class);
                        intt.putExtra("score",s);
                        intt.putExtra("question_left",qCounter);
                        startActivity(intt);
                    }
                    else{
                        Toast.makeText(QuizData4.this,"please select an option",Toast.LENGTH_SHORT).show();
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
        rb5.setTextColor(Color.RED);
        rb6.setTextColor(Color.RED);
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
            case 5:
                rb5.setTextColor(Color.GREEN);

                break;
            case 6:
                rb6.setTextColor(Color.GREEN);

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
        if(i_alpha==rt_8)
        {
            return 1;
        }
        if(i_alpha==rt_6)
        {
            return 2;
        }
        if(i_alpha==rt_4)
        {
            return 3;
        }
        if(i_alpha==tt_2)
        {
            return 4;
        }
        if(i_alpha==tt_22)
        {
            return 5;
        }
        if(i_alpha==tc)
        {
            return 6;
        }
        return -1;
    }
}