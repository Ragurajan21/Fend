package com.example.rajan.ps03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by HP on 6/14/2018.
 */

public class AboutActivity extends AppCompatActivity {
    TextView t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        t1 = (TextView) findViewById(R.id.t1);
        t1.setText("About");
        t1.setMovementMethod(new ScrollingMovementMethod());
    }
}
