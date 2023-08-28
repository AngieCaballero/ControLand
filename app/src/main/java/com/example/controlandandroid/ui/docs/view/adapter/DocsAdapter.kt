package com.example.controlandandroid.ui.docs.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.controlandandroid.R
import com.example.controlandandroid.data.model.Document
import com.example.controlandandroid.databinding.ItemDocsBinding

class DocsAdapter(
    val listener: DocsListeners
): RecyclerView.Adapter<DocsAdapter.DocsViewHolder>() {

    interface DocsListeners{
        fun onSelectDoc(doc: Document)
    }

    private val docsList: MutableList<Document> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DocsAdapter.DocsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DocsViewHolder(
            layoutInflater.inflate(R.layout.item_docs, parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: DocsAdapter.DocsViewHolder,
        position: Int
    ) = holder.bind(docsList[position])

    override fun getItemCount(): Int = docsList.size


    @SuppressLint("NotifyDataSetChanged")
    fun updateDocsList(newDocsList: List<Document>) {
        val oldDocsList = docsList.toList()
//        val differCallback = object : RecyclerViewDiffUtil<Task>(oldTaskList, newTaskList) {
//            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
//                val properties1 = oldTaskList[oldItemPosition]::class.members
//
//            }
//        }
        docsList.clear()
        docsList.addAll(newDocsList)
        notifyDataSetChanged()
    }

    inner class DocsViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val binding = ItemDocsBinding.bind(view)

        fun bind(doc: Document) {
            binding.itemDocName.text = doc.name
            binding.itemDocDate.text = doc.uploadDate

            binding.root.setOnClickListener {
                listener.onSelectDoc(doc)
            }
        }
    }
}