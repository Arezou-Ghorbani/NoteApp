package com.example.noteapp.room.ui.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentNoteBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NoteFragment : BottomSheetDialogFragment() {

    //binding
    private lateinit var binding: FragmentNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNoteBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //initViews
        binding.apply {
            closeImg.setOnClickListener { this@NoteFragment.dismiss() }
        }
    }
}