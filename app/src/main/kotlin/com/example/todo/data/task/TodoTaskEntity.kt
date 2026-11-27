package com.example.todo.data.task

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "tasks",
    indices = [Index(value = ["group_id"])]
)
data class TodoTaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val description: String? = null,
    @ColumnInfo(name = "group_id")
    val groupId: String,
    /** ISO-8601 date text, or null when the task has no end date. */
    @ColumnInfo(name = "end_date")
    val endDate: String? = null
)
