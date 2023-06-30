package com.example.capcollect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button; //dhlwsh metavlhths button
    private Button button2; //dhlwsh metavlhths button2
    private Button button3; //dhlwsh metavlhths button3

    private Button button4; // dhlwsh metavlhths button4

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.calculatorbutton); // taftisi ths metavlhths button me to koumpi Plastic Calculator
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            } // otan patietai to koumpi Plastic Calculator kaleitai h methodos openActivity2
        });

        button2 = (Button) findViewById(R.id.missionsbutton); // taftish ths metavlhths button2 me to koumpi missions
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openActivity3();} // otan patietai to koumpi missions kaleitai h methodos openActivity3
        });

        button3 = (Button) findViewById(R.id.infobutton); // taftisi ths metavlhths button3 me to koumpi About Info
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity4();
            } // otan patietai to koumpi About Info kaleitai h methodos openActivity4
        });

        button4 = (Button) findViewById(R.id.helpbutton);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity6();
            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(this, Activity2.class);
                startActivity(intent); // anoigei to Plastic Calculator
    }

    public void openActivity3() {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent); // anoigei to missions
    }

    public void openActivity4() {
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent); // anoigei to about info
    }

    public void openActivity6() {
        Intent intent = new Intent(this, Activity6.class);
        startActivity(intent);
    }
}