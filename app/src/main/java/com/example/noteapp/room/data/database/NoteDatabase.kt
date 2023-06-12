package com.example.noteapp.room.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.noteapp.room.data.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}