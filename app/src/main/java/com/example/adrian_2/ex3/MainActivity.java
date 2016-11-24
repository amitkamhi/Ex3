package com.example.adrian_2.ex3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher{

    private double first;
    private char operator;
    private double second;
    private double res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText first = (EditText) findViewById(R.id.enterFirst);
        first.addTextChangedListener(this);
    }

    public void reset(View view){
        res = 0;
        first = 0;
        second = 0;
        operator = '\u0000';

        EditText first = (EditText) findViewById(R.id.enterFirst);
        first.setText(null);
        EditText second = (EditText) findViewById(R.id.enterSecond);
        second.setText(null);
        changeButtonState(false);
        TextView myTextView = (TextView) findViewById(R.id.answer);
        myTextView.setText(null);
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


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        EditText first = (EditText) findViewById(R.id.enterFirst);
        changeButtonState(!(first.getText().toString().isEmpty()));
    }

    private void changeButtonState(Boolean newState){
        findViewById(R.id.buttonAdd).setEnabled(newState);
        findViewById(R.id.buttonMinus).setEnabled(newState);
        findViewById(R.id.buttonMulti).setEnabled(newState);
        findViewById(R.id.buttonDivisin).setEnabled(newState);
        findViewById(R.id.buttonAnswer).setEnabled(newState);
    }
}
