package com.example.simpletodoapp.data.databases

import com.example.simpletodoapp.data.models.ToDo
import java.time.Instant
import java.util.Date

/**
* TodoManager as a simple in-memory database that provides basic CRUD (Create, Read, Update, Delete) operations for ToDo items.
*/
object ToDoManager {

    private val toDoList = mutableListOf<ToDo>(
    )

    fun getAllToDo() : List<ToDo> {
        return toDoList
    }

    fun addToDo(title : String) {
        toDoList.add(ToDo(System.currentTimeMillis().toInt(), title, Date.from(Instant.now())))
    }

    fun deleteToDo(id : Int) {
        toDoList.removeIf{
            it.id==id
        }
    }

    fun updateToDo(id: Int, title: String) {
        val index = toDoList.indexOfFirst { it.id == id }
        if (index != -1) {
            toDoList[index].title = title
        }
    }
}