package com.example.controlandandroid.data.repository.task

import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.controlandandroid.data.database.dao.TaskDao
import com.example.controlandandroid.data.database.entity.TaskEntity
import com.example.controlandandroid.data.database.entity.TaskEntity.Companion.toEntity
import com.example.controlandandroid.data.model.Filters
import com.example.controlandandroid.data.model.Task
import com.example.controlandandroid.data.model.Task.Companion.toModel
import com.example.controlandandroid.data.model.Task.Companion.toModelList
import javax.inject.Inject


class TaskRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao
): TaskRepository {

    override suspend fun getTask(id: Int): Task? {
        return taskDao.getTask(id)?.toModel()
    }

    override suspend fun getAllTasks(): List<Task>? {
        return taskDao.getAllTasks()?.toModelList()
    }

    override suspend fun insertTask(task: Task) {
        taskDao.insertTask(task.toEntity())
    }

    override suspend fun filterTask(filters: Filters): List<Task>? {
        val query = "SELECT * FROM ${TaskEntity.TABLE_NAME} WHERE name LIKE '%${filters.name}%' AND client LIKE '%${filters.client}%'"
        return taskDao.filterTask(SimpleSQLiteQuery(query)).toModelList()
    }
}