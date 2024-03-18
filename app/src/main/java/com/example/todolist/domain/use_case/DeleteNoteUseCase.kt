package com.example.todolist.domain.use_case

import com.example.todolist.domain.model.Note
import com.example.todolist.domain.repository.NoteRepository

class DeleteNoteUseCase(
    private val repo: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        repo.deleteNote(note)
    }
}