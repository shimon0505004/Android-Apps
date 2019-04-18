package com.shawonarefin.findrepo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.searchButton)
        val text = findViewById<EditText>(R.id.editText).text
        button.setOnClickListener{
            val intent = Intent(this,SearchResultActivity::class.java)
            intent.putExtra("searchTerm", text.toString())
            startActivity(intent)
        }
    }
}
