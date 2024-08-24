package com.example.simpletodoapp.data.models

import java.util.Date

/**
 * A data class to represent the To Do list items
 */
data class ToDo(

    var id: Int,
    var title: String,
    var createdAt: Date,
)