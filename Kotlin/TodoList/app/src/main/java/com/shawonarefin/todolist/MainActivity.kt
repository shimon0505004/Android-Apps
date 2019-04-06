package com.shawonarefin.todolist

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.*
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import io.realm.Realm

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        Realm.init(this)

        fab.setOnClickListener {
            val addIntent = Intent(this, AddTodoActivity::class.java)
            startActivity(addIntent)
        }

    }

    override fun onResume() {
        super.onResume()

        val realm = Realm.getDefaultInstance()
        val query = realm.where(ToDoItem::class.java)
        val results = query.findAll()
        val listView = findViewById<ListView>(R.id.todoListView)

        listView.setOnItemClickListener{adapterView, view, index, l ->
            val selectedToDo = results[index]
            val finishIntent = Intent(this,FinishToDoActivity::class.java)
            finishIntent.putExtra("toDoItem",selectedToDo?.getId())
            println(selectedToDo?.name)
            startActivity(finishIntent)
        }

        val adapter = ToDoAdapter(this,android.R.layout.simple_list_item_1,results)
        listView.adapter = adapter
    }

    /**
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
    */
}

class ToDoAdapter(context: Context, resource: Int, objects: MutableList<ToDoItem>) :
    ArrayAdapter<ToDoItem>(context, resource, objects) {

    override fun getCount(): Int {
        return super.getCount()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //return super.getView(position, convertView, parent)
        val inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val toDoView = inflator.inflate(android.R.layout.simple_list_item_1,parent, false) as TextView

        val toDoItem = getItem(position)
        toDoView.text = toDoItem.name

        if(toDoItem.important){
            toDoView.typeface = Typeface.DEFAULT_BOLD
        }

        return toDoView

    }
}