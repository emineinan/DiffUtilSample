package com.example.diffutilsample.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.diffutilsample.model.Word

class WordDiffUtil(
    private val oldList: List<Word>,
    private val newList: List<Word>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].id != newList[newItemPosition].id -> false
            oldList[oldItemPosition].word != newList[newItemPosition].word -> false
            else -> true
        }
    }
}