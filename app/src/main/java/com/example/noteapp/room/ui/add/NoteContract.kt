package com.example.noteapp.room.ui.add

import com.example.noteapp.room.data.model.NoteEntity
import com.example.noteapp.room.packages.base.BasePresenter

interface NoteContract {
    interface View {
        fun close( )
    }

    interface Presenter : BasePresenter {
        fun saveNote(entity: NoteEntity)
    }
}