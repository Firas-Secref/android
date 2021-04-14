 package com.example.visitetechnique;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.HashMap;

 public class ThirdActivity extends AppCompatActivity {

    public HashMap<String, String> data = new HashMap<String, String>();
    CheckBox checkBox;
    Button btnNext;
    TextView conditions;
    public static String donnee;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        conditions = (TextView) findViewById(R.id.conditions);
        conditions.setMovementMethod(new ScrollingMovementMethod());

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        checkBox = (CheckBox) findViewById(R.id.checkBox) ;
        btnNext = (Button) findViewById(R.id.btn2Next);

        Intent i = getIntent();

        HashMap<String, String> data = (HashMap<String, String>) i.getSerializableExtra(secondActivity.donnee);

        Log.d("hashmap",""+data);

    }
     public void onCheckboxClicked(View view) {
         // Is the view now checked?
         boolean checked = ((CheckBox) view).isChecked();
            if (checked){
                btnNext.setEnabled(true);
            }else
                btnNext.setEnabled(false);
     }

     public void navigate(){
         Intent x = new Intent(this, Fourth.class);
         Intent i = getIntent();

         HashMap<String, String> data = (HashMap<String, String>) i.getSerializableExtra(secondActivity.donnee);

         Log.d("hashmap",""+data);

         x.putExtra(donnee, data);
         startActivity(x);
     }

     public void onClick(View view) {
        navigate();
     }
 }