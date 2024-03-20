package com.example.todolist.presentation.notes

import com.example.todolist.domain.model.Note
import com.example.todolist.domain.util.NoteOrder
import com.example.todolist.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
