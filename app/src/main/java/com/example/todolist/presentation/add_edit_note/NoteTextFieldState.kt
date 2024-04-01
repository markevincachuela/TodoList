package com.example.todolist.presentation.add_edit_note

data class NoteTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintIsVisible : Boolean = true
)
