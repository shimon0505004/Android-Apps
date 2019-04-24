package com.shawonarefin.helloconstraint

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

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
        button_count.setBackgroundColor(if(mCount%2==0) Color.BLUE else Color.GREEN)
        button_zero.setBackgroundColor(Color.MAGENTA)
    }

    fun makeZero(view: View){
        mCount = 0
        mShowCount?.text = mCount.toString()
        button_zero.setBackgroundColor(Color.GRAY)
        button_count.setBackgroundColor(Color.BLUE)
    }

}
