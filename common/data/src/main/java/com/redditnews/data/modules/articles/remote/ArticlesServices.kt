package com.redditnews.data.modules.articles.remote

import com.redditnews.data.models.ArticlesResponse
import retrofit2.http.GET

interface ArticlesServices {

    @GET("r/kotlin/.json")
    suspend fun getArticles() : ArticlesResponse
}