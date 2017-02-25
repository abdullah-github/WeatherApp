package com.wordpress.abdullahhafeez.weatherapp;


import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.wordpress.abdullahhafeez.weatherapp.Interface.ApiEndPoints;
import com.wordpress.abdullahhafeez.weatherapp.databinding.ActivityMainBinding;
import com.wordpress.abdullahhafeez.weatherapp.weather_data.Main;
import com.wordpress.abdullahhafeez.weatherapp.weather_data.Weather;
import com.wordpress.abdullahhafeez.weatherapp.weather_data.WeatherData;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.List;
import java.util.Properties;

import cz.msebera.android.httpclient.Header;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private Retrofit retrofit;
    private Gson gson;
    private TextView humidity_text, pressure_text, min_temp_text, max_temp_text, desc_text;
    private EditText city_name;
    private ApiEndPoints endPoints;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        city_name = (EditText) findViewById(R.id.city_name);
//        pressure_text = (TextView) findViewById(R.id.pressure_text);
//        humidity_text = (TextView) findViewById(R.id.humidity_text);
//        min_temp_text = (TextView) findViewById(R.id.min_temp_text);
//        max_temp_text = (TextView) findViewById(R.id.max_temp_text);
//        desc_text = (TextView) findViewById(R.id.desc_text);


        gson = new GsonBuilder().create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        endPoints = retrofit.create(ApiEndPoints.class);


    }

    public void cityButAction(View view) {

        String cityName = city_name.getText().toString();
        cityName += ",PK";

        Log.d("Asda",cityName);

        endPoints.getWeatherData(cityName, "ef2b7d047d7d7a38bc6559ae2177c5c4").enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {

                if(response.isSuccessful())  {

                    WeatherData data = response.body();

                    Main mainData = data.main;
                    List<Weather> weatherList = data.weather;

                    Weather weather = weatherList.get(0);
                    activityMainBinding.setMain_weather_data(mainData);
                    activityMainBinding.setWeather(weather);

//
//                    pressure_text.setText(Integer.toString(mainData.pressure));
//                    humidity_text.setText(Integer.toString(mainData.humidity));
//                    min_temp_text.setText(Float.toString(mainData.tempMin)+ "K");
//                    max_temp_text.setText(Float.toString(mainData.tempMax) + "K");
//
//
//                    desc_text.setText(weather.get(0).description);

                }
                else {
                    Toast.makeText(getApplicationContext(), "Not Successfull", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failure Happens", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
