package com.example.controlandandroid.data.model

import com.example.controlandandroid.data.database.entity.TaskEntity
import java.io.Serializable

data class Task(
    val id: Int,
    val name: String,
    val date: String,
    val client: String
): Serializable {

    companion object {

        fun TaskEntity?.toModel(): Task? {
            return if (this == null) null else Task(id, name, date, client)
        }

        fun List<TaskEntity>?.toModelList(): List<Task>? {
            return this?.map { task -> Task(
                task.id, task.name, task.date, task.client
            )
            }
        }
    }
}
