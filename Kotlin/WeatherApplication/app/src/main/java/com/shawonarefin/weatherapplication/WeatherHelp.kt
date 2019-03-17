package com.shawonarefin.weatherapplication

import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WeatherAPI{
    @GET("forecast.json?key=57a2b6efb27642c888e151513191703&q=07112&days=7")
    fun getForecast() : Call<Weather>
}

class Weather(val forecast : WeatherForecast)
class WeatherForecast(val forecastday : List<WeatherForecastByDay>)
class WeatherForecastByDay(val day: WeatherOnDay)
class WeatherOnDay(val condition: WeatherCondition)
class WeatherCondition(val text: String)

class WeatherRetriever{
    val service : WeatherAPI

    init {
        val baseURL = "http://api.apixu.com/v1/"
        val retrofit = Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit.create(WeatherAPI::class.java)
    }

    fun getForecast(callback: Callback<Weather>){
        val call = service.getForecast()
        call.enqueue(callback)
    }
}