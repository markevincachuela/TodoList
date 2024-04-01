package com.example.todolist.domain.use_case

import com.example.todolist.domain.model.Note
import com.example.todolist.domain.repository.NoteRepository

class GetNoteUseCase(
    private val repo: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repo.getNoteById(id)
    }
}