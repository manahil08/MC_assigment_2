package com.example.mc_assigment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen2);
       Button  button=(Button)findViewById(R.id.button5);
       Button button2=(Button)findViewById(R.id.button6);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               gotoUrl("https://learn-quran-kids.com/tajweed/makharij-emission-points/");
           }
       });
       button2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               gotoUrl1("https://www.youtube.com/watch?v=NO24BDtrB9I");
           }
       });

    }
    private void gotoUrl(String s) {
        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
    private void gotoUrl1(String s) {
        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}