package com.rahul.jetnoteapp.repository

import com.rahul.jetnoteapp.data.NoteDatabaseDao
import com.rahul.jetnoteapp.model.Notes
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(val noteDatabaseDao: NoteDatabaseDao) {

    suspend fun addNote(note: Notes) {
        noteDatabaseDao.insert(note)
    }


    suspend fun deleteNote(note: Notes) {
        noteDatabaseDao.delete(note)
    }


    suspend fun updateNote(note: Notes) {
        noteDatabaseDao.update(note)
    }

    suspend fun deleteAllNotes() {
        noteDatabaseDao.deleteAllNotes()
    }

    fun getAllNotes() = noteDatabaseDao.getAllNotes().flowOn(Dispatchers.IO).conflate()

}