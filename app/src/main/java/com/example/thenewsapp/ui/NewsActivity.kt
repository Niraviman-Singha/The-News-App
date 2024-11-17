package com.example.thenewsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.thenewsapp.R
import com.example.thenewsapp.database.ArticleDatabase
import com.example.thenewsapp.databinding.ActivityNewsBinding
import com.example.thenewsapp.repository.NewsRepository
import com.example.thenewsapp.util.NewsViewModelProviderFactory

class NewsActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewsBinding
    lateinit var newsViewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
        newsViewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)

    }
}