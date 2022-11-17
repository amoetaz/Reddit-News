package com.redditnews.articles

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.net.toUri
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
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
        articleAdapterClicks()
        requireActivity().title = "Reddit News"
    }

    private fun articleAdapterClicks() {
        articleAdapter.onItemClick = {
            Log.d("sdfsdfdsfds", "articleAdapterClicks: $it")
            val request = NavDeepLinkRequest.Builder
                .fromUri("android-app://com.redditnews.articles/articlesFragment?article=${Gson().toJson(it.apply {desc = desc?.replace("#" , "") })}".toUri())
                .build()
            findNavController().navigate(request)

        }
    }

}

fun String?.toSpannedText(): Spanned {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
    } else {
        @Suppress("DEPRECATION")
        return Html.fromHtml(this)
    }
}