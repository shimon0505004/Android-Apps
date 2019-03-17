package com.shawonarefin.weatherapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_forecast.*
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
        val callback = object : Callback<WeatherQuery>{

            override fun onResponse(call: Call<WeatherQuery>, response: Response<WeatherQuery>) {
                println("We have a response")
                println(response.body())

            }

            override fun onFailure(call: Call<WeatherQuery>, t: Throwable) {
                println("It failed :(")
            }

        }
        retriever.getForecast(callback)
    }
}
