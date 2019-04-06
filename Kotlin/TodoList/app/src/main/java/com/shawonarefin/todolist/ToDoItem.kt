package com.shawonarefin.todolist

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class ToDoItem: RealmObject(){
    @PrimaryKey
    private var id:String = UUID.randomUUID().toString()

    var name:String = ""
    var important: Boolean = false

    fun getId(): String{
        return id
    }

    override fun toString():String{
        return name
    }
}