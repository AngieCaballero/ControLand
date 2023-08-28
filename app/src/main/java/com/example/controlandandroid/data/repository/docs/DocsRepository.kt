package com.example.controlandandroid.data.repository.docs

import com.example.controlandandroid.data.model.Document

interface DocsRepository {

    suspend fun getAllDocuments(): List<Document>?

    suspend fun getDocumentByName(name: String): List<Document>?

    suspend fun saveDocument(document: Document)
}