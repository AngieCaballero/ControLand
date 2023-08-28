package com.example.controlandandroid.data.repository.docs

import android.content.ContentProvider
import com.example.controlandandroid.data.database.dao.DocumentDao
import com.example.controlandandroid.data.database.entity.DocumentEntity.Companion.toEntity
import com.example.controlandandroid.data.model.Document
import com.example.controlandandroid.data.model.Document.Companion.toModelList
import javax.inject.Inject

class DocsRepositoryImpl @Inject constructor(
    private val documentDao: DocumentDao
): DocsRepository {

    override suspend fun getAllDocuments(): List<Document>? {
        return documentDao.getAllDocs().toModelList()
    }

    override suspend fun getDocumentByName(name: String): List<Document>? {
        return documentDao.getDocsByName(name).toModelList()
    }

    override suspend fun saveDocument(document: Document) {
        documentDao.insertDoc(document.toEntity())
    }

}