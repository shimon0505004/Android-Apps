package com.shawonarefin.weatherapplication.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.shawonarefin.weatherapplication.R
import com.shawonarefin.weatherapplication.Weather
import com.shawonarefin.weatherapplication.WeatherRetriever
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


        var retriever = WeatherRetriever()
        val callback = object : Callback<Weather>{

            override fun onResponse(call: Call<Weather>?, response: Response<Weather>?) {
                println("We have a response")
                println(response)

            }

            override fun onFailure(call: Call<Weather>?, t: Throwable?) {
                println("It failed :(")
            }

        }
        retriever.getForecast(callback)
    }
}
