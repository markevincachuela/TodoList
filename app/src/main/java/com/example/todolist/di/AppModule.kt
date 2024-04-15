package com.example.todolist.di

import android.app.Application
import androidx.room.Room
import com.example.todolist.feature_note.domain.repository.NoteRepository
import com.example.todolist.feature_note.domain.use_case.AddNote
import com.example.todolist.feature_note.domain.use_case.DeleteNoteUseCase
import com.example.todolist.feature_note.domain.use_case.GetNoteUseCase
import com.example.todolist.feature_note.domain.use_case.GetNotesUseCase
import com.example.todolist.feature_note.domain.use_case.NoteUseCases
import com.example.todolist.feature_note.data_source.NoteDatabase
import com.example.todolist.feature_note.repository.NoteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase{
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }


    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repo: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotesUseCase = GetNotesUseCase(repo),
            deleteNoteUseCase = DeleteNoteUseCase(repo),
            addNote = AddNote(repo),
            getNoteUseCase = GetNoteUseCase(repo)
        )
    }
}