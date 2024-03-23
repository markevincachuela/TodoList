package com.example.todolist.domain.use_case

import com.example.todolist.domain.model.InvalidNoteException
import com.example.todolist.domain.model.Note
import com.example.todolist.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNote(
    private val repo: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty")
        }
        repo.insertNote(note)
    }
}