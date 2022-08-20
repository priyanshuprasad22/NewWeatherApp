package com.example.newweatherapp;

public class NewWeatherdata {
    public NewWeatherdata() {
    }

    @Override
    public String toString() {
        return
                "Temperature in Celcius -" + temp_c +"\n"+
                "Temperature in Farenheit -" + temp_f +"\n"+
                "condition -" + condition  +"\n"+
                "Wind Speed-" + wind_kph +"\n"+
                "Humidity-" + humidity +"\n"+
                "uv-" + uv +"\n"+
                "vis_km=" + vis_km +"\n"+
                "vis_miles=" + vis_miles +"\n"+
                "gust_mph=" + gust_mph +"\n"+
                "gust_kph=" + gust_kph +"\n"+
                "wind_degree=" + wind_degree +"\n"+
                "wind_dir='" + wind_dir + '\'' +"\n"+
                "precip_mm=" + precip_mm +"\n";
    }

    private double temp_c;
    private double temp_f;
    private String condition;
    private String text;
    private double wind_kph;
    private int humidity;
    private double uv;
    private double vis_km;
    private double vis_miles;
    private double gust_mph;
    private double gust_kph;
    private double wind_degree;
    private String wind_dir;
    private double precip_mm;

    public NewWeatherdata(double temp_c, double temp_f, String condition, String text, double wind_kph, int humidity, double uv, double vis_km, double vis_miles, double gust_mph, double gust_kph, double wind_degree, String wind_dir, double precip_mm) {
        this.temp_c = temp_c;
        this.temp_f = temp_f;
        this.condition = condition;
        this.text = text;
        this.wind_kph = wind_kph;
        this.humidity = humidity;
        this.uv = uv;
        this.vis_km = vis_km;
        this.vis_miles = vis_miles;
        this.gust_mph = gust_mph;
        this.gust_kph = gust_kph;
        this.wind_degree = wind_degree;
        this.wind_dir = wind_dir;
        this.precip_mm = precip_mm;
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

    public double getUv() {
        return uv;
    }

    public void setUv(double uv) {
        this.uv = uv;
    }

    public double getVis_km() {
        return vis_km;
    }

    public void setVis_km(double vis_km) {
        this.vis_km = vis_km;
    }

    public double getVis_miles() {
        return vis_miles;
    }

    public void setVis_miles(double vis_miles) {
        this.vis_miles = vis_miles;
    }

    public double getGust_mph() {
        return gust_mph;
    }

    public void setGust_mph(double gust_mph) {
        this.gust_mph = gust_mph;
    }

    public double getGust_kph() {
        return gust_kph;
    }

    public void setGust_kph(double gust_kph) {
        this.gust_kph = gust_kph;
    }

    public double getWind_degree() {
        return wind_degree;
    }

    public void setWind_degree(double wind_degree) {
        this.wind_degree = wind_degree;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public double getPrecip_mm() {
        return precip_mm;
    }

    public void setPrecip_mm(double precip_mm) {
        this.precip_mm = precip_mm;
    }
}
