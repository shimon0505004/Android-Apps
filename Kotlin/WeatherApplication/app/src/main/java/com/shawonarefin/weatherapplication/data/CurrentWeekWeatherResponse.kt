package com.shawonarefin.weatherapplication.data

data class CurrentWeekWeatherResponse(
    val current: CurrentWeatherEntry,
    val forecast: Forecast,
    val location: Location
)