package com.example.noteapp.room.packages.base

import androidx.annotation.NonNull
import io.reactivex.disposables.Disposable

open class BasePresenterImpl : BasePresenter {
    @NonNull
    var disposable: Disposable? = null
    override fun onStop() {
        disposable?.let {
            it.dispose()
        }
    }
}