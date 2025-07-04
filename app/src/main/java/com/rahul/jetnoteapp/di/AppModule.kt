package com.rahul.jetnoteapp.di

import android.content.Context
import androidx.room.Room
import com.rahul.jetnoteapp.data.NoteDatabase
import com.rahul.jetnoteapp.data.NoteDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNoteDatabaseDao(noteDatabase: NoteDatabase): NoteDatabaseDao {
        return noteDatabase.noteDao()
    }


    @Singleton
    @Provides
    fun provideNoteDatabase(@ApplicationContext context: Context): NoteDatabase = Room.databaseBuilder(context = context, klass = NoteDatabase::class.java, name = "notes_db").fallbackToDestructiveMigration(dropAllTables = false).build()

}