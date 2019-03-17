package com.shawonarefin.weatherapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ForecastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        var listView = findViewById<ListView>(R.id.forecast_ListView)
        var randomThings = listOf<String>("Hello"
            , "How Are You"
            , "I like Cheese"
            , "Hello"
            , "How Are You"
            , "I like Cheese"
            , "Hello"
            , "How Are You"
            , "I like Cheese"
            , "Hello"
            , "How Are You"
            , "I like Cheese"
            , "Hello"
            , "How Are You"
            , "I like Cheese"
            , "Hello"
            , "How Are You"
            , "I like Cheese"
            , "Hello"
            , "How Are You"
            , "I like Cheese"
        )
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,randomThings)
        listView.adapter = adapter
    }
}
