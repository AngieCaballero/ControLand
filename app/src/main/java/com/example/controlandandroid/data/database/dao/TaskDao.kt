package com.example.controlandandroid.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RawQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.controlandandroid.data.database.entity.TaskEntity

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTasks(tasks: List<TaskEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TaskEntity)

    @Query("SELECT * FROM task_table")
    suspend fun getAllTasks(): List<TaskEntity>?

    @Query("SELECT * FROM task_table WHERE id = (:id)")
    suspend fun getTask(id: Int): TaskEntity?

    @Query("DELETE FROM task_table WHERE id = (:id)")
    suspend fun removeTask(id: Int)

    @RawQuery
    suspend fun filterTask(query: SupportSQLiteQuery): List<TaskEntity>?
}