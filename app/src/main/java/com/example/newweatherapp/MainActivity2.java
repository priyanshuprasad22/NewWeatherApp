package com.example.newweatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView newView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        newView=findViewById(R.id.textView3);
        NewServices newServices=new NewServices(MainActivity2.this);

            Intent intent=getIntent();
            String n=intent.getStringExtra("city");

            newServices.cityid(n,new NewServices.newCity(){
                @Override
                public void onError(String message) {

                }

                @Override
                public void onResponse(NewWeatherdata newWeatherdata) {
                 newView.setText(newWeatherdata.toString());
                }
            });
        }
    }