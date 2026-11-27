package com.example.todo.data.group

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "groups")
data class TodoGroupEntity(
    @PrimaryKey
    @ColumnInfo(name = "group_id")
    val groupId: String,
    val title: String,
    /** ARGB color value, such as 0xFF6750A4. */
    val color: Int
)
