package com.example.todolist.feature_note.repository

import com.example.todolist.feature_note.domain.model.Note
import com.example.todolist.feature_note.domain.repository.NoteRepository
import com.example.todolist.feature_note.data_source.NoteDao
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val notedao: NoteDao
): NoteRepository {

    override fun getNotes(): Flow<List<Note>> {
        return notedao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return notedao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        notedao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        notedao.deleteNote(note)
    }
}