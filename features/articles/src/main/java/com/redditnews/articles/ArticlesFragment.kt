package com.redditnews.articles

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.redditnews.articles.databinding.FragmentArticlesBinding
import com.redditnews.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ArticlesFragment : BaseFragment<ArticlesViewModel , FragmentArticlesBinding>(R.layout.fragment_articles) {
    override val binding: FragmentArticlesBinding
        by viewBinding(FragmentArticlesBinding::bind)
    override val fragmentViewModel: ArticlesViewModel
        by viewModels()

    private val articleAdapter by lazy { ArticlesAdapter() }
    override fun onCreated() {
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = fragmentViewModel
        }
        binding.rvList.adapter = articleAdapter
    }

}