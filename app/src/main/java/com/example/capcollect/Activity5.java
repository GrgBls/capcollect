package com.example.capcollect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity5 extends AppCompatActivity {

    private Button button; // dhlwsh metavlhths button


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        button = (Button) findViewById(R.id.closebutton); // taftish ths metavlhths button me to antikeimeno closebutton
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3(); // otan patietai to koumpi, exoume kalesma ths methodou openActivity3
            }
        });
    }

    public void openActivity3() {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent); // anoigei to Activity 3
    }
}