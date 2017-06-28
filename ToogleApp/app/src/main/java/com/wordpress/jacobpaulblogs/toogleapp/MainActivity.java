package com.wordpress.jacobpaulblogs.toogleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        reset = (Button) findViewById(R.id.button3);
    }
    public void onButtonClick1(View v){
        button1.setEnabled(false);
        button2.setEnabled(true);
    }
    public void onButtonClick2(View v){
        button2.setEnabled(false);
        button1.setEnabled(true);
    }
    public void onButtonClick3(View v) {
        button1.setEnabled(true);
        button2.setEnabled(true);
    }
}
