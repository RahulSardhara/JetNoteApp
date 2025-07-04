package com.rahul.jetnoteapp.data

import android.provider.ContactsContract
import androidx.compose.runtime.MutableState
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.rahul.jetnoteapp.model.Notes
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface NoteDatabaseDao {

    @Query("SELECT * FROM notes_tbl")
    fun getAllNotes(): Flow<List<Notes>>

    @Query("SELECT * FROM notes_tbl WHERE note_id = :id")
    fun getNoteById(id: UUID): Flow<Notes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Notes)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Notes)

    @Delete
    suspend fun delete(note: Notes)

    @Query("DELETE FROM notes_tbl")
    suspend fun deleteAllNotes()
}
