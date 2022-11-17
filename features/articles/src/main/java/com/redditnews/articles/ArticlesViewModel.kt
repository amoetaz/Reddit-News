package com.redditnews.articles

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.redditnews.domain.models.Article
import com.redditnews.domain.modules.articles.useCases.GetArticlesUseCase
import com.redditnews.domain.utils.Resource
import com.redditnews.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(private val getArticlesUseCase: GetArticlesUseCase) :
    BaseViewModel() {

    val _articleResponse = MutableStateFlow<Resource<List<Article>?>>(Resource.Default)
    val articleResponse = _articleResponse

     init {
         getArticles()
     }
    fun getArticles() {

        getArticlesUseCase()
            .onEach {
                Log.d("dfgfdgdfgfd", "getArticles: ${it.toData()?.size}")
                _articleResponse.value = it
            }
            .launchIn(viewModelScope)
    }

}