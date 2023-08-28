package com.example.controlandandroid.data.repository.task

import com.example.controlandandroid.data.model.Task

interface TaskRepository {

    suspend fun getTask(id: Int): Task?
    suspend fun getAllTasks(): List<Task>?
    suspend fun getTasksByName(name: String): List<Task>?
    suspend fun insertTask(task: Task)
}