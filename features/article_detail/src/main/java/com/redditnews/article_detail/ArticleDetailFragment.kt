package com.redditnews.article_detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.gson.Gson
import com.redditnews.article_detail.databinding.FragmentArticleDetailBinding
import com.redditnews.domain.models.Article
import com.redditnews.presentation.Extra
import com.redditnews.presentation.base.BaseFragment


class ArticleDetailFragment
    : BaseFragment<ArticleDetailViewModel , FragmentArticleDetailBinding>(R.layout.fragment_article_detail) {
    override val binding: FragmentArticleDetailBinding
        by viewBinding(FragmentArticleDetailBinding::bind)
    override val fragmentViewModel: ArticleDetailViewModel
        by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentViewModel.article = Gson().fromJson(arguments?.getString("article")?.trim() , Article::class.java)
    }
    override fun onCreated() {
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = fragmentViewModel
        }

        requireActivity().title = fragmentViewModel.article?.title
    }


}