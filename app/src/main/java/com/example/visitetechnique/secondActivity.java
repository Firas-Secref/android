package com.example.visitetechnique;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class secondActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {



    static String donnee;
    public HashMap<String, String> data = new HashMap<String, String>();
    private int nbField ;

    Spinner spChoises;
    View fields;
    Button next;
    TextView serie1, serie2, serie3, serie4, numero1, numero2, nChassis, label, label2;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        spChoises = (Spinner) findViewById(R.id.spinner);
        fields = (View) findViewById(R.id.bottom);
        spChoises.setOnItemSelectedListener(this);
        next = (Button) findViewById(R.id.btnNext);
//        next.setEnabled(false);
        serie1 = (TextView) findViewById(R.id.nSerie1);
        serie2 = (TextView) findViewById(R.id.nSerie2);
        serie3 = (TextView) findViewById(R.id.nSerie3);
        serie4 = (TextView) findViewById(R.id.serie4);

        numero1 = (TextView) findViewById(R.id.numero1);
        numero2 = (TextView) findViewById(R.id.numero2);
        nChassis = (TextView) findViewById(R.id.nChassis);
        label = (TextView) findViewById(R.id.label1);
        label2 = (TextView) findViewById(R.id.label2);

               fields.setVisibility(View.GONE);
        Log.d("testttt0"," "+fields.getVisibility());

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( serie1.getVisibility() == View.VISIBLE && TextUtils.isEmpty(serie1.getText()) ){
                    serie1.setError("Ce champs est obligatoire");return;
                }else if(serie1.getVisibility() == View.VISIBLE && serie1.getText().length() !=0){
                    data.put("serie1", serie1.getText().toString());
                }
                if( serie2.getVisibility() == View.VISIBLE && TextUtils.isEmpty(serie2.getText())){
                    serie2.setError("Ce champs est obligatoire");return;
                }else if(serie2.getVisibility() == View.VISIBLE && serie2.getText().length() !=0){
                    data.put("serie2", serie2.getText().toString());
                }

                if( numero1.getVisibility() == View.VISIBLE && TextUtils.isEmpty(numero1.getText())){
                    numero1.setError("Ce champs est obligatoire");return;
                }else if(numero1.getVisibility() == View.VISIBLE && numero1.getText().length() !=0){
                    data.put("numero1", numero1.getText().toString());
                }
                if( numero2.getVisibility() == View.VISIBLE && TextUtils.isEmpty(numero2.getText())){
                    numero2.setError("Ce champs est obligatoire");return;
                }else if(numero2.getVisibility() == View.VISIBLE && numero2.getText().length() !=0){
                    data.put("numero2", numero2.getText().toString());
                }
                if( nChassis.getVisibility() == View.VISIBLE && TextUtils.isEmpty(nChassis.getText())){
                    nChassis.setError("Ce champs est obligatoire");return;
                }else if(nChassis.getVisibility() == View.VISIBLE && nChassis.getText().length() !=0){
                    data.put("nChassis", nChassis.getText().toString());
                }

                if( serie3.getVisibility() == View.VISIBLE && TextUtils.isEmpty(nChassis.getText())){
                    serie3.setError("Ce champs est obligatoire");return;
                }else if(serie3.getVisibility() == View.VISIBLE && serie3.getText().length() !=0){
                    data.put("serie3", serie3.getText().toString());
                }

                if( serie4.getVisibility() == View.VISIBLE && TextUtils.isEmpty(nChassis.getText())){
                    serie4.setError("Ce champs est obligatoire");return;
                }else if(serie4.getVisibility() == View.VISIBLE && serie4.getText().length() !=0){
                    data.put("serie4", serie4.getText().toString());
                }

                navigate();
                Log.d("hashmap", ""+data);

                return;
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position != 0)
            fields.setVisibility(View.VISIBLE);
        else
            fields.setVisibility(View.GONE);

        switch (position){
            case 1:
                serie3.setVisibility(View.GONE);
                serie4.setVisibility(View.GONE);

                serie1.setVisibility(View.VISIBLE);
                serie2.setVisibility(View.VISIBLE);
                numero1.setVisibility(View.VISIBLE);
                numero2.setVisibility(View.VISIBLE);
                label.setVisibility(View.VISIBLE);
                label.setText("TU تونس");
                data.put("type_Immatriculation", "TU تونس");
                label2.setText("TU تونس");
                nbField = 5;
                break;

            case 2:
                serie3.setVisibility(View.VISIBLE);
                serie4.setVisibility(View.VISIBLE);

                serie1.setVisibility(View.GONE);
                serie2.setVisibility(View.GONE);
                numero1.setVisibility(View.GONE);
                numero2.setVisibility(View.GONE);
                label.setVisibility(View.VISIBLE);
                label.setText("ن ت");
                data.put("type_Immatriculation", "ن ت");

                label2.setText("ن ت");
                nbField = 3;


                break;

            case 3:
                serie3.setVisibility(View.VISIBLE);
                serie4.setVisibility(View.VISIBLE);

                serie1.setVisibility(View.GONE);
                serie2.setVisibility(View.GONE);
                numero1.setVisibility(View.GONE);
                numero2.setVisibility(View.GONE);
                label.setVisibility(View.VISIBLE);
                label.setText("د ن");
                label2.setText("د ن");
                data.put("type_Immatriculation", "د ن");

                nbField = 3;

                break;

            case 4:
                serie3.setVisibility(View.VISIBLE);
                serie4.setVisibility(View.VISIBLE);

                serie1.setVisibility(View.GONE);
                serie2.setVisibility(View.GONE);
                numero1.setVisibility(View.GONE);
                numero2.setVisibility(View.GONE);
                label.setVisibility(View.VISIBLE);
                label.setText("ج ف");
                label2.setText("ج ف");
                data.put("type_Immatriculation", "ج ف");

                nbField = 3;

                break;

            case 5:
                serie3.setVisibility(View.GONE);
                serie4.setVisibility(View.GONE);

                serie1.setVisibility(View.VISIBLE);
                serie2.setVisibility(View.VISIBLE);
                numero1.setVisibility(View.VISIBLE);
                numero2.setVisibility(View.VISIBLE);
                label.setVisibility(View.VISIBLE);
                label.setText("م إ ف");
                label2.setText("م إ ف");
                data.put("type_Immatriculation", "م إ ف");

                nbField = 5;

                break;

            case 6:
                serie3.setVisibility(View.GONE);
                serie4.setVisibility(View.GONE);

                serie1.setVisibility(View.VISIBLE);
                serie2.setVisibility(View.VISIBLE);
                numero1.setVisibility(View.VISIBLE);
                numero2.setVisibility(View.VISIBLE);
                label.setVisibility(View.VISIBLE);
                label.setText("ر ب د");
                label2.setText("ر ب د");
                data.put("type_Immatriculation", "ر ب د");

                nbField = 5;

                break;

            case 7:
                serie3.setVisibility(View.GONE);
                serie4.setVisibility(View.GONE);

                serie1.setVisibility(View.VISIBLE);
                serie2.setVisibility(View.VISIBLE);
                numero1.setVisibility(View.VISIBLE);
                numero2.setVisibility(View.VISIBLE);
                label.setVisibility(View.VISIBLE);
                label.setText("س د");
                label2.setText("س د");
                data.put("type_Immatriculation", "س د");

                nbField = 5;

                break;

            case 8:
                serie3.setVisibility(View.GONE);
                serie4.setVisibility(View.GONE);

                serie1.setVisibility(View.VISIBLE);
                serie2.setVisibility(View.VISIBLE);
                numero1.setVisibility(View.VISIBLE);
                numero2.setVisibility(View.VISIBLE);
                label.setVisibility(View.VISIBLE);
                label.setText("ب د");
                label2.setText("ب د");
                data.put("type_Immatriculation", "ب د");

                nbField = 5;

                break;

            case 9:
                serie3.setVisibility(View.GONE);
                serie4.setVisibility(View.GONE);

                serie1.setVisibility(View.VISIBLE);
                serie2.setVisibility(View.VISIBLE);
                numero1.setVisibility(View.VISIBLE);
                numero2.setVisibility(View.VISIBLE);
                label.setVisibility(View.VISIBLE);
                label.setText("ث ق");
                label2.setText("ث ق");
                data.put("type_Immatriculation", "ث ق");

                nbField = 5;

                break;

            case 10:
                serie3.setVisibility(View.GONE);
                serie4.setVisibility(View.GONE);

                serie1.setVisibility(View.VISIBLE);
                serie2.setVisibility(View.VISIBLE);
                numero1.setVisibility(View.VISIBLE);
                numero2.setVisibility(View.VISIBLE);
                label.setVisibility(View.VISIBLE);
                label.setText("س ق");
                label2.setText("س ق");
                data.put("type_Immatriculation", "س ق");

                nbField = 5;

                break;

            case 11:
                serie3.setVisibility(View.VISIBLE);
                serie4.setVisibility(View.VISIBLE);

                serie1.setVisibility(View.GONE);
                serie2.setVisibility(View.GONE);
                numero1.setVisibility(View.GONE);
                numero2.setVisibility(View.GONE);
                label.setVisibility(View.VISIBLE);
                label.setText("ع م");
                label2.setText("ع م");
                data.put("type_Immatriculation", "ع م");

                nbField = 3;

                break;

            case 12:
                serie3.setVisibility(View.VISIBLE);
                serie4.setVisibility(View.VISIBLE);

                serie1.setVisibility(View.GONE);
                serie2.setVisibility(View.GONE);
                numero1.setVisibility(View.GONE);
                numero2.setVisibility(View.GONE);
                label.setVisibility(View.VISIBLE);
                label.setText("أ ف");
                label2.setText("أ ف");
                data.put("type_Immatriculation", "أ ف");

                nbField = 3;

                break;

            case 13:
                serie3.setVisibility(View.VISIBLE);
                serie4.setVisibility(View.VISIBLE);

                serie1.setVisibility(View.GONE);
                serie2.setVisibility(View.GONE);
                numero1.setVisibility(View.GONE);
                numero2.setVisibility(View.GONE);
                label.setVisibility(View.VISIBLE);
                label.setText("م خ");
                label2.setText("م خ");
                data.put("type_Immatriculation", "م خ");

                nbField = 3;

                break;

            case 14:
                serie3.setVisibility(View.GONE);
                serie4.setVisibility(View.GONE);

                serie1.setVisibility(View.VISIBLE);
                serie2.setVisibility(View.VISIBLE);
                numero1.setVisibility(View.VISIBLE);
                numero2.setVisibility(View.VISIBLE);
                label.setVisibility(View.VISIBLE);
                label.setText("PE -");
                label2.setText("PE -");
                data.put("type_Immatriculation", "PE -");

                nbField = 5;

                break;

            case 15:
                serie3.setVisibility(View.VISIBLE);
                serie4.setVisibility(View.VISIBLE);

                serie1.setVisibility(View.GONE);
                serie2.setVisibility(View.GONE);
                numero1.setVisibility(View.GONE);
                numero2.setVisibility(View.GONE);
                label.setVisibility(View.VISIBLE);
                label.setText("ت م");
                label2.setText("ت م");
                data.put("type_Immatriculation", "ت م");

                nbField = 3;

                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    public void navigate(){
        Intent x = new Intent(this, ThirdActivity.class);
        x.putExtra(donnee, data);
        startActivity(x);
    }




}