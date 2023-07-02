package com.example.noteapp.room.ui.add

import com.example.noteapp.room.data.model.NoteEntity
import com.example.noteapp.room.data.repository.add.AddNoteRepository
import com.example.noteapp.room.packages.base.BasePresenterImpl
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class NotePresenter @Inject constructor(
    private val repository: AddNoteRepository,
    private val view: NoteContract.View
) : NoteContract.Presenter, BasePresenterImpl() {
    override fun saveNote(entity: NoteEntity) {
        disposable = repository.saveNote(entity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {

            }
        daghoghe 19:57 film 170
    }
}