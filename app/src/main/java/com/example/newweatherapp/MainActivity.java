package com.example.newweatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button getweatherByname,getweatherbyID,getcityid;
    EditText et_dataInput;
    ListView lv_WeatherReport;
    TextView newText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getcityid=findViewById(R.id.btn_getCityID);
        getweatherbyID=findViewById(R.id.btn_getWeather_byCItyID);
        getweatherByname=findViewById(R.id.get_WeatherByCityName);
        et_dataInput=findViewById(R.id.editText);
        newText=findViewById(R.id.textView);

        getweatherByname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            NewService newService=new NewService(MainActivity.this);
            newService.getForeCast(et_dataInput.getText().toString(), new NewService.Forecast() {
                @Override
                public void onError(String message) {

                }

                @Override
                public void onResponse(WeatherData weatherData) {
                    newText.setText(weatherData.toString());
                }
            });
            }
        });
        getweatherbyID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenMainActivity2();
            }
        });
        getcityid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenMainActivity3();
                                // Request a string response from the provided URL.
                                //        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                            new Response.Listener<String>() {
//                                @Override
//                                public void onResponse(String response) {
//                                    Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
//                                }
//                            }, new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
//                        }
//                    });

// Add the request to the RequestQueue.

                //Toast.makeText(MainActivity.this, "Clicked On city ID", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void OpenMainActivity2(){
        Intent intent=new Intent(this,MainActivity2.class);
        intent.putExtra("city",et_dataInput.getText().toString());
        startActivity(intent);

    }
    public void OpenMainActivity3()
    {
        Intent intent=new Intent(this,MainActivity3.class);
        intent.putExtra("city",et_dataInput.getText().toString());
        startActivity(intent);
    }
}