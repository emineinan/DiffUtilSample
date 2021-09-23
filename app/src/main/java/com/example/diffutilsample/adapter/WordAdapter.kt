package com.example.diffutilsample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutilsample.databinding.RowItemBinding
import com.example.diffutilsample.model.Word

class WordAdapter : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    private var wordList = emptyList<Word>()

    class WordViewHolder(val binding: RowItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(
            RowItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.binding.textViewWord.text = wordList[position].word
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    fun setData(newWordList: List<Word>) {
        val diffUtil = WordDiffUtil(wordList, newWordList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        wordList = newWordList
        diffResults.dispatchUpdatesTo(this)
    }
}