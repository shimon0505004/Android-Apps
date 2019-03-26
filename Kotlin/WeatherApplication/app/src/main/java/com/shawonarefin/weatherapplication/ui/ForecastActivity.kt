package com.shawonarefin.weatherapplication.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.shawonarefin.weatherapplication.R
import com.shawonarefin.weatherapplication.data.CurrentWeekWeatherResponse
import com.shawonarefin.weatherapplication.data.Response.ApixuWeatherApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForecastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        var movieListView = findViewById<ListView>(R.id.forecast_ListView)
        var movieList = listOf<String>(
            "Veer Zaara"
        ,   "Aashiqui"
        ,   "Saving Private Ryan"
        ,   "Jack of all trades"
        ,   "Beam me up scotty"
        ,   "Find me and kill"
        ,   "A good day to die"
        ,   "The notebook"
        ,   "Alexi Krilenko"
        ,   "A man apart"
        )
        var movieListAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,movieList)
        movieListView.adapter = movieListAdapter


        var apiService = ApixuWeatherApiService()
        GlobalScope.launch(Dispatchers.Main) {
            val currentWeatherResponse = apiService.getWeatherForecast("Dhaka").await()
            println(currentWeatherResponse.location.toString())

        }
    }
}

