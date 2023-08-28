package com.example.controlandandroid.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.controlandandroid.data.database.entity.DocumentEntity

@Dao
interface DocumentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDoc(docs: DocumentEntity)

    @Query("SELECT * FROM document_table")
    suspend fun getAllDocs(): List<DocumentEntity>?

    @Query("SELECT * FROM document_table WHERE id = (:id)")
    suspend fun getDoc(id: Int): DocumentEntity?

    @Query("SELECT * FROM document_table WHERE name = (:name)")
    suspend fun getDocsByName(name: String): List<DocumentEntity>?

    @Query("DELETE FROM document_table WHERE id = (:id)")
    suspend fun removeDoc(id: Int)
}