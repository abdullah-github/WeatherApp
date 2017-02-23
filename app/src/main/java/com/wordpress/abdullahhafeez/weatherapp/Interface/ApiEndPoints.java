package com.wordpress.abdullahhafeez.weatherapp.Interface;

import com.wordpress.abdullahhafeez.weatherapp.weather_data.WeatherData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Abdullah on 2/23/2017.
 */

public interface ApiEndPoints {


    @GET("Weather")
    Call<WeatherData> getWeatherData(@Query("q") String name, @Query("APPID") String appid);



}
