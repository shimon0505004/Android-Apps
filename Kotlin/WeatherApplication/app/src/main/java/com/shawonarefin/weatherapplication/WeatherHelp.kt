package com.shawonarefin.weatherapplication

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WeatherAPI{
    @GET("bins/cu8xy")
    fun getForecast() : Call<Weather>
}

class Weather


class WeatherRetriever{
    val service : WeatherAPI

    init {
        val retrofit = Retrofit.Builder().baseUrl("https://api.myjson.com/").addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit.create(WeatherAPI::class.java)
    }

    fun getForecast(callback: Callback<Weather>){
        val call = service.getForecast()
        call.enqueue(callback)
    }
}