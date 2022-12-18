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

public class NewServices {
    Context context;
    public static final String City = BuildConfig.API_Key;
    public NewServices(Context context) {
        this.context = context;
    }
    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(String response);
    }
    public interface newCity{
        void onError(String message);

        void onResponse(NewWeatherdata newWeatherdata);
    }

    public void cityid(String cityName,newCity city)
    {
        String url = City+cityName+"&aqi=yes";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String w="";
                       NewWeatherdata n=new NewWeatherdata();
                        try {
                            JSONObject NewCity=response.getJSONObject( "current");
                            JSONObject x=NewCity.getJSONObject("condition");
                            n.setCondition(x.getString("text"));
                            n.setTemp_c(NewCity.getDouble("temp_c"));
                            n.setHumidity(Integer.parseInt(NewCity.getString("humidity")));
                            n.setTemp_f(NewCity.getDouble("temp_f"));
                            n.setWind_kph(NewCity.getDouble("wind_kph"));
                            n.setGust_kph(NewCity.getDouble("gust_kph"));
                            n.setGust_mph(NewCity.getDouble("gust_mph"));
                            n.setPrecip_mm(NewCity.getDouble("precip_mm"));
                            n.setUv(NewCity.getDouble("uv"));
                            n.setVis_km(NewCity.getDouble("vis_km"));
                            n.setVis_miles(NewCity.getDouble("vis_miles"));
                            n.setWind_dir(NewCity.getString("wind_dir"));
                            n.setWind_degree(NewCity.getDouble("wind_degree"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                       city.onResponse(n);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                        city.onError("Error");
                    }
                });
        MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }
}
