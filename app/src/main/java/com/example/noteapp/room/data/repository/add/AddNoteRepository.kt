package com.example.noteapp.room.data.repository.add

import com.example.noteapp.room.data.database.NoteDao
import com.example.noteapp.room.data.model.NoteEntity
import javax.inject.Inject

class AddNoteRepository @Inject constructor(private val dao: NoteDao) {
    fun saveNote(entity: NoteEntity) = dao.saveNote(entity)
}