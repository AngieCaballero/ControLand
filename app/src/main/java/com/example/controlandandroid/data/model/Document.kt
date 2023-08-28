package com.example.controlandandroid.data.model

import com.example.controlandandroid.data.database.entity.DocumentEntity
import java.io.Serializable

data class Document(
    val id: Int,
    val name: String,
    val uri: String,
    val uploadDate: String
): Serializable
{
    companion object {

        fun DocumentEntity?.toModel(): Document? {
            return if (this == null) null else Document(id, name, uri, uploadDate)
        }

        fun List<DocumentEntity>?.toModelList(): List<Document>? {
            return this?.map { document -> Document(
                document.id, document.name, document.uri, document.uploadDate
            )
            }
        }
    }
}
