package com.wordpress.abdullahhafeez.weatherapp.weather_data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by Abdullah on 2/23/2017.
 */


public class Sys {

    @SerializedName("type")
    @Expose
    public int type;
    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("message")
    @Expose
    public float message;
    @SerializedName("country")
    @Expose
    public String country;
    @SerializedName("sunrise")
    @Expose
    public int sunrise;
    @SerializedName("sunset")
    @Expose
    public int sunset;

}
