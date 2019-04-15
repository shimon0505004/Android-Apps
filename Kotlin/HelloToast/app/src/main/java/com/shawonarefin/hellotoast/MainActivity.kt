package com.shawonarefin.hellotoast

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var mCount:Int = 0
    private var mShowCount:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mShowCount = findViewById(R.id.show_count)
        mShowCount?.text = mCount.toString()
    }

    fun showToast(view: View){
        val toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_LONG)
        toast.show()
    }

    fun countUp(view: View){
        mCount++
        mShowCount?.text = mCount.toString()
    }

}
