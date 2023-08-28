package com.example.controlandandroid.ui.docs.view

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import com.example.controlandandroid.data.model.Document
import com.example.controlandandroid.databinding.FragmentDocsBinding
import com.example.controlandandroid.ui.utils.getNameFromUri
import com.example.controlandandroid.ui.base.BaseFragment
import com.example.controlandandroid.ui.docs.view.adapter.DocsAdapter
import com.example.controlandandroid.ui.docs.viewmodel.DocsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DocsFragment: BaseFragment<FragmentDocsBinding>(), DocsAdapter.DocsListeners {

    private val viewModel: DocsViewModel by viewModels()
    private var adapter: DocsAdapter? = null

    private val openDoc = registerForActivityResult(
        ActivityResultContracts.OpenDocument()
    ) { uri ->
        if (uri != null) saveDocumentUri(uri)
        else showToast("Error al abrir el documento")
    }

    override fun onCreateBinding(inflater: LayoutInflater): FragmentDocsBinding {
        return FragmentDocsBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setObservers()
        setupRecycler()
        viewModel.getDocuments()
    }

    private fun setListeners() {
        binding.docsUploadButton.setOnClickListener {
            openDoc.launch(arrayOf("*/*"))
        }

        binding.docsUpdateButton.setOnClickListener {
            viewModel.getDocuments()
        }
    }

    private fun setObservers() {
        viewModel.docsList.observe(viewLifecycleOwner) { docsList ->
            adapter?.updateDocsList(docsList ?: listOf())
        }
    }

    private fun setupRecycler() {
        adapter = DocsAdapter(this)
        binding.docsRecyclerView.adapter = adapter
    }

    private fun saveDocumentUri(uri: Uri) {
        viewModel.saveDocumentUriInDB(
            requireContext().getNameFromUri(uri), uri
        )
        showToast("Se guardo el documento $uri")
    }

    private fun showToast(info: String) {
        Toast.makeText(
            requireContext(),
            info,
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onSelectDoc(doc: Document) {
        //
    }
}