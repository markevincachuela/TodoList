package com.example.todolist.domain.util

sealed class OrderType {
    object Ascending : OrderType()
    object Descending: OrderType()
}