package com.example.thenewsapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.thenewsapp.R
import com.example.thenewsapp.adapters.NewsAdapter
import com.example.thenewsapp.databinding.FragmentHeadlinesBinding
import com.example.thenewsapp.ui.NewsViewModel


class HeadlinesFragment : Fragment(R.layout.fragment_headlines) {
    lateinit var newsViewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    lateinit var retryButton: Button
    lateinit var errorText:TextView
    lateinit var itemHeadlinesError:CardView

    lateinit var binding: FragmentHeadlinesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHeadlinesBinding.bind(view)

    }

    var isError = false
    var isLoading = false
    var isLastPage = false
    var isScrolling = false

    private fun hideProgressbar(){
        binding.paginationProgressBar.visibility = View.INVISIBLE
        isLoading = false
    }

    private fun showProgressbar(){
        binding.paginationProgressBar.visibility = View.VISIBLE
        isLoading = true
    }

    private fun hideErrorMessage(){
        itemHeadlinesError.visibility = View.INVISIBLE
        isError = false
    }

    private fun showErrorMessage(message:String){
        itemHeadlinesError.visibility = View.VISIBLE
        errorText.text = message
        isError = true
    }


}