package com.example.capcollect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    EditText input1; // dhlwsh gia input xrhsth
    Button calc;

    Button home;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        input1 = findViewById(R.id.enterinput); // taftish ths metavlhths input1 me to enterinput antikeimeno
        calc = findViewById(R.id.calculateresultbutton); // taftish ths metavlhths calc me to koumpi tou layer (leitourgei san koumpi enter)
        home = findViewById(R.id.homebutton);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity1();
            }
        });

    }
    public void mul(View view){
        Integer i = Integer.parseInt(input1.getText().toString()); // metatrepei to input tou xrhsth apo morfh string se akeraio arithmo
        Integer k = i * 5; // ena plastiko kapaki isoutai me 5 grammaria plastikou sto peripou
        Toast.makeText(this, "You have recycled " + k + " grams of plastic", Toast.LENGTH_SHORT).show(); // emfanizei mhnyma ston xrhsth, enhmerwnontas ton gia to posa gr exei anakyklwsei
    }

    public void openActivity1(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }




}
