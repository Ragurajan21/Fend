package com.example.rajan.ps03;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Button;
import android.widget.Toast;

import com.example.rajan.ps03.R;

public class TimeActivity extends AppCompatActivity {

EditText ed1;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        ed1 = findViewById(R.id.ed1);
        b = findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time =ed1.getText().toString();
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(TimeActivity.this);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("time",time);
                editor.apply();

                Toast.makeText(TimeActivity.this, "saved", Toast.LENGTH_SHORT).show();
            }
        });


    }


}