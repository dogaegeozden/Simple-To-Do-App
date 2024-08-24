package com.example.simpletodoapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpletodoapp.data.databases.ToDoManager
import com.example.simpletodoapp.data.models.ToDo

/**
* This ToDoViewModel class acts as an intermediary between the UI and data storage, exposing a list of ToDo items through LiveData, and providing methods to add, delete, and retrieve ToDo items, while also updating the UI accordingly.
*/
class ToDoViewModel : ViewModel() {

    // LiveData objects can be observed by the other parts of the application, typically a UI
    private var _toDoList = MutableLiveData<List<ToDo>>()
    val toDoList : LiveData<List<ToDo>> = _toDoList

    init {
        getAllToDo()
    }

    fun getAllToDo() {
        _toDoList.value = ToDoManager.getAllToDo().reversed()
    }

    fun addToDo(title: String) {
        ToDoManager.addToDo(title)
        getAllToDo()
    }

    fun deleteToDo(id: Int){
        ToDoManager.deleteToDo(id)
        getAllToDo()
    }

    fun updateToDo(id: Int, title: String) {
        ToDoManager.updateToDo(id, title)
    }

}