package com.example.controlandandroid.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.controlandandroid.data.database.entity.DocumentEntity.Companion.toEntity
import com.example.controlandandroid.data.model.Document
import com.example.controlandandroid.data.model.Task

@Entity(tableName = "document_table")
data class DocumentEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "uri") val uri: String,
    @ColumnInfo(name = "uploadDate") val uploadDate: String
) {

    companion object {

        fun Document.toEntity(): DocumentEntity {
            return DocumentEntity(
                name = this.name,
                uri = this.uri,
                uploadDate = this.uploadDate
            )
        }

        fun List<Document>.toEntityList(): List<DocumentEntity> {
            return map { document -> DocumentEntity(
                name = document.name,
                uri = document.uri,
                uploadDate = document.uploadDate
            )
            }
        }
    }
}
