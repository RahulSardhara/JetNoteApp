package com.rahul.jetnoteapp.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rahul.jetnoteapp.data.NoteDataSource
import com.rahul.jetnoteapp.model.Notes
import com.rahul.jetnoteapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class NoteViewModel @Inject constructor(private val noteRepository: NoteRepository) : ViewModel() {

    private val _noteList = MutableStateFlow(emptyList<Notes>())
    val notList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.getAllNotes().collect { notes ->
                if (notes.isNullOrEmpty()) {
                    _noteList.value = NoteDataSource.loadNotes()
                } else {
                    _noteList.value = notes
                }
            }
        }
    }

    fun addNOte(note: Notes) {
        viewModelScope.launch {
            noteRepository.addNote(note)
        }
    }

    fun updateNote(note: Notes) {
        viewModelScope.launch {
            noteRepository.updateNote(note)
        }
    }


    fun removeNote(note: Notes) {
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }
    }
}