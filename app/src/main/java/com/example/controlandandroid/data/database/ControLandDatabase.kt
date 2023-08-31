package com.example.controlandandroid.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.controlandandroid.data.database.dao.DocumentDao
import com.example.controlandandroid.data.database.dao.RawDao
import com.example.controlandandroid.data.database.dao.TaskDao
import com.example.controlandandroid.data.database.entity.DocumentEntity
import com.example.controlandandroid.data.database.entity.TaskEntity

@Database(
    entities = [
        TaskEntity::class,
        DocumentEntity::class
               ],
    version = 1,
    exportSchema = false
)
abstract class ControLandDatabase: RoomDatabase() {

    abstract fun getTaskDao(): TaskDao
    abstract fun getDocumentDao(): DocumentDao
    abstract fun getRawDao(): RawDao
}