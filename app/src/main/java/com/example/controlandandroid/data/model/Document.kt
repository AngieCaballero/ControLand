package com.example.controlandandroid.data.model

import android.net.Uri
import com.example.controlandandroid.data.database.entity.DocumentEntity
import java.io.Serializable

data class Document(
    val id: Int,
    val name: String,
    val uri: String,
    val mimeType: String,
    val uploadDate: String
): Serializable
{
    companion object {

        fun DocumentEntity?.toModel(): Document? {
            return if (this == null) null else Document(id, name, uri, mimeType, uploadDate)
        }

        fun List<DocumentEntity>?.toModelList(): List<Document>? {
            return this?.map { document -> Document(
                document.id, document.name, document.uri, document.mimeType, document.uploadDate
            )
            }
        }
    }
}
