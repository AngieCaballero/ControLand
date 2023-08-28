package com.example.controlandandroid.data.repository.task

import com.example.controlandandroid.data.database.dao.TaskDao
import com.example.controlandandroid.data.database.entity.TaskEntity.Companion.toEntity
import com.example.controlandandroid.data.model.Task
import com.example.controlandandroid.data.model.Task.Companion.toModel
import com.example.controlandandroid.data.model.Task.Companion.toModelList
import javax.inject.Inject


class TaskRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao
): TaskRepository {

    override suspend fun getTask(id: Int): Task? {
        return taskDao.getTask(id)?.toModel() ?: return null
    }

    override suspend fun getAllTasks(): List<Task>? {
        return taskDao.getAllTasks()?.toModelList() ?: return null
    }

    override suspend fun getTasksByName(name: String): List<Task>? {
        return taskDao.getTasksByName(name)?.toModelList() ?: return null
    }

    override suspend fun insertTask(task: Task) {
        taskDao.insertTask(task.toEntity())
    }
}