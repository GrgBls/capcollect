package com.example.capcollect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.lang.Math;
public class Activity3 extends AppCompatActivity {

    private Button button;
    private Button home;

    private int n; // dhlwsh akeraiou o opoios antilamvanetai se poia apostolh vrisketai o xrhsths twrina
    private int l; // dhlwsh akeraiou gia to level tou xrhsth
    public int n2; // dhlwsh akeraiou gia ton arithmo twn apostolwn pou exei oloklhrwsei o xrhsths

    private TextView textviewmission; // dhlwsh TextView to opoio tha parousiazei thn twrinh apostolh ston xrhsth
    private TextView level; // dhlwsh TextView to opoio tha parousiazei to level tou xrhsth

    private TextView xp;

    String[] missionarray = {"Tide up your room and try to find plastic caps. Go and recycle them",
            "Recycle three bottle caps", "Research the topic of recycling more. Try finding any videos or documentaries about it",
            "Recycle one bottle cap", "Recycle two plastic bottles", "Come up with ways to reduce your CO2 footprint",
            "Go to work/school on feet, or use a bicycle", "Use a seperate trash bag for items which can be recycled",
            "Recycle five bottle caps", "Recycle over 10 grams of plastic(Hint: use the plastic calculator)",
            "Switch your default search engine from Google to Ecosia", "Recycle ten bottle caps", "Recycle seven bottle caps",
            "Go grocery-shopping with a reusable bag", "Recycle five plastic bottles"}; // dhlwsh String array to opoio periexei 15 apostoles


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        button = findViewById(R.id.completebutton); // taftish metavlhths button me to koumpi completeButton
        textviewmission = findViewById(R.id.missiondisplay); // taftish metavlhths textviewmission me to textview missiondisplay
        level = findViewById(R.id.leveltext); // taftish metavlhths level me to textview leveltext
        xp = findViewById(R.id.xptextview);
        home = findViewById(R.id.homebutton2);


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this); // xrhsh ths SharedPreferences gia na thymatai h efarmogh thn proodo tou xrhsth
        n = prefs.getInt("n", 0); // Arxikh n = 0; (profanws ksekiname apo thn prwth apostolh)
        l = prefs.getInt("l", 1); // Arxiko level = 1
        n2 = prefs.getInt("n2", 1); // Arxiko n2 = 1

        level.setText("Level: " + l); // Emfanizei sthn othonh to level
        if (l < 10) { xp.setText("XP: " + 1000 * n2); }
        else {xp.setText("XP: " + 1000 * 26);}

        textviewmission.setText(missionarray[n]); // Emfanizei thn twrinh apostolh ston xrhsth

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity1();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increasen(); // kalei thn methodo h opoia afksanei ton arithmo n, wste na perasoume sthn epomenh apostolh
                increasel(); // Kalei thn methodo l h opoia afksanei to epipedo tou xrhsth
                level.setText("Level: " + l); // emfanizei to kainourio level tou xrhsth
                textviewmission.setText(missionarray[n]); // emfanizei thn epomenh apostolh ston xrhsth
                if (l < 10) { xp.setText("XP: " + 1000 * n2); }
                else {xp.setText("XP: " + 1000 * 26);}
                openActivity5(); // kalei thn methodo openActivity5
            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit(); // epeksergazetai ta preferences ths efarmoghs wste na ananewthei o arithmos n
        editor.putInt("n", n); // enhmerwnei ton arithmo n
        editor.putInt("n2", n2); // enhmerwnei ton arithmo n2
        editor.putInt("l", l); // enhmerwnei ton arithmo l
        editor.apply(); // efarmozei tous ananewmenous arithmous
    }

    public void openActivity5() {
        Intent intent = new Intent(this, Activity5.class);
        startActivity(intent); // anoigei thn Activity5
    }

    public void increasen() {
        n2 = n2 + 1; // afksanetai to n2 ana mia monada (o xrhsths proxwraei sthn epomenh apostolh)
        if (n == 14) {
            n = 0; // se periptwsh pou o xrhsths exei oloklhrwsei kai tis 15 apostoles, oi apostoles ksekinane apo thn arxh
        }
        else {
            n = n + 1; // afksanetai o arithmos n ana mia monada
        }

    }

    public void increasel(){
        float equation = Math.round(2.942 * Math.log(n2)); // logarithmikos typos pou ypologizei to epipedo tou xrhsth (apo excel trendline)
        if (equation <= 10){ // megisto epipedo to 10;
            l = (int) equation;
    }
        else{
            l = 10; // den yparxei allo epipedo meta to 10
        }
    }

    public void startActivity1(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}