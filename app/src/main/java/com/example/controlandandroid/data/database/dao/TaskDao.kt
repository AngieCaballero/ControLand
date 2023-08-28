package com.example.controlandandroid.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
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

    @Query("SELECT * FROM task_table WHERE name = (:name)")
    suspend fun getTasksByName(name: String): List<TaskEntity>?

    @Query("DELETE FROM task_table WHERE id = (:id)")
    suspend fun removeTask(id: Int)
}