package com.example.noteapp.room.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.noteapp.room.utils.NOTE_TABLE

@Entity(tableName = NOTE_TABLE)
data class NoteEntity(
    @PrimaryKey
    var id: Int = 0,
    var tittle: String = "",
    var des: String = "",
    var category: String = "",
    var priority: String = "",
)