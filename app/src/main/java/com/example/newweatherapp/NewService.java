package com.example.newweatherapp;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewService {
    Context context;
    public static final String City =BuildConfig.API_Key;

    public NewService(Context context) {
        this.context = context;
    }
    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(String response);
    }
    public void cityid(String cityName,VolleyResponseListener volleyResponseListener)
    {
        String url = City+cityName+"&aqi=yes";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String w="";
                        try {
                            JSONObject NewCity=response.getJSONObject( "location");
                            w= NewCity.getString("country");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Toast.makeText(context, w.toString(), Toast.LENGTH_SHORT).show();
                        volleyResponseListener.onResponse(w);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                        volleyResponseListener.onError("Error");
                    }
                });
        MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }
    public interface Forecast {
        void onError(String message);

        void onResponse(WeatherData weatherData);
    }
    public void getForeCast(String city,Forecast forecast)
    {
        List<WeatherData> data=new ArrayList<>();
        String url = City+city+"&aqi=yes";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        WeatherData t=new WeatherData();
                        String w="";
                        try {
                      JSONObject e=response.getJSONObject("current");
                      JSONObject x=e.getJSONObject("condition");
                      t.setCondition(x.getString("text"));
                      t.setHumidity(Integer.parseInt(e.getString("humidity")));
                      t.setTemp_c(e.getDouble("temp_c"));
                      t.setTemp_f(e.getDouble("temp_f"));
                      t.setWind_kph(e.getDouble("wind_kph"));
                      t.setText(e.getString("text"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Toast.makeText(context, w, Toast.LENGTH_SHORT).show();
                        forecast.onResponse(t);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
        MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }

    }
