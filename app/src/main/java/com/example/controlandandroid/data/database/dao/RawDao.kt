package com.example.controlandandroid.data.database.dao

import androidx.room.Dao
import androidx.room.RawQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.controlandandroid.data.database.entity.DocumentEntity
import com.example.controlandandroid.data.database.entity.TaskEntity

@Dao
interface RawDao {

    @RawQuery(observedEntities = [TaskEntity::class])
    suspend fun filterTask(query: SupportSQLiteQuery): List<TaskEntity>
}