package com.shawonarefin.weatherapplication.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.shawonarefin.weatherapplication.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var getForecastButton = findViewById<Button>(R.id.getForecast_Button)
        getForecastButton.setOnClickListener {
            var moveIntent = Intent(this, ForecastActivity::class.java)
            startActivity(moveIntent)
        }
    }
}
