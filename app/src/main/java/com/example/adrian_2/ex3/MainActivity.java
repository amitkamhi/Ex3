package com.example.adrian_2.ex3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private double first;
    private char operator;
    private double second;
    private double res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void resetResult(View view){
        res = 0;
        String ans = Double.toString(res);
        TextView myTextView = (TextView) findViewById(R.id.answer);
        myTextView.setText(ans);
    }

    public void pressAdd(View view){
        operator ='+';
    }

    public void pressMinus(View view){
        operator ='-';
    }

    public void pressMulti(View view){
        operator ='*';
    }

    public void pressDivision(View view){
        operator ='/';
    }

    public void result(View view){
        EditText num1 = (EditText) findViewById(R.id.enterFirst);
        String num = num1.getText().toString();
        Log.d("myTag", "num=" + num);
        if (!num.isEmpty())
            first = Double.valueOf(num).doubleValue();
        Log.d("myTag", "first=" + first);

        if (num.isEmpty()){
            String message = getResources().getString(R.string.emptyNumber1);
            Toast.makeText(this,String.format(message), Toast.LENGTH_SHORT).show();
            return;}

        EditText num2 = (EditText) findViewById(R.id.enterSecond);
        num = num2.getText().toString();
        Log.d("myTag", "num=" + num);
        if (!num.isEmpty())
            second = Double.valueOf(num).doubleValue();
        Log.d("myTag", "second=" + second);

        if (num.isEmpty()){
            String message = getResources().getString(R.string.emptyNumber2);
            Toast.makeText(this,String.format(message), Toast.LENGTH_SHORT).show();
            return;}

        if (operator == '\u0000'){
            String message = getResources().getString(R.string.noOp);
            Toast.makeText(this,String.format(message), Toast.LENGTH_SHORT).show();
            return;}
        Log.d("myTag", "operator= " + operator);
        switch(operator){
            case '+':
                res = first + second;
                break;
            case '-':
                res = first - second;
                break;
            case '*':
                res = first * second;
                break;
            case '/':
                res = first / second;

        }
        String ans = Double.toString(res);
        TextView myTextView = (TextView) findViewById(R.id.answer);
        myTextView.setText(ans);
      //  Log.d("myTag", "res=" + res);
    }
}
