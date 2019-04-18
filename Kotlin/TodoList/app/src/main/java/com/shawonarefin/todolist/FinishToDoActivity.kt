package com.shawonarefin.todolist

import android.graphics.Typeface
import android.graphics.Typeface.*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import io.realm.Realm

class FinishToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_to_do)
        title = "Complete ToDo"

    }

    override fun onResume() {
        super.onResume()

        val toDoItemId = intent.getStringExtra("toDoItem")
        println(toDoItemId)

        val realm = Realm.getDefaultInstance()
        try {
            val toDoItem = realm.where(ToDoItem::class.java)
                .equalTo("id",toDoItemId)
                .findFirst()

            //title = toDoItem?.name
            val textView = findViewById<TextView>(R.id.todoNameTextView)
            textView.text = toDoItem?.name
            if(toDoItem?.important!!) textView.typeface = DEFAULT_BOLD

            val completeButton = findViewById<Button>(R.id.completeButton)
            completeButton.setOnClickListener {
                realm.beginTransaction()
                toDoItem.deleteFromRealm()
                realm.commitTransaction()

                finish()
            }

        } finally {
            realm.close()
        }
    }

}
