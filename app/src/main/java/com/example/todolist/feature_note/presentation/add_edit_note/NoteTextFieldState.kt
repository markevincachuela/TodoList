package com.example.todolist.feature_note.presentation.add_edit_note

data class NoteTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintIsVisible : Boolean = true
)
