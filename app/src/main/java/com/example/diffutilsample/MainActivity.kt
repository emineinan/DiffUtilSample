package com.example.diffutilsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diffutilsample.adapter.WordAdapter
import com.example.diffutilsample.databinding.ActivityMainBinding
import com.example.diffutilsample.model.Word

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val wordAdapter by lazy { WordAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAdapter()

        val wordList: List<Word> = listOf(
            Word(1, "Mobiler.dev"),
            Word(2, "Android"),
            Word(3, "Kotlin"),
            Word(4, "RecyclerView"),
        )
        wordAdapter.setData(wordList)

        binding.buttonAdd.setOnClickListener {
            val newWordListList: List<Word> = listOf(
                Word(1, "Mobiler.dev"),
                Word(2, "Android"),
                Word(3, "Kotlin"),
                Word(4, "RecyclerView"),
                Word(5, "DiffUtil"),
                Word(6, "ViewBinding"),
                Word(7, "Android Studio"),
            )
            wordAdapter.setData(newWordListList)
        }
    }

    private fun setAdapter() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = wordAdapter
    }
}