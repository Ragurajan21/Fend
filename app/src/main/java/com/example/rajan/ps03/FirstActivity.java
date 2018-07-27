package com.example.rajan.ps03;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class FirstActivity extends AppCompatActivity {
    VideoView video;
    Button b;
    private Boolean firstTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        video =findViewById(R.id.video);


        SharedPreferences settings = getSharedPreferences("PREFS", 0);
        firstTime = settings.getBoolean("first_time_Strat", true);
        if(firstTime){
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("first_time_Strat", false);
            editor.commit();
            Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.intro);
            video.setVideoURI(uri);
            video.start();
            b =findViewById(R.id.b);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(FirstActivity.this,NumberActivity.class);
                    startActivity(i);
                }
            });
        }
        else {
            Intent i =new Intent(FirstActivity.this,SecondActivity.class);
            startActivity(i);
        }




    }
}
