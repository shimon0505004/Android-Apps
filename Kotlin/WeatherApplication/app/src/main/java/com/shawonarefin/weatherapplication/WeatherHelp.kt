package com.shawonarefin.weatherapplication

import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


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