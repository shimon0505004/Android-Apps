package com.shawonarefin.coolresume

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var workHistory = findViewById<Button>(R.id.WorkHistory_Button)
        workHistory.setOnClickListener {
            println("Hey you hit the button!")

            var moveToWorkHistory = Intent(getApplicationContext(),WorkHistoryActivity::class.java)
            startActivity(moveToWorkHistory)
        }
    }
}
