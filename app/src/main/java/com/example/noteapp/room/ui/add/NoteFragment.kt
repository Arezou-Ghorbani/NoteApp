package com.example.noteapp.room.ui.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentNoteBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NoteFragment : BottomSheetDialogFragment() {

    //binding
    private lateinit var binding: FragmentNoteBinding

    //other
    private lateinit var categoriesList: Array<String>
    private lateinit var prioritiesList: Array<String>
    private var category: String = ""
    private var priority: String = ""

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
            categoriesSpinnerItems()
            prioritiesSpinnerItems()
        }
    }

    private fun categoriesSpinnerItems() {
        categoriesList = arrayOf("work", "Home", "Education", "Health")
        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, categoriesList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.categoriesSpinner.adapter = adapter
        binding.categoriesSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?, view: View?, position: Int, id: Long
                ) {
                    category = categoriesList[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

            }
    }

    private fun prioritiesSpinnerItems() {
        prioritiesList = arrayOf("High", "Normal", "low")
        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, prioritiesList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.prioritiesSpinner.adapter = adapter
        binding.prioritiesSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?, view: View?, position: Int, id: Long
                ) {
                    priority = prioritiesList[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

            }
    }
}