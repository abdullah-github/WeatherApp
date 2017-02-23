package com.wordpress.abdullahhafeez.weatherapp.weather_data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by Abdullah on 2/23/2017.
 */

public class Main {

    @SerializedName("temp")
    @Expose
    public float temp;
    @SerializedName("pressure")
    @Expose
    public int pressure;
    @SerializedName("humidity")
    @Expose
    public int humidity;
    @SerializedName("temp_min")
    @Expose
    public float tempMin;
    @SerializedName("temp_max")
    @Expose
    public float tempMax;

}