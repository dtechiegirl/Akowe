package com.example.akowe.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "notes")
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val noteContent: String,
//    val date: Date,
)
