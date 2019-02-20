package com.example.a10013063.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonPlus;
    Button buttonMinus;
    Button buttonEqual;
    Button buttonMultiply;
    Button buttonDivide;
    Button buttonClear;
    TextView input;
    TextView result;
    String modifyText;
    String resultText;
    boolean replaceZero = true;
    String outcome = "";
    boolean lastOperator = false;
    boolean nextEx = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = findViewById(R.id.id_button_0);
        button1 = findViewById(R.id.id_button_1);
        button2 = findViewById(R.id.id_button_2);
        button3 = findViewById(R.id.id_button_3);
        button4 = findViewById(R.id.id_button_4);
        button5 = findViewById(R.id.id_button_5);
        button6 = findViewById(R.id.id_button_6);
        button7 = findViewById(R.id.id_button_7);
        button8 = findViewById(R.id.id_button_8);
        button9 = findViewById(R.id.id_button_9);
        buttonPlus = findViewById(R.id.id_button_plus);
        buttonMinus = findViewById(R.id.id_button_minus);
        buttonDivide = findViewById(R.id.id_button_divide);
        buttonMultiply = findViewById(R.id.id_button_multiply);
        buttonEqual = findViewById(R.id.id_button_equal);
        buttonClear = findViewById(R.id.id_button_clear);
        input = findViewById(R.id.id_textview_input);
        result = findViewById(R.id.id_textview_result);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonClear.setOnClickListener(this);

    }

    public static String calculate(String modifyText){
        if(modifyText.charAt(0) == '-')
            modifyText = "0" + modifyText;

        ArrayList<String> array1 = new ArrayList<>(Arrays.asList(modifyText.split("\\+|\\-")));

        ArrayList<Boolean> operators = new ArrayList<>();
        for (int i=0; i < modifyText.length(); i++){
            if (modifyText.charAt(i) == '+')
                operators.add(true);
            else if(modifyText.charAt(i) == '-')
                operators.add(false);
        }

        ArrayList<Boolean> operators2 = new ArrayList<>();
        for (int i=0; i < modifyText.length(); i++){
            if (modifyText.charAt(i) == '*'){
                operators2.add(true);
            }
            else if(modifyText.charAt(i) == '÷')
                operators2.add(false);
        }


        for(int i = 0; i< array1.size(); i++){
            if(array1.get(i).contains("*")){
                double x = Double.parseDouble(array1.get(i).substring(0,array1.get(i).indexOf('*'))) * Double.parseDouble(array1.get(i).substring(array1.get(i).indexOf('*')+1));
                array1.set(i,Double.toString(x));

            }
            else if(array1.get(i).contains("÷")){
                double x = Double.parseDouble(array1.get(i).substring(0,array1.get(i).indexOf('÷'))) / Double.parseDouble(array1.get(i).substring(array1.get(i).indexOf('÷')+1));
                array1.set(i,Double.toString(x));
            }

        }


        int operatorCount = 0;
        while(array1.size()>1){ //adding left to right
            if(operators.get(operatorCount)){
                array1.set(0, Double.toString(Double.parseDouble(array1.get(0)) + Double.parseDouble(array1.remove(1))));
            }
            else{
                array1.set(0, Double.toString(Double.parseDouble(array1.get(0)) - Double.parseDouble(array1.remove(1))));
            }
            operatorCount++;
        }


        modifyText = array1.get(0);

        if(Double.parseDouble(modifyText) == (int)(Double.parseDouble(modifyText)))
            modifyText = Integer.toString((int)(Double.parseDouble(modifyText)));
        if(modifyText.equals("Infinity") || modifyText.equals("-Infinity") || modifyText.equals("NaN"))
            modifyText = "Error";
        return modifyText;
    }

    @Override
    public void onClick(View v) {
        if(replaceZero) {
            result.setText("");
            input.setText("Enter expression");
        }
        replaceZero = false;
        modifyText = input.getText().toString();
        switch(v.getId()) {
            case R.id.id_button_0:
                if(nextEx) {
                    outcome = "";
                    modifyText = "0";
                    nextEx = false;
                }
                else {
                    modifyText += "0";
                }
                try{
                    outcome =  calculate(modifyText);
                    input.setTextSize(50);
                    result.setTextSize(30);
                }catch(Exception E) {

                }

                resultText = outcome;
                lastOperator = false;
                break;
            case R.id.id_button_1:
                if(nextEx) {
                    outcome = "";
                    modifyText = "1";
                    nextEx = false;
                }
                else {
                    modifyText += "1";
                }
                try{
                    outcome =  calculate(modifyText);
                    input.setTextSize(50);
                    result.setTextSize(30);
                }catch(Exception E) {

                }

                resultText = outcome;
                lastOperator = false;
                break;
            case R.id.id_button_2:
                if(nextEx) {
                    outcome = "";
                    modifyText = "2";
                    nextEx = false;
                }
                else {
                    modifyText += "2";
                }
                try{
                    outcome =  calculate(modifyText);
                    input.setTextSize(50);
                    result.setTextSize(30);
                }catch(Exception E) {
                    outcome = "Error";
                    result.setTextSize(50);
                }

                resultText = outcome;
                lastOperator = false;
                break;
            case R.id.id_button_3:
                if(nextEx) {
                    outcome = "";
                    modifyText = "3";
                    nextEx = false;
                }
                else {
                    modifyText += "3";
                }
                try{
                    outcome =  calculate(modifyText);
                    input.setTextSize(50);
                    result.setTextSize(30);
                }catch(Exception E) {
                    outcome = "Error";
                    result.setTextSize(50);
                }

                resultText = outcome;
                lastOperator = false;
                break;
            case R.id.id_button_4:
                if(nextEx) {
                    outcome = "";
                    modifyText = "4";
                    nextEx = false;
                }
                else {
                    modifyText += "4";
                }
                try{
                    outcome =  calculate(modifyText);
                    input.setTextSize(50);
                    result.setTextSize(30);
                }catch(Exception E) {
                    outcome = "Error";
                    result.setTextSize(50);
                }

                resultText = outcome;
                lastOperator = false;
                break;
            case R.id.id_button_5:
                if(nextEx) {
                    outcome = "";
                    modifyText = "5";
                    nextEx = false;
                }
                else {
                    modifyText += "5";
                }
                try{
                    outcome =  calculate(modifyText);
                    input.setTextSize(50);
                    result.setTextSize(30);
                }catch(Exception E) {
                    outcome = "Error";
                    result.setTextSize(50);
                }

                resultText = outcome;
                lastOperator = false;
                break;
            case R.id.id_button_6:
                if(nextEx) {
                    outcome = "";
                    modifyText = "6";
                    nextEx = false;
                }
                else {
                    modifyText += "6";
                }
                try{
                    outcome =  calculate(modifyText);
                    input.setTextSize(50);
                    result.setTextSize(30);
                }catch(Exception E) {
                    outcome = "Error";
                    result.setTextSize(50);
                }

                resultText = outcome;
                lastOperator = false;
                break;
            case R.id.id_button_7:
                if(nextEx) {
                    outcome = "";
                    modifyText = "7";
                    nextEx = false;
                }
                else {
                    modifyText += "7";

                }
                try{
                    outcome =  calculate(modifyText);
                    input.setTextSize(50);
                    result.setTextSize(30);
                }catch(Exception E) {
                    outcome = "Error";
                    result.setTextSize(50);
                }

                resultText = outcome;
                lastOperator = false;
                break;
            case R.id.id_button_8:
                if(nextEx) {
                    outcome = "";
                    modifyText = "8";
                    nextEx = false;
                }
                else {
                    modifyText += "8";

                }
                try{
                    outcome =  calculate(modifyText);
                    input.setTextSize(50);
                    result.setTextSize(30);
                }catch(Exception E) {
                    outcome = "Error";
                    result.setTextSize(50);
                }

                resultText = outcome;
                lastOperator = false;
                break;
            case R.id.id_button_9:
                if(nextEx) {
                    outcome = "";
                    modifyText = "9";
                    nextEx = false;
                }
                else {
                    modifyText += "9";

                }
                try{
                    outcome =  calculate(modifyText);
                    input.setTextSize(50);
                    result.setTextSize(30);
                }catch(Exception E) {
                    outcome = "Error";
                    result.setTextSize(50);
                }

                resultText = outcome;
                lastOperator = false;
                break;
            case R.id.id_button_clear:
                modifyText = "0";
                resultText = "0";
                outcome = "";
                lastOperator = false;
                replaceZero = true;
                input.setTextSize(50);
                result.setTextSize(30);
                nextEx = true;
                break;
            case R.id.id_button_plus:
                if(!lastOperator)
                    modifyText += "+";
                else
                    modifyText = modifyText.substring(0,modifyText.length()-1) + "+";
                input.setTextSize(50);
                result.setTextSize(30);
                lastOperator = true;
                nextEx = false;
                break;
            case R.id.id_button_minus:
                if(!lastOperator)
                    modifyText += "-";
                else
                    modifyText = modifyText.substring(0,modifyText.length()-1) + "-";
                input.setTextSize(50);
                result.setTextSize(30);
                lastOperator = true;
                nextEx = false;
                break;
            case R.id.id_button_multiply:
                if(!lastOperator)
                    modifyText += "*";
                else
                    modifyText = modifyText.substring(0,modifyText.length()-1) + "*";
                input.setTextSize(50);
                result.setTextSize(30);
                lastOperator = true;
                nextEx = false;
                break;
            case R.id.id_button_divide:
                if(!lastOperator)
                    modifyText += "÷";
                else
                    modifyText = modifyText.substring(0,modifyText.length()-1) + "÷";
                input.setTextSize(50);
                result.setTextSize(30);
                lastOperator = true;
                nextEx = false;
                break;
            case R.id.id_button_equal:
                try{
                   resultText =  calculate(modifyText);
                }catch(Exception E) {
                    resultText = "Error";
                }
                input.setTextSize(30);
                result.setTextSize(50);
                lastOperator = false;
                nextEx = true;
                break;

        }
        input.setText(modifyText);
        result.setText(resultText);
    }
}
