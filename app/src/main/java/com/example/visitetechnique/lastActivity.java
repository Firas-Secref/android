package com.example.visitetechnique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.HashMap;

public class lastActivity extends AppCompatActivity {

    String immatriculation, date, heure;
    TextView tImmatriculation, tDate, tHeure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        tImmatriculation = (TextView) findViewById(R.id.immatriculation);
        tDate = (TextView) findViewById(R.id.dateH);
        tHeure = (TextView) findViewById(R.id.heureD) ;
        Intent i = getIntent();
        HashMap<String, String> data = (HashMap<String, String>) i.getSerializableExtra(Fourth.donnee);
        Log.d("data", ""+data);
        tDate.setText(data.get("date"));
        tHeure.setText(data.get(""));
//        tImmatriculation.setText(data.get());
    }

}