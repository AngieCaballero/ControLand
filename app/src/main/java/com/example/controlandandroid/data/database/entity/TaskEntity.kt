package com.example.controlandandroid.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.controlandandroid.data.model.Task

@Entity(tableName = "task_table")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "client") val client: String
) {

    companion object {

        fun Task.toEntity(): TaskEntity {
            return TaskEntity(
                name = name,
                date = date,
                client = client
            )
        }

        fun List<Task>.toEntityList(): List<TaskEntity> {
            return map { task -> TaskEntity(
                name = task.name,
                date = task.date,
                client = task.client
            )
            }
        }
    }
}
