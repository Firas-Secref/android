package com.example.visitetechnique;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Fourth extends AppCompatActivity {

    Spinner spDate, spCentre;
    static String donnee;
    String date, place;
    private ArrayList<Dates> dateList;
    private DateAdapter dAdapter;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        initlist();

        spDate = (Spinner) findViewById(R.id.spDate);
        spCentre = (Spinner) findViewById(R.id.spCentre) ;


        dAdapter = new DateAdapter(this, dateList);
        spDate.setAdapter(dAdapter);
        spDate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Dates clickedItem = (Dates) parent.getItemAtPosition(position);
                LocalDate ll = clickedItem.getDate();
                date = ll.toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spCentre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                place = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @SuppressLint("NewApi")
    private void initlist() {
        dateList = new ArrayList<>();
        LocalDate today = LocalDate.now().plusMonths(1);
        for (int i =1; i<=10; i++){
            dateList.add(new Dates(today.plusDays(i)));
        }
    }

    public void onClick(View view) {
        navigate();
    }

    public void navigate(){

        Intent i = getIntent();

        HashMap<String, String> data = (HashMap<String, String>) i.getSerializableExtra(ThirdActivity.donnee);
        data.put("centre", place);
        data.put("date", date);
        Log.d("hashmap",""+data);
        Intent x = new Intent(this, lastActivity.class);
        x.putExtra(donnee, data);
        startActivity(x);
    }
}