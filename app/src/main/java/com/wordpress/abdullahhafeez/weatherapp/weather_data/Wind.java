package com.wordpress.abdullahhafeez.weatherapp.weather_data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by Abdullah on 2/23/2017.
 */

public class Wind {

    @SerializedName("speed")
    @Expose
    public float speed;
    @SerializedName("deg")
    @Expose
    public int deg;

}
