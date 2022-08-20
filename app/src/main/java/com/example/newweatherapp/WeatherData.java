package com.example.newweatherapp;

public class WeatherData {
    public WeatherData(int last_updated_epoch, String last_updated, double temp_c, double temp_f, String condition, String text, double wind_kph, int humidity) {
        this.last_updated_epoch = last_updated_epoch;
        this.last_updated = last_updated;
        this.temp_c = temp_c;
        this.temp_f = temp_f;
        this.condition = condition;
        this.text = text;
        this.wind_kph = wind_kph;
        this.humidity = humidity;
        this.uv=uv;
    }

    public WeatherData() {
    }

    @Override
    public String toString() {
        return
                "Temperature in Celsius " + temp_c +"C"+"\n"+
                "Temperature in Farenheit " + temp_f +"F"+"\n"+
                "Weather condition - " + condition  +"\n"+
                "wind in km/h " + wind_kph +"\n"+
                "humidity=" + humidity ;
    }

    public int getLast_updated_epoch() {
        return last_updated_epoch;
    }

    public void setLast_updated_epoch(int last_updated_epoch) {
        this.last_updated_epoch = last_updated_epoch;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public double getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(double temp_c) {
        this.temp_c = temp_c;
    }

    public double getTemp_f() {
        return temp_f;
    }

    public void setTemp_f(double temp_f) {
        this.temp_f = temp_f;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(double wind_kph) {
        this.wind_kph = wind_kph;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    private int last_updated_epoch;
    private String last_updated;
    private double temp_c;
    private double temp_f;
    private String condition;
    private String text;
    private double wind_kph;
    private int humidity;
    private double uv;
}
