package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
     private Switch modeBtn;
     private EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       modeBtn=findViewById(R.id.switch1);
       text=findViewById(R.id.textView);
       text.setShowSoftInputOnFocus(false);

       text.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
     if(getString(R.string.textfield).equals(text.getText().toString()))
         text.setText("");
           }
       });




       modeBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean chechked) {
              if(chechked){
                  getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
              }else{
                  getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
              }
           }
       });


    }



    private void addValue(String value){
        String val=text.getText().toString();
        int mousePosition= text.getSelectionStart();
        String left=val.substring(0,mousePosition);
        String right=val.substring(mousePosition);
        if(getString(R.string.textfield).equals(text.getText().toString())){
           text.setText("");
            text.setText(value);
            text.setSelection(mousePosition + 1);
        }else {


            text.setText((String.format("%S%S%S", left, value, right)));
            text.setSelection(mousePosition + 1);
        }


    }
    public void Zerobtn(View View){
        addValue("0");
    }
    public void onebtn(View View){
        addValue("1");
    }
    public void twobtn(View View){
        addValue("2");
    }
    public void threebtn(View View){
        addValue("3");
    }
    public void fourbtn(View View){
        addValue("4");
    }
    public void fivebtn(View View){
        addValue("5");
    }
    public void sixbtn(View View){
        addValue("6");
    }
    public void sevenbtn(View View){
        addValue("7");
    }
    public void eightbtn(View View){
        addValue("8");
    }
    public void ninebtn(View View){
        addValue("9");
    }
    public void dotbtn(View View){
        addValue(".");
    }
    public void multbtn(View View){
        addValue("*");
    }
    public void divbtn(View View){
        addValue("/");
    }
    public void modbtn(View View){
        addValue("%");
    }
    public void expobtn(View View){
        addValue("^");
    }
    public void Cbtn(View View){
        text.setText("");
    }
    public void delbtn(View View){
    int cur=text.getSelectionStart();
    int len=text.getText().length();
     if(cur!=0 && len !=0){
         SpannableStringBuilder string =(SpannableStringBuilder) text.getText();
         string.replace(cur-1,cur,"");
         text.setText(string);
         text.setSelection(cur-1);
     }





    }
    public void plusbtn(View View){
        addValue("+");
    }
    public void minusbtn(View View){
        addValue("-");
    }
    public void equalbtn(View View){
    String textString =text.getText().toString();
    Expression exp = new Expression(textString);
    String result =String.valueOf(exp.calculate());
    text.setText(result);
    text.setSelection(result.length());
    }




}