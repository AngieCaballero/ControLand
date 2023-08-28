package com.example.controlandandroid.ui.utils

import androidx.recyclerview.widget.DiffUtil

abstract class RecyclerViewDiffUtil<E>(
    private val oldList: List<E>,
    private val newList: List<E>
): DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = oldList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}