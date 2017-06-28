package com.wordpress.jacobpaulblogs.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView result,display;
    private Button plus,minus,multiply,divide,equals,reset;
    private EditText number;
    private Integer number1, number2;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (TextView) findViewById(R.id.textView);
        number = (EditText) findViewById(R.id.editText);
        plus = (Button) findViewById(R.id.button1);
        minus = (Button) findViewById(R.id.button2);
        multiply = (Button) findViewById(R.id.button3);
        divide = (Button) findViewById(R.id.button4);
        equals = (Button) findViewById(R.id.button5);
        reset = (Button) findViewById(R.id.button6);
        View.OnClickListener ourOnClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                switch (v.getId()){
                    case R.id.button1:
                        operator = "+";
                        break;
                    case R.id.button2:
                        operator = "-";
                        break;
                    case R.id.button3:
                        operator = "*";
                        break;
                    case R.id.button4:
                        operator = "/";
                        break;
                }
                Button b = (Button)v;
                if ((display.getText().toString() == ""))
                    number1 = Integer.parseInt(number.getText().toString());
                else
                    number1 = Integer.parseInt(display.getText().toString());
                display.setText(number1+" "+b.getText());
                number.setText("");
            }
        };
        View.OnClickListener calculation = new View.OnClickListener(){
          @Override
            public void onClick(View v){
              number2 = Integer.parseInt(number.getText().toString());
              if (number2 != null)
                  switch (operator){
                      case "+":
                          display.setText(String.valueOf(number1 + number2));
                          number.setText("");
                          break;
                      case "-":
                          display.setText(String.valueOf(number1 - number2));
                          number.setText("");
                          break;
                      case "*":
                          display.setText(String.valueOf(number1 * number2));
                          number.setText("");
                          break;
                      case "/":
                          display.setText(String.valueOf(number1 / number2));
                          number.setText("");
                          break;
                  }
              else
                  Log.i("error","operator is empty");
          }
        };
        View.OnClickListener resetFunct = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                display.setText("");
                number.setText("");
            }
        };
        plus.setOnClickListener(ourOnClickListener);
        minus.setOnClickListener(ourOnClickListener);
        multiply.setOnClickListener(ourOnClickListener);
        divide.setOnClickListener(ourOnClickListener);
        equals.setOnClickListener(calculation);
        reset.setOnClickListener(resetFunct);
    }
}
