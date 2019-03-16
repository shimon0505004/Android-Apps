package com.shawonarefin.coolresume

import android.content.Intent
import android.net.Uri
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


        var callButton = findViewById<Button>(R.id.CallShimon_Button)
        callButton.setOnClickListener {
            println("Call Shimon!")

            var phoneURI = Uri.parse("tel:+8801724878680")
            var callIntent = Intent(Intent.ACTION_DIAL,phoneURI)
            startActivity(callIntent)
        }


        var emailButton = findViewById<Button>(R.id.EmailShimon_Button)
        emailButton.setOnClickListener {
            println("Email Shimon!")

            var emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.setType("plain/text")
            emailIntent.putExtra(Intent.EXTRA_EMAIL,"shimon@shawonarefin.com")
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Resume from the app")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "I liked your email")
            startActivity(emailIntent)
        }

    }
}
