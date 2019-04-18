package com.shawonarefin.todolist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import io.realm.Realm
import java.util.*

class AddTodoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_todo)

        title = "New To Do"

        val button = findViewById<Button>(R.id.addButton)

        button.setOnClickListener{

            val editText = findViewById<EditText>(R.id.todoEditText)
            val checkBox = findViewById<CheckBox>(R.id.importantCheckBox)


            val realm = Realm.getDefaultInstance()
            realm.beginTransaction()

            val toDo = realm.createObject(ToDoItem::class.java, UUID.randomUUID().toString())
            toDo.name = editText.text.toString()
            toDo.important = checkBox.isChecked

            realm.commitTransaction()
            finish()

        }


    }
}
