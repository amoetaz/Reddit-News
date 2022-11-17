package com.redditnews.articles

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.redditnews.domain.models.Article
import com.redditnews.domain.modules.articles.useCases.GetArticlesUseCase
import com.redditnews.domain.utils.Resource
import com.redditnews.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(private val getArticlesUseCase: GetArticlesUseCase) :
    BaseViewModel() {

    private val _articleResponse = MutableStateFlow<Resource<List<Article>?>>(Resource.Default)
    val articleResponse = _articleResponse

     init {
         getArticles()
     }
    fun getArticles() {

        getArticlesUseCase()
            .onEach {
                _articleResponse.value = it
            }
            .launchIn(viewModelScope)
    }

}