package com.example.visitetechnique;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCommencer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCommencer = (Button) findViewById(R.id.lunchBtn);
        btnCommencer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigate();
            }
        });

    }

    public void navigate(){
        Intent startIntent = new Intent(this, secondActivity.class);
        startActivity(startIntent);
    }
}