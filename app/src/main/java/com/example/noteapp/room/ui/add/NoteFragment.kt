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
import com.example.noteapp.room.data.model.NoteEntity
import com.example.noteapp.room.data.repository.add.AddNoteRepository
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class NoteFragment : BottomSheetDialogFragment(), NoteContract.View {

    //binding
    private lateinit var binding: FragmentNoteBinding

    @Inject
    lateinit var entity: NoteEntity

    @Inject
    lateinit var repository: AddNoteRepository

    //other
    private val presenter by lazy { NotePresenter(repository, this) }
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
//            spinners
            categoriesSpinnerItems()
            prioritiesSpinnerItems()
//            save
            saveBtn.setOnClickListener {
                val tittle = tittleEdt.text.toString()
                val desc = desEdt.text.toString()
//                Entity
                entity.id = 0
                entity.tittle = tittle
                entity.des = desc
                entity.category = category
                entity.priority = priority
//                save
                presenter.saveNote(entity)
            }
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

    override fun close() {
        this.dismiss()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }
}