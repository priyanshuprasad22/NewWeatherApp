package com.example.newweatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity3 extends AppCompatActivity {
    public static final String City = BuildConfig.API_Key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView textView13,textView15,textView21,textView23,textView4,textView6,textView8,textView10;
        textView13 =findViewById(R.id.textView13);
                textView15=findViewById(R.id.textView15);
        textView21=findViewById(R.id.textView21);
                textView23=findViewById(R.id.textView23);
        textView4=findViewById(R.id.textView4);
                textView6=findViewById(R.id.textView6);
        textView8=findViewById(R.id.textView8);
                textView10=findViewById(R.id.textView10);
        Intent intent = getIntent();
        String n = intent.getStringExtra("city");
        String url = City + n + "&aqi=yes";
     JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
         @Override
         public void onResponse(JSONObject response) {
             try{

             JSONObject NewCity = response.getJSONObject("current");
             JSONObject x=NewCity.getJSONObject("air_quality");
             textView13.setText(x.getString("co"));
             textView15.setText(x.getString("no2"));
             textView21.setText(x.getString("o3"));
             textView23.setText(x.getString("so2"));
             textView4.setText(x.getString("pm2_5"));
             textView6.setText(x.getString("pm10"));
             textView8.setText(x.getString("us-epa-index"));
             textView10.setText(x.getString("gb-defra-index"));
         }
             catch (JSONException e)
             {
             }
         }
     },new Response.ErrorListener() {
         @Override
         public void onErrorResponse(VolleyError error) {
         }
     });
        MySingleton.getInstance(MainActivity3.this).addToRequestQueue(jsonObjectRequest);
    }
}