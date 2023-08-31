package com.example.controlandandroid.ui.docs.viewmodel

import android.net.Uri
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.controlandandroid.data.model.Document
import com.example.controlandandroid.data.repository.docs.DocsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class DocsViewModel @Inject constructor(
    private val docsRepository: DocsRepository
): ViewModel() {

    private val _docsList = MutableLiveData<List<Document>?>()
    val docsList: LiveData<List<Document>?>
        get() = _docsList

    fun saveDocumentUriInDB(name: String, uri: Uri, mimeType: String) {
        viewModelScope.launch(Dispatchers.IO) {
            docsRepository.saveDocument(
                Document(
                    id = 0,
                    name = name,
                    uri = uri.toString(),
                    mimeType = mimeType,
                    uploadDate = LocalDate.now().toString()
                )
            )
        }
    }

    fun getDocuments(name: String = "") {
        viewModelScope.launch(Dispatchers.IO) {
            val docsList = if (name.isEmpty()) docsRepository.getAllDocuments()
            else docsRepository.getDocumentByName(name)
            _docsList.postValue(docsList)
        }
    }
}