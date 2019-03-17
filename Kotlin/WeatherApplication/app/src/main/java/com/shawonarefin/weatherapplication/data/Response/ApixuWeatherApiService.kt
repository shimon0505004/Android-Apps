package com.shawonarefin.weatherapplication.data.Response

import retrofit2.http.GET
import retrofit2.http.Query


const val API_KEY = "57a2b6efb27642c888e151513191703"

//http://api.apixu.com/v1/forecast.json?key=57a2b6efb27642c888e151513191703&q=07112&days=7


//Will be used by Retrofit library to fetch data from Apixu API
interface ApixuWeatherApiService {

    @GET("Forecast.json")
    fun getWeatherForecast(
        @Query("q") location: String,
        @Query("lang") languageCode: String = "en"
    )
}