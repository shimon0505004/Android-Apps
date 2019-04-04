package com.shawonarefin.weatherapplication.data.Response

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.shawonarefin.weatherapplication.data.CurrentWeekWeatherResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
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
    ): Deferred<CurrentWeekWeatherResponse>

    companion object {
        operator fun invoke(): ApixuWeatherApiService{
            val requestInterceptor = Interceptor{ chain ->

                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("key", API_KEY)
                    .build()

                val request = chain.request().newBuilder().url(url).build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.apixu.com/v1/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApixuWeatherApiService::class.java)
        }
    }
}