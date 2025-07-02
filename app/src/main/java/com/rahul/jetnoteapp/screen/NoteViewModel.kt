package com.rahul.jetnoteapp.screen

import androidx.lifecycle.ViewModel
import com.rahul.jetnoteapp.data.NoteDataSource
import com.rahul.jetnoteapp.model.Notes

class NoteViewModel : ViewModel() {

    private var notList = mutableListOf<Notes>()

    init {
        notList.addAll(NoteDataSource.loadNotes())

    }

    fun addNOte(note: Notes) {
        notList.add(0, note)
    }

    fun removeNote(note: Notes) {
        notList.remove(note)
    }


    fun getAllNotes(): List<Notes> {
        return notList
    }

}