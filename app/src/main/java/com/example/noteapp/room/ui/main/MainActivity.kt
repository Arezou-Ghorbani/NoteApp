package com.example.noteapp.room.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.noteapp.R
import com.example.noteapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Binding
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //initViews
        binding.apply {

        }
    }
}