package com.example.todo.data.group

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoGroupDao {
    @Query("SELECT * FROM groups ORDER BY title COLLATE NOCASE")
    fun observeAll(): Flow<List<TodoGroupEntity>>

    @Query("SELECT * FROM groups WHERE group_id = :groupId")
    suspend fun getById(groupId: String): TodoGroupEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(group: TodoGroupEntity)

    @Query("DELETE FROM groups WHERE group_id = :groupId")
    suspend fun deleteById(groupId: String)
}
