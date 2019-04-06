package com.shawonarefin.todolist

import io.realm.RealmObject

open class ToDoItem: RealmObject(){
    var name:String = ""
    var important: Boolean = false
}