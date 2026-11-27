package com.example.todo.data

import com.example.todo.ui.main.TodoListItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface DataRepository {
  val data: Flow<List<TodoListItem>>
}

class DefaultDataRepository : DataRepository {
  override val data: Flow<List<TodoListItem>> = flow {
    emit(
      listOf(
        TodoListItem(
          title = "Plan the week",
          description = "Review priorities and add tasks for the week.",
          endDate = "Nov 25",
          groupId = "personal"
        ),
        TodoListItem(
          title = "Finish Material 3 setup",
          description = "Check the app theme and list components.",
          endDate = "Nov 27",
          groupId = "development"
        ),
        TodoListItem(
          title = "Pick up groceries",
          endDate = "Nov 28",
          groupId = "personal"
        ),
        TodoListItem(
          title = "Read Compose documentation",
          description = "Explore lists, cards, and floating action buttons.",
          groupId = "learning"
        ),
        TodoListItem(
          title = "Take a break",
          groupId = "personal"
        )
      )
    )
  }
}
