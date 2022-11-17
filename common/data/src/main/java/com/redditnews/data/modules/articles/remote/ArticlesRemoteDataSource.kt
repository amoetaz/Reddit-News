package com.redditnews.data.modules.articles.remote


import com.redditnews.data.BaseRemoteDataSource

import java.io.File


import javax.inject.Inject

class ArticlesRemoteDataSource @Inject constructor(private val apiServices: ArticlesServices) :
    BaseRemoteDataSource() {

    suspend fun getArticles() = safeApiCall {
        apiServices.getArticles()
    }


}