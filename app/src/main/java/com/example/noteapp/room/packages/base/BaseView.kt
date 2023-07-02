package com.example.noteapp.room.packages.base

interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun isInternetAvailable(): Boolean
    fun showInternetError()
    fun showEmpty()
    fun showServerError()
    fun logoutUser()
}